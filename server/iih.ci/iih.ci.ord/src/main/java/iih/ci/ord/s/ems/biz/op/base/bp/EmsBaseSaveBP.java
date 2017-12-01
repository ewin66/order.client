package iih.ci.ord.s.ems.biz.op.base.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.cache.CacheContext;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseRService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.IDefaultCreateOrderInfo;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.itf.bp.IEmsSaveBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderHpInfoBP;
import iih.ci.ord.s.ems.biz.meta.BdSrvInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.meta.ObjectList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.biz.meta.OrderSavedRstInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvDoseList;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.meta.OrderSrvSetList;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.hp.std.OrderHpInfoBP;
import iih.ci.ord.s.ems.biz.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗单保存业务逻辑处理 -- 基类
 * 
 * @author wangqingzhu
 *
 */
public class EmsBaseSaveBP extends CacheContext implements IEmsSaveBP,IOrderHpInfoBP {

	/**
	 * 有效性校验接口
	 */
	private IEmsValidate emsValidate = null;
	/**
	 * 就诊上下文
	 */
	private CiEnContextDTO enContextInfo = null;

	/**
	 * 医保信息处理逻辑对象
	 */
	private IOrderHpInfoBP orderHpInfoBP = new OrderHpInfoBP();
	

	/**
	 * 默认医嘱生成逻辑接口
	 */
	private IDefaultCreateOrderInfo defaultCreateOrderInfo = null;

	
	public IEmsValidate getEmsValidate() {
		return emsValidate;
	}

	public void setEmsValidate(IEmsValidate emsValidate) {
		this.emsValidate = emsValidate;
	}

	public IDefaultCreateOrderInfo getDefaultCreateOrderInfo() {
		return defaultCreateOrderInfo;
	}

	public void setDefaultCreateOrderInfo(IDefaultCreateOrderInfo defaultCreateOrderInfo) {
		this.defaultCreateOrderInfo = defaultCreateOrderInfo;
	}
	
	public CiEnContextDTO getEnContextInfo() {
		return enContextInfo;
	}

	public void setEnContextInfo(CiEnContextDTO enContextInfo) {
		this.enContextInfo = enContextInfo;
	}

	@Override
	public EmsRstDTO save(EmsSaveDTO ems) throws BizException {

		EmsRstDTO rst = new EmsRstDTO();
		// 1. 获取就诊上下文
		CiEnContextDTO ctx = ems.getEnContext();
		Context.get().setAttribute("CiEnContextDTO", ctx);
		this.setEnContextInfo(ctx);

		// 2. 获取医疗单文档信息
		OrdBizLogger.info(ctx, "[SaveBP]处理医疗单保存逻辑");

		// 3. 有效性批量验证
		//3.1 互斥医嘱检查
		//3.2 执行科室为空检查
		ErrorEmsList errorMsg = getEmsValidate().viewModelValidate(ems.getDocument().toArray(), ctx);
		if (!CiOrdUtils.isEmpty(errorMsg)) {
			rst.setErrorEmsList(errorMsg.asFArrayList());
			return rst;
		}
		OrdBizLogger.info(ctx, "[SaveBP]有效性验证通过");
		// 4. 默认值批量处理
		// 4.1 在院执行标志处理 -- 


		// 5. 批量构建
		OrderPackageInfo[] szOrderPakageInfo = handleOrderAggInfoList(ctx, ems.getDocument());
		OrdBizLogger.info(ctx, "[SaveBP]构建医嘱包信息通过");
		

		// 6. 完整性批量验证
		ErrorEmsList rstValidate = getEmsValidate().beforeSaveValidate(szOrderPakageInfo);
		if (!CiOrdUtils.isEmpty(rstValidate)) {
			// 设置错误信息数据
			rst.setErrorEmsList(rstValidate.asFArrayList());
			// 将错误的医嘱保存对象从保存集合中移除
			OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList(szOrderPakageInfo);
			orderPackageInfoList.removeAll(rstValidate.asMetaDataList());
			szOrderPakageInfo = orderPackageInfoList.asArray();
		}
		// 8. 批量执行
		OrderSavedRstInfo[] szInnerOrderSaveInfo = handleSaveOrderPackageList(ctx, szOrderPakageInfo);
		OrdBizLogger.info(ctx, "[SaveBP]保存数据库通过");
		
		// 9. 返回值处理
		FArrayList rstList = new FArrayList();
		for (OrderSavedRstInfo orderAggInfo : szInnerOrderSaveInfo) {
			rstList.append(orderAggInfo.getOrderAggInfo());
		}
		rst.setDocument(rstList);
		OrdBizLogger.info(ctx, "[SaveBP]处理返回值Order信息");
		return rst;
	}

	
	/**
	 * 处理医嘱包的保存
	 * @param ctx
	 * @param szOrderPackageInfo
	 * @return
	 * @throws BizException
	 */
	protected OrderSavedRstInfo[] handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		List<OrderSavedRstInfo> listInnerOrderSaveInfo = new ArrayList<OrderSavedRstInfo>();
		
		OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList(szOrderPackageInfo);
		
		// 保存医嘱信息
		CiOrderDO[] szOrderInfo = orderPackageInfoList.asOrderArray();
		if (!CiOrdUtils.isEmpty(szOrderInfo)){
			szOrderInfo = ServiceFinder.find(ICiorderMDOCudService.class).save(szOrderInfo);
			
		}
		// 保存医嘱服务信息
		OrdSrvDO[] szOrdSrvInfo = orderPackageInfoList.asOrderSrvArray();
		if (!CiOrdUtils.isEmpty(szOrdSrvInfo)){
			szOrdSrvInfo = ServiceFinder.find(IOrdSrvDOCudService.class).save(szOrdSrvInfo);
			
		}
		// 保存医嘱服务物品信息
		OrdSrvMmDO[] szOrdSrvMmInfo = orderPackageInfoList.asOrderSrvMmArray();
		if (!CiOrdUtils.isEmpty(szOrdSrvMmInfo)){
			szOrdSrvMmInfo = CiOrdAppUtils.getOrsrvmmService().save(szOrdSrvMmInfo);
			
		}
			
		OrderSavedRstInfo innerOrderSaveInfo = new OrderSavedRstInfo();
		
		CiorderAggDO orderAggInfo = new CiorderAggDO();
		orderAggInfo.setParentDO(szOrderInfo[0]);
		orderAggInfo.setOrdSrvDO(szOrdSrvInfo);
		innerOrderSaveInfo.setOrderAggInfo(orderAggInfo);
		listInnerOrderSaveInfo.add(innerOrderSaveInfo);
		
		return listInnerOrderSaveInfo.toArray(new OrderSavedRstInfo[listInnerOrderSaveInfo.size()]);
	}
	
	
	protected <T extends BaseDO> DefaultCreateParam[] SingleSrv_DefaultCreateParamArrayOf(List<Object> listUiModel) throws BizException{
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		for (Object uiModel : listUiModel){
			T doInfo = (T)uiModel;
			som.put(doInfo.getAttrVal("Id_srv").toString(), uiModel);
		}
		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(som.asKeyArray(),FBoolean.FALSE);
		assert CiOrdUtils.isEmpty(szMedSrvInfo) : "获取医疗单基础服务数据失败";
		for (MedSrvDO srvInfo : szMedSrvInfo){
			listDefaultCreateParam.add(new DefaultCreateParam(srvInfo,som.get(srvInfo.getId_srv())));
		}
		return listDefaultCreateParam.asArray();
	}
	
	protected <T extends BaseDO> DefaultCreateParam[] GroupDrugs_DefaultCreateParamArrayOf(List<Object> listUiModel) throws BizException{
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		
		return listDefaultCreateParam.asArray();
	}

	/**
	 * 构建医嘱保存时候的数据对象数组
	 * 
	 * @param objList
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo[] handleOrderAggInfoList(CiEnContextDTO ctx, FArrayList objList) throws BizException {
		OrderPackageInfoList listOrderPakageInfo = new OrderPackageInfoList();
		// 定义新建医嘱集合与更新医嘱集合
		List<Object> listCreateInfo = new ArrayList<Object>();
		List<Object> listUpdateInfo = new ArrayList<Object>();
		for (Object objInfo : objList) {
			// 是否为新建医疗单
			if (GetSrvObjStatus(objInfo) == DOStatus.NEW) {
				listCreateInfo.add(objInfo);
			}
			// 更新医疗单
			else if (GetSrvObjStatus(objInfo) == DOStatus.UPDATED || GetSrvObjStatus(objInfo) == DOStatus.DELETED) {
				listUpdateInfo.add(objInfo);
			}
		}
		
		OrderPackageInfo[] szCreateOrderAgg = handleCreateOrderInfo(ctx, listCreateInfo);
		if (szCreateOrderAgg != null && szCreateOrderAgg.length > 0) {
			listOrderPakageInfo.addAll(Arrays.asList(szCreateOrderAgg));
		}

		OrderPackageInfo[] szUpdateOrderAgg = handleUpdateOrderInfo(ctx, listUpdateInfo);
		if (szUpdateOrderAgg != null && szUpdateOrderAgg.length > 0) {
			listOrderPakageInfo.addAll(Arrays.asList(szUpdateOrderAgg));
		}

		return listOrderPakageInfo.asArray();
	}

	/**
	 * 获取服务对象的状态
	 * 
	 * @param objDO
	 * @return
	 */
	protected int GetSrvObjStatus(Object objDO) {
		return DOStatus.UNCHANGED;
	}

	/**
	 * 将医疗单UI模型列表转化为默认创建医疗单参数数组
	 * 
	 * @param listUiModel
	 * @return
	 */
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel)  throws BizException{
		return null;
	}
	
	/**
	 * 批量解析医嘱ID
	 * @param listUiModel
	 * @return
	 */
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel){
		return null;
	}

	/**
	 * 处理新建医嘱逻辑
	 * 
	 * @param itemDO
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo[] handleCreateOrderInfo(CiEnContextDTO ctx, List<Object> listUiModel) throws BizException {
		if (listUiModel == null || listUiModel.size() <= 0)
			return null;
	
		return mergeOrderPakageInfo(ctx,getDefaultCreateOrderInfo().createOrderPakageInfo(ctx,
				defaultCreateParamFrom(listUiModel)));
	}
	
	/**
	 * 处理医嘱更新逻辑
	 * @param ctx 就诊上下文
	 * @param listUiModel 医疗单模型列表
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo[] handleUpdateOrderInfo(CiEnContextDTO ctx, List<Object> listUiModel) throws BizException {
		if (listUiModel == null || listUiModel.size() <= 0)
			return null;

		return mergeOrderPakageInfo(ctx, orderPakageInfoArrayFrom(assembleOrderKey2UiModelMap(listUiModel)));
	}
	
	
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel){
		assert false : "必须实现该方法：服务srv主键与服务ui模型的映射！！！！！！！";
		return null;
	}
	
	/**
	 * 根据用户医疗单UI模型信息，获取医嘱包信息数组
	 * @param szId_or 医嘱ID数组
	 * @return 医嘱包信息数组
	 * @throws BizException
	 */
	protected OrderPackageInfo[] orderPakageInfoArrayFrom(OrderKey2UiModelMap oium) throws BizException{
		OrderPackageInfoList orderPakageInfoList = new OrderPackageInfoList();
		// 获取医嘱服务聚集信息
		CiorderAggDO[] szCiorderAggInfo = CiOrdAppUtils.getOrAggQryService().findByBIds(oium.asKeyArray(), FBoolean.FALSE);
		// 查询套内项目信息
		for (CiorderAggDO orderAggInfo : szCiorderAggInfo){
			// 获取医嘱信息
			CiOrderDO orderInfo = orderAggInfo.getParentDO();
			// 获取服务项目数组
			OrdSrvDO[] szOrdSrvDO = orderAggInfo.getOrdSrvDO();
			// 查询套内项目数组
			OrdSrvSetDO[] szOrdSrvSetDO = ServiceFinder.find(IOrdsrvsetRService.class).
					findByAttrValStrings(OrdSrvSetDO.ID_OR, new String[]{orderInfo.getId_or()});
			// 查询物品项目数组
			OrdSrvMmDO[] szOrdSrvMmDO = ServiceFinder.find(IOrdsrvmmRService.class).
					findByAttrValStrings(OrdSrvMmDO.ID_ORSRV, OrderUtils.ModelAttrValues(szOrdSrvDO, OrdSrvMmDO.ID_ORSRV));
			// 查询变动用药信息数组
			OrdSrvDoseDO[] szOrdSrvDoseDO = ServiceFinder.find(IOrdsrvdoseRService.class).
					findByAttrValStrings(OrdSrvMmDO.ID_ORSRV, OrderUtils.ModelAttrValues(szOrdSrvDO, OrdSrvMmDO.ID_ORSRV));
			// 查询申请单信息
			Object[] szOrderAppSheetList = qryOrderAppSheetList(new String[]{orderInfo.getId_or()});
			
			// 获取服务项目的主键和UI模型的映射
			SrvKey2UiModelMap srvKeyUiModelCache =  assembleSrvKey2UiModelMap(oium.get(orderInfo.getId_or()));
			
			// 组装医嘱服务包
			OrderPackageInfo opi = new OrderPackageInfo();
			opi.setStatus(DOStatus.UPDATED);
			opi.setOrderInfo(orderAggInfo.getParentDO());
			Map<String, OrdSrvMmDO> tmpSrvKeyOrdSrvMmCache = new HashMap<String, OrdSrvMmDO>();
			
			if (!CiOrdUtils.isEmpty(szOrdSrvMmDO)){
				for (OrdSrvMmDO mmInfo : szOrdSrvMmDO){
					tmpSrvKeyOrdSrvMmCache.put(mmInfo.getId_orsrv(), mmInfo);
				}
			}
			
			OrderSrvMmList ordSrvMmInfoList = new OrderSrvMmList();
			for (OrdSrvDO srvInfo : orderAggInfo.getOrdSrvDO()){
				Object uiModel = srvKeyUiModelCache.containsKey(srvInfo.getId_orsrv())?srvKeyUiModelCache.get(srvInfo.getId_orsrv()):null;
				OrderSrvMmInfo orderSrvMmInfo = new OrderSrvMmInfo(srvInfo,uiModel);
				if (tmpSrvKeyOrdSrvMmCache.containsKey(srvInfo.getId_orsrv())){
					orderSrvMmInfo.setOrderSrvMmInfo(tmpSrvKeyOrdSrvMmCache.get(srvInfo.getId_orsrv()));
				}
				ordSrvMmInfoList.add(orderSrvMmInfo);
			}
			opi.setOrderSrvMmList(ordSrvMmInfoList);
			//基础服务信息
			opi.setBdSrvList(bdSrvInfoListFrom(orderInfo,ordSrvMmInfoList));
//			if (CiOrdUtils.isTrue(orderInfo.getFg_set())){
//				MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[]{orderInfo.getId_srv()});
//				opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
//			}
//			else{
//				
//				MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(ordSrvMmInfoList.asSrvKeyArray());
//				opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
//			}
			
			if(!CiOrdUtils.isEmpty(szOrdSrvSetDO)){
				opi.setOrderSrvSetList(new OrderSrvSetList(szOrdSrvSetDO));
			}
			if (!CiOrdUtils.isEmpty(szOrdSrvDoseDO)){
				opi.setOrderSrvDoseList(new OrderSrvDoseList(szOrdSrvDoseDO));
			}
			if (!CiOrdUtils.isEmpty(szOrderAppSheetList)){
				opi.setOrderAppSheetList(new ObjectList(szOrderAppSheetList));
			}
			opi.setUiModel(oium.get(orderInfo.getId_or()));
			orderPakageInfoList.add(opi);
		}
		
		
		return orderPakageInfoList.asArray();
	}
	
	protected BdSrvInfoList bdSrvInfoListFrom(CiOrderDO orderInfo,OrderSrvMmList ordSrvMmInfoList) throws BizException{
		if (CiOrdUtils.isTrue(orderInfo.getFg_set())){
			MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[]{orderInfo.getId_srv()});
			return (new BdSrvInfoList(szMedSrvInfo));
		}
		else{
			
			MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(ordSrvMmInfoList.asSrvKeyArray());
			return (new BdSrvInfoList(szMedSrvInfo));
		}
	}
	
	
	/**
	 * 合并用户数据到默认医嘱中
	 * @param ctx 就诊上下文
	 * @param szOrderPakageInfo 批量医嘱包信息
	 * @return 批量医嘱包信息（合并过信息）
	 * @throws BizException 业务异常
	 */
	protected OrderPackageInfo[]  mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo) throws BizException{
		// 
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			
			// 合并医嘱UI模型数据
			mergeOrderInfo(ctx, pInfo.getOrderInfo(), pInfo.getUiModel());

			// 合并服务UI模型数据
			for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()) {
				// 合并服务信息
				mergeOrderSrvInfo(ctx, srvMmInfo.getOrderSrvInfo(), srvMmInfo.getUiModel());
				
				// 处理其他信息
				afterMergeOrderSrvInfo(ctx,pInfo.getOrderInfo(),srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());
				
				if (CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_mm())){
					mergeOrderMmInfo(ctx, srvMmInfo.getOrderSrvMmInfo(),srvMmInfo.getUiModel());
			}
			}
			// 处理医嘱服务的医保信息
			handleOrderHpInfo(ctx, pInfo.getOrderInfo());
			//FIXME handleSrvHpInfo方法需要同时传入srv和与srv关联的srvmm
			// 处理医嘱服务医保信息
			OrderSrvMmList szOrdSrvMmInfo = pInfo.getOrderSrvMmList();
			handleSrvHpInfo(ctx, szOrdSrvMmInfo);
			// 医保信息处理完毕之后的其他任务
			OrdSrvDO[] szOrdSrvInfo = pInfo.getOrderSrvList();
			afterHandleHpInfo(ctx, pInfo.getOrderInfo(),szOrdSrvInfo);
		}
		return szOrderPakageInfo;
	}

	/**
	 * 将UI模型数据合并到医嘱信息中
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, Object uiModel) throws BizException {

	}

	/**
	 * 将UI信息合并到服务中
	 * 
	 * @param ctx
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {

	}

	/**
	 * 合并服务信息之后的处理
	 * @param ctx
	 * @param orderInfo
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, final CiOrderDO orderInfo, OrdSrvDO srvInfo, Object uiModel) throws BizException {

	}
	

	/**
	 * 
	 * @param ctx
	 * @param opInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {

	}
	/**
	 * 合并申请单之后的处理
	 * @param ctx
	 * @param orderInfo
	 * @param appSheetList
	 * @param extInfoList
	 * @param uiModel
	 * @throws BizException
	 */
	protected void afterMergeOrderAppInfo(CiEnContextDTO ctx,final CiOrderDO orderInfo, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {

	}

	/**
	 * 合并物品信息
	 * 
	 * @param ctx
	 * @param mmList
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderMmInfo(CiEnContextDTO ctx, OrdSrvMmDO srvMmInfo, Object uiModel) throws BizException {

	}

	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException{
		return OrderUtils.QryOrderAppSheetList(szId_or);
	}
	
	@Override
	public boolean handleOrderHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo) {
		// TODO Auto-generated method stub
		return orderHpInfoBP.handleOrderHpInfo(ctx, orderInfo);
	}

	@Override
	public boolean handleSrvHpInfo(CiEnContextDTO ctx, OrderSrvMmList szSrvInfo) {
		// TODO Auto-generated method stub
		return orderHpInfoBP.handleSrvHpInfo(ctx, szSrvInfo);
	}

	@Override
	public boolean afterHandleHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] szSrvInfo) {
		// TODO Auto-generated method stub
		return orderHpInfoBP.afterHandleHpInfo(ctx, orderInfo, szSrvInfo);
	}
	
}

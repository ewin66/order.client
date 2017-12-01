package iih.ci.ord.s.ems.biz.op.base.bp;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import iih.bd.base.cache.CacheContext;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseRService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.bp.IEmsLoadBP;
import iih.ci.ord.s.ems.biz.meta.BdSrvInfoList;
import iih.ci.ord.s.ems.biz.meta.ObjectList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.biz.meta.OrderSrvDoseList;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.meta.OrderSrvSetList;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 医疗单加载业务逻辑处理 -- 基类
 * @author wangqingzhu
 *
 */
public class EmsBaseLoadBP extends CacheContext implements IEmsLoadBP{

	@Override
	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException{
		return new EmsRstDTO[]{new EmsRstDTO()};
	}
	/**
	 * 获取医疗单对象
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	protected CiEmsDTO ciEmsInfoFrom(String id_or) throws BizException{
		FMap fmap = ServiceFinder.find(ICiOrdQryService.class).getCiEmsDTO(new String[] { id_or });
		CiEmsDTO ems = (CiEmsDTO) fmap.get(id_or);
        ems.setStatus( DOStatus.UPDATED);
        return ems;
	}
	
	protected FArrayList handleReturnDocument(Object objInfo) throws BizException{
		FArrayList objList = new FArrayList();
		objList.add(objInfo);
		
		return objList;
	}
	
	/**
	 * 获取医疗单主服务信息
	 * @param ciEmsInfo
	 * @return
	 * @throws BizException 
	 */
	protected CiEmsSrvDTO mainSrvInfoFrom(CiEnContextDTO ctx,CiEmsDTO ciEmsInfo) throws BizException{
		CiEmsSrvDTO mainSrvInfo = null;
		if (CiOrdUtils.isTrue(ciEmsInfo.getFg_set())){
			mainSrvInfo = new CiEmsSrvDTO();
			mainSrvInfo.setStatus(DOStatus.UPDATED);
			mainSrvInfo.setId_srv(ciEmsInfo.getId_srv());
			mainSrvInfo.setName_srv(ciEmsInfo.getName());
			mainSrvInfo.setSd_srvtp(ciEmsInfo.getSd_srvtp());
			mainSrvInfo.setInnercode_srvca(ciEmsInfo.getInnercode_srvca());
			mainSrvInfo.setId_emp_srv(ciEmsInfo.getId_emp_phy());
			mainSrvInfo.setDt_create_srv(ciEmsInfo.getDt_begin());
			mainSrvInfo.setQuan_med(ciEmsInfo.getQuan_medu());
			mainSrvInfo.setId_unit_med(ciEmsInfo.getId_unit_med());
			mainSrvInfo.setName_unit_med(ciEmsInfo.getName_unit_med());
			mainSrvInfo.setId_dep(ciEmsInfo.getId_dep_mp());
			String key_dep_mp = String.format("%s-%s", ciEmsInfo.getId_or(), ciEmsInfo.getId_dep_mp());
			String name_mp_dep = this.getCache(L1SessionKeyWith(ctx), key_dep_mp);
			if (CiOrdUtils.isEmpty(name_mp_dep)){
				DeptDO[] szDeptDO = ServiceFinder.find(IDeptRService.class).findByAttrValString(DeptDO.ID_DEP, ciEmsInfo.getId_dep_mp());
				assert CiOrdUtils.isEmpty(szDeptDO):"获取执行科室名称失败！";
				name_mp_dep = szDeptDO[0].getName();
				this.putCache(L1SessionKeyWith(ctx), key_dep_mp, name_mp_dep);
			}
			mainSrvInfo.setName_dep(name_mp_dep);
		}
		else{
			 for ( Object item : ciEmsInfo.getEmssrvs()) {
		        	CiEmsSrvDTO srv = (CiEmsSrvDTO) item;
			if (srv.getId_srv().equals(ciEmsInfo.getId_srv())){
		        	   mainSrvInfo = srv;
		        	   break;
			}
		}
		}
		
		
		return mainSrvInfo;
	}
	
	/**
	 * 医嘱主键与医嘱UI模型的映射表代理
	 * @author wangqingzhu
	 *
	 */
	public static interface IOrderKey2UiModelMapFrom{
		public OrderKey2UiModelMap getOrderKey2UiModelMap(Object objInfo);
	}
	
	
	
	/**
	 * 
	 * @param objInfo
	 * @param itf
	  * @return
	  * @throws BizException
	  */
	protected OrderPackageInfo[] orderPakageInfoArrayFrom(Object objInfo, IOrderKey2UiModelMapFrom orderDelegate,ISrvKey2UiModelMapFrom srvDelegate) throws BizException{
		return orderPakageInfoArrayFrom(orderDelegate.getOrderKey2UiModelMap(objInfo),srvDelegate);
	}
	
	/**
	 * 医嘱服务主键与UI模型的映射表代理
	 * @author wangqingzhu
	 *
	 */
	public static interface ISrvKey2UiModelMapFrom{
		public SrvKey2UiModelMap getSrvKey2UiModelMap(Object objInfo);
	}
	
	/**
	 * 根据用户医疗单UI模型信息，获取医嘱包信息数组
	 * @param szId_or 医嘱ID数组
	 * @return 医嘱包信息数组
	 * @throws BizException
	 */
	protected OrderPackageInfo[] orderPakageInfoArrayFrom(OrderKey2UiModelMap oium, ISrvKey2UiModelMapFrom srvDelegate) throws BizException{
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
					findByAttrValStrings("Id_or", new String[]{orderInfo.getId_or()});
			// 查询物品项目数组
			OrdSrvMmDO[] szOrdSrvMmDO = ServiceFinder.find(IOrdsrvmmRService.class).
					findByAttrValStrings("Id_orsrv", OrderUtils.ModelAttrValues(szOrdSrvDO, "Id_orsrv"));
			// 查询变动用药信息数组
			OrdSrvDoseDO[] szOrdSrvDoseDO = ServiceFinder.find(IOrdsrvdoseRService.class).
					findByAttrValStrings("Id_orsrv", OrderUtils.ModelAttrValues(szOrdSrvDO, "Id_orsrv"));
			// 查询申请单信息
			Object[] szOrderAppSheetList = OrderUtils.QryOrderAppSheetList(new String[]{orderInfo.getId_or()});
			
			// 获取服务项目的主键和UI模型的映射
			SrvKey2UiModelMap srvKeyUiModelCache = srvDelegate.getSrvKey2UiModelMap(oium.get(orderInfo.getId_or())) ;
			
			// 组装医嘱服务包
			OrderPackageInfo opi = new OrderPackageInfo();
			
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
			if (CiOrdUtils.isTrue(orderInfo.getFg_set())){
				MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[]{orderInfo.getId_srv()});
				opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
			}
			else{
				MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(ordSrvMmInfoList.asSrvKeyArray());
				opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
			}
			
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
	
	/**
	 * 根据用户医疗单UI模型信息，获取医嘱包信息数组
	 * @param szId_or 医嘱ID数组
	 * @return 医嘱包信息数组
	 * @throws BizException
	 */
	protected OrderPackageInfo[] orderPakageInfoArrayFrom(String[] szId_or) throws BizException{
		OrderPackageInfoList orderPakageInfoList = new OrderPackageInfoList();
		// 获取医嘱服务聚集信息
		CiorderAggDO[] szCiorderAggInfo = CiOrdAppUtils.getOrAggQryService().findByBIds(szId_or, FBoolean.FALSE);
		// 查询套内项目信息
		for (CiorderAggDO orderAggInfo : szCiorderAggInfo){
			// 获取医嘱信息
			CiOrderDO orderInfo = orderAggInfo.getParentDO();
			// 获取服务项目数组
			OrdSrvDO[] szOrdSrvDO = orderAggInfo.getOrdSrvDO();
			// 查询套内项目数组
			OrdSrvSetDO[] szOrdSrvSetDO = ServiceFinder.find(IOrdsrvsetRService.class).
					findByAttrValStrings("Id_or", new String[]{orderInfo.getId_or()});
			// 查询物品项目数组
			OrdSrvMmDO[] szOrdSrvMmDO = ServiceFinder.find(IOrdsrvmmRService.class).
					findByAttrValStrings("Id_orsrv", OrderUtils.ModelAttrValues(szOrdSrvDO, "Id_orsrv"));
			// 查询变动用药信息数组
			OrdSrvDoseDO[] szOrdSrvDoseDO = ServiceFinder.find(IOrdsrvdoseRService.class).
					findByAttrValStrings("Id_orsrv", OrderUtils.ModelAttrValues(szOrdSrvDO, "Id_orsrv"));
			// 查询申请单信息
			Object[] szOrderAppSheetList = OrderUtils.QryOrderAppSheetList(new String[]{orderInfo.getId_or()});
			
			
			// 组装医嘱服务包
			OrderPackageInfo opi = new OrderPackageInfo();
			
			opi.setOrderInfo(orderAggInfo.getParentDO());
			Map<String, OrdSrvMmDO> tmpSrvKeyOrdSrvMmCache = new HashMap<String, OrdSrvMmDO>();
		
			if (!CiOrdUtils.isEmpty(szOrdSrvMmDO)){
				for (OrdSrvMmDO mmInfo : szOrdSrvMmDO){
					tmpSrvKeyOrdSrvMmCache.put(mmInfo.getId_orsrv(), mmInfo);
				}
			}
			
			OrderSrvMmList ordSrvMmInfoList = new OrderSrvMmList();
			for (OrdSrvDO srvInfo : orderAggInfo.getOrdSrvDO()){
				
				OrderSrvMmInfo orderSrvMmInfo = new OrderSrvMmInfo(srvInfo,null);
				if (tmpSrvKeyOrdSrvMmCache.containsKey(srvInfo.getId_orsrv())){
					orderSrvMmInfo.setOrderSrvMmInfo(tmpSrvKeyOrdSrvMmCache.get(srvInfo.getId_orsrv()));
				}
				ordSrvMmInfoList.add(orderSrvMmInfo);
			}
			opi.setOrderSrvMmList(ordSrvMmInfoList);
			//基础服务信息
			if (CiOrdUtils.isTrue(orderInfo.getFg_set())){
				MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[]{orderInfo.getId_srv()});
				opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
  }
			else{
				MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(ordSrvMmInfoList.asSrvKeyArray());
				opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
			}
			
			if(!CiOrdUtils.isEmpty(szOrdSrvSetDO)){
				opi.setOrderSrvSetList(new OrderSrvSetList(szOrdSrvSetDO));
			}
			if (!CiOrdUtils.isEmpty(szOrdSrvDoseDO)){
				opi.setOrderSrvDoseList(new OrderSrvDoseList(szOrdSrvDoseDO));
			}
			if (!CiOrdUtils.isEmpty(szOrderAppSheetList)){
				opi.setOrderAppSheetList(new ObjectList(szOrderAppSheetList));
			}
			opi.setUiModel(null);
			orderPakageInfoList.add(opi);
		}

		return orderPakageInfoList.asArray();
	}

}

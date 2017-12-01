package iih.ci.ord.s.ems.biz.op.emsv1.def;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.mm.itf.basematerialdto.d.BaseMaterialDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 默认药品创建医嘱
 * @author wangqingzhu
 *
 */
public class DefaultDrugsCreateOrderInfo extends DefaultSingleSrvCreateOrderInfo {
	

	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		
		// 药品id不能为空
		if (!isValidate(szParam)){
			return null;
		}
		
		OrderPackageInfo[] szOrderPakageInfo = super.createOrderPakageInfo(ctx, szParam);
		if(CiOrdUtils.isEmpty(szOrderPakageInfo)){
			return null;
		}
		for (DefaultCreateParam param : szParam){
			
			// 处理物品信息,建立临时缓存
			Map<String,MeterialDO> tmpMmInfoMap = new HashMap<String,MeterialDO>();
			MeterialDO[] szMmInfo = ServiceFinder.find(IMeterialMDORService.class).findByIds(param.getBdSrvMmInfoList().asIdMmArray(),FBoolean.FALSE);
			if (CiOrdUtils.isEmpty(szMmInfo)){
				return null;
			}
			for (MeterialDO mmInfo : szMmInfo){
				tmpMmInfoMap.put(mmInfo.getId_mm(), mmInfo);
			}

			// 批量处理物品信息
			for (OrderPackageInfo orderPakageInfo : szOrderPakageInfo){
				// 获取医嘱和医嘱服务信息
				CiOrderDO orderInfo = orderPakageInfo.getOrderInfo();
				OrdSrvDO[] szOrdSrvInfo = orderPakageInfo.getOrderSrvList();
				OrdSrvDO mainSrvInfo = szOrdSrvInfo[0];
				//MedSrvDO[] medSrvDos = orderPakageInfo.getBdSrvList();
				OrderSrvMmList ordSrvMmDos = orderPakageInfo.getOrderSrvMmList();
				OrderSrvMmInfo orderSrvMmInfo = ordSrvMmDos.get(0);
				// 获取物品信息
				MeterialDO mmInfo = tmpMmInfoMap.get(orderSrvMmInfo.getOrderSrvMmInfo().getId_mm());
				// 处理医嘱和主服务信息
				handleOrderMainSrvInfo(ctx, orderInfo, mainSrvInfo, mmInfo.getId_mm());
				// 处理成组药共同信息
				handleSrvSameInfo(orderInfo.getId_freq(),orderInfo.getId_route(),szOrdSrvInfo);
				// 处理医嘱服务信息
				handleOrderSrvInfo(ctx,orderInfo.getId_dep_mp(),szOrdSrvInfo,tmpMmInfoMap);
				// 处理医嘱物品
				//handleSrvMmInfo(ctx,orderPakageInfo,tmpMmInfoMap);
				// 处理皮试标志
				orderInfo.setFg_skintest(hasSkinTestInfo(ctx,szOrdSrvInfo,tmpMmInfoMap));
			}
		}
		

		return szOrderPakageInfo;
	}
	@Override
	protected DefaultBaseCreateOrderInfo createOrderInfo(OrderPackageInfo orderPakageInfo, MedSrvDO mainBdSrvInfo)
			throws BizException {
		//by yzh 2017-08-23 19:04:50  
		EmsDrugItemDO uiModel = (EmsDrugItemDO) orderPakageInfo.getUiModel();
		orderPakageInfo.getOrderInfo().setId_srvof(uiModel.getId_srvof());
		return super.createOrderInfo(orderPakageInfo, mainBdSrvInfo);
	}
	
	
	
//	/**
//	 * 获取用法关联服务费用
//	 * @param emstype
//	 * @param aggdo
//	 * @return
//	 * @throws BizException
//	 */
//	private  OrdSrvDO[] getCiOrRelUsgFeeOrSrvInfo(CiorderAggDO aggdo) throws BizException{
//		//获得医嘱关联费用服务数据
//		CiOrUsageRelFeeSrvGetBPNew bp=new CiOrUsageRelFeeSrvGetBPNew();
//		CiOrderDO order = aggdo.getParentDO();
//		if(CiOrdUtils.isEmpty(order))return null;
//		UsageRelFeeSrvDO[] relfeesrvdos=bp.exec(false,order.getId_en(),order.getOrders_boil(),order.getId_boil(),order.getId_route());
//		//医嘱关联费用服务信息创建医嘱项目
//		return creatOrdSrvRelFee(aggdo, relfeesrvdos,new Hashtable());
//	}

	private boolean isValidate(DefaultCreateParam[] szParam){
		for (DefaultCreateParam param : szParam){
			if (CiOrdUtils.isEmpty(param.getBdSrvMmInfoList())||
					CiOrdUtils.isEmpty(param.getBdSrvMmInfoList().asIdSrvArray())||
					CiOrdUtils.isEmpty(param.getBdSrvMmInfoList().asIdMmArray())){
				return false;
			}
		}
		return true;
	}

	/**
	 * 处理医嘱和主服务信息
	 * @param ctx
	 * @param orderInfo
	 * @param srvInfo
	 * @param id_mm
	 * @throws BizException
	 */
	protected void handleOrderMainSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO srvInfo, String id_mm) throws BizException{
		handleMpWhDeptInfo(ctx,null,srvInfo,id_mm);
		orderInfo.setId_dep_mp(srvInfo.getId_dep_mp());
		orderInfo.setId_route(srvInfo.getId_route());
		orderInfo.setId_freq(srvInfo.getId_freq());
		orderInfo.setSd_frequnitct(srvInfo.getSd_frequnitct());
	}

	/**
	 * 处理基数药
	 * @param ordsrvs
	 * @param tmpMmInfoMap
	 * @throws BizException
	 */
	private void handleOrderSrvInfo(CiEnContextDTO ctx,String id_dep_main, OrdSrvDO[] ordsrvs,Map<String,MeterialDO> tmpMmInfoMap) throws BizException{
		List<BaseMaterialDTO> materialList=new ArrayList<BaseMaterialDTO>();
		
		for(OrdSrvDO srvInfo:ordsrvs){
			if (tmpMmInfoMap.containsKey(srvInfo.getId_srv())){
				MeterialDO mmInfo = tmpMmInfoMap.get(srvInfo.getId_srv());
				
				// 处理执行科室
				handleMpWhDeptInfo(ctx, id_dep_main, srvInfo,mmInfo.getId_mm());
				// 有效性判断
				if(CiOrdUtils.isEmpty(srvInfo.getId_dep_mp()))continue;
				// 处理基数药
				BaseMaterialDTO materialDTO=new BaseMaterialDTO();
				materialDTO.setId_srv(srvInfo.getId_srv());
				materialDTO.setId_mm(mmInfo.getId_mm());
				materialDTO.setId_dep(srvInfo.getId_dep_mp());
				materialList.add(materialDTO);
				
			}
		}
		if(materialList.size()==0)return;
		Map<String,BaseMaterialDTO> map=getBaseDrugMap(materialList.toArray(new BaseMaterialDTO[materialList.size()]));
		for(OrdSrvDO srvdo:ordsrvs){
			if(map.containsKey(srvdo.getId_srv()))
				srvdo.setFg_base(map.get(srvdo.getId_srv()).getFg_base());
		}
	}
	
	private void handleSrvSameInfo(String id_freq, String id_route, OrdSrvDO[] szSrvInfo){
		for (OrdSrvDO srvInfo : szSrvInfo){
			srvInfo.setId_freq(id_freq);
			srvInfo.setId_route(id_route);
			
		}
	}
	/**
	 * 获取基数药信息
	 * @param ctx
	 * @param mmdo
	 * @throws BizException 
	 */
	private Map<String,BaseMaterialDTO> getBaseDrugMap(BaseMaterialDTO[]  baseMaterials) throws BizException{
		BaseMaterialDTO[] baseMMDTOS = CiOrdAppUtils.getIMaterialBaseInfoService().isBaseMaterial(baseMaterials);
		Map<String,BaseMaterialDTO>  map = new HashMap<String,BaseMaterialDTO>();
		if(baseMMDTOS != null){
			String key ="";
			for(BaseMaterialDTO  dto:baseMMDTOS){
				key = dto.getId_srv();
				map.put(key, dto);
			}
		}
		return map;	
	}


	private FBoolean hasSkinTestInfo(CiEnContextDTO ctx,OrdSrvDO[] szOrderSrvInfo,Map<String,MeterialDO> tmpMmInfoMap) throws BizException{
		FBoolean hasSkinTest = FBoolean.FALSE;
		for (OrdSrvDO srvInfo : szOrderSrvInfo){
			if (tmpMmInfoMap.containsKey(srvInfo.getId_srv())){
				
				if(FBoolean.FALSE.equals(hasSkinTest) && FBoolean.TRUE.equals(OrderUtils.needFgSkinTest(ctx, tmpMmInfoMap.get(srvInfo.getId_srv())))){
					hasSkinTest = FBoolean.TRUE;
				}
			}
		}
		return hasSkinTest;
	}


}

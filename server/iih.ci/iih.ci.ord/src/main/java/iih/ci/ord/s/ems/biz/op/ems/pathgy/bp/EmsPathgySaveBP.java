package iih.ci.ord.s.ems.biz.op.ems.pathgy.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.ciordems.d.EmsItemInPathgy;
import iih.ci.ord.ciordems.d.EmsPathgyItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSavedRstInfo;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsSingleSaveBP;
import iih.ci.ord.s.ems.biz.op.ems.def.DefaultPathgyCreateOrderInfo;
import iih.ci.ord.s.ems.biz.op.ems.pathgy.EmsPathgyValidate;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 病理医疗单处理逻辑
 * @author wangqingzhu
 *
 */
public class EmsPathgySaveBP extends EmsSingleSaveBP {

	public EmsPathgySaveBP() {
		super();
		// 设置有效性检查
		setEmsValidate(new EmsPathgyValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultPathgyCreateOrderInfo());
	}
	
	public EmsPathgySaveBP(IEmsValidate emsValidate) {
	
		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultPathgyCreateOrderInfo());
	}
	
	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException{

		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		StringObjectMap srvKey2UiModelCache = new StringObjectMap();
		for (Object uiModel : listUiModel){
			EmsPathgyItemDO doInfo = (EmsPathgyItemDO)uiModel;
			som.put(doInfo.getId_srv(), uiModel);
			srvKey2UiModelCache.put(doInfo.getId_srv(), doInfo);
		}
		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(som.asKeyArray(),FBoolean.FALSE);
		assert !CiOrdUtils.isEmpty(szMedSrvInfo) : "获取病理医疗单基础服务数据失败";
		for (MedSrvDO srvInfo : szMedSrvInfo){
			BdSrvMmInfoList bdSrvMmInfoList = new BdSrvMmInfoList();
			bdSrvMmInfoList.add(new BdSrvMmInfo(srvInfo,srvKey2UiModelCache.get(srvInfo.getId_srv())));
			listDefaultCreateParam.add(new DefaultCreateParam(bdSrvMmInfoList,som.get(srvInfo.getId_srv())));
		}
		return listDefaultCreateParam.asArray();
	}

	
	@Override
	protected OrderSavedRstInfo[] handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		OrderSavedRstInfo[] szInnerOrderSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		
		for (OrderPackageInfo opInfo : szOrderPackageInfo) {

			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList()) ) {
				String id_or = opInfo.getOrderInfo().getId_or();
				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				
				if (objAppSheetInfo instanceof CiorapppathgyAggDO) { // 病理申请单保存
					CiOrdAppUtils.getOrapppathgyService().save(
							opInfo.getOrderAppSheetList().toArray(new CiorapppathgyAggDO[opInfo.getOrderAppSheetList().size()]));
				}
			}
		}
		
			return szInnerOrderSaveInfo;
	}
	
	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		OrderKey2UiModelMap oiumm = new OrderKey2UiModelMap();
		for (int index = 0; index < listUiModel.size(); ++index) {
			EmsPathgyItemDO itemDO = (EmsPathgyItemDO) listUiModel.get(index);
			oiumm.put(itemDO.getId_or(), itemDO);
		}
		return oiumm;
	}


	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		SrvKey2UiModelMap o= new SrvKey2UiModelMap();
		EmsPathgyItemDO doInfo = (EmsPathgyItemDO)uiModel;
		
		o.put(doInfo.getId_orsrv(), doInfo);
		
		return o;
	}

	/**
	 * 合并医嘱
	 * @param srvInfo
	 * @param ctx
	 * @return
	 * @throws BizException 
	 */
	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, Object uiModel) throws BizException{
		EmsPathgyItemDO ems = (EmsPathgyItemDO)uiModel;
		orderInfo.setContent_or(CiOrContentUtils.create(orderInfo.getSd_srvtp(), ems.getName_srv(), orderInfo.getRoute_name(), FBoolean.FALSE).toString());
		orderInfo.setDays_or(ems.getUse_days());
		orderInfo.setDt_entry(ems.getDt_begin_ui());
		FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(),ems.getDt_begin_ui(),ems.getDt_end_ui(),ems.getUse_days());
		orderInfo.setDt_effe(dtSE[0]);
		orderInfo.setDt_end(dtSE[1]);
		if (FBoolean.TRUE.equals(orderInfo.getFg_long())
				&& orderInfo.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(orderInfo.getDt_end())) {
			orderInfo.setFg_stop(FBoolean.TRUE);
			orderInfo.setId_emp_stop(ctx.getId_emp_or());
			orderInfo.setId_dep_stop(ctx.getId_dep_or());
			orderInfo.setDt_stop(orderInfo.getDt_entry());
		}
		orderInfo.setFg_mp_in(FBoolean.TRUE);
			orderInfo.setTimes_mp_in(ems.getTimes_mp_in());
			if(ems.getTimes_mp_in() != null){
				orderInfo.setTimes_mp_in(ems.getTimes_mp_in());
			}else{
				orderInfo.setTimes_mp_in(ems.getTimes_cur());
				ems.setTimes_mp_in(ems.getTimes_cur());
			}
		orderInfo.setFuncclassstr(ems.getFuncclassstr());
		orderInfo.setId_srvof(ems.getId_srvof());
		orderInfo.setApplyno(ems.getApplyno());
		orderInfo.setDt_last_bl(OrderUtils.getLastDt(orderInfo.getId_freq(), orderInfo.getDt_effe(), 0,orderInfo.getFg_long()));
		orderInfo.setAmount(ems.getPrice());	
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(orderInfo.getId_freq(), ems.getUse_days());
		orderInfo.setTimes_cur(totalTimes);

		orderInfo.setId_orpltp(OrderUtils.getOrCLoopTpId(orderInfo));// 执行闭环

		orderInfo.setId_dep_mp(ems.getId_mp_dep());
		orderInfo.setDt_last_mp(dtSE[0]);
		orderInfo.setStatus(ems.getStatus());
	}

	/**
	 * 合并服务
	 * @param ctx
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException 
	 */
	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx,OrdSrvDO ordSrvInfo, Object uiModel) throws BizException {
		EmsPathgyItemDO srvdto=(EmsPathgyItemDO)uiModel;
		if(ordSrvInfo.getStatus()==DOStatus.DELETED) return;
		//		ordSrvInfo.setSortno(0);
		ordSrvInfo.setDt_create(srvdto.getDt_begin_ui());
		//
		//				ordSrvInfo.setDt_last_cg(getLastDt(ordSrvInfo.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		ordSrvInfo.setDt_last_bl(OrderUtils.getLastDt(ordSrvInfo.getId_freq(),srvdto.getDt_begin_ui(),null,FBoolean.FALSE));//???
		if(CiOrdUtils.isEmpty(srvdto.getPrice())){
			//映射折扣价，如果折扣价为空，则后台再查询折扣价
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), ordSrvInfo.getId_srv(),srvdto.getPrice().toString(),ordSrvInfo);
		}else{
			ordSrvInfo.setPri(srvdto.getPrice());
			ordSrvInfo.setPri_std(srvdto.getPri_std());//???
			ordSrvInfo.setPri_ratio(srvdto.getPri_ratio());//???
			ordSrvInfo.setId_pripat(srvdto.getId_pripat());//???
		}
//		ordSrvInfo.setEu_sourcemd(srvdto.getEu_sourcemd());
//		ordSrvInfo.setEu_sourcemd(srvdto.getEu_sourcemd()); //添加医疗单来源//???
//		ordSrvInfo.setId_srv_src(srvdto.getId_srv_src());
		ordSrvInfo.setId_dep_mp(srvdto.getId_mp_dep()); 
		ordSrvInfo.setId_org_mp(CiOrdUtils.getOrgOfDept(ordSrvInfo.getId_dep_mp()));
//		ordSrvInfo.setPriby(srvdto.getPri);//2016-09-01  新增
		ordSrvInfo.setStatus(srvdto.getStatus());
	}
	
	/**
	 * 合并申请单
	 */
	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		EmsPathgyItemDO srvdto = (EmsPathgyItemDO) uiModel;
		for (Object obj : appSheetList) {
			CiorapppathgyAggDO aggdo = (CiorapppathgyAggDO) obj;
			orderApplySheetFrom(aggdo, srvdto);
		}
	}
	
	/**
	 * 获取申清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException{
		
		// 病理申请单保存
		CiorapppathgyAggDO[] szCiorapppathgyAggDO = CiOrdAppUtils.getOrapppathgyQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorapppathgyAggDO)){
			return szCiorapppathgyAggDO;
		}
		return null;
	}
	

	/**
	 * 病理申请单内容映射
	 * @param ordo
	 * @param srvInfo
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private void orderApplySheetFrom(CiorapppathgyAggDO aggDO, EmsPathgyItemDO srvInfo)
			throws BizException {
		if (aggDO == null)
			return;
		OrdApPathgyDO pathgyDO = aggDO.getParentDO();
		pathgyDO.setNo_applyform(srvInfo.getNo_applyform());
		pathgyDO.setId_samptp(srvInfo.getId_samptp());
		pathgyDO.setSd_samptp(srvInfo.getSd_samptp());
		pathgyDO.setName_samptp(srvInfo.getName_samptp());
		pathgyDO.setQuan(srvInfo.getQuan());
		pathgyDO.setId_colltp(srvInfo.getId_colltp());
		pathgyDO.setSd_colltp(srvInfo.getSd_colltp());
		pathgyDO.setName_cooltp(srvInfo.getName_colltp());
		pathgyDO.setDes_labsamp(srvInfo.getDes_labsamp());
		pathgyDO.setFg_urgent(srvInfo.getFg_urgent());
		pathgyDO.setId_di(srvInfo.getId_di());
		pathgyDO.setStr_code_di(srvInfo.getStr_code_di());
		pathgyDO.setStr_name_di(srvInfo.getStr_name_di());
		pathgyDO.setName_diag(srvInfo.getName_diag());
		pathgyDO.setId_diitm(srvInfo.getId_diitm());
		pathgyDO.setStr_id_diitm(srvInfo.getStr_id_diitm());
		pathgyDO.setAnnouncements(srvInfo.getAnnouncements());
		pathgyDO.setDes_sympsign(srvInfo.getDes_sympsign());
		pathgyDO.setFg_outer(srvInfo.getFg_outer());
		pathgyDO.setNo_pathgy_old(srvInfo.getNo_pathgy_old());
		pathgyDO.setDt_pathgy_old(srvInfo.getDt_pathgy_old());
		pathgyDO.setDi_pathgy_old(srvInfo.getName_di_pathgy_old());
		pathgyDO.setOrg_pathgy_old(srvInfo.getOrg_pathgy_old());
		pathgyDO.setCollectdes(srvInfo.getCollectdes());
		pathgyDO.setId_emp(srvInfo.getId_emp_coll());
		pathgyDO.setName_coll_emp(srvInfo.getName_emp_coll());
		pathgyDO.setId_dep(srvInfo.getId_dep_coll());
		pathgyDO.setName_dep(srvInfo.getName_dep_coll());
		pathgyDO.setDt_coll(srvInfo.getDt_coll());
		pathgyDO.setId_su_pathgy(ICiDictCodeConst.ID_SU_PATHGY_YSQ);
		pathgyDO.setSd_su_pathgy(ICiDictCodeConst.SD_SU_PATHGY_YSQ);
		pathgyDO.setName_su("已申请");
		pathgyDO.setNo_pathgy(srvInfo.getNo_pathgy());
		pathgyDO.setDt_rptpathgy(srvInfo.getDt_rptpathgy());
		//		pathgyDO.setFg_prn(Fg_prn);//---
		//		pathgyDO.setCnt_prn(Cnt_prn);//---
		pathgyDO.setDef1(srvInfo.getDef1());
		pathgyDO.setDef2(srvInfo.getDef2());
		pathgyDO.setDef3(srvInfo.getDef3());
		pathgyDO.setDef4(srvInfo.getDef4());
		pathgyDO.setDef5(srvInfo.getDef5());
		pathgyDO.setDef6(srvInfo.getDef6());
		pathgyDO.setDef7(srvInfo.getDef7());
		pathgyDO.setDef8(srvInfo.getDef8());
		pathgyDO.setDef9(srvInfo.getDef9());
		pathgyDO.setDef10(srvInfo.getDef10());
		pathgyDO.setDef11(srvInfo.getDef11());
		pathgyDO.setDef12(srvInfo.getDef12());
		pathgyDO.setDef13(srvInfo.getDef13());
		pathgyDO.setDef14(srvInfo.getDef14());
		pathgyDO.setDef15(srvInfo.getDef15());
		pathgyDO.setDef16(srvInfo.getDef16());
		pathgyDO.setDef17(srvInfo.getDef17());
		pathgyDO.setDef18(srvInfo.getDef18());
		pathgyDO.setDef19(srvInfo.getDef19());
		pathgyDO.setDef20(srvInfo.getDef20());
		pathgyDO.setDef21(srvInfo.getDef21());
		pathgyDO.setDef22(srvInfo.getDef22());
		pathgyDO.setDef23(srvInfo.getDef23());
		pathgyDO.setDef24(srvInfo.getDef24());
		pathgyDO.setDef25(srvInfo.getDef25());
		pathgyDO.setDef26(srvInfo.getDef26());
		pathgyDO.setDef27(srvInfo.getDef27());
		pathgyDO.setDef28(srvInfo.getDef28());
		pathgyDO.setDef29(srvInfo.getDef29());
		pathgyDO.setDef30(srvInfo.getDef30());
		pathgyDO.setDef31(srvInfo.getDef31());
		pathgyDO.setDef32(srvInfo.getDef32());
		pathgyDO.setDef33(srvInfo.getDef33());
		pathgyDO.setDef34(srvInfo.getDef34());
		pathgyDO.setDef35(srvInfo.getDef35());
		pathgyDO.setDef36(srvInfo.getDef36());
		pathgyDO.setDef37(srvInfo.getDef37());
		pathgyDO.setDef38(srvInfo.getDef38());
		pathgyDO.setDef39(srvInfo.getDef39());
		pathgyDO.setDef40(srvInfo.getDef40());
		pathgyDO.setDef41(srvInfo.getDef41());
		pathgyDO.setDef42(srvInfo.getDef42());
		pathgyDO.setDef43(srvInfo.getDef43());
		pathgyDO.setDef44(srvInfo.getDef44());
		pathgyDO.setDef45(srvInfo.getDef45());
		pathgyDO.setDef46(srvInfo.getDef46());
		pathgyDO.setDef47(srvInfo.getDef47());
		pathgyDO.setDef48(srvInfo.getDef48());
		pathgyDO.setDef49(srvInfo.getDef49());
		pathgyDO.setDef50(srvInfo.getDef50());
		pathgyDO.setStatus(srvInfo.getStatus());

		FArrayList pathgySamList = srvInfo.getEmsItemInpathgyList();
		OrdApPathgySampDO[] sampDOs = aggDO.getOrdApPathgySampDO();
		Map<String, OrdApPathgySampDO> mapSampDOs = new HashMap<String, OrdApPathgySampDO>();
		if (sampDOs != null && sampDOs.length > 0) {
			for (OrdApPathgySampDO sampDO : sampDOs) {
				mapSampDOs.put(sampDO.getId_appathgysamp(), sampDO);
			}
		}
		
		List<OrdApPathgySampDO> lstSampDOs = new ArrayList<OrdApPathgySampDO>();
		for (int i = 0; i < pathgySamList.size(); i++) {
			EmsItemInPathgy emsItem = (EmsItemInPathgy) pathgySamList.get(i);
			OrdApPathgySampDO pathgySampDO = mapSampDOs.containsKey(emsItem.getId_oriteminpathgy()) ? 
					mapSampDOs.get(emsItem.getId_oriteminpathgy()) : new OrdApPathgySampDO();
			if (pathgyDO.getId_appathgy() != null && pathgySampDO.getId_appathgy() == null) {
				pathgySampDO.setId_appathgy(pathgyDO.getId_appathgy());
			}
			pathgySampDO.setName_labsamp(emsItem.getName_labsamp());
			pathgySampDO.setId_body_coll(emsItem.getId_body_coll());
			pathgySampDO.setSd_body_coll(emsItem.getSd_body_coll());
			pathgySampDO.setBody_coll(emsItem.getBody_coll());
			pathgySampDO.setQuan_coll(emsItem.getQuan_coll());
			pathgySampDO.setId_fixative(emsItem.getId_fixative());
			pathgySampDO.setSd_fixative(emsItem.getSd_fixative());
			pathgySampDO.setFixative(emsItem.getFixative());
			pathgySampDO.setId_su_labsamp(emsItem.getId_su_labsamp());
			pathgySampDO.setSd_su_labsamp(emsItem.getSd_su_labsamp());
			//			pathgySampDO.setName_su_labsamp();
			pathgySampDO.setId_dep_sign(emsItem.getId_dep_sign());
			//			pathgySampDO.setCode_dep_sign();
			//			pathgySampDO.setName_dep_sign();
			pathgySampDO.setId_emp_sign(emsItem.getId_emp_sign());
			//			pathgySampDO.setCode_emp_sign();
			//			pathgySampDO.setName_emp_sign();
			pathgySampDO.setDt_sign(emsItem.getDt_coll());
			pathgySampDO.setSortno(emsItem.getSortno());
			pathgySampDO.setStatus(pathgySampDO.getId_appathgysamp() == null ? DOStatus.NEW : emsItem.getStatus());
			lstSampDOs.add(pathgySampDO);
		}
		aggDO.setOrdApPathgySampDO(lstSampDOs.toArray(new OrdApPathgySampDO[lstSampDOs.size()]));
	}
	@Override
	protected int GetSrvObjStatus(Object uiModel) {
		return ((EmsPathgyItemDO)uiModel).getStatus();
	}
}

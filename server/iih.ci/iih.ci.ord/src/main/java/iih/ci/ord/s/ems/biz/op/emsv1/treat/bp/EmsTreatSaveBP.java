package iih.ci.ord.s.ems.biz.op.emsv1.treat.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrDtLastBlCal4OpenBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsSetSaveBP;
import iih.ci.ord.s.ems.biz.op.ems.def.DefaultTreatCreateOrderInfo;
import iih.ci.ord.s.ems.biz.op.ems.treat.EmsTreatValidate;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 治疗医疗单保存逻辑
 * @author wangqingzhu
 *
 */
public class EmsTreatSaveBP extends EmsSetSaveBP {

	
	public EmsTreatSaveBP() {
		// 设置有效性检查
		setEmsValidate(new EmsTreatValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultTreatCreateOrderInfo());
	}

	
	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException{
		// 定义创建默认医嘱参数列表
    	DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		StringObjectMap srvKey2UiModelCache = new StringObjectMap();
		for (Object uiModel : listUiModel){
			EmsDrugItemDO doInfo = (EmsDrugItemDO)uiModel;
			som.put(doInfo.getId_srv(), uiModel);
			srvKey2UiModelCache.put(doInfo.getId_srv(), doInfo.getEmsOrDrugListEx().get(0));
		}
		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(som.asKeyArray(),FBoolean.FALSE);
		assert !CiOrdUtils.isEmpty(szMedSrvInfo) : "获取治疗医疗单基础服务数据失败";
		for (MedSrvDO srvInfo : szMedSrvInfo){
			BdSrvMmInfoList bdSrvMmInfoList = new BdSrvMmInfoList();
			bdSrvMmInfoList.add(new BdSrvMmInfo(srvInfo,srvKey2UiModelCache.get(srvInfo.getId_srv())));
			listDefaultCreateParam.add(new DefaultCreateParam(bdSrvMmInfoList,som.get(srvInfo.getId_srv())));
		}
		return listDefaultCreateParam.asArray();
    }
	
	

	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		OrderKey2UiModelMap oiumm = new OrderKey2UiModelMap();
		for (int index = 0; index < listUiModel.size(); ++index){
			EmsDrugItemDO itemDO = (EmsDrugItemDO)listUiModel.get(index);
			oiumm.put(itemDO.getId_or(), itemDO);
		}
		return oiumm;
	}


	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		SrvKey2UiModelMap o= new SrvKey2UiModelMap();
		EmsDrugItemDO doInfo = (EmsDrugItemDO)uiModel;
		for (Object um : doInfo.getEmsOrDrugListEx()){
			EmsOrDrug drug = (EmsOrDrug)um;
			o.put(drug.getId_orsrv(), um);
		}
		return o;
	}
	
	/**
	 * 合并医嘱
	 * @param orderInfo
	 * @param uiModel
	 * @throws BizException 
	 */
	protected void mergeOrderInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, Object uiModel) throws BizException{
		EmsDrugItemDO drugItemDO = (EmsDrugItemDO)uiModel;
		EmsOrDrug drugInfo = (EmsOrDrug)drugItemDO.getEmsOrDrugListEx().get(0);
		
		orderInfo.setId_srv(drugInfo.getId_srv());
		orderInfo.setInnercode_srvca(drugInfo.getInnercode_srvca());
		orderInfo.setId_srvca(drugInfo.getId_srvca());
		orderInfo.setSd_srvtp(drugInfo.getSd_srvtp());
		// 剂量
		orderInfo.setId_unit_med(drugInfo.getId_unit_med());
		orderInfo.setQuan_medu(drugInfo.getQuan_med());
		
		// 急
		orderInfo.setFg_urgent(drugInfo.getFg_urgent());
		orderInfo.setContent_or(CiOrContentUtils.create(drugInfo.getSd_srvtp(), drugInfo.getName_srv(), drugInfo.getName_route(), drugInfo.getFg_urgent()).toString());
		
		// 执行科室
		orderInfo.setId_dep_mp(drugInfo.getId_mp_dep());
		orderInfo.setName_dep_mp(drugInfo.getName_mp_dep());
		
		orderInfo.setEu_orsrcmdtp(ctx.getEu_orsrcmdtp());
		// 日期相关
		orderInfo.setDt_end(CiOrdAppUtils.getServerDateTime());
		FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(),CiOrdAppUtils.getServerDateTime(),null, drugItemDO.getUse_days());
		orderInfo.setDt_effe(dtSE[0]);
		orderInfo.setDt_end(dtSE[1]);
		orderInfo.setDt_last_mp(dtSE[0]);
		orderInfo.setFg_urgent(drugItemDO.getFg_urgent());
		orderInfo.setFg_sign(FBoolean.FALSE);
		orderInfo.setDt_invalid(OrderUtils.getDtInvalid(ctx, dtSE[0]));
		orderInfo.setDt_last_bl(OrderUtils.getLastDt(orderInfo.getId_freq(), orderInfo.getDt_effe(), 0,orderInfo.getFg_long()));
		orderInfo.setDt_last_mp(dtSE[0]);
		orderInfo.setFg_chk(CiOrdUtils.nullHandle(null));
		if (FBoolean.TRUE.equals(drugItemDO.getFg_long())
				&& orderInfo.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(orderInfo.getDt_end())) {
			orderInfo.setFg_stop(FBoolean.TRUE);
			orderInfo.setId_emp_stop(ctx.getId_emp_or());
			orderInfo.setId_dep_stop(ctx.getId_dep_or());
			orderInfo.setDt_stop(orderInfo.getDt_entry());
		}

		/*if(CiOrdUtils.isOpWf(ctx.getCode_entp())){
			orderInfo.setFg_mp_in(opDefaultVHandle(drugItemDO));
		}*/
		orderInfo.setFg_mp_in(OrderUtils.IsMpInpatent(ctx, orderInfo.getSd_srvtp(), orderInfo.getId_route(), orderInfo.getFg_mp_in()));
		//orderInfo.setId_srvof(drugItemDO.getId_srvof());
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(orderInfo.getId_freq(), drugItemDO.getUse_days());
		orderInfo.setTimes_cur(totalTimes);
		// 执行闭环
		//orderInfo.setId_orpltp(OrderUtils.getOrCLoopTpId(orderInfo));
	
		orderInfo.setNote_or(drugItemDO.getNote_or());
		
		if(CiOrdUtils.isTrue(orderInfo.getFg_mp_in())){

			if(drugItemDO.getTimes_mp_in() != null){
				orderInfo.setTimes_mp_in(drugItemDO.getTimes_mp_in());
			}else{
				orderInfo.setTimes_mp_in(drugItemDO.getTimes_cur());	
			}
		}
		orderInfo.setStatus(drugItemDO.getStatus());


	}
	
	/**
	 * 门诊默认值处理
	 * @param EmsDrugItemDO emsdto
	 * @throws BizException 
	 */
	private FBoolean opDefaultVHandle(EmsDrugItemDO emsdto) throws BizException{
		String sd_srvtp=emsdto.getSd_srvtp();
		
		//非药品医嘱时
		if(!CiOrdUtils.isPharmacy(sd_srvtp)){
			return FBoolean.TRUE;
			//emsdto.setFg_mp_in(FBoolean.TRUE);
		}
		
		//草药医嘱时
		if(CiOrdUtils.isHerbOrder(sd_srvtp)){
			return FBoolean.FALSE;
			//emsdto.setFg_mp_in(FBoolean.FALSE);
		}
		
		//西成药医嘱时
		if(isOrIV(emsdto)){
			//西成药IV医嘱时
			return FBoolean.TRUE;
			//emsdto.setFg_mp_in(FBoolean.TRUE);
		}else{
			//西成药非IV医嘱时
			return FBoolean.FALSE;
			//emsdto.setFg_mp_in(FBoolean.FALSE);
		}
	}
	/**
	 * 西成药医嘱时，是否为IV医嘱的判断逻辑
	 * @param EmsDrugItemDO emsdto
	 * @return
	 * @throws BizException 
	 */
	private boolean isOrIV(EmsDrugItemDO emsdto) throws BizException{
		return CiOrdUtils.isWesternMedicineIVOr(emsdto.getId_route());
	}
	/**
	 * 合并服务
	 * @param ctx
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException 
	 */
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		EmsOrDrug drugInfo = (EmsOrDrug) uiModel;
		String idSrv = drugInfo.getId_srv();
		if (srvInfo.getId_srv() != null && srvInfo.getId_srv().equals(idSrv)) {
			if (drugInfo.getStatus() == DOStatus.DELETED) {
				srvInfo.setStatus(DOStatus.DELETED);
			} else {
				srvInfo.setId_srv(drugInfo.getId_srv());
				srvInfo.setName_srv(drugInfo.getName_srv());
				srvInfo.setInnercode_srvca(drugInfo.getInnercode_srvca());
				// srvInfo.setCode_srv(drugInfo.getCode_srv());
				srvInfo.setSd_srvtp(drugInfo.getSd_srvtp());
				srvInfo.setId_srvca(drugInfo.getId_srvca());
				srvInfo.setId_medu(drugInfo.getId_unit_med());
				srvInfo.setQuan_medu(drugInfo.getQuan_med());
				srvInfo.setId_dep_mp(drugInfo.getId_mp_dep());
				srvInfo.setId_dep_wh(drugInfo.getId_dep_wh());
				srvInfo.setPri(drugInfo.getPrice());
				srvInfo.setPri_std(drugInfo.getPrice());
				srvInfo.setId_pripat(ctx.getEnt4BannerDTO().getId_pripat());
				srvInfo.setQuan_total_medu(drugInfo.getQuan_cur());
				srvInfo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvInfo.getId_dep_mp()));
				srvInfo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
				srvInfo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
				srvInfo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
				srvInfo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
				srvInfo.setId_hpsrvtp(drugInfo.getId_hpsrvtp());
				srvInfo.setSd_hpsrvtp(drugInfo.getSd_hpsrvtp());
				srvInfo.setEu_sourcemd(drugInfo.getEu_sourcemd());
				srvInfo.setPri(drugInfo.getPrice());
				srvInfo.setFg_selfpay(drugInfo.getFg_selfpay());
				// srvInfo.setPri_std(drugInfo.g.getPri_std());
				// srvInfo.setPri_ratio(drugInfo.getPri_ratio());
				// srvInfo.setId_pripat(drugInfo.getId_pripat());
		
				srvInfo.setStatus(drugInfo.getStatus());
			}
		}
	}
	
	
	

	@Override
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, final CiOrderDO orderInfo, OrdSrvDO srvInfo, Object uiModel)
			throws BizException {
		EmsDrugItemDO drugItemDO = (EmsDrugItemDO)uiModel;
		CiOrDtLastBlCal4OpenBP bp=new CiOrDtLastBlCal4OpenBP();
		srvInfo.setDt_last_bl(bp.exec(srvInfo.getId_freq(),drugItemDO.getDt_begin_ui(),null,drugItemDO.getFg_long()));
	}


	@Override
	protected int GetSrvObjStatus(Object uiModel) {
		return ((EmsDrugItemDO)uiModel).getStatus();
	}

	
}

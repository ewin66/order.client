package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.ris.bp;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
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
import iih.ci.ord.s.ems.biz.op.ems.ris.bp.EmsRisSaveBP;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class TmplRisSaveBP extends EmsRisSaveBP {
	
	public TmplRisSaveBP(IEmsValidate iv) {
		super(iv);
		
	}
	
	@Override
	protected OrderSavedRstInfo[] handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		OrderSavedRstInfo[] szInnerOrderSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);

		for (OrderPackageInfo opInfo : szOrderPackageInfo) {

			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList())) {

				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				//ObjectList objAppSheetList = new ObjectList(opInfo.getOrderAppSheetList());
				if (objAppSheetInfo instanceof OrdApObsDO) {// 检查申请单保存
					CiOrdAppUtils.getOrapprisService().save(
							opInfo.getOrderAppSheetList().toArray(new OrdApObsDO[opInfo.getOrderAppSheetList().size()]));
				}
			}
		}
		return szInnerOrderSaveInfo;
	}

	@Override
	protected int GetSrvObjStatus(Object objDO) {
		// TODO Auto-generated method stub
		return ((EmsObsItemDO) objDO).getStatus();
	}

	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException {
		// 定义创建默认医嘱参数列表
    	DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		StringObjectMap srvKey2UiModelCache = new StringObjectMap();
		for (Object uiModel : listUiModel){
			EmsObsItemDO doInfo = (EmsObsItemDO)uiModel;
			som.put(doInfo.getId_srv(), uiModel);
			srvKey2UiModelCache.put(doInfo.getId_srv(), doInfo);
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
		for (int index = 0; index < listUiModel.size(); ++index) {
			EmsObsItemDO itemDO = (EmsObsItemDO) listUiModel.get(index);
			oiumm.put(itemDO.getId_or(), itemDO);
		}
		return oiumm;
	}
	
	
	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		// 组装映射表
		SrvKey2UiModelMap o= new SrvKey2UiModelMap();
		EmsObsItemDO doInfo = (EmsObsItemDO)uiModel;
		
		o.put(doInfo.getId_orsrv(), doInfo);
		
		return o;
	}
	
	/**
	 * 将前端选择的临床套内项目转化为服务ID的映射表
	 * @param objInfo
	 * @return
	 */
	protected SrvKey2UiModelMap assembleSrvSetItemKey2UiModelMap(Object objInfo){
		SrvKey2UiModelMap o= new SrvKey2UiModelMap();
		
		EmsObsItemDO ems = (EmsObsItemDO)objInfo;
		for(Object obsLapInfo:ems.getEmsOrObsListEx()){
			EmsObsLap itemdo=(EmsObsLap)obsLapInfo;
			if(itemdo.getStatus()!=DOStatus.DELETED){
				o.put(itemdo.getId_srv(), obsLapInfo);
			}
		}
		return o;
	}

	/**
	 * 获取生清单信息
	 * 
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException {
		// 检查申请单保存
		OrdApObsDO[] szOrdApObsDO = CiOrdAppUtils.getOrapprisQryService().findByAttrValStrings(CiOrderDO.ID_OR, szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApObsDO)) {
			return szOrdApObsDO;
		}
		return null;
	}

//	@Override
//	protected OrderPackageInfo[] mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo)
//			throws BizException {
//		// TODO Auto-generated method stub
//		OrderPackageInfo[] szOrderPackageInfo = super.mergeOrderPakageInfo(ctx, szOrderPakageInfo);
//		for (OrderPackageInfo opInfo : szOrderPackageInfo) {
//			EmsObsItemDO ems = (EmsObsItemDO) opInfo.getUiModel();
//
//			if (ems.getFg_set() == FBoolean.TRUE) {
//				StringList itemidlist = new StringList();
//				for (Object obj : ems.getEmsOrObsListEx()) {
//					EmsObsLap itemdo = (EmsObsLap) obj;
//					if (itemdo.getStatus() != DOStatus.DELETED) {
//						itemidlist.add(itemdo.getId_srv());
//					}
//				}
//				
//				OrderSrvExtPackage srvext = ((DefaultLisCreateOrderInfo) this.getDefaultCreateOrderInfo())
//						.CalcSrvFeesOrdSrvInfo(ctx, opInfo.getOrderInfo(), new BdSrvMmInfo(opInfo.getBdSrvList().get(0)),
//								itemidlist.asArray());
//				
//				opInfo.setOrderSrvSetList(srvext.getOrdSrvSetInfoList());
//				opInfo.setOrderSrvMmList(opInfo.getOrderSrvMmList().append(srvext.getOrderSrvMmList()));
//			}
//		}
//		return szOrderPackageInfo;
//	}

	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, Object uiModel) throws BizException {
		// TODO 执行医嘱信息合并
		//super.mergeOrderInfo(ctx, orderInfo, uiModel);
		EmsObsItemDO emsObsItemDO = (EmsObsItemDO) uiModel;
		orderInfo.setContent_or(CiOrContentUtils.create(orderInfo.getSd_srvtp(), emsObsItemDO.getName_srv(),
				orderInfo.getRoute_name(), FBoolean.FALSE).toString());
		orderInfo.setDays_or(emsObsItemDO.getUse_days());
		orderInfo.setDt_entry(emsObsItemDO.getDt_plan());
		FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(), emsObsItemDO.getDt_plan(),
				emsObsItemDO.getDt_plan(), emsObsItemDO.getUse_days());
		orderInfo.setDt_effe(dtSE[0]);
		orderInfo.setDt_end(dtSE[1]);
		orderInfo.setDes_or(emsObsItemDO.getDes_sympsign());
		if (FBoolean.TRUE.equals(orderInfo.getFg_long()) && orderInfo.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(orderInfo.getDt_end())) {
			orderInfo.setFg_stop(FBoolean.TRUE);
			orderInfo.setId_emp_stop(ctx.getId_emp_or());
			orderInfo.setId_dep_stop(ctx.getId_dep_or());
			orderInfo.setDt_stop(orderInfo.getDt_entry());
		}
		if (FBoolean.TRUE.equals(orderInfo.getFg_mp_in())) {
			orderInfo.setTimes_mp_in(emsObsItemDO.getTimes_mp_in());
			if (emsObsItemDO.getTimes_mp_in() != null) {
				orderInfo.setTimes_mp_in(emsObsItemDO.getTimes_mp_in());
			} else {
				orderInfo.setTimes_mp_in(emsObsItemDO.getTimes_cur());
				emsObsItemDO.setTimes_mp_in(emsObsItemDO.getTimes_cur());
			}
		}
		orderInfo.setFuncclassstr(emsObsItemDO.getFuncclassstr());
		orderInfo.setId_srvof(emsObsItemDO.getId_srvof());
		orderInfo.setApplyno(emsObsItemDO.getApplyno());
		orderInfo.setDt_last_bl(OrderUtils.getLastDt(orderInfo.getId_freq(), orderInfo.getDt_effe(), 0,
				orderInfo.getFg_long()));
		orderInfo.setAmount(emsObsItemDO.getPrice());
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(orderInfo.getId_freq(), emsObsItemDO.getUse_days());
		orderInfo.setTimes_cur(totalTimes);
		orderInfo.setId_orpltp(OrderUtils.getOrCLoopTpId(orderInfo));// 执行闭环
		orderInfo.setId_dep_mp(emsObsItemDO.getId_mp_dep());
		orderInfo.setDt_last_mp(dtSE[0]);
		orderInfo.setFg_urgent(emsObsItemDO.getFg_urgent());
		orderInfo.setStatus(emsObsItemDO.getStatus());
	}

	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		// TODO 医嘱服务信息合并
		super.mergeOrderSrvInfo(ctx, srvInfo, uiModel);
		EmsObsItemDO srvdto = (EmsObsItemDO) uiModel;
		if (FBoolean.TRUE.equals(srvdto.getFg_set())) {
			srvInfo.setStatus(DOStatus.DELETED);
		} else {
			if (srvInfo.getStatus() == DOStatus.DELETED)
				return;
			srvInfo.setDt_create(srvdto.getDt_plan());
			srvInfo.setDt_last_bl(OrderUtils.getLastDt(srvInfo.getId_freq(), srvdto.getDt_plan(), null, FBoolean.FALSE));//???
			if (CiOrdUtils.isEmpty(srvdto.getPrice())) {
				//映射折扣价，如果折扣价为空，则后台再查询折扣价
				CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), srvInfo.getId_srv(), srvdto
						.getPrice().toString(), srvInfo);
			} else {
				srvInfo.setPri(srvdto.getPrice());
				srvInfo.setPri_std(srvdto.getPri_std());//???
				srvInfo.setPri_ratio(srvdto.getPri_ratio());//???
				srvInfo.setId_pripat(srvdto.getId_pripat());//???
			}
			//			ordSrvInfo.setId_srv_src(srvdto.getId_srv_src());
			srvInfo.setId_dep_mp(srvdto.getId_mp_dep());
			srvInfo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvInfo.getId_dep_mp()));
			srvInfo.setStatus(srvdto.getStatus());
			//			ordSrvInfo.setPriby(srvdto.getPriby());
		}
	}

	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		// TODO 合并申请单信息
		EmsObsItemDO srvdto = (EmsObsItemDO) uiModel;
		for (Object obj : appSheetList) {
			OrdApObsDO ordris = (OrdApObsDO) obj;
			//ordris.setId_or(srvdto.getId_or());// 医嘱id不需要合并
			ordris.setId_di(srvdto.getId_di());//临床诊断	
			ordris.setId_diitm(srvdto.getId_diitm());//临床诊断子项
			ordris.setStr_id_diitm(srvdto.getStr_id_diitm());//临床诊断明细
			ordris.setStr_code_di(srvdto.getStr_code_di());//诊断编码拼接
			ordris.setStr_name_di(srvdto.getStr_name_di());//诊断名称拼接
			ordris.setName_diag(srvdto.getName_diag());//诊断名称	
			ordris.setNo_applyform(srvdto.getNo_applyobs());//申请单号	
			ordris.setDt_plan(srvdto.getDt_plan());//计划检查日期
			//			ordris.setBiopsy(srvdto.);
			ordris.setDes_sympsign(srvdto.getDes_sympsign());//病情描述
			ordris.setClinicalzztz(srvdto.getClinicalzztz());//临床症状及体征
			ordris.setPastillness(srvdto.getPastillness());//既往病史 
			ordris.setAuximtexam(srvdto.getAuximtexam());//其它检查所见 
			ordris.setFg_urgent(srvdto.getFg_urgent());//加急标识
			ordris.setAnnouncements(srvdto.getAnnouncements());//注意事项 
			ordris.setId_pps(srvdto.getId_pps());//检查目的
			ordris.setSd_pps(srvdto.getSd_pps());//检查目的编码
			ordris.setDes_pps(srvdto.getDes_pps());//检查目的描述	
			//			ordris.setId_su_obs(Id_su_obs);
			//			ordris.setSd_su_obs(Sd_su_obs);
			ordris.setDef1(srvdto.getDef1());
			ordris.setDef2(srvdto.getDef2());
			ordris.setDef3(srvdto.getDef3());
			ordris.setDef4(srvdto.getDef4());
			ordris.setDef5(srvdto.getDef5());

			ordris.setDef6(srvdto.getDef6());
			ordris.setDef7(srvdto.getDef7());
			ordris.setDef8(srvdto.getDef8());
			ordris.setDef9(srvdto.getDef9());
			ordris.setDef10(srvdto.getDef10());

			ordris.setDef11(srvdto.getDef11());
			ordris.setDef12(srvdto.getDef12());
			ordris.setDef13(srvdto.getDef13());
			ordris.setDef14(srvdto.getDef14());
			ordris.setDef15(srvdto.getDef15());

			ordris.setDef16(srvdto.getDef16());
			ordris.setDef17(srvdto.getDef17());
			ordris.setDef18(srvdto.getDef18());
			ordris.setDef19(srvdto.getDef19());
			ordris.setDef20(srvdto.getDef20());

			ordris.setDef21(srvdto.getDef21());
			ordris.setDef22(srvdto.getDef22());
			ordris.setDef23(srvdto.getDef23());
			ordris.setDef24(srvdto.getDef24());
			ordris.setDef25(srvdto.getDef25());

			ordris.setDef26(srvdto.getDef26());
			ordris.setDef27(srvdto.getDef27());
			ordris.setDef28(srvdto.getDef28());
			ordris.setDef29(srvdto.getDef29());
			ordris.setDef30(srvdto.getDef30());

			ordris.setDef31(srvdto.getDef31());
			ordris.setDef32(srvdto.getDef32());
			ordris.setDef33(srvdto.getDef33());
			ordris.setDef34(srvdto.getDef34());
			ordris.setDef35(srvdto.getDef35());

			ordris.setDef36(srvdto.getDef36());
			ordris.setDef37(srvdto.getDef37());
			ordris.setDef38(srvdto.getDef38());
			ordris.setDef39(srvdto.getDef39());
			ordris.setDef40(srvdto.getDef40());

			ordris.setDef41(srvdto.getDef41());
			ordris.setDef42(srvdto.getDef42());
			ordris.setDef43(srvdto.getDef43());
			ordris.setDef44(srvdto.getDef44());
			ordris.setDef45(srvdto.getDef45());

			ordris.setDef46(srvdto.getDef46());
			ordris.setDef47(srvdto.getDef47());
			ordris.setDef48(srvdto.getDef48());
			ordris.setDef49(srvdto.getDef49());
			ordris.setDef50(srvdto.getDef50());

			ordris.setStatus(srvdto.getStatus());
		}
	}

//	@Override
//	protected void mergeOrderSetInfo(CiEnContextDTO ctx, OrdSrvSetDO[] setSrvList, Object uiModel) throws BizException {
//		// TODO 合并套内项目信息
//		for (OrdSrvSetDO srvset : setSrvList) {
//			srvset.setStatus(DOStatus.DELETED);
//		}
//	}

	@Override
	protected void mergeOrderMmInfo(CiEnContextDTO ctx, OrdSrvMmDO srvMmInfo, Object uiModel) throws BizException {
//		EmsObsItemDO srvdto = (EmsObsItemDO) uiModel;
//		StringList itemidlist = new StringList();
//		for (Object obj : srvdto.getEmsOrObsListEx()) {
//			EmsObsLap itemdo = (EmsObsLap) obj;
//			itemidlist.add(itemdo.getId_srv());
//		}
//		for (OrdSrvMmDO mmdo : mmList) {
//			if (itemidlist.contains(mmdo.getId_srv())) {
//				mmdo.setStatus(DOStatus.DELETED);
//			}
//		}
		srvMmInfo.setStatus(DOStatus.DELETED);
	}
}

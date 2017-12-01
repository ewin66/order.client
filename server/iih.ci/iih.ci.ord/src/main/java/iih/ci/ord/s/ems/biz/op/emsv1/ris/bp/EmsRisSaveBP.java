package iih.ci.ord.s.ems.biz.op.emsv1.ris.bp;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.ems.uiemsdto.d.EmsRisViewDTO;
import iih.ci.ord.dto.ems.uiemsdto.d.EmsRisViewItemDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSavedRstInfo;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsSetSaveBP;
import iih.ci.ord.s.ems.biz.op.ems.def.DefaultRisCreateOrderInfo;
import iih.ci.ord.s.ems.biz.op.emsv1.ris.EmsRisValidate;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsRisSaveBP extends EmsSetSaveBP {
	public EmsRisSaveBP() {
		super();
		// 设置有效性检查
		setEmsValidate(new EmsRisValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultRisCreateOrderInfo());
	}

	@Override
	protected OrderSavedRstInfo[] handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		OrderSavedRstInfo[] szInnerOrderSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);

		for (OrderPackageInfo opInfo : szOrderPackageInfo) {

			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList())) {

				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
			
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
		EmsRisViewDTO doInfo = (EmsRisViewDTO)uiModel;
		
		o.put(doInfo.getId_or_srv(), doInfo);
		
		return o;
	}
	
	/**
	 * 将前端选择的临床套内项目转化为服务ID的映射表
	 * @param objInfo
	 * @return
	 */
	protected SrvKey2UiModelMap assembleSrvSetItemKey2UiModelMap(Object objInfo){
		SrvKey2UiModelMap o= new SrvKey2UiModelMap();
		
		EmsRisViewDTO ems = (EmsRisViewDTO)objInfo;
		for(Object obsLapInfo:ems.getEmsrisviewitems()){
			EmsRisViewItemDTO itemdo=(EmsRisViewItemDTO)obsLapInfo;
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

	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, Object uiModel) throws BizException {
		// TODO 执行医嘱信息合并
		//super.mergeOrderInfo(ctx, orderInfo, uiModel);
		EmsRisViewDTO emsRisViewInfo = (EmsRisViewDTO) uiModel;
		orderInfo.setContent_or(CiOrContentUtils.create(orderInfo.getSd_srvtp(), emsRisViewInfo.getName_srv(),
				orderInfo.getRoute_name(), FBoolean.FALSE).toString());
		orderInfo.setDays_or(1);
		orderInfo.setDt_entry(emsRisViewInfo.getDt_plan());
		FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(), emsRisViewInfo.getDt_plan(),
				emsRisViewInfo.getDt_plan(), 1);
		orderInfo.setDt_effe(dtSE[0]);
		orderInfo.setDt_end(dtSE[1]);
		//orderInfo.setDes_or(emsObsItemDO.getDes_sympsign());
		if (FBoolean.TRUE.equals(orderInfo.getFg_long()) && orderInfo.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(orderInfo.getDt_end())) {
			orderInfo.setFg_stop(FBoolean.TRUE);
			orderInfo.setId_emp_stop(ctx.getId_emp_or());
			orderInfo.setId_dep_stop(ctx.getId_dep_or());
			orderInfo.setDt_stop(orderInfo.getDt_entry());
		}
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(orderInfo.getId_freq(), orderInfo.getDays_or());
		if (FBoolean.TRUE.equals(orderInfo.getFg_mp_in())) {
			orderInfo.setTimes_mp_in(totalTimes);
		}
		orderInfo.setTimes_cur(totalTimes);
		//orderInfo.setFuncclassstr(emsObsItemDO.getFuncclassstr());
		orderInfo.setId_srvof(emsRisViewInfo.getId_ems());
		orderInfo.setApplyno(emsRisViewInfo.getNo_applyform());
		orderInfo.setDt_last_bl(OrderUtils.getLastDt(orderInfo.getId_freq(), orderInfo.getDt_effe(), 0,
				orderInfo.getFg_long()));
		orderInfo.setDt_last_mp(dtSE[0]);
		orderInfo.setAmount(emsRisViewInfo.getPrice());
		
		orderInfo.setId_orpltp(OrderUtils.getOrCLoopTpId(orderInfo));// 执行闭环
		orderInfo.setId_dep_mp(emsRisViewInfo.getId_dep_mp());
		
		orderInfo.setFg_urgent(emsRisViewInfo.getFg_urgent());
		orderInfo.setStatus(emsRisViewInfo.getStatus());
	}

	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		// TODO 医嘱服务信息合并
		//super.mergeOrderSrvInfo(ctx, srvInfo, uiModel);
		EmsRisViewDTO emsRisViewDTO = (EmsRisViewDTO) uiModel;
		
		if (srvInfo.getStatus() == DOStatus.DELETED)
			return;
		srvInfo.setDt_create(emsRisViewDTO.getDt_plan());
		srvInfo.setDt_last_bl(OrderUtils.getLastDt(srvInfo.getId_freq(), emsRisViewDTO.getDt_plan(), null, FBoolean.FALSE));//???
		if (CiOrdUtils.isEmpty(emsRisViewDTO.getPrice())) {
			//映射折扣价，如果折扣价为空，则后台再查询折扣价
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(
					ctx.getCode_entp(), 
					srvInfo.getId_srv(), 
					emsRisViewDTO.getPrice().toString(), 
					srvInfo);
		} 
		else {
			srvInfo.setPri(emsRisViewDTO.getPrice());
			srvInfo.setPri_std(emsRisViewDTO.getPrice_std());
			srvInfo.setPri_ratio(emsRisViewDTO.getPrice_ratio());
			srvInfo.setId_pripat(ctx.getEnt4BannerDTO().getId_pripat());
		}
		srvInfo.setId_dep_mp(emsRisViewDTO.getId_dep_mp());
		srvInfo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvInfo.getId_dep_mp()));
		srvInfo.setStatus(emsRisViewDTO.getStatus());
		
	}

	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		// TODO 合并申请单信息
		EmsRisViewDTO srvdto = (EmsRisViewDTO) uiModel;
		for (Object obj : appSheetList) {
			OrdApObsDO ordris = (OrdApObsDO) obj;
		
			ordris.setId_di(srvdto.getId_di());//临床诊断	
//			ordris.setId_diitm(srvdto.getId_diitm());//临床诊断子项
//			ordris.setStr_id_diitm(srvdto.getStr_id_diitm());//临床诊断明细
//			ordris.setStr_code_di(srvdto.getStr_code_di());//诊断编码拼接
//			ordris.setStr_name_di(srvdto.getStr_name_di());//诊断名称拼接
			ordris.setName_diag(srvdto.getName_di());//诊断名称	
			//ordris.setNo_applyform(srvdto.getNo_applyform());//申请单号	
			ordris.setDt_plan(srvdto.getDt_plan());//计划检查日期
			
			ordris.setClinicalzztz(srvdto.getClinicalzztz());//临床症状及体征
			
			ordris.setFg_urgent(srvdto.getFg_urgent());//加急标识
			
			ordris.setId_pps(srvdto.getId_pps());//检查目的
			ordris.setSd_pps(srvdto.getSd_pps());//检查目的编码
			ordris.setDes_pps(srvdto.getDes_pps());//检查目的描述	

			ordris.setStatus(srvdto.getStatus());
		}
	}

	@Override
	protected void mergeOrderSetInfo(CiEnContextDTO ctx, OrdSrvSetDO[] setSrvList, Object uiModel) throws BizException {
		// TODO 合并套内项目信息
		for (OrdSrvSetDO srvset : setSrvList) {
			srvset.setStatus(DOStatus.DELETED);
		}
	}

	@Override
	protected void mergeOrderMmInfo(CiEnContextDTO ctx, OrdSrvMmDO srvMmInfo, Object uiModel) throws BizException {
		srvMmInfo.setStatus(DOStatus.DELETED);
	}
}

package iih.ci.ord.s.ems.biz.op.tmpl.base.cons.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.ciordems.d.EmsConsItemDO;
import iih.ci.ord.ciordems.d.EmsItemInCons;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSavedRstInfo;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseSaveBP;
import iih.ci.ord.s.ems.biz.op.ems.cons.EmsConsValidate;
import iih.ci.ord.s.ems.biz.op.ems.def.DefaultConsCreateOrderInfo;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class TmplBaseConsSaveBP extends EmsBaseSaveBP {
	public TmplBaseConsSaveBP() {
		super();
		// 设置有效性检查
		setEmsValidate(new EmsConsValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultConsCreateOrderInfo());
	}

	
	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException{
		
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		for (Object uiModel : listUiModel){
			EmsConsItemDO doInfo = (EmsConsItemDO)uiModel;
			som.put(doInfo.getId_srv(), uiModel);
		}
		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(som.asKeyArray(),FBoolean.FALSE);
		assert CiOrdUtils.isEmpty(szMedSrvInfo) : "获取治疗医疗单基础服务数据失败";
		for (MedSrvDO srvInfo : szMedSrvInfo){
			listDefaultCreateParam.add(new DefaultCreateParam(srvInfo,som.get(srvInfo.getId_srv())));
		}
		return listDefaultCreateParam.asArray();
	}
	
//	@Override
//	protected OrderPackageInfo[] handleUpdateOrderInfo(CiEnContextDTO ctx, List<Object> listUiModel)throws BizException {
//		List<OrderPackageInfo> listOrderPakageInfo = new ArrayList<OrderPackageInfo>();
//		// 编辑保存医嘱逻辑
//		for (int index = 0; index < listUiModel.size(); ++index){
//			EmsConsItemDO itemDO = (EmsConsItemDO)listUiModel.get(index);
//			OrderPackageInfo orderPakageInfo = new OrderPackageInfo();
//			CiorderAggDO orderAggInfo = CiOrdAppUtils.getOrAggQryService().findById(itemDO.getId_or());
//			CiOrderDO orderInfo = orderAggInfo.getParentDO();
//			orderPakageInfo.setOrderInfo(orderInfo);
//			// 合并ui数据
//			mergeOrderInfo(ctx,orderInfo,itemDO);
//			OrdSrvMmInfoList orderSrvInfoList = new OrdSrvMmInfoList(orderAggInfo.getOrdSrvDO());
//			for (OrdSrvDO srvInfo : orderSrvInfoList){
//				mergeOrderSrvInfo(ctx,srvInfo,itemDO);
//			}
//			orderPakageInfo.setOrderSrvList(orderSrvInfoList.asArray());
//			// 提取 医嘱对象
//			listOrderPakageInfo.add(orderPakageInfo);
//		}
//		return listOrderPakageInfo.toArray(new OrderPackageInfo[listOrderPakageInfo.size()]);
//	}
	
	
	@Override
	protected OrderSavedRstInfo[] handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		OrderSavedRstInfo[] szInnerOrderSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		
		for (OrderPackageInfo opInfo : szOrderPackageInfo) {

			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList()) ) {
				String id_or = opInfo.getOrderInfo().getId_or();
				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				//ObjectList objAppSheetList = new ObjectList(opInfo.getOrderAppSheetList());
				if (objAppSheetInfo instanceof CiorappconsultAggDO) { // 会诊申请单保存
					CiOrdAppUtils.getOrappconsultService().save(
							opInfo.getOrderAppSheetList().toArray(new CiorappconsultAggDO[opInfo.getOrderAppSheetList().size()]));
				} 
			}
		}
		
		return szInnerOrderSaveInfo;
	}

	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		OrderKey2UiModelMap oiumm = new OrderKey2UiModelMap();
		for (int index = 0; index < listUiModel.size(); ++index) {
			EmsConsItemDO itemDO = (EmsConsItemDO) listUiModel.get(index);
			oiumm.put(itemDO.getId_or(), itemDO);
		}
		return oiumm;
	}


	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		SrvKey2UiModelMap o= new SrvKey2UiModelMap();
		EmsConsItemDO doInfo = (EmsConsItemDO)uiModel;
		
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
	protected void mergeOrderInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, Object uiModel) throws BizException{
		EmsConsItemDO ems=(EmsConsItemDO)uiModel;
		//		
		orderInfo.setContent_or(CiOrContentUtils.create(orderInfo.getSd_srvtp(), ems.getName_srv(), orderInfo.getRoute_name(), FBoolean.FALSE).toString());
		orderInfo.setDays_or(ems.getUse_days());
		orderInfo.setDt_entry(ems.getDt_plan());
		FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(),ems.getDt_plan(),ems.getDt_plan(),ems.getUse_days());
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
		//		orderInfo.setId_reltp(ems.getId_reltp());//???
		//		orderInfo.setSd_reltp(ems.getId_reltp());//???
		//		orderInfo.setId_or_rel(ems.getId_or_rel());//???
		//				orderInfo.setFg_ctlcp(CiOrdUtils.nullHandle(ems.getFg_ctlcp()));//???
		//		orderInfo.setFg_mr(CiOrdUtils.nullHandle(ems.getFg_mr()));//???
		if(FBoolean.TRUE.equals(orderInfo.getFg_mp_in())){
			orderInfo.setTimes_mp_in(ems.getTimes_mp_in());
			if(ems.getTimes_mp_in() != null){
				orderInfo.setTimes_mp_in(ems.getTimes_mp_in());
			}else{
				orderInfo.setTimes_mp_in(ems.getTimes_cur());
				ems.setTimes_mp_in(ems.getTimes_cur());
			}
		}
		orderInfo.setFuncclassstr(ems.getFuncclassstr());
		orderInfo.setId_srvof(ems.getId_srvof());
		orderInfo.setApplyno(ems.getApplyno());
		orderInfo.setDt_last_bl(OrderUtils.getLastDt(orderInfo.getId_freq(), orderInfo.getDt_effe(), 0,orderInfo.getFg_long()));
		orderInfo.setFg_urgent(ems.getFg_urgent());
		orderInfo.setAmount(ems.getPrice());	
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(orderInfo.getId_freq(), ems.getUse_days());
		orderInfo.setTimes_cur(totalTimes);

		orderInfo.setId_orpltp(OrderUtils.getOrCLoopTpId(orderInfo));// 执行闭环

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
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx,OrdSrvDO ordSrvInfo, Object uiModel) throws BizException {
		EmsConsItemDO srvdto=(EmsConsItemDO)uiModel;
		if(ordSrvInfo.getStatus()==DOStatus.DELETED) return;
		//		ordSrvInfo.setSortno(0);
		ordSrvInfo.setDt_create(srvdto.getDt_plan());
		//
		//				ordSrvInfo.setDt_last_cg(getLastDt(ordSrvInfo.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		ordSrvInfo.setDt_last_bl(OrderUtils.getLastDt(ordSrvInfo.getId_freq(),srvdto.getDt_plan(),null,FBoolean.FALSE));//???
		if(CiOrdUtils.isEmpty(srvdto.getPrice())){
			//映射折扣价，如果折扣价为空，则后台再查询折扣价
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), ordSrvInfo.getId_srv(),srvdto.getPrice().toString(),ordSrvInfo);
		}else{
			ordSrvInfo.setPri(srvdto.getPrice());
			ordSrvInfo.setPri_std(srvdto.getPri_std());//???
			ordSrvInfo.setPri_ratio(srvdto.getPri_ratio());//???
			ordSrvInfo.setId_pripat(srvdto.getId_pripat());//???
		}
		ordSrvInfo.setEu_sourcemd(srvdto.getEu_sourcemd());
		ordSrvInfo.setEu_sourcemd(srvdto.getEu_sourcemd()); //添加医疗单来源//???
		ordSrvInfo.setId_srv_src(srvdto.getId_srv_src());
		ordSrvInfo.setId_dep_mp(srvdto.getId_dep_cons()); 
		ordSrvInfo.setId_org_mp(CiOrdUtils.getOrgOfDept(ordSrvInfo.getId_dep_mp()));
		ordSrvInfo.setPriby(srvdto.getPriby());//2016-09-01  新增
	}
	/**
	 * 合并申请单
	 * @param ctx
	 * @param appSheetList
	 * @param extInfoList
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, List<Object> appSheetList,List<Object> extInfoList,Object uiModel)throws BizException{
		EmsConsItemDO srvdto=(EmsConsItemDO)uiModel;
		
		for(Object obj:appSheetList){
			CiorappconsultAggDO aggdo=(CiorappconsultAggDO)obj;
			ordApInfoFrom(srvdto,aggdo.getParentDO(),(MedSrvConsDO)extInfoList.get(0));
			List<CiordInviteConsDO> invitecons=new ArrayList<CiordInviteConsDO>();
			for(Object itemdo:srvdto.getConsAssList()){
				EmsItemInCons consitem=(EmsItemInCons)itemdo;
				invitecons.add(consItemInfoFrom(consitem));
			}
			if(invitecons.size()>0){
				aggdo.setCiordInviteConsDO(invitecons.toArray(new CiordInviteConsDO[invitecons.size()]));
			}
		}
	}
	
	/**
	 * 获取申清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException{
		
		return null;
	}
	
		/**
		 * 会诊申请单映射
		 * @param ems
		 * @return
		 */
		private void ordApInfoFrom(EmsConsItemDO ems,OrdApConsDO consdo,MedSrvConsDO srvcons){
	//		consdo.setId_apcons();
//			consdo.setId_or(ems.getId_or());
			consdo.setNo_applyform(ems.getNo_applyform());
			consdo.setId_constp(ems.getId_constp());
			consdo.setSd_constp(ems.getSd_constp());
			consdo.setDt_ap(ems.getDt_creat());	
			consdo.setTel(ems.getTel());
			consdo.setDes_emr(ems.getDes_emr());
			consdo.setDt_plan(ems.getDt_plan());
			consdo.setPlace(ems.getName_place());	
			consdo.setDes_psp(ems.getDes_psp());
			consdo.setId_su_cons(ems.getId_su_cons());
			consdo.setSd_su_cons(ems.getSd_su_cons());
			consdo.setFg_urgent(ems.getFg_urgent());
			if(FBoolean.TRUE.equals(consdo.getFg_urgent())){
				consdo.setDt_constimelimit(OrderUtils.getConsTimeLimit(srvcons.getId_unit_urg(),srvcons.getQuan_urg_constimelimit(),ems.getDt_creat()));
			}else{
				consdo.setDt_constimelimit(OrderUtils.getConsTimeLimit(srvcons.getId_unit(),srvcons.getQuan_constimelimit(),ems.getDt_creat()));
			}
			consdo.setDes_dep(ems.getDes_dep());
		}
		
		

		/**
		 * 会诊受邀对象映射
		 * @param consitems
		 * @return
		 */
		private CiordInviteConsDO consItemInfoFrom(EmsItemInCons consitem){
				CiordInviteConsDO item=new CiordInviteConsDO();
	//			item.setId_invitecons();
	//			item.setId_apcons();
				item.setId_org(consitem.getId_org());
				item.setId_dep(consitem.getId_dep_emp());
				item.setId_emp(consitem.getId_emp_doctor());	
				item.setSd_emp_title(consitem.getSd_emp_title());	
				item.setId_emp_title(consitem.getId_emp_title());
				item.setStatus(DOStatus.NEW);
	//			item.setFg_response();
	//			item.setDt_response();
	//			item.setId_emp_response();	
	//			item.setFg_join_cons();	
	//			item.setJudgcons();
			return item;
		}
		@Override
		protected int GetSrvObjStatus(Object uiModel) {
			return ((EmsConsItemDO)uiModel).getStatus();
		}
}

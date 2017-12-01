package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.apbu.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.PharmVerifyStatusEnum;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.dto.d.CiordubDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSavedRstInfo;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.ems.apbu.bp.EmsApBuSaveBP;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AuditInfoUtil;



public class TmplApBuSaveBP extends EmsApBuSaveBP {

	public TmplApBuSaveBP(IEmsValidate emsValidate) {
		super(emsValidate);
	}
	
	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException{
		
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		for (Object uiModel : listUiModel){
			CiordubDTO doInfo = (CiordubDTO)uiModel;
			som.put(doInfo.getId_srv(), uiModel);
		}
		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(som.asKeyArray(),FBoolean.FALSE);
		assert CiOrdUtils.isEmpty(szMedSrvInfo) : "获取治疗医疗单基础服务数据失败";
		for (MedSrvDO srvInfo : szMedSrvInfo){
			listDefaultCreateParam.add(new DefaultCreateParam(srvInfo,som.get(srvInfo.getId_srv())));
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
				
				if (objAppSheetInfo instanceof OrdAppBtUseDO) { // 用血申请单保存
					CiOrdAppUtils.getOrappbuService().save(
							opInfo.getOrderAppSheetList().toArray(new OrdAppBtUseDO[opInfo.getOrderAppSheetList().size()]));
				} 
			}
		}
	
		
			return szInnerOrderSaveInfo;
	}
	
	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		OrderKey2UiModelMap oiumm = new OrderKey2UiModelMap();
		for (int index = 0; index < listUiModel.size(); ++index) {
			CiordubDTO itemDO = (CiordubDTO) listUiModel.get(index);
			oiumm.put(itemDO.getId_or(), itemDO);
		}
		return oiumm;
	}


	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		
		
		return super.assembleSrvKey2UiModelMap(uiModel);
	}
	
	/**
	 * 获取生清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException{
		
		// 用血申请单保存
		OrdAppBtUseDO[] szOrdAppBtUseDO = CiOrdAppUtils.getOrappbuQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdAppBtUseDO)){
			return szOrdAppBtUseDO;
		}
		
		return null;
	}
	

	/// <summary>
	/// 获得唯一的用血服务
	/// </summary>
	/// <returns></returns>
	public CiOrderDO getApBtSrv(String id) throws BizException
	{
		ICiorderMDORService service = ServiceFinder.find(ICiorderMDORService.class);
		//查询用血申请单
		CiOrderDO btords = service.findById(id);
		if (btords != null )
		{
			return btords;
		}
		return null;
	}




	/**
	 * 合并医嘱
	 * @param srvInfo
	 * @param ctx
	 * @return
	 * @throws BizException 
	 */
	protected void mergeOrderInfo(CiEnContextDTO ctx,CiOrderDO ordo, Object uiModel) throws BizException{
		CiordubDTO srvInfo = (CiordubDTO)uiModel;
		CiOrderDO btord=getApBtSrv(srvInfo.getId_or_rel());
		ordo.setId_srv(srvInfo.getId_srv());

		ordo.setContent_or(CiOrContentUtils.create(srvInfo.getOrsrvname(),srvInfo.getName_route(),srvInfo.getQuan_medu_ub(),srvInfo.getName_unit()).toString());
		//ordo.setDes_or(srvInfo.getDe);//?? 医嘱备注 ，门诊未使用，未定义
		//ordo.setId_freq(srvInfo.getId_freq());//?? 频次未定义
		//ordo.setSd_frequnitct(ems.getSd_frequnitct());//?? 频次未定义
		//ordo.setFrequnitct(ems.getFrequnitct());//?? 频次未定义
		//ordo.setFreqct(ems.getFreqct());//?? 频次未定义
		//ordo.setFreq_name(ems.getName_freq());//?? 频次未定义
		ordo.setDays_or(srvInfo.getUse_days());
		ordo.setDt_entry(srvInfo.getDt_begin_ui());
		FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(),srvInfo.getDt_begin_ui(),srvInfo.getDt_end_ui(),srvInfo.getUse_days());
		ordo.setDt_effe(dtSE[0]);
		ordo.setDt_end(dtSE[1]);
		ordo.setDt_last_mp(dtSE[0]);
		ordo.setDt_invalid(OrderUtils.getDtInvalid(ctx,srvInfo.getDt_begin_ui()));
		ordo.setFg_chk(CiOrdUtils.nullHandle(null));

		/*
		 * 原则与结论： 开立时 有结束时间，医嘱的停止信息添加 1、未停止核对的有效医嘱，可反复修改停止时间；
		 * 2、停止按钮和医疗单设置停止时间是同等效果；设置DT_END、FG_STOP、停止人、停止操作时间
		 */
		//				if (ems.getFg_long() != null && ems.getFg_long().booleanValue()//?? fg_long未定义
		//					t	&& ems.getDt_end() != null
		//						&& CiOrdUtils.MAX_SYS_DATETIME.after(ems.getDt_end())) {
		//					ordo.setFg_stop(FBoolean.TRUE);
		//					ordo.setId_emp_stop(this.empid);
		//					ordo.setId_dep_stop(this.depid);
		//					ordo.setDt_stop(ordo.getDt_entry());
		//				}

		//				ordo.setFg_pmor(CiOrdUtils.nullHandle(srvInfo.getFg_pmor()));
		//				ordo.setDes_pmor(srvInfo.getDes_pmor());
		//				ordo.setFg_active_pm(CiOrdUtils.nullHandle(srvInfo.getFg_active_pm()));
		if(btord!=null){
			ordo.setId_reltp(btord.getId_srvtp());
			ordo.setSd_reltp(btord.getSd_srvtp());
			ordo.setId_or_rel(srvInfo.getId_or_rel());
		}
		//				ordo.setFg_ctlcp(CiOrdUtils.nullHandle(srvInfo.getFg_ctlcp()));
		//				ordo.setFg_mr(CiOrdUtils.nullHandle(srvInfo.getFg_mr()));

		ordo.setFg_mp_in(FBoolean.TRUE);
		ordo.setFg_pres_outp(FBoolean.FALSE);
		ordo.setTimes_mp_in(srvInfo.getTimes_mp_in());
		//ordo.setFg_mp_bed(CiOrdUtils.nullHandle(srvInfo.getFg_mp_bed()));
		ordo.setApplyno(srvInfo.getApplyno());// 刘羽 使用
		AuditInfoUtil.addData(ordo);// 设置设计信息
		ordo.setDt_last_bl(OrderUtils.getLastDt(ordo.getId_freq(), ordo.getDt_effe(),
				null,ordo.getFg_long()));

		if (CiOrdUtils.isPharmacy(ordo.getSd_srvtp())) {
			ordo.setEu_verify_pharm(PharmVerifyStatusEnum.UNAUDIT);
		} // 2016-07-21 新增
		//ordo.setId_srvca(srvInfo.getId_srvca()); // 2016-07-21 启用该字段//??未定义

		ordo.setFuncclassstr(srvInfo.getFuncclassstr());// 2016-03-25 新增
		ordo.setId_srvof(srvInfo.getId_srvof());// 医疗单主键ID
		ordo.setTimes_cur(srvInfo.getTimes_cur());// 2016-06-29 新增
		ordo.setId_dep_mp(srvInfo.getId_mp_dep());
		//ordo.setFg_urgent(srvInfo.getFg_urgent());//?? 未定义
		ordo.setId_unit_med(srvInfo.getId_unit());// 2016-07-21 新增 以下三个属性（含本条）
		ordo.setQuan_medu(srvInfo.getQuan_medu());
		ordo.setFg_skintest(FBoolean.FALSE);
		ordo.setId_orpltp(OrderUtils.getOrCLoopTpId(ordo));//?? 未定义
		//ordo.setInnercode_srvca(srvInfo.getInnercode_srvca());
		ordo.setFg_feertnable(FBoolean.TRUE); //可退费标识

		//				if (OrSrvSplitUtil.isPlanFreq0(ems.getId_freq())) {// 医嘱频次执行时刻处理
		//					ordFreqExTimeHandle(aggdo, ems.getCiorfreqtimes());
		//				}
		//
		//				if (!CiOrdUtils.isEmpty(ems.getOrapplysheet())) {// 申请单处理逻辑
		//					orAppSheetHandle(ems.getOrapplysheet(), ems.getEmstype(), ht);
		//				}
		//添加字段 医嘱来源
		ordo.setFg_uncancelable(FBoolean.FALSE);//医嘱执行不可逆标识
		//ordo.setEu_uncporjudge(srvInfo.getEu_uncporjudge());//非径内医嘱判断标识枚 未定义
		//ordo.setPurpose_or(srvInfo.getPurpose_or());//医嘱目的//?? 未定义
		ordo.setEu_orsrcmdtp(srvInfo.getEu_orsrcmdtp());
		ordo.setFg_quickwflow(srvInfo.getFg_quickwflow());

		ordo.setBhpjudgerst(ctx.getBhpjudgerst());
		ordo.setDes_bhpjudgerst(ctx.getDes_bhpjudgerst());
		//ordo.setFg_vip(srvInfo.getFg_vip());//vip号 ?? 未定义
		ordo.setStatus(srvInfo.getStatus());
	}

	/**
	 * 合并服务
	 * @param ctx
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException 
	 */
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx,OrdSrvDO srvdo, Object uiModel) throws BizException {
		CiordubDTO srvInfo = (CiordubDTO)uiModel;
		//		srvdo.setId_or(ordo.getId_or());
		srvdo.setId_pat(ctx.getId_pat());
		srvdo.setId_entp(ctx.getId_entp());
		srvdo.setCode_entp(ctx.getCode_entp());
		srvdo.setId_en(ctx.getId_en());
		//srvdo.setSortno(srvdto.getSortno());//?? 未定义  
		//srvdo.setId_srvtp(srvInfo.getId_srvtp());//??未定义
		//srvdo.setSd_srvtp(srvInfo.getSd_srvtp());//?? 未定义  
		srvdo.setId_srv(srvInfo.getId_srv());
		//srvdo.setName(srvInfo.getName_srv());
		//srvdo.setFg_dose_anoma(CiOrdUtils.nullHandle(srvdto.getFg_dose_anoma()));
		srvdo.setQuan_medu(srvInfo.getQuan_medu_ub());
		srvdo.setId_medu(srvInfo.getId_unit());
		//srvdo.setId_freq(srvInfo.getId_freq());//?? 未定义  
		//		srvdo.setId_org_srv(ordo.getId_org_or());
		//		srvdo.setId_dep_srv(ordo.getId_dep_or());
		//		srvdo.setId_wg_or(ordo.getId_wg_or());
		//		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(srvInfo.getDt_begin_ui());
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvInfo.getId_mp_dep()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//		srvdo.setDt_last_bl(OrderUtils.getLastDt(srvdo.getId_freq(), srvInfo.getDt_begin_ui(), null, srvInfo.getFg_long()));
		//srvdo.setFg_or(CiOrdUtils.nullHandle(srvInfo.getFg_or()));//?? 未定义
		//srvdo.setEu_blmd(srvInfo.getEu_blmd());//??未定义
		srvdo.setFg_mm(FBoolean.FALSE);
		//srvdo.setPri(srvInfo.getPrice());//??  未定义
		srvdo.setPri_std(srvInfo.getPri_std());
		srvdo.setPri_ratio(srvInfo.getPri_ratio());
		srvdo.setId_pripat(srvInfo.getId_pripat());
		srvdo.setFg_set(FBoolean.FALSE);
		srvdo.setFg_pres_outp(FBoolean.FALSE);
		//srvdo.setNote_srv(srvdto.getDes_srv());//?? 未定义
		//srvdo.setId_srvca(srvInfo.getId_srvca());//?? 未定义
		//srvdo.setFg_bl(CiOrdUtils.nullHandle(srvInfo.getFg_bl()));
		//srvdo.setCode_srv(srvInfo.getCode_srv());//?? 未定义
		//srvdo.setEu_sourcemd(srvInfo.getEu_sourcemd());
		//srvdo.setEu_blmd(srvInfo.getEu_blmd());//?? 未定义
		//srvdo.setId_primd(srvInfo.getId_primd());//?? 未定义
		//srvdo.setFg_hpindicjudged(srvdto.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
		//srvdo.setSd_reltp(srvdto.getSd_reltp());//2016-03-25 新增  关联类型编码 //??未定义
		//srvdo.setEu_sourcemd(srvdto.getEu_sourcemd()); //添加医疗单来源 //?? 未定义
		// 非住院就诊或出院带药时候，计算服务总量 -- 2016.12.28 by wangqzh
		//srvdo.setQuan_total_medu(srvInfo.getQuan_cur().multiply(obslap.getQuan_medu()));//??缺少计算字段，无法计算
		//srvdo.setFg_selfpay(srvdto.getFg_selfpay());//2016-07-08新增自费标识//?? 未定义
		srvdo.setId_hp(ctx.getId_hp());//2016-07-12新增医保相关信息 //?? 未定义
		//srvdo.setId_hpsrvtp(obslap.getId_hpsrvtp());//?? 未定义
		//srvdo.setSd_hpsrvtp(obslap.getSd_hpsrvtp());//?? 未定义
		//srvdo.setDes_hplimit(obslap.getLimit()); //?? 医保限制条件 未定义
		srvdo.setFg_pres_outp(FBoolean.FALSE);//出院带药标识  zwq 2016-08-11
		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
		srvdo.setId_dep_mp(srvInfo.getId_mp_dep());

		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		//srvdo.setPriby(srvdto.getPriby());//2016-09-01  新增 //?? 未定义
		srvdo.setFg_feertnable(FBoolean.TRUE); //可退费标识
	}
	/**
	 * 合并申请单
	 */
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, List<Object> appSheetList,List<Object> extInfoList,Object uiModel)throws BizException{
		CiordubDTO srvdto=(CiordubDTO)uiModel;
		for(Object obj:appSheetList){
			OrdAppBtUseDO btusedo=(OrdAppBtUseDO)obj;
			ordApBuInfo(srvdto,btusedo);
		}
	}
	
	private void ordApBuInfo(CiordubDTO srvInfo,OrdAppBtUseDO ordbu){
		ordbu.setId_apbu(srvInfo.getId_apbu());
//		ordbu.setId_or(srvInfo.getid);
		ordbu.setDt_bu_plan(srvInfo.getDt_bu_pl_ub());
		ordbu.setNo_applyform(srvInfo.getApplyform());
//		ordbu.setFg_prn(srvInfo);
//		ordbu.setCnt_prn(Cnt_prn);
	}
}

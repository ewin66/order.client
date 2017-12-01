package iih.ci.ord.s.ems.biz.op.tmpl.base.apbt.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.ciordems.d.EmsBtItemDO;
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
import iih.ci.ord.s.ems.biz.op.ems.def.DefaultApBtCreateOrderInfo;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 备血医疗单保存逻辑
 * @author wangqingzhu
 *
 */
public class TmplBaseApBtSaveBP extends EmsBaseSaveBP {



	public TmplBaseApBtSaveBP() {
		
		// 设置有效性检查
		setEmsValidate(null);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultApBtCreateOrderInfo());
	}


	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException{
		
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		for (Object uiModel : listUiModel){
			EmsBtItemDO doInfo = (EmsBtItemDO)uiModel;
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
				
				if (objAppSheetInfo instanceof CiorappbtAggDO) { // 备血申请单保存
					CiOrdAppUtils.getOrappbtService().save(
							opInfo.getOrderAppSheetList().toArray(new CiorappbtAggDO[opInfo.getOrderAppSheetList().size()]));
				} 
			}
		}
		
			return szInnerOrderSaveInfo;
	}
	
	


	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		OrderKey2UiModelMap oiumm = new OrderKey2UiModelMap();
		for (int index = 0; index < listUiModel.size(); ++index) {
			EmsBtItemDO itemDO = (EmsBtItemDO) listUiModel.get(index);
			oiumm.put(itemDO.getId_or(), itemDO);
		}
		return oiumm;
	}


	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		SrvKey2UiModelMap o= new SrvKey2UiModelMap();
		EmsBtItemDO doInfo = (EmsBtItemDO)uiModel;
		
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
	protected void mergeOrderInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, Object uiModel)throws BizException{
		EmsBtItemDO ems=(EmsBtItemDO)uiModel;
		orderInfo.setContent_or(CiOrContentUtils.create(orderInfo.getSd_srvtp(), ems.getName_srv(), orderInfo.getRoute_name(), FBoolean.FALSE).toString());
		orderInfo.setDays_or(ems.getUse_days());
		orderInfo.setDt_entry(ems.getDt_begin_ui());
		FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(),ems.getDt_begin_ui(),ems.getDt_begin_ui(),ems.getUse_days());
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
		//		orderInfo.setFg_urgent(ems.getfg);
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
		EmsBtItemDO srvdto=(EmsBtItemDO)uiModel;
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
		ordSrvInfo.setEu_sourcemd(srvdto.getEu_sourcemd());
		ordSrvInfo.setEu_sourcemd(srvdto.getEu_sourcemd()); //添加医疗单来源//???
		ordSrvInfo.setId_srv_src(srvdto.getId_srv_src());
		ordSrvInfo.setId_dep_mp(srvdto.getId_mp_dep()); 
		ordSrvInfo.setId_org_mp(CiOrdUtils.getOrgOfDept(ordSrvInfo.getId_dep_mp()));
		ordSrvInfo.setPriby(srvdto.getPriby());//2016-09-01  新增
	}
	
	/**
	 * 合并申请单
	 */
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, List<Object> appSheetList,List<Object> extInfoList,Object uiModel)throws BizException{
		EmsBtItemDO srvdto=(EmsBtItemDO)uiModel;
		for(Object obj:appSheetList){
			CiorappbtAggDO aggdo=(CiorappbtAggDO)obj;
			assembleOrderBtInfo(srvdto,aggdo.getParentDO());
			assembleOrderBtObsIndexInfo(aggdo,srvdto);
		}
	}

	private void assembleOrderBtInfo(EmsBtItemDO ems,OrdApBtDO ordbt){
		//		ordbt.setid_apbt();//备血申请
		//		ordbt.setid_or();//医嘱
		ordbt.setId_di(ems.getId_di());//临床诊断
		ordbt.setStr_id_diitm(ems.getStr_id_diitm());//临床诊断明细	
		ordbt.setStr_code_di(ems.getStr_code_di());//诊断编码拼接	
		ordbt.setStr_name_di(ems.getStr_name_di());//诊断名称拼接	
		ordbt.setNo_applyform(ems.getNo_applyform());//输血申请单号	
		ordbt.setPregnant_num(ems.getPregnat_num());//孕几胎
		ordbt.setParturition_cnt(ems.getParturition_cnt());//生产数量	
		ordbt.setId_his_bt(ems.getId_his_bt());//输血史标识	
		ordbt.setSd_his_bt(ems.getSd_his_bt());//输血史标识编码	
		ordbt.setId_pps_bt(ems.getId_pps());//输血目的
		ordbt.setSd_pps_bt(ems.getSd_pps());//输血目的编码	
		//				ordbt.setDes_pps_bt(ems.getd);//输血目的描述	
		ordbt.setFg_db(ems.getFg_db());//献血史标识
		ordbt.setNo_db(ems.getNo_db());//献血证号
		ordbt.setId_labitmexplain(ems.getId_labitmexplain());//输血前监测项目说明	
		ordbt.setSd_labitmexplain(ems.getSd_labitmexplain());//输血前监测项目说明编码	
		ordbt.setId_demandsu_bt(ems.getId_demandsu());//输血需求状态	
		ordbt.setSd_demandsu_bt(ems.getSd_demandsu());//输血需求状态编码
		ordbt.setId_mode_bt(ems.getId_mode());//预定输血方式
		ordbt.setSd_mode_bt(ems.getSd_mode());//预定输血方式编码	
		//				ordbt.setApbtobsindexs();//观察指标集合
		ordbt.setNum_margin_bu(new FDouble(ems.getReal_num().doubleValue()));//可用于血量
		ordbt.setDt_bt_pl(ems.getDt_bt().toString());//计划输血日期	
		ordbt.setSd_su_bt(ICiDictCodeConst.ID_CI_BT_YSQ);//备血申请状态	
		ordbt.setId_su_bt(ICiDictCodeConst.SD_CI_BT_YSQ);//备血申请状态编码	
		//		ordbt.setFg_rpt();//报告标志	
		//		ordbt.setName_diag();//诊断名称
		//		ordbt.setFg_prn();//打印标识	
		//		ordbt.setCnt_prn();//打印次数
		//		ordbt.setId_diitm();//诊断id明细
	}
	private void assembleOrderBtObsIndexInfo(CiorappbtAggDO ordbt,EmsBtItemDO ems){
		FArrayList sugbiewitem=ems.getBtLabItemEx();
		List<OrdApBtViewItemDO> btviewlist=new ArrayList<OrdApBtViewItemDO>();
		for(Object obj:sugbiewitem){
			OrdApSugViewItemDO itemdo=(OrdApSugViewItemDO)obj;
			OrdApBtViewItemDO btietemdo=new OrdApBtViewItemDO();
			btietemdo.setId_srv(itemdo.getId_srv());
			btietemdo.setName_srv(itemdo.getName_srv());
			btietemdo.setVal_rstrptla(itemdo.getVal_rstrptla());
			btietemdo.setId_unit(itemdo.getId_unit());
			btietemdo.setName_unit(itemdo.getName_unit());
			btietemdo.setVal_restrptlab(itemdo.getVal_restrptlab());
			btietemdo.setSd_restrptlabtp(itemdo.getSd_restrptlabtp());
			btietemdo.setId_restrptlabtp(itemdo.getId_restrptlabtp());
			btviewlist.add(btietemdo);
		}
		if(btviewlist.size()>0){
			ordbt.setOrdApBtViewItemDO(btviewlist.toArray(new OrdApBtViewItemDO[btviewlist.size()]));
		}
		
	}
	
	/**
	 * 获取申清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException{
		
		// 备血申请单保存
		CiorappbtAggDO[] szCiorappbtAggDO = CiOrdAppUtils.getOrappbtQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorappbtAggDO)){
			return szCiorappbtAggDO;
		}
		return null;
	}
	
}

package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import iih.ci.ord.ciorder.d.PharmVerifyStatusEnum;
import iih.ci.ord.content.d.CiOrIdentifcationInfo;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.base.fc.GetOrMpCloseLoopTpBP;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;

import java.util.Hashtable;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/**
 * 根据医疗单数据创建医嘱DO信息操作BP
 */
public class CiOrCreateOrd8EmsBP {
	private FDateTime curtime = null;// 当前日期时间
	private String grpid = null; // 集团id
	private String orgid = null; // 组织id
	private String depid = null; // 科室id
	private String empid = null; // 人员id

	/**
	 * 根据医疗单数据创建医嘱DO信息
	 * 
	 * @param aggdo
	 * @param ems
	 * @param ht
	 * @return
	 * @throws BizException
	 */
	public void exec(CiorderAggDO aggdo, CiEmsDTO ems, Hashtable ht)
			throws BizException {
		if (ems == null)
			return;
		setCommonData();
		if (CiOrdUtils.isDONew(aggdo.getParentDO())) {// 新增处理
			createOrderDOInfo(aggdo, ems, ht);
		} else {// 值修改处理
			setOrderDOInfo(aggdo, ems, ht);
		}

	}

	private String SetNameOR(CiEmsDTO ems) {
		String name_or = "";
		if (ems != null && ems.getEmssrvs() != null
				&& ems.getEmssrvs().size() > 0) {
			if (ems.getSd_srvtp().equals(
					IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)
					|| ems.getSd_srvtp().equals(
							IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY)) {
				FArrayList list = ems.getEmssrvs();
				for (int i = 0; i < list.size(); i++) {
					CiEmsSrvDTO srv = (CiEmsSrvDTO) list.get(i);
					name_or += "," + srv.getName_srv();
				}
			} else if (ems.getSd_srvtp().equals(
					IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				name_or = ",草药";
			} else {
				CiEmsSrvDTO srvdto = (CiEmsSrvDTO) ems.getEmssrvs().get(0);
				name_or = "," + srvdto.getName_srv();
			}
		}
		if (name_or != "") {
			return name_or.substring(1);
		}
		return name_or;
	}

	/**
	 * 创建医嘱DO数据信息
	 * 
	 * @param aggdo
	 * @param ems
	 * @param ht
	 * @throws BizException
	 */
	private void createOrderDOInfo(CiorderAggDO aggdo, CiEmsDTO ems,
			Hashtable ht) throws BizException {
		CiOrIdentifcationInfo oridrelinfo = getOrIdRelInfo(ems);
		CiEmsSrvDTO srvdto = (CiEmsSrvDTO) ems.getEmssrvs().get(0);
		CiOrderDO ordo = new CiOrderDO();
		// ordo.setId_or(ems.getId_or());
		ordo.setId_grp(this.grpid);
		ordo.setId_org(this.orgid);
		ordo.setId_pat(ems.getId_pat());
		ordo.setId_en(ems.getId_en());
		ordo.setId_entp(ems.getId_entp());
		ordo.setCode_entp(ems.getCode_entp());
		ordo.setId_srvtp(oridrelinfo.getId_srvtp());
		ordo.setSd_srvtp(oridrelinfo.getSd_srvtp());
		ordo.setId_srv(ems.getId_srv());
		ordo.setFg_set(ems.getFg_set());// 刘晓颖 15—12—18
		// if(ems.getId_srv() != null){
		// ordo.setFg_set(FBoolean.TRUE);
		// }else{ordo.setFg_set(FBoolean.FALSE);}

		ordo.setId_srv_pkg(ems.getId_srv_pkg());
		ordo.setFg_long(CiOrdUtils.nullHandle(ems.getFg_long()));
		ordo.setCode_or(oridrelinfo.getCode());
		// ordo.setName_or(oridrelinfo.getName());
		ordo.setName_or(SetNameOR(ems)); //
		ordo.setContent_or(oridrelinfo.getContent());
		ordo.setDes_or(ems.getNote());
		ordo.setId_freq(ems.getId_freq());
		//zwq 2016-09-06
		ordo.setSd_frequnitct(ems.getSd_frequnitct());
		ordo.setFrequnitct(ems.getFrequnitct());
		ordo.setFreqct(ems.getFreqct());
		ordo.setFreq_name(ems.getName_freq());
		ordo.setOrders(ems.getOrders());
		ordo.setFg_boil(CiOrdUtils.nullHandle(ems.getFg_boil()));
		ordo.setOrders_boil(ems.getOrders_boil());
		ordo.setId_route(ems.getId_route());
		ordo.setId_routedes(ems.getId_routedes());
		ordo.setId_boil(ems.getId_boil());
		ordo.setId_boildes(ems.getId_boildes());
		ordo.setDays_or(ems.getDays_or());
		ordo.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
		ordo.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
		ordo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ordo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ordo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		ordo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		ordo.setId_org_or(this.orgid);
		ordo.setId_dep_or(this.depid);
		ordo.setId_wg_or(ems.getId_wg_or());
		ordo.setId_emp_or(this.empid);
		ordo.setDt_entry(curtime);
		setSignInfo(ordo); // 设置签署信息
		FDateTime[] dtSE = getDtBeginEnd(ems);
		ordo.setDt_effe(dtSE[0]);
		ordo.setDt_end(dtSE[1]);
		// 0104801: 门诊医嘱，dt_end>dt_effe的医嘱，fg_long标识必须为Y -- 徐星要求
		// {{
		if (ordo.getDt_end().compareTo(ordo.getDt_effe()) > 0 && CiOrdUtils.isOpUrgentWf(ems.getCode_entp())){
			ordo.setFg_long(FBoolean.TRUE);
		}
		// }}
        ordo.setDt_last_mp(dtSE[0]);
		/*
		 * if(ems.getDt_end() !=null){ //lizheng 修改
		 * ordo.setDt_end(ems.getDt_end()); }else{ ordo.setDt_end(dtSE[1]); }
		 */

		ordo.setDt_invalid(getDtInvalid(ems));
		ordo.setFg_chk(CiOrdUtils.nullHandle(null));
		// ordo.setId_emp_chk(ems.getId_emp_chk());
		// ordo.setId_dep_chk(ems.getId_dep_chk());
		// ordo.setDt_chk(ems.getDt_chk());
		/*
		 * 原则与结论： 开立时 有结束时间，医嘱的停止信息添加 1、未停止核对的有效医嘱，可反复修改停止时间；
		 * 2、停止按钮和医疗单设置停止时间是同等效果；设置DT_END、FG_STOP、停止人、停止操作时间
		 */
		if (ems.getFg_long() != null && ems.getFg_long().booleanValue()
				&& ems.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(ems.getDt_end())) {
			ordo.setFg_stop(FBoolean.TRUE);
			ordo.setId_emp_stop(this.empid);
			ordo.setId_dep_stop(this.depid);
			ordo.setDt_stop(ordo.getDt_entry());
		}
		// ordo.setFg_stop(CiOrdUtils.nullHandle(null));
		// ordo.setId_emp_stop(ems.getId_emp_stop());
		// ordo.setId_dep_stop(ems.getId_dep_stop());
		// ordo.setDt_stop(ems.getDt_stop());
		ordo.setFg_chk_stop(CiOrdUtils.nullHandle(null));
		// ordo.setId_emp_chk_stop(ems.getId_emp_chk_stop());
		// ordo.setId_dep_chk_stop(ems.getId_dep_chk_stop());
		// ordo.setDt_chk_stop(ems.getDt_chk_stop());
		ordo.setFg_canc(CiOrdUtils.nullHandle(null));
		// ordo.setId_emp_canc(ems.getId_emp_canc());
		// ordo.setId_dep_canc(ems.getId_dep_canc());
		// ordo.setDt_canc(ems.getDt_canc());
		ordo.setFg_chk_canc(CiOrdUtils.nullHandle(null));
		// ordo.setId_emp_chk_canc(ems.getId_emp_chk_canc());
		// ordo.setId_dep_chk_canc(ems.getId_dep_chk_canc());
		// ordo.setDt_chk_canc(ems.getDt_chk_canc());
		ordo.setFg_pmor(CiOrdUtils.nullHandle(ems.getFg_pmor()));
		ordo.setDes_pmor(ems.getDes_pmor());
		ordo.setFg_active_pm(CiOrdUtils.nullHandle(ems.getFg_active_pm()));
		ordo.setId_reltp(ems.getId_reltp());
		ordo.setSd_reltp(ems.getSd_reltp());
		ordo.setId_or_rel(ems.getId_or_rel());
		ordo.setFg_bb(CiOrdUtils.nullHandle(ems.getFg_bb()));
		ordo.setNo_bb(ems.getNo_bb());
		ordo.setFg_ctlcp(CiOrdUtils.nullHandle(ems.getFg_ctlcp()));
		ordo.setFg_mr(CiOrdUtils.nullHandle(ems.getFg_mr()));
		ordo.setFg_mp_in(CiOrdUtils.JudgeFgMpIn(ems));
		ordo.setFg_pres_outp(CiOrdUtils.nullHandle(ems.getFg_pres_outp()));// 2016-03-25// 新增
		// 是否出院带药标识
//		if(ordo.getFg_pres_outp().booleanValue()){
//			 ordo.setFg_mp_in(FBoolean.FALSE);
//		}
		if(ordo.getFg_mp_in().booleanValue()){
			ordo.setTimes_mp_in(ems.getTimes_mp_in());
			if(ems.getTimes_mp_in() != null){
				ordo.setTimes_mp_in(ems.getTimes_mp_in());
			}else{
				ordo.setTimes_mp_in(ems.getTimes_cur());
				ems.setTimes_mp_in(ems.getTimes_cur());
			}
		}
		ordo.setFg_mp_bed(CiOrdUtils.nullHandle(ems.getFg_mp_bed()));
		ordo.setNote_or(ems.getNote());
		ordo.setQuan_firday_mp(ems.getTimes_firday_mp());
		ordo.setApplyno(ems.getApplyno());// 刘羽 使用
		AuditInfoUtil.addData(ordo);// 设置设计信息
		ordo.setDt_last_bl(getLastDt(srvdto.getId_freq(), ordo.getDt_effe(),
				ems.getTimes_firday_mp(),ordo.getFg_long()));

		if (CiOrdUtils.isPharmacy(ems.getSd_srvtp())) {
			ordo.setEu_verify_pharm(PharmVerifyStatusEnum.UNAUDIT);
		} // 2016-07-21 新增
		// ordo.setDes_verify_pharm(ems.getDes_verify_pharm());
		// ordo.setId_ecep_level_pharm(ems.getId_ecep_level_pharm());
		// ordo.setSd_excep_level_pharm(ems.getSd_excep_level_pharm());
		// ordo.setDes_verify_sys(ems.getDes_verify_sys());
		// ordo.setId_ecep_level_sys(ems.getId_ecep_level_sys());
		// ordo.setSd_excep_level_sys(ems.getSd_excep_level_sys());
		// ordo.setId_emp_verify_pharm(ems.getId_emp_verify_pharm());
		// ordo.setDt_verify_pharm(ems.getDt_verify_pharm());
		// ordo.setDes_bk_pharm(ems.getDes_bk_pharm());
		// ordo.setDt_bk_pharm(ems.getDt_bk_pharm());
		// ordo.setId_emp_bk_pharm(ems.getId_emp_bk_pharm());
		// ordo.setStr_long(ems.getStr_long()); //废弃不用的字段
		ordo.setId_srvca(ems.getId_srvca()); // 2016-07-21 启用该字段
		
		ordo.setFuncclassstr(ems.getFuncclassstr());// 2016-03-25 新增
		ordo.setId_srvof(ems.getId_srvof());// 医疗单主键ID
		ordo.setTimes_cur(ems.getTimes_cur());// 2016-06-29 新增
		if(ems.getId_dep_mp()==null){//2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
			ExeWhDeptDTO exeandwhdeptinfo=getMpDeptID(ordo,ems);  //待打开
			ordo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开
			ems.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());//  为服务使用
		}else{
			ordo.setId_dep_mp(ems.getId_dep_mp());
		}
		ems.setId_dep_mp(ordo.getId_dep_mp());//2016-10-27 新增逻辑 主要是为传递执行科室用 应该不会引起大的变化
		ordo.setFg_urgent(ems.getFg_urgent());// 医嘱的加急标志2016-06-30张万青
		ordo.setId_unit_med(ems.getId_unit_med());// 2016-07-21 新增 以下三个属性（含本条）
		ordo.setQuan_medu(ems.getQuan_medu());
		ordo.setFg_skintest(CiOrdUtils.nullHandle(ems.getFg_skintest()));
		ordo.setId_orpltp(getOrCLoopTpId(ordo));
        ordo.setInnercode_srvca(ems.getInnercode_srvca());
        ordo.setFg_feertnable(FBoolean.TRUE); //可退费标识
       
		if (OrSrvSplitUtil.isPlanFreq0(ems.getId_freq())) {// 医嘱频次执行时刻处理
			ordFreqExTimeHandle(aggdo, ems.getCiorfreqtimes());
		}

		if (!CiOrdUtils.isEmpty(ems.getOrapplysheet())) {// 申请单处理逻辑
			orAppSheetHandle(ems.getOrapplysheet(), ems.getEmstype(), ht);
		}
		//添加字段 医嘱来源
		ordo.setFg_uncancelable(FBoolean.FALSE);//医嘱执行不可逆标识
		ordo.setEu_uncporjudge(ems.getEu_uncporjudge());//非径内医嘱判断标识枚
		ordo.setPurpose_or(ems.getPurpose_or());//医嘱目的
		ordo.setEu_orsrcmdtp(ems.getEu_orsrcmdtp());
		ordo.setId_orsrc_main(ems.getId_orsrc_main());
		ordo.setId_orsrc_sub(ems.getId_orsrc_sub());
		ordo.setId_orsrc_subsub(ems.getId_orsrc_subsub());
		ordo.setFg_quickwflow(ems.getFg_quickwflow());
		
		ordo.setBhpjudgerst(ems.getBhpjudgerst());
		ordo.setDes_bhpjudgerst(ems.getDes_bhpjudgerst());
		ordo.setFg_vip(ems.getFg_vip());//vip号
		ordo.setStatus(DOStatus.NEW);
		aggdo.setParentDO(ordo);
	}

	/**
	 * 医嘱申请单处理逻辑（新建）
	 * 
	 * @param appsheet
	 * @param iemstp
	 * @param ht
	 */
	private void orAppSheetHandle(FMap appsheet, int iemstp, Hashtable ht) {
		Object[] os = appsheet.values().toArray();
		if (os == null || os.length == 0)
			return;
		CiOrAttachInfoUtils.addOrAppDatumObj(ht, iemstp, appsheet.values()
				.toArray()[0]);
	}

	/**
	 * 设置医嘱DO数据信息
	 * 
	 * @param aggdo
	 * @param ems
	 * @param ht
	 * @throws BizException
	 */
	private void setOrderDOInfo(CiorderAggDO aggdo, CiEmsDTO ems, Hashtable ht)
			throws BizException {
		CiOrderDO ordo = aggdo.getParentDO();
		CiOrIdentifcationInfo oridrelinfo = getOrIdRelInfo(ems);
		CiEmsSrvDTO srvdto = (CiEmsSrvDTO) ems.getEmssrvs().get(0);
		// ordo.setId_or(ems.getId_or());
		// ordo.setId_grp(this.grpid);
		// ordo.setId_org(this.orgid);
		// ordo.setId_pat(ems.getId_pat());
		// ordo.setId_en(ems.getId_en());
		// ordo.setId_entp(ems.getId_entp());
		// ordo.setCode_entp(ems.getCode_entp());
		ordo.setEu_hpindicjudge(ems.getEu_hpindicjudge());
		ordo.setId_srvtp(oridrelinfo.getId_srvtp());
		ordo.setSd_srvtp(oridrelinfo.getSd_srvtp());
		ordo.setId_emp_or(this.empid);
		ordo.setId_srv(ems.getId_srv());
		ordo.setFg_set(ems.getFg_set());// 刘晓颖 15—12—18
		// if(ems.getId_srv() != null){
		// ordo.setFg_set(FBoolean.TRUE);
		// }else{ordo.setFg_set(FBoolean.FALSE);}
		ordo.setId_srv_pkg(ems.getId_srv_pkg());
		ordo.setFg_long(CiOrdUtils.nullHandle(ems.getFg_long()));
		if(ordo.getCode_or() != null){
			ordo.setCode_or(ordo.getCode_or());
		}else{
			ordo.setCode_or(oridrelinfo.getCode());
		}
		
		ordo.setName_or(oridrelinfo.getName());
		ordo.setContent_or(oridrelinfo.getContent());
		ordo.setDes_or(ems.getNote());
		ordo.setId_freq(ems.getId_freq());
		//zwq 2016-09-06
		ordo.setSd_frequnitct(ems.getSd_frequnitct());
		ordo.setFrequnitct(ems.getFrequnitct());
		ordo.setFreqct(ems.getFreqct());
		
		ordo.setOrders(ems.getOrders());
		ordo.setFg_boil(CiOrdUtils.nullHandle(ems.getFg_boil()));
		ordo.setOrders_boil(ems.getOrders_boil());
		ordo.setId_route(ems.getId_route());
		ordo.setId_routedes(ems.getId_routedes());
		ordo.setId_boil(ems.getId_boil());
		ordo.setId_boildes(ems.getId_boildes());
		ordo.setDays_or(ems.getDays_or());
		// ordo.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
		// ordo.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
		// ordo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		// ordo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		// ordo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		// ordo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		// ordo.setId_org_or(this.orgid);
		// ordo.setId_dep_or(this.depid);
		// ordo.setId_wg_or(ems.getId_wg_or());
		// ordo.setId_emp_or(this.empid);
		// ordo.setDt_entry(curtime);
		// setSignInfo(ordo); //设置签署信息
		FDateTime[] dtSE = getDtBeginEnd(ems);
		ordo.setDt_effe(dtSE[0]);
		ordo.setDt_end(dtSE[1]);
		ordo.setDt_invalid(getDtInvalid(ems));
		ordo.setFg_chk(CiOrdUtils.nullHandle(null));
		ordo.setDt_last_bl(getLastDt(srvdto.getId_freq(), ordo.getDt_effe(),
				ems.getTimes_firday_mp(),ordo.getFg_long()));
		// ordo.setId_emp_chk(ems.getId_emp_chk());
		// ordo.setId_dep_chk(ems.getId_dep_chk());
		// ordo.setDt_chk(ems.getDt_chk());
		// ordo.setFg_stop(CiOrdUtils.nullHandle(null)); //2016-06-30注释掉
		// 相关处理逻辑参见下述
		// ordo.setId_emp_stop(ems.getId_emp_stop());
		// ordo.setId_dep_stop(ems.getId_dep_stop());
		// ordo.setDt_stop(ems.getDt_stop());
		ordo.setFg_chk_stop(CiOrdUtils.nullHandle(null));
		// ordo.setId_emp_chk_stop(ems.getId_emp_chk_stop());
		// ordo.setId_dep_chk_stop(ems.getId_dep_chk_stop());
		// ordo.setDt_chk_stop(ems.getDt_chk_stop());
		ordo.setFg_canc(CiOrdUtils.nullHandle(null));
		// ordo.setId_emp_canc(ems.getId_emp_canc());
		// ordo.setId_dep_canc(ems.getId_dep_canc());
		// ordo.setDt_canc(ems.getDt_canc());
		ordo.setFg_chk_canc(CiOrdUtils.nullHandle(null));
		// ordo.setId_emp_chk_canc(ems.getId_emp_chk_canc());
		// ordo.setId_dep_chk_canc(ems.getId_dep_chk_canc());
		// ordo.setDt_chk_canc(ems.getDt_chk_canc());
		ordo.setFg_pmor(CiOrdUtils.nullHandle(ems.getFg_pmor()));
		ordo.setDes_pmor(ems.getDes_pmor());
		ordo.setFg_active_pm(CiOrdUtils.nullHandle(ems.getFg_active_pm()));
		ordo.setId_reltp(ems.getId_reltp());
		ordo.setSd_reltp(ems.getSd_reltp());
		ordo.setId_or_rel(ems.getId_or_rel());
		ordo.setFg_bb(CiOrdUtils.nullHandle(ems.getFg_bb()));
		ordo.setNo_bb(ems.getNo_bb());
		ordo.setFg_ctlcp(CiOrdUtils.nullHandle(ems.getFg_ctlcp()));
		ordo.setFg_mr(CiOrdUtils.nullHandle(ems.getFg_mr()));
		ordo.setFg_skintest(CiOrdUtils.nullHandle(ems.getFg_skintest()));
		ordo.setFg_mp_in(CiOrdUtils.nullHandle(ems.getFg_mp_in()));
		if(ordo.getFg_mp_in().booleanValue()){
			ordo.setTimes_mp_in(ems.getTimes_mp_in());
			if(ems.getTimes_mp_in() != null && !"".equals(ems.getTimes_mp_in())){
				ordo.setTimes_mp_in(ems.getTimes_mp_in());
			}else{
				ordo.setTimes_mp_in(ems.getTimes_cur());
				ems.setTimes_mp_in(ems.getTimes_cur());
			}
		}
//		if(ems.getTimes_cur() !=  null){
			ordo.setTimes_cur(ems.getTimes_cur());// 2016-06-29 新增
//		}else{
//			ordo.setTimes_cur(ems.getTimes_mp_in());// 2016-06-29 新增
//		}
		
		ordo.setFg_mp_bed(CiOrdUtils.nullHandle(ems.getFg_mp_bed()));
		ordo.setNote_or(ems.getNote());
		ordo.setQuan_firday_mp(ems.getTimes_firday_mp());
		AuditInfoUtil.updateData(ordo);// 修改审计信息
		// ordo.setEu_verify_pharm(ems.getEu_verify_pharm());
		// ordo.setDes_verify_pharm(ems.getDes_verify_pharm());
		// ordo.setId_ecep_level_pharm(ems.getId_ecep_level_pharm());
		// ordo.setSd_excep_level_pharm(ems.getSd_excep_level_pharm());
		// ordo.setDes_verify_sys(ems.getDes_verify_sys());
		// ordo.setId_ecep_level_sys(ems.getId_ecep_level_sys());
		// ordo.setSd_excep_level_sys(ems.getSd_excep_level_sys());
		// ordo.setId_emp_verify_pharm(ems.getId_emp_verify_pharm());
		// ordo.setDt_verify_pharm(ems.getDt_verify_pharm());
		// ordo.setDes_bk_pharm(ems.getDes_bk_pharm());
		// ordo.setDt_bk_pharm(ems.getDt_bk_pharm());
		// ordo.setId_emp_bk_pharm(ems.getId_emp_bk_pharm());
		// ordo.setStr_long(ems.getStr_long()); //废弃不用的字段
		ordo.setId_srvca(ems.getId_srvca()); // 2016-07-21 启用该字段
		if (ems.getFg_long() != null && ems.getFg_long().booleanValue()
				&& ems.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(ems.getDt_end())) {// 2016-06-30
																	// 新增该处理逻辑
			ordo.setFg_stop(FBoolean.TRUE);
			ordo.setId_emp_stop(this.empid);
			ordo.setId_dep_stop(this.depid);
			ordo.setDt_stop(this.curtime);
		} else {
			ordo.setFg_stop(FBoolean.FALSE);
			ordo.setId_emp_stop(null);
			ordo.setId_dep_stop(null);
			ordo.setDt_stop(null);
		}

		ordo.setApplyno(ems.getApplyno());
		ordo.setFg_pres_outp(CiOrdUtils.nullHandle(ems.getFg_pres_outp()));// 2016-03-25
																			// 新增
																			// 是否出院带药标识
		ordo.setFuncclassstr(ems.getFuncclassstr());// 2016-03-25 新增
		ordo.setId_srvof(ems.getId_srvof());
		
		ordo.setId_dep_mp(ems.getId_dep_mp());
		ordo.setFg_urgent(ems.getFg_urgent());// 医嘱的加急标志2016-06-30张万青
		ordo.setId_unit_med(ems.getId_unit_med());// 2016-07-21 新增 以下三个属性（含本条）
		ordo.setQuan_medu(ems.getQuan_medu());
		ordo.setId_orpltp(getOrCLoopTpId(ordo));

		if (OrSrvSplitUtil.isPlanFreq0(ems.getId_freq())) {// 医嘱频次执行时刻处理
			ordFreqExTimeHandle4Mod(aggdo, ems.getCiorfreqtimes());
		}

		if (!CiOrdUtils.isEmpty(ems.getOrapplysheet())) {// 申请单处理逻辑
			orAppSheetModHandle(ems.getOrapplysheet(), ems.getEmstype(), ht);
		}
		//添加医嘱来源字段
		ordo.setEu_orsrcmdtp(ems.getEu_orsrcmdtp());
		ordo.setId_orsrc_main(ems.getId_orsrc_main());
		ordo.setId_orsrc_sub(ems.getId_orsrc_sub());
		ordo.setId_orsrc_subsub(ems.getId_orsrc_subsub());
		ordo.setFg_quickwflow(ems.getFg_quickwflow());
		ordo.setFg_vip(ems.getFg_vip());//vip号
		ordo.setStatus(DOStatus.UPDATED);
	}

	private String getApplyno(CiEmsDTO ems) {
		String applyno = "";
		if (ems != null) {
			// 申请单数据保存
			/*
			 * if(EmsType.LIS.equals(iemstp)){ ave((OrdApLabDO)orappmap,id_or);;
			 * }else if(EmsType.RIS.equals(iemstp)){
			 * OrapprisSave((OrdApObsDO)orappmap,id_or); }else
			 * if(EmsType.OPER.equals(iemstp)){
			 * OrappoptSave((CiorappsurgeryAggDO)orappmap,id_or); }else
			 * if(EmsType.PATHGY.equals(iemstp)){
			 * OrapppathgySave((CiorapppathgyAggDO)orappmap,id_or); }else
			 * if(EmsType.BT.equals(iemstp)){
			 * OrappbtSave((CiorappbtAggDO)orappmap,id_or); }else
			 * if(EmsType.CONS.equals(iemstp)){
			 * OrappconsultSave((CiorappconsultAggDO)orappmap,id_or); }else
			 * if(EmsType.BTUSE.equals(iemstp)){
			 * OrappbuSave((OrdAppBtUseDO)orappmap,id_or); }else
			 * if(EmsType.TRANSDEPT.equals(iemstp)){
			 * OrapptransdepSave((OrdApTransDO)orappmap,id_or); }else
			 * if(EmsType.OUTHOSP.equals(iemstp)){
			 * OrappoutSave((OrdApOutDO)orappmap,id_or); }
			 */
		}

		return applyno;
	}

	/**
	 * 医嘱申请单处理逻辑（新建）
	 * 
	 * @param appsheet
	 * @param iemstp
	 * @param ht
	 */
	private void orAppSheetModHandle(FMap appsheet, int iemstp, Hashtable ht) {
		Object[] os = appsheet.values().toArray();
		if (os == null || os.length == 0)
			return;
		CiOrAttachInfoUtils.addOrAppDatumObj(ht, iemstp, appsheet.values()
				.toArray()[0]);
	}

	/**
	 * 获得医嘱内容
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private CiOrIdentifcationInfo getOrIdRelInfo(CiEmsDTO ems)
			throws BizException {
		GetOrContentRelInfoBP bp = new GetOrContentRelInfoBP();
		return bp.exec(ems);
	}

	/**
	 * 设置签署相关信息
	 * 
	 * @param ordo
	 */
	private void setSignInfo(CiOrderDO ordo) {
		if (1 != 1) {// CiOrdUtils.isOpUrgentWf(ordo.getCode_entp())){
			ordo.setFg_sign(FBoolean.TRUE);
			ordo.setId_emp_sign(this.empid);
			ordo.setId_dep_sign(this.depid);
			ordo.setDt_sign(curtime);
		} else {
			ordo.setFg_sign(CiOrdUtils.nullHandle(null));
			// ordo.setId_emp_sign(ems.getId_emp_sign());
			// ordo.setId_dep_sign(ems.getId_dep_sign());
			// ordo.setDt_sign(ems.getDt_sign());
		}
	}

	/**
	 * 获得过期时间
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private FDateTime getDtInvalid(CiEmsDTO ems) throws BizException {
		CiOrInvalidDtHandleBP bp = new CiOrInvalidDtHandleBP();
		return bp.exec(ems);
	}

	/**
	 * 获得开始结束时间
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private FDateTime[] getDtBeginEnd(CiEmsDTO ems) throws BizException {
		CiOrEndDtHandleBP bp = new CiOrEndDtHandleBP();
		return bp.exec(ems);
	}

	/**
	 * 医嘱频次执行时刻相关处理
	 * 
	 * @param aggdo
	 * @param orfreqextimes
	 * @throws BizException
	 */
	private void ordFreqExTimeHandle(CiorderAggDO aggdo,
			FArrayList orfreqextimes) throws BizException {
		// CiOrFreqTimeDTO
		if (orfreqextimes == null || orfreqextimes.size() == 0)
			return;

		CiOrFreqTimeDtO2DOBP bp = new CiOrFreqTimeDtO2DOBP();
		OrdFreqTimeDO[] dos = bp.exec(orfreqextimes);

		if (!(dos == null || dos.length == 0)) {
			aggdo.setOrdFreqTimeDO(dos);
		}
	}

	/**
	 * 医嘱频次执行时刻相关处理（修改信息情况）
	 * 
	 * @param aggdo
	 * @param orfreqextimes
	 * @throws BizException
	 */
	private void ordFreqExTimeHandle4Mod(CiorderAggDO aggdo,
			FArrayList orfreqextimes) throws BizException {
		OrdFreqTimeDO[] orfreqtimedos = aggdo.getOrdFreqTimeDO();
		if (CiOrdUtils.isEmpty(orfreqextimes)
				&& CiOrdUtils.isEmpty(orfreqtimedos))
			return;

		if (CiOrdUtils.isEmpty(orfreqtimedos)) {// 纯新增数据处理
			CiOrFreqTimeDtO2DOBP bp = new CiOrFreqTimeDtO2DOBP();
			OrdFreqTimeDO[] dos = bp.exec(orfreqextimes);
			if (!(dos == null || dos.length == 0)) {
				aggdo.setOrdFreqTimeDO(dos);
			}
		} else if (CiOrdUtils.isEmpty(orfreqextimes)) { // 原有数据删除处理 这种情况应该不存在
			CiOrdUtils.setDelStatus(orfreqtimedos);
		} else {// 混合情况处理
			CiOrFreqTimeDtOModDOBP bp = new CiOrFreqTimeDtOModDOBP();
			bp.exec(aggdo, orfreqextimes);
		}

	}

	/**
	 * 设置公共数据信息
	 * 
	 * @throws BizException
	 */
	private void setCommonData() throws BizException {
		curtime = CiOrdAppUtils.getServerDateTime();
		grpid = CiOrdAppUtils.getEnvContext().getGroupId(); // 集团id
		orgid = CiOrdAppUtils.getEnvContext().getOrgId(); // 组织id
		depid = CiOrdAppUtils.getEnvContext().getDeptId(); // 科室id
		empid = CiOrdAppUtils.getEnvContext().getUserId(); // 人员id
		empid = CiOrdUtils.getPsnDocID(empid);
	}

	/**
	 * 获得最近医嘱生成日期
	 * 
	 * @param id_freq
	 * @param dt_effe
	 * @param firstdaytimes
	 * @return
	 * @throws BizException
	 */
	private FDateTime getLastDt(String id_freq, FDateTime dt_effe,
			Integer firstdaytimes,FBoolean fg_long) throws BizException {
		CiOrDtLastBlCal4OpenBP bp = new CiOrDtLastBlCal4OpenBP();
		return bp.exec(id_freq, dt_effe, firstdaytimes,fg_long);
	}

	/**
	 * 获得医嘱闭环类型id
	 * 
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	public String getOrCLoopTpId(CiOrderDO ordo) throws BizException {
		try {
			GetOrMpCloseLoopTpBP bp = new GetOrMpCloseLoopTpBP();
			OrpltpDO[] cltpids = bp.exec(ordo);
			if (CiOrdUtils.isEmpty(cltpids))
				return null;
			return cltpids[0].getId_orpltp();
		} catch (Exception e) {
			Logger.error(e);
		}
		return null;
	}
	/**
	 * 获得执行科室数据信息
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 * @throws BizException
	 */
	private ExeWhDeptDTO getMpDeptID(CiOrderDO ordo,CiEmsDTO ems) throws BizException{
		ExeDeptCalParamDTO param=getExeDeptCalParamDTO(ordo,ems);
		return CiOrdUtils.getMpDeptID(param);
	}
	
	/**
	 * 获得执行科室计算参数信息DTO
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 */
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiOrderDO ordo,CiEmsDTO ems){
		ExeDeptCalParamDTO paramdto=new ExeDeptCalParamDTO();
		paramdto.setCode_entp(ems.getCode_entp());
		paramdto.setId_dep_en(ems.getId_dept_en());
		paramdto.setId_dep_or(ems.getId_dep_phy());
		paramdto.setId_dep_ns(ems.getId_dept_ns());
		paramdto.setFg_long(ems.getFg_long());
		paramdto.setId_srv(ems.getId_srv());
		//paramdto.setId_mm();
		paramdto.setSd_srvtp(ems.getSd_srvtp());
		paramdto.setId_srvca(ems.getId_srvca());
		paramdto.setInnercode_srvca(ems.getInnercode_srvca());
		paramdto.setId_route(ems.getId_route());
		paramdto.setDt_effe(ordo.getDt_effe());
		paramdto.setId_dep_exe(ems.getId_dep_mp());// 10-27 服务的执行科室
		//paramdto.setDef1();
		//paramdto.setDef2();
		//paramdto.setDef3();
		//paramdto.setDef4();
		//paramdto.setDef5();
		paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW);  //只求执行科室
		
		return paramdto;
	}
}

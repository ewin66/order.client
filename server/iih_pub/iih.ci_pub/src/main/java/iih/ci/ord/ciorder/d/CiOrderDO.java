package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import java.math.BigDecimal;

/**
 * 临床医嘱 DO数据 
 * 
 */
public class CiOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OR= "Id_or";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_EN= "Id_en";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRV= "Id_srv";
	public static final String FG_SET= "Fg_set";
	public static final String ID_SRV_PKG= "Id_srv_pkg";
	public static final String FG_LONG= "Fg_long";
	public static final String CODE_OR= "Code_or";
	public static final String CONTENT_OR= "Content_or";
	public static final String DES_OR= "Des_or";
	public static final String ID_FREQ= "Id_freq";
	public static final String ORDERS= "Orders";
	public static final String FG_BOIL= "Fg_boil";
	public static final String ORDERS_BOIL= "Orders_boil";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_ROUTEDES= "Id_routedes";
	public static final String ID_BOIL= "Id_boil";
	public static final String ID_BOILDES= "Id_boildes";
	public static final String DAYS_OR= "Days_or";
	public static final String ID_SU_OR= "Id_su_or";
	public static final String SD_SU_OR= "Sd_su_or";
	public static final String ID_SU_MP= "Id_su_mp";
	public static final String SD_SU_MP= "Sd_su_mp";
	public static final String ID_SU_BL= "Id_su_bl";
	public static final String SD_SU_BL= "Sd_su_bl";
	public static final String ID_ORG_OR= "Id_org_or";
	public static final String ID_DEP_OR= "Id_dep_or";
	public static final String ID_WG_OR= "Id_wg_or";
	public static final String ID_EMP_OR= "Id_emp_or";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String FG_SIGN= "Fg_sign";
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	public static final String ID_DEP_SIGN= "Id_dep_sign";
	public static final String DT_SIGN= "Dt_sign";
	public static final String DT_EFFE= "Dt_effe";
	public static final String DT_END= "Dt_end";
	public static final String DT_INVALID= "Dt_invalid";
	public static final String FG_CHK= "Fg_chk";
	public static final String ID_EMP_CHK= "Id_emp_chk";
	public static final String ID_DEP_CHK= "Id_dep_chk";
	public static final String DT_CHK= "Dt_chk";
	public static final String FG_STOP= "Fg_stop";
	public static final String ID_EMP_STOP= "Id_emp_stop";
	public static final String ID_DEP_STOP= "Id_dep_stop";
	public static final String DT_STOP= "Dt_stop";
	public static final String FG_CHK_STOP= "Fg_chk_stop";
	public static final String ID_EMP_CHK_STOP= "Id_emp_chk_stop";
	public static final String ID_DEP_CHK_STOP= "Id_dep_chk_stop";
	public static final String DT_CHK_STOP= "Dt_chk_stop";
	public static final String FG_CANC= "Fg_canc";
	public static final String ID_EMP_CANC= "Id_emp_canc";
	public static final String ID_DEP_CANC= "Id_dep_canc";
	public static final String DT_CANC= "Dt_canc";
	public static final String FG_CHK_CANC= "Fg_chk_canc";
	public static final String ID_EMP_CHK_CANC= "Id_emp_chk_canc";
	public static final String ID_DEP_CHK_CANC= "Id_dep_chk_canc";
	public static final String DT_CHK_CANC= "Dt_chk_canc";
	public static final String FG_PMOR= "Fg_pmor";
	public static final String DES_PMOR= "Des_pmor";
	public static final String FG_ACTIVE_PM= "Fg_active_pm";
	public static final String ID_RELTP= "Id_reltp";
	public static final String SD_RELTP= "Sd_reltp";
	public static final String ID_OR_REL= "Id_or_rel";
	public static final String FG_BB= "Fg_bb";
	public static final String NO_BB= "No_bb";
	public static final String FG_CTLCP= "Fg_ctlcp";
	public static final String FG_MR= "Fg_mr";
	public static final String FG_SKINTEST= "Fg_skintest";
	public static final String FG_MP_IN= "Fg_mp_in";
	public static final String TIMES_MP_IN= "Times_mp_in";
	public static final String FG_MP_BED= "Fg_mp_bed";
	public static final String NOTE_OR= "Note_or";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String EU_VERIFY_PHARM= "Eu_verify_pharm";
	public static final String DES_VERIFY_PHARM= "Des_verify_pharm";
	public static final String ID_ECEP_LEVEL_PHARM= "Id_ecep_level_pharm";
	public static final String SD_EXCEP_LEVEL_PHARM= "Sd_excep_level_pharm";
	public static final String DES_VERIFY_SYS= "Des_verify_sys";
	public static final String ID_ECEP_LEVEL_SYS= "Id_ecep_level_sys";
	public static final String SD_EXCEP_LEVEL_SYS= "Sd_excep_level_sys";
	public static final String ID_EMP_VERIFY_PHARM= "Id_emp_verify_pharm";
	public static final String DT_VERIFY_PHARM= "Dt_verify_pharm";
	public static final String DES_BK_PHARM= "Des_bk_pharm";
	public static final String DT_BK_PHARM= "Dt_bk_pharm";
	public static final String ID_EMP_BK_PHARM= "Id_emp_bk_pharm";
	public static final String FG_PKG= "Fg_pkg";
	public static final String STR_LONG= "Str_long";
	public static final String NAME_OR= "Name_or";
	public static final String QUAN_FIRDAY_MP= "Quan_firday_mp";
	public static final String FG_OR_FORM= "Fg_or_form";
	public static final String ID_SKINTEST_SKIP_REASON= "Id_skintest_skip_reason";
	public static final String SD_SKINTEST_SKIP_REASON= "Sd_skintest_skip_reason";
	public static final String FG_PRES_OUTP= "Fg_pres_outp";
	public static final String FUNCCLASSSTR= "Funcclassstr";
	public static final String ID_SRVOF= "Id_srvof";
	public static final String APPLYNO= "Applyno";
	public static final String DT_LAST_BL= "Dt_last_bl";
	public static final String FG_URGENT= "Fg_urgent";
	public static final String ORD_COLLIGATE= "Ord_colligate";
	public static final String AMOUNT= "Amount";
	public static final String RESULT= "Result";
	public static final String ID_ORPLTP= "Id_orpltp";
	public static final String ID_SRVCA= "Id_srvca";
	public static final String TIMES_CUR= "Times_cur";
	public static final String ID_ORRSTTP= "Id_orrsttp";
	public static final String SD_ORRSTTP= "Sd_orrsttp";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String DT_LAST_MP= "Dt_last_mp";
	public static final String ID_UNIT_MED= "Id_unit_med";
	public static final String QUAN_MEDU= "Quan_medu";
	public static final String INNERCODE_SRVCA= "Innercode_srvca";
	public static final String FG_UNCANCELABLE= "Fg_uncancelable";
	public static final String EU_HPINDICJUDGE= "Eu_hpindicjudge";
	public static final String EU_UNCPORDOCTORJUDGE= "Eu_uncpordoctorjudge";
	public static final String EU_UNCPORJUDGE= "Eu_uncporjudge";
	public static final String REASON_UNCPORUSE= "Reason_uncporuse";
	public static final String PURPOSE_OR= "Purpose_or";
	public static final String FG_FLUSH2MR= "Fg_flush2mr";
	public static final String FG_FEERTNABLE= "Fg_feertnable";
	public static final String FG_QUICKWFLOW= "Fg_quickwflow";
	public static final String EU_ORSRCMDTP= "Eu_orsrcmdtp";
	public static final String ID_ORSRC_MAIN= "Id_orsrc_main";
	public static final String ID_ORSRC_SUB= "Id_orsrc_sub";
	public static final String ID_ORSRC_SUBSUB= "Id_orsrc_subsub";
	public static final String BHPJUDGERST= "Bhpjudgerst";
	public static final String DES_BHPJUDGERST= "Des_bhpjudgerst";
	public static final String FG_VIP= "Fg_vip";
	public static final String FG_PREPAY= "Fg_prepay";
	public static final String FG_ORHP= "Fg_orhp";
	public static final String EU_FEEREVERSETP= "Eu_feereversetp";
	public static final String MDICALINFO= "Mdicalinfo";
	public static final String ID_EXCESSIVE_REASON= "Id_excessive_reason";
	public static final String SD_EXCESSIVE_REASON= "Sd_excessive_reason";
	public static final String PAT_NAME= "Pat_name";
	public static final String PAT_ID_SEX= "Pat_id_sex";
	public static final String PAT_DT_BIRTH= "Pat_dt_birth";
	public static final String PAT_SD_SEX= "Pat_sd_sex";
	public static final String ID_DEP_NS= "Id_dep_ns";
	public static final String ID_WG_NS= "Id_wg_ns";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ENTP_NAME= "Entp_name";
	public static final String SRVTP_NAME= "Srvtp_name";
	public static final String SRV_PKG_NAME= "Srv_pkg_name";
	public static final String FREQ_NAME= "Freq_name";
	public static final String FREQUNITCT= "Frequnitct";
	public static final String FREQCT= "Freqct";
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	public static final String ROUTE_NAME= "Route_name";
	public static final String ROUTEDES_NAME= "Routedes_name";
	public static final String BOIL_NAME= "Boil_name";
	public static final String BOILDES_NAME= "Boildes_name";
	public static final String SU_OR_NAME= "Su_or_name";
	public static final String SD_SU_NAME= "Sd_su_name";
	public static final String ORG_OR_NAME= "Org_or_name";
	public static final String DEPT_OR_NAME= "Dept_or_name";
	public static final String WG_OR_NAME= "Wg_or_name";
	public static final String EMP_PHY_NAME= "Emp_phy_name";
	public static final String EMP_SIGN_NAME= "Emp_sign_name";
	public static final String DEP_SIGN_NAME= "Dep_sign_name";
	public static final String EMP_CHK_NAME= "Emp_chk_name";
	public static final String DEP_NUR_NAME= "Dep_nur_name";
	public static final String EMP_STOP_NAME= "Emp_stop_name";
	public static final String DEP_STOP_NAME= "Dep_stop_name";
	public static final String EMP_CHK_STOP_NAME= "Emp_chk_stop_name";
	public static final String EMP_CANC_NAME= "Emp_canc_name";
	public static final String DEP_CANC_NAME= "Dep_canc_name";
	public static final String EMP_CHK_CANC_NAME= "Emp_chk_canc_name";
	public static final String DEP_CHK_CANC_NAME= "Dep_chk_canc_name";
	public static final String RELTP_NAME= "Reltp_name";
	public static final String OR_REL_NAME= "Or_rel_name";
	public static final String NAME_DEP_MP= "Name_dep_mp";
	public static final String NAME_UNIT_MED= "Name_unit_med";
	public static final String NAME_EXCESSIVE_REASON= "Name_excessive_reason";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	public String getId_srv_pkg() {
		return ((String) getAttrVal("Id_srv_pkg"));
	}	
	public void setId_srv_pkg(String Id_srv_pkg) {
		setAttrVal("Id_srv_pkg", Id_srv_pkg);
	}
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}	
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}	
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	public String getId_su_or() {
		return ((String) getAttrVal("Id_su_or"));
	}	
	public void setId_su_or(String Id_su_or) {
		setAttrVal("Id_su_or", Id_su_or);
	}
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}	
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	public String getId_su_mp() {
		return ((String) getAttrVal("Id_su_mp"));
	}	
	public void setId_su_mp(String Id_su_mp) {
		setAttrVal("Id_su_mp", Id_su_mp);
	}
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}	
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}	
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}	
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	public String getId_org_or() {
		return ((String) getAttrVal("Id_org_or"));
	}	
	public void setId_org_or(String Id_org_or) {
		setAttrVal("Id_org_or", Id_org_or);
	}
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}	
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
	}
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}	
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}	
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}	
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FDateTime getDt_invalid() {
		return ((FDateTime) getAttrVal("Dt_invalid"));
	}	
	public void setDt_invalid(FDateTime Dt_invalid) {
		setAttrVal("Dt_invalid", Dt_invalid);
	}
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}	
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}	
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}	
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}	
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	public String getId_emp_stop() {
		return ((String) getAttrVal("Id_emp_stop"));
	}	
	public void setId_emp_stop(String Id_emp_stop) {
		setAttrVal("Id_emp_stop", Id_emp_stop);
	}
	public String getId_dep_stop() {
		return ((String) getAttrVal("Id_dep_stop"));
	}	
	public void setId_dep_stop(String Id_dep_stop) {
		setAttrVal("Id_dep_stop", Id_dep_stop);
	}
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}	
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
	}
	public FBoolean getFg_chk_stop() {
		return ((FBoolean) getAttrVal("Fg_chk_stop"));
	}	
	public void setFg_chk_stop(FBoolean Fg_chk_stop) {
		setAttrVal("Fg_chk_stop", Fg_chk_stop);
	}
	public String getId_emp_chk_stop() {
		return ((String) getAttrVal("Id_emp_chk_stop"));
	}	
	public void setId_emp_chk_stop(String Id_emp_chk_stop) {
		setAttrVal("Id_emp_chk_stop", Id_emp_chk_stop);
	}
	public String getId_dep_chk_stop() {
		return ((String) getAttrVal("Id_dep_chk_stop"));
	}	
	public void setId_dep_chk_stop(String Id_dep_chk_stop) {
		setAttrVal("Id_dep_chk_stop", Id_dep_chk_stop);
	}
	public FDateTime getDt_chk_stop() {
		return ((FDateTime) getAttrVal("Dt_chk_stop"));
	}	
	public void setDt_chk_stop(FDateTime Dt_chk_stop) {
		setAttrVal("Dt_chk_stop", Dt_chk_stop);
	}
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	public String getId_dep_canc() {
		return ((String) getAttrVal("Id_dep_canc"));
	}	
	public void setId_dep_canc(String Id_dep_canc) {
		setAttrVal("Id_dep_canc", Id_dep_canc);
	}
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	public FBoolean getFg_chk_canc() {
		return ((FBoolean) getAttrVal("Fg_chk_canc"));
	}	
	public void setFg_chk_canc(FBoolean Fg_chk_canc) {
		setAttrVal("Fg_chk_canc", Fg_chk_canc);
	}
	public String getId_emp_chk_canc() {
		return ((String) getAttrVal("Id_emp_chk_canc"));
	}	
	public void setId_emp_chk_canc(String Id_emp_chk_canc) {
		setAttrVal("Id_emp_chk_canc", Id_emp_chk_canc);
	}
	public String getId_dep_chk_canc() {
		return ((String) getAttrVal("Id_dep_chk_canc"));
	}	
	public void setId_dep_chk_canc(String Id_dep_chk_canc) {
		setAttrVal("Id_dep_chk_canc", Id_dep_chk_canc);
	}
	public FDateTime getDt_chk_canc() {
		return ((FDateTime) getAttrVal("Dt_chk_canc"));
	}	
	public void setDt_chk_canc(FDateTime Dt_chk_canc) {
		setAttrVal("Dt_chk_canc", Dt_chk_canc);
	}
	public FBoolean getFg_pmor() {
		return ((FBoolean) getAttrVal("Fg_pmor"));
	}	
	public void setFg_pmor(FBoolean Fg_pmor) {
		setAttrVal("Fg_pmor", Fg_pmor);
	}
	public String getDes_pmor() {
		return ((String) getAttrVal("Des_pmor"));
	}	
	public void setDes_pmor(String Des_pmor) {
		setAttrVal("Des_pmor", Des_pmor);
	}
	public FBoolean getFg_active_pm() {
		return ((FBoolean) getAttrVal("Fg_active_pm"));
	}	
	public void setFg_active_pm(FBoolean Fg_active_pm) {
		setAttrVal("Fg_active_pm", Fg_active_pm);
	}
	public String getId_reltp() {
		return ((String) getAttrVal("Id_reltp"));
	}	
	public void setId_reltp(String Id_reltp) {
		setAttrVal("Id_reltp", Id_reltp);
	}
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}	
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
	}
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}	
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}	
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}	
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	public FBoolean getFg_ctlcp() {
		return ((FBoolean) getAttrVal("Fg_ctlcp"));
	}	
	public void setFg_ctlcp(FBoolean Fg_ctlcp) {
		setAttrVal("Fg_ctlcp", Fg_ctlcp);
	}
	public FBoolean getFg_mr() {
		return ((FBoolean) getAttrVal("Fg_mr"));
	}	
	public void setFg_mr(FBoolean Fg_mr) {
		setAttrVal("Fg_mr", Fg_mr);
	}
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	public FBoolean getFg_mp_in() {
		return ((FBoolean) getAttrVal("Fg_mp_in"));
	}	
	public void setFg_mp_in(FBoolean Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
	}
	public Integer getTimes_mp_in() {
		return ((Integer) getAttrVal("Times_mp_in"));
	}	
	public void setTimes_mp_in(Integer Times_mp_in) {
		setAttrVal("Times_mp_in", Times_mp_in);
	}
	public FBoolean getFg_mp_bed() {
		return ((FBoolean) getAttrVal("Fg_mp_bed"));
	}	
	public void setFg_mp_bed(FBoolean Fg_mp_bed) {
		setAttrVal("Fg_mp_bed", Fg_mp_bed);
	}
	public String getNote_or() {
		return ((String) getAttrVal("Note_or"));
	}	
	public void setNote_or(String Note_or) {
		setAttrVal("Note_or", Note_or);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public Integer getEu_verify_pharm() {
		return ((Integer) getAttrVal("Eu_verify_pharm"));
	}	
	public void setEu_verify_pharm(Integer Eu_verify_pharm) {
		setAttrVal("Eu_verify_pharm", Eu_verify_pharm);
	}
	public String getDes_verify_pharm() {
		return ((String) getAttrVal("Des_verify_pharm"));
	}	
	public void setDes_verify_pharm(String Des_verify_pharm) {
		setAttrVal("Des_verify_pharm", Des_verify_pharm);
	}
	public String getId_ecep_level_pharm() {
		return ((String) getAttrVal("Id_ecep_level_pharm"));
	}	
	public void setId_ecep_level_pharm(String Id_ecep_level_pharm) {
		setAttrVal("Id_ecep_level_pharm", Id_ecep_level_pharm);
	}
	public String getSd_excep_level_pharm() {
		return ((String) getAttrVal("Sd_excep_level_pharm"));
	}	
	public void setSd_excep_level_pharm(String Sd_excep_level_pharm) {
		setAttrVal("Sd_excep_level_pharm", Sd_excep_level_pharm);
	}
	public String getDes_verify_sys() {
		return ((String) getAttrVal("Des_verify_sys"));
	}	
	public void setDes_verify_sys(String Des_verify_sys) {
		setAttrVal("Des_verify_sys", Des_verify_sys);
	}
	public String getId_ecep_level_sys() {
		return ((String) getAttrVal("Id_ecep_level_sys"));
	}	
	public void setId_ecep_level_sys(String Id_ecep_level_sys) {
		setAttrVal("Id_ecep_level_sys", Id_ecep_level_sys);
	}
	public String getSd_excep_level_sys() {
		return ((String) getAttrVal("Sd_excep_level_sys"));
	}	
	public void setSd_excep_level_sys(String Sd_excep_level_sys) {
		setAttrVal("Sd_excep_level_sys", Sd_excep_level_sys);
	}
	public String getId_emp_verify_pharm() {
		return ((String) getAttrVal("Id_emp_verify_pharm"));
	}	
	public void setId_emp_verify_pharm(String Id_emp_verify_pharm) {
		setAttrVal("Id_emp_verify_pharm", Id_emp_verify_pharm);
	}
	public FDateTime getDt_verify_pharm() {
		return ((FDateTime) getAttrVal("Dt_verify_pharm"));
	}	
	public void setDt_verify_pharm(FDateTime Dt_verify_pharm) {
		setAttrVal("Dt_verify_pharm", Dt_verify_pharm);
	}
	public String getDes_bk_pharm() {
		return ((String) getAttrVal("Des_bk_pharm"));
	}	
	public void setDes_bk_pharm(String Des_bk_pharm) {
		setAttrVal("Des_bk_pharm", Des_bk_pharm);
	}
	public FDateTime getDt_bk_pharm() {
		return ((FDateTime) getAttrVal("Dt_bk_pharm"));
	}	
	public void setDt_bk_pharm(FDateTime Dt_bk_pharm) {
		setAttrVal("Dt_bk_pharm", Dt_bk_pharm);
	}
	public String getId_emp_bk_pharm() {
		return ((String) getAttrVal("Id_emp_bk_pharm"));
	}	
	public void setId_emp_bk_pharm(String Id_emp_bk_pharm) {
		setAttrVal("Id_emp_bk_pharm", Id_emp_bk_pharm);
	}
	public FBoolean getFg_pkg() {
		return ((FBoolean) getAttrVal("Fg_pkg"));
	}	
	public void setFg_pkg(FBoolean Fg_pkg) {
		setAttrVal("Fg_pkg", Fg_pkg);
	}
	public String getStr_long() {
		return ((String) getAttrVal("Str_long"));
	}	
	public void setStr_long(String Str_long) {
		setAttrVal("Str_long", Str_long);
	}
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	public Integer getQuan_firday_mp() {
		return ((Integer) getAttrVal("Quan_firday_mp"));
	}	
	public void setQuan_firday_mp(Integer Quan_firday_mp) {
		setAttrVal("Quan_firday_mp", Quan_firday_mp);
	}
	public FBoolean getFg_or_form() {
		return ((FBoolean) getAttrVal("Fg_or_form"));
	}	
	public void setFg_or_form(FBoolean Fg_or_form) {
		setAttrVal("Fg_or_form", Fg_or_form);
	}
	public String getId_skintest_skip_reason() {
		return ((String) getAttrVal("Id_skintest_skip_reason"));
	}	
	public void setId_skintest_skip_reason(String Id_skintest_skip_reason) {
		setAttrVal("Id_skintest_skip_reason", Id_skintest_skip_reason);
	}
	public String getSd_skintest_skip_reason() {
		return ((String) getAttrVal("Sd_skintest_skip_reason"));
	}	
	public void setSd_skintest_skip_reason(String Sd_skintest_skip_reason) {
		setAttrVal("Sd_skintest_skip_reason", Sd_skintest_skip_reason);
	}
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}	
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	public String getFuncclassstr() {
		return ((String) getAttrVal("Funcclassstr"));
	}	
	public void setFuncclassstr(String Funcclassstr) {
		setAttrVal("Funcclassstr", Funcclassstr);
	}
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
	}
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}	
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}	
	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	public String getOrd_colligate() {
		return ((String) getAttrVal("Ord_colligate"));
	}	
	public void setOrd_colligate(String Ord_colligate) {
		setAttrVal("Ord_colligate", Ord_colligate);
	}
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}	
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	public String getResult() {
		return ((String) getAttrVal("Result"));
	}	
	public void setResult(String Result) {
		setAttrVal("Result", Result);
	}
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}	
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	public Integer getTimes_cur() {
		return ((Integer) getAttrVal("Times_cur"));
	}	
	public void setTimes_cur(Integer Times_cur) {
		setAttrVal("Times_cur", Times_cur);
	}
	public String getId_orrsttp() {
		return ((String) getAttrVal("Id_orrsttp"));
	}	
	public void setId_orrsttp(String Id_orrsttp) {
		setAttrVal("Id_orrsttp", Id_orrsttp);
	}
	public String getSd_orrsttp() {
		return ((String) getAttrVal("Sd_orrsttp"));
	}	
	public void setSd_orrsttp(String Sd_orrsttp) {
		setAttrVal("Sd_orrsttp", Sd_orrsttp);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public FDateTime getDt_last_mp() {
		return ((FDateTime) getAttrVal("Dt_last_mp"));
	}	
	public void setDt_last_mp(FDateTime Dt_last_mp) {
		setAttrVal("Dt_last_mp", Dt_last_mp);
	}
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}	
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	public FBoolean getFg_uncancelable() {
		return ((FBoolean) getAttrVal("Fg_uncancelable"));
	}	
	public void setFg_uncancelable(FBoolean Fg_uncancelable) {
		setAttrVal("Fg_uncancelable", Fg_uncancelable);
	}
	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}	
	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}
	public Integer getEu_uncpordoctorjudge() {
		return ((Integer) getAttrVal("Eu_uncpordoctorjudge"));
	}	
	public void setEu_uncpordoctorjudge(Integer Eu_uncpordoctorjudge) {
		setAttrVal("Eu_uncpordoctorjudge", Eu_uncpordoctorjudge);
	}
	public Integer getEu_uncporjudge() {
		return ((Integer) getAttrVal("Eu_uncporjudge"));
	}	
	public void setEu_uncporjudge(Integer Eu_uncporjudge) {
		setAttrVal("Eu_uncporjudge", Eu_uncporjudge);
	}
	public String getReason_uncporuse() {
		return ((String) getAttrVal("Reason_uncporuse"));
	}	
	public void setReason_uncporuse(String Reason_uncporuse) {
		setAttrVal("Reason_uncporuse", Reason_uncporuse);
	}
	public String getPurpose_or() {
		return ((String) getAttrVal("Purpose_or"));
	}	
	public void setPurpose_or(String Purpose_or) {
		setAttrVal("Purpose_or", Purpose_or);
	}
	public FBoolean getFg_flush2mr() {
		return ((FBoolean) getAttrVal("Fg_flush2mr"));
	}	
	public void setFg_flush2mr(FBoolean Fg_flush2mr) {
		setAttrVal("Fg_flush2mr", Fg_flush2mr);
	}
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}	
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	public FBoolean getFg_quickwflow() {
		return ((FBoolean) getAttrVal("Fg_quickwflow"));
	}	
	public void setFg_quickwflow(FBoolean Fg_quickwflow) {
		setAttrVal("Fg_quickwflow", Fg_quickwflow);
	}
	public String getEu_orsrcmdtp() {
		return ((String) getAttrVal("Eu_orsrcmdtp"));
	}	
	public void setEu_orsrcmdtp(String Eu_orsrcmdtp) {
		setAttrVal("Eu_orsrcmdtp", Eu_orsrcmdtp);
	}
	public String getId_orsrc_main() {
		return ((String) getAttrVal("Id_orsrc_main"));
	}	
	public void setId_orsrc_main(String Id_orsrc_main) {
		setAttrVal("Id_orsrc_main", Id_orsrc_main);
	}
	public String getId_orsrc_sub() {
		return ((String) getAttrVal("Id_orsrc_sub"));
	}	
	public void setId_orsrc_sub(String Id_orsrc_sub) {
		setAttrVal("Id_orsrc_sub", Id_orsrc_sub);
	}
	public String getId_orsrc_subsub() {
		return ((String) getAttrVal("Id_orsrc_subsub"));
	}	
	public void setId_orsrc_subsub(String Id_orsrc_subsub) {
		setAttrVal("Id_orsrc_subsub", Id_orsrc_subsub);
	}
	public String getBhpjudgerst() {
		return ((String) getAttrVal("Bhpjudgerst"));
	}	
	public void setBhpjudgerst(String Bhpjudgerst) {
		setAttrVal("Bhpjudgerst", Bhpjudgerst);
	}
	public String getDes_bhpjudgerst() {
		return ((String) getAttrVal("Des_bhpjudgerst"));
	}	
	public void setDes_bhpjudgerst(String Des_bhpjudgerst) {
		setAttrVal("Des_bhpjudgerst", Des_bhpjudgerst);
	}
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}	
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	public FBoolean getFg_orhp() {
		return ((FBoolean) getAttrVal("Fg_orhp"));
	}	
	public void setFg_orhp(FBoolean Fg_orhp) {
		setAttrVal("Fg_orhp", Fg_orhp);
	}
	public Integer getEu_feereversetp() {
		return ((Integer) getAttrVal("Eu_feereversetp"));
	}	
	public void setEu_feereversetp(Integer Eu_feereversetp) {
		setAttrVal("Eu_feereversetp", Eu_feereversetp);
	}
	public String getMdicalinfo() {
		return ((String) getAttrVal("Mdicalinfo"));
	}	
	public void setMdicalinfo(String Mdicalinfo) {
		setAttrVal("Mdicalinfo", Mdicalinfo);
	}
	public String getId_excessive_reason() {
		return ((String) getAttrVal("Id_excessive_reason"));
	}	
	public void setId_excessive_reason(String Id_excessive_reason) {
		setAttrVal("Id_excessive_reason", Id_excessive_reason);
	}
	public String getSd_excessive_reason() {
		return ((String) getAttrVal("Sd_excessive_reason"));
	}	
	public void setSd_excessive_reason(String Sd_excessive_reason) {
		setAttrVal("Sd_excessive_reason", Sd_excessive_reason);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getPat_id_sex() {
		return ((String) getAttrVal("Pat_id_sex"));
	}	
	public void setPat_id_sex(String Pat_id_sex) {
		setAttrVal("Pat_id_sex", Pat_id_sex);
	}
	public FDate getPat_dt_birth() {
		return ((FDate) getAttrVal("Pat_dt_birth"));
	}	
	public void setPat_dt_birth(FDate Pat_dt_birth) {
		setAttrVal("Pat_dt_birth", Pat_dt_birth);
	}
	public String getPat_sd_sex() {
		return ((String) getAttrVal("Pat_sd_sex"));
	}	
	public void setPat_sd_sex(String Pat_sd_sex) {
		setAttrVal("Pat_sd_sex", Pat_sd_sex);
	}
	public String getId_dep_ns() {
		return ((String) getAttrVal("Id_dep_ns"));
	}	
	public void setId_dep_ns(String Id_dep_ns) {
		setAttrVal("Id_dep_ns", Id_dep_ns);
	}
	public String getId_wg_ns() {
		return ((String) getAttrVal("Id_wg_ns"));
	}	
	public void setId_wg_ns(String Id_wg_ns) {
		setAttrVal("Id_wg_ns", Id_wg_ns);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	public String getSrv_pkg_name() {
		return ((String) getAttrVal("Srv_pkg_name"));
	}	
	public void setSrv_pkg_name(String Srv_pkg_name) {
		setAttrVal("Srv_pkg_name", Srv_pkg_name);
	}
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}	
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	public Integer getFrequnitct() {
		return ((Integer) getAttrVal("Frequnitct"));
	}	
	public void setFrequnitct(Integer Frequnitct) {
		setAttrVal("Frequnitct", Frequnitct);
	}
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}	
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}	
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}	
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	public String getRoutedes_name() {
		return ((String) getAttrVal("Routedes_name"));
	}	
	public void setRoutedes_name(String Routedes_name) {
		setAttrVal("Routedes_name", Routedes_name);
	}
	public String getBoil_name() {
		return ((String) getAttrVal("Boil_name"));
	}	
	public void setBoil_name(String Boil_name) {
		setAttrVal("Boil_name", Boil_name);
	}
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}	
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	public String getSu_or_name() {
		return ((String) getAttrVal("Su_or_name"));
	}	
	public void setSu_or_name(String Su_or_name) {
		setAttrVal("Su_or_name", Su_or_name);
	}
	public String getSd_su_name() {
		return ((String) getAttrVal("Sd_su_name"));
	}	
	public void setSd_su_name(String Sd_su_name) {
		setAttrVal("Sd_su_name", Sd_su_name);
	}
	public String getOrg_or_name() {
		return ((String) getAttrVal("Org_or_name"));
	}	
	public void setOrg_or_name(String Org_or_name) {
		setAttrVal("Org_or_name", Org_or_name);
	}
	public String getDept_or_name() {
		return ((String) getAttrVal("Dept_or_name"));
	}	
	public void setDept_or_name(String Dept_or_name) {
		setAttrVal("Dept_or_name", Dept_or_name);
	}
	public String getWg_or_name() {
		return ((String) getAttrVal("Wg_or_name"));
	}	
	public void setWg_or_name(String Wg_or_name) {
		setAttrVal("Wg_or_name", Wg_or_name);
	}
	public String getEmp_phy_name() {
		return ((String) getAttrVal("Emp_phy_name"));
	}	
	public void setEmp_phy_name(String Emp_phy_name) {
		setAttrVal("Emp_phy_name", Emp_phy_name);
	}
	public String getEmp_sign_name() {
		return ((String) getAttrVal("Emp_sign_name"));
	}	
	public void setEmp_sign_name(String Emp_sign_name) {
		setAttrVal("Emp_sign_name", Emp_sign_name);
	}
	public String getDep_sign_name() {
		return ((String) getAttrVal("Dep_sign_name"));
	}	
	public void setDep_sign_name(String Dep_sign_name) {
		setAttrVal("Dep_sign_name", Dep_sign_name);
	}
	public String getEmp_chk_name() {
		return ((String) getAttrVal("Emp_chk_name"));
	}	
	public void setEmp_chk_name(String Emp_chk_name) {
		setAttrVal("Emp_chk_name", Emp_chk_name);
	}
	public String getDep_nur_name() {
		return ((String) getAttrVal("Dep_nur_name"));
	}	
	public void setDep_nur_name(String Dep_nur_name) {
		setAttrVal("Dep_nur_name", Dep_nur_name);
	}
	public String getEmp_stop_name() {
		return ((String) getAttrVal("Emp_stop_name"));
	}	
	public void setEmp_stop_name(String Emp_stop_name) {
		setAttrVal("Emp_stop_name", Emp_stop_name);
	}
	public String getDep_stop_name() {
		return ((String) getAttrVal("Dep_stop_name"));
	}	
	public void setDep_stop_name(String Dep_stop_name) {
		setAttrVal("Dep_stop_name", Dep_stop_name);
	}
	public String getEmp_chk_stop_name() {
		return ((String) getAttrVal("Emp_chk_stop_name"));
	}	
	public void setEmp_chk_stop_name(String Emp_chk_stop_name) {
		setAttrVal("Emp_chk_stop_name", Emp_chk_stop_name);
	}
	public String getEmp_canc_name() {
		return ((String) getAttrVal("Emp_canc_name"));
	}	
	public void setEmp_canc_name(String Emp_canc_name) {
		setAttrVal("Emp_canc_name", Emp_canc_name);
	}
	public String getDep_canc_name() {
		return ((String) getAttrVal("Dep_canc_name"));
	}	
	public void setDep_canc_name(String Dep_canc_name) {
		setAttrVal("Dep_canc_name", Dep_canc_name);
	}
	public String getEmp_chk_canc_name() {
		return ((String) getAttrVal("Emp_chk_canc_name"));
	}	
	public void setEmp_chk_canc_name(String Emp_chk_canc_name) {
		setAttrVal("Emp_chk_canc_name", Emp_chk_canc_name);
	}
	public String getDep_chk_canc_name() {
		return ((String) getAttrVal("Dep_chk_canc_name"));
	}	
	public void setDep_chk_canc_name(String Dep_chk_canc_name) {
		setAttrVal("Dep_chk_canc_name", Dep_chk_canc_name);
	}
	public String getReltp_name() {
		return ((String) getAttrVal("Reltp_name"));
	}	
	public void setReltp_name(String Reltp_name) {
		setAttrVal("Reltp_name", Reltp_name);
	}
	public String getOr_rel_name() {
		return ((String) getAttrVal("Or_rel_name"));
	}	
	public void setOr_rel_name(String Or_rel_name) {
		setAttrVal("Or_rel_name", Or_rel_name);
	}
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}	
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	public String getName_excessive_reason() {
		return ((String) getAttrVal("Name_excessive_reason"));
	}	
	public void setName_excessive_reason(String Name_excessive_reason) {
		setAttrVal("Name_excessive_reason", Name_excessive_reason);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_or";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_order";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrderDODesc.class);
	}
	
}
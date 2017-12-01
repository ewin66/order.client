package iih.ci.ord.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.app.d.desc.CiAppLisSheetDODesc;
import java.math.BigDecimal;

/**
 * 检验打印申请单 DO数据 
 * 
 */
public class CiAppLisSheetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIAPPLISSHEET= "Id_ciapplissheet";
	public static final String ID_DI= "Id_di";
	public static final String ID_DIITM= "Id_diitm";
	public static final String STR_ID_DIITM= "Str_id_diitm";
	public static final String STR_CODE_DI= "Str_code_di";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String NAME_DIAG= "Name_diag";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String CODE_APP= "Code_app";
	public static final String NAME_APP= "Name_app";
	public static final String DT_PLAN= "Dt_plan";
	public static final String FG_URGENT= "Fg_urgent";
	public static final String ID_ORG_APP= "Id_org_app";
	public static final String ID_DEP_APP= "Id_dep_app";
	public static final String FG_PRN= "Fg_prn";
	public static final String CNT_PRN= "Cnt_prn";
	public static final String FG_HP_PRES= "Fg_hp_pres";
	public static final String ID_EMP_APP= "Id_emp_app";
	public static final String DT_APP= "Dt_app";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_EN= "Id_en";
	public static final String FG_BB= "Fg_bb";
	public static final String NO_BB= "No_bb";
	public static final String FG_OPSPECIAL= "Fg_opspecial";
	public static final String ANNOUNCEMENTS= "Announcements";
	public static final String SAMPCOLPLACE= "Sampcolplace";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String AMT_APP_TOTAL= "Amt_app_total";
	public static final String ID_SAMPCOLTIME= "Id_sampcoltime";
	public static final String LEN_SAMPCOLTIME= "Len_sampcoltime";
	public static final String ID_SAMPCOLLECTTIMETP= "Id_sampcollecttimetp";
	public static final String SD_SAMPCOLLECTTIMETP= "Sd_sampcollecttimetp";
	public static final String ID_UNIT_SAMPCOLTIME= "Id_unit_sampcoltime";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_SESSION= "Id_session";
	public static final String ID_SAMPTP= "Id_samptp";
	public static final String SD_SAMPTP= "Sd_samptp";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String DEF7= "Def7";
	public static final String DEF8= "Def8";
	public static final String DEF9= "Def9";
	public static final String DEF10= "Def10";
	public static final String DEF11= "Def11";
	public static final String DEF12= "Def12";
	public static final String DEF13= "Def13";
	public static final String DEF14= "Def14";
	public static final String DEF15= "Def15";
	public static final String DEF16= "Def16";
	public static final String DEF17= "Def17";
	public static final String DEF18= "Def18";
	public static final String DEF19= "Def19";
	public static final String DEF20= "Def20";
	public static final String FG_HECOMINSUR= "Fg_hecominsur";
	public static final String HECOMINSURINFO= "Hecominsurinfo";
	public static final String FG_PREPAY= "Fg_prepay";
	public static final String FG_VIP= "Fg_vip";
	public static final String FG_LISHP= "Fg_lishp";
	public static final String FG_HPBIRTH= "Fg_hpbirth";
	public static final String RESEARCHINFO= "Researchinfo";
	public static final String FG_BLSETTLED= "Fg_blsettled";
	public static final String NAME_ORDI= "Name_ordi";
	public static final String NAME_SAMPCOLTIME= "Name_sampcoltime";
	public static final String NAME_SAMPCOLLECTTIMETP= "Name_sampcollecttimetp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciapplissheet() {
		return ((String) getAttrVal("Id_ciapplissheet"));
	}	
	public void setId_ciapplissheet(String Id_ciapplissheet) {
		setAttrVal("Id_ciapplissheet", Id_ciapplissheet);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}	
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}	
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getCode_app() {
		return ((String) getAttrVal("Code_app"));
	}	
	public void setCode_app(String Code_app) {
		setAttrVal("Code_app", Code_app);
	}
	public String getName_app() {
		return ((String) getAttrVal("Name_app"));
	}	
	public void setName_app(String Name_app) {
		setAttrVal("Name_app", Name_app);
	}
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	public String getId_org_app() {
		return ((String) getAttrVal("Id_org_app"));
	}	
	public void setId_org_app(String Id_org_app) {
		setAttrVal("Id_org_app", Id_org_app);
	}
	public String getId_dep_app() {
		return ((String) getAttrVal("Id_dep_app"));
	}	
	public void setId_dep_app(String Id_dep_app) {
		setAttrVal("Id_dep_app", Id_dep_app);
	}
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	public Integer getCnt_prn() {
		return ((Integer) getAttrVal("Cnt_prn"));
	}	
	public void setCnt_prn(Integer Cnt_prn) {
		setAttrVal("Cnt_prn", Cnt_prn);
	}
	public FBoolean getFg_hp_pres() {
		return ((FBoolean) getAttrVal("Fg_hp_pres"));
	}	
	public void setFg_hp_pres(FBoolean Fg_hp_pres) {
		setAttrVal("Fg_hp_pres", Fg_hp_pres);
	}
	public String getId_emp_app() {
		return ((String) getAttrVal("Id_emp_app"));
	}	
	public void setId_emp_app(String Id_emp_app) {
		setAttrVal("Id_emp_app", Id_emp_app);
	}
	public FDateTime getDt_app() {
		return ((FDateTime) getAttrVal("Dt_app"));
	}	
	public void setDt_app(FDateTime Dt_app) {
		setAttrVal("Dt_app", Dt_app);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
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
	public FBoolean getFg_opspecial() {
		return ((FBoolean) getAttrVal("Fg_opspecial"));
	}	
	public void setFg_opspecial(FBoolean Fg_opspecial) {
		setAttrVal("Fg_opspecial", Fg_opspecial);
	}
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}	
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	public String getSampcolplace() {
		return ((String) getAttrVal("Sampcolplace"));
	}	
	public void setSampcolplace(String Sampcolplace) {
		setAttrVal("Sampcolplace", Sampcolplace);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public FDouble getAmt_app_total() {
		return ((FDouble) getAttrVal("Amt_app_total"));
	}	
	public void setAmt_app_total(FDouble Amt_app_total) {
		setAttrVal("Amt_app_total", Amt_app_total);
	}
	public String getId_sampcoltime() {
		return ((String) getAttrVal("Id_sampcoltime"));
	}	
	public void setId_sampcoltime(String Id_sampcoltime) {
		setAttrVal("Id_sampcoltime", Id_sampcoltime);
	}
	public FDouble getLen_sampcoltime() {
		return ((FDouble) getAttrVal("Len_sampcoltime"));
	}	
	public void setLen_sampcoltime(FDouble Len_sampcoltime) {
		setAttrVal("Len_sampcoltime", Len_sampcoltime);
	}
	public String getId_sampcollecttimetp() {
		return ((String) getAttrVal("Id_sampcollecttimetp"));
	}	
	public void setId_sampcollecttimetp(String Id_sampcollecttimetp) {
		setAttrVal("Id_sampcollecttimetp", Id_sampcollecttimetp);
	}
	public String getSd_sampcollecttimetp() {
		return ((String) getAttrVal("Sd_sampcollecttimetp"));
	}	
	public void setSd_sampcollecttimetp(String Sd_sampcollecttimetp) {
		setAttrVal("Sd_sampcollecttimetp", Sd_sampcollecttimetp);
	}
	public String getId_unit_sampcoltime() {
		return ((String) getAttrVal("Id_unit_sampcoltime"));
	}	
	public void setId_unit_sampcoltime(String Id_unit_sampcoltime) {
		setAttrVal("Id_unit_sampcoltime", Id_unit_sampcoltime);
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
	public String getId_session() {
		return ((String) getAttrVal("Id_session"));
	}	
	public void setId_session(String Id_session) {
		setAttrVal("Id_session", Id_session);
	}
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}	
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}	
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	public String getDef11() {
		return ((String) getAttrVal("Def11"));
	}	
	public void setDef11(String Def11) {
		setAttrVal("Def11", Def11);
	}
	public String getDef12() {
		return ((String) getAttrVal("Def12"));
	}	
	public void setDef12(String Def12) {
		setAttrVal("Def12", Def12);
	}
	public String getDef13() {
		return ((String) getAttrVal("Def13"));
	}	
	public void setDef13(String Def13) {
		setAttrVal("Def13", Def13);
	}
	public String getDef14() {
		return ((String) getAttrVal("Def14"));
	}	
	public void setDef14(String Def14) {
		setAttrVal("Def14", Def14);
	}
	public String getDef15() {
		return ((String) getAttrVal("Def15"));
	}	
	public void setDef15(String Def15) {
		setAttrVal("Def15", Def15);
	}
	public String getDef16() {
		return ((String) getAttrVal("Def16"));
	}	
	public void setDef16(String Def16) {
		setAttrVal("Def16", Def16);
	}
	public String getDef17() {
		return ((String) getAttrVal("Def17"));
	}	
	public void setDef17(String Def17) {
		setAttrVal("Def17", Def17);
	}
	public String getDef18() {
		return ((String) getAttrVal("Def18"));
	}	
	public void setDef18(String Def18) {
		setAttrVal("Def18", Def18);
	}
	public String getDef19() {
		return ((String) getAttrVal("Def19"));
	}	
	public void setDef19(String Def19) {
		setAttrVal("Def19", Def19);
	}
	public String getDef20() {
		return ((String) getAttrVal("Def20"));
	}	
	public void setDef20(String Def20) {
		setAttrVal("Def20", Def20);
	}
	public FBoolean getFg_hecominsur() {
		return ((FBoolean) getAttrVal("Fg_hecominsur"));
	}	
	public void setFg_hecominsur(FBoolean Fg_hecominsur) {
		setAttrVal("Fg_hecominsur", Fg_hecominsur);
	}
	public String getHecominsurinfo() {
		return ((String) getAttrVal("Hecominsurinfo"));
	}	
	public void setHecominsurinfo(String Hecominsurinfo) {
		setAttrVal("Hecominsurinfo", Hecominsurinfo);
	}
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}	
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	public FBoolean getFg_lishp() {
		return ((FBoolean) getAttrVal("Fg_lishp"));
	}	
	public void setFg_lishp(FBoolean Fg_lishp) {
		setAttrVal("Fg_lishp", Fg_lishp);
	}
	public FBoolean getFg_hpbirth() {
		return ((FBoolean) getAttrVal("Fg_hpbirth"));
	}	
	public void setFg_hpbirth(FBoolean Fg_hpbirth) {
		setAttrVal("Fg_hpbirth", Fg_hpbirth);
	}
	public String getResearchinfo() {
		return ((String) getAttrVal("Researchinfo"));
	}	
	public void setResearchinfo(String Researchinfo) {
		setAttrVal("Researchinfo", Researchinfo);
	}
	public FBoolean getFg_blsettled() {
		return ((FBoolean) getAttrVal("Fg_blsettled"));
	}	
	public void setFg_blsettled(FBoolean Fg_blsettled) {
		setAttrVal("Fg_blsettled", Fg_blsettled);
	}
	public String getName_ordi() {
		return ((String) getAttrVal("Name_ordi"));
	}	
	public void setName_ordi(String Name_ordi) {
		setAttrVal("Name_ordi", Name_ordi);
	}
	public String getName_sampcoltime() {
		return ((String) getAttrVal("Name_sampcoltime"));
	}	
	public void setName_sampcoltime(String Name_sampcoltime) {
		setAttrVal("Name_sampcoltime", Name_sampcoltime);
	}
	public String getName_sampcollecttimetp() {
		return ((String) getAttrVal("Name_sampcollecttimetp"));
	}	
	public void setName_sampcollecttimetp(String Name_sampcollecttimetp) {
		setAttrVal("Name_sampcollecttimetp", Name_sampcollecttimetp);
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
		return "Id_ciapplissheet";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_app_lis";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiAppLisSheetDODesc.class);
	}
	
}
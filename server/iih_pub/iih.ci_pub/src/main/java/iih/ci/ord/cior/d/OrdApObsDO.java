package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import java.math.BigDecimal;

/**
 * 医嘱检查申请单 DO数据 
 * 
 */
public class OrdApObsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OROBS= "Id_orobs";
	public static final String ID_OR= "Id_or";
	public static final String ID_DI= "Id_di";
	public static final String NAME_DIAG= "Name_diag";
	public static final String STR_CODE_DI= "Str_code_di";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String DT_PLAN= "Dt_plan";
	public static final String BIOPSY= "Biopsy";
	public static final String DES_SYMPSIGN= "Des_sympsign";
	public static final String CLINICALZZTZ= "Clinicalzztz";
	public static final String PASTILLNESS= "Pastillness";
	public static final String AUXIMTEXAM= "Auximtexam";
	public static final String FG_URGENT= "Fg_urgent";
	public static final String ANNOUNCEMENTS= "Announcements";
	public static final String ID_PPS= "Id_pps";
	public static final String SD_PPS= "Sd_pps";
	public static final String DES_PPS= "Des_pps";
	public static final String ID_SU_OBS= "Id_su_obs";
	public static final String SD_SU_OBS= "Sd_su_obs";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String STR_ID_DIITM= "Str_id_diitm";
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
	public static final String DEF21= "Def21";
	public static final String DEF22= "Def22";
	public static final String DEF23= "Def23";
	public static final String DEF24= "Def24";
	public static final String DEF25= "Def25";
	public static final String DEF26= "Def26";
	public static final String DEF27= "Def27";
	public static final String DEF28= "Def28";
	public static final String DEF29= "Def29";
	public static final String DEF30= "Def30";
	public static final String DEF31= "Def31";
	public static final String DEF32= "Def32";
	public static final String DEF33= "Def33";
	public static final String DEF34= "Def34";
	public static final String DEF35= "Def35";
	public static final String DEF36= "Def36";
	public static final String DEF37= "Def37";
	public static final String DEF38= "Def38";
	public static final String DEF39= "Def39";
	public static final String DEF40= "Def40";
	public static final String DEF41= "Def41";
	public static final String DEF42= "Def42";
	public static final String DEF43= "Def43";
	public static final String DEF44= "Def44";
	public static final String DEF45= "Def45";
	public static final String DEF46= "Def46";
	public static final String DEF47= "Def47";
	public static final String DEF48= "Def48";
	public static final String DEF49= "Def49";
	public static final String DEF50= "Def50";
	public static final String ID_DIITM= "Id_diitm";
	public static final String FG_PRN= "Fg_prn";
	public static final String CNT_PRN= "Cnt_prn";
	public static final String NAME_DI= "Name_di";
	public static final String NAME_PPS= "Name_pps";
	public static final String NAME_SU_OBS= "Name_su_obs";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orobs() {
		return ((String) getAttrVal("Id_orobs"));
	}	
	public void setId_orobs(String Id_orobs) {
		setAttrVal("Id_orobs", Id_orobs);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
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
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	public String getBiopsy() {
		return ((String) getAttrVal("Biopsy"));
	}	
	public void setBiopsy(String Biopsy) {
		setAttrVal("Biopsy", Biopsy);
	}
	public String getDes_sympsign() {
		return ((String) getAttrVal("Des_sympsign"));
	}	
	public void setDes_sympsign(String Des_sympsign) {
		setAttrVal("Des_sympsign", Des_sympsign);
	}
	public String getClinicalzztz() {
		return ((String) getAttrVal("Clinicalzztz"));
	}	
	public void setClinicalzztz(String Clinicalzztz) {
		setAttrVal("Clinicalzztz", Clinicalzztz);
	}
	public String getPastillness() {
		return ((String) getAttrVal("Pastillness"));
	}	
	public void setPastillness(String Pastillness) {
		setAttrVal("Pastillness", Pastillness);
	}
	public String getAuximtexam() {
		return ((String) getAttrVal("Auximtexam"));
	}	
	public void setAuximtexam(String Auximtexam) {
		setAttrVal("Auximtexam", Auximtexam);
	}
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}	
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	public String getId_pps() {
		return ((String) getAttrVal("Id_pps"));
	}	
	public void setId_pps(String Id_pps) {
		setAttrVal("Id_pps", Id_pps);
	}
	public String getSd_pps() {
		return ((String) getAttrVal("Sd_pps"));
	}	
	public void setSd_pps(String Sd_pps) {
		setAttrVal("Sd_pps", Sd_pps);
	}
	public String getDes_pps() {
		return ((String) getAttrVal("Des_pps"));
	}	
	public void setDes_pps(String Des_pps) {
		setAttrVal("Des_pps", Des_pps);
	}
	public String getId_su_obs() {
		return ((String) getAttrVal("Id_su_obs"));
	}	
	public void setId_su_obs(String Id_su_obs) {
		setAttrVal("Id_su_obs", Id_su_obs);
	}
	public String getSd_su_obs() {
		return ((String) getAttrVal("Sd_su_obs"));
	}	
	public void setSd_su_obs(String Sd_su_obs) {
		setAttrVal("Sd_su_obs", Sd_su_obs);
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
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}	
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
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
	public String getDef21() {
		return ((String) getAttrVal("Def21"));
	}	
	public void setDef21(String Def21) {
		setAttrVal("Def21", Def21);
	}
	public String getDef22() {
		return ((String) getAttrVal("Def22"));
	}	
	public void setDef22(String Def22) {
		setAttrVal("Def22", Def22);
	}
	public String getDef23() {
		return ((String) getAttrVal("Def23"));
	}	
	public void setDef23(String Def23) {
		setAttrVal("Def23", Def23);
	}
	public String getDef24() {
		return ((String) getAttrVal("Def24"));
	}	
	public void setDef24(String Def24) {
		setAttrVal("Def24", Def24);
	}
	public String getDef25() {
		return ((String) getAttrVal("Def25"));
	}	
	public void setDef25(String Def25) {
		setAttrVal("Def25", Def25);
	}
	public String getDef26() {
		return ((String) getAttrVal("Def26"));
	}	
	public void setDef26(String Def26) {
		setAttrVal("Def26", Def26);
	}
	public String getDef27() {
		return ((String) getAttrVal("Def27"));
	}	
	public void setDef27(String Def27) {
		setAttrVal("Def27", Def27);
	}
	public String getDef28() {
		return ((String) getAttrVal("Def28"));
	}	
	public void setDef28(String Def28) {
		setAttrVal("Def28", Def28);
	}
	public String getDef29() {
		return ((String) getAttrVal("Def29"));
	}	
	public void setDef29(String Def29) {
		setAttrVal("Def29", Def29);
	}
	public String getDef30() {
		return ((String) getAttrVal("Def30"));
	}	
	public void setDef30(String Def30) {
		setAttrVal("Def30", Def30);
	}
	public String getDef31() {
		return ((String) getAttrVal("Def31"));
	}	
	public void setDef31(String Def31) {
		setAttrVal("Def31", Def31);
	}
	public String getDef32() {
		return ((String) getAttrVal("Def32"));
	}	
	public void setDef32(String Def32) {
		setAttrVal("Def32", Def32);
	}
	public String getDef33() {
		return ((String) getAttrVal("Def33"));
	}	
	public void setDef33(String Def33) {
		setAttrVal("Def33", Def33);
	}
	public String getDef34() {
		return ((String) getAttrVal("Def34"));
	}	
	public void setDef34(String Def34) {
		setAttrVal("Def34", Def34);
	}
	public String getDef35() {
		return ((String) getAttrVal("Def35"));
	}	
	public void setDef35(String Def35) {
		setAttrVal("Def35", Def35);
	}
	public String getDef36() {
		return ((String) getAttrVal("Def36"));
	}	
	public void setDef36(String Def36) {
		setAttrVal("Def36", Def36);
	}
	public String getDef37() {
		return ((String) getAttrVal("Def37"));
	}	
	public void setDef37(String Def37) {
		setAttrVal("Def37", Def37);
	}
	public String getDef38() {
		return ((String) getAttrVal("Def38"));
	}	
	public void setDef38(String Def38) {
		setAttrVal("Def38", Def38);
	}
	public String getDef39() {
		return ((String) getAttrVal("Def39"));
	}	
	public void setDef39(String Def39) {
		setAttrVal("Def39", Def39);
	}
	public String getDef40() {
		return ((String) getAttrVal("Def40"));
	}	
	public void setDef40(String Def40) {
		setAttrVal("Def40", Def40);
	}
	public String getDef41() {
		return ((String) getAttrVal("Def41"));
	}	
	public void setDef41(String Def41) {
		setAttrVal("Def41", Def41);
	}
	public String getDef42() {
		return ((String) getAttrVal("Def42"));
	}	
	public void setDef42(String Def42) {
		setAttrVal("Def42", Def42);
	}
	public String getDef43() {
		return ((String) getAttrVal("Def43"));
	}	
	public void setDef43(String Def43) {
		setAttrVal("Def43", Def43);
	}
	public String getDef44() {
		return ((String) getAttrVal("Def44"));
	}	
	public void setDef44(String Def44) {
		setAttrVal("Def44", Def44);
	}
	public String getDef45() {
		return ((String) getAttrVal("Def45"));
	}	
	public void setDef45(String Def45) {
		setAttrVal("Def45", Def45);
	}
	public String getDef46() {
		return ((String) getAttrVal("Def46"));
	}	
	public void setDef46(String Def46) {
		setAttrVal("Def46", Def46);
	}
	public String getDef47() {
		return ((String) getAttrVal("Def47"));
	}	
	public void setDef47(String Def47) {
		setAttrVal("Def47", Def47);
	}
	public String getDef48() {
		return ((String) getAttrVal("Def48"));
	}	
	public void setDef48(String Def48) {
		setAttrVal("Def48", Def48);
	}
	public String getDef49() {
		return ((String) getAttrVal("Def49"));
	}	
	public void setDef49(String Def49) {
		setAttrVal("Def49", Def49);
	}
	public String getDef50() {
		return ((String) getAttrVal("Def50"));
	}	
	public void setDef50(String Def50) {
		setAttrVal("Def50", Def50);
	}
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
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
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	public String getName_pps() {
		return ((String) getAttrVal("Name_pps"));
	}	
	public void setName_pps(String Name_pps) {
		setAttrVal("Name_pps", Name_pps);
	}
	public String getName_su_obs() {
		return ((String) getAttrVal("Name_su_obs"));
	}	
	public void setName_su_obs(String Name_su_obs) {
		setAttrVal("Name_su_obs", Name_su_obs);
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
		return "Id_orobs";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_obs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApObsDODesc.class);
	}
	
}
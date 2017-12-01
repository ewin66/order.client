package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import java.math.BigDecimal;

/**
 * 会诊申请单 DO数据 
 * 
 */
public class OrdApConsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APCONS= "Id_apcons";
	public static final String ID_OR= "Id_or";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String ID_CONSTP= "Id_constp";
	public static final String SD_CONSTP= "Sd_constp";
	public static final String DT_AP= "Dt_ap";
	public static final String TEL= "Tel";
	public static final String DES_EMR= "Des_emr";
	public static final String DT_PLAN= "Dt_plan";
	public static final String PLACE= "Place";
	public static final String DES_PSP= "Des_psp";
	public static final String ID_SU_CONS= "Id_su_cons";
	public static final String SD_SU_CONS= "Sd_su_cons";
	public static final String FG_URGENT= "Fg_urgent";
	public static final String DES_DEP= "Des_dep";
	public static final String DT_CONSTIMELIMIT= "Dt_constimelimit";
	public static final String FG_AUDIT_CLIDEP= "Fg_audit_clidep";
	public static final String FG_AUDIT_ADMDEP= "Fg_audit_admdep";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_PRN= "Fg_prn";
	public static final String CNT_PRN= "Cnt_prn";
	public static final String NAME_CONSTP= "Name_constp";
	public static final String NAME_SU_CONS= "Name_su_cons";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apcons() {
		return ((String) getAttrVal("Id_apcons"));
	}	
	public void setId_apcons(String Id_apcons) {
		setAttrVal("Id_apcons", Id_apcons);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public String getId_constp() {
		return ((String) getAttrVal("Id_constp"));
	}	
	public void setId_constp(String Id_constp) {
		setAttrVal("Id_constp", Id_constp);
	}
	public String getSd_constp() {
		return ((String) getAttrVal("Sd_constp"));
	}	
	public void setSd_constp(String Sd_constp) {
		setAttrVal("Sd_constp", Sd_constp);
	}
	public FDateTime getDt_ap() {
		return ((FDateTime) getAttrVal("Dt_ap"));
	}	
	public void setDt_ap(FDateTime Dt_ap) {
		setAttrVal("Dt_ap", Dt_ap);
	}
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	public String getDes_emr() {
		return ((String) getAttrVal("Des_emr"));
	}	
	public void setDes_emr(String Des_emr) {
		setAttrVal("Des_emr", Des_emr);
	}
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	public String getPlace() {
		return ((String) getAttrVal("Place"));
	}	
	public void setPlace(String Place) {
		setAttrVal("Place", Place);
	}
	public String getDes_psp() {
		return ((String) getAttrVal("Des_psp"));
	}	
	public void setDes_psp(String Des_psp) {
		setAttrVal("Des_psp", Des_psp);
	}
	public String getId_su_cons() {
		return ((String) getAttrVal("Id_su_cons"));
	}	
	public void setId_su_cons(String Id_su_cons) {
		setAttrVal("Id_su_cons", Id_su_cons);
	}
	public String getSd_su_cons() {
		return ((String) getAttrVal("Sd_su_cons"));
	}	
	public void setSd_su_cons(String Sd_su_cons) {
		setAttrVal("Sd_su_cons", Sd_su_cons);
	}
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	public String getDes_dep() {
		return ((String) getAttrVal("Des_dep"));
	}	
	public void setDes_dep(String Des_dep) {
		setAttrVal("Des_dep", Des_dep);
	}
	public FDateTime getDt_constimelimit() {
		return ((FDateTime) getAttrVal("Dt_constimelimit"));
	}	
	public void setDt_constimelimit(FDateTime Dt_constimelimit) {
		setAttrVal("Dt_constimelimit", Dt_constimelimit);
	}
	public FBoolean getFg_audit_clidep() {
		return ((FBoolean) getAttrVal("Fg_audit_clidep"));
	}	
	public void setFg_audit_clidep(FBoolean Fg_audit_clidep) {
		setAttrVal("Fg_audit_clidep", Fg_audit_clidep);
	}
	public FBoolean getFg_audit_admdep() {
		return ((FBoolean) getAttrVal("Fg_audit_admdep"));
	}	
	public void setFg_audit_admdep(FBoolean Fg_audit_admdep) {
		setAttrVal("Fg_audit_admdep", Fg_audit_admdep);
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
	public String getName_constp() {
		return ((String) getAttrVal("Name_constp"));
	}	
	public void setName_constp(String Name_constp) {
		setAttrVal("Name_constp", Name_constp);
	}
	public String getName_su_cons() {
		return ((String) getAttrVal("Name_su_cons"));
	}	
	public void setName_su_cons(String Name_su_cons) {
		setAttrVal("Name_su_cons", Name_su_cons);
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
		return "Id_apcons";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_cons";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApConsDODesc.class);
	}
	
}
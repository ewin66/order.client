package iih.ci.ord.cirptpathgy.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cirptpathgy.d.desc.CiRptPathgyDesc;
import java.math.BigDecimal;

/**
 * 病理报告单 DO数据 
 * 
 */
public class CiRptPathgy extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTPATHGY= "Id_rptpathgy";
	public static final String ID_APPATHGY= "Id_appathgy";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String ID_OR= "Id_or";
	public static final String NO_RPTPATHGY= "No_rptpathgy";
	public static final String DES_RPTPATHGY= "Des_rptpathgy";
	public static final String DES_ADVICE= "Des_advice";
	public static final String DES_PATHGY= "Des_pathgy";
	public static final String ID_ENT= "Id_ent";
	public static final String SD_INSMT= "Sd_insmt";
	public static final String ID_SU_RPT= "Id_su_rpt";
	public static final String SD_SU_RPT= "Sd_su_rpt";
	public static final String DT_RPTPATHGY= "Dt_rptpathgy";
	public static final String ID_EMP_RPT= "Id_emp_rpt";
	public static final String ID_DEP_RPT= "Id_dep_rpt";
	public static final String URL_IMG= "Url_img";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String APPLYFORMNO= "Applyformno";
	public static final String DT_EFFE= "Dt_effe";
	public static final String PSN_NAME= "Psn_name";
	public static final String SEX_NAME= "Sex_name";
	public static final String NAME_OR= "Name_or";
	public static final String ENT_CODE= "Ent_code";
	public static final String NAME_PAT= "Name_pat";
	public static final String SU_NAME= "Su_name";
	public static final String RPT_NAME= "Rpt_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptpathgy() {
		return ((String) getAttrVal("Id_rptpathgy"));
	}	
	public void setId_rptpathgy(String Id_rptpathgy) {
		setAttrVal("Id_rptpathgy", Id_rptpathgy);
	}
	public String getId_appathgy() {
		return ((String) getAttrVal("Id_appathgy"));
	}	
	public void setId_appathgy(String Id_appathgy) {
		setAttrVal("Id_appathgy", Id_appathgy);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getNo_rptpathgy() {
		return ((String) getAttrVal("No_rptpathgy"));
	}	
	public void setNo_rptpathgy(String No_rptpathgy) {
		setAttrVal("No_rptpathgy", No_rptpathgy);
	}
	public String getDes_rptpathgy() {
		return ((String) getAttrVal("Des_rptpathgy"));
	}	
	public void setDes_rptpathgy(String Des_rptpathgy) {
		setAttrVal("Des_rptpathgy", Des_rptpathgy);
	}
	public String getDes_advice() {
		return ((String) getAttrVal("Des_advice"));
	}	
	public void setDes_advice(String Des_advice) {
		setAttrVal("Des_advice", Des_advice);
	}
	public String getDes_pathgy() {
		return ((String) getAttrVal("Des_pathgy"));
	}	
	public void setDes_pathgy(String Des_pathgy) {
		setAttrVal("Des_pathgy", Des_pathgy);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getSd_insmt() {
		return ((String) getAttrVal("Sd_insmt"));
	}	
	public void setSd_insmt(String Sd_insmt) {
		setAttrVal("Sd_insmt", Sd_insmt);
	}
	public String getId_su_rpt() {
		return ((String) getAttrVal("Id_su_rpt"));
	}	
	public void setId_su_rpt(String Id_su_rpt) {
		setAttrVal("Id_su_rpt", Id_su_rpt);
	}
	public String getSd_su_rpt() {
		return ((String) getAttrVal("Sd_su_rpt"));
	}	
	public void setSd_su_rpt(String Sd_su_rpt) {
		setAttrVal("Sd_su_rpt", Sd_su_rpt);
	}
	public FDateTime getDt_rptpathgy() {
		return ((FDateTime) getAttrVal("Dt_rptpathgy"));
	}	
	public void setDt_rptpathgy(FDateTime Dt_rptpathgy) {
		setAttrVal("Dt_rptpathgy", Dt_rptpathgy);
	}
	public String getId_emp_rpt() {
		return ((String) getAttrVal("Id_emp_rpt"));
	}	
	public void setId_emp_rpt(String Id_emp_rpt) {
		setAttrVal("Id_emp_rpt", Id_emp_rpt);
	}
	public String getId_dep_rpt() {
		return ((String) getAttrVal("Id_dep_rpt"));
	}	
	public void setId_dep_rpt(String Id_dep_rpt) {
		setAttrVal("Id_dep_rpt", Id_dep_rpt);
	}
	public String getUrl_img() {
		return ((String) getAttrVal("Url_img"));
	}	
	public void setUrl_img(String Url_img) {
		setAttrVal("Url_img", Url_img);
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
	public String getApplyformno() {
		return ((String) getAttrVal("Applyformno"));
	}	
	public void setApplyformno(String Applyformno) {
		setAttrVal("Applyformno", Applyformno);
	}
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}	
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	public String getPsn_name() {
		return ((String) getAttrVal("Psn_name"));
	}	
	public void setPsn_name(String Psn_name) {
		setAttrVal("Psn_name", Psn_name);
	}
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}	
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getSu_name() {
		return ((String) getAttrVal("Su_name"));
	}	
	public void setSu_name(String Su_name) {
		setAttrVal("Su_name", Su_name);
	}
	public String getRpt_name() {
		return ((String) getAttrVal("Rpt_name"));
	}	
	public void setRpt_name(String Rpt_name) {
		setAttrVal("Rpt_name", Rpt_name);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
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
		return "Id_rptpathgy";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rpt_pathgy";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRptPathgyDesc.class);
	}
	
}
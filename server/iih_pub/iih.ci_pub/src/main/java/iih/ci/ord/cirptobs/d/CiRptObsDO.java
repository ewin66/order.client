package iih.ci.ord.cirptobs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cirptobs.d.desc.CiRptObsDODesc;
import java.math.BigDecimal;

/**
 * 检查报告单 DO数据 
 * 
 */
public class CiRptObsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTOBS= "Id_rptobs";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String ID_OROBS= "Id_orobs";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_OR= "Id_or";
	public static final String NO_RPTOBS= "No_rptobs";
	public static final String DES_RPTOBS= "Des_rptobs";
	public static final String DES_ADVICE= "Des_advice";
	public static final String DES_OBS= "Des_obs";
	public static final String ID_INSMT= "Id_insmt";
	public static final String SD_INSMT= "Sd_insmt";
	public static final String ID_SU= "Id_su";
	public static final String SD_SU= "Sd_su";
	public static final String DT_RPTOBS= "Dt_rptobs";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_DEP= "Id_dep";
	public static final String IMAGE_URL= "Image_url";
	public static final String APPLYFORMNO= "Applyformno";
	public static final String NAME_PAT= "Name_pat";
	public static final String ENT_CODE= "Ent_code";
	public static final String SU_NAME= "Su_name";
	public static final String RPT_NAME= "Rpt_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptobs() {
		return ((String) getAttrVal("Id_rptobs"));
	}	
	public void setId_rptobs(String Id_rptobs) {
		setAttrVal("Id_rptobs", Id_rptobs);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public String getId_orobs() {
		return ((String) getAttrVal("Id_orobs"));
	}	
	public void setId_orobs(String Id_orobs) {
		setAttrVal("Id_orobs", Id_orobs);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getNo_rptobs() {
		return ((String) getAttrVal("No_rptobs"));
	}	
	public void setNo_rptobs(String No_rptobs) {
		setAttrVal("No_rptobs", No_rptobs);
	}
	public String getDes_rptobs() {
		return ((String) getAttrVal("Des_rptobs"));
	}	
	public void setDes_rptobs(String Des_rptobs) {
		setAttrVal("Des_rptobs", Des_rptobs);
	}
	public String getDes_advice() {
		return ((String) getAttrVal("Des_advice"));
	}	
	public void setDes_advice(String Des_advice) {
		setAttrVal("Des_advice", Des_advice);
	}
	public String getDes_obs() {
		return ((String) getAttrVal("Des_obs"));
	}	
	public void setDes_obs(String Des_obs) {
		setAttrVal("Des_obs", Des_obs);
	}
	public String getId_insmt() {
		return ((String) getAttrVal("Id_insmt"));
	}	
	public void setId_insmt(String Id_insmt) {
		setAttrVal("Id_insmt", Id_insmt);
	}
	public String getSd_insmt() {
		return ((String) getAttrVal("Sd_insmt"));
	}	
	public void setSd_insmt(String Sd_insmt) {
		setAttrVal("Sd_insmt", Sd_insmt);
	}
	public String getId_su() {
		return ((String) getAttrVal("Id_su"));
	}	
	public void setId_su(String Id_su) {
		setAttrVal("Id_su", Id_su);
	}
	public String getSd_su() {
		return ((String) getAttrVal("Sd_su"));
	}	
	public void setSd_su(String Sd_su) {
		setAttrVal("Sd_su", Sd_su);
	}
	public FDateTime getDt_rptobs() {
		return ((FDateTime) getAttrVal("Dt_rptobs"));
	}	
	public void setDt_rptobs(FDateTime Dt_rptobs) {
		setAttrVal("Dt_rptobs", Dt_rptobs);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getImage_url() {
		return ((String) getAttrVal("Image_url"));
	}	
	public void setImage_url(String Image_url) {
		setAttrVal("Image_url", Image_url);
	}
	public String getApplyformno() {
		return ((String) getAttrVal("Applyformno"));
	}	
	public void setApplyformno(String Applyformno) {
		setAttrVal("Applyformno", Applyformno);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}	
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
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
		return "Id_rptobs";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_RPT_OBS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRptObsDODesc.class);
	}
	
}
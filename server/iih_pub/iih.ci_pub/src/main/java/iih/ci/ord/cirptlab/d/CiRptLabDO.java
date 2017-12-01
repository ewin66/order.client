package iih.ci.ord.cirptlab.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cirptlab.d.desc.CiRptLabDODesc;
import java.math.BigDecimal;

/**
 * 检验报告单 DO数据 
 * 
 */
public class CiRptLabDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTLAB= "Id_rptlab";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String ID_ORLAB= "Id_orlab";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_OR= "Id_or";
	public static final String NO_RPTLAB= "No_rptlab";
	public static final String ID_RPTTP= "Id_rpttp";
	public static final String SD_RPTTP= "Sd_rpttp";
	public static final String ID_SU_LAB= "Id_su_lab";
	public static final String SD_SU_LAB= "Sd_su_lab";
	public static final String SD_INSMT= "Sd_insmt";
	public static final String ID_INSMT= "Id_insmt";
	public static final String ID_DEP= "Id_dep";
	public static final String DT_RPTLAB= "Dt_rptlab";
	public static final String ID_EMP= "Id_emp";
	public static final String APPLYFORMNO= "Applyformno";
	public static final String ENT_CODE= "Ent_code";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_RPTTP= "Name_rpttp";
	public static final String RPT_NAME= "Rpt_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptlab() {
		return ((String) getAttrVal("Id_rptlab"));
	}	
	public void setId_rptlab(String Id_rptlab) {
		setAttrVal("Id_rptlab", Id_rptlab);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public String getId_orlab() {
		return ((String) getAttrVal("Id_orlab"));
	}	
	public void setId_orlab(String Id_orlab) {
		setAttrVal("Id_orlab", Id_orlab);
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
	public String getNo_rptlab() {
		return ((String) getAttrVal("No_rptlab"));
	}	
	public void setNo_rptlab(String No_rptlab) {
		setAttrVal("No_rptlab", No_rptlab);
	}
	public String getId_rpttp() {
		return ((String) getAttrVal("Id_rpttp"));
	}	
	public void setId_rpttp(String Id_rpttp) {
		setAttrVal("Id_rpttp", Id_rpttp);
	}
	public String getSd_rpttp() {
		return ((String) getAttrVal("Sd_rpttp"));
	}	
	public void setSd_rpttp(String Sd_rpttp) {
		setAttrVal("Sd_rpttp", Sd_rpttp);
	}
	public String getId_su_lab() {
		return ((String) getAttrVal("Id_su_lab"));
	}	
	public void setId_su_lab(String Id_su_lab) {
		setAttrVal("Id_su_lab", Id_su_lab);
	}
	public String getSd_su_lab() {
		return ((String) getAttrVal("Sd_su_lab"));
	}	
	public void setSd_su_lab(String Sd_su_lab) {
		setAttrVal("Sd_su_lab", Sd_su_lab);
	}
	public String getSd_insmt() {
		return ((String) getAttrVal("Sd_insmt"));
	}	
	public void setSd_insmt(String Sd_insmt) {
		setAttrVal("Sd_insmt", Sd_insmt);
	}
	public String getId_insmt() {
		return ((String) getAttrVal("Id_insmt"));
	}	
	public void setId_insmt(String Id_insmt) {
		setAttrVal("Id_insmt", Id_insmt);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FDateTime getDt_rptlab() {
		return ((FDateTime) getAttrVal("Dt_rptlab"));
	}	
	public void setDt_rptlab(FDateTime Dt_rptlab) {
		setAttrVal("Dt_rptlab", Dt_rptlab);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getApplyformno() {
		return ((String) getAttrVal("Applyformno"));
	}	
	public void setApplyformno(String Applyformno) {
		setAttrVal("Applyformno", Applyformno);
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
	public String getName_rpttp() {
		return ((String) getAttrVal("Name_rpttp"));
	}	
	public void setName_rpttp(String Name_rpttp) {
		setAttrVal("Name_rpttp", Name_rpttp);
	}
	public String getRpt_name() {
		return ((String) getAttrVal("Rpt_name"));
	}	
	public void setRpt_name(String Rpt_name) {
		setAttrVal("Rpt_name", Rpt_name);
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
		return "Id_rptlab";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_RPT_LAB";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRptLabDODesc.class);
	}
	
}
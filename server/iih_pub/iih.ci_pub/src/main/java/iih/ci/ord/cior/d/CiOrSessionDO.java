package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.CiOrSessionDODesc;
import java.math.BigDecimal;

/**
 * 门诊医嘱开立区间 DO数据 
 * 
 */
public class CiOrSessionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIORSESSION= "Id_ciorsession";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_EN= "Id_en";
	public static final String ID_ORG_SIGN= "Id_org_sign";
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	public static final String ID_DEP_SIGN= "Id_dep_sign";
	public static final String DT_SIGN= "Dt_sign";
	public static final String FG_SIGNCANC= "Fg_signcanc";
	public static final String DT_SIGNCANC= "Dt_signcanc";
	public static final String ID_DEP_SIGNCANC= "Id_dep_signcanc";
	public static final String ID_EMP_SIGNCANC= "Id_emp_signcanc";
	public static final String ID_ORS= "Id_ors";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciorsession() {
		return ((String) getAttrVal("Id_ciorsession"));
	}	
	public void setId_ciorsession(String Id_ciorsession) {
		setAttrVal("Id_ciorsession", Id_ciorsession);
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
	public String getId_org_sign() {
		return ((String) getAttrVal("Id_org_sign"));
	}	
	public void setId_org_sign(String Id_org_sign) {
		setAttrVal("Id_org_sign", Id_org_sign);
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
	public FBoolean getFg_signcanc() {
		return ((FBoolean) getAttrVal("Fg_signcanc"));
	}	
	public void setFg_signcanc(FBoolean Fg_signcanc) {
		setAttrVal("Fg_signcanc", Fg_signcanc);
	}
	public FDateTime getDt_signcanc() {
		return ((FDateTime) getAttrVal("Dt_signcanc"));
	}	
	public void setDt_signcanc(FDateTime Dt_signcanc) {
		setAttrVal("Dt_signcanc", Dt_signcanc);
	}
	public String getId_dep_signcanc() {
		return ((String) getAttrVal("Id_dep_signcanc"));
	}	
	public void setId_dep_signcanc(String Id_dep_signcanc) {
		setAttrVal("Id_dep_signcanc", Id_dep_signcanc);
	}
	public String getId_emp_signcanc() {
		return ((String) getAttrVal("Id_emp_signcanc"));
	}	
	public void setId_emp_signcanc(String Id_emp_signcanc) {
		setAttrVal("Id_emp_signcanc", Id_emp_signcanc);
	}
	public String getId_ors() {
		return ((String) getAttrVal("Id_ors"));
	}	
	public void setId_ors(String Id_ors) {
		setAttrVal("Id_ors", Id_ors);
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
		return "Id_ciorsession";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_session";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrSessionDODesc.class);
	}
	
}
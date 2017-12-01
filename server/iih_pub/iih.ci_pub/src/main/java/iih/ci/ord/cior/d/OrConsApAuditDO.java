package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrConsApAuditDODesc;
import java.math.BigDecimal;

/**
 * 会诊审批记录 DO数据 
 * 
 */
public class OrConsApAuditDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REVIEWCONS= "Id_reviewcons";
	public static final String ID_APCONS= "Id_apcons";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_DEP= "Id_dep";
	public static final String DT_REVIEW= "Dt_review";
	public static final String DES_REVIEW= "Des_review";
	public static final String FG_AUDIT= "Fg_audit";
	public static final String RESULT= "Result";
	public static final String NAME_EMP= "Name_emp";
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_reviewcons() {
		return ((String) getAttrVal("Id_reviewcons"));
	}	
	public void setId_reviewcons(String Id_reviewcons) {
		setAttrVal("Id_reviewcons", Id_reviewcons);
	}
	public String getId_apcons() {
		return ((String) getAttrVal("Id_apcons"));
	}	
	public void setId_apcons(String Id_apcons) {
		setAttrVal("Id_apcons", Id_apcons);
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
	public FDateTime getDt_review() {
		return ((FDateTime) getAttrVal("Dt_review"));
	}	
	public void setDt_review(FDateTime Dt_review) {
		setAttrVal("Dt_review", Dt_review);
	}
	public String getDes_review() {
		return ((String) getAttrVal("Des_review"));
	}	
	public void setDes_review(String Des_review) {
		setAttrVal("Des_review", Des_review);
	}
	public FBoolean getFg_audit() {
		return ((FBoolean) getAttrVal("Fg_audit"));
	}	
	public void setFg_audit(FBoolean Fg_audit) {
		setAttrVal("Fg_audit", Fg_audit);
	}
	public String getResult() {
		return ((String) getAttrVal("Result"));
	}	
	public void setResult(String Result) {
		setAttrVal("Result", Result);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_reviewcons";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_review_cons";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrConsApAuditDODesc.class);
	}
	
}
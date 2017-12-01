package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.CiOrSeesionDODesc;
import java.math.BigDecimal;

/**
 * 实体 DO数据 
 * 
 */
public class CiOrSeesionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIORSESSION= "Id_ciorsession";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_EN= "Id_en";
	public static final String ID_ORG_CREATE= "Id_org_create";
	public static final String ID_EMP_CREATE= "Id_emp_create";
	public static final String ID_DEP_CREATE= "Id_dep_create";
	public static final String ID_WG_CREATE= "Id_wg_create";
	public static final String DT_CREATE= "Dt_create";
	public static final String FG_CANC= "Fg_canc";
	public static final String DT_CANC= "Dt_canc";
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
	public String getId_org_create() {
		return ((String) getAttrVal("Id_org_create"));
	}	
	public void setId_org_create(String Id_org_create) {
		setAttrVal("Id_org_create", Id_org_create);
	}
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}	
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	public String getId_dep_create() {
		return ((String) getAttrVal("Id_dep_create"));
	}	
	public void setId_dep_create(String Id_dep_create) {
		setAttrVal("Id_dep_create", Id_dep_create);
	}
	public String getId_wg_create() {
		return ((String) getAttrVal("Id_wg_create"));
	}	
	public void setId_wg_create(String Id_wg_create) {
		setAttrVal("Id_wg_create", Id_wg_create);
	}
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
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
		return "CI_OR_SESSION";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrSeesionDODesc.class);
	}
	
}
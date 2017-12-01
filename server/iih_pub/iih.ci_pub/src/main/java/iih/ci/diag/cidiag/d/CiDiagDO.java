package iih.ci.diag.cidiag.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.diag.cidiag.d.desc.CiDiagDODesc;
import java.math.BigDecimal;

/**
 * 临床诊断 DO数据 
 * 
 */
public class CiDiagDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DI= "Id_di";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_EN= "Id_en";
	public static final String ID_DITP= "Id_ditp";
	public static final String SD_DITP= "Sd_ditp";
	public static final String DES_DI= "Des_di";
	public static final String DT_DI= "Dt_di";
	public static final String ID_DEP= "Id_dep";
	public static final String FG_SIGN= "Fg_sign";
	public static final String DT_SIGN= "Dt_sign";
	public static final String ID_DEP_SIGN= "Id_dep_sign";
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	public static final String ID_EMP_CREATE= "Id_emp_create";
	public static final String ID_DEP_CREATE= "Id_dep_create";
	public static final String DT_CREATE= "Dt_create";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME= "Name";
	public static final String CODE_DITP= "Code_ditp";
	public static final String NAME_DITP= "Name_ditp";
	public static final String NAME_DEP_SIGN= "Name_dep_sign";
	public static final String SIGNNAME= "Signname";
	public static final String SIGNCODE= "Signcode";
	public static final String EMPCODE= "Empcode";
	public static final String EMPNAME= "Empname";
	public static final String CODE_DEP_CREATE= "Code_dep_create";
	public static final String NAME_DEP_CREATE= "Name_dep_create";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
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
	public String getId_ditp() {
		return ((String) getAttrVal("Id_ditp"));
	}	
	public void setId_ditp(String Id_ditp) {
		setAttrVal("Id_ditp", Id_ditp);
	}
	public String getSd_ditp() {
		return ((String) getAttrVal("Sd_ditp"));
	}	
	public void setSd_ditp(String Sd_ditp) {
		setAttrVal("Sd_ditp", Sd_ditp);
	}
	public String getDes_di() {
		return ((String) getAttrVal("Des_di"));
	}	
	public void setDes_di(String Des_di) {
		setAttrVal("Des_di", Des_di);
	}
	public FDateTime getDt_di() {
		return ((FDateTime) getAttrVal("Dt_di"));
	}	
	public void setDt_di(FDateTime Dt_di) {
		setAttrVal("Dt_di", Dt_di);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}	
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}	
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
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
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode_ditp() {
		return ((String) getAttrVal("Code_ditp"));
	}	
	public void setCode_ditp(String Code_ditp) {
		setAttrVal("Code_ditp", Code_ditp);
	}
	public String getName_ditp() {
		return ((String) getAttrVal("Name_ditp"));
	}	
	public void setName_ditp(String Name_ditp) {
		setAttrVal("Name_ditp", Name_ditp);
	}
	public String getName_dep_sign() {
		return ((String) getAttrVal("Name_dep_sign"));
	}	
	public void setName_dep_sign(String Name_dep_sign) {
		setAttrVal("Name_dep_sign", Name_dep_sign);
	}
	public String getSignname() {
		return ((String) getAttrVal("Signname"));
	}	
	public void setSignname(String Signname) {
		setAttrVal("Signname", Signname);
	}
	public String getSigncode() {
		return ((String) getAttrVal("Signcode"));
	}	
	public void setSigncode(String Signcode) {
		setAttrVal("Signcode", Signcode);
	}
	public String getEmpcode() {
		return ((String) getAttrVal("Empcode"));
	}	
	public void setEmpcode(String Empcode) {
		setAttrVal("Empcode", Empcode);
	}
	public String getEmpname() {
		return ((String) getAttrVal("Empname"));
	}	
	public void setEmpname(String Empname) {
		setAttrVal("Empname", Empname);
	}
	public String getCode_dep_create() {
		return ((String) getAttrVal("Code_dep_create"));
	}	
	public void setCode_dep_create(String Code_dep_create) {
		setAttrVal("Code_dep_create", Code_dep_create);
	}
	public String getName_dep_create() {
		return ((String) getAttrVal("Name_dep_create"));
	}	
	public void setName_dep_create(String Name_dep_create) {
		setAttrVal("Name_dep_create", Name_dep_create);
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
		return "Id_di";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_di";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiDiagDODesc.class);
	}
	
}
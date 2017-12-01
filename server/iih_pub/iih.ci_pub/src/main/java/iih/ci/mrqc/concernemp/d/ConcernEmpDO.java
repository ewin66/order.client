package iih.ci.mrqc.concernemp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.concernemp.d.desc.ConcernEmpDODesc;
import java.math.BigDecimal;

/**
 * 门诊质控人员关注 DO数据 
 * 
 */
public class ConcernEmpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CON_EMP= "Id_con_emp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_CONED_EMP= "Id_coned_emp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CONED_EMP_NAME= "Coned_emp_name";
	public static final String CONED_EMP_CODE= "Coned_emp_code";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_con_emp() {
		return ((String) getAttrVal("Id_con_emp"));
	}	
	public void setId_con_emp(String Id_con_emp) {
		setAttrVal("Id_con_emp", Id_con_emp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_coned_emp() {
		return ((String) getAttrVal("Id_coned_emp"));
	}	
	public void setId_coned_emp(String Id_coned_emp) {
		setAttrVal("Id_coned_emp", Id_coned_emp);
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
	public String getConed_emp_name() {
		return ((String) getAttrVal("Coned_emp_name"));
	}	
	public void setConed_emp_name(String Coned_emp_name) {
		setAttrVal("Coned_emp_name", Coned_emp_name);
	}
	public String getConed_emp_code() {
		return ((String) getAttrVal("Coned_emp_code"));
	}	
	public void setConed_emp_code(String Coned_emp_code) {
		setAttrVal("Coned_emp_code", Coned_emp_code);
	}
	public String getCreateby_name() {
		return ((String) getAttrVal("Createby_name"));
	}	
	public void setCreateby_name(String Createby_name) {
		setAttrVal("Createby_name", Createby_name);
	}
	public String getCreateby_code() {
		return ((String) getAttrVal("Createby_code"));
	}	
	public void setCreateby_code(String Createby_code) {
		setAttrVal("Createby_code", Createby_code);
	}
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
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
		return "Id_con_emp";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_AMR_CON_EMP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ConcernEmpDODesc.class);
	}
	
}
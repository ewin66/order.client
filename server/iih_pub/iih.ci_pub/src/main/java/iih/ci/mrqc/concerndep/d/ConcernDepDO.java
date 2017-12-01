package iih.ci.mrqc.concerndep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.concerndep.d.desc.ConcernDepDODesc;
import java.math.BigDecimal;

/**
 * 门诊质控科室关注 DO数据 
 * 
 */
public class ConcernDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CON_DEPT= "Id_con_dept";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_CONED_DEPT= "Id_coned_dept";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CONED_DEPT_CODE= "Coned_dept_code";
	public static final String CONED_DEPT_NAME= "Coned_dept_name";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_con_dept() {
		return ((String) getAttrVal("Id_con_dept"));
	}	
	public void setId_con_dept(String Id_con_dept) {
		setAttrVal("Id_con_dept", Id_con_dept);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_coned_dept() {
		return ((String) getAttrVal("Id_coned_dept"));
	}	
	public void setId_coned_dept(String Id_coned_dept) {
		setAttrVal("Id_coned_dept", Id_coned_dept);
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
	public String getConed_dept_code() {
		return ((String) getAttrVal("Coned_dept_code"));
	}	
	public void setConed_dept_code(String Coned_dept_code) {
		setAttrVal("Coned_dept_code", Coned_dept_code);
	}
	public String getConed_dept_name() {
		return ((String) getAttrVal("Coned_dept_name"));
	}	
	public void setConed_dept_name(String Coned_dept_name) {
		setAttrVal("Coned_dept_name", Coned_dept_name);
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
		return "Id_con_dept";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_ARM_CON_DEPT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ConcernDepDODesc.class);
	}
	
}
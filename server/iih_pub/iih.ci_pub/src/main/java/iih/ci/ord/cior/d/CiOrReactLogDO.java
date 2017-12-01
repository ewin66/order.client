package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.CiOrReactLogDODesc;
import java.math.BigDecimal;

/**
 * 医嘱互斥日志记录 DO数据 
 * 
 */
public class CiOrReactLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIORREACTLOG= "Id_ciorreactlog";
	public static final String ID_OR= "Id_or";
	public static final String ID_OR_REACT= "Id_or_react";
	public static final String ID_REACTTP= "Id_reacttp";
	public static final String SD_REACTTP= "Sd_reacttp";
	public static final String DT_REACT= "Dt_react";
	public static final String ID_DEP_REACT= "Id_dep_react";
	public static final String ID_EMP_REACT= "Id_emp_react";
	public static final String DT_END_ORREACT= "Dt_end_orreact";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciorreactlog() {
		return ((String) getAttrVal("Id_ciorreactlog"));
	}	
	public void setId_ciorreactlog(String Id_ciorreactlog) {
		setAttrVal("Id_ciorreactlog", Id_ciorreactlog);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_or_react() {
		return ((String) getAttrVal("Id_or_react"));
	}	
	public void setId_or_react(String Id_or_react) {
		setAttrVal("Id_or_react", Id_or_react);
	}
	public String getId_reacttp() {
		return ((String) getAttrVal("Id_reacttp"));
	}	
	public void setId_reacttp(String Id_reacttp) {
		setAttrVal("Id_reacttp", Id_reacttp);
	}
	public String getSd_reacttp() {
		return ((String) getAttrVal("Sd_reacttp"));
	}	
	public void setSd_reacttp(String Sd_reacttp) {
		setAttrVal("Sd_reacttp", Sd_reacttp);
	}
	public FDateTime getDt_react() {
		return ((FDateTime) getAttrVal("Dt_react"));
	}	
	public void setDt_react(FDateTime Dt_react) {
		setAttrVal("Dt_react", Dt_react);
	}
	public String getId_dep_react() {
		return ((String) getAttrVal("Id_dep_react"));
	}	
	public void setId_dep_react(String Id_dep_react) {
		setAttrVal("Id_dep_react", Id_dep_react);
	}
	public String getId_emp_react() {
		return ((String) getAttrVal("Id_emp_react"));
	}	
	public void setId_emp_react(String Id_emp_react) {
		setAttrVal("Id_emp_react", Id_emp_react);
	}
	public FDateTime getDt_end_orreact() {
		return ((FDateTime) getAttrVal("Dt_end_orreact"));
	}	
	public void setDt_end_orreact(FDateTime Dt_end_orreact) {
		setAttrVal("Dt_end_orreact", Dt_end_orreact);
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
		return "Id_ciorreactlog";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_react_log";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrReactLogDODesc.class);
	}
	
}
package iih.ci.ord.skintest.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.skintest.d.desc.CiSkinTestRstDODesc;
import java.math.BigDecimal;

/**
 * 皮试结果记录 DO数据 
 * 
 */
public class CiSkinTestRstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SKINTEST= "Id_skintest";
	public static final String ID_OR= "Id_or";
	public static final String ID_RST_SKINTEST= "Id_rst_skintest";
	public static final String SD_RST_SKINTEST= "Sd_rst_skintest";
	public static final String ID_EMP_CREATE= "Id_emp_create";
	public static final String DT_CREATE= "Dt_create";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SKINRES_NAME= "Skinres_name";
	public static final String SKINRES_CODE= "Skinres_code";
	public static final String ID_UDIDOCLIST= "Id_udidoclist";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_skintest() {
		return ((String) getAttrVal("Id_skintest"));
	}	
	public void setId_skintest(String Id_skintest) {
		setAttrVal("Id_skintest", Id_skintest);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_rst_skintest() {
		return ((String) getAttrVal("Id_rst_skintest"));
	}	
	public void setId_rst_skintest(String Id_rst_skintest) {
		setAttrVal("Id_rst_skintest", Id_rst_skintest);
	}
	public String getSd_rst_skintest() {
		return ((String) getAttrVal("Sd_rst_skintest"));
	}	
	public void setSd_rst_skintest(String Sd_rst_skintest) {
		setAttrVal("Sd_rst_skintest", Sd_rst_skintest);
	}
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}	
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
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
	public String getSkinres_name() {
		return ((String) getAttrVal("Skinres_name"));
	}	
	public void setSkinres_name(String Skinres_name) {
		setAttrVal("Skinres_name", Skinres_name);
	}
	public String getSkinres_code() {
		return ((String) getAttrVal("Skinres_code"));
	}	
	public void setSkinres_code(String Skinres_code) {
		setAttrVal("Skinres_code", Skinres_code);
	}
	public String getId_udidoclist() {
		return ((String) getAttrVal("Id_udidoclist"));
	}	
	public void setId_udidoclist(String Id_udidoclist) {
		setAttrVal("Id_udidoclist", Id_udidoclist);
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
		return "Id_skintest";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_skin_test";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiSkinTestRstDODesc.class);
	}
	
}
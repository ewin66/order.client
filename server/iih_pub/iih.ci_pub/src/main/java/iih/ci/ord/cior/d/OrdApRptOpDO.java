package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApRptOpDODesc;
import java.math.BigDecimal;

/**
 * 手术记录 DO数据 
 * 
 */
public class OrdApRptOpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTSUG= "Id_rptsug";
	public static final String ID_OROP= "Id_orop";
	public static final String ID_OR= "Id_or";
	public static final String DT_B_ACTUAL= "Dt_b_actual";
	public static final String DT_E_ACTUAL= "Dt_e_actual";
	public static final String ID_DEP_ACTUAL= "Id_dep_actual";
	public static final String FG_SUCCESS= "Fg_success";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptsug() {
		return ((String) getAttrVal("Id_rptsug"));
	}	
	public void setId_rptsug(String Id_rptsug) {
		setAttrVal("Id_rptsug", Id_rptsug);
	}
	public String getId_orop() {
		return ((String) getAttrVal("Id_orop"));
	}	
	public void setId_orop(String Id_orop) {
		setAttrVal("Id_orop", Id_orop);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public FDateTime getDt_b_actual() {
		return ((FDateTime) getAttrVal("Dt_b_actual"));
	}	
	public void setDt_b_actual(FDateTime Dt_b_actual) {
		setAttrVal("Dt_b_actual", Dt_b_actual);
	}
	public FDateTime getDt_e_actual() {
		return ((FDateTime) getAttrVal("Dt_e_actual"));
	}	
	public void setDt_e_actual(FDateTime Dt_e_actual) {
		setAttrVal("Dt_e_actual", Dt_e_actual);
	}
	public String getId_dep_actual() {
		return ((String) getAttrVal("Id_dep_actual"));
	}	
	public void setId_dep_actual(String Id_dep_actual) {
		setAttrVal("Id_dep_actual", Id_dep_actual);
	}
	public FBoolean getFg_success() {
		return ((FBoolean) getAttrVal("Fg_success"));
	}	
	public void setFg_success(FBoolean Fg_success) {
		setAttrVal("Fg_success", Fg_success);
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
		return "Id_rptsug";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rpt_sug";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApRptOpDODesc.class);
	}
	
}
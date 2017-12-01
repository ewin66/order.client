package iih.ci.ord.consrpt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.consrpt.d.desc.CiOrdConsRptDODesc;
import java.math.BigDecimal;

/**
 * 会诊记录单 DO数据 
 * 
 */
public class CiOrdConsRptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTCONS= "Id_rptcons";
	public static final String ID_APCONS= "Id_apcons";
	public static final String DT_ACTUAL= "Dt_actual";
	public static final String ADVICE= "Advice";
	public static final String ID_EMP_RPT= "Id_emp_rpt";
	public static final String ID_DEP_RPT= "Id_dep_rpt";
	public static final String DT_RPT= "Dt_rpt";
	public static final String ID_EMP_HOST= "Id_emp_host";
	public static final String ID_PLACE_ACTUAL= "Id_place_actual";
	public static final String SD_SU_RPT= "Sd_su_rpt";
	public static final String ID_SU_RPT= "Id_su_rpt";
	public static final String NAME_PLACE= "Name_place";
	public static final String NAME_EMP_RPT= "Name_emp_rpt";
	public static final String NAME_DEP_RPT= "Name_dep_rpt";
	public static final String NAME_EMP_HOST= "Name_emp_host";
	public static final String NAME_PLACE_ACTUAL= "Name_place_actual";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptcons() {
		return ((String) getAttrVal("Id_rptcons"));
	}	
	public void setId_rptcons(String Id_rptcons) {
		setAttrVal("Id_rptcons", Id_rptcons);
	}
	public String getId_apcons() {
		return ((String) getAttrVal("Id_apcons"));
	}	
	public void setId_apcons(String Id_apcons) {
		setAttrVal("Id_apcons", Id_apcons);
	}
	public FDateTime getDt_actual() {
		return ((FDateTime) getAttrVal("Dt_actual"));
	}	
	public void setDt_actual(FDateTime Dt_actual) {
		setAttrVal("Dt_actual", Dt_actual);
	}
	public String getAdvice() {
		return ((String) getAttrVal("Advice"));
	}	
	public void setAdvice(String Advice) {
		setAttrVal("Advice", Advice);
	}
	public String getId_emp_rpt() {
		return ((String) getAttrVal("Id_emp_rpt"));
	}	
	public void setId_emp_rpt(String Id_emp_rpt) {
		setAttrVal("Id_emp_rpt", Id_emp_rpt);
	}
	public String getId_dep_rpt() {
		return ((String) getAttrVal("Id_dep_rpt"));
	}	
	public void setId_dep_rpt(String Id_dep_rpt) {
		setAttrVal("Id_dep_rpt", Id_dep_rpt);
	}
	public FDateTime getDt_rpt() {
		return ((FDateTime) getAttrVal("Dt_rpt"));
	}	
	public void setDt_rpt(FDateTime Dt_rpt) {
		setAttrVal("Dt_rpt", Dt_rpt);
	}
	public String getId_emp_host() {
		return ((String) getAttrVal("Id_emp_host"));
	}	
	public void setId_emp_host(String Id_emp_host) {
		setAttrVal("Id_emp_host", Id_emp_host);
	}
	public String getId_place_actual() {
		return ((String) getAttrVal("Id_place_actual"));
	}	
	public void setId_place_actual(String Id_place_actual) {
		setAttrVal("Id_place_actual", Id_place_actual);
	}
	public String getSd_su_rpt() {
		return ((String) getAttrVal("Sd_su_rpt"));
	}	
	public void setSd_su_rpt(String Sd_su_rpt) {
		setAttrVal("Sd_su_rpt", Sd_su_rpt);
	}
	public String getId_su_rpt() {
		return ((String) getAttrVal("Id_su_rpt"));
	}	
	public void setId_su_rpt(String Id_su_rpt) {
		setAttrVal("Id_su_rpt", Id_su_rpt);
	}
	public String getName_place() {
		return ((String) getAttrVal("Name_place"));
	}	
	public void setName_place(String Name_place) {
		setAttrVal("Name_place", Name_place);
	}
	public String getName_emp_rpt() {
		return ((String) getAttrVal("Name_emp_rpt"));
	}	
	public void setName_emp_rpt(String Name_emp_rpt) {
		setAttrVal("Name_emp_rpt", Name_emp_rpt);
	}
	public String getName_dep_rpt() {
		return ((String) getAttrVal("Name_dep_rpt"));
	}	
	public void setName_dep_rpt(String Name_dep_rpt) {
		setAttrVal("Name_dep_rpt", Name_dep_rpt);
	}
	public String getName_emp_host() {
		return ((String) getAttrVal("Name_emp_host"));
	}	
	public void setName_emp_host(String Name_emp_host) {
		setAttrVal("Name_emp_host", Name_emp_host);
	}
	public String getName_place_actual() {
		return ((String) getAttrVal("Name_place_actual"));
	}	
	public void setName_place_actual(String Name_place_actual) {
		setAttrVal("Name_place_actual", Name_place_actual);
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
		return "Id_rptcons";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rpt_cons";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrdConsRptDODesc.class);
	}
	
}
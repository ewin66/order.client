package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.RptOpEmpDODesc;
import java.math.BigDecimal;

/**
 * 手术人员 DO数据 
 * 
 */
public class RptOpEmpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTSUGEMP= "Id_rptsugemp";
	public static final String ID_RPTSUG= "Id_rptsug";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_ROLE= "Id_role";
	public static final String SD_ROLE= "Sd_role";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptsugemp() {
		return ((String) getAttrVal("Id_rptsugemp"));
	}	
	public void setId_rptsugemp(String Id_rptsugemp) {
		setAttrVal("Id_rptsugemp", Id_rptsugemp);
	}
	public String getId_rptsug() {
		return ((String) getAttrVal("Id_rptsug"));
	}	
	public void setId_rptsug(String Id_rptsug) {
		setAttrVal("Id_rptsug", Id_rptsug);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getId_role() {
		return ((String) getAttrVal("Id_role"));
	}	
	public void setId_role(String Id_role) {
		setAttrVal("Id_role", Id_role);
	}
	public String getSd_role() {
		return ((String) getAttrVal("Sd_role"));
	}	
	public void setSd_role(String Sd_role) {
		setAttrVal("Sd_role", Sd_role);
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
		return "Id_rptsugemp";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rpt_sug_emp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RptOpEmpDODesc.class);
	}
	
}
package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdOpEmpDODesc;
import java.math.BigDecimal;

/**
 * 手术人员 DO数据 
 * 
 */
public class OrdOpEmpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APOPEMP= "Id_apopemp";
	public static final String ID_APOP= "Id_apop";
	public static final String ID_EMP= "Id_emp";
	public static final String SD_ROLE= "Sd_role";
	public static final String ID_ROLE= "Id_role";
	public static final String SORTNO= "Sortno";
	public static final String NAME_EMP= "Name_emp";
	public static final String NAME_ROLE= "Name_role";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apopemp() {
		return ((String) getAttrVal("Id_apopemp"));
	}	
	public void setId_apopemp(String Id_apopemp) {
		setAttrVal("Id_apopemp", Id_apopemp);
	}
	public String getId_apop() {
		return ((String) getAttrVal("Id_apop"));
	}	
	public void setId_apop(String Id_apop) {
		setAttrVal("Id_apop", Id_apop);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getSd_role() {
		return ((String) getAttrVal("Sd_role"));
	}	
	public void setSd_role(String Sd_role) {
		setAttrVal("Sd_role", Sd_role);
	}
	public String getId_role() {
		return ((String) getAttrVal("Id_role"));
	}	
	public void setId_role(String Id_role) {
		setAttrVal("Id_role", Id_role);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	public String getName_role() {
		return ((String) getAttrVal("Name_role"));
	}	
	public void setName_role(String Name_role) {
		setAttrVal("Name_role", Name_role);
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
		return "Id_apopemp";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_sug_emp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdOpEmpDODesc.class);
	}
	
}
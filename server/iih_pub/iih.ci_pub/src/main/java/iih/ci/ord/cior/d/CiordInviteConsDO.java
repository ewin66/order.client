package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.CiordInviteConsDODesc;
import java.math.BigDecimal;

/**
 * 会诊受邀对象 DO数据 
 * 
 */
public class CiordInviteConsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INVITECONS= "Id_invitecons";
	public static final String ID_APCONS= "Id_apcons";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String SD_EMP_TITLE= "Sd_emp_title";
	public static final String ID_EMP_TITLE= "Id_emp_title";
	public static final String FG_RESPONSE= "Fg_response";
	public static final String DT_RESPONSE= "Dt_response";
	public static final String ID_EMP_RESPONSE= "Id_emp_response";
	public static final String FG_JOIN_CONS= "Fg_join_cons";
	public static final String JUDGCONS= "Judgcons";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_EMP= "Name_emp";
	public static final String NAME_EMP_TITLE= "Name_emp_title";
	public static final String NAME_EMP_RESPON= "Name_emp_respon";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_invitecons() {
		return ((String) getAttrVal("Id_invitecons"));
	}	
	public void setId_invitecons(String Id_invitecons) {
		setAttrVal("Id_invitecons", Id_invitecons);
	}
	public String getId_apcons() {
		return ((String) getAttrVal("Id_apcons"));
	}	
	public void setId_apcons(String Id_apcons) {
		setAttrVal("Id_apcons", Id_apcons);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getSd_emp_title() {
		return ((String) getAttrVal("Sd_emp_title"));
	}	
	public void setSd_emp_title(String Sd_emp_title) {
		setAttrVal("Sd_emp_title", Sd_emp_title);
	}
	public String getId_emp_title() {
		return ((String) getAttrVal("Id_emp_title"));
	}	
	public void setId_emp_title(String Id_emp_title) {
		setAttrVal("Id_emp_title", Id_emp_title);
	}
	public FBoolean getFg_response() {
		return ((FBoolean) getAttrVal("Fg_response"));
	}	
	public void setFg_response(FBoolean Fg_response) {
		setAttrVal("Fg_response", Fg_response);
	}
	public FDateTime getDt_response() {
		return ((FDateTime) getAttrVal("Dt_response"));
	}	
	public void setDt_response(FDateTime Dt_response) {
		setAttrVal("Dt_response", Dt_response);
	}
	public String getId_emp_response() {
		return ((String) getAttrVal("Id_emp_response"));
	}	
	public void setId_emp_response(String Id_emp_response) {
		setAttrVal("Id_emp_response", Id_emp_response);
	}
	public FBoolean getFg_join_cons() {
		return ((FBoolean) getAttrVal("Fg_join_cons"));
	}	
	public void setFg_join_cons(FBoolean Fg_join_cons) {
		setAttrVal("Fg_join_cons", Fg_join_cons);
	}
	public String getJudgcons() {
		return ((String) getAttrVal("Judgcons"));
	}	
	public void setJudgcons(String Judgcons) {
		setAttrVal("Judgcons", Judgcons);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	public String getName_emp_title() {
		return ((String) getAttrVal("Name_emp_title"));
	}	
	public void setName_emp_title(String Name_emp_title) {
		setAttrVal("Name_emp_title", Name_emp_title);
	}
	public String getName_emp_respon() {
		return ((String) getAttrVal("Name_emp_respon"));
	}	
	public void setName_emp_respon(String Name_emp_respon) {
		setAttrVal("Name_emp_respon", Name_emp_respon);
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
		return "Id_invitecons";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_invite_cons";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiordInviteConsDODesc.class);
	}
	
}
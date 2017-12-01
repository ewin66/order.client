package iih.ci.mr.cimrrs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrrs.d.desc.CiMrRsDODesc;
import java.math.BigDecimal;

/**
 * 病历封存 DO数据 
 * 
 */
public class CiMrRsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRRS= "Id_mrrs";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String FG_RS= "Fg_rs";
	public static final String RS_START_TIME= "Rs_start_time";
	public static final String RS_END_TIME= "Rs_end_time";
	public static final String SC_PAT= "Sc_pat";
	public static final String SC_HOS= "Sc_hos";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrrs() {
		return ((String) getAttrVal("Id_mrrs"));
	}	
	public void setId_mrrs(String Id_mrrs) {
		setAttrVal("Id_mrrs", Id_mrrs);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public FBoolean getFg_rs() {
		return ((FBoolean) getAttrVal("Fg_rs"));
	}	
	public void setFg_rs(FBoolean Fg_rs) {
		setAttrVal("Fg_rs", Fg_rs);
	}
	public FDateTime getRs_start_time() {
		return ((FDateTime) getAttrVal("Rs_start_time"));
	}	
	public void setRs_start_time(FDateTime Rs_start_time) {
		setAttrVal("Rs_start_time", Rs_start_time);
	}
	public FDateTime getRs_end_time() {
		return ((FDateTime) getAttrVal("Rs_end_time"));
	}	
	public void setRs_end_time(FDateTime Rs_end_time) {
		setAttrVal("Rs_end_time", Rs_end_time);
	}
	public String getSc_pat() {
		return ((String) getAttrVal("Sc_pat"));
	}	
	public void setSc_pat(String Sc_pat) {
		setAttrVal("Sc_pat", Sc_pat);
	}
	public String getSc_hos() {
		return ((String) getAttrVal("Sc_hos"));
	}	
	public void setSc_hos(String Sc_hos) {
		setAttrVal("Sc_hos", Sc_hos);
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
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
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
		return "Id_mrrs";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_rs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrRsDODesc.class);
	}
	
}
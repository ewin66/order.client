package iih.ci.mrqc.amrapply.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.amrapply.d.desc.AmrApplyDODesc;
import java.math.BigDecimal;

/**
 * 病历召回申请 DO数据 
 * 
 */
public class AmrApplyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AMR_APPLY= "Id_amr_apply";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_APPLY_STATUS= "Id_apply_status";
	public static final String SD_APPLY_STATUS= "Sd_apply_status";
	public static final String APPLY_REASON= "Apply_reason";
	public static final String ID_APPLY_USER= "Id_apply_user";
	public static final String ID_APPLY_DEP= "Id_apply_dep";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_AGREE_USER= "Id_agree_user";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DT_APPLY= "Dt_apply";
	public static final String DT_AGREE= "Dt_agree";
	public static final String ID_PAT= "Id_pat";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String APPLY_STATUS_CODE= "Apply_status_code";
	public static final String APPLY_STATUS_NAME= "Apply_status_name";
	public static final String USERAPPLY_CODE= "Userapply_code";
	public static final String USERAPPLY_NAME= "Userapply_name";
	public static final String DEP_CODE= "Dep_code";
	public static final String DEP_NAME= "Dep_name";
	public static final String EN_ID_PAT= "En_id_pat";
	public static final String USERAGREE_NAME= "Useragree_name";
	public static final String USERAGREE_CODE= "Useragree_code";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String PAT_CODE= "Pat_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_amr_apply() {
		return ((String) getAttrVal("Id_amr_apply"));
	}	
	public void setId_amr_apply(String Id_amr_apply) {
		setAttrVal("Id_amr_apply", Id_amr_apply);
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
	public String getId_apply_status() {
		return ((String) getAttrVal("Id_apply_status"));
	}	
	public void setId_apply_status(String Id_apply_status) {
		setAttrVal("Id_apply_status", Id_apply_status);
	}
	public String getSd_apply_status() {
		return ((String) getAttrVal("Sd_apply_status"));
	}	
	public void setSd_apply_status(String Sd_apply_status) {
		setAttrVal("Sd_apply_status", Sd_apply_status);
	}
	public String getApply_reason() {
		return ((String) getAttrVal("Apply_reason"));
	}	
	public void setApply_reason(String Apply_reason) {
		setAttrVal("Apply_reason", Apply_reason);
	}
	public String getId_apply_user() {
		return ((String) getAttrVal("Id_apply_user"));
	}	
	public void setId_apply_user(String Id_apply_user) {
		setAttrVal("Id_apply_user", Id_apply_user);
	}
	public String getId_apply_dep() {
		return ((String) getAttrVal("Id_apply_dep"));
	}	
	public void setId_apply_dep(String Id_apply_dep) {
		setAttrVal("Id_apply_dep", Id_apply_dep);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_agree_user() {
		return ((String) getAttrVal("Id_agree_user"));
	}	
	public void setId_agree_user(String Id_agree_user) {
		setAttrVal("Id_agree_user", Id_agree_user);
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
	public FDateTime getDt_apply() {
		return ((FDateTime) getAttrVal("Dt_apply"));
	}	
	public void setDt_apply(FDateTime Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	public FDateTime getDt_agree() {
		return ((FDateTime) getAttrVal("Dt_agree"));
	}	
	public void setDt_agree(FDateTime Dt_agree) {
		setAttrVal("Dt_agree", Dt_agree);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	public String getApply_status_code() {
		return ((String) getAttrVal("Apply_status_code"));
	}	
	public void setApply_status_code(String Apply_status_code) {
		setAttrVal("Apply_status_code", Apply_status_code);
	}
	public String getApply_status_name() {
		return ((String) getAttrVal("Apply_status_name"));
	}	
	public void setApply_status_name(String Apply_status_name) {
		setAttrVal("Apply_status_name", Apply_status_name);
	}
	public String getUserapply_code() {
		return ((String) getAttrVal("Userapply_code"));
	}	
	public void setUserapply_code(String Userapply_code) {
		setAttrVal("Userapply_code", Userapply_code);
	}
	public String getUserapply_name() {
		return ((String) getAttrVal("Userapply_name"));
	}	
	public void setUserapply_name(String Userapply_name) {
		setAttrVal("Userapply_name", Userapply_name);
	}
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getEn_id_pat() {
		return ((String) getAttrVal("En_id_pat"));
	}	
	public void setEn_id_pat(String En_id_pat) {
		setAttrVal("En_id_pat", En_id_pat);
	}
	public String getUseragree_name() {
		return ((String) getAttrVal("Useragree_name"));
	}	
	public void setUseragree_name(String Useragree_name) {
		setAttrVal("Useragree_name", Useragree_name);
	}
	public String getUseragree_code() {
		return ((String) getAttrVal("Useragree_code"));
	}	
	public void setUseragree_code(String Useragree_code) {
		setAttrVal("Useragree_code", Useragree_code);
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
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
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
		return "Id_amr_apply";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_amr_apply";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AmrApplyDODesc.class);
	}
	
}
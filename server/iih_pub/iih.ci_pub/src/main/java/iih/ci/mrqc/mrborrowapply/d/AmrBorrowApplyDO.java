package iih.ci.mrqc.mrborrowapply.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.mrborrowapply.d.desc.AmrBorrowApplyDODesc;
import java.math.BigDecimal;

/**
 * 病案借阅申请 DO数据 
 * 
 */
public class AmrBorrowApplyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AMR_BORROW_APPLY= "Id_amr_borrow_apply";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_BORROW_APPLY_STATUS= "Id_borrow_apply_status";
	public static final String SD_BORROW_APPLY_STATUS= "Sd_borrow_apply_status";
	public static final String ID_AMR= "Id_amr";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String TIME_OVER= "Time_over";
	public static final String ID_TYPE_APPROVE= "Id_type_approve";
	public static final String SD_TYPE_APPROVE= "Sd_type_approve";
	public static final String REMARK_APPLY= "Remark_apply";
	public static final String ID_BORROW_APPLY_REASON= "Id_borrow_apply_reason";
	public static final String SD_BORROW_APPLY_REASON= "Sd_borrow_apply_reason";
	public static final String ID_BORROW_APPLY_USER= "Id_borrow_apply_user";
	public static final String ID_BORROW_APPLY_DEP= "Id_borrow_apply_dep";
	public static final String DT_BORROW_APPLY= "Dt_borrow_apply";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_AGREE_BORROW_USER= "Id_agree_borrow_user";
	public static final String DT_BORROW_AGREE= "Dt_borrow_agree";
	public static final String DT_END_BORROW= "Dt_end_borrow";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String PAT_AGE= "Pat_age";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ENT_CODE= "Ent_code";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String BORROW_APPLY_CODE= "Borrow_apply_code";
	public static final String BORROW_APPLY_NAME= "Borrow_apply_name";
	public static final String TYPE_APPROVE_CODE= "Type_approve_code";
	public static final String TYPE_APPROVE_NAME= "Type_approve_name";
	public static final String BORROW_APPLY_REASON_CODE= "Borrow_apply_reason_code";
	public static final String BORROW_APPLY_REASON_NAME= "Borrow_apply_reason_name";
	public static final String USERR_BORROWAPPLY_CODE= "Userr_borrowapply_code";
	public static final String USER_BORROWAPPLY_NAME= "User_borrowapply_name";
	public static final String DEPR_BORROWAPPLY_CODE= "Depr_borrowapply_code";
	public static final String DEPR_BORROWAPPLY_NAME= "Depr_borrowapply_name";
	public static final String USERR_BORROWAGREE_NAME= "Userr_borrowagree_name";
	public static final String USER_BORROWAGREE_CODE= "User_borrowagree_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String PAT_CODE= "Pat_code";
	public static final String SEX_CODE= "Sex_code";
	public static final String SEX_NAME= "Sex_name";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_amr_borrow_apply() {
		return ((String) getAttrVal("Id_amr_borrow_apply"));
	}	
	public void setId_amr_borrow_apply(String Id_amr_borrow_apply) {
		setAttrVal("Id_amr_borrow_apply", Id_amr_borrow_apply);
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
	public String getId_borrow_apply_status() {
		return ((String) getAttrVal("Id_borrow_apply_status"));
	}	
	public void setId_borrow_apply_status(String Id_borrow_apply_status) {
		setAttrVal("Id_borrow_apply_status", Id_borrow_apply_status);
	}
	public String getSd_borrow_apply_status() {
		return ((String) getAttrVal("Sd_borrow_apply_status"));
	}	
	public void setSd_borrow_apply_status(String Sd_borrow_apply_status) {
		setAttrVal("Sd_borrow_apply_status", Sd_borrow_apply_status);
	}
	public String getId_amr() {
		return ((String) getAttrVal("Id_amr"));
	}	
	public void setId_amr(String Id_amr) {
		setAttrVal("Id_amr", Id_amr);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public Integer getTime_over() {
		return ((Integer) getAttrVal("Time_over"));
	}	
	public void setTime_over(Integer Time_over) {
		setAttrVal("Time_over", Time_over);
	}
	public String getId_type_approve() {
		return ((String) getAttrVal("Id_type_approve"));
	}	
	public void setId_type_approve(String Id_type_approve) {
		setAttrVal("Id_type_approve", Id_type_approve);
	}
	public String getSd_type_approve() {
		return ((String) getAttrVal("Sd_type_approve"));
	}	
	public void setSd_type_approve(String Sd_type_approve) {
		setAttrVal("Sd_type_approve", Sd_type_approve);
	}
	public String getRemark_apply() {
		return ((String) getAttrVal("Remark_apply"));
	}	
	public void setRemark_apply(String Remark_apply) {
		setAttrVal("Remark_apply", Remark_apply);
	}
	public String getId_borrow_apply_reason() {
		return ((String) getAttrVal("Id_borrow_apply_reason"));
	}	
	public void setId_borrow_apply_reason(String Id_borrow_apply_reason) {
		setAttrVal("Id_borrow_apply_reason", Id_borrow_apply_reason);
	}
	public String getSd_borrow_apply_reason() {
		return ((String) getAttrVal("Sd_borrow_apply_reason"));
	}	
	public void setSd_borrow_apply_reason(String Sd_borrow_apply_reason) {
		setAttrVal("Sd_borrow_apply_reason", Sd_borrow_apply_reason);
	}
	public String getId_borrow_apply_user() {
		return ((String) getAttrVal("Id_borrow_apply_user"));
	}	
	public void setId_borrow_apply_user(String Id_borrow_apply_user) {
		setAttrVal("Id_borrow_apply_user", Id_borrow_apply_user);
	}
	public String getId_borrow_apply_dep() {
		return ((String) getAttrVal("Id_borrow_apply_dep"));
	}	
	public void setId_borrow_apply_dep(String Id_borrow_apply_dep) {
		setAttrVal("Id_borrow_apply_dep", Id_borrow_apply_dep);
	}
	public FDateTime getDt_borrow_apply() {
		return ((FDateTime) getAttrVal("Dt_borrow_apply"));
	}	
	public void setDt_borrow_apply(FDateTime Dt_borrow_apply) {
		setAttrVal("Dt_borrow_apply", Dt_borrow_apply);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_agree_borrow_user() {
		return ((String) getAttrVal("Id_agree_borrow_user"));
	}	
	public void setId_agree_borrow_user(String Id_agree_borrow_user) {
		setAttrVal("Id_agree_borrow_user", Id_agree_borrow_user);
	}
	public FDateTime getDt_borrow_agree() {
		return ((FDateTime) getAttrVal("Dt_borrow_agree"));
	}	
	public void setDt_borrow_agree(FDateTime Dt_borrow_agree) {
		setAttrVal("Dt_borrow_agree", Dt_borrow_agree);
	}
	public FDateTime getDt_end_borrow() {
		return ((FDateTime) getAttrVal("Dt_end_borrow"));
	}	
	public void setDt_end_borrow(FDateTime Dt_end_borrow) {
		setAttrVal("Dt_end_borrow", Dt_end_borrow);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}	
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
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
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}	
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
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
	public String getBorrow_apply_code() {
		return ((String) getAttrVal("Borrow_apply_code"));
	}	
	public void setBorrow_apply_code(String Borrow_apply_code) {
		setAttrVal("Borrow_apply_code", Borrow_apply_code);
	}
	public String getBorrow_apply_name() {
		return ((String) getAttrVal("Borrow_apply_name"));
	}	
	public void setBorrow_apply_name(String Borrow_apply_name) {
		setAttrVal("Borrow_apply_name", Borrow_apply_name);
	}
	public String getType_approve_code() {
		return ((String) getAttrVal("Type_approve_code"));
	}	
	public void setType_approve_code(String Type_approve_code) {
		setAttrVal("Type_approve_code", Type_approve_code);
	}
	public String getType_approve_name() {
		return ((String) getAttrVal("Type_approve_name"));
	}	
	public void setType_approve_name(String Type_approve_name) {
		setAttrVal("Type_approve_name", Type_approve_name);
	}
	public String getBorrow_apply_reason_code() {
		return ((String) getAttrVal("Borrow_apply_reason_code"));
	}	
	public void setBorrow_apply_reason_code(String Borrow_apply_reason_code) {
		setAttrVal("Borrow_apply_reason_code", Borrow_apply_reason_code);
	}
	public String getBorrow_apply_reason_name() {
		return ((String) getAttrVal("Borrow_apply_reason_name"));
	}	
	public void setBorrow_apply_reason_name(String Borrow_apply_reason_name) {
		setAttrVal("Borrow_apply_reason_name", Borrow_apply_reason_name);
	}
	public String getUserr_borrowapply_code() {
		return ((String) getAttrVal("Userr_borrowapply_code"));
	}	
	public void setUserr_borrowapply_code(String Userr_borrowapply_code) {
		setAttrVal("Userr_borrowapply_code", Userr_borrowapply_code);
	}
	public String getUser_borrowapply_name() {
		return ((String) getAttrVal("User_borrowapply_name"));
	}	
	public void setUser_borrowapply_name(String User_borrowapply_name) {
		setAttrVal("User_borrowapply_name", User_borrowapply_name);
	}
	public String getDepr_borrowapply_code() {
		return ((String) getAttrVal("Depr_borrowapply_code"));
	}	
	public void setDepr_borrowapply_code(String Depr_borrowapply_code) {
		setAttrVal("Depr_borrowapply_code", Depr_borrowapply_code);
	}
	public String getDepr_borrowapply_name() {
		return ((String) getAttrVal("Depr_borrowapply_name"));
	}	
	public void setDepr_borrowapply_name(String Depr_borrowapply_name) {
		setAttrVal("Depr_borrowapply_name", Depr_borrowapply_name);
	}
	public String getUserr_borrowagree_name() {
		return ((String) getAttrVal("Userr_borrowagree_name"));
	}	
	public void setUserr_borrowagree_name(String Userr_borrowagree_name) {
		setAttrVal("Userr_borrowagree_name", Userr_borrowagree_name);
	}
	public String getUser_borrowagree_code() {
		return ((String) getAttrVal("User_borrowagree_code"));
	}	
	public void setUser_borrowagree_code(String User_borrowagree_code) {
		setAttrVal("User_borrowagree_code", User_borrowagree_code);
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
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
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
		return "Id_amr_borrow_apply";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_amr_borrow_apply";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AmrBorrowApplyDODesc.class);
	}
	
}
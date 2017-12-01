package iih.ci.mrqc.cimrrecall.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.cimrrecall.d.desc.CiMrRecallDODesc;
import java.math.BigDecimal;

/**
 * 病历召回 DO数据 
 * 
 */
public class CiMrRecallDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CI_MR_RECALL= "Id_ci_mr_recall";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_DEP_APPLY= "Id_dep_apply";
	public static final String ID_PSN_APPLY= "Id_psn_apply";
	public static final String DT_APPLY= "Dt_apply";
	public static final String DT_END= "Dt_end";
	public static final String APPLY_RESON= "Apply_reson";
	public static final String ID_STATE= "Id_state";
	public static final String SD_STATE= "Sd_state";
	public static final String REJECT_RESON= "Reject_reson";
	public static final String ID_DEP_REJECT= "Id_dep_reject";
	public static final String ID_PSN_REJECT= "Id_psn_reject";
	public static final String DT_REJECT= "Dt_reject";
	public static final String ID_DEP_AUDIT= "Id_dep_audit";
	public static final String ID_PSN_AUDIT= "Id_psn_audit";
	public static final String DT_AUDIT= "Dt_audit";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String TIMEOUT_REASON= "Timeout_reason";
	public static final String FG_TIMEOUT= "Fg_timeout";
	public static final String CODE_DEP_APPLY= "Code_dep_apply";
	public static final String NAME_DEP_APPLY= "Name_dep_apply";
	public static final String CODE_PSN_APPLY= "Code_psn_apply";
	public static final String NAME_PSN_APPLY= "Name_psn_apply";
	public static final String CODE_SATE= "Code_sate";
	public static final String NAME_SATE= "Name_sate";
	public static final String CODE_DEP_REJECT= "Code_dep_reject";
	public static final String NAME_DEP_REJECT= "Name_dep_reject";
	public static final String CODE_PSN_REJECT= "Code_psn_reject";
	public static final String NAME_PSN_REJECT= "Name_psn_reject";
	public static final String CODE_DEP_AUDIT= "Code_dep_audit";
	public static final String NAME_DEP_AUDIT= "Name_dep_audit";
	public static final String CODE_PSN_AUDIT= "Code_psn_audit";
	public static final String NAME_PSN_AUDIT= "Name_psn_audit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ci_mr_recall() {
		return ((String) getAttrVal("Id_ci_mr_recall"));
	}	
	public void setId_ci_mr_recall(String Id_ci_mr_recall) {
		setAttrVal("Id_ci_mr_recall", Id_ci_mr_recall);
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
	public String getId_dep_apply() {
		return ((String) getAttrVal("Id_dep_apply"));
	}	
	public void setId_dep_apply(String Id_dep_apply) {
		setAttrVal("Id_dep_apply", Id_dep_apply);
	}
	public String getId_psn_apply() {
		return ((String) getAttrVal("Id_psn_apply"));
	}	
	public void setId_psn_apply(String Id_psn_apply) {
		setAttrVal("Id_psn_apply", Id_psn_apply);
	}
	public FDateTime getDt_apply() {
		return ((FDateTime) getAttrVal("Dt_apply"));
	}	
	public void setDt_apply(FDateTime Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getApply_reson() {
		return ((String) getAttrVal("Apply_reson"));
	}	
	public void setApply_reson(String Apply_reson) {
		setAttrVal("Apply_reson", Apply_reson);
	}
	public String getId_state() {
		return ((String) getAttrVal("Id_state"));
	}	
	public void setId_state(String Id_state) {
		setAttrVal("Id_state", Id_state);
	}
	public String getSd_state() {
		return ((String) getAttrVal("Sd_state"));
	}	
	public void setSd_state(String Sd_state) {
		setAttrVal("Sd_state", Sd_state);
	}
	public String getReject_reson() {
		return ((String) getAttrVal("Reject_reson"));
	}	
	public void setReject_reson(String Reject_reson) {
		setAttrVal("Reject_reson", Reject_reson);
	}
	public String getId_dep_reject() {
		return ((String) getAttrVal("Id_dep_reject"));
	}	
	public void setId_dep_reject(String Id_dep_reject) {
		setAttrVal("Id_dep_reject", Id_dep_reject);
	}
	public String getId_psn_reject() {
		return ((String) getAttrVal("Id_psn_reject"));
	}	
	public void setId_psn_reject(String Id_psn_reject) {
		setAttrVal("Id_psn_reject", Id_psn_reject);
	}
	public FDateTime getDt_reject() {
		return ((FDateTime) getAttrVal("Dt_reject"));
	}	
	public void setDt_reject(FDateTime Dt_reject) {
		setAttrVal("Dt_reject", Dt_reject);
	}
	public String getId_dep_audit() {
		return ((String) getAttrVal("Id_dep_audit"));
	}	
	public void setId_dep_audit(String Id_dep_audit) {
		setAttrVal("Id_dep_audit", Id_dep_audit);
	}
	public String getId_psn_audit() {
		return ((String) getAttrVal("Id_psn_audit"));
	}	
	public void setId_psn_audit(String Id_psn_audit) {
		setAttrVal("Id_psn_audit", Id_psn_audit);
	}
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}	
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
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
	public String getTimeout_reason() {
		return ((String) getAttrVal("Timeout_reason"));
	}	
	public void setTimeout_reason(String Timeout_reason) {
		setAttrVal("Timeout_reason", Timeout_reason);
	}
	public FBoolean getFg_timeout() {
		return ((FBoolean) getAttrVal("Fg_timeout"));
	}	
	public void setFg_timeout(FBoolean Fg_timeout) {
		setAttrVal("Fg_timeout", Fg_timeout);
	}
	public String getCode_dep_apply() {
		return ((String) getAttrVal("Code_dep_apply"));
	}	
	public void setCode_dep_apply(String Code_dep_apply) {
		setAttrVal("Code_dep_apply", Code_dep_apply);
	}
	public String getName_dep_apply() {
		return ((String) getAttrVal("Name_dep_apply"));
	}	
	public void setName_dep_apply(String Name_dep_apply) {
		setAttrVal("Name_dep_apply", Name_dep_apply);
	}
	public String getCode_psn_apply() {
		return ((String) getAttrVal("Code_psn_apply"));
	}	
	public void setCode_psn_apply(String Code_psn_apply) {
		setAttrVal("Code_psn_apply", Code_psn_apply);
	}
	public String getName_psn_apply() {
		return ((String) getAttrVal("Name_psn_apply"));
	}	
	public void setName_psn_apply(String Name_psn_apply) {
		setAttrVal("Name_psn_apply", Name_psn_apply);
	}
	public String getCode_sate() {
		return ((String) getAttrVal("Code_sate"));
	}	
	public void setCode_sate(String Code_sate) {
		setAttrVal("Code_sate", Code_sate);
	}
	public String getName_sate() {
		return ((String) getAttrVal("Name_sate"));
	}	
	public void setName_sate(String Name_sate) {
		setAttrVal("Name_sate", Name_sate);
	}
	public String getCode_dep_reject() {
		return ((String) getAttrVal("Code_dep_reject"));
	}	
	public void setCode_dep_reject(String Code_dep_reject) {
		setAttrVal("Code_dep_reject", Code_dep_reject);
	}
	public String getName_dep_reject() {
		return ((String) getAttrVal("Name_dep_reject"));
	}	
	public void setName_dep_reject(String Name_dep_reject) {
		setAttrVal("Name_dep_reject", Name_dep_reject);
	}
	public String getCode_psn_reject() {
		return ((String) getAttrVal("Code_psn_reject"));
	}	
	public void setCode_psn_reject(String Code_psn_reject) {
		setAttrVal("Code_psn_reject", Code_psn_reject);
	}
	public String getName_psn_reject() {
		return ((String) getAttrVal("Name_psn_reject"));
	}	
	public void setName_psn_reject(String Name_psn_reject) {
		setAttrVal("Name_psn_reject", Name_psn_reject);
	}
	public String getCode_dep_audit() {
		return ((String) getAttrVal("Code_dep_audit"));
	}	
	public void setCode_dep_audit(String Code_dep_audit) {
		setAttrVal("Code_dep_audit", Code_dep_audit);
	}
	public String getName_dep_audit() {
		return ((String) getAttrVal("Name_dep_audit"));
	}	
	public void setName_dep_audit(String Name_dep_audit) {
		setAttrVal("Name_dep_audit", Name_dep_audit);
	}
	public String getCode_psn_audit() {
		return ((String) getAttrVal("Code_psn_audit"));
	}	
	public void setCode_psn_audit(String Code_psn_audit) {
		setAttrVal("Code_psn_audit", Code_psn_audit);
	}
	public String getName_psn_audit() {
		return ((String) getAttrVal("Name_psn_audit"));
	}	
	public void setName_psn_audit(String Name_psn_audit) {
		setAttrVal("Name_psn_audit", Name_psn_audit);
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
		return "Id_ci_mr_recall";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_RECALL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrRecallDODesc.class);
	}
	
}
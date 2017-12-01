package iih.ci.mrqc.revisionnotice.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.revisionnotice.d.desc.RevisionNoticeDODesc;
import java.math.BigDecimal;

/**
 * 整改通知 DO数据 
 * 
 */
public class RevisionNoticeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REVISION= "Id_revision";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String DT_SEND= "Dt_send";
	public static final String ID_EXEC_DOCTOR= "Id_exec_doctor";
	public static final String RFM_DEADLINE= "Rfm_deadline";
	public static final String DT_DEADLINE= "Dt_deadline";
	public static final String ID_EXEC_DEPT= "Id_exec_dept";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_RFM_DOCTOR= "Id_rfm_doctor";
	public static final String ID_RFM_DEPT= "Id_rfm_dept";
	public static final String ID_QA_TY= "Id_qa_ty";
	public static final String SD_QA_TY= "Sd_qa_ty";
	public static final String FG_CMPL= "Fg_cmpl";
	public static final String RFM_TIME= "Rfm_time";
	public static final String VRF_TIME= "Vrf_time";
	public static final String DES= "Des";
	public static final String ID_VRF_USER= "Id_vrf_user";
	public static final String ID_VRF_DEPT= "Id_vrf_dept";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_DEAD_APPLY_STATUS= "Id_dead_apply_status";
	public static final String SD_DEAD_APPLY_STATUS= "Sd_dead_apply_status";
	public static final String DEAD_APPLY_REASON= "Dead_apply_reason";
	public static final String DEAD_CALLBACK_REASON= "Dead_callback_reason";
	public static final String DT_DEAD_APPLY= "Dt_dead_apply";
	public static final String DT_DEAD_AGREE= "Dt_dead_agree";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String RFM_DOCTOR_CODE= "Rfm_doctor_code";
	public static final String RFM_DOCTOR_NAME= "Rfm_doctor_name";
	public static final String RFM_DEPT_CODE= "Rfm_dept_code";
	public static final String RFM_DEPT_NAME= "Rfm_dept_name";
	public static final String VRF_USER_NAME= "Vrf_user_name";
	public static final String VRF_USER_CODE= "Vrf_user_code";
	public static final String VRF_DEPT_CODE= "Vrf_dept_code";
	public static final String VRF_DEPT_NAME= "Vrf_dept_name";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DEAD_APPLY_STATUS_CODE= "Dead_apply_status_code";
	public static final String DEAD_APPLY_STATUS_NAME= "Dead_apply_status_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_revision() {
		return ((String) getAttrVal("Id_revision"));
	}	
	public void setId_revision(String Id_revision) {
		setAttrVal("Id_revision", Id_revision);
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
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public FDateTime getDt_send() {
		return ((FDateTime) getAttrVal("Dt_send"));
	}	
	public void setDt_send(FDateTime Dt_send) {
		setAttrVal("Dt_send", Dt_send);
	}
	public String getId_exec_doctor() {
		return ((String) getAttrVal("Id_exec_doctor"));
	}	
	public void setId_exec_doctor(String Id_exec_doctor) {
		setAttrVal("Id_exec_doctor", Id_exec_doctor);
	}
	public Integer getRfm_deadline() {
		return ((Integer) getAttrVal("Rfm_deadline"));
	}	
	public void setRfm_deadline(Integer Rfm_deadline) {
		setAttrVal("Rfm_deadline", Rfm_deadline);
	}
	public FDateTime getDt_deadline() {
		return ((FDateTime) getAttrVal("Dt_deadline"));
	}	
	public void setDt_deadline(FDateTime Dt_deadline) {
		setAttrVal("Dt_deadline", Dt_deadline);
	}
	public String getId_exec_dept() {
		return ((String) getAttrVal("Id_exec_dept"));
	}	
	public void setId_exec_dept(String Id_exec_dept) {
		setAttrVal("Id_exec_dept", Id_exec_dept);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_rfm_doctor() {
		return ((String) getAttrVal("Id_rfm_doctor"));
	}	
	public void setId_rfm_doctor(String Id_rfm_doctor) {
		setAttrVal("Id_rfm_doctor", Id_rfm_doctor);
	}
	public String getId_rfm_dept() {
		return ((String) getAttrVal("Id_rfm_dept"));
	}	
	public void setId_rfm_dept(String Id_rfm_dept) {
		setAttrVal("Id_rfm_dept", Id_rfm_dept);
	}
	public String getId_qa_ty() {
		return ((String) getAttrVal("Id_qa_ty"));
	}	
	public void setId_qa_ty(String Id_qa_ty) {
		setAttrVal("Id_qa_ty", Id_qa_ty);
	}
	public String getSd_qa_ty() {
		return ((String) getAttrVal("Sd_qa_ty"));
	}	
	public void setSd_qa_ty(String Sd_qa_ty) {
		setAttrVal("Sd_qa_ty", Sd_qa_ty);
	}
	public FBoolean getFg_cmpl() {
		return ((FBoolean) getAttrVal("Fg_cmpl"));
	}	
	public void setFg_cmpl(FBoolean Fg_cmpl) {
		setAttrVal("Fg_cmpl", Fg_cmpl);
	}
	public FDateTime getRfm_time() {
		return ((FDateTime) getAttrVal("Rfm_time"));
	}	
	public void setRfm_time(FDateTime Rfm_time) {
		setAttrVal("Rfm_time", Rfm_time);
	}
	public FDateTime getVrf_time() {
		return ((FDateTime) getAttrVal("Vrf_time"));
	}	
	public void setVrf_time(FDateTime Vrf_time) {
		setAttrVal("Vrf_time", Vrf_time);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_vrf_user() {
		return ((String) getAttrVal("Id_vrf_user"));
	}	
	public void setId_vrf_user(String Id_vrf_user) {
		setAttrVal("Id_vrf_user", Id_vrf_user);
	}
	public String getId_vrf_dept() {
		return ((String) getAttrVal("Id_vrf_dept"));
	}	
	public void setId_vrf_dept(String Id_vrf_dept) {
		setAttrVal("Id_vrf_dept", Id_vrf_dept);
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
	public String getId_dead_apply_status() {
		return ((String) getAttrVal("Id_dead_apply_status"));
	}	
	public void setId_dead_apply_status(String Id_dead_apply_status) {
		setAttrVal("Id_dead_apply_status", Id_dead_apply_status);
	}
	public String getSd_dead_apply_status() {
		return ((String) getAttrVal("Sd_dead_apply_status"));
	}	
	public void setSd_dead_apply_status(String Sd_dead_apply_status) {
		setAttrVal("Sd_dead_apply_status", Sd_dead_apply_status);
	}
	public String getDead_apply_reason() {
		return ((String) getAttrVal("Dead_apply_reason"));
	}	
	public void setDead_apply_reason(String Dead_apply_reason) {
		setAttrVal("Dead_apply_reason", Dead_apply_reason);
	}
	public String getDead_callback_reason() {
		return ((String) getAttrVal("Dead_callback_reason"));
	}	
	public void setDead_callback_reason(String Dead_callback_reason) {
		setAttrVal("Dead_callback_reason", Dead_callback_reason);
	}
	public FDateTime getDt_dead_apply() {
		return ((FDateTime) getAttrVal("Dt_dead_apply"));
	}	
	public void setDt_dead_apply(FDateTime Dt_dead_apply) {
		setAttrVal("Dt_dead_apply", Dt_dead_apply);
	}
	public FDateTime getDt_dead_agree() {
		return ((FDateTime) getAttrVal("Dt_dead_agree"));
	}	
	public void setDt_dead_agree(FDateTime Dt_dead_agree) {
		setAttrVal("Dt_dead_agree", Dt_dead_agree);
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
	public String getRfm_doctor_code() {
		return ((String) getAttrVal("Rfm_doctor_code"));
	}	
	public void setRfm_doctor_code(String Rfm_doctor_code) {
		setAttrVal("Rfm_doctor_code", Rfm_doctor_code);
	}
	public String getRfm_doctor_name() {
		return ((String) getAttrVal("Rfm_doctor_name"));
	}	
	public void setRfm_doctor_name(String Rfm_doctor_name) {
		setAttrVal("Rfm_doctor_name", Rfm_doctor_name);
	}
	public String getRfm_dept_code() {
		return ((String) getAttrVal("Rfm_dept_code"));
	}	
	public void setRfm_dept_code(String Rfm_dept_code) {
		setAttrVal("Rfm_dept_code", Rfm_dept_code);
	}
	public String getRfm_dept_name() {
		return ((String) getAttrVal("Rfm_dept_name"));
	}	
	public void setRfm_dept_name(String Rfm_dept_name) {
		setAttrVal("Rfm_dept_name", Rfm_dept_name);
	}
	public String getVrf_user_name() {
		return ((String) getAttrVal("Vrf_user_name"));
	}	
	public void setVrf_user_name(String Vrf_user_name) {
		setAttrVal("Vrf_user_name", Vrf_user_name);
	}
	public String getVrf_user_code() {
		return ((String) getAttrVal("Vrf_user_code"));
	}	
	public void setVrf_user_code(String Vrf_user_code) {
		setAttrVal("Vrf_user_code", Vrf_user_code);
	}
	public String getVrf_dept_code() {
		return ((String) getAttrVal("Vrf_dept_code"));
	}	
	public void setVrf_dept_code(String Vrf_dept_code) {
		setAttrVal("Vrf_dept_code", Vrf_dept_code);
	}
	public String getVrf_dept_name() {
		return ((String) getAttrVal("Vrf_dept_name"));
	}	
	public void setVrf_dept_name(String Vrf_dept_name) {
		setAttrVal("Vrf_dept_name", Vrf_dept_name);
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
	public String getDead_apply_status_code() {
		return ((String) getAttrVal("Dead_apply_status_code"));
	}	
	public void setDead_apply_status_code(String Dead_apply_status_code) {
		setAttrVal("Dead_apply_status_code", Dead_apply_status_code);
	}
	public String getDead_apply_status_name() {
		return ((String) getAttrVal("Dead_apply_status_name"));
	}	
	public void setDead_apply_status_name(String Dead_apply_status_name) {
		setAttrVal("Dead_apply_status_name", Dead_apply_status_name);
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
		return "Id_revision";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_revision_notice";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RevisionNoticeDODesc.class);
	}
	
}
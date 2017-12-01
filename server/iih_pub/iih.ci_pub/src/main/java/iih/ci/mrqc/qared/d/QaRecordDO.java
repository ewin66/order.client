package iih.ci.mrqc.qared.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.qared.d.desc.QaRecordDODesc;
import java.math.BigDecimal;

/**
 * 质控工作记录 DO数据 
 * 
 */
public class QaRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QA= "Id_qa";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_QA_TY= "Id_qa_ty";
	public static final String SD_QA_TY= "Sd_qa_ty";
	public static final String DT_PLAN= "Dt_plan";
	public static final String DT_EXEC_BEGIN= "Dt_exec_begin";
	public static final String DT_EXEC_END= "Dt_exec_end";
	public static final String ID_EXEC_USER= "Id_exec_user";
	public static final String ID_EXEC_DEPT= "Id_exec_dept";
	public static final String FG_CMPL= "Fg_cmpl";
	public static final String FG_HAVE_FLT= "Fg_have_flt";
	public static final String FG_NEED_RFM_FLT= "Fg_need_rfm_flt";
	public static final String RFM_DEADLINE= "Rfm_deadline";
	public static final String DEADLINE= "Deadline";
	public static final String ID_REVISION= "Id_revision";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qa() {
		return ((String) getAttrVal("Id_qa"));
	}	
	public void setId_qa(String Id_qa) {
		setAttrVal("Id_qa", Id_qa);
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
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	public FDateTime getDt_exec_begin() {
		return ((FDateTime) getAttrVal("Dt_exec_begin"));
	}	
	public void setDt_exec_begin(FDateTime Dt_exec_begin) {
		setAttrVal("Dt_exec_begin", Dt_exec_begin);
	}
	public FDateTime getDt_exec_end() {
		return ((FDateTime) getAttrVal("Dt_exec_end"));
	}	
	public void setDt_exec_end(FDateTime Dt_exec_end) {
		setAttrVal("Dt_exec_end", Dt_exec_end);
	}
	public String getId_exec_user() {
		return ((String) getAttrVal("Id_exec_user"));
	}	
	public void setId_exec_user(String Id_exec_user) {
		setAttrVal("Id_exec_user", Id_exec_user);
	}
	public String getId_exec_dept() {
		return ((String) getAttrVal("Id_exec_dept"));
	}	
	public void setId_exec_dept(String Id_exec_dept) {
		setAttrVal("Id_exec_dept", Id_exec_dept);
	}
	public FBoolean getFg_cmpl() {
		return ((FBoolean) getAttrVal("Fg_cmpl"));
	}	
	public void setFg_cmpl(FBoolean Fg_cmpl) {
		setAttrVal("Fg_cmpl", Fg_cmpl);
	}
	public FBoolean getFg_have_flt() {
		return ((FBoolean) getAttrVal("Fg_have_flt"));
	}	
	public void setFg_have_flt(FBoolean Fg_have_flt) {
		setAttrVal("Fg_have_flt", Fg_have_flt);
	}
	public FBoolean getFg_need_rfm_flt() {
		return ((FBoolean) getAttrVal("Fg_need_rfm_flt"));
	}	
	public void setFg_need_rfm_flt(FBoolean Fg_need_rfm_flt) {
		setAttrVal("Fg_need_rfm_flt", Fg_need_rfm_flt);
	}
	public Integer getRfm_deadline() {
		return ((Integer) getAttrVal("Rfm_deadline"));
	}	
	public void setRfm_deadline(Integer Rfm_deadline) {
		setAttrVal("Rfm_deadline", Rfm_deadline);
	}
	public FDateTime getDeadline() {
		return ((FDateTime) getAttrVal("Deadline"));
	}	
	public void setDeadline(FDateTime Deadline) {
		setAttrVal("Deadline", Deadline);
	}
	public String getId_revision() {
		return ((String) getAttrVal("Id_revision"));
	}	
	public void setId_revision(String Id_revision) {
		setAttrVal("Id_revision", Id_revision);
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
		return "Id_qa";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_record";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QaRecordDODesc.class);
	}
	
}
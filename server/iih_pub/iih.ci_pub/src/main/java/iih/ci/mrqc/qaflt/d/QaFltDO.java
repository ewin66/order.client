package iih.ci.mrqc.qaflt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.qaflt.d.desc.QaFltDODesc;
import java.math.BigDecimal;

/**
 * 质控缺陷 DO数据 
 * 
 */
public class QaFltDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QA_FLT= "Id_qa_flt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_REVISION= "Id_revision";
	public static final String ID_QA_ITM= "Id_qa_itm";
	public static final String ID_QA_TY= "Id_qa_ty";
	public static final String SD_QA_TY= "Sd_qa_ty";
	public static final String ID_FLT_STA= "Id_flt_sta";
	public static final String SD_FLT_STA= "Sd_flt_sta";
	public static final String DT_SBMT= "Dt_sbmt";
	public static final String ID_SBMT_USER= "Id_sbmt_user";
	public static final String ID_SBMT_DEPT= "Id_sbmt_dept";
	public static final String RFM_REQ= "Rfm_req";
	public static final String DT_RFM= "Dt_rfm";
	public static final String ID_RFM_USER= "Id_rfm_user";
	public static final String ID_RFM_DEPT= "Id_rfm_dept";
	public static final String RFM_DES= "Rfm_des";
	public static final String DT_VRF= "Dt_vrf";
	public static final String ID_VRF_USER= "Id_vrf_user";
	public static final String ID_VRF_DEPT= "Id_vrf_dept";
	public static final String DRP_DES= "Drp_des";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_MR= "Id_mr";
	public static final String DEDUCT_SCR_TIMES= "Deduct_scr_times";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String QA_TY_CODE= "Qa_ty_code";
	public static final String QA_TY_NAME= "Qa_ty_name";
	public static final String FLT_STA_CODE= "Flt_sta_code";
	public static final String FLT_STA_NAME= "Flt_sta_name";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qa_flt() {
		return ((String) getAttrVal("Id_qa_flt"));
	}	
	public void setId_qa_flt(String Id_qa_flt) {
		setAttrVal("Id_qa_flt", Id_qa_flt);
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
	public String getId_revision() {
		return ((String) getAttrVal("Id_revision"));
	}	
	public void setId_revision(String Id_revision) {
		setAttrVal("Id_revision", Id_revision);
	}
	public String getId_qa_itm() {
		return ((String) getAttrVal("Id_qa_itm"));
	}	
	public void setId_qa_itm(String Id_qa_itm) {
		setAttrVal("Id_qa_itm", Id_qa_itm);
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
	public String getId_flt_sta() {
		return ((String) getAttrVal("Id_flt_sta"));
	}	
	public void setId_flt_sta(String Id_flt_sta) {
		setAttrVal("Id_flt_sta", Id_flt_sta);
	}
	public String getSd_flt_sta() {
		return ((String) getAttrVal("Sd_flt_sta"));
	}	
	public void setSd_flt_sta(String Sd_flt_sta) {
		setAttrVal("Sd_flt_sta", Sd_flt_sta);
	}
	public FDateTime getDt_sbmt() {
		return ((FDateTime) getAttrVal("Dt_sbmt"));
	}	
	public void setDt_sbmt(FDateTime Dt_sbmt) {
		setAttrVal("Dt_sbmt", Dt_sbmt);
	}
	public String getId_sbmt_user() {
		return ((String) getAttrVal("Id_sbmt_user"));
	}	
	public void setId_sbmt_user(String Id_sbmt_user) {
		setAttrVal("Id_sbmt_user", Id_sbmt_user);
	}
	public String getId_sbmt_dept() {
		return ((String) getAttrVal("Id_sbmt_dept"));
	}	
	public void setId_sbmt_dept(String Id_sbmt_dept) {
		setAttrVal("Id_sbmt_dept", Id_sbmt_dept);
	}
	public String getRfm_req() {
		return ((String) getAttrVal("Rfm_req"));
	}	
	public void setRfm_req(String Rfm_req) {
		setAttrVal("Rfm_req", Rfm_req);
	}
	public FDateTime getDt_rfm() {
		return ((FDateTime) getAttrVal("Dt_rfm"));
	}	
	public void setDt_rfm(FDateTime Dt_rfm) {
		setAttrVal("Dt_rfm", Dt_rfm);
	}
	public String getId_rfm_user() {
		return ((String) getAttrVal("Id_rfm_user"));
	}	
	public void setId_rfm_user(String Id_rfm_user) {
		setAttrVal("Id_rfm_user", Id_rfm_user);
	}
	public String getId_rfm_dept() {
		return ((String) getAttrVal("Id_rfm_dept"));
	}	
	public void setId_rfm_dept(String Id_rfm_dept) {
		setAttrVal("Id_rfm_dept", Id_rfm_dept);
	}
	public String getRfm_des() {
		return ((String) getAttrVal("Rfm_des"));
	}	
	public void setRfm_des(String Rfm_des) {
		setAttrVal("Rfm_des", Rfm_des);
	}
	public FDateTime getDt_vrf() {
		return ((FDateTime) getAttrVal("Dt_vrf"));
	}	
	public void setDt_vrf(FDateTime Dt_vrf) {
		setAttrVal("Dt_vrf", Dt_vrf);
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
	public String getDrp_des() {
		return ((String) getAttrVal("Drp_des"));
	}	
	public void setDrp_des(String Drp_des) {
		setAttrVal("Drp_des", Drp_des);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public Integer getDeduct_scr_times() {
		return ((Integer) getAttrVal("Deduct_scr_times"));
	}	
	public void setDeduct_scr_times(Integer Deduct_scr_times) {
		setAttrVal("Deduct_scr_times", Deduct_scr_times);
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
	public String getQa_ty_code() {
		return ((String) getAttrVal("Qa_ty_code"));
	}	
	public void setQa_ty_code(String Qa_ty_code) {
		setAttrVal("Qa_ty_code", Qa_ty_code);
	}
	public String getQa_ty_name() {
		return ((String) getAttrVal("Qa_ty_name"));
	}	
	public void setQa_ty_name(String Qa_ty_name) {
		setAttrVal("Qa_ty_name", Qa_ty_name);
	}
	public String getFlt_sta_code() {
		return ((String) getAttrVal("Flt_sta_code"));
	}	
	public void setFlt_sta_code(String Flt_sta_code) {
		setAttrVal("Flt_sta_code", Flt_sta_code);
	}
	public String getFlt_sta_name() {
		return ((String) getAttrVal("Flt_sta_name"));
	}	
	public void setFlt_sta_name(String Flt_sta_name) {
		setAttrVal("Flt_sta_name", Flt_sta_name);
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
		return "Id_qa_flt";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_flt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QaFltDODesc.class);
	}
	
}
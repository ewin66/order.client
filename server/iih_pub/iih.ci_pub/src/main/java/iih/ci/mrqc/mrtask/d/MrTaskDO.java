package iih.ci.mrqc.mrtask.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.mrtask.d.desc.MrTaskDODesc;
import java.math.BigDecimal;

/**
 * 病历任务 DO数据 
 * 
 */
public class MrTaskDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRTASK= "Id_mrtask";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String MRTASK_NAME= "Mrtask_name";
	public static final String ID_QA_ITM_CONFIG= "Id_qa_itm_config";
	public static final String ID_MRTASK_STA= "Id_mrtask_sta";
	public static final String SD_MRTASK_STA= "Sd_mrtask_sta";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_EXEC_DEPT= "Id_exec_dept";
	public static final String ID_EXEC_DOCTOR= "Id_exec_doctor";
	public static final String ID_MRCACTM= "Id_mrcactm";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String ID_SOURCE= "Id_source";
	public static final String SOURCE_TYPE= "Source_type";
	public static final String SOURCE_NAME= "Source_name";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String DT_COMPLETE= "Dt_complete";
	public static final String TIME_HAS= "Time_has";
	public static final String REASON_CANCEL= "Reason_cancel";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ISRATE= "Israte";
	public static final String RATE= "Rate";
	public static final String ID_OR= "Id_or";
	public static final String MRTASKSTA_NAME= "Mrtasksta_name";
	public static final String MRTASKSTA_CODE= "Mrtasksta_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String MRCACTM_NAME= "Mrcactm_name";
	public static final String MRCACTM_CODE= "Mrcactm_code";
	public static final String MRTP_CODE= "Mrtp_code";
	public static final String MRTP_NAME= "Mrtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrtask() {
		return ((String) getAttrVal("Id_mrtask"));
	}	
	public void setId_mrtask(String Id_mrtask) {
		setAttrVal("Id_mrtask", Id_mrtask);
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
	public String getMrtask_name() {
		return ((String) getAttrVal("Mrtask_name"));
	}	
	public void setMrtask_name(String Mrtask_name) {
		setAttrVal("Mrtask_name", Mrtask_name);
	}
	public String getId_qa_itm_config() {
		return ((String) getAttrVal("Id_qa_itm_config"));
	}	
	public void setId_qa_itm_config(String Id_qa_itm_config) {
		setAttrVal("Id_qa_itm_config", Id_qa_itm_config);
	}
	public String getId_mrtask_sta() {
		return ((String) getAttrVal("Id_mrtask_sta"));
	}	
	public void setId_mrtask_sta(String Id_mrtask_sta) {
		setAttrVal("Id_mrtask_sta", Id_mrtask_sta);
	}
	public String getSd_mrtask_sta() {
		return ((String) getAttrVal("Sd_mrtask_sta"));
	}	
	public void setSd_mrtask_sta(String Sd_mrtask_sta) {
		setAttrVal("Sd_mrtask_sta", Sd_mrtask_sta);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_exec_dept() {
		return ((String) getAttrVal("Id_exec_dept"));
	}	
	public void setId_exec_dept(String Id_exec_dept) {
		setAttrVal("Id_exec_dept", Id_exec_dept);
	}
	public String getId_exec_doctor() {
		return ((String) getAttrVal("Id_exec_doctor"));
	}	
	public void setId_exec_doctor(String Id_exec_doctor) {
		setAttrVal("Id_exec_doctor", Id_exec_doctor);
	}
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public String getId_source() {
		return ((String) getAttrVal("Id_source"));
	}	
	public void setId_source(String Id_source) {
		setAttrVal("Id_source", Id_source);
	}
	public String getSource_type() {
		return ((String) getAttrVal("Source_type"));
	}	
	public void setSource_type(String Source_type) {
		setAttrVal("Source_type", Source_type);
	}
	public String getSource_name() {
		return ((String) getAttrVal("Source_name"));
	}	
	public void setSource_name(String Source_name) {
		setAttrVal("Source_name", Source_name);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FDateTime getDt_complete() {
		return ((FDateTime) getAttrVal("Dt_complete"));
	}	
	public void setDt_complete(FDateTime Dt_complete) {
		setAttrVal("Dt_complete", Dt_complete);
	}
	public String getTime_has() {
		return ((String) getAttrVal("Time_has"));
	}	
	public void setTime_has(String Time_has) {
		setAttrVal("Time_has", Time_has);
	}
	public String getReason_cancel() {
		return ((String) getAttrVal("Reason_cancel"));
	}	
	public void setReason_cancel(String Reason_cancel) {
		setAttrVal("Reason_cancel", Reason_cancel);
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
	public FBoolean getIsrate() {
		return ((FBoolean) getAttrVal("Israte"));
	}	
	public void setIsrate(FBoolean Israte) {
		setAttrVal("Israte", Israte);
	}
	public String getRate() {
		return ((String) getAttrVal("Rate"));
	}	
	public void setRate(String Rate) {
		setAttrVal("Rate", Rate);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getMrtasksta_name() {
		return ((String) getAttrVal("Mrtasksta_name"));
	}	
	public void setMrtasksta_name(String Mrtasksta_name) {
		setAttrVal("Mrtasksta_name", Mrtasksta_name);
	}
	public String getMrtasksta_code() {
		return ((String) getAttrVal("Mrtasksta_code"));
	}	
	public void setMrtasksta_code(String Mrtasksta_code) {
		setAttrVal("Mrtasksta_code", Mrtasksta_code);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getMrcactm_name() {
		return ((String) getAttrVal("Mrcactm_name"));
	}	
	public void setMrcactm_name(String Mrcactm_name) {
		setAttrVal("Mrcactm_name", Mrcactm_name);
	}
	public String getMrcactm_code() {
		return ((String) getAttrVal("Mrcactm_code"));
	}	
	public void setMrcactm_code(String Mrcactm_code) {
		setAttrVal("Mrcactm_code", Mrcactm_code);
	}
	public String getMrtp_code() {
		return ((String) getAttrVal("Mrtp_code"));
	}	
	public void setMrtp_code(String Mrtp_code) {
		setAttrVal("Mrtp_code", Mrtp_code);
	}
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
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
		return "Id_mrtask";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_mrtask";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrTaskDODesc.class);
	}
	
}
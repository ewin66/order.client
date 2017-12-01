package iih.ci.ciet.cievent.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ciet.cievent.d.desc.CiEventDODesc;
import java.math.BigDecimal;

/**
 * 临床事件 DO数据 
 * 
 */
public class CiEventDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ET= "Id_et";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_OR= "Id_or";
	public static final String ID_DI= "Id_di";
	public static final String ID_MR= "Id_mr";
	public static final String DT_ET= "Dt_et";
	public static final String ID_ETTP= "Id_ettp";
	public static final String SD_ETTP= "Sd_ettp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ID_DES_STATUS= "Id_des_status";
	public static final String SD_DES_STATUS= "Sd_des_status";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_DEP_ET= "Id_dep_et";
	public static final String ID_EMP_ET= "Id_emp_et";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String ISCOMPLETED= "Iscompleted";
	public static final String ID_USER= "Id_user";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String DT_COMPLETE= "Dt_complete";
	public static final String TIME_HAS= "Time_has";
	public static final String REASON_CANCEL= "Reason_cancel";
	public static final String ISRATE= "Israte";
	public static final String RATE= "Rate";
	public static final String IS_ASSOCIATED= "Is_associated";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String EVENTSTA_CODE= "Eventsta_code";
	public static final String EVENTSTA_NAME= "Eventsta_name";
	public static final String PAT_NAME= "Pat_name";
	public static final String MRTP_CODE= "Mrtp_code";
	public static final String MRTP_NAME= "Mrtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_et() {
		return ((String) getAttrVal("Id_et"));
	}	
	public void setId_et(String Id_et) {
		setAttrVal("Id_et", Id_et);
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
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public FDateTime getDt_et() {
		return ((FDateTime) getAttrVal("Dt_et"));
	}	
	public void setDt_et(FDateTime Dt_et) {
		setAttrVal("Dt_et", Dt_et);
	}
	public String getId_ettp() {
		return ((String) getAttrVal("Id_ettp"));
	}	
	public void setId_ettp(String Id_ettp) {
		setAttrVal("Id_ettp", Id_ettp);
	}
	public String getSd_ettp() {
		return ((String) getAttrVal("Sd_ettp"));
	}	
	public void setSd_ettp(String Sd_ettp) {
		setAttrVal("Sd_ettp", Sd_ettp);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_des_status() {
		return ((String) getAttrVal("Id_des_status"));
	}	
	public void setId_des_status(String Id_des_status) {
		setAttrVal("Id_des_status", Id_des_status);
	}
	public String getSd_des_status() {
		return ((String) getAttrVal("Sd_des_status"));
	}	
	public void setSd_des_status(String Sd_des_status) {
		setAttrVal("Sd_des_status", Sd_des_status);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_dep_et() {
		return ((String) getAttrVal("Id_dep_et"));
	}	
	public void setId_dep_et(String Id_dep_et) {
		setAttrVal("Id_dep_et", Id_dep_et);
	}
	public String getId_emp_et() {
		return ((String) getAttrVal("Id_emp_et"));
	}	
	public void setId_emp_et(String Id_emp_et) {
		setAttrVal("Id_emp_et", Id_emp_et);
	}
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public FBoolean getIscompleted() {
		return ((FBoolean) getAttrVal("Iscompleted"));
	}	
	public void setIscompleted(FBoolean Iscompleted) {
		setAttrVal("Iscompleted", Iscompleted);
	}
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}	
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
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
	public FBoolean getIs_associated() {
		return ((FBoolean) getAttrVal("Is_associated"));
	}	
	public void setIs_associated(FBoolean Is_associated) {
		setAttrVal("Is_associated", Is_associated);
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
	public String getEventsta_code() {
		return ((String) getAttrVal("Eventsta_code"));
	}	
	public void setEventsta_code(String Eventsta_code) {
		setAttrVal("Eventsta_code", Eventsta_code);
	}
	public String getEventsta_name() {
		return ((String) getAttrVal("Eventsta_name"));
	}	
	public void setEventsta_name(String Eventsta_name) {
		setAttrVal("Eventsta_name", Eventsta_name);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
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
		return "Id_et";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_et";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiEventDODesc.class);
	}
	
}
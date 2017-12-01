package iih.ci.mr.mrlog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.mrlog.d.desc.CiMrLogDODesc;
import java.math.BigDecimal;

/**
 * 病历操作记录 DO数据 
 * 
 */
public class CiMrLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_LOG= "Id_mr_log";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MR= "Id_mr";
	public static final String ID_USER_OPERATE= "Id_user_operate";
	public static final String ID_TYPE_OPERATE= "Id_type_operate";
	public static final String SD_TYPE_OPERATE= "Sd_type_operate";
	public static final String DT_OPERATE= "Dt_operate";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String USER_OPERATE_NAME= "User_operate_name";
	public static final String USER_OPERATE_CODE= "User_operate_code";
	public static final String TYPE_OPERATE_CODE= "Type_operate_code";
	public static final String TYPE_OPERATE_NAME= "Type_operate_name";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr_log() {
		return ((String) getAttrVal("Id_mr_log"));
	}	
	public void setId_mr_log(String Id_mr_log) {
		setAttrVal("Id_mr_log", Id_mr_log);
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
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public String getId_user_operate() {
		return ((String) getAttrVal("Id_user_operate"));
	}	
	public void setId_user_operate(String Id_user_operate) {
		setAttrVal("Id_user_operate", Id_user_operate);
	}
	public String getId_type_operate() {
		return ((String) getAttrVal("Id_type_operate"));
	}	
	public void setId_type_operate(String Id_type_operate) {
		setAttrVal("Id_type_operate", Id_type_operate);
	}
	public String getSd_type_operate() {
		return ((String) getAttrVal("Sd_type_operate"));
	}	
	public void setSd_type_operate(String Sd_type_operate) {
		setAttrVal("Sd_type_operate", Sd_type_operate);
	}
	public FDateTime getDt_operate() {
		return ((FDateTime) getAttrVal("Dt_operate"));
	}	
	public void setDt_operate(FDateTime Dt_operate) {
		setAttrVal("Dt_operate", Dt_operate);
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
	public String getUser_operate_name() {
		return ((String) getAttrVal("User_operate_name"));
	}	
	public void setUser_operate_name(String User_operate_name) {
		setAttrVal("User_operate_name", User_operate_name);
	}
	public String getUser_operate_code() {
		return ((String) getAttrVal("User_operate_code"));
	}	
	public void setUser_operate_code(String User_operate_code) {
		setAttrVal("User_operate_code", User_operate_code);
	}
	public String getType_operate_code() {
		return ((String) getAttrVal("Type_operate_code"));
	}	
	public void setType_operate_code(String Type_operate_code) {
		setAttrVal("Type_operate_code", Type_operate_code);
	}
	public String getType_operate_name() {
		return ((String) getAttrVal("Type_operate_name"));
	}	
	public void setType_operate_name(String Type_operate_name) {
		setAttrVal("Type_operate_name", Type_operate_name);
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
		return "Id_mr_log";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_log";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrLogDODesc.class);
	}
	
}
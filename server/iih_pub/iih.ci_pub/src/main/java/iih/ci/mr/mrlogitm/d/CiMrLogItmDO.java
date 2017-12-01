package iih.ci.mr.mrlogitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.mrlogitm.d.desc.CiMrLogItmDODesc;
import java.math.BigDecimal;

/**
 * 病历记录操作明细 DO数据 
 * 
 */
public class CiMrLogItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_LOG_ITM= "Id_mr_log_itm";
	public static final String ID_MR_LOG= "Id_mr_log";
	public static final String TEXT_OPERATE_ITM= "Text_operate_itm";
	public static final String ID_TYPE_OPERATE_ITM= "Id_type_operate_itm";
	public static final String SD_TYPE_OPERATE_ITM= "Sd_type_operate_itm";
	public static final String PREMISSIONLEVEL= "Premissionlevel";
	public static final String ID_USER_IN= "Id_user_in";
	public static final String USER_IN_NAME= "User_in_name";
	public static final String TITLE_OPERATE_ITM= "Title_operate_itm";
	public static final String DT_OPERATE_ITM= "Dt_operate_itm";
	public static final String TYPE_OPERATE_ITM_CODE= "Type_operate_itm_code";
	public static final String TYPE_OPERATE_ITM_NAME= "Type_operate_itm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr_log_itm() {
		return ((String) getAttrVal("Id_mr_log_itm"));
	}	
	public void setId_mr_log_itm(String Id_mr_log_itm) {
		setAttrVal("Id_mr_log_itm", Id_mr_log_itm);
	}
	public String getId_mr_log() {
		return ((String) getAttrVal("Id_mr_log"));
	}	
	public void setId_mr_log(String Id_mr_log) {
		setAttrVal("Id_mr_log", Id_mr_log);
	}
	public String getText_operate_itm() {
		return ((String) getAttrVal("Text_operate_itm"));
	}	
	public void setText_operate_itm(String Text_operate_itm) {
		setAttrVal("Text_operate_itm", Text_operate_itm);
	}
	public String getId_type_operate_itm() {
		return ((String) getAttrVal("Id_type_operate_itm"));
	}	
	public void setId_type_operate_itm(String Id_type_operate_itm) {
		setAttrVal("Id_type_operate_itm", Id_type_operate_itm);
	}
	public String getSd_type_operate_itm() {
		return ((String) getAttrVal("Sd_type_operate_itm"));
	}	
	public void setSd_type_operate_itm(String Sd_type_operate_itm) {
		setAttrVal("Sd_type_operate_itm", Sd_type_operate_itm);
	}
	public Integer getPremissionlevel() {
		return ((Integer) getAttrVal("Premissionlevel"));
	}	
	public void setPremissionlevel(Integer Premissionlevel) {
		setAttrVal("Premissionlevel", Premissionlevel);
	}
	public String getId_user_in() {
		return ((String) getAttrVal("Id_user_in"));
	}	
	public void setId_user_in(String Id_user_in) {
		setAttrVal("Id_user_in", Id_user_in);
	}
	public String getUser_in_name() {
		return ((String) getAttrVal("User_in_name"));
	}	
	public void setUser_in_name(String User_in_name) {
		setAttrVal("User_in_name", User_in_name);
	}
	public String getTitle_operate_itm() {
		return ((String) getAttrVal("Title_operate_itm"));
	}	
	public void setTitle_operate_itm(String Title_operate_itm) {
		setAttrVal("Title_operate_itm", Title_operate_itm);
	}
	public FDateTime getDt_operate_itm() {
		return ((FDateTime) getAttrVal("Dt_operate_itm"));
	}	
	public void setDt_operate_itm(FDateTime Dt_operate_itm) {
		setAttrVal("Dt_operate_itm", Dt_operate_itm);
	}
	public String getType_operate_itm_code() {
		return ((String) getAttrVal("Type_operate_itm_code"));
	}	
	public void setType_operate_itm_code(String Type_operate_itm_code) {
		setAttrVal("Type_operate_itm_code", Type_operate_itm_code);
	}
	public String getType_operate_itm_name() {
		return ((String) getAttrVal("Type_operate_itm_name"));
	}	
	public void setType_operate_itm_name(String Type_operate_itm_name) {
		setAttrVal("Type_operate_itm_name", Type_operate_itm_name);
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
		return "Id_mr_log_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_log_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrLogItmDODesc.class);
	}
	
}
package iih.ci.mrqc.spotcheck.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.spotcheck.d.desc.CiAmrSpotCheckRecordDODesc;
import java.math.BigDecimal;

/**
 * 门诊病历抽查 DO数据 
 * 
 */
public class CiAmrSpotCheckRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SPOT_CHECK= "Id_spot_check";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENHR= "Id_enhr";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_EMP_CHECK= "Id_emp_check";
	public static final String DT_CHECK= "Dt_check";
	public static final String FG_CHECK= "Fg_check";
	public static final String SCORE_EMP_CHECK= "Score_emp_check";
	public static final String ID_CHECK_STATUS= "Id_check_status";
	public static final String SD_CHECK_STATUS= "Sd_check_status";
	public static final String DT_SCORE= "Dt_score";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String CREATEDBY= "Createdby";
	public static final String TEMP1= "Temp1";
	public static final String TEMP2= "Temp2";
	public static final String TEMP3= "Temp3";
	public static final String TEMP4= "Temp4";
	public static final String TEMP5= "Temp5";
	public static final String EMP_CHECK_NAME= "Emp_check_name";
	public static final String EMP_CHECK_CODE= "Emp_check_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_spot_check() {
		return ((String) getAttrVal("Id_spot_check"));
	}	
	public void setId_spot_check(String Id_spot_check) {
		setAttrVal("Id_spot_check", Id_spot_check);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_enhr() {
		return ((String) getAttrVal("Id_enhr"));
	}	
	public void setId_enhr(String Id_enhr) {
		setAttrVal("Id_enhr", Id_enhr);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	public FBoolean getFg_check() {
		return ((FBoolean) getAttrVal("Fg_check"));
	}	
	public void setFg_check(FBoolean Fg_check) {
		setAttrVal("Fg_check", Fg_check);
	}
	public FDouble getScore_emp_check() {
		return ((FDouble) getAttrVal("Score_emp_check"));
	}	
	public void setScore_emp_check(FDouble Score_emp_check) {
		setAttrVal("Score_emp_check", Score_emp_check);
	}
	public String getId_check_status() {
		return ((String) getAttrVal("Id_check_status"));
	}	
	public void setId_check_status(String Id_check_status) {
		setAttrVal("Id_check_status", Id_check_status);
	}
	public String getSd_check_status() {
		return ((String) getAttrVal("Sd_check_status"));
	}	
	public void setSd_check_status(String Sd_check_status) {
		setAttrVal("Sd_check_status", Sd_check_status);
	}
	public FDateTime getDt_score() {
		return ((FDateTime) getAttrVal("Dt_score"));
	}	
	public void setDt_score(FDateTime Dt_score) {
		setAttrVal("Dt_score", Dt_score);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public String getTemp1() {
		return ((String) getAttrVal("Temp1"));
	}	
	public void setTemp1(String Temp1) {
		setAttrVal("Temp1", Temp1);
	}
	public String getTemp2() {
		return ((String) getAttrVal("Temp2"));
	}	
	public void setTemp2(String Temp2) {
		setAttrVal("Temp2", Temp2);
	}
	public String getTemp3() {
		return ((String) getAttrVal("Temp3"));
	}	
	public void setTemp3(String Temp3) {
		setAttrVal("Temp3", Temp3);
	}
	public String getTemp4() {
		return ((String) getAttrVal("Temp4"));
	}	
	public void setTemp4(String Temp4) {
		setAttrVal("Temp4", Temp4);
	}
	public String getTemp5() {
		return ((String) getAttrVal("Temp5"));
	}	
	public void setTemp5(String Temp5) {
		setAttrVal("Temp5", Temp5);
	}
	public String getEmp_check_name() {
		return ((String) getAttrVal("Emp_check_name"));
	}	
	public void setEmp_check_name(String Emp_check_name) {
		setAttrVal("Emp_check_name", Emp_check_name);
	}
	public String getEmp_check_code() {
		return ((String) getAttrVal("Emp_check_code"));
	}	
	public void setEmp_check_code(String Emp_check_code) {
		setAttrVal("Emp_check_code", Emp_check_code);
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
		return "Id_spot_check";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_AMR_SPOT_CHECK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiAmrSpotCheckRecordDODesc.class);
	}
	
}
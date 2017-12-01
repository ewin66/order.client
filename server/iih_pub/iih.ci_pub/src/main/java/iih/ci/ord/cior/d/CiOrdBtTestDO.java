package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.CiOrdBtTestDODesc;
import java.math.BigDecimal;

/**
 * 交叉备血结果单 DO数据 
 * 
 */
public class CiOrdBtTestDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTBTTEST= "Id_rptbttest";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String ID_APBT= "Id_apbt";
	public static final String ID_OR= "Id_or";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_SRV_BT= "Id_srv_bt";
	public static final String ID_ABO_PAT= "Id_abo_pat";
	public static final String SD_ABO_PAT= "Sd_abo_pat";
	public static final String ID_RH_PAT= "Id_rh_pat";
	public static final String SD_RH_PAT= "Sd_rh_pat";
	public static final String ID_EMP_RECHECK= "Id_emp_recheck";
	public static final String DT_RECHECK= "Dt_recheck";
	public static final String DES= "Des";
	public static final String NUM_BT= "Num_bt";
	public static final String ID_UNIT_BT= "Id_unit_bt";
	public static final String NUM_ST= "Num_st";
	public static final String ID_UNIT_ST= "Id_unit_st";
	public static final String ID_SU_BTTEST= "Id_su_bttest";
	public static final String SD_SU_BTTEST= "Sd_su_bttest";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String QUAN_MEDU= "Quan_medu";
	public static final String ID_MEDU= "Id_medu";
	public static final String APPLYFORMNO= "Applyformno";
	public static final String ENT_CODE= "Ent_code";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_BT= "Name_bt";
	public static final String ABO_NAME= "Abo_name";
	public static final String RH_NAME= "Rh_name";
	public static final String RECHECK_NAME= "Recheck_name";
	public static final String BT_UNIT_NAME= "Bt_unit_name";
	public static final String ST_UNIT_NAME= "St_unit_name";
	public static final String SU_BTTEST_NAME= "Su_bttest_name";
	public static final String MEDU_NAME= "Medu_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptbttest() {
		return ((String) getAttrVal("Id_rptbttest"));
	}	
	public void setId_rptbttest(String Id_rptbttest) {
		setAttrVal("Id_rptbttest", Id_rptbttest);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public String getId_apbt() {
		return ((String) getAttrVal("Id_apbt"));
	}	
	public void setId_apbt(String Id_apbt) {
		setAttrVal("Id_apbt", Id_apbt);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	public String getId_srv_bt() {
		return ((String) getAttrVal("Id_srv_bt"));
	}	
	public void setId_srv_bt(String Id_srv_bt) {
		setAttrVal("Id_srv_bt", Id_srv_bt);
	}
	public String getId_abo_pat() {
		return ((String) getAttrVal("Id_abo_pat"));
	}	
	public void setId_abo_pat(String Id_abo_pat) {
		setAttrVal("Id_abo_pat", Id_abo_pat);
	}
	public String getSd_abo_pat() {
		return ((String) getAttrVal("Sd_abo_pat"));
	}	
	public void setSd_abo_pat(String Sd_abo_pat) {
		setAttrVal("Sd_abo_pat", Sd_abo_pat);
	}
	public String getId_rh_pat() {
		return ((String) getAttrVal("Id_rh_pat"));
	}	
	public void setId_rh_pat(String Id_rh_pat) {
		setAttrVal("Id_rh_pat", Id_rh_pat);
	}
	public String getSd_rh_pat() {
		return ((String) getAttrVal("Sd_rh_pat"));
	}	
	public void setSd_rh_pat(String Sd_rh_pat) {
		setAttrVal("Sd_rh_pat", Sd_rh_pat);
	}
	public String getId_emp_recheck() {
		return ((String) getAttrVal("Id_emp_recheck"));
	}	
	public void setId_emp_recheck(String Id_emp_recheck) {
		setAttrVal("Id_emp_recheck", Id_emp_recheck);
	}
	public FDateTime getDt_recheck() {
		return ((FDateTime) getAttrVal("Dt_recheck"));
	}	
	public void setDt_recheck(FDateTime Dt_recheck) {
		setAttrVal("Dt_recheck", Dt_recheck);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public Integer getNum_bt() {
		return ((Integer) getAttrVal("Num_bt"));
	}	
	public void setNum_bt(Integer Num_bt) {
		setAttrVal("Num_bt", Num_bt);
	}
	public String getId_unit_bt() {
		return ((String) getAttrVal("Id_unit_bt"));
	}	
	public void setId_unit_bt(String Id_unit_bt) {
		setAttrVal("Id_unit_bt", Id_unit_bt);
	}
	public Integer getNum_st() {
		return ((Integer) getAttrVal("Num_st"));
	}	
	public void setNum_st(Integer Num_st) {
		setAttrVal("Num_st", Num_st);
	}
	public String getId_unit_st() {
		return ((String) getAttrVal("Id_unit_st"));
	}	
	public void setId_unit_st(String Id_unit_st) {
		setAttrVal("Id_unit_st", Id_unit_st);
	}
	public String getId_su_bttest() {
		return ((String) getAttrVal("Id_su_bttest"));
	}	
	public void setId_su_bttest(String Id_su_bttest) {
		setAttrVal("Id_su_bttest", Id_su_bttest);
	}
	public String getSd_su_bttest() {
		return ((String) getAttrVal("Sd_su_bttest"));
	}	
	public void setSd_su_bttest(String Sd_su_bttest) {
		setAttrVal("Sd_su_bttest", Sd_su_bttest);
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
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	public String getApplyformno() {
		return ((String) getAttrVal("Applyformno"));
	}	
	public void setApplyformno(String Applyformno) {
		setAttrVal("Applyformno", Applyformno);
	}
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}	
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_bt() {
		return ((String) getAttrVal("Name_bt"));
	}	
	public void setName_bt(String Name_bt) {
		setAttrVal("Name_bt", Name_bt);
	}
	public String getAbo_name() {
		return ((String) getAttrVal("Abo_name"));
	}	
	public void setAbo_name(String Abo_name) {
		setAttrVal("Abo_name", Abo_name);
	}
	public String getRh_name() {
		return ((String) getAttrVal("Rh_name"));
	}	
	public void setRh_name(String Rh_name) {
		setAttrVal("Rh_name", Rh_name);
	}
	public String getRecheck_name() {
		return ((String) getAttrVal("Recheck_name"));
	}	
	public void setRecheck_name(String Recheck_name) {
		setAttrVal("Recheck_name", Recheck_name);
	}
	public String getBt_unit_name() {
		return ((String) getAttrVal("Bt_unit_name"));
	}	
	public void setBt_unit_name(String Bt_unit_name) {
		setAttrVal("Bt_unit_name", Bt_unit_name);
	}
	public String getSt_unit_name() {
		return ((String) getAttrVal("St_unit_name"));
	}	
	public void setSt_unit_name(String St_unit_name) {
		setAttrVal("St_unit_name", St_unit_name);
	}
	public String getSu_bttest_name() {
		return ((String) getAttrVal("Su_bttest_name"));
	}	
	public void setSu_bttest_name(String Su_bttest_name) {
		setAttrVal("Su_bttest_name", Su_bttest_name);
	}
	public String getMedu_name() {
		return ((String) getAttrVal("Medu_name"));
	}	
	public void setMedu_name(String Medu_name) {
		setAttrVal("Medu_name", Medu_name);
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
		return "Id_rptbttest";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_RPT_BTTEST";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrdBtTestDODesc.class);
	}
	
}
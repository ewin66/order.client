package iih.ci.mrfp.sug2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.sug2mrfp.d.desc.CiMrFpSugDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录_住院病历首页_手术 DO数据 
 * 
 */
public class CiMrFpSugDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRFPSUG= "Id_mrfpsug";
	public static final String ID_MRFP= "Id_mrfp";
	public static final String SORTNO= "Sortno";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_SUG= "Id_sug";
	public static final String SD_SUG= "Sd_sug";
	public static final String NAME_SUG= "Name_sug";
	public static final String ID_LVLSUG= "Id_lvlsug";
	public static final String SD_LVLSUG= "Sd_lvlsug";
	public static final String NAME_LVLSUG= "Name_lvlsug";
	public static final String DT_START_SUG= "Dt_start_sug";
	public static final String DT_END_SUG= "Dt_end_sug";
	public static final String ID_EMP_SUG= "Id_emp_sug";
	public static final String SD_EMP_SUG= "Sd_emp_sug";
	public static final String NAME_EMP_SUG= "Name_emp_sug";
	public static final String ID_EMP_ASST1= "Id_emp_asst1";
	public static final String SD_EMP_ASST1= "Sd_emp_asst1";
	public static final String NAME_EMP_ASST1= "Name_emp_asst1";
	public static final String ID_EMP_ASST2= "Id_emp_asst2";
	public static final String SD_EMP_ASST2= "Sd_emp_asst2";
	public static final String NAME_EMP_ASST2= "Name_emp_asst2";
	public static final String ID_EMP_ANES= "Id_emp_anes";
	public static final String SD_EMP_ANES= "Sd_emp_anes";
	public static final String NAME_EMP_ANES= "Name_emp_anes";
	public static final String ID_INCITP= "Id_incitp";
	public static final String SD_INCITP= "Sd_incitp";
	public static final String NAME_INCITP= "Name_incitp";
	public static final String ID_ANESTP= "Id_anestp";
	public static final String SD_ANESTP= "Sd_anestp";
	public static final String NAME_ANESTP= "Name_anestp";
	public static final String ID_INCICONDI= "Id_incicondi";
	public static final String SD_INCICONDI= "Sd_incicondi";
	public static final String NAME_INCICONDI= "Name_incicondi";
	public static final String SUG_CODE= "Sug_code";
	public static final String SUG_NAME= "Sug_name";
	public static final String LVLSUG_CODE= "Lvlsug_code";
	public static final String LVLSUG_NAME= "Lvlsug_name";
	public static final String EMP_SUG_NAME= "Emp_sug_name";
	public static final String EMP_SUG_CODE= "Emp_sug_code";
	public static final String EMP_ASST1_NAME= "Emp_asst1_name";
	public static final String EMP_ASST1_CODE= "Emp_asst1_code";
	public static final String EMP_ASST2_NAME= "Emp_asst2_name";
	public static final String EMP_ASST2_CODE= "Emp_asst2_code";
	public static final String EMP_ANES_NAME= "Emp_anes_name";
	public static final String EMP_ANES_CODE= "Emp_anes_code";
	public static final String INCITP_CODE= "Incitp_code";
	public static final String INCITP_NAME= "Incitp_name";
	public static final String ANESTP_CODE= "Anestp_code";
	public static final String ANESTP_NAME= "Anestp_name";
	public static final String INCICONDI_CODE= "Incicondi_code";
	public static final String INCICONDI_NAME= "Incicondi_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrfpsug() {
		return ((String) getAttrVal("Id_mrfpsug"));
	}	
	public void setId_mrfpsug(String Id_mrfpsug) {
		setAttrVal("Id_mrfpsug", Id_mrfpsug);
	}
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}	
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getId_sug() {
		return ((String) getAttrVal("Id_sug"));
	}	
	public void setId_sug(String Id_sug) {
		setAttrVal("Id_sug", Id_sug);
	}
	public String getSd_sug() {
		return ((String) getAttrVal("Sd_sug"));
	}	
	public void setSd_sug(String Sd_sug) {
		setAttrVal("Sd_sug", Sd_sug);
	}
	public String getName_sug() {
		return ((String) getAttrVal("Name_sug"));
	}	
	public void setName_sug(String Name_sug) {
		setAttrVal("Name_sug", Name_sug);
	}
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}	
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}	
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	public String getName_lvlsug() {
		return ((String) getAttrVal("Name_lvlsug"));
	}	
	public void setName_lvlsug(String Name_lvlsug) {
		setAttrVal("Name_lvlsug", Name_lvlsug);
	}
	public FDateTime getDt_start_sug() {
		return ((FDateTime) getAttrVal("Dt_start_sug"));
	}	
	public void setDt_start_sug(FDateTime Dt_start_sug) {
		setAttrVal("Dt_start_sug", Dt_start_sug);
	}
	public FDateTime getDt_end_sug() {
		return ((FDateTime) getAttrVal("Dt_end_sug"));
	}	
	public void setDt_end_sug(FDateTime Dt_end_sug) {
		setAttrVal("Dt_end_sug", Dt_end_sug);
	}
	public String getId_emp_sug() {
		return ((String) getAttrVal("Id_emp_sug"));
	}	
	public void setId_emp_sug(String Id_emp_sug) {
		setAttrVal("Id_emp_sug", Id_emp_sug);
	}
	public String getSd_emp_sug() {
		return ((String) getAttrVal("Sd_emp_sug"));
	}	
	public void setSd_emp_sug(String Sd_emp_sug) {
		setAttrVal("Sd_emp_sug", Sd_emp_sug);
	}
	public String getName_emp_sug() {
		return ((String) getAttrVal("Name_emp_sug"));
	}	
	public void setName_emp_sug(String Name_emp_sug) {
		setAttrVal("Name_emp_sug", Name_emp_sug);
	}
	public String getId_emp_asst1() {
		return ((String) getAttrVal("Id_emp_asst1"));
	}	
	public void setId_emp_asst1(String Id_emp_asst1) {
		setAttrVal("Id_emp_asst1", Id_emp_asst1);
	}
	public String getSd_emp_asst1() {
		return ((String) getAttrVal("Sd_emp_asst1"));
	}	
	public void setSd_emp_asst1(String Sd_emp_asst1) {
		setAttrVal("Sd_emp_asst1", Sd_emp_asst1);
	}
	public String getName_emp_asst1() {
		return ((String) getAttrVal("Name_emp_asst1"));
	}	
	public void setName_emp_asst1(String Name_emp_asst1) {
		setAttrVal("Name_emp_asst1", Name_emp_asst1);
	}
	public String getId_emp_asst2() {
		return ((String) getAttrVal("Id_emp_asst2"));
	}	
	public void setId_emp_asst2(String Id_emp_asst2) {
		setAttrVal("Id_emp_asst2", Id_emp_asst2);
	}
	public String getSd_emp_asst2() {
		return ((String) getAttrVal("Sd_emp_asst2"));
	}	
	public void setSd_emp_asst2(String Sd_emp_asst2) {
		setAttrVal("Sd_emp_asst2", Sd_emp_asst2);
	}
	public String getName_emp_asst2() {
		return ((String) getAttrVal("Name_emp_asst2"));
	}	
	public void setName_emp_asst2(String Name_emp_asst2) {
		setAttrVal("Name_emp_asst2", Name_emp_asst2);
	}
	public String getId_emp_anes() {
		return ((String) getAttrVal("Id_emp_anes"));
	}	
	public void setId_emp_anes(String Id_emp_anes) {
		setAttrVal("Id_emp_anes", Id_emp_anes);
	}
	public String getSd_emp_anes() {
		return ((String) getAttrVal("Sd_emp_anes"));
	}	
	public void setSd_emp_anes(String Sd_emp_anes) {
		setAttrVal("Sd_emp_anes", Sd_emp_anes);
	}
	public String getName_emp_anes() {
		return ((String) getAttrVal("Name_emp_anes"));
	}	
	public void setName_emp_anes(String Name_emp_anes) {
		setAttrVal("Name_emp_anes", Name_emp_anes);
	}
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}	
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}	
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	public String getName_incitp() {
		return ((String) getAttrVal("Name_incitp"));
	}	
	public void setName_incitp(String Name_incitp) {
		setAttrVal("Name_incitp", Name_incitp);
	}
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}	
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}	
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	public String getId_incicondi() {
		return ((String) getAttrVal("Id_incicondi"));
	}	
	public void setId_incicondi(String Id_incicondi) {
		setAttrVal("Id_incicondi", Id_incicondi);
	}
	public String getSd_incicondi() {
		return ((String) getAttrVal("Sd_incicondi"));
	}	
	public void setSd_incicondi(String Sd_incicondi) {
		setAttrVal("Sd_incicondi", Sd_incicondi);
	}
	public String getName_incicondi() {
		return ((String) getAttrVal("Name_incicondi"));
	}	
	public void setName_incicondi(String Name_incicondi) {
		setAttrVal("Name_incicondi", Name_incicondi);
	}
	public String getSug_code() {
		return ((String) getAttrVal("Sug_code"));
	}	
	public void setSug_code(String Sug_code) {
		setAttrVal("Sug_code", Sug_code);
	}
	public String getSug_name() {
		return ((String) getAttrVal("Sug_name"));
	}	
	public void setSug_name(String Sug_name) {
		setAttrVal("Sug_name", Sug_name);
	}
	public String getLvlsug_code() {
		return ((String) getAttrVal("Lvlsug_code"));
	}	
	public void setLvlsug_code(String Lvlsug_code) {
		setAttrVal("Lvlsug_code", Lvlsug_code);
	}
	public String getLvlsug_name() {
		return ((String) getAttrVal("Lvlsug_name"));
	}	
	public void setLvlsug_name(String Lvlsug_name) {
		setAttrVal("Lvlsug_name", Lvlsug_name);
	}
	public String getEmp_sug_name() {
		return ((String) getAttrVal("Emp_sug_name"));
	}	
	public void setEmp_sug_name(String Emp_sug_name) {
		setAttrVal("Emp_sug_name", Emp_sug_name);
	}
	public String getEmp_sug_code() {
		return ((String) getAttrVal("Emp_sug_code"));
	}	
	public void setEmp_sug_code(String Emp_sug_code) {
		setAttrVal("Emp_sug_code", Emp_sug_code);
	}
	public String getEmp_asst1_name() {
		return ((String) getAttrVal("Emp_asst1_name"));
	}	
	public void setEmp_asst1_name(String Emp_asst1_name) {
		setAttrVal("Emp_asst1_name", Emp_asst1_name);
	}
	public String getEmp_asst1_code() {
		return ((String) getAttrVal("Emp_asst1_code"));
	}	
	public void setEmp_asst1_code(String Emp_asst1_code) {
		setAttrVal("Emp_asst1_code", Emp_asst1_code);
	}
	public String getEmp_asst2_name() {
		return ((String) getAttrVal("Emp_asst2_name"));
	}	
	public void setEmp_asst2_name(String Emp_asst2_name) {
		setAttrVal("Emp_asst2_name", Emp_asst2_name);
	}
	public String getEmp_asst2_code() {
		return ((String) getAttrVal("Emp_asst2_code"));
	}	
	public void setEmp_asst2_code(String Emp_asst2_code) {
		setAttrVal("Emp_asst2_code", Emp_asst2_code);
	}
	public String getEmp_anes_name() {
		return ((String) getAttrVal("Emp_anes_name"));
	}	
	public void setEmp_anes_name(String Emp_anes_name) {
		setAttrVal("Emp_anes_name", Emp_anes_name);
	}
	public String getEmp_anes_code() {
		return ((String) getAttrVal("Emp_anes_code"));
	}	
	public void setEmp_anes_code(String Emp_anes_code) {
		setAttrVal("Emp_anes_code", Emp_anes_code);
	}
	public String getIncitp_code() {
		return ((String) getAttrVal("Incitp_code"));
	}	
	public void setIncitp_code(String Incitp_code) {
		setAttrVal("Incitp_code", Incitp_code);
	}
	public String getIncitp_name() {
		return ((String) getAttrVal("Incitp_name"));
	}	
	public void setIncitp_name(String Incitp_name) {
		setAttrVal("Incitp_name", Incitp_name);
	}
	public String getAnestp_code() {
		return ((String) getAttrVal("Anestp_code"));
	}	
	public void setAnestp_code(String Anestp_code) {
		setAttrVal("Anestp_code", Anestp_code);
	}
	public String getAnestp_name() {
		return ((String) getAttrVal("Anestp_name"));
	}	
	public void setAnestp_name(String Anestp_name) {
		setAttrVal("Anestp_name", Anestp_name);
	}
	public String getIncicondi_code() {
		return ((String) getAttrVal("Incicondi_code"));
	}	
	public void setIncicondi_code(String Incicondi_code) {
		setAttrVal("Incicondi_code", Incicondi_code);
	}
	public String getIncicondi_name() {
		return ((String) getAttrVal("Incicondi_name"));
	}	
	public void setIncicondi_name(String Incicondi_name) {
		setAttrVal("Incicondi_name", Incicondi_name);
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
		return "Id_mrfpsug";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_SUG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpSugDODesc.class);
	}
	
}
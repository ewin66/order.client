package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.StdDODesc;
import java.math.BigDecimal;

/**
 * 性病附卡 DO数据 
 * 
 */
public class StdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CONTAGION_STD= "Id_contagion_std";
	public static final String ID_CONTAGION= "Id_contagion";
	public static final String ID_FORM= "Id_form";
	public static final String ID_MARRY= "Id_marry";
	public static final String SD_MARRY= "Sd_marry";
	public static final String NAME_MARRY= "Name_marry";
	public static final String ID_NATION= "Id_nation";
	public static final String SD_NATION= "Sd_nation";
	public static final String NAME_NATION= "Name_nation";
	public static final String ID_EDUCATION= "Id_education";
	public static final String SD_EDUCATION= "Sd_education";
	public static final String NAME_EDUCATION= "Name_education";
	public static final String IS_STD_HISTORY= "Is_std_history";
	public static final String SD_STD_HISTORY= "Sd_std_history";
	public static final String NAME_STD_HISTORY= "Name_std_history";
	public static final String ID_CONTACT_HISTORY= "Id_contact_history";
	public static final String SD_CONTACT_HISTORY= "Sd_contact_history";
	public static final String NAME_CONTACT_HISTORY= "Name_contact_history";
	public static final String ID_INFECTION_WAY= "Id_infection_way";
	public static final String SD_INFECTION_WAY= "Sd_infection_way";
	public static final String NAME_INFECTION_WAY= "Name_infection_way";
	public static final String ID_SAMPLE_SOURCE= "Id_sample_source";
	public static final String SD_SAMPLE_SOURCE= "Sd_sample_source";
	public static final String NAME_SAMPLE_SOURCE= "Name_sample_source";
	public static final String ID_CONCLUSION= "Id_conclusion";
	public static final String SD_CONCLUSION= "Sd_conclusion";
	public static final String NAME_CONCLUSION= "Name_conclusion";
	public static final String DT_CONTAGION= "Dt_contagion";
	public static final String MARRY_CODE= "Marry_code";
	public static final String MARRY_NAME= "Marry_name";
	public static final String NATION_CODE= "Nation_code";
	public static final String NATION_NAME= "Nation_name";
	public static final String EDUCATION_CODE= "Education_code";
	public static final String EDUCATION_NAME= "Education_name";
	public static final String STD_HISTORY_CODE= "Std_history_code";
	public static final String STD_HISTORY_NAME= "Std_history_name";
	public static final String CONTACT_HISTORY_CODE= "Contact_history_code";
	public static final String CONTACT_HISTORY_NAME= "Contact_history_name";
	public static final String INFECTION_CODE= "Infection_code";
	public static final String INFECTION_NAME= "Infection_name";
	public static final String SAMPLE_CODE= "Sample_code";
	public static final String SAMPLE_NAME= "Sample_name";
	public static final String CONCLUSION_CODE= "Conclusion_code";
	public static final String CONCLUSION_NAME= "Conclusion_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_contagion_std() {
		return ((String) getAttrVal("Id_contagion_std"));
	}	
	public void setId_contagion_std(String Id_contagion_std) {
		setAttrVal("Id_contagion_std", Id_contagion_std);
	}
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}	
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}	
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}	
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}	
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	public String getId_education() {
		return ((String) getAttrVal("Id_education"));
	}	
	public void setId_education(String Id_education) {
		setAttrVal("Id_education", Id_education);
	}
	public String getSd_education() {
		return ((String) getAttrVal("Sd_education"));
	}	
	public void setSd_education(String Sd_education) {
		setAttrVal("Sd_education", Sd_education);
	}
	public String getName_education() {
		return ((String) getAttrVal("Name_education"));
	}	
	public void setName_education(String Name_education) {
		setAttrVal("Name_education", Name_education);
	}
	public String getIs_std_history() {
		return ((String) getAttrVal("Is_std_history"));
	}	
	public void setIs_std_history(String Is_std_history) {
		setAttrVal("Is_std_history", Is_std_history);
	}
	public String getSd_std_history() {
		return ((String) getAttrVal("Sd_std_history"));
	}	
	public void setSd_std_history(String Sd_std_history) {
		setAttrVal("Sd_std_history", Sd_std_history);
	}
	public String getName_std_history() {
		return ((String) getAttrVal("Name_std_history"));
	}	
	public void setName_std_history(String Name_std_history) {
		setAttrVal("Name_std_history", Name_std_history);
	}
	public String getId_contact_history() {
		return ((String) getAttrVal("Id_contact_history"));
	}	
	public void setId_contact_history(String Id_contact_history) {
		setAttrVal("Id_contact_history", Id_contact_history);
	}
	public String getSd_contact_history() {
		return ((String) getAttrVal("Sd_contact_history"));
	}	
	public void setSd_contact_history(String Sd_contact_history) {
		setAttrVal("Sd_contact_history", Sd_contact_history);
	}
	public String getName_contact_history() {
		return ((String) getAttrVal("Name_contact_history"));
	}	
	public void setName_contact_history(String Name_contact_history) {
		setAttrVal("Name_contact_history", Name_contact_history);
	}
	public String getId_infection_way() {
		return ((String) getAttrVal("Id_infection_way"));
	}	
	public void setId_infection_way(String Id_infection_way) {
		setAttrVal("Id_infection_way", Id_infection_way);
	}
	public String getSd_infection_way() {
		return ((String) getAttrVal("Sd_infection_way"));
	}	
	public void setSd_infection_way(String Sd_infection_way) {
		setAttrVal("Sd_infection_way", Sd_infection_way);
	}
	public String getName_infection_way() {
		return ((String) getAttrVal("Name_infection_way"));
	}	
	public void setName_infection_way(String Name_infection_way) {
		setAttrVal("Name_infection_way", Name_infection_way);
	}
	public String getId_sample_source() {
		return ((String) getAttrVal("Id_sample_source"));
	}	
	public void setId_sample_source(String Id_sample_source) {
		setAttrVal("Id_sample_source", Id_sample_source);
	}
	public String getSd_sample_source() {
		return ((String) getAttrVal("Sd_sample_source"));
	}	
	public void setSd_sample_source(String Sd_sample_source) {
		setAttrVal("Sd_sample_source", Sd_sample_source);
	}
	public String getName_sample_source() {
		return ((String) getAttrVal("Name_sample_source"));
	}	
	public void setName_sample_source(String Name_sample_source) {
		setAttrVal("Name_sample_source", Name_sample_source);
	}
	public String getId_conclusion() {
		return ((String) getAttrVal("Id_conclusion"));
	}	
	public void setId_conclusion(String Id_conclusion) {
		setAttrVal("Id_conclusion", Id_conclusion);
	}
	public String getSd_conclusion() {
		return ((String) getAttrVal("Sd_conclusion"));
	}	
	public void setSd_conclusion(String Sd_conclusion) {
		setAttrVal("Sd_conclusion", Sd_conclusion);
	}
	public String getName_conclusion() {
		return ((String) getAttrVal("Name_conclusion"));
	}	
	public void setName_conclusion(String Name_conclusion) {
		setAttrVal("Name_conclusion", Name_conclusion);
	}
	public FDateTime getDt_contagion() {
		return ((FDateTime) getAttrVal("Dt_contagion"));
	}	
	public void setDt_contagion(FDateTime Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}	
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	public String getMarry_name() {
		return ((String) getAttrVal("Marry_name"));
	}	
	public void setMarry_name(String Marry_name) {
		setAttrVal("Marry_name", Marry_name);
	}
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}	
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	public String getNation_name() {
		return ((String) getAttrVal("Nation_name"));
	}	
	public void setNation_name(String Nation_name) {
		setAttrVal("Nation_name", Nation_name);
	}
	public String getEducation_code() {
		return ((String) getAttrVal("Education_code"));
	}	
	public void setEducation_code(String Education_code) {
		setAttrVal("Education_code", Education_code);
	}
	public String getEducation_name() {
		return ((String) getAttrVal("Education_name"));
	}	
	public void setEducation_name(String Education_name) {
		setAttrVal("Education_name", Education_name);
	}
	public String getStd_history_code() {
		return ((String) getAttrVal("Std_history_code"));
	}	
	public void setStd_history_code(String Std_history_code) {
		setAttrVal("Std_history_code", Std_history_code);
	}
	public String getStd_history_name() {
		return ((String) getAttrVal("Std_history_name"));
	}	
	public void setStd_history_name(String Std_history_name) {
		setAttrVal("Std_history_name", Std_history_name);
	}
	public String getContact_history_code() {
		return ((String) getAttrVal("Contact_history_code"));
	}	
	public void setContact_history_code(String Contact_history_code) {
		setAttrVal("Contact_history_code", Contact_history_code);
	}
	public String getContact_history_name() {
		return ((String) getAttrVal("Contact_history_name"));
	}	
	public void setContact_history_name(String Contact_history_name) {
		setAttrVal("Contact_history_name", Contact_history_name);
	}
	public String getInfection_code() {
		return ((String) getAttrVal("Infection_code"));
	}	
	public void setInfection_code(String Infection_code) {
		setAttrVal("Infection_code", Infection_code);
	}
	public String getInfection_name() {
		return ((String) getAttrVal("Infection_name"));
	}	
	public void setInfection_name(String Infection_name) {
		setAttrVal("Infection_name", Infection_name);
	}
	public String getSample_code() {
		return ((String) getAttrVal("Sample_code"));
	}	
	public void setSample_code(String Sample_code) {
		setAttrVal("Sample_code", Sample_code);
	}
	public String getSample_name() {
		return ((String) getAttrVal("Sample_name"));
	}	
	public void setSample_name(String Sample_name) {
		setAttrVal("Sample_name", Sample_name);
	}
	public String getConclusion_code() {
		return ((String) getAttrVal("Conclusion_code"));
	}	
	public void setConclusion_code(String Conclusion_code) {
		setAttrVal("Conclusion_code", Conclusion_code);
	}
	public String getConclusion_name() {
		return ((String) getAttrVal("Conclusion_name"));
	}	
	public void setConclusion_name(String Conclusion_name) {
		setAttrVal("Conclusion_name", Conclusion_name);
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
		return "Id_contagion_std";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_STD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StdDODesc.class);
	}
	
}
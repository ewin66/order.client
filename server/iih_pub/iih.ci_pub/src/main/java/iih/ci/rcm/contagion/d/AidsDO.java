package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.AidsDODesc;
import java.math.BigDecimal;

/**
 * 艾滋病附卡 DO数据 
 * 
 */
public class AidsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AIDS= "Id_aids";
	public static final String ID_CONTAGION= "Id_contagion";
	public static final String ID_FORM= "Id_form";
	public static final String DISEASE= "Disease";
	public static final String DISEASE_CODE= "Disease_code";
	public static final String DISEASE_NAME= "Disease_name";
	public static final String IS_AIDS_HISTORY= "Is_aids_history";
	public static final String SD_AIDS_HISTORY= "Sd_aids_history";
	public static final String NAME_AIDS_HISTORY= "Name_aids_history";
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
	public static final String DT_AIDS= "Dt_aids";
	public static final String CARD_NO= "Card_no";
	public static final String PAT_NAME= "Pat_name";
	public static final String PARENT_NAME= "Parent_name";
	public static final String ID_MARRY= "Id_marry";
	public static final String CODE_MARRY= "Code_marry";
	public static final String NAME_MARRY= "Name_marry";
	public static final String HJDZ= "Hjdz";
	public static final String CODE_HJDZ= "Code_hjdz";
	public static final String NAME_HJDZ= "Name_hjdz";
	public static final String TOWN= "Town";
	public static final String VILLAGE= "Village";
	public static final String HOUSE_NO= "House_no";
	public static final String ID_CULTURE= "Id_culture";
	public static final String NAME_CULTURE= "Name_culture";
	public static final String CODE_CULTURE= "Code_culture";
	public static final String DT_CONTAGION= "Dt_contagion";
	public static final String ID_EMP_ENTRY= "Id_emp_entry";
	public static final String SD_EMP_ENTRY= "Sd_emp_entry";
	public static final String NAME_EMP_ENTRY= "Name_emp_entry";
	public static final String ID_NATION= "Id_nation";
	public static final String SD_NATION= "Sd_nation";
	public static final String NAME_NATION= "Name_nation";
	public static final String CONFIRM_DETECTION_UNITE= "Confirm_detection_unite";
	public static final String DEF1= "Def1";
	public static final String CODE_DISEASE= "Code_disease";
	public static final String NAME_DISEASE= "Name_disease";
	public static final String SD_HISTORY_CODE= "Sd_history_code";
	public static final String SD_HISTORY_NAME= "Sd_history_name";
	public static final String CONTACT_HISTORY_CODE= "Contact_history_code";
	public static final String CONTACT_HISTORY_NAME= "Contact_history_name";
	public static final String INFECTION_CODE= "Infection_code";
	public static final String INFECTION_NAME= "Infection_name";
	public static final String SAMPLE_CODE= "Sample_code";
	public static final String SAMPLE_NAME= "Sample_name";
	public static final String CONCLUSION_CODE= "Conclusion_code";
	public static final String CONCLUSION_NAME= "Conclusion_name";
	public static final String MARRY_CODE= "Marry_code";
	public static final String MARRY_NAME= "Marry_name";
	public static final String AREACODE= "Areacode";
	public static final String AREANAME= "Areaname";
	public static final String CULTURECODE= "Culturecode";
	public static final String CULTURENAME= "Culturename";
	public static final String DOCTORCODE= "Doctorcode";
	public static final String DOCTORNAME= "Doctorname";
	public static final String NATION_CODE= "Nation_code";
	public static final String NATION_NAME= "Nation_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aids() {
		return ((String) getAttrVal("Id_aids"));
	}	
	public void setId_aids(String Id_aids) {
		setAttrVal("Id_aids", Id_aids);
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
	public String getDisease() {
		return ((String) getAttrVal("Disease"));
	}	
	public void setDisease(String Disease) {
		setAttrVal("Disease", Disease);
	}
	public String getDisease_code() {
		return ((String) getAttrVal("Disease_code"));
	}	
	public void setDisease_code(String Disease_code) {
		setAttrVal("Disease_code", Disease_code);
	}
	public String getDisease_name() {
		return ((String) getAttrVal("Disease_name"));
	}	
	public void setDisease_name(String Disease_name) {
		setAttrVal("Disease_name", Disease_name);
	}
	public String getIs_aids_history() {
		return ((String) getAttrVal("Is_aids_history"));
	}	
	public void setIs_aids_history(String Is_aids_history) {
		setAttrVal("Is_aids_history", Is_aids_history);
	}
	public String getSd_aids_history() {
		return ((String) getAttrVal("Sd_aids_history"));
	}	
	public void setSd_aids_history(String Sd_aids_history) {
		setAttrVal("Sd_aids_history", Sd_aids_history);
	}
	public String getName_aids_history() {
		return ((String) getAttrVal("Name_aids_history"));
	}	
	public void setName_aids_history(String Name_aids_history) {
		setAttrVal("Name_aids_history", Name_aids_history);
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
	public FDateTime getDt_aids() {
		return ((FDateTime) getAttrVal("Dt_aids"));
	}	
	public void setDt_aids(FDateTime Dt_aids) {
		setAttrVal("Dt_aids", Dt_aids);
	}
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getParent_name() {
		return ((String) getAttrVal("Parent_name"));
	}	
	public void setParent_name(String Parent_name) {
		setAttrVal("Parent_name", Parent_name);
	}
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	public String getCode_marry() {
		return ((String) getAttrVal("Code_marry"));
	}	
	public void setCode_marry(String Code_marry) {
		setAttrVal("Code_marry", Code_marry);
	}
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	public String getHjdz() {
		return ((String) getAttrVal("Hjdz"));
	}	
	public void setHjdz(String Hjdz) {
		setAttrVal("Hjdz", Hjdz);
	}
	public String getCode_hjdz() {
		return ((String) getAttrVal("Code_hjdz"));
	}	
	public void setCode_hjdz(String Code_hjdz) {
		setAttrVal("Code_hjdz", Code_hjdz);
	}
	public String getName_hjdz() {
		return ((String) getAttrVal("Name_hjdz"));
	}	
	public void setName_hjdz(String Name_hjdz) {
		setAttrVal("Name_hjdz", Name_hjdz);
	}
	public String getTown() {
		return ((String) getAttrVal("Town"));
	}	
	public void setTown(String Town) {
		setAttrVal("Town", Town);
	}
	public String getVillage() {
		return ((String) getAttrVal("Village"));
	}	
	public void setVillage(String Village) {
		setAttrVal("Village", Village);
	}
	public String getHouse_no() {
		return ((String) getAttrVal("House_no"));
	}	
	public void setHouse_no(String House_no) {
		setAttrVal("House_no", House_no);
	}
	public String getId_culture() {
		return ((String) getAttrVal("Id_culture"));
	}	
	public void setId_culture(String Id_culture) {
		setAttrVal("Id_culture", Id_culture);
	}
	public String getName_culture() {
		return ((String) getAttrVal("Name_culture"));
	}	
	public void setName_culture(String Name_culture) {
		setAttrVal("Name_culture", Name_culture);
	}
	public String getCode_culture() {
		return ((String) getAttrVal("Code_culture"));
	}	
	public void setCode_culture(String Code_culture) {
		setAttrVal("Code_culture", Code_culture);
	}
	public FDate getDt_contagion() {
		return ((FDate) getAttrVal("Dt_contagion"));
	}	
	public void setDt_contagion(FDate Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}	
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	public String getSd_emp_entry() {
		return ((String) getAttrVal("Sd_emp_entry"));
	}	
	public void setSd_emp_entry(String Sd_emp_entry) {
		setAttrVal("Sd_emp_entry", Sd_emp_entry);
	}
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}	
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
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
	public String getConfirm_detection_unite() {
		return ((String) getAttrVal("Confirm_detection_unite"));
	}	
	public void setConfirm_detection_unite(String Confirm_detection_unite) {
		setAttrVal("Confirm_detection_unite", Confirm_detection_unite);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getCode_disease() {
		return ((String) getAttrVal("Code_disease"));
	}	
	public void setCode_disease(String Code_disease) {
		setAttrVal("Code_disease", Code_disease);
	}
	public String getName_disease() {
		return ((String) getAttrVal("Name_disease"));
	}	
	public void setName_disease(String Name_disease) {
		setAttrVal("Name_disease", Name_disease);
	}
	public String getSd_history_code() {
		return ((String) getAttrVal("Sd_history_code"));
	}	
	public void setSd_history_code(String Sd_history_code) {
		setAttrVal("Sd_history_code", Sd_history_code);
	}
	public String getSd_history_name() {
		return ((String) getAttrVal("Sd_history_name"));
	}	
	public void setSd_history_name(String Sd_history_name) {
		setAttrVal("Sd_history_name", Sd_history_name);
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
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}	
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	public String getAreaname() {
		return ((String) getAttrVal("Areaname"));
	}	
	public void setAreaname(String Areaname) {
		setAttrVal("Areaname", Areaname);
	}
	public String getCulturecode() {
		return ((String) getAttrVal("Culturecode"));
	}	
	public void setCulturecode(String Culturecode) {
		setAttrVal("Culturecode", Culturecode);
	}
	public String getCulturename() {
		return ((String) getAttrVal("Culturename"));
	}	
	public void setCulturename(String Culturename) {
		setAttrVal("Culturename", Culturename);
	}
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}	
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}	
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
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
		return "Id_aids";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_AIDS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AidsDODesc.class);
	}
	
}
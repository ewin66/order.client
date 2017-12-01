package iih.ci.rcm.hospitalreport.d;

import iih.ci.rcm.hospitalreport.d.desc.HospitalReportDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 院感上报 DO数据
 * 
 */
public class HospitalReportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HOSPITALREPORT = "Id_hospitalreport";
	public static final String ID_ENT = "Id_ent";
	public static final String ADMISSION_DATE = "Admission_date";
	public static final String DISCHARGE_DATE = "Discharge_date";
	public static final String IN_HOSPITAL_DAYS = "In_hospital_days";
	public static final String MONITOR_DATE = "Monitor_date";
	public static final String ID_DI_DIAGNOSIS = "Id_di_diagnosis";
	public static final String SD_DI_DIAGNOSIS = "Sd_di_diagnosis";
	public static final String NAME_DI_DIAGNOSIS = "Name_di_diagnosis";
	public static final String ID_DISEASE_OUTCOME = "Id_disease_outcome";
	public static final String SD_DISEASE_OUTCOME = "Sd_disease_outcome";
	public static final String NAME_DISEASE_OUTCOME = "Name_disease_outcome";
	public static final String ID_RELA_WITH_DEATH = "Id_rela_with_death";
	public static final String SD_RELA_WITH_DEATH = "Sd_rela_with_death";
	public static final String NAME_RELA_WITH_DEATH = "Name_rela_with_death";
	public static final String INFECTIOUS_DISEASE = "Infectious_disease";
	public static final String DIAGNOSIS_BASIS = "Diagnosis_basis";
	public static final String IS_TREATMENT_IN_ICU = "Is_treatment_in_icu";
	public static final String ID_ICU_TYPE = "Id_icu_type";
	public static final String SD_ICU_TYPE = "Sd_icu_type";
	public static final String NAME_ICU_TYPE = "Name_icu_type";
	public static final String HOSPITAL_OCCURRENCE_DATE = "Hospital_occurrence_date";
	public static final String ID_INFECTION_FACTORS = "Id_infection_factors";
	public static final String SD_INFECTION_FACTORS = "Sd_infection_factors";
	public static final String NAME_INFECTION_FACTORS = "Name_infection_factors";
	public static final String IS_SURGERY = "Is_surgery";
	public static final String DI_OF_HOSP_INFECTION = "Di_of_hosp_infection";
	public static final String IS_ETIOL_EXAMINATION = "Is_etiol_examination";
	public static final String IS_USE_ANTIBIOTICS = "Is_use_antibiotics";
	public static final String IS_LATE = "Is_late";
	public static final String FILL_IN_PERSON = "Fill_in_person";
	public static final String FILL_IN_DATE = "Fill_in_date";
	public static final String TITLE = "Title";
	public static final String ID_STAGE = "Id_stage";
	public static final String SD_STAGE = "Sd_stage";
	public static final String NAME_STAGE = "Name_stage";
	public static final String REJECT_REASON = "Reject_reason";
	public static final String DELETE_REASON = "Delete_reason";
	public static final String DELETEBY = "Deleteby";
	public static final String CODE_DELETEBY = "Code_deleteby";
	public static final String NAME_DELETEBY = "Name_deleteby";
	public static final String DELETETIME = "Deletetime";
	public static final String DI_DIAGNOSIS_CODE = "Di_diagnosis_code";
	public static final String DI_DIAGNOSIS_NAME = "Di_diagnosis_name";
	public static final String DISEASE_OUTCOME_CODE = "Disease_outcome_code";
	public static final String DISEASE_OUTCOME_NAME = "Disease_outcome_name";
	public static final String RELATIONSHIP_WITH_DEATH_CODE = "Relationship_with_death_code";
	public static final String RELATIONSHIP_WITH_DEATH_NAME = "Relationship_with_death_name";
	public static final String ICU_TYPE_CODE = "Icu_type_code";
	public static final String ICU_TYPE_NAME = "Icu_type_name";
	public static final String INFECTION_FACTORS_CODE = "Infection_factors_code";
	public static final String INFECTION_FACTORS_NAME = "Infection_factors_name";
	public static final String STAGE_CODE = "Stage_code";
	public static final String STAGE_NAME = "Stage_name";
	public static final String DELETEBY_CODE = "Deleteby_code";
	public static final String DELETEBY_NAME = "Deleteby_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";

	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}

	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}

	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}

	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}

	public FDate getAdmission_date() {
		return ((FDate) getAttrVal("Admission_date"));
	}

	public void setAdmission_date(FDate Admission_date) {
		setAttrVal("Admission_date", Admission_date);
	}

	public FDate getDischarge_date() {
		return ((FDate) getAttrVal("Discharge_date"));
	}

	public void setDischarge_date(FDate Discharge_date) {
		setAttrVal("Discharge_date", Discharge_date);
	}

	public Integer getIn_hospital_days() {
		return ((Integer) getAttrVal("In_hospital_days"));
	}

	public void setIn_hospital_days(Integer In_hospital_days) {
		setAttrVal("In_hospital_days", In_hospital_days);
	}

	public FDate getMonitor_date() {
		return ((FDate) getAttrVal("Monitor_date"));
	}

	public void setMonitor_date(FDate Monitor_date) {
		setAttrVal("Monitor_date", Monitor_date);
	}

	public String getId_di_diagnosis() {
		return ((String) getAttrVal("Id_di_diagnosis"));
	}

	public void setId_di_diagnosis(String Id_di_diagnosis) {
		setAttrVal("Id_di_diagnosis", Id_di_diagnosis);
	}

	public String getSd_di_diagnosis() {
		return ((String) getAttrVal("Sd_di_diagnosis"));
	}

	public void setSd_di_diagnosis(String Sd_di_diagnosis) {
		setAttrVal("Sd_di_diagnosis", Sd_di_diagnosis);
	}

	public String getName_di_diagnosis() {
		return ((String) getAttrVal("Name_di_diagnosis"));
	}

	public void setName_di_diagnosis(String Name_di_diagnosis) {
		setAttrVal("Name_di_diagnosis", Name_di_diagnosis);
	}

	public String getId_disease_outcome() {
		return ((String) getAttrVal("Id_disease_outcome"));
	}

	public void setId_disease_outcome(String Id_disease_outcome) {
		setAttrVal("Id_disease_outcome", Id_disease_outcome);
	}

	public String getSd_disease_outcome() {
		return ((String) getAttrVal("Sd_disease_outcome"));
	}

	public void setSd_disease_outcome(String Sd_disease_outcome) {
		setAttrVal("Sd_disease_outcome", Sd_disease_outcome);
	}

	public String getName_disease_outcome() {
		return ((String) getAttrVal("Name_disease_outcome"));
	}

	public void setName_disease_outcome(String Name_disease_outcome) {
		setAttrVal("Name_disease_outcome", Name_disease_outcome);
	}

	public String getId_rela_with_death() {
		return ((String) getAttrVal("Id_rela_with_death"));
	}

	public void setId_rela_with_death(String Id_rela_with_death) {
		setAttrVal("Id_rela_with_death", Id_rela_with_death);
	}

	public String getSd_rela_with_death() {
		return ((String) getAttrVal("Sd_rela_with_death"));
	}

	public void setSd_rela_with_death(String Sd_rela_with_death) {
		setAttrVal("Sd_rela_with_death", Sd_rela_with_death);
	}

	public String getName_rela_with_death() {
		return ((String) getAttrVal("Name_rela_with_death"));
	}

	public void setName_rela_with_death(String Name_rela_with_death) {
		setAttrVal("Name_rela_with_death", Name_rela_with_death);
	}

	public String getInfectious_disease() {
		return ((String) getAttrVal("Infectious_disease"));
	}

	public void setInfectious_disease(String Infectious_disease) {
		setAttrVal("Infectious_disease", Infectious_disease);
	}

	public String getDiagnosis_basis() {
		return ((String) getAttrVal("Diagnosis_basis"));
	}

	public void setDiagnosis_basis(String Diagnosis_basis) {
		setAttrVal("Diagnosis_basis", Diagnosis_basis);
	}

	public FBoolean getIs_treatment_in_icu() {
		return ((FBoolean) getAttrVal("Is_treatment_in_icu"));
	}

	public void setIs_treatment_in_icu(FBoolean Is_treatment_in_icu) {
		setAttrVal("Is_treatment_in_icu", Is_treatment_in_icu);
	}

	public String getId_icu_type() {
		return ((String) getAttrVal("Id_icu_type"));
	}

	public void setId_icu_type(String Id_icu_type) {
		setAttrVal("Id_icu_type", Id_icu_type);
	}

	public String getSd_icu_type() {
		return ((String) getAttrVal("Sd_icu_type"));
	}

	public void setSd_icu_type(String Sd_icu_type) {
		setAttrVal("Sd_icu_type", Sd_icu_type);
	}

	public String getName_icu_type() {
		return ((String) getAttrVal("Name_icu_type"));
	}

	public void setName_icu_type(String Name_icu_type) {
		setAttrVal("Name_icu_type", Name_icu_type);
	}

	public FDate getHospital_occurrence_date() {
		return ((FDate) getAttrVal("Hospital_occurrence_date"));
	}

	public void setHospital_occurrence_date(FDate Hospital_occurrence_date) {
		setAttrVal("Hospital_occurrence_date", Hospital_occurrence_date);
	}

	public String getId_infection_factors() {
		return ((String) getAttrVal("Id_infection_factors"));
	}

	public void setId_infection_factors(String Id_infection_factors) {
		setAttrVal("Id_infection_factors", Id_infection_factors);
	}

	public String getSd_infection_factors() {
		return ((String) getAttrVal("Sd_infection_factors"));
	}

	public void setSd_infection_factors(String Sd_infection_factors) {
		setAttrVal("Sd_infection_factors", Sd_infection_factors);
	}

	public String getName_infection_factors() {
		return ((String) getAttrVal("Name_infection_factors"));
	}

	public void setName_infection_factors(String Name_infection_factors) {
		setAttrVal("Name_infection_factors", Name_infection_factors);
	}

	public FBoolean getIs_surgery() {
		return ((FBoolean) getAttrVal("Is_surgery"));
	}

	public void setIs_surgery(FBoolean Is_surgery) {
		setAttrVal("Is_surgery", Is_surgery);
	}

	public String getDi_of_hosp_infection() {
		return ((String) getAttrVal("Di_of_hosp_infection"));
	}

	public void setDi_of_hosp_infection(String Di_of_hosp_infection) {
		setAttrVal("Di_of_hosp_infection", Di_of_hosp_infection);
	}

	public FBoolean getIs_etiol_examination() {
		return ((FBoolean) getAttrVal("Is_etiol_examination"));
	}

	public void setIs_etiol_examination(FBoolean Is_etiol_examination) {
		setAttrVal("Is_etiol_examination", Is_etiol_examination);
	}

	public FBoolean getIs_use_antibiotics() {
		return ((FBoolean) getAttrVal("Is_use_antibiotics"));
	}

	public void setIs_use_antibiotics(FBoolean Is_use_antibiotics) {
		setAttrVal("Is_use_antibiotics", Is_use_antibiotics);
	}

	public FBoolean getIs_late() {
		return ((FBoolean) getAttrVal("Is_late"));
	}

	public void setIs_late(FBoolean Is_late) {
		setAttrVal("Is_late", Is_late);
	}

	public String getFill_in_person() {
		return ((String) getAttrVal("Fill_in_person"));
	}

	public void setFill_in_person(String Fill_in_person) {
		setAttrVal("Fill_in_person", Fill_in_person);
	}

	public FDate getFill_in_date() {
		return ((FDate) getAttrVal("Fill_in_date"));
	}

	public void setFill_in_date(FDate Fill_in_date) {
		setAttrVal("Fill_in_date", Fill_in_date);
	}

	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}

	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}

	public String getId_stage() {
		return ((String) getAttrVal("Id_stage"));
	}

	public void setId_stage(String Id_stage) {
		setAttrVal("Id_stage", Id_stage);
	}

	public String getSd_stage() {
		return ((String) getAttrVal("Sd_stage"));
	}

	public void setSd_stage(String Sd_stage) {
		setAttrVal("Sd_stage", Sd_stage);
	}

	public String getName_stage() {
		return ((String) getAttrVal("Name_stage"));
	}

	public void setName_stage(String Name_stage) {
		setAttrVal("Name_stage", Name_stage);
	}

	public String getReject_reason() {
		return ((String) getAttrVal("Reject_reason"));
	}

	public void setReject_reason(String Reject_reason) {
		setAttrVal("Reject_reason", Reject_reason);
	}

	public String getDelete_reason() {
		return ((String) getAttrVal("Delete_reason"));
	}

	public void setDelete_reason(String Delete_reason) {
		setAttrVal("Delete_reason", Delete_reason);
	}

	public String getDeleteby() {
		return ((String) getAttrVal("Deleteby"));
	}

	public void setDeleteby(String Deleteby) {
		setAttrVal("Deleteby", Deleteby);
	}

	public String getCode_deleteby() {
		return ((String) getAttrVal("Code_deleteby"));
	}

	public void setCode_deleteby(String Code_deleteby) {
		setAttrVal("Code_deleteby", Code_deleteby);
	}

	public String getName_deleteby() {
		return ((String) getAttrVal("Name_deleteby"));
	}

	public void setName_deleteby(String Name_deleteby) {
		setAttrVal("Name_deleteby", Name_deleteby);
	}

	public FDateTime getDeletetime() {
		return ((FDateTime) getAttrVal("Deletetime"));
	}

	public void setDeletetime(FDateTime Deletetime) {
		setAttrVal("Deletetime", Deletetime);
	}

	public String getDi_diagnosis_code() {
		return ((String) getAttrVal("Di_diagnosis_code"));
	}

	public void setDi_diagnosis_code(String Di_diagnosis_code) {
		setAttrVal("Di_diagnosis_code", Di_diagnosis_code);
	}

	public String getDi_diagnosis_name() {
		return ((String) getAttrVal("Di_diagnosis_name"));
	}

	public void setDi_diagnosis_name(String Di_diagnosis_name) {
		setAttrVal("Di_diagnosis_name", Di_diagnosis_name);
	}

	public String getDisease_outcome_code() {
		return ((String) getAttrVal("Disease_outcome_code"));
	}

	public void setDisease_outcome_code(String Disease_outcome_code) {
		setAttrVal("Disease_outcome_code", Disease_outcome_code);
	}

	public String getDisease_outcome_name() {
		return ((String) getAttrVal("Disease_outcome_name"));
	}

	public void setDisease_outcome_name(String Disease_outcome_name) {
		setAttrVal("Disease_outcome_name", Disease_outcome_name);
	}

	public String getRelationship_with_death_code() {
		return ((String) getAttrVal("Relationship_with_death_code"));
	}

	public void setRelationship_with_death_code(
			String Relationship_with_death_code) {
		setAttrVal("Relationship_with_death_code", Relationship_with_death_code);
	}

	public String getRelationship_with_death_name() {
		return ((String) getAttrVal("Relationship_with_death_name"));
	}

	public void setRelationship_with_death_name(
			String Relationship_with_death_name) {
		setAttrVal("Relationship_with_death_name", Relationship_with_death_name);
	}

	public String getIcu_type_code() {
		return ((String) getAttrVal("Icu_type_code"));
	}

	public void setIcu_type_code(String Icu_type_code) {
		setAttrVal("Icu_type_code", Icu_type_code);
	}

	public String getIcu_type_name() {
		return ((String) getAttrVal("Icu_type_name"));
	}

	public void setIcu_type_name(String Icu_type_name) {
		setAttrVal("Icu_type_name", Icu_type_name);
	}

	public String getInfection_factors_code() {
		return ((String) getAttrVal("Infection_factors_code"));
	}

	public void setInfection_factors_code(String Infection_factors_code) {
		setAttrVal("Infection_factors_code", Infection_factors_code);
	}

	public String getInfection_factors_name() {
		return ((String) getAttrVal("Infection_factors_name"));
	}

	public void setInfection_factors_name(String Infection_factors_name) {
		setAttrVal("Infection_factors_name", Infection_factors_name);
	}

	public String getStage_code() {
		return ((String) getAttrVal("Stage_code"));
	}

	public void setStage_code(String Stage_code) {
		setAttrVal("Stage_code", Stage_code);
	}

	public String getStage_name() {
		return ((String) getAttrVal("Stage_name"));
	}

	public void setStage_name(String Stage_name) {
		setAttrVal("Stage_name", Stage_name);
	}

	public String getDeleteby_code() {
		return ((String) getAttrVal("Deleteby_code"));
	}

	public void setDeleteby_code(String Deleteby_code) {
		setAttrVal("Deleteby_code", Deleteby_code);
	}

	public String getDeleteby_name() {
		return ((String) getAttrVal("Deleteby_name"));
	}

	public void setDeleteby_name(String Deleteby_name) {
		setAttrVal("Deleteby_name", Deleteby_name);
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

	// @Override
	// public java.lang.String getParentPKFieldName() {
	// return null;
	// }

	@Override
	public String getPKFieldName() {
		return "Id_hospitalreport";
	}

	@Override
	public String getTableName() {
		return "CI_MR_HOS_REPORT";
	}

	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HospitalReportDODesc.class);
	}

}
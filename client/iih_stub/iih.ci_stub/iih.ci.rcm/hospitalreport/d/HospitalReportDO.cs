
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.hospitalreport.d
{
    /// <summary>
    /// HospitalReportDO 的摘要说明。
    /// </summary>
    public class HospitalReportDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_HOS_REPORT";
		public const string TABLE_ALIAS_NAME = "a0";

        public HospitalReportDO() {
            this.Is_treatment_in_icu = false;
            this.Is_surgery = false;
            this.Is_etiol_examination = false;
            this.Is_use_antibiotics = false;
            this.Is_late = false;
        }
		public string Id_hospitalreport {
            get { return getAttrVal<string>("Id_hospitalreport",null); }
            set { setAttrVal<string>("Id_hospitalreport", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public DateTime? Admission_date {
            get { return getAttrVal<FDate>("Admission_date",null); }
            set { setAttrVal<FDate>("Admission_date", value); }
        }
		public DateTime? Discharge_date {
            get { return getAttrVal<FDate>("Discharge_date",null); }
            set { setAttrVal<FDate>("Discharge_date", value); }
        }
		public int? In_hospital_days {
            get { return getAttrVal<int?>("In_hospital_days",null); }
            set { setAttrVal<int?>("In_hospital_days", value); }
        }
		public DateTime? Monitor_date {
            get { return getAttrVal<FDate>("Monitor_date",null); }
            set { setAttrVal<FDate>("Monitor_date", value); }
        }
		public string Id_di_diagnosis {
            get { return getAttrVal<string>("Id_di_diagnosis",null); }
            set { setAttrVal<string>("Id_di_diagnosis", value); }
        }
		public string Sd_di_diagnosis {
            get { return getAttrVal<string>("Sd_di_diagnosis",null); }
            set { setAttrVal<string>("Sd_di_diagnosis", value); }
        }
		public string Name_di_diagnosis {
            get { return getAttrVal<string>("Name_di_diagnosis",null); }
            set { setAttrVal<string>("Name_di_diagnosis", value); }
        }
		public string Id_disease_outcome {
            get { return getAttrVal<string>("Id_disease_outcome",null); }
            set { setAttrVal<string>("Id_disease_outcome", value); }
        }
		public string Sd_disease_outcome {
            get { return getAttrVal<string>("Sd_disease_outcome",null); }
            set { setAttrVal<string>("Sd_disease_outcome", value); }
        }
		public string Name_disease_outcome {
            get { return getAttrVal<string>("Name_disease_outcome",null); }
            set { setAttrVal<string>("Name_disease_outcome", value); }
        }
		public string Id_rela_with_death {
            get { return getAttrVal<string>("Id_rela_with_death",null); }
            set { setAttrVal<string>("Id_rela_with_death", value); }
        }
		public string Sd_rela_with_death {
            get { return getAttrVal<string>("Sd_rela_with_death",null); }
            set { setAttrVal<string>("Sd_rela_with_death", value); }
        }
		public string Name_rela_with_death {
            get { return getAttrVal<string>("Name_rela_with_death",null); }
            set { setAttrVal<string>("Name_rela_with_death", value); }
        }
		public string Infectious_disease {
            get { return getAttrVal<string>("Infectious_disease",null); }
            set { setAttrVal<string>("Infectious_disease", value); }
        }
		public string Diagnosis_basis {
            get { return getAttrVal<string>("Diagnosis_basis",null); }
            set { setAttrVal<string>("Diagnosis_basis", value); }
        }
		public bool? Is_treatment_in_icu {
            get { return getAttrVal<FBoolean>("Is_treatment_in_icu",false); }
            set { setAttrVal<FBoolean>("Is_treatment_in_icu", value); }
        }
		public string Id_icu_type {
            get { return getAttrVal<string>("Id_icu_type",null); }
            set { setAttrVal<string>("Id_icu_type", value); }
        }
		public string Sd_icu_type {
            get { return getAttrVal<string>("Sd_icu_type",null); }
            set { setAttrVal<string>("Sd_icu_type", value); }
        }
		public string Name_icu_type {
            get { return getAttrVal<string>("Name_icu_type",null); }
            set { setAttrVal<string>("Name_icu_type", value); }
        }
		public DateTime? Hospital_occurrence_date {
            get { return getAttrVal<FDate>("Hospital_occurrence_date",null); }
            set { setAttrVal<FDate>("Hospital_occurrence_date", value); }
        }
		public string Id_infection_factors {
            get { return getAttrVal<string>("Id_infection_factors",null); }
            set { setAttrVal<string>("Id_infection_factors", value); }
        }
		public string Sd_infection_factors {
            get { return getAttrVal<string>("Sd_infection_factors",null); }
            set { setAttrVal<string>("Sd_infection_factors", value); }
        }
		public string Name_infection_factors {
            get { return getAttrVal<string>("Name_infection_factors",null); }
            set { setAttrVal<string>("Name_infection_factors", value); }
        }
		public bool? Is_surgery {
            get { return getAttrVal<FBoolean>("Is_surgery",false); }
            set { setAttrVal<FBoolean>("Is_surgery", value); }
        }
		public string Di_of_hosp_infection {
            get { return getAttrVal<string>("Di_of_hosp_infection",null); }
            set { setAttrVal<string>("Di_of_hosp_infection", value); }
        }
		public bool? Is_etiol_examination {
            get { return getAttrVal<FBoolean>("Is_etiol_examination",false); }
            set { setAttrVal<FBoolean>("Is_etiol_examination", value); }
        }
		public bool? Is_use_antibiotics {
            get { return getAttrVal<FBoolean>("Is_use_antibiotics",false); }
            set { setAttrVal<FBoolean>("Is_use_antibiotics", value); }
        }
		public bool? Is_late {
            get { return getAttrVal<FBoolean>("Is_late",false); }
            set { setAttrVal<FBoolean>("Is_late", value); }
        }
		public string Fill_in_person {
            get { return getAttrVal<string>("Fill_in_person",null); }
            set { setAttrVal<string>("Fill_in_person", value); }
        }
		public DateTime? Fill_in_date {
            get { return getAttrVal<FDate>("Fill_in_date",null); }
            set { setAttrVal<FDate>("Fill_in_date", value); }
        }
		public string Title {
            get { return getAttrVal<string>("Title",null); }
            set { setAttrVal<string>("Title", value); }
        }
		public string Id_stage {
            get { return getAttrVal<string>("Id_stage",null); }
            set { setAttrVal<string>("Id_stage", value); }
        }
		public string Sd_stage {
            get { return getAttrVal<string>("Sd_stage",null); }
            set { setAttrVal<string>("Sd_stage", value); }
        }
		public string Name_stage {
            get { return getAttrVal<string>("Name_stage",null); }
            set { setAttrVal<string>("Name_stage", value); }
        }
		public string Reject_reason {
            get { return getAttrVal<string>("Reject_reason",null); }
            set { setAttrVal<string>("Reject_reason", value); }
        }
		public string Delete_reason {
            get { return getAttrVal<string>("Delete_reason",null); }
            set { setAttrVal<string>("Delete_reason", value); }
        }
		public string Deleteby {
            get { return getAttrVal<string>("Deleteby",null); }
            set { setAttrVal<string>("Deleteby", value); }
        }
		public string Code_deleteby {
            get { return getAttrVal<string>("Code_deleteby",null); }
            set { setAttrVal<string>("Code_deleteby", value); }
        }
		public string Name_deleteby {
            get { return getAttrVal<string>("Name_deleteby",null); }
            set { setAttrVal<string>("Name_deleteby", value); }
        }
		public DateTime? Deletetime {
            get { return getAttrVal<FDateTime>("Deletetime",null); }
            set { setAttrVal<FDateTime>("Deletetime", value); }
        }
		public string Di_diagnosis_code {
            get { return getAttrVal<string>("Di_diagnosis_code",null); }
            set { setAttrVal<string>("Di_diagnosis_code", value); }
        }
		public string Di_diagnosis_name {
            get { return getAttrVal<string>("Di_diagnosis_name",null); }
            set { setAttrVal<string>("Di_diagnosis_name", value); }
        }
		public string Disease_outcome_code {
            get { return getAttrVal<string>("Disease_outcome_code",null); }
            set { setAttrVal<string>("Disease_outcome_code", value); }
        }
		public string Disease_outcome_name {
            get { return getAttrVal<string>("Disease_outcome_name",null); }
            set { setAttrVal<string>("Disease_outcome_name", value); }
        }
		public string Relationship_with_death_code {
            get { return getAttrVal<string>("Relationship_with_death_code",null); }
            set { setAttrVal<string>("Relationship_with_death_code", value); }
        }
		public string Relationship_with_death_name {
            get { return getAttrVal<string>("Relationship_with_death_name",null); }
            set { setAttrVal<string>("Relationship_with_death_name", value); }
        }
		public string Icu_type_code {
            get { return getAttrVal<string>("Icu_type_code",null); }
            set { setAttrVal<string>("Icu_type_code", value); }
        }
		public string Icu_type_name {
            get { return getAttrVal<string>("Icu_type_name",null); }
            set { setAttrVal<string>("Icu_type_name", value); }
        }
		public string Infection_factors_code {
            get { return getAttrVal<string>("Infection_factors_code",null); }
            set { setAttrVal<string>("Infection_factors_code", value); }
        }
		public string Infection_factors_name {
            get { return getAttrVal<string>("Infection_factors_name",null); }
            set { setAttrVal<string>("Infection_factors_name", value); }
        }
		public string Stage_code {
            get { return getAttrVal<string>("Stage_code",null); }
            set { setAttrVal<string>("Stage_code", value); }
        }
		public string Stage_name {
            get { return getAttrVal<string>("Stage_name",null); }
            set { setAttrVal<string>("Stage_name", value); }
        }
		public string Deleteby_code {
            get { return getAttrVal<string>("Deleteby_code",null); }
            set { setAttrVal<string>("Deleteby_code", value); }
        }
		public string Deleteby_name {
            get { return getAttrVal<string>("Deleteby_name",null); }
            set { setAttrVal<string>("Deleteby_name", value); }
        }
        public int Ds {
            get { return getAttrVal<int>("Ds",0);}
            set { setAttrVal<int>("Ds", value); }
        }

        public DateTime? Sv        {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }
        
        /// <summary>
        /// 返回表名
        /// </summary>
        /// <returns></returns>
        public override string getTableName()
        {
            return "CI_MR_HOS_REPORT";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a0";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_hospitalreport";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.hospitalreport.d.HospitalReportDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_hospitalreport", "Id_ent", "Admission_date", "Discharge_date", "In_hospital_days", "Monitor_date", "Id_di_diagnosis", "Sd_di_diagnosis", "Name_di_diagnosis", "Id_disease_outcome", "Sd_disease_outcome", "Name_disease_outcome", "Id_rela_with_death", "Sd_rela_with_death", "Name_rela_with_death", "Infectious_disease", "Diagnosis_basis", "Is_treatment_in_icu", "Id_icu_type", "Sd_icu_type", "Name_icu_type", "Hospital_occurrence_date", "Id_infection_factors", "Sd_infection_factors", "Name_infection_factors", "Is_surgery", "Di_of_hosp_infection", "Is_etiol_examination", "Is_use_antibiotics", "Is_late", "Fill_in_person", "Fill_in_date", "Title", "Id_stage", "Sd_stage", "Name_stage", "Reject_reason", "Delete_reason", "Deleteby", "Code_deleteby", "Name_deleteby", "Deletetime", "Di_diagnosis_code", "Di_diagnosis_name", "Disease_outcome_code", "Disease_outcome_name", "Relationship_with_death_code", "Relationship_with_death_name", "Icu_type_code", "Icu_type_name", "Infection_factors_code", "Infection_factors_name", "Stage_code", "Stage_name", "Deleteby_code", "Deleteby_name"};
        }
        
    }
}

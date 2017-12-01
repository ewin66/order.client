
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagion.d
{
    /// <summary>
    /// AidsDO 的摘要说明。
    /// </summary>
    public class AidsDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_CONTAGION_CARD_AIDS";
		public const string TABLE_ALIAS_NAME = "a5";

        public AidsDO() {
        }
		public string Id_aids {
            get { return getAttrVal<string>("Id_aids",null); }
            set { setAttrVal<string>("Id_aids", value); }
        }
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }
		public string Id_form {
            get { return getAttrVal<string>("Id_form",null); }
            set { setAttrVal<string>("Id_form", value); }
        }
		public string Disease {
            get { return getAttrVal<string>("Disease",null); }
            set { setAttrVal<string>("Disease", value); }
        }
		public string Disease_code {
            get { return getAttrVal<string>("Disease_code",null); }
            set { setAttrVal<string>("Disease_code", value); }
        }
		public string Disease_name {
            get { return getAttrVal<string>("Disease_name",null); }
            set { setAttrVal<string>("Disease_name", value); }
        }
		public string Is_aids_history {
            get { return getAttrVal<string>("Is_aids_history",null); }
            set { setAttrVal<string>("Is_aids_history", value); }
        }
		public string Sd_aids_history {
            get { return getAttrVal<string>("Sd_aids_history",null); }
            set { setAttrVal<string>("Sd_aids_history", value); }
        }
		public string Name_aids_history {
            get { return getAttrVal<string>("Name_aids_history",null); }
            set { setAttrVal<string>("Name_aids_history", value); }
        }
		public string Id_contact_history {
            get { return getAttrVal<string>("Id_contact_history",null); }
            set { setAttrVal<string>("Id_contact_history", value); }
        }
		public string Sd_contact_history {
            get { return getAttrVal<string>("Sd_contact_history",null); }
            set { setAttrVal<string>("Sd_contact_history", value); }
        }
		public string Name_contact_history {
            get { return getAttrVal<string>("Name_contact_history",null); }
            set { setAttrVal<string>("Name_contact_history", value); }
        }
		public string Id_infection_way {
            get { return getAttrVal<string>("Id_infection_way",null); }
            set { setAttrVal<string>("Id_infection_way", value); }
        }
		public string Sd_infection_way {
            get { return getAttrVal<string>("Sd_infection_way",null); }
            set { setAttrVal<string>("Sd_infection_way", value); }
        }
		public string Name_infection_way {
            get { return getAttrVal<string>("Name_infection_way",null); }
            set { setAttrVal<string>("Name_infection_way", value); }
        }
		public string Id_sample_source {
            get { return getAttrVal<string>("Id_sample_source",null); }
            set { setAttrVal<string>("Id_sample_source", value); }
        }
		public string Sd_sample_source {
            get { return getAttrVal<string>("Sd_sample_source",null); }
            set { setAttrVal<string>("Sd_sample_source", value); }
        }
		public string Name_sample_source {
            get { return getAttrVal<string>("Name_sample_source",null); }
            set { setAttrVal<string>("Name_sample_source", value); }
        }
		public string Id_conclusion {
            get { return getAttrVal<string>("Id_conclusion",null); }
            set { setAttrVal<string>("Id_conclusion", value); }
        }
		public string Sd_conclusion {
            get { return getAttrVal<string>("Sd_conclusion",null); }
            set { setAttrVal<string>("Sd_conclusion", value); }
        }
		public string Name_conclusion {
            get { return getAttrVal<string>("Name_conclusion",null); }
            set { setAttrVal<string>("Name_conclusion", value); }
        }
		public DateTime? Dt_aids {
            get { return getAttrVal<FDateTime>("Dt_aids",null); }
            set { setAttrVal<FDateTime>("Dt_aids", value); }
        }
		public string Card_no {
            get { return getAttrVal<string>("Card_no",null); }
            set { setAttrVal<string>("Card_no", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Parent_name {
            get { return getAttrVal<string>("Parent_name",null); }
            set { setAttrVal<string>("Parent_name", value); }
        }
		public string Id_marry {
            get { return getAttrVal<string>("Id_marry",null); }
            set { setAttrVal<string>("Id_marry", value); }
        }
		public string Code_marry {
            get { return getAttrVal<string>("Code_marry",null); }
            set { setAttrVal<string>("Code_marry", value); }
        }
		public string Name_marry {
            get { return getAttrVal<string>("Name_marry",null); }
            set { setAttrVal<string>("Name_marry", value); }
        }
		public string Hjdz {
            get { return getAttrVal<string>("Hjdz",null); }
            set { setAttrVal<string>("Hjdz", value); }
        }
		public string Code_hjdz {
            get { return getAttrVal<string>("Code_hjdz",null); }
            set { setAttrVal<string>("Code_hjdz", value); }
        }
		public string Name_hjdz {
            get { return getAttrVal<string>("Name_hjdz",null); }
            set { setAttrVal<string>("Name_hjdz", value); }
        }
		public string Town {
            get { return getAttrVal<string>("Town",null); }
            set { setAttrVal<string>("Town", value); }
        }
		public string Village {
            get { return getAttrVal<string>("Village",null); }
            set { setAttrVal<string>("Village", value); }
        }
		public string House_no {
            get { return getAttrVal<string>("House_no",null); }
            set { setAttrVal<string>("House_no", value); }
        }
		public string Id_culture {
            get { return getAttrVal<string>("Id_culture",null); }
            set { setAttrVal<string>("Id_culture", value); }
        }
		public string Name_culture {
            get { return getAttrVal<string>("Name_culture",null); }
            set { setAttrVal<string>("Name_culture", value); }
        }
		public string Code_culture {
            get { return getAttrVal<string>("Code_culture",null); }
            set { setAttrVal<string>("Code_culture", value); }
        }
		public DateTime? Dt_contagion {
            get { return getAttrVal<FDate>("Dt_contagion",null); }
            set { setAttrVal<FDate>("Dt_contagion", value); }
        }
		public string Id_emp_entry {
            get { return getAttrVal<string>("Id_emp_entry",null); }
            set { setAttrVal<string>("Id_emp_entry", value); }
        }
		public string Sd_emp_entry {
            get { return getAttrVal<string>("Sd_emp_entry",null); }
            set { setAttrVal<string>("Sd_emp_entry", value); }
        }
		public string Name_emp_entry {
            get { return getAttrVal<string>("Name_emp_entry",null); }
            set { setAttrVal<string>("Name_emp_entry", value); }
        }
		public string Id_nation {
            get { return getAttrVal<string>("Id_nation",null); }
            set { setAttrVal<string>("Id_nation", value); }
        }
		public string Sd_nation {
            get { return getAttrVal<string>("Sd_nation",null); }
            set { setAttrVal<string>("Sd_nation", value); }
        }
		public string Name_nation {
            get { return getAttrVal<string>("Name_nation",null); }
            set { setAttrVal<string>("Name_nation", value); }
        }
		public string Confirm_detection_unite {
            get { return getAttrVal<string>("Confirm_detection_unite",null); }
            set { setAttrVal<string>("Confirm_detection_unite", value); }
        }
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }
		public string Code_disease {
            get { return getAttrVal<string>("Code_disease",null); }
            set { setAttrVal<string>("Code_disease", value); }
        }
		public string Name_disease {
            get { return getAttrVal<string>("Name_disease",null); }
            set { setAttrVal<string>("Name_disease", value); }
        }
		public string Sd_history_code {
            get { return getAttrVal<string>("Sd_history_code",null); }
            set { setAttrVal<string>("Sd_history_code", value); }
        }
		public string Sd_history_name {
            get { return getAttrVal<string>("Sd_history_name",null); }
            set { setAttrVal<string>("Sd_history_name", value); }
        }
		public string Contact_history_code {
            get { return getAttrVal<string>("Contact_history_code",null); }
            set { setAttrVal<string>("Contact_history_code", value); }
        }
		public string Contact_history_name {
            get { return getAttrVal<string>("Contact_history_name",null); }
            set { setAttrVal<string>("Contact_history_name", value); }
        }
		public string Infection_code {
            get { return getAttrVal<string>("Infection_code",null); }
            set { setAttrVal<string>("Infection_code", value); }
        }
		public string Infection_name {
            get { return getAttrVal<string>("Infection_name",null); }
            set { setAttrVal<string>("Infection_name", value); }
        }
		public string Sample_code {
            get { return getAttrVal<string>("Sample_code",null); }
            set { setAttrVal<string>("Sample_code", value); }
        }
		public string Sample_name {
            get { return getAttrVal<string>("Sample_name",null); }
            set { setAttrVal<string>("Sample_name", value); }
        }
		public string Conclusion_code {
            get { return getAttrVal<string>("Conclusion_code",null); }
            set { setAttrVal<string>("Conclusion_code", value); }
        }
		public string Conclusion_name {
            get { return getAttrVal<string>("Conclusion_name",null); }
            set { setAttrVal<string>("Conclusion_name", value); }
        }
		public string Marry_code {
            get { return getAttrVal<string>("Marry_code",null); }
            set { setAttrVal<string>("Marry_code", value); }
        }
		public string Marry_name {
            get { return getAttrVal<string>("Marry_name",null); }
            set { setAttrVal<string>("Marry_name", value); }
        }
		public string Areacode {
            get { return getAttrVal<string>("Areacode",null); }
            set { setAttrVal<string>("Areacode", value); }
        }
		public string Areaname {
            get { return getAttrVal<string>("Areaname",null); }
            set { setAttrVal<string>("Areaname", value); }
        }
		public string Culturecode {
            get { return getAttrVal<string>("Culturecode",null); }
            set { setAttrVal<string>("Culturecode", value); }
        }
		public string Culturename {
            get { return getAttrVal<string>("Culturename",null); }
            set { setAttrVal<string>("Culturename", value); }
        }
		public string Doctorcode {
            get { return getAttrVal<string>("Doctorcode",null); }
            set { setAttrVal<string>("Doctorcode", value); }
        }
		public string Doctorname {
            get { return getAttrVal<string>("Doctorname",null); }
            set { setAttrVal<string>("Doctorname", value); }
        }
		public string Nation_code {
            get { return getAttrVal<string>("Nation_code",null); }
            set { setAttrVal<string>("Nation_code", value); }
        }
		public string Nation_name {
            get { return getAttrVal<string>("Nation_name",null); }
            set { setAttrVal<string>("Nation_name", value); }
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
            return "CI_MR_CONTAGION_CARD_AIDS";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a5";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_aids";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagion.d.AidsDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_aids", "Id_contagion", "Id_form", "Disease", "Disease_code", "Disease_name", "Is_aids_history", "Sd_aids_history", "Name_aids_history", "Id_contact_history", "Sd_contact_history", "Name_contact_history", "Id_infection_way", "Sd_infection_way", "Name_infection_way", "Id_sample_source", "Sd_sample_source", "Name_sample_source", "Id_conclusion", "Sd_conclusion", "Name_conclusion", "Dt_aids", "Card_no", "Pat_name", "Parent_name", "Id_marry", "Code_marry", "Name_marry", "Hjdz", "Code_hjdz", "Name_hjdz", "Town", "Village", "House_no", "Id_culture", "Name_culture", "Code_culture", "Dt_contagion", "Id_emp_entry", "Sd_emp_entry", "Name_emp_entry", "Id_nation", "Sd_nation", "Name_nation", "Confirm_detection_unite", "Def1", "Code_disease", "Name_disease", "Sd_history_code", "Sd_history_name", "Contact_history_code", "Contact_history_name", "Infection_code", "Infection_name", "Sample_code", "Sample_name", "Conclusion_code", "Conclusion_name", "Marry_code", "Marry_name", "Areacode", "Areaname", "Culturecode", "Culturename", "Doctorcode", "Doctorname", "Nation_code", "Nation_name"};
        }
        
    }
}

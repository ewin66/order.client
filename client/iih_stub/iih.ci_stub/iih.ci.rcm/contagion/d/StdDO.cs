
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagion.d
{
    /// <summary>
    /// StdDO 的摘要说明。
    /// </summary>
    public class StdDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_CONTAGION_CARD_STD";
		public const string TABLE_ALIAS_NAME = "a1";

        public StdDO() {
        }
		public string Id_contagion_std {
            get { return getAttrVal<string>("Id_contagion_std",null); }
            set { setAttrVal<string>("Id_contagion_std", value); }
        }
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }
		public string Id_form {
            get { return getAttrVal<string>("Id_form",null); }
            set { setAttrVal<string>("Id_form", value); }
        }
		public string Id_marry {
            get { return getAttrVal<string>("Id_marry",null); }
            set { setAttrVal<string>("Id_marry", value); }
        }
		public string Sd_marry {
            get { return getAttrVal<string>("Sd_marry",null); }
            set { setAttrVal<string>("Sd_marry", value); }
        }
		public string Name_marry {
            get { return getAttrVal<string>("Name_marry",null); }
            set { setAttrVal<string>("Name_marry", value); }
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
		public string Id_education {
            get { return getAttrVal<string>("Id_education",null); }
            set { setAttrVal<string>("Id_education", value); }
        }
		public string Sd_education {
            get { return getAttrVal<string>("Sd_education",null); }
            set { setAttrVal<string>("Sd_education", value); }
        }
		public string Name_education {
            get { return getAttrVal<string>("Name_education",null); }
            set { setAttrVal<string>("Name_education", value); }
        }
		public string Is_std_history {
            get { return getAttrVal<string>("Is_std_history",null); }
            set { setAttrVal<string>("Is_std_history", value); }
        }
		public string Sd_std_history {
            get { return getAttrVal<string>("Sd_std_history",null); }
            set { setAttrVal<string>("Sd_std_history", value); }
        }
		public string Name_std_history {
            get { return getAttrVal<string>("Name_std_history",null); }
            set { setAttrVal<string>("Name_std_history", value); }
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
		public DateTime? Dt_contagion {
            get { return getAttrVal<FDateTime>("Dt_contagion",null); }
            set { setAttrVal<FDateTime>("Dt_contagion", value); }
        }
		public string Marry_code {
            get { return getAttrVal<string>("Marry_code",null); }
            set { setAttrVal<string>("Marry_code", value); }
        }
		public string Marry_name {
            get { return getAttrVal<string>("Marry_name",null); }
            set { setAttrVal<string>("Marry_name", value); }
        }
		public string Nation_code {
            get { return getAttrVal<string>("Nation_code",null); }
            set { setAttrVal<string>("Nation_code", value); }
        }
		public string Nation_name {
            get { return getAttrVal<string>("Nation_name",null); }
            set { setAttrVal<string>("Nation_name", value); }
        }
		public string Education_code {
            get { return getAttrVal<string>("Education_code",null); }
            set { setAttrVal<string>("Education_code", value); }
        }
		public string Education_name {
            get { return getAttrVal<string>("Education_name",null); }
            set { setAttrVal<string>("Education_name", value); }
        }
		public string Std_history_code {
            get { return getAttrVal<string>("Std_history_code",null); }
            set { setAttrVal<string>("Std_history_code", value); }
        }
		public string Std_history_name {
            get { return getAttrVal<string>("Std_history_name",null); }
            set { setAttrVal<string>("Std_history_name", value); }
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
            return "CI_MR_CONTAGION_CARD_STD";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a1";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_contagion_std";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagion.d.StdDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_contagion_std", "Id_contagion", "Id_form", "Id_marry", "Sd_marry", "Name_marry", "Id_nation", "Sd_nation", "Name_nation", "Id_education", "Sd_education", "Name_education", "Is_std_history", "Sd_std_history", "Name_std_history", "Id_contact_history", "Sd_contact_history", "Name_contact_history", "Id_infection_way", "Sd_infection_way", "Name_infection_way", "Id_sample_source", "Sd_sample_source", "Name_sample_source", "Id_conclusion", "Sd_conclusion", "Name_conclusion", "Dt_contagion", "Marry_code", "Marry_name", "Nation_code", "Nation_name", "Education_code", "Education_name", "Std_history_code", "Std_history_name", "Contact_history_code", "Contact_history_name", "Infection_code", "Infection_name", "Sample_code", "Sample_name", "Conclusion_code", "Conclusion_name"};
        }
        
    }
}

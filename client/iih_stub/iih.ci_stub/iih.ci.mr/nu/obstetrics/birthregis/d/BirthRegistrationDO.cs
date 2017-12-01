
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.birthregis.d
{
    /// <summary>
    /// BirthRegistrationDO 的摘要说明。
    /// </summary>
    public class BirthRegistrationDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_BIRTH_REG";
		public const string TABLE_ALIAS_NAME = "a0";

        public BirthRegistrationDO() {
        }
		public string Id_birth_reg {
            get { return getAttrVal<string>("Id_birth_reg",null); }
            set { setAttrVal<string>("Id_birth_reg", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Sortno {
            get { return getAttrVal<string>("Sortno",null); }
            set { setAttrVal<string>("Sortno", value); }
        }
		public DateTime? Dt_date {
            get { return getAttrVal<FDate>("Dt_date",null); }
            set { setAttrVal<FDate>("Dt_date", value); }
        }
		public DateTime? Dt_time {
            get { return getAttrVal<FTime>("Dt_time",null); }
            set { setAttrVal<FTime>("Dt_time", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public int? Num_preg {
            get { return getAttrVal<int?>("Num_preg",null); }
            set { setAttrVal<int?>("Num_preg", value); }
        }
		public int? Num_birth {
            get { return getAttrVal<int?>("Num_birth",null); }
            set { setAttrVal<int?>("Num_birth", value); }
        }
		public int? Week_preg {
            get { return getAttrVal<int?>("Week_preg",null); }
            set { setAttrVal<int?>("Week_preg", value); }
        }
		public string Id_delivery {
            get { return getAttrVal<string>("Id_delivery",null); }
            set { setAttrVal<string>("Id_delivery", value); }
        }
		public string Sd_delivery {
            get { return getAttrVal<string>("Sd_delivery",null); }
            set { setAttrVal<string>("Sd_delivery", value); }
        }
		public string Id_position {
            get { return getAttrVal<string>("Id_position",null); }
            set { setAttrVal<string>("Id_position", value); }
        }
		public string Sd_position {
            get { return getAttrVal<string>("Sd_position",null); }
            set { setAttrVal<string>("Sd_position", value); }
        }
		public string Name_oper {
            get { return getAttrVal<string>("Name_oper",null); }
            set { setAttrVal<string>("Name_oper", value); }
        }
		public string Complication {
            get { return getAttrVal<string>("Complication",null); }
            set { setAttrVal<string>("Complication", value); }
        }
		public int? Num_bleed_intrap {
            get { return getAttrVal<int?>("Num_bleed_intrap",null); }
            set { setAttrVal<int?>("Num_bleed_intrap", value); }
        }
		public int? Num_bleed_postp {
            get { return getAttrVal<int?>("Num_bleed_postp",null); }
            set { setAttrVal<int?>("Num_bleed_postp", value); }
        }
		public string Res_bleed {
            get { return getAttrVal<string>("Res_bleed",null); }
            set { setAttrVal<string>("Res_bleed", value); }
        }
		public string Id_perineum_status {
            get { return getAttrVal<string>("Id_perineum_status",null); }
            set { setAttrVal<string>("Id_perineum_status", value); }
        }
		public string Sd_perineum_status {
            get { return getAttrVal<string>("Sd_perineum_status",null); }
            set { setAttrVal<string>("Sd_perineum_status", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public FDouble Weight {
            get { return getAttrVal<FDouble>("Weight",null); }
            set { setAttrVal<FDouble>("Weight", value); }
        }
		public int? Height {
            get { return getAttrVal<int?>("Height",null); }
            set { setAttrVal<int?>("Height", value); }
        }
		public string Situation_special {
            get { return getAttrVal<string>("Situation_special",null); }
            set { setAttrVal<string>("Situation_special", value); }
        }
		public int? Score_minute_one {
            get { return getAttrVal<int?>("Score_minute_one",null); }
            set { setAttrVal<int?>("Score_minute_one", value); }
        }
		public int? Score_minute_five {
            get { return getAttrVal<int?>("Score_minute_five",null); }
            set { setAttrVal<int?>("Score_minute_five", value); }
        }
		public int? Score_minute_ten {
            get { return getAttrVal<int?>("Score_minute_ten",null); }
            set { setAttrVal<int?>("Score_minute_ten", value); }
        }
		public int? Eu_anmelden {
            get { return getAttrVal<int?>("Eu_anmelden",null); }
            set { setAttrVal<int?>("Eu_anmelden", value); }
        }
		public int? Eu_consulthiv {
            get { return getAttrVal<int?>("Eu_consulthiv",null); }
            set { setAttrVal<int?>("Eu_consulthiv", value); }
        }
		public int? Eu_filtratehiv {
            get { return getAttrVal<int?>("Eu_filtratehiv",null); }
            set { setAttrVal<int?>("Eu_filtratehiv", value); }
        }
		public string Id_assaytesthiv {
            get { return getAttrVal<string>("Id_assaytesthiv",null); }
            set { setAttrVal<string>("Id_assaytesthiv", value); }
        }
		public string Sd_assaytesthiv {
            get { return getAttrVal<string>("Sd_assaytesthiv",null); }
            set { setAttrVal<string>("Sd_assaytesthiv", value); }
        }
		public int? Eu_syphilis {
            get { return getAttrVal<int?>("Eu_syphilis",null); }
            set { setAttrVal<int?>("Eu_syphilis", value); }
        }
		public int? Eu_hbsag {
            get { return getAttrVal<int?>("Eu_hbsag",null); }
            set { setAttrVal<int?>("Eu_hbsag", value); }
        }
		public string Other_sexillness {
            get { return getAttrVal<string>("Other_sexillness",null); }
            set { setAttrVal<string>("Other_sexillness", value); }
        }
		public int? Num_fetus {
            get { return getAttrVal<int?>("Num_fetus",null); }
            set { setAttrVal<int?>("Num_fetus", value); }
        }
		public int? Num_dead_fetus {
            get { return getAttrVal<int?>("Num_dead_fetus",null); }
            set { setAttrVal<int?>("Num_dead_fetus", value); }
        }
		public int? Num_dead_birth {
            get { return getAttrVal<int?>("Num_dead_birth",null); }
            set { setAttrVal<int?>("Num_dead_birth", value); }
        }
		public int? Num_dead_newborn {
            get { return getAttrVal<int?>("Num_dead_newborn",null); }
            set { setAttrVal<int?>("Num_dead_newborn", value); }
        }
		public string Defects_birth {
            get { return getAttrVal<string>("Defects_birth",null); }
            set { setAttrVal<string>("Defects_birth", value); }
        }
		public string Sue_send {
            get { return getAttrVal<string>("Sue_send",null); }
            set { setAttrVal<string>("Sue_send", value); }
        }
		public string Id_emp_midwives {
            get { return getAttrVal<string>("Id_emp_midwives",null); }
            set { setAttrVal<string>("Id_emp_midwives", value); }
        }
		public string Id_emp_reg {
            get { return getAttrVal<string>("Id_emp_reg",null); }
            set { setAttrVal<string>("Id_emp_reg", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_delivery {
            get { return getAttrVal<string>("Name_delivery",null); }
            set { setAttrVal<string>("Name_delivery", value); }
        }
		public string Name_position {
            get { return getAttrVal<string>("Name_position",null); }
            set { setAttrVal<string>("Name_position", value); }
        }
		public string Name_perineum_status {
            get { return getAttrVal<string>("Name_perineum_status",null); }
            set { setAttrVal<string>("Name_perineum_status", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Name_assaytesthiv {
            get { return getAttrVal<string>("Name_assaytesthiv",null); }
            set { setAttrVal<string>("Name_assaytesthiv", value); }
        }
		public string Name_emp_midwives {
            get { return getAttrVal<string>("Name_emp_midwives",null); }
            set { setAttrVal<string>("Name_emp_midwives", value); }
        }
		public string Name_emp_reg {
            get { return getAttrVal<string>("Name_emp_reg",null); }
            set { setAttrVal<string>("Name_emp_reg", value); }
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
            return "CI_MR_NU_BIRTH_REG";
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
            return "Id_birth_reg";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.birthregis.d.BirthRegistrationDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_birth_reg", "Id_org", "Id_grp", "Id_ent", "Id_pat", "Code_entp", "Sortno", "Dt_date", "Dt_time", "Age", "Code_amr_ip", "Num_preg", "Num_birth", "Week_preg", "Id_delivery", "Sd_delivery", "Id_position", "Sd_position", "Name_oper", "Complication", "Num_bleed_intrap", "Num_bleed_postp", "Res_bleed", "Id_perineum_status", "Sd_perineum_status", "Id_sex", "Sd_sex", "Weight", "Height", "Situation_special", "Score_minute_one", "Score_minute_five", "Score_minute_ten", "Eu_anmelden", "Eu_consulthiv", "Eu_filtratehiv", "Id_assaytesthiv", "Sd_assaytesthiv", "Eu_syphilis", "Eu_hbsag", "Other_sexillness", "Num_fetus", "Num_dead_fetus", "Num_dead_birth", "Num_dead_newborn", "Defects_birth", "Sue_send", "Id_emp_midwives", "Id_emp_reg", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Name_delivery", "Name_position", "Name_perineum_status", "Name_sex", "Name_assaytesthiv", "Name_emp_midwives", "Name_emp_reg"};
        }
        
    }
}

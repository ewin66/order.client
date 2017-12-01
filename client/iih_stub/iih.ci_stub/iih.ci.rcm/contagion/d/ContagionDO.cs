
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.rcm.contagion.d
{
    /// <summary>
    /// ContagionDO 的摘要说明。
    /// </summary>
    public class ContagionDO : BaseDO {

		public const string TABLE_NAME = "ci_contagion_card";
		public const string TABLE_ALIAS_NAME = "a0";

        public ContagionDO() {
        }
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string P_id_contagion {
            get { return getAttrVal<string>("P_id_contagion",null); }
            set { setAttrVal<string>("P_id_contagion", value); }
        }
		public string Id_form {
            get { return getAttrVal<string>("Id_form",null); }
            set { setAttrVal<string>("Id_form", value); }
        }
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }
		public string Eu_bklb {
            get { return getAttrVal<string>("Eu_bklb",null); }
            set { setAttrVal<string>("Eu_bklb", value); }
        }
		public string Eu_bklb_code {
            get { return getAttrVal<string>("Eu_bklb_code",null); }
            set { setAttrVal<string>("Eu_bklb_code", value); }
        }
		public string Eu_bklb_name {
            get { return getAttrVal<string>("Eu_bklb_name",null); }
            set { setAttrVal<string>("Eu_bklb_name", value); }
        }
		public string Id_con_cardsu {
            get { return getAttrVal<string>("Id_con_cardsu",null); }
            set { setAttrVal<string>("Id_con_cardsu", value); }
        }
		public string Sd_con_cardsu {
            get { return getAttrVal<string>("Sd_con_cardsu",null); }
            set { setAttrVal<string>("Sd_con_cardsu", value); }
        }
		public string Name_con_cardsu {
            get { return getAttrVal<string>("Name_con_cardsu",null); }
            set { setAttrVal<string>("Name_con_cardsu", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Id_code {
            get { return getAttrVal<string>("Id_code",null); }
            set { setAttrVal<string>("Id_code", value); }
        }
		public string Revised_name {
            get { return getAttrVal<string>("Revised_name",null); }
            set { setAttrVal<string>("Revised_name", value); }
        }
		public string Retreat_reason {
            get { return getAttrVal<string>("Retreat_reason",null); }
            set { setAttrVal<string>("Retreat_reason", value); }
        }
		public string Report_unit {
            get { return getAttrVal<string>("Report_unit",null); }
            set { setAttrVal<string>("Report_unit", value); }
        }
		public string Report_unit_code {
            get { return getAttrVal<string>("Report_unit_code",null); }
            set { setAttrVal<string>("Report_unit_code", value); }
        }
		public string Report_unit_name {
            get { return getAttrVal<string>("Report_unit_name",null); }
            set { setAttrVal<string>("Report_unit_name", value); }
        }
		public string Doctor_card {
            get { return getAttrVal<string>("Doctor_card",null); }
            set { setAttrVal<string>("Doctor_card", value); }
        }
		public string Eu_jlcrb {
            get { return getAttrVal<string>("Eu_jlcrb",null); }
            set { setAttrVal<string>("Eu_jlcrb", value); }
        }
		public string Eu_jlcrb_code {
            get { return getAttrVal<string>("Eu_jlcrb_code",null); }
            set { setAttrVal<string>("Eu_jlcrb_code", value); }
        }
		public string Eu_jlcrb_name {
            get { return getAttrVal<string>("Eu_jlcrb_name",null); }
            set { setAttrVal<string>("Eu_jlcrb_name", value); }
        }
		public string Eu_ylcrb {
            get { return getAttrVal<string>("Eu_ylcrb",null); }
            set { setAttrVal<string>("Eu_ylcrb", value); }
        }
		public string Eu_ylcrb_code {
            get { return getAttrVal<string>("Eu_ylcrb_code",null); }
            set { setAttrVal<string>("Eu_ylcrb_code", value); }
        }
		public string Eu_ylcrb_name {
            get { return getAttrVal<string>("Eu_ylcrb_name",null); }
            set { setAttrVal<string>("Eu_ylcrb_name", value); }
        }
		public string Eu_blcrb {
            get { return getAttrVal<string>("Eu_blcrb",null); }
            set { setAttrVal<string>("Eu_blcrb", value); }
        }
		public string Eu_blcrb_code {
            get { return getAttrVal<string>("Eu_blcrb_code",null); }
            set { setAttrVal<string>("Eu_blcrb_code", value); }
        }
		public string Eu_blcrb_name {
            get { return getAttrVal<string>("Eu_blcrb_name",null); }
            set { setAttrVal<string>("Eu_blcrb_name", value); }
        }
		public string Id_other_diseases {
            get { return getAttrVal<string>("Id_other_diseases",null); }
            set { setAttrVal<string>("Id_other_diseases", value); }
        }
		public string Sd_other_diseases {
            get { return getAttrVal<string>("Sd_other_diseases",null); }
            set { setAttrVal<string>("Sd_other_diseases", value); }
        }
		public string Name_other_diseases {
            get { return getAttrVal<string>("Name_other_diseases",null); }
            set { setAttrVal<string>("Name_other_diseases", value); }
        }
		public bool? Is_alike {
            get { return getAttrVal<FBoolean>("Is_alike",null); }
            set { setAttrVal<FBoolean>("Is_alike", value); }
        }
		public string Eu_blfl {
            get { return getAttrVal<string>("Eu_blfl",null); }
            set { setAttrVal<string>("Eu_blfl", value); }
        }
		public string Eu_blfl_code {
            get { return getAttrVal<string>("Eu_blfl_code",null); }
            set { setAttrVal<string>("Eu_blfl_code", value); }
        }
		public string Eu_blfl_name {
            get { return getAttrVal<string>("Eu_blfl_name",null); }
            set { setAttrVal<string>("Eu_blfl_name", value); }
        }
		public string Eu_brsy {
            get { return getAttrVal<string>("Eu_brsy",null); }
            set { setAttrVal<string>("Eu_brsy", value); }
        }
		public string Eu_brsy_code {
            get { return getAttrVal<string>("Eu_brsy_code",null); }
            set { setAttrVal<string>("Eu_brsy_code", value); }
        }
		public string Eu_brsy_name {
            get { return getAttrVal<string>("Eu_brsy_name",null); }
            set { setAttrVal<string>("Eu_brsy_name", value); }
        }
		public string Eu_rqfl {
            get { return getAttrVal<string>("Eu_rqfl",null); }
            set { setAttrVal<string>("Eu_rqfl", value); }
        }
		public string Eu_rqfl_code {
            get { return getAttrVal<string>("Eu_rqfl_code",null); }
            set { setAttrVal<string>("Eu_rqfl_code", value); }
        }
		public string Eu_rqfl_name {
            get { return getAttrVal<string>("Eu_rqfl_name",null); }
            set { setAttrVal<string>("Eu_rqfl_name", value); }
        }
		public string Hzjzxm {
            get { return getAttrVal<string>("Hzjzxm",null); }
            set { setAttrVal<string>("Hzjzxm", value); }
        }
		public DateTime? Fbrq {
            get { return getAttrVal<FDate>("Fbrq",null); }
            set { setAttrVal<FDate>("Fbrq", value); }
        }
		public DateTime? Zdrq {
            get { return getAttrVal<FDateTime>("Zdrq",null); }
            set { setAttrVal<FDateTime>("Zdrq", value); }
        }
		public DateTime? Swrq {
            get { return getAttrVal<FDate>("Swrq",null); }
            set { setAttrVal<FDate>("Swrq", value); }
        }
		public string Eu_nldw {
            get { return getAttrVal<string>("Eu_nldw",null); }
            set { setAttrVal<string>("Eu_nldw", value); }
        }
		public string Eu_nldw_code {
            get { return getAttrVal<string>("Eu_nldw_code",null); }
            set { setAttrVal<string>("Eu_nldw_code", value); }
        }
		public string Eu_nldw_name {
            get { return getAttrVal<string>("Eu_nldw_name",null); }
            set { setAttrVal<string>("Eu_nldw_name", value); }
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
		public int? Exact_age {
            get { return getAttrVal<int?>("Exact_age",null); }
            set { setAttrVal<int?>("Exact_age", value); }
        }
		public string Workunit {
            get { return getAttrVal<string>("Workunit",null); }
            set { setAttrVal<string>("Workunit", value); }
        }
		public string Mob {
            get { return getAttrVal<string>("Mob",null); }
            set { setAttrVal<string>("Mob", value); }
        }
		public string Addr_now {
            get { return getAttrVal<string>("Addr_now",null); }
            set { setAttrVal<string>("Addr_now", value); }
        }
		public string Id_province {
            get { return getAttrVal<string>("Id_province",null); }
            set { setAttrVal<string>("Id_province", value); }
        }
		public string Sd_province {
            get { return getAttrVal<string>("Sd_province",null); }
            set { setAttrVal<string>("Sd_province", value); }
        }
		public string Name_province {
            get { return getAttrVal<string>("Name_province",null); }
            set { setAttrVal<string>("Name_province", value); }
        }
		public string Street {
            get { return getAttrVal<string>("Street",null); }
            set { setAttrVal<string>("Street", value); }
        }
		public string Village {
            get { return getAttrVal<string>("Village",null); }
            set { setAttrVal<string>("Village", value); }
        }
		public string Housenum {
            get { return getAttrVal<string>("Housenum",null); }
            set { setAttrVal<string>("Housenum", value); }
        }
		public string Residence_addr {
            get { return getAttrVal<string>("Residence_addr",null); }
            set { setAttrVal<string>("Residence_addr", value); }
        }
		public string Residence_code {
            get { return getAttrVal<string>("Residence_code",null); }
            set { setAttrVal<string>("Residence_code", value); }
        }
		public string Residence {
            get { return getAttrVal<string>("Residence",null); }
            set { setAttrVal<string>("Residence", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }
		public DateTime? Dt_contagion {
            get { return getAttrVal<FDate>("Dt_contagion",null); }
            set { setAttrVal<FDate>("Dt_contagion", value); }
        }
		public string Tel {
            get { return getAttrVal<string>("Tel",null); }
            set { setAttrVal<string>("Tel", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Sd_grp {
            get { return getAttrVal<string>("Sd_grp",null); }
            set { setAttrVal<string>("Sd_grp", value); }
        }
		public string Name_grp {
            get { return getAttrVal<string>("Name_grp",null); }
            set { setAttrVal<string>("Name_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Sd_org {
            get { return getAttrVal<string>("Sd_org",null); }
            set { setAttrVal<string>("Sd_org", value); }
        }
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }
		public string Remarks {
            get { return getAttrVal<string>("Remarks",null); }
            set { setAttrVal<string>("Remarks", value); }
        }
		public string Delete_resion {
            get { return getAttrVal<string>("Delete_resion",null); }
            set { setAttrVal<string>("Delete_resion", value); }
        }
		public string Rehect_reason {
            get { return getAttrVal<string>("Rehect_reason",null); }
            set { setAttrVal<string>("Rehect_reason", value); }
        }
		public string Eu_bqfl {
            get { return getAttrVal<string>("Eu_bqfl",null); }
            set { setAttrVal<string>("Eu_bqfl", value); }
        }
		public string Code_eu_bqfl {
            get { return getAttrVal<string>("Code_eu_bqfl",null); }
            set { setAttrVal<string>("Code_eu_bqfl", value); }
        }
		public string Name_eu_bqfl {
            get { return getAttrVal<string>("Name_eu_bqfl",null); }
            set { setAttrVal<string>("Name_eu_bqfl", value); }
        }
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }
		public string Def2 {
            get { return getAttrVal<string>("Def2",null); }
            set { setAttrVal<string>("Def2", value); }
        }
		public string Def3 {
            get { return getAttrVal<string>("Def3",null); }
            set { setAttrVal<string>("Def3", value); }
        }
		public string Def4 {
            get { return getAttrVal<string>("Def4",null); }
            set { setAttrVal<string>("Def4", value); }
        }
		public string Def5 {
            get { return getAttrVal<string>("Def5",null); }
            set { setAttrVal<string>("Def5", value); }
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
		public string Ref_bklb_code {
            get { return getAttrVal<string>("Ref_bklb_code",null); }
            set { setAttrVal<string>("Ref_bklb_code", value); }
        }
		public string Ref_bklb_name {
            get { return getAttrVal<string>("Ref_bklb_name",null); }
            set { setAttrVal<string>("Ref_bklb_name", value); }
        }
		public string Ref_cardsu_code {
            get { return getAttrVal<string>("Ref_cardsu_code",null); }
            set { setAttrVal<string>("Ref_cardsu_code", value); }
        }
		public string Ref_cardsu_name {
            get { return getAttrVal<string>("Ref_cardsu_name",null); }
            set { setAttrVal<string>("Ref_cardsu_name", value); }
        }
		public string Ref_code_report_unit {
            get { return getAttrVal<string>("Ref_code_report_unit",null); }
            set { setAttrVal<string>("Ref_code_report_unit", value); }
        }
		public string Ref_name_report_unit {
            get { return getAttrVal<string>("Ref_name_report_unit",null); }
            set { setAttrVal<string>("Ref_name_report_unit", value); }
        }
		public string Ref_code_eu_jlcrb {
            get { return getAttrVal<string>("Ref_code_eu_jlcrb",null); }
            set { setAttrVal<string>("Ref_code_eu_jlcrb", value); }
        }
		public string Ref_name_eu_jlcrb {
            get { return getAttrVal<string>("Ref_name_eu_jlcrb",null); }
            set { setAttrVal<string>("Ref_name_eu_jlcrb", value); }
        }
		public string Ref_code_eu_ylcrb {
            get { return getAttrVal<string>("Ref_code_eu_ylcrb",null); }
            set { setAttrVal<string>("Ref_code_eu_ylcrb", value); }
        }
		public string Ref_name_eu_ylcrb {
            get { return getAttrVal<string>("Ref_name_eu_ylcrb",null); }
            set { setAttrVal<string>("Ref_name_eu_ylcrb", value); }
        }
		public string Code_eu_blcrb {
            get { return getAttrVal<string>("Code_eu_blcrb",null); }
            set { setAttrVal<string>("Code_eu_blcrb", value); }
        }
		public string Name_eu_blcrb {
            get { return getAttrVal<string>("Name_eu_blcrb",null); }
            set { setAttrVal<string>("Name_eu_blcrb", value); }
        }
		public string Other_diseases_code {
            get { return getAttrVal<string>("Other_diseases_code",null); }
            set { setAttrVal<string>("Other_diseases_code", value); }
        }
		public string Other_diseases_name {
            get { return getAttrVal<string>("Other_diseases_name",null); }
            set { setAttrVal<string>("Other_diseases_name", value); }
        }
		public string Code_eu_rqfl {
            get { return getAttrVal<string>("Code_eu_rqfl",null); }
            set { setAttrVal<string>("Code_eu_rqfl", value); }
        }
		public string Name_eu_rqfl {
            get { return getAttrVal<string>("Name_eu_rqfl",null); }
            set { setAttrVal<string>("Name_eu_rqfl", value); }
        }
		public string Code_eu_brsy {
            get { return getAttrVal<string>("Code_eu_brsy",null); }
            set { setAttrVal<string>("Code_eu_brsy", value); }
        }
		public string Name_eu_brsy {
            get { return getAttrVal<string>("Name_eu_brsy",null); }
            set { setAttrVal<string>("Name_eu_brsy", value); }
        }
		public string Ref_code_eu_rqfl {
            get { return getAttrVal<string>("Ref_code_eu_rqfl",null); }
            set { setAttrVal<string>("Ref_code_eu_rqfl", value); }
        }
		public string Ref_name_eu_rqfl {
            get { return getAttrVal<string>("Ref_name_eu_rqfl",null); }
            set { setAttrVal<string>("Ref_name_eu_rqfl", value); }
        }
		public string Code_eu_nldw {
            get { return getAttrVal<string>("Code_eu_nldw",null); }
            set { setAttrVal<string>("Code_eu_nldw", value); }
        }
		public string Name_eu_nldw {
            get { return getAttrVal<string>("Name_eu_nldw",null); }
            set { setAttrVal<string>("Name_eu_nldw", value); }
        }
		public string Doctorcode {
            get { return getAttrVal<string>("Doctorcode",null); }
            set { setAttrVal<string>("Doctorcode", value); }
        }
		public string Doctorname {
            get { return getAttrVal<string>("Doctorname",null); }
            set { setAttrVal<string>("Doctorname", value); }
        }
		public string Province_code {
            get { return getAttrVal<string>("Province_code",null); }
            set { setAttrVal<string>("Province_code", value); }
        }
		public string Province_name {
            get { return getAttrVal<string>("Province_name",null); }
            set { setAttrVal<string>("Province_name", value); }
        }
		public string Areacode {
            get { return getAttrVal<string>("Areacode",null); }
            set { setAttrVal<string>("Areacode", value); }
        }
		public string Areafullname {
            get { return getAttrVal<string>("Areafullname",null); }
            set { setAttrVal<string>("Areafullname", value); }
        }
		public string Sex_code {
            get { return getAttrVal<string>("Sex_code",null); }
            set { setAttrVal<string>("Sex_code", value); }
        }
		public string Sex_name {
            get { return getAttrVal<string>("Sex_name",null); }
            set { setAttrVal<string>("Sex_name", value); }
        }
		public string Org_code {
            get { return getAttrVal<string>("Org_code",null); }
            set { setAttrVal<string>("Org_code", value); }
        }
		public string Org_name {
            get { return getAttrVal<string>("Org_name",null); }
            set { setAttrVal<string>("Org_name", value); }
        }
		public string Eu_bqfl_code {
            get { return getAttrVal<string>("Eu_bqfl_code",null); }
            set { setAttrVal<string>("Eu_bqfl_code", value); }
        }
		public string Eu_bqfl_name {
            get { return getAttrVal<string>("Eu_bqfl_name",null); }
            set { setAttrVal<string>("Eu_bqfl_name", value); }
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
            return "ci_contagion_card";
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
            return "Id_contagion";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagion.d.ContagionDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_contagion", "Id_mr", "Id_ent", "P_id_contagion", "Id_form", "Code", "Eu_bklb", "Eu_bklb_code", "Eu_bklb_name", "Id_con_cardsu", "Sd_con_cardsu", "Name_con_cardsu", "Name", "Id_code", "Revised_name", "Retreat_reason", "Report_unit", "Report_unit_code", "Report_unit_name", "Doctor_card", "Eu_jlcrb", "Eu_jlcrb_code", "Eu_jlcrb_name", "Eu_ylcrb", "Eu_ylcrb_code", "Eu_ylcrb_name", "Eu_blcrb", "Eu_blcrb_code", "Eu_blcrb_name", "Id_other_diseases", "Sd_other_diseases", "Name_other_diseases", "Is_alike", "Eu_blfl", "Eu_blfl_code", "Eu_blfl_name", "Eu_brsy", "Eu_brsy_code", "Eu_brsy_name", "Eu_rqfl", "Eu_rqfl_code", "Eu_rqfl_name", "Hzjzxm", "Fbrq", "Zdrq", "Swrq", "Eu_nldw", "Eu_nldw_code", "Eu_nldw_name", "Id_emp_entry", "Sd_emp_entry", "Name_emp_entry", "Exact_age", "Workunit", "Mob", "Addr_now", "Id_province", "Sd_province", "Name_province", "Street", "Village", "Housenum", "Residence_addr", "Residence_code", "Residence", "Id_sex", "Sd_sex", "Name_sex", "Dt_birth", "Dt_contagion", "Tel", "Id_grp", "Sd_grp", "Name_grp", "Id_org", "Sd_org", "Name_org", "Remarks", "Delete_resion", "Rehect_reason", "Eu_bqfl", "Code_eu_bqfl", "Name_eu_bqfl", "Def1", "Def2", "Def3", "Def4", "Def5", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Ref_bklb_code", "Ref_bklb_name", "Ref_cardsu_code", "Ref_cardsu_name", "Ref_code_report_unit", "Ref_name_report_unit", "Ref_code_eu_jlcrb", "Ref_name_eu_jlcrb", "Ref_code_eu_ylcrb", "Ref_name_eu_ylcrb", "Code_eu_blcrb", "Name_eu_blcrb", "Other_diseases_code", "Other_diseases_name", "Code_eu_rqfl", "Name_eu_rqfl", "Code_eu_brsy", "Name_eu_brsy", "Ref_code_eu_rqfl", "Ref_name_eu_rqfl", "Code_eu_nldw", "Name_eu_nldw", "Doctorcode", "Doctorname", "Province_code", "Province_name", "Areacode", "Areafullname", "Sex_code", "Sex_name", "Org_code", "Org_name", "Eu_bqfl_code", "Eu_bqfl_name"};
        }
        
    }
}

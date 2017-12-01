
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.cideathcert.d
{
    /// <summary>
    /// CideathcertDO 的摘要说明。
    /// </summary>
    public class CideathcertDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_death_cert";
		public const string TABLE_ALIAS_NAME = "a0";

        public CideathcertDO() {
        }
		public string Id_death_cert {
            get { return getAttrVal<string>("Id_death_cert",null); }
            set { setAttrVal<string>("Id_death_cert", value); }
        }
		public string Title {
            get { return getAttrVal<string>("Title",null); }
            set { setAttrVal<string>("Title", value); }
        }
		public string Inhos_no {
            get { return getAttrVal<string>("Inhos_no",null); }
            set { setAttrVal<string>("Inhos_no", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sex_code {
            get { return getAttrVal<string>("Sex_code",null); }
            set { setAttrVal<string>("Sex_code", value); }
        }
		public string Sex_pat {
            get { return getAttrVal<string>("Sex_pat",null); }
            set { setAttrVal<string>("Sex_pat", value); }
        }
		public string Age_pat {
            get { return getAttrVal<string>("Age_pat",null); }
            set { setAttrVal<string>("Age_pat", value); }
        }
		public string Id_cardtype {
            get { return getAttrVal<string>("Id_cardtype",null); }
            set { setAttrVal<string>("Id_cardtype", value); }
        }
		public string Card_type_code {
            get { return getAttrVal<string>("Card_type_code",null); }
            set { setAttrVal<string>("Card_type_code", value); }
        }
		public string Idcard_type {
            get { return getAttrVal<string>("Idcard_type",null); }
            set { setAttrVal<string>("Idcard_type", value); }
        }
		public string Idcard_no {
            get { return getAttrVal<string>("Idcard_no",null); }
            set { setAttrVal<string>("Idcard_no", value); }
        }
		public string Id_country {
            get { return getAttrVal<string>("Id_country",null); }
            set { setAttrVal<string>("Id_country", value); }
        }
		public string Country_pat {
            get { return getAttrVal<string>("Country_pat",null); }
            set { setAttrVal<string>("Country_pat", value); }
        }
		public string Id_nation {
            get { return getAttrVal<string>("Id_nation",null); }
            set { setAttrVal<string>("Id_nation", value); }
        }
		public string Nation_pat {
            get { return getAttrVal<string>("Nation_pat",null); }
            set { setAttrVal<string>("Nation_pat", value); }
        }
		public DateTime? Birth_pat {
            get { return getAttrVal<FDate>("Birth_pat",null); }
            set { setAttrVal<FDate>("Birth_pat", value); }
        }
		public string Id_marry {
            get { return getAttrVal<string>("Id_marry",null); }
            set { setAttrVal<string>("Id_marry", value); }
        }
		public string Marry_code {
            get { return getAttrVal<string>("Marry_code",null); }
            set { setAttrVal<string>("Marry_code", value); }
        }
		public string Marry_status {
            get { return getAttrVal<string>("Marry_status",null); }
            set { setAttrVal<string>("Marry_status", value); }
        }
		public string Id_degree {
            get { return getAttrVal<string>("Id_degree",null); }
            set { setAttrVal<string>("Id_degree", value); }
        }
		public string Degree_code {
            get { return getAttrVal<string>("Degree_code",null); }
            set { setAttrVal<string>("Degree_code", value); }
        }
		public string Degree_pat {
            get { return getAttrVal<string>("Degree_pat",null); }
            set { setAttrVal<string>("Degree_pat", value); }
        }
		public string Id_job {
            get { return getAttrVal<string>("Id_job",null); }
            set { setAttrVal<string>("Id_job", value); }
        }
		public string Personal_identity_code {
            get { return getAttrVal<string>("Personal_identity_code",null); }
            set { setAttrVal<string>("Personal_identity_code", value); }
        }
		public string Job_pat {
            get { return getAttrVal<string>("Job_pat",null); }
            set { setAttrVal<string>("Job_pat", value); }
        }
		public string Address_province {
            get { return getAttrVal<string>("Address_province",null); }
            set { setAttrVal<string>("Address_province", value); }
        }
		public string Address_county {
            get { return getAttrVal<string>("Address_county",null); }
            set { setAttrVal<string>("Address_county", value); }
        }
		public string Address_detail {
            get { return getAttrVal<string>("Address_detail",null); }
            set { setAttrVal<string>("Address_detail", value); }
        }
		public string Address_pat {
            get { return getAttrVal<string>("Address_pat",null); }
            set { setAttrVal<string>("Address_pat", value); }
        }
		public string Address_pat_code {
            get { return getAttrVal<string>("Address_pat_code",null); }
            set { setAttrVal<string>("Address_pat_code", value); }
        }
		public string Address_pat_name {
            get { return getAttrVal<string>("Address_pat_name",null); }
            set { setAttrVal<string>("Address_pat_name", value); }
        }
		public string Address_pat_street {
            get { return getAttrVal<string>("Address_pat_street",null); }
            set { setAttrVal<string>("Address_pat_street", value); }
        }
		public string Address_code {
            get { return getAttrVal<string>("Address_code",null); }
            set { setAttrVal<string>("Address_code", value); }
        }
		public string Address_no {
            get { return getAttrVal<string>("Address_no",null); }
            set { setAttrVal<string>("Address_no", value); }
        }
		public DateTime? Unknown_date {
            get { return getAttrVal<FDateTime>("Unknown_date",null); }
            set { setAttrVal<FDateTime>("Unknown_date", value); }
        }
		public DateTime? Death_time {
            get { return getAttrVal<FDateTime>("Death_time",null); }
            set { setAttrVal<FDateTime>("Death_time", value); }
        }
		public string Death_site {
            get { return getAttrVal<string>("Death_site",null); }
            set { setAttrVal<string>("Death_site", value); }
        }
		public string Death_site_code {
            get { return getAttrVal<string>("Death_site_code",null); }
            set { setAttrVal<string>("Death_site_code", value); }
        }
		public string Death_site_name {
            get { return getAttrVal<string>("Death_site_name",null); }
            set { setAttrVal<string>("Death_site_name", value); }
        }
		public bool? Is_pregnant {
            get { return getAttrVal<FBoolean>("Is_pregnant",null); }
            set { setAttrVal<FBoolean>("Is_pregnant", value); }
        }
		public string Work_company {
            get { return getAttrVal<string>("Work_company",null); }
            set { setAttrVal<string>("Work_company", value); }
        }
		public string Birth_place {
            get { return getAttrVal<string>("Birth_place",null); }
            set { setAttrVal<string>("Birth_place", value); }
        }
		public string Address_usual {
            get { return getAttrVal<string>("Address_usual",null); }
            set { setAttrVal<string>("Address_usual", value); }
        }
		public string Relation_name {
            get { return getAttrVal<string>("Relation_name",null); }
            set { setAttrVal<string>("Relation_name", value); }
        }
		public string Relation_phone {
            get { return getAttrVal<string>("Relation_phone",null); }
            set { setAttrVal<string>("Relation_phone", value); }
        }
		public string Relation_address {
            get { return getAttrVal<string>("Relation_address",null); }
            set { setAttrVal<string>("Relation_address", value); }
        }
		public string Death_a_diag {
            get { return getAttrVal<string>("Death_a_diag",null); }
            set { setAttrVal<string>("Death_a_diag", value); }
        }
		public string Death_a_timespan {
            get { return getAttrVal<string>("Death_a_timespan",null); }
            set { setAttrVal<string>("Death_a_timespan", value); }
        }
		public string Death_b_diag {
            get { return getAttrVal<string>("Death_b_diag",null); }
            set { setAttrVal<string>("Death_b_diag", value); }
        }
		public string Death_b_timespan {
            get { return getAttrVal<string>("Death_b_timespan",null); }
            set { setAttrVal<string>("Death_b_timespan", value); }
        }
		public string Death_c_diag {
            get { return getAttrVal<string>("Death_c_diag",null); }
            set { setAttrVal<string>("Death_c_diag", value); }
        }
		public string Death_c_timespan {
            get { return getAttrVal<string>("Death_c_timespan",null); }
            set { setAttrVal<string>("Death_c_timespan", value); }
        }
		public string Death_d_diag {
            get { return getAttrVal<string>("Death_d_diag",null); }
            set { setAttrVal<string>("Death_d_diag", value); }
        }
		public string Death_d_timespan {
            get { return getAttrVal<string>("Death_d_timespan",null); }
            set { setAttrVal<string>("Death_d_timespan", value); }
        }
		public string Death_other_diag {
            get { return getAttrVal<string>("Death_other_diag",null); }
            set { setAttrVal<string>("Death_other_diag", value); }
        }
		public string Death_other_timespan {
            get { return getAttrVal<string>("Death_other_timespan",null); }
            set { setAttrVal<string>("Death_other_timespan", value); }
        }
		public string Diag_basis {
            get { return getAttrVal<string>("Diag_basis",null); }
            set { setAttrVal<string>("Diag_basis", value); }
        }
		public string Diag_basis_code {
            get { return getAttrVal<string>("Diag_basis_code",null); }
            set { setAttrVal<string>("Diag_basis_code", value); }
        }
		public string Diag_basis_name {
            get { return getAttrVal<string>("Diag_basis_name",null); }
            set { setAttrVal<string>("Diag_basis_name", value); }
        }
		public string Diag_hospital {
            get { return getAttrVal<string>("Diag_hospital",null); }
            set { setAttrVal<string>("Diag_hospital", value); }
        }
		public string Diag_hospital_code {
            get { return getAttrVal<string>("Diag_hospital_code",null); }
            set { setAttrVal<string>("Diag_hospital_code", value); }
        }
		public string Diag_hospital_name {
            get { return getAttrVal<string>("Diag_hospital_name",null); }
            set { setAttrVal<string>("Diag_hospital_name", value); }
        }
		public string Sign_doctor {
            get { return getAttrVal<string>("Sign_doctor",null); }
            set { setAttrVal<string>("Sign_doctor", value); }
        }
		public string Death_reason {
            get { return getAttrVal<string>("Death_reason",null); }
            set { setAttrVal<string>("Death_reason", value); }
        }
		public string Diag_icdcode {
            get { return getAttrVal<string>("Diag_icdcode",null); }
            set { setAttrVal<string>("Diag_icdcode", value); }
        }
		public string Diag_icdname {
            get { return getAttrVal<string>("Diag_icdname",null); }
            set { setAttrVal<string>("Diag_icdname", value); }
        }
		public string Symptom_sign {
            get { return getAttrVal<string>("Symptom_sign",null); }
            set { setAttrVal<string>("Symptom_sign", value); }
        }
		public string Investigate_name {
            get { return getAttrVal<string>("Investigate_name",null); }
            set { setAttrVal<string>("Investigate_name", value); }
        }
		public string Investigate_relation {
            get { return getAttrVal<string>("Investigate_relation",null); }
            set { setAttrVal<string>("Investigate_relation", value); }
        }
		public string Investigate_phone {
            get { return getAttrVal<string>("Investigate_phone",null); }
            set { setAttrVal<string>("Investigate_phone", value); }
        }
		public string Investigate_address {
            get { return getAttrVal<string>("Investigate_address",null); }
            set { setAttrVal<string>("Investigate_address", value); }
        }
		public string Death_infer {
            get { return getAttrVal<string>("Death_infer",null); }
            set { setAttrVal<string>("Death_infer", value); }
        }
		public DateTime? Investigate_date {
            get { return getAttrVal<FDateTime>("Investigate_date",null); }
            set { setAttrVal<FDateTime>("Investigate_date", value); }
        }
		public string Investigater {
            get { return getAttrVal<string>("Investigater",null); }
            set { setAttrVal<string>("Investigater", value); }
        }
		public string Cert_status {
            get { return getAttrVal<string>("Cert_status",null); }
            set { setAttrVal<string>("Cert_status", value); }
        }
		public string Verifiedby {
            get { return getAttrVal<string>("Verifiedby",null); }
            set { setAttrVal<string>("Verifiedby", value); }
        }
		public DateTime? Verifiedtime {
            get { return getAttrVal<FDateTime>("Verifiedtime",null); }
            set { setAttrVal<FDateTime>("Verifiedtime", value); }
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
		public string Code_sex {
            get { return getAttrVal<string>("Code_sex",null); }
            set { setAttrVal<string>("Code_sex", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Code_cardtype {
            get { return getAttrVal<string>("Code_cardtype",null); }
            set { setAttrVal<string>("Code_cardtype", value); }
        }
		public string Name_cardtype {
            get { return getAttrVal<string>("Name_cardtype",null); }
            set { setAttrVal<string>("Name_cardtype", value); }
        }
		public string Code_country {
            get { return getAttrVal<string>("Code_country",null); }
            set { setAttrVal<string>("Code_country", value); }
        }
		public string Name_country {
            get { return getAttrVal<string>("Name_country",null); }
            set { setAttrVal<string>("Name_country", value); }
        }
		public string Codeth_country {
            get { return getAttrVal<string>("Codeth_country",null); }
            set { setAttrVal<string>("Codeth_country", value); }
        }
		public string Fullname_country {
            get { return getAttrVal<string>("Fullname_country",null); }
            set { setAttrVal<string>("Fullname_country", value); }
        }
		public string Code_nation {
            get { return getAttrVal<string>("Code_nation",null); }
            set { setAttrVal<string>("Code_nation", value); }
        }
		public string Name_nation {
            get { return getAttrVal<string>("Name_nation",null); }
            set { setAttrVal<string>("Name_nation", value); }
        }
		public string Code_marry {
            get { return getAttrVal<string>("Code_marry",null); }
            set { setAttrVal<string>("Code_marry", value); }
        }
		public string Name_marry {
            get { return getAttrVal<string>("Name_marry",null); }
            set { setAttrVal<string>("Name_marry", value); }
        }
		public string Code_degree {
            get { return getAttrVal<string>("Code_degree",null); }
            set { setAttrVal<string>("Code_degree", value); }
        }
		public string Name_degree {
            get { return getAttrVal<string>("Name_degree",null); }
            set { setAttrVal<string>("Name_degree", value); }
        }
		public string Code_job {
            get { return getAttrVal<string>("Code_job",null); }
            set { setAttrVal<string>("Code_job", value); }
        }
		public string Name_job {
            get { return getAttrVal<string>("Name_job",null); }
            set { setAttrVal<string>("Name_job", value); }
        }
		public string Code_address {
            get { return getAttrVal<string>("Code_address",null); }
            set { setAttrVal<string>("Code_address", value); }
        }
		public string Name_address {
            get { return getAttrVal<string>("Name_address",null); }
            set { setAttrVal<string>("Name_address", value); }
        }
		public string Code_deathsite {
            get { return getAttrVal<string>("Code_deathsite",null); }
            set { setAttrVal<string>("Code_deathsite", value); }
        }
		public string Name_deathsite {
            get { return getAttrVal<string>("Name_deathsite",null); }
            set { setAttrVal<string>("Name_deathsite", value); }
        }
		public string Code_diagbasis {
            get { return getAttrVal<string>("Code_diagbasis",null); }
            set { setAttrVal<string>("Code_diagbasis", value); }
        }
		public string Name_diagbasis {
            get { return getAttrVal<string>("Name_diagbasis",null); }
            set { setAttrVal<string>("Name_diagbasis", value); }
        }
		public string Code123 {
            get { return getAttrVal<string>("Code123",null); }
            set { setAttrVal<string>("Code123", value); }
        }
		public string Name123 {
            get { return getAttrVal<string>("Name123",null); }
            set { setAttrVal<string>("Name123", value); }
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
            return "ci_mr_death_cert";
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
            return "Id_death_cert";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cideathcert.d.CideathcertDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_death_cert", "Title", "Inhos_no", "Id_pat", "Name_pat", "Id_sex", "Sex_code", "Sex_pat", "Age_pat", "Id_cardtype", "Card_type_code", "Idcard_type", "Idcard_no", "Id_country", "Country_pat", "Id_nation", "Nation_pat", "Birth_pat", "Id_marry", "Marry_code", "Marry_status", "Id_degree", "Degree_code", "Degree_pat", "Id_job", "Personal_identity_code", "Job_pat", "Address_province", "Address_county", "Address_detail", "Address_pat", "Address_pat_code", "Address_pat_name", "Address_pat_street", "Address_code", "Address_no", "Unknown_date", "Death_time", "Death_site", "Death_site_code", "Death_site_name", "Is_pregnant", "Work_company", "Birth_place", "Address_usual", "Relation_name", "Relation_phone", "Relation_address", "Death_a_diag", "Death_a_timespan", "Death_b_diag", "Death_b_timespan", "Death_c_diag", "Death_c_timespan", "Death_d_diag", "Death_d_timespan", "Death_other_diag", "Death_other_timespan", "Diag_basis", "Diag_basis_code", "Diag_basis_name", "Diag_hospital", "Diag_hospital_code", "Diag_hospital_name", "Sign_doctor", "Death_reason", "Diag_icdcode", "Diag_icdname", "Symptom_sign", "Investigate_name", "Investigate_relation", "Investigate_phone", "Investigate_address", "Death_infer", "Investigate_date", "Investigater", "Cert_status", "Verifiedby", "Verifiedtime", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Code_sex", "Name_sex", "Code_cardtype", "Name_cardtype", "Code_country", "Name_country", "Codeth_country", "Fullname_country", "Code_nation", "Name_nation", "Code_marry", "Name_marry", "Code_degree", "Name_degree", "Code_job", "Name_job", "Code_address", "Name_address", "Code_deathsite", "Name_deathsite", "Code_diagbasis", "Name_diagbasis", "Code123", "Name123"};
        }
        
    }
}

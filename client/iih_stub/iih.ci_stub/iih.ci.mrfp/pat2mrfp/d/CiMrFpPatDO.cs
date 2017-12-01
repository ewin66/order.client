
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.pat2mrfp.d
{
    /// <summary>
    /// CiMrFpPatDO 的摘要说明。
    /// </summary>
    public class CiMrFpPatDO : BaseDO {

        public CiMrFpPatDO() {
            this.Age = "-";
        }
		public string Id_cimrfppat {
            get { return getAttrVal<string>("Id_cimrfppat",null); }
            set { setAttrVal<string>("Id_cimrfppat", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public DateTime? Dt_birth_pat {
            get { return getAttrVal<FDate>("Dt_birth_pat",null); }
            set { setAttrVal<FDate>("Dt_birth_pat", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age","-"); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Id_emp_phy {
            get { return getAttrVal<string>("Id_emp_phy",null); }
            set { setAttrVal<string>("Id_emp_phy", value); }
        }
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }
		public string Id_emp_nur {
            get { return getAttrVal<string>("Id_emp_nur",null); }
            set { setAttrVal<string>("Id_emp_nur", value); }
        }
		public string Name_emp_nur {
            get { return getAttrVal<string>("Name_emp_nur",null); }
            set { setAttrVal<string>("Name_emp_nur", value); }
        }
		public string Id_zr_doc {
            get { return getAttrVal<string>("Id_zr_doc",null); }
            set { setAttrVal<string>("Id_zr_doc", value); }
        }
		public string Name_zr_doc {
            get { return getAttrVal<string>("Name_zr_doc",null); }
            set { setAttrVal<string>("Name_zr_doc", value); }
        }
		public string Id_zz_doc {
            get { return getAttrVal<string>("Id_zz_doc",null); }
            set { setAttrVal<string>("Id_zz_doc", value); }
        }
		public string Name_zz_doc {
            get { return getAttrVal<string>("Name_zz_doc",null); }
            set { setAttrVal<string>("Name_zz_doc", value); }
        }
		public string Id_zy_doc {
            get { return getAttrVal<string>("Id_zy_doc",null); }
            set { setAttrVal<string>("Id_zy_doc", value); }
        }
		public string Name_zy_doc {
            get { return getAttrVal<string>("Name_zy_doc",null); }
            set { setAttrVal<string>("Name_zy_doc", value); }
        }
		public string Addr_born {
            get { return getAttrVal<string>("Addr_born",null); }
            set { setAttrVal<string>("Addr_born", value); }
        }
		public string Addr_origin {
            get { return getAttrVal<string>("Addr_origin",null); }
            set { setAttrVal<string>("Addr_origin", value); }
        }
		public string Addr_now {
            get { return getAttrVal<string>("Addr_now",null); }
            set { setAttrVal<string>("Addr_now", value); }
        }
		public string Tel_addr_now {
            get { return getAttrVal<string>("Tel_addr_now",null); }
            set { setAttrVal<string>("Tel_addr_now", value); }
        }
		public string Zip_addr_now {
            get { return getAttrVal<string>("Zip_addr_now",null); }
            set { setAttrVal<string>("Zip_addr_now", value); }
        }
		public string Addr_cencus {
            get { return getAttrVal<string>("Addr_cencus",null); }
            set { setAttrVal<string>("Addr_cencus", value); }
        }
		public string Zip_addr_cencus {
            get { return getAttrVal<string>("Zip_addr_cencus",null); }
            set { setAttrVal<string>("Zip_addr_cencus", value); }
        }
		public string Workunit {
            get { return getAttrVal<string>("Workunit",null); }
            set { setAttrVal<string>("Workunit", value); }
        }
		public string Addr_work {
            get { return getAttrVal<string>("Addr_work",null); }
            set { setAttrVal<string>("Addr_work", value); }
        }
		public string Del_addr_work {
            get { return getAttrVal<string>("Del_addr_work",null); }
            set { setAttrVal<string>("Del_addr_work", value); }
        }
		public string Zip_addr_work {
            get { return getAttrVal<string>("Zip_addr_work",null); }
            set { setAttrVal<string>("Zip_addr_work", value); }
        }
		public string Name_cont {
            get { return getAttrVal<string>("Name_cont",null); }
            set { setAttrVal<string>("Name_cont", value); }
        }
		public string Id_conttp {
            get { return getAttrVal<string>("Id_conttp",null); }
            set { setAttrVal<string>("Id_conttp", value); }
        }
		public string Sd_conttp {
            get { return getAttrVal<string>("Sd_conttp",null); }
            set { setAttrVal<string>("Sd_conttp", value); }
        }
		public string Addr_cont {
            get { return getAttrVal<string>("Addr_cont",null); }
            set { setAttrVal<string>("Addr_cont", value); }
        }
		public string Tel_cont {
            get { return getAttrVal<string>("Tel_cont",null); }
            set { setAttrVal<string>("Tel_cont", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Id_pay_method {
            get { return getAttrVal<string>("Id_pay_method",null); }
            set { setAttrVal<string>("Id_pay_method", value); }
        }
		public string Sd_pay_method {
            get { return getAttrVal<string>("Sd_pay_method",null); }
            set { setAttrVal<string>("Sd_pay_method", value); }
        }
		public int? N_times_inhospital {
            get { return getAttrVal<int?>("N_times_inhospital",null); }
            set { setAttrVal<int?>("N_times_inhospital", value); }
        }
		public string Id_country {
            get { return getAttrVal<string>("Id_country",null); }
            set { setAttrVal<string>("Id_country", value); }
        }
		public string Sd_country {
            get { return getAttrVal<string>("Sd_country",null); }
            set { setAttrVal<string>("Sd_country", value); }
        }
		public string Id_nation {
            get { return getAttrVal<string>("Id_nation",null); }
            set { setAttrVal<string>("Id_nation", value); }
        }
		public string Sd_nation {
            get { return getAttrVal<string>("Sd_nation",null); }
            set { setAttrVal<string>("Sd_nation", value); }
        }
		public string Id_marry {
            get { return getAttrVal<string>("Id_marry",null); }
            set { setAttrVal<string>("Id_marry", value); }
        }
		public string Sd_marry {
            get { return getAttrVal<string>("Sd_marry",null); }
            set { setAttrVal<string>("Sd_marry", value); }
        }
		public string Id_idtp {
            get { return getAttrVal<string>("Id_idtp",null); }
            set { setAttrVal<string>("Id_idtp", value); }
        }
		public string Sd_idtp {
            get { return getAttrVal<string>("Sd_idtp",null); }
            set { setAttrVal<string>("Sd_idtp", value); }
        }
		public string Id_code {
            get { return getAttrVal<string>("Id_code",null); }
            set { setAttrVal<string>("Id_code", value); }
        }
		public string Id_occu {
            get { return getAttrVal<string>("Id_occu",null); }
            set { setAttrVal<string>("Id_occu", value); }
        }
		public string Sd_occu {
            get { return getAttrVal<string>("Sd_occu",null); }
            set { setAttrVal<string>("Sd_occu", value); }
        }
		public string Age_month {
            get { return getAttrVal<string>("Age_month",null); }
            set { setAttrVal<string>("Age_month", value); }
        }
		public int? Birth_weight {
            get { return getAttrVal<int?>("Birth_weight",null); }
            set { setAttrVal<int?>("Birth_weight", value); }
        }
		public int? Addmission_weight {
            get { return getAttrVal<int?>("Addmission_weight",null); }
            set { setAttrVal<int?>("Addmission_weight", value); }
        }
		public string Id_referalsrc {
            get { return getAttrVal<string>("Id_referalsrc",null); }
            set { setAttrVal<string>("Id_referalsrc", value); }
        }
		public string Sd_referalsrc {
            get { return getAttrVal<string>("Sd_referalsrc",null); }
            set { setAttrVal<string>("Sd_referalsrc", value); }
        }
		public DateTime? Dt_acpt {
            get { return getAttrVal<FDateTime>("Dt_acpt",null); }
            set { setAttrVal<FDateTime>("Dt_acpt", value); }
        }
		public string Id_dep_phyadm {
            get { return getAttrVal<string>("Id_dep_phyadm",null); }
            set { setAttrVal<string>("Id_dep_phyadm", value); }
        }
		public string Sd_dep_phyadm {
            get { return getAttrVal<string>("Sd_dep_phyadm",null); }
            set { setAttrVal<string>("Sd_dep_phyadm", value); }
        }
		public string Id_dep_trans {
            get { return getAttrVal<string>("Id_dep_trans",null); }
            set { setAttrVal<string>("Id_dep_trans", value); }
        }
		public string Sd_dep_trans {
            get { return getAttrVal<string>("Sd_dep_trans",null); }
            set { setAttrVal<string>("Sd_dep_trans", value); }
        }
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
		public string Id_dep_phydisc {
            get { return getAttrVal<string>("Id_dep_phydisc",null); }
            set { setAttrVal<string>("Id_dep_phydisc", value); }
        }
		public string Sd_dep_phydisc {
            get { return getAttrVal<string>("Sd_dep_phydisc",null); }
            set { setAttrVal<string>("Sd_dep_phydisc", value); }
        }
		public int? Hosdays {
            get { return getAttrVal<int?>("Hosdays",null); }
            set { setAttrVal<int?>("Hosdays", value); }
        }
		public string In_id_bed {
            get { return getAttrVal<string>("In_id_bed",null); }
            set { setAttrVal<string>("In_id_bed", value); }
        }
		public string Out_id_bed {
            get { return getAttrVal<string>("Out_id_bed",null); }
            set { setAttrVal<string>("Out_id_bed", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Name_country {
            get { return getAttrVal<string>("Name_country",null); }
            set { setAttrVal<string>("Name_country", value); }
        }
		public string Name_nation {
            get { return getAttrVal<string>("Name_nation",null); }
            set { setAttrVal<string>("Name_nation", value); }
        }
		public string Name_occu {
            get { return getAttrVal<string>("Name_occu",null); }
            set { setAttrVal<string>("Name_occu", value); }
        }
		public string Name_marry {
            get { return getAttrVal<string>("Name_marry",null); }
            set { setAttrVal<string>("Name_marry", value); }
        }
		public string Name_conttp {
            get { return getAttrVal<string>("Name_conttp",null); }
            set { setAttrVal<string>("Name_conttp", value); }
        }
		public string Name_referalsrc {
            get { return getAttrVal<string>("Name_referalsrc",null); }
            set { setAttrVal<string>("Name_referalsrc", value); }
        }
		public string Name_dep_phyadm {
            get { return getAttrVal<string>("Name_dep_phyadm",null); }
            set { setAttrVal<string>("Name_dep_phyadm", value); }
        }
		public string Name_dep_trans {
            get { return getAttrVal<string>("Name_dep_trans",null); }
            set { setAttrVal<string>("Name_dep_trans", value); }
        }
		public string Name_dep_phydisc {
            get { return getAttrVal<string>("Name_dep_phydisc",null); }
            set { setAttrVal<string>("Name_dep_phydisc", value); }
        }
		public string Name_pay_method {
            get { return getAttrVal<string>("Name_pay_method",null); }
            set { setAttrVal<string>("Name_pay_method", value); }
        }
		public string Id_outp_emer_di {
            get { return getAttrVal<string>("Id_outp_emer_di",null); }
            set { setAttrVal<string>("Id_outp_emer_di", value); }
        }
		public string Name_outp_emer_di {
            get { return getAttrVal<string>("Name_outp_emer_di",null); }
            set { setAttrVal<string>("Name_outp_emer_di", value); }
        }
		public string Sd_outp_emer_di {
            get { return getAttrVal<string>("Sd_outp_emer_di",null); }
            set { setAttrVal<string>("Sd_outp_emer_di", value); }
        }
		public string Sex_code {
            get { return getAttrVal<string>("Sex_code",null); }
            set { setAttrVal<string>("Sex_code", value); }
        }
		public string Sex_name {
            get { return getAttrVal<string>("Sex_name",null); }
            set { setAttrVal<string>("Sex_name", value); }
        }
		public string Conttp_code {
            get { return getAttrVal<string>("Conttp_code",null); }
            set { setAttrVal<string>("Conttp_code", value); }
        }
		public string Conttp_name {
            get { return getAttrVal<string>("Conttp_name",null); }
            set { setAttrVal<string>("Conttp_name", value); }
        }
		public string Pay_method_code {
            get { return getAttrVal<string>("Pay_method_code",null); }
            set { setAttrVal<string>("Pay_method_code", value); }
        }
		public string Pay_method_name {
            get { return getAttrVal<string>("Pay_method_name",null); }
            set { setAttrVal<string>("Pay_method_name", value); }
        }
		public string Country_code {
            get { return getAttrVal<string>("Country_code",null); }
            set { setAttrVal<string>("Country_code", value); }
        }
		public string Country_name {
            get { return getAttrVal<string>("Country_name",null); }
            set { setAttrVal<string>("Country_name", value); }
        }
		public string Nation_code {
            get { return getAttrVal<string>("Nation_code",null); }
            set { setAttrVal<string>("Nation_code", value); }
        }
		public string Nation_name {
            get { return getAttrVal<string>("Nation_name",null); }
            set { setAttrVal<string>("Nation_name", value); }
        }
		public string Marry_code {
            get { return getAttrVal<string>("Marry_code",null); }
            set { setAttrVal<string>("Marry_code", value); }
        }
		public string Marry_name {
            get { return getAttrVal<string>("Marry_name",null); }
            set { setAttrVal<string>("Marry_name", value); }
        }
		public string Idtp_code {
            get { return getAttrVal<string>("Idtp_code",null); }
            set { setAttrVal<string>("Idtp_code", value); }
        }
		public string Idtp_name {
            get { return getAttrVal<string>("Idtp_name",null); }
            set { setAttrVal<string>("Idtp_name", value); }
        }
		public string Occu_code {
            get { return getAttrVal<string>("Occu_code",null); }
            set { setAttrVal<string>("Occu_code", value); }
        }
		public string Occu_name {
            get { return getAttrVal<string>("Occu_name",null); }
            set { setAttrVal<string>("Occu_name", value); }
        }
		public string Referalsrc_code {
            get { return getAttrVal<string>("Referalsrc_code",null); }
            set { setAttrVal<string>("Referalsrc_code", value); }
        }
		public string Referalsrc_name {
            get { return getAttrVal<string>("Referalsrc_name",null); }
            set { setAttrVal<string>("Referalsrc_name", value); }
        }
		public string Dep_phyadm_code {
            get { return getAttrVal<string>("Dep_phyadm_code",null); }
            set { setAttrVal<string>("Dep_phyadm_code", value); }
        }
		public string Dep_phyadm_name {
            get { return getAttrVal<string>("Dep_phyadm_name",null); }
            set { setAttrVal<string>("Dep_phyadm_name", value); }
        }
		public string Dep_trans_code {
            get { return getAttrVal<string>("Dep_trans_code",null); }
            set { setAttrVal<string>("Dep_trans_code", value); }
        }
		public string Dep_trans_name {
            get { return getAttrVal<string>("Dep_trans_name",null); }
            set { setAttrVal<string>("Dep_trans_name", value); }
        }
		public string Dep_phydisc_code {
            get { return getAttrVal<string>("Dep_phydisc_code",null); }
            set { setAttrVal<string>("Dep_phydisc_code", value); }
        }
		public string Dep_phydisc_name {
            get { return getAttrVal<string>("Dep_phydisc_name",null); }
            set { setAttrVal<string>("Dep_phydisc_name", value); }
        }
		public string Code_outp_di {
            get { return getAttrVal<string>("Code_outp_di",null); }
            set { setAttrVal<string>("Code_outp_di", value); }
        }
		public string Name_outp_di {
            get { return getAttrVal<string>("Name_outp_di",null); }
            set { setAttrVal<string>("Name_outp_di", value); }
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
            return "CI_MR_FP_PAT";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_cimrfppat";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.pat2mrfp.d.CiMrFpPatDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_cimrfppat", "Id_ent", "Id_pat", "Name_pat", "Id_entp", "Code_entp", "Id_sex", "Sd_sex", "Dt_birth_pat", "Age", "Id_emp_phy", "Name_emp_phy", "Id_emp_nur", "Name_emp_nur", "Id_zr_doc", "Name_zr_doc", "Id_zz_doc", "Name_zz_doc", "Id_zy_doc", "Name_zy_doc", "Addr_born", "Addr_origin", "Addr_now", "Tel_addr_now", "Zip_addr_now", "Addr_cencus", "Zip_addr_cencus", "Workunit", "Addr_work", "Del_addr_work", "Zip_addr_work", "Name_cont", "Id_conttp", "Sd_conttp", "Addr_cont", "Tel_cont", "Code_amr_ip", "Id_pay_method", "Sd_pay_method", "N_times_inhospital", "Id_country", "Sd_country", "Id_nation", "Sd_nation", "Id_marry", "Sd_marry", "Id_idtp", "Sd_idtp", "Id_code", "Id_occu", "Sd_occu", "Age_month", "Birth_weight", "Addmission_weight", "Id_referalsrc", "Sd_referalsrc", "Dt_acpt", "Id_dep_phyadm", "Sd_dep_phyadm", "Id_dep_trans", "Sd_dep_trans", "Dt_end", "Id_dep_phydisc", "Sd_dep_phydisc", "Hosdays", "In_id_bed", "Out_id_bed", "Name_sex", "Name_country", "Name_nation", "Name_occu", "Name_marry", "Name_conttp", "Name_referalsrc", "Name_dep_phyadm", "Name_dep_trans", "Name_dep_phydisc", "Name_pay_method", "Id_outp_emer_di", "Name_outp_emer_di", "Sd_outp_emer_di", "Sex_code", "Sex_name", "Conttp_code", "Conttp_name", "Pay_method_code", "Pay_method_name", "Country_code", "Country_name", "Nation_code", "Nation_name", "Marry_code", "Marry_name", "Idtp_code", "Idtp_name", "Occu_code", "Occu_name", "Referalsrc_code", "Referalsrc_name", "Dep_phyadm_code", "Dep_phyadm_name", "Dep_trans_code", "Dep_trans_name", "Dep_phydisc_code", "Dep_phydisc_name", "Code_outp_di", "Name_outp_di"};
        }
        
    }
}

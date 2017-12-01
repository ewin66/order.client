
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.drugsinfo.d
{
    /// <summary>
    /// DrugSensitiInfoDO 的摘要说明。
    /// </summary>
    public class DrugSensitiInfoDO : BaseDO {

        public DrugSensitiInfoDO() {
            this.Drug_sen_test = false;
            this.Drug_sen_result = false;
        }
		public string Id_drugseinfo {
            get { return getAttrVal<string>("Id_drugseinfo",null); }
            set { setAttrVal<string>("Id_drugseinfo", value); }
        }
		public string Id_hospitalreport {
            get { return getAttrVal<string>("Id_hospitalreport",null); }
            set { setAttrVal<string>("Id_hospitalreport", value); }
        }
		public string Id_samplename {
            get { return getAttrVal<string>("Id_samplename",null); }
            set { setAttrVal<string>("Id_samplename", value); }
        }
		public string Sd_samplename {
            get { return getAttrVal<string>("Sd_samplename",null); }
            set { setAttrVal<string>("Sd_samplename", value); }
        }
		public string Name_samplename {
            get { return getAttrVal<string>("Name_samplename",null); }
            set { setAttrVal<string>("Name_samplename", value); }
        }
		public DateTime? Submission_date {
            get { return getAttrVal<FDate>("Submission_date",null); }
            set { setAttrVal<FDate>("Submission_date", value); }
        }
		public string Id_test_method {
            get { return getAttrVal<string>("Id_test_method",null); }
            set { setAttrVal<string>("Id_test_method", value); }
        }
		public string Sd_test_method {
            get { return getAttrVal<string>("Sd_test_method",null); }
            set { setAttrVal<string>("Sd_test_method", value); }
        }
		public string Name_test_method {
            get { return getAttrVal<string>("Name_test_method",null); }
            set { setAttrVal<string>("Name_test_method", value); }
        }
		public string Id_pathogen_species {
            get { return getAttrVal<string>("Id_pathogen_species",null); }
            set { setAttrVal<string>("Id_pathogen_species", value); }
        }
		public string Sd_pathogen_species {
            get { return getAttrVal<string>("Sd_pathogen_species",null); }
            set { setAttrVal<string>("Sd_pathogen_species", value); }
        }
		public string Name_pathogen_species {
            get { return getAttrVal<string>("Name_pathogen_species",null); }
            set { setAttrVal<string>("Name_pathogen_species", value); }
        }
		public string Id_spe_test_result {
            get { return getAttrVal<string>("Id_spe_test_result",null); }
            set { setAttrVal<string>("Id_spe_test_result", value); }
        }
		public string Sd_spe_test_result {
            get { return getAttrVal<string>("Sd_spe_test_result",null); }
            set { setAttrVal<string>("Sd_spe_test_result", value); }
        }
		public string Name_spe_test_result {
            get { return getAttrVal<string>("Name_spe_test_result",null); }
            set { setAttrVal<string>("Name_spe_test_result", value); }
        }
		public bool? Drug_sen_test {
            get { return getAttrVal<FBoolean>("Drug_sen_test",false); }
            set { setAttrVal<FBoolean>("Drug_sen_test", value); }
        }
		public bool? Drug_sen_result {
            get { return getAttrVal<FBoolean>("Drug_sen_result",false); }
            set { setAttrVal<FBoolean>("Drug_sen_result", value); }
        }
		public string Id_infe_site {
            get { return getAttrVal<string>("Id_infe_site",null); }
            set { setAttrVal<string>("Id_infe_site", value); }
        }
		public string Sd_infe_site {
            get { return getAttrVal<string>("Sd_infe_site",null); }
            set { setAttrVal<string>("Sd_infe_site", value); }
        }
		public string Name_infe_site {
            get { return getAttrVal<string>("Name_infe_site",null); }
            set { setAttrVal<string>("Name_infe_site", value); }
        }
		public string Samplename_code {
            get { return getAttrVal<string>("Samplename_code",null); }
            set { setAttrVal<string>("Samplename_code", value); }
        }
		public string Samplename_name {
            get { return getAttrVal<string>("Samplename_name",null); }
            set { setAttrVal<string>("Samplename_name", value); }
        }
		public string Test_method_code {
            get { return getAttrVal<string>("Test_method_code",null); }
            set { setAttrVal<string>("Test_method_code", value); }
        }
		public string Test_method_name {
            get { return getAttrVal<string>("Test_method_name",null); }
            set { setAttrVal<string>("Test_method_name", value); }
        }
		public string Pathogen_species_code {
            get { return getAttrVal<string>("Pathogen_species_code",null); }
            set { setAttrVal<string>("Pathogen_species_code", value); }
        }
		public string Pathogen_species_name {
            get { return getAttrVal<string>("Pathogen_species_name",null); }
            set { setAttrVal<string>("Pathogen_species_name", value); }
        }
		public string Spe_test_result_code {
            get { return getAttrVal<string>("Spe_test_result_code",null); }
            set { setAttrVal<string>("Spe_test_result_code", value); }
        }
		public string Spe_test_result_name {
            get { return getAttrVal<string>("Spe_test_result_name",null); }
            set { setAttrVal<string>("Spe_test_result_name", value); }
        }
		public string Infe_site_code {
            get { return getAttrVal<string>("Infe_site_code",null); }
            set { setAttrVal<string>("Infe_site_code", value); }
        }
		public string Infe_site_name {
            get { return getAttrVal<string>("Infe_site_name",null); }
            set { setAttrVal<string>("Infe_site_name", value); }
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
            return "CI_MR_CONTAGION_CARD_DSI";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_drugseinfo";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.drugsinfo.d.DrugSensitiInfoDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_drugseinfo", "Id_hospitalreport", "Id_samplename", "Sd_samplename", "Name_samplename", "Submission_date", "Id_test_method", "Sd_test_method", "Name_test_method", "Id_pathogen_species", "Sd_pathogen_species", "Name_pathogen_species", "Id_spe_test_result", "Sd_spe_test_result", "Name_spe_test_result", "Drug_sen_test", "Drug_sen_result", "Id_infe_site", "Sd_infe_site", "Name_infe_site", "Samplename_code", "Samplename_name", "Test_method_code", "Test_method_name", "Pathogen_species_code", "Pathogen_species_name", "Spe_test_result_code", "Spe_test_result_name", "Infe_site_code", "Infe_site_name"};
        }
        
    }
}

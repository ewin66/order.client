
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.consite.d
{
    /// <summary>
    /// ConSiteDO 的摘要说明。
    /// </summary>
    public class ConSiteDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_CONTAGION_SITE";
		public const string TABLE_ALIAS_NAME = "a0";

        public ConSiteDO() {
        }
		public string Id_site {
            get { return getAttrVal<string>("Id_site",null); }
            set { setAttrVal<string>("Id_site", value); }
        }
		public string Id_hospitalreport {
            get { return getAttrVal<string>("Id_hospitalreport",null); }
            set { setAttrVal<string>("Id_hospitalreport", value); }
        }
		public DateTime? Infectedate {
            get { return getAttrVal<FDate>("Infectedate",null); }
            set { setAttrVal<FDate>("Infectedate", value); }
        }
		public string Id_infecte_site {
            get { return getAttrVal<string>("Id_infecte_site",null); }
            set { setAttrVal<string>("Id_infecte_site", value); }
        }
		public string Sd_infecte_site {
            get { return getAttrVal<string>("Sd_infecte_site",null); }
            set { setAttrVal<string>("Sd_infecte_site", value); }
        }
		public string Name_infecte_site {
            get { return getAttrVal<string>("Name_infecte_site",null); }
            set { setAttrVal<string>("Name_infecte_site", value); }
        }
		public string Infecte_site_other {
            get { return getAttrVal<string>("Infecte_site_other",null); }
            set { setAttrVal<string>("Infecte_site_other", value); }
        }
		public string Id_di_infection {
            get { return getAttrVal<string>("Id_di_infection",null); }
            set { setAttrVal<string>("Id_di_infection", value); }
        }
		public string Sd_di_infection {
            get { return getAttrVal<string>("Sd_di_infection",null); }
            set { setAttrVal<string>("Sd_di_infection", value); }
        }
		public string Name_di_infection {
            get { return getAttrVal<string>("Name_di_infection",null); }
            set { setAttrVal<string>("Name_di_infection", value); }
        }
		public string Id_inva_oper {
            get { return getAttrVal<string>("Id_inva_oper",null); }
            set { setAttrVal<string>("Id_inva_oper", value); }
        }
		public string Sd_inva_oper {
            get { return getAttrVal<string>("Sd_inva_oper",null); }
            set { setAttrVal<string>("Sd_inva_oper", value); }
        }
		public string Name_inva_oper {
            get { return getAttrVal<string>("Name_inva_oper",null); }
            set { setAttrVal<string>("Name_inva_oper", value); }
        }
		public string Id_report_dept {
            get { return getAttrVal<string>("Id_report_dept",null); }
            set { setAttrVal<string>("Id_report_dept", value); }
        }
		public string Name_report_dept {
            get { return getAttrVal<string>("Name_report_dept",null); }
            set { setAttrVal<string>("Name_report_dept", value); }
        }
		public string Sd_report_dept {
            get { return getAttrVal<string>("Sd_report_dept",null); }
            set { setAttrVal<string>("Sd_report_dept", value); }
        }
		public string Id_report_person {
            get { return getAttrVal<string>("Id_report_person",null); }
            set { setAttrVal<string>("Id_report_person", value); }
        }
		public string Name_report_person {
            get { return getAttrVal<string>("Name_report_person",null); }
            set { setAttrVal<string>("Name_report_person", value); }
        }
		public string Sd_report_person {
            get { return getAttrVal<string>("Sd_report_person",null); }
            set { setAttrVal<string>("Sd_report_person", value); }
        }
		public string Dt_report {
            get { return getAttrVal<string>("Dt_report",null); }
            set { setAttrVal<string>("Dt_report", value); }
        }
		public string Operation {
            get { return getAttrVal<string>("Operation",null); }
            set { setAttrVal<string>("Operation", value); }
        }
		public string Infecte_site_name {
            get { return getAttrVal<string>("Infecte_site_name",null); }
            set { setAttrVal<string>("Infecte_site_name", value); }
        }
		public string Infecte_site_code {
            get { return getAttrVal<string>("Infecte_site_code",null); }
            set { setAttrVal<string>("Infecte_site_code", value); }
        }
		public string Di_infection_code {
            get { return getAttrVal<string>("Di_infection_code",null); }
            set { setAttrVal<string>("Di_infection_code", value); }
        }
		public string Di_infection_name {
            get { return getAttrVal<string>("Di_infection_name",null); }
            set { setAttrVal<string>("Di_infection_name", value); }
        }
		public string Inva_oper_code {
            get { return getAttrVal<string>("Inva_oper_code",null); }
            set { setAttrVal<string>("Inva_oper_code", value); }
        }
		public string Inva_oper_name {
            get { return getAttrVal<string>("Inva_oper_name",null); }
            set { setAttrVal<string>("Inva_oper_name", value); }
        }
		public string Report_dept_code {
            get { return getAttrVal<string>("Report_dept_code",null); }
            set { setAttrVal<string>("Report_dept_code", value); }
        }
		public string Report_dept_name {
            get { return getAttrVal<string>("Report_dept_name",null); }
            set { setAttrVal<string>("Report_dept_name", value); }
        }
		public string Report_person_code {
            get { return getAttrVal<string>("Report_person_code",null); }
            set { setAttrVal<string>("Report_person_code", value); }
        }
		public string Report_person_name {
            get { return getAttrVal<string>("Report_person_name",null); }
            set { setAttrVal<string>("Report_person_name", value); }
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
            return "CI_MR_CONTAGION_SITE";
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
            return "Id_site";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.consite.d.ConSiteDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_site", "Id_hospitalreport", "Infectedate", "Id_infecte_site", "Sd_infecte_site", "Name_infecte_site", "Infecte_site_other", "Id_di_infection", "Sd_di_infection", "Name_di_infection", "Id_inva_oper", "Sd_inva_oper", "Name_inva_oper", "Id_report_dept", "Name_report_dept", "Sd_report_dept", "Id_report_person", "Name_report_person", "Sd_report_person", "Dt_report", "Operation", "Infecte_site_name", "Infecte_site_code", "Di_infection_code", "Di_infection_name", "Inva_oper_code", "Inva_oper_name", "Report_dept_code", "Report_dept_name", "Report_person_code", "Report_person_name"};
        }
        
    }
}

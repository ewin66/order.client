
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cirptpathgy.d
{
    /// <summary>
    /// CiRptPathgyDO 的摘要说明。
    /// </summary>
    public class CiRptPathgyDO : BaseDO {

        public CiRptPathgyDO() {
        }
		public string Id_rptpathgy {
            get { return getAttrVal<string>("Id_rptpathgy",null); }
            set { setAttrVal<string>("Id_rptpathgy", value); }
        }
		public string Id_appathgy {
            get { return getAttrVal<string>("Id_appathgy",null); }
            set { setAttrVal<string>("Id_appathgy", value); }
        }
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string No_rptpathgy {
            get { return getAttrVal<string>("No_rptpathgy",null); }
            set { setAttrVal<string>("No_rptpathgy", value); }
        }
		public string Des_rptpathgy {
            get { return getAttrVal<string>("Des_rptpathgy",null); }
            set { setAttrVal<string>("Des_rptpathgy", value); }
        }
		public string Des_advice {
            get { return getAttrVal<string>("Des_advice",null); }
            set { setAttrVal<string>("Des_advice", value); }
        }
		public string Des_pathgy {
            get { return getAttrVal<string>("Des_pathgy",null); }
            set { setAttrVal<string>("Des_pathgy", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Sd_insmt {
            get { return getAttrVal<string>("Sd_insmt",null); }
            set { setAttrVal<string>("Sd_insmt", value); }
        }
		public string Id_su_rpt {
            get { return getAttrVal<string>("Id_su_rpt",null); }
            set { setAttrVal<string>("Id_su_rpt", value); }
        }
		public string Sd_su_rpt {
            get { return getAttrVal<string>("Sd_su_rpt",null); }
            set { setAttrVal<string>("Sd_su_rpt", value); }
        }
		public DateTime? Dt_rptpathgy {
            get { return getAttrVal<FDateTime>("Dt_rptpathgy",null); }
            set { setAttrVal<FDateTime>("Dt_rptpathgy", value); }
        }
		public string Id_emp_rpt {
            get { return getAttrVal<string>("Id_emp_rpt",null); }
            set { setAttrVal<string>("Id_emp_rpt", value); }
        }
		public string Id_dep_rpt {
            get { return getAttrVal<string>("Id_dep_rpt",null); }
            set { setAttrVal<string>("Id_dep_rpt", value); }
        }
		public string Url_img {
            get { return getAttrVal<string>("Url_img",null); }
            set { setAttrVal<string>("Url_img", value); }
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
		public string Applyformno {
            get { return getAttrVal<string>("Applyformno",null); }
            set { setAttrVal<string>("Applyformno", value); }
        }
		public string Dt_effe {
            get { return getAttrVal<string>("Dt_effe",null); }
            set { setAttrVal<string>("Dt_effe", value); }
        }
		public string Psn_name {
            get { return getAttrVal<string>("Psn_name",null); }
            set { setAttrVal<string>("Psn_name", value); }
        }
		public string Sex_name {
            get { return getAttrVal<string>("Sex_name",null); }
            set { setAttrVal<string>("Sex_name", value); }
        }
		public string Name_or {
            get { return getAttrVal<string>("Name_or",null); }
            set { setAttrVal<string>("Name_or", value); }
        }
		public string Ent_code {
            get { return getAttrVal<string>("Ent_code",null); }
            set { setAttrVal<string>("Ent_code", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Su_name {
            get { return getAttrVal<string>("Su_name",null); }
            set { setAttrVal<string>("Su_name", value); }
        }
		public string Rpt_name {
            get { return getAttrVal<string>("Rpt_name",null); }
            set { setAttrVal<string>("Rpt_name", value); }
        }
		public string Dep_name {
            get { return getAttrVal<string>("Dep_name",null); }
            set { setAttrVal<string>("Dep_name", value); }
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
            return "ci_rpt_pathgy";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rptpathgy";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cirptpathgy.d.CiRptPathgyDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptpathgy", "Id_appathgy", "No_applyform", "Id_or", "No_rptpathgy", "Des_rptpathgy", "Des_advice", "Des_pathgy", "Id_ent", "Sd_insmt", "Id_su_rpt", "Sd_su_rpt", "Dt_rptpathgy", "Id_emp_rpt", "Id_dep_rpt", "Url_img", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Applyformno", "Dt_effe", "Psn_name", "Sex_name", "Name_or", "Ent_code", "Name_pat", "Su_name", "Rpt_name", "Dep_name"};
        }
        
    }
}

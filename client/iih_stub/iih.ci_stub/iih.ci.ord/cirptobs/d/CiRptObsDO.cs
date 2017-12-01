
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cirptobs.d
{
    /// <summary>
    /// CiRptObsDO 的摘要说明。
    /// </summary>
    public class CiRptObsDO : BaseDO {

        public CiRptObsDO() {
        }
		public string Id_rptobs {
            get { return getAttrVal<string>("Id_rptobs",null); }
            set { setAttrVal<string>("Id_rptobs", value); }
        }
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }
		public string Id_orobs {
            get { return getAttrVal<string>("Id_orobs",null); }
            set { setAttrVal<string>("Id_orobs", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string No_rptobs {
            get { return getAttrVal<string>("No_rptobs",null); }
            set { setAttrVal<string>("No_rptobs", value); }
        }
		public string Des_rptobs {
            get { return getAttrVal<string>("Des_rptobs",null); }
            set { setAttrVal<string>("Des_rptobs", value); }
        }
		public string Des_advice {
            get { return getAttrVal<string>("Des_advice",null); }
            set { setAttrVal<string>("Des_advice", value); }
        }
		public string Des_obs {
            get { return getAttrVal<string>("Des_obs",null); }
            set { setAttrVal<string>("Des_obs", value); }
        }
		public string Id_insmt {
            get { return getAttrVal<string>("Id_insmt",null); }
            set { setAttrVal<string>("Id_insmt", value); }
        }
		public string Sd_insmt {
            get { return getAttrVal<string>("Sd_insmt",null); }
            set { setAttrVal<string>("Sd_insmt", value); }
        }
		public string Id_su {
            get { return getAttrVal<string>("Id_su",null); }
            set { setAttrVal<string>("Id_su", value); }
        }
		public string Sd_su {
            get { return getAttrVal<string>("Sd_su",null); }
            set { setAttrVal<string>("Sd_su", value); }
        }
		public DateTime? Dt_rptobs {
            get { return getAttrVal<FDateTime>("Dt_rptobs",null); }
            set { setAttrVal<FDateTime>("Dt_rptobs", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }
		public string Image_url {
            get { return getAttrVal<string>("Image_url",null); }
            set { setAttrVal<string>("Image_url", value); }
        }
		public string Applyformno {
            get { return getAttrVal<string>("Applyformno",null); }
            set { setAttrVal<string>("Applyformno", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Ent_code {
            get { return getAttrVal<string>("Ent_code",null); }
            set { setAttrVal<string>("Ent_code", value); }
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
            return "CI_RPT_OBS";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rptobs";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cirptobs.d.CiRptObsDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptobs", "No_applyform", "Id_orobs", "Id_ent", "Id_or", "No_rptobs", "Des_rptobs", "Des_advice", "Des_obs", "Id_insmt", "Sd_insmt", "Id_su", "Sd_su", "Dt_rptobs", "Id_emp", "Id_dep", "Image_url", "Applyformno", "Name_pat", "Ent_code", "Su_name", "Rpt_name", "Dep_name"};
        }
        
    }
}

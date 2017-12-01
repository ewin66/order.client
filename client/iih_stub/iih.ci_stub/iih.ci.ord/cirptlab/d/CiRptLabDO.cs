
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cirptlab.d
{
    /// <summary>
    /// CiRptLabDO 的摘要说明。
    /// </summary>
    public class CiRptLabDO : BaseDO {

        public CiRptLabDO() {
        }
		public string Id_rptlab {
            get { return getAttrVal<string>("Id_rptlab",null); }
            set { setAttrVal<string>("Id_rptlab", value); }
        }
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }
		public string Id_orlab {
            get { return getAttrVal<string>("Id_orlab",null); }
            set { setAttrVal<string>("Id_orlab", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string No_rptlab {
            get { return getAttrVal<string>("No_rptlab",null); }
            set { setAttrVal<string>("No_rptlab", value); }
        }
		public string Id_rpttp {
            get { return getAttrVal<string>("Id_rpttp",null); }
            set { setAttrVal<string>("Id_rpttp", value); }
        }
		public string Sd_rpttp {
            get { return getAttrVal<string>("Sd_rpttp",null); }
            set { setAttrVal<string>("Sd_rpttp", value); }
        }
		public string Id_su_lab {
            get { return getAttrVal<string>("Id_su_lab",null); }
            set { setAttrVal<string>("Id_su_lab", value); }
        }
		public string Sd_su_lab {
            get { return getAttrVal<string>("Sd_su_lab",null); }
            set { setAttrVal<string>("Sd_su_lab", value); }
        }
		public string Sd_insmt {
            get { return getAttrVal<string>("Sd_insmt",null); }
            set { setAttrVal<string>("Sd_insmt", value); }
        }
		public string Id_insmt {
            get { return getAttrVal<string>("Id_insmt",null); }
            set { setAttrVal<string>("Id_insmt", value); }
        }
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }
		public DateTime? Dt_rptlab {
            get { return getAttrVal<FDateTime>("Dt_rptlab",null); }
            set { setAttrVal<FDateTime>("Dt_rptlab", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public string Applyformno {
            get { return getAttrVal<string>("Applyformno",null); }
            set { setAttrVal<string>("Applyformno", value); }
        }
		public string Ent_code {
            get { return getAttrVal<string>("Ent_code",null); }
            set { setAttrVal<string>("Ent_code", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_rpttp {
            get { return getAttrVal<string>("Name_rpttp",null); }
            set { setAttrVal<string>("Name_rpttp", value); }
        }
		public string Rpt_name {
            get { return getAttrVal<string>("Rpt_name",null); }
            set { setAttrVal<string>("Rpt_name", value); }
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
            return "CI_RPT_LAB";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rptlab";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cirptlab.d.CiRptLabDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptlab", "No_applyform", "Id_orlab", "Id_ent", "Id_or", "No_rptlab", "Id_rpttp", "Sd_rpttp", "Id_su_lab", "Sd_su_lab", "Sd_insmt", "Id_insmt", "Id_dep", "Dt_rptlab", "Id_emp", "Applyformno", "Ent_code", "Name_pat", "Name_rpttp", "Rpt_name"};
        }
        
    }
}

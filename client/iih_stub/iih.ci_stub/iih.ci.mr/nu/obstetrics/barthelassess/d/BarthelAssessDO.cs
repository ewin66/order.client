
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.barthelassess.d
{
    /// <summary>
    /// BarthelAssessDO 的摘要说明。
    /// </summary>
    public class BarthelAssessDO : BaseDO {

        public BarthelAssessDO() {
        }
		public string Id_ba {
            get { return getAttrVal<string>("Id_ba",null); }
            set { setAttrVal<string>("Id_ba", value); }
        }
		public string Ks {
            get { return getAttrVal<string>("Ks",null); }
            set { setAttrVal<string>("Ks", value); }
        }
		public string Ch {
            get { return getAttrVal<string>("Ch",null); }
            set { setAttrVal<string>("Ch", value); }
        }
		public string Xm {
            get { return getAttrVal<string>("Xm",null); }
            set { setAttrVal<string>("Xm", value); }
        }
		public string Zyh {
            get { return getAttrVal<string>("Zyh",null); }
            set { setAttrVal<string>("Zyh", value); }
        }
		public int? Eu_js {
            get { return getAttrVal<int?>("Eu_js",null); }
            set { setAttrVal<int?>("Eu_js", value); }
        }
		public int? Eu_xz {
            get { return getAttrVal<int?>("Eu_xz",null); }
            set { setAttrVal<int?>("Eu_xz", value); }
        }
		public int? Eu_xs {
            get { return getAttrVal<int?>("Eu_xs",null); }
            set { setAttrVal<int?>("Eu_xs", value); }
        }
		public int? Eu_cy {
            get { return getAttrVal<int?>("Eu_cy",null); }
            set { setAttrVal<int?>("Eu_cy", value); }
        }
		public int? Eu_kzdb {
            get { return getAttrVal<int?>("Eu_kzdb",null); }
            set { setAttrVal<int?>("Eu_kzdb", value); }
        }
		public int? Eu_kzxb {
            get { return getAttrVal<int?>("Eu_kzxb",null); }
            set { setAttrVal<int?>("Eu_kzxb", value); }
        }
		public int? Eu_rc {
            get { return getAttrVal<int?>("Eu_rc",null); }
            set { setAttrVal<int?>("Eu_rc", value); }
        }
		public int? Eu_cyyd {
            get { return getAttrVal<int?>("Eu_cyyd",null); }
            set { setAttrVal<int?>("Eu_cyyd", value); }
        }
		public int? Eu_pdxz {
            get { return getAttrVal<int?>("Eu_pdxz",null); }
            set { setAttrVal<int?>("Eu_pdxz", value); }
        }
		public int? Eu_sxlt {
            get { return getAttrVal<int?>("Eu_sxlt",null); }
            set { setAttrVal<int?>("Eu_sxlt", value); }
        }
		public int? Zf {
            get { return getAttrVal<int?>("Zf",null); }
            set { setAttrVal<int?>("Zf", value); }
        }
		public DateTime? Pgrqsj {
            get { return getAttrVal<FDateTime>("Pgrqsj",null); }
            set { setAttrVal<FDateTime>("Pgrqsj", value); }
        }
		public string Pgr {
            get { return getAttrVal<string>("Pgr",null); }
            set { setAttrVal<string>("Pgr", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_dept {
            get { return getAttrVal<string>("Id_dept",null); }
            set { setAttrVal<string>("Id_dept", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_assess {
            get { return getAttrVal<string>("Id_assess",null); }
            set { setAttrVal<string>("Id_assess", value); }
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
		public string Dept_name {
            get { return getAttrVal<string>("Dept_name",null); }
            set { setAttrVal<string>("Dept_name", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Assess_name {
            get { return getAttrVal<string>("Assess_name",null); }
            set { setAttrVal<string>("Assess_name", value); }
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
            return "CI_MR_NU_ADH_BA";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_ba";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.barthelassess.d.BarthelAssessDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ba", "Ks", "Ch", "Xm", "Zyh", "Eu_js", "Eu_xz", "Eu_xs", "Eu_cy", "Eu_kzdb", "Eu_kzxb", "Eu_rc", "Eu_cyyd", "Eu_pdxz", "Eu_sxlt", "Zf", "Pgrqsj", "Pgr", "Id_grp", "Id_org", "Id_dept", "Id_pat", "Id_assess", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Dept_name", "Pat_name", "Assess_name"};
        }
        
    }
}

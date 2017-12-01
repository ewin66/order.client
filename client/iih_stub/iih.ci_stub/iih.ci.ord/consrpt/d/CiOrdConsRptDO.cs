
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.consrpt.d
{
    /// <summary>
    /// CiOrdConsRptDO 的摘要说明。
    /// </summary>
    public class CiOrdConsRptDO : BaseDO {

		public const string TABLE_NAME = "ci_rpt_cons";
		public const string TABLE_ALIAS_NAME = "a0";

        public CiOrdConsRptDO() {
        }
		public string Id_rptcons {
            get { return getAttrVal<string>("Id_rptcons",null); }
            set { setAttrVal<string>("Id_rptcons", value); }
        }
		public string Id_apcons {
            get { return getAttrVal<string>("Id_apcons",null); }
            set { setAttrVal<string>("Id_apcons", value); }
        }
		public DateTime? Dt_actual {
            get { return getAttrVal<FDateTime>("Dt_actual",null); }
            set { setAttrVal<FDateTime>("Dt_actual", value); }
        }
		public string Advice {
            get { return getAttrVal<string>("Advice",null); }
            set { setAttrVal<string>("Advice", value); }
        }
		public string Id_emp_rpt {
            get { return getAttrVal<string>("Id_emp_rpt",null); }
            set { setAttrVal<string>("Id_emp_rpt", value); }
        }
		public string Id_dep_rpt {
            get { return getAttrVal<string>("Id_dep_rpt",null); }
            set { setAttrVal<string>("Id_dep_rpt", value); }
        }
		public DateTime? Dt_rpt {
            get { return getAttrVal<FDateTime>("Dt_rpt",null); }
            set { setAttrVal<FDateTime>("Dt_rpt", value); }
        }
		public string Id_emp_host {
            get { return getAttrVal<string>("Id_emp_host",null); }
            set { setAttrVal<string>("Id_emp_host", value); }
        }
		public string Id_place_actual {
            get { return getAttrVal<string>("Id_place_actual",null); }
            set { setAttrVal<string>("Id_place_actual", value); }
        }
		public string Sd_su_rpt {
            get { return getAttrVal<string>("Sd_su_rpt",null); }
            set { setAttrVal<string>("Sd_su_rpt", value); }
        }
		public string Id_su_rpt {
            get { return getAttrVal<string>("Id_su_rpt",null); }
            set { setAttrVal<string>("Id_su_rpt", value); }
        }
		public string Name_place {
            get { return getAttrVal<string>("Name_place",null); }
            set { setAttrVal<string>("Name_place", value); }
        }
		public string Name_emp_rpt {
            get { return getAttrVal<string>("Name_emp_rpt",null); }
            set { setAttrVal<string>("Name_emp_rpt", value); }
        }
		public string Name_dep_rpt {
            get { return getAttrVal<string>("Name_dep_rpt",null); }
            set { setAttrVal<string>("Name_dep_rpt", value); }
        }
		public string Name_emp_host {
            get { return getAttrVal<string>("Name_emp_host",null); }
            set { setAttrVal<string>("Name_emp_host", value); }
        }
		public string Name_place_actual {
            get { return getAttrVal<string>("Name_place_actual",null); }
            set { setAttrVal<string>("Name_place_actual", value); }
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
            return "ci_rpt_cons";
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
            return "Id_rptcons";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.consrpt.d.CiOrdConsRptDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptcons", "Id_apcons", "Dt_actual", "Advice", "Id_emp_rpt", "Id_dep_rpt", "Dt_rpt", "Id_emp_host", "Id_place_actual", "Sd_su_rpt", "Id_su_rpt", "Name_place", "Name_emp_rpt", "Name_dep_rpt", "Name_emp_host", "Name_place_actual"};
        }
        
    }
}

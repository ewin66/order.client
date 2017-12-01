
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrConsApAuditDO 的摘要说明。
    /// </summary>
    public class OrConsApAuditDO : BaseDO {

        public OrConsApAuditDO() {
        }
		public string Id_reviewcons {
            get { return getAttrVal<string>("Id_reviewcons",null); }
            set { setAttrVal<string>("Id_reviewcons", value); }
        }
		public string Id_apcons {
            get { return getAttrVal<string>("Id_apcons",null); }
            set { setAttrVal<string>("Id_apcons", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }
		public DateTime? Dt_review {
            get { return getAttrVal<FDateTime>("Dt_review",null); }
            set { setAttrVal<FDateTime>("Dt_review", value); }
        }
		public string Des_review {
            get { return getAttrVal<string>("Des_review",null); }
            set { setAttrVal<string>("Des_review", value); }
        }
		public bool? Fg_audit {
            get { return getAttrVal<FBoolean>("Fg_audit",null); }
            set { setAttrVal<FBoolean>("Fg_audit", value); }
        }
		public string Result {
            get { return getAttrVal<string>("Result",null); }
            set { setAttrVal<string>("Result", value); }
        }
		public string Name_emp {
            get { return getAttrVal<string>("Name_emp",null); }
            set { setAttrVal<string>("Name_emp", value); }
        }
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
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
            return "ci_review_cons";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_reviewcons";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrConsApAuditDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_reviewcons", "Id_apcons", "Id_emp", "Id_dep", "Dt_review", "Des_review", "Fg_audit", "Result", "Name_emp", "Name_dep"};
        }
        
    }
}


using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// RptOpEmpDO 的摘要说明。
    /// </summary>
    public class RptOpEmpDO : BaseDO {

        public RptOpEmpDO() {
        }
		public string Id_rptsugemp {
            get { return getAttrVal<string>("Id_rptsugemp",null); }
            set { setAttrVal<string>("Id_rptsugemp", value); }
        }
		public string Id_rptsug {
            get { return getAttrVal<string>("Id_rptsug",null); }
            set { setAttrVal<string>("Id_rptsug", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public string Id_role {
            get { return getAttrVal<string>("Id_role",null); }
            set { setAttrVal<string>("Id_role", value); }
        }
		public string Sd_role {
            get { return getAttrVal<string>("Sd_role",null); }
            set { setAttrVal<string>("Sd_role", value); }
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
            return "ci_rpt_sug_emp";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rptsugemp";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.RptOpEmpDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptsugemp", "Id_rptsug", "Id_emp", "Id_role", "Sd_role"};
        }
        
    }
}

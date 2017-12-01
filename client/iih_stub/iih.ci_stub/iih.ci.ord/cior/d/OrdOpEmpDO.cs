
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdOpEmpDO 的摘要说明。
    /// </summary>
    public class OrdOpEmpDO : BaseDO {

        public OrdOpEmpDO() {
        }
		public string Id_apopemp {
            get { return getAttrVal<string>("Id_apopemp",null); }
            set { setAttrVal<string>("Id_apopemp", value); }
        }
		public string Id_apop {
            get { return getAttrVal<string>("Id_apop",null); }
            set { setAttrVal<string>("Id_apop", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public string Sd_role {
            get { return getAttrVal<string>("Sd_role",null); }
            set { setAttrVal<string>("Sd_role", value); }
        }
		public string Id_role {
            get { return getAttrVal<string>("Id_role",null); }
            set { setAttrVal<string>("Id_role", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Name_emp {
            get { return getAttrVal<string>("Name_emp",null); }
            set { setAttrVal<string>("Name_emp", value); }
        }
		public string Name_role {
            get { return getAttrVal<string>("Name_role",null); }
            set { setAttrVal<string>("Name_role", value); }
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
            return "ci_ap_sug_emp";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_apopemp";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdOpEmpDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_apopemp", "Id_apop", "Id_emp", "Sd_role", "Id_role", "Sortno", "Name_emp", "Name_role"};
        }
        
    }
}

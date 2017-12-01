
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.app.d
{
    /// <summary>
    /// CiAppTreatExecOrDO 的摘要说明。
    /// </summary>
    public class CiAppTreatExecOrDO : BaseDO {

		public const string TABLE_NAME = "ci_app_treatexec_or";
		public const string TABLE_ALIAS_NAME = "a1";

        public CiAppTreatExecOrDO() {
        }
		public string Id_ciapptreatexecor {
            get { return getAttrVal<string>("Id_ciapptreatexecor",null); }
            set { setAttrVal<string>("Id_ciapptreatexecor", value); }
        }
		public string Id_ciapptreatexec {
            get { return getAttrVal<string>("Id_ciapptreatexec",null); }
            set { setAttrVal<string>("Id_ciapptreatexec", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public FDouble Amt_or {
            get { return getAttrVal<FDouble>("Amt_or",null); }
            set { setAttrVal<FDouble>("Amt_or", value); }
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
            return "ci_app_treatexec_or";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a1";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_ciapptreatexecor";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.app.d.CiAppTreatExecOrDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciapptreatexecor", "Id_ciapptreatexec", "Id_or", "Amt_or"};
        }
        
    }
}

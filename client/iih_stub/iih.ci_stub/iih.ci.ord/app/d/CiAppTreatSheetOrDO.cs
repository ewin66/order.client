
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.app.d
{
    /// <summary>
    /// CiAppTreatSheetOrDO 的摘要说明。
    /// </summary>
    public class CiAppTreatSheetOrDO : BaseDO {

		public const string TABLE_NAME = "ci_app_treat_or";
		public const string TABLE_ALIAS_NAME = "a1";

        public CiAppTreatSheetOrDO() {
        }
		public string Id_ciapptreatsheetor {
            get { return getAttrVal<string>("Id_ciapptreatsheetor",null); }
            set { setAttrVal<string>("Id_ciapptreatsheetor", value); }
        }
		public string Id_ciapptreatsheet {
            get { return getAttrVal<string>("Id_ciapptreatsheet",null); }
            set { setAttrVal<string>("Id_ciapptreatsheet", value); }
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
            return "ci_app_treat_or";
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
            return "Id_ciapptreatsheetor";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.app.d.CiAppTreatSheetOrDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciapptreatsheetor", "Id_ciapptreatsheet", "Id_or", "Amt_or"};
        }
        
    }
}


using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.app.d
{
    /// <summary>
    /// CiAppLisSheetOrDO 的摘要说明。
    /// </summary>
    public class CiAppLisSheetOrDO : BaseDO {

		public const string TABLE_NAME = "ci_app_lis_or";
		public const string TABLE_ALIAS_NAME = "a1";

        public CiAppLisSheetOrDO() {
        }
		public string Id_ciapplissheetor {
            get { return getAttrVal<string>("Id_ciapplissheetor",null); }
            set { setAttrVal<string>("Id_ciapplissheetor", value); }
        }
		public string Id_ciapplissheet {
            get { return getAttrVal<string>("Id_ciapplissheet",null); }
            set { setAttrVal<string>("Id_ciapplissheet", value); }
        }
		public string Id_orlab {
            get { return getAttrVal<string>("Id_orlab",null); }
            set { setAttrVal<string>("Id_orlab", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public FDouble Amt_app {
            get { return getAttrVal<FDouble>("Amt_app",null); }
            set { setAttrVal<FDouble>("Amt_app", value); }
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
            return "ci_app_lis_or";
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
            return "Id_ciapplissheetor";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.app.d.CiAppLisSheetOrDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciapplissheetor", "Id_ciapplissheet", "Id_orlab", "Id_or", "Amt_app"};
        }
        
    }
}


using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciprn.d
{
    /// <summary>
    /// CiPrnItmDO 的摘要说明。
    /// </summary>
    public class CiPrnItmDO : BaseDO {

		public const string TABLE_NAME = "ci_prn_item";
		public const string TABLE_ALIAS_NAME = "a1";

        public CiPrnItmDO() {
        }
		public string Id_ciprnitm {
            get { return getAttrVal<string>("Id_ciprnitm",null); }
            set { setAttrVal<string>("Id_ciprnitm", value); }
        }
		public string Id_ciprn {
            get { return getAttrVal<string>("Id_ciprn",null); }
            set { setAttrVal<string>("Id_ciprn", value); }
        }
		public string Id_biz {
            get { return getAttrVal<string>("Id_biz",null); }
            set { setAttrVal<string>("Id_biz", value); }
        }
		public FDouble Amt_biz {
            get { return getAttrVal<FDouble>("Amt_biz",null); }
            set { setAttrVal<FDouble>("Amt_biz", value); }
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
            return "ci_prn_item";
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
            return "Id_ciprnitm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciprn.d.CiPrnItmDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciprnitm", "Id_ciprn", "Id_biz", "Amt_biz"};
        }
        
    }
}

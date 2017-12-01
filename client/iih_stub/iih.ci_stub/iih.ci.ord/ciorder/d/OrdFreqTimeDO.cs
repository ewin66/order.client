
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.d
{
    /// <summary>
    /// OrdFreqTimeDO 的摘要说明。
    /// </summary>
    public class OrdFreqTimeDO : BaseDO {

		public const string TABLE_NAME = "ci_or_freq";
		public const string TABLE_ALIAS_NAME = "a2";

        public OrdFreqTimeDO() {
        }
		public string Id_orfreqtime {
            get { return getAttrVal<string>("Id_orfreqtime",null); }
            set { setAttrVal<string>("Id_orfreqtime", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public DateTime? Wdno {
            get { return getAttrVal<FDate>("Wdno",null); }
            set { setAttrVal<FDate>("Wdno", value); }
        }
		public DateTime? Time_mp {
            get { return getAttrVal<FTime>("Time_mp",null); }
            set { setAttrVal<FTime>("Time_mp", value); }
        }
		public string Des_mp {
            get { return getAttrVal<string>("Des_mp",null); }
            set { setAttrVal<string>("Des_mp", value); }
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
            return "ci_or_freq";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a2";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_orfreqtime";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciorder.d.OrdFreqTimeDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orfreqtime", "Id_or", "Sortno", "Wdno", "Time_mp", "Des_mp"};
        }
        
    }
}

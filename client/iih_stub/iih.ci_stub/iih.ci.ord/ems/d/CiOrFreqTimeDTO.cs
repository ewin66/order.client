using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ems.d
{
    /// <summary>
    /// CiOrFreqTimeDTO 的摘要说明。
    /// </summary>
    public class CiOrFreqTimeDTO : BaseDTO {

        public CiOrFreqTimeDTO() {
 
        }

        /// <summary>
        /// 医嘱执行时刻主键标识
        /// </summary>
		public string Id_orfreqtime {
            get { return getAttrVal<string>("Id_orfreqtime",null); }
            set { setAttrVal<string>("Id_orfreqtime", value); }
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 计划日期
        /// </summary>
		public DateTime? Wdno {
            get { return getAttrVal<FDate>("Wdno",null); }
            set { setAttrVal<FDate>("Wdno", value); }
        }

        /// <summary>
        /// 执行时刻
        /// </summary>
		public DateTime? Time_mp {
            get { return getAttrVal<FTime>("Time_mp",null); }
            set { setAttrVal<FTime>("Time_mp", value); }
        }

        /// <summary>
        /// 执行时刻描述
        /// </summary>
		public string Des_mp {
            get { return getAttrVal<string>("Des_mp",null); }
            set { setAttrVal<string>("Des_mp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_orfreqtime", "Id_or", "Sortno", "Wdno", "Time_mp", "Des_mp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ems.d.CiOrFreqTimeDTO";
        }
    }
}

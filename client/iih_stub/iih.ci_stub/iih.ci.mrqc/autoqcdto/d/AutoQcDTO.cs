using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.autoqcdto.d
{
    /// <summary>
    /// AutoQcDTO 的摘要说明。
    /// </summary>
    public class AutoQcDTO : BaseDTO {

        public AutoQcDTO() {
 
        }

        /// <summary>
        /// 入院时间
        /// </summary>
		public DateTime? Dt_acpt {
            get { return getAttrVal<FDateTime>("Dt_acpt",null); }
            set { setAttrVal<FDateTime>("Dt_acpt", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Dt_acpt"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.autoqcdto.d.AutoQcDTO";
        }
    }
}

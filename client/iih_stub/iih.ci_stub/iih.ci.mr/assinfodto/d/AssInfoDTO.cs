using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.assinfodto.d
{
    /// <summary>
    /// AssInfoDTO 的摘要说明。
    /// </summary>
    public class AssInfoDTO : BaseDTO {

        public AssInfoDTO() {
 
        }

        /// <summary>
        /// 助手编码
        /// </summary>
		public string Code_ass {
            get { return getAttrVal<string>("Code_ass",null); }
            set { setAttrVal<string>("Code_ass", value); }
        }

        /// <summary>
        /// 助手名称
        /// </summary>
		public string Ass {
            get { return getAttrVal<string>("Ass",null); }
            set { setAttrVal<string>("Ass", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code_ass", "Ass"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.assinfodto.d.AssInfoDTO";
        }
    }
}

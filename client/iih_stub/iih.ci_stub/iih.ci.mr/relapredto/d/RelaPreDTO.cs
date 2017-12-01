using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.relapredto.d
{
    /// <summary>
    /// RelaPreDTO 的摘要说明。
    /// </summary>
    public class RelaPreDTO : BaseDTO {

        public RelaPreDTO() {
 
        }

        /// <summary>
        /// 医嘱号
        /// </summary>
		public string Id_pre {
            get { return getAttrVal<string>("Id_pre",null); }
            set { setAttrVal<string>("Id_pre", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_pre"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.relapredto.d.RelaPreDTO";
        }
    }
}

using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.secinfodto.d
{
    /// <summary>
    /// SecInfoDTO 的摘要说明。
    /// </summary>
    public class SecInfoDTO : BaseDTO {

        public SecInfoDTO() {
 
        }

        /// <summary>
        /// 章节编码
        /// </summary>
		public string Code_sec {
            get { return getAttrVal<string>("Code_sec",null); }
            set { setAttrVal<string>("Code_sec", value); }
        }

        /// <summary>
        /// 章节名称
        /// </summary>
		public string Title {
            get { return getAttrVal<string>("Title",null); }
            set { setAttrVal<string>("Title", value); }
        }

        /// <summary>
        /// 章节信息
        /// </summary>
		public string Sec {
            get { return getAttrVal<string>("Sec",null); }
            set { setAttrVal<string>("Sec", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code_sec", "Title", "Sec"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.secinfodto.d.SecInfoDTO";
        }
    }
}

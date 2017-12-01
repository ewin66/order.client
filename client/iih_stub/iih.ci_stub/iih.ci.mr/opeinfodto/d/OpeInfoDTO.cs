using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.opeinfodto.d
{
    /// <summary>
    /// OpeInfoDTO 的摘要说明。
    /// </summary>
    public class OpeInfoDTO : BaseDTO {

        public OpeInfoDTO() {
 
        }

        /// <summary>
        /// 术者编码
        /// </summary>
		public string Code_ope {
            get { return getAttrVal<string>("Code_ope",null); }
            set { setAttrVal<string>("Code_ope", value); }
        }

        /// <summary>
        /// 术者名称
        /// </summary>
		public string Ope {
            get { return getAttrVal<string>("Ope",null); }
            set { setAttrVal<string>("Ope", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code_ope", "Ope"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.opeinfodto.d.OpeInfoDTO";
        }
    }
}

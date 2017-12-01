using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.nurinfodto.d
{
    /// <summary>
    /// NurInfoDTO 的摘要说明。
    /// </summary>
    public class NurInfoDTO : BaseDTO {

        public NurInfoDTO() {
 
        }

        /// <summary>
        /// 护士编码
        /// </summary>
		public string Code_nur {
            get { return getAttrVal<string>("Code_nur",null); }
            set { setAttrVal<string>("Code_nur", value); }
        }

        /// <summary>
        /// 护士名称
        /// </summary>
		public string Nur {
            get { return getAttrVal<string>("Nur",null); }
            set { setAttrVal<string>("Nur", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code_nur", "Nur"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nurinfodto.d.NurInfoDTO";
        }
    }
}

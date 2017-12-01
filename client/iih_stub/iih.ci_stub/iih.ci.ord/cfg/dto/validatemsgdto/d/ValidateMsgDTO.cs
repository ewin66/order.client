using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cfg.dto.validatemsgdto.d
{
    /// <summary>
    /// ValidateMsgDTO 的摘要说明。
    /// </summary>
    public class ValidateMsgDTO : BaseDTO {

        public ValidateMsgDTO() {
 
        }

        /// <summary>
        /// 消息编码
        /// </summary>
		public string Msg_code {
            get { return getAttrVal<string>("Msg_code",null); }
            set { setAttrVal<string>("Msg_code", value); }
        }

        /// <summary>
        /// 消息类型
        /// </summary>
		public string Msg_type {
            get { return getAttrVal<string>("Msg_type",null); }
            set { setAttrVal<string>("Msg_type", value); }
        }

        /// <summary>
        /// 功能编码
        /// </summary>
		public string Module_code {
            get { return getAttrVal<string>("Module_code",null); }
            set { setAttrVal<string>("Module_code", value); }
        }

        /// <summary>
        /// 功能模块名称
        /// </summary>
		public string Module_name {
            get { return getAttrVal<string>("Module_name",null); }
            set { setAttrVal<string>("Module_name", value); }
        }

        /// <summary>
        /// 消息内容
        /// </summary>
		public string Content {
            get { return getAttrVal<string>("Content",null); }
            set { setAttrVal<string>("Content", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Msg_code", "Msg_type", "Module_code", "Module_name", "Content"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cfg.dto.validatemsgdto.d.ValidateMsgDTO";
        }
    }
}

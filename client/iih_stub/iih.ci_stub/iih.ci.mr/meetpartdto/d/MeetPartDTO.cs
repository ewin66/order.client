using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.meetpartdto.d
{
    /// <summary>
    /// MeetPartDTO 的摘要说明。
    /// </summary>
    public class MeetPartDTO : BaseDTO {

        public MeetPartDTO() {
 
        }

        /// <summary>
        /// 会议参加者编码
        /// </summary>
		public string Code_mepa {
            get { return getAttrVal<string>("Code_mepa",null); }
            set { setAttrVal<string>("Code_mepa", value); }
        }

        /// <summary>
        /// 会议参加者名称
        /// </summary>
		public string Mepa {
            get { return getAttrVal<string>("Mepa",null); }
            set { setAttrVal<string>("Mepa", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code_mepa", "Mepa"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.meetpartdto.d.MeetPartDTO";
        }
    }
}

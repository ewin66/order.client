using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.meethostdto.d
{
    /// <summary>
    /// MeetHostDTO 的摘要说明。
    /// </summary>
    public class MeetHostDTO : BaseDTO {

        public MeetHostDTO() {
 
        }

        /// <summary>
        /// 会议主持者编码
        /// </summary>
		public string Code_meho {
            get { return getAttrVal<string>("Code_meho",null); }
            set { setAttrVal<string>("Code_meho", value); }
        }

        /// <summary>
        /// 会议主持者名称
        /// </summary>
		public string Meho {
            get { return getAttrVal<string>("Meho",null); }
            set { setAttrVal<string>("Meho", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code_meho", "Meho"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.meethostdto.d.MeetHostDTO";
        }
    }
}

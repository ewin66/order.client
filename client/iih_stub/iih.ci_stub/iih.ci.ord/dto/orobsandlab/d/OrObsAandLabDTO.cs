using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.orobsandlab.d
{
    /// <summary>
    /// OrObsAandLabDTO 的摘要说明。
    /// </summary>
    public class OrObsAandLabDTO : BaseDTO {

        public OrObsAandLabDTO() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 父id
        /// </summary>
		public string Parent {
            get { return getAttrVal<string>("Parent",null); }
            set { setAttrVal<string>("Parent", value); }
        }

        /// <summary>
        /// 类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 日期
        /// </summary>
		public DateTime? Dtor {
            get { return getAttrVal<FDateTime>("Dtor",null); }
            set { setAttrVal<FDateTime>("Dtor", value); }
        }

        /// <summary>
        /// 医生名称
        /// </summary>
		public string Signname {
            get { return getAttrVal<string>("Signname",null); }
            set { setAttrVal<string>("Signname", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id", "Name", "Parent", "Sd_srvtp", "Dtor", "Signname"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.orobsandlab.d.OrObsAandLabDTO";
        }
    }
}

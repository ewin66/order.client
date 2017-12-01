using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// SkinTestParamDTO 的摘要说明。
    /// </summary>
    public class SkinTestParamDTO : BaseDTO {

        public SkinTestParamDTO() {
 
        }

        /// <summary>
        /// 所属组织
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Id_pi {
            get { return getAttrVal<string>("Id_pi",null); }
            set { setAttrVal<string>("Id_pi", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }

        /// <summary>
        /// 用药服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 用药
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 皮试服务
        /// </summary>
		public string Id_skinsrv {
            get { return getAttrVal<string>("Id_skinsrv",null); }
            set { setAttrVal<string>("Id_skinsrv", value); }
        }

        /// <summary>
        /// 皮试药品
        /// </summary>
		public string Id_skinmm {
            get { return getAttrVal<string>("Id_skinmm",null); }
            set { setAttrVal<string>("Id_skinmm", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_org", "Id_pi", "Dt_birth", "Id_srv", "Id_mm", "Id_skinsrv", "Id_skinmm"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.SkinTestParamDTO";
        }
    }
}

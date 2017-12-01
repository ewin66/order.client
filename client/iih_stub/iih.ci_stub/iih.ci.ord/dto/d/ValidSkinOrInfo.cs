using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// ValidSkinOrInfo 的摘要说明。
    /// </summary>
    public class ValidSkinOrInfo : BaseDTO {

        public ValidSkinOrInfo() {
 
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 皮试结果编码
        /// </summary>
		public string Sd_rst_skintest {
            get { return getAttrVal<string>("Sd_rst_skintest",null); }
            set { setAttrVal<string>("Sd_rst_skintest", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_srv", "Sd_rst_skintest"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.ValidSkinOrInfo";
        }
    }
}

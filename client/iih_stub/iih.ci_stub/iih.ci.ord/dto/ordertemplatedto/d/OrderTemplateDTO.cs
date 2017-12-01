using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordertemplatedto.d
{
    /// <summary>
    /// OrderTemplateDTO 的摘要说明。
    /// </summary>
    public class OrderTemplateDTO : BaseDTO {

        public OrderTemplateDTO() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_template {
            get { return getAttrVal<string>("Id_template",null); }
            set { setAttrVal<string>("Id_template", value); }
        }

        /// <summary>
        /// 医嘱模板
        /// </summary>
		public FMap Srvortplitemaggdo {
            get { return getAttrVal<FMap>("Srvortplitemaggdo",null); }
            set { setAttrVal<FMap>("Srvortplitemaggdo", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public FMap Freqdefdo {
            get { return getAttrVal<FMap>("Freqdefdo",null); }
            set { setAttrVal<FMap>("Freqdefdo", value); }
        }

        /// <summary>
        /// 剂量单位
        /// </summary>
		public FMap Measdocdo {
            get { return getAttrVal<FMap>("Measdocdo",null); }
            set { setAttrVal<FMap>("Measdocdo", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_template", "Srvortplitemaggdo", "Freqdefdo", "Measdocdo"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordertemplatedto.d.OrderTemplateDTO";
        }
    }
}

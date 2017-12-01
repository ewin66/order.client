using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordertpltree.d
{
    /// <summary>
    /// OderTplTreeDto 的摘要说明。
    /// </summary>
    public class OrderTplTreeDto : BaseDTO {

        public OrderTplTreeDto() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 父编码
        /// </summary>
		public string Parent {
            get { return getAttrVal<string>("Parent",null); }
            set { setAttrVal<string>("Parent", value); }
        }

        /// <summary>
        /// 名称
        /// </summary>
		public string Nm {
            get { return getAttrVal<string>("Nm",null); }
            set { setAttrVal<string>("Nm", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id", "Parent", "Nm"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.odertpltree.d.OderTplTreeDto";
        }
    }
}

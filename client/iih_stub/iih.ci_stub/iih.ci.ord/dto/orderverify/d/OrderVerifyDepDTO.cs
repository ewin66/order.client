using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.orderverify.d
{
    /// <summary>
    /// OrderVerifyDepDTO 的摘要说明。
    /// </summary>
    public class OrderVerifyDepDTO : BaseDTO {

        public OrderVerifyDepDTO() {
 
        }

        /// <summary>
        /// 病区id
        /// </summary>
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }

        /// <summary>
        /// 病区名称
        /// </summary>
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
        }

        /// <summary>
        /// 医嘱数量
        /// </summary>
		public int? Order_num {
            get { return getAttrVal<int?>("Order_num",null); }
            set { setAttrVal<int?>("Order_num", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_dep", "Name_dep", "Order_num"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.orderverify.d.OrderVerifyDepDTO";
        }
    }
}

using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.orderverify.d
{
    /// <summary>
    /// OrderVerifyCondDTO 的摘要说明。
    /// </summary>
    public class OrderVerifyCondDTO : BaseDTO {

        public OrderVerifyCondDTO() {
 
        }

        /// <summary>
        /// 患者条件类型
        /// </summary>
		public string Pat_cond_type {
            get { return getAttrVal<string>("Pat_cond_type",null); }
            set { setAttrVal<string>("Pat_cond_type", value); }
        }

        /// <summary>
        /// 患者条件值
        /// </summary>
		public string Pat_cond_value {
            get { return getAttrVal<string>("Pat_cond_value",null); }
            set { setAttrVal<string>("Pat_cond_value", value); }
        }

        /// <summary>
        /// 审核状态
        /// </summary>
		public string Verify_state {
            get { return getAttrVal<string>("Verify_state",null); }
            set { setAttrVal<string>("Verify_state", value); }
        }

        /// <summary>
        /// 开始时间
        /// </summary>
		public DateTime? Dt_begin {
            get { return getAttrVal<FDate>("Dt_begin",null); }
            set { setAttrVal<FDate>("Dt_begin", value); }
        }

        /// <summary>
        /// 门诊/住院
        /// </summary>
		public bool? Fg_op {
            get { return getAttrVal<FBoolean>("Fg_op",null); }
            set { setAttrVal<FBoolean>("Fg_op", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Pat_cond_type", "Pat_cond_value", "Verify_state", "Dt_begin", "Fg_op"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.orderverify.d.OrderVerifyCondDTO";
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ciorder.d
{
   public enum FeeReverseType {
        /// <summary>
        /// 记账后
        /// </summary>
        [Description("【记账状态】=已记账，冲账类型 = 0")]
        NOBLCANCEL =0,
	/// <summary>
	/// 销账
	/// </summary>
    [Description("销账")]
    BLCGCANCEL=1,
	/// <summary>
	/// 结算后冲账
	/// </summary>
    [Description("结算后冲账")]
    BLSTREVERSE=2,
   }
}

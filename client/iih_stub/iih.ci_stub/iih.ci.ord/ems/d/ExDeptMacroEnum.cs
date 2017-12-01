using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ems.d
{
   public enum ExDeptMacroEnum {
	/// <summary>
	/// 【开单科室】
	/// </summary>
    [Description("【开单科室】")]
    ORDERDEP=1,
	/// <summary>
	/// 【就诊科室】
	/// </summary>
    [Description("【就诊科室】")]
    ENTDEP=2,
	/// <summary>
	/// 【临床跟随】
	/// </summary>
    [Description("【临床跟随】")]
    FOLLOWOR=3,
	/// <summary>
	/// 【就诊病区】
	/// </summary>
    [Description("【就诊病区】")]
    ENTWARD=11,
	/// <summary>
	/// 【套跟随】
	/// </summary>
    [Description("【套跟随】")]
    FOLLOWSET=999,
   }
}

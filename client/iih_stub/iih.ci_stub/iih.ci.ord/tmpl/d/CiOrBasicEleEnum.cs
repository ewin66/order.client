using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.tmpl.d
{
   public enum CiOrBasicEleEnum {
	/// <summary>
	/// 频次
	/// </summary>
    [Description("频次")]
    FREQDEF=1,
	/// <summary>
	/// 用法
	/// </summary>
    [Description("用法")]
    ROUTE=2,
	/// <summary>
	/// 要求
	/// </summary>
    [Description("要求")]
    ROUTEDES=3,
	/// <summary>
	/// 煎法
	/// </summary>
    [Description("煎法")]
    BOIL=4,
	/// <summary>
	/// 煎法要求
	/// </summary>
    [Description("煎法要求")]
    BOILDES=5,
   }
}

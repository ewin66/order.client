using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ciorder.d
{
   public enum HpIndicJudgeEnum {
	/// <summary>
	/// 不需要判断
	/// </summary>
    [Description("不需要判断")]
    NONEEDJUDGE=0,
	/// <summary>
	/// 待判断
	/// </summary>
    [Description("待判断")]
    WAITINGJUDGE=1,
	/// <summary>
	/// 已判断
	/// </summary>
    [Description("已判断")]
    JUDGED=2,
    /// <summary>
    /// 自费
    /// </summary>
    [Description("自费")]
    SELFPAY = 9,
   }
}

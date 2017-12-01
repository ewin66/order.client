using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.cior.d
{
   public enum LastOfMpRstTp {
	/// <summary>
	/// 最后一顿
	/// </summary>
    [Description("最后一顿")]
    THELASTOFMP=1,
	/// <summary>
	/// 非最后一顿
	/// </summary>
    [Description("非最后一顿")]
    NOTTHELASTOFMP=2,
	/// <summary>
	/// 尚未计算
	/// </summary>
    [Description("尚未计算")]
    UNKNOWN=3,
   }
}

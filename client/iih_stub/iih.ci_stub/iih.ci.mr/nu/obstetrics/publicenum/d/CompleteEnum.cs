using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum CompleteEnum {
	/// <summary>
	/// 很好
	/// </summary>
    [Description("很好")]
    VERYGOOD=0,
	/// <summary>
	/// 完成
	/// </summary>
    [Description("完成")]
    COMPLETE=1,
	/// <summary>
	/// 未完成
	/// </summary>
    [Description("未完成")]
    NOTCOMPLETE=2,
   }
}

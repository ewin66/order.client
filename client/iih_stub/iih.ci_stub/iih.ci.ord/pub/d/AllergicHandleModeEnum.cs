using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.pub.d
{
   public enum AllergicHandleModeEnum {
	/// <summary>
	/// 药品禁用
	/// </summary>
    [Description("药品禁用")]
    FORBIDDEN=0,
	/// <summary>
	/// 再次皮试
	/// </summary>
    [Description("再次皮试")]
    RESKINTEST=1,
	/// <summary>
	/// 强制使用
	/// </summary>
    [Description("强制使用")]
    FORCEDUSE=2,
   }
}

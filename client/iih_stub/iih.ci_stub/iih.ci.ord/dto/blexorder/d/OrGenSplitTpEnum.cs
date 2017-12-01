using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.dto.blexorder.d
{
   public enum OrGenSplitTpEnum {
	/// <summary>
	/// 拆分医嘱
	/// </summary>
    [Description("拆分医嘱")]
    SPLITBYOR=0,
	/// <summary>
	/// 拆分服务物品 
	/// </summary>
    [Description("拆分服务物品 ")]
    SPLITBYSRVMM=1,
	/// <summary>
	/// 拆分费用服务
	/// </summary>
    [Description("拆分费用服务")]
    SPLITBYFEESRV=2,
   }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.dto.blexorder.d
{
   public enum PresOutPTpEnum {
	/// <summary>
	/// 出院未带药
	/// </summary>
    [Description("出院未带药")]
    UNPRESOUTP=0,
	/// <summary>
	/// 出院带药
	/// </summary>
    [Description("出院带药")]
    PRESOUTP=1,
	/// <summary>
	/// 全部
	/// </summary>
    [Description("全部")]
    ALL=2,
   }
}

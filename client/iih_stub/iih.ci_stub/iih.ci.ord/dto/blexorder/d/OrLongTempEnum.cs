using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.dto.blexorder.d
{
   public enum OrLongTempEnum {
	/// <summary>
	/// 长期医嘱
	/// </summary>
    [Description("长期医嘱")]
    LONGOR=1,
	/// <summary>
	/// 临时医嘱
	/// </summary>
    [Description("临时医嘱")]
    TEMPOR=0,
	/// <summary>
	/// 全部
	/// </summary>
    [Description("全部")]
    ALL=2,
   }
}

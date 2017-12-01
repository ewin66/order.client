using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.cfg.dto.msg.d
{
   public enum MsgType {
	/// <summary>
	/// 消息
	/// </summary>
    [Description("消息")]
    INFO=0,
	/// <summary>
	/// 错误
	/// </summary>
    [Description("错误")]
    ERROR=1,
	/// <summary>
	/// 询问确认
	/// </summary>
    [Description("询问确认")]
    CONFIRM=2,
   }
}

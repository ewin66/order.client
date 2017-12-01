using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.pub.d
{
   public enum NDaysTimeCalValidMode {
	/// <summary>
	/// 24小时有效模式
	/// </summary>
    [Description("24小时有效模式")]
    VALIDWITHIN24HOURMODE=0,
	/// <summary>
	/// 日开始时间模式
	/// </summary>
    [Description("日开始时间模式")]
    VALIDFROMDATESTARTMODE=1,
   }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum WelcomeEnum {
	/// <summary>
	/// 欢迎
	/// </summary>
    [Description("欢迎")]
    WELCOME=0,
	/// <summary>
	/// 不欢迎
	/// </summary>
    [Description("不欢迎")]
    NOTWELCOME=1,
   }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum GoodEnum {
	/// <summary>
	/// 好
	/// </summary>
    [Description("好")]
    GOOD=0,
	/// <summary>
	/// 不良
	/// </summary>
    [Description("不良")]
    NOTGOOD=1,
   }
}

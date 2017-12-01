using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum EnumExist {
	/// <summary>
	/// 有
	/// </summary>
    [Description("有")]
    EXIST=1,
	/// <summary>
	/// 无
	/// </summary>
    [Description("无")]
    NOEXIST=0,
   }
}

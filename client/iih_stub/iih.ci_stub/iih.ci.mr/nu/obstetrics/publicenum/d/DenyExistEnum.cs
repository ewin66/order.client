using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum DenyExistEnum {
	/// <summary>
	/// 否认
	/// </summary>
    [Description("否认")]
    DENY=0,
	/// <summary>
	/// 有
	/// </summary>
    [Description("有")]
    EXIST=1,
   }
}

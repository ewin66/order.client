using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum HBsAgEnum {
	/// <summary>
	/// 检测
	/// </summary>
    [Description("检测")]
    DETECTION=0,
	/// <summary>
	/// 阳性
	/// </summary>
    [Description("阳性")]
    POSITIVE=1,
   }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum AbnormalEnum {
	/// <summary>
	/// 正常
	/// </summary>
    [Description("正常")]
    NORMAL=0,
	/// <summary>
	/// 异常
	/// </summary>
    [Description("异常")]
    ABNORMAL=1,
   }
}

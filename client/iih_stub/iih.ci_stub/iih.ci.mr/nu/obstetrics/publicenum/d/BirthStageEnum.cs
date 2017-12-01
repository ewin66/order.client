using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum BirthStageEnum {
	/// <summary>
	/// 孕期
	/// </summary>
    [Description("孕期")]
    PREGNANCY=0,
	/// <summary>
	/// 产时
	/// </summary>
    [Description("产时")]
    INTRAPARTUM=1,
	/// <summary>
	/// 无
	/// </summary>
    [Description("无")]
    NONE=2,
   }
}

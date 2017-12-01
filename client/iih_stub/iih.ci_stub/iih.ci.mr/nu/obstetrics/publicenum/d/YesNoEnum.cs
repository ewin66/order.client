using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum YesNoEnum {
	/// <summary>
	/// 是
	/// </summary>
    [Description("是")]
    YES=1,
	/// <summary>
	/// 否
	/// </summary>
    [Description("否")]
    NO=0,
   }
}

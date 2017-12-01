using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum ParentsEnum {
	/// <summary>
	/// 父
	/// </summary>
    [Description("父")]
    FATHER=0,
	/// <summary>
	/// 母
	/// </summary>
    [Description("母")]
    MOTHER=1,
   }
}

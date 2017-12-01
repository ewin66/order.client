using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.nu.obstetrics.publicenum.d
{
   public enum SyphilisEnum {
	/// <summary>
	/// 检测
	/// </summary>
    [Description("检测")]
    DETECTION=0,
	/// <summary>
	/// 确诊
	/// </summary>
    [Description("确诊")]
    CONFIRMED=1,
   }
}

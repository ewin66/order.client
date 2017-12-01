using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.cfg.cirulecfg.d
{
   public enum RuleRelCa {
	/// <summary>
	/// 医疗单
	/// </summary>
    [Description("医疗单")]
    ID_SRVOF=0,
	/// <summary>
	/// 服务类型
	/// </summary>
    [Description("服务类型")]
    SD_SRVTP=1,
	/// <summary>
	/// 服务
	/// </summary>
    [Description("服务")]
    ID_SRV=2,
   }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.cfg.cirulecfg.d
{
   public enum RuleCategory {
	/// <summary>
	/// 校验规则
	/// </summary>
    [Description("校验规则")]
    VALIDATOR=1,
	/// <summary>
	/// 业务逻辑规则
	/// </summary>
    [Description("业务逻辑规则")]
    BIZ_LOGIC=2,
   }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.dto.orderverify.d
{
   public enum OrderVerifyStateEnum {
	/// <summary>
	/// 未审核
	/// </summary>
    [Description("未审核")]
    NOTVERIFY=0,
	/// <summary>
	/// 审核通过
	/// </summary>
    [Description("审核通过")]
    PASS=1,
	/// <summary>
	/// 审核驳回
	/// </summary>
    [Description("审核驳回")]
    REJECT=2,
	/// <summary>
	/// 强制执行
	/// </summary>
    [Description("强制执行")]
    FORCE=3,
   }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.pub.d
{
   public enum AllergicPharmHandleMode {
	/// <summary>
	/// 过敏用药禁用
	/// </summary>
    [Description("过敏用药禁用")]
    ALLERGICPHARMFORBIDDEN=0,
	/// <summary>
	/// 过敏再皮试
	/// </summary>
    [Description("过敏再皮试")]
    ALLERGICRESKINTEST=1,
	/// <summary>
	/// 皮肤过敏试验
	/// </summary>
    [Description("皮肤过敏试验")]
    SKINALLERGICTEST=3,
	/// <summary>
	/// 过敏强制使用
	/// </summary>
    [Description("过敏强制使用")]
    ALLERGICFORCEDUSE=2,
	/// <summary>
	/// 过敏排除后直接使用（本次不需再皮试）
	/// </summary>
    [Description("过敏排除后直接使用（本次不需再皮试）")]
    DIRECTUSEEXCLUDEALLERGIC=4,
	/// <summary>
	/// 过敏皮试结果未出
	/// </summary>
    [Description("过敏皮试结果未出")]
    WAITSKINTESTRPT=5,
	/// <summary>
	/// 未知
	/// </summary>
    [Description("未知")]
    UNKNOWN=9,
   }
}

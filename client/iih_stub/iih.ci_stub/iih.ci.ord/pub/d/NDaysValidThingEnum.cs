using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.pub.d
{
   public enum NDaysValidThingEnum {
	/// <summary>
	/// 皮试阳性
	/// </summary>
    [Description("皮试阳性")]
    SKINTESTYANG=0,
	/// <summary>
	/// 皮试阴性
	/// </summary>
    [Description("皮试阴性")]
    SKINTESTYIN=1,
	/// <summary>
	/// 暂无结果
	/// </summary>
    [Description("暂无结果")]
    WAITSKINTESTRST=2,
	/// <summary>
	/// 有执行用药
	/// </summary>
    [Description("有执行用药")]
    WITHEXECUSEPHARM=3,
	/// <summary>
	/// 其它
	/// </summary>
    [Description("其它")]
    OTHER=9,
	/// <summary>
	/// 无执行用药
	/// </summary>
    [Description("无执行用药")]
    NOEXECUSEPHARM=4,
   }
}

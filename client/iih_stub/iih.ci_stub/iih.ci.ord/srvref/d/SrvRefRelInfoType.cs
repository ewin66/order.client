using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.srvref.d
{
   public enum SrvRefRelInfoType {
	/// <summary>
	/// 服务基本信息
	/// </summary>
    [Description("服务基本信息")]
    MEDSRVDATUMINFO=0,
	/// <summary>
	/// 药品定义
	/// </summary>
    [Description("药品定义")]
    MMDEFDATUMINFO=1,
	/// <summary>
	/// 药品属性
	/// </summary>
    [Description("药品属性")]
    SRVMMDATUMINFO=2,
	/// <summary>
	/// 检查属性
	/// </summary>
    [Description("检查属性")]
    SRVRISDATUMINFO=3,
	/// <summary>
	/// 检验属性
	/// </summary>
    [Description("检验属性")]
    SRVLISDATUMINFO=4,
	/// <summary>
	/// 手术属性
	/// </summary>
    [Description("手术属性")]
    SRVOPDATUMINFO=5,
	/// <summary>
	/// 医保计划
	/// </summary>
    [Description("医保计划")]
    HPPLANDATUMINFO=6,
	/// <summary>
	/// 参照描述
	/// </summary>
    [Description("参照描述")]
    REFDESCDATUMINFO=7,
   }
}

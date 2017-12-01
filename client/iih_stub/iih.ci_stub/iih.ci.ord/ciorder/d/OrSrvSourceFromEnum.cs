using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ciorder.d
{
   public enum OrSrvSourceFromEnum {
	/// <summary>
	/// 医生开立
	/// </summary>
    [Description("医生开立")]
    PHYSIAN=0,
	/// <summary>
	/// 用法关联费用派生
	/// </summary>
    [Description("用法关联费用派生")]
    USAGERELFEE=1,
	/// <summary>
	/// 付款策略派生价格代理（套）
	/// </summary>
    [Description("付款策略派生价格代理（套）")]
    AGENTFROMPRIMD=2,
	/// <summary>
	/// 护士核对补录
	/// </summary>
    [Description("护士核对补录")]
    NURSECHECKADD=3,
	/// <summary>
	/// 医技执行补录
	/// </summary>
    [Description("医技执行补录")]
    MTEXECADD=4,
	/// <summary>
	/// 煎法关联费用派生
	/// </summary>
    [Description("煎法关联费用派生")]
    BOILRELFEE=5,
	/// <summary>
	/// 临床路径执行（废弃不用）
	/// </summary>
    [Description("临床路径执行（废弃不用）")]
    CP=7,
	/// <summary>
	/// 床边执行
	/// </summary>
    [Description("床边执行")]
    BEDMP=6,
	/// <summary>
	/// 付款策略派生价格代理（组合）
	/// </summary>
    [Description("付款策略派生价格代理（组合）")]
    AGENTFROMCOMPPRIMD=8,
	/// <summary>
	/// 会诊受邀科室费用派生
	/// </summary>
    [Description("会诊受邀科室费用派生")]
    FROMCONSDEPFEE=9,
	/// <summary>
	/// 关联服务策略派生
	/// </summary>
    [Description("关联服务策略派生")]
    RELSRVTACTIC=10,
	/// <summary>
	/// 医生费用补录
	/// </summary>
    [Description("医生费用补录")]
    PHYSIANFEEADD=11,
	/// <summary>
	/// 标本关联费用派生
	/// </summary>
    [Description("标本关联费用派生")]
    SPECIMENRELFEE=12,
	/// <summary>
	/// 标本容器关联派生
	/// </summary>
    [Description("标本容器关联派生")]
    SPECIMENVESSELRELFEE=13,
	/// <summary>
	/// 其它
	/// </summary>
    [Description("其它")]
    OTHER=99,
   }
}

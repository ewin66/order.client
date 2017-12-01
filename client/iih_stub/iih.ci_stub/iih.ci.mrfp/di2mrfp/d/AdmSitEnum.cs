using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mrfp.di2mrfp.d
{
   public enum AdmSitEnum {
	/// <summary>
	/// 有
	/// </summary>
    [Description("有")]
    YOU=1,
	/// <summary>
	/// 临床未确定
	/// </summary>
    [Description("临床未确定")]
    LINCHUANGWEIQUEDING=2,
	/// <summary>
	/// 情况不明
	/// </summary>
    [Description("情况不明")]
    QINGKUANGBUMING=3,
	/// <summary>
	/// 无
	/// </summary>
    [Description("无")]
    WU=4,
   }
}

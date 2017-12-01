using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.mr.knowledgetype.d
{
   public enum Attribute {
	/// <summary>
	/// 个人
	/// </summary>
    [Description("个人")]
    PERSONAL=1,
	/// <summary>
	/// 科室
	/// </summary>
    [Description("科室")]
    DEPT=2,
   }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.tmpl.d
{
   public enum LongTempOrEnum {
	/// <summary>
	/// NULL
	/// </summary>
    [Description("NULL")]
    LONGTMPNULLOR=0,
	/// <summary>
	/// 长期医嘱
	/// </summary>
    [Description("长期医嘱")]
    LONGOR=1,
	/// <summary>
	/// 临时医嘱
	/// </summary>
    [Description("临时医嘱")]
    TEMPORARYOR=2,
   }
}

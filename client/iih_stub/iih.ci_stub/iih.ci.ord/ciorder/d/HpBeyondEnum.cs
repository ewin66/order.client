using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ciorder.d
{
	public class HpBeyondEnum {
        [Description("保内诊断")]
		public const String HPDIAG="0";//保内诊断
        [Description("保外诊断")]
		public const String HPEXTERNALDIAG="1";//保外诊断
        [Description("非医保就诊")]
		public const String NONMEDICARE="9";//非医保就诊
   }
}

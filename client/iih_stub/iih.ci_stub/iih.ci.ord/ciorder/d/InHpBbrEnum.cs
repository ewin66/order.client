using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ciorder.d
{
	public class InHpBbrEnum {
        [Description("白名单")]
		public const String WHITELIST="0";//白名单
        [Description("黑名单")]
		public const String BLACKLIST="1";//黑名单
        [Description("非医保就诊")]
		public const String NONMEDICARE="9";//非医保就诊
   }
}

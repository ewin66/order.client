using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.srvref.d
{
	public class MedicalWfTpAbbrEnum {
        [Description("门诊")]
		public const String OP="OP";//门诊
        [Description("急诊")]
		public const String ER="ER";//急诊
        [Description("住院")]
		public const String IP="IP";//住院
        [Description("体检")]
		public const String PE="PE";//体检
        [Description("家床")]
		public const String FM="FM";//家床
   }
}

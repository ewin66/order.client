using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ciorder.d
{
	public class HpIndicBasicJudgeEnum {
        [Description("非医保就诊")]
		public const String NOTHPPV="00";//非医保就诊
        [Description("医保就诊")]
		public const String HPPV="10";//医保就诊
        [Description("医保保内诊断")]
		public const String HPPVANDDIINHP="11";//医保保内诊断
        [Description("医保保外诊断")]
		public const String HPPVANDDINOTINHP="12";//医保保外诊断
   }
}

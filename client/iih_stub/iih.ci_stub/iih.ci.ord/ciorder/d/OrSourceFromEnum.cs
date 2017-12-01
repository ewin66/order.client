using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ciorder.d
{
	public class OrSourceFromEnum {
        [Description("服务参照")]
		public const String IIHSRVREF="01";//服务参照
        [Description("服务分类")]
		public const String IIHSRVCAHELPER="02";//服务分类
        [Description("医嘱模板")]
		public const String IIHORTMPLHELPER="03";//医嘱模板
        [Description("医技常规")]
		public const String IIHMTROUTINEHELPER="04";//医技常规
        [Description("患者既往")]
		public const String IIHPATIPASTHELPER="05";//患者既往
        [Description("组套")]
		public const String IIHCLINICALKITHELPER="06";//组套
        [Description("医嘱复制")]
		public const String IIHORCLONE="07";//医嘱复制
        [Description("关联生成")]
		public const String IIHORRELAUTOGEN="08";//关联生成
        [Description("临床路径")]
		public const String IIHCPHELPER="09";//临床路径
        [Description("服务参照（语音）")]
		public const String IIHSRVREF8VOICE="0A";//服务参照（语音）
        [Description("住院医嘱复制")]
		public const String IIHOPORCOPY="0B";//住院医嘱复制
        [Description("第三方系统")]
		public const String THIRDPARTYSYS="10";//第三方系统
        [Description("医技补费")]
		public const String IIHMEDTECHORDERS="0C";//医技补费
   }
}

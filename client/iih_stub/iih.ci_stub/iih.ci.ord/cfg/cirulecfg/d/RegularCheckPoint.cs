using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.cfg.cirulecfg.d
{
	public class RegularCheckPoint {
        [Description("保存医嘱")]
		public const String SAVE="10";//保存医嘱
        [Description("医嘱签署")]
		public const String SIGN="11";//医嘱签署
        [Description("医嘱撤回")]
		public const String REVOKE="12";//医嘱撤回
        [Description("医嘱停止")]
		public const String STOP="13";//医嘱停止
        [Description("医嘱作废")]
		public const String CANCEL="14";//医嘱作废
        [Description("医嘱删除")]
		public const String DELETE="15";//医嘱删除
        [Description("服务启用")]
		public const String ENABLE="20";//服务启用
        [Description("超天数开单校验")]
		public const String EXCESSIVE="25";//超天数开单校验
        [Description("合单规则")]
		public const String MERGE_BILL="A1";//合单规则
        [Description("分方规则")]
		public const String HANDLE_PRES="A2";//分方规则
   }
}

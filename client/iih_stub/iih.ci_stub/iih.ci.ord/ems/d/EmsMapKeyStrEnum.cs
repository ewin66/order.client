using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ems.d
{
	public class EmsMapKeyStrEnum {
        [Description("医疗单动态指标项及数据")]
		public const String EMSDYNAMICINDEXDTOFARRAYLIST="iih.bd.srv.ems.d.EmsDynamicIndexDTO";//医疗单动态指标项及数据
        [Description("医嘱主服务套时对应的套定义数据")]
		public const String BDSRVSETITEMDOFARRAYLIST="iih.bd.srv.medsrv.d.MedSrvSetItemDO";//医嘱主服务套时对应的套定义数据
   }
}

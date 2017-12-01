using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace iih.ci.ord.ems.d
{
	public class EmsSrvMapKeyStrEnum {
        [Description("服务关联物品数据信息")]
		public const String BDSRVRELMMDTOFARRAYLIST="iih.bd.mm.meterial.d.MeterialDO";//服务关联物品数据信息
        [Description("医嘱项目服务套时对应的套定义数据")]
		public const String BDSRVSETITEMDOFARRAYLIST="iih.bd.srv.medsrv.d.MedSrvSetItemDO";//医嘱项目服务套时对应的套定义数据
        [Description("服务对应物品可用包装单位数据")]
		public const String MEASUNITDTOARRAYLIST="bd.srv.oth.MeasUnitDTO";//服务对应物品可用包装单位数据
   }
}

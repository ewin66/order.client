package iih.ci.ord.ems.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EmsSrvMapKeyStrEnum {

    @DmEnumDesc(name="服务关联物品数据信息",description="服务关联物品数据信息")
    public static final String BDSRVRELMMDTOFARRAYLIST="iih.bd.mm.meterial.d.MeterialDO"; //服务关联物品数据信息
    @DmEnumDesc(name="医嘱项目服务套时对应的套定义数据",description="医嘱项目服务套时对应的套定义数据")
    public static final String BDSRVSETITEMDOFARRAYLIST="iih.bd.srv.medsrv.d.MedSrvSetItemDO"; //医嘱项目服务套时对应的套定义数据
    @DmEnumDesc(name="服务对应物品可用包装单位数据",description="服务对应物品的包装单位数据")
    public static final String MEASUNITDTOARRAYLIST="bd.srv.oth.MeasUnitDTO"; //服务对应物品可用包装单位数据
}	

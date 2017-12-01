package iih.ci.ord.ems.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EmsMapKeyStrEnum {

    @DmEnumDesc(name="医疗单动态指标项及数据",description="医疗单动态指标项及数据")
    public static final String EMSDYNAMICINDEXDTOFARRAYLIST="iih.bd.srv.ems.d.EmsDynamicIndexDTO"; //医疗单动态指标项及数据
    @DmEnumDesc(name="医嘱主服务套时对应的套定义数据",description="医嘱主服务套时对应的套定义数据")
    public static final String BDSRVSETITEMDOFARRAYLIST="iih.bd.srv.medsrv.d.MedSrvSetItemDO"; //医嘱主服务套时对应的套定义数据
}	

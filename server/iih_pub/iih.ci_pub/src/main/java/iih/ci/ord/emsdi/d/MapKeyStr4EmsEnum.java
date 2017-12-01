package iih.ci.ord.emsdi.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MapKeyStr4EmsEnum {

    @DmEnumDesc(name="医嘱主服务套时对应的服务套数据",description="医嘱主服务套时对应的服务套数据")
    public static final String ORDSRVSETDOFARRAYLIST="iih.ci.ord.ordsrvset.d.OrdSrvSetDO"; //医嘱主服务套时对应的服务套数据
    @DmEnumDesc(name="医疗单动态指标项及数据",description="医疗单动态指标项及数据")
    public static final String EMSDYNAMICINDEXDTOFARRAYLIST="iih.bd.srv.ems.d.EmsDynamicIndexDTO"; //医疗单动态指标项及数据
}	

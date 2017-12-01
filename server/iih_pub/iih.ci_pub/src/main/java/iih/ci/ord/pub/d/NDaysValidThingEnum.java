package iih.ci.ord.pub.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface NDaysValidThingEnum {

    @DmEnumDesc(name="皮试阳性",description="")
	public static final Integer SKINTESTYANG=0;
    @DmEnumDesc(name="皮试阴性",description="")
	public static final Integer SKINTESTYIN=1;
    @DmEnumDesc(name="暂无结果",description="")
	public static final Integer WAITSKINTESTRST=2;
    @DmEnumDesc(name="有执行用药",description="")
	public static final Integer WITHEXECUSEPHARM=3;
    @DmEnumDesc(name="其它",description="")
	public static final Integer OTHER=9;
    @DmEnumDesc(name="无执行用药",description="")
	public static final Integer NOEXECUSEPHARM=4;
}	

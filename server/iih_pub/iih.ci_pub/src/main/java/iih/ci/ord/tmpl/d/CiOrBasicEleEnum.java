package iih.ci.ord.tmpl.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CiOrBasicEleEnum {

    @DmEnumDesc(name="频次",description="频次")
	public static final Integer FREQDEF=1; //频次
    @DmEnumDesc(name="用法",description="用法")
	public static final Integer ROUTE=2; //用法
    @DmEnumDesc(name="要求",description="要求")
	public static final Integer ROUTEDES=3; //要求
    @DmEnumDesc(name="煎法",description="煎法")
	public static final Integer BOIL=4; //煎法
    @DmEnumDesc(name="煎法要求",description="煎法要求")
	public static final Integer BOILDES=5; //煎法要求
}	

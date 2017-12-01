package iih.ci.ord.srvref.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SrvRefRelInfoType {

    @DmEnumDesc(name="服务基本信息",description="医疗服务数据信息")
	public static final Integer MEDSRVDATUMINFO=0;
    @DmEnumDesc(name="药品定义",description="物品定义数据信息")
	public static final Integer MMDEFDATUMINFO=1;
    @DmEnumDesc(name="药品属性",description="物品属性数据信息")
	public static final Integer SRVMMDATUMINFO=2;
    @DmEnumDesc(name="检查属性",description="检查属性数据信息")
	public static final Integer SRVRISDATUMINFO=3;
    @DmEnumDesc(name="检验属性",description="检验属性数据信息")
	public static final Integer SRVLISDATUMINFO=4;
    @DmEnumDesc(name="手术属性",description="手术属性数据信息")
	public static final Integer SRVOPDATUMINFO=5;
    @DmEnumDesc(name="医保计划",description="医保计划数据信息")
	public static final Integer HPPLANDATUMINFO=6;
    @DmEnumDesc(name="参照描述",description="参照描述数据信息")
	public static final Integer REFDESCDATUMINFO=7;
}	

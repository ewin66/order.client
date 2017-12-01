package iih.ci.ord.pub.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface AllergicHandleModeEnum {

    @DmEnumDesc(name="药品禁用",description="由于过敏，药品禁用")
	public static final Integer FORBIDDEN=0;
    @DmEnumDesc(name="再次皮试",description="再次皮试，已测试是否还过敏")
	public static final Integer RESKINTEST=1;
    @DmEnumDesc(name="强制使用",description="情况紧急，必须强制使用")
	public static final Integer FORCEDUSE=2;
}	

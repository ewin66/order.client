package iih.ci.ord.cfg.cirulecfg.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RuleRelCa {

    @DmEnumDesc(name="医疗单",description="根据医疗单校验")
	public static final Integer ID_SRVOF=0; //医疗单
    @DmEnumDesc(name="服务类型",description="通过服务类型校验")
	public static final Integer SD_SRVTP=1; //服务类型
    @DmEnumDesc(name="服务",description="根据服务ID进行校验")
	public static final Integer ID_SRV=2; //服务
    @DmEnumDesc(name="标本类型",description="标本类型")
	public static final Integer SAMPLE_TYPE=3; //标本类型
}	

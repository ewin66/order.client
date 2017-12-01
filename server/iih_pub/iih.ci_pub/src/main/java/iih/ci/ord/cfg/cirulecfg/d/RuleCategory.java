package iih.ci.ord.cfg.cirulecfg.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RuleCategory {

    @DmEnumDesc(name="校验规则",description="校验规则")
	public static final Integer VALIDATOR=1; //校验规则
    @DmEnumDesc(name="业务逻辑规则",description="业务逻辑规则")
	public static final Integer BIZ_LOGIC=2; //业务逻辑规则
}	

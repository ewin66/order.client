package iih.ci.ord.ems.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ExDeptMacroEnum {

    @DmEnumDesc(name="【开单科室】",description="执行科室宏变量：开单科室")
	public static final Integer ORDERDEP=1; //【开单科室】
    @DmEnumDesc(name="【就诊科室】",description="执行科室宏变量：就诊科室")
	public static final Integer ENTDEP=2; //【就诊科室】
    @DmEnumDesc(name="【临床跟随】",description="执行科室宏变量：医嘱跟随")
	public static final Integer FOLLOWOR=3; //【临床跟随】
    @DmEnumDesc(name="【就诊病区】",description="执行科室宏变量：就诊病区")
	public static final Integer ENTWARD=11; //【就诊病区】
    @DmEnumDesc(name="【套跟随】",description="执行科室宏变量：套跟随")
	public static final Integer FOLLOWSET=999; //【套跟随】
}	

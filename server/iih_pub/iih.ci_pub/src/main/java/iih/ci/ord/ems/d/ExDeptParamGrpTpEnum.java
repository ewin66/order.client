package iih.ci.ord.ems.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ExDeptParamGrpTpEnum {

    @DmEnumDesc(name="套组之套服务",description="组类型为套，角色为套服务")
    public static final String SETGRPANDSETSRV="00"; //套组之套服务
    @DmEnumDesc(name="套组之套内项目",description="组类型为套，角色为套内项目服务")
    public static final String SETGRPANDSRVOFSETSRV="01"; //套组之套内项目
}	

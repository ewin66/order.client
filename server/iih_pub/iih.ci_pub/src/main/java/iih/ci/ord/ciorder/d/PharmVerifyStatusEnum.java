package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PharmVerifyStatusEnum {

    @DmEnumDesc(name="未审核",description="未审核")
	public static final Integer UNAUDIT=0; //未审核
    @DmEnumDesc(name="审核通过",description="审核通过")
	public static final Integer PASS=1; //审核通过
    @DmEnumDesc(name="审核驳回",description="审核驳回")
	public static final Integer REJECT=2; //审核驳回
    @DmEnumDesc(name="强制执行",description="强制执行")
	public static final Integer ENFORCEDEXEC=3; //强制执行
}	

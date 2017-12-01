package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface InHpBbrEnum {

    @DmEnumDesc(name="白名单",description="白名单")
    public static final String WHITELIST="0"; //白名单
    @DmEnumDesc(name="黑名单",description="黑名单")
    public static final String BLACKLIST="1"; //黑名单
    @DmEnumDesc(name="非医保就诊",description="非医保就诊")
    public static final String NONMEDICARE="9"; //非医保就诊
}	

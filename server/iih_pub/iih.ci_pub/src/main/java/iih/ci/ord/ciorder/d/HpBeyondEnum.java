package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpBeyondEnum {

    @DmEnumDesc(name="保内诊断",description="保内诊断")
    public static final String HPDIAG="0"; //保内诊断
    @DmEnumDesc(name="保外诊断",description="保外诊断")
    public static final String HPEXTERNALDIAG="1"; //保外诊断
    @DmEnumDesc(name="非医保就诊",description="非医保就诊")
    public static final String NONMEDICARE="9"; //非医保就诊
}	

package iih.ci.ord.srvref.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MedicalWfTpAbbrEnum {

    @DmEnumDesc(name="门诊",description="门诊英文简称")
    public static final String OP="OP";
    @DmEnumDesc(name="急诊",description="急诊英文简称")
    public static final String ER="ER";
    @DmEnumDesc(name="住院",description="住院英文简称")
    public static final String IP="IP";
    @DmEnumDesc(name="体检",description="体检英文简称")
    public static final String PE="PE";
    @DmEnumDesc(name="家床",description="家庭病床英文简称")
    public static final String FM="FM";
}	

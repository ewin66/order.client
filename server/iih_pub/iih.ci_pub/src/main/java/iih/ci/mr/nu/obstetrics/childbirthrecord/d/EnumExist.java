package iih.ci.mr.nu.obstetrics.childbirthrecord.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumExist {

    @DmEnumDesc(name="有",description="有伤裂")
	public static final Integer EXIST=0; //有
    @DmEnumDesc(name="无",description="无伤裂")
	public static final Integer NOEXIST=1; //无
}	

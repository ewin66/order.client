package iih.ci.mr.nu.obstetrics.childbirthrecord.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumPoints {

    @DmEnumDesc(name="0分",description="0分")
	public static final Integer ZERO=0; //0分
    @DmEnumDesc(name="1分",description="1分")
	public static final Integer ONE=1; //1分
    @DmEnumDesc(name="2分",description="2分")
	public static final Integer TWO=2; //2分
}	

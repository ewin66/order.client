package iih.ci.ord.pub.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface NDaysTimeCalValidMode {

    @DmEnumDesc(name="24小时有效模式",description="")
	public static final Integer VALIDWITHIN24HOURMODE=0;
    @DmEnumDesc(name="日开始时间模式",description="")
	public static final Integer VALIDFROMDATESTARTMODE=1;
}	

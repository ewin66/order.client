package iih.ci.mr.knowledgetype.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface Attribute {

    @DmEnumDesc(name="个人",description="个人")
	public static final Integer PERSONAL=1; //个人
    @DmEnumDesc(name="科室",description="科室")
	public static final Integer DEPT=2; //科室
}	

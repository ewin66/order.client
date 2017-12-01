package iih.ci.ord.tmpl.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface LongTempOrEnum {

    @DmEnumDesc(name="NULL",description="NULL")
	public static final Integer LONGTMPNULLOR=0; //NULL
    @DmEnumDesc(name="长期医嘱",description="长期医嘱")
	public static final Integer LONGOR=1; //长期医嘱
    @DmEnumDesc(name="临时医嘱",description="临时医嘱")
	public static final Integer TEMPORARYOR=2; //临时医嘱
}	

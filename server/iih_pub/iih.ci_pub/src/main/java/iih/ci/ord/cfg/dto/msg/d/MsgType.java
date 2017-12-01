package iih.ci.ord.cfg.dto.msg.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MsgType {

    @DmEnumDesc(name="消息",description="消息")
	public static final Integer INFO=0; //消息
    @DmEnumDesc(name="错误",description="错误")
	public static final Integer ERROR=1; //错误
    @DmEnumDesc(name="询问确认",description="询问确认")
	public static final Integer CONFIRM=2; //询问确认
}	

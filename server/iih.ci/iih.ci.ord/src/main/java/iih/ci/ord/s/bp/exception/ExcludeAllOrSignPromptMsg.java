package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class ExcludeAllOrSignPromptMsg extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="全排斥医嘱即将停止所有活动中的长期医嘱，停止时间为全排斥医嘱的生效日期！";
	

    public ExcludeAllOrSignPromptMsg(String name_or_all) {
    	super();
    	defaultMsg ="["+name_or_all+"]是全排斥医嘱，即将停止所有活动中的长期医嘱，停止时间为全排斥医嘱["+name_or_all+"]的生效日期！";
    }
	
	public ExcludeAllOrSignPromptMsg(Throwable t)
	{
		super(t);
	}
	
	public ExcludeAllOrSignPromptMsg(String msg,Throwable t)
	{
		super(msg,t);
	}
	
	@Override
	public String getMessage() {
		String msg = super.getMessage();
		if(StringUtils.isBlank(msg))
			msg = defaultMsg;
		
		return msg;		
	}	
}

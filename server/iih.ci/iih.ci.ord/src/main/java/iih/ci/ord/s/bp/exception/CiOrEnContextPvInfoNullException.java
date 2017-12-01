package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrEnContextPvInfoNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="患者就诊时，患者及就诊数据信息空错误！";

	public CiOrEnContextPvInfoNullException()
	{
		super();
	}

    public CiOrEnContextPvInfoNullException(String s) {
    	super(s);
    }
	
	public CiOrEnContextPvInfoNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrEnContextPvInfoNullException(String msg,Throwable t)
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

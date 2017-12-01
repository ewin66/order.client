package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrEnContextNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="患者就诊上下文对象空错误！";

	public CiOrEnContextNullException()
	{
		super();
	}

    public CiOrEnContextNullException(String s) {
    	super(s);
    }
	
	public CiOrEnContextNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrEnContextNullException(String msg,Throwable t)
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

package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class ExternFunNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="外挂函数空异常！";

    public ExternFunNullException(String s) {
    	super(s);
    	defaultMsg=s+"外挂函数空异常！";
    }
	
	public ExternFunNullException(Throwable t)
	{
		super(t);
	}
	
	public ExternFunNullException(String msg,Throwable t)
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

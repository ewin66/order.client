package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class StrFactorDenoNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="比例系数分母为空异常！";

    public StrFactorDenoNullException(String s) {
    	super(s);
    	defaultMsg=s+"比例系数分母为空异常！";
    }
	
	public StrFactorDenoNullException(Throwable t)
	{
		super(t);
	}
	
	public StrFactorDenoNullException(String msg,Throwable t)
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

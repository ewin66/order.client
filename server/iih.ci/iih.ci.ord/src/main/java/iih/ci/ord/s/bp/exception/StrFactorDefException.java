package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class StrFactorDefException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="字符类型比例系数Factor定义异常！";

    public StrFactorDefException(String s) {
    	super(s);
    	defaultMsg=s+"字符类型比例系数Factor定义异常！";
    	
    }
	
	public StrFactorDefException(Throwable t)
	{
		super(t);
	}
	
	public StrFactorDefException(String msg,Throwable t)
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

package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class StrFactorNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="比例系数定义空异常！";

    public StrFactorNullException(String s) {
    	super(s);
    	defaultMsg=s+"比例系数定义空异常！";
    }
	
	public StrFactorNullException(Throwable t)
	{
		super(t);
	}
	
	public StrFactorNullException(String msg,Throwable t)
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

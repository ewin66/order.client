package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class ParamVStrNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="参数值串空异常！";

    public ParamVStrNullException(String s) {
    	super(s);
    	defaultMsg=s+"参数值串空异常！";
    	
    }
	
	public ParamVStrNullException(Throwable t)
	{
		super(t);
	}
	
	public ParamVStrNullException(String msg,Throwable t)
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

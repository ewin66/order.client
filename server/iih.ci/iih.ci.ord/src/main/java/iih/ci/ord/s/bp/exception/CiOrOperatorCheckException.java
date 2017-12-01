package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrOperatorCheckException extends BizException{
	
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="没有符合操作的数据！";

	public CiOrOperatorCheckException()
	{
		super();
	}

    public CiOrOperatorCheckException(String s) {
    	super(s);
    }
	
	public CiOrOperatorCheckException(Throwable t)
	{
		super(t);
	}
	
	public CiOrOperatorCheckException(String msg,Throwable t)
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

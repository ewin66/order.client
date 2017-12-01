package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class ExDeptTacticInfoNull4SrvItemOfSetException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="执行科室计算时，套内项目执行科室策略相关信息串空异常！";

	public ExDeptTacticInfoNull4SrvItemOfSetException()
	{
		super();
	}

    public ExDeptTacticInfoNull4SrvItemOfSetException(String s) {
    	super(s);
    }
	
	public ExDeptTacticInfoNull4SrvItemOfSetException(Throwable t)
	{
		super(t);
	}
	
	public ExDeptTacticInfoNull4SrvItemOfSetException(String msg,Throwable t)
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

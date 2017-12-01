package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrEnContextEntTpNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="患者就诊时，所在就诊流程类型数据空错误！";

	public CiOrEnContextEntTpNullException()
	{
		super();
	}

    public CiOrEnContextEntTpNullException(String s) {
    	super(s);
    }
	
	public CiOrEnContextEntTpNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrEnContextEntTpNullException(String msg,Throwable t)
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

package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrOpenSrvReactCheckException extends BizException{
	
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱开立时，存在开始结束时间重叠的互斥医嘱异常！";

	public CiOrOpenSrvReactCheckException()
	{
		super();
	}

    public CiOrOpenSrvReactCheckException(String s) {
    	super(s);
    }
	
	public CiOrOpenSrvReactCheckException(Throwable t)
	{
		super(t);
	}
	
	public CiOrOpenSrvReactCheckException(String msg,Throwable t)
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

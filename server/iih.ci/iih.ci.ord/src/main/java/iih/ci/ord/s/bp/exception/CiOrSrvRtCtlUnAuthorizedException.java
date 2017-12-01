package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
/*
 * 医嘱开立时，医嘱项目开立权限未授权错误异常
 */
public class CiOrSrvRtCtlUnAuthorizedException extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱开立时，医嘱项目开立权限未授权错误异常！";

	public CiOrSrvRtCtlUnAuthorizedException()
	{
		super();
	}

    public CiOrSrvRtCtlUnAuthorizedException(String s) {
    	super(s);
    }
	
	public CiOrSrvRtCtlUnAuthorizedException(Throwable t)
	{
		super(t);
	}
	
	public CiOrSrvRtCtlUnAuthorizedException(String msg,Throwable t)
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

package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
/**
 * 部门服务限制时，黑名单与白名单共同存在错误异常
 */
public class DeptSrvLimitBWMixedException extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="部门服务限制时，黑名单与白名单共同存在错误异常！";
	
	public DeptSrvLimitBWMixedException()
	{
		super();
	}
	
    public DeptSrvLimitBWMixedException(String s) {
    	super(s);
    }
	
	public DeptSrvLimitBWMixedException(Throwable t)
	{
		super(t);
	}
	
	public DeptSrvLimitBWMixedException(String msg,Throwable t)
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

package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrEnContextOrgInfoNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="患者就诊时，开立医嘱组织相关数据信息空错误！";

	public CiOrEnContextOrgInfoNullException()
	{
		super();
	}

    public CiOrEnContextOrgInfoNullException(String s) {
    	super(s);
    }
	
	public CiOrEnContextOrgInfoNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrEnContextOrgInfoNullException(String msg,Throwable t)
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

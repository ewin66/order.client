package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrEnContextOrOpenInfoNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="患者就诊时，当前开立科室或开立医生数据空错误！";

	public CiOrEnContextOrOpenInfoNullException()
	{
		super();
	}

    public CiOrEnContextOrOpenInfoNullException(String s) {
    	super(s);
    }
	
	public CiOrEnContextOrOpenInfoNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrEnContextOrOpenInfoNullException(String msg,Throwable t)
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

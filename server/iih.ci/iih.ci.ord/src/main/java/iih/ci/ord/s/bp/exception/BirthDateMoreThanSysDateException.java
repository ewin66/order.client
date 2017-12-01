package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class BirthDateMoreThanSysDateException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="年龄计算时，出生日期不能大于系统时间！";

	public BirthDateMoreThanSysDateException()
	{
		super();
	}

    public BirthDateMoreThanSysDateException(String s) {
    	super(s);
    }
	
	public BirthDateMoreThanSysDateException(Throwable t)
	{
		super(t);
	}
	
	public BirthDateMoreThanSysDateException(String msg,Throwable t)
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

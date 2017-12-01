package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrEnContextCurDeptNullException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="患者就诊时，就诊当前就诊科室或就诊病区数据空错误！";

	public CiOrEnContextCurDeptNullException()
	{
		super();
	}

    public CiOrEnContextCurDeptNullException(String s) {
    	super(s);
    }
	
	public CiOrEnContextCurDeptNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrEnContextCurDeptNullException(String msg,Throwable t)
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

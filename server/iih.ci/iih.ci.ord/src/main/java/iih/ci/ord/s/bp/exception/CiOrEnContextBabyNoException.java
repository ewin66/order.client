package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrEnContextBabyNoException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="就诊患者为婴儿时，婴儿序号数据错误异常！";

	public CiOrEnContextBabyNoException()
	{
		super();
	}

    public CiOrEnContextBabyNoException(String s) {
    	super(s);
    }
	
	public CiOrEnContextBabyNoException(Throwable t)
	{
		super(t);
	}
	
	public CiOrEnContextBabyNoException(String msg,Throwable t)
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

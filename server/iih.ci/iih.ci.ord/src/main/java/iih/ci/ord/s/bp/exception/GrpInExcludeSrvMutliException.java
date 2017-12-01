package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
/**
 * 医嘱保存时，医嘱项目中同组内排斥项目同时存在异常
 */
public class GrpInExcludeSrvMutliException extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱保存时，医嘱项目中同组内排斥项目同时存在错误！";
	
	public GrpInExcludeSrvMutliException()
	{
		super();
	}
	
    public GrpInExcludeSrvMutliException(String s) {
    	super(s);
    }
	
	public GrpInExcludeSrvMutliException(Throwable t)
	{
		super(t);
	}
	
	public GrpInExcludeSrvMutliException(String msg,Throwable t)
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

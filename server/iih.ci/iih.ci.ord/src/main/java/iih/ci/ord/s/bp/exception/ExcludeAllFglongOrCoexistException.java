package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
/**
 * 医嘱签署保存时，全排医嘱与长期医嘱不能同时存在异常
 */
public class ExcludeAllFglongOrCoexistException extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱签署保存时，全排医嘱与长期医嘱不能同时存在！";

	public ExcludeAllFglongOrCoexistException()
	{
		super();
	}
	
	public ExcludeAllFglongOrCoexistException(String name_or_all,String name_or_long)
	{
		super();
		defaultMsg ="医嘱签署保存时，全排医嘱["+name_or_all+"]与长期医嘱["+name_or_long+"]不能同时存在！";
	}
	
    public ExcludeAllFglongOrCoexistException(String s) {
    	super(s);
    }
	
	public ExcludeAllFglongOrCoexistException(Throwable t)
	{
		super(t);
	}
	
	public ExcludeAllFglongOrCoexistException(String msg,Throwable t)
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

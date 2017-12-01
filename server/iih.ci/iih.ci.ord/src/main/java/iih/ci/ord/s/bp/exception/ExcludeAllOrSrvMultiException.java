/**
 * 
 */
package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

/**
 * 医嘱保存时，医嘱项目中存在多个全排项目异常
 */
public class ExcludeAllOrSrvMultiException extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱保存时，医嘱项目中存在多个全排项目错误！";
	
	public ExcludeAllOrSrvMultiException()
	{
		super();
	}
	
    public ExcludeAllOrSrvMultiException(String s) {
    	super(s);
    }
	
	public ExcludeAllOrSrvMultiException(Throwable t)
	{
		super(t);
	}
	
	public ExcludeAllOrSrvMultiException(String msg,Throwable t)
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

package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
/*
 * 用药医嘱时，患者存在该药品过敏史并禁用该药异常
 */
public class AllergicHisCheckPharmForbiddenException extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="用药医嘱时，患者存在该药品过敏史并禁用该药异常！";

	public AllergicHisCheckPharmForbiddenException()
	{
		super();
	}

    public AllergicHisCheckPharmForbiddenException(String s) {
    	super(s);
    }
	
	public AllergicHisCheckPharmForbiddenException(Throwable t)
	{
		super(t);
	}
	
	public AllergicHisCheckPharmForbiddenException(String msg,Throwable t)
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

package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class ParamVCntAndParamCntNotEqualException extends BizException {
	private static final long serialVersionUID = 1L;
	
	private String defaultMsg ="参数值个数与参数个数不相等异常！";

    public ParamVCntAndParamCntNotEqualException(String s) {
    	super(s);
    	defaultMsg=s+"参数值个数与参数个数不相等异常！";
    	
    }
	
	public ParamVCntAndParamCntNotEqualException(Throwable t)
	{
		super(t);
	}
	
	public ParamVCntAndParamCntNotEqualException(String msg,Throwable t)
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

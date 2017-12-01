package iih.ci.ord.s.bp.exception;

import iih.ci.ord.pub.CiOrdUtils;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

/**
 * 待签医嘱中，同一个排斥组存在多个医嘱的错误异常
 */
public class GrpInReactExistMultiOrException extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="待签医嘱中，同一个排斥组存在多个医嘱的错误！";

	public GrpInReactExistMultiOrException()
	{
		super();
	}
	
	public GrpInReactExistMultiOrException(String[] name_ors)
	{
		super();
		defaultMsg =getOrNameStr(name_ors)+"是组内排斥医嘱，签署时只能保留一条，请做删除处理！";
	}
	
    public GrpInReactExistMultiOrException(String s) {
    	super(s);
    }
	
	public GrpInReactExistMultiOrException(Throwable t)
	{
		super(t);
	}
	
	public GrpInReactExistMultiOrException(String msg,Throwable t)
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
	private String getOrNameStr(String[] name_ors){
		return CiOrdUtils.getChineseNamesStrWithBracket(name_ors);
	}
}

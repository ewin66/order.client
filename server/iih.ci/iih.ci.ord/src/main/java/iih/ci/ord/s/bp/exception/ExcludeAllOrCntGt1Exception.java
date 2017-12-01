package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

/**
 * 医嘱签署保存时,不允许同时提交多条全排医嘱。请删除处理后再重新提交！
 */
public class ExcludeAllOrCntGt1Exception  extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱签署保存时,不允许同时提交多条全排医嘱。请删除处理后再重新提交！";
	
	public ExcludeAllOrCntGt1Exception()
	{
		super();
	}
	
    public ExcludeAllOrCntGt1Exception(String s) {
    	super(s);
    }
	
	public ExcludeAllOrCntGt1Exception(Throwable t)
	{
		super(t);
	}
	
	public ExcludeAllOrCntGt1Exception(String msg,Throwable t)
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

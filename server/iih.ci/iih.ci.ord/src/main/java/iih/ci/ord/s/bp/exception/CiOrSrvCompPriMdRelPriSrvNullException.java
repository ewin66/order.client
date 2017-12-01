package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrSrvCompPriMdRelPriSrvNullException extends BizException{
	
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱项目组合定价时，对应的价格服务空异常！";

	public CiOrSrvCompPriMdRelPriSrvNullException()
	{
		super();
	}

    public CiOrSrvCompPriMdRelPriSrvNullException(String s) {
    	super(s);
    }
	
	public CiOrSrvCompPriMdRelPriSrvNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrSrvCompPriMdRelPriSrvNullException(String msg,Throwable t)
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

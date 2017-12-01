package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrSetMemCntPriMdSrvNullException extends BizException{
	
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="套成员个数定价时，对应的价格服务空异常！";

	public CiOrSetMemCntPriMdSrvNullException()
	{
		super();
	}

    public CiOrSetMemCntPriMdSrvNullException(String s) {
    	super(s);
    }
	
	public CiOrSetMemCntPriMdSrvNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrSetMemCntPriMdSrvNullException(String msg,Throwable t)
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

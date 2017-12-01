package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrSetMemCntAddPriMdSrvNullException extends BizException{
	
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="套成员个数加收定价时，对应的价格服务空异常！";

	public CiOrSetMemCntAddPriMdSrvNullException()
	{
		super();
	}

    public CiOrSetMemCntAddPriMdSrvNullException(String s) {
    	super(s);
    }
	
	public CiOrSetMemCntAddPriMdSrvNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrSetMemCntAddPriMdSrvNullException(String msg,Throwable t)
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

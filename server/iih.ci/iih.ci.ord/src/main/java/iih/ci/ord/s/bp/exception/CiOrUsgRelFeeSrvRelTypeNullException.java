package iih.ci.ord.s.bp.exception;

import xap.mw.core.data.BizException;

public class CiOrUsgRelFeeSrvRelTypeNullException extends BizException{
	
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱关联服务，关联类型值空错误！";
	
	private String name_srv="";

	public CiOrUsgRelFeeSrvRelTypeNullException()
	{
		super();
	}

    public CiOrUsgRelFeeSrvRelTypeNullException(String s) {
    	super(s);
    	name_srv = s;
    }
	
	public CiOrUsgRelFeeSrvRelTypeNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrUsgRelFeeSrvRelTypeNullException(String msg,Throwable t)
	{
		super(msg,t);
	}
	
	@Override
	public String getMessage() {
		String msg = name_srv+defaultMsg;
		return msg;		
	}

}

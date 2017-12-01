package iih.ci.ord.s.bp.exception;

import xap.mw.core.data.BizException;

public class CiOrUsgRelFeeSrvQuanNullException extends BizException{
	
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱关联服务，关联服务数量空错误！";
	
	private String name_srv="";

	public CiOrUsgRelFeeSrvQuanNullException()
	{
		super();
	}

    public CiOrUsgRelFeeSrvQuanNullException(String s) {
    	super(s);
    	name_srv = s;
    }
	
	public CiOrUsgRelFeeSrvQuanNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrUsgRelFeeSrvQuanNullException(String msg,Throwable t)
	{
		super(msg,t);
	}
	
	@Override
	public String getMessage() {
		String msg = name_srv+defaultMsg;
		return msg;		
	}

}

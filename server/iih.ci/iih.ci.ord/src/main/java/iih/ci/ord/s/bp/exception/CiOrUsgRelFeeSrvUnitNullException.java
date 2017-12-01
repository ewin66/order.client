package iih.ci.ord.s.bp.exception;

import xap.mw.core.data.BizException;

public class CiOrUsgRelFeeSrvUnitNullException extends BizException{
	
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱关联服务，服务医学单位空错误！";
	
	private String name_srv="";

	public CiOrUsgRelFeeSrvUnitNullException()
	{
		super();
	}

    public CiOrUsgRelFeeSrvUnitNullException(String s) {
    	super(s);
    	name_srv = s;
    }
	
	public CiOrUsgRelFeeSrvUnitNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrUsgRelFeeSrvUnitNullException(String msg,Throwable t)
	{
		super(msg,t);
	}
	
	@Override
	public String getMessage() {
		String msg = name_srv+defaultMsg;
		return msg;		
	}

}

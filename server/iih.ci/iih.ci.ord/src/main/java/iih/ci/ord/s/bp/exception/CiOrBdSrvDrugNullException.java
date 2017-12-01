package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrBdSrvDrugNullException extends BizException{
	
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="关联的药品属性信息未维护！当前服务不可录入！";
	
	private String name_srv="";

	public CiOrBdSrvDrugNullException()
	{
		super();
	}

    public CiOrBdSrvDrugNullException(String s) {
    	super(s);
    	name_srv = s;
    }
	
	public CiOrBdSrvDrugNullException(Throwable t)
	{
		super(t);
	}
	
	public CiOrBdSrvDrugNullException(String msg,Throwable t)
	{
		super(msg,t);
	}
	
	@Override
	public String getMessage() {
		String msg = name_srv+defaultMsg;
		return msg;		
	}

}

/**
 * 
 */
package iih.ci.ord.s.bp.exception;

import xap.mw.core.data.BizException;

/**
 * @ClassName: CiOrderFreqSynchronizationCiOrSrvException
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年5月11日 上午10:44:56
 * @Package iih.ci.ord.s.bp.exception
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class CiOrderFreqSynchronizationCiOrSrvException extends BizException{
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医嘱频次同步到医嘱项目时，医嘱对象为空或者医嘱项目为空！";
	
	private String name_srv="";

	public CiOrderFreqSynchronizationCiOrSrvException()
	{
		super();
	}

    public CiOrderFreqSynchronizationCiOrSrvException(String s) {
    	super(s);
    	name_srv = s;
    }
	
	public CiOrderFreqSynchronizationCiOrSrvException(Throwable t)
	{
		super(t);
	}
	
	public CiOrderFreqSynchronizationCiOrSrvException(String msg,Throwable t)
	{
		super(msg,t);
	}
	
	@Override
	public String getMessage() {
		String msg = name_srv+defaultMsg;
		return msg;		
	}
}

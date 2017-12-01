/**
 * 
 */
package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

/**
 * @ClassName: GenEmsDiInfo8BdSrvParameterNUllException
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年7月26日 下午4:24:43
 * @Package iih.ci.ord.s.bp.exception
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class GenEmsDiInfo8BdSrvParameterNUllException  extends BizException {
	private static final long serialVersionUID = 1L;

	private String defaultMsg ="医疗服务选取参数为空";

	public GenEmsDiInfo8BdSrvParameterNUllException()
	{
		super();
	}

    public GenEmsDiInfo8BdSrvParameterNUllException(String s) {
    	super(s);
    }
	
	public GenEmsDiInfo8BdSrvParameterNUllException(Throwable t)
	{
		super(t);
	}
	
	public GenEmsDiInfo8BdSrvParameterNUllException(String msg,Throwable t)
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

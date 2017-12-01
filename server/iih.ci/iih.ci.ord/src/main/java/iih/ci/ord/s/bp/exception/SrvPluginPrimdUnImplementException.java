package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
/*
 * 服务价格计算时，外挂插件价格计算模式尚未支持错误异常
 */
public class SrvPluginPrimdUnImplementException extends BizException {
		private static final long serialVersionUID = 1L;

		private String defaultMsg ="服务价格计算时，外挂插件价格计算模式尚未支持错误异常！";

		public SrvPluginPrimdUnImplementException()
		{
			super();
		}

	    public SrvPluginPrimdUnImplementException(String s) {
	    	super(s);
	    }
		
		public SrvPluginPrimdUnImplementException(Throwable t)
		{
			super(t);
		}
		
		public SrvPluginPrimdUnImplementException(String msg,Throwable t)
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

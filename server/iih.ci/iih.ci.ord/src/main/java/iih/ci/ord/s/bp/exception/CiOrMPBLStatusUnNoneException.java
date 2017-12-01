package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
/*
 * 门诊医嘱撤销签署时已有医嘱记费或执行，不可撤销签署错误异常
 */
public class CiOrMPBLStatusUnNoneException extends BizException {
		private static final long serialVersionUID = 1L;

		private String defaultMsg ="门诊医嘱撤销签署时已有医嘱记费或执行，不可撤销签署错误异常！";

		public CiOrMPBLStatusUnNoneException()
		{
			super();
		}

	    public CiOrMPBLStatusUnNoneException(String s) {
	    	super(s);
	    }
		
		public CiOrMPBLStatusUnNoneException(Throwable t)
		{
			super(t);
		}
		
		public CiOrMPBLStatusUnNoneException(String msg,Throwable t)
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

//		@Override
//		public int getCode() {
//			// TODO Auto-generated method stub
//			return -1000;
//		}
		
}

package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrSetQuanMeduException extends BizException {

	private static final long serialVersionUID = 1L;

	private static String defaultMsg = "医疗服务%s频次【持续】，%s异常！";

	public CiOrSetQuanMeduException() {
		super();
	}

	public CiOrSetQuanMeduException(String s) {
		super(s);
	}

	public CiOrSetQuanMeduException(String srvStr, String expStr) {
		super(String.format(defaultMsg, "【" + srvStr + "】", expStr));
	}

	public CiOrSetQuanMeduException(Throwable t) {
		super(t);
	}

	public CiOrSetQuanMeduException(String msg, Throwable t) {
		super(msg, t);
	}

	@Override
	public String getMessage() {
		String msg = super.getMessage();
		if (StringUtils.isBlank(msg))
			msg = defaultMsg;
		return msg;
	}
}

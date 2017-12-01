package iih.ci.ord.s.bp.exception;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;

public class CiOrSrvMmRelSkinSrvNullException extends BizException {

	private static final long serialVersionUID = 1L;

	private static String defaultMsg = "医嘱开立时，医嘱项目为需皮试药品但对应的皮试服务为空异常！";

	public CiOrSrvMmRelSkinSrvNullException() {
		super();
	}

	public CiOrSrvMmRelSkinSrvNullException(String s) {
		super(s);
	}

	public CiOrSrvMmRelSkinSrvNullException(String srvStr, String expStr) {
		super(String.format(defaultMsg, "【" + srvStr + "】", expStr));
	}

	public CiOrSrvMmRelSkinSrvNullException(Throwable t) {
		super(t);
	}

	public CiOrSrvMmRelSkinSrvNullException(String msg, Throwable t) {
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

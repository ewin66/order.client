package iih.ci.ord.d.ems.order;

import iih.ci.ord.d.ems.base.BaseCiDTO;
import xap.mw.coreitf.d.FBoolean;

public class OrderRstDTO extends BaseCiDTO {
	/**
	 * 医嘱查询返回结果
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 成功标志
	 * @return
	 */
	public FBoolean getIsSuccess() {
		return ((FBoolean) getAttrVal("IsSuccess"));
	}
	/**
	 * 成功标志
	 * @param 真假值
	 */
	public void setIsSuccess(FBoolean IsSuccess) {
		setAttrVal("IsSuccess", IsSuccess);
	}
	/**
	 * 信息
	 * @return
	 */
	public String getMessageInfo() {
		return ((String) getAttrVal("MessageInfo"));
	}
	/**
	 * 信息
	 * @param 信息
	 */
	public void setMessageInfo(String MessageInfo) {
		setAttrVal("MessageInfo", MessageInfo);
	}
	
	
}

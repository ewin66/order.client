package iih.ci.ord.d.ems.thr;

import iih.ci.ord.d.ems.base.BaseCiDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 第三方医嘱返回类型
 * @author wangqingzhu
 *
 */
public class ThirdRstDTO extends BaseCiDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 判断处理结果标志
	 * @return FBoolean
	 */
	public FBoolean isSuccessful() {
		return ((FBoolean) getAttrVal("isSuccessful"));
	}
	/**
	 * 设置处理结果标志
	 * @param isSuccessful
	 */
	public void setSuccessful(FBoolean isSuccessful) {
		setAttrVal("isSuccessful", isSuccessful);
	}
	
	/**
	 * 错误信息
	 * @return String
	 */
	public String getErrorMessage() {
		return ((String) getAttrVal("ErrorMessage"));
	}
	/**
	 * 错误信息
	 * @param ErrorMessage
	 */
	public void setErrorMessage(String emsDocument) {
		setAttrVal("ErrorMessage", emsDocument);
	}
	
	/**
	 * 医嘱模型
	 * @return String
	 */
	public FArrayList getOrderAggInfoList() {
		return ((FArrayList) getAttrVal("OrderAggInfoList"));
	}
	/**
	 * 医嘱模型
	 * @param ErrorMessage
	 */
	public void setOrderAggInfoList(FArrayList OrderAggInfoList) {
		setAttrVal("OrderAggInfoList", OrderAggInfoList);
	}
}

package iih.ci.ord.moreemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 多医疗单的返回集合 DTO数据 
 * 
 */
public class MoreEmsParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_moreems() {
		return ((String) getAttrVal("Id_moreems"));
	}
	/**
	 * 主键
	 * @param Id_moreems
	 */
	public void setId_moreems(String Id_moreems) {
		setAttrVal("Id_moreems", Id_moreems);
	}
	/**
	 * 医嘱列表
	 * @return FMap2
	 */
	public FMap2 getOrdermap2() {
		return ((FMap2) getAttrVal("Ordermap2"));
	}
	/**
	 * 医嘱列表
	 * @param Ordermap2
	 */
	public void setOrdermap2(FMap2 Ordermap2) {
		setAttrVal("Ordermap2", Ordermap2);
	}
	/**
	 * 错误信息字符串
	 * @return String
	 */
	public String getErrorinfo() {
		return ((String) getAttrVal("Errorinfo"));
	}
	/**
	 * 错误信息字符串
	 * @param Errorinfo
	 */
	public void setErrorinfo(String Errorinfo) {
		setAttrVal("Errorinfo", Errorinfo);
	}
	/**
	 * 多医疗单的错误数据
	 * @return FMap2
	 */
	public FMap2 getErrormap2() {
		return ((FMap2) getAttrVal("Errormap2"));
	}
	/**
	 * 多医疗单的错误数据
	 * @param Errormap2
	 */
	public void setErrormap2(FMap2 Errormap2) {
		setAttrVal("Errormap2", Errormap2);
	}
	/**
	 * displaynam5
	 * @return String
	 */
	public String getName5() {
		return ((String) getAttrVal("Name5"));
	}
	/**
	 * displaynam5
	 * @param Name5
	 */
	public void setName5(String Name5) {
		setAttrVal("Name5", Name5);
	}
	/**
	 * displaynam6
	 * @return String
	 */
	public String getName6() {
		return ((String) getAttrVal("Name6"));
	}
	/**
	 * displaynam6
	 * @param Name6
	 */
	public void setName6(String Name6) {
		setAttrVal("Name6", Name6);
	}
	/**
	 * 提示信息
	 * @return String
	 */
	public String getPrompt_msg() {
		return ((String) getAttrVal("Prompt_msg"));
	}
	/**
	 * 提示信息
	 * @param Prompt_msg
	 */
	public void setPrompt_msg(String Prompt_msg) {
		setAttrVal("Prompt_msg", Prompt_msg);
	}
}
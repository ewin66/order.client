package iih.ci.ord.dto.orderverify.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 审核检索条件dto DTO数据 
 * 
 */
public class OrderVerifyCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者条件类型
	 * @return String
	 */
	public String getPat_cond_type() {
		return ((String) getAttrVal("Pat_cond_type"));
	}
	/**
	 * 患者条件类型
	 * @param Pat_cond_type
	 */
	public void setPat_cond_type(String Pat_cond_type) {
		setAttrVal("Pat_cond_type", Pat_cond_type);
	}
	/**
	 * 患者条件值
	 * @return String
	 */
	public String getPat_cond_value() {
		return ((String) getAttrVal("Pat_cond_value"));
	}
	/**
	 * 患者条件值
	 * @param Pat_cond_value
	 */
	public void setPat_cond_value(String Pat_cond_value) {
		setAttrVal("Pat_cond_value", Pat_cond_value);
	}
	/**
	 * 审核状态
	 * @return String
	 */
	public String getVerify_state() {
		return ((String) getAttrVal("Verify_state"));
	}
	/**
	 * 审核状态
	 * @param Verify_state
	 */
	public void setVerify_state(String Verify_state) {
		setAttrVal("Verify_state", Verify_state);
	}
	/**
	 * 开始时间
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 门诊/住院
	 * @return FBoolean
	 */
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}
	/**
	 * 门诊/住院
	 * @param Fg_op
	 */
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
}
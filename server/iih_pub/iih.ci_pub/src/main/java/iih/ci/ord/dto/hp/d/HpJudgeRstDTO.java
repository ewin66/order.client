package iih.ci.ord.dto.hp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保校验结果 DTO数据 
 * 
 */
public class HpJudgeRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 适应症标识
	 * @return FBoolean
	 */
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}
	/**
	 * 适应症标识
	 * @param Fg_indic
	 */
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}
	/**
	 * 自费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 医保适应症处理结果
	 * @return Integer
	 */
	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}
	/**
	 * 医保适应症处理结果
	 * @param Eu_hpindicjudge
	 */
	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}
	/**
	 * 医保适应症判断方式
	 * @return String
	 */
	public String getEu_hpsrvctrtp() {
		return ((String) getAttrVal("Eu_hpsrvctrtp"));
	}
	/**
	 * 医保适应症判断方式
	 * @param Eu_hpsrvctrtp
	 */
	public void setEu_hpsrvctrtp(String Eu_hpsrvctrtp) {
		setAttrVal("Eu_hpsrvctrtp", Eu_hpsrvctrtp);
	}
	/**
	 * 医保限制条件
	 * @return String
	 */
	public String getDes_hplimit() {
		return ((String) getAttrVal("Des_hplimit"));
	}
	/**
	 * 医保限制条件
	 * @param Des_hplimit
	 */
	public void setDes_hplimit(String Des_hplimit) {
		setAttrVal("Des_hplimit", Des_hplimit);
	}
}
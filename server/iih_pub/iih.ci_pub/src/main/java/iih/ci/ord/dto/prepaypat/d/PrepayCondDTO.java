package iih.ci.ord.dto.prepaypat.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预付费患者检索条件dto DTO数据 
 * 
 */
public class PrepayCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 有效开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe_begin() {
		return ((FDateTime) getAttrVal("Dt_effe_begin"));
	}
	/**
	 * 有效开始时间
	 * @param Dt_effe_begin
	 */
	public void setDt_effe_begin(FDateTime Dt_effe_begin) {
		setAttrVal("Dt_effe_begin", Dt_effe_begin);
	}
	/**
	 * 有效结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe_end() {
		return ((FDateTime) getAttrVal("Dt_effe_end"));
	}
	/**
	 * 有效结束时间
	 * @param Dt_effe_end
	 */
	public void setDt_effe_end(FDateTime Dt_effe_end) {
		setAttrVal("Dt_effe_end", Dt_effe_end);
	}
	/**
	 * 草药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_herb() {
		return ((FBoolean) getAttrVal("Fg_herb"));
	}
	/**
	 * 草药标志
	 * @param Fg_herb
	 */
	public void setFg_herb(FBoolean Fg_herb) {
		setAttrVal("Fg_herb", Fg_herb);
	}
}
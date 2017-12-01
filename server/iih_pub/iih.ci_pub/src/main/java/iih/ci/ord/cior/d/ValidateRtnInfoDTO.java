package iih.ci.ord.cior.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检查校验返回数据信息 DTO数据 
 * 
 */
public class ValidateRtnInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 所在阶段序号
	 * @return Integer
	 */
	public Integer getPhaseno() {
		return ((Integer) getAttrVal("Phaseno"));
	}
	/**
	 * 所在阶段序号
	 * @param Phaseno
	 */
	public void setPhaseno(Integer Phaseno) {
		setAttrVal("Phaseno", Phaseno);
	}
	/**
	 * 场景数据
	 * @return FMap
	 */
	public FMap2 getScenedatum() {
		return ((FMap2) getAttrVal("Scenedatum"));
	}
	/**
	 * 场景数据
	 * @param Scenedatum
	 */
	public void setScenedatum(FMap2 Scenedatum) {
		setAttrVal("Scenedatum", Scenedatum);
	}
	/**
	 * 返回值
	 * @return FMap
	 */
	public FMap2 getRtnvalue() {
		return ((FMap2) getAttrVal("Rtnvalue"));
	}
	/**
	 * 返回值
	 * @param Rtnvalue
	 */
	public void setRtnvalue(FMap2 Rtnvalue) {
		setAttrVal("Rtnvalue", Rtnvalue);
	}
	/**
	 * 返回值为场景值标识
	 * @return FBoolean
	 */
	public FBoolean getFg_rtnscene() {
		return ((FBoolean) getAttrVal("Fg_rtnscene"));
	}
	/**
	 * 返回值为场景值标识
	 * @param Fg_rtnscene
	 */
	public void setFg_rtnscene(FBoolean Fg_rtnscene) {
		setAttrVal("Fg_rtnscene", Fg_rtnscene);
	}
}
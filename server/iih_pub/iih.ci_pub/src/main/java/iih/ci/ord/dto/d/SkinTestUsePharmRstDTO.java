package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

import java.math.BigDecimal;

/**
 * 患者皮试或用药相关数据结果信息DTO DTO数据 
 * 
 */
public class SkinTestUsePharmRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * N天有效返回结果枚举值
	 * @return Integer
	 */
	public Integer getNdaysvalidrst() {
		return ((Integer) getAttrVal("Ndaysvalidrst"));
	}
	/**
	 * N天有效返回结果枚举值
	 * @param Ndaysvalidrst
	 */
	public void setNdaysvalidrst(Integer Ndaysvalidrst) {
		setAttrVal("Ndaysvalidrst", Ndaysvalidrst);
	}
	/**
	 * 皮试医嘱主键标识
	 * @return String
	 */
	public String getId_orskin() {
		return ((String) getAttrVal("Id_orskin"));
	}
	/**
	 * 皮试医嘱主键标识
	 * @param Id_orskin
	 */
	public void setId_orskin(String Id_orskin) {
		setAttrVal("Id_orskin", Id_orskin);
	}
	/**
	 * 过敏日期
	 * @return
	 */
	public FDateTime getDt_act()
	{
		return ((FDateTime) getAttrVal("Dt_act"));
	}
	/**
	 * 过敏日期
	 * @param Dt_act
	 */
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
}
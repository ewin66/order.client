package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 皮试逻辑结果DTO DTO数据 
 * 
 */
public class SkinTestRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 易过敏类药物处理方式
	 * @return Integer
	 */
	public Integer getAllergicpharmhandlemode() {
		return ((Integer) getAttrVal("Allergicpharmhandlemode"));
	}
	/**
	 * 易过敏类药物处理方式
	 * @param Allergicpharmhandlemode
	 */
	public void setAllergicpharmhandlemode(Integer Allergicpharmhandlemode) {
		setAttrVal("Allergicpharmhandlemode", Allergicpharmhandlemode);
	}
	/**
	 * 皮试医嘱
	 * @return String
	 */
	public String getId_skinor() {
		return ((String) getAttrVal("Id_skinor"));
	}
	/**
	 * 皮试医嘱
	 * @param Id_skinor
	 */
	public void setId_skinor(String Id_skinor) {
		setAttrVal("Id_skinor", Id_skinor);
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
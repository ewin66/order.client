package iih.ci.ord.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * ci判断特殊病药 DTO数据 
 * 
 */
public class CijudgeSpecillDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 药品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 药品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 特殊病药
	 * @return FBoolean
	 */
	public FBoolean getFg_mmspecill() {
		return ((FBoolean) getAttrVal("Fg_mmspecill"));
	}
	/**
	 * 特殊病药
	 * @param Fg_mmspecill
	 */
	public void setFg_mmspecill(FBoolean Fg_mmspecill) {
		setAttrVal("Fg_mmspecill", Fg_mmspecill);
	}
	/**
	 * 诊断集合
	 * @return FMap2
	 */
	public FMap2 getDiagmap() {
		return ((FMap2) getAttrVal("Diagmap"));
	}
	/**
	 * 诊断集合
	 * @param Diagmap
	 */
	public void setDiagmap(FMap2 Diagmap) {
		setAttrVal("Diagmap", Diagmap);
	}
	/**
	 * 扩展字段
	 * @return String
	 */
	public String getStr() {
		return ((String) getAttrVal("Str"));
	}
	/**
	 * 扩展字段
	 * @param Str
	 */
	public void setStr(String Str) {
		setAttrVal("Str", Str);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getStr2() {
		return ((String) getAttrVal("Str2"));
	}
	/**
	 * 扩展字段2
	 * @param Str2
	 */
	public void setStr2(String Str2) {
		setAttrVal("Str2", Str2);
	}
}
package iih.ci.ord.dto.ordpres.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱处方打印查询入口参数 DTO数据 
 * 
 */
public class PresPrintParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 处方串（逗号分隔）
	 * @return String
	 */
	public String getId_preses() {
		return ((String) getAttrVal("Id_preses"));
	}
	/**
	 * 处方串（逗号分隔）
	 * @param Id_preses
	 */
	public void setId_preses(String Id_preses) {
		setAttrVal("Id_preses", Id_preses);
	}
	/**
	 * 年龄
	 * @return FDouble
	 */
	public FDouble getAge() {
		return ((FDouble) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(FDouble Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 过敏史
	 * @return String
	 */
	public String getDes_alcla() {
		return ((String) getAttrVal("Des_alcla"));
	}
	/**
	 * 过敏史
	 * @param Des_alcla
	 */
	public void setDes_alcla(String Des_alcla) {
		setAttrVal("Des_alcla", Des_alcla);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
}
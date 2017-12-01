package iih.ci.rcm.contagionmessage.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 传染病消息DTO DTO数据 
 * 
 */
public class ContagionMessageDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 传染病主键
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}
	/**
	 * 传染病主键
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	/**
	 * 保存时间
	 * @return String
	 */
	public String getSave_time() {
		return ((String) getAttrVal("Save_time"));
	}
	/**
	 * 保存时间
	 * @param Save_time
	 */
	public void setSave_time(String Save_time) {
		setAttrVal("Save_time", Save_time);
	}
	/**
	 * 填报科室
	 * @return String
	 */
	public String getReport_dep() {
		return ((String) getAttrVal("Report_dep"));
	}
	/**
	 * 填报科室
	 * @param Report_dep
	 */
	public void setReport_dep(String Report_dep) {
		setAttrVal("Report_dep", Report_dep);
	}
	/**
	 * 填报医生
	 * @return String
	 */
	public String getReport_doc() {
		return ((String) getAttrVal("Report_doc"));
	}
	/**
	 * 填报医生
	 * @param Report_doc
	 */
	public void setReport_doc(String Report_doc) {
		setAttrVal("Report_doc", Report_doc);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getName_disease() {
		return ((String) getAttrVal("Name_disease"));
	}
	/**
	 * 疾病名称
	 * @param Name_disease
	 */
	public void setName_disease(String Name_disease) {
		setAttrVal("Name_disease", Name_disease);
	}
	/**
	 * 自定义1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 自定义1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 自定义2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 自定义2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 自定义3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 自定义3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
}
package iih.ci.rcm.d;

import xap.mw.core.data.*;

/**
 * 梅毒附卡打印 DTO数据 
 * 
 */
public class ContagionSyCardPrintDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 梅毒附卡ID
	 * @return String
	 */
	public String getId_syphilis() {
		return ((String) getAttrVal("Id_syphilis"));
	}
	/**
	 * 梅毒附卡ID
	 * @param Id_syphilis
	 */
	public void setId_syphilis(String Id_syphilis) {
		setAttrVal("Id_syphilis", Id_syphilis);
	}
	/**
	 * 父id
	 * @return String
	 */
	public String getP_id_contagion() {
		return ((String) getAttrVal("P_id_contagion"));
	}
	/**
	 * 父id
	 * @param P_id_contagion
	 */
	public void setP_id_contagion(String P_id_contagion) {
		setAttrVal("P_id_contagion", P_id_contagion);
	}
	/**
	 * 表单
	 * @return String
	 */
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}
	/**
	 * 表单
	 * @param Id_form
	 */
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	/**
	 * 梅毒检验结果
	 * @return String
	 */
	public String getSyphilis_result() {
		return ((String) getAttrVal("Syphilis_result"));
	}
	/**
	 * 梅毒检验结果
	 * @param Syphilis_result
	 */
	public void setSyphilis_result(String Syphilis_result) {
		setAttrVal("Syphilis_result", Syphilis_result);
	}
	/**
	 * 特征性临床表现
	 * @return String
	 */
	public String getClinical_manifestation() {
		return ((String) getAttrVal("Clinical_manifestation"));
	}
	/**
	 * 特征性临床表现
	 * @param Clinical_manifestation
	 */
	public void setClinical_manifestation(String Clinical_manifestation) {
		setAttrVal("Clinical_manifestation", Clinical_manifestation);
	}
	/**
	 * 报告科室
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 报告科室
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 报告科室code
	 * @return String
	 */
	public String getCode_dep_phyadm() {
		return ((String) getAttrVal("Code_dep_phyadm"));
	}
	/**
	 * 报告科室code
	 * @param Code_dep_phyadm
	 */
	public void setCode_dep_phyadm(String Code_dep_phyadm) {
		setAttrVal("Code_dep_phyadm", Code_dep_phyadm);
	}
	/**
	 * 报告科室name
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 报告科室name
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
}
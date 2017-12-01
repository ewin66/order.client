package iih.ci.rcm.contagionstdcardprntdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;

/**
 * 性病附卡打印 DTO数据
 * 
 */
public class ContagionStdCardPrintDto extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 性病打印卡id
	 * 
	 * @return String
	 */
	public String getId_std_contagion() {
		return ((String) getAttrVal("Id_std_contagion"));
	}

	/**
	 * 性病打印卡id
	 * 
	 * @param Id_std_contagion
	 */
	public void setId_std_contagion(String Id_std_contagion) {
		setAttrVal("Id_std_contagion", Id_std_contagion);
	}

	/**
	 * 性病附卡ID
	 * 
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}

	/**
	 * 性病附卡ID
	 * 
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}

	/**
	 * 父卡ID
	 * 
	 * @return String
	 */
	public String getP_id_contagion() {
		return ((String) getAttrVal("P_id_contagion"));
	}

	/**
	 * 父卡ID
	 * 
	 * @param P_id_contagion
	 */
	public void setP_id_contagion(String P_id_contagion) {
		setAttrVal("P_id_contagion", P_id_contagion);
	}

	/**
	 * 表单
	 * 
	 * @return String
	 */
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}

	/**
	 * 表单
	 * 
	 * @param Id_form
	 */
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}

	/**
	 * 婚姻
	 * 
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}

	/**
	 * 婚姻
	 * 
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}

	/**
	 * 婚姻编码
	 * 
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}

	/**
	 * 婚姻编码
	 * 
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}

	/**
	 * 婚姻状态名称
	 * 
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}

	/**
	 * 婚姻状态名称
	 * 
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}

	/**
	 * 民族
	 * 
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}

	/**
	 * 民族
	 * 
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}

	/**
	 * 民族编码
	 * 
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}

	/**
	 * 民族编码
	 * 
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}

	/**
	 * 民族名称
	 * 
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}

	/**
	 * 民族名称
	 * 
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}

	/**
	 * 文化程度
	 * 
	 * @return String
	 */
	public String getId_education() {
		return ((String) getAttrVal("Id_education"));
	}

	/**
	 * 文化程度
	 * 
	 * @param Id_education
	 */
	public void setId_education(String Id_education) {
		setAttrVal("Id_education", Id_education);
	}

	/**
	 * 文化程度编码
	 * 
	 * @return String
	 */
	public String getSd_education() {
		return ((String) getAttrVal("Sd_education"));
	}

	/**
	 * 文化程度编码
	 * 
	 * @param Sd_education
	 */
	public void setSd_education(String Sd_education) {
		setAttrVal("Sd_education", Sd_education);
	}

	/**
	 * 文化程度名称
	 * 
	 * @return String
	 */
	public String getName_education() {
		return ((String) getAttrVal("Name_education"));
	}

	/**
	 * 文化程度名称
	 * 
	 * @param Name_education
	 */
	public void setName_education(String Name_education) {
		setAttrVal("Name_education", Name_education);
	}

	/**
	 * 性病史
	 * 
	 * @return String
	 */
	public String getIs_std_history() {
		return ((String) getAttrVal("Is_std_history"));
	}

	/**
	 * 性病史
	 * 
	 * @param Is_std_history
	 */
	public void setIs_std_history(String Is_std_history) {
		setAttrVal("Is_std_history", Is_std_history);
	}

	/**
	 * 性病史编码
	 * 
	 * @return String
	 */
	public String getSd_std_history() {
		return ((String) getAttrVal("Sd_std_history"));
	}

	/**
	 * 性病史编码
	 * 
	 * @param Sd_std_history
	 */
	public void setSd_std_history(String Sd_std_history) {
		setAttrVal("Sd_std_history", Sd_std_history);
	}

	/**
	 * 性病史名称
	 * 
	 * @return String
	 */
	public String getName_std_history() {
		return ((String) getAttrVal("Name_std_history"));
	}

	/**
	 * 性病史名称
	 * 
	 * @param Name_std_history
	 */
	public void setName_std_history(String Name_std_history) {
		setAttrVal("Name_std_history", Name_std_history);
	}

	/**
	 * 接触史
	 * 
	 * @return String
	 */
	public String getId_contact_history() {
		return ((String) getAttrVal("Id_contact_history"));
	}

	/**
	 * 接触史
	 * 
	 * @param Id_contact_history
	 */
	public void setId_contact_history(String Id_contact_history) {
		setAttrVal("Id_contact_history", Id_contact_history);
	}

	/**
	 * 接触史编码
	 * 
	 * @return String
	 */
	public String getSd_contact_history() {
		return ((String) getAttrVal("Sd_contact_history"));
	}

	/**
	 * 接触史编码
	 * 
	 * @param Sd_contact_history
	 */
	public void setSd_contact_history(String Sd_contact_history) {
		setAttrVal("Sd_contact_history", Sd_contact_history);
	}

	/**
	 * 接触史名称
	 * 
	 * @return String
	 */
	public String getName_contact_history() {
		return ((String) getAttrVal("Name_contact_history"));
	}

	/**
	 * 接触史名称
	 * 
	 * @param Name_contact_history
	 */
	public void setName_contact_history(String Name_contact_history) {
		setAttrVal("Name_contact_history", Name_contact_history);
	}

	/**
	 * 感染途径
	 * 
	 * @return String
	 */
	public String getId_infection_way() {
		return ((String) getAttrVal("Id_infection_way"));
	}

	/**
	 * 感染途径
	 * 
	 * @param Id_infection_way
	 */
	public void setId_infection_way(String Id_infection_way) {
		setAttrVal("Id_infection_way", Id_infection_way);
	}

	/**
	 * 感染途径编码
	 * 
	 * @return String
	 */
	public String getSd_infection_way() {
		return ((String) getAttrVal("Sd_infection_way"));
	}

	/**
	 * 感染途径编码
	 * 
	 * @param Sd_infection_way
	 */
	public void setSd_infection_way(String Sd_infection_way) {
		setAttrVal("Sd_infection_way", Sd_infection_way);
	}

	/**
	 * 感染途径名称
	 * 
	 * @return String
	 */
	public String getName_infection_way() {
		return ((String) getAttrVal("Name_infection_way"));
	}

	/**
	 * 感染途径名称
	 * 
	 * @param Name_infection_way
	 */
	public void setName_infection_way(String Name_infection_way) {
		setAttrVal("Name_infection_way", Name_infection_way);
	}

	/**
	 * 样本来源
	 * 
	 * @return String
	 */
	public String getId_sample_source() {
		return ((String) getAttrVal("Id_sample_source"));
	}

	/**
	 * 样本来源
	 * 
	 * @param Id_sample_source
	 */
	public void setId_sample_source(String Id_sample_source) {
		setAttrVal("Id_sample_source", Id_sample_source);
	}

	/**
	 * 样本来源编码
	 * 
	 * @return String
	 */
	public String getSd_sample_source() {
		return ((String) getAttrVal("Sd_sample_source"));
	}

	/**
	 * 样本来源编码
	 * 
	 * @param Sd_sample_source
	 */
	public void setSd_sample_source(String Sd_sample_source) {
		setAttrVal("Sd_sample_source", Sd_sample_source);
	}

	/**
	 * 样本来源名称
	 * 
	 * @return String
	 */
	public String getName_sample_source() {
		return ((String) getAttrVal("Name_sample_source"));
	}

	/**
	 * 样本来源名称
	 * 
	 * @param Name_sample_source
	 */
	public void setName_sample_source(String Name_sample_source) {
		setAttrVal("Name_sample_source", Name_sample_source);
	}

	/**
	 * 实验室检测结论
	 * 
	 * @return String
	 */
	public String getId_conclusion() {
		return ((String) getAttrVal("Id_conclusion"));
	}

	/**
	 * 实验室检测结论
	 * 
	 * @param Id_conclusion
	 */
	public void setId_conclusion(String Id_conclusion) {
		setAttrVal("Id_conclusion", Id_conclusion);
	}

	/**
	 * 实验室检测结论编码
	 * 
	 * @return String
	 */
	public String getSd_conclusion() {
		return ((String) getAttrVal("Sd_conclusion"));
	}

	/**
	 * 实验室检测结论编码
	 * 
	 * @param Sd_conclusion
	 */
	public void setSd_conclusion(String Sd_conclusion) {
		setAttrVal("Sd_conclusion", Sd_conclusion);
	}

	/**
	 * 实验室检测结论名称
	 * 
	 * @return String
	 */
	public String getName_conclusion() {
		return ((String) getAttrVal("Name_conclusion"));
	}

	/**
	 * 实验室检测结论名称
	 * 
	 * @param Name_conclusion
	 */
	public void setName_conclusion(String Name_conclusion) {
		setAttrVal("Name_conclusion", Name_conclusion);
	}

	/**
	 * 时间
	 * 
	 * @return FDateTime
	 */
	public FDateTime getDt_contagion() {
		return ((FDateTime) getAttrVal("Dt_contagion"));
	}

	/**
	 * 时间
	 * 
	 * @param Dt_contagion
	 */
	public void setDt_contagion(FDateTime Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}

	/**
	 * 性病史4打印
	 * 
	 * @return String
	 */
	public String getStdhistory() {
		return ((String) getAttrVal("Stdhistory"));
	}

	/**
	 * 性病史4打印
	 * 
	 * @param Stdhistory
	 */
	public void setStdhistory(String Stdhistory) {
		setAttrVal("Stdhistory", Stdhistory);
	}

	/**
	 * 接触史4打印
	 * 
	 * @return String
	 */
	public String getStdcontact() {
		return ((String) getAttrVal("Stdcontact"));
	}

	/**
	 * 接触史4打印
	 * 
	 * @param Stdcontact
	 */
	public void setStdcontact(String Stdcontact) {
		setAttrVal("Stdcontact", Stdcontact);
	}

	/**
	 * 感染途径4打印
	 * 
	 * @return String
	 */
	public String getInfection() {
		return ((String) getAttrVal("Infection"));
	}

	/**
	 * 感染途径4打印
	 * 
	 * @param Infection
	 */
	public void setInfection(String Infection) {
		setAttrVal("Infection", Infection);
	}

	/**
	 * 样本来源4打印
	 * 
	 * @return String
	 */
	public String getSample() {
		return ((String) getAttrVal("Sample"));
	}

	/**
	 * 样本来源4打印
	 * 
	 * @param Sample
	 */
	public void setSample(String Sample) {
		setAttrVal("Sample", Sample);
	}

	/**
	 * 检测结论
	 * 
	 * @return String
	 */
	public String getConclusion() {
		return ((String) getAttrVal("Conclusion"));
	}

	/**
	 * 检测结论
	 * 
	 * @param Conclusion
	 */
	public void setConclusion(String Conclusion) {
		setAttrVal("Conclusion", Conclusion);
	}
}
package iih.ci.rcm.coninfodto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 实体 DTO数据
 * 
 */
public class ConInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 报卡名称
	 * 
	 * @return String
	 */
	public String getCard_name() {
		return ((String) getAttrVal("Card_name"));
	}

	/**
	 * 报卡名称
	 * 
	 * @param Card_name
	 */
	public void setCard_name(String Card_name) {
		setAttrVal("Card_name", Card_name);
	}

	/**
	 * 患者姓名
	 * 
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}

	/**
	 * 患者姓名
	 * 
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}

	/**
	 * 性别
	 * 
	 * @return String
	 */
	public String getPat_xex() {
		return ((String) getAttrVal("Pat_xex"));
	}

	/**
	 * 性别
	 * 
	 * @param Pat_xex
	 */
	public void setPat_xex(String Pat_xex) {
		setAttrVal("Pat_xex", Pat_xex);
	}

	/**
	 * 诊断
	 * 
	 * @return String
	 */
	public String getDiagnose() {
		return ((String) getAttrVal("Diagnose"));
	}

	/**
	 * 诊断
	 * 
	 * @param Diagnose
	 */
	public void setDiagnose(String Diagnose) {
		setAttrVal("Diagnose", Diagnose);
	}

	/**
	 * 报卡医生
	 * 
	 * @return String
	 */
	public String getReport_doctor() {
		return ((String) getAttrVal("Report_doctor"));
	}

	/**
	 * 报卡医生
	 * 
	 * @param Report_doctor
	 */
	public void setReport_doctor(String Report_doctor) {
		setAttrVal("Report_doctor", Report_doctor);
	}

	/**
	 * 报卡日期
	 * 
	 * @return FDate
	 */
	public FDate getReport_date() {
		return ((FDate) getAttrVal("Report_date"));
	}

	/**
	 * 报卡日期
	 * 
	 * @param Report_date
	 */
	public void setReport_date(FDate Report_date) {
		setAttrVal("Report_date", Report_date);
	}

	/**
	 * 删除原因
	 * 
	 * @return String
	 */
	public String getDelete_reason() {
		return ((String) getAttrVal("Delete_reason"));
	}

	/**
	 * 删除原因
	 * 
	 * @param Delete_reason
	 */
	public void setDelete_reason(String Delete_reason) {
		setAttrVal("Delete_reason", Delete_reason);
	}

	/**
	 * 删除人员
	 * 
	 * @return String
	 */
	public String getDelete_person() {
		return ((String) getAttrVal("Delete_person"));
	}

	/**
	 * 删除人员
	 * 
	 * @param Delete_person
	 */
	public void setDelete_person(String Delete_person) {
		setAttrVal("Delete_person", Delete_person);
	}

	/**
	 * 操作时间
	 * 
	 * @return FDateTime
	 */
	public FDateTime getOpreta_time() {
		return ((FDateTime) getAttrVal("Opreta_time"));
	}

	/**
	 * 操作时间
	 * 
	 * @param Opreta_time
	 */
	public void setOpreta_time(FDateTime Opreta_time) {
		setAttrVal("Opreta_time", Opreta_time);
	}

	/**
	 * 就诊号
	 * 
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}

	/**
	 * 就诊号
	 * 
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}

	/**
	 * 传染病id
	 * 
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}

	/**
	 * 传染病id
	 * 
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}

	/**
	 * 预留字段1
	 * 
	 * @return String
	 */
	public String getSpare_field1() {
		return ((String) getAttrVal("Spare_field1"));
	}

	/**
	 * 预留字段1
	 * 
	 * @param Spare_field1
	 */
	public void setSpare_field1(String Spare_field1) {
		setAttrVal("Spare_field1", Spare_field1);
	}

	/**
	 * 预留字段2
	 * 
	 * @return String
	 */
	public String getSpare_field2() {
		return ((String) getAttrVal("Spare_field2"));
	}

	/**
	 * 预留字段2
	 * 
	 * @param Spare_field2
	 */
	public void setSpare_field2(String Spare_field2) {
		setAttrVal("Spare_field2", Spare_field2);
	}

	/**
	 * 预留字段3
	 * 
	 * @return String
	 */
	public String getSpare_field3() {
		return ((String) getAttrVal("Spare_field3"));
	}

	/**
	 * 预留字段3
	 * 
	 * @param Spare_field3
	 */
	public void setSpare_field3(String Spare_field3) {
		setAttrVal("Spare_field3", Spare_field3);
	}

	/**
	 * 预留字段4
	 * 
	 * @return String
	 */
	public String getSpare_field4() {
		return ((String) getAttrVal("Spare_field4"));
	}

	/**
	 * 预留字段4
	 * 
	 * @param Spare_field4
	 */
	public void setSpare_field4(String Spare_field4) {
		setAttrVal("Spare_field4", Spare_field4);
	}

	/**
	 * 预留字段5
	 * 
	 * @return String
	 */
	public String getSpare_field5() {
		return ((String) getAttrVal("Spare_field5"));
	}

	/**
	 * 预留字段5
	 * 
	 * @param Spare_field5
	 */
	public void setSpare_field5(String Spare_field5) {
		setAttrVal("Spare_field5", Spare_field5);
	}
}
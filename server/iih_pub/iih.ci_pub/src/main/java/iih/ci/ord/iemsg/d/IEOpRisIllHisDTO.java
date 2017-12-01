package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检查病史信息DTO DTO数据 
 * 
 */
public class IEOpRisIllHisDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检查申请就诊主键标识
	 * @return String
	 */
	public String getId_ierisoren() {
		return ((String) getAttrVal("Id_ierisoren"));
	}	
	/**
	 * IE检查申请就诊主键标识
	 * @param Id_ierisoren
	 */
	public void setId_ierisoren(String Id_ierisoren) {
		setAttrVal("Id_ierisoren", Id_ierisoren);
	}
	/**
	 * IE检查病史主键标识
	 * @return String
	 */
	public String getId_ierisillhis() {
		return ((String) getAttrVal("Id_ierisillhis"));
	}	
	/**
	 * IE检查病史主键标识
	 * @param Id_ierisillhis
	 */
	public void setId_ierisillhis(String Id_ierisillhis) {
		setAttrVal("Id_ierisillhis", Id_ierisillhis);
	}
	/**
	 * 既往史编码
	 * @return String
	 */
	public String getAnamnesis_code() {
		return ((String) getAttrVal("Anamnesis_code"));
	}	
	/**
	 * 既往史编码
	 * @param Anamnesis_code
	 */
	public void setAnamnesis_code(String Anamnesis_code) {
		setAttrVal("Anamnesis_code", Anamnesis_code);
	}
	/**
	 * 既往史疾病编码
	 * @return String
	 */
	public String getAnamnesis_disease_code() {
		return ((String) getAttrVal("Anamnesis_disease_code"));
	}	
	/**
	 * 既往史疾病编码
	 * @param Anamnesis_disease_code
	 */
	public void setAnamnesis_disease_code(String Anamnesis_disease_code) {
		setAttrVal("Anamnesis_disease_code", Anamnesis_disease_code);
	}
	/**
	 * 既往史疾病名称
	 * @return String
	 */
	public String getAnamnesis_content() {
		return ((String) getAttrVal("Anamnesis_content"));
	}	
	/**
	 * 既往史疾病名称
	 * @param Anamnesis_content
	 */
	public void setAnamnesis_content(String Anamnesis_content) {
		setAttrVal("Anamnesis_content", Anamnesis_content);
	}
}
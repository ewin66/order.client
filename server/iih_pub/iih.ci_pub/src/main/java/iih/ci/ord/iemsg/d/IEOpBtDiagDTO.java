package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊输血诊断信息DTO DTO数据 
 * 
 */
public class IEOpBtDiagDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE输血诊断主键标识
	 * @return String
	 */
	public String getId_iebtdiag() {
		return ((String) getAttrVal("Id_iebtdiag"));
	}	
	/**
	 * IE输血诊断主键标识
	 * @param Id_iebtdiag
	 */
	public void setId_iebtdiag(String Id_iebtdiag) {
		setAttrVal("Id_iebtdiag", Id_iebtdiag);
	}
	/**
	 * IE输血申请
	 * @return String
	 */
	public String getId_iebtoren() {
		return ((String) getAttrVal("Id_iebtoren"));
	}	
	/**
	 * IE输血申请
	 * @param Id_iebtoren
	 */
	public void setId_iebtoren(String Id_iebtoren) {
		setAttrVal("Id_iebtoren", Id_iebtoren);
	}
	/**
	 * 诊断类别编码
	 * @return String
	 */
	public String getDiagnosecode() {
		return ((String) getAttrVal("Diagnosecode"));
	}	
	/**
	 * 诊断类别编码
	 * @param Diagnosecode
	 */
	public void setDiagnosecode(String Diagnosecode) {
		setAttrVal("Diagnosecode", Diagnosecode);
	}
	/**
	 * 诊断类别名称
	 * @return String
	 */
	public String getDiagnosename() {
		return ((String) getAttrVal("Diagnosename"));
	}	
	/**
	 * 诊断类别名称
	 * @param Diagnosename
	 */
	public void setDiagnosename(String Diagnosename) {
		setAttrVal("Diagnosename", Diagnosename);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getDiseasecode() {
		return ((String) getAttrVal("Diseasecode"));
	}	
	/**
	 * 疾病编码
	 * @param Diseasecode
	 */
	public void setDiseasecode(String Diseasecode) {
		setAttrVal("Diseasecode", Diseasecode);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getDiseasename() {
		return ((String) getAttrVal("Diseasename"));
	}	
	/**
	 * 疾病名称
	 * @param Diseasename
	 */
	public void setDiseasename(String Diseasename) {
		setAttrVal("Diseasename", Diseasename);
	}
}
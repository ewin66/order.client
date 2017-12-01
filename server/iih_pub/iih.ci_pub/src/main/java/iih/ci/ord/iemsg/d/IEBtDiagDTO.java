package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE输血诊断信息DTO DTO数据 
 * 
 */
public class IEBtDiagDTO extends BaseDTO {
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
	public String getDiagcode() {
		return ((String) getAttrVal("Diagcode"));
	}	
	/**
	 * 诊断类别编码
	 * @param Diagcode
	 */
	public void setDiagcode(String Diagcode) {
		setAttrVal("Diagcode", Diagcode);
	}
	/**
	 * 诊断类别名称
	 * @return String
	 */
	public String getDiagname() {
		return ((String) getAttrVal("Diagname"));
	}	
	/**
	 * 诊断类别名称
	 * @param Diagname
	 */
	public void setDiagname(String Diagname) {
		setAttrVal("Diagname", Diagname);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getJbcode() {
		return ((String) getAttrVal("Jbcode"));
	}	
	/**
	 * 疾病编码
	 * @param Jbcode
	 */
	public void setJbcode(String Jbcode) {
		setAttrVal("Jbcode", Jbcode);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getJbname() {
		return ((String) getAttrVal("Jbname"));
	}	
	/**
	 * 疾病名称
	 * @param Jbname
	 */
	public void setJbname(String Jbname) {
		setAttrVal("Jbname", Jbname);
	}
}
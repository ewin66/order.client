package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE就诊主要诊断DTO DTO数据 
 * 
 */
public class IEPvMainDiagDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ie就诊主诊断主键标识
	 * @return String
	 */
	public String getId_iepvmaindiag() {
		return ((String) getAttrVal("Id_iepvmaindiag"));
	}	
	/**
	 * ie就诊主诊断主键标识
	 * @param Id_iepvmaindiag
	 */
	public void setId_iepvmaindiag(String Id_iepvmaindiag) {
		setAttrVal("Id_iepvmaindiag", Id_iepvmaindiag);
	}
	/**
	 * ie就诊次要诊断集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIepvseconddiags() {
		return ((FArrayList2) getAttrVal("Iepvseconddiags"));
	}	
	/**
	 * ie就诊次要诊断集合
	 * @param Iepvseconddiags
	 */
	public void setIepvseconddiags(FArrayList2 Iepvseconddiags) {
		setAttrVal("Iepvseconddiags", Iepvseconddiags);
	}
	/**
	 * IE诊断就诊信息主键标识
	 * @return String
	 */
	public String getId_iepvdiagen() {
		return ((String) getAttrVal("Id_iepvdiagen"));
	}	
	/**
	 * IE诊断就诊信息主键标识
	 * @param Id_iepvdiagen
	 */
	public void setId_iepvdiagen(String Id_iepvdiagen) {
		setAttrVal("Id_iepvdiagen", Id_iepvdiagen);
	}
	/**
	 * 诊断号
	 * @return String
	 */
	public String getDiagno() {
		return ((String) getAttrVal("Diagno"));
	}	
	/**
	 * 诊断号
	 * @param Diagno
	 */
	public void setDiagno(String Diagno) {
		setAttrVal("Diagno", Diagno);
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
	 * 是否待查
	 * @return String
	 */
	public String getUnconfirm() {
		return ((String) getAttrVal("Unconfirm"));
	}	
	/**
	 * 是否待查
	 * @param Unconfirm
	 */
	public void setUnconfirm(String Unconfirm) {
		setAttrVal("Unconfirm", Unconfirm);
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
	/**
	 * 诊断时间
	 * @return String
	 */
	public String getDiagtime() {
		return ((String) getAttrVal("Diagtime"));
	}	
	/**
	 * 诊断时间
	 * @param Diagtime
	 */
	public void setDiagtime(String Diagtime) {
		setAttrVal("Diagtime", Diagtime);
	}
	/**
	 * 诊断医生编码
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}	
	/**
	 * 诊断医生编码
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 诊断医生名称
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}	
	/**
	 * 诊断医生名称
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 诊断科室编码
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	/**
	 * 诊断科室编码
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 诊断科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 诊断科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 是否传染
	 * @return String
	 */
	public String getInflectable() {
		return ((String) getAttrVal("Inflectable"));
	}	
	/**
	 * 是否传染
	 * @param Inflectable
	 */
	public void setInflectable(String Inflectable) {
		setAttrVal("Inflectable", Inflectable);
	}
}
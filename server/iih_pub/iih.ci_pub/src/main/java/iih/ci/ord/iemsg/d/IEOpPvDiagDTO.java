package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊就诊诊断DTO DTO数据 
 * 
 */
public class IEOpPvDiagDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ie门诊就诊诊断主键标识
	 * @return String
	 */
	public String getId_ieoppvmaindiag() {
		return ((String) getAttrVal("Id_ieoppvmaindiag"));
	}	
	/**
	 * ie门诊就诊诊断主键标识
	 * @param Id_ieoppvmaindiag
	 */
	public void setId_ieoppvmaindiag(String Id_ieoppvmaindiag) {
		setAttrVal("Id_ieoppvmaindiag", Id_ieoppvmaindiag);
	}
	/**
	 * IE门诊诊断就诊信息主键标识
	 * @return String
	 */
	public String getId_ieoppvdiagen() {
		return ((String) getAttrVal("Id_ieoppvdiagen"));
	}	
	/**
	 * IE门诊诊断就诊信息主键标识
	 * @param Id_ieoppvdiagen
	 */
	public void setId_ieoppvdiagen(String Id_ieoppvdiagen) {
		setAttrVal("Id_ieoppvdiagen", Id_ieoppvdiagen);
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
	/**
	 * 是否主诊断
	 * @return String
	 */
	public String getMain_flag() {
		return ((String) getAttrVal("Main_flag"));
	}	
	/**
	 * 是否主诊断
	 * @param Main_flag
	 */
	public void setMain_flag(String Main_flag) {
		setAttrVal("Main_flag", Main_flag);
	}
	/**
	 * EMR系统诊断类别编码
	 * @return String
	 */
	public String getEmrtpcode() {
		return ((String) getAttrVal("Emrtpcode"));
	}	
	/**
	 * EMR系统诊断类别编码
	 * @param Emrtpcode
	 */
	public void setEmrtpcode(String Emrtpcode) {
		setAttrVal("Emrtpcode", Emrtpcode);
	}
	/**
	 * EMR系统诊断类别名称
	 * @return String
	 */
	public String getEmrtpname() {
		return ((String) getAttrVal("Emrtpname"));
	}	
	/**
	 * EMR系统诊断类别名称
	 * @param Emrtpname
	 */
	public void setEmrtpname(String Emrtpname) {
		setAttrVal("Emrtpname", Emrtpname);
	}
}
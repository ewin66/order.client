package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊药品处方信息DTO DTO数据 
 * 
 */
public class IEOpPharmPresDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE药品处方主键标识
	 * @return String
	 */
	public String getId_iepharmpres() {
		return ((String) getAttrVal("Id_iepharmpres"));
	}	
	/**
	 * IE药品处方主键标识
	 * @param Id_iepharmpres
	 */
	public void setId_iepharmpres(String Id_iepharmpres) {
		setAttrVal("Id_iepharmpres", Id_iepharmpres);
	}
	/**
	 * IE药品医嘱就诊主键标识
	 * @return String
	 */
	public String getId_iepharmoren() {
		return ((String) getAttrVal("Id_iepharmoren"));
	}	
	/**
	 * IE药品医嘱就诊主键标识
	 * @param Id_iepharmoren
	 */
	public void setId_iepharmoren(String Id_iepharmoren) {
		setAttrVal("Id_iepharmoren", Id_iepharmoren);
	}
	/**
	 * IE草药医嘱集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_iepharmors() {
		return ((FArrayList2) getAttrVal("Id_iepharmors"));
	}	
	/**
	 * IE草药医嘱集合
	 * @param Id_iepharmors
	 */
	public void setId_iepharmors(FArrayList2 Id_iepharmors) {
		setAttrVal("Id_iepharmors", Id_iepharmors);
	}
	/**
	 * IE西成药医嘱集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_iepharmwcors() {
		return ((FArrayList2) getAttrVal("Id_iepharmwcors"));
	}	
	/**
	 * IE西成药医嘱集合
	 * @param Id_iepharmwcors
	 */
	public void setId_iepharmwcors(FArrayList2 Id_iepharmwcors) {
		setAttrVal("Id_iepharmwcors", Id_iepharmwcors);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}	
	/**
	 * 处方号
	 * @param Orderno
	 */
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	/**
	 * 处方类别编码
	 * @return String
	 */
	public String getOrdertypecode() {
		return ((String) getAttrVal("Ordertypecode"));
	}	
	/**
	 * 处方类别编码
	 * @param Ordertypecode
	 */
	public void setOrdertypecode(String Ordertypecode) {
		setAttrVal("Ordertypecode", Ordertypecode);
	}
	/**
	 * 处方类别名称
	 * @return String
	 */
	public String getOrdertypename() {
		return ((String) getAttrVal("Ordertypename"));
	}	
	/**
	 * 处方类别名称
	 * @param Ordertypename
	 */
	public void setOrdertypename(String Ordertypename) {
		setAttrVal("Ordertypename", Ordertypename);
	}
	/**
	 * 开方医生编码
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}	
	/**
	 * 开方医生编码
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 开方医生姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}	
	/**
	 * 开方医生姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 开方时间
	 * @return FDateTime
	 */
	public FDateTime getOrdertime() {
		return ((FDateTime) getAttrVal("Ordertime"));
	}	
	/**
	 * 开方时间
	 * @param Ordertime
	 */
	public void setOrdertime(FDateTime Ordertime) {
		setAttrVal("Ordertime", Ordertime);
	}
	/**
	 * 开方科室编码
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	/**
	 * 开方科室编码
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 开方科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 开方科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 审核医生编码
	 * @return String
	 */
	public String getCheckdoctorcode() {
		return ((String) getAttrVal("Checkdoctorcode"));
	}	
	/**
	 * 审核医生编码
	 * @param Checkdoctorcode
	 */
	public void setCheckdoctorcode(String Checkdoctorcode) {
		setAttrVal("Checkdoctorcode", Checkdoctorcode);
	}
	/**
	 * 审核医生姓名
	 * @return String
	 */
	public String getCheckdoctorname() {
		return ((String) getAttrVal("Checkdoctorname"));
	}	
	/**
	 * 审核医生姓名
	 * @param Checkdoctorname
	 */
	public void setCheckdoctorname(String Checkdoctorname) {
		setAttrVal("Checkdoctorname", Checkdoctorname);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getChecktime() {
		return ((FDateTime) getAttrVal("Checktime"));
	}	
	/**
	 * 审核时间
	 * @param Checktime
	 */
	public void setChecktime(FDateTime Checktime) {
		setAttrVal("Checktime", Checktime);
	}
}
package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;

/**
 * IE门诊诊断就诊信息DTO DTO数据 
 * 
 */
public class IEOpPvDiagEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * ie门诊就诊诊断集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIeoppvmaindiags() {
		return ((FArrayList2) getAttrVal("Ieoppvmaindiags"));
	}	
	/**
	 * ie门诊就诊诊断集合
	 * @param Ieoppvmaindiags
	 */
	public void setIeoppvmaindiags(FArrayList2 Ieoppvmaindiags) {
		setAttrVal("Ieoppvmaindiags", Ieoppvmaindiags);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatientid() {
		return ((String) getAttrVal("Patientid"));
	}	
	/**
	 * 患者ID
	 * @param Patientid
	 */
	public void setPatientid(String Patientid) {
		setAttrVal("Patientid", Patientid);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getP_bar_code() {
		return ((String) getAttrVal("P_bar_code"));
	}	
	/**
	 * 就诊号
	 * @param P_bar_code
	 */
	public void setP_bar_code(String P_bar_code) {
		setAttrVal("P_bar_code", P_bar_code);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getBqcode() {
		return ((String) getAttrVal("Bqcode"));
	}	
	/**
	 * 就诊次数
	 * @param Bqcode
	 */
	public void setBqcode(String Bqcode) {
		setAttrVal("Bqcode", Bqcode);
	}
	/**
	 * 患者姓名 
	 * @return String
	 */
	public String getBqname() {
		return ((String) getAttrVal("Bqname"));
	}	
	/**
	 * 患者姓名 
	 * @param Bqname
	 */
	public void setBqname(String Bqname) {
		setAttrVal("Bqname", Bqname);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getBedno() {
		return ((String) getAttrVal("Bedno"));
	}	
	/**
	 * 科室编码
	 * @param Bedno
	 */
	public void setBedno(String Bedno) {
		setAttrVal("Bedno", Bedno);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 科室名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	/**
	 * 病区编码
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 病区名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}	
	/**
	 * 床位号
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	/**
	 * 医疗机构编码
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHospital_name() {
		return ((String) getAttrVal("Hospital_name"));
	}	
	/**
	 * 医疗机构名称
	 * @param Hospital_name
	 */
	public void setHospital_name(String Hospital_name) {
		setAttrVal("Hospital_name", Hospital_name);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}	
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
}
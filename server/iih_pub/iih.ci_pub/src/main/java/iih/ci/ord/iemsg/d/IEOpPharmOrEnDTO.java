package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊药品医嘱核对确认信息DTO DTO数据 
 * 
 */
public class IEOpPharmOrEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * IE药品处方集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_iepharmpreses() {
		return ((FArrayList2) getAttrVal("Id_iepharmpreses"));
	}	
	/**
	 * IE药品处方集合
	 * @param Id_iepharmpreses
	 */
	public void setId_iepharmpreses(FArrayList2 Id_iepharmpreses) {
		setAttrVal("Id_iepharmpreses", Id_iepharmpreses);
	}
	/**
	 * 药品已收费集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIepharmfees() {
		return ((FArrayList2) getAttrVal("Iepharmfees"));
	}	
	/**
	 * 药品已收费集合
	 * @param Iepharmfees
	 */
	public void setIepharmfees(FArrayList2 Iepharmfees) {
		setAttrVal("Iepharmfees", Iepharmfees);
	}
	/**
	 * 域Id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}	
	/**
	 * 域Id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
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
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}	
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 就诊科室编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	/**
	 * 就诊科室编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 就诊科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 就诊科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatientname() {
		return ((String) getAttrVal("Patientname"));
	}	
	/**
	 * 患者姓名
	 * @param Patientname
	 */
	public void setPatientname(String Patientname) {
		setAttrVal("Patientname", Patientname);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	/**
	 * 性别编码
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthday() {
		return ((FDate) getAttrVal("Birthday"));
	}	
	/**
	 * 出生日期
	 * @param Birthday
	 */
	public void setBirthday(FDate Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 与患者关系编码
	 * @return String
	 */
	public String getRelationcode() {
		return ((String) getAttrVal("Relationcode"));
	}	
	/**
	 * 与患者关系编码
	 * @param Relationcode
	 */
	public void setRelationcode(String Relationcode) {
		setAttrVal("Relationcode", Relationcode);
	}
	/**
	 * 代办人身份证号
	 * @return String
	 */
	public String getDbsocialid() {
		return ((String) getAttrVal("Dbsocialid"));
	}	
	/**
	 * 代办人身份证号
	 * @param Dbsocialid
	 */
	public void setDbsocialid(String Dbsocialid) {
		setAttrVal("Dbsocialid", Dbsocialid);
	}
	/**
	 * 代办人姓名
	 * @return String
	 */
	public String getDbname() {
		return ((String) getAttrVal("Dbname"));
	}	
	/**
	 * 代办人姓名
	 * @param Dbname
	 */
	public void setDbname(String Dbname) {
		setAttrVal("Dbname", Dbname);
	}
	/**
	 * 病人身份编码
	 * @return String
	 */
	public String getResponsetypecode() {
		return ((String) getAttrVal("Responsetypecode"));
	}	
	/**
	 * 病人身份编码
	 * @param Responsetypecode
	 */
	public void setResponsetypecode(String Responsetypecode) {
		setAttrVal("Responsetypecode", Responsetypecode);
	}
	/**
	 * 病人身份名称
	 * @return String
	 */
	public String getResponsetypename() {
		return ((String) getAttrVal("Responsetypename"));
	}	
	/**
	 * 病人身份名称
	 * @param Responsetypename
	 */
	public void setResponsetypename(String Responsetypename) {
		setAttrVal("Responsetypename", Responsetypename);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}	
	/**
	 * 医疗机构编码
	 * @param Orgcode
	 */
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}	
	/**
	 * 医疗机构名称
	 * @param Orgname
	 */
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	/**
	 * 保险类别编码
	 * @return String
	 */
	public String getInsurrancecode() {
		return ((String) getAttrVal("Insurrancecode"));
	}	
	/**
	 * 保险类别编码
	 * @param Insurrancecode
	 */
	public void setInsurrancecode(String Insurrancecode) {
		setAttrVal("Insurrancecode", Insurrancecode);
	}
	/**
	 * 保险类别名称
	 * @return String
	 */
	public String getInsurrancetype() {
		return ((String) getAttrVal("Insurrancetype"));
	}	
	/**
	 * 保险类别名称
	 * @param Insurrancetype
	 */
	public void setInsurrancetype(String Insurrancetype) {
		setAttrVal("Insurrancetype", Insurrancetype);
	}
	/**
	 * 保险机构号
	 * @return String
	 */
	public String getInsurranceno() {
		return ((String) getAttrVal("Insurranceno"));
	}	
	/**
	 * 保险机构号
	 * @param Insurranceno
	 */
	public void setInsurranceno(String Insurranceno) {
		setAttrVal("Insurranceno", Insurranceno);
	}
}
package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE检验申请就诊信息DTO DTO数据 
 * 
 */
public class IELisOrEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检验申请就诊主键标识
	 * @return String
	 */
	public String getId_ielisoren() {
		return ((String) getAttrVal("Id_ielisoren"));
	}	
	/**
	 * IE检验申请就诊主键标识
	 * @param Id_ielisoren
	 */
	public void setId_ielisoren(String Id_ielisoren) {
		setAttrVal("Id_ielisoren", Id_ielisoren);
	}
	/**
	 * IE检验申请集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_ielisors() {
		return ((FArrayList2) getAttrVal("Id_ielisors"));
	}	
	/**
	 * IE检验申请集合
	 * @param Id_ielisors
	 */
	public void setId_ielisors(FArrayList2 Id_ielisors) {
		setAttrVal("Id_ielisors", Id_ielisors);
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
	public String getPatientseqnum() {
		return ((String) getAttrVal("Patientseqnum"));
	}	
	/**
	 * 就诊号
	 * @param Patientseqnum
	 */
	public void setPatientseqnum(String Patientseqnum) {
		setAttrVal("Patientseqnum", Patientseqnum);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getWardcode() {
		return ((String) getAttrVal("Wardcode"));
	}	
	/**
	 * 病区编码
	 * @param Wardcode
	 */
	public void setWardcode(String Wardcode) {
		setAttrVal("Wardcode", Wardcode);
	}
	/**
	 * 病区名
	 * @return String
	 */
	public String getWardname() {
		return ((String) getAttrVal("Wardname"));
	}	
	/**
	 * 病区名
	 * @param Wardname
	 */
	public void setWardname(String Wardname) {
		setAttrVal("Wardname", Wardname);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBedcode() {
		return ((String) getAttrVal("Bedcode"));
	}	
	/**
	 * 床号
	 * @param Bedcode
	 */
	public void setBedcode(String Bedcode) {
		setAttrVal("Bedcode", Bedcode);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}	
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTelephone() {
		return ((String) getAttrVal("Telephone"));
	}	
	/**
	 * 联系电话
	 * @param Telephone
	 */
	public void setTelephone(String Telephone) {
		setAttrVal("Telephone", Telephone);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别代码
	 * @return String
	 */
	public String getSexid() {
		return ((String) getAttrVal("Sexid"));
	}	
	/**
	 * 性别代码
	 * @param Sexid
	 */
	public void setSexid(String Sexid) {
		setAttrVal("Sexid", Sexid);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthdaydate() {
		return ((FDate) getAttrVal("Birthdaydate"));
	}	
	/**
	 * 出生日期
	 * @param Birthdaydate
	 */
	public void setBirthdaydate(FDate Birthdaydate) {
		setAttrVal("Birthdaydate", Birthdaydate);
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
	 * 家庭住址
	 * @return String
	 */
	public String getHomeaddress() {
		return ((String) getAttrVal("Homeaddress"));
	}	
	/**
	 * 家庭住址
	 * @param Homeaddress
	 */
	public void setHomeaddress(String Homeaddress) {
		setAttrVal("Homeaddress", Homeaddress);
	}
	/**
	 * 邮政编码
	 * @return String
	 */
	public String getPostal() {
		return ((String) getAttrVal("Postal"));
	}	
	/**
	 * 邮政编码
	 * @param Postal
	 */
	public void setPostal(String Postal) {
		setAttrVal("Postal", Postal);
	}
	/**
	 * 医疗机构代码
	 * @return String
	 */
	public String getHospitalid() {
		return ((String) getAttrVal("Hospitalid"));
	}	
	/**
	 * 医疗机构代码
	 * @param Hospitalid
	 */
	public void setHospitalid(String Hospitalid) {
		setAttrVal("Hospitalid", Hospitalid);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHospitalname() {
		return ((String) getAttrVal("Hospitalname"));
	}	
	/**
	 * 医疗机构名称
	 * @param Hospitalname
	 */
	public void setHospitalname(String Hospitalname) {
		setAttrVal("Hospitalname", Hospitalname);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getConfirm_date() {
		return ((FDateTime) getAttrVal("Confirm_date"));
	}	
	/**
	 * 确认时间
	 * @param Confirm_date
	 */
	public void setConfirm_date(FDateTime Confirm_date) {
		setAttrVal("Confirm_date", Confirm_date);
	}
	/**
	 * 确认人编码
	 * @return String
	 */
	public String getConfirm_nurse_code() {
		return ((String) getAttrVal("Confirm_nurse_code"));
	}	
	/**
	 * 确认人编码
	 * @param Confirm_nurse_code
	 */
	public void setConfirm_nurse_code(String Confirm_nurse_code) {
		setAttrVal("Confirm_nurse_code", Confirm_nurse_code);
	}
	/**
	 * 确认人姓名
	 * @return String
	 */
	public String getConfirm_nurse_name() {
		return ((String) getAttrVal("Confirm_nurse_name"));
	}	
	/**
	 * 确认人姓名
	 * @param Confirm_nurse_name
	 */
	public void setConfirm_nurse_name(String Confirm_nurse_name) {
		setAttrVal("Confirm_nurse_name", Confirm_nurse_name);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getAdmiss_times() {
		return ((String) getAttrVal("Admiss_times"));
	}	
	/**
	 * 就诊次数
	 * @param Admiss_times
	 */
	public void setAdmiss_times(String Admiss_times) {
		setAttrVal("Admiss_times", Admiss_times);
	}
	/**
	 * 就诊类别
	 * @return String
	 */
	public String getAdmiss_type() {
		return ((String) getAttrVal("Admiss_type"));
	}	
	/**
	 * 就诊类别
	 * @param Admiss_type
	 */
	public void setAdmiss_type(String Admiss_type) {
		setAttrVal("Admiss_type", Admiss_type);
	}
	/**
	 * 就诊类别名称
	 * @return String
	 */
	public String getAdmiss_typename() {
		return ((String) getAttrVal("Admiss_typename"));
	}	
	/**
	 * 就诊类别名称
	 * @param Admiss_typename
	 */
	public void setAdmiss_typename(String Admiss_typename) {
		setAttrVal("Admiss_typename", Admiss_typename);
	}
	/**
	 * 工作单位代码
	 * @return String
	 */
	public String getWorkunitcode() {
		return ((String) getAttrVal("Workunitcode"));
	}	
	/**
	 * 工作单位代码
	 * @param Workunitcode
	 */
	public void setWorkunitcode(String Workunitcode) {
		setAttrVal("Workunitcode", Workunitcode);
	}
	/**
	 * 工作单位名称
	 * @return String
	 */
	public String getWorkunitname() {
		return ((String) getAttrVal("Workunitname"));
	}	
	/**
	 * 工作单位名称
	 * @param Workunitname
	 */
	public void setWorkunitname(String Workunitname) {
		setAttrVal("Workunitname", Workunitname);
	}
	/**
	 * 开单时间
	 * @return FDateTime
	 */
	public FDateTime getOrderdatetime() {
		return ((FDateTime) getAttrVal("Orderdatetime"));
	}	
	/**
	 * 开单时间
	 * @param Orderdatetime
	 */
	public void setOrderdatetime(FDateTime Orderdatetime) {
		setAttrVal("Orderdatetime", Orderdatetime);
	}
	/**
	 * 开单医生编码
	 * @return String
	 */
	public String getOrderbyid() {
		return ((String) getAttrVal("Orderbyid"));
	}	
	/**
	 * 开单医生编码
	 * @param Orderbyid
	 */
	public void setOrderbyid(String Orderbyid) {
		setAttrVal("Orderbyid", Orderbyid);
	}
	/**
	 * 开单医生姓名
	 * @return String
	 */
	public String getOrderbyname() {
		return ((String) getAttrVal("Orderbyname"));
	}	
	/**
	 * 开单医生姓名
	 * @param Orderbyname
	 */
	public void setOrderbyname(String Orderbyname) {
		setAttrVal("Orderbyname", Orderbyname);
	}
	/**
	 * 申请科室编码
	 * @return String
	 */
	public String getLocationid() {
		return ((String) getAttrVal("Locationid"));
	}	
	/**
	 * 申请科室编码
	 * @param Locationid
	 */
	public void setLocationid(String Locationid) {
		setAttrVal("Locationid", Locationid);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getLocationname() {
		return ((String) getAttrVal("Locationname"));
	}	
	/**
	 * 申请科室名称
	 * @param Locationname
	 */
	public void setLocationname(String Locationname) {
		setAttrVal("Locationname", Locationname);
	}
	/**
	 * 诊断类别
	 * @return String
	 */
	public String getDiag_type() {
		return ((String) getAttrVal("Diag_type"));
	}	
	/**
	 * 诊断类别
	 * @param Diag_type
	 */
	public void setDiag_type(String Diag_type) {
		setAttrVal("Diag_type", Diag_type);
	}
	/**
	 * 疾病代码
	 * @return String
	 */
	public String getDiag_code() {
		return ((String) getAttrVal("Diag_code"));
	}	
	/**
	 * 疾病代码
	 * @param Diag_code
	 */
	public void setDiag_code(String Diag_code) {
		setAttrVal("Diag_code", Diag_code);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getDiag_name() {
		return ((String) getAttrVal("Diag_name"));
	}	
	/**
	 * 疾病名称
	 * @param Diag_name
	 */
	public void setDiag_name(String Diag_name) {
		setAttrVal("Diag_name", Diag_name);
	}
	/**
	 * 录入日期开始时间
	 * @return FDateTime
	 */
	public FDateTime getEnterdatetime_start() {
		return ((FDateTime) getAttrVal("Enterdatetime_start"));
	}	
	/**
	 * 录入日期开始时间
	 * @param Enterdatetime_start
	 */
	public void setEnterdatetime_start(FDateTime Enterdatetime_start) {
		setAttrVal("Enterdatetime_start", Enterdatetime_start);
	}
	/**
	 * 录入日期结束时间
	 * @return FDateTime
	 */
	public FDateTime getEnterdatetime_end() {
		return ((FDateTime) getAttrVal("Enterdatetime_end"));
	}	
	/**
	 * 录入日期结束时间
	 * @param Enterdatetime_end
	 */
	public void setEnterdatetime_end(FDateTime Enterdatetime_end) {
		setAttrVal("Enterdatetime_end", Enterdatetime_end);
	}
	/**
	 * 录入人
	 * @return String
	 */
	public String getEnterbyid() {
		return ((String) getAttrVal("Enterbyid"));
	}	
	/**
	 * 录入人
	 * @param Enterbyid
	 */
	public void setEnterbyid(String Enterbyid) {
		setAttrVal("Enterbyid", Enterbyid);
	}
	/**
	 * 录入人姓名
	 * @return String
	 */
	public String getEnterbyname() {
		return ((String) getAttrVal("Enterbyname"));
	}	
	/**
	 * 录入人姓名
	 * @param Enterbyname
	 */
	public void setEnterbyname(String Enterbyname) {
		setAttrVal("Enterbyname", Enterbyname);
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
	/**
	 * 病人科室编码
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	/**
	 * 病人科室编码
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 病人科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
}
package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE手术申请信息DTO DTO数据 
 * 
 */
public class IEOpOrEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE手术申请就诊主键标识
	 * @return String
	 */
	public String getId_ieoporen() {
		return ((String) getAttrVal("Id_ieoporen"));
	}	
	/**
	 * IE手术申请就诊主键标识
	 * @param Id_ieoporen
	 */
	public void setId_ieoporen(String Id_ieoporen) {
		setAttrVal("Id_ieoporen", Id_ieoporen);
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
	 * 性别编码
	 * @return String
	 */
	public String getSexid() {
		return ((String) getAttrVal("Sexid"));
	}	
	/**
	 * 性别编码
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
	 * 派生年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 派生年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
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
	 * 电话
	 * @return String
	 */
	public String getTelephone() {
		return ((String) getAttrVal("Telephone"));
	}	
	/**
	 * 电话
	 * @param Telephone
	 */
	public void setTelephone(String Telephone) {
		setAttrVal("Telephone", Telephone);
	}
	/**
	 * 地址
	 * @return String
	 */
	public String getHomeaddress() {
		return ((String) getAttrVal("Homeaddress"));
	}	
	/**
	 * 地址
	 * @param Homeaddress
	 */
	public void setHomeaddress(String Homeaddress) {
		setAttrVal("Homeaddress", Homeaddress);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getYbcode() {
		return ((String) getAttrVal("Ybcode"));
	}	
	/**
	 * 医保号
	 * @param Ybcode
	 */
	public void setYbcode(String Ybcode) {
		setAttrVal("Ybcode", Ybcode);
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
	 * 医疗机构代码
	 * @return String
	 */
	public String getHos_code() {
		return ((String) getAttrVal("Hos_code"));
	}	
	/**
	 * 医疗机构代码
	 * @param Hos_code
	 */
	public void setHos_code(String Hos_code) {
		setAttrVal("Hos_code", Hos_code);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHos_name() {
		return ((String) getAttrVal("Hos_name"));
	}	
	/**
	 * 医疗机构名称
	 * @param Hos_name
	 */
	public void setHos_name(String Hos_name) {
		setAttrVal("Hos_name", Hos_name);
	}
	/**
	 * 审核日期
	 * @return FDateTime
	 */
	public FDateTime getConfirm_date() {
		return ((FDateTime) getAttrVal("Confirm_date"));
	}	
	/**
	 * 审核日期
	 * @param Confirm_date
	 */
	public void setConfirm_date(FDateTime Confirm_date) {
		setAttrVal("Confirm_date", Confirm_date);
	}
	/**
	 * 审核人编码
	 * @return String
	 */
	public String getConfirm_nurse_code() {
		return ((String) getAttrVal("Confirm_nurse_code"));
	}	
	/**
	 * 审核人编码
	 * @param Confirm_nurse_code
	 */
	public void setConfirm_nurse_code(String Confirm_nurse_code) {
		setAttrVal("Confirm_nurse_code", Confirm_nurse_code);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getConfirm_nurse_name() {
		return ((String) getAttrVal("Confirm_nurse_name"));
	}	
	/**
	 * 审核人姓名
	 * @param Confirm_nurse_name
	 */
	public void setConfirm_nurse_name(String Confirm_nurse_name) {
		setAttrVal("Confirm_nurse_name", Confirm_nurse_name);
	}
	/**
	 * 申请医师编码
	 * @return String
	 */
	public String getOrderbyid() {
		return ((String) getAttrVal("Orderbyid"));
	}	
	/**
	 * 申请医师编码
	 * @param Orderbyid
	 */
	public void setOrderbyid(String Orderbyid) {
		setAttrVal("Orderbyid", Orderbyid);
	}
	/**
	 * 申请医师
	 * @return String
	 */
	public String getOrderbyname() {
		return ((String) getAttrVal("Orderbyname"));
	}	
	/**
	 * 申请医师
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
	 * 就诊（住院）日期
	 * @return FDateTime
	 */
	public FDateTime getVisit_date() {
		return ((FDateTime) getAttrVal("Visit_date"));
	}	
	/**
	 * 就诊（住院）日期
	 * @param Visit_date
	 */
	public void setVisit_date(FDateTime Visit_date) {
		setAttrVal("Visit_date", Visit_date);
	}
	/**
	 * 预定手术时间
	 * @return String
	 */
	public String getOp_datetime() {
		return ((String) getAttrVal("Op_datetime"));
	}	
	/**
	 * 预定手术时间
	 * @param Op_datetime
	 */
	public void setOp_datetime(String Op_datetime) {
		setAttrVal("Op_datetime", Op_datetime);
	}
	/**
	 * 主治医师编码
	 * @return String
	 */
	public String getOp_doctor() {
		return ((String) getAttrVal("Op_doctor"));
	}	
	/**
	 * 主治医师编码
	 * @param Op_doctor
	 */
	public void setOp_doctor(String Op_doctor) {
		setAttrVal("Op_doctor", Op_doctor);
	}
	/**
	 * 主治医师姓名
	 * @return String
	 */
	public String getOp_doctor_name() {
		return ((String) getAttrVal("Op_doctor_name"));
	}	
	/**
	 * 主治医师姓名
	 * @param Op_doctor_name
	 */
	public void setOp_doctor_name(String Op_doctor_name) {
		setAttrVal("Op_doctor_name", Op_doctor_name);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExec_code() {
		return ((String) getAttrVal("Exec_code"));
	}	
	/**
	 * 执行科室编码
	 * @param Exec_code
	 */
	public void setExec_code(String Exec_code) {
		setAttrVal("Exec_code", Exec_code);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getExec_code_name() {
		return ((String) getAttrVal("Exec_code_name"));
	}	
	/**
	 * 执行科室
	 * @param Exec_code_name
	 */
	public void setExec_code_name(String Exec_code_name) {
		setAttrVal("Exec_code_name", Exec_code_name);
	}
	/**
	 * 是否皮试
	 * @return String
	 */
	public String getIsstest() {
		return ((String) getAttrVal("Isstest"));
	}	
	/**
	 * 是否皮试
	 * @param Isstest
	 */
	public void setIsstest(String Isstest) {
		setAttrVal("Isstest", Isstest);
	}
	/**
	 * 是否皮试结果
	 * @return String
	 */
	public String getStest() {
		return ((String) getAttrVal("Stest"));
	}	
	/**
	 * 是否皮试结果
	 * @param Stest
	 */
	public void setStest(String Stest) {
		setAttrVal("Stest", Stest);
	}
	/**
	 * 是否加急
	 * @return String
	 */
	public String getIs_em() {
		return ((String) getAttrVal("Is_em"));
	}	
	/**
	 * 是否加急
	 * @param Is_em
	 */
	public void setIs_em(String Is_em) {
		setAttrVal("Is_em", Is_em);
	}
	/**
	 * 是否加急结果
	 * @return String
	 */
	public String getIs_em_r() {
		return ((String) getAttrVal("Is_em_r"));
	}	
	/**
	 * 是否加急结果
	 * @param Is_em_r
	 */
	public void setIs_em_r(String Is_em_r) {
		setAttrVal("Is_em_r", Is_em_r);
	}
	/**
	 * 是否药观
	 * @return String
	 */
	public String getIsyg() {
		return ((String) getAttrVal("Isyg"));
	}	
	/**
	 * 是否药观
	 * @param Isyg
	 */
	public void setIsyg(String Isyg) {
		setAttrVal("Isyg", Isyg);
	}
	/**
	 * 是否药观结果
	 * @return String
	 */
	public String getYg() {
		return ((String) getAttrVal("Yg"));
	}	
	/**
	 * 是否药观结果
	 * @param Yg
	 */
	public void setYg(String Yg) {
		setAttrVal("Yg", Yg);
	}
	/**
	 * 是否冰冻
	 * @return String
	 */
	public String getIs_frozen_flag() {
		return ((String) getAttrVal("Is_frozen_flag"));
	}	
	/**
	 * 是否冰冻
	 * @param Is_frozen_flag
	 */
	public void setIs_frozen_flag(String Is_frozen_flag) {
		setAttrVal("Is_frozen_flag", Is_frozen_flag);
	}
	/**
	 * 是否冰冻结果
	 * @return String
	 */
	public String getFrozen_flag() {
		return ((String) getAttrVal("Frozen_flag"));
	}	
	/**
	 * 是否冰冻结果
	 * @param Frozen_flag
	 */
	public void setFrozen_flag(String Frozen_flag) {
		setAttrVal("Frozen_flag", Frozen_flag);
	}
	/**
	 * 是否择期
	 * @return String
	 */
	public String getIs_urgent_select_flag() {
		return ((String) getAttrVal("Is_urgent_select_flag"));
	}	
	/**
	 * 是否择期
	 * @param Is_urgent_select_flag
	 */
	public void setIs_urgent_select_flag(String Is_urgent_select_flag) {
		setAttrVal("Is_urgent_select_flag", Is_urgent_select_flag);
	}
	/**
	 * 是否择期结果
	 * @return String
	 */
	public String getUrgent_select_flag() {
		return ((String) getAttrVal("Urgent_select_flag"));
	}	
	/**
	 * 是否择期结果
	 * @param Urgent_select_flag
	 */
	public void setUrgent_select_flag(String Urgent_select_flag) {
		setAttrVal("Urgent_select_flag", Urgent_select_flag);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getComment1() {
		return ((String) getAttrVal("Comment1"));
	}	
	/**
	 * 注意事项
	 * @param Comment1
	 */
	public void setComment1(String Comment1) {
		setAttrVal("Comment1", Comment1);
	}
	/**
	 * 费用类别编码
	 * @return String
	 */
	public String getResponse_type_code() {
		return ((String) getAttrVal("Response_type_code"));
	}	
	/**
	 * 费用类别编码
	 * @param Response_type_code
	 */
	public void setResponse_type_code(String Response_type_code) {
		setAttrVal("Response_type_code", Response_type_code);
	}
	/**
	 * 费用类别名称
	 * @return String
	 */
	public String getResponse_type_name() {
		return ((String) getAttrVal("Response_type_name"));
	}	
	/**
	 * 费用类别名称
	 * @param Response_type_name
	 */
	public void setResponse_type_name(String Response_type_name) {
		setAttrVal("Response_type_name", Response_type_name);
	}
	/**
	 * 诊断类别编码
	 * @return String
	 */
	public String getDiag_type() {
		return ((String) getAttrVal("Diag_type"));
	}	
	/**
	 * 诊断类别编码
	 * @param Diag_type
	 */
	public void setDiag_type(String Diag_type) {
		setAttrVal("Diag_type", Diag_type);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDiag_type_name() {
		return ((String) getAttrVal("Diag_type_name"));
	}	
	/**
	 * 诊断名称
	 * @param Diag_type_name
	 */
	public void setDiag_type_name(String Diag_type_name) {
		setAttrVal("Diag_type_name", Diag_type_name);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getDiag_code() {
		return ((String) getAttrVal("Diag_code"));
	}	
	/**
	 * 疾病编码
	 * @param Diag_code
	 */
	public void setDiag_code(String Diag_code) {
		setAttrVal("Diag_code", Diag_code);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getDiag_str() {
		return ((String) getAttrVal("Diag_str"));
	}	
	/**
	 * 疾病名称
	 * @param Diag_str
	 */
	public void setDiag_str(String Diag_str) {
		setAttrVal("Diag_str", Diag_str);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getYz_no() {
		return ((String) getAttrVal("Yz_no"));
	}	
	/**
	 * 医嘱号
	 * @param Yz_no
	 */
	public void setYz_no(String Yz_no) {
		setAttrVal("Yz_no", Yz_no);
	}
	/**
	 * 申请单编号
	 * @return String
	 */
	public String getOp_record_id() {
		return ((String) getAttrVal("Op_record_id"));
	}	
	/**
	 * 申请单编号
	 * @param Op_record_id
	 */
	public void setOp_record_id(String Op_record_id) {
		setAttrVal("Op_record_id", Op_record_id);
	}
	/**
	 * 手术名称编码
	 * @return String
	 */
	public String getOp_code() {
		return ((String) getAttrVal("Op_code"));
	}	
	/**
	 * 手术名称编码
	 * @param Op_code
	 */
	public void setOp_code(String Op_code) {
		setAttrVal("Op_code", Op_code);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getOp_code_name() {
		return ((String) getAttrVal("Op_code_name"));
	}	
	/**
	 * 手术名称
	 * @param Op_code_name
	 */
	public void setOp_code_name(String Op_code_name) {
		setAttrVal("Op_code_name", Op_code_name);
	}
	/**
	 * 说明
	 * @return String
	 */
	public String getOp_describe() {
		return ((String) getAttrVal("Op_describe"));
	}	
	/**
	 * 说明
	 * @param Op_describe
	 */
	public void setOp_describe(String Op_describe) {
		setAttrVal("Op_describe", Op_describe);
	}
	/**
	 * 申请日期
	 * @return FDateTime
	 */
	public FDateTime getApply_date() {
		return ((FDateTime) getAttrVal("Apply_date"));
	}	
	/**
	 * 申请日期
	 * @param Apply_date
	 */
	public void setApply_date(FDateTime Apply_date) {
		setAttrVal("Apply_date", Apply_date);
	}
	/**
	 * 手术等级编码
	 * @return String
	 */
	public String getOp_scale() {
		return ((String) getAttrVal("Op_scale"));
	}	
	/**
	 * 手术等级编码
	 * @param Op_scale
	 */
	public void setOp_scale(String Op_scale) {
		setAttrVal("Op_scale", Op_scale);
	}
	/**
	 * 手术等级名称
	 * @return String
	 */
	public String getOp_scale_name() {
		return ((String) getAttrVal("Op_scale_name"));
	}	
	/**
	 * 手术等级名称
	 * @param Op_scale_name
	 */
	public void setOp_scale_name(String Op_scale_name) {
		setAttrVal("Op_scale_name", Op_scale_name);
	}
	/**
	 * 麻醉方式编码
	 * @return String
	 */
	public String getAnaesthesia_method_code() {
		return ((String) getAttrVal("Anaesthesia_method_code"));
	}	
	/**
	 * 麻醉方式编码
	 * @param Anaesthesia_method_code
	 */
	public void setAnaesthesia_method_code(String Anaesthesia_method_code) {
		setAttrVal("Anaesthesia_method_code", Anaesthesia_method_code);
	}
	/**
	 * 麻醉方式名称
	 * @return String
	 */
	public String getAnaesthesia_method_name() {
		return ((String) getAttrVal("Anaesthesia_method_name"));
	}	
	/**
	 * 麻醉方式名称
	 * @param Anaesthesia_method_name
	 */
	public void setAnaesthesia_method_name(String Anaesthesia_method_name) {
		setAttrVal("Anaesthesia_method_name", Anaesthesia_method_name);
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
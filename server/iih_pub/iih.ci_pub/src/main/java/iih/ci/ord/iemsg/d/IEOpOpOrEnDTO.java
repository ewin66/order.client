package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊手术申请信息DTO DTO数据 
 * 
 */
public class IEOpOpOrEnDTO extends BaseDTO {
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
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}	
	/**
	 * 患者ID
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
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
	 * 病区名
	 * @return String
	 */
	public String getWard_code_name() {
		return ((String) getAttrVal("Ward_code_name"));
	}	
	/**
	 * 病区名
	 * @param Ward_code_name
	 */
	public void setWard_code_name(String Ward_code_name) {
		setAttrVal("Ward_code_name", Ward_code_name);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getWard_code() {
		return ((String) getAttrVal("Ward_code"));
	}	
	/**
	 * 病区编码
	 * @param Ward_code
	 */
	public void setWard_code(String Ward_code) {
		setAttrVal("Ward_code", Ward_code);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}	
	/**
	 * 床号
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getSocial_no() {
		return ((String) getAttrVal("Social_no"));
	}	
	/**
	 * 身份证号
	 * @param Social_no
	 */
	public void setSocial_no(String Social_no) {
		setAttrVal("Social_no", Social_no);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getAddition_no1() {
		return ((String) getAttrVal("Addition_no1"));
	}	
	/**
	 * 医保号
	 * @param Addition_no1
	 */
	public void setAddition_no1(String Addition_no1) {
		setAttrVal("Addition_no1", Addition_no1);
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
	 * 电话
	 * @return String
	 */
	public String getHome_tel() {
		return ((String) getAttrVal("Home_tel"));
	}	
	/**
	 * 电话
	 * @param Home_tel
	 */
	public void setHome_tel(String Home_tel) {
		setAttrVal("Home_tel", Home_tel);
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
	 * 地址
	 * @return String
	 */
	public String getHome_street() {
		return ((String) getAttrVal("Home_street"));
	}	
	/**
	 * 地址
	 * @param Home_street
	 */
	public void setHome_street(String Home_street) {
		setAttrVal("Home_street", Home_street);
	}
	/**
	 * 病人科室编码
	 * @return String
	 */
	public String getPatient_dept() {
		return ((String) getAttrVal("Patient_dept"));
	}	
	/**
	 * 病人科室编码
	 * @param Patient_dept
	 */
	public void setPatient_dept(String Patient_dept) {
		setAttrVal("Patient_dept", Patient_dept);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getPatient_dept_name() {
		return ((String) getAttrVal("Patient_dept_name"));
	}	
	/**
	 * 病人科室名称
	 * @param Patient_dept_name
	 */
	public void setPatient_dept_name(String Patient_dept_name) {
		setAttrVal("Patient_dept_name", Patient_dept_name);
	}
	/**
	 * 医疗机构代码
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	/**
	 * 医疗机构代码
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
	 * 预订手术时间
	 * @return FDateTime
	 */
	public FDateTime getOp_datetime() {
		return ((FDateTime) getAttrVal("Op_datetime"));
	}	
	/**
	 * 预订手术时间
	 * @param Op_datetime
	 */
	public void setOp_datetime(FDateTime Op_datetime) {
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
	 * 申请医师编码
	 * @return String
	 */
	public String getApply_user() {
		return ((String) getAttrVal("Apply_user"));
	}	
	/**
	 * 申请医师编码
	 * @param Apply_user
	 */
	public void setApply_user(String Apply_user) {
		setAttrVal("Apply_user", Apply_user);
	}
	/**
	 * 申请医师
	 * @return String
	 */
	public String getApply_user_name() {
		return ((String) getAttrVal("Apply_user_name"));
	}	
	/**
	 * 申请医师
	 * @param Apply_user_name
	 */
	public void setApply_user_name(String Apply_user_name) {
		setAttrVal("Apply_user_name", Apply_user_name);
	}
	/**
	 * 申请科室编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	/**
	 * 申请科室编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getDept_code_name() {
		return ((String) getAttrVal("Dept_code_name"));
	}	
	/**
	 * 申请科室
	 * @param Dept_code_name
	 */
	public void setDept_code_name(String Dept_code_name) {
		setAttrVal("Dept_code_name", Dept_code_name);
	}
	/**
	 * 审核日期
	 * @return FDateTime
	 */
	public FDateTime getCheck_date() {
		return ((FDateTime) getAttrVal("Check_date"));
	}	
	/**
	 * 审核日期
	 * @param Check_date
	 */
	public void setCheck_date(FDateTime Check_date) {
		setAttrVal("Check_date", Check_date);
	}
	/**
	 * 审核人编码
	 * @return String
	 */
	public String getCheck_opera() {
		return ((String) getAttrVal("Check_opera"));
	}	
	/**
	 * 审核人编码
	 * @param Check_opera
	 */
	public void setCheck_opera(String Check_opera) {
		setAttrVal("Check_opera", Check_opera);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getCheck_opera_name() {
		return ((String) getAttrVal("Check_opera_name"));
	}	
	/**
	 * 审核人姓名
	 * @param Check_opera_name
	 */
	public void setCheck_opera_name(String Check_opera_name) {
		setAttrVal("Check_opera_name", Check_opera_name);
	}
	/**
	 * 是否皮试
	 * @return FBoolean
	 */
	public FBoolean getIsstest() {
		return ((FBoolean) getAttrVal("Isstest"));
	}	
	/**
	 * 是否皮试
	 * @param Isstest
	 */
	public void setIsstest(FBoolean Isstest) {
		setAttrVal("Isstest", Isstest);
	}
	/**
	 * 是否皮试结果
	 * @return FBoolean
	 */
	public FBoolean getStest() {
		return ((FBoolean) getAttrVal("Stest"));
	}	
	/**
	 * 是否皮试结果
	 * @param Stest
	 */
	public void setStest(FBoolean Stest) {
		setAttrVal("Stest", Stest);
	}
	/**
	 * 是否加急
	 * @return FBoolean
	 */
	public FBoolean getIs_em() {
		return ((FBoolean) getAttrVal("Is_em"));
	}	
	/**
	 * 是否加急
	 * @param Is_em
	 */
	public void setIs_em(FBoolean Is_em) {
		setAttrVal("Is_em", Is_em);
	}
	/**
	 * 是否加急结果
	 * @return FBoolean
	 */
	public FBoolean getIs_em_r() {
		return ((FBoolean) getAttrVal("Is_em_r"));
	}	
	/**
	 * 是否加急结果
	 * @param Is_em_r
	 */
	public void setIs_em_r(FBoolean Is_em_r) {
		setAttrVal("Is_em_r", Is_em_r);
	}
	/**
	 * 是否冰冻
	 * @return FBoolean
	 */
	public FBoolean getIs_frozen_flag() {
		return ((FBoolean) getAttrVal("Is_frozen_flag"));
	}	
	/**
	 * 是否冰冻
	 * @param Is_frozen_flag
	 */
	public void setIs_frozen_flag(FBoolean Is_frozen_flag) {
		setAttrVal("Is_frozen_flag", Is_frozen_flag);
	}
	/**
	 * 是否冰冻结果
	 * @return FBoolean
	 */
	public FBoolean getFrozen_flag() {
		return ((FBoolean) getAttrVal("Frozen_flag"));
	}	
	/**
	 * 是否冰冻结果
	 * @param Frozen_flag
	 */
	public void setFrozen_flag(FBoolean Frozen_flag) {
		setAttrVal("Frozen_flag", Frozen_flag);
	}
	/**
	 * 是否择期
	 * @return FBoolean
	 */
	public FBoolean getIs_urgent_select_flag() {
		return ((FBoolean) getAttrVal("Is_urgent_select_flag"));
	}	
	/**
	 * 是否择期
	 * @param Is_urgent_select_flag
	 */
	public void setIs_urgent_select_flag(FBoolean Is_urgent_select_flag) {
		setAttrVal("Is_urgent_select_flag", Is_urgent_select_flag);
	}
	/**
	 * 是否择期结果
	 * @return FBoolean
	 */
	public FBoolean getUrgent_select_flag() {
		return ((FBoolean) getAttrVal("Urgent_select_flag"));
	}	
	/**
	 * 是否择期结果
	 * @param Urgent_select_flag
	 */
	public void setUrgent_select_flag(FBoolean Urgent_select_flag) {
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
	 * 就诊次数
	 * @return String
	 */
	public String getAdmit_times() {
		return ((String) getAttrVal("Admit_times"));
	}	
	/**
	 * 就诊次数
	 * @param Admit_times
	 */
	public void setAdmit_times(String Admit_times) {
		setAttrVal("Admit_times", Admit_times);
	}
	/**
	 * 就诊(住院)日期
	 * @return FDateTime
	 */
	public FDateTime getVisit_date() {
		return ((FDateTime) getAttrVal("Visit_date"));
	}	
	/**
	 * 就诊(住院)日期
	 * @param Visit_date
	 */
	public void setVisit_date(FDateTime Visit_date) {
		setAttrVal("Visit_date", Visit_date);
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
	 * 疾病编名称
	 * @return String
	 */
	public String getDiag_str() {
		return ((String) getAttrVal("Diag_str"));
	}	
	/**
	 * 疾病编名称
	 * @param Diag_str
	 */
	public void setDiag_str(String Diag_str) {
		setAttrVal("Diag_str", Diag_str);
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
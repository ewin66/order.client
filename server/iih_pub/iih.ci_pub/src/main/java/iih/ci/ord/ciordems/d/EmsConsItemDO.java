package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 会诊申请单项目 DTO数据 
 * 
 */
public class EmsConsItemDO extends OrCommonFieldsDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断id拼接
	 * @return String
	 */
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}
	/**
	 * 诊断id拼接
	 * @param Str_id_diitm
	 */
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	/**
	 * 诊断名称拼接
	 * @return String
	 */
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}
	/**
	 * 诊断名称拼接
	 * @param Str_name_di
	 */
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	/**
	 * 诊断编码拼接
	 * @return String
	 */
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}
	/**
	 * 诊断编码拼接
	 * @param Str_code_di
	 */
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}
	/**
	 * 诊断子项目id
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}
	/**
	 * 诊断子项目id
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 诊断ID
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 诊断ID
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}
	/**
	 * 诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 主键
	 * @return String
	 */
	public String getId_emsconsitem() {
		return ((String) getAttrVal("Id_emsconsitem"));
	}
	/**
	 * 主键
	 * @param Id_emsconsitem
	 */
	public void setId_emsconsitem(String Id_emsconsitem) {
		setAttrVal("Id_emsconsitem", Id_emsconsitem);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 计划会诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划会诊时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 联系电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 申请地点id
	 * @return String
	 */
	public String getId_place() {
		return ((String) getAttrVal("Id_place"));
	}
	/**
	 * 申请地点id
	 * @param Id_place
	 */
	public void setId_place(String Id_place) {
		setAttrVal("Id_place", Id_place);
	}
	/**
	 * 申请地点名称
	 * @return String
	 */
	public String getName_place() {
		return ((String) getAttrVal("Name_place"));
	}
	/**
	 * 申请地点名称
	 * @param Name_place
	 */
	public void setName_place(String Name_place) {
		setAttrVal("Name_place", Name_place);
	}
	/**
	 * 病理摘要
	 * @return String
	 */
	public String getDes_emr() {
		return ((String) getAttrVal("Des_emr"));
	}
	/**
	 * 病理摘要
	 * @param Des_emr
	 */
	public void setDes_emr(String Des_emr) {
		setAttrVal("Des_emr", Des_emr);
	}
	/**
	 * 会诊目的
	 * @return String
	 */
	public String getDes_psp() {
		return ((String) getAttrVal("Des_psp"));
	}
	/**
	 * 会诊目的
	 * @param Des_psp
	 */
	public void setDes_psp(String Des_psp) {
		setAttrVal("Des_psp", Des_psp);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_dep_cons() {
		return ((String) getAttrVal("Id_dep_cons"));
	}
	/**
	 * 申请科室id
	 * @param Id_dep_cons
	 */
	public void setId_dep_cons(String Id_dep_cons) {
		setAttrVal("Id_dep_cons", Id_dep_cons);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getName_dep_cons() {
		return ((String) getAttrVal("Name_dep_cons"));
	}
	/**
	 * 申请科室
	 * @param Name_dep_cons
	 */
	public void setName_dep_cons(String Name_dep_cons) {
		setAttrVal("Name_dep_cons", Name_dep_cons);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_creat() {
		return ((FDateTime) getAttrVal("Dt_creat"));
	}
	/**
	 * 申请时间
	 * @param Dt_creat
	 */
	public void setDt_creat(FDateTime Dt_creat) {
		setAttrVal("Dt_creat", Dt_creat);
	}
	/**
	 * 申请人id
	 * @return String
	 */
	public String getId_emp_cons() {
		return ((String) getAttrVal("Id_emp_cons"));
	}
	/**
	 * 申请人id
	 * @param Id_emp_cons
	 */
	public void setId_emp_cons(String Id_emp_cons) {
		setAttrVal("Id_emp_cons", Id_emp_cons);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getName_emp_cons() {
		return ((String) getAttrVal("Name_emp_cons"));
	}
	/**
	 * 申请人
	 * @param Name_emp_cons
	 */
	public void setName_emp_cons(String Name_emp_cons) {
		setAttrVal("Name_emp_cons", Name_emp_cons);
	}
	/**
	 * 会诊类型id
	 * @return String
	 */
	public String getId_constp() {
		return ((String) getAttrVal("Id_constp"));
	}
	/**
	 * 会诊类型id
	 * @param Id_constp
	 */
	public void setId_constp(String Id_constp) {
		setAttrVal("Id_constp", Id_constp);
	}
	/**
	 * 会诊类型
	 * @return String
	 */
	public String getName_constp() {
		return ((String) getAttrVal("Name_constp"));
	}
	/**
	 * 会诊类型
	 * @param Name_constp
	 */
	public void setName_constp(String Name_constp) {
		setAttrVal("Name_constp", Name_constp);
	}
	/**
	 * 会诊类型编码
	 * @return String
	 */
	public String getSd_constp() {
		return ((String) getAttrVal("Sd_constp"));
	}
	/**
	 * 会诊类型编码
	 * @param Sd_constp
	 */
	public void setSd_constp(String Sd_constp) {
		setAttrVal("Sd_constp", Sd_constp);
	}
	/**
	 * 会诊申请状态id
	 * @return String
	 */
	public String getId_su_cons() {
		return ((String) getAttrVal("Id_su_cons"));
	}
	/**
	 * 会诊申请状态id
	 * @param Id_su_cons
	 */
	public void setId_su_cons(String Id_su_cons) {
		setAttrVal("Id_su_cons", Id_su_cons);
	}
	/**
	 * 会诊申请状态
	 * @return String
	 */
	public String getName_su_cons() {
		return ((String) getAttrVal("Name_su_cons"));
	}
	/**
	 * 会诊申请状态
	 * @param Name_su_cons
	 */
	public void setName_su_cons(String Name_su_cons) {
		setAttrVal("Name_su_cons", Name_su_cons);
	}
	/**
	 * 会诊申请状态编码
	 * @return String
	 */
	public String getSd_su_cons() {
		return ((String) getAttrVal("Sd_su_cons"));
	}
	/**
	 * 会诊申请状态编码
	 * @param Sd_su_cons
	 */
	public void setSd_su_cons(String Sd_su_cons) {
		setAttrVal("Sd_su_cons", Sd_su_cons);
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
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 加急状态
	 * @return String
	 */
	public String getStr_urgent() {
		return ((String) getAttrVal("Str_urgent"));
	}
	/**
	 * 加急状态
	 * @param Str_urgent
	 */
	public void setStr_urgent(String Str_urgent) {
		setAttrVal("Str_urgent", Str_urgent);
	}
	/**
	 * 医务部意见
	 * @return String
	 */
	public String getDes_dep() {
		return ((String) getAttrVal("Des_dep"));
	}
	/**
	 * 医务部意见
	 * @param Des_dep
	 */
	public void setDes_dep(String Des_dep) {
		setAttrVal("Des_dep", Des_dep);
	}
	/**
	 * 会诊主持人id
	 * @return String
	 */
	public String getId_emp_host() {
		return ((String) getAttrVal("Id_emp_host"));
	}
	/**
	 * 会诊主持人id
	 * @param Id_emp_host
	 */
	public void setId_emp_host(String Id_emp_host) {
		setAttrVal("Id_emp_host", Id_emp_host);
	}
	/**
	 * 会诊主持人
	 * @return String
	 */
	public String getName_emp_host() {
		return ((String) getAttrVal("Name_emp_host"));
	}
	/**
	 * 会诊主持人
	 * @param Name_emp_host
	 */
	public void setName_emp_host(String Name_emp_host) {
		setAttrVal("Name_emp_host", Name_emp_host);
	}
	/**
	 * 会诊记录
	 * @return String
	 */
	public String getAdvice() {
		return ((String) getAttrVal("Advice"));
	}
	/**
	 * 会诊记录
	 * @param Advice
	 */
	public void setAdvice(String Advice) {
		setAttrVal("Advice", Advice);
	}
	/**
	 * 会诊申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 会诊申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 受邀科室
	 * @return String
	 */
	public String getId_dep_emp() {
		return ((String) getAttrVal("Id_dep_emp"));
	}
	/**
	 * 受邀科室
	 * @param Id_dep_emp
	 */
	public void setId_dep_emp(String Id_dep_emp) {
		setAttrVal("Id_dep_emp", Id_dep_emp);
	}
	/**
	 * 受邀科室名称
	 * @return String
	 */
	public String getName_dep_emp() {
		return ((String) getAttrVal("Name_dep_emp"));
	}
	/**
	 * 受邀科室名称
	 * @param Name_dep_emp
	 */
	public void setName_dep_emp(String Name_dep_emp) {
		setAttrVal("Name_dep_emp", Name_dep_emp);
	}
	/**
	 * 受邀人
	 * @return String
	 */
	public String getId_emp_doctor() {
		return ((String) getAttrVal("Id_emp_doctor"));
	}
	/**
	 * 受邀人
	 * @param Id_emp_doctor
	 */
	public void setId_emp_doctor(String Id_emp_doctor) {
		setAttrVal("Id_emp_doctor", Id_emp_doctor);
	}
	/**
	 * 受邀人名称
	 * @return String
	 */
	public String getName_emp_doctor() {
		return ((String) getAttrVal("Name_emp_doctor"));
	}
	/**
	 * 受邀人名称
	 * @param Name_emp_doctor
	 */
	public void setName_emp_doctor(String Name_emp_doctor) {
		setAttrVal("Name_emp_doctor", Name_emp_doctor);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 参考价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 服务分类内部编码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}
	/**
	 * 服务分类内部编码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	/**
	 * 费用同步标识
	 * @return FBoolean
	 */
	public FBoolean getFg_syncfee() {
		return ((FBoolean) getAttrVal("Fg_syncfee"));
	}
	/**
	 * 费用同步标识
	 * @param Fg_syncfee
	 */
	public void setFg_syncfee(FBoolean Fg_syncfee) {
		setAttrVal("Fg_syncfee", Fg_syncfee);
	}
	/**
	 * 医嘱来源
	 * @return Integer
	 */
	public Integer getEu_sourcemd() {
		return ((Integer) getAttrVal("Eu_sourcemd"));
	}
	/**
	 * 医嘱来源
	 * @param Eu_sourcemd
	 */
	public void setEu_sourcemd(Integer Eu_sourcemd) {
		setAttrVal("Eu_sourcemd", Eu_sourcemd);
	}
	/**
	 * 所属服务
	 * @return String
	 */
	public String getId_srv_src() {
		return ((String) getAttrVal("Id_srv_src"));
	}
	/**
	 * 所属服务
	 * @param Id_srv_src
	 */
	public void setId_srv_src(String Id_srv_src) {
		setAttrVal("Id_srv_src", Id_srv_src);
	}
	/**
	 * 加价方式
	 * @return String
	 */
	public String getPriby() {
		return ((String) getAttrVal("Priby"));
	}
	/**
	 * 加价方式
	 * @param Priby
	 */
	public void setPriby(String Priby) {
		setAttrVal("Priby", Priby);
	}
	
	public FBoolean getFg_inorg() {
		return ((FBoolean) getAttrVal("Fg_inorg"));
	}	
	public void setFg_inorg(FBoolean Fg_inorg) {
		setAttrVal("Fg_inorg", Fg_inorg);
	}
	public FBoolean getFg_deps() {
		return ((FBoolean) getAttrVal("Fg_deps"));
	}	
	public void setFg_deps(FBoolean Fg_deps) {
		setAttrVal("Fg_deps", Fg_deps);
	}
	
	public FArrayList getConsAssList() {
		return ((FArrayList) getAttrVal("ConsAssList"));
	}	
	public void setConsAssList(FArrayList ConsAssList) {
		setAttrVal("ConsAssList", ConsAssList);
	}
   
    public FArrayList getConsItemList() {
		return ((FArrayList) getAttrVal("ConsItemList"));
	}	
	public void setConsItemList(FArrayList ConsItemList) {
		setAttrVal("ConsItemList", ConsItemList);
	}
    
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 自费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 记费模式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 记费模式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}	
}
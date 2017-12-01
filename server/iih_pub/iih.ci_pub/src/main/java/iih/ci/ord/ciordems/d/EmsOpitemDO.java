package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术申请单项目 DTO数据 
 * 
 */
public class EmsOpitemDO extends OrCommonFieldsDTO {
	private static final long serialVersionUID = 1L;
	public String getId_apop() {
		return ((String) getAttrVal("Id_apop"));
	}	
	public void setId_apop(String Id_apop) {
		setAttrVal("Id_apop", Id_apop);
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
	 * 临床诊断id拼接
	 * @return String
	 */
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}
	/**
	 * 临床诊断id拼接
	 * @param Str_id_diitm
	 */
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
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
	 * 诊断id
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 诊断id
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
	 * 手术申请单主键
	 * @return String
	 */
	public String getId_emsopitem() {
		return ((String) getAttrVal("Id_emsopitem"));
	}
	/**
	 * 手术申请单主键
	 * @param Id_emsopitem
	 */
	public void setId_emsopitem(String Id_emsopitem) {
		setAttrVal("Id_emsopitem", Id_emsopitem);
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
	 * displaynam48
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * displaynam48
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
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
	 * 手术名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 手术名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 手术编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 急诊手术
	 * @return FBoolean
	 */
	public FBoolean getFg_er_sug() {
		return ((FBoolean) getAttrVal("Fg_er_sug"));
	}
	/**
	 * 急诊手术
	 * @param Fg_er_sug
	 */
	public void setFg_er_sug(FBoolean Fg_er_sug) {
		setAttrVal("Fg_er_sug", Fg_er_sug);
	}
	/**
	 * 限期手术
	 * @return FBoolean
	 */
	public FBoolean getFg_xq_sug() {
		return ((FBoolean) getAttrVal("Fg_xq_sug"));
	}
	/**
	 * 限期手术
	 * @param Fg_xq_sug
	 */
	public void setFg_xq_sug(FBoolean Fg_xq_sug) {
		setAttrVal("Fg_xq_sug", Fg_xq_sug);
	}
	/**
	 * 择期手术
	 * @return FBoolean
	 */
	public FBoolean getFg_zq_sug() {
		return ((FBoolean) getAttrVal("Fg_zq_sug"));
	}
	/**
	 * 择期手术
	 * @param Fg_zq_sug
	 */
	public void setFg_zq_sug(FBoolean Fg_zq_sug) {
		setAttrVal("Fg_zq_sug", Fg_zq_sug);
	}
	/**
	 * 计划手术时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划手术时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_creat() {
		return ((FDateTime) getAttrVal("Dt_creat"));
	}
	/**
	 * 开立日期
	 * @param Dt_creat
	 */
	public void setDt_creat(FDateTime Dt_creat) {
		setAttrVal("Dt_creat", Dt_creat);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_mp_dep() {
		return ((String) getAttrVal("Id_mp_dep"));
	}
	/**
	 * 执行科室id
	 * @param Id_mp_dep
	 */
	public void setId_mp_dep(String Id_mp_dep) {
		setAttrVal("Id_mp_dep", Id_mp_dep);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_mp_dep() {
		return ((String) getAttrVal("Name_mp_dep"));
	}
	/**
	 * 执行科室
	 * @param Name_mp_dep
	 */
	public void setName_mp_dep(String Name_mp_dep) {
		setAttrVal("Name_mp_dep", Name_mp_dep);
	}
	/**
	 * 手术分级编码
	 * @return String
	 */
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}
	/**
	 * 手术分级编码
	 * @param Sd_lvlsug
	 */
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	/**
	 * 手术分级
	 * @return String
	 */
	public String getName_lvlsug() {
		return ((String) getAttrVal("Name_lvlsug"));
	}
	/**
	 * 手术分级
	 * @param Name_lvlsug
	 */
	public void setName_lvlsug(String Name_lvlsug) {
		setAttrVal("Name_lvlsug", Name_lvlsug);
	}
	/**
	 * 手术分级id
	 * @return String
	 */
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}
	/**
	 * 手术分级id
	 * @param Id_lvlsug
	 */
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	/**
	 * 麻醉方式编码
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}
	/**
	 * 麻醉方式编码
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}
	/**
	 * 麻醉方式
	 * @param Name_anestp
	 */
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	/**
	 * 麻醉方式id
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}
	/**
	 * 麻醉方式id
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 药物过敏史
	 * @return FBoolean
	 */
	public FBoolean getFg_allergy() {
		return ((FBoolean) getAttrVal("Fg_allergy"));
	}
	/**
	 * 药物过敏史
	 * @param Fg_allergy
	 */
	public void setFg_allergy(FBoolean Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	/**
	 * 是否开展新手术
	 * @return FBoolean
	 */
	public FBoolean getFg_new_sug() {
		return ((FBoolean) getAttrVal("Fg_new_sug"));
	}
	/**
	 * 是否开展新手术
	 * @param Fg_new_sug
	 */
	public void setFg_new_sug(FBoolean Fg_new_sug) {
		setAttrVal("Fg_new_sug", Fg_new_sug);
	}
	/**
	 * 手术中冰冻处理
	 * @return FBoolean
	 */
	public FBoolean getFg_patho() {
		return ((FBoolean) getAttrVal("Fg_patho"));
	}
	/**
	 * 手术中冰冻处理
	 * @param Fg_patho
	 */
	public void setFg_patho(FBoolean Fg_patho) {
		setAttrVal("Fg_patho", Fg_patho);
	}
	/**
	 * 预期输血量
	 * @return FDouble
	 */
	public FDouble getQuan_bt_plan() {
		return ((FDouble) getAttrVal("Quan_bt_plan"));
	}
	/**
	 * 预期输血量
	 * @param Quan_bt_plan
	 */
	public void setQuan_bt_plan(FDouble Quan_bt_plan) {
		setAttrVal("Quan_bt_plan", Quan_bt_plan);
	}
	/**
	 * 预期手术时长
	 * @return Integer
	 */
	public Integer getTime_sup_plan() {
		return ((Integer) getAttrVal("Time_sup_plan"));
	}
	/**
	 * 预期手术时长
	 * @param Time_sup_plan
	 */
	public void setTime_sup_plan(Integer Time_sup_plan) {
		setAttrVal("Time_sup_plan", Time_sup_plan);
	}
	/**
	 * 主刀医师id
	 * @return String
	 */
	public String getId_emp_operator() {
		return ((String) getAttrVal("Id_emp_operator"));
	}
	/**
	 * 主刀医师id
	 * @param Id_emp_operator
	 */
	public void setId_emp_operator(String Id_emp_operator) {
		setAttrVal("Id_emp_operator", Id_emp_operator);
	}
	/**
	 * 主刀医师
	 * @return String
	 */
	public String getName_emp_operator() {
		return ((String) getAttrVal("Name_emp_operator"));
	}
	/**
	 * 主刀医师
	 * @param Name_emp_operator
	 */
	public void setName_emp_operator(String Name_emp_operator) {
		setAttrVal("Name_emp_operator", Name_emp_operator);
	}
	/**
	 * 一助id
	 * @return String
	 */
	public String getId_emp_help1() {
		return ((String) getAttrVal("Id_emp_help1"));
	}
	/**
	 * 一助id
	 * @param Id_emp_help1
	 */
	public void setId_emp_help1(String Id_emp_help1) {
		setAttrVal("Id_emp_help1", Id_emp_help1);
	}
	/**
	 * 一助
	 * @return String
	 */
	public String getName_emp_help1() {
		return ((String) getAttrVal("Name_emp_help1"));
	}
	/**
	 * 一助
	 * @param Name_emp_help1
	 */
	public void setName_emp_help1(String Name_emp_help1) {
		setAttrVal("Name_emp_help1", Name_emp_help1);
	}
	/**
	 * 体位编码
	 * @return String
	 */
	public String getSd_sugbodycod() {
		return ((String) getAttrVal("Sd_sugbodycod"));
	}
	/**
	 * 体位编码
	 * @param Sd_sugbodycod
	 */
	public void setSd_sugbodycod(String Sd_sugbodycod) {
		setAttrVal("Sd_sugbodycod", Sd_sugbodycod);
	}
	/**
	 * 体位
	 * @return String
	 */
	public String getName_sugbodycod() {
		return ((String) getAttrVal("Name_sugbodycod"));
	}
	/**
	 * 体位
	 * @param Name_sugbodycod
	 */
	public void setName_sugbodycod(String Name_sugbodycod) {
		setAttrVal("Name_sugbodycod", Name_sugbodycod);
	}
	/**
	 * 体位id
	 * @return String
	 */
	public String getId_sugbodycod() {
		return ((String) getAttrVal("Id_sugbodycod"));
	}
	/**
	 * 体位id
	 * @param Id_sugbodycod
	 */
	public void setId_sugbodycod(String Id_sugbodycod) {
		setAttrVal("Id_sugbodycod", Id_sugbodycod);
	}
	/**
	 * 特殊器械
	 * @return String
	 */
	public String getSpecialreq() {
		return ((String) getAttrVal("Specialreq"));
	}
	/**
	 * 特殊器械
	 * @param Specialreq
	 */
	public void setSpecialreq(String Specialreq) {
		setAttrVal("Specialreq", Specialreq);
	}
	/**
	 * 特殊仪器
	 * @return String
	 */
	public String getSpecialinstrument() {
		return ((String) getAttrVal("Specialinstrument"));
	}
	/**
	 * 特殊仪器
	 * @param Specialinstrument
	 */
	public void setSpecialinstrument(String Specialinstrument) {
		setAttrVal("Specialinstrument", Specialinstrument);
	}
	/**
	 * 特殊准备
	 * @return String
	 */
	public String getSpecialdes() {
		return ((String) getAttrVal("Specialdes"));
	}
	/**
	 * 特殊准备
	 * @param Specialdes
	 */
	public void setSpecialdes(String Specialdes) {
		setAttrVal("Specialdes", Specialdes);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}
	/**
	 * 注意事项
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 手术申请状态id
	 * @return String
	 */
	public String getId_su() {
		return ((String) getAttrVal("Id_su"));
	}
	/**
	 * 手术申请状态id
	 * @param Id_su
	 */
	public void setId_su(String Id_su) {
		setAttrVal("Id_su", Id_su);
	}
	/**
	 * 手术申请状态
	 * @return String
	 */
	public String getSd_su() {
		return ((String) getAttrVal("Sd_su"));
	}
	/**
	 * 手术申请状态
	 * @param Sd_su
	 */
	public void setSd_su(String Sd_su) {
		setAttrVal("Sd_su", Sd_su);
	}
	/**
	 * 角色id
	 * @return String
	 */
	public String getId_role() {
		return ((String) getAttrVal("Id_role"));
	}
	/**
	 * 角色id
	 * @param Id_role
	 */
	public void setId_role(String Id_role) {
		setAttrVal("Id_role", Id_role);
	}
	/**
	 * 角色
	 * @return String
	 */
	public String getName_role() {
		return ((String) getAttrVal("Name_role"));
	}
	/**
	 * 角色
	 * @param Name_role
	 */
	public void setName_role(String Name_role) {
		setAttrVal("Name_role", Name_role);
	}
	/**
	 * 人员id
	 * @return String
	 */
	public String getId_emp_op() {
		return ((String) getAttrVal("Id_emp_op"));
	}
	/**
	 * 人员id
	 * @param Id_emp_op
	 */
	public void setId_emp_op(String Id_emp_op) {
		setAttrVal("Id_emp_op", Id_emp_op);
	}
	/**
	 * 人员名称
	 * @return String
	 */
	public String getName_emp_op() {
		return ((String) getAttrVal("Name_emp_op"));
	}
	/**
	 * 人员名称
	 * @param Name_emp_op
	 */
	public void setName_emp_op(String Name_emp_op) {
		setAttrVal("Name_emp_op", Name_emp_op);
	}
	/**
	 * 版本号
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本号
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 排序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 排序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 手术等级id
	 * @return String
	 */
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}
	/**
	 * 手术等级id
	 * @param Id_incitp
	 */
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	/**
	 * 手术等级编码
	 * @return String
	 */
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}
	/**
	 * 手术等级编码
	 * @param Sd_incitp
	 */
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	/**
	 * 附加手术编码集合
	 * @return String
	 */
	public String getCode_opex_srvs() {
		return ((String) getAttrVal("Code_opex_srvs"));
	}
	/**
	 * 附加手术编码集合
	 * @param Code_opex_srvs
	 */
	public void setCode_opex_srvs(String Code_opex_srvs) {
		setAttrVal("Code_opex_srvs", Code_opex_srvs);
	}
	/**
	 * 附加手术服务id集合
	 * @return String
	 */
	public String getId_opex_srvs() {
		return ((String) getAttrVal("Id_opex_srvs"));
	}
	/**
	 * 附加手术服务id集合
	 * @param Id_opex_srvs
	 */
	public void setId_opex_srvs(String Id_opex_srvs) {
		setAttrVal("Id_opex_srvs", Id_opex_srvs);
	}
	/**
	 * 附加手术服务名称集合
	 * @return String
	 */
	public String getName_opex_srvs() {
		return ((String) getAttrVal("Name_opex_srvs"));
	}
	/**
	 * 附加手术服务名称集合
	 * @param Name_opex_srvs
	 */
	public void setName_opex_srvs(String Name_opex_srvs) {
		setAttrVal("Name_opex_srvs", Name_opex_srvs);
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
	 * 医学单位ID
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 医学单位ID
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 医学单位
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 医学数量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 医学数量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 频次ID
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次ID
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 频次时刻数量
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}
	/**
	 * 频次时刻数量
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
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
	 * 服务所属
	 * @return String
	 */
	public String getId_srv_src() {
		return ((String) getAttrVal("Id_srv_src"));
	}
	/**
	 * 服务所属
	 * @param Id_srv_src
	 */
	public void setId_srv_src(String Id_srv_src) {
		setAttrVal("Id_srv_src", Id_srv_src);
	}
	/**
	 * 计价方式
	 * @return String
	 */
	public String getPriby() {
		return ((String) getAttrVal("Priby"));
	}
	/**
	 * 计价方式
	 * @param Priby
	 */
	public void setPriby(String Priby) {
		setAttrVal("Priby", Priby);
	}
	
	/**
	 * 附加手术列表
	 * @return FArrayList
	 */
	public FArrayList getOpAppendList() {
		return ((FArrayList) getAttrVal("OpAppendList"));
	}
	/**
	 * 附加手术列表
	 * @param AppendOpList
	 */
	public void setOpAppendList(FArrayList ls) {
		setAttrVal("OpAppendList", ls);
	}
	
	/**
	 * 附加手术人员
	 * @return FArrayList
	 */
	public FArrayList getOpPersonList() {
		return ((FArrayList) getAttrVal("OpPersonList"));
	}
	/**
	 * 附加手术人员
	 * @param OpPersonList
	 */
	public void setOpPersonList(FArrayList ls) {
		setAttrVal("OpPersonList", ls);
	}
	
	/**
	 * 手术动态指标检查项
	 * @return FArrayList
	 */
	public FArrayList getOpCheckIndicatorList() {
		return ((FArrayList) getAttrVal("OpCheckIndicatorList"));
	}
	/**
	 * 手术动态指标检查项
	 * @param OpCheckIndicatorList
	 */
	public void setOpCheckIndicatorList(FArrayList ls) {
		setAttrVal("OpCheckIndicatorList", ls);
	}
	
	/**
	 * 手术耗材列表
	 * @return FArrayList
	 */
	public FArrayList getOpSuppliesList() {
		return ((FArrayList) getAttrVal("OpSuppliesList"));
	}
	/**
	 * 手术耗材列表
	 * @param OpSuppliesList
	 */
	public void setOpSuppliesList(FArrayList ls) {
		setAttrVal("OpSuppliesList", ls);
	}
	
	/**
	 * 手术药品列表
	 * @return FArrayList
	 */
	public FArrayList getOpDrugList() {
		return ((FArrayList) getAttrVal("OpDrugList"));
	}
	/**
	 * 手术药品列表
	 * @param OpDrugList
	 */
	public void setOpDrugList(FArrayList ls) {
		setAttrVal("OpDrugList", ls);
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
	/**
	 * 日间手术标识
	 * @return FBoolean
	 */
	public FBoolean getFg_daysug() {
		return ((FBoolean) getAttrVal("Fg_daysug"));
	}
	/**
	 * 日间手术标识
	 * @param Fg_daysug
	 */
	public void setFg_daysug(FBoolean Fg_daysug) {
		setAttrVal("Fg_daysug", Fg_daysug);
	}
	/**
	 * 麻醉分类
	 * @return Integer
	 */
	public Integer getEu_anesca() {
		return ((Integer) getAttrVal("Eu_anesca"));
	}
	/**
	 *麻醉分类
	 * @param Eu_anesca
	 */
	public void setEu_anesca(Integer Eu_anesca) {
		setAttrVal("Eu_anesca", Eu_anesca);
	}
}
package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

/**
 * 检查检验医疗单 DTO数据
 * 
 */
public class EmsObsItemDO extends OrCommonFieldsDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 诊断子项id
	 * 
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}

	/**
	 * 诊断子项id
	 * 
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}

	/**
	 * 诊断子项id拼接
	 * 
	 * @return String
	 */
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}

	/**
	 * 诊断子项id拼接
	 * 
	 * @param Str_id_diitm
	 */
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}

	/**
	 * 诊断名称拼接
	 * 
	 * @return String
	 */
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}

	/**
	 * 诊断名称拼接
	 * 
	 * @param Str_name_di
	 */
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}

	/**
	 * 诊断编码拼接
	 * 
	 * @return String
	 */
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}

	/**
	 * 诊断编码拼接
	 * 
	 * @param Str_code_di
	 */
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}

	/**
	 * 诊断名称
	 * 
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}

	/**
	 * 诊断名称
	 * 
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}

	/**
	 * 诊断id
	 * 
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}

	/**
	 * 诊断id
	 * 
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}

	/**
	 * 检查申请单主键
	 * 
	 * @return String
	 */
	public String getId_emsobs() {
		return ((String) getAttrVal("Id_emsobs"));
	}

	/**
	 * 检查申请单主键
	 * 
	 * @param Id_emsobs
	 */
	public void setId_emsobs(String Id_emsobs) {
		setAttrVal("Id_emsobs", Id_emsobs);
	}

	/**
	 * 医嘱服务id
	 * 
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}

	/**
	 * 医嘱服务id
	 * 
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}

	/**
	 * 医嘱医疗单
	 * 
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}

	/**
	 * 医嘱医疗单
	 * 
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}

	/**
	 * 服务id
	 * 
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	/**
	 * 服务id
	 * 
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}

	/**
	 * 服务名称
	 * 
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}

	/**
	 * 服务名称
	 * 
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}

	/**
	 * 服务类型
	 * 
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}

	/**
	 * 服务类型
	 * 
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}

	/**
	 * 服务类型名称
	 * 
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}

	/**
	 * 服务类型名称
	 * 
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}

	/**
	 * 检查类型id
	 * 
	 * @return String
	 */
	public String getId_obstp() {
		return ((String) getAttrVal("Id_obstp"));
	}

	/**
	 * 检查类型id
	 * 
	 * @param Id_obstp
	 */
	public void setId_obstp(String Id_obstp) {
		setAttrVal("Id_obstp", Id_obstp);
	}

	/**
	 * 检查类型名称
	 * 
	 * @return String
	 */
	public String getName_obstp() {
		return ((String) getAttrVal("Name_obstp"));
	}

	/**
	 * 检查类型名称
	 * 
	 * @param Name_obstp
	 */
	public void setName_obstp(String Name_obstp) {
		setAttrVal("Name_obstp", Name_obstp);
	}

	/**
	 * 检查申请单号
	 * 
	 * @return String
	 */
	public String getNo_applyobs() {
		return ((String) getAttrVal("No_applyobs"));
	}

	/**
	 * 检查申请单号
	 * 
	 * @param No_applyobs
	 */
	public void setNo_applyobs(String No_applyobs) {
		setAttrVal("No_applyobs", No_applyobs);
	}

	/**
	 * 加急标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}

	/**
	 * 加急标识
	 * 
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}

	/**
	 * 床旁执行标志
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_bed() {
		return ((FBoolean) getAttrVal("Fg_mp_bed"));
	}

	/**
	 * 床旁执行标志
	 * 
	 * @param Fg_mp_bed
	 */
	public void setFg_mp_bed(FBoolean Fg_mp_bed) {
		setAttrVal("Fg_mp_bed", Fg_mp_bed);
	}

	/**
	 * 计划检查时间
	 * 
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}

	/**
	 * 计划检查时间
	 * 
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}

	/**
	 * 检查目的编码
	 * 
	 * @return String
	 */
	public String getSd_pps() {
		return ((String) getAttrVal("Sd_pps"));
	}

	/**
	 * 检查目的编码
	 * 
	 * @param Sd_pps
	 */
	public void setSd_pps(String Sd_pps) {
		setAttrVal("Sd_pps", Sd_pps);
	}

	/**
	 * 检查目的
	 * 
	 * @return String
	 */
	public String getId_pps() {
		return ((String) getAttrVal("Id_pps"));
	}

	/**
	 * 检查目的
	 * 
	 * @param Id_pps
	 */
	public void setId_pps(String Id_pps) {
		setAttrVal("Id_pps", Id_pps);
	}

	/**
	 * 检查目的名称
	 * 
	 * @return String
	 */
	public String getName_pps() {
		return ((String) getAttrVal("Name_pps"));
	}

	/**
	 * 检查目的名称
	 * 
	 * @param Name_pps
	 */
	public void setName_pps(String Name_pps) {
		setAttrVal("Name_pps", Name_pps);
	}

	/**
	 * 检查目的描述
	 * 
	 * @return String
	 */
	public String getDes_pps() {
		return ((String) getAttrVal("Des_pps"));
	}

	/**
	 * 检查目的描述
	 * 
	 * @param Des_pps
	 */
	public void setDes_pps(String Des_pps) {
		setAttrVal("Des_pps", Des_pps);
	}

	/**
	 * 症状体征描述
	 * 
	 * @return String
	 */
	public String getDes_sympsign() {
		return ((String) getAttrVal("Des_sympsign"));
	}

	/**
	 * 症状体征描述
	 * 
	 * @param Des_sympsign
	 */
	public void setDes_sympsign(String Des_sympsign) {
		setAttrVal("Des_sympsign", Des_sympsign);
	}

	/**
	 * 身体部位id
	 * 
	 * @return String
	 */
	public String getId_body() {
		return ((String) getAttrVal("Id_body"));
	}

	/**
	 * 身体部位id
	 * 
	 * @param Id_body
	 */
	public void setId_body(String Id_body) {
		setAttrVal("Id_body", Id_body);
	}

	/**
	 * 身体部位编码
	 * 
	 * @return String
	 */
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}

	/**
	 * 身体部位编码
	 * 
	 * @param Sd_body
	 */
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}

	/**
	 * 身体部位名称
	 * 
	 * @return String
	 */
	public String getName_body() {
		return ((String) getAttrVal("Name_body"));
	}

	/**
	 * 身体部位名称
	 * 
	 * @param Name_body
	 */
	public void setName_body(String Name_body) {
		setAttrVal("Name_body", Name_body);
	}

	/**
	 * 检查申请单状态
	 * 
	 * @return String
	 */
	public String getId_su_obs() {
		return ((String) getAttrVal("Id_su_obs"));
	}

	/**
	 * 检查申请单状态
	 * 
	 * @param Id_su_obs
	 */
	public void setId_su_obs(String Id_su_obs) {
		setAttrVal("Id_su_obs", Id_su_obs);
	}

	/**
	 * 检查申请单编码
	 * 
	 * @return String
	 */
	public String getSd_su_obs() {
		return ((String) getAttrVal("Sd_su_obs"));
	}

	/**
	 * 检查申请单编码
	 * 
	 * @param Sd_su_obs
	 */
	public void setSd_su_obs(String Sd_su_obs) {
		setAttrVal("Sd_su_obs", Sd_su_obs);
	}

	/**
	 * 身体体位id
	 * 
	 * @return String
	 */
	public String getId_pos() {
		return ((String) getAttrVal("Id_pos"));
	}

	/**
	 * 身体体位id
	 * 
	 * @param Id_pos
	 */
	public void setId_pos(String Id_pos) {
		setAttrVal("Id_pos", Id_pos);
	}

	/**
	 * 身体体位编码
	 * 
	 * @return String
	 */
	public String getSd_pos() {
		return ((String) getAttrVal("Sd_pos"));
	}

	/**
	 * 身体体位编码
	 * 
	 * @param Sd_pos
	 */
	public void setSd_pos(String Sd_pos) {
		setAttrVal("Sd_pos", Sd_pos);
	}

	/**
	 * 身体体位名称
	 * 
	 * @return String
	 */
	public String getName_pos() {
		return ((String) getAttrVal("Name_pos"));
	}

	/**
	 * 身体体位名称
	 * 
	 * @param Name_pos
	 */
	public void setName_pos(String Name_pos) {
		setAttrVal("Name_pos", Name_pos);
	}

	/**
	 * 标本类型id
	 * 
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}

	/**
	 * 标本类型id
	 * 
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}

	/**
	 * 标本类型名称
	 * 
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}

	/**
	 * 标本类型名称
	 * 
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}

	/**
	 * 标本类型编码
	 * 
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}

	/**
	 * 标本类型编码
	 * 
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}

	/**
	 * 序号
	 * 
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}

	/**
	 * 序号
	 * 
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}

	/**
	 * 选择
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}

	/**
	 * 选择
	 * 
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}

	/**
	 * 注意事项
	 * 
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}

	/**
	 * 注意事项
	 * 
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}

	/**
	 * 版本号
	 * 
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}

	/**
	 * 版本号
	 * 
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}

	/**
	 * 检验分类
	 * 
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}

	/**
	 * 检验分类
	 * 
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}

	/**
	 * 采集方法编码
	 * 
	 * @return String
	 */
	public String getSd_colltp() {
		return ((String) getAttrVal("Sd_colltp"));
	}

	/**
	 * 采集方法编码
	 * 
	 * @param Sd_colltp
	 */
	public void setSd_colltp(String Sd_colltp) {
		setAttrVal("Sd_colltp", Sd_colltp);
	}

	/**
	 * 采集方法id
	 * 
	 * @return String
	 */
	public String getId_colltp() {
		return ((String) getAttrVal("Id_colltp"));
	}

	/**
	 * 采集方法id
	 * 
	 * @param Id_colltp
	 */
	public void setId_colltp(String Id_colltp) {
		setAttrVal("Id_colltp", Id_colltp);
	}

	/**
	 * 标本说明
	 * 
	 * @return String
	 */
	public String getDes_labsamp() {
		return ((String) getAttrVal("Des_labsamp"));
	}

	/**
	 * 标本说明
	 * 
	 * @param Des_labsamp
	 */
	public void setDes_labsamp(String Des_labsamp) {
		setAttrVal("Des_labsamp", Des_labsamp);
	}

	/**
	 * 使用天数
	 * 
	 * @return Integer
	 */
	public Integer getUse_days() {
		return ((Integer) getAttrVal("Use_days"));
	}

	/**
	 * 使用天数
	 * 
	 * @param Use_days
	 */
	public void setUse_days(Integer Use_days) {
		setAttrVal("Use_days", Use_days);
	}

	/**
	 * 执行科室ID
	 * 
	 * @return String
	 */
	public String getId_mp_dep() {
		return ((String) getAttrVal("Id_mp_dep"));
	}

	/**
	 * 执行科室ID
	 * 
	 * @param Id_mp_dep
	 */
	public void setId_mp_dep(String Id_mp_dep) {
		setAttrVal("Id_mp_dep", Id_mp_dep);
	}

	/**
	 * 执行科室名称
	 * 
	 * @return String
	 */
	public String getName_mp_dep() {
		return ((String) getAttrVal("Name_mp_dep"));
	}

	/**
	 * 执行科室名称
	 * 
	 * @param Name_mp_dep
	 */
	public void setName_mp_dep(String Name_mp_dep) {
		setAttrVal("Name_mp_dep", Name_mp_dep);
	}

	/**
	 * 价格
	 * 
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}

	/**
	 * 价格
	 * 
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}

	/**
	 * 总量
	 * 
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}

	/**
	 * 总量
	 * 
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}

	/**
	 * 总量单位
	 * 
	 * @return String
	 */
	public String getId_unit_sale() {
		return ((String) getAttrVal("Id_unit_sale"));
	}

	/**
	 * 总量单位
	 * 
	 * @param Id_unit_sale
	 */
	public void setId_unit_sale(String Id_unit_sale) {
		setAttrVal("Id_unit_sale", Id_unit_sale);
	}

	/**
	 * 总量单位名称
	 * 
	 * @return String
	 */
	public String getName_unit_sale() {
		return ((String) getAttrVal("Name_unit_sale"));
	}

	/**
	 * 总量单位名称
	 * 
	 * @param Name_unit_sale
	 */
	public void setName_unit_sale(String Name_unit_sale) {
		setAttrVal("Name_unit_sale", Name_unit_sale);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	/**
	 * 医学单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	
	/**
	 * 医学单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}	
	/**
	 * 医学单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	
	/**
	 * 数量_医学单位
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}	
	/**
	 * 数量_医学单位
	 * @param Quan_medu
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	
	/**
	 * 总次数
	 * @return Integer
	 */
	public Integer getTimes_cur() {
		return ((Integer) getAttrVal("Times_cur"));
	}	
	/**
	 * 总次数
	 * @param Times_cur
	 */
	public void setTimes_cur(Integer Times_cur) {
		setAttrVal("Times_cur", Times_cur);
	}
	
	

	/**
	 * 适应症
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}

	/**
	 * 适应症
	 * 
	 * @param Fg_indic
	 */
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}

	/**
	 * 计数单位ID
	 * 
	 * @return String
	 */
	public String getId_unit_base() {
		return ((String) getAttrVal("Id_unit_base"));
	}

	/**
	 * 计数单位ID
	 * 
	 * @param Id_unit_base
	 */
	public void setId_unit_base(String Id_unit_base) {
		setAttrVal("Id_unit_base", Id_unit_base);
	}

	/**
	 * 计数单位名称
	 * 
	 * @return String
	 */
	public String getName_unit_base() {
		return ((String) getAttrVal("Name_unit_base"));
	}

	/**
	 * 计数单位名称
	 * 
	 * @param Name_unit_base
	 */
	public void setName_unit_base(String Name_unit_base) {
		setAttrVal("Name_unit_base", Name_unit_base);
	}

	/**
	 * 计数单位
	 * 
	 * @return FDouble
	 */
	public FDouble getQuan_base() {
		return ((FDouble) getAttrVal("Quan_base"));
	}

	/**
	 * 计数单位
	 * 
	 * @param Quan_base
	 */
	public void setQuan_base(FDouble Quan_base) {
		setAttrVal("Quan_base", Quan_base);
	}

	/**
	 * 服务分类内部编码
	 * 
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}

	/**
	 * 服务分类内部编码
	 * 
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}

	/**
	 * 费用同步标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_syncfee() {
		return ((FBoolean) getAttrVal("Fg_syncfee"));
	}

	/**
	 * 费用同步标识
	 * 
	 * @param Fg_syncfee
	 */
	public void setFg_syncfee(FBoolean Fg_syncfee) {
		setAttrVal("Fg_syncfee", Fg_syncfee);
	}

	/**
	 * 客户拓展字段1
	 * 
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}

	/**
	 * 客户拓展字段1
	 * 
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}

	/**
	 * 客户拓展字段2
	 * 
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}

	/**
	 * 客户拓展字段2
	 * 
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}

	/**
	 * 客户拓展字段3
	 * 
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}

	/**
	 * 客户拓展字段3
	 * 
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}

	/**
	 * 客户拓展字段4
	 * 
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}

	/**
	 * 客户拓展字段4
	 * 
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}

	/**
	 * 客户拓展字段5
	 * 
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}

	/**
	 * 客户拓展字段5
	 * 
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}

	/**
	 * 客户拓展字段6
	 * 
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}

	/**
	 * 客户拓展字段6
	 * 
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}

	/**
	 * 客户拓展字段7
	 * 
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}

	/**
	 * 客户拓展字段7
	 * 
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}

	/**
	 * 客户拓展字段8
	 * 
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}

	/**
	 * 客户拓展字段8
	 * 
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}

	/**
	 * 客户拓展字段9
	 * 
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}

	/**
	 * 客户拓展字段9
	 * 
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}

	/**
	 * 客户拓展字段10
	 * 
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}

	/**
	 * 客户拓展字段10
	 * 
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}

	/**
	 * 客户拓展字段11
	 * 
	 * @return String
	 */
	public String getDef11() {
		return ((String) getAttrVal("Def11"));
	}

	/**
	 * 客户拓展字段11
	 * 
	 * @param Def11
	 */
	public void setDef11(String Def11) {
		setAttrVal("Def11", Def11);
	}

	/**
	 * 客户拓展字段12
	 * 
	 * @return String
	 */
	public String getDef12() {
		return ((String) getAttrVal("Def12"));
	}

	/**
	 * 客户拓展字段12
	 * 
	 * @param Def12
	 */
	public void setDef12(String Def12) {
		setAttrVal("Def12", Def12);
	}

	/**
	 * 客户拓展字段13
	 * 
	 * @return String
	 */
	public String getDef13() {
		return ((String) getAttrVal("Def13"));
	}

	/**
	 * 客户拓展字段13
	 * 
	 * @param Def13
	 */
	public void setDef13(String Def13) {
		setAttrVal("Def13", Def13);
	}

	/**
	 * 客户拓展字段14
	 * 
	 * @return String
	 */
	public String getDef14() {
		return ((String) getAttrVal("Def14"));
	}

	/**
	 * 客户拓展字段14
	 * 
	 * @param Def14
	 */
	public void setDef14(String Def14) {
		setAttrVal("Def14", Def14);
	}

	/**
	 * 客户拓展字段15
	 * 
	 * @return String
	 */
	public String getDef15() {
		return ((String) getAttrVal("Def15"));
	}

	/**
	 * 客户拓展字段15
	 * 
	 * @param Def15
	 */
	public void setDef15(String Def15) {
		setAttrVal("Def15", Def15);
	}

	/**
	 * 客户拓展字段16
	 * 
	 * @return String
	 */
	public String getDef16() {
		return ((String) getAttrVal("Def16"));
	}

	/**
	 * 客户拓展字段16
	 * 
	 * @param Def16
	 */
	public void setDef16(String Def16) {
		setAttrVal("Def16", Def16);
	}

	/**
	 * 客户拓展字段17
	 * 
	 * @return String
	 */
	public String getDef17() {
		return ((String) getAttrVal("Def17"));
	}

	/**
	 * 客户拓展字段17
	 * 
	 * @param Def17
	 */
	public void setDef17(String Def17) {
		setAttrVal("Def17", Def17);
	}

	/**
	 * 客户拓展字段18
	 * 
	 * @return String
	 */
	public String getDef18() {
		return ((String) getAttrVal("Def18"));
	}

	/**
	 * 客户拓展字段18
	 * 
	 * @param Def18
	 */
	public void setDef18(String Def18) {
		setAttrVal("Def18", Def18);
	}

	/**
	 * 客户拓展字段19
	 * 
	 * @return String
	 */
	public String getDef19() {
		return ((String) getAttrVal("Def19"));
	}

	/**
	 * 客户拓展字段19
	 * 
	 * @param Def19
	 */
	public void setDef19(String Def19) {
		setAttrVal("Def19", Def19);
	}

	/**
	 * 客户拓展字段20
	 * 
	 * @return String
	 */
	public String getDef20() {
		return ((String) getAttrVal("Def20"));
	}

	/**
	 * 客户拓展字段20
	 * 
	 * @param Def20
	 */
	public void setDef20(String Def20) {
		setAttrVal("Def20", Def20);
	}

	/**
	 * 客户拓展字段21
	 * 
	 * @return String
	 */
	public String getDef21() {
		return ((String) getAttrVal("Def21"));
	}

	/**
	 * 客户拓展字段21
	 * 
	 * @param Def21
	 */
	public void setDef21(String Def21) {
		setAttrVal("Def21", Def21);
	}

	/**
	 * 客户拓展字段22
	 * 
	 * @return String
	 */
	public String getDef22() {
		return ((String) getAttrVal("Def22"));
	}

	/**
	 * 客户拓展字段22
	 * 
	 * @param Def22
	 */
	public void setDef22(String Def22) {
		setAttrVal("Def22", Def22);
	}

	/**
	 * 客户拓展字段23
	 * 
	 * @return String
	 */
	public String getDef23() {
		return ((String) getAttrVal("Def23"));
	}

	/**
	 * 客户拓展字段23
	 * 
	 * @param Def23
	 */
	public void setDef23(String Def23) {
		setAttrVal("Def23", Def23);
	}

	/**
	 * 客户拓展字段24
	 * 
	 * @return String
	 */
	public String getDef24() {
		return ((String) getAttrVal("Def24"));
	}

	/**
	 * 客户拓展字段24
	 * 
	 * @param Def24
	 */
	public void setDef24(String Def24) {
		setAttrVal("Def24", Def24);
	}

	/**
	 * 客户拓展字段25
	 * 
	 * @return String
	 */
	public String getDef25() {
		return ((String) getAttrVal("Def25"));
	}

	/**
	 * 客户拓展字段25
	 * 
	 * @param Def25
	 */
	public void setDef25(String Def25) {
		setAttrVal("Def25", Def25);
	}

	/**
	 * 客户拓展字段26
	 * 
	 * @return String
	 */
	public String getDef26() {
		return ((String) getAttrVal("Def26"));
	}

	/**
	 * 客户拓展字段26
	 * 
	 * @param Def26
	 */
	public void setDef26(String Def26) {
		setAttrVal("Def26", Def26);
	}

	/**
	 * 客户拓展字段27
	 * 
	 * @return String
	 */
	public String getDef27() {
		return ((String) getAttrVal("Def27"));
	}

	/**
	 * 客户拓展字段27
	 * 
	 * @param Def27
	 */
	public void setDef27(String Def27) {
		setAttrVal("Def27", Def27);
	}

	/**
	 * 客户拓展字段28
	 * 
	 * @return String
	 */
	public String getDef28() {
		return ((String) getAttrVal("Def28"));
	}

	/**
	 * 客户拓展字段28
	 * 
	 * @param Def28
	 */
	public void setDef28(String Def28) {
		setAttrVal("Def28", Def28);
	}

	/**
	 * 客户拓展字段29
	 * 
	 * @return String
	 */
	public String getDef29() {
		return ((String) getAttrVal("Def29"));
	}

	/**
	 * 客户拓展字段29
	 * 
	 * @param Def29
	 */
	public void setDef29(String Def29) {
		setAttrVal("Def29", Def29);
	}

	/**
	 * 客户拓展字段304
	 * 
	 * @return String
	 */
	public String getDef30() {
		return ((String) getAttrVal("Def30"));
	}

	/**
	 * 客户拓展字段304
	 * 
	 * @param Def30
	 */
	public void setDef30(String Def30) {
		setAttrVal("Def30", Def30);
	}

	/**
	 * 客户拓展字段31
	 * 
	 * @return String
	 */
	public String getDef31() {
		return ((String) getAttrVal("Def31"));
	}

	/**
	 * 客户拓展字段31
	 * 
	 * @param Def31
	 */
	public void setDef31(String Def31) {
		setAttrVal("Def31", Def31);
	}

	/**
	 * 客户拓展字段32
	 * 
	 * @return String
	 */
	public String getDef32() {
		return ((String) getAttrVal("Def32"));
	}

	/**
	 * 客户拓展字段32
	 * 
	 * @param Def32
	 */
	public void setDef32(String Def32) {
		setAttrVal("Def32", Def32);
	}

	/**
	 * 客户拓展字段33
	 * 
	 * @return String
	 */
	public String getDef33() {
		return ((String) getAttrVal("Def33"));
	}

	/**
	 * 客户拓展字段33
	 * 
	 * @param Def33
	 */
	public void setDef33(String Def33) {
		setAttrVal("Def33", Def33);
	}

	/**
	 * 客户拓展字段34
	 * 
	 * @return String
	 */
	public String getDef34() {
		return ((String) getAttrVal("Def34"));
	}

	/**
	 * 客户拓展字段34
	 * 
	 * @param Def34
	 */
	public void setDef34(String Def34) {
		setAttrVal("Def34", Def34);
	}

	/**
	 * 客户拓展字段35
	 * 
	 * @return String
	 */
	public String getDef35() {
		return ((String) getAttrVal("Def35"));
	}

	/**
	 * 客户拓展字段35
	 * 
	 * @param Def35
	 */
	public void setDef35(String Def35) {
		setAttrVal("Def35", Def35);
	}

	/**
	 * 客户拓展字段36
	 * 
	 * @return String
	 */
	public String getDef36() {
		return ((String) getAttrVal("Def36"));
	}

	/**
	 * 客户拓展字段36
	 * 
	 * @param Def36
	 */
	public void setDef36(String Def36) {
		setAttrVal("Def36", Def36);
	}

	/**
	 * 客户拓展字段37
	 * 
	 * @return String
	 */
	public String getDef37() {
		return ((String) getAttrVal("Def37"));
	}

	/**
	 * 客户拓展字段37
	 * 
	 * @param Def37
	 */
	public void setDef37(String Def37) {
		setAttrVal("Def37", Def37);
	}

	/**
	 * 客户拓展字段38
	 * 
	 * @return String
	 */
	public String getDef38() {
		return ((String) getAttrVal("Def38"));
	}

	/**
	 * 客户拓展字段38
	 * 
	 * @param Def38
	 */
	public void setDef38(String Def38) {
		setAttrVal("Def38", Def38);
	}

	/**
	 * 客户拓展字段39
	 * 
	 * @return String
	 */
	public String getDef39() {
		return ((String) getAttrVal("Def39"));
	}

	/**
	 * 客户拓展字段39
	 * 
	 * @param Def39
	 */
	public void setDef39(String Def39) {
		setAttrVal("Def39", Def39);
	}

	/**
	 * 客户拓展字段40
	 * 
	 * @return String
	 */
	public String getDef40() {
		return ((String) getAttrVal("Def40"));
	}

	/**
	 * 客户拓展字段40
	 * 
	 * @param Def40
	 */
	public void setDef40(String Def40) {
		setAttrVal("Def40", Def40);
	}

	/**
	 * 客户拓展字段41
	 * 
	 * @return String
	 */
	public String getDef41() {
		return ((String) getAttrVal("Def41"));
	}

	/**
	 * 客户拓展字段41
	 * 
	 * @param Def41
	 */
	public void setDef41(String Def41) {
		setAttrVal("Def41", Def41);
	}

	/**
	 * 客户拓展字段42
	 * 
	 * @return String
	 */
	public String getDef42() {
		return ((String) getAttrVal("Def42"));
	}

	/**
	 * 客户拓展字段42
	 * 
	 * @param Def42
	 */
	public void setDef42(String Def42) {
		setAttrVal("Def42", Def42);
	}

	/**
	 * 客户拓展字段43
	 * 
	 * @return String
	 */
	public String getDef43() {
		return ((String) getAttrVal("Def43"));
	}

	/**
	 * 客户拓展字段43
	 * 
	 * @param Def43
	 */
	public void setDef43(String Def43) {
		setAttrVal("Def43", Def43);
	}

	/**
	 * 客户拓展字段44
	 * 
	 * @return String
	 */
	public String getDef44() {
		return ((String) getAttrVal("Def44"));
	}

	/**
	 * 客户拓展字段44
	 * 
	 * @param Def44
	 */
	public void setDef44(String Def44) {
		setAttrVal("Def44", Def44);
	}

	/**
	 * 客户拓展字段45
	 * 
	 * @return String
	 */
	public String getDef45() {
		return ((String) getAttrVal("Def45"));
	}

	/**
	 * 客户拓展字段45
	 * 
	 * @param Def45
	 */
	public void setDef45(String Def45) {
		setAttrVal("Def45", Def45);
	}

	/**
	 * 客户拓展字段46
	 * 
	 * @return String
	 */
	public String getDef46() {
		return ((String) getAttrVal("Def46"));
	}

	/**
	 * 客户拓展字段46
	 * 
	 * @param Def46
	 */
	public void setDef46(String Def46) {
		setAttrVal("Def46", Def46);
	}

	/**
	 * 客户拓展字段47
	 * 
	 * @return String
	 */
	public String getDef47() {
		return ((String) getAttrVal("Def47"));
	}

	/**
	 * 客户拓展字段47
	 * 
	 * @param Def47
	 */
	public void setDef47(String Def47) {
		setAttrVal("Def47", Def47);
	}

	/**
	 * 客户拓展字段48
	 * 
	 * @return String
	 */
	public String getDef48() {
		return ((String) getAttrVal("Def48"));
	}

	/**
	 * 客户拓展字段48
	 * 
	 * @param Def48
	 */
	public void setDef48(String Def48) {
		setAttrVal("Def48", Def48);
	}

	/**
	 * 客户拓展字段49
	 * 
	 * @return String
	 */
	public String getDef49() {
		return ((String) getAttrVal("Def49"));
	}

	/**
	 * 客户拓展字段49
	 * 
	 * @param Def49
	 */
	public void setDef49(String Def49) {
		setAttrVal("Def49", Def49);
	}

	/**
	 * 客户拓展字段50
	 * 
	 * @return String
	 */
	public String getDef50() {
		return ((String) getAttrVal("Def50"));
	}

	/**
	 * 客户拓展字段50
	 * 
	 * @param Def50
	 */
	public void setDef50(String Def50) {
		setAttrVal("Def50", Def50);
	}

	/**
	 * 临床症状及体征
	 * 
	 * @return String
	 */
	public String getClinicalzztz() {
		return ((String) getAttrVal("Clinicalzztz"));
	}

	/**
	 * 临床症状及体征
	 * 
	 * @param Clinicalzztz
	 */
	public void setClinicalzztz(String Clinicalzztz) {
		setAttrVal("Clinicalzztz", Clinicalzztz);
	}

	/**
	 * 既往病史
	 * 
	 * @return String
	 */
	public String getPastillness() {
		return ((String) getAttrVal("Pastillness"));
	}

	/**
	 * 既往病史
	 * 
	 * @param Pastillness
	 */
	public void setPastillness(String Pastillness) {
		setAttrVal("Pastillness", Pastillness);
	}

	/**
	 * 其他检查所见
	 * 
	 * @return String
	 */
	public String getAuximtexam() {
		return ((String) getAttrVal("Auximtexam"));
	}

	/**
	 * 其他检查所见
	 * 
	 * @param Auximtexam
	 */
	public void setAuximtexam(String Auximtexam) {
		setAttrVal("Auximtexam", Auximtexam);
	}

	/**
	 * 标本采集
	 * 
	 * @return String
	 */
	public String getId_sampcoltime() {
		return ((String) getAttrVal("Id_sampcoltime"));
	}

	/**
	 * 标本采集
	 * 
	 * @param Id_sampcoltime
	 */
	public void setId_sampcoltime(String Id_sampcoltime) {
		setAttrVal("Id_sampcoltime", Id_sampcoltime);
	}

	/**
	 * 标本采集时长
	 * 
	 * @return FDouble
	 */
	public FDouble getLen_sampcoltime() {
		return ((FDouble) getAttrVal("Len_sampcoltime"));
	}

	/**
	 * 标本采集时长
	 * 
	 * @param Len_sampcoltime
	 */
	public void setLen_sampcoltime(FDouble Len_sampcoltime) {
		setAttrVal("Len_sampcoltime", Len_sampcoltime);
	}

	/**
	 * 时长单位
	 * 
	 * @return String
	 */
	public String getId_unit_sampcoltime() {
		return ((String) getAttrVal("Id_unit_sampcoltime"));
	}

	/**
	 * 时长单位
	 * 
	 * @param Id_unit_sampcoltime
	 */
	public void setId_unit_sampcoltime(String Id_unit_sampcoltime) {
		setAttrVal("Id_unit_sampcoltime", Id_unit_sampcoltime);
	}

	/**
	 * 标本采集时间类型采集时间类型
	 * 
	 * @return String
	 */
	public String getId_sampcollecttimetp() {
		return ((String) getAttrVal("Id_sampcollecttimetp"));
	}

	/**
	 * 标本采集时间类型采集时间类型
	 * 
	 * @param Id_sampcollecttimetp
	 */
	public void setId_sampcollecttimetp(String Id_sampcollecttimetp) {
		setAttrVal("Id_sampcollecttimetp", Id_sampcollecttimetp);
	}

	/**
	 * 采集时间编码
	 * 
	 * @return String
	 */
	public String getSd_sampcollecttimetp() {
		return ((String) getAttrVal("Sd_sampcollecttimetp"));
	}

	/**
	 * 采集时间编码
	 * 
	 * @param Sd_sampcollecttimetp
	 */
	public void setSd_sampcollecttimetp(String Sd_sampcollecttimetp) {
		setAttrVal("Sd_sampcollecttimetp", Sd_sampcollecttimetp);
	}

	/**
	 * 标本采集时间名称
	 * 
	 * @return String
	 */
	public String getName_sampcoltime() {
		return ((String) getAttrVal("Name_sampcoltime"));
	}

	/**
	 * 标本采集时间名称
	 * 
	 * @param Name_sampcoltime
	 */
	public void setName_sampcoltime(String Name_sampcoltime) {
		setAttrVal("Name_sampcoltime", Name_sampcoltime);
	}

	/**
	 * 采集时长名称
	 * 
	 * @return String
	 */
	public String getName_len_sampcoltime() {
		return ((String) getAttrVal("Name_len_sampcoltime"));
	}

	/**
	 * 采集时长名称
	 * 
	 * @param Name_len_sampcoltime
	 */
	public void setName_len_sampcoltime(String Name_len_sampcoltime) {
		setAttrVal("Name_len_sampcoltime", Name_len_sampcoltime);
	}

	/**
	 * 采集时间类型名称
	 * 
	 * @return String
	 */
	public String getName_sampcollecttimetp() {
		return ((String) getAttrVal("Name_sampcollecttimetp"));
	}

	/**
	 * 采集时间类型名称
	 * 
	 * @param Name_sampcollecttimetp
	 */
	public void setName_sampcollecttimetp(String Name_sampcollecttimetp) {
		setAttrVal("Name_sampcollecttimetp", Name_sampcollecttimetp);
	}

	/**
	 * 时长单位名称
	 * 
	 * @return String
	 */
	public String getName_unit_sampcoltime() {
		return ((String) getAttrVal("Name_unit_sampcoltime"));
	}

	/**
	 * 时长单位名称
	 * 
	 * @param Name_unit_sampcoltime
	 */
	public void setName_unit_sampcoltime(String Name_unit_sampcoltime) {
		setAttrVal("Name_unit_sampcoltime", Name_unit_sampcoltime);
	}

	/**
	 * 药品列表
	 * @return
	 */
	public FArrayList getEmsOrDrugListEx() {
		return (FArrayList) getAttrVal("EmsOrDrugListEx");

	}
	/**
	 * 药品列表
	 * @return
	 */
	public void setEmsOrDrugListEx(FArrayList EmsOrDrugListEx) {

		setAttrVal("EmsOrDrugListEx", EmsOrDrugListEx);
	}

	/**
	 * 检验检查子项列表
	 * @return
	 */
	public FArrayList getEmsOrObsListEx() {
		return (FArrayList) getAttrVal("EmsOrObsListEx");

	}
	/**
	 * 检验检查子项列表
	 * @return
	 */
	public void setEmsOrObsListEx(FArrayList EmsOrObsList) {
		setAttrVal("EmsOrObsListEx", EmsOrObsList);
	}
	/**
	 * 服务套标志
	 * 
	 * @param Name_unit_sampcoltime
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	
	/**
	 * 计价模式
	 * 
	 * @param Name_unit_sampcoltime
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}

	/**
	 * 计价模式
	 * 
	 * @param Name_unit_sampcoltime
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
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
	
	/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
	/**
	 * 医嘱频次ID
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次ID
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 医嘱频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 频次下频次数
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}
	/**
	 * 频次下频次数
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 频次周期类型
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}
	/**
	 * 频次周期类型
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	
	/**
	 * 是否多次执行
	 * @return
	 */
	public FBoolean getIsmulexec() {
		return ((FBoolean) getAttrVal("Ismulexec"));
	}
	/**
	 * 是否多次执行
	 * @param Ismulexec
	 */
	public void setIsmulexec(FBoolean Ismulexec) {
		setAttrVal("Ismulexec", Ismulexec);
	}
	
	/**
	 * 是否多剂量
	 * @return
	 */
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}
	/**
	 * 是否多剂量
	 * @param Ismulexec
	 */
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
	}
	/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
}
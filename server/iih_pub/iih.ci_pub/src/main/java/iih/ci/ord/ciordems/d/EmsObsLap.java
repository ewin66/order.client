package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检查检验的项目 DTO数据 
 * 
 */
public class EmsObsLap extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * id
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 部位编码
	 * @return String
	 */
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}
	/**
	 * 部位编码
	 * @param Sd_body
	 */
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}
	/**
	 * 部位名称
	 * @return String
	 */
	public String getName_body() {
		return ((String) getAttrVal("Name_body"));
	}
	/**
	 * 部位名称
	 * @param Name_body
	 */
	public void setName_body(String Name_body) {
		setAttrVal("Name_body", Name_body);
	}
	/**
	 * 体位编码
	 * @return String
	 */
	public String getSd_pos() {
		return ((String) getAttrVal("Sd_pos"));
	}
	/**
	 * 体位编码
	 * @param Sd_pos
	 */
	public void setSd_pos(String Sd_pos) {
		setAttrVal("Sd_pos", Sd_pos);
	}
	/**
	 * 体位名称
	 * @return String
	 */
	public String getName_pos() {
		return ((String) getAttrVal("Name_pos"));
	}
	/**
	 * 体位名称
	 * @param Name_pos
	 */
	public void setName_pos(String Name_pos) {
		setAttrVal("Name_pos", Name_pos);
	}
	/**
	 * 是否可床边执行
	 * @return String
	 */
	public String getIf_mp_bed() {
		return ((String) getAttrVal("If_mp_bed"));
	}
	/**
	 * 是否可床边执行
	 * @param If_mp_bed
	 */
	public void setIf_mp_bed(String If_mp_bed) {
		setAttrVal("If_mp_bed", If_mp_bed);
	}
	/**
	 * 检验编码
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 检验编码
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 检验名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 检验名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 体位id
	 * @return String
	 */
	public String getId_pos() {
		return ((String) getAttrVal("Id_pos"));
	}
	/**
	 * 体位id
	 * @param Id_pos
	 */
	public void setId_pos(String Id_pos) {
		setAttrVal("Id_pos", Id_pos);
	}
	/**
	 * 部位id
	 * @return String
	 */
	public String getId_body() {
		return ((String) getAttrVal("Id_body"));
	}
	/**
	 * 部位id
	 * @param Id_body
	 */
	public void setId_body(String Id_body) {
		setAttrVal("Id_body", Id_body);
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
	 * 医嘱医疗单
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱医疗单
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}
	/**
	 * 服务类型名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 检查类型id
	 * @return String
	 */
	public String getId_obstp() {
		return ((String) getAttrVal("Id_obstp"));
	}
	/**
	 * 检查类型id
	 * @param Id_obstp
	 */
	public void setId_obstp(String Id_obstp) {
		setAttrVal("Id_obstp", Id_obstp);
	}
	/**
	 * 检查类型名称
	 * @return String
	 */
	public String getName_obstp() {
		return ((String) getAttrVal("Name_obstp"));
	}
	/**
	 * 检查类型名称
	 * @param Name_obstp
	 */
	public void setName_obstp(String Name_obstp) {
		setAttrVal("Name_obstp", Name_obstp);
	}
	/**
	 * 检查申请单号
	 * @return String
	 */
	public String getNo_applyobs() {
		return ((String) getAttrVal("No_applyobs"));
	}
	/**
	 * 检查申请单号
	 * @param No_applyobs
	 */
	public void setNo_applyobs(String No_applyobs) {
		setAttrVal("No_applyobs", No_applyobs);
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
	 * 床旁执行标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_bed() {
		return ((FBoolean) getAttrVal("Fg_mp_bed"));
	}
	/**
	 * 床旁执行标志
	 * @param Fg_mp_bed
	 */
	public void setFg_mp_bed(FBoolean Fg_mp_bed) {
		setAttrVal("Fg_mp_bed", Fg_mp_bed);
	}
	/**
	 * 计划检查时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划检查时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
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
	 * 诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 诊断编码拼接
	 * @return String
	 */
	public String getStr_id_di() {
		return ((String) getAttrVal("Str_id_di"));
	}
	/**
	 * 诊断编码拼接
	 * @param Str_id_di
	 */
	public void setStr_id_di(String Str_id_di) {
		setAttrVal("Str_id_di", Str_id_di);
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
	 * 检查目的编码
	 * @return String
	 */
	public String getSd_pps() {
		return ((String) getAttrVal("Sd_pps"));
	}
	/**
	 * 检查目的编码
	 * @param Sd_pps
	 */
	public void setSd_pps(String Sd_pps) {
		setAttrVal("Sd_pps", Sd_pps);
	}
	/**
	 * 检查目的
	 * @return String
	 */
	public String getId_pps() {
		return ((String) getAttrVal("Id_pps"));
	}
	/**
	 * 检查目的
	 * @param Id_pps
	 */
	public void setId_pps(String Id_pps) {
		setAttrVal("Id_pps", Id_pps);
	}
	/**
	 * 检查目的描述
	 * @return String
	 */
	public String getDes_pps() {
		return ((String) getAttrVal("Des_pps"));
	}
	/**
	 * 检查目的描述
	 * @param Des_pps
	 */
	public void setDes_pps(String Des_pps) {
		setAttrVal("Des_pps", Des_pps);
	}
	/**
	 * 症状体征描述
	 * @return String
	 */
	public String getDes_sympsign() {
		return ((String) getAttrVal("Des_sympsign"));
	}
	/**
	 * 症状体征描述
	 * @param Des_sympsign
	 */
	public void setDes_sympsign(String Des_sympsign) {
		setAttrVal("Des_sympsign", Des_sympsign);
	}
	/**
	 * 检查申请单状态
	 * @return String
	 */
	public String getId_su_obs() {
		return ((String) getAttrVal("Id_su_obs"));
	}
	/**
	 * 检查申请单状态
	 * @param Id_su_obs
	 */
	public void setId_su_obs(String Id_su_obs) {
		setAttrVal("Id_su_obs", Id_su_obs);
	}
	/**
	 * 检查申请单编码
	 * @return String
	 */
	public String getSd_su_obs() {
		return ((String) getAttrVal("Sd_su_obs"));
	}
	/**
	 * 检查申请单编码
	 * @param Sd_su_obs
	 */
	public void setSd_su_obs(String Sd_su_obs) {
		setAttrVal("Sd_su_obs", Sd_su_obs);
	}
	/**
	 * 标本类型id
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}
	/**
	 * 标本类型id
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	/**
	 * 标本类型名称
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}
	/**
	 * 标本类型名称
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
	/**
	 * 标本类型编码
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}
	/**
	 * 标本类型编码
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 选择
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}
	/**
	 * 选择
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
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
	 * 检验分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 检验分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 采集方法编码
	 * @return String
	 */
	public String getSd_colltp() {
		return ((String) getAttrVal("Sd_colltp"));
	}
	/**
	 * 采集方法编码
	 * @param Sd_colltp
	 */
	public void setSd_colltp(String Sd_colltp) {
		setAttrVal("Sd_colltp", Sd_colltp);
	}
	/**
	 * 采集方法id
	 * @return String
	 */
	public String getId_colltp() {
		return ((String) getAttrVal("Id_colltp"));
	}
	/**
	 * 采集方法id
	 * @param Id_colltp
	 */
	public void setId_colltp(String Id_colltp) {
		setAttrVal("Id_colltp", Id_colltp);
	}
	/**
	 * 标本说明
	 * @return String
	 */
	public String getDes_labsamp() {
		return ((String) getAttrVal("Des_labsamp"));
	}
	/**
	 * 标本说明
	 * @param Des_labsamp
	 */
	public void setDes_labsamp(String Des_labsamp) {
		setAttrVal("Des_labsamp", Des_labsamp);
	}
	/**
	 * 容器编码
	 * @return String
	 */
	public String getId_contp() {
		return ((String) getAttrVal("Id_contp"));
	}
	/**
	 * 容器编码
	 * @param Id_contp
	 */
	public void setId_contp(String Id_contp) {
		setAttrVal("Id_contp", Id_contp);
	}
	/**
	 * 容器id
	 * @return String
	 */
	public String getSd_contp() {
		return ((String) getAttrVal("Sd_contp"));
	}
	/**
	 * 容器id
	 * @param Sd_contp
	 */
	public void setSd_contp(String Sd_contp) {
		setAttrVal("Sd_contp", Sd_contp);
	}
	/**
	 * 标本需求量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 标本需求量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
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
	 * 检查组织描述
	 * @return String
	 */
	public String getBiopsy() {
		return ((String) getAttrVal("Biopsy"));
	}
	/**
	 * 检查组织描述
	 * @param Biopsy
	 */
	public void setBiopsy(String Biopsy) {
		setAttrVal("Biopsy", Biopsy);
	}
	/**
	 * 医嘱标志
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}
	/**
	 * 医嘱标志
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 医嘱类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 数值_医疗单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 数值_医疗单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医疗单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}
	/**
	 * 医疗单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 计费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 计费标志
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 可选标识
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}
	/**
	 * 可选标识
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	/**
	 * 部位可修改标示
	 * @return FBoolean
	 */
	public FBoolean getFg_body_update() {
		return ((FBoolean) getAttrVal("Fg_body_update"));
	}
	/**
	 * 部位可修改标示
	 * @param Fg_body_update
	 */
	public void setFg_body_update(FBoolean Fg_body_update) {
		setAttrVal("Fg_body_update", Fg_body_update);
	}
	/**
	 * 标本需求量单位
	 * @return String
	 */
	public String getId_quan() {
		return ((String) getAttrVal("Id_quan"));
	}
	/**
	 * 标本需求量单位
	 * @param Id_quan
	 */
	public void setId_quan(String Id_quan) {
		setAttrVal("Id_quan", Id_quan);
	}
	/**
	 * 医保
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 数据来源
	 * @return Integer
	 */
	public Integer getEu_sourcemd() {
		return ((Integer) getAttrVal("Eu_sourcemd"));
	}
	/**
	 * 数据来源
	 * @param Eu_sourcemd
	 */
	public void setEu_sourcemd(Integer Eu_sourcemd) {
		setAttrVal("Eu_sourcemd", Eu_sourcemd);
	}
	/**
	 * 服务来源
	 * @return String
	 */
	public String getId_srv_src() {
		return ((String) getAttrVal("Id_srv_src"));
	}
	/**
	 * 服务来源
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
	 * 标本采集时间
	 * @return FDateTime
	 */
	public FDateTime getId_sampcoltime() {
		return ((FDateTime) getAttrVal("Id_sampcoltime"));
	}
	/**
	 * 标本采集时间
	 * @param Id_sampcoltime
	 */
	public void setId_sampcoltime(FDateTime Id_sampcoltime) {
		setAttrVal("Id_sampcoltime", Id_sampcoltime);
	}
	/**
	 * 标本采集时长
	 * @return FDouble
	 */
	public FDouble getLen_sampcoltime() {
		return ((FDouble) getAttrVal("Len_sampcoltime"));
	}
	/**
	 * 标本采集时长
	 * @param Len_sampcoltime
	 */
	public void setLen_sampcoltime(FDouble Len_sampcoltime) {
		setAttrVal("Len_sampcoltime", Len_sampcoltime);
	}
	/**
	 * 时长单位
	 * @return String
	 */
	public String getId_unit_sampcoltime() {
		return ((String) getAttrVal("Id_unit_sampcoltime"));
	}
	/**
	 * 时长单位
	 * @param Id_unit_sampcoltime
	 */
	public void setId_unit_sampcoltime(String Id_unit_sampcoltime) {
		setAttrVal("Id_unit_sampcoltime", Id_unit_sampcoltime);
	}
	/**
	 * 标本采集时间类型采集时间类型
	 * @return String
	 */
	public String getId_sampcollecttimetp() {
		return ((String) getAttrVal("Id_sampcollecttimetp"));
	}
	/**
	 * 标本采集时间类型采集时间类型
	 * @param Id_sampcollecttimetp
	 */
	public void setId_sampcollecttimetp(String Id_sampcollecttimetp) {
		setAttrVal("Id_sampcollecttimetp", Id_sampcollecttimetp);
	}
	/**
	 * 采集时间编码
	 * @return String
	 */
	public String getSd_sampcollecttimetp() {
		return ((String) getAttrVal("Sd_sampcollecttimetp"));
	}
	/**
	 * 采集时间编码
	 * @param Sd_sampcollecttimetp
	 */
	public void setSd_sampcollecttimetp(String Sd_sampcollecttimetp) {
		setAttrVal("Sd_sampcollecttimetp", Sd_sampcollecttimetp);
	}
	/**
	 * 标本采集时间名称
	 * @return String
	 */
	public String getName_sampcoltime() {
		return ((String) getAttrVal("Name_sampcoltime"));
	}
	/**
	 * 标本采集时间名称
	 * @param Name_sampcoltime
	 */
	public void setName_sampcoltime(String Name_sampcoltime) {
		setAttrVal("Name_sampcoltime", Name_sampcoltime);
	}
	/**
	 * 采集时长名称
	 * @return String
	 */
	public String getName_len_sampcoltime() {
		return ((String) getAttrVal("Name_len_sampcoltime"));
	}
	/**
	 * 采集时长名称
	 * @param Name_len_sampcoltime
	 */
	public void setName_len_sampcoltime(String Name_len_sampcoltime) {
		setAttrVal("Name_len_sampcoltime", Name_len_sampcoltime);
	}
	/**
	 * 采集时间类型名称
	 * @return String
	 */
	public String getName_sampcollecttimetp() {
		return ((String) getAttrVal("Name_sampcollecttimetp"));
	}
	/**
	 * 采集时间类型名称
	 * @param Name_sampcollecttimetp
	 */
	public void setName_sampcollecttimetp(String Name_sampcollecttimetp) {
		setAttrVal("Name_sampcollecttimetp", Name_sampcollecttimetp);
	}
	/**
	 * 时长单位名称
	 * @return String
	 */
	public String getName_unit_sampcoltime() {
		return ((String) getAttrVal("Name_unit_sampcoltime"));
	}
	/**
	 * 时长单位名称
	 * @param Name_unit_sampcoltime
	 */
	public void setName_unit_sampcoltime(String Name_unit_sampcoltime) {
		setAttrVal("Name_unit_sampcoltime", Name_unit_sampcoltime);
	}
	/**
	 * 是否有检查部位
	 * @return FBoolean
	 */
	public FBoolean getFg_pos() {
		return ((FBoolean) getAttrVal("Fg_pos"));
	}
	/**
	 * 是否有检查部位
	 * @param Fg_pos
	 */
	public void setFg_pos(FBoolean Fg_pos) {
		setAttrVal("Fg_pos", Fg_pos);
	}
	/**
	 * 检验分组
	 * @return String
	 */
	public String getId_labgroup() {
		return ((String) getAttrVal("Id_labgroup"));
	}
	/**
	 * 检验分组
	 * @param Id_labgroup
	 */
	public void setId_labgroup(String Id_labgroup) {
		setAttrVal("Id_labgroup", Id_labgroup);
	}
	/**
	 * 检验分组编码
	 * @return String
	 */
	public String getSd_labgroup() {
		return ((String) getAttrVal("Sd_labgroup"));
	}
	/**
	 * 检验分组编码
	 * @param Sd_labgroup
	 */
	public void setSd_labgroup(String Sd_labgroup) {
		setAttrVal("Sd_labgroup", Sd_labgroup);
	}
	/**
	 * Eu_blmd
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * Eu_blmd
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 定价模式
	 * @return String
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}
	/**
	 * 定价模式
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
}
package iih.ci.mr.cimrpatinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病人基本和住院信息 DTO数据 
 * 
 */
public class CiMrPatInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊类型id
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型id
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 门诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}
	/**
	 * 门诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别id
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}
	/**
	 * 性别id
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex_pat() {
		return ((String) getAttrVal("Name_sex_pat"));
	}
	/**
	 * 性别
	 * @param Name_sex_pat
	 */
	public void setName_sex_pat(String Name_sex_pat) {
		setAttrVal("Name_sex_pat", Name_sex_pat);
	}
	/**
	 * 证件类型id
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 证件类型id
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件类型
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 证件号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 婚姻状况id
	 * @return String
	 */
	public String getId_mari_pat() {
		return ((String) getAttrVal("Id_mari_pat"));
	}
	/**
	 * 婚姻状况id
	 * @param Id_mari_pat
	 */
	public void setId_mari_pat(String Id_mari_pat) {
		setAttrVal("Id_mari_pat", Id_mari_pat);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getName_mari_pat() {
		return ((String) getAttrVal("Name_mari_pat"));
	}
	/**
	 * 婚姻状况
	 * @param Name_mari_pat
	 */
	public void setName_mari_pat(String Name_mari_pat) {
		setAttrVal("Name_mari_pat", Name_mari_pat);
	}
	/**
	 * 民族id
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}
	/**
	 * 民族id
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}
	/**
	 * 民族
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 国家id
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}
	/**
	 * 国家id
	 * @param Id_country
	 */
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	/**
	 * 国家
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}
	/**
	 * 国家
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
	}
	/**
	 * 职业id
	 * @return String
	 */
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}
	/**
	 * 职业id
	 * @param Id_occu
	 */
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}
	/**
	 * 职业
	 * @param Name_occu
	 */
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类id
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 患者价格分类id
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者价格分类id
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 患者价格分类
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 患者价格分类
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 患者信用分类id
	 * @return String
	 */
	public String getId_patcret() {
		return ((String) getAttrVal("Id_patcret"));
	}
	/**
	 * 患者信用分类id
	 * @param Id_patcret
	 */
	public void setId_patcret(String Id_patcret) {
		setAttrVal("Id_patcret", Id_patcret);
	}
	/**
	 * 患者信用分类
	 * @return String
	 */
	public String getName_patcret() {
		return ((String) getAttrVal("Name_patcret"));
	}
	/**
	 * 患者信用分类
	 * @param Name_patcret
	 */
	public void setName_patcret(String Name_patcret) {
		setAttrVal("Name_patcret", Name_patcret);
	}
	/**
	 * 主医保计划id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 主医保计划
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 主医保卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 主医保卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTel_num() {
		return ((String) getAttrVal("Tel_num"));
	}
	/**
	 * 联系电话
	 * @param Tel_num
	 */
	public void setTel_num(String Tel_num) {
		setAttrVal("Tel_num", Tel_num);
	}
	/**
	 * 出生地址
	 * @return String
	 */
	public String getAddr_born() {
		return ((String) getAttrVal("Addr_born"));
	}
	/**
	 * 出生地址
	 * @param Addr_born
	 */
	public void setAddr_born(String Addr_born) {
		setAttrVal("Addr_born", Addr_born);
	}
	/**
	 * 籍贯
	 * @return String
	 */
	public String getAddr_originc() {
		return ((String) getAttrVal("Addr_originc"));
	}
	/**
	 * 籍贯
	 * @param Addr_originc
	 */
	public void setAddr_originc(String Addr_originc) {
		setAttrVal("Addr_originc", Addr_originc);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}
	/**
	 * 工作单位
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	/**
	 * 工作地址
	 * @return String
	 */
	public String getAddr_work() {
		return ((String) getAttrVal("Addr_work"));
	}
	/**
	 * 工作地址
	 * @param Addr_work
	 */
	public void setAddr_work(String Addr_work) {
		setAttrVal("Addr_work", Addr_work);
	}
	/**
	 * 工作地址电话
	 * @return String
	 */
	public String getDel_addr_work() {
		return ((String) getAttrVal("Del_addr_work"));
	}
	/**
	 * 工作地址电话
	 * @param Del_addr_work
	 */
	public void setDel_addr_work(String Del_addr_work) {
		setAttrVal("Del_addr_work", Del_addr_work);
	}
	/**
	 * 工作地邮编
	 * @return String
	 */
	public String getZip_addr_work() {
		return ((String) getAttrVal("Zip_addr_work"));
	}
	/**
	 * 工作地邮编
	 * @param Zip_addr_work
	 */
	public void setZip_addr_work(String Zip_addr_work) {
		setAttrVal("Zip_addr_work", Zip_addr_work);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getName_cont() {
		return ((String) getAttrVal("Name_cont"));
	}
	/**
	 * 联系人
	 * @param Name_cont
	 */
	public void setName_cont(String Name_cont) {
		setAttrVal("Name_cont", Name_cont);
	}
	/**
	 * 联系人类型id
	 * @return String
	 */
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}
	/**
	 * 联系人类型id
	 * @param Id_conttp
	 */
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	/**
	 * 联系人类型
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 联系人类型
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getAddr_cont() {
		return ((String) getAttrVal("Addr_cont"));
	}
	/**
	 * 联系人地址
	 * @param Addr_cont
	 */
	public void setAddr_cont(String Addr_cont) {
		setAttrVal("Addr_cont", Addr_cont);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getTel_cont() {
		return ((String) getAttrVal("Tel_cont"));
	}
	/**
	 * 联系人电话
	 * @param Tel_cont
	 */
	public void setTel_cont(String Tel_cont) {
		setAttrVal("Tel_cont", Tel_cont);
	}
	/**
	 * 入院时间
	 * @return FDate
	 */
	public FDate getDt_acpt() {
		return ((FDate) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDate Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 入院科室id
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科室id
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 入院科室
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 入院病区id
	 * @return String
	 */
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}
	/**
	 * 入院病区id
	 * @param Id_dep_nuradm
	 */
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getName_dep_nuradm() {
		return ((String) getAttrVal("Name_dep_nuradm"));
	}
	/**
	 * 入院病区
	 * @param Name_dep_nuradm
	 */
	public void setName_dep_nuradm(String Name_dep_nuradm) {
		setAttrVal("Name_dep_nuradm", Name_dep_nuradm);
	}
	/**
	 * 住院诊断
	 * @return String
	 */
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}
	/**
	 * 住院诊断
	 * @param Id_didef_dis
	 */
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
	/**
	 * 住院诊断名称
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}
	/**
	 * 住院诊断名称
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 当前科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 当前科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 当前科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 当前科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 当前病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 当前病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 当前病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 当前病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 主管医生id
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 主管医生id
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 主管医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 主管医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 责任护士id
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}
	/**
	 * 责任护士id
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 责任护士
	 * @return String
	 */
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}
	/**
	 * 责任护士
	 * @param Name_emp_nur
	 */
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
	}
	/**
	 * 床位id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床位id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床位
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 护理等级id
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}
	/**
	 * 护理等级id
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	/**
	 * 护理等级
	 * @return String
	 */
	public String getName_level_nurname65() {
		return ((String) getAttrVal("Name_level_nurname65"));
	}
	/**
	 * 护理等级
	 * @param Name_level_nurname65
	 */
	public void setName_level_nurname65(String Name_level_nurname65) {
		setAttrVal("Name_level_nurname65", Name_level_nurname65);
	}
	/**
	 * 病情等级id
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病情等级id
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情等级
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}
	/**
	 * 病情等级
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
	}
	/**
	 * 新生儿标志
	 * @return String
	 */
	public String getFg_newborn() {
		return ((String) getAttrVal("Fg_newborn"));
	}
	/**
	 * 新生儿标志
	 * @param Fg_newborn
	 */
	public void setFg_newborn(String Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
	/**
	 * 住院天数
	 * @return String
	 */
	public String getInhosdays() {
		return ((String) getAttrVal("Inhosdays"));
	}
	/**
	 * 住院天数
	 * @param Inhosdays
	 */
	public void setInhosdays(String Inhosdays) {
		setAttrVal("Inhosdays", Inhosdays);
	}
	/**
	 * 出院病区id
	 * @return String
	 */
	public String getId_dep_nurdisc() {
		return ((String) getAttrVal("Id_dep_nurdisc"));
	}
	/**
	 * 出院病区id
	 * @param Id_dep_nurdisc
	 */
	public void setId_dep_nurdisc(String Id_dep_nurdisc) {
		setAttrVal("Id_dep_nurdisc", Id_dep_nurdisc);
	}
	/**
	 * 出院病区
	 * @return String
	 */
	public String getName_dep_nurdisc() {
		return ((String) getAttrVal("Name_dep_nurdisc"));
	}
	/**
	 * 出院病区
	 * @param Name_dep_nurdisc
	 */
	public void setName_dep_nurdisc(String Name_dep_nurdisc) {
		setAttrVal("Name_dep_nurdisc", Name_dep_nurdisc);
	}
	/**
	 * 出院科室id
	 * @return String
	 */
	public String getId_dep_phydisc() {
		return ((String) getAttrVal("Id_dep_phydisc"));
	}
	/**
	 * 出院科室id
	 * @param Id_dep_phydisc
	 */
	public void setId_dep_phydisc(String Id_dep_phydisc) {
		setAttrVal("Id_dep_phydisc", Id_dep_phydisc);
	}
	/**
	 * 出院科室
	 * @return String
	 */
	public String getName_dep_phydisc() {
		return ((String) getAttrVal("Name_dep_phydisc"));
	}
	/**
	 * 出院科室
	 * @param Name_dep_phydisc
	 */
	public void setName_dep_phydisc(String Name_dep_phydisc) {
		setAttrVal("Name_dep_phydisc", Name_dep_phydisc);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_outhos() {
		return ((FDateTime) getAttrVal("Dt_outhos"));
	}
	/**
	 * 出院时间
	 * @param Dt_outhos
	 */
	public void setDt_outhos(FDateTime Dt_outhos) {
		setAttrVal("Dt_outhos", Dt_outhos);
	}
	/**
	 * 在院标志
	 * @return String
	 */
	public String getFg_ip() {
		return ((String) getAttrVal("Fg_ip"));
	}
	/**
	 * 在院标志
	 * @param Fg_ip
	 */
	public void setFg_ip(String Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 死亡时间
	 * @return FDateTime
	 */
	public FDateTime getDt_death() {
		return ((FDateTime) getAttrVal("Dt_death"));
	}
	/**
	 * 死亡时间
	 * @param Dt_death
	 */
	public void setDt_death(FDateTime Dt_death) {
		setAttrVal("Dt_death", Dt_death);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getId_pre() {
		return ((String) getAttrVal("Id_pre"));
	}
	/**
	 * 域id
	 * @param Id_pre
	 */
	public void setId_pre(String Id_pre) {
		setAttrVal("Id_pre", Id_pre);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}
	/**
	 * 医疗机构编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrg() {
		return ((String) getAttrVal("Org"));
	}
	/**
	 * 医疗机构名称
	 * @param Org
	 */
	public void setOrg(String Org) {
		setAttrVal("Org", Org);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 卡片编号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 报卡类别
	 * @return String
	 */
	public String getEu_bklb() {
		return ((String) getAttrVal("Eu_bklb"));
	}
	/**
	 * 报卡类别
	 * @param Eu_bklb
	 */
	public void setEu_bklb(String Eu_bklb) {
		setAttrVal("Eu_bklb", Eu_bklb);
	}
	/**
	 * 报卡类别编码
	 * @return String
	 */
	public String getEu_bklb_code() {
		return ((String) getAttrVal("Eu_bklb_code"));
	}
	/**
	 * 报卡类别编码
	 * @param Eu_bklb_code
	 */
	public void setEu_bklb_code(String Eu_bklb_code) {
		setAttrVal("Eu_bklb_code", Eu_bklb_code);
	}
	/**
	 * 报卡类别名称
	 * @return String
	 */
	public String getEu_bklb_name() {
		return ((String) getAttrVal("Eu_bklb_name"));
	}
	/**
	 * 报卡类别名称
	 * @param Eu_bklb_name
	 */
	public void setEu_bklb_name(String Eu_bklb_name) {
		setAttrVal("Eu_bklb_name", Eu_bklb_name);
	}
	/**
	 * 传染卡状态
	 * @return String
	 */
	public String getId_con_cardsu() {
		return ((String) getAttrVal("Id_con_cardsu"));
	}
	/**
	 * 传染卡状态
	 * @param Id_con_cardsu
	 */
	public void setId_con_cardsu(String Id_con_cardsu) {
		setAttrVal("Id_con_cardsu", Id_con_cardsu);
	}
	/**
	 * 传染卡状态编码
	 * @return String
	 */
	public String getSd_con_cardsu() {
		return ((String) getAttrVal("Sd_con_cardsu"));
	}
	/**
	 * 传染卡状态编码
	 * @param Sd_con_cardsu
	 */
	public void setSd_con_cardsu(String Sd_con_cardsu) {
		setAttrVal("Sd_con_cardsu", Sd_con_cardsu);
	}
	/**
	 * 传染卡状态名称
	 * @return String
	 */
	public String getName_con_cardsu() {
		return ((String) getAttrVal("Name_con_cardsu"));
	}
	/**
	 * 传染卡状态名称
	 * @param Name_con_cardsu
	 */
	public void setName_con_cardsu(String Name_con_cardsu) {
		setAttrVal("Name_con_cardsu", Name_con_cardsu);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 订正病名
	 * @return String
	 */
	public String getRevised_name() {
		return ((String) getAttrVal("Revised_name"));
	}
	/**
	 * 订正病名
	 * @param Revised_name
	 */
	public void setRevised_name(String Revised_name) {
		setAttrVal("Revised_name", Revised_name);
	}
	/**
	 * 退卡原因
	 * @return String
	 */
	public String getRetreat_reason() {
		return ((String) getAttrVal("Retreat_reason"));
	}
	/**
	 * 退卡原因
	 * @param Retreat_reason
	 */
	public void setRetreat_reason(String Retreat_reason) {
		setAttrVal("Retreat_reason", Retreat_reason);
	}
	/**
	 * 报告单位
	 * @return String
	 */
	public String getReport_unit() {
		return ((String) getAttrVal("Report_unit"));
	}
	/**
	 * 报告单位
	 * @param Report_unit
	 */
	public void setReport_unit(String Report_unit) {
		setAttrVal("Report_unit", Report_unit);
	}
	/**
	 * 报告单位编码
	 * @return String
	 */
	public String getReport_unit_code() {
		return ((String) getAttrVal("Report_unit_code"));
	}
	/**
	 * 报告单位编码
	 * @param Report_unit_code
	 */
	public void setReport_unit_code(String Report_unit_code) {
		setAttrVal("Report_unit_code", Report_unit_code);
	}
	/**
	 * 报告单位名称
	 * @return String
	 */
	public String getReport_unit_name() {
		return ((String) getAttrVal("Report_unit_name"));
	}
	/**
	 * 报告单位名称
	 * @param Report_unit_name
	 */
	public void setReport_unit_name(String Report_unit_name) {
		setAttrVal("Report_unit_name", Report_unit_name);
	}
	/**
	 * 填卡医生
	 * @return String
	 */
	public String getDoctor_card() {
		return ((String) getAttrVal("Doctor_card"));
	}
	/**
	 * 填卡医生
	 * @param Doctor_card
	 */
	public void setDoctor_card(String Doctor_card) {
		setAttrVal("Doctor_card", Doctor_card);
	}
	/**
	 * 甲类传染病
	 * @return String
	 */
	public String getEu_jlcrb() {
		return ((String) getAttrVal("Eu_jlcrb"));
	}
	/**
	 * 甲类传染病
	 * @param Eu_jlcrb
	 */
	public void setEu_jlcrb(String Eu_jlcrb) {
		setAttrVal("Eu_jlcrb", Eu_jlcrb);
	}
	/**
	 * 甲类传染病编码
	 * @return String
	 */
	public String getEu_jlcrb_code() {
		return ((String) getAttrVal("Eu_jlcrb_code"));
	}
	/**
	 * 甲类传染病编码
	 * @param Eu_jlcrb_code
	 */
	public void setEu_jlcrb_code(String Eu_jlcrb_code) {
		setAttrVal("Eu_jlcrb_code", Eu_jlcrb_code);
	}
	/**
	 * 甲类传染病名称
	 * @return String
	 */
	public String getEu_jlcrb_name() {
		return ((String) getAttrVal("Eu_jlcrb_name"));
	}
	/**
	 * 甲类传染病名称
	 * @param Eu_jlcrb_name
	 */
	public void setEu_jlcrb_name(String Eu_jlcrb_name) {
		setAttrVal("Eu_jlcrb_name", Eu_jlcrb_name);
	}
	/**
	 * 乙类传染病
	 * @return String
	 */
	public String getEu_ylcrb() {
		return ((String) getAttrVal("Eu_ylcrb"));
	}
	/**
	 * 乙类传染病
	 * @param Eu_ylcrb
	 */
	public void setEu_ylcrb(String Eu_ylcrb) {
		setAttrVal("Eu_ylcrb", Eu_ylcrb);
	}
	/**
	 * 乙类传染病编码
	 * @return String
	 */
	public String getEu_ylcrb_code() {
		return ((String) getAttrVal("Eu_ylcrb_code"));
	}
	/**
	 * 乙类传染病编码
	 * @param Eu_ylcrb_code
	 */
	public void setEu_ylcrb_code(String Eu_ylcrb_code) {
		setAttrVal("Eu_ylcrb_code", Eu_ylcrb_code);
	}
	/**
	 * 乙类传染病名称
	 * @return String
	 */
	public String getEu_ylcrb_name() {
		return ((String) getAttrVal("Eu_ylcrb_name"));
	}
	/**
	 * 乙类传染病名称
	 * @param Eu_ylcrb_name
	 */
	public void setEu_ylcrb_name(String Eu_ylcrb_name) {
		setAttrVal("Eu_ylcrb_name", Eu_ylcrb_name);
	}
	/**
	 * 丙类传染病
	 * @return String
	 */
	public String getEu_blcrb() {
		return ((String) getAttrVal("Eu_blcrb"));
	}
	/**
	 * 丙类传染病
	 * @param Eu_blcrb
	 */
	public void setEu_blcrb(String Eu_blcrb) {
		setAttrVal("Eu_blcrb", Eu_blcrb);
	}
	/**
	 * 丙类传染病编码
	 * @return String
	 */
	public String getEu_blcrb_code() {
		return ((String) getAttrVal("Eu_blcrb_code"));
	}
	/**
	 * 丙类传染病编码
	 * @param Eu_blcrb_code
	 */
	public void setEu_blcrb_code(String Eu_blcrb_code) {
		setAttrVal("Eu_blcrb_code", Eu_blcrb_code);
	}
	/**
	 * 病类传染病名称
	 * @return String
	 */
	public String getEu_blcrb_name() {
		return ((String) getAttrVal("Eu_blcrb_name"));
	}
	/**
	 * 病类传染病名称
	 * @param Eu_blcrb_name
	 */
	public void setEu_blcrb_name(String Eu_blcrb_name) {
		setAttrVal("Eu_blcrb_name", Eu_blcrb_name);
	}
	/**
	 * 其他传染病
	 * @return String
	 */
	public String getId_other_diseases() {
		return ((String) getAttrVal("Id_other_diseases"));
	}
	/**
	 * 其他传染病
	 * @param Id_other_diseases
	 */
	public void setId_other_diseases(String Id_other_diseases) {
		setAttrVal("Id_other_diseases", Id_other_diseases);
	}
	/**
	 * 其他传染病编码
	 * @return String
	 */
	public String getSd_other_diseases() {
		return ((String) getAttrVal("Sd_other_diseases"));
	}
	/**
	 * 其他传染病编码
	 * @param Sd_other_diseases
	 */
	public void setSd_other_diseases(String Sd_other_diseases) {
		setAttrVal("Sd_other_diseases", Sd_other_diseases);
	}
	/**
	 * 其他传染病名称
	 * @return String
	 */
	public String getName_other_diseases() {
		return ((String) getAttrVal("Name_other_diseases"));
	}
	/**
	 * 其他传染病名称
	 * @param Name_other_diseases
	 */
	public void setName_other_diseases(String Name_other_diseases) {
		setAttrVal("Name_other_diseases", Name_other_diseases);
	}
	/**
	 * 有无相同症状
	 * @return FBoolean
	 */
	public FBoolean getIs_alike() {
		return ((FBoolean) getAttrVal("Is_alike"));
	}
	/**
	 * 有无相同症状
	 * @param Is_alike
	 */
	public void setIs_alike(FBoolean Is_alike) {
		setAttrVal("Is_alike", Is_alike);
	}
	/**
	 * 病例分类
	 * @return String
	 */
	public String getEu_blfl() {
		return ((String) getAttrVal("Eu_blfl"));
	}
	/**
	 * 病例分类
	 * @param Eu_blfl
	 */
	public void setEu_blfl(String Eu_blfl) {
		setAttrVal("Eu_blfl", Eu_blfl);
	}
	/**
	 * 病例分类编码
	 * @return String
	 */
	public String getEu_blfl_code() {
		return ((String) getAttrVal("Eu_blfl_code"));
	}
	/**
	 * 病例分类编码
	 * @param Eu_blfl_code
	 */
	public void setEu_blfl_code(String Eu_blfl_code) {
		setAttrVal("Eu_blfl_code", Eu_blfl_code);
	}
	/**
	 * 病例分类名称
	 * @return String
	 */
	public String getEu_blfl_name() {
		return ((String) getAttrVal("Eu_blfl_name"));
	}
	/**
	 * 病例分类名称
	 * @param Eu_blfl_name
	 */
	public void setEu_blfl_name(String Eu_blfl_name) {
		setAttrVal("Eu_blfl_name", Eu_blfl_name);
	}
	/**
	 * 病人属于
	 * @return String
	 */
	public String getEu_brsy() {
		return ((String) getAttrVal("Eu_brsy"));
	}
	/**
	 * 病人属于
	 * @param Eu_brsy
	 */
	public void setEu_brsy(String Eu_brsy) {
		setAttrVal("Eu_brsy", Eu_brsy);
	}
	/**
	 * 病人属于编码
	 * @return String
	 */
	public String getEu_brsy_code() {
		return ((String) getAttrVal("Eu_brsy_code"));
	}
	/**
	 * 病人属于编码
	 * @param Eu_brsy_code
	 */
	public void setEu_brsy_code(String Eu_brsy_code) {
		setAttrVal("Eu_brsy_code", Eu_brsy_code);
	}
	/**
	 * 病人属于名称
	 * @return String
	 */
	public String getEu_brsy_name() {
		return ((String) getAttrVal("Eu_brsy_name"));
	}
	/**
	 * 病人属于名称
	 * @param Eu_brsy_name
	 */
	public void setEu_brsy_name(String Eu_brsy_name) {
		setAttrVal("Eu_brsy_name", Eu_brsy_name);
	}
	/**
	 * 人群分类
	 * @return String
	 */
	public String getEu_rqfl() {
		return ((String) getAttrVal("Eu_rqfl"));
	}
	/**
	 * 人群分类
	 * @param Eu_rqfl
	 */
	public void setEu_rqfl(String Eu_rqfl) {
		setAttrVal("Eu_rqfl", Eu_rqfl);
	}
	/**
	 * 人群分类编码
	 * @return String
	 */
	public String getEu_rqfl_code() {
		return ((String) getAttrVal("Eu_rqfl_code"));
	}
	/**
	 * 人群分类编码
	 * @param Eu_rqfl_code
	 */
	public void setEu_rqfl_code(String Eu_rqfl_code) {
		setAttrVal("Eu_rqfl_code", Eu_rqfl_code);
	}
	/**
	 * 人群分类名称
	 * @return String
	 */
	public String getEu_rqfl_name() {
		return ((String) getAttrVal("Eu_rqfl_name"));
	}
	/**
	 * 人群分类名称
	 * @param Eu_rqfl_name
	 */
	public void setEu_rqfl_name(String Eu_rqfl_name) {
		setAttrVal("Eu_rqfl_name", Eu_rqfl_name);
	}
	/**
	 * 患者家长姓名
	 * @return String
	 */
	public String getHzjzxm() {
		return ((String) getAttrVal("Hzjzxm"));
	}
	/**
	 * 患者家长姓名
	 * @param Hzjzxm
	 */
	public void setHzjzxm(String Hzjzxm) {
		setAttrVal("Hzjzxm", Hzjzxm);
	}
	/**
	 * 发病日期
	 * @return FDate
	 */
	public FDate getFbrq() {
		return ((FDate) getAttrVal("Fbrq"));
	}
	/**
	 * 发病日期
	 * @param Fbrq
	 */
	public void setFbrq(FDate Fbrq) {
		setAttrVal("Fbrq", Fbrq);
	}
	/**
	 * 诊断日期
	 * @return FDateTime
	 */
	public FDateTime getZdrq() {
		return ((FDateTime) getAttrVal("Zdrq"));
	}
	/**
	 * 诊断日期
	 * @param Zdrq
	 */
	public void setZdrq(FDateTime Zdrq) {
		setAttrVal("Zdrq", Zdrq);
	}
	/**
	 * 死亡日期
	 * @return FDate
	 */
	public FDate getSwrq() {
		return ((FDate) getAttrVal("Swrq"));
	}
	/**
	 * 死亡日期
	 * @param Swrq
	 */
	public void setSwrq(FDate Swrq) {
		setAttrVal("Swrq", Swrq);
	}
	/**
	 * 年龄单位
	 * @return String
	 */
	public String getEu_nldw() {
		return ((String) getAttrVal("Eu_nldw"));
	}
	/**
	 * 年龄单位
	 * @param Eu_nldw
	 */
	public void setEu_nldw(String Eu_nldw) {
		setAttrVal("Eu_nldw", Eu_nldw);
	}
	/**
	 * 年龄单位编码
	 * @return String
	 */
	public String getEu_nldw_code() {
		return ((String) getAttrVal("Eu_nldw_code"));
	}
	/**
	 * 年龄单位编码
	 * @param Eu_nldw_code
	 */
	public void setEu_nldw_code(String Eu_nldw_code) {
		setAttrVal("Eu_nldw_code", Eu_nldw_code);
	}
	/**
	 * 年龄单位名称
	 * @return String
	 */
	public String getEu_nldw_name() {
		return ((String) getAttrVal("Eu_nldw_name"));
	}
	/**
	 * 年龄单位名称
	 * @param Eu_nldw_name
	 */
	public void setEu_nldw_name(String Eu_nldw_name) {
		setAttrVal("Eu_nldw_name", Eu_nldw_name);
	}
	/**
	 * 报卡医生
	 * @return String
	 */
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}
	/**
	 * 报卡医生
	 * @param Id_emp_entry
	 */
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	/**
	 * 报卡医生编码
	 * @return String
	 */
	public String getSd_emp_entry() {
		return ((String) getAttrVal("Sd_emp_entry"));
	}
	/**
	 * 报卡医生编码
	 * @param Sd_emp_entry
	 */
	public void setSd_emp_entry(String Sd_emp_entry) {
		setAttrVal("Sd_emp_entry", Sd_emp_entry);
	}
	/**
	 * 报卡医生名称
	 * @return String
	 */
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}
	/**
	 * 报卡医生名称
	 * @param Name_emp_entry
	 */
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
	}
	/**
	 * 实足年龄
	 * @return Integer
	 */
	public Integer getExact_age() {
		return ((Integer) getAttrVal("Exact_age"));
	}
	/**
	 * 实足年龄
	 * @param Exact_age
	 */
	public void setExact_age(Integer Exact_age) {
		setAttrVal("Exact_age", Exact_age);
	}
	/**
	 * 患者联系电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 患者联系电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getId_province() {
		return ((String) getAttrVal("Id_province"));
	}
	/**
	 * 现住址
	 * @param Id_province
	 */
	public void setId_province(String Id_province) {
		setAttrVal("Id_province", Id_province);
	}
	/**
	 * 现住址编码
	 * @return String
	 */
	public String getSd_province() {
		return ((String) getAttrVal("Sd_province"));
	}
	/**
	 * 现住址编码
	 * @param Sd_province
	 */
	public void setSd_province(String Sd_province) {
		setAttrVal("Sd_province", Sd_province);
	}
	/**
	 * 现住址名称
	 * @return String
	 */
	public String getName_province() {
		return ((String) getAttrVal("Name_province"));
	}
	/**
	 * 现住址名称
	 * @param Name_province
	 */
	public void setName_province(String Name_province) {
		setAttrVal("Name_province", Name_province);
	}
	/**
	 * 乡（镇、街道）
	 * @return String
	 */
	public String getStreet() {
		return ((String) getAttrVal("Street"));
	}
	/**
	 * 乡（镇、街道）
	 * @param Street
	 */
	public void setStreet(String Street) {
		setAttrVal("Street", Street);
	}
	/**
	 * 村
	 * @return String
	 */
	public String getVillage() {
		return ((String) getAttrVal("Village"));
	}
	/**
	 * 村
	 * @param Village
	 */
	public void setVillage(String Village) {
		setAttrVal("Village", Village);
	}
	/**
	 * （门牌号）
	 * @return String
	 */
	public String getHousenum() {
		return ((String) getAttrVal("Housenum"));
	}
	/**
	 * （门牌号）
	 * @param Housenum
	 */
	public void setHousenum(String Housenum) {
		setAttrVal("Housenum", Housenum);
	}
	/**
	 * 户籍地址
	 * @return String
	 */
	public String getResidence_addr() {
		return ((String) getAttrVal("Residence_addr"));
	}
	/**
	 * 户籍地址
	 * @param Residence_addr
	 */
	public void setResidence_addr(String Residence_addr) {
		setAttrVal("Residence_addr", Residence_addr);
	}
	/**
	 * 户籍地址编码
	 * @return String
	 */
	public String getResidence_code() {
		return ((String) getAttrVal("Residence_code"));
	}
	/**
	 * 户籍地址编码
	 * @param Residence_code
	 */
	public void setResidence_code(String Residence_code) {
		setAttrVal("Residence_code", Residence_code);
	}
	/**
	 * 户籍地址名称
	 * @return String
	 */
	public String getResidence() {
		return ((String) getAttrVal("Residence"));
	}
	/**
	 * 户籍地址名称
	 * @param Residence
	 */
	public void setResidence(String Residence) {
		setAttrVal("Residence", Residence);
	}
	/**
	 * 填卡日期
	 * @return FDate
	 */
	public FDate getDt_contagion() {
		return ((FDate) getAttrVal("Dt_contagion"));
	}
	/**
	 * 填卡日期
	 * @param Dt_contagion
	 */
	public void setDt_contagion(FDate Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}
	/**
	 * 联系电话1
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 联系电话1
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 病情分类编码
	 * @return String
	 */
	public String getCode_eu_bqfl() {
		return ((String) getAttrVal("Code_eu_bqfl"));
	}
	/**
	 * 病情分类编码
	 * @param Code_eu_bqfl
	 */
	public void setCode_eu_bqfl(String Code_eu_bqfl) {
		setAttrVal("Code_eu_bqfl", Code_eu_bqfl);
	}
	/**
	 * 病情分类名称
	 * @return String
	 */
	public String getName_eu_bqfl() {
		return ((String) getAttrVal("Name_eu_bqfl"));
	}
	/**
	 * 病情分类名称
	 * @param Name_eu_bqfl
	 */
	public void setName_eu_bqfl(String Name_eu_bqfl) {
		setAttrVal("Name_eu_bqfl", Name_eu_bqfl);
	}
	/**
	 * 传染病分类编码
	 * @return String
	 */
	public String getCode_congation_type() {
		return ((String) getAttrVal("Code_congation_type"));
	}
	/**
	 * 传染病分类编码
	 * @param Code_congation_type
	 */
	public void setCode_congation_type(String Code_congation_type) {
		setAttrVal("Code_congation_type", Code_congation_type);
	}
	/**
	 * 传染病分类名称
	 * @return String
	 */
	public String getName_congation_type() {
		return ((String) getAttrVal("Name_congation_type"));
	}
	/**
	 * 传染病分类名称
	 * @param Name_congation_type
	 */
	public void setName_congation_type(String Name_congation_type) {
		setAttrVal("Name_congation_type", Name_congation_type);
	}
	/**
	 * 传染病编码
	 * @return String
	 */
	public String getCode_congationnew() {
		return ((String) getAttrVal("Code_congationnew"));
	}
	/**
	 * 传染病编码
	 * @param Code_congationnew
	 */
	public void setCode_congationnew(String Code_congationnew) {
		setAttrVal("Code_congationnew", Code_congationnew);
	}
	/**
	 * 传染病名称
	 * @return String
	 */
	public String getName_congationnew() {
		return ((String) getAttrVal("Name_congationnew"));
	}
	/**
	 * 传染病名称
	 * @param Name_congationnew
	 */
	public void setName_congationnew(String Name_congationnew) {
		setAttrVal("Name_congationnew", Name_congationnew);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemarks() {
		return ((String) getAttrVal("Remarks"));
	}
	/**
	 * 备注
	 * @param Remarks
	 */
	public void setRemarks(String Remarks) {
		setAttrVal("Remarks", Remarks);
	}
	/**
	 * 是否传染病
	 * @return String
	 */
	public String getFg_crb() {
		return ((String) getAttrVal("Fg_crb"));
	}
	/**
	 * 是否传染病
	 * @param Fg_crb
	 */
	public void setFg_crb(String Fg_crb) {
		setAttrVal("Fg_crb", Fg_crb);
	}
}
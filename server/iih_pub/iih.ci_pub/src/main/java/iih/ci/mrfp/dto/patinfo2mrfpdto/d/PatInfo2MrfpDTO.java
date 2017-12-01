package iih.ci.mrfp.dto.patinfo2mrfpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

/**
 * 病案首页 标题显示与患者信息 DTO数据 
 * 
 */
public class PatInfo2MrfpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院病历首页ID
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}
	/**
	 * 住院病历首页ID
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**
	 * 住院首页类型
	 * @return String
	 */
	public String getSd_mrfptp() {
		return ((String) getAttrVal("Sd_mrfptp"));
	}
	/**
	 * 住院首页类型
	 * @param Sd_mrfptp
	 */
	public void setSd_mrfptp(String Sd_mrfptp) {
		setAttrVal("Sd_mrfptp", Sd_mrfptp);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 住院病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 就诊类型ID
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型ID
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}
	/**
	 * 性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别ID
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}
	/**
	 * 性别ID
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
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
	 * 国籍
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}
	/**
	 * 国籍
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
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
	 * 婚姻编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}
	/**
	 * 婚姻编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 证件类型
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 证件类型名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件类型名称
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
	public String getAddr_origin() {
		return ((String) getAttrVal("Addr_origin"));
	}
	/**
	 * 籍贯
	 * @param Addr_origin
	 */
	public void setAddr_origin(String Addr_origin) {
		setAttrVal("Addr_origin", Addr_origin);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getAddr_now() {
		return ((String) getAttrVal("Addr_now"));
	}
	/**
	 * 现住址
	 * @param Addr_now
	 */
	public void setAddr_now(String Addr_now) {
		setAttrVal("Addr_now", Addr_now);
	}
	/**
	 * 现住址电话
	 * @return String
	 */
	public String getTel_addr_now() {
		return ((String) getAttrVal("Tel_addr_now"));
	}
	/**
	 * 现住址电话
	 * @param Tel_addr_now
	 */
	public void setTel_addr_now(String Tel_addr_now) {
		setAttrVal("Tel_addr_now", Tel_addr_now);
	}
	/**
	 * 现住址邮编
	 * @return String
	 */
	public String getZip_addr_now() {
		return ((String) getAttrVal("Zip_addr_now"));
	}
	/**
	 * 现住址邮编
	 * @param Zip_addr_now
	 */
	public void setZip_addr_now(String Zip_addr_now) {
		setAttrVal("Zip_addr_now", Zip_addr_now);
	}
	/**
	 * 户口地址
	 * @return String
	 */
	public String getAddr_cencus() {
		return ((String) getAttrVal("Addr_cencus"));
	}
	/**
	 * 户口地址
	 * @param Addr_cencus
	 */
	public void setAddr_cencus(String Addr_cencus) {
		setAttrVal("Addr_cencus", Addr_cencus);
	}
	/**
	 * 户口地址邮编
	 * @return String
	 */
	public String getZip_addr_cencus() {
		return ((String) getAttrVal("Zip_addr_cencus"));
	}
	/**
	 * 户口地址邮编
	 * @param Zip_addr_cencus
	 */
	public void setZip_addr_cencus(String Zip_addr_cencus) {
		setAttrVal("Zip_addr_cencus", Zip_addr_cencus);
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
	 * 工作地址邮编
	 * @return String
	 */
	public String getZip_addr_work() {
		return ((String) getAttrVal("Zip_addr_work"));
	}
	/**
	 * 工作地址邮编
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
	 * 关系
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 关系
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
	 * 责任医生ID
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 责任医生ID
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 责任医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 责任医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 责任护士ID
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}
	/**
	 * 责任护士ID
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
	 * 主任医师ID
	 * @return String
	 */
	public String getId_zr_doc() {
		return ((String) getAttrVal("Id_zr_doc"));
	}
	/**
	 * 主任医师ID
	 * @param Id_zr_doc
	 */
	public void setId_zr_doc(String Id_zr_doc) {
		setAttrVal("Id_zr_doc", Id_zr_doc);
	}
	/**
	 * 主任医师
	 * @return String
	 */
	public String getName_zr_doc() {
		return ((String) getAttrVal("Name_zr_doc"));
	}
	/**
	 * 主任医师
	 * @param Name_zr_doc
	 */
	public void setName_zr_doc(String Name_zr_doc) {
		setAttrVal("Name_zr_doc", Name_zr_doc);
	}
	/**
	 * 主治医生ID
	 * @return String
	 */
	public String getId_zz_doc() {
		return ((String) getAttrVal("Id_zz_doc"));
	}
	/**
	 * 主治医生ID
	 * @param Id_zz_doc
	 */
	public void setId_zz_doc(String Id_zz_doc) {
		setAttrVal("Id_zz_doc", Id_zz_doc);
	}
	/**
	 * 主治医生
	 * @return String
	 */
	public String getName_zz_doc() {
		return ((String) getAttrVal("Name_zz_doc"));
	}
	/**
	 * 主治医生
	 * @param Name_zz_doc
	 */
	public void setName_zz_doc(String Name_zz_doc) {
		setAttrVal("Name_zz_doc", Name_zz_doc);
	}
	/**
	 * 住院医生ID
	 * @return String
	 */
	public String getId_zy_doc() {
		return ((String) getAttrVal("Id_zy_doc"));
	}
	/**
	 * 住院医生ID
	 * @param Id_zy_doc
	 */
	public void setId_zy_doc(String Id_zy_doc) {
		setAttrVal("Id_zy_doc", Id_zy_doc);
	}
	/**
	 * 住院医生
	 * @return String
	 */
	public String getName_zy_doc() {
		return ((String) getAttrVal("Name_zy_doc"));
	}
	/**
	 * 住院医生
	 * @param Name_zy_doc
	 */
	public void setName_zy_doc(String Name_zy_doc) {
		setAttrVal("Name_zy_doc", Name_zy_doc);
	}
	/**
	 * 医疗付费方式
	 * @return String
	 */
	public String getName_pay_method() {
		return ((String) getAttrVal("Name_pay_method"));
	}
	/**
	 * 医疗付费方式
	 * @param Name_pay_method
	 */
	public void setName_pay_method(String Name_pay_method) {
		setAttrVal("Name_pay_method", Name_pay_method);
	}
	/**
	 * 医疗付费方式ID
	 * @return String
	 */
	public String getId_pay_method() {
		return ((String) getAttrVal("Id_pay_method"));
	}
	/**
	 * 医疗付费方式ID
	 * @param Id_pay_method
	 */
	public void setId_pay_method(String Id_pay_method) {
		setAttrVal("Id_pay_method", Id_pay_method);
	}
	/**
	 * 医疗付费方式编码
	 * @return String
	 */
	public String getSd_pay_method() {
		return ((String) getAttrVal("Sd_pay_method"));
	}
	/**
	 * 医疗付费方式编码
	 * @param Sd_pay_method
	 */
	public void setSd_pay_method(String Sd_pay_method) {
		setAttrVal("Sd_pay_method", Sd_pay_method);
	}
	/**
	 * 第几次住院
	 * @return String
	 */
	public String getN_times_inhospital() {
		return ((String) getAttrVal("N_times_inhospital"));
	}
	/**
	 * 第几次住院
	 * @param N_times_inhospital
	 */
	public void setN_times_inhospital(String N_times_inhospital) {
		setAttrVal("N_times_inhospital", N_times_inhospital);
	}
	/**
	 * 入院途径
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}
	/**
	 * 入院途径
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 入院科别
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科别
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 转科科别
	 * @return String
	 */
	public String getId_dep_trans() {
		return ((String) getAttrVal("Id_dep_trans"));
	}
	/**
	 * 转科科别
	 * @param Id_dep_trans
	 */
	public void setId_dep_trans(String Id_dep_trans) {
		setAttrVal("Id_dep_trans", Id_dep_trans);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 出院科别
	 * @return String
	 */
	public String getId_dep_phydisc() {
		return ((String) getAttrVal("Id_dep_phydisc"));
	}
	/**
	 * 出院科别
	 * @param Id_dep_phydisc
	 */
	public void setId_dep_phydisc(String Id_dep_phydisc) {
		setAttrVal("Id_dep_phydisc", Id_dep_phydisc);
	}
	/**
	 * 实际住院天数
	 * @return Integer
	 */
	public Integer getHosdays() {
		return ((Integer) getAttrVal("Hosdays"));
	}
	/**
	 * 实际住院天数
	 * @param Hosdays
	 */
	public void setHosdays(Integer Hosdays) {
		setAttrVal("Hosdays", Hosdays);
	}
	/**
	 * 入院病房
	 * @return String
	 */
	public String getIn_id_bed() {
		return ((String) getAttrVal("In_id_bed"));
	}
	/**
	 * 入院病房
	 * @param In_id_bed
	 */
	public void setIn_id_bed(String In_id_bed) {
		setAttrVal("In_id_bed", In_id_bed);
	}
	/**
	 * 出院病房
	 * @return String
	 */
	public String getOut_id_bed() {
		return ((String) getAttrVal("Out_id_bed"));
	}
	/**
	 * 出院病房
	 * @param Out_id_bed
	 */
	public void setOut_id_bed(String Out_id_bed) {
		setAttrVal("Out_id_bed", Out_id_bed);
	}
}
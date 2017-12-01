package iih.ci.diag.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊断dto DTO数据 
 * 
 */
public class DIDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 基础数据诊断id
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * 基础数据诊断id
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDidef_code() {
		return ((String) getAttrVal("Didef_code"));
	}
	/**
	 * 诊断编码
	 * @param Didef_code
	 */
	public void setDidef_code(String Didef_code) {
		setAttrVal("Didef_code", Didef_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDidef_name() {
		return ((String) getAttrVal("Didef_name"));
	}
	/**
	 * 诊断名称
	 * @param Didef_name
	 */
	public void setDidef_name(String Didef_name) {
		setAttrVal("Didef_name", Didef_name);
	}
	/**
	 * 诊断类型
	 * @return String
	 */
	public String getId_ditp() {
		return ((String) getAttrVal("Id_ditp"));
	}
	/**
	 * 诊断类型
	 * @param Id_ditp
	 */
	public void setId_ditp(String Id_ditp) {
		setAttrVal("Id_ditp", Id_ditp);
	}
	/**
	 * 诊断类型编码
	 * @return String
	 */
	public String getSd_ditp() {
		return ((String) getAttrVal("Sd_ditp"));
	}
	/**
	 * 诊断类型编码
	 * @param Sd_ditp
	 */
	public void setSd_ditp(String Sd_ditp) {
		setAttrVal("Sd_ditp", Sd_ditp);
	}
	/**
	 * 诊断类型名称
	 * @return String
	 */
	public String getId_ditp_name() {
		return ((String) getAttrVal("Id_ditp_name"));
	}
	/**
	 * 诊断类型名称
	 * @param Id_ditp_name
	 */
	public void setId_ditp_name(String Id_ditp_name) {
		setAttrVal("Id_ditp_name", Id_ditp_name);
	}
	/**
	 * 证候诊断
	 * @return String
	 */
	public String getId_didef_syn() {
		return ((String) getAttrVal("Id_didef_syn"));
	}
	/**
	 * 证候诊断
	 * @param Id_didef_syn
	 */
	public void setId_didef_syn(String Id_didef_syn) {
		setAttrVal("Id_didef_syn", Id_didef_syn);
	}
	/**
	 * 证候诊断编码
	 * @return String
	 */
	public String getId_didef_syn_code() {
		return ((String) getAttrVal("Id_didef_syn_code"));
	}
	/**
	 * 证候诊断编码
	 * @param Id_didef_syn_code
	 */
	public void setId_didef_syn_code(String Id_didef_syn_code) {
		setAttrVal("Id_didef_syn_code", Id_didef_syn_code);
	}
	/**
	 * 证候诊断名称
	 * @return String
	 */
	public String getId_didef_syn_name() {
		return ((String) getAttrVal("Id_didef_syn_name"));
	}
	/**
	 * 证候诊断名称
	 * @param Id_didef_syn_name
	 */
	public void setId_didef_syn_name(String Id_didef_syn_name) {
		setAttrVal("Id_didef_syn_name", Id_didef_syn_name);
	}
	/**
	 * 疑似
	 * @return FBoolean
	 */
	public FBoolean getFg_suspdi() {
		return ((FBoolean) getAttrVal("Fg_suspdi"));
	}
	/**
	 * 疑似
	 * @param Fg_suspdi
	 */
	public void setFg_suspdi(FBoolean Fg_suspdi) {
		setAttrVal("Fg_suspdi", Fg_suspdi);
	}
	/**
	 * 补充说明
	 * @return String
	 */
	public String getSupplement() {
		return ((String) getAttrVal("Supplement"));
	}
	/**
	 * 补充说明
	 * @param Supplement
	 */
	public void setSupplement(String Supplement) {
		setAttrVal("Supplement", Supplement);
	}
	/**
	 * 诊断医生
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}
	/**
	 * 诊断医生
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getId_emp_create_name() {
		return ((String) getAttrVal("Id_emp_create_name"));
	}
	/**
	 * 医生姓名
	 * @param Id_emp_create_name
	 */
	public void setId_emp_create_name(String Id_emp_create_name) {
		setAttrVal("Id_emp_create_name", Id_emp_create_name);
	}
	/**
	 * 诊断时间
	 * @return FDateTime
	 */
	public FDateTime getDt_di() {
		return ((FDateTime) getAttrVal("Dt_di"));
	}
	/**
	 * 诊断时间
	 * @param Dt_di
	 */
	public void setDt_di(FDateTime Dt_di) {
		setAttrVal("Dt_di", Dt_di);
	}
	/**
	 * 西医标志
	 * @return FBoolean
	 */
	public FBoolean getFg_med() {
		return ((FBoolean) getAttrVal("Fg_med"));
	}
	/**
	 * 西医标志
	 * @param Fg_med
	 */
	public void setFg_med(FBoolean Fg_med) {
		setAttrVal("Fg_med", Fg_med);
	}
	/**
	 * 传染病标志
	 * @return FBoolean
	 */
	public FBoolean getFg_infedi() {
		return ((FBoolean) getAttrVal("Fg_infedi"));
	}
	/**
	 * 传染病标志
	 * @param Fg_infedi
	 */
	public void setFg_infedi(FBoolean Fg_infedi) {
		setAttrVal("Fg_infedi", Fg_infedi);
	}
	/**
	 * 上级
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 上级
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 主要诊断
	 * @return FBoolean
	 */
	public FBoolean getFg_majdi() {
		return ((FBoolean) getAttrVal("Fg_majdi"));
	}
	/**
	 * 主要诊断
	 * @param Fg_majdi
	 */
	public void setFg_majdi(FBoolean Fg_majdi) {
		setAttrVal("Fg_majdi", Fg_majdi);
	}
	/**
	 * 诊断科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 诊断科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 诊断体系编码
	 * @return String
	 */
	public String getId_disys() {
		return ((String) getAttrVal("Id_disys"));
	}
	/**
	 * 诊断体系编码
	 * @param Id_disys
	 */
	public void setId_disys(String Id_disys) {
		setAttrVal("Id_disys", Id_disys);
	}
	/**
	 * 诊断体系名称
	 * @return String
	 */
	public String getId_disys_name() {
		return ((String) getAttrVal("Id_disys_name"));
	}
	/**
	 * 诊断体系名称
	 * @param Id_disys_name
	 */
	public void setId_disys_name(String Id_disys_name) {
		setAttrVal("Id_disys_name", Id_disys_name);
	}
	/**
	 * 诊断体系sd
	 * @return String
	 */
	public String getSd_disys() {
		return ((String) getAttrVal("Sd_disys"));
	}
	/**
	 * 诊断体系sd
	 * @param Sd_disys
	 */
	public void setSd_disys(String Sd_disys) {
		setAttrVal("Sd_disys", Sd_disys);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
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
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 诊断描述
	 * @return String
	 */
	public String getDes_di() {
		return ((String) getAttrVal("Des_di"));
	}
	/**
	 * 诊断描述
	 * @param Des_di
	 */
	public void setDes_di(String Des_di) {
		setAttrVal("Des_di", Des_di);
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
	 * 签署人
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}
	/**
	 * 签署人
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署科室
	 * @return String
	 */
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}
	/**
	 * 签署科室
	 * @param Id_dep_sign
	 */
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	/**
	 * 签署时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}
	/**
	 * 签署时间
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 签署人名称
	 * @return String
	 */
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}
	/**
	 * 签署人名称
	 * @param Name_emp_sign
	 */
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	/**
	 * 诊断标准名称
	 * @return String
	 */
	public String getDi_standard_name() {
		return ((String) getAttrVal("Di_standard_name"));
	}
	/**
	 * 诊断标准名称
	 * @param Di_standard_name
	 */
	public void setDi_standard_name(String Di_standard_name) {
		setAttrVal("Di_standard_name", Di_standard_name);
	}
	/**
	 * 诊断标准
	 * @return String
	 */
	public String getDi_standard() {
		return ((String) getAttrVal("Di_standard"));
	}
	/**
	 * 诊断标准
	 * @param Di_standard
	 */
	public void setDi_standard(String Di_standard) {
		setAttrVal("Di_standard", Di_standard);
	}
	/**
	 * 标准编码
	 * @return String
	 */
	public String getDi_standard_code() {
		return ((String) getAttrVal("Di_standard_code"));
	}
	/**
	 * 标准编码
	 * @param Di_standard_code
	 */
	public void setDi_standard_code(String Di_standard_code) {
		setAttrVal("Di_standard_code", Di_standard_code);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_create() {
		return ((String) getAttrVal("Id_dep_create"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_create
	 */
	public void setId_dep_create(String Id_dep_create) {
		setAttrVal("Id_dep_create", Id_dep_create);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getId_dep_create_name() {
		return ((String) getAttrVal("Id_dep_create_name"));
	}
	/**
	 * 开立科室名称
	 * @param Id_dep_create_name
	 */
	public void setId_dep_create_name(String Id_dep_create_name) {
		setAttrVal("Id_dep_create_name", Id_dep_create_name);
	}
	/**
	 * 签署标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}
	/**
	 * 签署标识
	 * @param Fg_sign
	 */
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 开立时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 子表主键
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}
	/**
	 * 子表主键
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 疾病诊断id
	 * @return String
	 */
	public String getDi_disease() {
		return ((String) getAttrVal("Di_disease"));
	}
	/**
	 * 疾病诊断id
	 * @param Di_disease
	 */
	public void setDi_disease(String Di_disease) {
		setAttrVal("Di_disease", Di_disease);
	}
	/**
	 * 疾病诊断名称
	 * @return String
	 */
	public String getId_disease_name() {
		return ((String) getAttrVal("Id_disease_name"));
	}
	/**
	 * 疾病诊断名称
	 * @param Id_disease_name
	 */
	public void setId_disease_name(String Id_disease_name) {
		setAttrVal("Id_disease_name", Id_disease_name);
	}
	/**
	 * 疾病诊断编码
	 * @return String
	 */
	public String getId_disease_code() {
		return ((String) getAttrVal("Id_disease_code"));
	}
	/**
	 * 疾病诊断编码
	 * @param Id_disease_code
	 */
	public void setId_disease_code(String Id_disease_code) {
		setAttrVal("Id_disease_code", Id_disease_code);
	}
	/**
	 * 自定义诊断标识
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}
	/**
	 * 自定义诊断标识
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 内部编码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}
	/**
	 * 内部编码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 上报标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ur() {
		return ((FBoolean) getAttrVal("Fg_ur"));
	}
	/**
	 * 上报标识
	 * @param Fg_ur
	 */
	public void setFg_ur(FBoolean Fg_ur) {
		setAttrVal("Fg_ur", Fg_ur);
	}
	/**
	 * 慢性病标志
	 * @return FBoolean
	 */
	public FBoolean getFg_chronic() {
		return ((FBoolean) getAttrVal("Fg_chronic"));
	}
	/**
	 * 慢性病标志
	 * @param Fg_chronic
	 */
	public void setFg_chronic(FBoolean Fg_chronic) {
		setAttrVal("Fg_chronic", Fg_chronic);
	}
	/**
	 * 特种病标志
	 * @return FBoolean
	 */
	public FBoolean getFg_special() {
		return ((FBoolean) getAttrVal("Fg_special"));
	}
	/**
	 * 特种病标志
	 * @param Fg_special
	 */
	public void setFg_special(FBoolean Fg_special) {
		setAttrVal("Fg_special", Fg_special);
	}
	/**
	 * 传染病种类
	 * @return String
	 */
	public String getId_infectiontp() {
		return ((String) getAttrVal("Id_infectiontp"));
	}
	/**
	 * 传染病种类
	 * @param Id_infectiontp
	 */
	public void setId_infectiontp(String Id_infectiontp) {
		setAttrVal("Id_infectiontp", Id_infectiontp);
	}
	/**
	 * 传染病种类编码
	 * @return String
	 */
	public String getSd_infectiontp() {
		return ((String) getAttrVal("Sd_infectiontp"));
	}
	/**
	 * 传染病种类编码
	 * @param Sd_infectiontp
	 */
	public void setSd_infectiontp(String Sd_infectiontp) {
		setAttrVal("Sd_infectiontp", Sd_infectiontp);
	}
	/**
	 * 保外诊断标识
	 * @return String
	 */
	public String getEu_hpbeyond() {
		return ((String) getAttrVal("Eu_hpbeyond"));
	}
	/**
	 * 保外诊断标识
	 * @param Eu_hpbeyond
	 */
	public void setEu_hpbeyond(String Eu_hpbeyond) {
		setAttrVal("Eu_hpbeyond", Eu_hpbeyond);
	}
}
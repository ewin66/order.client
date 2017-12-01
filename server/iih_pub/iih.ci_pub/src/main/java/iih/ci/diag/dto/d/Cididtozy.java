package iih.ci.diag.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 中医诊断 DTO数据 
 * 
 */
public class Cididtozy extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_cididti_zy() {
		return ((String) getAttrVal("Id_cididti_zy"));
	}
	/**
	 * 主键
	 * @param Id_cididti_zy
	 */
	public void setId_cididti_zy(String Id_cididti_zy) {
		setAttrVal("Id_cididti_zy", Id_cididti_zy);
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
	 * 诊断标准编码
	 * @return String
	 */
	public String getDi_standard_code() {
		return ((String) getAttrVal("Di_standard_code"));
	}
	/**
	 * 诊断标准编码
	 * @param Di_standard_code
	 */
	public void setDi_standard_code(String Di_standard_code) {
		setAttrVal("Di_standard_code", Di_standard_code);
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
	 * 诊断疾病
	 * @return String
	 */
	public String getDi_disease() {
		return ((String) getAttrVal("Di_disease"));
	}
	/**
	 * 诊断疾病
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
	 * 证候诊断
	 * @return String
	 */
	public String getId_syndrome() {
		return ((String) getAttrVal("Id_syndrome"));
	}
	/**
	 * 证候诊断
	 * @param Id_syndrome
	 */
	public void setId_syndrome(String Id_syndrome) {
		setAttrVal("Id_syndrome", Id_syndrome);
	}
	/**
	 * 证候诊断名称
	 * @return String
	 */
	public String getId_syndrome_name() {
		return ((String) getAttrVal("Id_syndrome_name"));
	}
	/**
	 * 证候诊断名称
	 * @param Id_syndrome_name
	 */
	public void setId_syndrome_name(String Id_syndrome_name) {
		setAttrVal("Id_syndrome_name", Id_syndrome_name);
	}
	/**
	 * 证候诊断编码
	 * @return String
	 */
	public String getId_syndrome_code() {
		return ((String) getAttrVal("Id_syndrome_code"));
	}
	/**
	 * 证候诊断编码
	 * @param Id_syndrome_code
	 */
	public void setId_syndrome_code(String Id_syndrome_code) {
		setAttrVal("Id_syndrome_code", Id_syndrome_code);
	}
	/**
	 * 开立科室编码
	 * @return String
	 */
	public String getId_dep_create() {
		return ((String) getAttrVal("Id_dep_create"));
	}
	/**
	 * 开立科室编码
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
	 * 主诊断
	 * @return FBoolean
	 */
	public FBoolean getFg_majdi() {
		return ((FBoolean) getAttrVal("Fg_majdi"));
	}
	/**
	 * 主诊断
	 * @param Fg_majdi
	 */
	public void setFg_majdi(FBoolean Fg_majdi) {
		setAttrVal("Fg_majdi", Fg_majdi);
	}
	/**
	 * 体系
	 * @return String
	 */
	public String getId_disys() {
		return ((String) getAttrVal("Id_disys"));
	}
	/**
	 * 体系
	 * @param Id_disys
	 */
	public void setId_disys(String Id_disys) {
		setAttrVal("Id_disys", Id_disys);
	}
	/**
	 * 体系编码
	 * @return String
	 */
	public String getSd_disys() {
		return ((String) getAttrVal("Sd_disys"));
	}
	/**
	 * 体系编码
	 * @param Sd_disys
	 */
	public void setSd_disys(String Sd_disys) {
		setAttrVal("Sd_disys", Sd_disys);
	}
	/**
	 * 体系名称
	 * @return String
	 */
	public String getId_disys_name() {
		return ((String) getAttrVal("Id_disys_name"));
	}
	/**
	 * 体系名称
	 * @param Id_disys_name
	 */
	public void setId_disys_name(String Id_disys_name) {
		setAttrVal("Id_disys_name", Id_disys_name);
	}
	/**
	 * 字表主键
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}
	/**
	 * 字表主键
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
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
	 * 上级节点Id
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 上级节点Id
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
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
	 * 保外诊断标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hpbeyond() {
		return ((FBoolean) getAttrVal("Fg_hpbeyond"));
	}
	/**
	 * 保外诊断标识
	 * @param Fg_hpbeyond
	 */
	public void setFg_hpbeyond(FBoolean Fg_hpbeyond) {
		setAttrVal("Fg_hpbeyond", Fg_hpbeyond);
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
}
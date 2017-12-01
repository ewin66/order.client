package iih.ci.ord.srvref.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱服务参照入口参数DTO DTO数据 
 * 
 */
public class CiSrvRefParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 表单id
	 * @return String
	 */
	public String getId_billform() {
		return ((String) getAttrVal("Id_billform"));
	}
	/**
	 * 表单id
	 * @param Id_billform
	 */
	public void setId_billform(String Id_billform) {
		setAttrVal("Id_billform", Id_billform);
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
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
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
	 * 模糊查询标识
	 * @return FBoolean
	 */
	public FBoolean getFg_blurred() {
		return ((FBoolean) getAttrVal("Fg_blurred"));
	}
	/**
	 * 模糊查询标识
	 * @param Fg_blurred
	 */
	public void setFg_blurred(FBoolean Fg_blurred) {
		setAttrVal("Fg_blurred", Fg_blurred);
	}
	/**
	 * 按编码查询标识
	 * @return FBoolean
	 */
	public FBoolean getFg_code() {
		return ((FBoolean) getAttrVal("Fg_code"));
	}
	/**
	 * 按编码查询标识
	 * @param Fg_code
	 */
	public void setFg_code(FBoolean Fg_code) {
		setAttrVal("Fg_code", Fg_code);
	}
	/**
	 * 按名称查询标识
	 * @return FBoolean
	 */
	public FBoolean getFg_name() {
		return ((FBoolean) getAttrVal("Fg_name"));
	}
	/**
	 * 按名称查询标识
	 * @param Fg_name
	 */
	public void setFg_name(FBoolean Fg_name) {
		setAttrVal("Fg_name", Fg_name);
	}
	/**
	 * 按简称查询标识
	 * @return FBoolean
	 */
	public FBoolean getFg_shortname() {
		return ((FBoolean) getAttrVal("Fg_shortname"));
	}
	/**
	 * 按简称查询标识
	 * @param Fg_shortname
	 */
	public void setFg_shortname(FBoolean Fg_shortname) {
		setAttrVal("Fg_shortname", Fg_shortname);
	}
	/**
	 * 按拼音码查询标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pycode() {
		return ((FBoolean) getAttrVal("Fg_pycode"));
	}
	/**
	 * 按拼音码查询标识
	 * @param Fg_pycode
	 */
	public void setFg_pycode(FBoolean Fg_pycode) {
		setAttrVal("Fg_pycode", Fg_pycode);
	}
	/**
	 * 按五笔查询标识
	 * @return FBoolean
	 */
	public FBoolean getFg_wbcode() {
		return ((FBoolean) getAttrVal("Fg_wbcode"));
	}
	/**
	 * 按五笔查询标识
	 * @param Fg_wbcode
	 */
	public void setFg_wbcode(FBoolean Fg_wbcode) {
		setAttrVal("Fg_wbcode", Fg_wbcode);
	}
	/**
	 * 按助记码查询标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mnemonic() {
		return ((FBoolean) getAttrVal("Fg_mnemonic"));
	}
	/**
	 * 按助记码查询标识
	 * @param Fg_mnemonic
	 */
	public void setFg_mnemonic(FBoolean Fg_mnemonic) {
		setAttrVal("Fg_mnemonic", Fg_mnemonic);
	}
	/**
	 * 返回记录数
	 * @return String
	 */
	public String getResult_cnt() {
		return ((String) getAttrVal("Result_cnt"));
	}
	/**
	 * 返回记录数
	 * @param Result_cnt
	 */
	public void setResult_cnt(String Result_cnt) {
		setAttrVal("Result_cnt", Result_cnt);
	}
	/**
	 * 医疗单
	 * @return String
	 */
	public String getId_ems() {
		return ((String) getAttrVal("Id_ems"));
	}
	/**
	 * 医疗单
	 * @param Id_ems
	 */
	public void setId_ems(String Id_ems) {
		setAttrVal("Id_ems", Id_ems);
	}
	/**
	 * 医生场景标识
	 * @return FBoolean
	 */
	public FBoolean getFg_doctor() {
		return ((FBoolean) getAttrVal("Fg_doctor"));
	}
	/**
	 * 医生场景标识
	 * @param Fg_doctor
	 */
	public void setFg_doctor(FBoolean Fg_doctor) {
		setAttrVal("Fg_doctor", Fg_doctor);
	}
	/**
	 * 输入串
	 * @return String
	 */
	public String getInputstr() {
		return ((String) getAttrVal("Inputstr"));
	}
	/**
	 * 输入串
	 * @param Inputstr
	 */
	public void setInputstr(String Inputstr) {
		setAttrVal("Inputstr", Inputstr);
	}
}
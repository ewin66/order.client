package iih.ci.ord.dto.hp;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

public class BdHpIndicDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病人基本信息
	 * @return PatDO
	 */
	public PatDO getPipatdo() {
		return ((PatDO) getAttrVal("Pipatdo"));
	}
	/**
	 * 病人基本信息
	 * @param Pipatdo
	 */
	public void setPipatdo(PatDO Pipatdo) {
		setAttrVal("Pipatdo", Pipatdo);
	}
	/**
	 * 医嘱项目明细
	 * @return OrdSrvDO
	 */
	public OrdSrvDO getCi_orsrvdo() {
		return ((OrdSrvDO) getAttrVal("Ci_orsrvdo"));
	}
	/**
	 * 医嘱项目明细
	 * @param Ci_orsrvdo
	 */
	public void setCi_orsrvdo(OrdSrvDO Ci_orsrvdo) {
		setAttrVal("Ci_orsrvdo", Ci_orsrvdo);
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
	 * 医保目录类型ID
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保目录类型ID
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保目录类型SD
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保目录类型SD
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	
	/**
	 * 医保目录类型描述
	 * @return String
	 */
	public String getDes_hpsrvtp() {
		return ((String) getAttrVal("Des_hpsrvtp"));
	}
	/**
	 * 医保目录类型描述
	 * @param Des_hpsrvtp
	 */
	public void setDes_hpsrvtp(String Des_hpsrvtp) {
		setAttrVal("Des_hpsrvtp", Des_hpsrvtp);
	}
	/**
	 * 医保限制条件
	 * @return String
	 */
	public String getDes_hplimit() {
		return ((String) getAttrVal("Des_hplimit"));
	}
	/**
	 * 医保限制条件
	 * @param Des_hplimit
	 */
	public void setDes_hplimit(String Des_hplimit) {
		setAttrVal("Des_hplimit", Des_hplimit);
	}
	/**
	 * 系统判断结果
	 * @return FBoolean
	 */
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}
	/**
	 * 系统判断结果
	 * @param Fg_indic
	 */
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}
	/**
	 * 判断方式
	 * @return String
	 */
	public String getCode_hpindicjudged() {
		return ((String) getAttrVal("Code_hpindicjudged"));
	}
	/**
	 * 判断方式
	 * @param Code_hpindicjudged
	 */
	public void setCode_hpindicjudged(String Code_hpindicjudged) {
		setAttrVal("Code_hpindicjudged", Code_hpindicjudged);
	}
	/**
	 * 新生儿标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 新生儿标志
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
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
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开单科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开单科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 临床诊断明细
	 * @return FArrayList2
	 */
	public FArrayList2 getCi_di_itms() {
		return ((FArrayList2) getAttrVal("Ci_di_itms"));
	}
	/**
	 * 临床诊断明细
	 * @param Ci_di_itms
	 */
	public void setCi_di_itms(FArrayList2 Ci_di_itms) {
		setAttrVal("Ci_di_itms", Ci_di_itms);
	}
	/**
	 * 用药天数
	 * @return Integer
	 */
	public Integer getUse_days() {
		return ((Integer) getAttrVal("Use_days"));
	}
	/**
	 * 用药天数
	 * @param Use_days
	 */
	public void setUse_days(Integer Use_days) {
		setAttrVal("Use_days", Use_days);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
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
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	/**
	 * 物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	
	/**
	 * 数量
	 * @return String
	 */
	public String getQuan() {
		return ((String) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(String Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 使用天数
	 * @return Integer
	 */
	public Integer getUse_day() {
		return ((Integer) getAttrVal("Use_day"));
	}
	/**
	 * 使用天数
	 * @param Use_day
	 */
	public void setUse_day(Integer Use_day) {
		setAttrVal("Use_day", Use_day);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 服务名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 物品标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标志
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 单次剂量
	 * @return String
	 */
	public String getQuan_medu() {
		return ((String) getAttrVal("Quan_medu"));
	}
	/**
	 * 单次剂量
	 * @param Quan_medu
	 */
	public void setQuan_medu(String Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}}

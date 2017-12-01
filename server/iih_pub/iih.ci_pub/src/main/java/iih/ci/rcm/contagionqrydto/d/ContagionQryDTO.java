package iih.ci.rcm.contagionqrydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 传染病查询DTO DTO数据 
 * 
 */
public class ContagionQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_contagiondto() {
		return ((String) getAttrVal("Id_contagiondto"));
	}
	/**
	 * 主键
	 * @param Id_contagiondto
	 */
	public void setId_contagiondto(String Id_contagiondto) {
		setAttrVal("Id_contagiondto", Id_contagiondto);
	}
	/**
	 * 收卡时间
	 * @return FDate
	 */
	public FDate getDt_contagion() {
		return ((FDate) getAttrVal("Dt_contagion"));
	}
	/**
	 * 收卡时间
	 * @param Dt_contagion
	 */
	public void setDt_contagion(FDate Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}
	/**
	 * 报卡类别
	 * @return String
	 */
	public String getName_eu_bklb() {
		return ((String) getAttrVal("Name_eu_bklb"));
	}
	/**
	 * 报卡类别
	 * @param Name_eu_bklb
	 */
	public void setName_eu_bklb(String Name_eu_bklb) {
		setAttrVal("Name_eu_bklb", Name_eu_bklb);
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
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getExact_age() {
		return ((String) getAttrVal("Exact_age"));
	}
	/**
	 * 年龄
	 * @param Exact_age
	 */
	public void setExact_age(String Exact_age) {
		setAttrVal("Exact_age", Exact_age);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getName_eu_rqfl() {
		return ((String) getAttrVal("Name_eu_rqfl"));
	}
	/**
	 * 职业
	 * @param Name_eu_rqfl
	 */
	public void setName_eu_rqfl(String Name_eu_rqfl) {
		setAttrVal("Name_eu_rqfl", Name_eu_rqfl);
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
	 * 联系电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 联系电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 病例分类
	 * @return String
	 */
	public String getName_eu_blfl() {
		return ((String) getAttrVal("Name_eu_blfl"));
	}
	/**
	 * 病例分类
	 * @param Name_eu_blfl
	 */
	public void setName_eu_blfl(String Name_eu_blfl) {
		setAttrVal("Name_eu_blfl", Name_eu_blfl);
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
	 * 报告科室
	 * @return String
	 */
	public String getDep_deport() {
		return ((String) getAttrVal("Dep_deport"));
	}
	/**
	 * 报告科室
	 * @param Dep_deport
	 */
	public void setDep_deport(String Dep_deport) {
		setAttrVal("Dep_deport", Dep_deport);
	}
	/**
	 * 报告医生
	 * @return String
	 */
	public String getDoctor_card() {
		return ((String) getAttrVal("Doctor_card"));
	}
	/**
	 * 报告医生
	 * @param Doctor_card
	 */
	public void setDoctor_card(String Doctor_card) {
		setAttrVal("Doctor_card", Doctor_card);
	}
	/**
	 * 访视日期
	 * @return String
	 */
	public String getDt_fangshi() {
		return ((String) getAttrVal("Dt_fangshi"));
	}
	/**
	 * 访视日期
	 * @param Dt_fangshi
	 */
	public void setDt_fangshi(String Dt_fangshi) {
		setAttrVal("Dt_fangshi", Dt_fangshi);
	}
	/**
	 * 转归
	 * @return String
	 */
	public String getZhuangui() {
		return ((String) getAttrVal("Zhuangui"));
	}
	/**
	 * 转归
	 * @param Zhuangui
	 */
	public void setZhuangui(String Zhuangui) {
		setAttrVal("Zhuangui", Zhuangui);
	}
	/**
	 * 订正卡编号
	 * @return String
	 */
	public String getCode_dingzhika() {
		return ((String) getAttrVal("Code_dingzhika"));
	}
	/**
	 * 订正卡编号
	 * @param Code_dingzhika
	 */
	public void setCode_dingzhika(String Code_dingzhika) {
		setAttrVal("Code_dingzhika", Code_dingzhika);
	}
	/**
	 * 订正人
	 * @return String
	 */
	public String getDingzhengren() {
		return ((String) getAttrVal("Dingzhengren"));
	}
	/**
	 * 订正人
	 * @param Dingzhengren
	 */
	public void setDingzhengren(String Dingzhengren) {
		setAttrVal("Dingzhengren", Dingzhengren);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getBeizhu() {
		return ((String) getAttrVal("Beizhu"));
	}
	/**
	 * 备注
	 * @param Beizhu
	 */
	public void setBeizhu(String Beizhu) {
		setAttrVal("Beizhu", Beizhu);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getName_disease() {
		return ((String) getAttrVal("Name_disease"));
	}
	/**
	 * 疾病名称
	 * @param Name_disease
	 */
	public void setName_disease(String Name_disease) {
		setAttrVal("Name_disease", Name_disease);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
}
package iih.ci.pre.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊预检DTO DTO数据 
 * 
 */
public class EmergPreDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预检id
	 * @return String
	 */
	public String getId_obspre() {
		return ((String) getAttrVal("Id_obspre"));
	}
	/**
	 * 预检id
	 * @param Id_obspre
	 */
	public void setId_obspre(String Id_obspre) {
		setAttrVal("Id_obspre", Id_obspre);
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
	 * 病情等级
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病情等级
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情等级编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情等级编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 到院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 到院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 到院方式
	 * @return String
	 */
	public String getId_come_way() {
		return ((String) getAttrVal("Id_come_way"));
	}
	/**
	 * 到院方式
	 * @param Id_come_way
	 */
	public void setId_come_way(String Id_come_way) {
		setAttrVal("Id_come_way", Id_come_way);
	}
	/**
	 * 到院方式编码
	 * @return String
	 */
	public String getSd_come_way() {
		return ((String) getAttrVal("Sd_come_way"));
	}
	/**
	 * 到院方式编码
	 * @param Sd_come_way
	 */
	public void setSd_come_way(String Sd_come_way) {
		setAttrVal("Sd_come_way", Sd_come_way);
	}
	/**
	 * 到院方式名称
	 * @return String
	 */
	public String getName_come_way() {
		return ((String) getAttrVal("Name_come_way"));
	}
	/**
	 * 到院方式名称
	 * @param Name_come_way
	 */
	public void setName_come_way(String Name_come_way) {
		setAttrVal("Name_come_way", Name_come_way);
	}
	/**
	 * 抢救开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rescue_b() {
		return ((FDateTime) getAttrVal("Dt_rescue_b"));
	}
	/**
	 * 抢救开始时间
	 * @param Dt_rescue_b
	 */
	public void setDt_rescue_b(FDateTime Dt_rescue_b) {
		setAttrVal("Dt_rescue_b", Dt_rescue_b);
	}
	/**
	 * 抢救结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rescue_e() {
		return ((FDateTime) getAttrVal("Dt_rescue_e"));
	}
	/**
	 * 抢救结束时间
	 * @param Dt_rescue_e
	 */
	public void setDt_rescue_e(FDateTime Dt_rescue_e) {
		setAttrVal("Dt_rescue_e", Dt_rescue_e);
	}
	/**
	 * 陪伴人员id
	 * @return String
	 */
	public String getIds_companion() {
		return ((String) getAttrVal("Ids_companion"));
	}
	/**
	 * 陪伴人员id
	 * @param Ids_companion
	 */
	public void setIds_companion(String Ids_companion) {
		setAttrVal("Ids_companion", Ids_companion);
	}
	/**
	 * 陪伴人员
	 * @return String
	 */
	public String getSds_companion() {
		return ((String) getAttrVal("Sds_companion"));
	}
	/**
	 * 陪伴人员
	 * @param Sds_companion
	 */
	public void setSds_companion(String Sds_companion) {
		setAttrVal("Sds_companion", Sds_companion);
	}
	/**
	 * 询问流行病史标志
	 * @return FBoolean
	 */
	public FBoolean getFg_chk_eqidemic() {
		return ((FBoolean) getAttrVal("Fg_chk_eqidemic"));
	}
	/**
	 * 询问流行病史标志
	 * @param Fg_chk_eqidemic
	 */
	public void setFg_chk_eqidemic(FBoolean Fg_chk_eqidemic) {
		setAttrVal("Fg_chk_eqidemic", Fg_chk_eqidemic);
	}
	/**
	 * 有24时发热
	 * @return FBoolean
	 */
	public FBoolean getFg_has_hot() {
		return ((FBoolean) getAttrVal("Fg_has_hot"));
	}
	/**
	 * 有24时发热
	 * @param Fg_has_hot
	 */
	public void setFg_has_hot(FBoolean Fg_has_hot) {
		setAttrVal("Fg_has_hot", Fg_has_hot);
	}
	/**
	 * 有3天发热
	 * @return FBoolean
	 */
	public FBoolean getFg_has_hot2() {
		return ((FBoolean) getAttrVal("Fg_has_hot2"));
	}
	/**
	 * 有3天发热
	 * @param Fg_has_hot2
	 */
	public void setFg_has_hot2(FBoolean Fg_has_hot2) {
		setAttrVal("Fg_has_hot2", Fg_has_hot2);
	}
	/**
	 * 有最近疫区旅游
	 * @return FBoolean
	 */
	public FBoolean getFg_has_eqidarea() {
		return ((FBoolean) getAttrVal("Fg_has_eqidarea"));
	}
	/**
	 * 有最近疫区旅游
	 * @param Fg_has_eqidarea
	 */
	public void setFg_has_eqidarea(FBoolean Fg_has_eqidarea) {
		setAttrVal("Fg_has_eqidarea", Fg_has_eqidarea);
	}
	/**
	 * 有接触动物
	 * @return FBoolean
	 */
	public FBoolean getFg_has_touchanim() {
		return ((FBoolean) getAttrVal("Fg_has_touchanim"));
	}
	/**
	 * 有接触动物
	 * @param Fg_has_touchanim
	 */
	public void setFg_has_touchanim(FBoolean Fg_has_touchanim) {
		setAttrVal("Fg_has_touchanim", Fg_has_touchanim);
	}
	/**
	 * 询问补充
	 * @return String
	 */
	public String getChk_note() {
		return ((String) getAttrVal("Chk_note"));
	}
	/**
	 * 询问补充
	 * @param Chk_note
	 */
	public void setChk_note(String Chk_note) {
		setAttrVal("Chk_note", Chk_note);
	}
	/**
	 * 预检服务项目集合
	 * @return FArrayList
	 */
	public FArrayList getSrvarray() {
		return ((FArrayList) getAttrVal("Srvarray"));
	}
	/**
	 * 预检服务项目集合
	 * @param Srvarray
	 */
	public void setSrvarray(FArrayList Srvarray) {
		setAttrVal("Srvarray", Srvarray);
	}
	/**
	 * 复诊
	 * @return FBoolean
	 */
	public FBoolean getFg_revisit() {
		return ((FBoolean) getAttrVal("Fg_revisit"));
	}
	/**
	 * 复诊
	 * @param Fg_revisit
	 */
	public void setFg_revisit(FBoolean Fg_revisit) {
		setAttrVal("Fg_revisit", Fg_revisit);
	}
}
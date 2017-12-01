package iih.ci.ord.dto.blexorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行与记费医嘱拆解医嘱信息 DTO数据 
 * 
 */
public class OrSplitOrderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
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
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 婴儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}	
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 婴儿序号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}	
	/**
	 * 婴儿序号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 医嘱备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getId_orsrvtp() {
		return ((String) getAttrVal("Id_orsrvtp"));
	}	
	/**
	 * 医嘱类型
	 * @param Id_orsrvtp
	 */
	public void setId_orsrvtp(String Id_orsrvtp) {
		setAttrVal("Id_orsrvtp", Id_orsrvtp);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_orsrvtp() {
		return ((String) getAttrVal("Sd_orsrvtp"));
	}	
	/**
	 * 医嘱类型编码
	 * @param Sd_orsrvtp
	 */
	public void setSd_orsrvtp(String Sd_orsrvtp) {
		setAttrVal("Sd_orsrvtp", Sd_orsrvtp);
	}
	/**
	 * 医嘱状态
	 * @return String
	 */
	public String getId_su_or() {
		return ((String) getAttrVal("Id_su_or"));
	}	
	/**
	 * 医嘱状态
	 * @param Id_su_or
	 */
	public void setId_su_or(String Id_su_or) {
		setAttrVal("Id_su_or", Id_su_or);
	}
	/**
	 * 医嘱状态编码
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}	
	/**
	 * 医嘱状态编码
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 失效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_invalid() {
		return ((FDateTime) getAttrVal("Dt_invalid"));
	}	
	/**
	 * 失效日期
	 * @param Dt_invalid
	 */
	public void setDt_invalid(FDateTime Dt_invalid) {
		setAttrVal("Dt_invalid", Dt_invalid);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 代煎标识
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	/**
	 * 代煎标识
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getQuan_or() {
		return ((Integer) getAttrVal("Quan_or"));
	}	
	/**
	 * 医嘱付数
	 * @param Quan_or
	 */
	public void setQuan_or(Integer Quan_or) {
		setAttrVal("Quan_or", Quan_or);
	}
	/**
	 * 代煎付数
	 * @return Integer
	 */
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}	
	/**
	 * 代煎付数
	 * @param Orders_boil
	 */
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
	}
	/**
	 * 皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 床边执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_bed() {
		return ((FBoolean) getAttrVal("Fg_mp_bed"));
	}	
	/**
	 * 床边执行标识
	 * @param Fg_mp_bed
	 */
	public void setFg_mp_bed(FBoolean Fg_mp_bed) {
		setAttrVal("Fg_mp_bed", Fg_mp_bed);
	}
	/**
	 * 停止日期
	 * @return FDateTime
	 */
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}	
	/**
	 * 停止日期
	 * @param Dt_stop
	 */
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pati() {
		return ((String) getAttrVal("Name_pati"));
	}	
	/**
	 * 姓名
	 * @param Name_pati
	 */
	public void setName_pati(String Name_pati) {
		setAttrVal("Name_pati", Name_pati);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getGender() {
		return ((String) getAttrVal("Gender"));
	}	
	/**
	 * 性别
	 * @param Gender
	 */
	public void setGender(String Gender) {
		setAttrVal("Gender", Gender);
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
	 * 床号
	 * @return String
	 */
	public String getNo_bed() {
		return ((String) getAttrVal("No_bed"));
	}	
	/**
	 * 床号
	 * @param No_bed
	 */
	public void setNo_bed(String No_bed) {
		setAttrVal("No_bed", No_bed);
	}
	/**
	 * 附属信息
	 * @return FMap
	 */
	public FMap getOrattachinfos() {
		return ((FMap) getAttrVal("Orattachinfos"));
	}	
	/**
	 * 附属信息
	 * @param Orattachinfos
	 */
	public void setOrattachinfos(FMap Orattachinfos) {
		setAttrVal("Orattachinfos", Orattachinfos);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 开立日期
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 开立机构
	 * @return String
	 */
	public String getId_org_create() {
		return ((String) getAttrVal("Id_org_create"));
	}	
	/**
	 * 开立机构
	 * @param Id_org_create
	 */
	public void setId_org_create(String Id_org_create) {
		setAttrVal("Id_org_create", Id_org_create);
	}
	/**
	 * 开立科室病区
	 * @return String
	 */
	public String getId_dep_create() {
		return ((String) getAttrVal("Id_dep_create"));
	}	
	/**
	 * 开立科室病区
	 * @param Id_dep_create
	 */
	public void setId_dep_create(String Id_dep_create) {
		setAttrVal("Id_dep_create", Id_dep_create);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}	
	/**
	 * 开立医生
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 最近生成时间（医嘱）
	 * @return FDateTime
	 */
	public FDateTime getDt_last_bl_or() {
		return ((FDateTime) getAttrVal("Dt_last_bl_or"));
	}	
	/**
	 * 最近生成时间（医嘱）
	 * @param Dt_last_bl_or
	 */
	public void setDt_last_bl_or(FDateTime Dt_last_bl_or) {
		setAttrVal("Dt_last_bl_or", Dt_last_bl_or);
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
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
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
	 * 频次周期类型
	 * @return String
	 */
	public String getId_frequnit() {
		return ((String) getAttrVal("Id_frequnit"));
	}	
	/**
	 * 频次周期类型
	 * @param Id_frequnit
	 */
	public void setId_frequnit(String Id_frequnit) {
		setAttrVal("Id_frequnit", Id_frequnit);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getSd_frequnit() {
		return ((String) getAttrVal("Sd_frequnit"));
	}	
	/**
	 * 频次周期类型编码
	 * @param Sd_frequnit
	 */
	public void setSd_frequnit(String Sd_frequnit) {
		setAttrVal("Sd_frequnit", Sd_frequnit);
	}
	/**
	 * 频次周期总数
	 * @return Integer
	 */
	public Integer getFrequnitcnt() {
		return ((Integer) getAttrVal("Frequnitcnt"));
	}	
	/**
	 * 频次周期总数
	 * @param Frequnitcnt
	 */
	public void setFrequnitcnt(Integer Frequnitcnt) {
		setAttrVal("Frequnitcnt", Frequnitcnt);
	}
	/**
	 * 频次周期下次数
	 * @return Integer
	 */
	public Integer getFreqcnt() {
		return ((Integer) getAttrVal("Freqcnt"));
	}	
	/**
	 * 频次周期下次数
	 * @param Freqcnt
	 */
	public void setFreqcnt(Integer Freqcnt) {
		setAttrVal("Freqcnt", Freqcnt);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}	
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 持续时间秒数
	 * @return Integer
	 */
	public Integer getDurationsec() {
		return ((Integer) getAttrVal("Durationsec"));
	}	
	/**
	 * 持续时间秒数
	 * @param Durationsec
	 */
	public void setDurationsec(Integer Durationsec) {
		setAttrVal("Durationsec", Durationsec);
	}
	/**
	 * 医嘱执行状态
	 * @return String
	 */
	public String getOr_mp_status() {
		return ((String) getAttrVal("Or_mp_status"));
	}	
	/**
	 * 医嘱执行状态
	 * @param Or_mp_status
	 */
	public void setOr_mp_status(String Or_mp_status) {
		setAttrVal("Or_mp_status", Or_mp_status);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}	
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
}
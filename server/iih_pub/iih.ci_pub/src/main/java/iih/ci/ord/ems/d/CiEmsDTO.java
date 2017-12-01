package iih.ci.ord.ems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗单 DTO数据 
 * 
 */
public class CiEmsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱主键标识
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱主键标识
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 医嘱类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 医嘱类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 医嘱类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 对应服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 对应服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务包
	 * @return String
	 */
	public String getId_srv_pkg() {
		return ((String) getAttrVal("Id_srv_pkg"));
	}	
	/**
	 * 服务包
	 * @param Id_srv_pkg
	 */
	public void setId_srv_pkg(String Id_srv_pkg) {
		setAttrVal("Id_srv_pkg", Id_srv_pkg);
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
	 * 医疗单类型
	 * @return Integer
	 */
	public Integer getEmstype() {
		return ((Integer) getAttrVal("Emstype"));
	}	
	/**
	 * 医疗单类型
	 * @param Emstype
	 */
	public void setEmstype(Integer Emstype) {
		setAttrVal("Emstype", Emstype);
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
	 * 医嘱频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}	
	/**
	 * 医嘱频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
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
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
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
	 * 用法要求描述
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}	
	/**
	 * 用法要求描述
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
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
	 * 煎法名称
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}	
	/**
	 * 煎法名称
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
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
	 * 煎法要求名称
	 * @return String
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}	
	/**
	 * 煎法要求名称
	 * @param Name_boildes
	 */
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
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
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}	
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 医嘱名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	/**
	 * 医嘱内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	/**
	 * 开立医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 开立医生姓名
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	/**
	 * 开立医生姓名
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 开立科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 开立科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 医疗组
	 * @return String
	 */
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}	
	/**
	 * 医疗组
	 * @param Id_wg_or
	 */
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
	}
	/**
	 * 开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
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
	 * 医嘱过期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_invalid() {
		return ((FDateTime) getAttrVal("Dt_invalid"));
	}	
	/**
	 * 医嘱过期时间
	 * @param Dt_invalid
	 */
	public void setDt_invalid(FDateTime Dt_invalid) {
		setAttrVal("Dt_invalid", Dt_invalid);
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
	 * 备用医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pmor() {
		return ((FBoolean) getAttrVal("Fg_pmor"));
	}	
	/**
	 * 备用医嘱标识
	 * @param Fg_pmor
	 */
	public void setFg_pmor(FBoolean Fg_pmor) {
		setAttrVal("Fg_pmor", Fg_pmor);
	}
	/**
	 * 备用医嘱使用条件描述
	 * @return String
	 */
	public String getDes_pmor() {
		return ((String) getAttrVal("Des_pmor"));
	}	
	/**
	 * 备用医嘱使用条件描述
	 * @param Des_pmor
	 */
	public void setDes_pmor(String Des_pmor) {
		setAttrVal("Des_pmor", Des_pmor);
	}
	/**
	 * 备用医嘱启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active_pm() {
		return ((FBoolean) getAttrVal("Fg_active_pm"));
	}	
	/**
	 * 备用医嘱启用标识
	 * @param Fg_active_pm
	 */
	public void setFg_active_pm(FBoolean Fg_active_pm) {
		setAttrVal("Fg_active_pm", Fg_active_pm);
	}
	/**
	 * 关联医嘱类型编码
	 * @return String
	 */
	public String getId_reltp() {
		return ((String) getAttrVal("Id_reltp"));
	}	
	/**
	 * 关联医嘱类型编码
	 * @param Id_reltp
	 */
	public void setId_reltp(String Id_reltp) {
		setAttrVal("Id_reltp", Id_reltp);
	}
	/**
	 * 关联医嘱类型
	 * @return String
	 */
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}	
	/**
	 * 关联医嘱类型
	 * @param Sd_reltp
	 */
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
	}
	/**
	 * 关联医嘱
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}	
	/**
	 * 关联医嘱
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 临床路径控制标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ctlcp() {
		return ((FBoolean) getAttrVal("Fg_ctlcp"));
	}	
	/**
	 * 临床路径控制标识
	 * @param Fg_ctlcp
	 */
	public void setFg_ctlcp(FBoolean Fg_ctlcp) {
		setAttrVal("Fg_ctlcp", Fg_ctlcp);
	}
	/**
	 * 医疗记录联动标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mr() {
		return ((FBoolean) getAttrVal("Fg_mr"));
	}	
	/**
	 * 医疗记录联动标识
	 * @param Fg_mr
	 */
	public void setFg_mr(FBoolean Fg_mr) {
		setAttrVal("Fg_mr", Fg_mr);
	}
	/**
	 * 需皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	/**
	 * 需皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 不皮试原因（废弃不用了）
	 * @return String
	 */
	public String getId_skintest_skip_reaso() {
		return ((String) getAttrVal("Id_skintest_skip_reaso"));
	}	
	/**
	 * 不皮试原因（废弃不用了）
	 * @param Id_skintest_skip_reaso
	 */
	public void setId_skintest_skip_reaso(String Id_skintest_skip_reaso) {
		setAttrVal("Id_skintest_skip_reaso", Id_skintest_skip_reaso);
	}
	/**
	 * 不皮试原因编码（废弃不用了）
	 * @return String
	 */
	public String getSd_skintest_skip_reaso() {
		return ((String) getAttrVal("Sd_skintest_skip_reaso"));
	}	
	/**
	 * 不皮试原因编码（废弃不用了）
	 * @param Sd_skintest_skip_reaso
	 */
	public void setSd_skintest_skip_reaso(String Sd_skintest_skip_reaso) {
		setAttrVal("Sd_skintest_skip_reaso", Sd_skintest_skip_reaso);
	}
	/**
	 * 在院执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_in() {
		return ((FBoolean) getAttrVal("Fg_mp_in"));
	}	
	/**
	 * 在院执行标识
	 * @param Fg_mp_in
	 */
	public void setFg_mp_in(FBoolean Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
	}
	/**
	 * 在院执行次数
	 * @return Integer
	 */
	public Integer getTimes_mp_in() {
		return ((Integer) getAttrVal("Times_mp_in"));
	}	
	/**
	 * 在院执行次数
	 * @param Times_mp_in
	 */
	public void setTimes_mp_in(Integer Times_mp_in) {
		setAttrVal("Times_mp_in", Times_mp_in);
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
	 * 首日执行次数
	 * @return Integer
	 */
	public Integer getTimes_firday_mp() {
		return ((Integer) getAttrVal("Times_firday_mp"));
	}	
	/**
	 * 首日执行次数
	 * @param Times_firday_mp
	 */
	public void setTimes_firday_mp(Integer Times_firday_mp) {
		setAttrVal("Times_firday_mp", Times_firday_mp);
	}
	/**
	 * 医生医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or_doc() {
		return ((FBoolean) getAttrVal("Fg_or_doc"));
	}	
	/**
	 * 医生医嘱标识
	 * @param Fg_or_doc
	 */
	public void setFg_or_doc(FBoolean Fg_or_doc) {
		setAttrVal("Fg_or_doc", Fg_or_doc);
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
	 * 医疗单项目集合
	 * @return String
	 */
	public FArrayList getEmssrvs() {
		return ((FArrayList) getAttrVal("Emssrvs"));
	}	
	/**
	 * 医疗单项目集合
	 * @param Emssrvs
	 */
	public void setEmssrvs(FArrayList Emssrvs) {
		setAttrVal("Emssrvs", Emssrvs);
	}
	/**
	 * 医嘱计划频次执行时刻集合
	 * @return String
	 */
	public FArrayList getCiorfreqtimes() {
		return ((FArrayList) getAttrVal("Ciorfreqtimes"));
	}	
	/**
	 * 医嘱计划频次执行时刻集合
	 * @param Ciorfreqtimes
	 */
	public void setCiorfreqtimes(FArrayList Ciorfreqtimes) {
		setAttrVal("Ciorfreqtimes", Ciorfreqtimes);
	}
	/**
	 * 套对应的套内项目集合
	 * @return FMap
	 */
	public FMap getSrvsetitms() {
		return ((FMap) getAttrVal("Srvsetitms"));
	}	
	/**
	 * 套对应的套内项目集合
	 * @param Srvsetitms
	 */
	public void setSrvsetitms(FMap Srvsetitms) {
		setAttrVal("Srvsetitms", Srvsetitms);
	}
	/**
	 * 医嘱对应的申请单
	 * @return FMap
	 */
	public FMap getOrapplysheet() {
		return ((FMap) getAttrVal("Orapplysheet"));
	}	
	/**
	 * 医嘱对应的申请单
	 * @param Orapplysheet
	 */
	public void setOrapplysheet(FMap Orapplysheet) {
		setAttrVal("Orapplysheet", Orapplysheet);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dept_en() {
		return ((String) getAttrVal("Id_dept_en"));
	}	
	/**
	 * 就诊科室
	 * @param Id_dept_en
	 */
	public void setId_dept_en(String Id_dept_en) {
		setAttrVal("Id_dept_en", Id_dept_en);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dept_ns() {
		return ((String) getAttrVal("Id_dept_ns"));
	}	
	/**
	 * 护理单元
	 * @param Id_dept_ns
	 */
	public void setId_dept_ns(String Id_dept_ns) {
		setAttrVal("Id_dept_ns", Id_dept_ns);
	}
	/**
	 * 是否是套
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	/**
	 * 是否是套
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 嘱托
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
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
	/**
	 * 医疗单URL
	 * @return String
	 */
	public String getFuncclassstr() {
		return ((String) getAttrVal("Funcclassstr"));
	}	
	/**
	 * 医疗单URL
	 * @param Funcclassstr
	 */
	public void setFuncclassstr(String Funcclassstr) {
		setAttrVal("Funcclassstr", Funcclassstr);
	}
	/**
	 * 医疗单
	 * @return String
	 */
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	/**
	 * 医疗单
	 * @param Id_srvof
	 */
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}	
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
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
	 * 总次数
	 * @return Integer
	 */
	public Integer getTimes_cur() {
		return ((Integer) getAttrVal("Times_cur"));
	}	
	/**
	 * 总次数
	 * @param Times_cur
	 */
	public void setTimes_cur(Integer Times_cur) {
		setAttrVal("Times_cur", Times_cur);
	}
	/**
	 * 医嘱结果
	 * @return String
	 */
	public String getId_orrsttp() {
		return ((String) getAttrVal("Id_orrsttp"));
	}	
	/**
	 * 医嘱结果
	 * @param Id_orrsttp
	 */
	public void setId_orrsttp(String Id_orrsttp) {
		setAttrVal("Id_orrsttp", Id_orrsttp);
	}
	/**
	 * 医嘱结果编码
	 * @return String
	 */
	public String getSd_orrsttp() {
		return ((String) getAttrVal("Sd_orrsttp"));
	}	
	/**
	 * 医嘱结果编码
	 * @param Sd_orrsttp
	 */
	public void setSd_orrsttp(String Sd_orrsttp) {
		setAttrVal("Sd_orrsttp", Sd_orrsttp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	/**
	 * 医学单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 数量_医学单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 数量_医学单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医嘱基本分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 医嘱基本分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 医学单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}	
	/**
	 * 医学单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 服务分类内码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}	
	/**
	 * 服务分类内码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
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
	 * 医疗单应用场景
	 * @return Integer
	 */
	public Integer getEmsappmode() {
		return ((Integer) getAttrVal("Emsappmode"));
	}	
	/**
	 * 医疗单应用场景
	 * @param Emsappmode
	 */
	public void setEmsappmode(Integer Emsappmode) {
		setAttrVal("Emsappmode", Emsappmode);
	}
	/**
	 * 医疗单显示名称
	 * @return String
	 */
	public String getName_ems() {
		return ((String) getAttrVal("Name_ems"));
	}	
	/**
	 * 医疗单显示名称
	 * @param Name_ems
	 */
	public void setName_ems(String Name_ems) {
		setAttrVal("Name_ems", Name_ems);
	}
	/**
	 * 医嘱执行闭环类型
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}	
	/**
	 * 医嘱执行闭环类型
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 附加信息Map键值串
	 * @return String
	 */
	public String getMapkeys() {
		return ((String) getAttrVal("Mapkeys"));
	}	
	/**
	 * 附加信息Map键值串
	 * @param Mapkeys
	 */
	public void setMapkeys(String Mapkeys) {
		setAttrVal("Mapkeys", Mapkeys);
	}
	/**
	 * 相关附加信息MAP
	 * @return FMap2
	 */
	public FMap2 getMapinfo() {
		return ((FMap2) getAttrVal("Mapinfo"));
	}	
	/**
	 * 相关附加信息MAP
	 * @param Mapinfo
	 */
	public void setMapinfo(FMap2 Mapinfo) {
		setAttrVal("Mapinfo", Mapinfo);
	}
	/**
	 * 费用同步标识
	 * @return FBoolean
	 */
	public FBoolean getFg_syncfee() {
		return ((FBoolean) getAttrVal("Fg_syncfee"));
	}	
	/**
	 * 费用同步标识
	 * @param Fg_syncfee
	 */
	public void setFg_syncfee(FBoolean Fg_syncfee) {
		setAttrVal("Fg_syncfee", Fg_syncfee);
	}
	/**
	 * 频次下次数
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}	
	/**
	 * 频次下次数
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 频次周期数
	 * @return Integer
	 */
	public Integer getFrequnitct() {
		return ((Integer) getAttrVal("Frequnitct"));
	}	
	/**
	 * 频次周期数
	 * @param Frequnitct
	 */
	public void setFrequnitct(Integer Frequnitct) {
		setAttrVal("Frequnitct", Frequnitct);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}	
	/**
	 * 频次周期类型编码
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	/**
	 * 医保适应症判断标识枚举
	 * @return Integer
	 */
	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}	
	/**
	 * 医保适应症判断标识枚举
	 * @param Eu_hpindicjudge
	 */
	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}
	/**
	 * 非径内医嘱判断标识枚
	 * @return Integer
	 */
	public Integer getEu_uncporjudge() {
		return ((Integer) getAttrVal("Eu_uncporjudge"));
	}	
	/**
	 * 非径内医嘱判断标识枚
	 * @param Eu_uncporjudge
	 */
	public void setEu_uncporjudge(Integer Eu_uncporjudge) {
		setAttrVal("Eu_uncporjudge", Eu_uncporjudge);
	}
	/**
	 * 径外医嘱使用说明
	 * @return String
	 */
	public String getReason_uncporuse() {
		return ((String) getAttrVal("Reason_uncporuse"));
	}	
	/**
	 * 径外医嘱使用说明
	 * @param Reason_uncporuse
	 */
	public void setReason_uncporuse(String Reason_uncporuse) {
		setAttrVal("Reason_uncporuse", Reason_uncporuse);
	}
	/**
	 * 患者入径标识
	 * @return String
	 */
	public String getFg_cp() {
		return ((String) getAttrVal("Fg_cp"));
	}	
	/**
	 * 患者入径标识
	 * @param Fg_cp
	 */
	public void setFg_cp(String Fg_cp) {
		setAttrVal("Fg_cp", Fg_cp);
	}
	/**
	 * 医嘱目的
	 * @return String
	 */
	public String getPurpose_or() {
		return ((String) getAttrVal("Purpose_or"));
	}	
	/**
	 * 医嘱目的
	 * @param Purpose_or
	 */
	public void setPurpose_or(String Purpose_or) {
		setAttrVal("Purpose_or", Purpose_or);
	}
	/**
	 * 可退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}	
	/**
	 * 可退费标识
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 简化的流程标识
	 * @return FBoolean
	 */
	public FBoolean getFg_quickwflow() {
		return ((FBoolean) getAttrVal("Fg_quickwflow"));
	}	
	/**
	 * 简化的流程标识
	 * @param Fg_quickwflow
	 */
	public void setFg_quickwflow(FBoolean Fg_quickwflow) {
		setAttrVal("Fg_quickwflow", Fg_quickwflow);
	}
	/**
	 * 医嘱来源模式类型
	 * @return String
	 */
	public String getEu_orsrcmdtp() {
		return ((String) getAttrVal("Eu_orsrcmdtp"));
	}	
	/**
	 * 医嘱来源模式类型
	 * @param Eu_orsrcmdtp
	 */
	public void setEu_orsrcmdtp(String Eu_orsrcmdtp) {
		setAttrVal("Eu_orsrcmdtp", Eu_orsrcmdtp);
	}
	/**
	 * 医嘱来源主标识
	 * @return String
	 */
	public String getId_orsrc_main() {
		return ((String) getAttrVal("Id_orsrc_main"));
	}	
	/**
	 * 医嘱来源主标识
	 * @param Id_orsrc_main
	 */
	public void setId_orsrc_main(String Id_orsrc_main) {
		setAttrVal("Id_orsrc_main", Id_orsrc_main);
	}
	/**
	 * 医嘱来源子标识
	 * @return String
	 */
	public String getId_orsrc_sub() {
		return ((String) getAttrVal("Id_orsrc_sub"));
	}	
	/**
	 * 医嘱来源子标识
	 * @param Id_orsrc_sub
	 */
	public void setId_orsrc_sub(String Id_orsrc_sub) {
		setAttrVal("Id_orsrc_sub", Id_orsrc_sub);
	}
	/**
	 * 医嘱来源孙标识
	 * @return String
	 */
	public String getId_orsrc_subsub() {
		return ((String) getAttrVal("Id_orsrc_subsub"));
	}	
	/**
	 * 医嘱来源孙标识
	 * @param Id_orsrc_subsub
	 */
	public void setId_orsrc_subsub(String Id_orsrc_subsub) {
		setAttrVal("Id_orsrc_subsub", Id_orsrc_subsub);
	}
	/**
	 * 基本医保判断结果数据信息
	 * @return String
	 */
	public String getBhpjudgerst() {
		return ((String) getAttrVal("Bhpjudgerst"));
	}	
	/**
	 * 基本医保判断结果数据信息
	 * @param Bhpjudgerst
	 */
	public void setBhpjudgerst(String Bhpjudgerst) {
		setAttrVal("Bhpjudgerst", Bhpjudgerst);
	}
	/**
	 * 基本医保判断结果数据信息描述
	 * @return String
	 */
	public String getDes_bhpjudgerst() {
		return ((String) getAttrVal("Des_bhpjudgerst"));
	}	
	/**
	 * 基本医保判断结果数据信息描述
	 * @param Des_bhpjudgerst
	 */
	public void setDes_bhpjudgerst(String Des_bhpjudgerst) {
		setAttrVal("Des_bhpjudgerst", Des_bhpjudgerst);
	}
	/**
	 * 时间戳
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}	
	/**
	 * 时间戳
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 费用项是否已经计算过标志
	 * @return FBoolean
	 */
	public FBoolean getFg_prisrvhandled() {
		return ((FBoolean) getAttrVal("Fg_prisrvhandled"));
	}	
	/**
	 * 费用项是否已经计算过标志
	 * @param Fg_prisrvhandled
	 */
	public void setFg_prisrvhandled(FBoolean Fg_prisrvhandled) {
		setAttrVal("Fg_prisrvhandled", Fg_prisrvhandled);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	
	/**
	 * 超量开单原因id
	 * @return String
	 */
	public String getId_excessive_reason() {
		return ((String) getAttrVal("Id_excessive_reason"));
	}	
	/**
	 * 超量开单原因id
	 * @param Id_excessive_reason
	 */
	public void setId_excessive_reason(String Id_excessive_reason) {
		setAttrVal("Id_excessive_reason", Id_excessive_reason);
	}
	/**
	 * 超量开单原因sd
	 * @return String
	 */
	public String getSd_excessive_reason() {
		return ((String) getAttrVal("Sd_excessive_reason"));
	}	
	/**
	 * 超量开单原因sd
	 * @param Sd_excessive_reason
	 */
	public void setSd_excessive_reason(String Sd_excessive_reason) {
		setAttrVal("Sd_excessive_reason", Sd_excessive_reason);
	}
	/**
	 * 超量开单原因名称
	 * @return String
	 */
	public String getName_excessive_reason() {
		return ((String) getAttrVal("Name_excessive_reason"));
	}	
	/**
	 * 超量开单原因名称
	 * @param Name_excessive_reason
	 */
	public void setName_excessive_reason(String Name_excessive_reason) {
		setAttrVal("Name_excessive_reason", Name_excessive_reason);
	}
	/**
	 * 临床项目医保标识
	 * @return FBoolean
	 */
	public FBoolean getFg_orhp() {
		return ((FBoolean) getAttrVal("Fg_orhp"));
	}	
	/**
	 * 临床项目医保标识
	 * @param Fg_orhp
	 */
	public void setFg_orhp(FBoolean Fg_orhp) {
		setAttrVal("Fg_orhp", Fg_orhp);
	}
}
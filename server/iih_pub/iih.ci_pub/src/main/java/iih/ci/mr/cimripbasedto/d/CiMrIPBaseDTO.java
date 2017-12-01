package iih.ci.mr.cimripbasedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历文书集成平台基础DTO DTO数据 
 * 
 */
public class CiMrIPBaseDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 域ID
	 * @return String
	 */
	public String getId_pre() {
		return ((String) getAttrVal("Id_pre"));
	}	
	/**
	 * 域ID
	 * @param Id_pre
	 */
	public void setId_pre(String Id_pre) {
		setAttrVal("Id_pre", Id_pre);
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
	 * 就诊次数（门诊）
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}	
	/**
	 * 就诊次数（门诊）
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 就诊次数（住院）
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}	
	/**
	 * 就诊次数（住院）
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 就诊类别编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类别编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类别名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类别名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 影像号
	 * @return String
	 */
	public String getId_img() {
		return ((String) getAttrVal("Id_img"));
	}	
	/**
	 * 影像号
	 * @param Id_img
	 */
	public void setId_img(String Id_img) {
		setAttrVal("Id_img", Id_img);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 患者年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}	
	/**
	 * 患者性别编码
	 * @param Code_sex
	 */
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
	}
	/**
	 * 患者性别名称
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	/**
	 * 患者性别名称
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
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
	 * 民族编码
	 * @return String
	 */
	public String getCode_nation() {
		return ((String) getAttrVal("Code_nation"));
	}	
	/**
	 * 民族编码
	 * @param Code_nation
	 */
	public void setCode_nation(String Code_nation) {
		setAttrVal("Code_nation", Code_nation);
	}
	/**
	 * 民族名称
	 * @return String
	 */
	public String getNation() {
		return ((String) getAttrVal("Nation"));
	}	
	/**
	 * 民族名称
	 * @param Nation
	 */
	public void setNation(String Nation) {
		setAttrVal("Nation", Nation);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getAdd() {
		return ((String) getAttrVal("Add"));
	}	
	/**
	 * 出生地
	 * @param Add
	 */
	public void setAdd(String Add) {
		setAttrVal("Add", Add);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDept() {
		return ((String) getAttrVal("Dept"));
	}	
	/**
	 * 科室名称
	 * @param Dept
	 */
	public void setDept(String Dept) {
		setAttrVal("Dept", Dept);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getDep_nuradm() {
		return ((String) getAttrVal("Dep_nuradm"));
	}	
	/**
	 * 病区名称
	 * @param Dep_nuradm
	 */
	public void setDep_nuradm(String Dep_nuradm) {
		setAttrVal("Dep_nuradm", Dep_nuradm);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床位号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 记录时间
	 * @return FDateTime
	 */
	public FDateTime getDt_record() {
		return ((FDateTime) getAttrVal("Dt_record"));
	}	
	/**
	 * 记录时间
	 * @param Dt_record
	 */
	public void setDt_record(FDateTime Dt_record) {
		setAttrVal("Dt_record", Dt_record);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getCode_doc() {
		return ((String) getAttrVal("Code_doc"));
	}	
	/**
	 * 医生编码
	 * @param Code_doc
	 */
	public void setCode_doc(String Code_doc) {
		setAttrVal("Code_doc", Code_doc);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getDoc() {
		return ((String) getAttrVal("Doc"));
	}	
	/**
	 * 医生名称
	 * @param Doc
	 */
	public void setDoc(String Doc) {
		setAttrVal("Doc", Doc);
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
	 * 修改日期
	 * @return FDateTime
	 */
	public FDateTime getDt_update() {
		return ((FDateTime) getAttrVal("Dt_update"));
	}	
	/**
	 * 修改日期
	 * @param Dt_update
	 */
	public void setDt_update(FDateTime Dt_update) {
		setAttrVal("Dt_update", Dt_update);
	}
	/**
	 * 修改医生编码
	 * @return String
	 */
	public String getCode_up_doc() {
		return ((String) getAttrVal("Code_up_doc"));
	}	
	/**
	 * 修改医生编码
	 * @param Code_up_doc
	 */
	public void setCode_up_doc(String Code_up_doc) {
		setAttrVal("Code_up_doc", Code_up_doc);
	}
	/**
	 * 修改医生名称
	 * @return String
	 */
	public String getUp_doc() {
		return ((String) getAttrVal("Up_doc"));
	}	
	/**
	 * 修改医生名称
	 * @param Up_doc
	 */
	public void setUp_doc(String Up_doc) {
		setAttrVal("Up_doc", Up_doc);
	}
	/**
	 * 审签人信息集合
	 * @return String
	 */
	public FArrayList getLs_audit() {
		return ((FArrayList) getAttrVal("Ls_audit"));
	}	
	/**
	 * 审签人信息集合
	 * @param Ls_audit
	 */
	public void setLs_audit(FArrayList Ls_audit) {
		setAttrVal("Ls_audit", Ls_audit);
	}
	/**
	 * 关联医嘱信息集合
	 * @return String
	 */
	public FArrayList getLs_order() {
		return ((FArrayList) getAttrVal("Ls_order"));
	}	
	/**
	 * 关联医嘱信息集合
	 * @param Ls_order
	 */
	public void setLs_order(FArrayList Ls_order) {
		setAttrVal("Ls_order", Ls_order);
	}
	/**
	 * 影像索引号
	 * @return String
	 */
	public String getIma_index() {
		return ((String) getAttrVal("Ima_index"));
	}	
	/**
	 * 影像索引号
	 * @param Ima_index
	 */
	public void setIma_index(String Ima_index) {
		setAttrVal("Ima_index", Ima_index);
	}
	/**
	 * 手术开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ope_start() {
		return ((FDateTime) getAttrVal("Dt_ope_start"));
	}	
	/**
	 * 手术开始时间
	 * @param Dt_ope_start
	 */
	public void setDt_ope_start(FDateTime Dt_ope_start) {
		setAttrVal("Dt_ope_start", Dt_ope_start);
	}
	/**
	 * 手术结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ope_end() {
		return ((FDateTime) getAttrVal("Dt_ope_end"));
	}	
	/**
	 * 手术结束时间
	 * @param Dt_ope_end
	 */
	public void setDt_ope_end(FDateTime Dt_ope_end) {
		setAttrVal("Dt_ope_end", Dt_ope_end);
	}
	/**
	 * 手术名称编码
	 * @return String
	 */
	public String getCode_ope() {
		return ((String) getAttrVal("Code_ope"));
	}	
	/**
	 * 手术名称编码
	 * @param Code_ope
	 */
	public void setCode_ope(String Code_ope) {
		setAttrVal("Code_ope", Code_ope);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getOpe() {
		return ((String) getAttrVal("Ope"));
	}	
	/**
	 * 手术名称
	 * @param Ope
	 */
	public void setOpe(String Ope) {
		setAttrVal("Ope", Ope);
	}
	/**
	 * 手术间编码
	 * @return String
	 */
	public String getCode_ope_room() {
		return ((String) getAttrVal("Code_ope_room"));
	}	
	/**
	 * 手术间编码
	 * @param Code_ope_room
	 */
	public void setCode_ope_room(String Code_ope_room) {
		setAttrVal("Code_ope_room", Code_ope_room);
	}
	/**
	 * 手术间名称
	 * @return String
	 */
	public String getOpe_room() {
		return ((String) getAttrVal("Ope_room"));
	}	
	/**
	 * 手术间名称
	 * @param Ope_room
	 */
	public void setOpe_room(String Ope_room) {
		setAttrVal("Ope_room", Ope_room);
	}
	/**
	 * 切口愈合等级编码
	 * @return String
	 */
	public String getCocde_incicondi() {
		return ((String) getAttrVal("Cocde_incicondi"));
	}	
	/**
	 * 切口愈合等级编码
	 * @param Cocde_incicondi
	 */
	public void setCocde_incicondi(String Cocde_incicondi) {
		setAttrVal("Cocde_incicondi", Cocde_incicondi);
	}
	/**
	 * 切口愈合等级名称
	 * @return String
	 */
	public String getIncicondi() {
		return ((String) getAttrVal("Incicondi"));
	}	
	/**
	 * 切口愈合等级名称
	 * @param Incicondi
	 */
	public void setIncicondi(String Incicondi) {
		setAttrVal("Incicondi", Incicondi);
	}
	/**
	 * 麻醉方式编码
	 * @return String
	 */
	public String getCode_anestp() {
		return ((String) getAttrVal("Code_anestp"));
	}	
	/**
	 * 麻醉方式编码
	 * @param Code_anestp
	 */
	public void setCode_anestp(String Code_anestp) {
		setAttrVal("Code_anestp", Code_anestp);
	}
	/**
	 * 麻醉方式名称
	 * @return String
	 */
	public String getAnestp() {
		return ((String) getAttrVal("Anestp"));
	}	
	/**
	 * 麻醉方式名称
	 * @param Anestp
	 */
	public void setAnestp(String Anestp) {
		setAttrVal("Anestp", Anestp);
	}
	/**
	 * 术前简历
	 * @return String
	 */
	public String getOpe_res() {
		return ((String) getAttrVal("Ope_res"));
	}	
	/**
	 * 术前简历
	 * @param Ope_res
	 */
	public void setOpe_res(String Ope_res) {
		setAttrVal("Ope_res", Ope_res);
	}
	/**
	 * 操作步骤
	 * @return String
	 */
	public String getOpe_step() {
		return ((String) getAttrVal("Ope_step"));
	}	
	/**
	 * 操作步骤
	 * @param Ope_step
	 */
	public void setOpe_step(String Ope_step) {
		setAttrVal("Ope_step", Ope_step);
	}
	/**
	 * 术者信息结合
	 * @return String
	 */
	public FArrayList getLs_ope_doc() {
		return ((FArrayList) getAttrVal("Ls_ope_doc"));
	}	
	/**
	 * 术者信息结合
	 * @param Ls_ope_doc
	 */
	public void setLs_ope_doc(FArrayList Ls_ope_doc) {
		setAttrVal("Ls_ope_doc", Ls_ope_doc);
	}
	/**
	 * 助手信息集合
	 * @return String
	 */
	public FArrayList getLs_ope_ass() {
		return ((FArrayList) getAttrVal("Ls_ope_ass"));
	}	
	/**
	 * 助手信息集合
	 * @param Ls_ope_ass
	 */
	public void setLs_ope_ass(FArrayList Ls_ope_ass) {
		setAttrVal("Ls_ope_ass", Ls_ope_ass);
	}
	/**
	 * 护士信息结合
	 * @return String
	 */
	public FArrayList getLs_ope_nur() {
		return ((FArrayList) getAttrVal("Ls_ope_nur"));
	}	
	/**
	 * 护士信息结合
	 * @param Ls_ope_nur
	 */
	public void setLs_ope_nur(FArrayList Ls_ope_nur) {
		setAttrVal("Ls_ope_nur", Ls_ope_nur);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getIp_day() {
		return ((Integer) getAttrVal("Ip_day"));
	}	
	/**
	 * 住院天数
	 * @param Ip_day
	 */
	public void setIp_day(Integer Ip_day) {
		setAttrVal("Ip_day", Ip_day);
	}
	/**
	 * 出院情况信息
	 * @return String
	 */
	public String getLeave_info() {
		return ((String) getAttrVal("Leave_info"));
	}	
	/**
	 * 出院情况信息
	 * @param Leave_info
	 */
	public void setLeave_info(String Leave_info) {
		setAttrVal("Leave_info", Leave_info);
	}
	/**
	 * 出院诊断证明书信息
	 * @return String
	 */
	public String getLeave_dia_info() {
		return ((String) getAttrVal("Leave_dia_info"));
	}	
	/**
	 * 出院诊断证明书信息
	 * @param Leave_dia_info
	 */
	public void setLeave_dia_info(String Leave_dia_info) {
		setAttrVal("Leave_dia_info", Leave_dia_info);
	}
	/**
	 * 出院后多少周复诊
	 * @return String
	 */
	public String getLeave_week_rv() {
		return ((String) getAttrVal("Leave_week_rv"));
	}	
	/**
	 * 出院后多少周复诊
	 * @param Leave_week_rv
	 */
	public void setLeave_week_rv(String Leave_week_rv) {
		setAttrVal("Leave_week_rv", Leave_week_rv);
	}
	/**
	 * 采史日期
	 * @return FDateTime
	 */
	public FDateTime getDt_ga_mh() {
		return ((FDateTime) getAttrVal("Dt_ga_mh"));
	}	
	/**
	 * 采史日期
	 * @param Dt_ga_mh
	 */
	public void setDt_ga_mh(FDateTime Dt_ga_mh) {
		setAttrVal("Dt_ga_mh", Dt_ga_mh);
	}
	/**
	 * 采史人地址
	 * @return String
	 */
	public String getAdd_ga_mh() {
		return ((String) getAttrVal("Add_ga_mh"));
	}	
	/**
	 * 采史人地址
	 * @param Add_ga_mh
	 */
	public void setAdd_ga_mh(String Add_ga_mh) {
		setAttrVal("Add_ga_mh", Add_ga_mh);
	}
	/**
	 * 采史人电话
	 * @return String
	 */
	public String getPho_ga_mh() {
		return ((String) getAttrVal("Pho_ga_mh"));
	}	
	/**
	 * 采史人电话
	 * @param Pho_ga_mh
	 */
	public void setPho_ga_mh(String Pho_ga_mh) {
		setAttrVal("Pho_ga_mh", Pho_ga_mh);
	}
	/**
	 * 病史陈述者名称
	 * @return String
	 */
	public String getGa_mh() {
		return ((String) getAttrVal("Ga_mh"));
	}	
	/**
	 * 病史陈述者名称
	 * @param Ga_mh
	 */
	public void setGa_mh(String Ga_mh) {
		setAttrVal("Ga_mh", Ga_mh);
	}
	/**
	 * 采史人关系编码
	 * @return String
	 */
	public String getCode_ga_mh_re() {
		return ((String) getAttrVal("Code_ga_mh_re"));
	}	
	/**
	 * 采史人关系编码
	 * @param Code_ga_mh_re
	 */
	public void setCode_ga_mh_re(String Code_ga_mh_re) {
		setAttrVal("Code_ga_mh_re", Code_ga_mh_re);
	}
	/**
	 * 采史人关系名称
	 * @return String
	 */
	public String getGa_mh_re() {
		return ((String) getAttrVal("Ga_mh_re"));
	}	
	/**
	 * 采史人关系名称
	 * @param Ga_mh_re
	 */
	public void setGa_mh_re(String Ga_mh_re) {
		setAttrVal("Ga_mh_re", Ga_mh_re);
	}
	/**
	 * 可靠程度编码
	 * @return String
	 */
	public String getCode_re_de() {
		return ((String) getAttrVal("Code_re_de"));
	}	
	/**
	 * 可靠程度编码
	 * @param Code_re_de
	 */
	public void setCode_re_de(String Code_re_de) {
		setAttrVal("Code_re_de", Code_re_de);
	}
	/**
	 * 可靠程度名称
	 * @return String
	 */
	public String getRe_de() {
		return ((String) getAttrVal("Re_de"));
	}	
	/**
	 * 可靠程度名称
	 * @param Re_de
	 */
	public void setRe_de(String Re_de) {
		setAttrVal("Re_de", Re_de);
	}
	/**
	 * 主诉
	 * @return String
	 */
	public String getCh_co() {
		return ((String) getAttrVal("Ch_co"));
	}	
	/**
	 * 主诉
	 * @param Ch_co
	 */
	public void setCh_co(String Ch_co) {
		setAttrVal("Ch_co", Ch_co);
	}
	/**
	 * 现病史
	 * @return String
	 */
	public String getIll_ht() {
		return ((String) getAttrVal("Ill_ht"));
	}	
	/**
	 * 现病史
	 * @param Ill_ht
	 */
	public void setIll_ht(String Ill_ht) {
		setAttrVal("Ill_ht", Ill_ht);
	}
	/**
	 * 既往史
	 * @return String
	 */
	public String getPa_ht() {
		return ((String) getAttrVal("Pa_ht"));
	}	
	/**
	 * 既往史
	 * @param Pa_ht
	 */
	public void setPa_ht(String Pa_ht) {
		setAttrVal("Pa_ht", Pa_ht);
	}
	/**
	 * 药物过敏史
	 * @return String
	 */
	public String getMe_al_ht() {
		return ((String) getAttrVal("Me_al_ht"));
	}	
	/**
	 * 药物过敏史
	 * @param Me_al_ht
	 */
	public void setMe_al_ht(String Me_al_ht) {
		setAttrVal("Me_al_ht", Me_al_ht);
	}
	/**
	 * 家族史
	 * @return String
	 */
	public String getFa_ht() {
		return ((String) getAttrVal("Fa_ht"));
	}	
	/**
	 * 家族史
	 * @param Fa_ht
	 */
	public void setFa_ht(String Fa_ht) {
		setAttrVal("Fa_ht", Fa_ht);
	}
	/**
	 * 社会/个人史
	 * @return String
	 */
	public String getPe_ht() {
		return ((String) getAttrVal("Pe_ht"));
	}	
	/**
	 * 社会/个人史
	 * @param Pe_ht
	 */
	public void setPe_ht(String Pe_ht) {
		setAttrVal("Pe_ht", Pe_ht);
	}
	/**
	 * 婚育史
	 * @return String
	 */
	public String getMa_ht() {
		return ((String) getAttrVal("Ma_ht"));
	}	
	/**
	 * 婚育史
	 * @param Ma_ht
	 */
	public void setMa_ht(String Ma_ht) {
		setAttrVal("Ma_ht", Ma_ht);
	}
	/**
	 * 体格检查信息
	 * @return String
	 */
	public String getPh_ex_info() {
		return ((String) getAttrVal("Ph_ex_info"));
	}	
	/**
	 * 体格检查信息
	 * @param Ph_ex_info
	 */
	public void setPh_ex_info(String Ph_ex_info) {
		setAttrVal("Ph_ex_info", Ph_ex_info);
	}
	/**
	 * 专科检查章节标题
	 * @return String
	 */
	public String getSp_ex_title() {
		return ((String) getAttrVal("Sp_ex_title"));
	}	
	/**
	 * 专科检查章节标题
	 * @param Sp_ex_title
	 */
	public void setSp_ex_title(String Sp_ex_title) {
		setAttrVal("Sp_ex_title", Sp_ex_title);
	}
	/**
	 * 专科检查
	 * @return String
	 */
	public String getSp_ex() {
		return ((String) getAttrVal("Sp_ex"));
	}	
	/**
	 * 专科检查
	 * @param Sp_ex
	 */
	public void setSp_ex(String Sp_ex) {
		setAttrVal("Sp_ex", Sp_ex);
	}
	/**
	 * 辅助检查章节标题
	 * @return String
	 */
	public String getSu_ex_title() {
		return ((String) getAttrVal("Su_ex_title"));
	}	
	/**
	 * 辅助检查章节标题
	 * @param Su_ex_title
	 */
	public void setSu_ex_title(String Su_ex_title) {
		setAttrVal("Su_ex_title", Su_ex_title);
	}
	/**
	 * 辅助检查
	 * @return String
	 */
	public String getSu_ex() {
		return ((String) getAttrVal("Su_ex"));
	}	
	/**
	 * 辅助检查
	 * @param Su_ex
	 */
	public void setSu_ex(String Su_ex) {
		setAttrVal("Su_ex", Su_ex);
	}
	/**
	 * 文书内容
	 * @return String
	 */
	public String getMr_area() {
		return ((String) getAttrVal("Mr_area"));
	}	
	/**
	 * 文书内容
	 * @param Mr_area
	 */
	public void setMr_area(String Mr_area) {
		setAttrVal("Mr_area", Mr_area);
	}
	/**
	 * 入院情况
	 * @return String
	 */
	public String getIn_si() {
		return ((String) getAttrVal("In_si"));
	}	
	/**
	 * 入院情况
	 * @param In_si
	 */
	public void setIn_si(String In_si) {
		setAttrVal("In_si", In_si);
	}
	/**
	 * 诊疗经过
	 * @return String
	 */
	public String getTreatment() {
		return ((String) getAttrVal("Treatment"));
	}	
	/**
	 * 诊疗经过
	 * @param Treatment
	 */
	public void setTreatment(String Treatment) {
		setAttrVal("Treatment", Treatment);
	}
	/**
	 * 死亡日期
	 * @return FDateTime
	 */
	public FDateTime getDt_de() {
		return ((FDateTime) getAttrVal("Dt_de"));
	}	
	/**
	 * 死亡日期
	 * @param Dt_de
	 */
	public void setDt_de(FDateTime Dt_de) {
		setAttrVal("Dt_de", Dt_de);
	}
	/**
	 * 抢救过程
	 * @return String
	 */
	public String getRe_pr() {
		return ((String) getAttrVal("Re_pr"));
	}	
	/**
	 * 抢救过程
	 * @param Re_pr
	 */
	public void setRe_pr(String Re_pr) {
		setAttrVal("Re_pr", Re_pr);
	}
	/**
	 * 死亡原因
	 * @return String
	 */
	public String getDe_re() {
		return ((String) getAttrVal("De_re"));
	}	
	/**
	 * 死亡原因
	 * @param De_re
	 */
	public void setDe_re(String De_re) {
		setAttrVal("De_re", De_re);
	}
	/**
	 * 签名人编码
	 * @return String
	 */
	public String getCode_doc_sign() {
		return ((String) getAttrVal("Code_doc_sign"));
	}	
	/**
	 * 签名人编码
	 * @param Code_doc_sign
	 */
	public void setCode_doc_sign(String Code_doc_sign) {
		setAttrVal("Code_doc_sign", Code_doc_sign);
	}
	/**
	 * 签名人名称
	 * @return String
	 */
	public String getDoc_sign() {
		return ((String) getAttrVal("Doc_sign"));
	}	
	/**
	 * 签名人名称
	 * @param Doc_sign
	 */
	public void setDoc_sign(String Doc_sign) {
		setAttrVal("Doc_sign", Doc_sign);
	}
	/**
	 * 病历及诊治摘要
	 * @return String
	 */
	public String getMr_ab() {
		return ((String) getAttrVal("Mr_ab"));
	}	
	/**
	 * 病历及诊治摘要
	 * @param Mr_ab
	 */
	public void setMr_ab(String Mr_ab) {
		setAttrVal("Mr_ab", Mr_ab);
	}
	/**
	 * 出院医嘱内容
	 * @return String
	 */
	public String getOr_le_ar() {
		return ((String) getAttrVal("Or_le_ar"));
	}	
	/**
	 * 出院医嘱内容
	 * @param Or_le_ar
	 */
	public void setOr_le_ar(String Or_le_ar) {
		setAttrVal("Or_le_ar", Or_le_ar);
	}
	/**
	 * 诊断信息集合
	 * @return String
	 */
	public FArrayList getLs_dia() {
		return ((FArrayList) getAttrVal("Ls_dia"));
	}	
	/**
	 * 诊断信息集合
	 * @param Ls_dia
	 */
	public void setLs_dia(FArrayList Ls_dia) {
		setAttrVal("Ls_dia", Ls_dia);
	}
	/**
	 * 章节信息集合
	 * @return String
	 */
	public FArrayList getLs_sec() {
		return ((FArrayList) getAttrVal("Ls_sec"));
	}	
	/**
	 * 章节信息集合
	 * @param Ls_sec
	 */
	public void setLs_sec(FArrayList Ls_sec) {
		setAttrVal("Ls_sec", Ls_sec);
	}
	/**
	 * 讨论时间
	 * @return FDateTime
	 */
	public FDateTime getDt_meet() {
		return ((FDateTime) getAttrVal("Dt_meet"));
	}	
	/**
	 * 讨论时间
	 * @param Dt_meet
	 */
	public void setDt_meet(FDateTime Dt_meet) {
		setAttrVal("Dt_meet", Dt_meet);
	}
	/**
	 * 会议主持者集合
	 * @return String
	 */
	public FArrayList getLs_me_ho() {
		return ((FArrayList) getAttrVal("Ls_me_ho"));
	}	
	/**
	 * 会议主持者集合
	 * @param Ls_me_ho
	 */
	public void setLs_me_ho(FArrayList Ls_me_ho) {
		setAttrVal("Ls_me_ho", Ls_me_ho);
	}
	/**
	 * 会议参加者集合
	 * @return String
	 */
	public FArrayList getLs_me_pa() {
		return ((FArrayList) getAttrVal("Ls_me_pa"));
	}	
	/**
	 * 会议参加者集合
	 * @param Ls_me_pa
	 */
	public void setLs_me_pa(FArrayList Ls_me_pa) {
		setAttrVal("Ls_me_pa", Ls_me_pa);
	}
	/**
	 * 地点信息
	 * @return String
	 */
	public String getMe_add() {
		return ((String) getAttrVal("Me_add"));
	}	
	/**
	 * 地点信息
	 * @param Me_add
	 */
	public void setMe_add(String Me_add) {
		setAttrVal("Me_add", Me_add);
	}
	/**
	 * 讨论结论
	 * @return String
	 */
	public String getMe_co() {
		return ((String) getAttrVal("Me_co"));
	}	
	/**
	 * 讨论结论
	 * @param Me_co
	 */
	public void setMe_co(String Me_co) {
		setAttrVal("Me_co", Me_co);
	}
	/**
	 * 参照本例应借鉴的问题
	 * @return String
	 */
	public String getMe_le() {
		return ((String) getAttrVal("Me_le"));
	}	
	/**
	 * 参照本例应借鉴的问题
	 * @param Me_le
	 */
	public void setMe_le(String Me_le) {
		setAttrVal("Me_le", Me_le);
	}
	/**
	 * 数据集编码
	 * @return String
	 */
	public String getCode_set() {
		return ((String) getAttrVal("Code_set"));
	}	
	/**
	 * 数据集编码
	 * @param Code_set
	 */
	public void setCode_set(String Code_set) {
		setAttrVal("Code_set", Code_set);
	}
	/**
	 * 文书二进制
	 * @return byte[]
	 */
	public byte[] getFs() {
		return ((byte[]) getAttrVal("Fs"));
	}	
	/**
	 * 文书二进制
	 * @param Fs
	 */
	public void setFs(byte[] Fs) {
		setAttrVal("Fs", Fs);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 病理诊断
	 * @return String
	 */
	public String getPa_dia() {
		return ((String) getAttrVal("Pa_dia"));
	}	
	/**
	 * 病理诊断
	 * @param Pa_dia
	 */
	public void setPa_dia(String Pa_dia) {
		setAttrVal("Pa_dia", Pa_dia);
	}
	/**
	 * 经治医师陈述
	 * @return String
	 */
	public String getOb_va() {
		return ((String) getAttrVal("Ob_va"));
	}	
	/**
	 * 经治医师陈述
	 * @param Ob_va
	 */
	public void setOb_va(String Ob_va) {
		setAttrVal("Ob_va", Ob_va);
	}
	/**
	 * 接口服务id
	 * @return String
	 */
	public String getId_server() {
		return ((String) getAttrVal("Id_server"));
	}	
	/**
	 * 接口服务id
	 * @param Id_server
	 */
	public void setId_server(String Id_server) {
		setAttrVal("Id_server", Id_server);
	}
	/**
	 * 文书主键
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	/**
	 * 文书主键
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 就诊主键
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 消息类型
	 * @return String
	 */
	public String getType_message() {
		return ((String) getAttrVal("Type_message"));
	}	
	/**
	 * 消息类型
	 * @param Type_message
	 */
	public void setType_message(String Type_message) {
		setAttrVal("Type_message", Type_message);
	}
}
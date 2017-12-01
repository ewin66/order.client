package iih.ci.rcm.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 传染病报告卡打印 DTO数据
 * 
 */
public class ContagionMainCardPrintDto extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 传染病报告卡id
	 * 
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}

	/**
	 * 传染病报告卡id
	 * 
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}

	/**
	 * 业务接口
	 * 
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}

	/**
	 * 业务接口
	 * 
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}

	/**
	 * 就诊id
	 * 
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}

	/**
	 * 就诊id
	 * 
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}

	/**
	 * 父id
	 * 
	 * @return String
	 */
	public String getP_id_contagion() {
		return ((String) getAttrVal("P_id_contagion"));
	}

	/**
	 * 父id
	 * 
	 * @param P_id_contagion
	 */
	public void setP_id_contagion(String P_id_contagion) {
		setAttrVal("P_id_contagion", P_id_contagion);
	}

	/**
	 * 表单id
	 * 
	 * @return String
	 */
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}

	/**
	 * 表单id
	 * 
	 * @param Id_form
	 */
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}

	/**
	 * 卡片编号
	 * 
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}

	/**
	 * 卡片编号
	 * 
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}

	/**
	 * 报卡类别
	 * 
	 * @return String
	 */
	public String getEu_bklb() {
		return ((String) getAttrVal("Eu_bklb"));
	}

	/**
	 * 报卡类别
	 * 
	 * @param Eu_bklb
	 */
	public void setEu_bklb(String Eu_bklb) {
		setAttrVal("Eu_bklb", Eu_bklb);
	}

	/**
	 * 报卡类别编码
	 * 
	 * @return String
	 */
	public String getEu_bklb_code() {
		return ((String) getAttrVal("Eu_bklb_code"));
	}

	/**
	 * 报卡类别编码
	 * 
	 * @param Eu_bklb_code
	 */
	public void setEu_bklb_code(String Eu_bklb_code) {
		setAttrVal("Eu_bklb_code", Eu_bklb_code);
	}

	/**
	 * 报卡类别名称
	 * 
	 * @return String
	 */
	public String getEu_bklb_name() {
		return ((String) getAttrVal("Eu_bklb_name"));
	}

	/**
	 * 报卡类别名称
	 * 
	 * @param Eu_bklb_name
	 */
	public void setEu_bklb_name(String Eu_bklb_name) {
		setAttrVal("Eu_bklb_name", Eu_bklb_name);
	}

	/**
	 * 传染卡状态
	 * 
	 * @return String
	 */
	public String getId_con_cardsu() {
		return ((String) getAttrVal("Id_con_cardsu"));
	}

	/**
	 * 传染卡状态
	 * 
	 * @param Id_con_cardsu
	 */
	public void setId_con_cardsu(String Id_con_cardsu) {
		setAttrVal("Id_con_cardsu", Id_con_cardsu);
	}

	/**
	 * 传染卡状态编码
	 * 
	 * @return String
	 */
	public String getSd_con_cardsu() {
		return ((String) getAttrVal("Sd_con_cardsu"));
	}

	/**
	 * 传染卡状态编码
	 * 
	 * @param Sd_con_cardsu
	 */
	public void setSd_con_cardsu(String Sd_con_cardsu) {
		setAttrVal("Sd_con_cardsu", Sd_con_cardsu);
	}

	/**
	 * 传染卡状态名称
	 * 
	 * @return String
	 */
	public String getName_con_cardsu() {
		return ((String) getAttrVal("Name_con_cardsu"));
	}

	/**
	 * 传染卡状态名称
	 * 
	 * @param Name_con_cardsu
	 */
	public void setName_con_cardsu(String Name_con_cardsu) {
		setAttrVal("Name_con_cardsu", Name_con_cardsu);
	}

	/**
	 * 姓名
	 * 
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}

	/**
	 * 姓名
	 * 
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}

	/**
	 * 有效证件号
	 * 
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}

	/**
	 * 有效证件号
	 * 
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}

	/**
	 * 订正病名
	 * 
	 * @return String
	 */
	public String getRevised_name() {
		return ((String) getAttrVal("Revised_name"));
	}

	/**
	 * 订正病名
	 * 
	 * @param Revised_name
	 */
	public void setRevised_name(String Revised_name) {
		setAttrVal("Revised_name", Revised_name);
	}

	/**
	 * 退卡原因
	 * 
	 * @return String
	 */
	public String getRetreat_reason() {
		return ((String) getAttrVal("Retreat_reason"));
	}

	/**
	 * 退卡原因
	 * 
	 * @param Retreat_reason
	 */
	public void setRetreat_reason(String Retreat_reason) {
		setAttrVal("Retreat_reason", Retreat_reason);
	}

	/**
	 * 报告单位
	 * 
	 * @return String
	 */
	public String getReport_unit() {
		return ((String) getAttrVal("Report_unit"));
	}

	/**
	 * 报告单位
	 * 
	 * @param Report_unit
	 */
	public void setReport_unit(String Report_unit) {
		setAttrVal("Report_unit", Report_unit);
	}

	/**
	 * 报告单位编码
	 * 
	 * @return String
	 */
	public String getReport_unit_code() {
		return ((String) getAttrVal("Report_unit_code"));
	}

	/**
	 * 报告单位编码
	 * 
	 * @param Report_unit_code
	 */
	public void setReport_unit_code(String Report_unit_code) {
		setAttrVal("Report_unit_code", Report_unit_code);
	}

	/**
	 * 报告单位名称
	 * 
	 * @return String
	 */
	public String getReport_unit_name() {
		return ((String) getAttrVal("Report_unit_name"));
	}

	/**
	 * 报告单位名称
	 * 
	 * @param Report_unit_name
	 */
	public void setReport_unit_name(String Report_unit_name) {
		setAttrVal("Report_unit_name", Report_unit_name);
	}

	/**
	 * 填卡医生
	 * 
	 * @return String
	 */
	public String getDoctor_card() {
		return ((String) getAttrVal("Doctor_card"));
	}

	/**
	 * 填卡医生
	 * 
	 * @param Doctor_card
	 */
	public void setDoctor_card(String Doctor_card) {
		setAttrVal("Doctor_card", Doctor_card);
	}

	/**
	 * 甲类传染病
	 * 
	 * @return String
	 */
	public String getEu_jlcrb() {
		return ((String) getAttrVal("Eu_jlcrb"));
	}

	/**
	 * 甲类传染病
	 * 
	 * @param Eu_jlcrb
	 */
	public void setEu_jlcrb(String Eu_jlcrb) {
		setAttrVal("Eu_jlcrb", Eu_jlcrb);
	}

	/**
	 * 甲类传染病编码
	 * 
	 * @return String
	 */
	public String getEu_jlcrb_code() {
		return ((String) getAttrVal("Eu_jlcrb_code"));
	}

	/**
	 * 甲类传染病编码
	 * 
	 * @param Eu_jlcrb_code
	 */
	public void setEu_jlcrb_code(String Eu_jlcrb_code) {
		setAttrVal("Eu_jlcrb_code", Eu_jlcrb_code);
	}

	/**
	 * 甲类传染病名称
	 * 
	 * @return String
	 */
	public String getEu_jlcrb_name() {
		return ((String) getAttrVal("Eu_jlcrb_name"));
	}

	/**
	 * 甲类传染病名称
	 * 
	 * @param Eu_jlcrb_name
	 */
	public void setEu_jlcrb_name(String Eu_jlcrb_name) {
		setAttrVal("Eu_jlcrb_name", Eu_jlcrb_name);
	}

	/**
	 * 乙类传染病
	 * 
	 * @return String
	 */
	public String getEu_ylcrb() {
		return ((String) getAttrVal("Eu_ylcrb"));
	}

	/**
	 * 乙类传染病
	 * 
	 * @param Eu_ylcrb
	 */
	public void setEu_ylcrb(String Eu_ylcrb) {
		setAttrVal("Eu_ylcrb", Eu_ylcrb);
	}

	/**
	 * 乙类传染病编码
	 * 
	 * @return String
	 */
	public String getEu_ylcrb_code() {
		return ((String) getAttrVal("Eu_ylcrb_code"));
	}

	/**
	 * 乙类传染病编码
	 * 
	 * @param Eu_ylcrb_code
	 */
	public void setEu_ylcrb_code(String Eu_ylcrb_code) {
		setAttrVal("Eu_ylcrb_code", Eu_ylcrb_code);
	}

	/**
	 * 乙类传染病名称
	 * 
	 * @return String
	 */
	public String getEu_ylcrb_name() {
		return ((String) getAttrVal("Eu_ylcrb_name"));
	}

	/**
	 * 乙类传染病名称
	 * 
	 * @param Eu_ylcrb_name
	 */
	public void setEu_ylcrb_name(String Eu_ylcrb_name) {
		setAttrVal("Eu_ylcrb_name", Eu_ylcrb_name);
	}

	/**
	 * 丙类传染病
	 * 
	 * @return String
	 */
	public String getEu_blcrb() {
		return ((String) getAttrVal("Eu_blcrb"));
	}

	/**
	 * 丙类传染病
	 * 
	 * @param Eu_blcrb
	 */
	public void setEu_blcrb(String Eu_blcrb) {
		setAttrVal("Eu_blcrb", Eu_blcrb);
	}

	/**
	 * 丙类传染病编码
	 * 
	 * @return String
	 */
	public String getEu_blcrb_code() {
		return ((String) getAttrVal("Eu_blcrb_code"));
	}

	/**
	 * 丙类传染病编码
	 * 
	 * @param Eu_blcrb_code
	 */
	public void setEu_blcrb_code(String Eu_blcrb_code) {
		setAttrVal("Eu_blcrb_code", Eu_blcrb_code);
	}

	/**
	 * 病类传染病名称
	 * 
	 * @return String
	 */
	public String getEu_blcrb_name() {
		return ((String) getAttrVal("Eu_blcrb_name"));
	}

	/**
	 * 病类传染病名称
	 * 
	 * @param Eu_blcrb_name
	 */
	public void setEu_blcrb_name(String Eu_blcrb_name) {
		setAttrVal("Eu_blcrb_name", Eu_blcrb_name);
	}

	/**
	 * 其他传染病
	 * 
	 * @return String
	 */
	public String getId_other_diseases() {
		return ((String) getAttrVal("Id_other_diseases"));
	}

	/**
	 * 其他传染病
	 * 
	 * @param Id_other_diseases
	 */
	public void setId_other_diseases(String Id_other_diseases) {
		setAttrVal("Id_other_diseases", Id_other_diseases);
	}

	/**
	 * 其他传染病编码
	 * 
	 * @return String
	 */
	public String getSd_other_diseases() {
		return ((String) getAttrVal("Sd_other_diseases"));
	}

	/**
	 * 其他传染病编码
	 * 
	 * @param Sd_other_diseases
	 */
	public void setSd_other_diseases(String Sd_other_diseases) {
		setAttrVal("Sd_other_diseases", Sd_other_diseases);
	}

	/**
	 * 其他传染病名称
	 * 
	 * @return String
	 */
	public String getName_other_diseases() {
		return ((String) getAttrVal("Name_other_diseases"));
	}

	/**
	 * 其他传染病名称
	 * 
	 * @param Name_other_diseases
	 */
	public void setName_other_diseases(String Name_other_diseases) {
		setAttrVal("Name_other_diseases", Name_other_diseases);
	}

	/**
	 * 有无相同症状
	 * 
	 * @return FBoolean
	 */
	public FBoolean getIs_alike() {
		return ((FBoolean) getAttrVal("Is_alike"));
	}

	/**
	 * 有无相同症状
	 * 
	 * @param Is_alike
	 */
	public void setIs_alike(FBoolean Is_alike) {
		setAttrVal("Is_alike", Is_alike);
	}

	/**
	 * 病例分类
	 * 
	 * @return String
	 */
	public String getEu_blfl() {
		return ((String) getAttrVal("Eu_blfl"));
	}

	/**
	 * 病例分类
	 * 
	 * @param Eu_blfl
	 */
	public void setEu_blfl(String Eu_blfl) {
		setAttrVal("Eu_blfl", Eu_blfl);
	}

	/**
	 * 病例分类编码
	 * 
	 * @return String
	 */
	public String getEu_blfl_code() {
		return ((String) getAttrVal("Eu_blfl_code"));
	}

	/**
	 * 病例分类编码
	 * 
	 * @param Eu_blfl_code
	 */
	public void setEu_blfl_code(String Eu_blfl_code) {
		setAttrVal("Eu_blfl_code", Eu_blfl_code);
	}

	/**
	 * 病例分类名称
	 * 
	 * @return String
	 */
	public String getEu_blfl_name() {
		return ((String) getAttrVal("Eu_blfl_name"));
	}

	/**
	 * 病例分类名称
	 * 
	 * @param Eu_blfl_name
	 */
	public void setEu_blfl_name(String Eu_blfl_name) {
		setAttrVal("Eu_blfl_name", Eu_blfl_name);
	}

	/**
	 * 病人属于
	 * 
	 * @return String
	 */
	public String getEu_brsy() {
		return ((String) getAttrVal("Eu_brsy"));
	}

	/**
	 * 病人属于
	 * 
	 * @param Eu_brsy
	 */
	public void setEu_brsy(String Eu_brsy) {
		setAttrVal("Eu_brsy", Eu_brsy);
	}

	/**
	 * 病人属于编码
	 * 
	 * @return String
	 */
	public String getEu_brsy_code() {
		return ((String) getAttrVal("Eu_brsy_code"));
	}

	/**
	 * 病人属于编码
	 * 
	 * @param Eu_brsy_code
	 */
	public void setEu_brsy_code(String Eu_brsy_code) {
		setAttrVal("Eu_brsy_code", Eu_brsy_code);
	}

	/**
	 * 病人属于名称
	 * 
	 * @return String
	 */
	public String getEu_brsy_name() {
		return ((String) getAttrVal("Eu_brsy_name"));
	}

	/**
	 * 病人属于名称
	 * 
	 * @param Eu_brsy_name
	 */
	public void setEu_brsy_name(String Eu_brsy_name) {
		setAttrVal("Eu_brsy_name", Eu_brsy_name);
	}

	/**
	 * 人群分类
	 * 
	 * @return String
	 */
	public String getEu_rqfl() {
		return ((String) getAttrVal("Eu_rqfl"));
	}

	/**
	 * 人群分类
	 * 
	 * @param Eu_rqfl
	 */
	public void setEu_rqfl(String Eu_rqfl) {
		setAttrVal("Eu_rqfl", Eu_rqfl);
	}

	/**
	 * 人群分类编码
	 * 
	 * @return String
	 */
	public String getEu_rqfl_code() {
		return ((String) getAttrVal("Eu_rqfl_code"));
	}

	/**
	 * 人群分类编码
	 * 
	 * @param Eu_rqfl_code
	 */
	public void setEu_rqfl_code(String Eu_rqfl_code) {
		setAttrVal("Eu_rqfl_code", Eu_rqfl_code);
	}

	/**
	 * 人群分类名称
	 * 
	 * @return String
	 */
	public String getEu_rqfl_name() {
		return ((String) getAttrVal("Eu_rqfl_name"));
	}

	/**
	 * 人群分类名称
	 * 
	 * @param Eu_rqfl_name
	 */
	public void setEu_rqfl_name(String Eu_rqfl_name) {
		setAttrVal("Eu_rqfl_name", Eu_rqfl_name);
	}

	/**
	 * 患者家长姓名
	 * 
	 * @return String
	 */
	public String getHzjzxm() {
		return ((String) getAttrVal("Hzjzxm"));
	}

	/**
	 * 患者家长姓名
	 * 
	 * @param Hzjzxm
	 */
	public void setHzjzxm(String Hzjzxm) {
		setAttrVal("Hzjzxm", Hzjzxm);
	}

	/**
	 * 发病日期
	 * 
	 * @return FDate
	 */
	public FDate getFbrq() {
		return ((FDate) getAttrVal("Fbrq"));
	}

	/**
	 * 发病日期
	 * 
	 * @param Fbrq
	 */
	public void setFbrq(FDate Fbrq) {
		setAttrVal("Fbrq", Fbrq);
	}

	/**
	 * 诊断日期
	 * 
	 * @return FDate
	 */
	public FDate getZdrq() {
		return ((FDate) getAttrVal("Zdrq"));
	}

	/**
	 * 诊断日期
	 * 
	 * @param Zdrq
	 */
	public void setZdrq(FDate Zdrq) {
		setAttrVal("Zdrq", Zdrq);
	}

	/**
	 * 死亡日期
	 * 
	 * @return FDate
	 */
	public FDate getSwrq() {
		return ((FDate) getAttrVal("Swrq"));
	}

	/**
	 * 死亡日期
	 * 
	 * @param Swrq
	 */
	public void setSwrq(FDate Swrq) {
		setAttrVal("Swrq", Swrq);
	}

	/**
	 * 年龄单位
	 * 
	 * @return String
	 */
	public String getEu_nldw() {
		return ((String) getAttrVal("Eu_nldw"));
	}

	/**
	 * 年龄单位
	 * 
	 * @param Eu_nldw
	 */
	public void setEu_nldw(String Eu_nldw) {
		setAttrVal("Eu_nldw", Eu_nldw);
	}

	/**
	 * 年龄单位编码
	 * 
	 * @return String
	 */
	public String getEu_nldw_code() {
		return ((String) getAttrVal("Eu_nldw_code"));
	}

	/**
	 * 年龄单位编码
	 * 
	 * @param Eu_nldw_code
	 */
	public void setEu_nldw_code(String Eu_nldw_code) {
		setAttrVal("Eu_nldw_code", Eu_nldw_code);
	}

	/**
	 * 年龄单位名称
	 * 
	 * @return String
	 */
	public String getEu_nldw_name() {
		return ((String) getAttrVal("Eu_nldw_name"));
	}

	/**
	 * 年龄单位名称
	 * 
	 * @param Eu_nldw_name
	 */
	public void setEu_nldw_name(String Eu_nldw_name) {
		setAttrVal("Eu_nldw_name", Eu_nldw_name);
	}

	/**
	 * 报卡医生
	 * 
	 * @return String
	 */
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}

	/**
	 * 报卡医生
	 * 
	 * @param Id_emp_entry
	 */
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}

	/**
	 * 报卡医生编码
	 * 
	 * @return String
	 */
	public String getSd_emp_entry() {
		return ((String) getAttrVal("Sd_emp_entry"));
	}

	/**
	 * 报卡医生编码
	 * 
	 * @param Sd_emp_entry
	 */
	public void setSd_emp_entry(String Sd_emp_entry) {
		setAttrVal("Sd_emp_entry", Sd_emp_entry);
	}

	/**
	 * 报卡医生名称
	 * 
	 * @return String
	 */
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}

	/**
	 * 报卡医生名称
	 * 
	 * @param Name_emp_entry
	 */
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
	}

	/**
	 * 实足年龄
	 * 
	 * @return Integer
	 */
	public Integer getExact_age() {
		return ((Integer) getAttrVal("Exact_age"));
	}

	/**
	 * 实足年龄
	 * 
	 * @param Exact_age
	 */
	public void setExact_age(Integer Exact_age) {
		setAttrVal("Exact_age", Exact_age);
	}

	/**
	 * 工作单位(学校)
	 * 
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}

	/**
	 * 工作单位(学校)
	 * 
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}

	/**
	 * 联系电话
	 * 
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}

	/**
	 * 联系电话
	 * 
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}

	/**
	 * 现住址（详填）
	 * 
	 * @return String
	 */
	public String getAddr_now() {
		return ((String) getAttrVal("Addr_now"));
	}

	/**
	 * 现住址（详填）
	 * 
	 * @param Addr_now
	 */
	public void setAddr_now(String Addr_now) {
		setAttrVal("Addr_now", Addr_now);
	}

	/**
	 * 现住址
	 * 
	 * @return String
	 */
	public String getId_province() {
		return ((String) getAttrVal("Id_province"));
	}

	/**
	 * 现住址
	 * 
	 * @param Id_province
	 */
	public void setId_province(String Id_province) {
		setAttrVal("Id_province", Id_province);
	}

	/**
	 * 现住址编码
	 * 
	 * @return String
	 */
	public String getSd_province() {
		return ((String) getAttrVal("Sd_province"));
	}

	/**
	 * 现住址编码
	 * 
	 * @param Sd_province
	 */
	public void setSd_province(String Sd_province) {
		setAttrVal("Sd_province", Sd_province);
	}

	/**
	 * 现住址名称
	 * 
	 * @return String
	 */
	public String getName_province() {
		return ((String) getAttrVal("Name_province"));
	}

	/**
	 * 现住址名称
	 * 
	 * @param Name_province
	 */
	public void setName_province(String Name_province) {
		setAttrVal("Name_province", Name_province);
	}

	/**
	 * 乡（镇、街道）
	 * 
	 * @return String
	 */
	public String getStreet() {
		return ((String) getAttrVal("Street"));
	}

	/**
	 * 乡（镇、街道）
	 * 
	 * @param Street
	 */
	public void setStreet(String Street) {
		setAttrVal("Street", Street);
	}

	/**
	 * 村
	 * 
	 * @return String
	 */
	public String getVillage() {
		return ((String) getAttrVal("Village"));
	}

	/**
	 * 村
	 * 
	 * @param Village
	 */
	public void setVillage(String Village) {
		setAttrVal("Village", Village);
	}

	/**
	 * （门牌号）
	 * 
	 * @return String
	 */
	public String getHousenum() {
		return ((String) getAttrVal("Housenum"));
	}

	/**
	 * （门牌号）
	 * 
	 * @param Housenum
	 */
	public void setHousenum(String Housenum) {
		setAttrVal("Housenum", Housenum);
	}

	/**
	 * 性别
	 * 
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}

	/**
	 * 性别
	 * 
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}

	/**
	 * 性别编码
	 * 
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}

	/**
	 * 性别编码
	 * 
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}

	/**
	 * 性别名称
	 * 
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}

	/**
	 * 性别名称
	 * 
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}

	/**
	 * 出生日期
	 * 
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}

	/**
	 * 出生日期
	 * 
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}

	/**
	 * 填卡日期
	 * 
	 * @return FDate
	 */
	public FDate getDt_contagion() {
		return ((FDate) getAttrVal("Dt_contagion"));
	}

	/**
	 * 填卡日期
	 * 
	 * @param Dt_contagion
	 */
	public void setDt_contagion(FDate Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}

	/**
	 * 联系电话1
	 * 
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}

	/**
	 * 联系电话1
	 * 
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}

	/**
	 * 集团
	 * 
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}

	/**
	 * 集团
	 * 
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}

	/**
	 * 集团编码
	 * 
	 * @return String
	 */
	public String getSd_grp() {
		return ((String) getAttrVal("Sd_grp"));
	}

	/**
	 * 集团编码
	 * 
	 * @param Sd_grp
	 */
	public void setSd_grp(String Sd_grp) {
		setAttrVal("Sd_grp", Sd_grp);
	}

	/**
	 * 集团名称
	 * 
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}

	/**
	 * 集团名称
	 * 
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}

	/**
	 * 组织
	 * 
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}

	/**
	 * 组织
	 * 
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}

	/**
	 * 组织编码
	 * 
	 * @return String
	 */
	public String getSd_org() {
		return ((String) getAttrVal("Sd_org"));
	}

	/**
	 * 组织编码
	 * 
	 * @param Sd_org
	 */
	public void setSd_org(String Sd_org) {
		setAttrVal("Sd_org", Sd_org);
	}

	/**
	 * 组织名称
	 * 
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}

	/**
	 * 组织名称
	 * 
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}

	/**
	 * 备注
	 * 
	 * @return String
	 */
	public String getRemarks() {
		return ((String) getAttrVal("Remarks"));
	}

	/**
	 * 备注
	 * 
	 * @param Remarks
	 */
	public void setRemarks(String Remarks) {
		setAttrVal("Remarks", Remarks);
	}

	/**
	 * 报卡类别4打印
	 * 
	 * @return String
	 */
	public String getCardtype() {
		return ((String) getAttrVal("Cardtype"));
	}

	/**
	 * 报卡类别4打印
	 * 
	 * @param Cardtype
	 */
	public void setCardtype(String Cardtype) {
		setAttrVal("Cardtype", Cardtype);
	}

	/**
	 * 年龄单位4打印
	 * 
	 * @return String
	 */
	public String getAgetype() {
		return ((String) getAttrVal("Agetype"));
	}

	/**
	 * 年龄单位4打印
	 * 
	 * @param Agetype
	 */
	public void setAgetype(String Agetype) {
		setAttrVal("Agetype", Agetype);
	}

	/**
	 * 病人属于4打印
	 * 
	 * @return String
	 */
	public String getPatrelation() {
		return ((String) getAttrVal("Patrelation"));
	}

	/**
	 * 病人属于4打印
	 * 
	 * @param Patrelation
	 */
	public void setPatrelation(String Patrelation) {
		setAttrVal("Patrelation", Patrelation);
	}

	/**
	 * 人群分类4打印
	 * 
	 * @return String
	 */
	public String getPattype() {
		return ((String) getAttrVal("Pattype"));
	}

	/**
	 * 人群分类4打印
	 * 
	 * @param Pattype
	 */
	public void setPattype(String Pattype) {
		setAttrVal("Pattype", Pattype);
	}

	/**
	 * 病例分类1
	 * 
	 * @return String
	 */
	public String getDiscaseone() {
		return ((String) getAttrVal("Discaseone"));
	}

	/**
	 * 病例分类1
	 * 
	 * @param Discaseone
	 */
	public void setDiscaseone(String Discaseone) {
		setAttrVal("Discaseone", Discaseone);
	}

	/**
	 * 病例分类2
	 * 
	 * @return String
	 */
	public String getDiscasetwo() {
		return ((String) getAttrVal("Discasetwo"));
	}

	/**
	 * 病例分类2
	 * 
	 * @param Discasetwo
	 */
	public void setDiscasetwo(String Discasetwo) {
		setAttrVal("Discasetwo", Discasetwo);
	}

	/**
	 * 甲类传染病4打印
	 * 
	 * @return String
	 */
	public String getJlcrb() {
		return ((String) getAttrVal("Jlcrb"));
	}

	/**
	 * 甲类传染病4打印
	 * 
	 * @param Jlcrb
	 */
	public void setJlcrb(String Jlcrb) {
		setAttrVal("Jlcrb", Jlcrb);
	}

	/**
	 * 乙类传染病4打印
	 * 
	 * @return String
	 */
	public String getYlcrb() {
		return ((String) getAttrVal("Ylcrb"));
	}

	/**
	 * 乙类传染病4打印
	 * 
	 * @param Ylcrb
	 */
	public void setYlcrb(String Ylcrb) {
		setAttrVal("Ylcrb", Ylcrb);
	}

	/**
	 * 丙类传染病4打印
	 * 
	 * @return String
	 */
	public String getBlcrb() {
		return ((String) getAttrVal("Blcrb"));
	}

	/**
	 * 丙类传染病4打印
	 * 
	 * @param Blcrb
	 */
	public void setBlcrb(String Blcrb) {
		setAttrVal("Blcrb", Blcrb);
	}

	/**
	 * 其它传染病4打印
	 * 
	 * @return String
	 */
	public String getQtcrb() {
		return ((String) getAttrVal("Qtcrb"));
	}

	/**
	 * 其它传染病4打印
	 * 
	 * @param Qtcrb
	 */
	public void setQtcrb(String Qtcrb) {
		setAttrVal("Qtcrb", Qtcrb);
	}

	/**
	 * 相同症状
	 * 
	 * @return String
	 */
	public String getIshassame() {
		return ((String) getAttrVal("Ishassame"));
	}

	/**
	 * 相同症状
	 * 
	 * @param Ishassame
	 */
	public void setIshassame(String Ishassame) {
		setAttrVal("Ishassame", Ishassame);
	}
}
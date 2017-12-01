package iih.ci.ord.dto.ordpres.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱处方 DTO数据 
 * 
 */
public class OrdPresDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	/**
	 * 处方
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
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
	public String getId_pati() {
		return ((String) getAttrVal("Id_pati"));
	}	
	/**
	 * 患者
	 * @param Id_pati
	 */
	public void setId_pati(String Id_pati) {
		setAttrVal("Id_pati", Id_pati);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pati() {
		return ((String) getAttrVal("Name_pati"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pati
	 */
	public void setName_pati(String Name_pati) {
		setAttrVal("Name_pati", Name_pati);
	}
	/**
	 * 费别
	 * @return String
	 */
	public String getName_patica() {
		return ((String) getAttrVal("Name_patica"));
	}	
	/**
	 * 费别
	 * @param Name_patica
	 */
	public void setName_patica(String Name_patica) {
		setAttrVal("Name_patica", Name_patica);
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
	 * 临床诊断
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 临床诊断
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 临床诊断明细
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	/**
	 * 临床诊断明细
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 诊断编码拼接
	 * @return String
	 */
	public String getStr_id_di() {
		return ((String) getAttrVal("Str_id_di"));
	}	
	/**
	 * 诊断编码拼接
	 * @param Str_id_di
	 */
	public void setStr_id_di(String Str_id_di) {
		setAttrVal("Str_id_di", Str_id_di);
	}
	/**
	 * 诊断名称拼接
	 * @return String
	 */
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	/**
	 * 诊断名称拼接
	 * @param Str_name_di
	 */
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
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
	 * 处方类型
	 * @return String
	 */
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}	
	/**
	 * 处方类型
	 * @param Id_prestp
	 */
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}	
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getId_prestpWord() {
		return ((String) getAttrVal("Id_prestpWord"));
	}	
	/**
	 * 处方类型
	 * @param Id_prestp
	 */
	public void setId_prestpWord(String Id_prestpWord) {
		setAttrVal("Id_prestpWord", Id_prestpWord);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestpWord() {
		return ((String) getAttrVal("Sd_prestpWord"));
	}	
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestpWord(String Sd_prestpWord) {
		setAttrVal("Sd_prestpWord", Sd_prestpWord);
	}
	/**
	 * 处方类型名称
	 * @return String
	 */
	public String getName_prestp() {
		return ((String) getAttrVal("Name_prestp"));
	}	
	/**
	 * 处方类型名称
	 * @param Name_prestp
	 */
	public void setName_prestp(String Name_prestp) {
		setAttrVal("Name_prestp", Name_prestp);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 处方编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 处方名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}	
	/**
	 * 开立科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}	
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}	
	/**
	 * 开立医生名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 开立日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
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
	 * 婴儿
	 * @return String
	 */
	public String getId_bb() {
		return ((String) getAttrVal("Id_bb"));
	}	
	/**
	 * 婴儿
	 * @param Id_bb
	 */
	public void setId_bb(String Id_bb) {
		setAttrVal("Id_bb", Id_bb);
	}
	/**
	 * 医疗用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 医疗用法
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
	 * 中药煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 中药煎法
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
	 * 收费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}	
	/**
	 * 收费标识
	 * @param Fg_charge
	 */
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	/**
	 * 发药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dispense() {
		return ((FBoolean) getAttrVal("Fg_dispense"));
	}	
	/**
	 * 发药标识
	 * @param Fg_dispense
	 */
	public void setFg_dispense(FBoolean Fg_dispense) {
		setAttrVal("Fg_dispense", Fg_dispense);
	}
	/**
	 * 退药类型
	 * @return String
	 */
	public String getId_backtp() {
		return ((String) getAttrVal("Id_backtp"));
	}	
	/**
	 * 退药类型
	 * @param Id_backtp
	 */
	public void setId_backtp(String Id_backtp) {
		setAttrVal("Id_backtp", Id_backtp);
	}
	/**
	 * 退药类型编码
	 * @return String
	 */
	public String getSd_backtp() {
		return ((String) getAttrVal("Sd_backtp"));
	}	
	/**
	 * 退药类型编码
	 * @param Sd_backtp
	 */
	public void setSd_backtp(String Sd_backtp) {
		setAttrVal("Sd_backtp", Sd_backtp);
	}
	/**
	 * 处方退药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_back() {
		return ((FBoolean) getAttrVal("Fg_back"));
	}	
	/**
	 * 处方退药标识
	 * @param Fg_back
	 */
	public void setFg_back(FBoolean Fg_back) {
		setAttrVal("Fg_back", Fg_back);
	}
	/**
	 * 关联原处方
	 * @return String
	 */
	public String getId_pres_rel() {
		return ((String) getAttrVal("Id_pres_rel"));
	}	
	/**
	 * 关联原处方
	 * @param Id_pres_rel
	 */
	public void setId_pres_rel(String Id_pres_rel) {
		setAttrVal("Id_pres_rel", Id_pres_rel);
	}
	/**
	 * 医生签名
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 医生签名
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 处方药品
	 * @return String
	 */
	public FArrayList getPresdrugs() {
		return ((FArrayList) getAttrVal("Presdrugs"));
	}	
	/**
	 * 处方药品
	 * @param Presdrugs
	 */
	public void setPresdrugs(FArrayList Presdrugs) {
		setAttrVal("Presdrugs", Presdrugs);
	}
	/**
	 * 发药人
	 * @return String
	 */
	public String getId_emp_disp() {
		return ((String) getAttrVal("Id_emp_disp"));
	}	
	/**
	 * 发药人
	 * @param Id_emp_disp
	 */
	public void setId_emp_disp(String Id_emp_disp) {
		setAttrVal("Id_emp_disp", Id_emp_disp);
	}
	/**
	 * 发药人名称
	 * @return String
	 */
	public String getName_emp_disp() {
		return ((String) getAttrVal("Name_emp_disp"));
	}	
	/**
	 * 发药人名称
	 * @param Name_emp_disp
	 */
	public void setName_emp_disp(String Name_emp_disp) {
		setAttrVal("Name_emp_disp", Name_emp_disp);
	}
	/**
	 * 发药时间
	 * @return FDateTime
	 */
	public FDateTime getDt_disp() {
		return ((FDateTime) getAttrVal("Dt_disp"));
	}	
	/**
	 * 发药时间
	 * @param Dt_disp
	 */
	public void setDt_disp(FDateTime Dt_disp) {
		setAttrVal("Dt_disp", Dt_disp);
	}
	/**
	 * 收费日期
	 * @return String
	 */
	public String getDt_charge() {
		return ((String) getAttrVal("Dt_charge"));
	}	
	/**
	 * 收费日期
	 * @param Dt_charge
	 */
	public void setDt_charge(String Dt_charge) {
		setAttrVal("Dt_charge", Dt_charge);
	}
	/**
	 * 退药原因
	 * @return String
	 */
	public String getReason_rtn() {
		return ((String) getAttrVal("Reason_rtn"));
	}	
	/**
	 * 退药原因
	 * @param Reason_rtn
	 */
	public void setReason_rtn(String Reason_rtn) {
		setAttrVal("Reason_rtn", Reason_rtn);
	}
	/**
	 * 批次号
	 * @return String
	 */
	public String getBatchno() {
		return ((String) getAttrVal("Batchno"));
	}	
	/**
	 * 批次号
	 * @param Batchno
	 */
	public void setBatchno(String Batchno) {
		setAttrVal("Batchno", Batchno);
	}
	/**
	 * 条形码（就诊号）
	 * @return String
	 */
	public String getBarcode() {
		return ((String) getAttrVal("Barcode"));
	}	
	/**
	 * 条形码（就诊号）
	 * @param Barcode
	 */
	public void setBarcode(String Barcode) {
		setAttrVal("Barcode", Barcode);
	}
	/**
	 * 医疗机构登记号
	 * @return String
	 */
	public String getRegnum_org() {
		return ((String) getAttrVal("Regnum_org"));
	}	
	/**
	 * 医疗机构登记号
	 * @param Regnum_org
	 */
	public void setRegnum_org(String Regnum_org) {
		setAttrVal("Regnum_org", Regnum_org);
	}
	/**
	 * 毒麻处方号
	 * @return String
	 */
	public String getCode_poishempres() {
		return ((String) getAttrVal("Code_poishempres"));
	}	
	/**
	 * 毒麻处方号
	 * @param Code_poishempres
	 */
	public void setCode_poishempres(String Code_poishempres) {
		setAttrVal("Code_poishempres", Code_poishempres);
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
	 * @return String
	 */
	public String getBirth() {
		return ((String) getAttrVal("Birth"));
	}	
	/**
	 * 出生日期
	 * @param Birth
	 */
	public void setBirth(String Birth) {
		setAttrVal("Birth", Birth);
	}
	/**
	 * 年龄
	 * @return FDouble
	 */
	public FDouble getAge() {
		return ((FDouble) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(FDouble Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdno() {
		return ((String) getAttrVal("Idno"));
	}	
	/**
	 * 身份证号
	 * @param Idno
	 */
	public void setIdno(String Idno) {
		setAttrVal("Idno", Idno);
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
	 * 代办人
	 * @return String
	 */
	public String getPsn_agent() {
		return ((String) getAttrVal("Psn_agent"));
	}	
	/**
	 * 代办人
	 * @param Psn_agent
	 */
	public void setPsn_agent(String Psn_agent) {
		setAttrVal("Psn_agent", Psn_agent);
	}
	/**
	 * 代办人身份证号
	 * @return String
	 */
	public String getIdno_agent() {
		return ((String) getAttrVal("Idno_agent"));
	}	
	/**
	 * 代办人身份证号
	 * @param Idno_agent
	 */
	public void setIdno_agent(String Idno_agent) {
		setAttrVal("Idno_agent", Idno_agent);
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
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getNum_pv() {
		return ((Integer) getAttrVal("Num_pv"));
	}	
	/**
	 * 就诊次数
	 * @param Num_pv
	 */
	public void setNum_pv(Integer Num_pv) {
		setAttrVal("Num_pv", Num_pv);
	}
	/**
	 * 过敏史
	 * @return String
	 */
	public String getDes_alcla() {
		return ((String) getAttrVal("Des_alcla"));
	}	
	/**
	 * 过敏史
	 * @param Des_alcla
	 */
	public void setDes_alcla(String Des_alcla) {
		setAttrVal("Des_alcla", Des_alcla);
	}
	/**
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getAmt_total() {
		return ((FDouble) getAttrVal("Amt_total"));
	}	
	/**
	 * 总金额
	 * @param Amt_total
	 */
	public void setAmt_total(FDouble Amt_total) {
		setAttrVal("Amt_total", Amt_total);
	}
	/**
	 * 打印单据类型id
	 * @return String
	 */
	public String getId_ciprnsheettp() {
		return ((String) getAttrVal("Id_ciprnsheettp"));
	}	
	/**
	 * 打印单据类型id
	 * @param Id_ciprnsheettp
	 */
	public void setId_ciprnsheettp(String Id_ciprnsheettp) {
		setAttrVal("Id_ciprnsheettp", Id_ciprnsheettp);
	}
	/**
	 * 打印单据类型编码
	 * @return String
	 */
	public String getSd_ciprnsheettp() {
		return ((String) getAttrVal("Sd_ciprnsheettp"));
	}	
	/**
	 * 打印单据类型编码
	 * @param Sd_ciprnsheettp
	 */
	public void setSd_ciprnsheettp(String Sd_ciprnsheettp) {
		setAttrVal("Sd_ciprnsheettp", Sd_ciprnsheettp);
	}
	/**
	 * 打印单据类型名称
	 * @return String
	 */
	public String getName_ciprnsheettp() {
		return ((String) getAttrVal("Name_ciprnsheettp"));
	}	
	/**
	 * 打印单据类型名称
	 * @param Name_ciprnsheettp
	 */
	public void setName_ciprnsheettp(String Name_ciprnsheettp) {
		setAttrVal("Name_ciprnsheettp", Name_ciprnsheettp);
	}
}
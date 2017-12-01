package iih.ci.rcm.contagionrecordop.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 门诊传染病记录 DTO数据
 * 
 */
public class ContagionRecordOpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 * 
	 * @return String
	 */
	public String getId_contagiondto() {
		return ((String) getAttrVal("Id_contagiondto"));
	}

	/**
	 * 主键
	 * 
	 * @param Id_contagiondto
	 */
	public void setId_contagiondto(String Id_contagiondto) {
		setAttrVal("Id_contagiondto", Id_contagiondto);
	}

	/**
	 * 门诊号
	 * 
	 * @return String
	 */
	public String getOp_code() {
		return ((String) getAttrVal("Op_code"));
	}

	/**
	 * 门诊号
	 * 
	 * @param Op_code
	 */
	public void setOp_code(String Op_code) {
		setAttrVal("Op_code", Op_code);
	}

	/**
	 * 患者姓名
	 * 
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}

	/**
	 * 患者姓名
	 * 
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}

	/**
	 * 性别
	 * 
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}

	/**
	 * 性别
	 * 
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}

	/**
	 * 年龄
	 * 
	 * @return String
	 */
	public String getExact_age() {
		return ((String) getAttrVal("Exact_age"));
	}

	/**
	 * 年龄
	 * 
	 * @param Exact_age
	 */
	public void setExact_age(String Exact_age) {
		setAttrVal("Exact_age", Exact_age);
	}

	/**
	 * 诊断
	 * 
	 * @return String
	 */
	public String getDiagnose() {
		return ((String) getAttrVal("Diagnose"));
	}

	/**
	 * 诊断
	 * 
	 * @param Diagnose
	 */
	public void setDiagnose(String Diagnose) {
		setAttrVal("Diagnose", Diagnose);
	}

	/**
	 * 就诊时间
	 * 
	 * @return FDate
	 */
	public FDate getClinic_time() {
		return ((FDate) getAttrVal("Clinic_time"));
	}

	/**
	 * 就诊时间
	 * 
	 * @param Clinic_time
	 */
	public void setClinic_time(FDate Clinic_time) {
		setAttrVal("Clinic_time", Clinic_time);
	}

	/**
	 * 初诊或复诊
	 * 
	 * @return FBoolean
	 */
	public FBoolean getIs_first_en() {
		return ((FBoolean) getAttrVal("Is_first_en"));
	}

	/**
	 * 初诊或复诊
	 * 
	 * @param Is_first_en
	 */
	public void setIs_first_en(FBoolean Is_first_en) {
		setAttrVal("Is_first_en", Is_first_en);
	}

	/**
	 * 就诊科室
	 * 
	 * @return String
	 */
	public String getClinic_unit() {
		return ((String) getAttrVal("Clinic_unit"));
	}

	/**
	 * 就诊科室
	 * 
	 * @param Clinic_unit
	 */
	public void setClinic_unit(String Clinic_unit) {
		setAttrVal("Clinic_unit", Clinic_unit);
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
	 * 职业
	 * 
	 * @return String
	 */
	public String getProfession() {
		return ((String) getAttrVal("Profession"));
	}

	/**
	 * 职业
	 * 
	 * @param Profession
	 */
	public void setProfession(String Profession) {
		setAttrVal("Profession", Profession);
	}

	/**
	 * 现住址
	 * 
	 * @return String
	 */
	public String getAddr_now() {
		return ((String) getAttrVal("Addr_now"));
	}

	/**
	 * 现住址
	 * 
	 * @param Addr_now
	 */
	public void setAddr_now(String Addr_now) {
		setAttrVal("Addr_now", Addr_now);
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
	 * 自定义（备用）属性1
	 * 
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}

	/**
	 * 自定义（备用）属性1
	 * 
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}

	/**
	 * 自定义（备用）属性2
	 * 
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}

	/**
	 * 自定义（备用）属性2
	 * 
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}

	/**
	 * 自定义（备用）属性3
	 * 
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}

	/**
	 * 自定义（备用）属性3
	 * 
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}

	/**
	 * 自定义（备用）属性4
	 * 
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}

	/**
	 * 自定义（备用）属性4
	 * 
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
}
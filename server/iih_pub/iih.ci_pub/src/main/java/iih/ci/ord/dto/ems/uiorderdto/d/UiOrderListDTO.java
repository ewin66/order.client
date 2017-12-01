package iih.ci.ord.dto.ems.uiorderdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱列表 DTO数据 
 * 
 */
public class UiOrderListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱综合状态
	 * @return String
	 */
	public String getOrd_colligate() {
		return ((String) getAttrVal("Ord_colligate"));
	}
	/**
	 * 医嘱综合状态
	 * @param Ord_colligate
	 */
	public void setOrd_colligate(String Ord_colligate) {
		setAttrVal("Ord_colligate", Ord_colligate);
	}
	/**
	 * 医嘱状态ID
	 * @return String
	 */
	public String getId_su_or() {
		return ((String) getAttrVal("Id_su_or"));
	}
	/**
	 * 医嘱状态ID
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
	 * 医嘱状态
	 * @return String
	 */
	public String getName_su_or() {
		return ((String) getAttrVal("Name_su_or"));
	}
	/**
	 * 医嘱状态
	 * @param Name_su_or
	 */
	public void setName_su_or(String Name_su_or) {
		setAttrVal("Name_su_or", Name_su_or);
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
	 * 医嘱类型
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}
	/**
	 * 医嘱类型
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
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
	 * 医生
	 * @return String
	 */
	public String getDoctor() {
		return ((String) getAttrVal("Doctor"));
	}
	/**
	 * 医生
	 * @param Doctor
	 */
	public void setDoctor(String Doctor) {
		setAttrVal("Doctor", Doctor);
	}
	/**
	 * 开立医生ID
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生ID
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 执行状态ID
	 * @return String
	 */
	public String getId_su_mp() {
		return ((String) getAttrVal("Id_su_mp"));
	}
	/**
	 * 执行状态ID
	 * @param Id_su_mp
	 */
	public void setId_su_mp(String Id_su_mp) {
		setAttrVal("Id_su_mp", Id_su_mp);
	}
	/**
	 * 执行状态编码
	 * @return String
	 */
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}
	/**
	 * 执行状态编码
	 * @param Sd_su_mp
	 */
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}
	/**
	 * 记账状态ID
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}
	/**
	 * 记账状态ID
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
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
	 * 皮试结果
	 * @return String
	 */
	public String getSkintest_result() {
		return ((String) getAttrVal("Skintest_result"));
	}
	/**
	 * 皮试结果
	 * @param Skintest_result
	 */
	public void setSkintest_result(String Skintest_result) {
		setAttrVal("Skintest_result", Skintest_result);
	}
	/**
	 * 签署标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}
	/**
	 * 签署标识
	 * @param Fg_sign
	 */
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 签署医生ID
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}
	/**
	 * 签署医生ID
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署医生
	 * @return String
	 */
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}
	/**
	 * 签署医生
	 * @param Name_emp_sign
	 */
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	/**
	 * 审核/结果
	 * @return String
	 */
	public String getCheck_result() {
		return ((String) getAttrVal("Check_result"));
	}
	/**
	 * 审核/结果
	 * @param Check_result
	 */
	public void setCheck_result(String Check_result) {
		setAttrVal("Check_result", Check_result);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
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
	 * 非径内医嘱判断标识枚举
	 * @return Integer
	 */
	public Integer getEu_uncporjudge() {
		return ((Integer) getAttrVal("Eu_uncporjudge"));
	}
	/**
	 * 非径内医嘱判断标识枚举
	 * @param Eu_uncporjudge
	 */
	public void setEu_uncporjudge(Integer Eu_uncporjudge) {
		setAttrVal("Eu_uncporjudge", Eu_uncporjudge);
	}
	/**
	 * 医嘱结果ID
	 * @return String
	 */
	public String getId_orrsttp() {
		return ((String) getAttrVal("Id_orrsttp"));
	}
	/**
	 * 医嘱结果ID
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
	 * sv
	 * @return String
	 */
	public String getSv() {
		return ((String) getAttrVal("Sv"));
	}
	/**
	 * sv
	 * @param Sv
	 */
	public void setSv(String Sv) {
		setAttrVal("Sv", Sv);
	}
}
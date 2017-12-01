package iih.ci.ord.dto.enappointmentdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊预约接口 DTO数据 
 * 
 */
public class EnappointmentDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 患者id
	 * @return FMap2
	 */
	public FMap2 getId_pat() {
		return ((FMap2) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(FMap2 Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 医嘱开始时间
	 * @return FDateTime
	 */
	public FDateTime getDtsignb() {
		return ((FDateTime) getAttrVal("Dtsignb"));
	}
	/**
	 * 医嘱开始时间
	 * @param Dtsignb
	 */
	public void setDtsignb(FDateTime Dtsignb) {
		setAttrVal("Dtsignb", Dtsignb);
	}
	/**
	 * 医嘱结束时间
	 * @return FDateTime
	 */
	public FDateTime getDtsigne() {
		return ((FDateTime) getAttrVal("Dtsigne"));
	}
	/**
	 * 医嘱结束时间
	 * @param Dtsigne
	 */
	public void setDtsigne(FDateTime Dtsigne) {
		setAttrVal("Dtsigne", Dtsigne);
	}
	/**
	 * 就诊类型
	 * @return FMap2
	 */
	public FMap2 getEn_entp() {
		return ((FMap2) getAttrVal("En_entp"));
	}
	/**
	 * 就诊类型
	 * @param En_entp
	 */
	public void setEn_entp(FMap2 En_entp) {
		setAttrVal("En_entp", En_entp);
	}
	/**
	 * 待预约医嘱类型 02检查，03检验，04手术，05治疗
	 * @return FMap2
	 */
	public FMap2 getSd_srvtp() {
		return ((FMap2) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 待预约医嘱类型 02检查，03检验，04手术，05治疗
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(FMap2 Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 是否需要已缴费
	 * @return FMap2
	 */
	public FMap2 getPayment() {
		return ((FMap2) getAttrVal("Payment"));
	}
	/**
	 * 是否需要已缴费
	 * @param Payment
	 */
	public void setPayment(FMap2 Payment) {
		setAttrVal("Payment", Payment);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 执行科室id
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 签署医生id
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}
	/**
	 * 签署医生id
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 申请单号（不支持）
	 * @return String
	 */
	public String getAppno() {
		return ((String) getAttrVal("Appno"));
	}
	/**
	 * 申请单号（不支持）
	 * @param Appno
	 */
	public void setAppno(String Appno) {
		setAttrVal("Appno", Appno);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName12() {
		return ((String) getAttrVal("Name12"));
	}
	/**
	 * 扩展字段1
	 * @param Name12
	 */
	public void setName12(String Name12) {
		setAttrVal("Name12", Name12);
	}
	/**
	 * 扩展字段13
	 * @return String
	 */
	public String getName13() {
		return ((String) getAttrVal("Name13"));
	}
	/**
	 * 扩展字段13
	 * @param Name13
	 */
	public void setName13(String Name13) {
		setAttrVal("Name13", Name13);
	}
	/**
	 * 扩展字段14
	 * @return String
	 */
	public String getName14() {
		return ((String) getAttrVal("Name14"));
	}
	/**
	 * 扩展字段14
	 * @param Name14
	 */
	public void setName14(String Name14) {
		setAttrVal("Name14", Name14);
	}
	/**
	 * 扩展字段15
	 * @return String
	 */
	public String getName15() {
		return ((String) getAttrVal("Name15"));
	}
	/**
	 * 扩展字段15
	 * @param Name15
	 */
	public void setName15(String Name15) {
		setAttrVal("Name15", Name15);
	}
	/**
	 * 扩展字段16
	 * @return String
	 */
	public String getName16() {
		return ((String) getAttrVal("Name16"));
	}
	/**
	 * 扩展字段16
	 * @param Name16
	 */
	public void setName16(String Name16) {
		setAttrVal("Name16", Name16);
	}
	/**
	 * 扩展字段17
	 * @return String
	 */
	public String getName17() {
		return ((String) getAttrVal("Name17"));
	}
	/**
	 * 扩展字段17
	 * @param Name17
	 */
	public void setName17(String Name17) {
		setAttrVal("Name17", Name17);
	}
}
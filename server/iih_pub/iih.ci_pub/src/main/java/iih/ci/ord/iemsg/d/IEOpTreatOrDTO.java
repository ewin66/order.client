package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊治疗医嘱信息DTO DTO数据 
 * 
 */
public class IEOpTreatOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE治疗医嘱主键标识
	 * @return String
	 */
	public String getId_ietreator() {
		return ((String) getAttrVal("Id_ietreator"));
	}	
	/**
	 * IE治疗医嘱主键标识
	 * @param Id_ietreator
	 */
	public void setId_ietreator(String Id_ietreator) {
		setAttrVal("Id_ietreator", Id_ietreator);
	}
	/**
	 * IE治疗医嘱就诊
	 * @return String
	 */
	public String getId_ietreatoren() {
		return ((String) getAttrVal("Id_ietreatoren"));
	}	
	/**
	 * IE治疗医嘱就诊
	 * @param Id_ietreatoren
	 */
	public void setId_ietreatoren(String Id_ietreatoren) {
		setAttrVal("Id_ietreatoren", Id_ietreatoren);
	}
	/**
	 * 诊疗处方号
	 * @return String
	 */
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}	
	/**
	 * 诊疗处方号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getYz_no() {
		return ((String) getAttrVal("Yz_no"));
	}	
	/**
	 * 医嘱号
	 * @param Yz_no
	 */
	public void setYz_no(String Yz_no) {
		setAttrVal("Yz_no", Yz_no);
	}
	/**
	 * 医嘱类别编码
	 * @return String
	 */
	public String getOrder_type() {
		return ((String) getAttrVal("Order_type"));
	}	
	/**
	 * 医嘱类别编码
	 * @param Order_type
	 */
	public void setOrder_type(String Order_type) {
		setAttrVal("Order_type", Order_type);
	}
	/**
	 * 医嘱类别名称
	 * @return String
	 */
	public String getOrder_type_name() {
		return ((String) getAttrVal("Order_type_name"));
	}	
	/**
	 * 医嘱类别名称
	 * @param Order_type_name
	 */
	public void setOrder_type_name(String Order_type_name) {
		setAttrVal("Order_type_name", Order_type_name);
	}
	/**
	 * 医嘱备注
	 * @return String
	 */
	public String getYz_comment() {
		return ((String) getAttrVal("Yz_comment"));
	}	
	/**
	 * 医嘱备注
	 * @param Yz_comment
	 */
	public void setYz_comment(String Yz_comment) {
		setAttrVal("Yz_comment", Yz_comment);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getYz_code() {
		return ((String) getAttrVal("Yz_code"));
	}	
	/**
	 * 医嘱编码
	 * @param Yz_code
	 */
	public void setYz_code(String Yz_code) {
		setAttrVal("Yz_code", Yz_code);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getYz_name() {
		return ((String) getAttrVal("Yz_name"));
	}	
	/**
	 * 医嘱名称
	 * @param Yz_name
	 */
	public void setYz_name(String Yz_name) {
		setAttrVal("Yz_name", Yz_name);
	}
	/**
	 * 包装序号
	 * @return String
	 */
	public String getPack_serial() {
		return ((String) getAttrVal("Pack_serial"));
	}	
	/**
	 * 包装序号
	 * @param Pack_serial
	 */
	public void setPack_serial(String Pack_serial) {
		setAttrVal("Pack_serial", Pack_serial);
	}
	/**
	 * 数量
	 * @return String
	 */
	public String getCharge_amount() {
		return ((String) getAttrVal("Charge_amount"));
	}	
	/**
	 * 数量
	 * @param Charge_amount
	 */
	public void setCharge_amount(String Charge_amount) {
		setAttrVal("Charge_amount", Charge_amount);
	}
	/**
	 * 数量单位
	 * @return String
	 */
	public String getSpe_external() {
		return ((String) getAttrVal("Spe_external"));
	}	
	/**
	 * 数量单位
	 * @param Spe_external
	 */
	public void setSpe_external(String Spe_external) {
		setAttrVal("Spe_external", Spe_external);
	}
	/**
	 * 执行频率编码
	 * @return String
	 */
	public String getFreq_code() {
		return ((String) getAttrVal("Freq_code"));
	}	
	/**
	 * 执行频率编码
	 * @param Freq_code
	 */
	public void setFreq_code(String Freq_code) {
		setAttrVal("Freq_code", Freq_code);
	}
	/**
	 * 执行频率
	 * @return String
	 */
	public String getFreq_code_name() {
		return ((String) getAttrVal("Freq_code_name"));
	}	
	/**
	 * 执行频率
	 * @param Freq_code_name
	 */
	public void setFreq_code_name(String Freq_code_name) {
		setAttrVal("Freq_code_name", Freq_code_name);
	}
	/**
	 * 医嘱原科室编码
	 * @return String
	 */
	public String getYz_olddept_code() {
		return ((String) getAttrVal("Yz_olddept_code"));
	}	
	/**
	 * 医嘱原科室编码
	 * @param Yz_olddept_code
	 */
	public void setYz_olddept_code(String Yz_olddept_code) {
		setAttrVal("Yz_olddept_code", Yz_olddept_code);
	}
	/**
	 * 医嘱原科室名称
	 * @return String
	 */
	public String getYz_olddept_name() {
		return ((String) getAttrVal("Yz_olddept_name"));
	}	
	/**
	 * 医嘱原科室名称
	 * @param Yz_olddept_name
	 */
	public void setYz_olddept_name(String Yz_olddept_name) {
		setAttrVal("Yz_olddept_name", Yz_olddept_name);
	}
	/**
	 * 医嘱原病区编码
	 * @return String
	 */
	public String getYz_oldward_code() {
		return ((String) getAttrVal("Yz_oldward_code"));
	}	
	/**
	 * 医嘱原病区编码
	 * @param Yz_oldward_code
	 */
	public void setYz_oldward_code(String Yz_oldward_code) {
		setAttrVal("Yz_oldward_code", Yz_oldward_code);
	}
	/**
	 * 医嘱原病区名称
	 * @return String
	 */
	public String getYz_oldward_name() {
		return ((String) getAttrVal("Yz_oldward_name"));
	}	
	/**
	 * 医嘱原病区名称
	 * @param Yz_oldward_name
	 */
	public void setYz_oldward_name(String Yz_oldward_name) {
		setAttrVal("Yz_oldward_name", Yz_oldward_name);
	}
	/**
	 * 开嘱时间
	 * @return FDateTime
	 */
	public FDateTime getEnter_date() {
		return ((FDateTime) getAttrVal("Enter_date"));
	}	
	/**
	 * 开嘱时间
	 * @param Enter_date
	 */
	public void setEnter_date(FDateTime Enter_date) {
		setAttrVal("Enter_date", Enter_date);
	}
	/**
	 * 开嘱医生编码
	 * @return String
	 */
	public String getDoctor_code() {
		return ((String) getAttrVal("Doctor_code"));
	}	
	/**
	 * 开嘱医生编码
	 * @param Doctor_code
	 */
	public void setDoctor_code(String Doctor_code) {
		setAttrVal("Doctor_code", Doctor_code);
	}
	/**
	 * 开嘱医生名称
	 * @return String
	 */
	public String getDoctor_name() {
		return ((String) getAttrVal("Doctor_name"));
	}	
	/**
	 * 开嘱医生名称
	 * @param Doctor_name
	 */
	public void setDoctor_name(String Doctor_name) {
		setAttrVal("Doctor_name", Doctor_name);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getConfirm_date() {
		return ((FDateTime) getAttrVal("Confirm_date"));
	}	
	/**
	 * 确认时间
	 * @param Confirm_date
	 */
	public void setConfirm_date(FDateTime Confirm_date) {
		setAttrVal("Confirm_date", Confirm_date);
	}
	/**
	 * 确认医生编码
	 * @return String
	 */
	public String getConfirm_opera() {
		return ((String) getAttrVal("Confirm_opera"));
	}	
	/**
	 * 确认医生编码
	 * @param Confirm_opera
	 */
	public void setConfirm_opera(String Confirm_opera) {
		setAttrVal("Confirm_opera", Confirm_opera);
	}
	/**
	 * 确认医生名称
	 * @return String
	 */
	public String getConfirm_opera_name() {
		return ((String) getAttrVal("Confirm_opera_name"));
	}	
	/**
	 * 确认医生名称
	 * @param Confirm_opera_name
	 */
	public void setConfirm_opera_name(String Confirm_opera_name) {
		setAttrVal("Confirm_opera_name", Confirm_opera_name);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExec_sn() {
		return ((String) getAttrVal("Exec_sn"));
	}	
	/**
	 * 执行科室编码
	 * @param Exec_sn
	 */
	public void setExec_sn(String Exec_sn) {
		setAttrVal("Exec_sn", Exec_sn);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExec_name() {
		return ((String) getAttrVal("Exec_name"));
	}	
	/**
	 * 执行科室名称
	 * @param Exec_name
	 */
	public void setExec_name(String Exec_name) {
		setAttrVal("Exec_name", Exec_name);
	}
	/**
	 * 父医嘱号
	 * @return String
	 */
	public String getParent_no() {
		return ((String) getAttrVal("Parent_no"));
	}	
	/**
	 * 父医嘱号
	 * @param Parent_no
	 */
	public void setParent_no(String Parent_no) {
		setAttrVal("Parent_no", Parent_no);
	}
	/**
	 * 互斥类别编码
	 * @return String
	 */
	public String getIncompatibleyz_no() {
		return ((String) getAttrVal("Incompatibleyz_no"));
	}	
	/**
	 * 互斥类别编码
	 * @param Incompatibleyz_no
	 */
	public void setIncompatibleyz_no(String Incompatibleyz_no) {
		setAttrVal("Incompatibleyz_no", Incompatibleyz_no);
	}
	/**
	 * 互斥类别名称
	 * @return String
	 */
	public String getIncompatibleyz_type_code() {
		return ((String) getAttrVal("Incompatibleyz_type_code"));
	}	
	/**
	 * 互斥类别名称
	 * @param Incompatibleyz_type_code
	 */
	public void setIncompatibleyz_type_code(String Incompatibleyz_type_code) {
		setAttrVal("Incompatibleyz_type_code", Incompatibleyz_type_code);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getBegin_time() {
		return ((FDateTime) getAttrVal("Begin_time"));
	}	
	/**
	 * 开始时间
	 * @param Begin_time
	 */
	public void setBegin_time(FDateTime Begin_time) {
		setAttrVal("Begin_time", Begin_time);
	}
	/**
	 * 停止时间
	 * @return FDateTime
	 */
	public FDateTime getEnd_time() {
		return ((FDateTime) getAttrVal("End_time"));
	}	
	/**
	 * 停止时间
	 * @param End_time
	 */
	public void setEnd_time(FDateTime End_time) {
		setAttrVal("End_time", End_time);
	}
	/**
	 * 是否皮试
	 * @return String
	 */
	public String getIs_ps() {
		return ((String) getAttrVal("Is_ps"));
	}	
	/**
	 * 是否皮试
	 * @param Is_ps
	 */
	public void setIs_ps(String Is_ps) {
		setAttrVal("Is_ps", Is_ps);
	}
	/**
	 * 是否皮试结果
	 * @return String
	 */
	public String getIs_psresult() {
		return ((String) getAttrVal("Is_psresult"));
	}	
	/**
	 * 是否皮试结果
	 * @param Is_psresult
	 */
	public void setIs_psresult(String Is_psresult) {
		setAttrVal("Is_psresult", Is_psresult);
	}
	/**
	 * 是否适应症
	 * @return String
	 */
	public String getIs_syz() {
		return ((String) getAttrVal("Is_syz"));
	}	
	/**
	 * 是否适应症
	 * @param Is_syz
	 */
	public void setIs_syz(String Is_syz) {
		setAttrVal("Is_syz", Is_syz);
	}
	/**
	 * 是否适应症结果
	 * @return String
	 */
	public String getIs_syzresult() {
		return ((String) getAttrVal("Is_syzresult"));
	}	
	/**
	 * 是否适应症结果
	 * @param Is_syzresult
	 */
	public void setIs_syzresult(String Is_syzresult) {
		setAttrVal("Is_syzresult", Is_syzresult);
	}
	/**
	 * 是否加急
	 * @return String
	 */
	public String getIs_jj() {
		return ((String) getAttrVal("Is_jj"));
	}	
	/**
	 * 是否加急
	 * @param Is_jj
	 */
	public void setIs_jj(String Is_jj) {
		setAttrVal("Is_jj", Is_jj);
	}
	/**
	 * 是否加急结果
	 * @return String
	 */
	public String getIs_jjresult() {
		return ((String) getAttrVal("Is_jjresult"));
	}	
	/**
	 * 是否加急结果
	 * @param Is_jjresult
	 */
	public void setIs_jjresult(String Is_jjresult) {
		setAttrVal("Is_jjresult", Is_jjresult);
	}
	/**
	 * 是否药观
	 * @return String
	 */
	public String getIs_yg() {
		return ((String) getAttrVal("Is_yg"));
	}	
	/**
	 * 是否药观
	 * @param Is_yg
	 */
	public void setIs_yg(String Is_yg) {
		setAttrVal("Is_yg", Is_yg);
	}
	/**
	 * 是否药观结果
	 * @return String
	 */
	public String getIs_ygresult() {
		return ((String) getAttrVal("Is_ygresult"));
	}	
	/**
	 * 是否药观结果
	 * @param Is_ygresult
	 */
	public void setIs_ygresult(String Is_ygresult) {
		setAttrVal("Is_ygresult", Is_ygresult);
	}
	/**
	 * 医保类别编码
	 * @return String
	 */
	public String getCharge_gourp() {
		return ((String) getAttrVal("Charge_gourp"));
	}	
	/**
	 * 医保类别编码
	 * @param Charge_gourp
	 */
	public void setCharge_gourp(String Charge_gourp) {
		setAttrVal("Charge_gourp", Charge_gourp);
	}
	/**
	 * 医保类别名称
	 * @return String
	 */
	public String getCharge_group_name_external() {
		return ((String) getAttrVal("Charge_group_name_external"));
	}	
	/**
	 * 医保类别名称
	 * @param Charge_group_name_external
	 */
	public void setCharge_group_name_external(String Charge_group_name_external) {
		setAttrVal("Charge_group_name_external", Charge_group_name_external);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getComment1() {
		return ((String) getAttrVal("Comment1"));
	}	
	/**
	 * 嘱托
	 * @param Comment1
	 */
	public void setComment1(String Comment1) {
		setAttrVal("Comment1", Comment1);
	}
	/**
	 * 费用标记编码
	 * @return String
	 */
	public String getSginfee_code() {
		return ((String) getAttrVal("Sginfee_code"));
	}	
	/**
	 * 费用标记编码
	 * @param Sginfee_code
	 */
	public void setSginfee_code(String Sginfee_code) {
		setAttrVal("Sginfee_code", Sginfee_code);
	}
	/**
	 * 费用标记名称
	 * @return String
	 */
	public String getSginfee_name() {
		return ((String) getAttrVal("Sginfee_name"));
	}	
	/**
	 * 费用标记名称
	 * @param Sginfee_name
	 */
	public void setSginfee_name(String Sginfee_name) {
		setAttrVal("Sginfee_name", Sginfee_name);
	}
	/**
	 * 临床路径项目编码
	 * @return String
	 */
	public String getRoute_code() {
		return ((String) getAttrVal("Route_code"));
	}	
	/**
	 * 临床路径项目编码
	 * @param Route_code
	 */
	public void setRoute_code(String Route_code) {
		setAttrVal("Route_code", Route_code);
	}
	/**
	 * 临床路径项目序号
	 * @return String
	 */
	public String getRoute_no() {
		return ((String) getAttrVal("Route_no"));
	}	
	/**
	 * 临床路径项目序号
	 * @param Route_no
	 */
	public void setRoute_no(String Route_no) {
		setAttrVal("Route_no", Route_no);
	}
}
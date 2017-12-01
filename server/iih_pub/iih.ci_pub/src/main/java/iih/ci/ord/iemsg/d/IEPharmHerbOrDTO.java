package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE草药医嘱信息DTO DTO数据 
 * 
 */
public class IEPharmHerbOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE草药医嘱主键标识
	 * @return String
	 */
	public String getId_iepharmor() {
		return ((String) getAttrVal("Id_iepharmor"));
	}	
	/**
	 * IE草药医嘱主键标识
	 * @param Id_iepharmor
	 */
	public void setId_iepharmor(String Id_iepharmor) {
		setAttrVal("Id_iepharmor", Id_iepharmor);
	}
	/**
	 * IE药品医嘱就诊
	 * @return String
	 */
	public String getId_iepharmoren() {
		return ((String) getAttrVal("Id_iepharmoren"));
	}	
	/**
	 * IE药品医嘱就诊
	 * @param Id_iepharmoren
	 */
	public void setId_iepharmoren(String Id_iepharmoren) {
		setAttrVal("Id_iepharmoren", Id_iepharmoren);
	}
	/**
	 * IE药品医嘱药品集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_iepharmormms() {
		return ((FArrayList2) getAttrVal("Id_iepharmormms"));
	}	
	/**
	 * IE药品医嘱药品集合
	 * @param Id_iepharmormms
	 */
	public void setId_iepharmormms(FArrayList2 Id_iepharmormms) {
		setAttrVal("Id_iepharmormms", Id_iepharmormms);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getXy_zcy_order_code() {
		return ((String) getAttrVal("Xy_zcy_order_code"));
	}	
	/**
	 * 医嘱号
	 * @param Xy_zcy_order_code
	 */
	public void setXy_zcy_order_code(String Xy_zcy_order_code) {
		setAttrVal("Xy_zcy_order_code", Xy_zcy_order_code);
	}
	/**
	 * 医嘱类别编码
	 * @return String
	 */
	public String getXy_zcy_order_type_code() {
		return ((String) getAttrVal("Xy_zcy_order_type_code"));
	}	
	/**
	 * 医嘱类别编码
	 * @param Xy_zcy_order_type_code
	 */
	public void setXy_zcy_order_type_code(String Xy_zcy_order_type_code) {
		setAttrVal("Xy_zcy_order_type_code", Xy_zcy_order_type_code);
	}
	/**
	 * 医嘱类别名称
	 * @return String
	 */
	public String getXy_zcy_order_type_name() {
		return ((String) getAttrVal("Xy_zcy_order_type_name"));
	}	
	/**
	 * 医嘱类别名称
	 * @param Xy_zcy_order_type_name
	 */
	public void setXy_zcy_order_type_name(String Xy_zcy_order_type_name) {
		setAttrVal("Xy_zcy_order_type_name", Xy_zcy_order_type_name);
	}
	/**
	 * 医嘱备注
	 * @return String
	 */
	public String getXy_zcy_yz_memo() {
		return ((String) getAttrVal("Xy_zcy_yz_memo"));
	}	
	/**
	 * 医嘱备注
	 * @param Xy_zcy_yz_memo
	 */
	public void setXy_zcy_yz_memo(String Xy_zcy_yz_memo) {
		setAttrVal("Xy_zcy_yz_memo", Xy_zcy_yz_memo);
	}
	/**
	 * 医嘱执行频率编码
	 * @return String
	 */
	public String getXy_zcy_fre_code() {
		return ((String) getAttrVal("Xy_zcy_fre_code"));
	}	
	/**
	 * 医嘱执行频率编码
	 * @param Xy_zcy_fre_code
	 */
	public void setXy_zcy_fre_code(String Xy_zcy_fre_code) {
		setAttrVal("Xy_zcy_fre_code", Xy_zcy_fre_code);
	}
	/**
	 * 医嘱执行频率名称
	 * @return String
	 */
	public String getXy_zcy_fre_name() {
		return ((String) getAttrVal("Xy_zcy_fre_name"));
	}	
	/**
	 * 医嘱执行频率名称
	 * @param Xy_zcy_fre_name
	 */
	public void setXy_zcy_fre_name(String Xy_zcy_fre_name) {
		setAttrVal("Xy_zcy_fre_name", Xy_zcy_fre_name);
	}
	/**
	 * 用药途径编码
	 * @return String
	 */
	public String getXy_zcy_yytj_code() {
		return ((String) getAttrVal("Xy_zcy_yytj_code"));
	}	
	/**
	 * 用药途径编码
	 * @param Xy_zcy_yytj_code
	 */
	public void setXy_zcy_yytj_code(String Xy_zcy_yytj_code) {
		setAttrVal("Xy_zcy_yytj_code", Xy_zcy_yytj_code);
	}
	/**
	 * 用药途径名称
	 * @return String
	 */
	public String getXy_zcy_yytj_name() {
		return ((String) getAttrVal("Xy_zcy_yytj_name"));
	}	
	/**
	 * 用药途径名称
	 * @param Xy_zcy_yytj_name
	 */
	public void setXy_zcy_yytj_name(String Xy_zcy_yytj_name) {
		setAttrVal("Xy_zcy_yytj_name", Xy_zcy_yytj_name);
	}
	/**
	 * 次剂量
	 * @return String
	 */
	public String getXy_zcy_cjl() {
		return ((String) getAttrVal("Xy_zcy_cjl"));
	}	
	/**
	 * 次剂量
	 * @param Xy_zcy_cjl
	 */
	public void setXy_zcy_cjl(String Xy_zcy_cjl) {
		setAttrVal("Xy_zcy_cjl", Xy_zcy_cjl);
	}
	/**
	 * 次剂量单位
	 * @return String
	 */
	public String getXy_zcy_cjlunit() {
		return ((String) getAttrVal("Xy_zcy_cjlunit"));
	}	
	/**
	 * 次剂量单位
	 * @param Xy_zcy_cjlunit
	 */
	public void setXy_zcy_cjlunit(String Xy_zcy_cjlunit) {
		setAttrVal("Xy_zcy_cjlunit", Xy_zcy_cjlunit);
	}
	/**
	 * 总用量
	 * @return String
	 */
	public String getXy_zcy_zyl() {
		return ((String) getAttrVal("Xy_zcy_zyl"));
	}	
	/**
	 * 总用量
	 * @param Xy_zcy_zyl
	 */
	public void setXy_zcy_zyl(String Xy_zcy_zyl) {
		setAttrVal("Xy_zcy_zyl", Xy_zcy_zyl);
	}
	/**
	 * 总用量单位
	 * @return String
	 */
	public String getXy_zcy_zylunit() {
		return ((String) getAttrVal("Xy_zcy_zylunit"));
	}	
	/**
	 * 总用量单位
	 * @param Xy_zcy_zylunit
	 */
	public void setXy_zcy_zylunit(String Xy_zcy_zylunit) {
		setAttrVal("Xy_zcy_zylunit", Xy_zcy_zylunit);
	}
	/**
	 * 医嘱原科室编码
	 * @return String
	 */
	public String getXy_zcy_yz_old_dept_code() {
		return ((String) getAttrVal("Xy_zcy_yz_old_dept_code"));
	}	
	/**
	 * 医嘱原科室编码
	 * @param Xy_zcy_yz_old_dept_code
	 */
	public void setXy_zcy_yz_old_dept_code(String Xy_zcy_yz_old_dept_code) {
		setAttrVal("Xy_zcy_yz_old_dept_code", Xy_zcy_yz_old_dept_code);
	}
	/**
	 * 医嘱原科室名称
	 * @return String
	 */
	public String getXy_zcy_yz_old_dept_name() {
		return ((String) getAttrVal("Xy_zcy_yz_old_dept_name"));
	}	
	/**
	 * 医嘱原科室名称
	 * @param Xy_zcy_yz_old_dept_name
	 */
	public void setXy_zcy_yz_old_dept_name(String Xy_zcy_yz_old_dept_name) {
		setAttrVal("Xy_zcy_yz_old_dept_name", Xy_zcy_yz_old_dept_name);
	}
	/**
	 * 医嘱原病区编码
	 * @return String
	 */
	public String getXy_zcy_yz_old_ward_code() {
		return ((String) getAttrVal("Xy_zcy_yz_old_ward_code"));
	}	
	/**
	 * 医嘱原病区编码
	 * @param Xy_zcy_yz_old_ward_code
	 */
	public void setXy_zcy_yz_old_ward_code(String Xy_zcy_yz_old_ward_code) {
		setAttrVal("Xy_zcy_yz_old_ward_code", Xy_zcy_yz_old_ward_code);
	}
	/**
	 * 医嘱原病区名称
	 * @return String
	 */
	public String getXy_zcy_yz_old_ward_name() {
		return ((String) getAttrVal("Xy_zcy_yz_old_ward_name"));
	}	
	/**
	 * 医嘱原病区名称
	 * @param Xy_zcy_yz_old_ward_name
	 */
	public void setXy_zcy_yz_old_ward_name(String Xy_zcy_yz_old_ward_name) {
		setAttrVal("Xy_zcy_yz_old_ward_name", Xy_zcy_yz_old_ward_name);
	}
	/**
	 * 药物编码
	 * @return String
	 */
	public String getXy_zcy_yw_code() {
		return ((String) getAttrVal("Xy_zcy_yw_code"));
	}	
	/**
	 * 药物编码
	 * @param Xy_zcy_yw_code
	 */
	public void setXy_zcy_yw_code(String Xy_zcy_yw_code) {
		setAttrVal("Xy_zcy_yw_code", Xy_zcy_yw_code);
	}
	/**
	 * 包装序号
	 * @return String
	 */
	public String getXy_zcy_bz_no() {
		return ((String) getAttrVal("Xy_zcy_bz_no"));
	}	
	/**
	 * 包装序号
	 * @param Xy_zcy_bz_no
	 */
	public void setXy_zcy_bz_no(String Xy_zcy_bz_no) {
		setAttrVal("Xy_zcy_bz_no", Xy_zcy_bz_no);
	}
	/**
	 * 药物医保类别编码
	 * @return String
	 */
	public String getXy_zcy_yw_yb_code() {
		return ((String) getAttrVal("Xy_zcy_yw_yb_code"));
	}	
	/**
	 * 药物医保类别编码
	 * @param Xy_zcy_yw_yb_code
	 */
	public void setXy_zcy_yw_yb_code(String Xy_zcy_yw_yb_code) {
		setAttrVal("Xy_zcy_yw_yb_code", Xy_zcy_yw_yb_code);
	}
	/**
	 * 药物医保类别名称
	 * @return String
	 */
	public String getXy_zcy_yw_yb_name() {
		return ((String) getAttrVal("Xy_zcy_yw_yb_name"));
	}	
	/**
	 * 药物医保类别名称
	 * @param Xy_zcy_yw_yb_name
	 */
	public void setXy_zcy_yw_yb_name(String Xy_zcy_yw_yb_name) {
		setAttrVal("Xy_zcy_yw_yb_name", Xy_zcy_yw_yb_name);
	}
	/**
	 * 开嘱时间
	 * @return FDateTime
	 */
	public FDateTime getXy_zcy_yz_date() {
		return ((FDateTime) getAttrVal("Xy_zcy_yz_date"));
	}	
	/**
	 * 开嘱时间
	 * @param Xy_zcy_yz_date
	 */
	public void setXy_zcy_yz_date(FDateTime Xy_zcy_yz_date) {
		setAttrVal("Xy_zcy_yz_date", Xy_zcy_yz_date);
	}
	/**
	 * 开嘱医生编码
	 * @return String
	 */
	public String getXy_zcy_yz_doctor_no() {
		return ((String) getAttrVal("Xy_zcy_yz_doctor_no"));
	}	
	/**
	 * 开嘱医生编码
	 * @param Xy_zcy_yz_doctor_no
	 */
	public void setXy_zcy_yz_doctor_no(String Xy_zcy_yz_doctor_no) {
		setAttrVal("Xy_zcy_yz_doctor_no", Xy_zcy_yz_doctor_no);
	}
	/**
	 * 开嘱医生姓名
	 * @return String
	 */
	public String getXy_zcy_yz_doctor_name() {
		return ((String) getAttrVal("Xy_zcy_yz_doctor_name"));
	}	
	/**
	 * 开嘱医生姓名
	 * @param Xy_zcy_yz_doctor_name
	 */
	public void setXy_zcy_yz_doctor_name(String Xy_zcy_yz_doctor_name) {
		setAttrVal("Xy_zcy_yz_doctor_name", Xy_zcy_yz_doctor_name);
	}
	/**
	 * 医嘱医生确认时间
	 * @return FDateTime
	 */
	public FDateTime getXy_zcy_yz_confirm_date() {
		return ((FDateTime) getAttrVal("Xy_zcy_yz_confirm_date"));
	}	
	/**
	 * 医嘱医生确认时间
	 * @param Xy_zcy_yz_confirm_date
	 */
	public void setXy_zcy_yz_confirm_date(FDateTime Xy_zcy_yz_confirm_date) {
		setAttrVal("Xy_zcy_yz_confirm_date", Xy_zcy_yz_confirm_date);
	}
	/**
	 * 医嘱确认医生编码
	 * @return String
	 */
	public String getXy_zcy_yz_confirm_code() {
		return ((String) getAttrVal("Xy_zcy_yz_confirm_code"));
	}	
	/**
	 * 医嘱确认医生编码
	 * @param Xy_zcy_yz_confirm_code
	 */
	public void setXy_zcy_yz_confirm_code(String Xy_zcy_yz_confirm_code) {
		setAttrVal("Xy_zcy_yz_confirm_code", Xy_zcy_yz_confirm_code);
	}
	/**
	 * 医嘱确认医生名称
	 * @return String
	 */
	public String getXy_zcy_yz_confirm_name() {
		return ((String) getAttrVal("Xy_zcy_yz_confirm_name"));
	}	
	/**
	 * 医嘱确认医生名称
	 * @param Xy_zcy_yz_confirm_name
	 */
	public void setXy_zcy_yz_confirm_name(String Xy_zcy_yz_confirm_name) {
		setAttrVal("Xy_zcy_yz_confirm_name", Xy_zcy_yz_confirm_name);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getXy_zcy_exe_dept_code() {
		return ((String) getAttrVal("Xy_zcy_exe_dept_code"));
	}	
	/**
	 * 执行科室编码
	 * @param Xy_zcy_exe_dept_code
	 */
	public void setXy_zcy_exe_dept_code(String Xy_zcy_exe_dept_code) {
		setAttrVal("Xy_zcy_exe_dept_code", Xy_zcy_exe_dept_code);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getXy_zcy_exe_dept_name() {
		return ((String) getAttrVal("Xy_zcy_exe_dept_name"));
	}	
	/**
	 * 执行科室名称
	 * @param Xy_zcy_exe_dept_name
	 */
	public void setXy_zcy_exe_dept_name(String Xy_zcy_exe_dept_name) {
		setAttrVal("Xy_zcy_exe_dept_name", Xy_zcy_exe_dept_name);
	}
	/**
	 * 父医嘱号
	 * @return String
	 */
	public String getXy_zcy_f_order_no() {
		return ((String) getAttrVal("Xy_zcy_f_order_no"));
	}	
	/**
	 * 父医嘱号
	 * @param Xy_zcy_f_order_no
	 */
	public void setXy_zcy_f_order_no(String Xy_zcy_f_order_no) {
		setAttrVal("Xy_zcy_f_order_no", Xy_zcy_f_order_no);
	}
	/**
	 * 互斥类型编码
	 * @return String
	 */
	public String getXy_zcy_hc_order_type_code() {
		return ((String) getAttrVal("Xy_zcy_hc_order_type_code"));
	}	
	/**
	 * 互斥类型编码
	 * @param Xy_zcy_hc_order_type_code
	 */
	public void setXy_zcy_hc_order_type_code(String Xy_zcy_hc_order_type_code) {
		setAttrVal("Xy_zcy_hc_order_type_code", Xy_zcy_hc_order_type_code);
	}
	/**
	 * 互斥类型名称
	 * @return String
	 */
	public String getXy_zcy_hc_order_type_name() {
		return ((String) getAttrVal("Xy_zcy_hc_order_type_name"));
	}	
	/**
	 * 互斥类型名称
	 * @param Xy_zcy_hc_order_type_name
	 */
	public void setXy_zcy_hc_order_type_name(String Xy_zcy_hc_order_type_name) {
		setAttrVal("Xy_zcy_hc_order_type_name", Xy_zcy_hc_order_type_name);
	}
	/**
	 * 费用标记编码
	 * @return String
	 */
	public String getXy_zcy_fybj_code() {
		return ((String) getAttrVal("Xy_zcy_fybj_code"));
	}	
	/**
	 * 费用标记编码
	 * @param Xy_zcy_fybj_code
	 */
	public void setXy_zcy_fybj_code(String Xy_zcy_fybj_code) {
		setAttrVal("Xy_zcy_fybj_code", Xy_zcy_fybj_code);
	}
	/**
	 * 费用标记名称
	 * @return String
	 */
	public String getXy_zcy_fybj_name() {
		return ((String) getAttrVal("Xy_zcy_fybj_name"));
	}	
	/**
	 * 费用标记名称
	 * @param Xy_zcy_fybj_name
	 */
	public void setXy_zcy_fybj_name(String Xy_zcy_fybj_name) {
		setAttrVal("Xy_zcy_fybj_name", Xy_zcy_fybj_name);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getXy_zcy_jt() {
		return ((String) getAttrVal("Xy_zcy_jt"));
	}	
	/**
	 * 嘱托
	 * @param Xy_zcy_jt
	 */
	public void setXy_zcy_jt(String Xy_zcy_jt) {
		setAttrVal("Xy_zcy_jt", Xy_zcy_jt);
	}
	/**
	 * 是否适应症
	 * @return String
	 */
	public String getXy_zcy_is_sy() {
		return ((String) getAttrVal("Xy_zcy_is_sy"));
	}	
	/**
	 * 是否适应症
	 * @param Xy_zcy_is_sy
	 */
	public void setXy_zcy_is_sy(String Xy_zcy_is_sy) {
		setAttrVal("Xy_zcy_is_sy", Xy_zcy_is_sy);
	}
	/**
	 * 是否适应症结果
	 * @return String
	 */
	public String getXy_zcy_is_syresult() {
		return ((String) getAttrVal("Xy_zcy_is_syresult"));
	}	
	/**
	 * 是否适应症结果
	 * @param Xy_zcy_is_syresult
	 */
	public void setXy_zcy_is_syresult(String Xy_zcy_is_syresult) {
		setAttrVal("Xy_zcy_is_syresult", Xy_zcy_is_syresult);
	}
	/**
	 * 是否皮试
	 * @return String
	 */
	public String getXy_zcy_is_ps() {
		return ((String) getAttrVal("Xy_zcy_is_ps"));
	}	
	/**
	 * 是否皮试
	 * @param Xy_zcy_is_ps
	 */
	public void setXy_zcy_is_ps(String Xy_zcy_is_ps) {
		setAttrVal("Xy_zcy_is_ps", Xy_zcy_is_ps);
	}
	/**
	 * 是否皮试结果
	 * @return String
	 */
	public String getXy_zcy_is_psresult() {
		return ((String) getAttrVal("Xy_zcy_is_psresult"));
	}	
	/**
	 * 是否皮试结果
	 * @param Xy_zcy_is_psresult
	 */
	public void setXy_zcy_is_psresult(String Xy_zcy_is_psresult) {
		setAttrVal("Xy_zcy_is_psresult", Xy_zcy_is_psresult);
	}
	/**
	 * 是否加急
	 * @return String
	 */
	public String getXy_zcy_is_jj() {
		return ((String) getAttrVal("Xy_zcy_is_jj"));
	}	
	/**
	 * 是否加急
	 * @param Xy_zcy_is_jj
	 */
	public void setXy_zcy_is_jj(String Xy_zcy_is_jj) {
		setAttrVal("Xy_zcy_is_jj", Xy_zcy_is_jj);
	}
	/**
	 * 是否加急结果
	 * @return String
	 */
	public String getXy_zcy_is_jjresult() {
		return ((String) getAttrVal("Xy_zcy_is_jjresult"));
	}	
	/**
	 * 是否加急结果
	 * @param Xy_zcy_is_jjresult
	 */
	public void setXy_zcy_is_jjresult(String Xy_zcy_is_jjresult) {
		setAttrVal("Xy_zcy_is_jjresult", Xy_zcy_is_jjresult);
	}
	/**
	 * 是否药观
	 * @return String
	 */
	public String getXy_zcy_is_yg() {
		return ((String) getAttrVal("Xy_zcy_is_yg"));
	}	
	/**
	 * 是否药观
	 * @param Xy_zcy_is_yg
	 */
	public void setXy_zcy_is_yg(String Xy_zcy_is_yg) {
		setAttrVal("Xy_zcy_is_yg", Xy_zcy_is_yg);
	}
	/**
	 * 是否药观结果
	 * @return String
	 */
	public String getXy_zcy_is_ygresult() {
		return ((String) getAttrVal("Xy_zcy_is_ygresult"));
	}	
	/**
	 * 是否药观结果
	 * @param Xy_zcy_is_ygresult
	 */
	public void setXy_zcy_is_ygresult(String Xy_zcy_is_ygresult) {
		setAttrVal("Xy_zcy_is_ygresult", Xy_zcy_is_ygresult);
	}
	/**
	 * 领药量
	 * @return String
	 */
	public String getXy_zcy_lyl() {
		return ((String) getAttrVal("Xy_zcy_lyl"));
	}	
	/**
	 * 领药量
	 * @param Xy_zcy_lyl
	 */
	public void setXy_zcy_lyl(String Xy_zcy_lyl) {
		setAttrVal("Xy_zcy_lyl", Xy_zcy_lyl);
	}
	/**
	 * 领药量单位
	 * @return String
	 */
	public String getXy_zcy_lylunit() {
		return ((String) getAttrVal("Xy_zcy_lylunit"));
	}	
	/**
	 * 领药量单位
	 * @param Xy_zcy_lylunit
	 */
	public void setXy_zcy_lylunit(String Xy_zcy_lylunit) {
		setAttrVal("Xy_zcy_lylunit", Xy_zcy_lylunit);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getXy_zcy_exe_date() {
		return ((FDateTime) getAttrVal("Xy_zcy_exe_date"));
	}	
	/**
	 * 执行时间
	 * @param Xy_zcy_exe_date
	 */
	public void setXy_zcy_exe_date(FDateTime Xy_zcy_exe_date) {
		setAttrVal("Xy_zcy_exe_date", Xy_zcy_exe_date);
	}
	/**
	 * 停止时间
	 * @return FDateTime
	 */
	public FDateTime getXy_zcy_stop_date() {
		return ((FDateTime) getAttrVal("Xy_zcy_stop_date"));
	}	
	/**
	 * 停止时间
	 * @param Xy_zcy_stop_date
	 */
	public void setXy_zcy_stop_date(FDateTime Xy_zcy_stop_date) {
		setAttrVal("Xy_zcy_stop_date", Xy_zcy_stop_date);
	}
	/**
	 * 总用量(付数)
	 * @return String
	 */
	public String getCy_fs_count() {
		return ((String) getAttrVal("Cy_fs_count"));
	}	
	/**
	 * 总用量(付数)
	 * @param Cy_fs_count
	 */
	public void setCy_fs_count(String Cy_fs_count) {
		setAttrVal("Cy_fs_count", Cy_fs_count);
	}
	/**
	 * 总用量单位(付)
	 * @return String
	 */
	public String getCy_fs_unit() {
		return ((String) getAttrVal("Cy_fs_unit"));
	}	
	/**
	 * 总用量单位(付)
	 * @param Cy_fs_unit
	 */
	public void setCy_fs_unit(String Cy_fs_unit) {
		setAttrVal("Cy_fs_unit", Cy_fs_unit);
	}
}
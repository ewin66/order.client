package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE护理医嘱信息DTO DTO数据 
 * 
 */
public class IENsOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE护理医嘱主键标识
	 * @return String
	 */
	public String getId_iensor() {
		return ((String) getAttrVal("Id_iensor"));
	}	
	/**
	 * IE护理医嘱主键标识
	 * @param Id_iensor
	 */
	public void setId_iensor(String Id_iensor) {
		setAttrVal("Id_iensor", Id_iensor);
	}
	/**
	 * IE护理医嘱就诊
	 * @return String
	 */
	public String getId_iensoren() {
		return ((String) getAttrVal("Id_iensoren"));
	}	
	/**
	 * IE护理医嘱就诊
	 * @param Id_iensoren
	 */
	public void setId_iensoren(String Id_iensoren) {
		setAttrVal("Id_iensoren", Id_iensoren);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getOrder_code() {
		return ((String) getAttrVal("Order_code"));
	}	
	/**
	 * 医嘱号
	 * @param Order_code
	 */
	public void setOrder_code(String Order_code) {
		setAttrVal("Order_code", Order_code);
	}
	/**
	 * 医嘱类别编码
	 * @return String
	 */
	public String getOrder_type_code() {
		return ((String) getAttrVal("Order_type_code"));
	}	
	/**
	 * 医嘱类别编码
	 * @param Order_type_code
	 */
	public void setOrder_type_code(String Order_type_code) {
		setAttrVal("Order_type_code", Order_type_code);
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
	 * 医嘱原科室编码
	 * @return String
	 */
	public String getYz_dept_code() {
		return ((String) getAttrVal("Yz_dept_code"));
	}	
	/**
	 * 医嘱原科室编码
	 * @param Yz_dept_code
	 */
	public void setYz_dept_code(String Yz_dept_code) {
		setAttrVal("Yz_dept_code", Yz_dept_code);
	}
	/**
	 * 医嘱原科室名称
	 * @return String
	 */
	public String getYz_dept_name() {
		return ((String) getAttrVal("Yz_dept_name"));
	}	
	/**
	 * 医嘱原科室名称
	 * @param Yz_dept_name
	 */
	public void setYz_dept_name(String Yz_dept_name) {
		setAttrVal("Yz_dept_name", Yz_dept_name);
	}
	/**
	 * 医嘱原病区编码
	 * @return String
	 */
	public String getYz_ward_code() {
		return ((String) getAttrVal("Yz_ward_code"));
	}	
	/**
	 * 医嘱原病区编码
	 * @param Yz_ward_code
	 */
	public void setYz_ward_code(String Yz_ward_code) {
		setAttrVal("Yz_ward_code", Yz_ward_code);
	}
	/**
	 * 医嘱原病区名称
	 * @return String
	 */
	public String getYz_ward_name() {
		return ((String) getAttrVal("Yz_ward_name"));
	}	
	/**
	 * 医嘱原病区名称
	 * @param Yz_ward_name
	 */
	public void setYz_ward_name(String Yz_ward_name) {
		setAttrVal("Yz_ward_name", Yz_ward_name);
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
	 * 医嘱备注
	 * @return String
	 */
	public String getYz_memo() {
		return ((String) getAttrVal("Yz_memo"));
	}	
	/**
	 * 医嘱备注
	 * @param Yz_memo
	 */
	public void setYz_memo(String Yz_memo) {
		setAttrVal("Yz_memo", Yz_memo);
	}
	/**
	 * 数量
	 * @return String
	 */
	public String getYz_unit() {
		return ((String) getAttrVal("Yz_unit"));
	}	
	/**
	 * 数量
	 * @param Yz_unit
	 */
	public void setYz_unit(String Yz_unit) {
		setAttrVal("Yz_unit", Yz_unit);
	}
	/**
	 * 数量单位
	 * @return String
	 */
	public String getYz_unit_code() {
		return ((String) getAttrVal("Yz_unit_code"));
	}	
	/**
	 * 数量单位
	 * @param Yz_unit_code
	 */
	public void setYz_unit_code(String Yz_unit_code) {
		setAttrVal("Yz_unit_code", Yz_unit_code);
	}
	/**
	 * 执行频率编码
	 * @return String
	 */
	public String getFre_no() {
		return ((String) getAttrVal("Fre_no"));
	}	
	/**
	 * 执行频率编码
	 * @param Fre_no
	 */
	public void setFre_no(String Fre_no) {
		setAttrVal("Fre_no", Fre_no);
	}
	/**
	 * 执行频率
	 * @return String
	 */
	public String getFre_name() {
		return ((String) getAttrVal("Fre_name"));
	}	
	/**
	 * 执行频率
	 * @param Fre_name
	 */
	public void setFre_name(String Fre_name) {
		setAttrVal("Fre_name", Fre_name);
	}
	/**
	 * 开始时间
	 * @return String
	 */
	public String getYz_start_time() {
		return ((String) getAttrVal("Yz_start_time"));
	}	
	/**
	 * 开始时间
	 * @param Yz_start_time
	 */
	public void setYz_start_time(String Yz_start_time) {
		setAttrVal("Yz_start_time", Yz_start_time);
	}
	/**
	 * 停止时间
	 * @return String
	 */
	public String getYz_stop_time() {
		return ((String) getAttrVal("Yz_stop_time"));
	}	
	/**
	 * 停止时间
	 * @param Yz_stop_time
	 */
	public void setYz_stop_time(String Yz_stop_time) {
		setAttrVal("Yz_stop_time", Yz_stop_time);
	}
	/**
	 * 开嘱医生编码
	 * @return String
	 */
	public String getYz_doctor_code() {
		return ((String) getAttrVal("Yz_doctor_code"));
	}	
	/**
	 * 开嘱医生编码
	 * @param Yz_doctor_code
	 */
	public void setYz_doctor_code(String Yz_doctor_code) {
		setAttrVal("Yz_doctor_code", Yz_doctor_code);
	}
	/**
	 * 开嘱医生姓名
	 * @return String
	 */
	public String getYz_doctor_name() {
		return ((String) getAttrVal("Yz_doctor_name"));
	}	
	/**
	 * 开嘱医生姓名
	 * @param Yz_doctor_name
	 */
	public void setYz_doctor_name(String Yz_doctor_name) {
		setAttrVal("Yz_doctor_name", Yz_doctor_name);
	}
	/**
	 * 开嘱时间
	 * @return String
	 */
	public String getYz_date() {
		return ((String) getAttrVal("Yz_date"));
	}	
	/**
	 * 开嘱时间
	 * @param Yz_date
	 */
	public void setYz_date(String Yz_date) {
		setAttrVal("Yz_date", Yz_date);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExe_dept_code() {
		return ((String) getAttrVal("Exe_dept_code"));
	}	
	/**
	 * 执行科室编码
	 * @param Exe_dept_code
	 */
	public void setExe_dept_code(String Exe_dept_code) {
		setAttrVal("Exe_dept_code", Exe_dept_code);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExe_dept_name() {
		return ((String) getAttrVal("Exe_dept_name"));
	}	
	/**
	 * 执行科室名称
	 * @param Exe_dept_name
	 */
	public void setExe_dept_name(String Exe_dept_name) {
		setAttrVal("Exe_dept_name", Exe_dept_name);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getJt() {
		return ((String) getAttrVal("Jt"));
	}	
	/**
	 * 嘱托
	 * @param Jt
	 */
	public void setJt(String Jt) {
		setAttrVal("Jt", Jt);
	}
	/**
	 * 互斥类型编码
	 * @return String
	 */
	public String getHc_order_type_code() {
		return ((String) getAttrVal("Hc_order_type_code"));
	}	
	/**
	 * 互斥类型编码
	 * @param Hc_order_type_code
	 */
	public void setHc_order_type_code(String Hc_order_type_code) {
		setAttrVal("Hc_order_type_code", Hc_order_type_code);
	}
	/**
	 * 互斥类型名称
	 * @return String
	 */
	public String getHc_order_type_name() {
		return ((String) getAttrVal("Hc_order_type_name"));
	}	
	/**
	 * 互斥类型名称
	 * @param Hc_order_type_name
	 */
	public void setHc_order_type_name(String Hc_order_type_name) {
		setAttrVal("Hc_order_type_name", Hc_order_type_name);
	}
	/**
	 * 父医嘱号
	 * @return String
	 */
	public String getF_order_code() {
		return ((String) getAttrVal("F_order_code"));
	}	
	/**
	 * 父医嘱号
	 * @param F_order_code
	 */
	public void setF_order_code(String F_order_code) {
		setAttrVal("F_order_code", F_order_code);
	}
	/**
	 * 确认医生编码
	 * @return String
	 */
	public String getYz_confirm_doctor_code() {
		return ((String) getAttrVal("Yz_confirm_doctor_code"));
	}	
	/**
	 * 确认医生编码
	 * @param Yz_confirm_doctor_code
	 */
	public void setYz_confirm_doctor_code(String Yz_confirm_doctor_code) {
		setAttrVal("Yz_confirm_doctor_code", Yz_confirm_doctor_code);
	}
	/**
	 * 确认医生名称
	 * @return String
	 */
	public String getYz_confirm_doctor_name() {
		return ((String) getAttrVal("Yz_confirm_doctor_name"));
	}	
	/**
	 * 确认医生名称
	 * @param Yz_confirm_doctor_name
	 */
	public void setYz_confirm_doctor_name(String Yz_confirm_doctor_name) {
		setAttrVal("Yz_confirm_doctor_name", Yz_confirm_doctor_name);
	}
	/**
	 * 确认时间
	 * @return String
	 */
	public String getYz_confirm_date() {
		return ((String) getAttrVal("Yz_confirm_date"));
	}	
	/**
	 * 确认时间
	 * @param Yz_confirm_date
	 */
	public void setYz_confirm_date(String Yz_confirm_date) {
		setAttrVal("Yz_confirm_date", Yz_confirm_date);
	}
	/**
	 * 费用标记编码
	 * @return String
	 */
	public String getFybj_code() {
		return ((String) getAttrVal("Fybj_code"));
	}	
	/**
	 * 费用标记编码
	 * @param Fybj_code
	 */
	public void setFybj_code(String Fybj_code) {
		setAttrVal("Fybj_code", Fybj_code);
	}
	/**
	 * 费用标记名称
	 * @return String
	 */
	public String getFybj_name() {
		return ((String) getAttrVal("Fybj_name"));
	}	
	/**
	 * 费用标记名称
	 * @param Fybj_name
	 */
	public void setFybj_name(String Fybj_name) {
		setAttrVal("Fybj_name", Fybj_name);
	}
	/**
	 * 价格
	 * @return String
	 */
	public String getJg() {
		return ((String) getAttrVal("Jg"));
	}	
	/**
	 * 价格
	 * @param Jg
	 */
	public void setJg(String Jg) {
		setAttrVal("Jg", Jg);
	}
	/**
	 * 价格单位
	 * @return String
	 */
	public String getJgdw() {
		return ((String) getAttrVal("Jgdw"));
	}	
	/**
	 * 价格单位
	 * @param Jgdw
	 */
	public void setJgdw(String Jgdw) {
		setAttrVal("Jgdw", Jgdw);
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
}
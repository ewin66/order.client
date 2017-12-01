package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检查申请对应项目信息DTO DTO数据 
 * 
 */
public class IEOpRisOrItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检查申请对应项目主键标识
	 * @return String
	 */
	public String getId_ierisoritm() {
		return ((String) getAttrVal("Id_ierisoritm"));
	}	
	/**
	 * IE检查申请对应项目主键标识
	 * @param Id_ierisoritm
	 */
	public void setId_ierisoritm(String Id_ierisoritm) {
		setAttrVal("Id_ierisoritm", Id_ierisoritm);
	}
	/**
	 * IE检查申请
	 * @return String
	 */
	public String getId_ierisor() {
		return ((String) getAttrVal("Id_ierisor"));
	}	
	/**
	 * IE检查申请
	 * @param Id_ierisor
	 */
	public void setId_ierisor(String Id_ierisor) {
		setAttrVal("Id_ierisor", Id_ierisor);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getExam_serial() {
		return ((String) getAttrVal("Exam_serial"));
	}	
	/**
	 * 医嘱号
	 * @param Exam_serial
	 */
	public void setExam_serial(String Exam_serial) {
		setAttrVal("Exam_serial", Exam_serial);
	}
	/**
	 * 检查项目编码
	 * @return String
	 */
	public String getExam_sub_type() {
		return ((String) getAttrVal("Exam_sub_type"));
	}	
	/**
	 * 检查项目编码
	 * @param Exam_sub_type
	 */
	public void setExam_sub_type(String Exam_sub_type) {
		setAttrVal("Exam_sub_type", Exam_sub_type);
	}
	/**
	 * 检查项目名称
	 * @return String
	 */
	public String getExam_sub_type_name() {
		return ((String) getAttrVal("Exam_sub_type_name"));
	}	
	/**
	 * 检查项目名称
	 * @param Exam_sub_type_name
	 */
	public void setExam_sub_type_name(String Exam_sub_type_name) {
		setAttrVal("Exam_sub_type_name", Exam_sub_type_name);
	}
	/**
	 * 医嘱费用
	 * @return String
	 */
	public String getOrder_pri() {
		return ((String) getAttrVal("Order_pri"));
	}	
	/**
	 * 医嘱费用
	 * @param Order_pri
	 */
	public void setOrder_pri(String Order_pri) {
		setAttrVal("Order_pri", Order_pri);
	}
	/**
	 * 医嘱开始时间
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}	
	/**
	 * 医嘱开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 医嘱停止时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}	
	/**
	 * 医嘱停止时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 医嘱执行频率编码
	 * @return String
	 */
	public String getYz_frequency() {
		return ((String) getAttrVal("Yz_frequency"));
	}	
	/**
	 * 医嘱执行频率编码
	 * @param Yz_frequency
	 */
	public void setYz_frequency(String Yz_frequency) {
		setAttrVal("Yz_frequency", Yz_frequency);
	}
	/**
	 * 医嘱执行频率名称
	 * @return String
	 */
	public String getYz_frequency_name() {
		return ((String) getAttrVal("Yz_frequency_name"));
	}	
	/**
	 * 医嘱执行频率名称
	 * @param Yz_frequency_name
	 */
	public void setYz_frequency_name(String Yz_frequency_name) {
		setAttrVal("Yz_frequency_name", Yz_frequency_name);
	}
	/**
	 * 检查方法变编码
	 * @return String
	 */
	public String getExam_sub_fftype() {
		return ((String) getAttrVal("Exam_sub_fftype"));
	}	
	/**
	 * 检查方法变编码
	 * @param Exam_sub_fftype
	 */
	public void setExam_sub_fftype(String Exam_sub_fftype) {
		setAttrVal("Exam_sub_fftype", Exam_sub_fftype);
	}
	/**
	 * 检查方法名
	 * @return String
	 */
	public String getExam_sub_fftype_name() {
		return ((String) getAttrVal("Exam_sub_fftype_name"));
	}	
	/**
	 * 检查方法名
	 * @param Exam_sub_fftype_name
	 */
	public void setExam_sub_fftype_name(String Exam_sub_fftype_name) {
		setAttrVal("Exam_sub_fftype_name", Exam_sub_fftype_name);
	}
	/**
	 * 检查部位编码
	 * @return String
	 */
	public String getExam_region() {
		return ((String) getAttrVal("Exam_region"));
	}	
	/**
	 * 检查部位编码
	 * @param Exam_region
	 */
	public void setExam_region(String Exam_region) {
		setAttrVal("Exam_region", Exam_region);
	}
	/**
	 * 检查部位名称
	 * @return String
	 */
	public String getExam_region_name() {
		return ((String) getAttrVal("Exam_region_name"));
	}	
	/**
	 * 检查部位名称
	 * @param Exam_region_name
	 */
	public void setExam_region_name(String Exam_region_name) {
		setAttrVal("Exam_region_name", Exam_region_name);
	}
	/**
	 * 是否皮试
	 * @return String
	 */
	public String getIsstest() {
		return ((String) getAttrVal("Isstest"));
	}	
	/**
	 * 是否皮试
	 * @param Isstest
	 */
	public void setIsstest(String Isstest) {
		setAttrVal("Isstest", Isstest);
	}
	/**
	 * 是否皮试结果
	 * @return String
	 */
	public String getStest() {
		return ((String) getAttrVal("Stest"));
	}	
	/**
	 * 是否皮试结果
	 * @param Stest
	 */
	public void setStest(String Stest) {
		setAttrVal("Stest", Stest);
	}
	/**
	 * 是否加急
	 * @return String
	 */
	public String getIs_em() {
		return ((String) getAttrVal("Is_em"));
	}	
	/**
	 * 是否加急
	 * @param Is_em
	 */
	public void setIs_em(String Is_em) {
		setAttrVal("Is_em", Is_em);
	}
	/**
	 * 是否加急结果
	 * @return String
	 */
	public String getIs_em_r() {
		return ((String) getAttrVal("Is_em_r"));
	}	
	/**
	 * 是否加急结果
	 * @param Is_em_r
	 */
	public void setIs_em_r(String Is_em_r) {
		setAttrVal("Is_em_r", Is_em_r);
	}
	/**
	 * 是否药观
	 * @return String
	 */
	public String getIsyg() {
		return ((String) getAttrVal("Isyg"));
	}	
	/**
	 * 是否药观
	 * @param Isyg
	 */
	public void setIsyg(String Isyg) {
		setAttrVal("Isyg", Isyg);
	}
	/**
	 * 是否药观结果
	 * @return String
	 */
	public String getYg() {
		return ((String) getAttrVal("Yg"));
	}	
	/**
	 * 是否药观结果
	 * @param Yg
	 */
	public void setYg(String Yg) {
		setAttrVal("Yg", Yg);
	}
	/**
	 * vip的值
	 * @return String
	 */
	public String getEu_vip() {
		return ((String) getAttrVal("Eu_vip"));
	}	
	/**
	 * vip的值
	 * @param Eu_vip
	 */
	public void setEu_vip(String Eu_vip) {
		setAttrVal("Eu_vip", Eu_vip);
	}
}
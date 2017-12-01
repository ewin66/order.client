package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检查申请信息DTO DTO数据 
 * 
 */
public class IEOpRisOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检查申请主键标识
	 * @return String
	 */
	public String getId_ierisor() {
		return ((String) getAttrVal("Id_ierisor"));
	}	
	/**
	 * IE检查申请主键标识
	 * @param Id_ierisor
	 */
	public void setId_ierisor(String Id_ierisor) {
		setAttrVal("Id_ierisor", Id_ierisor);
	}
	/**
	 * IE检查申请就诊
	 * @return String
	 */
	public String getId_ierisoren() {
		return ((String) getAttrVal("Id_ierisoren"));
	}	
	/**
	 * IE检查申请就诊
	 * @param Id_ierisoren
	 */
	public void setId_ierisoren(String Id_ierisoren) {
		setAttrVal("Id_ierisoren", Id_ierisoren);
	}
	/**
	 * IE检查申请项目集合
	 * @return FArrayList
	 */
	public FArrayList getId_ierisoritms() {
		return ((FArrayList) getAttrVal("Id_ierisoritms"));
	}	
	/**
	 * IE检查申请项目集合
	 * @param Id_ierisoritms
	 */
	public void setId_ierisoritms(FArrayList Id_ierisoritms) {
		setAttrVal("Id_ierisoritms", Id_ierisoritms);
	}
	/**
	 * 检查申请单编号
	 * @return String
	 */
	public String getApply_serial() {
		return ((String) getAttrVal("Apply_serial"));
	}	
	/**
	 * 检查申请单编号
	 * @param Apply_serial
	 */
	public void setApply_serial(String Apply_serial) {
		setAttrVal("Apply_serial", Apply_serial);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getExam_type() {
		return ((String) getAttrVal("Exam_type"));
	}	
	/**
	 * 医嘱类型
	 * @param Exam_type
	 */
	public void setExam_type(String Exam_type) {
		setAttrVal("Exam_type", Exam_type);
	}
	/**
	 * 医嘱类型名称
	 * @return String
	 */
	public String getExam_type_name() {
		return ((String) getAttrVal("Exam_type_name"));
	}	
	/**
	 * 医嘱类型名称
	 * @param Exam_type_name
	 */
	public void setExam_type_name(String Exam_type_name) {
		setAttrVal("Exam_type_name", Exam_type_name);
	}
	/**
	 * 申请单详细内容
	 * @return String
	 */
	public String getExam_content() {
		return ((String) getAttrVal("Exam_content"));
	}	
	/**
	 * 申请单详细内容
	 * @param Exam_content
	 */
	public void setExam_content(String Exam_content) {
		setAttrVal("Exam_content", Exam_content);
	}
	/**
	 * 检查申请日期
	 * @return FDateTime
	 */
	public FDateTime getExam_request_date() {
		return ((FDateTime) getAttrVal("Exam_request_date"));
	}	
	/**
	 * 检查申请日期
	 * @param Exam_request_date
	 */
	public void setExam_request_date(FDateTime Exam_request_date) {
		setAttrVal("Exam_request_date", Exam_request_date);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getSamp_bar_code() {
		return ((String) getAttrVal("Samp_bar_code"));
	}	
	/**
	 * 标本号
	 * @param Samp_bar_code
	 */
	public void setSamp_bar_code(String Samp_bar_code) {
		setAttrVal("Samp_bar_code", Samp_bar_code);
	}
	/**
	 * 标本类别编码
	 * @return String
	 */
	public String getSamp_type() {
		return ((String) getAttrVal("Samp_type"));
	}	
	/**
	 * 标本类别编码
	 * @param Samp_type
	 */
	public void setSamp_type(String Samp_type) {
		setAttrVal("Samp_type", Samp_type);
	}
	/**
	 * 标本要求
	 * @return String
	 */
	public String getSamp_content() {
		return ((String) getAttrVal("Samp_content"));
	}	
	/**
	 * 标本要求
	 * @param Samp_content
	 */
	public void setSamp_content(String Samp_content) {
		setAttrVal("Samp_content", Samp_content);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getExam_exec_date() {
		return ((FDateTime) getAttrVal("Exam_exec_date"));
	}	
	/**
	 * 执行时间
	 * @param Exam_exec_date
	 */
	public void setExam_exec_date(FDateTime Exam_exec_date) {
		setAttrVal("Exam_exec_date", Exam_exec_date);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExec_unit() {
		return ((String) getAttrVal("Exec_unit"));
	}	
	/**
	 * 执行科室名称
	 * @param Exec_unit
	 */
	public void setExec_unit(String Exec_unit) {
		setAttrVal("Exec_unit", Exec_unit);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getSqd_deptcode() {
		return ((String) getAttrVal("Sqd_deptcode"));
	}	
	/**
	 * 执行科室编码
	 * @param Sqd_deptcode
	 */
	public void setSqd_deptcode(String Sqd_deptcode) {
		setAttrVal("Sqd_deptcode", Sqd_deptcode);
	}
	/**
	 * 申请注意事项
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 申请注意事项
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 集成平台服务分类服务
	 * @return String
	 */
	public String getIemsgca_code() {
		return ((String) getAttrVal("Iemsgca_code"));
	}	
	/**
	 * 集成平台服务分类服务
	 * @param Iemsgca_code
	 */
	public void setIemsgca_code(String Iemsgca_code) {
		setAttrVal("Iemsgca_code", Iemsgca_code);
	}
	/**
	 * 集成平台服务分类名称
	 * @return String
	 */
	public String getIemsgca_name() {
		return ((String) getAttrVal("Iemsgca_name"));
	}	
	/**
	 * 集成平台服务分类名称
	 * @param Iemsgca_name
	 */
	public void setIemsgca_name(String Iemsgca_name) {
		setAttrVal("Iemsgca_name", Iemsgca_name);
	}
	/**
	 * 集成消息类型名称
	 * @return String
	 */
	public String getIemsgca_typename() {
		return ((String) getAttrVal("Iemsgca_typename"));
	}	
	/**
	 * 集成消息类型名称
	 * @param Iemsgca_typename
	 */
	public void setIemsgca_typename(String Iemsgca_typename) {
		setAttrVal("Iemsgca_typename", Iemsgca_typename);
	}
}
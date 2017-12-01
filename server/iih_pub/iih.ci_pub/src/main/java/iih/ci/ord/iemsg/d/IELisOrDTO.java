package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE检验申请信息DTO DTO数据 
 * 
 */
public class IELisOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检验申请主键标识
	 * @return String
	 */
	public String getId_ielisor() {
		return ((String) getAttrVal("Id_ielisor"));
	}	
	/**
	 * IE检验申请主键标识
	 * @param Id_ielisor
	 */
	public void setId_ielisor(String Id_ielisor) {
		setAttrVal("Id_ielisor", Id_ielisor);
	}
	/**
	 * IE检验申请就诊
	 * @return String
	 */
	public String getId_ielisoren() {
		return ((String) getAttrVal("Id_ielisoren"));
	}	
	/**
	 * IE检验申请就诊
	 * @param Id_ielisoren
	 */
	public void setId_ielisoren(String Id_ielisoren) {
		setAttrVal("Id_ielisoren", Id_ielisoren);
	}
	/**
	 * IE检验申请项目集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_ielisoritms() {
		return ((FArrayList2) getAttrVal("Id_ielisoritms"));
	}	
	/**
	 * IE检验申请项目集合
	 * @param Id_ielisoritms
	 */
	public void setId_ielisoritms(FArrayList2 Id_ielisoritms) {
		setAttrVal("Id_ielisoritms", Id_ielisoritms);
	}
	/**
	 * 检验申请单编号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}	
	/**
	 * 检验申请单编号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 医嘱类别编码
	 * @return String
	 */
	public String getOrdertype() {
		return ((String) getAttrVal("Ordertype"));
	}	
	/**
	 * 医嘱类别编码
	 * @param Ordertype
	 */
	public void setOrdertype(String Ordertype) {
		setAttrVal("Ordertype", Ordertype);
	}
	/**
	 * 医嘱类别名称
	 * @return String
	 */
	public String getOrdername() {
		return ((String) getAttrVal("Ordername"));
	}	
	/**
	 * 医嘱类别名称
	 * @param Ordername
	 */
	public void setOrdername(String Ordername) {
		setAttrVal("Ordername", Ordername);
	}
	/**
	 * 检验申请日期
	 * @return FDateTime
	 */
	public FDateTime getApplydate() {
		return ((FDateTime) getAttrVal("Applydate"));
	}	
	/**
	 * 检验申请日期
	 * @param Applydate
	 */
	public void setApplydate(FDateTime Applydate) {
		setAttrVal("Applydate", Applydate);
	}
	/**
	 * 是否隐私
	 * @return String
	 */
	public String getPrivacy() {
		return ((String) getAttrVal("Privacy"));
	}	
	/**
	 * 是否隐私
	 * @param Privacy
	 */
	public void setPrivacy(String Privacy) {
		setAttrVal("Privacy", Privacy);
	}
	/**
	 * 报告备注类型
	 * @return String
	 */
	public String getReportremark_type() {
		return ((String) getAttrVal("Reportremark_type"));
	}	
	/**
	 * 报告备注类型
	 * @param Reportremark_type
	 */
	public void setReportremark_type(String Reportremark_type) {
		setAttrVal("Reportremark_type", Reportremark_type);
	}
	/**
	 * 报告备注
	 * @return String
	 */
	public String getReportremark() {
		return ((String) getAttrVal("Reportremark"));
	}	
	/**
	 * 报告备注
	 * @param Reportremark
	 */
	public void setReportremark(String Reportremark) {
		setAttrVal("Reportremark", Reportremark);
	}
	/**
	 * 诊断类别（冗余）
	 * @return String
	 */
	public String getDiag_type() {
		return ((String) getAttrVal("Diag_type"));
	}	
	/**
	 * 诊断类别（冗余）
	 * @param Diag_type
	 */
	public void setDiag_type(String Diag_type) {
		setAttrVal("Diag_type", Diag_type);
	}
	/**
	 * 疾病代码（冗余）
	 * @return String
	 */
	public String getDiag_code() {
		return ((String) getAttrVal("Diag_code"));
	}	
	/**
	 * 疾病代码（冗余）
	 * @param Diag_code
	 */
	public void setDiag_code(String Diag_code) {
		setAttrVal("Diag_code", Diag_code);
	}
	/**
	 * 疾病名称（冗余）
	 * @return String
	 */
	public String getDiag_name() {
		return ((String) getAttrVal("Diag_name"));
	}	
	/**
	 * 疾病名称（冗余）
	 * @param Diag_name
	 */
	public void setDiag_name(String Diag_name) {
		setAttrVal("Diag_name", Diag_name);
	}
}
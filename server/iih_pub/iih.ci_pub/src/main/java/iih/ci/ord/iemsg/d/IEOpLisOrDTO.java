package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检验申请信息DTO DTO数据 
 * 
 */
public class IEOpLisOrDTO extends BaseDTO {
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
	public String getJy_applyserial1() {
		return ((String) getAttrVal("Jy_applyserial1"));
	}	
	/**
	 * 检验申请单编号
	 * @param Jy_applyserial1
	 */
	public void setJy_applyserial1(String Jy_applyserial1) {
		setAttrVal("Jy_applyserial1", Jy_applyserial1);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getOrder_type() {
		return ((String) getAttrVal("Order_type"));
	}	
	/**
	 * 医嘱类型
	 * @param Order_type
	 */
	public void setOrder_type(String Order_type) {
		setAttrVal("Order_type", Order_type);
	}
	/**
	 * 医嘱类型名称
	 * @return String
	 */
	public String getOrder_type_name() {
		return ((String) getAttrVal("Order_type_name"));
	}	
	/**
	 * 医嘱类型名称
	 * @param Order_type_name
	 */
	public void setOrder_type_name(String Order_type_name) {
		setAttrVal("Order_type_name", Order_type_name);
	}
	/**
	 * 检验申请日期
	 * @return FDateTime
	 */
	public FDateTime getApply_date() {
		return ((FDateTime) getAttrVal("Apply_date"));
	}	
	/**
	 * 检验申请日期
	 * @param Apply_date
	 */
	public void setApply_date(FDateTime Apply_date) {
		setAttrVal("Apply_date", Apply_date);
	}
	/**
	 * 是否隐私
	 * @return String
	 */
	public String getIs_private() {
		return ((String) getAttrVal("Is_private"));
	}	
	/**
	 * 是否隐私
	 * @param Is_private
	 */
	public void setIs_private(String Is_private) {
		setAttrVal("Is_private", Is_private);
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
	/**
	 * 疾病代码（冗余）
	 * @return String
	 */
	public String getDiag_str() {
		return ((String) getAttrVal("Diag_str"));
	}	
	/**
	 * 疾病代码（冗余）
	 * @param Diag_str
	 */
	public void setDiag_str(String Diag_str) {
		setAttrVal("Diag_str", Diag_str);
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
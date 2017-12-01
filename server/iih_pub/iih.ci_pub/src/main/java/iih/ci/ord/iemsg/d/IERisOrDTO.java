package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE检查申请信息DTO DTO数据 
 * 
 */
public class IERisOrDTO extends BaseDTO {
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
	 * @return FArrayList2
	 */
	public FArrayList2 getId_ierisoritms() {
		return ((FArrayList2) getAttrVal("Id_ierisoritms"));
	}	
	/**
	 * IE检查申请项目集合
	 * @param Id_ierisoritms
	 */
	public void setId_ierisoritms(FArrayList2 Id_ierisoritms) {
		setAttrVal("Id_ierisoritms", Id_ierisoritms);
	}
	/**
	 * 检查申请单编号
	 * @return String
	 */
	public String getSqd_jccode() {
		return ((String) getAttrVal("Sqd_jccode"));
	}	
	/**
	 * 检查申请单编号
	 * @param Sqd_jccode
	 */
	public void setSqd_jccode(String Sqd_jccode) {
		setAttrVal("Sqd_jccode", Sqd_jccode);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getSqd_ordertypecode() {
		return ((String) getAttrVal("Sqd_ordertypecode"));
	}	
	/**
	 * 医嘱类型
	 * @param Sqd_ordertypecode
	 */
	public void setSqd_ordertypecode(String Sqd_ordertypecode) {
		setAttrVal("Sqd_ordertypecode", Sqd_ordertypecode);
	}
	/**
	 * 医嘱类型名称
	 * @return String
	 */
	public String getSqd_ordertypename() {
		return ((String) getAttrVal("Sqd_ordertypename"));
	}	
	/**
	 * 医嘱类型名称
	 * @param Sqd_ordertypename
	 */
	public void setSqd_ordertypename(String Sqd_ordertypename) {
		setAttrVal("Sqd_ordertypename", Sqd_ordertypename);
	}
	/**
	 * 申请单详细内容
	 * @return String
	 */
	public String getSqd_sqddetail() {
		return ((String) getAttrVal("Sqd_sqddetail"));
	}	
	/**
	 * 申请单详细内容
	 * @param Sqd_sqddetail
	 */
	public void setSqd_sqddetail(String Sqd_sqddetail) {
		setAttrVal("Sqd_sqddetail", Sqd_sqddetail);
	}
	/**
	 * 检查申请日期
	 * @return FDateTime
	 */
	public FDateTime getSqd_sqddate() {
		return ((FDateTime) getAttrVal("Sqd_sqddate"));
	}	
	/**
	 * 检查申请日期
	 * @param Sqd_sqddate
	 */
	public void setSqd_sqddate(FDateTime Sqd_sqddate) {
		setAttrVal("Sqd_sqddate", Sqd_sqddate);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getSqd_bbh() {
		return ((String) getAttrVal("Sqd_bbh"));
	}	
	/**
	 * 标本号
	 * @param Sqd_bbh
	 */
	public void setSqd_bbh(String Sqd_bbh) {
		setAttrVal("Sqd_bbh", Sqd_bbh);
	}
	/**
	 * 标本类别编码
	 * @return String
	 */
	public String getSqd_bbhtype() {
		return ((String) getAttrVal("Sqd_bbhtype"));
	}	
	/**
	 * 标本类别编码
	 * @param Sqd_bbhtype
	 */
	public void setSqd_bbhtype(String Sqd_bbhtype) {
		setAttrVal("Sqd_bbhtype", Sqd_bbhtype);
	}
	/**
	 * 标本要求
	 * @return String
	 */
	public String getSqd_bbyq() {
		return ((String) getAttrVal("Sqd_bbyq"));
	}	
	/**
	 * 标本要求
	 * @param Sqd_bbyq
	 */
	public void setSqd_bbyq(String Sqd_bbyq) {
		setAttrVal("Sqd_bbyq", Sqd_bbyq);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getSqd_zxsj() {
		return ((FDateTime) getAttrVal("Sqd_zxsj"));
	}	
	/**
	 * 执行时间
	 * @param Sqd_zxsj
	 */
	public void setSqd_zxsj(FDateTime Sqd_zxsj) {
		setAttrVal("Sqd_zxsj", Sqd_zxsj);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getSqd_deptname() {
		return ((String) getAttrVal("Sqd_deptname"));
	}	
	/**
	 * 执行科室名称
	 * @param Sqd_deptname
	 */
	public void setSqd_deptname(String Sqd_deptname) {
		setAttrVal("Sqd_deptname", Sqd_deptname);
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
	public String getSqd_sqzysx() {
		return ((String) getAttrVal("Sqd_sqzysx"));
	}	
	/**
	 * 申请注意事项
	 * @param Sqd_sqzysx
	 */
	public void setSqd_sqzysx(String Sqd_sqzysx) {
		setAttrVal("Sqd_sqzysx", Sqd_sqzysx);
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
package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE医嘱撤销和停止信息DTO DTO数据 
 * 
 */
public class IEOrCancStpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE医嘱撤销和停止主键标识
	 * @return String
	 */
	public String getId_ieorcancstp() {
		return ((String) getAttrVal("Id_ieorcancstp"));
	}	
	/**
	 * IE医嘱撤销和停止主键标识
	 * @param Id_ieorcancstp
	 */
	public void setId_ieorcancstp(String Id_ieorcancstp) {
		setAttrVal("Id_ieorcancstp", Id_ieorcancstp);
	}
	/**
	 * IE医嘱撤销和停止就诊
	 * @return String
	 */
	public String getId_ieorcancstpen() {
		return ((String) getAttrVal("Id_ieorcancstpen"));
	}	
	/**
	 * IE医嘱撤销和停止就诊
	 * @param Id_ieorcancstpen
	 */
	public void setId_ieorcancstpen(String Id_ieorcancstpen) {
		setAttrVal("Id_ieorcancstpen", Id_ieorcancstpen);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}	
	/**
	 * 医嘱号
	 * @param Orderno
	 */
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	/**
	 * 医嘱的类型编码
	 * @return String
	 */
	public String getOrdertype() {
		return ((String) getAttrVal("Ordertype"));
	}	
	/**
	 * 医嘱的类型编码
	 * @param Ordertype
	 */
	public void setOrdertype(String Ordertype) {
		setAttrVal("Ordertype", Ordertype);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getBbno() {
		return ((String) getAttrVal("Bbno"));
	}	
	/**
	 * 标本号
	 * @param Bbno
	 */
	public void setBbno(String Bbno) {
		setAttrVal("Bbno", Bbno);
	}
	/**
	 * 撤销或停止时间
	 * @return FDateTime
	 */
	public FDateTime getCanceltime() {
		return ((FDateTime) getAttrVal("Canceltime"));
	}	
	/**
	 * 撤销或停止时间
	 * @param Canceltime
	 */
	public void setCanceltime(FDateTime Canceltime) {
		setAttrVal("Canceltime", Canceltime);
	}
	/**
	 * 撤销或停止人编码
	 * @return String
	 */
	public String getCancelpersoncode() {
		return ((String) getAttrVal("Cancelpersoncode"));
	}	
	/**
	 * 撤销或停止人编码
	 * @param Cancelpersoncode
	 */
	public void setCancelpersoncode(String Cancelpersoncode) {
		setAttrVal("Cancelpersoncode", Cancelpersoncode);
	}
	/**
	 * 撤销或停止人姓名
	 * @return String
	 */
	public String getCancelpersonname() {
		return ((String) getAttrVal("Cancelpersonname"));
	}	
	/**
	 * 撤销或停止人姓名
	 * @param Cancelpersonname
	 */
	public void setCancelpersonname(String Cancelpersonname) {
		setAttrVal("Cancelpersonname", Cancelpersonname);
	}
	/**
	 * 医嘱撤消原因
	 * @return String
	 */
	public String getYz_cancel_yy() {
		return ((String) getAttrVal("Yz_cancel_yy"));
	}	
	/**
	 * 医嘱撤消原因
	 * @param Yz_cancel_yy
	 */
	public void setYz_cancel_yy(String Yz_cancel_yy) {
		setAttrVal("Yz_cancel_yy", Yz_cancel_yy);
	}
	/**
	 * 互斥医嘱号
	 * @return String
	 */
	public String getHc_order_no() {
		return ((String) getAttrVal("Hc_order_no"));
	}	
	/**
	 * 互斥医嘱号
	 * @param Hc_order_no
	 */
	public void setHc_order_no(String Hc_order_no) {
		setAttrVal("Hc_order_no", Hc_order_no);
	}
	/**
	 * 互斥医嘱类别编码
	 * @return String
	 */
	public String getHc_order_type_no() {
		return ((String) getAttrVal("Hc_order_type_no"));
	}	
	/**
	 * 互斥医嘱类别编码
	 * @param Hc_order_type_no
	 */
	public void setHc_order_type_no(String Hc_order_type_no) {
		setAttrVal("Hc_order_type_no", Hc_order_type_no);
	}
	/**
	 * 互斥医嘱类别名称
	 * @return String
	 */
	public String getHc_order_type_name() {
		return ((String) getAttrVal("Hc_order_type_name"));
	}	
	/**
	 * 互斥医嘱类别名称
	 * @param Hc_order_type_name
	 */
	public void setHc_order_type_name(String Hc_order_type_name) {
		setAttrVal("Hc_order_type_name", Hc_order_type_name);
	}
	/**
	 * 项目序号
	 * @return String
	 */
	public String getSequence_number() {
		return ((String) getAttrVal("Sequence_number"));
	}	
	/**
	 * 项目序号
	 * @param Sequence_number
	 */
	public void setSequence_number(String Sequence_number) {
		setAttrVal("Sequence_number", Sequence_number);
	}
}
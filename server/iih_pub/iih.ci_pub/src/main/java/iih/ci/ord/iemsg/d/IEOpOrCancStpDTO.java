package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊医嘱撤销和停止信息DTO DTO数据 
 * 
 */
public class IEOpOrCancStpDTO extends BaseDTO {
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
	public String getOrder_id() {
		return ((String) getAttrVal("Order_id"));
	}	
	/**
	 * 医嘱号
	 * @param Order_id
	 */
	public void setOrder_id(String Order_id) {
		setAttrVal("Order_id", Order_id);
	}
	/**
	 * 医嘱的类型编码
	 * @return String
	 */
	public String getOrder_type() {
		return ((String) getAttrVal("Order_type"));
	}	
	/**
	 * 医嘱的类型编码
	 * @param Order_type
	 */
	public void setOrder_type(String Order_type) {
		setAttrVal("Order_type", Order_type);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getSample_no() {
		return ((String) getAttrVal("Sample_no"));
	}	
	/**
	 * 标本号
	 * @param Sample_no
	 */
	public void setSample_no(String Sample_no) {
		setAttrVal("Sample_no", Sample_no);
	}
	/**
	 * 撤销或停止时间
	 * @return FDateTime
	 */
	public FDateTime getCancel_date() {
		return ((FDateTime) getAttrVal("Cancel_date"));
	}	
	/**
	 * 撤销或停止时间
	 * @param Cancel_date
	 */
	public void setCancel_date(FDateTime Cancel_date) {
		setAttrVal("Cancel_date", Cancel_date);
	}
	/**
	 * 撤销或停止人编码
	 * @return String
	 */
	public String getCancel_opera() {
		return ((String) getAttrVal("Cancel_opera"));
	}	
	/**
	 * 撤销或停止人编码
	 * @param Cancel_opera
	 */
	public void setCancel_opera(String Cancel_opera) {
		setAttrVal("Cancel_opera", Cancel_opera);
	}
	/**
	 * 撤销或停止人姓名
	 * @return String
	 */
	public String getCancel_opera_name() {
		return ((String) getAttrVal("Cancel_opera_name"));
	}	
	/**
	 * 撤销或停止人姓名
	 * @param Cancel_opera_name
	 */
	public void setCancel_opera_name(String Cancel_opera_name) {
		setAttrVal("Cancel_opera_name", Cancel_opera_name);
	}
	/**
	 * 医嘱撤消原因
	 * @return String
	 */
	public String getCancel_reason() {
		return ((String) getAttrVal("Cancel_reason"));
	}	
	/**
	 * 医嘱撤消原因
	 * @param Cancel_reason
	 */
	public void setCancel_reason(String Cancel_reason) {
		setAttrVal("Cancel_reason", Cancel_reason);
	}
	/**
	 * 互斥医嘱号
	 * @return String
	 */
	public String getMutex_order_no() {
		return ((String) getAttrVal("Mutex_order_no"));
	}	
	/**
	 * 互斥医嘱号
	 * @param Mutex_order_no
	 */
	public void setMutex_order_no(String Mutex_order_no) {
		setAttrVal("Mutex_order_no", Mutex_order_no);
	}
	/**
	 * 互斥医嘱类别编码
	 * @return String
	 */
	public String getMutex_order_type() {
		return ((String) getAttrVal("Mutex_order_type"));
	}	
	/**
	 * 互斥医嘱类别编码
	 * @param Mutex_order_type
	 */
	public void setMutex_order_type(String Mutex_order_type) {
		setAttrVal("Mutex_order_type", Mutex_order_type);
	}
	/**
	 * 互斥医嘱类别名称
	 * @return String
	 */
	public String getMutex_order_name() {
		return ((String) getAttrVal("Mutex_order_name"));
	}	
	/**
	 * 互斥医嘱类别名称
	 * @param Mutex_order_name
	 */
	public void setMutex_order_name(String Mutex_order_name) {
		setAttrVal("Mutex_order_name", Mutex_order_name);
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
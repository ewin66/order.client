package iih.ci.ord.dto.orderpandectemrdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 总览显示病历信息 DTO数据 
 * 
 */
public class OrderPandectEmrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getOrderpandectemr_id() {
		return ((String) getAttrVal("Orderpandectemr_id"));
	}
	/**
	 * 主键
	 * @param Orderpandectemr_id
	 */
	public void setOrderpandectemr_id(String Orderpandectemr_id) {
		setAttrVal("Orderpandectemr_id", Orderpandectemr_id);
	}
	/**
	 * 主诉
	 * @return String
	 */
	public String getMainsuit_name() {
		return ((String) getAttrVal("Mainsuit_name"));
	}
	/**
	 * 主诉
	 * @param Mainsuit_name
	 */
	public void setMainsuit_name(String Mainsuit_name) {
		setAttrVal("Mainsuit_name", Mainsuit_name);
	}
	/**
	 * 主诉的值
	 * @return String
	 */
	public String getMainsuit_value() {
		return ((String) getAttrVal("Mainsuit_value"));
	}
	/**
	 * 主诉的值
	 * @param Mainsuit_value
	 */
	public void setMainsuit_value(String Mainsuit_value) {
		setAttrVal("Mainsuit_value", Mainsuit_value);
	}
	/**
	 * 现病史
	 * @return String
	 */
	public String getNewillnes_name() {
		return ((String) getAttrVal("Newillnes_name"));
	}
	/**
	 * 现病史
	 * @param Newillnes_name
	 */
	public void setNewillnes_name(String Newillnes_name) {
		setAttrVal("Newillnes_name", Newillnes_name);
	}
	/**
	 * 现病史值
	 * @return String
	 */
	public String getNewillnes_value() {
		return ((String) getAttrVal("Newillnes_value"));
	}
	/**
	 * 现病史值
	 * @param Newillnes_value
	 */
	public void setNewillnes_value(String Newillnes_value) {
		setAttrVal("Newillnes_value", Newillnes_value);
	}
	/**
	 * 既往史
	 * @return String
	 */
	public String getHistoryillnes_name() {
		return ((String) getAttrVal("Historyillnes_name"));
	}
	/**
	 * 既往史
	 * @param Historyillnes_name
	 */
	public void setHistoryillnes_name(String Historyillnes_name) {
		setAttrVal("Historyillnes_name", Historyillnes_name);
	}
	/**
	 * 既往史值
	 * @return String
	 */
	public String getHistoryillnes_value() {
		return ((String) getAttrVal("Historyillnes_value"));
	}
	/**
	 * 既往史值
	 * @param Historyillnes_value
	 */
	public void setHistoryillnes_value(String Historyillnes_value) {
		setAttrVal("Historyillnes_value", Historyillnes_value);
	}
	/**
	 * 体格检查
	 * @return String
	 */
	public String getPhysical_name() {
		return ((String) getAttrVal("Physical_name"));
	}
	/**
	 * 体格检查
	 * @param Physical_name
	 */
	public void setPhysical_name(String Physical_name) {
		setAttrVal("Physical_name", Physical_name);
	}
	/**
	 * 体格检查值
	 * @return String
	 */
	public String getPhysical_value() {
		return ((String) getAttrVal("Physical_value"));
	}
	/**
	 * 体格检查值
	 * @param Physical_value
	 */
	public void setPhysical_value(String Physical_value) {
		setAttrVal("Physical_value", Physical_value);
	}
	/**
	 * 一般检查
	 * @return String
	 */
	public String getCommonly_name() {
		return ((String) getAttrVal("Commonly_name"));
	}
	/**
	 * 一般检查
	 * @param Commonly_name
	 */
	public void setCommonly_name(String Commonly_name) {
		setAttrVal("Commonly_name", Commonly_name);
	}
	/**
	 * 一般检查值
	 * @return String
	 */
	public String getCommonly_value() {
		return ((String) getAttrVal("Commonly_value"));
	}
	/**
	 * 一般检查值
	 * @param Commonly_value
	 */
	public void setCommonly_value(String Commonly_value) {
		setAttrVal("Commonly_value", Commonly_value);
	}
}
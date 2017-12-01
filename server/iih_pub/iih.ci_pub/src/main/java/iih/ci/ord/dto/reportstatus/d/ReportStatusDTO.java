package iih.ci.ord.dto.reportstatus.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 报告状态回写 DTO数据 
 * 
 */
public class ReportStatusDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getRpt_status() {
		return ((String) getAttrVal("Rpt_status"));
	}
	/**
	 * 状态
	 * @param Status
	 */
	public void setRpt_status(String Rpt_status) {
		setAttrVal("Rpt_status", Rpt_status);
	}
	/**
	 * 报告类型
	 * @return Integer
	 */
	public Integer getRpt_tp() {
		return ((Integer) getAttrVal("Rpt_tp"));
	}
	/**
	 * 报告类型
	 * @param Rpt_tp
	 */
	public void setRpt_tp(Integer Rpt_tp) {
		setAttrVal("Rpt_tp", Rpt_tp);
	}
}
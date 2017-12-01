package iih.ci.ord.dto.orderhelppatientpast.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class OrderHelppatientPastDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 门急诊开始时间
	 * @return String
	 */
	public String getOp_start_dt() {
		return ((String) getAttrVal("Op_start_dt"));
	}
	/**
	 * 门急诊开始时间
	 * @param Op_start_dt
	 */
	public void setOp_start_dt(String Op_start_dt) {
		setAttrVal("Op_start_dt", Op_start_dt);
	}
	/**
	 * 门急诊结束时间
	 * @return String
	 */
	public String getOp_end_dt() {
		return ((String) getAttrVal("Op_end_dt"));
	}
	/**
	 * 门急诊结束时间
	 * @param Op_end_dt
	 */
	public void setOp_end_dt(String Op_end_dt) {
		setAttrVal("Op_end_dt", Op_end_dt);
	}
	/**
	 * 住院开始时间
	 * @return String
	 */
	public String getIp_start_dt() {
		return ((String) getAttrVal("Ip_start_dt"));
	}
	/**
	 * 住院开始时间
	 * @param Ip_start_dt
	 */
	public void setIp_start_dt(String Ip_start_dt) {
		setAttrVal("Ip_start_dt", Ip_start_dt);
	}
	/**
	 * 住院结束时间
	 * @return String
	 */
	public String getIp_end_dt() {
		return ((String) getAttrVal("Ip_end_dt"));
	}
	/**
	 * 住院结束时间
	 * @param Ip_end_dt
	 */
	public void setIp_end_dt(String Ip_end_dt) {
		setAttrVal("Ip_end_dt", Ip_end_dt);
	}
	/**
	 * 显示的患者参数
	 * @return String
	 */
	public String getDisplay_parameters() {
		return ((String) getAttrVal("Display_parameters"));
	}
	/**
	 * 显示的患者参数
	 * @param Display_parameters
	 */
	public void setDisplay_parameters(String Display_parameters) {
		setAttrVal("Display_parameters", Display_parameters);
	}
}
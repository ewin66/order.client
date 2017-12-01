package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import iih.bd.srv.ortpl.d.OrTplDO;

import java.util.List;

/**
 * 医嘱模板医疗服务查询参数dto
 * 
 */
public class OrtplDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	
	
	public String getExcludeSd_srvtp() {
		return ((String) getAttrVal("ExcludeSd_srvtp"));
	}
	
	public void setExcludeSd_srvtp(String ExcludeSd_srvtp) {
		setAttrVal("ExcludeSd_srvtp", ExcludeSd_srvtp);
	}
	
	
	public String getStrWhere() {
		return ((String) getAttrVal("StrWhere"));
	}
	
	public void setStrWhere(String StrWhere) {
		setAttrVal("StrWhere", StrWhere);
	}
	
	public OrTplDO getModel() {
		return ((OrTplDO) getAttrVal("Model"));
	}
	
	public void setModel(OrTplDO Model) {
		setAttrVal("Model", Model);
	}
	
	
	public String getHealthca() {
		return ((String) getAttrVal("Healthca"));
	}
	
	public void setHealthca(String Healthca) {
		setAttrVal("Healthca", Healthca);
	}
	
}
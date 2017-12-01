package iih.ci.ord.dto.opdispensecond.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊发药患者查询条件DTO DTO数据 
 * 
 */
public class OpDispenseCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getCard_code() {
		return ((String) getAttrVal("Card_code"));
	}	
	public void setCard_code(String Card_code) {
		setAttrVal("Card_code", Card_code);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getPat_pycode() {
		return ((String) getAttrVal("Pat_pycode"));
	}	
	public void setPat_pycode(String Pat_pycode) {
		setAttrVal("Pat_pycode", Pat_pycode);
	}
	public FDateTime getDt_charge_start() {
		return ((FDateTime) getAttrVal("Dt_charge_start"));
	}	
	public void setDt_charge_start(FDateTime Dt_charge_start) {
		setAttrVal("Dt_charge_start", Dt_charge_start);
	}
	public FDateTime getDt_charge_end() {
		return ((FDateTime) getAttrVal("Dt_charge_end"));
	}	
	public void setDt_charge_end(FDateTime Dt_charge_end) {
		setAttrVal("Dt_charge_end", Dt_charge_end);
	}
	public FBoolean getFg_herb() {
		return ((FBoolean) getAttrVal("Fg_herb"));
	}	
	public void setFg_herb(FBoolean Fg_herb) {
		setAttrVal("Fg_herb", Fg_herb);
	}

	
}
package iih.ci.ord.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;

public class LabDTO extends BaseDTO{
	
	
	

	public String getId_rptlab() {
		return ((String) getAttrVal("Id_rptlab"));
	}
	public void setId_rptlab(String Id_rptlab) {
		setAttrVal("Id_rptlab", Id_rptlab);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getVal_rstrptlab() {
		return ((String) getAttrVal("Val_rstrptlab"));
	}
	public void setVal_rstrptlab(String Val_rstrptlab) {
		setAttrVal("Val_rstrptlab", Val_rstrptlab);
	}
	
	public String getSd_restrptlabtp() {
		return ((String) getAttrVal("Sd_restrptlabtp"));
	}
	public void setSd_restrptlabtp(String Sd_restrptlabtp) {
		setAttrVal("Sd_restrptlabtp", Sd_restrptlabtp);
	}
	public FDateTime getDt_rptlab() {
		return ((FDateTime) getAttrVal("Dt_rptlab"));
	}
	public void setDt_rptlab(FDateTime Dt_rptlab) {
		setAttrVal("Dt_rptlab", Dt_rptlab);
	}
	
	

}

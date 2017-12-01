package iih.ci.mr.cimrvt.d;

import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.core.data.BaseDTO;

public class VitalSignSave extends BaseDTO {
	
	public CiMrDO getCimrDO(){
		return ((CiMrDO) getAttrVal("CimrDO"));
	}
	public void setCimrDO(CiMrDO CimrDO) {
		setAttrVal("CimrDO", CimrDO);
	}
	
	public CimrvtAggDO getAggDO(){
		return ((CimrvtAggDO) getAttrVal("AggDO"));
	}
	public void setAggDO(CimrvtAggDO AggDO) {
		setAttrVal("AggDO", AggDO);
	}
	
	
}
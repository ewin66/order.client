package iih.ci.ord.cior.d;

import iih.ci.ord.ciorder.d.CiorderAggDO;
/*
 * 门诊签署会话与其包含的医嘱数据对象
 */
public class OrAggAndSessionDO {
	private CiorderAggDO[] oraggs;
	private CiOrSessionDO orsession;
	public CiorderAggDO[] getOraggs() {
		return oraggs;
	}
	public void setOraggs(CiorderAggDO[] oraggs) {
		this.oraggs = oraggs;
	}
	public CiOrSessionDO getOrsession() {
		return orsession;
	}
	public void setOrsession(CiOrSessionDO orsession) {
		this.orsession = orsession;
	}
	
	
}

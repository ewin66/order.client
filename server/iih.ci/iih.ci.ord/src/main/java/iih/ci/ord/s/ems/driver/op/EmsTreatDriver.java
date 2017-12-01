package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.treat.EmsTreatAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 治疗医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsTreatDriver extends OrderEmsBaseDriver {

	
	public EmsTreatDriver(){
		this.setEmsAction(new EmsTreatAction());
//		this.setOrderAction(new OrderTreatAction());
	}

}

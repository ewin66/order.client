package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsTreatAction;
import iih.ci.ord.s.ems.biz.ip.OrderTreatAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院治疗医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsTreatDriver extends OrderEmsBaseDriver {
	public OrderEmsTreatDriver(){
		this.setEmsAction(new EmsTreatAction());
		this.setOrderAction(new OrderTreatAction());
	}
}

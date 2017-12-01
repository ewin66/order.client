package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsOutOfHospAction;
import iih.ci.ord.s.ems.biz.ip.OrderOutOfHospAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;
/**
 * 住院出院医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsOutOfHospDriver extends OrderEmsBaseDriver {
	public OrderEmsOutOfHospDriver(){
		this.setEmsAction(new EmsOutOfHospAction());
		this.setOrderAction(new OrderOutOfHospAction());
	}
}

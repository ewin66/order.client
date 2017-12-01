package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsApBuAction;
import iih.ci.ord.s.ems.biz.ip.OrderApBuAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院备血医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsApBuDriver extends OrderEmsBaseDriver {
	public OrderEmsApBuDriver(){
		this.setEmsAction(new EmsApBuAction());
		this.setOrderAction(new OrderApBuAction());
	}
}

package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsApBtAction;
import iih.ci.ord.s.ems.biz.ip.OrderApBtAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院用血医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsApBtDriver extends OrderEmsBaseDriver {
	
	public OrderEmsApBtDriver(){
		this.setEmsAction(new EmsApBtAction());
		this.setOrderAction(new OrderApBtAction());
	}

}

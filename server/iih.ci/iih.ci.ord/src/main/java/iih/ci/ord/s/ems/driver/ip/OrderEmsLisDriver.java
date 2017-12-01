package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsLisAction;
import iih.ci.ord.s.ems.biz.ip.OrderLisAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院检验医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsLisDriver extends OrderEmsBaseDriver {
	public OrderEmsLisDriver(){
		this.setEmsAction(new EmsLisAction());
		this.setOrderAction(new OrderLisAction());
	}
}

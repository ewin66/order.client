package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsPathgyAction;
import iih.ci.ord.s.ems.biz.ip.OrderPathgyAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院病理医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsPathgyDriver extends OrderEmsBaseDriver {
	public OrderEmsPathgyDriver(){
		this.setEmsAction(new EmsPathgyAction());
		this.setOrderAction(new OrderPathgyAction());
	}
}

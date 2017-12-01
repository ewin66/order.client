package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsHerbsAction;
import iih.ci.ord.s.ems.biz.ip.OrderHerbsAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院草药医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsHerbsDriver extends OrderEmsBaseDriver {
	public OrderEmsHerbsDriver(){
		this.setEmsAction(new EmsHerbsAction());
		this.setOrderAction(new OrderHerbsAction());
	}
}

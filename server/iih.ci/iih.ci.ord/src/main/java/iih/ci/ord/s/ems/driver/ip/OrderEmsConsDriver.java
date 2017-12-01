package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsConsAction;
import iih.ci.ord.s.ems.biz.ip.OrderConsAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院医嘱医疗单会诊驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsConsDriver extends OrderEmsBaseDriver {
	public OrderEmsConsDriver(){
		this.setEmsAction(new EmsConsAction());
		this.setOrderAction(new OrderConsAction());
	}
}

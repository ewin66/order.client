package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsDeadAction;
import iih.ci.ord.s.ems.biz.ip.OrderDeadAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院死亡医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsDeadDriver extends OrderEmsBaseDriver {
	public OrderEmsDeadDriver(){
		this.setEmsAction(new EmsDeadAction());
		this.setOrderAction(new OrderDeadAction());
	}
}

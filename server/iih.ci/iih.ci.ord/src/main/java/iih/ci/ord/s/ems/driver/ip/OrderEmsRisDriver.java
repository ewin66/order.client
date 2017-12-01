package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsRisAction;
import iih.ci.ord.s.ems.biz.ip.OrderRisAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院检查医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsRisDriver extends OrderEmsBaseDriver {
	public OrderEmsRisDriver(){
		this.setEmsAction(new EmsRisAction());
		this.setOrderAction(new OrderRisAction());
	}
}

package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsTransDeptAction;
import iih.ci.ord.s.ems.biz.ip.OrderTransDeptAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院转科医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsTransDeptDriver extends OrderEmsBaseDriver {
	public OrderEmsTransDeptDriver(){
		this.setEmsAction(new EmsTransDeptAction());
		this.setOrderAction(new OrderTransDeptAction());
	}
}

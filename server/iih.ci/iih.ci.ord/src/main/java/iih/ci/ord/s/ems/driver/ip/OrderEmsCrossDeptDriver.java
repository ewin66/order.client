package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsCrossDeptAction;
import iih.ci.ord.s.ems.biz.ip.OrderCrossDeptAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院医嘱医疗单跨科驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsCrossDeptDriver extends OrderEmsBaseDriver {
	public OrderEmsCrossDeptDriver(){
		this.setEmsAction(new EmsCrossDeptAction());
		this.setOrderAction(new OrderCrossDeptAction());
	}
}

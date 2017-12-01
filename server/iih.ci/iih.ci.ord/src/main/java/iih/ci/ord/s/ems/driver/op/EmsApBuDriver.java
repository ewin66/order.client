package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.apbu.EmsApBuAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 备血医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsApBuDriver extends OrderEmsBaseDriver {

	
	public EmsApBuDriver(){
		this.setEmsAction(new EmsApBuAction());
//		this.setOrderAction(new OrderApBuAction());
	}

}

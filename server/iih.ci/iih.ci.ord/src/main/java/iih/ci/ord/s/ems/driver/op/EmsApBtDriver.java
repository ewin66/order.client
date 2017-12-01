package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.apbt.EmsApBtAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 用血医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsApBtDriver extends OrderEmsBaseDriver  {

	
	public EmsApBtDriver(){
		this.setEmsAction(new EmsApBtAction());
		//this.setOrderAction(new OrderApBtAction());
	}

}

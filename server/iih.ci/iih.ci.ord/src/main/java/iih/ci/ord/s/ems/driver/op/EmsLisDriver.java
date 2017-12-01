package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.lis.EmsLisAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 检验医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsLisDriver extends OrderEmsBaseDriver {

	
	public EmsLisDriver(){
		this.setEmsAction(new EmsLisAction());
//		this.setOrderAction(new OrderLisAction());
	}
	
}

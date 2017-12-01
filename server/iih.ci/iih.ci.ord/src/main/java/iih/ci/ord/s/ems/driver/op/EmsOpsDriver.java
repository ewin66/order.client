package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.opr.EmsOpsAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 手术医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsOpsDriver extends OrderEmsBaseDriver{
	
	
	public EmsOpsDriver(){
		this.setEmsAction(new EmsOpsAction());
//		this.setOrderAction(new OrderOprAction());
	}
	
}

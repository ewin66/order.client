package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.pathgy.EmsPathgyAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 会诊医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsPathgyDriver extends OrderEmsBaseDriver {

	
	public EmsPathgyDriver(){
		this.setEmsAction(new EmsPathgyAction());
//		this.setOrderAction(new OrderPathgyAction());
	}
	
}

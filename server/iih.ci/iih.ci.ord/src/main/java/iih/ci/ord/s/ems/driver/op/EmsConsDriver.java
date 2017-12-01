package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.cons.EmsConsAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 会诊医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsConsDriver extends OrderEmsBaseDriver {

	
	public EmsConsDriver(){
		this.setEmsAction(new EmsConsAction());
//		this.setOrderAction(new OrderConsAction());
	}
	
	
}

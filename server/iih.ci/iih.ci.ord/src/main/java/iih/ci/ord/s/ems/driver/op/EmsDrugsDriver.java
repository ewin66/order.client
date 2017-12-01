package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.drugs.EmsDrugsAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 门诊药品医疗单
 * @author wangqingzhu
 *
 */
public class EmsDrugsDriver extends OrderEmsBaseDriver {
	
	
	public EmsDrugsDriver(){
		this.setEmsAction(new EmsDrugsAction());
//		this.setOrderAction(new OrderDrugsAction());
	}
	
}

package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.ris.EmsRisAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 检查医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsRisDriver extends OrderEmsBaseDriver {

	
	public EmsRisDriver(){
		this.setEmsAction(new EmsRisAction());
//		this.setOrderAction(new OrderRisAction());
	}
	
}

package iih.ci.ord.s.ems.driver.op;

import iih.ci.ord.s.ems.biz.op.ems.herbs.EmsHerbsAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 草药医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsHerbsDriver extends OrderEmsBaseDriver {

	
	public EmsHerbsDriver(){
		this.setEmsAction(new EmsHerbsAction());
//		this.setOrderAction(new OrderHerbsAction());
	}
	
	
}

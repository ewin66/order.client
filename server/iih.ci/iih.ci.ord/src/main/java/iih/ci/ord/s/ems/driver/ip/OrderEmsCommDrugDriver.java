package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsCommDrugAction;
import iih.ci.ord.s.ems.biz.ip.OrderCommDrugAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院普药医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsCommDrugDriver extends OrderEmsBaseDriver {
	public OrderEmsCommDrugDriver(){
		this.setEmsAction(new EmsCommDrugAction());
		this.setOrderAction(new OrderCommDrugAction());
	}
}

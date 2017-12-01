package iih.ci.ord.s.ems.driver.ip;

import iih.ci.ord.s.ems.biz.ip.EmsInjDrugAction;
import iih.ci.ord.s.ems.biz.ip.OrderInjDrugAction;
import iih.ci.ord.s.ems.driver.base.OrderEmsBaseDriver;

/**
 * 住院注射用药医嘱医疗单驱动
 * @author wangqingzhu
 *
 */
public class OrderEmsInjDrugDriver extends OrderEmsBaseDriver {
	public OrderEmsInjDrugDriver(){
		this.setEmsAction(new EmsInjDrugAction());
		this.setOrderAction(new OrderInjDrugAction());
	}
}

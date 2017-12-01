package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱作废业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderCancelBP {
	/**
	 * 作废医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO cancel(OrderOperateDTO arg) throws BizException;
}

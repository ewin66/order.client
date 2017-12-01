package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱撤回业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderRevertBP {
	/**
	 * 撤回医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO revert(OrderOperateDTO arg) throws BizException;
	
}

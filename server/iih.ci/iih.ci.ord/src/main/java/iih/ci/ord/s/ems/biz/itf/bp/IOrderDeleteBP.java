package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱删除业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderDeleteBP {
	/**
	 * 删除医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO delete(OrderOperateDTO arg) throws BizException;
}

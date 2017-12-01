package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱另存为业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderSaveAsBP {
	/**
	 * 另存为医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO saveAs(OrderOperateDTO arg) throws BizException;
}

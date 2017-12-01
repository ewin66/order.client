package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱加载业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderLoadBP {
	/**
	 * 从医嘱加载医疗单
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO load(OrderOperateDTO arg) throws BizException;
}

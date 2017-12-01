package iih.ci.ord.i.ems;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import xap.mw.core.data.BizException;

public interface ICiOrderReadService {
	/**
	 * 从医嘱加载医疗单
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO load(OrderOperateDTO arg) throws BizException;
}

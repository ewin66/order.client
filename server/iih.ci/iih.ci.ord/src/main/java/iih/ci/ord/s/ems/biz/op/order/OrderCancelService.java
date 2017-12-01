package iih.ci.ord.s.ems.biz.op.order;

import xap.mw.core.data.BizException;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderCancelBP;
import iih.ci.ord.s.ems.biz.op.order.bp.OrderCancelBP;

public class OrderCancelService implements IOrderCancelBP {

	private IOrderCancelBP bp = new OrderCancelBP();

	@Override
	public OrderRstDTO cancel(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return bp.cancel(arg);
	}

}

package iih.ci.ord.s.ems.biz.op.order;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.OrderCopyBP;
import xap.mw.core.data.BizException;

public class OrderCopyService implements IOrderCopyBP {

	private IOrderCopyBP orderCopyBp = new OrderCopyBP();
	@Override
	public OrderRstDTO copy(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCopyBp.copy(arg);
	}

}

package iih.ci.ord.s.ems.biz.op.order;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderDeleteBP;
import iih.ci.ord.s.ems.biz.op.order.bp.OrderDeleteBP;
import xap.mw.core.data.BizException;

public class OrderDeleteService implements IOrderDeleteBP {

	private IOrderDeleteBP orderDeleteBP = new OrderDeleteBP();
	@Override
	public OrderRstDTO delete(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderDeleteBP.delete(arg);
	}

}

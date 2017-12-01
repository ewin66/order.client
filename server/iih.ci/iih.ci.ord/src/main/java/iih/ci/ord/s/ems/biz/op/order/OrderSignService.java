package iih.ci.ord.s.ems.biz.op.order;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderSignBP;
import iih.ci.ord.s.ems.biz.op.order.bp.OrderSignBP;
import xap.mw.core.data.BizException;

public class OrderSignService implements IOrderSignBP {

	private IOrderSignBP orderSignBP = new OrderSignBP();
	@Override
	public OrderRstDTO sign(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSignBP.sign(arg);
	}

}

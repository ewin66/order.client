package iih.ci.ord.s.ems.biz.op.order;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderRevertBP;
import iih.ci.ord.s.ems.biz.op.order.bp.OrderRevertBP;
import xap.mw.core.data.BizException;

public class OrderRevertService implements IOrderRevertBP {

	private IOrderRevertBP orderRevertBP = new OrderRevertBP();
	@Override
	public OrderRstDTO revert(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderRevertBP.revert(arg);
	}

}

package iih.ci.ord.s.ems.biz.op.order;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderLoadBP;
import iih.ci.ord.s.ems.biz.op.order.bp.OrderLoadBP;
import xap.mw.core.data.BizException;

public class OrderLoadService implements IOrderLoadBP{

	private IOrderLoadBP orderLoadBP = new OrderLoadBP();
	@Override
	public OrderRstDTO load(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderLoadBP.load(arg);
	}

	

}

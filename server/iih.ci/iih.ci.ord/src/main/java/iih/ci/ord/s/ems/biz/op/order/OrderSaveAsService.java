package iih.ci.ord.s.ems.biz.op.order;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderSaveAsBP;
import iih.ci.ord.s.ems.biz.op.order.bp.OrderSaveAsBP;
import xap.mw.core.data.BizException;

public class OrderSaveAsService implements IOrderSaveAsBP {

	private IOrderSaveAsBP orderSaveAsBP = new OrderSaveAsBP();
	@Override
	public OrderRstDTO saveAs(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSaveAsBP.saveAs(arg);
	}

}

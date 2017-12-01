package iih.ci.ord.s.ems.biz.base;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.i.ems.ICiOrderMainService;
import iih.ci.ord.s.ems.biz.op.order.OrderCancelService;
import iih.ci.ord.s.ems.biz.op.order.OrderCopyService;
import iih.ci.ord.s.ems.biz.op.order.OrderDeleteService;
import iih.ci.ord.s.ems.biz.op.order.OrderLoadService;
import iih.ci.ord.s.ems.biz.op.order.OrderRevertService;
import iih.ci.ord.s.ems.biz.op.order.OrderSaveAsService;
import iih.ci.ord.s.ems.biz.op.order.OrderSignService;
import xap.mw.core.data.BizException;

public class CiOrderBaseMainService implements ICiOrderMainService {
	private OrderLoadService orderLoadService = new OrderLoadService();
	private OrderSignService orderSignService =  new OrderSignService();
	private OrderDeleteService orderDeleteService = new OrderDeleteService();
	private OrderRevertService orderRevertService = new OrderRevertService();
	private OrderCancelService orderCancelService = new OrderCancelService();
	private OrderCopyService orderCopyService = new OrderCopyService();
	private OrderSaveAsService orderSaveAsService = new OrderSaveAsService();


	@Override
	public OrderRstDTO delete(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderDeleteService.delete(arg);
	}

	@Override
	public OrderRstDTO sign(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSignService.sign(arg);
	}

	@Override
	public OrderRstDTO revert(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderRevertService.revert(arg);
	}

	@Override
	public OrderRstDTO cancel(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCancelService.cancel(arg);
	}

	@Override
	public OrderRstDTO copy(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCopyService.copy(arg);
	}

	@Override
	public OrderRstDTO saveAs(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSaveAsService.saveAs(arg);
	}

	@Override
	public OrderRstDTO load(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderLoadService.load(arg);
	}

}

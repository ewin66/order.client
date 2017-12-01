package iih.ci.ord.s.ems;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.i.ems.ICiOrderMainService;
import iih.ci.ord.s.ems.biz.base.CiOrderBaseMainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
/**
 * 医嘱相关主服务
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiOrderMainService.class }, binding = Binding.JSONRPC)
public class CiOrderMainServiceImpl extends CiOrderBaseMainService {

	@Override
	public OrderRstDTO load(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return super.load(arg);
	}

	@Override
	public OrderRstDTO delete(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return super.delete(arg);
	}

	@Override
	public OrderRstDTO sign(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return super.sign(arg);
	}

	@Override
	public OrderRstDTO revert(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return super.revert(arg);
	}

	@Override
	public OrderRstDTO cancel(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return super.cancel(arg);
	}

	@Override
	public OrderRstDTO copy(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return super.copy(arg);
	}

	@Override
	public OrderRstDTO saveAs(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return super.saveAs(arg);
	}
	
	
	
	
}

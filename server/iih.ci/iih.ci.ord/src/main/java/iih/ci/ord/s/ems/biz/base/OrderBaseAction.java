package iih.ci.ord.s.ems.biz.base;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.s.ems.biz.itf.IOrderAction;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderCopyBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderDeleteBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderLoadBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderRevertBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderSaveAsBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderSaveFeeBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderSignBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 
 * @author wangqingzhu
 *
 */
public class OrderBaseAction implements IOrderAction{
	private IOrderLoadBP orderLoadBP ;
	private IOrderSignBP orderSignBP;
	private IOrderDeleteBP orderDeleteBP;
	private IOrderRevertBP orderRevertBP;
	private IOrderSaveAsBP orderSaveAsBP;
	private IOrderCopyBP orderCopyBP;
	private IOrderSaveFeeBP orderSaveFeeBP;
	
	

	
	public IOrderLoadBP getOrderLoadBP() {
		return orderLoadBP;
	}
	public void setOrderLoadBP(IOrderLoadBP orderLoadBP) {
		this.orderLoadBP = orderLoadBP;
	}
	public IOrderSignBP getOrderSignBP() {
		return orderSignBP;
	}
	public void setOrderSignBP(IOrderSignBP orderSignBP) {
		this.orderSignBP = orderSignBP;
	}
	public IOrderDeleteBP getOrderDeleteBP() {
		return orderDeleteBP;
	}
	public void setOrderDeleteBP(IOrderDeleteBP orderDeleteBP) {
		this.orderDeleteBP = orderDeleteBP;
	}
	public IOrderRevertBP getOrderRevertBP() {
		return orderRevertBP;
	}
	public void setOrderRevertBP(IOrderRevertBP orderRevertBP) {
		this.orderRevertBP = orderRevertBP;
	}
	public IOrderSaveAsBP getOrderSaveAsBP() {
		return orderSaveAsBP;
	}
	public void setOrderSaveAsBP(IOrderSaveAsBP orderSaveAsBP) {
		this.orderSaveAsBP = orderSaveAsBP;
	}
	public IOrderCopyBP getOrderCopyBP() {
		return orderCopyBP;
	}
	public void setOrderCopyBP(IOrderCopyBP orderCopyBP) {
		this.orderCopyBP = orderCopyBP;
	}
	public IOrderSaveFeeBP getOrderSaveFeeBP() {
		return orderSaveFeeBP;
	}
	public void setOrderSaveFeeBP(IOrderSaveFeeBP orderSaveFeeBP) {
		this.orderSaveFeeBP = orderSaveFeeBP;
	}
	@Override
	public OrderRstDTO load(OrderOperateDTO arg) throws BizException{
		// TODO Auto-generated method stub
		return  orderLoadBP.load(arg);
	}
	/**
	 * 查询 MedSrvAggDO对象结构
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	protected MedsrvAggDO queryMedSrvAggInfo(String id_srv) throws BizException{
		return ServiceFinder.find(IMedsrvRService.class).findById(id_srv);
	}
	

	@Override
	public OrderRstDTO delete(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderDeleteBP.delete(arg);
	}

	@Override
	public OrderRstDTO sign(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSignBP.sign(arg);
	}

	@Override
	public OrderRstDTO revert(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderRevertBP.revert(arg);
	}

	@Override
	public OrderRstDTO copy(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCopyBP.copy(arg);
	}

	@Override
	public OrderRstDTO saveAs(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSaveAsBP.saveAs(arg);
	}
	@Override
	public OrderRstDTO cancel(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

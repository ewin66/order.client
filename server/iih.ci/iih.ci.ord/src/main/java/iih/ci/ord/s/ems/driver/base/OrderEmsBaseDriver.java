package iih.ci.ord.s.ems.driver.base;

import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.d.ems.tmpl.TmplLoadDTO;
import iih.ci.ord.d.ems.tmpl.TmplRstDTO;
import iih.ci.ord.d.ems.tmpl.TmplSaveDTO;
import iih.ci.ord.s.ems.biz.itf.IEmsAction;
import iih.ci.ord.s.ems.biz.itf.IOrderAction;
import iih.ci.ord.s.ems.biz.itf.ITmplAction;
import xap.mw.core.data.BizException;

/**
 * 医疗单数据驱动基类
 * @author wangqingzhu
 *
 */
public class OrderEmsBaseDriver implements IOrderEmsDriver {
	
	private IEmsAction emsAction = null;
	private IOrderAction orderAction = null;
	private ITmplAction tmplAction = null;
	

	public IEmsAction getEmsAction() {
		return emsAction;
	}

	public void setEmsAction(IEmsAction emsAction) {
		this.emsAction = emsAction;
	}

	public IOrderAction getOrderAction() {
		return orderAction;
	}

	public void setOrderAction(IOrderAction orderAction) {
		this.orderAction = orderAction;
	}

	@Override
	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.load(args);
	}

	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.create(emsarray);
	}

	@Override
	public EmsRstDTO save(EmsSaveDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return emsAction.save(ems);
	}

	@Override
	public OrderRstDTO delete(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderAction.delete(arg);
	}

	@Override
	public OrderRstDTO sign(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderAction.sign(arg);
	}

	@Override
	public OrderRstDTO revert(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderAction.revert(arg);
	}

	@Override
	public OrderRstDTO cancel(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderAction.cancel(arg);
	}

	@Override
	public OrderRstDTO copy(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderAction.copy(arg);
	}

	@Override
	public OrderRstDTO saveAs(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderAction.saveAs(arg);
	}

	@Override
	public OrderRstDTO load(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderAction.load(arg);
	}

	public ITmplAction getTmplAction() {
		return tmplAction;
	}

	public void setTmplAction(ITmplAction tmplAction) {
		this.tmplAction = tmplAction;
	}

	@Override
	public TmplRstDTO load(TmplLoadDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return tmplAction.load(arg);
	}

	@Override
	public TmplRstDTO save(TmplSaveDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return tmplAction.save(arg);
	}

	
}

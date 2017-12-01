package iih.ci.ord.s.ems.biz.itf;

import iih.ci.ord.s.ems.biz.itf.bp.IOrderCancelBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderCopyBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderDeleteBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderLoadBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderRevertBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderSaveAsBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderSaveFeeBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderSignBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderStopBP;

/**
 * 医嘱执行器接口
 * @author wangqingzhu
 *
 */
public interface IOrderAction extends IOrderLoadBP, IOrderDeleteBP, IOrderSignBP, IOrderRevertBP, IOrderCopyBP,
		IOrderSaveAsBP, IOrderCancelBP, IOrderStopBP,IOrderSaveFeeBP {

}

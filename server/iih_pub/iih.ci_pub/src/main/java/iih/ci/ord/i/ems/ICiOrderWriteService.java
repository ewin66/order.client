package iih.ci.ord.i.ems;

import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import xap.mw.core.data.BizException;

public interface ICiOrderWriteService  {
	
	
	
	/**
	 * 删除医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO delete(OrderOperateDTO arg) throws BizException;
	
	/**
	 * 签署医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO sign(OrderOperateDTO arg) throws BizException;
	
	/**
	 * 撤回医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO revert(OrderOperateDTO arg) throws BizException;
	
	/**
	 * 作废医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO cancel(OrderOperateDTO arg) throws BizException;
	
	/**
	 * 拷贝医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO copy(OrderOperateDTO arg) throws BizException;
	
	/**
	 * 另存为医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO saveAs(OrderOperateDTO arg) throws BizException;
}

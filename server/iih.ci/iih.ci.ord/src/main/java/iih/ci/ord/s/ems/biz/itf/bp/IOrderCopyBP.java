package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱拷贝业务逻辑
 * @author wangqingzhu
 *
 */
public interface IOrderCopyBP {
	/**
	 * 拷贝医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO copy(OrderOperateDTO arg) throws BizException;
}

package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;

/**
 * 处理医保信息
 * @author wangqingzhu
 *
 */
public interface IOrderHpInfoBP {

	/**
	 * 处理医嘱层面的医保信息
	 * @param ctx
	 * @param orderInfo
	 * @return
	 */
	public abstract boolean handleOrderHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo);
	
	/**
	 * 处理服务层面的医保信息
	 * @param ctx
	 * @param szSrvInfo
	 * @return
	 */
	public abstract boolean handleSrvHpInfo(CiEnContextDTO ctx, OrderSrvMmList szSrvInfo);
	
	/**
	 * 医保信息处理完成之后，其他处理
	 * @param ctx
	 * @param szSrvInfo
	 * @return
	 */
	public abstract boolean afterHandleHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] szSrvInfo);
}

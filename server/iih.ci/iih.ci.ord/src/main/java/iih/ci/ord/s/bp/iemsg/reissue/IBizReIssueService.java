package iih.ci.ord.s.bp.iemsg.reissue;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.s.bp.iemsg.reissue.dto.ReissueMsgDTO;
import xap.ip.reissue.BS023Param;
import xap.mw.core.data.BizException;

/**
 * 获取集成平台补发数据接口
 * 
 * @author HUMS
 *
 */
public interface IBizReIssueService {

	/**
	 * 获取医嘱信息集合
	 * 
	 * @param param
	 * @return
	 */
	public CiOrderDO[] getCiOrders(BS023Param param) throws BizException;

	/**
	 * 获取返回给集成平台的数据对象集合
	 * 
	 * @param ciorders
	 * @return
	 * @throws BizException 
	 */
	public ReissueMsgDTO[] getIEEventDTO( CiOrderDO[] ciorders) throws BizException;
}

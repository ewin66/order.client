package iih.ci.ord.i;

import iih.ci.ord.dto.orderverify.d.OrderVerifyCondDTO;
import iih.ci.ord.dto.orderverify.d.OrderVerifyDTO;
import iih.ci.ord.dto.orderverify.d.OrderVerifyPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱审核服务接口
 * @author ly
 *
 */
public interface ICiOrdVerifyService {
		
	/**
	 * 门诊医嘱审核检索患者医嘱
	 * @param cond 检索条件
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public abstract OrderVerifyPatDTO[] getVerifyPat(OrderVerifyCondDTO cond) throws BizException;
	
	/**
	 * 通过医嘱id检索医嘱信息
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	public abstract OrderVerifyDTO[] getPatOrderByIds(String idOrs) throws BizException;
	
	/**
	 * 系统自动审核医嘱
	 * @param orderIds
	 * @return 系统审核信息
	 * @throws BizException
	 */
	public abstract OrderVerifyDTO[] verifyOrderBySys(String[] orderIds) throws BizException;

	/**
	 * 医嘱审核确认
	 * @param orders
	 * @throws BizException
	 */
	public abstract void verifyOrder(OrderVerifyDTO[] orders) throws BizException;
	
	/**
	 * 医生核对异常医嘱
	 * @param ordId
	 * @param ifAccept
	 * @param explain
	 * @throws BizException
	 */
	public abstract void confirmVerifyResult(String ordId, FBoolean ifAccept, String explain) throws BizException;

	/**
	 * 审核状态
	 */
	public static final String VERIFY_STATE_NOT = "0";
	public static final String VERIFY_STATE_HAS = "1";
	public static final String VERIFY_STATE_FORCE = "2";
}

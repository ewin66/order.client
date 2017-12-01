package iih.ci.ord.s;

import iih.ci.ord.dto.orderverify.d.OrderVerifyCondDTO;
import iih.ci.ord.dto.orderverify.d.OrderVerifyDTO;
import iih.ci.ord.dto.orderverify.d.OrderVerifyPatDTO;
import iih.ci.ord.i.ICiOrdVerifyService;
import iih.ci.ord.s.bp.ordverify.ConfirmVerifyResultBP;
import iih.ci.ord.s.bp.ordverify.GetOpPatOrderBP;
import iih.ci.ord.s.bp.ordverify.GetOrderByIdsBP;
import iih.ci.ord.s.bp.ordverify.VerifyOrderBP;
import iih.ci.ord.s.bp.ordverify.VerifyOrderBySysBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱审核服务
 * @author ly
 *
 */
@Service(serviceInterfaces={ICiOrdVerifyService.class}, binding=Binding.JSONRPC)
public class CiOrdVerifyServiceImpl implements ICiOrdVerifyService {

	/**
	 * 医嘱审核检索患者列表
	 * @param cond 检索条件
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrderVerifyPatDTO[] getVerifyPat(OrderVerifyCondDTO cond) throws BizException{
		GetOpPatOrderBP bp = new GetOpPatOrderBP();
		return bp.exec(cond);
	}
	
	/**
	 * 通过医嘱id检索医嘱信息
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrderVerifyDTO[] getPatOrderByIds(String idOrs) throws BizException{
		GetOrderByIdsBP bp = new GetOrderByIdsBP();
		return bp.exec(idOrs);
	}
	
	/**
	 * 系统自动审核医嘱
	 * @param orderIds
	 * @return 系统审核信息
	 * @throws BizException
	 */
	@Override
	public OrderVerifyDTO[] verifyOrderBySys(String[] orderIds) throws BizException {
		VerifyOrderBySysBP bp = new VerifyOrderBySysBP();
		return bp.exec(orderIds);
	}

	/**
	 * 医嘱审核确认
	 * @param orders
	 * @throws BizException
	 */
	@Override
	public void verifyOrder(OrderVerifyDTO[] orders) throws BizException {
		VerifyOrderBP bp = new VerifyOrderBP();
		bp.exec(orders);
	}

	/**
	 * 医生核对异常医嘱
	 * @param ordId
	 * @param ifAccept
	 * @param explain
	 * @throws BizException
	 */
	@Override
	public void confirmVerifyResult(String ordId,FBoolean ifAccept,String explain) throws BizException{
		ConfirmVerifyResultBP bp = new ConfirmVerifyResultBP();
		bp.exec(ordId, ifAccept, explain);
	}
}

package iih.ci.ord.s.bp.ordverify;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.s.CiorderMDOCrudServiceImpl;
import iih.ci.ord.dto.orderverify.d.OrderVerifyStateEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 核对异常医嘱
 * @author ly
 *
 */
public class ConfirmVerifyResultBP {

	/**
	 * 核对异常医嘱
	 * @param ordId
	 * @param ifAccept
	 * @param explain
	 * @throws BizException
	 */
	public void exec(String ordId,FBoolean ifAccept,String explain) throws BizException{
		
		if(FBoolean.FALSE.equals(ifAccept) && StringUtil.isEmpty(explain)){
			throw new BizException("强制执行时，需要说明理由");
		}
		
		CiorderMDOCrudServiceImpl ciorderMDOCrudService = new CiorderMDOCrudServiceImpl();
		CiOrderDO ciOrderDO = ciorderMDOCrudService.findById(ordId);
		ciOrderDO.setStatus(DOStatus.UPDATED);
		if(FBoolean.TRUE.equals(ifAccept)){
			ciOrderDO.setEu_verify_pharm(OrderVerifyStateEnum.NOTVERIFY);
			//清空上次审核结果
			ciOrderDO.setDes_verify_pharm(null);
			ciOrderDO.setId_ecep_level_pharm(null);
			ciOrderDO.setSd_excep_level_pharm(null);
			ciOrderDO.setDes_verify_sys(null);
			ciOrderDO.setId_ecep_level_sys(null);
			ciOrderDO.setSd_excep_level_sys(null);
			
		}else{
			ciOrderDO.setEu_verify_pharm(OrderVerifyStateEnum.FORCE);
		}
		ciOrderDO.setId_emp_bk_pharm(Context.get().getStuffId());
		ciOrderDO.setDt_bk_pharm(new FDateTime());
		ciOrderDO.setDes_bk_pharm(explain);
		
		ciorderMDOCrudService.update(ciOrderDO);
	}
}

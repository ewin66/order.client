package iih.ci.ord.s.bp.ordverify;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.s.CiorderMDOCrudServiceImpl;
import iih.ci.ord.dto.orderverify.d.OrderVerifyDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 医嘱审核
 * @author ly
 *
 */
public class VerifyOrderBP {

	/**
	 * 医嘱审核
	 * @param orders
	 * @throws BizException
	 */
	public void exec(OrderVerifyDTO[] orders) throws BizException {
		
		if(ArrayUtil.isEmpty(orders)){
			return;
		}
		
		List<String> ordIds = new ArrayList<String>();
		for (OrderVerifyDTO item : orders) {
			ordIds.add(item.getId_or());
		}
		
		CiorderMDOCrudServiceImpl ciorderMDOCrudService = new CiorderMDOCrudServiceImpl();
		CiOrderDO[] ciOrderDOs = ciorderMDOCrudService.findByIds(ordIds.toArray(new String[ordIds.size()]), FBoolean.FALSE);
		
		for (CiOrderDO ciOrderDO : ciOrderDOs) {
			for (OrderVerifyDTO orderDTO : orders) {
				if(!ciOrderDO.getId_or().equals(orderDTO.getId_or())){
					continue;
				}
				ciOrderDO.setStatus(DOStatus.UPDATED);
				ciOrderDO.setEu_verify_pharm(orderDTO.getEu_verify_pharm());
				ciOrderDO.setDes_verify_pharm(orderDTO.getDes_verify_pharm());
				ciOrderDO.setId_ecep_level_pharm(orderDTO.getId_excep_level_pharm());
				ciOrderDO.setSd_excep_level_pharm(orderDTO.getSd_excep_level_pharm());
				ciOrderDO.setDes_verify_sys(orderDTO.getDes_verify_sys());
				ciOrderDO.setId_ecep_level_sys(orderDTO.getId_excep_level_sys());
				ciOrderDO.setSd_excep_level_sys(orderDTO.getSd_excep_level_sys());
				ciOrderDO.setId_emp_verify_pharm(Context.get().getStuffId());
				ciOrderDO.setDt_verify_pharm(new FDateTime());
				
				break;
			}
		}
		
		ciorderMDOCrudService.update(ciOrderDOs);
	}
}

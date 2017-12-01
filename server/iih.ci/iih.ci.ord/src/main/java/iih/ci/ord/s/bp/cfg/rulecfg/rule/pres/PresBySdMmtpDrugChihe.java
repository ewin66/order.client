package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据药品类型生成处方<br>
 * 中草药处方（药品类型为中草药）
 * 
 * @author HUMS
 *
 */
public class PresBySdMmtpDrugChihe extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdMmDictCodeConst.SD_MMTP_DRUG_CHIHE.equals(orderPresSplit.getSd_mmtp())) {
			return true;
		}
		return false;
	}
	
	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {
		
		return orderPresSplit.getId_or();
	}


}

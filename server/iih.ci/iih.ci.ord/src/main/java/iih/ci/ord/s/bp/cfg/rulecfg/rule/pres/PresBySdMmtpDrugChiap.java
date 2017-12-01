package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据药品类型生成处方<br>
 * 中成药处方（药品类型为中成药）
 * 
 * @author HUMS
 *
 */
public class PresBySdMmtpDrugChiap extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdMmDictCodeConst.SD_MMTP_DRUG_CHIPA.equals(orderPresSplit.getSd_mmtp())) {
			return true;
		}
		return false;
	}

}

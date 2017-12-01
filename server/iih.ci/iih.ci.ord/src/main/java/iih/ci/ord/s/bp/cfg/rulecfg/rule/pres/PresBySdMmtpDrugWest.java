package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据药品类型生成处方<br>
 * 西药处方（药品类型为西药）
 * 
 * @author HUMS
 *
 */
public class PresBySdMmtpDrugWest extends AbstractSinglePresRuleExecutor {

	
	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdMmDictCodeConst.SD_MMTP_DRUG_WEST.equals(orderPresSplit.getSd_mmtp())) {
			return true;
		}
		return false;
	}

}

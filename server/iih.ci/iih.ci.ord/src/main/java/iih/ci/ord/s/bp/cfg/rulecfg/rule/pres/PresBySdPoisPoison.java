package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据毒麻属性生成处方<br>
 * 毒麻属性为毒性时在一个处方
 * 
 * @author HUMS
 *
 */
public class PresBySdPoisPoison extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdMmDictCodeConst.SD_POIS_POISON.equals(orderPresSplit.getSd_pois())) {
			return true;
		}
		return false;
	}

}

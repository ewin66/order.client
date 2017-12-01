package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据毒麻属性生成处方<br>
 * 毒麻属性为"二类精神药品"时在一个处方
 * 
 * @author HUMS
 *
 */
public class PresBySdPoisJing2 extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdMmDictCodeConst.SD_POIS_JINGSHEN_2.equals(orderPresSplit.getSd_pois())) {
			return true;
		}
		return false;
	}

}

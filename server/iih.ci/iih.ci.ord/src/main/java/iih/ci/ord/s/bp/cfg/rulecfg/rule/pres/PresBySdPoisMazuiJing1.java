package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据毒麻属性生成处方<br>
 * 毒麻属性为麻醉药品或一类精神药品时分配到一个处方
 * 
 * @author HUMS
 *
 */
public class PresBySdPoisMazuiJing1 extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdMmDictCodeConst.SD_POIS_MAZUI.equals(orderPresSplit.getSd_pois())
				|| IBdMmDictCodeConst.SD_POIS_JINGSHEN_1.equals(orderPresSplit.getSd_pois())) {

			return true;
		}
		return false;
	}

}

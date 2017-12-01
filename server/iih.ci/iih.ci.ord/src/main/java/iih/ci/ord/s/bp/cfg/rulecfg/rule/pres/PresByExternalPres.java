package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据是否为外配处方进行分方<br>
 * 外配处方单独成方
 * 
 * @author HUMS
 *
 */
public class PresByExternalPres extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		if (orderPresSplit.getFg_extdispense() == FBoolean.TRUE) {

			return true;
		}
		return false;
	}

}

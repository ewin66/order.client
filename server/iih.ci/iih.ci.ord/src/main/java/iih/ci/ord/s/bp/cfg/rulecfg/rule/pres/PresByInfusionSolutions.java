package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 大输液大类单独分方：当服务类型为【溶媒】时，并且不是成组医嘱时，多个溶媒合并到一起
 * 
 * @author HUMS
 *
 */
public class PresByInfusionSolutions extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY.equals(orderPresSplit.getSd_srvtp())) {
			return true;
		}
		return false;
	}
}

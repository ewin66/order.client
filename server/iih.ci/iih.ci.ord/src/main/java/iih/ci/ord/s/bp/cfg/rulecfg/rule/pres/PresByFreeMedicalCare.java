package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据是否为公费医疗进行分方<br>
 * 保险类别是公费医疗时单独成方
 * 
 * @author HUMS
 *
 */
public class PresByFreeMedicalCare extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		// 判断是否为公费医疗
		if (IBdPpCodeTypeConst.SD_HP_BJ_KIND_PUBLIC_EXPENSE.equals(orderPresSplit.getCode_hpkind())) {
			return true;
		}
		return false;
	}

}

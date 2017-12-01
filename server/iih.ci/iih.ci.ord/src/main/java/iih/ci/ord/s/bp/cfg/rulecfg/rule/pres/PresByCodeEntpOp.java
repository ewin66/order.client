package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据就诊类型生成处方<br>
 * 门诊处方（就诊类型为门诊）
 * 
 * @author HUMS
 *
 */
public class PresByCodeEntpOp extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(orderPresSplit.getCode_entp())) {
			return true;
		}
		return false;
	}

}

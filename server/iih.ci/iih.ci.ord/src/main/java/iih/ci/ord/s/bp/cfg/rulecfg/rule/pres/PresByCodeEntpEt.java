package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据就诊类型生成处方<br>
 * 急诊处方（就诊类型为急诊）
 * 
 * @author HUMS
 *
 */
public class PresByCodeEntpEt extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(orderPresSplit.getCode_entp())) {
			return true;
		}
		return false;
	}

}

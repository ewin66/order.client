package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;

/**
 * 超量开单原因 - 行动不便<br>
 * 默认最大 开药天数 14 天
 * 
 * @author HUMS
 *
 */
public class ExcessiveReasonInconvenientValidator extends AbstractExcessiveDrugValidator {

	@Override
	protected String getExcessiveReasonIdentity() {
		// 行动不便
		return ICiDictCodeConst.ID_EXCESSIVE_REASON_INCONVENIENCE;
	}

	@Override
	protected String getExcessiveReasonMsg() {
		return "行动不便";
	}

	@Override
	protected int getDefaultUseDays() {
		return 14;
	}

	@Override
	protected boolean isConformToTheRules(EmsDrugItemDO t) {

		return true;
	}

}

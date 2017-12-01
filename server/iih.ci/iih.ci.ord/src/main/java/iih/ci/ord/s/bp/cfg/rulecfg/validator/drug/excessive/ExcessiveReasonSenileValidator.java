package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;

/**
 * 超量开单原因 - 老年病<br>
 * 默认最大 开药天数 30 天
 * 
 * @author HUMS
 *
 */
public class ExcessiveReasonSenileValidator extends AbstractExcessiveDrugValidator {

	@Override
	protected String getExcessiveReasonIdentity() {

		//老年病
		return ICiDictCodeConst.ID_EXCESSIVE_REASON_SENILE;
	}

	@Override
	protected String getExcessiveReasonMsg() {
		return "老年病";
	}

	@Override
	protected int getDefaultUseDays() {
		return 30;
	}

	@Override
	protected boolean isConformToTheRules(EmsDrugItemDO t) {
		// TODO Auto-generated method stub
		return true;
	}

}

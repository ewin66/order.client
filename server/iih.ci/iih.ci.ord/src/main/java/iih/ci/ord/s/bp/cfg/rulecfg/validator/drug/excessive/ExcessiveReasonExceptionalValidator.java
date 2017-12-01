package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;

/**
 * 超量开单原因 - 特殊情况<br>
 * 默认最大 开药天数 30 天
 * 
 * @author HUMS
 *
 */
public class ExcessiveReasonExceptionalValidator extends AbstractExcessiveDrugValidator {

	@Override
	protected String getExcessiveReasonIdentity() {
		//特殊情况
		return ICiDictCodeConst.ID_EXCESSIVE_REASON_EXCEPTIONAL;
	}

	@Override
	protected String getExcessiveReasonMsg() {
		// TODO Auto-generated method stub
		return "特殊情况";
	}

	@Override
	protected int getDefaultUseDays() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	protected boolean isConformToTheRules(EmsDrugItemDO t) {
		// TODO Auto-generated method stub
		return true;
	}

}

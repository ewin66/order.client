package iih.ci.ord.pub.listener;

import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 护理等级医嘱签署护士核对侦听器抽象类
 */
public class NsGradeOrCheckListener extends AbstractOrCheckListener {
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现

	}
	
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为护理等级医嘱判断
		if (CiOrderTypeEnum.NSGRADEORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}
}

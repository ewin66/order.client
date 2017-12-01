package iih.ci.ord.pub.listener;

import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 手术医嘱签署护士核对侦听器抽象类
 */
public class AllOpOrCheckListener extends AbstractOrCheckListener {
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现

	}
	
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为手术医嘱判断
		if (CiOrderTypeEnum.OPERATIONORDER.equals(CiOrPubUtils
				.getCiOrderType(or))
				|| CiOrderTypeEnum.BEDOPORDER.equals(CiOrPubUtils
						.getCiOrderType(or))
				|| CiOrderTypeEnum.ALLOPORDER.equals(CiOrPubUtils
						.getCiOrderType(or)))
			return true;
		return false;
	}
}

package iih.ci.ord.pub.listener;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;

/**
 * 下达手术医嘱侦听器插件
 * （含台次手术与床边手术医嘱）
 */
public class AllOpOrSignListener extends AbstractOrSignListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		// 在此处增加你的代码实现

	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		// 是否为台次手术医嘱或床边手术医嘱判断
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

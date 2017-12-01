package iih.ci.ord.pub.listener;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;

/**
 * 下达死亡医嘱侦听器插件
 */
public class DeathOrSignListener extends AbstractOrSignListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现

	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为死亡医嘱判断
		if (CiOrderTypeEnum.DEATHORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}
}

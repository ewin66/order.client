package iih.ci.ord.pub.listener;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 门诊医嘱签署撤销侦听器抽象类
 */
public class OrSignCancel4OpListener extends AbstractOrSignCancelListener {

	@Override
	protected void doYourActionAfterOrSignCancel(CiOrderDO[] ors)
			throws BizException {
	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为门诊医嘱判断
		if (CiOrPubUtils.isOpWf(or.getCode_entp()))
			return true;
		return false;
	}
}

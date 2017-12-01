package iih.ci.ord.pub.listener;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;

/**
 * 下达会诊医嘱侦听器插件
 */
public class ConsultOrSignListener extends AbstractOrSignListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现

	}
	
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为会诊医嘱判断
		if (CiOrderTypeEnum.CONSULTORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}

}

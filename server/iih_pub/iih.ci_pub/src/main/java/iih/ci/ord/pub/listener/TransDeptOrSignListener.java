package iih.ci.ord.pub.listener;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;

/**
 * 下达转科医嘱侦听器插件
 */
public class TransDeptOrSignListener extends AbstractOrSignListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException{
		//在此处增加你的代码实现
	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为转科医嘱判断
		if (CiOrderTypeEnum.DEPT2DEPTORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}
}

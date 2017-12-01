package iih.ci.ord.pub.listener;

import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

public class CrossDeptOrStopCheckListener extends AbstractOrStopCheckListener{

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为跨科医嘱判断
		if (CiOrderTypeEnum.CROSSDEPTORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}

	@Override
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {
		// TODO Auto-generated method stub
		
	}

	
}

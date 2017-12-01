package iih.ci.ord.pub.listener;

import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;
/**
 * 跨科医嘱作废基类
 * @author wangqingzhu
 *
 */
public class CrossDeptOrCancelCheckListener extends AbstractOrCancelCheckListener {

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为跨科医嘱判断
		if (CiOrderTypeEnum.CROSSDEPTORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}

	@Override
	protected void doYourActionAfterOrCancelCheck(CiOrderDO[] ors) throws BizException {
		// TODO Auto-generated method stub
		super.doYourActionAfterOrCancelCheck(ors);
	}

	

	
}

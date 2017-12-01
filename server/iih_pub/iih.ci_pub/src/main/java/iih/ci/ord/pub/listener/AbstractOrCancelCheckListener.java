package iih.ci.ord.pub.listener;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 医嘱作废护士核对侦听器抽象类
 */
public abstract class AbstractOrCancelCheckListener extends AbstractOrSignListener {
	@Override
	protected boolean isOrStatusCheck(CiOrderDO ordo){
		return CiOrPubUtils.isOrCancelCheck(ordo);
	}
	
	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		doYourActionAfterOrCancelCheck(ors);
	}
	
	protected void doYourActionAfterOrCancelCheck(CiOrderDO[] ors) throws BizException {
		
	}

}

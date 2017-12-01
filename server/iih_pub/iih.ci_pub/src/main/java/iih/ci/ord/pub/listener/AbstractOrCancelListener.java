package iih.ci.ord.pub.listener;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 医嘱作废侦听器抽象类
 */
public abstract class AbstractOrCancelListener extends AbstractOrSignListener {
	@Override
	protected boolean isOrStatusCheck(CiOrderDO ordo){
		return CiOrPubUtils.isOrCancel(ordo);
	}
	
	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		doYourActionAfterOrCancel(ors);
	}
	
	protected void doYourActionAfterOrCancel(CiOrderDO[] ors) throws BizException {
		
	}

}

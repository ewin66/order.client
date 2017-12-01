package iih.ci.ord.pub.listener;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 医嘱签署护士核对侦听器抽象类
 */
public abstract class AbstractOrCheckListener extends AbstractOrSignListener {
	@Override
	protected boolean isOrStatusCheck(CiOrderDO ordo){
		return CiOrPubUtils.isOrCheck(ordo);
	}
	
	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		doYourActionAfterOrCheck(ors);
	}
	
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors) throws BizException {
		
	}

}

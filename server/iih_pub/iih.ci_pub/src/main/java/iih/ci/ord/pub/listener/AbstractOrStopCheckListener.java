package iih.ci.ord.pub.listener;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 医嘱停止护士核对侦听器抽象类
 */
public abstract class AbstractOrStopCheckListener extends AbstractOrSignListener {
	@Override
	protected boolean isOrStatusCheck(CiOrderDO ordo){
		return CiOrPubUtils.isOrStopCheck(ordo);
	}
	
	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		doYourActionAfterOrStopCheck(ors);
	}
	
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {
		
	}

}

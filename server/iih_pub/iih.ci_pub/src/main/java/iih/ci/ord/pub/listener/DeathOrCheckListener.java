package iih.ci.ord.pub.listener;


import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

public class DeathOrCheckListener extends AbstractOrCheckListener{
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
   
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为死亡医嘱判断
		if (CiOrderTypeEnum.DEATHORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}
}

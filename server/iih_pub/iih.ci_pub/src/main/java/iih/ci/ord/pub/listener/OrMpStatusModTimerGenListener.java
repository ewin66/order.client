package iih.ci.ord.pub.listener;

import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱执行完成状态更新定时器生成侦听器
 * （停止核对时部署激活执行完成状态定时器）
 */
public class OrMpStatusModTimerGenListener extends AbstractOrStopCheckListener {
	@Override
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现
		
		

	}
	
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为护理等级、营养、病情医嘱判断
		if (CiOrderTypeEnum.NSGRADEORDER
				.equals(CiOrPubUtils.getCiOrderType(or))
				|| CiOrderTypeEnum.NUTRIONDIETORDER.equals(CiOrPubUtils
						.getCiOrderType(or))
				|| CiOrderTypeEnum.ILLSTATEORDER.equals(CiOrPubUtils
						.getCiOrderType(or)))
			return true;
		return false;
	}
}

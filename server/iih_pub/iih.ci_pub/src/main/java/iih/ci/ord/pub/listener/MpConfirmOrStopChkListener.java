package iih.ci.ord.pub.listener;

import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 执行确认类医嘱，护士核对停止侦听器
 * （停止核对时执行完成状态判断及修改的逻辑）
 * 非护理等级、营养、病情等类型的
 * 非  OrMpStatusModTimerGenListener 中情形
 * 
 */
public class MpConfirmOrStopChkListener extends AbstractOrStopCheckListener {
	@Override
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现

	}
	
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为非护理等级、营养、病情医嘱判断
		//OrMpStatusModTimerGenListener 中的  医嘱判断条件
		if (!(CiOrderTypeEnum.NSGRADEORDER
				.equals(CiOrPubUtils.getCiOrderType(or))
				|| CiOrderTypeEnum.NUTRIONDIETORDER.equals(CiOrPubUtils
						.getCiOrderType(or))
				|| CiOrderTypeEnum.ILLSTATEORDER.equals(CiOrPubUtils
						.getCiOrderType(or))))
			return true;
		return false;
	}
}

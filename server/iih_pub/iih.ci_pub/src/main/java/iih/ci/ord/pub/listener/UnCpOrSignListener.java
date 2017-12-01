package iih.ci.ord.pub.listener;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.pub.CiOrPubUtils;

/**
 * 入径患者，径外医嘱下达时变异原因侦听器插件
 */
public class UnCpOrSignListener extends AbstractOrSignListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现

	}
	
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为入径患者且医嘱为径外医嘱判断
		if (HpIndicJudgeEnum.JUDGED.equals(or.getEu_uncporjudge())
				&& !CiOrPubUtils.isEmpty(or.getReason_uncporuse()))
			return true;
		return false;
	}

}

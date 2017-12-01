package iih.ci.ord.pub.listener;

import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;

/**
 * 下达床边手术医嘱侦听器插件 
 * （仅含床边手术医嘱）
 */
public class BedOpOrSignListener extends AbstractOrSignListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) {
		// 在此处增加你的代码实现

	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		// 是否为床边手术医嘱判断
		if (CiOrderTypeEnum.BEDOPORDER.equals(CiOrPubUtils.getCiOrderType(or)))
			return true;
		return false;
	}

}

package iih.ci.ord.s.bp.validate;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.CiOrMPBLStatusUnNoneException;
import xap.mw.core.data.BizException;

/*
 * 门急诊签署撤回时医嘱有效性判断
 */
public class OpSignBackOrValidateBP {
	/**
	 * 门急诊签署撤回时医嘱有效性判断
	 * @param aggors
	 * @throws BizException
	 */
	public void exec(CiOrderDO[] orders) throws BizException{
		if (CiOrdUtils.isEmpty(orders))
			return;

		//遍历
		for (int i = 0; i < orders.length; i++) {
			if (!(ICiDictCodeConst.SD_SU_MP_NONE.equals(orders[i].getSd_su_mp()) && ICiDictCodeConst.SD_SU_BL_NONE
					.equals(orders[i].getSd_su_bl()))) {
				throw new CiOrMPBLStatusUnNoneException();
			}

		}
	}
}

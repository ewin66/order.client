package iih.ci.ord.s.bp.operableords;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获取允许作废的医嘱
 * @author HUMS
 *
 */
public class JudgeCancelOrderStatusBP extends JudgeBackOrderStatusBP{

	@Override
	protected List<CiOrderDO> getAllowdOrds(CiOrderDO[] orders) {

		List<CiOrderDO> orderList = new ArrayList<CiOrderDO>();
		
		for (CiOrderDO order : orders) {
			// 护士已经核对，未作废，并且医嘱不可取消为false时，允许作废
			if(order.getFg_chk() == FBoolean.TRUE && order.getFg_canc() == FBoolean.FALSE && order.getFg_uncancelable() == FBoolean.FALSE){
				orderList.add(order);
			}
		}

		return orderList;
	}
}

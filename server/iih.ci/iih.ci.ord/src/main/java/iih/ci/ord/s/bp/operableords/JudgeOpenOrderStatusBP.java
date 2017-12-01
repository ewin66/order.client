package iih.ci.ord.s.bp.operableords;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.CiOrOpenEntStatusValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 开立医嘱判断操作
 * @author zhangwq
 *
 */
public class JudgeOpenOrderStatusBP extends JudgeOrderStatusBP {

	public FMap2 exec(CiOrderDO[] orders,String id_dep_phy,String id_dep_nur) throws BizException {
		if(CiOrdUtils.isEmpty(orders)) return null;
		CiOrOpenEntStatusValidateBP bp = new CiOrOpenEntStatusValidateBP();
		bp.exec(orders[0].getCode_entp(), orders[0].getId_en(), id_dep_phy,id_dep_nur);
		return null;
	}
	@Override
	protected List<CiOrderDO> getAllowdOrds(CiOrderDO[] orders) {

		return null;
	}

	@Override
	protected String getRefusedOrdsMsg(CiOrderDO[] orders) {

		return null;
	}

	@Override
	protected List<CiOrderDO> getAllowedOrdByApObs(List<CiOrderDO> ordList) throws BizException {
		return null;
	}
	
	@Override
	protected List<CiOrderDO> getAllowedOrdByBt(List<CiOrderDO> ordList) throws BizException{
		return null;
	}
}

package iih.ci.ord.s.ems.biz.op.base.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderHpInfoBP;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;

public class HpBaseHandleBP implements IOrderHpInfoBP {

	@Override
	public boolean handleOrderHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleSrvHpInfo(CiEnContextDTO ctx, OrderSrvMmList szSrvInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean afterHandleHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] szSrvInfo) {
		// TODO Auto-generated method stub
		return false;
	}

}

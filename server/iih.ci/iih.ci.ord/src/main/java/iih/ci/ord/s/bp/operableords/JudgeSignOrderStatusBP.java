package iih.ci.ord.s.bp.operableords;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.CiOrOpenEntStatusValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获取允许签署的医嘱
 * @author HUMS
 *
 */
public class JudgeSignOrderStatusBP extends JudgeOrderStatusBP{
	@Override
	public FMap2 exec(CiOrderDO[] orders,String id_dep_phy,String id_dep_nur) throws BizException {

		ciorAppRisRService = CiOrdAppUtils.getOrapprisQryService();
		ciOrderRService = CiOrdAppUtils.getOrAggQryService();
		ciorderMRService = CiOrdAppUtils.getCiorderMDORService();
		FMap2 ordsMap = new FMap2();
		ordsMap.put(STATUS_ERROR, FBoolean.FALSE);

		CiOrderDO[] savedOrds = this.getSavedOrds(orders);
		//判断患者就诊状态
		CiOrOpenEntStatusValidateBP entBp = new CiOrOpenEntStatusValidateBP();
		entBp.exec(savedOrds[0].getCode_entp(),savedOrds[0].getId_en(),id_dep_phy,id_dep_nur);
		//判断医嘱状态是否发生改变
		if (isOrdStatusChanged(orders, savedOrds)) {
			ordsMap.put(STATUS_ERROR, FBoolean.TRUE);
			ordsMap.put(ORD_MSG, "医嘱状态发生改变，请刷新医嘱列表后重新操作！");
			return ordsMap;
		}
		
		return ordsMap;
	}
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

	@Override
	protected String getRefusedOrdsMsg(CiOrderDO[] orders) {
		return null;
	}

	@Override
	protected List<CiOrderDO> getAllowedOrdByApObs(List<CiOrderDO> ordList)
			throws BizException {
		return null;
	}

	@Override
	protected List<CiOrderDO> getAllowedOrdByBt(List<CiOrderDO> ordList)
			throws BizException {
		return null;
	}
}

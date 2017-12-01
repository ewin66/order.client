package iih.ci.ord.s.bp.operableords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获取允许执行撤回操作医嘱
 * @author HUMS
 *
 */
public class JudgeBackOrderStatusBP extends JudgeOrderStatusBP {

	@Override
	protected List<CiOrderDO> getAllowdOrds(CiOrderDO[] orders) {

		List<CiOrderDO> orderList = new ArrayList<CiOrderDO>();

		for (CiOrderDO order : orders) {
			if (ICiDictCodeConst.SD_SU_SIGN.equals(order.getSd_su_or())
					&& ICiDictCodeConst.SD_SU_BL_NONE.equals(order.getSd_su_bl()) && order.getFg_chk() == FBoolean.FALSE
					&& order.getFg_sign() == FBoolean.TRUE) {
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
	protected List<CiOrderDO> getAllowedOrdByApObs(List<CiOrderDO> ordList) throws BizException {

		if (ordList == null || ordList.size() == 0) {
			return null;
		}

		// 允许撤回的检查医嘱
		List<CiOrderDO> allowedOrdList = new ArrayList<CiOrderDO>();
		String[] ordIds = new String[ordList.size()];
		// 构造医嘱map便于处理
		Map<String, CiOrderDO> ordMap = new HashMap<String, CiOrderDO>();

		for (int i = 0; i < ordList.size(); i++) {

			CiOrderDO order = ordList.get(i);
			ordMap.put(order.getId_or(), order);
			ordIds[i] = order.getId_or();
		}

		// 获取检查申请单
		OrdApObsDO[] ordApObsDOs = ciorAppRisRService.findByAttrValStrings("Id_or", ordIds);

		//TODO 后续需要和执行闭环的状态匹配，等PO确定后此处需要调整
		// 根据检查申请单中的状态获取允许撤回的医嘱（申请单是申请状态 ）
		for (OrdApObsDO ordApObs : ordApObsDOs) {

			if (ICiDictCodeConst.SD_CI_OBS_SQ.equals(ordApObs.getSd_su_obs())
					|| ICiDictCodeConst.SD_CI_OBS_YQX.equals(ordApObs.getSd_su_obs())) {

				allowedOrdList.add(ordMap.get(ordApObs.getId_or()));
			}
		}

		return allowedOrdList;
	}
	
	@Override
	protected List<CiOrderDO> getAllowedOrdByBt(List<CiOrderDO> ordList) throws BizException{
		
		if (ordList == null || ordList.size() == 0) {
			return null;
		}

		// 查询条件
		StringBuffer whereBufer = new StringBuffer();
		// 允许撤回的备血医嘱
		List<CiOrderDO> allowedOrdList = new ArrayList<CiOrderDO>();
		String[] ordIds = new String[ordList.size()];
		// 构造医嘱map便于处理
		Map<String, CiOrderDO> ordMap = new HashMap<String, CiOrderDO>();

		for (int i = 0; i < ordList.size(); i++) {

			CiOrderDO order = ordList.get(i);
			ordMap.put(order.getId_or(), order);
			ordIds[i] = order.getId_or();
			whereBufer.append(",'"+order.getId_or() +"'");
		}

		String whereStr = "id_or_rel in (" + whereBufer.substring(1) +")  and fg_canc = 'N'";
		//
		CiOrderDO[] orders = ciorderMRService.find(whereStr, null, FBoolean.FALSE);
		
		// 删除已关联备血的用血医嘱，剩余的是可撤回的医嘱
		for (CiOrderDO ciOrder : orders) {
			if(ordMap.containsKey(ciOrder.getId_or_rel())){
				ordMap.remove(ciOrder.getId_or_rel());
			}
		}
		allowedOrdList = new ArrayList<CiOrderDO>(ordMap.values()) ;

		return allowedOrdList;
	}
}

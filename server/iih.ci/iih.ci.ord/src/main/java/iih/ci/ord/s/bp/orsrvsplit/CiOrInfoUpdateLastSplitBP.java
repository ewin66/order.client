package iih.ci.ord.s.bp.orsrvsplit;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.s.bp.qry.CiOrderSplitUpdateQry;
import iih.ci.ord.s.bp.qry.CiOrderSrvSplitUpdateQry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.lock.PKLock;

/**
 * 拆分回写医嘱最近生成时间
 * 
 * @author Administrator
 *
 */
public class CiOrInfoUpdateLastSplitBP {

	public void exec(OrSplitOrderDTO[] listOrSplitDTO, SrvSplitOrderDTO[] listSrvSplitDTO, FDateTime Dt_last_bl) throws BizException {

		// 1、非空验证
		if (listOrSplitDTO == null || listSrvSplitDTO == null || Dt_last_bl == null) {
			return;
		}

		// 2、长度验证
		if (listOrSplitDTO.length == 0 && listSrvSplitDTO.length == 0) {
			return;
		}

		// 3、获取医嘱主键集合
		HashMap<String, FDateTime> orSpecialMap = new HashMap<String, FDateTime>();
		String[] idOrKeys = getOrKeys(listOrSplitDTO, orSpecialMap);

		// 4、获取医嘱项目主键集合
		String[] idOrSrvKeys = getOrSrvKeys(listSrvSplitDTO, orSpecialMap);

		// 5、更改医嘱的最近生成时间
		updateOrder(idOrKeys, Dt_last_bl);

		// 6、更改项目的最近生成时间
		updateOrderSrv(idOrSrvKeys, Dt_last_bl);

		// 7、处理医嘱和医嘱项目的临界点(拆分的结束时间与拆分后的计划执行时间相等时：dt_mp_plan==dt_last_bl，最近生成时间默认往后加一秒)
		handelCritical(listOrSplitDTO, listSrvSplitDTO, Dt_last_bl);

		// 8、特殊医嘱指定最后拆分时间
		setSpecialLastSplit(orSpecialMap);
	}

	/**
	 * 获取医嘱ID集合
	 * 
	 * @param listOrSplitDTO
	 * @return
	 */
	private String[] getOrKeys(OrSplitOrderDTO[] listOrSplitDTO, HashMap<String, FDateTime> orMap) {

		ArrayList<String> listOr = new ArrayList<String>();

		for (OrSplitOrderDTO orderSplit : listOrSplitDTO) {

			// 药品类出院带药医嘱
			if (FBoolean.TRUE.equals(orderSplit.getFg_pres_outp()) && orderSplit.getSd_orsrvtp().indexOf(IBdSrvDictCodeConst.SD_SRVTP_DRUG) == 0) {
				orMap.put(orderSplit.getId_or(), orderSplit.getDt_end().addSeconds(1));
				continue;
			}

			if (!listOr.contains(orderSplit.getId_or())) {

				listOr.add(orderSplit.getId_or());
			}

		}
		return listOr.toArray(new String[listOr.size()]);
	}

	/**
	 * 获取医嘱ID集合
	 * 
	 * @param listOrSplitDTO
	 * @return
	 */
	private String[] getOrSrvKeys(SrvSplitOrderDTO[] listOrSrvSplitDTO, HashMap<String, FDateTime> orMap) {

		ArrayList<String> listOrSrv = new ArrayList<String>();

		for (SrvSplitOrderDTO orderSrvSplit : listOrSrvSplitDTO) {

			if (orMap.containsKey(orderSrvSplit.getId_or())) {
				continue;
			}

			if (!listOrSrv.contains(orderSrvSplit.getId_orsrv())) {

				listOrSrv.add(orderSrvSplit.getId_orsrv());
			}
		}
		return listOrSrv.toArray(new String[listOrSrv.size()]);
	}

	/**
	 * 更改医嘱的最近生成时间
	 * 
	 * @param idOrKeys
	 * @throws BizException
	 */
	private void updateOrder(String[] idOrKeys, FDateTime Dt_last_bl) throws BizException {

		if (idOrKeys != null && idOrKeys.length > 0) {

			boolean getLock = PKLock.getInstance().addBatchDynamicLock(idOrKeys);

			if (!getLock)

				throw new BizException("其他用户正锁定表CI_ORDER中的相关记录，请稍后重试!");

			CiOrderSplitUpdateQry Sql = new CiOrderSplitUpdateQry(idOrKeys, Dt_last_bl);

			new DAFacade().execUpdate(Sql.getQrySQLStr(), Sql.getQryParameter(null));
		}
	}

	/**
	 * 更改项目的最近生成时间
	 * 
	 * @param idOrSrvKeys
	 * @throws BizException
	 */
	private void updateOrderSrv(String[] idOrSrvKeys, FDateTime Dt_last_bl) throws BizException {

		if (idOrSrvKeys != null && idOrSrvKeys.length > 0) {

			boolean getLock = PKLock.getInstance().addBatchDynamicLock(idOrSrvKeys);

			if (!getLock)

				throw new BizException("其他用户正锁定表CI_OR_SRV中的相关记录，请稍后重试!");

			CiOrderSrvSplitUpdateQry Sql = new CiOrderSrvSplitUpdateQry(idOrSrvKeys, Dt_last_bl);

			new DAFacade().execUpdate(Sql.getQrySQLStr(), Sql.getQryParameter(null));
		}
	}

	/**
	 * 处理临界点的最近生成时间（增加一秒）
	 * 
	 * @param listOrSplitDTO
	 * @param listSrvSplitDTO
	 * @param Dt_last_bl
	 * @throws BizException
	 */
	private void handelCritical(OrSplitOrderDTO[] listOrSplitDTO, SrvSplitOrderDTO[] listSrvSplitDTO, FDateTime Dt_last_bl) throws BizException {

		String[] idOrKeys = getOrCritical(listOrSplitDTO, Dt_last_bl);
		String[] idOrSrvKeys = getSrvCritical(listSrvSplitDTO, Dt_last_bl);

		FDateTime last_bl = Dt_last_bl.addSeconds(2);

		if (idOrKeys != null && idOrKeys.length > 0) {
			updateOrder(idOrKeys, last_bl);
		}

		if (idOrSrvKeys != null && idOrSrvKeys.length > 0) {
			updateOrderSrv(idOrSrvKeys, last_bl);
		}
	}

	/**
	 * 获取拆分后处于临界点的医嘱
	 * 
	 * @param listOrSplitDTO
	 * @param Dt_last_bl
	 * @return
	 */
	private String[] getOrCritical(OrSplitOrderDTO[] listOrSplitDTO, FDateTime Dt_last_bl) {

		List<String> listOr = new ArrayList<String>();

		if (listOrSplitDTO != null && listOrSplitDTO.length > 0) {

			for (OrSplitOrderDTO orSplitOrderDTO : listOrSplitDTO) {

				if (orSplitOrderDTO.getDt_mp_plan().equals(Dt_last_bl)) {

					listOr.add(orSplitOrderDTO.getId_or());
				}
			}
		}

		return listOr.toArray(new String[listOr.size()]);
	}

	/**
	 * 获取拆分后处于临界点的服务项目
	 * 
	 * @param listSrvSplitDTO
	 * @param Dt_last_bl
	 * @return
	 */
	private String[] getSrvCritical(SrvSplitOrderDTO[] listSrvSplitDTO, FDateTime Dt_last_bl) {

		List<String> listSrv = new ArrayList<String>();

		if (listSrvSplitDTO != null && listSrvSplitDTO.length > 0) {

			for (SrvSplitOrderDTO srvSplitOrderDTO : listSrvSplitDTO) {

				// 出院带药和草药没有计划执行时间
				if (srvSplitOrderDTO.getDt_mp_plan() != null && srvSplitOrderDTO.getDt_mp_plan().equals(Dt_last_bl)) {

					listSrv.add(srvSplitOrderDTO.getId_orsrv());
				}
			}
		}

		return listSrv.toArray(new String[listSrv.size()]);
	}

	/**
	 * 特殊医嘱指定最近拆分时间
	 * 
	 * @param orSpecialMap
	 * @throws BizException
	 */
	private void setSpecialLastSplit(HashMap<String, FDateTime> orSpecialMap) throws BizException {

		Set<String> orList = orSpecialMap.keySet();

		if (orList != null && orList.size() > 0) {

			ICiorderRService findService = ServiceFinder.find(ICiorderRService.class);
			ICiorderCudService saveService = ServiceFinder.find(ICiorderCudService.class);

			CiorderAggDO[] aggDOS = findService.findByIds(orList.toArray(new String[orList.size()]), FBoolean.FALSE);

			if (aggDOS != null && aggDOS.length > 0) {

				for (CiorderAggDO agg : aggDOS) {

					CiOrderDO order = agg.getParentDO();
					FDateTime dt_last_bl = orSpecialMap.get(order.getId_or());

					if (dt_last_bl != null) {

						order.setDt_last_bl(dt_last_bl);
						order.setStatus(DOStatus.UPDATED);

						for (OrdSrvDO orsrv : agg.getOrdSrvDO()) {

							orsrv.setDt_last_bl(dt_last_bl);
							orsrv.setStatus(DOStatus.UPDATED);
						}
					}
				}
			}

			saveService.save(aggDOS);
		}
	}
}

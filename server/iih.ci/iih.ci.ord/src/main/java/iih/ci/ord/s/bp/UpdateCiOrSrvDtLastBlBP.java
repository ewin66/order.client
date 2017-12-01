/**
 * 
 */
package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderSrvDOCudService;
import iih.ci.ord.dto.orsrvsplitorder.d.OrSplitDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.SrvSplitDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.lock.PKLock;

/**
 * @ClassName: UpdateCiOrSrvDtLadtBlBP
 * @Description: 执行拆分回写医嘱项目最新生成时间
 * @author Comsys-li_zheng
 * @date 2016年6月7日 上午9:49:10
 * @Package iih.ci.ord.s.bp Copyright: Copyright (c) 2011 Company:
 *          北大医疗信息技术有限责任公司
 */
public class UpdateCiOrSrvDtLastBlBP {
	/**
	 * 执行拆分回写医嘱项目最新生成时间
	 * 
	 * @param Id_ors
	 * @param Dt_last_bl
	 * @throws BizException
	 */
	public String exe(OrSplitDTO[] orSplit, SrvSplitDTO[] srvSplit) throws BizException {

		// 1、获取医嘱ID集合
		String[] idOrStr = getIdOrs(orSplit);

		// 2、取医嘱服务ID集合
		String[] idOrSrvStr = getIdOrSrvs(srvSplit);

		// 3、取医嘱的最近生成时间
		FMap orLastBlMap = getOrPlanMap(orSplit);

		// 4、去医嘱项目的最近生成时间
		FMap srvLastBlMap = getOrSrvPlanMap(srvSplit);

		// 5、设置好最近生成时间的医嘱DO集合
		CiOrderDO[] ciOrderDOS = getUpdateOrderInfo(orLastBlMap, idOrStr);

		// 6、设置好最近生成时间的医嘱项目DO集合
		OrdSrvDO[] ciOrderSrvDOS = getUpdateOrderSrvInfo(srvLastBlMap, idOrSrvStr);

		// 7、批量更改医嘱最近生成日期
		updateOrder(idOrStr, ciOrderDOS);

		// 8、批量更改医嘱项目最近生成日期
		updateOrderSrv(idOrSrvStr, ciOrderSrvDOS);

		return "";
	}

	/**
	 * 取医嘱ID集合
	 * 
	 * @param Id_ors
	 * @return
	 */
	private String[] getIdOrs(OrSplitDTO[] orSplit) {

		if (orSplit == null)

			return null;

		List<String> idOrs = new ArrayList<String>();
		;

		for (OrSplitDTO DTO : orSplit) {

			idOrs.add(DTO.getId_or());
		}
		return idOrs.toArray((String[]) new String[idOrs.size()]);
	}

	/**
	 * 取医嘱服务ID集合
	 * 
	 * @param Id_ors
	 * @return
	 */
	private String[] getIdOrSrvs(SrvSplitDTO[] srvSplit) {

		if (srvSplit == null)
			return null;

		List<String> idOrSrvs = new ArrayList<String>();

		for (SrvSplitDTO DTO : srvSplit) {

			idOrSrvs.add(DTO.getId_orsrv());
		}
		return idOrSrvs.toArray((String[]) new String[idOrSrvs.size()]);
	}

	/**
	 * 获取医嘱的最近生成时间
	 * 
	 * @param orSplit
	 * @return
	 */
	private FMap getOrPlanMap(OrSplitDTO[] orSplit) {

		FMap reMap = new FMap();

		for (OrSplitDTO orSplitDTO : orSplit) {

			if (!reMap.containsKey(orSplitDTO.getId_or())) {

				reMap.put(orSplitDTO.getId_or(), orSplitDTO.getDt_last_bl());
			}
		}
		return reMap;
	}

	/**
	 * 获取医嘱项目的最近生成时间
	 * 
	 * @param orSplit
	 * @return
	 */
	private FMap getOrSrvPlanMap(SrvSplitDTO[] srvSplit) {

		FMap reMap = new FMap();

		for (SrvSplitDTO srvSplitDTO : srvSplit) {

			if (!reMap.containsKey(srvSplitDTO.getId_or())) {

				reMap.put(srvSplitDTO.getId_or(), srvSplitDTO.getDt_last_bl());
			}
		}
		return reMap;
	}

	/**
	 * 取设置好最近生成时间的医嘱DO集合
	 * 
	 * @param orLastBlMap
	 * @param listIdOrs
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] getUpdateOrderInfo(FMap orLastBlMap, String[] listIdOrs) throws BizException {

		if (listIdOrs != null && listIdOrs.length > 0) {

			CiOrderDO[] ords = CiOrdAppUtils.getCiorderMDORService().findByBIds(listIdOrs, FBoolean.FALSE);

			if (ords != null) {

				for (CiOrderDO ciOrderDO : ords) {

					Object Dt_last_bl = orLastBlMap.get(ciOrderDO.getId_or());

					if (Dt_last_bl != null) {

						ciOrderDO.setDt_last_bl((FDateTime) Dt_last_bl);
						ciOrderDO.setStatus(DOStatus.UPDATED);
					}
				}
			}
			return ords;
		}
		return null;
	}

	/**
	 * 取设置好最近生成时间的医嘱项目DO集合
	 * 
	 * @param srvLastBlMap
	 * @param listIdOrSrvs
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO[] getUpdateOrderSrvInfo(FMap srvLastBlMap, String[] listIdOrSrvs) throws BizException {

		if (listIdOrSrvs != null && listIdOrSrvs.length > 0) {

			OrdSrvDO[] ordSrvs = CiOrdAppUtils.getOrSrvQryService().findByBIds(listIdOrSrvs, FBoolean.FALSE);

			if (ordSrvs != null) {

				for (OrdSrvDO orSrvDO : ordSrvs) {

					Object Dt_last_bl = srvLastBlMap.get(orSrvDO.getId_orsrv());

					if (Dt_last_bl != null) {

						orSrvDO.setDt_last_bl((FDateTime) Dt_last_bl);
						orSrvDO.setStatus(DOStatus.UPDATED);
					}
				}
			}
			return ordSrvs;
		}
		return null;
	}

	/**
	 * 批量更改医嘱最近生成日期
	 * 
	 * @param idOrStr
	 * @param ciOrderDOS
	 * @throws BizException
	 */
	private void updateOrder(String[] idOrStr, CiOrderDO[] ciOrderDOS) throws BizException {

		boolean getLock = PKLock.getInstance().addBatchDynamicLock(idOrStr);

		if (!getLock)

			throw new BizException("其他用户正锁定表CI_ORDER中的相关记录，请稍后重试!");

		ICiorderMDOCudService orderSaveService = ServiceFinder.find(ICiorderMDOCudService.class);

		orderSaveService.save(ciOrderDOS);
	}

	/**
	 * 批量更改医嘱项目最近生成日期
	 * 
	 * @param idOrSrvStr
	 * @param ciOrderSrvDOS
	 * @throws BizException
	 */
	private void updateOrderSrv(String[] idOrSrvStr, OrdSrvDO[] ciOrderSrvDOS) throws BizException {

		boolean getLock = PKLock.getInstance().addBatchDynamicLock(idOrSrvStr);

		if (!getLock)

			throw new BizException("其他用户正锁定表CI_ORDER中的相关记录!");

		ICiorderSrvDOCudService orderSrvSaveService = ServiceFinder.find(ICiorderSrvDOCudService.class);

		orderSrvSaveService.save(ciOrderSrvDOS);
	}
}

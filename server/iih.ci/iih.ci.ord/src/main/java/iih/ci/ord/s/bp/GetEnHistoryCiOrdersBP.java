package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 获取就诊历史中显示的医嘱列表，包含医嘱对应的价格
 * 
 * @author HUMS
 *
 */
public class GetEnHistoryCiOrdersBP {

	/**
	 * 
	 * @param id_en 就诊id
	 * @param code_entp 就诊类型编码
	 * @param orderStr 排序字段
	 * @return 医嘱map结构，包含两项，ciOrderList 医嘱list集合，ciOrderPriMap 医嘱id与价格的map集合
	 * @throws BizException
	 */
	public FMap2 exec(String id_en, String code_entp, String orderStr) throws BizException {

		CiorderAggDO[] ciOrdAggs = this.getCiOrders(id_en, code_entp, orderStr);
		return getCiorderAggMap(code_entp, ciOrdAggs);

	}

	/**
	 * 获取医嘱展现数据
	 * 
	 * @param code_entp 就诊类型
	 * @param ciOrdAggs 医嘱对象集合
	 * @return
	 * @throws BizException
	 */
	private FMap2 getCiorderAggMap(String code_entp, CiorderAggDO[] ciOrdAggs) throws BizException {

		// 返回结果的map集合，包含医嘱的FArrayList2(CiOrderDO) 和 FMap2(id_or，价格) 医嘱对应的价格
		FMap2 orderMap = new FMap2();

		// 医嘱价格合计，key：id_or value：医嘱对应价格
		FMap2 orderPriMap = new FMap2();

		// 不可用医嘱map集合，key ：id_or value 不可用原因
		FMap2 orderStatusMap = new FMap2();

		// 医嘱集合
		FArrayList2 orderList = new FArrayList2();

		// 临时缓存药品服务项目与医嘱对应关系，，key：id_orsrv; value：id_or
		Map<String, String> idOrdMap = new HashMap<String, String>();

		// 缓存医嘱服务项目与基础医疗服务对应关系，key:id_orsrv; value:id_srv
		Map<String, String> idSrvMap = new HashMap<String, String>();

		// 医嘱id与医嘱对应的服务id集合
		Map<String, String> idOrIdSrvMap = new HashMap<String, String>();

		for (CiorderAggDO ciorderAgg : ciOrdAggs) {

			CiOrderDO ciOrder = ciorderAgg.getParentDO();
			orderList.add(ciOrder);

			OrdSrvDO[] ordSrvs = ciorderAgg.getOrdSrvDO();

			// 计算医嘱价格，非物品价格为服务项目中费用项目价格合计，物品医嘱价格为物品中的价格合计
			FDouble srvprice = new FDouble(0);
			for (OrdSrvDO ordSrv : ordSrvs) {

				if (ordSrv.getFg_or() == FBoolean.TRUE && ordSrv.getFg_mm() == FBoolean.TRUE) {

					// 缓存Id_orsrv与id_srv对应关系，用于后续构造OrdSrvChangedInfoDTO对象
					idSrvMap.put(ordSrv.getId_orsrv(), ordSrv.getId_srv());

					// 缓存医嘱服务项目与医嘱的对应关系，用于计算药品医嘱对应价格，药品服务是否可用					
					idOrdMap.put(ordSrv.getId_orsrv(), ciOrder.getId_or());

				} else if (!idOrIdSrvMap.containsKey(ciOrder.getId_or())) {
					// 医嘱对应的服务id集合，取非物品医嘱与服务对应关系
					idOrIdSrvMap.put(ciOrder.getId_or(), ciOrder.getId_srv());
				}

				// 非费用项目不计算
				if (ordSrv.getFg_bl() != FBoolean.TRUE) {
					continue;
				}

				// 计算价格，如果是物品，取物品表里的Price_pgku_cur * Quan_cur，否则如果是费用项目orsrv 中 Pri * Quan_total_medu
				if (ordSrv.getFg_mm() != FBoolean.TRUE && ordSrv.getPri() != null
						&& ordSrv.getQuan_total_medu() != null) {

					// 计算非物品服务价格
					srvprice = srvprice.add(ordSrv.getPri().multiply(ordSrv.getQuan_total_medu()));
				}
			}

			// 缓存非物品医嘱与医嘱价格对应关系
			orderPriMap.put(ciOrder.getId_or(), srvprice);
		}

		// 获取服务项目集合key：OrdSrvMmDO; key：id_or ;
		Map<OrdSrvMmDO, String> ordSrvMmMap = new HashMap<OrdSrvMmDO, String>();
		// 获取价格
		Map<String, FDouble> mmPriMap = this.getMmPriMap(idOrdMap, ordSrvMmMap);
		orderPriMap.putAll(mmPriMap);

		// 获取不可用医嘱及不可用原因
		orderStatusMap = getOrderStatusMap(code_entp, idOrdMap, idSrvMap, ordSrvMmMap, idOrIdSrvMap);

		// 医嘱list集合
		orderMap.put("orderList", orderList);
		// 医嘱价格map集合，key id_or value 价格
		orderMap.put("orderPriMap", orderPriMap);
		// 不可用医嘱map集合 key 不可用医嘱id， value 不可用原因
		orderMap.put("orderStatusMap", orderStatusMap);
		return orderMap;
	}

	/**
	 * 获取物品价格集合 价格计算方式：取物品表里的Price_pgku_cur * Quan_cur
	 * 
	 * @param idOrdMap id_orsrv与id_or对应关系集合 key：id_orsrv; vlaue：id_or
	 * @param ordSrvMmMap 用于获取物品与医嘱对应关系
	 * @return 医嘱价格map集合 key：id_or; value：医嘱价格
	 * @throws BizException
	 */
	private Map<String, FDouble> getMmPriMap(Map<String, String> idOrdMap, Map<OrdSrvMmDO, String> ordSrvMmMap)
			throws BizException {

		// 物品医嘱价格 key： id_or ;value: 医嘱价格
		Map<String, FDouble> ordSrvMmPriMap = new HashMap<String, FDouble>();
		// 拼接物品id用于查询物品
		StringBuffer idOrSrvBuffer = null;

		if (idOrdMap == null || idOrdMap.size() == 0) {
			return ordSrvMmPriMap;
		}

		idOrSrvBuffer = new StringBuffer();

		// idSrv 与idOr 的map集合
		//		Map<String, String> idOrSrvMap = new HashMap<String, String>();
		for (String key : idOrdMap.keySet()) {

			idOrSrvBuffer.append(",'" + key + "'");
		}

		// 根据物品服务查询所有的物品，用于计算物品医嘱价格
		String whereStr = "id_orsrv in (" + idOrSrvBuffer.substring(1) + ")";
		IOrdsrvmmRService ordsrvmmRService = CiOrdAppUtils.getOrSrvMmQryService();
		OrdSrvMmDO[] ordSrvMms = ordsrvmmRService.find(whereStr, null, FBoolean.FALSE);

		// 计算物品医嘱价格
		for (OrdSrvMmDO ordSrvMm : ordSrvMms) {

			// 获取物品id集合，返回给调用方法使用
			if (ordSrvMmMap != null) {
				ordSrvMmMap.put(ordSrvMm, idOrdMap.get(ordSrvMm.getId_orsrv()));
			}

			String idOr = idOrdMap.get(ordSrvMm.getId_orsrv());

			FDouble currPrice = null;
			// 获取缓存的map结构中的物品医嘱价格
			if (ordSrvMmPriMap.containsKey(idOr)) {
				currPrice = ordSrvMmPriMap.get(idOr);

			} else {
				currPrice = new FDouble(0);
			}

			if (ordSrvMm.getPrice_pgku_cur() != null && ordSrvMm.getQuan_cur() != null) {
				currPrice = currPrice.add(ordSrvMm.getPrice_pgku_cur().multiply(ordSrvMm.getQuan_cur()));
			}

			ordSrvMmPriMap.put(idOr, currPrice);
		}

		return ordSrvMmPriMap;
	}

	/**
	 * 获取医嘱CiorderAgg对象集合
	 * 
	 * @param id_en 就诊信息
	 * @param code_entp 就诊类型
	 * @param orderStr 排序字段
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO[] getCiOrders(String id_en, String code_entp, String orderStr) throws BizException {

		// 排除医嘱补费医嘱
		String whereStr = String.format(
				"a0.id_en='%s' and a0.fg_sign = 'Y' and fg_canc = 'N' and a0.eu_orsrcmdtp not in ('"
						+ OrSourceFromEnum.IIHMEDTECHORDERS + "') and a0.code_entp='%s' and a0.fg_pres_outp='N' ",
				id_en, code_entp);

		ICiorderRService ciorderRService = CiOrdAppUtils.getOrAggQryService();

		return ciorderRService.find(whereStr, "a0.createdtime " + orderStr, FBoolean.FALSE);
	}

	/**
	 * 获取不可用医嘱以及对应的提示信息
	 * 
	 * @param code_entp 就诊类型
	 * @param idOrdMap 物品医嘱id Map集合，key:id_orsrv; value:id_or
	 * @param idSrvMap 物品医嘱服务项目与基础医疗服务对应关系，key:key:id_orsrv; value:id_srv
	 * @param ordSrvMmMap 服务项目物品与医嘱对应关系，key：OrdSrvMmDO, value：id_or
	 * @param idOrIdSrvMap 非物品医嘱与服务对应关系， key：id_or; value：id_srv
	 * @return 不可用的医嘱id集合 key：id_or; value：不可用的原因
	 * @throws BizException
	 */
	private FMap2 getOrderStatusMap(String code_entp, Map<String, String> idOrdMap, Map<String, String> idSrvMap,
			Map<OrdSrvMmDO, String> ordSrvMmMap, Map<String, String> idOrIdSrvMap) throws BizException {

		// 不可用医嘱map集合
		FMap2 orderStatusMap = new FMap2();
		// 医嘱与物品关系map集合，key id_srv,id_mm ; value : id_or
		Map<String, String> idOrIdMmMap = new HashMap<String, String>();

		// 获取不可用服务查询条件集合
		List<OrdSrvChangedInfoDTO> ordSrvStatusInfoList = new ArrayList<OrdSrvChangedInfoDTO>();

		// // 构造查询不可用服务的查询条件 非物品
		for (String idSrv : idOrIdSrvMap.values()) {

			OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
			dto.setId_srv(idSrv);
			ordSrvStatusInfoList.add(dto);
		}

		// 构造物品的OrdSrvChangedInfoDTO对象集合 物品
		for (Entry<OrdSrvMmDO, String> ordSrvMmEntry : ordSrvMmMap.entrySet()) {

			String id_srv = idSrvMap.get(ordSrvMmEntry.getKey().getId_orsrv());
			String id_mm = ordSrvMmEntry.getKey().getId_mm();
			idOrIdMmMap.put(ordSrvMmEntry.getValue(), id_srv + "," + id_mm);

			OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
			dto.setId_srv(id_srv);
			dto.setId_mm(id_mm);
			ordSrvStatusInfoList.add(dto);

		}
		
		OrdChangedSrvValidateBP bp = new OrdChangedSrvValidateBP();
		
		// 获取不可用服务集合，key：id_srv; value：不可用提示信息
		Map<String, String> ordSrvStatusMap = bp.exec(code_entp, ordSrvStatusInfoList);

		// 构造不可用的服务id
		if (ordSrvStatusMap == null || ordSrvStatusMap.size() == 0) {
			return orderStatusMap;
		}

		String idOr = null;
		String idOrStatusInfo = null;

		// 遍历非物品医嘱，找出不可用的医嘱
		for (Entry<String, String> idOrIdSrvEntry : idOrIdSrvMap.entrySet()) {

			// 服务id（id_srv）不在返回的不可用服务范围内，继续循环
			if (!ordSrvStatusMap.containsKey(idOrIdSrvEntry.getValue())) {
				continue;
			}

			idOr = idOrIdSrvEntry.getKey();
			idOrStatusInfo = ordSrvStatusMap.get(idOrIdSrvEntry.getValue());
			orderStatusMap.put(idOr, idOrStatusInfo);
		}

		// 遍历物品医嘱，找出不可用的医嘱
		for (Entry<String, String> idOrIdMmEntry : idOrIdMmMap.entrySet()) {

			// 服务id（id_srv）不在返回的不可用服务范围内，继续循环
			if (!ordSrvStatusMap.containsKey(idOrIdMmEntry.getValue())) {
				continue;
			}

			idOr = idOrIdMmEntry.getKey();
			idOrStatusInfo = ordSrvStatusMap.get(idOrIdMmEntry.getValue());
			orderStatusMap.put(idOr, idOrStatusInfo);
		}

		return orderStatusMap;
	}
}

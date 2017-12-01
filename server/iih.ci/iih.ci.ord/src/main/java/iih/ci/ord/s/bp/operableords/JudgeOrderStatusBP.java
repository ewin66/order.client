package iih.ci.ord.s.bp.operableords;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.CiOrOpenEntStatusValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

public abstract class JudgeOrderStatusBP {

	/**
	 * 医嘱查询接口
	 */
	protected ICiorderRService ciOrderRService;

	protected ICiorderMDORService ciorderMRService;

	/**
	 * 检查申请单查询服务接口
	 */
	protected ICiorapprisRService ciorAppRisRService;

	/**
	 * 状态错误属性
	 */
	protected final static String STATUS_ERROR = "StatusError";
	/**
	 * 医嘱提示信息
	 */
	protected final static String ORD_MSG = "ordMsg";
	/**
	 * 允许操作的医嘱集合
	 */
	protected final static String ALLOWED_ORDS = "allowedOrds";
	/**
	 * 拒绝操作的医嘱集合
	 */
	protected final static String REFUSED_ORDS = "refusedOrds";

	public FMap2 exec(CiOrderDO[] orders,String id_dep_phy,String id_dep_nur) throws BizException {

		ciorAppRisRService = CiOrdAppUtils.getOrapprisQryService();
		ciOrderRService = CiOrdAppUtils.getOrAggQryService();
		ciorderMRService = CiOrdAppUtils.getCiorderMDORService();

		// 提示信息
		StringBuffer msgBuffer = new StringBuffer();

		FMap2 ordsMap = new FMap2();
		ordsMap.put(STATUS_ERROR, FBoolean.FALSE);

		CiOrderDO[] savedOrds = this.getSavedOrds(orders);
		// 判断患者就诊状态
		CiOrOpenEntStatusValidateBP entBp = new CiOrOpenEntStatusValidateBP();
		entBp.exec(savedOrds[0].getCode_entp(),
				savedOrds[0].getId_en(), id_dep_phy,id_dep_nur);
	
		//判断医嘱状态是否发生改变
		if (isOrdStatusChanged(orders, savedOrds)) {

			ordsMap.put(STATUS_ERROR, FBoolean.TRUE);
			ordsMap.put(ORD_MSG, "医嘱状态发生改变，请刷新医嘱列表后重新操作！");
			return ordsMap;
		}

		// 根据医嘱状态获取所有允许执行操作的医嘱
		List<CiOrderDO> allowedOrdList = this.getAllowdOrds(savedOrds);
		// 检查医嘱集合
		List<CiOrderDO> risOrdList = null;
		// 备血医嘱集合
		List<CiOrderDO> btOrdList = null;

		// 遍历医嘱，找出检查医嘱
		for (int i = 0; i < allowedOrdList.size(); i++) { // 检查

			CiOrderDO order = allowedOrdList.get(i);

			if (CiOrdUtils.isRisSrv(order.getSd_srvtp()) && !CiOrdUtils.isRisSrvBingli(order.getSd_srvtp())) {
				if (risOrdList == null) {
					risOrdList = new ArrayList<CiOrderDO>();
				}
				risOrdList.add(order);
			} else if (CiOrdUtils.isBtSrv(order.getSd_srvtp())
					|| IBdSrvDictCodeConst.SD_RELORDTYPE_BLOOD.equals(order.getSd_reltp())) { // 备血
				if (btOrdList == null) {
					btOrdList = new ArrayList<CiOrderDO>();
				}
				btOrdList.add(order);
			}
		}

		String lineSeparator = System.getProperty("line.separator", "\n");
		// 当有检查医嘱时，判断检查申请单状态
		if (risOrdList != null) {

			// 从允许执行操作的医嘱集合中排除检查检查医嘱集合（检查的需要单独根据申请单状态判断是否允许执行撤回）
			allowedOrdList.removeAll(risOrdList);

			// 获取允许的医嘱id
			List<CiOrderDO> allowedRisOrdList = this.getAllowedOrdByApObs(risOrdList);
			if (allowedRisOrdList != null) {
				allowedOrdList.addAll(allowedRisOrdList);
				if (risOrdList.size() != allowedRisOrdList.size()) {
					
					String tempNameOr = getRefusedOrderNameStr(risOrdList,allowedRisOrdList);
					msgBuffer.append("检查医嘱【"+tempNameOr+"】已进行预约检查不支持此操作！").append(lineSeparator);
				}
			}
		}

		// 当有住院医嘱时，判断是否有用血，有用血时不允许撤回
		if (btOrdList != null) {

			// 从允许执行操作的医嘱集合中排除检查检查医嘱集合（检查的需要单独根据申请单状态判断是否允许执行撤回）
			allowedOrdList.removeAll(btOrdList);

			// 获取允许的医嘱id
			List<CiOrderDO> allowedBtOrdList = this.getAllowedOrdByBt(btOrdList);
			if (allowedBtOrdList != null) {
				allowedOrdList.addAll(allowedBtOrdList);
				if (btOrdList.size() != allowedBtOrdList.size()) {
					String tempNameOr = getRefusedOrderNameStr(btOrdList,allowedBtOrdList);
					msgBuffer.append("已开立取血医嘱的备血医嘱【"+tempNameOr+"】不支持此操作，请删除用血医嘱后重新操作！");
				}
			}
		}

		// 转换为传输用的FArrayList
		List<CiOrderDO> refuseList = this.getRefusedOrds(savedOrds, allowedOrdList);
		FArrayList flistAllowed = new FArrayList();
		flistAllowed.addAll(allowedOrdList);

		FArrayList flistRefused = new FArrayList();
		flistRefused.addAll(refuseList);

		ordsMap.put(ALLOWED_ORDS, flistAllowed);
		ordsMap.put(ORD_MSG, msgBuffer.toString());
		ordsMap.put(REFUSED_ORDS, flistRefused);

		return ordsMap;
	}

	/**
	 * 获取当前允许进行操作的医嘱
	 * 
	 * @param orders
	 * @return
	 */
	protected abstract List<CiOrderDO> getAllowdOrds(CiOrderDO[] orders);

	/**
	 * 获取不允许执行操作的提示信息
	 * 
	 * @param orders
	 * @return 不允许操作的提示信息
	 */
	protected abstract String getRefusedOrdsMsg(CiOrderDO[] orders);

	/**
	 * 根据检查医疗单状态获取允许执行操作的检查医嘱
	 * 
	 * @param ordList 检查医嘱
	 * @return 允许操作的检查医嘱
	 * @throws BizException
	 */
	protected abstract List<CiOrderDO> getAllowedOrdByApObs(List<CiOrderDO> ordList) throws BizException;

	/**
	 * 允许操作的备血医嘱
	 * 
	 * @param ordList 备血医嘱集合
	 * @return
	 * @throws BizException
	 */
	protected abstract List<CiOrderDO> getAllowedOrdByBt(List<CiOrderDO> ordList) throws BizException;

	/**
	 * 获取不允许执行的操作的医嘱<br/>
	 * 查询到的医嘱排除掉允许执行操作的医嘱
	 * 
	 * @param savedOrds
	 * @param allowedOrdList
	 * @return
	 */
	private List<CiOrderDO> getRefusedOrds(CiOrderDO[] savedOrds, List<CiOrderDO> allowedOrdList) {

		List<CiOrderDO> refusedOrdList = new ArrayList<CiOrderDO>();

		if (savedOrds.length == allowedOrdList.size()) {
			return refusedOrdList;
		}

		for (CiOrderDO order : savedOrds) {
			if (refusedOrdList.contains(order)) {
				continue;
			}
			refusedOrdList.add(order);
		}

		return refusedOrdList;
	}

	/**
	 * 根据界面传入的医嘱获取当前数据空中最新医嘱数据，用于判断状态是否发生改变
	 * 
	 * @param orders 界面传入的医嘱
	 * @return 对应数据库中保存的医嘱
	 * @throws BizException
	 */
	protected CiOrderDO[] getSavedOrds(CiOrderDO[] orders) throws BizException {

		if (orders == null || orders.length == 0)
			return new CiOrderDO[0];

		List<String> ordIdList = this.getOrdIdList(orders);

		return CiOrdAppUtils.getOrQryService().findByIds(ordIdList.toArray(new String[ordIdList.size()]),
				FBoolean.FALSE);
	}

	/**
	 * 获取拒绝的医嘱操作的医嘱名称串（检查、备血用）
	 * @param orderList 前台传入进行撤销（作废）的全部检查或备血医嘱
	 * @param allowedOrderList 允许操作的检查或备血医嘱
	 * @return
	 */
	private String getRefusedOrderNameStr(List<CiOrderDO> orderList,List<CiOrderDO> allowedOrderList){
		
		StringBuffer orderNameBuffer = new StringBuffer();
		for(CiOrderDO order : orderList){
			if(!allowedOrderList.contains(order)){
				orderNameBuffer.append(","+order.getName_or());
			}
		}
		return orderNameBuffer.substring(1);
	}
	
	/**
	 * 获取医嘱id
	 * 
	 * @param orders
	 * @return id_or 数组
	 */
	protected List<String> getOrdIdList(CiOrderDO[] orders) {

		List<String> ordIdList = new ArrayList<String>();

		if (orders == null) {
			return ordIdList;
		}

		for (CiOrderDO order : orders) {
			ordIdList.add(order.getId_or());
		}

		return ordIdList;
	}

	/**
	 * 对比传入的医嘱与数据库中医嘱状态确定医嘱状态是否改变
	 * 
	 * @param orders 界面选择的医嘱
	 * @param savedOrds 数据库中保存的医嘱
	 * @return 状态是否一致，true 改变 false 未改变
	 */
	protected boolean isOrdStatusChanged(CiOrderDO[] orders, CiOrderDO[] savedOrds) {

		for (CiOrderDO ord : orders) {
			for (CiOrderDO savedOrd : savedOrds) {
				if (ord.getId_or().equals(savedOrd.getId_or())) {

					if (!ord.getSd_su_or().equals(savedOrd.getSd_su_or())) {
						return true;
					}
				}
			}
		}

		return false;
	}
}

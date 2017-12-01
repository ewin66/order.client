package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据是否为同一医院药房进行分方<br>
 * 1. 药房：同种药房的药分在一张方上
 * 
 * @author HUMS
 *
 */
public class PresByPharmacy extends AbstractPresRuleExecutor {
	
	/**
	 * 获取按部门分方的唯一规则
	 */
	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {
		
		return orderPresSplit.getId_dep_wh();
	}



	/**
	 * 按部门拆分时，每个处方明细都会有一个部门
	 */
	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		return true;
	}

	/*//返回集合
	List<CiOrPresSplitList> outList;
	//临时集合
	public Map<String, List<OrderPresSplitDTO>> tmpMap = new HashMap<String, List<OrderPresSplitDTO>>();

	@Override
	public List<CiOrPresSplitList> executeRule(List<CiOrPresSplitList> presList) {

		outList = new ArrayList<CiOrPresSplitList>();
		if (presList != null) {
			AnalyzeOrderPresSplitList(presList);
		}
		return outList;
	}

	

	*//**
	 * 药房 分方规则
	 * 
	 * @param orderpresSplitList
	 *//*
	private void AnalyzeOrderPresSplitList(List<CiOrPresSplitList> orderpresSplitList) {
		for (CiOrPresSplitList orderPresSplit : orderpresSplitList) {
			if (orderPresSplit.isAppRule) {
				tmpMap.clear();
				List<OrderPresSplitDTO> orderList = orderPresSplit.getOrderList();
				AnalyzeOrderPresSplitDTO(orderList);
				this.getOrderPresSplitList(orderPresSplit);
			} else {
				orderPresSplit.isAppRule = true;
				outList.add(orderPresSplit);
			}
		}
	}

	*//**
	 * 分解 List<OrderPresSplitDTO>
	 * 
	 * @param orderList
	 *//*
	private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList) {
		if (orderList != null && orderList.size() > 0) {

			for (OrderPresSplitDTO dto : orderList) {

				if (tmpMap.containsKey(dto.getId_dep_wh())) {
					List<OrderPresSplitDTO> list = tmpMap.get(dto.getId_dep_wh());
					list.add(dto);
				} else {
					List<OrderPresSplitDTO> list = new ArrayList<OrderPresSplitDTO>();
					list.add(dto);
					tmpMap.put(dto.getId_dep_wh(), list);
				}

			}
		}
	}

	*//**
	 * 返回的集合
	 * 
	 * @return
	 *//*
	private List<CiOrPresSplitList> getOrderPresSplitList(CiOrPresSplitList ps) {

		if (this.tmpMap == null && this.tmpMap.isEmpty())
			return null;
		Iterator entrys = tmpMap.entrySet().iterator();

		while (entrys.hasNext()) {
			Map.Entry entry = (Map.Entry) entrys.next();
			String key = (String) entry.getKey();
			List<OrderPresSplitDTO> orderList = (List) entry.getValue();
			if (orderList != null) {
				CiOrPresSplitList presSplitList = new CiOrPresSplitList();
				presSplitList.isAppRule = true;
				presSplitList.setName(ps.getName());
				presSplitList.setId_prestp(ps.getId_prestp());
				presSplitList.setCode(ps.code);
				presSplitList.setSd_pres(ps.getSd_pres());
				presSplitList.setSd_prestpword(ps.getSd_prestpword());
				presSplitList.setId_prestpword(ps.getId_prestpword());
				presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
				presSplitList.setOrderList(orderList);

				// 设置默认值，处方类型，处方字
				this.setDefaultVal(presSplitList);

				outList.add(presSplitList);
			}
		}

		return outList;
	}*/



	

	

}

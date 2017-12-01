package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 按是否为医保药品进行分方<br>
 * 保内在一个处方，保外在一个处方
 * 
 * @author HUMS
 *
 */
public class PresByMedicalInsurance extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if ("1".equals(orderPresSplit.getFg_hp_pres())) {
			return true;
		}
		return false;
	}
	
	/*List<CiOrPresSplitList> outList;3
	public Map<String, List> hpMap = new HashMap<String, List>();

	@Override
	public List<CiOrPresSplitList> executeRule(List<CiOrPresSplitList> presList) {

		// 根据药品的属性 TODO
		outList = new ArrayList<CiOrPresSplitList>();
		if (presList != null) {
			AnalyzeOrderPresSplitList(presList);
		}
		return outList;
	}

	@Override
	protected boolean isExecuteNext() {
		// TODO Auto-generated method stub
		return false;
	}

	*//**
	 * 
	 * @param orderpresSplitList
	 *//*
	private void AnalyzeOrderPresSplitList(List<CiOrPresSplitList> orderpresSplitList) {
		for (CiOrPresSplitList orderPresSplit : orderpresSplitList) {
			if (orderPresSplit.isAppRule) {
				hpMap.clear();
				List<OrderPresSplitDTO> orderList = orderPresSplit.getOrderList();
				AnalyzeOrderPresSplitDTO(orderList);
				this.getOrderPresSplitList(orderPresSplit);
			} else {
				//orderPresSplit.isAppRule=true;
				outList.add(orderPresSplit);
			}
		}
	}

	*//**
	 * 分解 List<OrderPresSplitDTO> //自费标志为N 医保 1，自费标志为Y 非医保 0
	 * 
	 * @param orderList
	 *//*
	private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList) {
		for (OrderPresSplitDTO dto : orderList) {
			if (dto.getFg_hp_pres() != null && dto.getFg_hp_pres().equals("1")) {
				if (hpMap.containsKey("1")) {
					List<OrderPresSplitDTO> list1 = hpMap.get("1");
					list1.add(dto);
					hpMap.put("1", list1);

				} else {
					List<OrderPresSplitDTO> list1 = new ArrayList<OrderPresSplitDTO>();
					list1.add(dto);
					hpMap.put("1", list1);
				}
			} else {

				if (hpMap.containsKey("0")) {
					List<OrderPresSplitDTO> list1 = hpMap.get("0");
					list1.add(dto);
					hpMap.put("0", list1);

				} else {
					List<OrderPresSplitDTO> list1 = new ArrayList<OrderPresSplitDTO>();
					list1.add(dto);
					hpMap.put("0", list1);
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

		if (this.hpMap == null)
			return null;
		Iterator entrys = this.hpMap.entrySet().iterator();
		while (entrys.hasNext()) {
			entrys.hasNext();
			Map.Entry entry = (Map.Entry) entrys.next();
			List<OrderPresSplitDTO> orderList = (List) entry.getValue();
			if (orderList != null && orderList.size() > 0) {
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
				outList.add(presSplitList);
			}
		}
		return outList;
	}*/

	

}

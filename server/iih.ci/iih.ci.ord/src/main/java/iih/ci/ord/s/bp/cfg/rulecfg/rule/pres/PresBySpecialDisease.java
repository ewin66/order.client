package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据是否为特殊病药品进行分方<br>
 * 特殊病处方（特殊病标识为True）
 * 
 * @author HUMS
 *
 */
public class PresBySpecialDisease extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (orderPresSplit.getFg_specill() == FBoolean.TRUE) {
			return true;
		}
		return false;
	}

	/*List<CiOrPresSplitList> outList;
	public Map<String, List> hpMap = new HashMap<String, List>();
	
	@Override
	public List<CiOrPresSplitList> executeRule(List<CiOrPresSplitList> presLsit) {
	
		// 根据药品的属性 TODO
		outList = new ArrayList<CiOrPresSplitList>();
		if (presLsit != null) {
			AnalyzeOrderPresSplitList(presLsit);
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
		 */
	/*
	private void AnalyzeOrderPresSplitList(List<CiOrPresSplitList> orderpresSplitList) {
	for (CiOrPresSplitList orderPresSplit : orderpresSplitList) {
		if (orderPresSplit.isAppRule) {
			hpMap.clear();
			List<OrderPresSplitDTO> orderList = orderPresSplit.getOrderList();
			//TODO
			AnalyzeOrderPresSplitDTO(orderList);
			this.getOrderPresSplitList(orderPresSplit);
		} else {
			//orderPresSplit.isAppRule=true;
			outList.add(orderPresSplit);
		}
	}
	}
	
	*//**
		 * 分解 List<OrderPresSplitDTO>
		 * 
		 * @param orderList
		 */
	/*
	private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList) {
	for (OrderPresSplitDTO dto : orderList) {
		if (dto.getFg_specill() == FBoolean.TRUE) {
			if (hpMap.containsKey("1")) {
				List<OrderPresSplitDTO> list1 = hpMap.get("1");
				list1.add(dto);
				//hpMap.put("1", list1);
	
			} else {
				List<OrderPresSplitDTO> list1 = new ArrayList<OrderPresSplitDTO>();
				list1.add(dto);
				hpMap.put("1", list1);
			}
		} else {
	
			if (hpMap.containsKey("0")) {
				List<OrderPresSplitDTO> list1 = hpMap.get("0");
				list1.add(dto);
				//hpMap.put("0", list1);
	
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
		presSplitList.setName(ps.getName());
		presSplitList.setSd_pres(ps.getSd_pres());
		presSplitList.setId_prestp(ps.getId_prestp());
		presSplitList.setCode(ps.getCode());
		if (entry.getKey() != null && entry.getKey().equals("1")) {
			presSplitList
					.setSd_prestpword(ps.getSd_prestpword() + "," + PKUSplitConst.SD_PRESCRIPTION_FLAG_TSB);
			presSplitList
					.setId_prestpword(ps.getId_prestpword() + "," + PKUSplitConst.ID_PRESCRIPTION_FLAG_TSB);
		} else {
			presSplitList.setSd_prestpword(ps.getSd_prestpword());
			presSplitList.setId_prestpword(ps.getId_prestpword());
		}
		presSplitList.isAppRule = true;
		presSplitList.setOrderList(orderList);
		outList.add(presSplitList);
		}
		}
		
		return outList;
		}
		
		@Override
		protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		// TODO Auto-generated method stub
		return false;
		}*/

}

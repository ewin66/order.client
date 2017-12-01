package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据是否为基数药进行分方<br>
 * 基数药单独分方（基数药标识为true）
 * 
 * @author HUMS
 *
 */
public class PresByFgBase extends AbstractSinglePresRuleExecutor {
	
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {
		
		return orderPresSplit.getId_orsrv();
	}

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (orderPresSplit.getFg_base() == FBoolean.TRUE) {
			return true;
		}
		return false;
	}

	/*List<CiOrPresSplitList> outList;
	public Map<String, List> fgbaseMap = new HashMap<String, List>();

	@Override
	public List<CiOrPresSplitList> executeRule(List<CiOrPresSplitList> presList) {

		outList = new ArrayList<CiOrPresSplitList>();
		if (presList != null) {
			AnalyzeOrderPresSplitList(presList);
		}
		return outList;
	}

	*//**
	 * 
	 * @param orderpresSplitList
	 *//*
	private void AnalyzeOrderPresSplitList(List<CiOrPresSplitList> orderpresSplitList) {
		for (CiOrPresSplitList orderPresSplit : orderpresSplitList) {
			if (orderPresSplit.isAppRule) {
				fgbaseMap.clear();
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
	 * 分解 List<OrderPresSplitDTO>
	 * 
	 * @param orderList
	 *//*
	private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList) {
		for (OrderPresSplitDTO dto : orderList) {
			if (dto.getFg_base() == null)
				continue;
			if (dto.getFg_base() == FBoolean.TRUE) {
				if (fgbaseMap.containsKey(FBoolean.TRUE.toString())) {
					List<OrderPresSplitDTO> list1 = fgbaseMap.get(FBoolean.TRUE.toString());
					list1.add(dto);
					fgbaseMap.put(FBoolean.TRUE.toString(), list1);

				} else {
					List<OrderPresSplitDTO> list1 = new ArrayList<OrderPresSplitDTO>();
					list1.add(dto);
					fgbaseMap.put(FBoolean.TRUE.toString(), list1);
				}
			} else if (dto.getFg_base() == FBoolean.FALSE) {

				if (fgbaseMap.containsKey(FBoolean.FALSE.toString())) {
					List<OrderPresSplitDTO> list1 = fgbaseMap.get(FBoolean.FALSE.toString());
					list1.add(dto);
					fgbaseMap.put(FBoolean.FALSE.toString(), list1);

				} else {
					List<OrderPresSplitDTO> list1 = new ArrayList<OrderPresSplitDTO>();
					list1.add(dto);
					fgbaseMap.put(FBoolean.FALSE.toString(), list1);
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

		if (this.fgbaseMap == null)
			return null;
		Iterator entrys = this.fgbaseMap.entrySet().iterator();
		while (entrys.hasNext()) {
			entrys.hasNext();
			Map.Entry entry = (Map.Entry) entrys.next();
			String key = (String) entry.getKey();
			List<OrderPresSplitDTO> orderList = (List) entry.getValue();
			if (orderList != null && orderList.size() > 0) {
				CiOrPresSplitList presSplitList = new CiOrPresSplitList();
				presSplitList.isAppRule = true;
				presSplitList.setName(ps.getName());
				presSplitList.setId_prestp(ps.getId_prestp());
				presSplitList.setCode(ps.code);
				presSplitList.setSd_pres(ps.getSd_pres());
				if (key.equalsIgnoreCase("Y")) {
					presSplitList
							.setSd_prestpword(ps.getSd_prestpword() + "," + PKUSplitConst.SD_PRESCRIPTION_FLAG_JSY);
					presSplitList
							.setId_prestpword(ps.getId_prestpword() + "," + PKUSplitConst.ID_PRESCRIPTION_FLAG_JSY);
				} else {
					presSplitList.setSd_prestpword(ps.getSd_prestpword());
					presSplitList.setId_prestpword(ps.getId_prestpword());
				}
				presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
				presSplitList.setOrderList(orderList);
				outList.add(presSplitList);
			}

		}

		return outList;
	}
*/
}

package iih.ci.ord.s.bp.splitpres.rule;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;

/**
 * 
 * @author li_cheng 临床医嘱分方规则：医保分方规则
 */
public class CiOrHPPresSplitRule implements ICiOrPresSplitRule {

	List<CiOrPresSplitList> outList;
	public Map<String, List> hpMap = new HashMap<String, List>();

	@Override
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> list) throws BizException {
		// TODO Auto-generated method stub
		// 根据药品的属性 TODO

		outList = new ArrayList<CiOrPresSplitList>();
		if (list != null) {
			AnalyzeOrderPresSplitList(list);
		}
		return outList;
	}

	/**
	 * 
	 * @param orderpresSplitList
	 */
	private void AnalyzeOrderPresSplitList(List<CiOrPresSplitList> orderpresSplitList) {
		for (CiOrPresSplitList orderPresSplit : orderpresSplitList) {
			if (orderPresSplit.isAppRule) {
				hpMap.clear();
				List<OrderPresSplitDTO> orderList = orderPresSplit.getOrderList();
				AnalyzeOrderPresSplitDTO(orderList);
				this.getOrderPresSplitList(orderPresSplit);
			} else {
				orderPresSplit.isAppRule=true;
				outList.add(orderPresSplit);
			}
		}
	}

	/**
	 * 分解 List<OrderPresSplitDTO>
	 * 
	 * @param orderList
	 */
	private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList) {
		for (OrderPresSplitDTO dto : orderList) {
			if (dto.getFg_hp_pres().equals("1")) {
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

	/**
	 * 返回的集合
	 * 
	 * @return
	 */
	private List<CiOrPresSplitList> getOrderPresSplitList(CiOrPresSplitList ps) {

		if (this.hpMap == null)
			return null;
		Iterator entrys = this.hpMap.entrySet().iterator();
		while (entrys.hasNext()) {
			entrys.hasNext();
			Map.Entry entry = (Map.Entry) entrys.next();
			List<OrderPresSplitDTO> orderList = (List) entry.getValue();
			if (orderList != null) {
				CiOrPresSplitList presSplitList = new CiOrPresSplitList();

				presSplitList.isAppRule = true;
				presSplitList.setId_pres(ps.getId_pres());
				presSplitList.setCode(ps.code);
				presSplitList.setSd_pres(ps.getSd_pres());
				presSplitList.setOrderList(orderList);

				outList.add(presSplitList);
			}

		}

		return outList;
	}

}

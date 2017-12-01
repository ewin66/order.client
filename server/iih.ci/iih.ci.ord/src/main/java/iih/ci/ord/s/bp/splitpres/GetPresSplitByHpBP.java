package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;

public class GetPresSplitByHpBP implements PresSplitBaseRule {
	// 返回的分方数据 集合
	List<OrderPresSplitList> orderPresSplitlist = new ArrayList<OrderPresSplitList>();
	public Map<String, List> hpMap = new HashMap<String, List>();

	@Override
	public List<OrderPresSplitList> exec(List<OrderPresSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		if (list == null||list.isEmpty())
			return null;
		for (OrderPresSplitList orderPresSplitList : list) {
			AnalyzePresSplitList(orderPresSplitList);
		}
		return this.orderPresSplitlist;
	}

	private void AnalyzePresSplitList(OrderPresSplitList orderPresSplitList) {
		hpMap.clear();
		List<OrderPresSplitDTO> orderPresSplitDTOList = orderPresSplitList
				.getOrderList();
		if (orderPresSplitDTOList != null && orderPresSplitDTOList.size() > 0) {

			AnalyzeOrderPresSplitDTO(orderPresSplitDTOList);

			this.getOrderPresSplitList(orderPresSplitList);
		}
	}

	private void AnalyzeOrderPresSplitDTO(
			List<OrderPresSplitDTO> orderPresSplitDTOList) {
		for (OrderPresSplitDTO dto : orderPresSplitDTOList) {
			// if(this.GetMapDept().containsKey(dto.getId_dep_or())){
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
	 * getOrderPresSplitList
	 * 
	 * @return
	 */
	private List<OrderPresSplitList> getOrderPresSplitList(OrderPresSplitList ps) {

		if (this.hpMap == null)
			return orderPresSplitlist;
		Iterator entrys = this.hpMap.entrySet().iterator();
		while (entrys.hasNext()) {
			entrys.hasNext();
			Map.Entry entry = (Map.Entry) entrys.next();
			List<OrderPresSplitDTO> orderList = (List) entry.getValue();
			if (orderList != null) {
				OrderPresSplitList presSplitList = new OrderPresSplitList();

				presSplitList.isAppRule = true;
				presSplitList.setId_pres(ps.getId_pres());
				presSplitList.setCode(ps.code);
				presSplitList.setSd_pres(ps.getSd_pres());
				presSplitList.setOrderList(orderList);

				orderPresSplitlist.add(presSplitList);
			}

		}

		return orderPresSplitlist;

	}

}

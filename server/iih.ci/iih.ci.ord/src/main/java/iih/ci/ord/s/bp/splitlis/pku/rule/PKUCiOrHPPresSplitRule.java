package iih.ci.ord.s.bp.splitlis.pku.rule;

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
 * 3.	医保：保内在一个处方，保外在一个处方，主要针对毒麻药处方
 * @author li_zheng
 *
 */
public class PKUCiOrHPPresSplitRule implements ICiOrPresSplitRule {

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
				//orderPresSplit.isAppRule=true;
				outList.add(orderPresSplit);
			}
		}
	}

	/**
	 * 分解 List<OrderPresSplitDTO>
	 *  //自费标志为N 医保 1，自费标志为Y 非医保 0
	 * @param orderList
	 */
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
			if (orderList != null && orderList.size() >0) {
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
	}

}

package iih.ci.ord.s.bp.splitpres.rule;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
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
 * @author li_cheng 临床医嘱分方规则：医嘱分方规则（只有草药医嘱需要按医嘱分方）
 */
public class CiOrOrdPresSplitRule implements ICiOrPresSplitRule {

	List<CiOrPresSplitList> outList;
	public Map<String, List> tmpMap = new HashMap<String, List>();

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
				tmpMap.clear();

				List<OrderPresSplitDTO> orderList = orderPresSplit.getOrderList();
				if (!orderList.get(0).getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					outList.add(orderPresSplit);
					continue;
				}
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
		if (orderList != null && orderList.size() > 0) {

			for (OrderPresSplitDTO dto : orderList) {

				if (dto.getSd_srvtp() == null)
					continue;
				String key = dto.getId_or();
				if (dto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {

					if (tmpMap.containsKey(key)) {
						List<OrderPresSplitDTO> list = tmpMap.get(key);
						list.add(dto);
					} else {
						List<OrderPresSplitDTO> list = new ArrayList<OrderPresSplitDTO>();
						list.add(dto);
						tmpMap.put(key, list);
					}

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

		Iterator entrys = tmpMap.entrySet().iterator();

		while (entrys.hasNext()) {
			Map.Entry entry = (Map.Entry) entrys.next();
			String key = (String) entry.getKey();
			List<OrderPresSplitDTO> orderList = (List) entry.getValue();
			if (orderList != null) {
				CiOrPresSplitList presSplitList = new CiOrPresSplitList();

				presSplitList.isAppRule = true;
				presSplitList.setId_pres(ps.getId_pres());
				presSplitList.setCode(orderList.get(0).getSd_srvtp());
				presSplitList.setSd_pres(ps.getSd_pres());
				presSplitList.setOrderList(orderList);
				outList.add(presSplitList);

			}

		}

		return outList;
	}

}

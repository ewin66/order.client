package iih.ci.ord.s.bp.splitpres.rule;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;
import iih.ci.ord.s.bp.splitpres.PresConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;

/**
 * 
 * @author li_cheng 临床医嘱分方规则：服务分方规则
 */
public class CiOrMedSrvPresSplitRule implements ICiOrPresSplitRule {

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
			if (dto.getSd_srvtp() == null)
				continue;
			String key = dto.getSd_srvtp().substring(0, 4);
			if (this.GetMedSrvType().containsKey(key)) {

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

	/**
	 * 返回的集合
	 * 
	 * @return
	 */
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
				if (this.GetMedSrvType().containsKey(key)) {
					presSplitList.setName(((String[]) this.GetMedSrvType().get(key))[2]);
					presSplitList.setSd_pres((((String[]) this.GetMedSrvType().get(key))[0]));
					presSplitList.setId_pres((((String[]) this.GetMedSrvType().get(key))[1]));
					presSplitList.setCode(ps.getCode());
					presSplitList.isAppRule = true;
					presSplitList.setOrderList(orderList);
					outList.add(presSplitList);
				}

			}
		}

		return outList;
	}

	private static Map GetMedSrvType() {

		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, new String[] { PresConstant.SD_HERBAL, PresConstant.ID_HERBAL, "草药" });
		map.put(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG, new String[] { PresConstant.SD_EMERGENCY, PresConstant.ID_EMERGENCY, "普通西药" });
		map.put(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG, new String[] { PresConstant.SD_WESTERNMEDICINE, PresConstant.ID_WESTERNMEDICINE, "成药" });

		return map;
	}

}

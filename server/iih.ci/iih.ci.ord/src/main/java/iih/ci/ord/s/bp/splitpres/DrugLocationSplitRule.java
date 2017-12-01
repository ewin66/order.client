package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;

/**
 * 根据执行地点分方（执行科室）
 * 
 * @author li_zheng
 *
 */
public class DrugLocationSplitRule implements PresSplitBaseRule {

	// 临时集合
	public Map<String, List> tmpMap = new HashMap<String, List>();

	// 返回的分方数据 集合
	List<OrderPresSplitList> orderPresSplitlist = new ArrayList<OrderPresSplitList>();

	/**
	 * 根据执行地点分方（执行科室）
	 */
	@Override
	public List<OrderPresSplitList> exec(List<OrderPresSplitList> orderPresSplitlist) throws BizException {
		// TODO Auto-generated method stub
		if (orderPresSplitlist == null || orderPresSplitlist.size() == 0)
			return null;
		// 根据执行地点分方（执行科室）
		for (OrderPresSplitList presSplitList : orderPresSplitlist) {
			AnalyzeOrderPresSplitList(presSplitList);
		}

		// 服务的执行科室
		return this.orderPresSplitlist;
	}

	private void AnalyzeOrderPresSplitList(OrderPresSplitList presSplitList) {
		tmpMap.clear();
		if (presSplitList.isAppRule) {
			AnalyzeOrderPresSplitDTO(presSplitList);
		} else {
			this.orderPresSplitlist.add(presSplitList);
		}
	}

	private void AnalyzeOrderPresSplitDTO(OrderPresSplitList presSplitList) {
		List<OrderPresSplitDTO> orderPresSplitDTOList = presSplitList
				.getOrderList();
		if (orderPresSplitDTOList != null && orderPresSplitDTOList.size() > 0) {

			for (OrderPresSplitDTO dto : orderPresSplitDTOList) {

				if (tmpMap.containsKey(dto.getId_dep_mp())) {
					List<OrderPresSplitDTO> list = tmpMap.get(dto.getId_dep_mp());
					list.add(dto);
				} else {
					List<OrderPresSplitDTO> list = new ArrayList<OrderPresSplitDTO>();
					list.add(dto);
					tmpMap.put(dto.getId_dep_mp(), list);
				}

			}
			this.getOrderPresSplitList(presSplitList);
		}
	}



	/**
	 * getOrderPresSplitList
	 * 
	 * @return
	 */
	private List<OrderPresSplitList> getOrderPresSplitList(OrderPresSplitList ps) {

		if (this.tmpMap == null)
			return orderPresSplitlist;
		Iterator entrys = this.tmpMap.entrySet().iterator();
		while (entrys.hasNext()) {
			Map.Entry entry = (Map.Entry) entrys.next();
			String key = (String) entry.getKey();
			List<OrderPresSplitDTO> orderList = (List) entry.getValue();
			if (orderList != null) {
				OrderPresSplitList presSplitList = new OrderPresSplitList();

				presSplitList.isAppRule = true;
				presSplitList.setId_pres(ps.getId_pres());
				presSplitList.setCode(orderList.get(0).getSd_srvtp());
				presSplitList.setSd_pres(ps.getSd_pres());
				presSplitList.setOrderList(orderList);

				orderPresSplitlist.add(presSplitList);
			}
		}
		return orderPresSplitlist;
	}

//	/**
//	 * 临时方案 ，todo 以后修改成配置文件
//	 * 
//	 * @return
//	 */
//	private Map GetMapDept() {
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("0001AA1000000000YTUY", new String[] { "aaa",
//				"bbb", "儿科" });
//		map.put("0001AA1000000005Q4L9", new String[] {
//				PresConstant.SD_EMERGENCY, PresConstant.ID_EMERGENCY, "急诊科" });
//		return map;
//
//	}
	
	
//	/**
//	 * getOrderPresSplitList
//	 * 
//	 * @return
//	 */
//	private List<OrderPresSplitList> getOrderPresSplitList() {
//
//		if (this.tmpMap == null)
//			return orderPresSplitlist;
//		Iterator entrys = this.tmpMap.entrySet().iterator();
//		while (entrys.hasNext()) {
//			Map.Entry entry = (Map.Entry) entrys.next();
//			String key = (String) entry.getKey();
//			List<OrderPresSplitDTO> orderList = (List) entry.getValue();
//			if (orderList != null) {
//				OrderPresSplitList presSplitList = new OrderPresSplitList();
//				if (this.GetMapDept().containsKey(key)) {
//					presSplitList.setName(((String[]) this.GetMapDept()
//							.get(key))[2]);
//					if ((orderList.get(0).getSd_srvtp()).substring(0, 4)
//							.equals("0102"))
//						presSplitList.setSd_pres(((String[]) this.GetMapDept()
//								.get(key))[0]);
//					else {
//						presSplitList.setSd_pres(orderList.get(0)
//								.getSd_prestp());
//					}
//					presSplitList.setId_pres(((String[]) this.GetMapDept().get(
//							key))[1]);
//					presSplitList.isAppRule = true;
//					presSplitList.setCode(orderList.get(0).getSd_srvtp());
//					presSplitList.setOrderList(orderList);
//				} else {
//					presSplitList.isAppRule = true;
//					presSplitList.setCode(orderList.get(0).getSd_srvtp());
//					presSplitList.setOrderList(orderList);
//				}
//				orderPresSplitlist.add(presSplitList);
//			}
//		}
//		return orderPresSplitlist;
//	}
}

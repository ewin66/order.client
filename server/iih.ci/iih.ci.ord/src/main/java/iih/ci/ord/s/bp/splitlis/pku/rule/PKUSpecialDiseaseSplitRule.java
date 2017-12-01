package iih.ci.ord.s.bp.splitlis.pku.rule;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.PKUSplitConst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 4.	特种病：作为特种病标志，特种病单独分方
 * @author li_zheng
 *
 */
public class PKUSpecialDiseaseSplitRule implements ICiOrPresSplitRule {

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
				//TODO
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
	 * 
	 * @param orderList
	 */
	private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList) {
		for (OrderPresSplitDTO dto : orderList) {
			if (dto.getFg_specill()==FBoolean.TRUE) {
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
				  presSplitList.setName(ps.getName());
	   			  presSplitList.setSd_pres(ps.getSd_pres());
	   			  presSplitList.setId_prestp(ps.getId_prestp());
	   			  presSplitList.setCode(ps.getCode());
	   			  if(entry.getKey() != null && entry.getKey().equals("1")){
	   				  presSplitList.setSd_prestpword(ps.getSd_prestpword()+","+PKUSplitConst.SD_PRESCRIPTION_FLAG_TSB);
		   			  presSplitList.setId_prestpword(ps.getId_prestpword()+","+PKUSplitConst.ID_PRESCRIPTION_FLAG_TSB);
	   			  }else{
	   				  presSplitList.setSd_prestpword(ps.getSd_prestpword());
		   			  presSplitList.setId_prestpword(ps.getId_prestpword());
	   			  }
	   			  presSplitList.isAppRule = true;
	   		 	  presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
				  presSplitList.setOrderList(orderList);
				outList.add(presSplitList);
			}
		}

		return outList;
	}
 
}

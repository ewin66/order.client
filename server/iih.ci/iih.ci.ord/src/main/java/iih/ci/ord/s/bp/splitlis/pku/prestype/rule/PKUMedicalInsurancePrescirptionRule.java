package iih.ci.ord.s.bp.splitlis.pku.prestype.rule;

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
 * 医疗保险处方笺
 * @author li_zheng
 *
 */
public class PKUMedicalInsurancePrescirptionRule implements ICiOrPresSplitRule {

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
	 * 1 是医保，  0 不是医保
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
			if (orderList != null && entry.getKey().equals("1")) {
				CiOrPresSplitList presSplitList = new CiOrPresSplitList();
				presSplitList.isAppRule = true;
				if(ps.getName() != null){
					presSplitList.setName(ps.getName());
					presSplitList.setId_prestp(ps.getId_prestp());
					presSplitList.setCode(ps.code);
					presSplitList.setSd_pres(ps.getSd_pres());
					presSplitList.setSd_prestpword(ps.getSd_prestpword()+","+PKUSplitConst.SD_PRESCRIPTION_FLAG_YB);
					presSplitList.setId_prestpword(ps.getId_prestpword()+","+PKUSplitConst.ID_PRESCRIPTION_FLAG_YB);
				}else{
					presSplitList.setName(PKUSplitConst.NAME_UDIDOC_PRESCRIPTION_YLBXCFJ);
					presSplitList.setId_prestp(PKUSplitConst.ID_UDIDOC_PKU_PRESCRIPTION_YLBXCFJ);
					presSplitList.setCode(ps.code);
					presSplitList.setSd_pres(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_YLBXCFJ);
					presSplitList.setSd_prestpword(PKUSplitConst.SD_PRESCRIPTION_FLAG_YB);
					presSplitList.setId_prestpword(PKUSplitConst.ID_PRESCRIPTION_FLAG_YB);
					presSplitList.setName(PKUSplitConst.NAME_UDIDOC_PRESCRIPTION_YLBXCFJ);
				}
				presSplitList.setFg_hp_pres(FBoolean.TRUE);
				presSplitList.setOrderList(orderList);
				outList.add(presSplitList);
			}else{
				CiOrPresSplitList presSplitList = new CiOrPresSplitList();
				presSplitList.isAppRule = true;
				presSplitList.setName(ps.getName());
				presSplitList.setId_prestp(ps.getId_prestp());
				presSplitList.setCode(ps.code);
				presSplitList.setSd_pres(ps.getSd_pres());
				presSplitList.setSd_prestpword(ps.getSd_prestpword());
				presSplitList.setId_prestpword(ps.getId_prestpword());
				presSplitList.setOrderList(orderList);
				presSplitList.setFg_hp_pres(FBoolean.FALSE);
				outList.add(presSplitList);
			}

		}

		return outList;
	}

}

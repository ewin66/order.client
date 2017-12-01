package iih.ci.ord.s.bp.splitlis.pku.prestype.rule;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
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

/**
 * 公费医疗处方笺
 * @author li_zheng
 *
 */
public class PKUFreeMedicalPrescriptionTypeRule implements ICiOrPresSplitRule {

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
	 *  1、	有社保医保计划，基金支付
		2、	险种 = 公费
		3、	保内项目：费用保内标志=Y

	 * @param orderList
	 */
	private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList) {
		List<OrderPresSplitDTO> listOP = new ArrayList<OrderPresSplitDTO>();
		List<OrderPresSplitDTO> list1 = new ArrayList<OrderPresSplitDTO>();
		for (OrderPresSplitDTO dto : orderList){
			if (dto.getCode_hpkind() != null && IBdPpCodeTypeConst.SD_HP_BJ_KIND_PUBLIC_EXPENSE.equals(dto.getCode_hpkind())) {
				listOP.add(dto);	 
			}else{
			    list1.add(dto);
				}
			}
		 
		if(listOP != null && listOP.size()>0 ){
			hpMap.put(IBdPpCodeTypeConst.SD_HP_BJ_KIND_PUBLIC_EXPENSE, listOP);
		}
		if(list1 != null && list1.size()>0 ){
			hpMap.put("OTH", list1);
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
			if (orderList != null && entry.getKey().equals(IBdPpCodeTypeConst.SD_HP_BJ_KIND_PUBLIC_EXPENSE)) {
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
					presSplitList.setId_prestp(PKUSplitConst.ID_UDIDOC_PKU_PRESCRIPTION_GFYLCFJ);
					presSplitList.setCode(ps.code);
					presSplitList.setName(PKUSplitConst.NAME_UDIDOC_PRESCRIPTION_GFYLCFJ);
					presSplitList.setSd_pres(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_GFYLCFJ);
					presSplitList.setSd_prestpword(PKUSplitConst.SD_PRESCRIPTION_FLAG_YB);
					presSplitList.setId_prestpword(PKUSplitConst.ID_PRESCRIPTION_FLAG_YB);
				}

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
				outList.add(presSplitList);
			}

		}

		return outList;
	}
}

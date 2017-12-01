package iih.ci.ord.s.bp.splitlis.pku.prestype.rule;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
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
 * 门诊处方
 * @author li_zheng
 *
 */
public class PKUOutpatientPrescriptionTypeRule implements ICiOrPresSplitRule {

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
		List<OrderPresSplitDTO> listOP = new ArrayList<OrderPresSplitDTO>();
		List<OrderPresSplitDTO> listIp = new ArrayList<OrderPresSplitDTO>();
		List<OrderPresSplitDTO> listPE = new ArrayList<OrderPresSplitDTO>();
		List<OrderPresSplitDTO> listET = new ArrayList<OrderPresSplitDTO>();
		List<OrderPresSplitDTO> listFA = new ArrayList<OrderPresSplitDTO>();
		List<OrderPresSplitDTO> listES = new ArrayList<OrderPresSplitDTO>();
		for (OrderPresSplitDTO dto : orderList){
			
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(dto.getCode_entp())) {// 门诊
				listOP.add(dto);	 
			}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(dto.getCode_entp())){// 住院
				listIp.add(dto);
			}else if(IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(dto.getCode_entp())){// 体检
				listPE.add(dto);
			}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(dto.getCode_entp())){// 急诊
				listET.add(dto);
			}else if(IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(dto.getCode_entp())){// 家庭病房
				listFA.add(dto);
			}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ES.equals(dto.getCode_entp())){// 留观
				listES.add(dto);
			}
		} 
		if(listOP != null && listOP.size()>0 ){
			hpMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, listOP);
		}
		if(listIp != null && listIp.size()>0 ){
			hpMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, listIp);
		}
		if(listPE != null && listPE.size()>0 ){
			hpMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_PE, listPE);
		}
		if(listET != null && listET.size()>0 ){
			hpMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_ET, listET);
		}
		if(listFA != null && listFA.size()>0 ){
			hpMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_FA, listFA);
		}
		if(listES != null && listES.size()>0 ){
			hpMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_ES, listES);
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
			if (orderList != null && orderList.size() >0 && entry.getKey().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)) {
				CiOrPresSplitList presSplitList = new CiOrPresSplitList();
				 if(ps.getName() != null){
					    presSplitList.isAppRule = true;
					    presSplitList.setName(ps.getName());
						presSplitList.setId_prestp(ps.getId_prestp());
						presSplitList.setCode(ps.code);
						presSplitList.setSd_pres(ps.getSd_pres());
						presSplitList.setSd_prestpword(ps.getSd_prestpword());
						presSplitList.setId_prestpword(ps.getId_prestpword());
						presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
				 }else{
					    presSplitList.isAppRule = true;
						presSplitList.setId_prestp(PKUSplitConst.ID_UDIDOC_PKU_PRESCRIPTION_MZCFJ);
						presSplitList.setCode(ps.code);
						presSplitList.setName(PKUSplitConst.NAME_UDIDOC_PRESCRIPTION_MZCFJ);
						presSplitList.setSd_pres(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_MZCFJ);
						presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
						//presSplitList.setSd_prestpword(PKUSplitConst.SD_PRESCRIPTION_FLAG_JZ);
						//presSplitList.setId_prestpword(PKUSplitConst.ID_PRESCRIPTION_FLAG_JZ);
				 }
				 
				presSplitList.setOrderList(orderList);
				outList.add(presSplitList);
			}else if(orderList != null && orderList.size() >0 && entry.getKey().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)){
				CiOrPresSplitList presSplitList = new CiOrPresSplitList();
				if(ps.getName() != null){
				    presSplitList.isAppRule = true;
				    presSplitList.setName(ps.getName());
					presSplitList.setId_prestp(ps.getId_prestp());
					presSplitList.setCode(ps.code);
					presSplitList.setSd_pres(ps.getSd_pres());
					presSplitList.setSd_prestpword(ps.getSd_prestpword()+","+PKUSplitConst.SD_PRESCRIPTION_FLAG_JZ);
					presSplitList.setId_prestpword(ps.getId_prestpword()+","+PKUSplitConst.ID_PRESCRIPTION_FLAG_JZ);
					presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
					
				}else{
					presSplitList.isAppRule = true;
					presSplitList.setId_prestp(PKUSplitConst.ID_UDIDOC_PKU_PRESCRIPTION_JZCFJ);
					presSplitList.setCode(ps.code);
					presSplitList.setName(PKUSplitConst.NAME_UDIDOC_PRESCRIPTION_JZCFJ);
					presSplitList.setSd_pres(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_JZCFJ);
					presSplitList.setSd_prestpword(PKUSplitConst.SD_PRESCRIPTION_FLAG_JZ);
					presSplitList.setId_prestpword(PKUSplitConst.ID_PRESCRIPTION_FLAG_JZ);
					presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
				}
				presSplitList.setOrderList(orderList);
				outList.add(presSplitList);
			}else{
				//国际医院 住院 不确定
				CiOrPresSplitList presSplitList = new CiOrPresSplitList();
				presSplitList.isAppRule = true;
				presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
				 if(ps.getName() != null){
					    presSplitList.isAppRule = true;
					    presSplitList.setName(ps.getName());
						presSplitList.setId_prestp(ps.getId_prestp());
						presSplitList.setCode(ps.code);
						presSplitList.setSd_pres(ps.getSd_pres());
						presSplitList.setSd_prestpword(ps.getSd_prestpword()+","+PKUSplitConst.SD_PRESCRIPTION_FLAG_JZ);
						presSplitList.setId_prestpword(ps.getId_prestpword()+","+PKUSplitConst.ID_PRESCRIPTION_FLAG_JZ);
				 }else{
					    presSplitList.isAppRule = true;
						presSplitList.setId_prestp(PKUSplitConst.ID_UDIDOC_PKU_PRESCRIPTION_MZCFJ);
						presSplitList.setCode(ps.code);
						presSplitList.setName("住院");
						presSplitList.setSd_pres(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_MZCFJ);
						presSplitList.setSd_prestpword(PKUSplitConst.SD_PRESCRIPTION_FLAG_JZ);
						presSplitList.setId_prestpword(PKUSplitConst.ID_PRESCRIPTION_FLAG_JZ);
				 }
				presSplitList.setOrderList(orderList);
				outList.add(presSplitList);
			}

		}

		return outList;
	}

}

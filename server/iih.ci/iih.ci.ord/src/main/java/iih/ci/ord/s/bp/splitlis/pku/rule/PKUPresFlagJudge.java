package iih.ci.ord.s.bp.splitlis.pku.rule;

import iih.bd.bc.udi.pub.ISysDictCodeConst;
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
 * 判断标识
 * @author li_zheng
 *
 */
public class PKUPresFlagJudge implements ICiOrPresSplitRule {

	List<CiOrPresSplitList> outList;
	public Map<String, List> fgbaseMap = new HashMap<String, List>();

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
			    JudgeFlag(orderPresSplit);
				outList.add(orderPresSplit);
			}
	}
    
	 private void JudgeFlag(CiOrPresSplitList orderPresSplit){
		  String Sd_clinicalprofessiontp ="";
		  String Id_clinicalprofessiontp ="";
		  if(orderPresSplit != null && orderPresSplit.getOrderList().size() >0){
			  List<OrderPresSplitDTO> orderList = orderPresSplit.getOrderList();
			  for(OrderPresSplitDTO dto:orderList){
				  
				  if(dto.getSd_clinicalprofessiontp() !="" && ISysDictCodeConst.SD_CLINICALPROFESSIONTP_EK.equals(dto.getSd_clinicalprofessiontp())){
					  Sd_clinicalprofessiontp = PKUSplitConst.SD_PRESCRIPTION_FLAG_EK;
					  Id_clinicalprofessiontp = PKUSplitConst.ID_PRESCRIPTION_FLAG_EK;
				  }
				  if(dto.getFg_extdispense()==FBoolean.TRUE){				
					  Sd_clinicalprofessiontp +=","+ PKUSplitConst.SD_PRESCRIPTION_FLAG_WPY;
					  Id_clinicalprofessiontp +=","+ PKUSplitConst.ID_PRESCRIPTION_FLAG_WPY;
				  }
				  if(dto.getFg_vip()==FBoolean.TRUE){				
					  Sd_clinicalprofessiontp += ","+PKUSplitConst.SD_PRESCRIPTION_FLAG_VIP;
					  Id_clinicalprofessiontp += ","+PKUSplitConst.ID_PRESCRIPTION_FLAG_VIP;
				  }
				  if(dto.getFg_specill()==FBoolean.TRUE){				
					  Sd_clinicalprofessiontp += ","+PKUSplitConst.SD_PRESCRIPTION_FLAG_TSB;
					  Id_clinicalprofessiontp += ","+PKUSplitConst.ID_PRESCRIPTION_FLAG_TSB;
				  }
				  
				  break;
			  }
			  orderPresSplit.setSd_prestpword(orderPresSplit.getSd_prestpword() +","+Sd_clinicalprofessiontp);
			  orderPresSplit.setId_prestpword(orderPresSplit.getId_prestpword()+","+Id_clinicalprofessiontp);
		  }
	 }
	
	
	/**
	 * 分解 List<OrderPresSplitDTO>
	 * 
	 * @param orderList
	 */
	private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList) {
		for (OrderPresSplitDTO dto : orderList) {
			if(dto.getFg_base()==null)
				continue;
			if (dto.getFg_base()==FBoolean.TRUE) {
				if (fgbaseMap.containsKey(FBoolean.TRUE.toString())) {
					List<OrderPresSplitDTO> list1 = fgbaseMap.get(FBoolean.TRUE.toString());
					list1.add(dto);
					fgbaseMap.put(FBoolean.TRUE.toString(), list1);

				} else {
					List<OrderPresSplitDTO> list1 = new ArrayList<OrderPresSplitDTO>();
					list1.add(dto);
					fgbaseMap.put(FBoolean.TRUE.toString(), list1);
				}
			} else if(dto.getFg_base()==FBoolean.FALSE){

				if (fgbaseMap.containsKey(FBoolean.FALSE.toString())) {
					List<OrderPresSplitDTO> list1 = fgbaseMap.get(FBoolean.FALSE.toString());
					list1.add(dto);
					fgbaseMap.put(FBoolean.FALSE.toString(), list1);

				} else {
					List<OrderPresSplitDTO> list1 = new ArrayList<OrderPresSplitDTO>();
					list1.add(dto);
					fgbaseMap.put(FBoolean.FALSE.toString(), list1);
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

		if (this.fgbaseMap == null)
			return null;
		Iterator entrys = this.fgbaseMap.entrySet().iterator();
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
				presSplitList.setOrderList(orderList);
				outList.add(presSplitList);
			}

		}

		return outList;
	}

}

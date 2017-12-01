package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
/**
 * 药理学分方
 * @author li_zheng
 *
 */
public class PharmaPresSplitRule implements PresSplitBaseRule {
   
	List<OrderPresSplitList> outList;
	
	 List<OrderPresSplitDTO>   sdList = new ArrayList<OrderPresSplitDTO>();	
	 List<OrderPresSplitDTO>   Mental1List = new ArrayList<OrderPresSplitDTO>();	
	 List<OrderPresSplitDTO>   Mental2List = new ArrayList<OrderPresSplitDTO>();	
	 List<OrderPresSplitDTO>   OrdinaryList = new ArrayList<OrderPresSplitDTO>();
	 
	 
	
	@Override
	public List<OrderPresSplitList> exec(List<OrderPresSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		// 根据药品的属性  TODO
		
		outList = new ArrayList<OrderPresSplitList>();
		if(list != null)
		  {
			 AnalyzeOrderPresSplitList(list);
		  }
		return outList;
	}

	/**
	 * 
	 * @param orderpresSplitList
	 */
	 private  void AnalyzeOrderPresSplitList(List<OrderPresSplitList> orderpresSplitList){
		   for(OrderPresSplitList orderPresSplit:orderpresSplitList){
			   if(orderPresSplit.isAppRule){
				   List<OrderPresSplitDTO> orderList =  orderPresSplit.getOrderList();
				   AnalyzeOrderPresSplitDTO(orderList);
			   }
		   }
	 }
	 /**
	  * 
	  * @param orderPresSplitDTOList
	  */
	 private  void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderPresSplitDTOList){
		 
		
		    for(OrderPresSplitDTO  dto : orderPresSplitDTOList){
		    	
		    	String sdpois=dto.getSd_pois();
		    	
		    	
		    	
		    	//毒麻
				 if(sdpois!=null&&!sdpois.equals("0")){
					 
					 if(sdpois.equals("1")||sdpois.equals("2")||sdpois.equals("4")||sdpois.equals("5"))
					 {
						//精一
//					 sdList.add(dto);
//					 OrderPresSplitList splitList = new OrderPresSplitList();
//					 splitList.setName(PresConstant.POISONOUSANESTHESIA);
//					 splitList.setSd_pres(PresConstant.SD_POIS);
//					 splitList.setId_pres(PresConstant.ID_POIS);
//					 splitList.setOrderList(sdList);
//					 splitList.setCode(dto.getSd_srvtp());
//					 splitList.isAppRule = false;
//					 outList.add(splitList);
						 Mental1List.add(dto);
					 
					 }else if(sdpois.equals("3")){
						//精二
						 Mental2List.add(dto);
					 }
				 }else if(sdpois==null||sdpois.equals("0")){
					 OrdinaryList.add(dto);
				 }
				 
			
		    }
		    if(!ListUtil.isEmpty(Mental1List)){
			    OrderPresSplitList Mental1 = new OrderPresSplitList();
			    Mental1.setName(PresConstant.MENTAL1);
			    Mental1.setSd_pres(PresConstant.SD_MENTAL1);
			    Mental1.setId_pres(PresConstant.ID_MENTAL1);
			    Mental1.setCode(Mental1List.get(0).getSd_srvtp());
			    Mental1.isAppRule = false;
			    Mental1.setOrderList(Mental1List);
			    outList.add(Mental1);
		    }
		    if(!ListUtil.isEmpty(Mental2List)){
			    OrderPresSplitList Mental2 = new OrderPresSplitList();
			    Mental2.setName(PresConstant.MENTAL2);
			    Mental2.setSd_pres(PresConstant.SD_MENTAL2);
			    Mental2.setId_pres(PresConstant.ID_MENTAL2);
			    Mental2.isAppRule = false;
			    Mental2.setCode(Mental2List.get(0).getSd_srvtp());
			    Mental2.setOrderList(Mental2List);
			    outList.add(Mental2);
		    }
		    if(!ListUtil.isEmpty(OrdinaryList)){
			    OrderPresSplitList Ordinary = new OrderPresSplitList();
			    Ordinary.setName(PresConstant.ORDINARY);
			    Ordinary.setSd_pres(PresConstant.SD_ORDINARY);
			    Ordinary.setId_pres(PresConstant.ID_ORDINARY);
			    Ordinary.setCode(OrdinaryList.get(0).getSd_srvtp());
			    Ordinary.isAppRule=true;
			    Ordinary.setOrderList(OrdinaryList);
			    outList.add(Ordinary);
		    }
	 }

}

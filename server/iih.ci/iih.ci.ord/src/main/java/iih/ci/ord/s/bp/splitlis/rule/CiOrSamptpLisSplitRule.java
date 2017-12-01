package iih.ci.ord.s.bp.splitlis.rule;
import iih.ci.ord.s.bp.splitlis.rule.bp.CiOrNotSamptpLisSplitRuleBP;
import iih.ci.ord.s.bp.splitlis.rule.bp.CiOrSamptpLisSplitRule1BP;
import iih.ci.ord.splitlis.d.CiOrdLisSplitList;
import iih.ci.ord.splitlis.d.ICiOrLisSplitRule;
import iih.ci.ord.splitlis.d.LisOrderSplitDTO;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;

/**
 * 临床医嘱合单规则：标本类型合单规则
 */
public class CiOrSamptpLisSplitRule implements ICiOrLisSplitRule {
   
	List<CiOrdLisSplitList> outList;
	
	@Override
	public List<CiOrdLisSplitList> exec(List<CiOrdLisSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		// 根据药品的属性  TODO
		
		outList = new ArrayList<CiOrdLisSplitList>();
		if(list != null)
		  {
			AnalyzeOrderLisSplitList(list);
		  }
		return outList;
	}

	/**
	 * 
	 * @param orderpresSplitList
	 */
	 private  void AnalyzeOrderLisSplitList(List<CiOrdLisSplitList> orderpresSplitList){
		 
		   for(CiOrdLisSplitList orderPresSplit:orderpresSplitList){
			   if(orderPresSplit.isAppRule){
				   
				   Hashtable<String, List<LisOrderSplitDTO>> rnt = new Hashtable<String, List<LisOrderSplitDTO>>(); 
				   List<LisOrderSplitDTO> orderList =  orderPresSplit.getOrderList();
				   Hashtable<String, List<LisOrderSplitDTO>> htors8lis = AnalyzeOrderLisSplitDTO(orderList);				   
				   //标本分类规则1
				   HandleRule1( htors8lis,rnt);
				   //将不在规则中的数据存起来
				   HandleNotRule( htors8lis,rnt);
				   getOrderPresSplitList(orderPresSplit, rnt);
				   
			   }
		   }
	 }
	 
	 /** 
	  * @param orderPresSplitDTOList
	  */
	 private  Hashtable<String, List<LisOrderSplitDTO>> AnalyzeOrderLisSplitDTO(List<LisOrderSplitDTO> orderPresSplitDTOList){
		 
			Hashtable<String, List<LisOrderSplitDTO>> htors8lis = new Hashtable<String, List<LisOrderSplitDTO>>(); //
					
		    for(LisOrderSplitDTO  dto : orderPresSplitDTOList){
		    	
		    	if (htors8lis.containsKey(dto.getId_samptp())) {
					List<LisOrderSplitDTO> list = htors8lis.get(dto.getId_samptp());
					list.add(dto);
				} else {
					List<LisOrderSplitDTO> list = new ArrayList<LisOrderSplitDTO>();
					list.add(dto);
					htors8lis.put(dto.getId_samptp(), list);
				}
		    	
		    }
		    
		    return htors8lis;    		   
     }
	 
	 /**
		 * 返回的集合
		 * 
		 * @return
		 */
		private void getOrderPresSplitList(CiOrdLisSplitList  ps,Hashtable<String, List<LisOrderSplitDTO>> rnt) {
			
			if (rnt == null && rnt.isEmpty())
				return ;
			
			
			Iterator entrys = rnt.entrySet().iterator();

			while (entrys.hasNext()) {
				Map.Entry entry = (Map.Entry) entrys.next();
				String key = (String) entry.getKey();
				List<LisOrderSplitDTO> orderList = (List) entry.getValue();
				CiOrdLisSplitList split=new CiOrdLisSplitList();
				split.setAnnouncements(ps.getAnnouncements());
				split.setAppRule(ps.isAppRule());
				split.setId_dep_mp(ps.getId_dep_mp());
				split.setSampcoltime(ps.getSampcoltime());
				split.setSpecialneed(ps.getSpecialneed());
				split.setSrvca(ps.getSrvca());
				split.setSamptp(orderList.get(0).getId_samptp());
				split.setSamptpcode(key);
				split.setOrderList(orderList);
				outList.add(split);
				//split.set
			}
			return ;
		}
	 
	 
	 private void HandleRule1(Hashtable<String, List<LisOrderSplitDTO>> htors8lis,Hashtable<String, List<LisOrderSplitDTO>> rnt){
		 
		 CiOrSamptpLisSplitRule1BP rule1=new CiOrSamptpLisSplitRule1BP();
		   rule1.exec(htors8lis, rnt);
	 }
	 
	 private void HandleNotRule(Hashtable<String, List<LisOrderSplitDTO>> htors8lis,Hashtable<String, List<LisOrderSplitDTO>> rnt){
		 
		 CiOrNotSamptpLisSplitRuleBP rule1=new CiOrNotSamptpLisSplitRuleBP();
		   rule1.exec(htors8lis, rnt);
	 }
	

}

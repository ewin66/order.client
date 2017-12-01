package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

public class GetPresByOrBP implements PresSplitBaseRule {
	
	public  Map<String,List>  tmpMap = new HashMap<String,List>();
	public  Map<String,List>  notorMap = new HashMap<String,List>();
	List<OrderPresSplitList> orderPresSplitlist = new ArrayList<OrderPresSplitList>();
	

	@Override
	public List<OrderPresSplitList> exec(List<OrderPresSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		
		 if(list == null )return null;
		  for(OrderPresSplitList pressplitList :list){
			  AnalyzePresSplitList(pressplitList);
			 
		  }
		
		return this.orderPresSplitlist;
	}
   
     /**
      * 分解 OrderPresSplitList
      * @param pressplitList
      */
	private void AnalyzePresSplitList(OrderPresSplitList pressplitList){
		
		  if(pressplitList.isAppRule){
			  notorMap.clear();
			  tmpMap.clear();
			  List<OrderPresSplitDTO> orderList  = pressplitList.getOrderList();
			  AnalyzeOrderPresSplitDTO(orderList);
			  this.getOrderPresSplitList(pressplitList);
		  }else{
			  orderPresSplitlist.add(pressplitList);
		  }
	}
	
	/**
	 *  按医嘱分解 List<OrderPresSplitDTO>
	 * @param orderList
	 */
	 private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList){
		  for(OrderPresSplitDTO dto :orderList){
			  if(dto.getSd_srvtp()==null)
				  continue;
			  String srv=dto.getSd_srvtp().substring(0, 4);
			  String key=dto.getId_or();
			  if(srv.equals("0103")){
				 
				  
				   if(tmpMap.containsKey(key)){
					   List<OrderPresSplitDTO>  list = tmpMap.get(key);
					    list.add(dto);
				   }else{
					  List<OrderPresSplitDTO> list = new  ArrayList<OrderPresSplitDTO>();  
					   list.add(dto);
					   tmpMap.put(key,list);
				   }
				  
			  }
		  }
	 }
	 
 

     

    /**
     * 返回的集合
     * @return
     */
    private List<OrderPresSplitList>  getOrderPresSplitList(OrderPresSplitList ps){
    	
    	 if(this.tmpMap == null||this.tmpMap.isEmpty()) {
    		 orderPresSplitlist.add(ps);
    		 return orderPresSplitlist;
    	 }
    	  Iterator entrys = tmpMap.entrySet().iterator();
    	 while(entrys.hasNext()){
    		 Map.Entry entry = (Map.Entry)entrys.next();
    		 String key =  (String)entry.getKey();
    		 List<OrderPresSplitDTO> orderList = (List)entry.getValue();
    		  if(orderList != null){
    			  OrderPresSplitList presSplitList = new OrderPresSplitList();
    			 
    				  presSplitList.setName(ps.getName());
        			  presSplitList.setSd_pres(ps.getSd_pres());
        			  presSplitList.setId_pres(ps.getId_pres());
        			  presSplitList.setCode(ps.getCode());
        			  presSplitList.isAppRule = true;
        			  presSplitList.setOrderList(orderList);
    			  
    			  orderPresSplitlist.add(presSplitList);
    		  } 
    	 } 	
    	 
    
    	return orderPresSplitlist;
    }
	
	
}

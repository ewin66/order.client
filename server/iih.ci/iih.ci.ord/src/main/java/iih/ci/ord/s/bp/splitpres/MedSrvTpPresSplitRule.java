package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
/**
 * 服务类型分方
 * @author li_zheng
 *
 */
public class MedSrvTpPresSplitRule implements PresSplitBaseRule {
	
	public  Map<String,List>  tmpMap = new HashMap<String,List>();
	public  Map<String,List>  deptmpMap = new HashMap<String,List>();
	List<OrderPresSplitList> orderPresSplitlist = new ArrayList<OrderPresSplitList>();
	

	@Override
	public List<OrderPresSplitList> exec(List<OrderPresSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		//读取配置文件
	 	//判断 服务类型 分方     草药，中成药，注射药品
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
			  tmpMap.clear();
			  this.deptmpMap.clear();
			  List<OrderPresSplitDTO> orderList  = pressplitList.getOrderList();
			  AnalyzeOrderPresSplitDTO(orderList);
			  this.getOrderPresSplitList(pressplitList);
		  }else{
			  orderPresSplitlist.add(pressplitList);
		  }
	}
	
	/**
	 *  分解 List<OrderPresSplitDTO>
	 * @param orderList
	 */
	 private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList){
		  for(OrderPresSplitDTO dto :orderList){
			  if(dto.getSd_srvtp()==null)
				  continue;
			  String key=dto.getSd_srvtp().substring(0, 4);
			  if(this.GetMedSrvType().containsKey(key)){
				 
				  
				  String depkey=dto.getId_dep_or()+","+dto.getSd_srvtp().substring(0, 4);
				  if(this.GetMapDept().containsKey(depkey)){
					 if(this.deptmpMap.containsKey(depkey)){
						 List<OrderPresSplitDTO>  list = deptmpMap.get(depkey);
						    list.add(dto);
					 }else{
					  List<OrderPresSplitDTO> list = new  ArrayList<OrderPresSplitDTO>();  
					   list.add(dto);
					   deptmpMap.put(depkey,list);
					 }
				  }else{
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
	 }
	 
 
    /**
     * 返回的集合
     * @return
     */
    private List<OrderPresSplitList>  getOrderPresSplitList(){
    	
    	 if(this.tmpMap == null) return orderPresSplitlist;
    	  Iterator entrys = tmpMap.entrySet().iterator();
    	 while(entrys.hasNext()){
    		 Map.Entry entry = (Map.Entry)entrys.next();
    		 String key =  (String)entry.getKey();
    		 List<OrderPresSplitDTO> orderList = (List)entry.getValue();
    		  if(orderList != null){
    			  OrderPresSplitList presSplitList = new OrderPresSplitList();
    			  presSplitList.setName(((String[])this.GetMedSrvType().get(key))[2]);
    			  presSplitList.setSd_pres((((String[])this.GetMedSrvType().get(key))[0]));
    			  presSplitList.setId_pres((((String[])this.GetMedSrvType().get(key))[1]));
    			  presSplitList.setCode(key);
    			  presSplitList.isAppRule = true;
    			  presSplitList.setOrderList(orderList);
    			  orderPresSplitlist.add(presSplitList);
    		  } 
    	 } 	
    	return orderPresSplitlist;
    }
     

    /**
     * 返回的集合
     * @return
     */
    private List<OrderPresSplitList>  getOrderPresSplitList(OrderPresSplitList ps){
    	
    	 if(this.tmpMap == null&&this.tmpMap.isEmpty()) return orderPresSplitlist;
    	  Iterator entrys = tmpMap.entrySet().iterator();
    	  
    	 while(entrys.hasNext()){
    		 Map.Entry entry = (Map.Entry)entrys.next();
    		 String key =  (String)entry.getKey();
    		 List<OrderPresSplitDTO> orderList = (List)entry.getValue();
    		  if(orderList != null){
    			  OrderPresSplitList presSplitList = new OrderPresSplitList();
    			  if(this.GetMedSrvType().containsKey(key)){
    			  presSplitList.setName(((String[])this.GetMedSrvType().get(key))[2]);
    			  presSplitList.setSd_pres((((String[])this.GetMedSrvType().get(key))[0]));
    			  presSplitList.setId_pres((((String[])this.GetMedSrvType().get(key))[1]));
    			  presSplitList.setCode(ps.getCode());
    			  presSplitList.isAppRule = true;
    			  presSplitList.setOrderList(orderList);
    			  }else{
    				  presSplitList.setName(ps.getName());
        			  presSplitList.setSd_pres(ps.getSd_pres());
        			  presSplitList.setId_pres(ps.getId_pres());
        			  presSplitList.setCode(ps.getCode());
        			  presSplitList.isAppRule = true;
        			  presSplitList.setOrderList(orderList);
    			  }
    			  orderPresSplitlist.add(presSplitList);
    		  } 
    	 } 	
    	 
    	 if(this.deptmpMap==null&&this.deptmpMap.isEmpty()) return orderPresSplitlist;

    	 Iterator depentrys = this.deptmpMap.entrySet().iterator();
    	 while(depentrys.hasNext()){
    		 Map.Entry entry = (Map.Entry)depentrys.next();
    		 String key =  (String)entry.getKey();
    		 List<OrderPresSplitDTO> orderList = (List)entry.getValue();
    		  if(orderList != null){
    			  OrderPresSplitList presSplitList = new OrderPresSplitList();
    			 
    			  presSplitList.setName(((String[])this.GetMapDept().get(key))[2]);
    			  presSplitList.setSd_pres((((String[])this.GetMapDept().get(key))[0]));
    			  presSplitList.setId_pres((((String[])this.GetMapDept().get(key))[1]));
    			  presSplitList.setCode(ps.getCode());
    			  presSplitList.isAppRule = true;
    			  presSplitList.setOrderList(orderList);
    			 
    			  orderPresSplitlist.add(presSplitList);
    		  } 
    	 } 
    	return orderPresSplitlist;
    }
	
	private static  Map GetMedSrvType(){
		
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("0103" , new String[]{"07",PresConstant.ID_HERBAL,"草药"});
		map.put("0101", new String[]{"08",PresConstant.ID_EMERGENCY,"普通西药"});
		map.put("0102", new String[]{"09",PresConstant.ID_WESTERNMEDICINE,"成药"});
	 
		return map;
	}
	
	/**
	 * 临时方案  ，todo  以后修改成配置文件
	 * @return
	 */
	 private Map GetMapDept(){
		 Map<String, String[]> map = new HashMap<String,String[]>();
		 map.put( "0001AA1000000000YTUY,0101", new String[]{PresConstant.SD_childmed,PresConstant.ID_childmed,"儿科西药"} );
		 map.put( "0001AA1000000000YTUY,0102", new String[]{PresConstant.SD_childready,PresConstant.ID_childready,"儿科成药"} );
		 map.put( "0001AA1000000005Q4L9,0102", new String[]{PresConstant.SD_emready,PresConstant.ID_emready,"急诊科成药"});
		 map.put( "0001AA1000000005Q4L9,0101", new String[]{PresConstant.SD_OCONTROL,PresConstant.ID_CONTROL,"急诊科西药"});
		 return map;
		 
	 }
}

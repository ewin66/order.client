package iih.ci.ord.s.bp.splitlis.pku.rule;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;
import iih.ci.ord.s.bp.splitpres.OrderPresSplitList;
import iih.ci.ord.s.bp.splitpres.PresConstant;
import iih.ci.ord.s.bp.splitpres.PresSplitBaseRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
/**
 * 7.	大输液大类单独分方：当服务类型为【溶媒】时，并且不是成组医嘱时，单独成方
 * @author li_zheng
 *
 */
public class PKUInfusionSplitRule implements ICiOrPresSplitRule {
	
	public  Map<String,List>  tmpMap = new HashMap<String,List>();
	public  Map<String,List>  deptmpMap = new HashMap<String,List>();
	List<CiOrPresSplitList> outList = new ArrayList<CiOrPresSplitList>();
	

	@Override
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		 if(list == null )return null;
		  for(CiOrPresSplitList pressplitList :list){
			  AnalyzePresSplitList(pressplitList);
		  }
		
		return outList;
	}
   
     /**
      * 分解 OrderPresSplitList
      * @param pressplitList
      */
	private void AnalyzePresSplitList(CiOrPresSplitList pressplitList){
		
		  if(pressplitList.isAppRule){
			  tmpMap.clear();
			  //this.deptmpMap.clear();
			  List<OrderPresSplitDTO> orderList  = pressplitList.getOrderList();
			  AnalyzeOrderPresSplitDTO(orderList);
			  this.getOrderPresSplitList(pressplitList);
		  }else{
			  outList.add(pressplitList);
		  }
	}
	
	/**
	 *  分解 List<OrderPresSplitDTO>
	 * @param orderList
	 */
	 private void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderList){
		 CiOrPresSplitList orderPresSplit = new CiOrPresSplitList();
		  List<OrderPresSplitDTO> tempList = new  ArrayList<OrderPresSplitDTO>();  
		  orderPresSplit.setOrderList(tempList);
		  tmpMap.put("OTH", tempList);
		  for(OrderPresSplitDTO dto :orderList){
			  if(dto != null && dto.getSd_srvtp() != null && dto.getSd_srvtp().length()>5){
				  String key=dto.getSd_srvtp().substring(0, 6);
				  if(this.GetMedSrvType().containsKey(key)){
					  String depkey=dto.getId_or()+","+dto.getSd_srvtp().substring(0, 4);		 
					   if(tmpMap.containsKey(depkey)){
						   List<OrderPresSplitDTO>  list = tmpMap.get(depkey);
						    list.add(dto);
					   }else{
						  List<OrderPresSplitDTO> list = new  ArrayList<OrderPresSplitDTO>();  
						   list.add(dto);
						   tmpMap.put(depkey,list);
					   }
				  }else{
					  tempList.add(dto);
				  }
			  }else{
				  tempList.add(dto);
			  }
		  }
	 }
	 
 
    /**
     * 返回的集合
     * @return
     */
   /* private List<CiOrPresSplitList>  getOrderPresSplitList(){
    	
    	 if(this.tmpMap == null) return orderPresSplitlist;
    	  Iterator entrys = tmpMap.entrySet().iterator();
    	 while(entrys.hasNext()){
    		 Map.Entry entry = (Map.Entry)entrys.next();
    		 String key =  (String)entry.getKey();
    		 List<OrderPresSplitDTO> orderList = (List)entry.getValue();
    		  if(orderList != null){
    			  CiOrPresSplitList presSplitList = new CiOrPresSplitList();
				presSplitList.setId_pres(ps.getId_pres());
				presSplitList.setCode(ps.code);
				presSplitList.setSd_pres(ps.getSd_pres());
				presSplitList.setSd_prestpword(ps.getSd_prestpword());
				presSplitList.setId_prestpword(ps.getId_prestpword());
    			  presSplitList.isAppRule = true;
    			  presSplitList.setOrderList(orderList);
    			  orderPresSplitlist.add(presSplitList);
    		  } 
    	 } 	
    	return orderPresSplitlist;
    }*/
     

    /**
     * 返回的集合
     * @return
     */
    private List<CiOrPresSplitList>  getOrderPresSplitList(CiOrPresSplitList ps){
    	
    	 if(this.tmpMap == null&&this.tmpMap.isEmpty()) return outList;
    	  Iterator entrys = tmpMap.entrySet().iterator();
    	  
    	 while(entrys.hasNext()){
    		 Map.Entry entry = (Map.Entry)entrys.next();
    		 String key =  (String)entry.getKey();
    		 List<OrderPresSplitDTO> orderList = (List)entry.getValue();
    		  if(orderList != null && orderList.size() >0){
    			  CiOrPresSplitList presSplitList = new CiOrPresSplitList();
    			 // if(this.GetMedSrvType().containsKey(key)){
	    			  presSplitList.setName(ps.getName());
	    			  presSplitList.setSd_pres(ps.getSd_pres());
	    			  presSplitList.setId_prestp(ps.getId_prestp());
	    			  presSplitList.setCode(ps.getCode());
	    			  presSplitList.setSd_prestpword(ps.getSd_prestpword());
	    			  presSplitList.setId_prestpword(ps.getId_prestpword());
	    			  presSplitList.isAppRule = true;
	    			  presSplitList.setOrderList(orderList);
    			  /*}else{
    				  presSplitList.setName(ps.getName());
        			  presSplitList.setSd_pres(ps.getSd_pres());
        			  presSplitList.setId_pres(ps.getId_pres());
        			  presSplitList.setCode(ps.getCode());
    				  presSplitList.setSd_prestpword(ps.getSd_prestpword());
    				  presSplitList.setId_prestpword(ps.getId_prestpword());
        			  presSplitList.isAppRule = true;
        			  presSplitList.setOrderList(orderList);
    			  }*/
    			  outList.add(presSplitList);
    		  } 
    	 } 	
    	 
    	/* if(this.deptmpMap==null&&this.deptmpMap.isEmpty()) return orderPresSplitlist;

    	 Iterator depentrys = this.deptmpMap.entrySet().iterator();
    	 while(depentrys.hasNext()){
    		 Map.Entry entry = (Map.Entry)depentrys.next();
    		 String key =  (String)entry.getKey();
    		 List<OrderPresSplitDTO> orderList = (List)entry.getValue();
    		  if(orderList != null){
    			  CiOrPresSplitList presSplitList = new CiOrPresSplitList();
    			 
    			  presSplitList.setName(((String[])this.GetMapDept().get(key))[2]);
    			  presSplitList.setSd_pres((((String[])this.GetMapDept().get(key))[0]));
    			  presSplitList.setId_pres((((String[])this.GetMapDept().get(key))[1]));
    			  presSplitList.setCode(ps.getCode());
    			  presSplitList.isAppRule = true;
    			  presSplitList.setOrderList(orderList);
    			 
    			  orderPresSplitlist.add(presSplitList);
    		  } 
    	 } */
    	return outList;
    }
	
	private static  Map GetMedSrvType(){
		
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("010104", new String[]{"08",PresConstant.ID_EMERGENCY,"溶媒"});
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

package iih.ci.ord.s.bp.splitlis.pku.rule;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;
import iih.ci.ord.s.bp.splitpres.PresConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
/**
 * 6.	成组：成组医嘱打印在一张方上，一个成组医嘱一个处方，如果组内药品是不同的处方笺类型，则分别打印
 * @author li_zheng
 *
 */
public class PKUGroupDrugSplitRule implements ICiOrPresSplitRule {
	
	public  Map<String,List>  tmpMap = new HashMap<String,List>();
	public  Map<String,List>  deptmpMap = new HashMap<String,List>();
	List<CiOrPresSplitList>   outList = new ArrayList<CiOrPresSplitList>();
	public  Map<String,List>  GroupMap = new HashMap<String,List>();
    public  final static  String  Group ="Group";
    public boolean  Isgroup = false;
    

	@Override
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		//读取配置文件
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
			  this.deptmpMap.clear();
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
		  Map map  =new HashMap();
		  for(OrderPresSplitDTO dto :orderList){
			  if(dto.getSd_srvtp()==null) continue;
			  String key = dto.getSd_srvtp().substring(0, 4);
			  if(dto.getFg_base().booleanValue()){
	    		  key = "true";
	    	  }
			 
			  
			  if(!JudgeGroupDrug(orderList,dto)){//待优化 //TODO
   			     key="GROUP"+ dto.getId_or()+dto.getSd_srvtp().substring(0, 4);
	   		   }else if(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY.equals(dto.getSd_srvtp())){
				  key = dto.getSd_srvtp().substring(0, 6);
			  }
			  if(IBdMmDictCodeConst.SD_POIS_POISON.equals(dto.getSd_pois())){
				  key =IBdMmDictCodeConst.SD_POIS_POISON; //毒性药品
			  }else if(IBdMmDictCodeConst.SD_POIS_JINGSHEN_1.equals(dto.getSd_pois())||
					  IBdMmDictCodeConst.SD_POIS_MAZUI.equals(dto.getSd_pois())){
				  key =IBdMmDictCodeConst.SD_POIS_JINGSHEN_1; //麻醉药品 一类精神药品
			  }else if(IBdMmDictCodeConst.SD_POIS_JINGSHEN_2.equals(dto.getSd_pois())){
				  key = IBdMmDictCodeConst.SD_POIS_JINGSHEN_2;//二类精神药品
			  }
			  
			  if(this.tmpMap.containsKey(key)){
					 List<OrderPresSplitDTO>  list = tmpMap.get(key);
					 list.add(dto);
				 }else{
					 List<OrderPresSplitDTO> list = new  ArrayList<OrderPresSplitDTO>();  
					 list.add(dto);
					 tmpMap.put(key,list);
				 }
			  
			  
			  
			  
			     /* if(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX.equals(dto.getSd_srvtp()) ||
			    	 IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY.equals(dto.getSd_srvtp())){
			    	  String depkey="GROUP"+dto.getSd_srvtp().substring(0, 4);
			    	  
			    	  if(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY.equals(dto.getSd_srvtp())){
			    		   if(JudgeGroupDrug(orderList,dto)){
			    			   depkey="GROUP"+ dto.getId_or()+dto.getSd_srvtp().substring(0, 6);
			    		   }else{
			    			   depkey="GROUP"+dto.getSd_srvtp().substring(0, 4);
			    		   }
			    	  }*/
			    	  
			    /*	  if(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX.equals(dto.getSd_srvtp())){
			    		  if(JudgeGroupDrug(orderList,dto)){
			    			   depkey="GROUP"+ dto.getId_or()+dto.getSd_srvtp().substring(0, 6);
			    		   }else{
			    			   depkey="GROUP"+ dto.getId_or()+dto.getSd_srvtp().substring(0, 4);
			    		   }
			    	  }*/
			    	
			    	/*  if(dto.getFg_base().booleanValue()){
			    		  depkey = "true";
			    	  }
			    	  if(!IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(dto.getSd_srvtp().substring(0, 4)) && IBdMmDictCodeConst.SD_POIS_POISON.equals(dto.getSd_pois())){
			    		  depkey =IBdMmDictCodeConst.SD_POIS_POISON;
			    	  }else if(!IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(dto.getSd_srvtp().substring(0, 4)) && (IBdMmDictCodeConst.SD_POIS_JINGSHEN_1.equals(dto.getSd_pois())||
							  IBdMmDictCodeConst.SD_POIS_MAZUI.equals(dto.getSd_pois()))){
			    		  depkey = IBdMmDictCodeConst.SD_POIS_JINGSHEN_1;
			    	  }else if(!IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(dto.getSd_srvtp().substring(0, 4)) && IBdMmDictCodeConst.SD_POIS_JINGSHEN_2.equals(dto.getSd_pois())){
			    		  depkey = IBdMmDictCodeConst.SD_POIS_JINGSHEN_2;
			    	  }*/
			    	 
			    	  
					/*	 if(this.tmpMap.containsKey(depkey)){
							 List<OrderPresSplitDTO>  list = tmpMap.get(depkey);
							 list.add(dto);
						 }else{
							 List<OrderPresSplitDTO> list = new  ArrayList<OrderPresSplitDTO>();  
							 list.add(dto);
							 tmpMap.put(depkey,list);
						 }*/
			      /*}else{
			    	  String depkey= dto.getSd_srvtp().substring(0, 4);
			    	  if(dto.getFg_base().booleanValue()){
			    		  depkey = "true";
			    	  }
			    	  if(!IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(dto.getSd_srvtp().substring(0, 4)) && IBdMmDictCodeConst.SD_POIS_POISON.equals(dto.getSd_pois())){
			    		  depkey =IBdMmDictCodeConst.SD_POIS_POISON;
			    	  }else if(!IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(dto.getSd_srvtp().substring(0, 4)) && (IBdMmDictCodeConst.SD_POIS_JINGSHEN_1.equals(dto.getSd_pois())||
							  IBdMmDictCodeConst.SD_POIS_MAZUI.equals(dto.getSd_pois()))){
			    		  depkey = IBdMmDictCodeConst.SD_POIS_JINGSHEN_1;
			    	  }else if(!IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(dto.getSd_srvtp().substring(0, 4)) && IBdMmDictCodeConst.SD_POIS_JINGSHEN_2.equals(dto.getSd_pois())){
			    		  depkey = IBdMmDictCodeConst.SD_POIS_JINGSHEN_2;
			    	  }
						 if(this.tmpMap.containsKey(depkey)){
							 List<OrderPresSplitDTO>  list = tmpMap.get(depkey);
							 list.add(dto);
						 }else{
							 List<OrderPresSplitDTO> list = new  ArrayList<OrderPresSplitDTO>();  
							 list.add(dto);
							 tmpMap.put(depkey,list);
						 }
			      }*/
			      
			}
        }
	 
	 
	 /**
	  * 
	  * @param orderList
	  * @param dto
	  * @return
	  */
	 private boolean JudgeGroupDrug(List<OrderPresSplitDTO> orderList,OrderPresSplitDTO orderPresDTO){
		 int  num = 0;
		 if(orderList != null && orderPresDTO != null){
			  for(OrderPresSplitDTO dto :orderList){
				  if(orderPresDTO.getId_or() != null  && orderPresDTO.getId_or().equals(dto.getId_or())){
					  num++;
				  }
			  }  
		} 
		if(num <=1){
			return true;
		}else{
			return false;
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
    		 JudgeGroup(orderList);
    		 
    		 if(GroupMap != null && GroupMap.size() >0){
    			 Iterator tempentry = tmpMap.entrySet().iterator();
    			 while(tempentry.hasNext()){
    				 Map.Entry temp = (Map.Entry)tempentry.next();
    				 String tempkey = (String)temp.getKey();
    				 List<OrderPresSplitDTO>  listDto = (List)temp.getValue();
    				 
    				 CiOrPresSplitList presSplitList = new CiOrPresSplitList();
    	    		    //if(orderList != null && orderList.size() >0){
    	    			 
    	    			  //if(this.GetMedSrvType().containsKey(key)){
    		    			  presSplitList.setName(ps.getName());
    		    			  presSplitList.setSd_pres(ps.getSd_pres());
    		    			  presSplitList.setId_prestp(ps.getId_prestp());
    		    			  presSplitList.setCode(ps.getCode());
    		    			  if(key.endsWith(IBdMmDictCodeConst.SD_MMTP_DRUG_CHIHE)){
    		    				  presSplitList.setSd_prestpword(ps.getSd_prestpword() );
    			    			  presSplitList.setId_prestpword(ps.getId_prestpword() );  
    		    			  }else{
    		    				  presSplitList.setSd_prestpword(ps.getSd_prestpword());
    			    			  presSplitList.setId_prestpword(ps.getId_prestpword());
    		    			  }
    		    			  presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
    		    			  if( tempkey != null && tempkey.startsWith("GROUP")){
    		    				  if(Isgroup){
    		    					  presSplitList.isAppRule = true;
    		    				  }else{
    		    					  presSplitList.isAppRule = false; 
    		    				  }
    		    				  
    		    			  }else{
    		    				  presSplitList.isAppRule = true;
    		    			  }
    		    			
    		    			  presSplitList.setOrderList(orderList);
    	    			  /*}else{
    	    				  presSplitList.setName(ps.getName());
    	        			  presSplitList.setSd_pres(ps.getSd_pres());
    	        			  presSplitList.setId_prestp(ps.getId_prestp());
    	        			  presSplitList.setSd_prestpword(ps.getSd_prestpword());
    		    			  presSplitList.setId_prestpword(ps.getId_prestpword());
    	        			  presSplitList.setCode(ps.getCode());
    	        			  presSplitList.isAppRule = true;
    	        			  presSplitList.setOrderList(orderList);
    	    			  }*/
    	    			  outList.add(presSplitList);
    			 }
    			 
    			 
    		  }else{
    		  if(orderList != null && orderList.size() >0){
    			  CiOrPresSplitList presSplitList = new CiOrPresSplitList();
    			  //if(this.GetMedSrvType().containsKey(key)){
    				    presSplitList.setName(ps.getName());
    					presSplitList.setId_prestp(ps.getId_prestp());
    					presSplitList.setCode(ps.code);
    					presSplitList.setSd_pres(ps.getSd_pres());
    					presSplitList.setSd_prestpword(ps.getSd_prestpword());
    					presSplitList.setId_prestpword(ps.getId_prestpword());
    					if(key != null && key.startsWith("GROUP")){
    						  if(Isgroup){
		    					  presSplitList.isAppRule = true;
		    				  }else{
		    					  presSplitList.isAppRule = false; 
		    				  }
    					}else{
    						presSplitList.isAppRule = true;
    					}
    			     
    			        presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
    			        presSplitList.setOrderList(orderList);
    			/*  }else{
    				  presSplitList.setName(ps.getName());
        			  presSplitList.setSd_pres(ps.getSd_pres());
        			  presSplitList.setId_pres(ps.getId_pres());
        			  presSplitList.setCode(ps.getCode());
        			  presSplitList.isAppRule = true;
        			  presSplitList.setOrderList(orderList);
    			  }*/
    			        outList.add(presSplitList);
    		  } 
    	 } 	
    	 
    /*	 if(this.deptmpMap==null&&this.deptmpMap.isEmpty()) return orderPresSplitlist;

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
    	  } */
    	 }
    	return outList;
    }
	
    
    /**
	 * 判断是否成组药
	 * @param orderList
	 * @return
	 */
   private  void JudgeGroup(List<OrderPresSplitDTO> orderList){
	   if(orderList != null && orderList.size() >5){
		   Map<String,List> map  = new HashMap<>();
		   List<OrderPresSplitDTO>  tempList = new ArrayList<>();
		   for(OrderPresSplitDTO dto:orderList){
			   if(map != null && map.containsKey(dto.getId_or())){
				   tempList  = map.get(dto.getId_or());
				   tempList.add(dto);	   
			   }else{
				   tempList = new ArrayList<>();
				   tempList.add(dto);
				   map.put(dto.getId_or(), tempList);
			   }
		   }
		   if(map != null){
			   if(map.size() == orderList.size()){
				   Isgroup = true;
			   }
		    Iterator entrys = map.entrySet().iterator();
		    List<OrderPresSplitDTO> addList = new ArrayList<>();
	    	 while(entrys.hasNext()){
	    		 Map.Entry entry = (Map.Entry)entrys.next();
	    		 String  key = (String)entry.getKey();
	    		 List<OrderPresSplitDTO> temlsit = (List)entry.getValue();
	    		 if(temlsit != null  && temlsit.size()  >5){
	    			 GroupMap.put(key, temlsit);
	    		 }else{
	    			 addList.addAll(temlsit);
	    			 GroupMap.put(Group, addList); 
	    		 }
	    	 }
		   }
	   }
	   
   }
	private static  Map GetMedSrvType(){
		
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("0103" , new String[]{"07",PresConstant.ID_HERBAL,"草药"});
		map.put("0101", new String[]{"08",PresConstant.ID_EMERGENCY,"普通西药"});
		map.put("0102", new String[]{"09",PresConstant.ID_WESTERNMEDICINE,"成药"});
	 
		return map;
	}
	

}

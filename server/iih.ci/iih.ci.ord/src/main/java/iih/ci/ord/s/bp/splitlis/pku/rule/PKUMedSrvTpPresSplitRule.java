package iih.ci.ord.s.bp.splitlis.pku.rule;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
/**
 * 药品类别
 * 2.	：西药、中成药、草药（一个草药医嘱一个处方，分处方类型时，以草药医嘱为单位区分）
 * @author li_zheng
 *
 */
public class PKUMedSrvTpPresSplitRule implements ICiOrPresSplitRule {
	
	public  Map<String,List>  tmpMap = new HashMap<String,List>();
	public  Map<String,List>  deptmpMap = new HashMap<String,List>();
	List<CiOrPresSplitList> outList = new ArrayList<CiOrPresSplitList>();
	
	@Override
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		//读取配置文件
	 	//判断 服务类型 分方     草药，中成药，注射药品
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
			 // this.deptmpMap.clear();
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
		  List<OrderPresSplitDTO> tempList = new  ArrayList<OrderPresSplitDTO>();  
		  tmpMap.put("OTH",tempList);
		  for(OrderPresSplitDTO dto :orderList){
			  if(dto.getSd_srvtp()==null || dto.getSd_mmtp() == null)
				  continue;
			 
			   if(dto.getSd_mmtp() != null && IBdMmDictCodeConst.SD_MMTP_DRUG_WEST.equals(dto.getSd_mmtp())){
				  if(tmpMap.containsKey(dto.getSd_mmtp())){
					   List<OrderPresSplitDTO>  list = tmpMap.get(dto.getSd_mmtp());
					    list.add(dto);
				   }else{
					  List<OrderPresSplitDTO> list = new  ArrayList<OrderPresSplitDTO>();  
					   list.add(dto);
					   tmpMap.put(dto.getSd_mmtp(),list);
				   }
			   }else if(dto.getSd_mmtp() != null && IBdMmDictCodeConst.SD_MMTP_DRUG_CHIPA.equals(dto.getSd_mmtp())){
				  String depkey= dto.getSd_mmtp();
				   if(tmpMap.containsKey(depkey)){
					   List<OrderPresSplitDTO>  list = tmpMap.get(depkey);
					    list.add(dto);
				   }else{
					  List<OrderPresSplitDTO> list = new  ArrayList<OrderPresSplitDTO>();  
					   list.add(dto);
					   tmpMap.put(depkey,list);
				   }
			  
			  }else if(dto.getSd_mmtp() != null && IBdMmDictCodeConst.SD_MMTP_DRUG_CHIHE.equals(dto.getSd_mmtp())){
				   String depkey="DRUG_CHIHE"+dto.getId_or()+","+dto.getSd_srvtp().substring(0, 4);
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
		  }
	 }
	 

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
    		    CiOrPresSplitList presSplitList = new CiOrPresSplitList();
    		    //if(orderList != null && orderList.size() >0){
    			 
    			  //if(this.GetMedSrvType().containsKey(key)){
	    			  presSplitList.setName(ps.getName());
	    			  presSplitList.setSd_pres(ps.getSd_pres());
	    			  presSplitList.setId_prestp(ps.getId_prestp());
	    			  presSplitList.setCode(ps.getCode());
	    			  if(key.endsWith(IBdMmDictCodeConst.SD_MMTP_DRUG_CHIHE)){
	    				  presSplitList.setSd_prestpword(ps.getSd_prestpword()+","+IBdSrvDictCodeConst.SD_PRESCRIPTION_FLAG_CY);
		    			  presSplitList.setId_prestpword(ps.getId_prestpword()+","+IBdSrvDictCodeConst.ID_PRESCRIPTION_FLAG_CY);  
	    			  }else{
	    				  presSplitList.setSd_prestpword(ps.getSd_prestpword());
		    			  presSplitList.setId_prestpword(ps.getId_prestpword());
	    			  }
	    			  presSplitList.setFg_hp_pres(ps.getFg_hp_pres());
	    			  if(key != null && key.startsWith("DRUG_CHIHE")){
	    				  presSplitList.isAppRule = false; //草药不在执行以后规则
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
               
    	    return outList;
    	 } 	

    	
    
    	 /*if(this.deptmpMap==null&&this.deptmpMap.isEmpty()) return orderPresSplitlist;

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
    	return orderPresSplitlist;*/
    //}
	
	private static  Map GetMedSrvType(){
		
		Map<String,String[]> map = new HashMap<String,String[]>();
		//map.put("0103" , new String[]{"07",PresConstant.ID_HERBAL,"草药"});
		//map.put("0101", new String[]{"08",PresConstant.ID_EMERGENCY,"普通西药"});
		//map.put("0102", new String[]{"09",PresConstant.ID_WESTERNMEDICINE,"成药"});
	 
		return map;
	}
	
	/**
	 * 临时方案  ，todo  以后修改成配置文件
	 * @return
	 */
//	 private Map GetMapDept(){
//		 Map<String, String[]> map = new HashMap<String,String[]>();
//		 map.put( "0001AA1000000000YTUY,0101", new String[]{PresConstant.SD_childmed,PresConstant.ID_childmed,"儿科西药"} );
//		 map.put( "0001AA1000000000YTUY,0102", new String[]{PresConstant.SD_childready,PresConstant.ID_childready,"儿科成药"} );
//		 map.put( "0001AA1000000005Q4L9,0102", new String[]{PresConstant.SD_emready,PresConstant.ID_emready,"急诊科成药"});
//		 map.put( "0001AA1000000005Q4L9,0101", new String[]{PresConstant.SD_OCONTROL,PresConstant.ID_CONTROL,"急诊科西药"});
//		 return map;
//		 
//	 }

}

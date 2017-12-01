package iih.ci.ord.s.bp;


import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医保医嘱和诊断的强制关系
 * @author li_zheng
 *
 */
public class ValidateOrderAndDiagBP {
    /**
     * 医保医嘱和诊断的关系
     * @param id_ent
     * @param id_hp
     * @param id_srvs
     * @return
     * @throws BizException
     */
	public FMap getValidateOrderAndDiag(String id_ent,String id_hp,String[] id_srvs)throws BizException{
		FMap map  = CiOrdAppUtils.getIBdHpQryService().getHpSrvCtrDiList(id_hp, id_srvs);
		if(map.isEmpty()) return null;
		FArrayList2 list = CiOrdUtils.getDiagItemList(id_ent);
		Map  DiMap = getDiagMap(list);
		
		return IsCompulsionRelation(map,id_srvs,DiMap);	
	}
	/**
	 * 
	 * @param map
	 * @param id_srvs
	 * @param ItemDIlist
	 * @return
	 */
	private FMap IsCompulsionRelation(FMap map,String[] id_srvs ,Map  CiDiMap)throws BizException{
		FMap   diMap = new FMap();
		if(!map.isEmpty()){
	      for(String key:id_srvs){
	    	  List<String> DiList =(List<String>)map.get(key);
	    	  if(DiList== null)continue;
	    	  for(String id_def:DiList){
	    		  if(!CiDiMap.containsKey(id_def)){
	    			  diMap.put(id_def, id_def);
	    		  }
	    	  }
	      }
		}
		if(!diMap.isEmpty()){
			return getbdDIdefName(diMap);
		}
		return null;
	}
	/**
	 * 诊断名称 和 诊断的 id_didef
	 * @param diMap
	 * @return
	 * @throws BizException
	 */
	private FMap getbdDIdefName(FMap diMap)throws BizException{
		FMap map = new FMap();
		if(diMap.isEmpty())return null;
		String id_didfe = "select id_didef ,name from bd_di_def  where id_didef in ("+CiOrdUtils.getFMapKeyConveretstr(diMap)+")";
	    DAFacade  df= new DAFacade();
	    List<DiagDefDO> diagdefDO =  (List<DiagDefDO>)df.execQuery(id_didfe, new BeanListHandler(DiagDefDO.class));
	    if(diagdefDO != null){
	    	for(DiagDefDO diag :diagdefDO){
	    		map.put(diag.getId_didef(), diag.getName());
	    	}
	    }
	    return map;
	}
	
	/**
	 * 诊断的  
	 *  kye id_didef 
	 *  value  诊断名称
	 * @return
	 */
	public Map getDiagMap(FArrayList2 ItemDIlist){
		 Map  map = new HashMap();
		  for(int i=0;i<ItemDIlist.size();i++){
			  CiDiagItemDO item = (CiDiagItemDO)ItemDIlist.get(i);
			  map.put(item.getId_didef(), item.getDidef_name()); 
		  }
		  return map;
	}
}

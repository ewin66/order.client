package iih.ci.ord.s.bp;

import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 删除自费诊断的提示
 * @author li_zheng
 *
 */
public class getUsedHpdiexpenseseBP {
	/**
	public String JudgeOwnExpenseDiag(String id_en, String Id_didef)throws BizException{
		String[] idorsrv= getEffectiveCiorderAggDO(id_en);
		if(idorsrv== null || idorsrv.length==0) return null;
	    FMap map = CiOrdAppUtils.getIBlOutQryService().getOrSrvStStatus(idorsrv);
		String key =  MapToString(map);
		if(key  != null){
			 FArrayList2 list2 = CiOrdUtils.getDiagItemList(id_en);
			 Map mapExpebses = getHpdiexpensese(list2);
			 String sql = " Id_didef ='"+ Id_didef +"' and Fg_entp_op ='Y' ";
			 if(mapExpebses != null && mapExpebses.size()>1 && mapExpebses.containsKey(Id_didef)){
				 return null;
			 }
			 BdHpDiExpenseSelfDO[] hpDiag= CiOrdAppUtils.getIHpdiexpenseself().find(sql, "", FBoolean.FALSE);
			 if(hpDiag != null && hpDiag.length >0){
				 return "有自费诊断不能删除"; 
			  } 
	  	 } 
       return null;
	}
	*/
	/**
	 * 通过费用接口判断保外诊断下是否有未结算的医嘱
	 * @author yzh
	 * @param id_en
	 * @param Id_didef
	 * @return
	 * @throws BizException
	 */
	public String JudgeOwnExpenseDiag(String id_en, String Id_didef)throws BizException{
		String[] idorsrv= getEffectiveCiorderAggDO(id_en);
		if(idorsrv== null || idorsrv.length==0) return null;
	    FMap map = CiOrdAppUtils.getIBlOutQryService().getOrSrvStStatus(idorsrv);
		String key =  MapToString(map);
		if(key  != null){
			 String sql = " Id_didef ='"+ Id_didef +"' and Fg_entp_op ='Y' ";
			 BdHpDiExpenseSelfDO[] hpDiag= CiOrdAppUtils.getIHpdiexpenseself().find(sql, "", FBoolean.FALSE);
			 if(hpDiag != null && hpDiag.length >0){
				 return "有自费诊断不能删除"; 
			  } 
	  	 } 
       return null;
	}
	
	private  Map<String,String> getHpdiexpensese(FArrayList2 list2){
		Map map = new HashMap();
		if(list2 != null && list2.size() >0){
			for(int i =0;i<list2.size();i++){
				CiDiagItemDO itemDO =(CiDiagItemDO)list2.get(i);
				if(itemDO != null && "1".equals(itemDO.getEu_hpbeyond())){
					map.put(itemDO.getId_didef(), itemDO.getId_didef_code());
				}
			}
		}
		return map;
	}
	/**
	 * 有效医嘱的项目
	 * @param id_ent
	 * @return
	 */
	private String[] getEffectiveCiorderAggDO(String id_ent)throws BizException{
		 List list = new ArrayList();
		 String  ci_ordersql = " id_en ='"+id_ent+"' and fg_canc='N' and sd_su_bl != '2' ";
		 CiorderAggDO[] aggs = CiOrdAppUtils.getOrAggQryService().find(ci_ordersql, "", FBoolean.FALSE);
		 if(aggs != null && aggs.length >0)	{
			 if(aggs != null && aggs.length >0){
				 for(CiorderAggDO aggdo: aggs){
					for(OrdSrvDO ordsrvdo :aggdo.getOrdSrvDO()){
						list.add(ordsrvdo.getId_orsrv());
					}  
				  }
	           }
          }
		 if(list != null && list.size() >0){
			 return (String[])list.toArray(new String[list.size()]); 
		 }
		return null;
   }
	/**
	 * 
	 * @param map
	 * @return
	 */
    private String MapToString(FMap map){
		if(map ==null || map.size()==0)return null;
		StringBuffer sb = new StringBuffer();
		for(String key : map.keySet()){ 
			   FBoolean  value = (FBoolean)map.get(key);
			   if(value == FBoolean.FALSE){
				 return key;
			   }
		} 
		return null;
	}		
}

package iih.ci.ord.s.bp;

import iih.ci.diag.dto.d.IpViewDiagDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.d.desc.EntDiDODesc;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class getCiDiagItemDOListBP {
	
	 public IpViewDiagDTO[] exec(String id_ent)throws BizException{
		 
		/* ICidiagQryService  service = ServiceFinder.find(ICidiagQryService.class);
		 return  service.getCiDiagItemDOlist(id_ent);*/
		 String wherestr = EntDiDODesc.TABLE_ALIAS_NAME+"."+EntDiDO.ID_ENT +"='"+id_ent+"'";
		  EntDiDO[] entdidos = CiOrdAppUtils.getIEntdiRService().find(wherestr, EntDiDO.SORTNO, FBoolean.FALSE);
		  if(entdidos == null)  return null;
		   Map<String,IpViewDiagDTO>  map  = new HashMap();	
		   String  fg_maj= "";
		   for(EntDiDO entdi:entdidos){
			   if(map != null && map.containsKey(entdi.getCode_didef_dis()))continue;
			   IpViewDiagDTO diag = new IpViewDiagDTO();
			   if(entdi.getFg_maj()==FBoolean.TRUE){
				   fg_maj +="★";
			   } 
			   if(entdi.getFg_suspdi()==FBoolean.TRUE){
				   fg_maj +="?"; 
			   }
			   diag.setName(entdi.getName_didef_dis()+fg_maj);
			   fg_maj ="";
			   diag.setSortno(entdi.getSortno()+"");
			   //dto[i] = diag;
			   map.put(entdi.getCode_didef_dis(), diag);
			  
		   }
		   if(map != null && map.size() >0){
			   int i =0;
			   IpViewDiagDTO[] dto = new IpViewDiagDTO[map.size()];
			   for(IpViewDiagDTO diag:map.values()){
				   dto[i] = diag;
				   i++;
			   }
			  return dto;
		   } 
		   return null;
	 }

}

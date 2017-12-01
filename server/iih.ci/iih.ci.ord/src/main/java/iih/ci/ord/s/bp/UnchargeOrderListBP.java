package iih.ci.ord.s.bp;

import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdDTO;
import iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdSrvDTO;
import iih.ci.ord.s.bp.qry.RecipeDTOQry;
import iih.ci.ord.s.bp.qry.UnchargeOrderQry;
import iih.ci.ord.s.bp.qry.UnchargeOrderSrvQry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class UnchargeOrderListBP {
	
	/**
	 * 未记费医嘱查询列表

	 * @param patid
	 * @param dtSignB
	 * @param dtSignE
	 * @param code_entp
	 * @return
	 */
	public List<UnchargeOrdDTO> exec(String patid,
			FDateTime dtSignB, FDateTime dtSignE, String code_entp,String Id_org)
			throws BizException {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		UnchargeOrderQry DtoQry  = new UnchargeOrderQry(patid,dtSignB,dtSignE,code_entp,Id_org);
		UnchargeOrdDTO[] ordList = (UnchargeOrdDTO[])AppFwUtil.getDORstWithDao(DtoQry, UnchargeOrdDTO.class);
		 List<UnchargeOrdDTO> listDTO = new  ArrayList<UnchargeOrdDTO>();
		 if(ordList !=  null){
			 for(UnchargeOrdDTO item : ordList){
				 UnchargeOrderSrvQry srvQry = new UnchargeOrderSrvQry(item.getId_or());
				 UnchargeOrdSrvDTO[] ordSrvArr = (UnchargeOrdSrvDTO[])AppFwUtil.getDORstWithDao(srvQry, UnchargeOrdSrvDTO.class);
				 FArrayList Flist = new FArrayList();
				 if(ordSrvArr != null){
					 for(UnchargeOrdSrvDTO srvDto : ordSrvArr){
						 srvDto.setDt_sign(item.getDt_sign());
						 Flist.add(srvDto);
						 map.put(srvDto.getId_pres(),srvDto.getId_pres());
					 }
				 }
				 item.setUnOrdsrvDTO(Flist);
				 //处方信息
				 item.setRecipeDTO(getPress(map));
				 listDTO.add(item);
			 }
			 
		 }
		 
		 
		return listDTO; 
	}
	
	/***
	 * 患者未计费处方信息
	 * @param map
	 * @return
	 */
	private  FArrayList  getPress(Map<String,String> map)throws BizException{
		
		FArrayList recipres = new FArrayList();
		if(map != null){
			String id_press = "";
			for(String pres :map.keySet()){
				id_press += "'"+pres +"',";
			}
			id_press = id_press.substring(0, id_press.lastIndexOf(","));
			RecipeDTOQry qry = new RecipeDTOQry(id_press);
			RecipeDTO[] RecipresList = (RecipeDTO[])AppFwUtil.getDORstWithDao(qry, RecipeDTO.class);
		    if(RecipresList != null && RecipresList.length>0){
		    	for(RecipeDTO dto :RecipresList){
		    		recipres.add(dto);
		    	}
		    }
		}
		
		return recipres;
	}
	
}

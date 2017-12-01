/**
 * 
 */
package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.getRecipeByIdEntsOtherMedicalBillsQry;
import iih.ci.ord.s.bp.qry.getRecipeByIdEntsQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: getBlCgRecipeDTOBP
 * @Description: 费用已经划价，没有计费的处方信息(药品 检查 检验)
 * @author Comsys-li_zheng
 * @date 2016年8月25日 下午2:39:05
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getBlCgRecipeDTOBP {
   
public  RecipeDTO[] exec(String[] id_ents)throws BizException{
		if(id_ents == null ||id_ents.length ==0) return null;
		//药品处方信息
		RecipeDTO[] drugRecipe = getRecipeByIdEnts(id_ents);
		//检查检验信息
        return drugRecipe;
	}
    /**
     * 药品处方信息
     * @param id_ents
     * @return
     */
    private RecipeDTO[] getRecipeByIdEnts(String[] id_ents)throws BizException{
    	//药品处方信息
    	List<RecipeDTO> list = new ArrayList<RecipeDTO>();
    	getRecipeByIdEntsQry qry = new getRecipeByIdEntsQry(id_ents);
    	RecipeDTO[] rtn = (RecipeDTO[])AppFwUtil.getDORstWithDao(qry, RecipeDTO.class);
    	if(rtn != null && rtn.length >0){
    		for(RecipeDTO dto:rtn){
    			list.add(dto);
    		}
    	}
    	//其它申请单信息
    	getRecipeByIdEntsOtherMedicalBillsQry otherqry = new getRecipeByIdEntsOtherMedicalBillsQry(id_ents);
    	RecipeDTO[] otherRtn = (RecipeDTO[])AppFwUtil.getDORstWithDao(otherqry, RecipeDTO.class);
    	if(otherRtn != null && otherRtn.length >0){
    		Map map = getDiagByidEnts(id_ents);
    		for(RecipeDTO dto:rtn){
    			if(map != null && map.size() > 0 ){
    				if(map.containsKey(dto.getId_en())){
    					String[] diag = (String[])map.get(dto.getId_en());
    					dto.setDidef_name(diag[0]);
    					dto.setDidef_code(diag[1]);
    				}
    			}
    			list.add(dto);
    		}
    	}
    	if(list.size() >0){
    		return list.toArray(new RecipeDTO[list.size()]);
    	}else{
    	  return  null;
    	}
    }
    
     /**
      * 就诊的诊断信息
      * @param id_ents
      * @return  Map<id_ent,code|name>
      * @throws BizException
      */
    private Map getDiagByidEnts(String[] id_ents)throws BizException{
    	Map<String,String[]> map = new HashMap<String,String[]>();
    	if(id_ents != null && id_ents.length>0){
    		for(String id_ent:id_ents){
    			String[] diag = CiOrdUtils.getDiag(id_ent);
    			map.put(id_ent, diag);
    		}
    	}
    	return map;
    }
  
}

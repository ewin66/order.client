/**
 * 
 */
package iih.ci.ord.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.s.bp.qry.getRecipeByIdPresQry;

/**
 * @ClassName: getRecipeDTOByIdPresBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年9月6日 下午5:05:43
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getRecipeDTOByIdPresBP {

	public  RecipeDTO[] exec(String[] Id_pres)throws BizException{
		
		getRecipeByIdPresQry qry = new getRecipeByIdPresQry(Id_pres);
		RecipeDTO[] rtn = (RecipeDTO[])AppFwUtil.getDORstWithDao(qry, RecipeDTO.class);
	    return rtn;
	}
	
}

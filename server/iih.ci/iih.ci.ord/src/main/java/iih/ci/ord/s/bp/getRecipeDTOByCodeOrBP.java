/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.s.bp.qry.getRecipeDTOByCodeOrQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: getRecipeDTOByCodeOrBP
 * @Description: 药品之外的申请单
 * @author Comsys-li_zheng
 * @date 2016年9月6日 下午5:27:56
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getRecipeDTOByCodeOrBP {
   
	
	public RecipeDTO[] exec(String[] code_ors)throws BizException{
		
		getRecipeDTOByCodeOrQry otherqry = new getRecipeDTOByCodeOrQry(code_ors);
		RecipeDTO[] otherRtn = (RecipeDTO[])AppFwUtil.getDORstWithDao(otherqry, RecipeDTO.class);
	    return otherRtn;
	}
}

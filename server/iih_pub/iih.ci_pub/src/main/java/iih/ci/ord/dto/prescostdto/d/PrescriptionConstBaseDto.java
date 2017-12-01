/**
 * 
 */
package iih.ci.ord.dto.prescostdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * @ClassName: PrescriptionConstBaseDto
 * @Description: 处方费用的basedto
 * @author Comsys-li_zheng
 * @date 2016年4月19日 上午11:05:05
 * @Package iih.ci.ord.dto.prescostdto.d
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class PrescriptionConstBaseDto  extends BaseDTO{
 
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方信息
	 * @return
	 */
	public FArrayList getRecipeDTO(){
		return ((FArrayList) getAttrVal("RecipeDTO"));
	}
	/**
	 * 处方信息
	 * @return
	 */
	public void setRecipeDTO(FArrayList RecipeDTO){
		setAttrVal("RecipeDTO", RecipeDTO);
	}
	
	/**
	 * 服务信息
	 * @return
	 */
	public FArrayList getPrescriptionCostDto(){
		return ((FArrayList) getAttrVal("PrescriptionCostDto"));
	}
	/**
	 * 服务信息
	 * @return
	 */
	public void setPrescriptionCostDto(FArrayList PrescriptionCostDto){
		setAttrVal("PrescriptionCostDto", PrescriptionCostDto);
	}
}

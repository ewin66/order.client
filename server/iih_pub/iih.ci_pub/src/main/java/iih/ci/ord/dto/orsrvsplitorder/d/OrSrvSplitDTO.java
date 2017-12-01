package iih.ci.ord.dto.orsrvsplitorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱拆分结果 DTO数据 
 * 
 */
public class OrSrvSplitDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱维度
	 * @return FArrayList
	 */
	public FArrayList getOrsplitarry() {
		return ((FArrayList) getAttrVal("Orsplitarry"));
	}
	/**
	 * 医嘱维度
	 * @param Orsplitarry
	 */
	public void setOrsplitarry(FArrayList Orsplitarry) {
		setAttrVal("Orsplitarry", Orsplitarry);
	}
	/**
	 * 服务维度
	 * @return FArrayList
	 */
	public FArrayList getSrvsplitarry() {
		return ((FArrayList) getAttrVal("Srvsplitarry"));
	}
	/**
	 * 服务维度
	 * @param Srvsplitarry
	 */
	public void setSrvsplitarry(FArrayList Srvsplitarry) {
		setAttrVal("Srvsplitarry", Srvsplitarry);
	}
	/**
	 * 原始服务维度
	 * @return FArrayList
	 */
	public FArrayList getOriginalsrvsplitarry() {
		return ((FArrayList) getAttrVal("Originalsrvsplitarry"));
	}
	/**
	 * 原始服务维度
	 * @param Originalsrvsplitarry
	 */
	public void setOriginalsrvsplitarry(FArrayList Originalsrvsplitarry) {
		setAttrVal("Originalsrvsplitarry", Originalsrvsplitarry);
	}
}
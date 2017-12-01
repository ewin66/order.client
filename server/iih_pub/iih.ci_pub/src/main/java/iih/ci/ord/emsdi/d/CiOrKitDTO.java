package iih.ci.ord.emsdi.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱Kit件DTO数据信息 DTO数据 
 * 
 */
public class CiOrKitDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 临床组套关联服务列表
	 * @return FArrayList
	 */
	public FArrayList getCiorkitsrvlist() {
		return ((FArrayList) getAttrVal("Ciorkitsrvlist"));
	}
	/**
	 * 临床组套关联服务列表
	 * @param Ciorkitsrvlist
	 */
	public void setCiorkitsrvlist(FArrayList Ciorkitsrvlist) {
		setAttrVal("Ciorkitsrvlist", Ciorkitsrvlist);
	}
	/**
	 * 临床组套关联医嘱模板列表
	 * @return FArrayList
	 */
	public FArrayList getCiorkitortmpllist() {
		return ((FArrayList) getAttrVal("Ciorkitortmpllist"));
	}
	/**
	 * 临床组套关联医嘱模板列表
	 * @param Ciorkitortmpllist
	 */
	public void setCiorkitortmpllist(FArrayList Ciorkitortmpllist) {
		setAttrVal("Ciorkitortmpllist", Ciorkitortmpllist);
	}
}
package iih.ci.ord.tmpl.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱模板保存后返回数据DTO DTO数据 
 * 
 */
public class CiOrTmplSaveRtnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊医嘱列表
	 * @return FArrayList
	 */
	public FArrayList getCiorlist() {
		return ((FArrayList) getAttrVal("Ciorlist"));
	}
	/**
	 * 患者就诊医嘱列表
	 * @param Ciorlist
	 */
	public void setCiorlist(FArrayList Ciorlist) {
		setAttrVal("Ciorlist", Ciorlist);
	}
	/**
	 * 问题医嘱列表数据
	 * @return FArrayList
	 */
	public FArrayList getProblemorlist() {
		return ((FArrayList) getAttrVal("Problemorlist"));
	}
	/**
	 * 问题医嘱列表数据
	 * @param Problemorlist
	 */
	public void setProblemorlist(FArrayList Problemorlist) {
		setAttrVal("Problemorlist", Problemorlist);
	}
	/**
	 * 医嘱问题列表数据
	 * @return FArrayList
	 */
	public FArrayList getOrsproblemlist() {
		return ((FArrayList) getAttrVal("Orsproblemlist"));
	}
	/**
	 * 医嘱问题列表数据
	 * @param Orsproblemlist
	 */
	public void setOrsproblemlist(FArrayList Orsproblemlist) {
		setAttrVal("Orsproblemlist", Orsproblemlist);
	}
}
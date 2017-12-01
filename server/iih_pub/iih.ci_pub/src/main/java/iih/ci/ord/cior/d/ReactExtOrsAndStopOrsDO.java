package iih.ci.ord.cior.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排斥扩展医嘱与排斥停止医嘱 DTO数据 
 * 
 */
public class ReactExtOrsAndStopOrsDO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排斥扩展医嘱聚集数据
	 * @return FArrayList
	 */
	public FArrayList getReactextdos() {
		return ((FArrayList) getAttrVal("Reactextdos"));
	}
	/**
	 * 排斥扩展医嘱聚集数据
	 * @param Reactextdos
	 */
	public void setReactextdos(FArrayList Reactextdos) {
		setAttrVal("Reactextdos", Reactextdos);
	}
	/**
	 * 关联要停止的医嘱
	 * @return FArrayList
	 */
	public FArrayList getStopordos() {
		return ((FArrayList) getAttrVal("Stopordos"));
	}
	/**
	 * 关联要停止的医嘱
	 * @param Stopordos
	 */
	public void setStopordos(FArrayList Stopordos) {
		setAttrVal("Stopordos", Stopordos);
	}
}
package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行闭环 DTO数据 
 * 
 */
public class ExecuteLoopDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 执行步骤
	 * @return FArrayList
	 */
	public FArrayList getLoops() {
		return ((FArrayList) getAttrVal("Loops"));
	}
	/**
	 * 执行步骤
	 * @param Loops
	 */
	public void setLoops(FArrayList Loops) {
		setAttrVal("Loops", Loops);
	}
	/**
	 * 服务项目
	 * @return FArrayList
	 */
	public FArrayList getSrvs() {
		return ((FArrayList) getAttrVal("Srvs"));
	}
	/**
	 * 服务项目
	 * @param Srvs
	 */
	public void setSrvs(FArrayList Srvs) {
		setAttrVal("Srvs", Srvs);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
}
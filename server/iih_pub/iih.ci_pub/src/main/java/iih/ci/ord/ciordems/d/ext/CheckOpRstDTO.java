package iih.ci.ord.ciordems.d.ext;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;

public class CheckOpRstDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	/**
	 * 麻醉分类
	 * @return String
	 */
	public String getEu_anesca() {
		return ((String) getAttrVal("Eu_anesca"));
	}
	/**
	 *麻醉分类
	 * @param Eu_anesca
	 */
	public void setEu_anesca(String Eu_anesca) {
		setAttrVal("Eu_anesca", Eu_anesca);
	}
	/**
	 * 计划手术时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划手术时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}

	
}

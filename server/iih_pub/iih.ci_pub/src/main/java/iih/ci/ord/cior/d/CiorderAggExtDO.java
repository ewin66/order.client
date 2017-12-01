package iih.ci.ord.cior.d;

import xap.mw.core.data.BaseDTO;
import iih.ci.ord.ciorder.d.CiorderAggDO;

public class CiorderAggExtDO extends BaseDTO {
//	private Integer reacttype;  //排斥医嘱类型  OrReactType
//	private String id_reacts;    //排斥医嘱 排斥组ID串
//	private String id_srvs;      //排斥医嘱  排斥组中使用的srvid串
//	private CiorderAggDO aggdo;
	
//	public Integer getReacttype() {
//		return reacttype;
//	}
//	public void setReacttype(Integer reacttype) {
//		this.reacttype = reacttype;
//	}
//	public CiorderAggDO getAggdo() {
//		return aggdo;
//	}
//	public void setAggdo(CiorderAggDO aggdo) {
//		this.aggdo = aggdo;
//	}
//	public String getId_reacts() {
//		return id_reacts;
//	}
//	public void setId_reacts(String id_reacts) {
//		this.id_reacts = id_reacts;
//	}
//	public String getId_srvs() {
//		return id_srvs;
//	}
//	public void setId_srvs(String id_srvs) {
//		this.id_srvs = id_srvs;
//	}
	
private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱排斥类型
	 * @return Integer
	 */
	public Integer getReacttype() {
		return ((Integer) getAttrVal("Reacttype"));
	}
	/**
	 * 医嘱排斥类型
	 * @param Reacttype
	 */
	public void setReacttype(Integer Reacttype) {
		setAttrVal("Reacttype", Reacttype);
	}
	/**
	 * 排斥组id串
	 * @return String
	 */
	public String getId_reacts() {
		return ((String) getAttrVal("Id_reacts"));
	}
	/**
	 * 排斥组id串
	 * @param Id_reacts
	 */
	public void setId_reacts(String Id_reacts) {
		setAttrVal("Id_reacts", Id_reacts);
	}
	/**
	 * 排斥组中使用的服务id串
	 * @return String
	 */
	public String getId_srvs() {
		return ((String) getAttrVal("Id_srvs"));
	}
	/**
	 * 排斥组中使用的服务id串
	 * @param Id_srvs
	 */
	public void setId_srvs(String Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	/**
	 * 对应医嘱聚集数据
	 * @return String
	 */
	public CiorderAggDO getAggdo() {
		return ((CiorderAggDO) getAttrVal("Aggdo"));
	}
	/**
	 * 对应医嘱聚集数据
	 * @param Aggdo
	 */
	public void setAggdo(CiorderAggDO Aggdo) {
		setAttrVal("Aggdo", Aggdo);
	}

	
}

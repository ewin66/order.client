package iih.ci.ord.cior.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱聚集排斥扩展数据信息 DTO数据 
 * 
 */
public class CiorderAggExtDTO extends BaseDTO {
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
	public String getAggdo() {
		return ((String) getAttrVal("Aggdo"));
	}
	/**
	 * 对应医嘱聚集数据
	 * @param Aggdo
	 */
	public void setAggdo(String Aggdo) {
		setAttrVal("Aggdo", Aggdo);
	}
}
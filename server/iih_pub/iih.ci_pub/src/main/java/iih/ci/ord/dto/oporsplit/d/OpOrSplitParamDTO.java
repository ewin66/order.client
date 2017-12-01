package iih.ci.ord.dto.oporsplit.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊医嘱拆分请求参数 DTO数据 
 * 
 */
public class OpOrSplitParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊主键串
	 * @return String
	 */
	public String getId_ens() {
		return ((String) getAttrVal("Id_ens"));
	}
	/**
	 * 就诊主键串
	 * @param Id_ens
	 */
	public void setId_ens(String Id_ens) {
		setAttrVal("Id_ens", Id_ens);
	}
	/**
	 * 医嘱主键串
	 * @return String
	 */
	public String getId_ors() {
		return ((String) getAttrVal("Id_ors"));
	}
	/**
	 * 医嘱主键串
	 * @param Id_ors
	 */
	public void setId_ors(String Id_ors) {
		setAttrVal("Id_ors", Id_ors);
	}
	/**
	 * 医嘱服务项目ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务项目ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务类型编码串
	 * @return String
	 */
	public String getSd_srvtps() {
		return ((String) getAttrVal("Sd_srvtps"));
	}
	/**
	 * 服务类型编码串
	 * @param Sd_srvtps
	 */
	public void setSd_srvtps(String Sd_srvtps) {
		setAttrVal("Sd_srvtps", Sd_srvtps);
	}
	/**
	 * 医嘱用法主键串
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}
	/**
	 * 医嘱用法主键串
	 * @param Id_routes
	 */
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
	/**
	 * 执行科室主键串
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室主键串
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 拆分触发时间
	 * @return FDateTime
	 */
	public FDateTime getDt_split() {
		return ((FDateTime) getAttrVal("Dt_split"));
	}
	/**
	 * 拆分触发时间
	 * @param Dt_split
	 */
	public void setDt_split(FDateTime Dt_split) {
		setAttrVal("Dt_split", Dt_split);
	}
	/**
	 * 接口类型
	 * @return String
	 */
	public String getInterfacetp() {
		return ((String) getAttrVal("Interfacetp"));
	}
	/**
	 * 接口类型
	 * @param Interfacetp
	 */
	public void setInterfacetp(String Interfacetp) {
		setAttrVal("Interfacetp", Interfacetp);
	}
}
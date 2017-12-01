package iih.ci.ord.dto.blexorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱服务拆分参数DTO DTO数据 
 * 
 */
public class OrSrvSplitParamDTO extends BaseDTO {
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
	 * 服务类型主键串
	 * @return String
	 */
	public String getSd_srvtps() {
		return ((String) getAttrVal("Sd_srvtps"));
	}
	/**
	 * 服务类型主键串
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
	 * 医嘱长临枚举项
	 * @return Integer
	 */
	public Integer getEu_orlongtemp() {
		return ((Integer) getAttrVal("Eu_orlongtemp"));
	}
	/**
	 * 医嘱长临枚举项
	 * @param Eu_orlongtemp
	 */
	public void setEu_orlongtemp(Integer Eu_orlongtemp) {
		setAttrVal("Eu_orlongtemp", Eu_orlongtemp);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 服务项目串
	 * @return String
	 */
	public String getId_srvs() {
		return ((String) getAttrVal("Id_srvs"));
	}
	/**
	 * 服务项目串
	 * @param Id_srvs
	 */
	public void setId_srvs(String Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	/**
	 * 住院带药枚举项
	 * @return Integer
	 */
	public Integer getFg_pres_outp() {
		return ((Integer) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 住院带药枚举项
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(Integer Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 拆分开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_split_start() {
		return ((FDateTime) getAttrVal("Dt_split_start"));
	}
	/**
	 * 拆分开始时间
	 * @param Dt_split_start
	 */
	public void setDt_split_start(FDateTime Dt_split_start) {
		setAttrVal("Dt_split_start", Dt_split_start);
	}
	/**
	 * 拆分结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_split_end() {
		return ((FDateTime) getAttrVal("Dt_split_end"));
	}
	/**
	 * 拆分结束时间
	 * @param Dt_split_end
	 */
	public void setDt_split_end(FDateTime Dt_split_end) {
		setAttrVal("Dt_split_end", Dt_split_end);
	}
	/**
	 * 医嘱生成拆分类型枚举
	 * @return Integer
	 */
	public Integer getEu_orgensplittp() {
		return ((Integer) getAttrVal("Eu_orgensplittp"));
	}
	/**
	 * 医嘱生成拆分类型枚举
	 * @param Eu_orgensplittp
	 */
	public void setEu_orgensplittp(Integer Eu_orgensplittp) {
		setAttrVal("Eu_orgensplittp", Eu_orgensplittp);
	}
	/**
	 * 附属字段
	 * @return FMap
	 */
	public FMap getAttachfields() {
		return ((FMap) getAttrVal("Attachfields"));
	}
	/**
	 * 附属字段
	 * @param Attachfields
	 */
	public void setAttachfields(FMap Attachfields) {
		setAttrVal("Attachfields", Attachfields);
	}
}
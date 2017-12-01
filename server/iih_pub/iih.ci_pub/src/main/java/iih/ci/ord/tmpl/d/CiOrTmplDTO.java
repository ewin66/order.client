package iih.ci.ord.tmpl.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱模板DTO DTO数据 
 * 
 */
public class CiOrTmplDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 临床医嘱模板主键标识
	 * @return String
	 */
	public String getId_ciortmpl() {
		return ((String) getAttrVal("Id_ciortmpl"));
	}	
	/**
	 * 临床医嘱模板主键标识
	 * @param Id_ciortmpl
	 */
	public void setId_ciortmpl(String Id_ciortmpl) {
		setAttrVal("Id_ciortmpl", Id_ciortmpl);
	}
	/**
	 * 医嘱模板项目列表
	 * @return String
	 */
	public FArrayList getOrtmplsrvs() {
		return ((FArrayList) getAttrVal("Ortmplsrvs"));
	}	
	/**
	 * 医嘱模板项目列表
	 * @param Ortmplsrvs
	 */
	public void setOrtmplsrvs(FArrayList Ortmplsrvs) {
		setAttrVal("Ortmplsrvs", Ortmplsrvs);
	}
	/**
	 * 医嘱来源方式类型
	 * @return String
	 */
	public String getEu_orsrcmdtp() {
		return ((String) getAttrVal("Eu_orsrcmdtp"));
	}	
	/**
	 * 医嘱来源方式类型
	 * @param Eu_orsrcmdtp
	 */
	public void setEu_orsrcmdtp(String Eu_orsrcmdtp) {
		setAttrVal("Eu_orsrcmdtp", Eu_orsrcmdtp);
	}
	/**
	 * 医嘱来源主标识
	 * @return String
	 */
	public String getId_orsrc_main() {
		return ((String) getAttrVal("Id_orsrc_main"));
	}	
	/**
	 * 医嘱来源主标识
	 * @param Id_orsrc_main
	 */
	public void setId_orsrc_main(String Id_orsrc_main) {
		setAttrVal("Id_orsrc_main", Id_orsrc_main);
	}
	/**
	 * 医嘱来源子标识
	 * @return String
	 */
	public String getId_orsrc_sub() {
		return ((String) getAttrVal("Id_orsrc_sub"));
	}	
	/**
	 * 医嘱来源子标识
	 * @param Id_orsrc_sub
	 */
	public void setId_orsrc_sub(String Id_orsrc_sub) {
		setAttrVal("Id_orsrc_sub", Id_orsrc_sub);
	}
	/**
	 * 医嘱来源孙标识
	 * @return String
	 */
	public String getId_orsrc_subsub() {
		return ((String) getAttrVal("Id_orsrc_subsub"));
	}	
	/**
	 * 医嘱来源孙标识
	 * @param Id_orsrc_subsub
	 */
	public void setId_orsrc_subsub(String Id_orsrc_subsub) {
		setAttrVal("Id_orsrc_subsub", Id_orsrc_subsub);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 医嘱类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 医嘱类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 长期临时类型
	 * @return Integer
	 */
	public Integer getEu_long() {
		return ((Integer) getAttrVal("Eu_long"));
	}	
	/**
	 * 长期临时类型
	 * @param Eu_long
	 */
	public void setEu_long(Integer Eu_long) {
		setAttrVal("Eu_long", Eu_long);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 代煎标识
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	/**
	 * 代煎标识
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}	
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 医嘱次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}	
	/**
	 * 医嘱次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 医嘱描述
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 医嘱描述
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 套标示
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	/**
	 * 套标示
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
}
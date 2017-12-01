package iih.ci.ord.ordappathgy.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病理报告DTO DTO数据 
 * 
 */
public class OrdApPathgyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病理申请单主键标识
	 * @return String
	 */
	public String getId_appathgy() {
		return ((String) getAttrVal("Id_appathgy"));
	}
	/**
	 * 病理申请单主键标识
	 * @param Id_appathgy
	 */
	public void setId_appathgy(String Id_appathgy) {
		setAttrVal("Id_appathgy", Id_appathgy);
	}
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 医嘱名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 服务项目分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务项目分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 生效时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 报告状态
	 * @return String
	 */
	public String getFg_rpt() {
		return ((String) getAttrVal("Fg_rpt"));
	}
	/**
	 * 报告状态
	 * @param Fg_rpt
	 */
	public void setFg_rpt(String Fg_rpt) {
		setAttrVal("Fg_rpt", Fg_rpt);
	}
}
/**
 * 
 */
package iih.ci.ord.dto.d;

import xap.mw.core.data.BaseDTO;

/**
 * @ClassName: InsurDrugDivideInfoDTO
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月1日 下午3:27:06
 * @Package iih.ci.ord.dto.d
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class InsurDrugDivideInfoDTO extends BaseDTO {
private static final long serialVersionUID = 1L;
	
	 public String getId_ent(){
			return ((String) getAttrVal("Id_ent"));
	 }
	 public void setId_ent(String Id_ent){
			setAttrVal("Id_ent", Id_ent);
	 }
	 
	 public String getId_pres(){
			return ((String) getAttrVal("Id_pres"));
	 }
	 public void setId_pres(String Id_pres){
			setAttrVal("Id_pres", Id_pres);
	 }
	 
	 public String getId_orsrv(){
			return ((String) getAttrVal("Id_orsrv"));
	 }
	 public void setId_orsrv(String Id_orsrv){
			setAttrVal("Id_orsrv", Id_orsrv);
	 }
	 public String getId_srv(){
			return ((String) getAttrVal("Id_srv"));
	 }
	 public void setId_srv(String Id_srv){
			setAttrVal("Id_srv", Id_srv);
	 }
 



	/**
	 * 剂型
	 * @return String
	 */
	public String getDose() {
		return ((String) getAttrVal("Dose"));
	}
	/**
	 * 剂型
	 * @param Dose
	 */
	public void setDose(String Dose) {
		setAttrVal("Dose", Dose);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getHowtouse() {
		return ((String) getAttrVal("Howtouse"));
	}
	/**
	 * 用法
	 * @param Howtouse
	 */
	public void setHowtouse(String Howtouse) {
		setAttrVal("Howtouse", Howtouse);
	}
	/**
	 * 单次用量
	 * @return String
	 */
	public String getDosage() {
		return ((String) getAttrVal("Dosage"));
	}
	/**
	 * 单次用量
	 * @param Dosage
	 */
	public void setDosage(String Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getPackaging() {
		return ((String) getAttrVal("Packaging"));
	}
	/**
	 * 包装单位
	 * @param Packaging
	 */
	public void setPackaging(String Packaging) {
		setAttrVal("Packaging", Packaging);
	}
	/**
	 * 最小包装
	 * @return String
	 */
	public String getMinpackage() {
		return ((String) getAttrVal("Minpackage"));
	}
	/**
	 * 最小包装
	 * @param Minpackage
	 */
	public void setMinpackage(String Minpackage) {
		setAttrVal("Minpackage", Minpackage);
	}
	/**
	 * 用药天数
	 * @return String
	 */
	public String getDays() {
		return ((String) getAttrVal("Days"));
	}
	/**
	 * 用药天数
	 * @param Days
	 */
	public void setDays(String Days) {
		setAttrVal("Days", Days);
	}
	/**
	 * 药品批准文字
	 * @return String
	 */
	public String getDrugapprovalnumber() {
		return ((String) getAttrVal("Drugapprovalnumber"));
	}
	/**
	 * 药品批准文字
	 * @param Drugapprovalnumber
	 */
	public void setDrugapprovalnumber(String Drugapprovalnumber) {
		setAttrVal("Drugapprovalnumber", Drugapprovalnumber);
	}
}

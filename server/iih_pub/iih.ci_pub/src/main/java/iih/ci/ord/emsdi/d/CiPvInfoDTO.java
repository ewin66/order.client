package iih.ci.ord.emsdi.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床就诊信息DTO DTO数据 
 * 
 */
public class CiPvInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pati() {
		return ((String) getAttrVal("Id_pati"));
	}
	/**
	 * 患者
	 * @param Id_pati
	 */
	public void setId_pati(String Id_pati) {
		setAttrVal("Id_pati", Id_pati);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_ns() {
		return ((String) getAttrVal("Id_dep_ns"));
	}
	/**
	 * 病区
	 * @param Id_dep_ns
	 */
	public void setId_dep_ns(String Id_dep_ns) {
		setAttrVal("Id_dep_ns", Id_dep_ns);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dep_en() {
		return ((String) getAttrVal("Id_dep_en"));
	}
	/**
	 * 就诊科室
	 * @param Id_dep_en
	 */
	public void setId_dep_en(String Id_dep_en) {
		setAttrVal("Id_dep_en", Id_dep_en);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 开单科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 医疗组
	 * @return String
	 */
	public String getId_wgrp_phy() {
		return ((String) getAttrVal("Id_wgrp_phy"));
	}
	/**
	 * 医疗组
	 * @param Id_wgrp_phy
	 */
	public void setId_wgrp_phy(String Id_wgrp_phy) {
		setAttrVal("Id_wgrp_phy", Id_wgrp_phy);
	}
	/**
	 * 主管医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 主管医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 主管护士
	 * @return String
	 */
	public String getId_emp_ns() {
		return ((String) getAttrVal("Id_emp_ns"));
	}
	/**
	 * 主管护士
	 * @param Id_emp_ns
	 */
	public void setId_emp_ns(String Id_emp_ns) {
		setAttrVal("Id_emp_ns", Id_emp_ns);
	}
}
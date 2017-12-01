package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊医嘱撤销和停止就诊信息DTO DTO数据 
 * 
 */
public class IEOpOrCancStpEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE医嘱撤销和停止就诊主键标识
	 * @return String
	 */
	public String getId_ieorcancstpen() {
		return ((String) getAttrVal("Id_ieorcancstpen"));
	}	
	/**
	 * IE医嘱撤销和停止就诊主键标识
	 * @param Id_ieorcancstpen
	 */
	public void setId_ieorcancstpen(String Id_ieorcancstpen) {
		setAttrVal("Id_ieorcancstpen", Id_ieorcancstpen);
	}
	/**
	 * IE医嘱撤销和停止集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_ieorcancstps() {
		return ((FArrayList2) getAttrVal("Id_ieorcancstps"));
	}	
	/**
	 * IE医嘱撤销和停止集合
	 * @param Id_ieorcancstps
	 */
	public void setId_ieorcancstps(FArrayList2 Id_ieorcancstps) {
		setAttrVal("Id_ieorcancstps", Id_ieorcancstps);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}	
	/**
	 * 患者ID
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}	
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExec_unit() {
		return ((String) getAttrVal("Exec_unit"));
	}	
	/**
	 * 执行科室编码
	 * @param Exec_unit
	 */
	public void setExec_unit(String Exec_unit) {
		setAttrVal("Exec_unit", Exec_unit);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExec_unit_name() {
		return ((String) getAttrVal("Exec_unit_name"));
	}	
	/**
	 * 执行科室名称
	 * @param Exec_unit_name
	 */
	public void setExec_unit_name(String Exec_unit_name) {
		setAttrVal("Exec_unit_name", Exec_unit_name);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}	
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
	/**
	 * 病人科室编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	/**
	 * 病人科室编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	/**
	 * 病人科室名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 医疗机构编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 医疗机构名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 集成平台服务分类编码
	 * @return String
	 */
	public String getIemsgca_code() {
		return ((String) getAttrVal("Iemsgca_code"));
	}	
	/**
	 * 集成平台服务分类编码
	 * @param Iemsgca_code
	 */
	public void setIemsgca_code(String Iemsgca_code) {
		setAttrVal("Iemsgca_code", Iemsgca_code);
	}
}
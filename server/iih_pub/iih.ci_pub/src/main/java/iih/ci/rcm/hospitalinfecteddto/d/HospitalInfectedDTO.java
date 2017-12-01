package iih.ci.rcm.hospitalinfecteddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 院感上报信息DTO DTO数据 
 * 
 */
public class HospitalInfectedDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 院感上报主键
	 * @return String
	 */
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	/**
	 * 院感上报主键
	 * @param Id_hospitalreport
	 */
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	/**
	 * 病人基本信息
	 * @return String
	 */
	public FArrayList getLs_patient() {
		return ((FArrayList) getAttrVal("Ls_patient"));
	}	
	/**
	 * 病人基本信息
	 * @param Ls_patient
	 */
	public void setLs_patient(FArrayList Ls_patient) {
		setAttrVal("Ls_patient", Ls_patient);
	}
	/**
	 * 院感上报信息
	 * @return String
	 */
	public FArrayList getLs_hosrep() {
		return ((FArrayList) getAttrVal("Ls_hosrep"));
	}	
	/**
	 * 院感上报信息
	 * @param Ls_hosrep
	 */
	public void setLs_hosrep(FArrayList Ls_hosrep) {
		setAttrVal("Ls_hosrep", Ls_hosrep);
	}
	/**
	 * 抗菌用药
	 * @return String
	 */
	public FArrayList getLs_antuse() {
		return ((FArrayList) getAttrVal("Ls_antuse"));
	}	
	/**
	 * 抗菌用药
	 * @param Ls_antuse
	 */
	public void setLs_antuse(FArrayList Ls_antuse) {
		setAttrVal("Ls_antuse", Ls_antuse);
	}
	/**
	 * 药敏信息
	 * @return String
	 */
	public FArrayList getLs_drugsen() {
		return ((FArrayList) getAttrVal("Ls_drugsen"));
	}	
	/**
	 * 药敏信息
	 * @param Ls_drugsen
	 */
	public void setLs_drugsen(FArrayList Ls_drugsen) {
		setAttrVal("Ls_drugsen", Ls_drugsen);
	}
	/**
	 * 感染部位
	 * @return String
	 */
	public FArrayList getLs_consite() {
		return ((FArrayList) getAttrVal("Ls_consite"));
	}	
	/**
	 * 感染部位
	 * @param Ls_consite
	 */
	public void setLs_consite(FArrayList Ls_consite) {
		setAttrVal("Ls_consite", Ls_consite);
	}
	/**
	 * 手术切口感染
	 * @return String
	 */
	public FArrayList getLs_operincinfect() {
		return ((FArrayList) getAttrVal("Ls_operincinfect"));
	}	
	/**
	 * 手术切口感染
	 * @param Ls_operincinfect
	 */
	public void setLs_operincinfect(FArrayList Ls_operincinfect) {
		setAttrVal("Ls_operincinfect", Ls_operincinfect);
	}
}
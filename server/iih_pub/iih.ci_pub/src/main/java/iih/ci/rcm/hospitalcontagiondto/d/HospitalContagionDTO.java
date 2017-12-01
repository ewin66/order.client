package iih.ci.rcm.hospitalcontagiondto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 传染病信息dto DTO数据 
 * 
 */
public class HospitalContagionDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 传染病报告卡主键
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}	
	/**
	 * 传染病报告卡主键
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	/**
	 * 患者信息
	 * @return String
	 */
	public FArrayList getLs_patient() {
		return ((FArrayList) getAttrVal("Ls_patient"));
	}	
	/**
	 * 患者信息
	 * @param Ls_patient
	 */
	public void setLs_patient(FArrayList Ls_patient) {
		setAttrVal("Ls_patient", Ls_patient);
	}
	/**
	 * 传染病报告卡信息
	 * @return String
	 */
	public FArrayList getLs_contagion() {
		return ((FArrayList) getAttrVal("Ls_contagion"));
	}	
	/**
	 * 传染病报告卡信息
	 * @param Ls_contagion
	 */
	public void setLs_contagion(FArrayList Ls_contagion) {
		setAttrVal("Ls_contagion", Ls_contagion);
	}
	/**
	 * 性别附卡
	 * @return String
	 */
	public FArrayList getLs_std() {
		return ((FArrayList) getAttrVal("Ls_std"));
	}	
	/**
	 * 性别附卡
	 * @param Ls_std
	 */
	public void setLs_std(FArrayList Ls_std) {
		setAttrVal("Ls_std", Ls_std);
	}
	/**
	 * 梅毒附卡
	 * @return String
	 */
	public FArrayList getLs_syphilis() {
		return ((FArrayList) getAttrVal("Ls_syphilis"));
	}	
	/**
	 * 梅毒附卡
	 * @param Ls_syphilis
	 */
	public void setLs_syphilis(FArrayList Ls_syphilis) {
		setAttrVal("Ls_syphilis", Ls_syphilis);
	}
	/**
	 * 手足口附卡
	 * @return String
	 */
	public FArrayList getLs_hfm() {
		return ((FArrayList) getAttrVal("Ls_hfm"));
	}	
	/**
	 * 手足口附卡
	 * @param Ls_hfm
	 */
	public void setLs_hfm(FArrayList Ls_hfm) {
		setAttrVal("Ls_hfm", Ls_hfm);
	}
	/**
	 * 乙肝附卡
	 * @return String
	 */
	public FArrayList getLs_hepatitisb() {
		return ((FArrayList) getAttrVal("Ls_hepatitisb"));
	}	
	/**
	 * 乙肝附卡
	 * @param Ls_hepatitisb
	 */
	public void setLs_hepatitisb(FArrayList Ls_hepatitisb) {
		setAttrVal("Ls_hepatitisb", Ls_hepatitisb);
	}
	/**
	 * 传染病分类
	 * @return String
	 */
	public FArrayList getLs_crb() {
		return ((FArrayList) getAttrVal("Ls_crb"));
	}	
	/**
	 * 传染病分类
	 * @param Ls_crb
	 */
	public void setLs_crb(FArrayList Ls_crb) {
		setAttrVal("Ls_crb", Ls_crb);
	}
}
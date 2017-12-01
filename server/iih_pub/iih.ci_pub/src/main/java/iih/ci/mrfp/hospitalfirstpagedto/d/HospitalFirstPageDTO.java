package iih.ci.mrfp.hospitalfirstpagedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案首页信息dto DTO数据 
 * 
 */
public class HospitalFirstPageDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病案首页主键
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}	
	/**
	 * 病案首页主键
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**
	 * 病案首页主表
	 * @return String
	 */
	public FArrayList getLs_mrfp() {
		return ((FArrayList) getAttrVal("Ls_mrfp"));
	}	
	/**
	 * 病案首页主表
	 * @param Ls_mrfp
	 */
	public void setLs_mrfp(FArrayList Ls_mrfp) {
		setAttrVal("Ls_mrfp", Ls_mrfp);
	}
	/**
	 * 费用
	 * @return String
	 */
	public FArrayList getLs_bl() {
		return ((FArrayList) getAttrVal("Ls_bl"));
	}	
	/**
	 * 费用
	 * @param Ls_bl
	 */
	public void setLs_bl(FArrayList Ls_bl) {
		setAttrVal("Ls_bl", Ls_bl);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public FArrayList getLs_dia() {
		return ((FArrayList) getAttrVal("Ls_dia"));
	}	
	/**
	 * 诊断
	 * @param Ls_dia
	 */
	public void setLs_dia(FArrayList Ls_dia) {
		setAttrVal("Ls_dia", Ls_dia);
	}
	/**
	 * 其他信息
	 * @return String
	 */
	public FArrayList getLs_other() {
		return ((FArrayList) getAttrVal("Ls_other"));
	}	
	/**
	 * 其他信息
	 * @param Ls_other
	 */
	public void setLs_other(FArrayList Ls_other) {
		setAttrVal("Ls_other", Ls_other);
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
	 * 手术信息
	 * @return String
	 */
	public FArrayList getLs_sug() {
		return ((FArrayList) getAttrVal("Ls_sug"));
	}	
	/**
	 * 手术信息
	 * @param Ls_sug
	 */
	public void setLs_sug(FArrayList Ls_sug) {
		setAttrVal("Ls_sug", Ls_sug);
	}
	/**
	 * 重症监护
	 * @return String
	 */
	public FArrayList getLs_intencare() {
		return ((FArrayList) getAttrVal("Ls_intencare"));
	}	
	/**
	 * 重症监护
	 * @param Ls_intencare
	 */
	public void setLs_intencare(FArrayList Ls_intencare) {
		setAttrVal("Ls_intencare", Ls_intencare);
	}
	/**
	 * 审核人信息
	 * @return String
	 */
	public FArrayList getLs_audit() {
		return ((FArrayList) getAttrVal("Ls_audit"));
	}	
	/**
	 * 审核人信息
	 * @param Ls_audit
	 */
	public void setLs_audit(FArrayList Ls_audit) {
		setAttrVal("Ls_audit", Ls_audit);
	}
}
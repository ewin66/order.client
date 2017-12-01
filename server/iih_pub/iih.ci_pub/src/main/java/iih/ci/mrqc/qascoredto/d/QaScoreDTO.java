package iih.ci.mrqc.qascoredto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质控评分 DTO数据 
 * 
 */
public class QaScoreDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * dto主键
	 * @return String
	 */
	public String getId_qascoredto() {
		return ((String) getAttrVal("Id_qascoredto"));
	}
	/**
	 * dto主键
	 * @param Id_qascoredto
	 */
	public void setId_qascoredto(String Id_qascoredto) {
		setAttrVal("Id_qascoredto", Id_qascoredto);
	}
	/**
	 * 质控项id
	 * @return String
	 */
	public String getId_qa_itm() {
		return ((String) getAttrVal("Id_qa_itm"));
	}
	/**
	 * 质控项id
	 * @param Id_qa_itm
	 */
	public void setId_qa_itm(String Id_qa_itm) {
		setAttrVal("Id_qa_itm", Id_qa_itm);
	}
	/**
	 * 自动质控配置主键
	 * @return String
	 */
	public String getId_qa_auto() {
		return ((String) getAttrVal("Id_qa_auto"));
	}
	/**
	 * 自动质控配置主键
	 * @param Id_qa_auto
	 */
	public void setId_qa_auto(String Id_qa_auto) {
		setAttrVal("Id_qa_auto", Id_qa_auto);
	}
	/**
	 * 评分主键
	 * @return String
	 */
	public String getId_qa_divide() {
		return ((String) getAttrVal("Id_qa_divide"));
	}
	/**
	 * 评分主键
	 * @param Id_qa_divide
	 */
	public void setId_qa_divide(String Id_qa_divide) {
		setAttrVal("Id_qa_divide", Id_qa_divide);
	}
	/**
	 * 一级分类id
	 * @return String
	 */
	public String getId_fst() {
		return ((String) getAttrVal("Id_fst"));
	}
	/**
	 * 一级分类id
	 * @param Id_fst
	 */
	public void setId_fst(String Id_fst) {
		setAttrVal("Id_fst", Id_fst);
	}
	/**
	 * 一级分类名称(一级分类表)
	 * @return String
	 */
	public String getFst_name() {
		return ((String) getAttrVal("Fst_name"));
	}
	/**
	 * 一级分类名称(一级分类表)
	 * @param Fst_name
	 */
	public void setFst_name(String Fst_name) {
		setAttrVal("Fst_name", Fst_name);
	}
	/**
	 * 一级分类最大分值(一级分类表)
	 * @return FDouble
	 */
	public FDouble getScore_fstmax() {
		return ((FDouble) getAttrVal("Score_fstmax"));
	}
	/**
	 * 一级分类最大分值(一级分类表)
	 * @param Score_fstmax
	 */
	public void setScore_fstmax(FDouble Score_fstmax) {
		setAttrVal("Score_fstmax", Score_fstmax);
	}
	/**
	 * 评分项目(质控项表)
	 * @return String
	 */
	public String getReq() {
		return ((String) getAttrVal("Req"));
	}
	/**
	 * 评分项目(质控项表)
	 * @param Req
	 */
	public void setReq(String Req) {
		setAttrVal("Req", Req);
	}
	/**
	 * 扣分类型(质控项表)
	 * @return String
	 */
	public String getId_qa_drp_scr_tp() {
		return ((String) getAttrVal("Id_qa_drp_scr_tp"));
	}
	/**
	 * 扣分类型(质控项表)
	 * @param Id_qa_drp_scr_tp
	 */
	public void setId_qa_drp_scr_tp(String Id_qa_drp_scr_tp) {
		setAttrVal("Id_qa_drp_scr_tp", Id_qa_drp_scr_tp);
	}
	/**
	 * 单次扣分值(质控项表)
	 * @return FDouble
	 */
	public FDouble getOnce_drp_scr() {
		return ((FDouble) getAttrVal("Once_drp_scr"));
	}
	/**
	 * 单次扣分值(质控项表)
	 * @param Once_drp_scr
	 */
	public void setOnce_drp_scr(FDouble Once_drp_scr) {
		setAttrVal("Once_drp_scr", Once_drp_scr);
	}
	/**
	 * 扣分标准(质控项表)
	 * @return String
	 */
	public String getDeduct_des() {
		return ((String) getAttrVal("Deduct_des"));
	}
	/**
	 * 扣分标准(质控项表)
	 * @param Deduct_des
	 */
	public void setDeduct_des(String Deduct_des) {
		setAttrVal("Deduct_des", Deduct_des);
	}
	/**
	 * 扣分次数(评分表)
	 * @return Integer
	 */
	public Integer getDeduct_scr_times() {
		return ((Integer) getAttrVal("Deduct_scr_times"));
	}
	/**
	 * 扣分次数(评分表)
	 * @param Deduct_scr_times
	 */
	public void setDeduct_scr_times(Integer Deduct_scr_times) {
		setAttrVal("Deduct_scr_times", Deduct_scr_times);
	}
	/**
	 * 扣分说明(评分表)
	 * @return String
	 */
	public String getDrp_des() {
		return ((String) getAttrVal("Drp_des"));
	}
	/**
	 * 扣分说明(评分表)
	 * @param Drp_des
	 */
	public void setDrp_des(String Drp_des) {
		setAttrVal("Drp_des", Drp_des);
	}
	/**
	 * 质控医生id(评分表)
	 * @return String
	 */
	public String getId_sbmt_user() {
		return ((String) getAttrVal("Id_sbmt_user"));
	}
	/**
	 * 质控医生id(评分表)
	 * @param Id_sbmt_user
	 */
	public void setId_sbmt_user(String Id_sbmt_user) {
		setAttrVal("Id_sbmt_user", Id_sbmt_user);
	}
	/**
	 * 质控医生(评分表)
	 * @return String
	 */
	public String getUser_name() {
		return ((String) getAttrVal("User_name"));
	}
	/**
	 * 质控医生(评分表)
	 * @param User_name
	 */
	public void setUser_name(String User_name) {
		setAttrVal("User_name", User_name);
	}
	/**
	 * 质控类型(评分表)
	 * @return String
	 */
	public String getId_qa_ty() {
		return ((String) getAttrVal("Id_qa_ty"));
	}
	/**
	 * 质控类型(评分表)
	 * @param Id_qa_ty
	 */
	public void setId_qa_ty(String Id_qa_ty) {
		setAttrVal("Id_qa_ty", Id_qa_ty);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 自定义分类id(自动质控配置表)
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}
	/**
	 * 自定义分类id(自动质控配置表)
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 自动以分类名称(自动质控配置表)
	 * @return String
	 */
	public String getMrcactm_name() {
		return ((String) getAttrVal("Mrcactm_name"));
	}
	/**
	 * 自动以分类名称(自动质控配置表)
	 * @param Mrcactm_name
	 */
	public void setMrcactm_name(String Mrcactm_name) {
		setAttrVal("Mrcactm_name", Mrcactm_name);
	}
	/**
	 * 文书类型id(自动质控配置表)
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}
	/**
	 * 文书类型id(自动质控配置表)
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 文书类型名称(自动质控配置表)
	 * @return String
	 */
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}
	/**
	 * 文书类型名称(自动质控配置表)
	 * @param Mrtp_name
	 */
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
	}
}
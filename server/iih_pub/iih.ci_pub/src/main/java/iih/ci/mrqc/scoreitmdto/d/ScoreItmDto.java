package iih.ci.mrqc.scoreitmdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 评分扣分项DTO DTO数据 
 * 
 */
public class ScoreItmDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * dto主键
	 * @return String
	 */
	public String getId_dto() {
		return ((String) getAttrVal("Id_dto"));
	}
	/**
	 * dto主键
	 * @param Id_dto
	 */
	public void setId_dto(String Id_dto) {
		setAttrVal("Id_dto", Id_dto);
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
	 * 评分项目
	 * @return String
	 */
	public String getReq() {
		return ((String) getAttrVal("Req"));
	}
	/**
	 * 评分项目
	 * @param Req
	 */
	public void setReq(String Req) {
		setAttrVal("Req", Req);
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
	 * 一级分类名称
	 * @return String
	 */
	public String getFst_name() {
		return ((String) getAttrVal("Fst_name"));
	}
	/**
	 * 一级分类名称
	 * @param Fst_name
	 */
	public void setFst_name(String Fst_name) {
		setAttrVal("Fst_name", Fst_name);
	}
	/**
	 * 一级分类分值
	 * @return FDouble
	 */
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}
	/**
	 * 一级分类分值
	 * @param Score
	 */
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 扣分类型
	 * @return String
	 */
	public String getId_qa_drp_scr_tp() {
		return ((String) getAttrVal("Id_qa_drp_scr_tp"));
	}
	/**
	 * 扣分类型
	 * @param Id_qa_drp_scr_tp
	 */
	public void setId_qa_drp_scr_tp(String Id_qa_drp_scr_tp) {
		setAttrVal("Id_qa_drp_scr_tp", Id_qa_drp_scr_tp);
	}
	/**
	 * 单词扣分值
	 * @return FDouble
	 */
	public FDouble getOnce_drp_scr() {
		return ((FDouble) getAttrVal("Once_drp_scr"));
	}
	/**
	 * 单词扣分值
	 * @param Once_drp_scr
	 */
	public void setOnce_drp_scr(FDouble Once_drp_scr) {
		setAttrVal("Once_drp_scr", Once_drp_scr);
	}
	/**
	 * 扣分次数
	 * @return Integer
	 */
	public Integer getDeduct_scr_times() {
		return ((Integer) getAttrVal("Deduct_scr_times"));
	}
	/**
	 * 扣分次数
	 * @param Deduct_scr_times
	 */
	public void setDeduct_scr_times(Integer Deduct_scr_times) {
		setAttrVal("Deduct_scr_times", Deduct_scr_times);
	}
	/**
	 * 扣分标准
	 * @return String
	 */
	public String getDeduct_des() {
		return ((String) getAttrVal("Deduct_des"));
	}
	/**
	 * 扣分标准
	 * @param Deduct_des
	 */
	public void setDeduct_des(String Deduct_des) {
		setAttrVal("Deduct_des", Deduct_des);
	}
	/**
	 * 扣分说明
	 * @return String
	 */
	public String getDrp_des() {
		return ((String) getAttrVal("Drp_des"));
	}
	/**
	 * 扣分说明
	 * @param Drp_des
	 */
	public void setDrp_des(String Drp_des) {
		setAttrVal("Drp_des", Drp_des);
	}
	/**
	 * 质控医生id
	 * @return String
	 */
	public String getId_sbmt_user() {
		return ((String) getAttrVal("Id_sbmt_user"));
	}
	/**
	 * 质控医生id
	 * @param Id_sbmt_user
	 */
	public void setId_sbmt_user(String Id_sbmt_user) {
		setAttrVal("Id_sbmt_user", Id_sbmt_user);
	}
	/**
	 * 质控医生
	 * @return String
	 */
	public String getUser_name() {
		return ((String) getAttrVal("User_name"));
	}
	/**
	 * 质控医生
	 * @param User_name
	 */
	public void setUser_name(String User_name) {
		setAttrVal("User_name", User_name);
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
	 * 质控类型
	 * @return String
	 */
	public String getId_qa_ty() {
		return ((String) getAttrVal("Id_qa_ty"));
	}
	/**
	 * 质控类型
	 * @param Id_qa_ty
	 */
	public void setId_qa_ty(String Id_qa_ty) {
		setAttrVal("Id_qa_ty", Id_qa_ty);
	}
}
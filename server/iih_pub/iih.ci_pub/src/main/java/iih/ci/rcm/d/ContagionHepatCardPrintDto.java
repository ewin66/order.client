package iih.ci.rcm.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 乙肝附卡打印 DTO数据
 * 
 */
public class ContagionHepatCardPrintDto extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 乙肝附卡ID
	 * 
	 * @return String
	 */
	public String getId_hepat() {
		return ((String) getAttrVal("Id_hepat"));
	}

	/**
	 * 乙肝附卡ID
	 * 
	 * @param Id_hepat
	 */
	public void setId_hepat(String Id_hepat) {
		setAttrVal("Id_hepat", Id_hepat);
	}

	/**
	 * 父id
	 * 
	 * @return String
	 */
	public String getP_id_contagion() {
		return ((String) getAttrVal("P_id_contagion"));
	}

	/**
	 * 父id
	 * 
	 * @param P_id_contagion
	 */
	public void setP_id_contagion(String P_id_contagion) {
		setAttrVal("P_id_contagion", P_id_contagion);
	}

	/**
	 * 表单
	 * 
	 * @return String
	 */
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}

	/**
	 * 表单
	 * 
	 * @param Id_form
	 */
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}

	/**
	 * HBsAg阳性时间
	 * 
	 * @return String
	 */
	public String getId_hbsag_dt() {
		return ((String) getAttrVal("Id_hbsag_dt"));
	}

	/**
	 * HBsAg阳性时间
	 * 
	 * @param Id_hbsag_dt
	 */
	public void setId_hbsag_dt(String Id_hbsag_dt) {
		setAttrVal("Id_hbsag_dt", Id_hbsag_dt);
	}

	/**
	 * HBsAg阳性时间编码
	 * 
	 * @return String
	 */
	public String getCode_hbsag_dt() {
		return ((String) getAttrVal("Code_hbsag_dt"));
	}

	/**
	 * HBsAg阳性时间编码
	 * 
	 * @param Code_hbsag_dt
	 */
	public void setCode_hbsag_dt(String Code_hbsag_dt) {
		setAttrVal("Code_hbsag_dt", Code_hbsag_dt);
	}

	/**
	 * HBsAg阳性时间name
	 * 
	 * @return String
	 */
	public String getName_hbsag_dt() {
		return ((String) getAttrVal("Name_hbsag_dt"));
	}

	/**
	 * HBsAg阳性时间name
	 * 
	 * @param Name_hbsag_dt
	 */
	public void setName_hbsag_dt(String Name_hbsag_dt) {
		setAttrVal("Name_hbsag_dt", Name_hbsag_dt);
	}

	/**
	 * 首次乙肝发病时间
	 * 
	 * @return FDate
	 */
	public FDate getDt_first() {
		return ((FDate) getAttrVal("Dt_first"));
	}

	/**
	 * 首次乙肝发病时间
	 * 
	 * @param Dt_first
	 */
	public void setDt_first(FDate Dt_first) {
		setAttrVal("Dt_first", Dt_first);
	}

	/**
	 * 本次ALT
	 * 
	 * @return String
	 */
	public String getAlt() {
		return ((String) getAttrVal("Alt"));
	}

	/**
	 * 本次ALT
	 * 
	 * @param Alt
	 */
	public void setAlt(String Alt) {
		setAttrVal("Alt", Alt);
	}

	/**
	 * 抗-HBc IgM1:1000检测结果
	 * 
	 * @return String
	 */
	public String getId_hbc_igm1() {
		return ((String) getAttrVal("Id_hbc_igm1"));
	}

	/**
	 * 抗-HBc IgM1:1000检测结果
	 * 
	 * @param Id_hbc_igm1
	 */
	public void setId_hbc_igm1(String Id_hbc_igm1) {
		setAttrVal("Id_hbc_igm1", Id_hbc_igm1);
	}

	/**
	 * 抗-HBc IgM1:1000检测结果code
	 * 
	 * @return String
	 */
	public String getCode_hbc_igm1() {
		return ((String) getAttrVal("Code_hbc_igm1"));
	}

	/**
	 * 抗-HBc IgM1:1000检测结果code
	 * 
	 * @param Code_hbc_igm1
	 */
	public void setCode_hbc_igm1(String Code_hbc_igm1) {
		setAttrVal("Code_hbc_igm1", Code_hbc_igm1);
	}

	/**
	 * 抗-HBc IgM1:1000检测结果name
	 * 
	 * @return String
	 */
	public String getName_hbc_igm1() {
		return ((String) getAttrVal("Name_hbc_igm1"));
	}

	/**
	 * 抗-HBc IgM1:1000检测结果name
	 * 
	 * @param Name_hbc_igm1
	 */
	public void setName_hbc_igm1(String Name_hbc_igm1) {
		setAttrVal("Name_hbc_igm1", Name_hbc_igm1);
	}

	/**
	 * 肝穿刺检测结果
	 * 
	 * @return String
	 */
	public String getId_liver_puncture_results() {
		return ((String) getAttrVal("Id_liver_puncture_results"));
	}

	/**
	 * 肝穿刺检测结果
	 * 
	 * @param Id_liver_puncture_results
	 */
	public void setId_liver_puncture_results(String Id_liver_puncture_results) {
		setAttrVal("Id_liver_puncture_results", Id_liver_puncture_results);
	}

	/**
	 * 肝穿刺检测结果code
	 * 
	 * @return String
	 */
	public String getCode_liver_puncture_results() {
		return ((String) getAttrVal("Code_liver_puncture_results"));
	}

	/**
	 * 肝穿刺检测结果code
	 * 
	 * @param Code_liver_puncture_results
	 */
	public void setCode_liver_puncture_results(
			String Code_liver_puncture_results) {
		setAttrVal("Code_liver_puncture_results", Code_liver_puncture_results);
	}

	/**
	 * 肝穿刺检测结果name
	 * 
	 * @return String
	 */
	public String getName_liver_puncture_results() {
		return ((String) getAttrVal("Name_liver_puncture_results"));
	}

	/**
	 * 肝穿刺检测结果name
	 * 
	 * @param Name_liver_puncture_results
	 */
	public void setName_liver_puncture_results(
			String Name_liver_puncture_results) {
		setAttrVal("Name_liver_puncture_results", Name_liver_puncture_results);
	}

	/**
	 * 恢复期血清HBsAg阴转
	 * 
	 * @return String
	 */
	public String getId_hbsag_huifu() {
		return ((String) getAttrVal("Id_hbsag_huifu"));
	}

	/**
	 * 恢复期血清HBsAg阴转
	 * 
	 * @param Id_hbsag_huifu
	 */
	public void setId_hbsag_huifu(String Id_hbsag_huifu) {
		setAttrVal("Id_hbsag_huifu", Id_hbsag_huifu);
	}

	/**
	 * 恢复期血清HBsAg阴转code
	 * 
	 * @return String
	 */
	public String getCode_hbsag_huifu() {
		return ((String) getAttrVal("Code_hbsag_huifu"));
	}

	/**
	 * 恢复期血清HBsAg阴转code
	 * 
	 * @param Code_hbsag_huifu
	 */
	public void setCode_hbsag_huifu(String Code_hbsag_huifu) {
		setAttrVal("Code_hbsag_huifu", Code_hbsag_huifu);
	}

	/**
	 * 恢复期血清HBsAg阴转name
	 * 
	 * @return String
	 */
	public String getName_hbsag_huifu() {
		return ((String) getAttrVal("Name_hbsag_huifu"));
	}

	/**
	 * 恢复期血清HBsAg阴转name
	 * 
	 * @param Name_hbsag_huifu
	 */
	public void setName_hbsag_huifu(String Name_hbsag_huifu) {
		setAttrVal("Name_hbsag_huifu", Name_hbsag_huifu);
	}

	/**
	 * 是否知道首次发病时间
	 * 
	 * @return FBoolean
	 */
	public FBoolean getIs_know() {
		return ((FBoolean) getAttrVal("Is_know"));
	}

	/**
	 * 是否知道首次发病时间
	 * 
	 * @param Is_know
	 */
	public void setIs_know(FBoolean Is_know) {
		setAttrVal("Is_know", Is_know);
	}

	/**
	 * HBsAg阳性时间4打印
	 * 
	 * @return String
	 */
	public String getHbsag() {
		return ((String) getAttrVal("Hbsag"));
	}

	/**
	 * HBsAg阳性时间4打印
	 * 
	 * @param Hbsag
	 */
	public void setHbsag(String Hbsag) {
		setAttrVal("Hbsag", Hbsag);
	}

	/**
	 * 肝穿刺检测
	 * 
	 * @return String
	 */
	public String getLiver() {
		return ((String) getAttrVal("Liver"));
	}

	/**
	 * 肝穿刺检测
	 * 
	 * @param Liver
	 */
	public void setLiver(String Liver) {
		setAttrVal("Liver", Liver);
	}

	/**
	 * 抗hbc
	 * 
	 * @return String
	 */
	public String getHbc() {
		return ((String) getAttrVal("Hbc"));
	}

	/**
	 * 抗hbc
	 * 
	 * @param Hbc
	 */
	public void setHbc(String Hbc) {
		setAttrVal("Hbc", Hbc);
	}

	/**
	 * 恢复期血清
	 * 
	 * @return String
	 */
	public String getHbsag_hf() {
		return ((String) getAttrVal("Hbsag_hf"));
	}

	/**
	 * 恢复期血清
	 * 
	 * @param Hbsag_hf
	 */
	public void setHbsag_hf(String Hbsag_hf) {
		setAttrVal("Hbsag_hf", Hbsag_hf);
	}
}
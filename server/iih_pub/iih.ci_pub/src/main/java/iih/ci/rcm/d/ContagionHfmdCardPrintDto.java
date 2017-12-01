package iih.ci.rcm.d;

import xap.mw.core.data.BaseDTO;

/**
 * 手足口附卡打印 DTO数据
 * 
 */
public class ContagionHfmdCardPrintDto extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 手足口附卡ID
	 * 
	 * @return String
	 */
	public String getId_hfmd() {
		return ((String) getAttrVal("Id_hfmd"));
	}

	/**
	 * 手足口附卡ID
	 * 
	 * @param Id_hfmd
	 */
	public void setId_hfmd(String Id_hfmd) {
		setAttrVal("Id_hfmd", Id_hfmd);
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
	 * 实验室结果
	 * 
	 * @return String
	 */
	public String getId_hfm_result() {
		return ((String) getAttrVal("Id_hfm_result"));
	}

	/**
	 * 实验室结果
	 * 
	 * @param Id_hfm_result
	 */
	public void setId_hfm_result(String Id_hfm_result) {
		setAttrVal("Id_hfm_result", Id_hfm_result);
	}

	/**
	 * 实验室结果code
	 * 
	 * @return String
	 */
	public String getCode_hfm_result() {
		return ((String) getAttrVal("Code_hfm_result"));
	}

	/**
	 * 实验室结果code
	 * 
	 * @param Code_hfm_result
	 */
	public void setCode_hfm_result(String Code_hfm_result) {
		setAttrVal("Code_hfm_result", Code_hfm_result);
	}

	/**
	 * 实验室结果name
	 * 
	 * @return String
	 */
	public String getName_hfm_result() {
		return ((String) getAttrVal("Name_hfm_result"));
	}

	/**
	 * 实验室结果name
	 * 
	 * @param Name_hfm_result
	 */
	public void setName_hfm_result(String Name_hfm_result) {
		setAttrVal("Name_hfm_result", Name_hfm_result);
	}

	/**
	 * 重症患者
	 * 
	 * @return String
	 */
	public String getIs_zhongzheng() {
		return ((String) getAttrVal("Is_zhongzheng"));
	}

	/**
	 * 重症患者
	 * 
	 * @param Is_zhongzheng
	 */
	public void setIs_zhongzheng(String Is_zhongzheng) {
		setAttrVal("Is_zhongzheng", Is_zhongzheng);
	}

	/**
	 * 重症患者code
	 * 
	 * @return String
	 */
	public String getCode_zhongzheng() {
		return ((String) getAttrVal("Code_zhongzheng"));
	}

	/**
	 * 重症患者code
	 * 
	 * @param Code_zhongzheng
	 */
	public void setCode_zhongzheng(String Code_zhongzheng) {
		setAttrVal("Code_zhongzheng", Code_zhongzheng);
	}

	/**
	 * 重症患者name
	 * 
	 * @return String
	 */
	public String getName_zhongzheng() {
		return ((String) getAttrVal("Name_zhongzheng"));
	}

	/**
	 * 重症患者name
	 * 
	 * @param Name_zhongzheng
	 */
	public void setName_zhongzheng(String Name_zhongzheng) {
		setAttrVal("Name_zhongzheng", Name_zhongzheng);
	}
}
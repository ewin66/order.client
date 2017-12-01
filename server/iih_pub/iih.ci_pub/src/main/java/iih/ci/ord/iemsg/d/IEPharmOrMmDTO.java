package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE草药医嘱成份信息DTO DTO数据 
 * 
 */
public class IEPharmOrMmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE药品医嘱药品主键标识
	 * @return String
	 */
	public String getId_iepharmormm() {
		return ((String) getAttrVal("Id_iepharmormm"));
	}	
	/**
	 * IE药品医嘱药品主键标识
	 * @param Id_iepharmormm
	 */
	public void setId_iepharmormm(String Id_iepharmormm) {
		setAttrVal("Id_iepharmormm", Id_iepharmormm);
	}
	/**
	 * IE药品医嘱
	 * @return String
	 */
	public String getId_iepharmor() {
		return ((String) getAttrVal("Id_iepharmor"));
	}	
	/**
	 * IE药品医嘱
	 * @param Id_iepharmor
	 */
	public void setId_iepharmor(String Id_iepharmor) {
		setAttrVal("Id_iepharmor", Id_iepharmor);
	}
	/**
	 * 重量
	 * @return String
	 */
	public String getCy_weight() {
		return ((String) getAttrVal("Cy_weight"));
	}	
	/**
	 * 重量
	 * @param Cy_weight
	 */
	public void setCy_weight(String Cy_weight) {
		setAttrVal("Cy_weight", Cy_weight);
	}
	/**
	 * 重量单位
	 * @return String
	 */
	public String getCy_weightunit() {
		return ((String) getAttrVal("Cy_weightunit"));
	}	
	/**
	 * 重量单位
	 * @param Cy_weightunit
	 */
	public void setCy_weightunit(String Cy_weightunit) {
		setAttrVal("Cy_weightunit", Cy_weightunit);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCy_yp_code() {
		return ((String) getAttrVal("Cy_yp_code"));
	}	
	/**
	 * 药品编码
	 * @param Cy_yp_code
	 */
	public void setCy_yp_code(String Cy_yp_code) {
		setAttrVal("Cy_yp_code", Cy_yp_code);
	}
	/**
	 * 包装序号
	 * @return String
	 */
	public String getCy_bz_no() {
		return ((String) getAttrVal("Cy_bz_no"));
	}	
	/**
	 * 包装序号
	 * @param Cy_bz_no
	 */
	public void setCy_bz_no(String Cy_bz_no) {
		setAttrVal("Cy_bz_no", Cy_bz_no);
	}
	/**
	 * 特殊用法编码
	 * @return String
	 */
	public String getCy_tsyf_code() {
		return ((String) getAttrVal("Cy_tsyf_code"));
	}	
	/**
	 * 特殊用法编码
	 * @param Cy_tsyf_code
	 */
	public void setCy_tsyf_code(String Cy_tsyf_code) {
		setAttrVal("Cy_tsyf_code", Cy_tsyf_code);
	}
	/**
	 * 特殊用法
	 * @return String
	 */
	public String getCy_tsyf() {
		return ((String) getAttrVal("Cy_tsyf"));
	}	
	/**
	 * 特殊用法
	 * @param Cy_tsyf
	 */
	public void setCy_tsyf(String Cy_tsyf) {
		setAttrVal("Cy_tsyf", Cy_tsyf);
	}
	/**
	 * 与付数无关标记
	 * @return String
	 */
	public String getCy_fswgbj() {
		return ((String) getAttrVal("Cy_fswgbj"));
	}	
	/**
	 * 与付数无关标记
	 * @param Cy_fswgbj
	 */
	public void setCy_fswgbj(String Cy_fswgbj) {
		setAttrVal("Cy_fswgbj", Cy_fswgbj);
	}
	/**
	 * 与付数无关标记结果
	 * @return String
	 */
	public String getCy_fswgbj_result() {
		return ((String) getAttrVal("Cy_fswgbj_result"));
	}	
	/**
	 * 与付数无关标记结果
	 * @param Cy_fswgbj_result
	 */
	public void setCy_fswgbj_result(String Cy_fswgbj_result) {
		setAttrVal("Cy_fswgbj_result", Cy_fswgbj_result);
	}
	/**
	 * 药物医保类别编码
	 * @return String
	 */
	public String getCy_ywyb_type_code() {
		return ((String) getAttrVal("Cy_ywyb_type_code"));
	}	
	/**
	 * 药物医保类别编码
	 * @param Cy_ywyb_type_code
	 */
	public void setCy_ywyb_type_code(String Cy_ywyb_type_code) {
		setAttrVal("Cy_ywyb_type_code", Cy_ywyb_type_code);
	}
	/**
	 * 药物医保类别名称
	 * @return String
	 */
	public String getCy_ywyb_type_name() {
		return ((String) getAttrVal("Cy_ywyb_type_name"));
	}	
	/**
	 * 药物医保类别名称
	 * @param Cy_ywyb_type_name
	 */
	public void setCy_ywyb_type_name(String Cy_ywyb_type_name) {
		setAttrVal("Cy_ywyb_type_name", Cy_ywyb_type_name);
	}
}
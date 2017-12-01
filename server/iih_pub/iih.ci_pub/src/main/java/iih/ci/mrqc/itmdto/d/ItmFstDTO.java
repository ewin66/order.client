package iih.ci.mrqc.itmdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质控项上下DTO DTO数据 
 * 
 */
public class ItmFstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 一级分类
	 * @return String
	 */
	public String getId_fst() {
		return ((String) getAttrVal("Id_fst"));
	}
	/**
	 * 一级分类
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
	 * 缺陷表主键
	 * @return String
	 */
	public String getId_qa_flt() {
		return ((String) getAttrVal("Id_qa_flt"));
	}
	/**
	 * 缺陷表主键
	 * @param Id_qa_flt
	 */
	public void setId_qa_flt(String Id_qa_flt) {
		setAttrVal("Id_qa_flt", Id_qa_flt);
	}
	/**
	 * 整改说明
	 * @return String
	 */
	public String getRfm_des() {
		return ((String) getAttrVal("Rfm_des"));
	}
	/**
	 * 整改说明
	 * @param Rfm_des
	 */
	public void setRfm_des(String Rfm_des) {
		setAttrVal("Rfm_des", Rfm_des);
	}
}
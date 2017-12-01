package iih.ci.mr.nu.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗记录数据元DTO DTO数据 
 * 
 */
public class NurDocStructDEDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗记录元素ID
	 * @return String
	 */
	public String getId_mrde() {
		return ((String) getAttrVal("Id_mrde"));
	}
	/**
	 * 医疗记录元素ID
	 * @param Id_mrde
	 */
	public void setId_mrde(String Id_mrde) {
		setAttrVal("Id_mrde", Id_mrde);
	}
	/**
	 * 医疗记录元素名称
	 * @return String
	 */
	public String getName_mrde() {
		return ((String) getAttrVal("Name_mrde"));
	}
	/**
	 * 医疗记录元素名称
	 * @param Name_mrde
	 */
	public void setName_mrde(String Name_mrde) {
		setAttrVal("Name_mrde", Name_mrde);
	}
	/**
	 * 医疗记录模板元素id
	 * @return String
	 */
	public String getId_mrtplde() {
		return ((String) getAttrVal("Id_mrtplde"));
	}
	/**
	 * 医疗记录模板元素id
	 * @param Id_mrtplde
	 */
	public void setId_mrtplde(String Id_mrtplde) {
		setAttrVal("Id_mrtplde", Id_mrtplde);
	}
	/**
	 * 数据组ID
	 * @return String
	 */
	public String getId_mrdg() {
		return ((String) getAttrVal("Id_mrdg"));
	}
	/**
	 * 数据组ID
	 * @param Id_mrdg
	 */
	public void setId_mrdg(String Id_mrdg) {
		setAttrVal("Id_mrdg", Id_mrdg);
	}
	/**
	 * 数据组名称
	 * @return String
	 */
	public String getName_mrdg() {
		return ((String) getAttrVal("Name_mrdg"));
	}
	/**
	 * 数据组名称
	 * @param Name_mrdg
	 */
	public void setName_mrdg(String Name_mrdg) {
		setAttrVal("Name_mrdg", Name_mrdg);
	}
	/**
	 * 对应公共数据组ID
	 * @return String
	 */
	public String getId_dg() {
		return ((String) getAttrVal("Id_dg"));
	}
	/**
	 * 对应公共数据组ID
	 * @param Id_dg
	 */
	public void setId_dg(String Id_dg) {
		setAttrVal("Id_dg", Id_dg);
	}
	/**
	 * 对应公共数据组名称
	 * @return String
	 */
	public String getName_dg() {
		return ((String) getAttrVal("Name_dg"));
	}
	/**
	 * 对应公共数据组名称
	 * @param Name_dg
	 */
	public void setName_dg(String Name_dg) {
		setAttrVal("Name_dg", Name_dg);
	}
	/**
	 * 对应公共数据元ID
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}
	/**
	 * 对应公共数据元ID
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 对应公共数据元名称
	 * @return String
	 */
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}
	/**
	 * 对应公共数据元名称
	 * @param Name_de
	 */
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
	}
	/**
	 * 公共数据元编码
	 * @return String
	 */
	public String getCode_de() {
		return ((String) getAttrVal("Code_de"));
	}
	/**
	 * 公共数据元编码
	 * @param Code_de
	 */
	public void setCode_de(String Code_de) {
		setAttrVal("Code_de", Code_de);
	}
	/**
	 * 数据元值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}
	/**
	 * 数据元值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
}
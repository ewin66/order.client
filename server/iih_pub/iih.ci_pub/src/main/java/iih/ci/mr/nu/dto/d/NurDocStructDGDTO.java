package iih.ci.mr.nu.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗记录数据组DTO DTO数据 
 * 
 */
public class NurDocStructDGDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗数据组id
	 * @return String
	 */
	public String getId_mrdg() {
		return ((String) getAttrVal("Id_mrdg"));
	}
	/**
	 * 医疗数据组id
	 * @param Id_mrdg
	 */
	public void setId_mrdg(String Id_mrdg) {
		setAttrVal("Id_mrdg", Id_mrdg);
	}
	/**
	 * 医疗记录组
	 * @return String
	 */
	public String getName_mrdg() {
		return ((String) getAttrVal("Name_mrdg"));
	}
	/**
	 * 医疗记录组
	 * @param Name_mrdg
	 */
	public void setName_mrdg(String Name_mrdg) {
		setAttrVal("Name_mrdg", Name_mrdg);
	}
	/**
	 * 公共数据组id
	 * @return String
	 */
	public String getId_dg() {
		return ((String) getAttrVal("Id_dg"));
	}
	/**
	 * 公共数据组id
	 * @param Id_dg
	 */
	public void setId_dg(String Id_dg) {
		setAttrVal("Id_dg", Id_dg);
	}
	/**
	 * 公共数据组名称
	 * @return String
	 */
	public String getName_dg() {
		return ((String) getAttrVal("Name_dg"));
	}
	/**
	 * 公共数据组名称
	 * @param Name_dg
	 */
	public void setName_dg(String Name_dg) {
		setAttrVal("Name_dg", Name_dg);
	}
	/**
	 * 父级数据组ID
	 * @return String
	 */
	public String getId_mrdg_par() {
		return ((String) getAttrVal("Id_mrdg_par"));
	}
	/**
	 * 父级数据组ID
	 * @param Id_mrdg_par
	 */
	public void setId_mrdg_par(String Id_mrdg_par) {
		setAttrVal("Id_mrdg_par", Id_mrdg_par);
	}
	/**
	 * 父数据组名称
	 * @return String
	 */
	public String getName_mrdg_par() {
		return ((String) getAttrVal("Name_mrdg_par"));
	}
	/**
	 * 父数据组名称
	 * @param Name_mrdg_par
	 */
	public void setName_mrdg_par(String Name_mrdg_par) {
		setAttrVal("Name_mrdg_par", Name_mrdg_par);
	}
	/**
	 * 医疗记录元素集合
	 * @return FArrayList
	 */
	public FArrayList getMrdedtos() {
		return ((FArrayList) getAttrVal("Mrdedtos"));
	}
	/**
	 * 医疗记录元素集合
	 * @param Mrdedtos
	 */
	public void setMrdedtos(FArrayList Mrdedtos) {
		setAttrVal("Mrdedtos", Mrdedtos);
	}
}
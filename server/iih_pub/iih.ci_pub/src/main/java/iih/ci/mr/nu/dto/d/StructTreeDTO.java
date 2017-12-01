package iih.ci.mr.nu.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class StructTreeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键ID
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键ID
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 是否是数据组
	 * @return FBoolean
	 */
	public FBoolean getFg_dg() {
		return ((FBoolean) getAttrVal("Fg_dg"));
	}
	/**
	 * 是否是数据组
	 * @param Fg_dg
	 */
	public void setFg_dg(FBoolean Fg_dg) {
		setAttrVal("Fg_dg", Fg_dg);
	}
	/**
	 * 树显示名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 树显示名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 父级主键
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 父级主键
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
}
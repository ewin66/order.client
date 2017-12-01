package iih.ci.ord.emsdi.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行与库房科室数据信息 DTO数据 
 * 
 */
public class ExeWhDeptDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行科室组织
	 * @return String
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}
	/**
	 * 执行科室组织
	 * @param Id_org_mp
	 */
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	/**
	 * 执行科室组织编码
	 * @return String
	 */
	public String getCode_org_mp() {
		return ((String) getAttrVal("Code_org_mp"));
	}
	/**
	 * 执行科室组织编码
	 * @param Code_org_mp
	 */
	public void setCode_org_mp(String Code_org_mp) {
		setAttrVal("Code_org_mp", Code_org_mp);
	}
	/**
	 * 执行科室组织名称
	 * @return String
	 */
	public String getName_org_mp() {
		return ((String) getAttrVal("Name_org_mp"));
	}
	/**
	 * 执行科室组织名称
	 * @param Name_org_mp
	 */
	public void setName_org_mp(String Name_org_mp) {
		setAttrVal("Name_org_mp", Name_org_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}
	/**
	 * 执行科室编码
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 库房组织
	 * @return String
	 */
	public String getId_org_wh() {
		return ((String) getAttrVal("Id_org_wh"));
	}
	/**
	 * 库房组织
	 * @param Id_org_wh
	 */
	public void setId_org_wh(String Id_org_wh) {
		setAttrVal("Id_org_wh", Id_org_wh);
	}
	/**
	 * 库房组织编码
	 * @return String
	 */
	public String getCode_org_wh() {
		return ((String) getAttrVal("Code_org_wh"));
	}
	/**
	 * 库房组织编码
	 * @param Code_org_wh
	 */
	public void setCode_org_wh(String Code_org_wh) {
		setAttrVal("Code_org_wh", Code_org_wh);
	}
	/**
	 * 库房组织名称
	 * @return String
	 */
	public String getName_org_wh() {
		return ((String) getAttrVal("Name_org_wh"));
	}
	/**
	 * 库房组织名称
	 * @param Name_org_wh
	 */
	public void setName_org_wh(String Name_org_wh) {
		setAttrVal("Name_org_wh", Name_org_wh);
	}
	/**
	 * 库房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 库房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 库房编码
	 * @return String
	 */
	public String getCode_dep_wh() {
		return ((String) getAttrVal("Code_dep_wh"));
	}
	/**
	 * 库房编码
	 * @param Code_dep_wh
	 */
	public void setCode_dep_wh(String Code_dep_wh) {
		setAttrVal("Code_dep_wh", Code_dep_wh);
	}
	/**
	 * 库房名称
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 库房名称
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
}
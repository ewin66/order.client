package iih.ci.ord.dto.medicalroutinetreedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技常规模板树 DTO数据 
 * 
 */
public class Medicalroutinetreedto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 父id
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 父id
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 模板分类
	 * @return String
	 */
	public String getId_ortmplca() {
		return ((String) getAttrVal("Id_ortmplca"));
	}
	/**
	 * 模板分类
	 * @param Id_ortmplca
	 */
	public void setId_ortmplca(String Id_ortmplca) {
		setAttrVal("Id_ortmplca", Id_ortmplca);
	}
	/**
	 * 模板id
	 * @return String
	 */
	public String getId_ortmpl() {
		return ((String) getAttrVal("Id_ortmpl"));
	}
	/**
	 * 模板id
	 * @param Id_ortmpl
	 */
	public void setId_ortmpl(String Id_ortmpl) {
		setAttrVal("Id_ortmpl", Id_ortmpl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDesc() {
		return ((String) getAttrVal("Desc"));
	}
	/**
	 * 描述
	 * @param Desc
	 */
	public void setDesc(String Desc) {
		setAttrVal("Desc", Desc);
	}
}
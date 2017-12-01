package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class ImplVtDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 *  主键
	 * @return String
	 */
	public String getId_implvt() {
		return ((String) getAttrVal("Id_implvt"));
	}
	/**
	 *  主键
	 * @param Id_implvt
	 */
	public void setId_implvt(String Id_implvt) {
		setAttrVal("Id_implvt", Id_implvt);
	}
	/**
	 * 所属集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属集团名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}
	/**
	 * 所属集团名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 所属组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 所属组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 服务分类id
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类id
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务分类内编码
	 * @return String
	 */
	public String getSrvca_innercode() {
		return ((String) getAttrVal("Srvca_innercode"));
	}
	/**
	 * 服务分类内编码
	 * @param Srvca_innercode
	 */
	public void setSrvca_innercode(String Srvca_innercode) {
		setAttrVal("Srvca_innercode", Srvca_innercode);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}
	/**
	 * 服务分类名称
	 * @param Name_srvca
	 */
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	/**
	 * 需要执行的sql
	 * @return String
	 */
	public String getExec_sql() {
		return ((String) getAttrVal("Exec_sql"));
	}
	/**
	 * 需要执行的sql
	 * @param Exec_sql
	 */
	public void setExec_sql(String Exec_sql) {
		setAttrVal("Exec_sql", Exec_sql);
	}
	/**
	 * base64编码的sql语句
	 * @return String
	 */
	public String getExec_sql_base64() {
		return ((String) getAttrVal("Exec_sql_base64"));
	}
	/**
	 * base64编码的sql语句
	 * @param Exec_sql_base64
	 */
	public void setExec_sql_base64(String Exec_sql_base64) {
		setAttrVal("Exec_sql_base64", Exec_sql_base64);
	}
}
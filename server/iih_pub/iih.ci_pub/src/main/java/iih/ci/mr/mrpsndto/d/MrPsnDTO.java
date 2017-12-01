package iih.ci.mr.mrpsndto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 人员 DTO 上级查房医师专用 DTO数据 
 * 
 */
public class MrPsnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户Id
	 * @return String
	 */
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}
	/**
	 * 用户Id
	 * @param Id_user
	 */
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
	}
	/**
	 * 人员Id
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}
	/**
	 * 人员Id
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 职称
	 * @return String
	 */
	public String getPsndocname() {
		return ((String) getAttrVal("Psndocname"));
	}
	/**
	 * 职称
	 * @param Psndocname
	 */
	public void setPsndocname(String Psndocname) {
		setAttrVal("Psndocname", Psndocname);
	}
}
package iih.ci.ord.dto.orobsandlab.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class OrObsAandLabDTO extends BaseDTO {
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
	 * 父id
	 * @return String
	 */
	public String getParent() {
		return ((String) getAttrVal("Parent"));
	}
	/**
	 * 父id
	 * @param Parent
	 */
	public void setParent(String Parent) {
		setAttrVal("Parent", Parent);
	}
	/**
	 * 类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 日期
	 * @return FDateTime
	 */
	public FDateTime getDtor() {
		return ((FDateTime) getAttrVal("Dtor"));
	}
	/**
	 * 日期
	 * @param Dtor
	 */
	public void setDtor(FDateTime Dtor) {
		setAttrVal("Dtor", Dtor);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getSignname() {
		return ((String) getAttrVal("Signname"));
	}
	/**
	 * 医生名称
	 * @param Signname
	 */
	public void setSignname(String Signname) {
		setAttrVal("Signname", Signname);
	}
}
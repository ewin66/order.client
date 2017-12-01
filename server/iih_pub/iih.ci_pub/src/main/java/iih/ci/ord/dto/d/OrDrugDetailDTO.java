package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 服务项目 DTO数据 
 * 
 */
public class OrDrugDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getNamesrv() {
		return ((String) getAttrVal("Namesrv"));
	}
	/**
	 * 名称
	 * @param Namesrv
	 */
	public void setNamesrv(String Namesrv) {
		setAttrVal("Namesrv", Namesrv);
	}
	/**
	 * 剂量
	 * @return String
	 */
	public String getQuan_medu() {
		return ((String) getAttrVal("Quan_medu"));
	}
	/**
	 * 剂量
	 * @param Quan_medu
	 */
	public void setQuan_medu(String Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医疗单位id
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}
	/**
	 * 医疗单位id
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 医疗单位
	 * @return String
	 */
	public String getName_medu() {
		return ((String) getAttrVal("Name_medu"));
	}
	/**
	 * 医疗单位
	 * @param Name_medu
	 */
	public void setName_medu(String Name_medu) {
		setAttrVal("Name_medu", Name_medu);
	}
	/**
	 * 用法id
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法id
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
}
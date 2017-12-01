package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊处方列表 DTO数据 
 * 
 */
public class OpPresList extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_opordpres() {
		return ((String) getAttrVal("Id_opordpres"));
	}
	/**
	 * 主键
	 * @param Id_opordpres
	 */
	public void setId_opordpres(String Id_opordpres) {
		setAttrVal("Id_opordpres", Id_opordpres);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getName_prestp() {
		return ((String) getAttrVal("Name_prestp"));
	}
	/**
	 * 处方类型
	 * @param Name_prestp
	 */
	public void setName_prestp(String Name_prestp) {
		setAttrVal("Name_prestp", Name_prestp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 提示
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}
	/**
	 * 提示
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 处方号
	 * @return Integer
	 */
	public Integer getPres_no() {
		return ((Integer) getAttrVal("Pres_no"));
	}
	/**
	 * 处方号
	 * @param Pres_no
	 */
	public void setPres_no(Integer Pres_no) {
		setAttrVal("Pres_no", Pres_no);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getOrder_des() {
		return ((String) getAttrVal("Order_des"));
	}
	/**
	 * 医嘱内容
	 * @param Order_des
	 */
	public void setOrder_des(String Order_des) {
		setAttrVal("Order_des", Order_des);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 开立医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
}
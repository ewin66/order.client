package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术表单列表项目 DTO数据 
 * 
 */
public class EmsItemInOp extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_oropitem() {
		return ((String) getAttrVal("Id_oropitem"));
	}
	/**
	 * 主键
	 * @param Id_oropitem
	 */
	public void setId_oropitem(String Id_oropitem) {
		setAttrVal("Id_oropitem", Id_oropitem);
	}
	/**
	 * 人员id
	 * @return String
	 */
	public String getId_emp_op() {
		return ((String) getAttrVal("Id_emp_op"));
	}
	/**
	 * 人员id
	 * @param Id_emp_op
	 */
	public void setId_emp_op(String Id_emp_op) {
		setAttrVal("Id_emp_op", Id_emp_op);
	}
	/**
	 * 人员
	 * @return String
	 */
	public String getName_emp_op() {
		return ((String) getAttrVal("Name_emp_op"));
	}
	/**
	 * 人员
	 * @param Name_emp_op
	 */
	public void setName_emp_op(String Name_emp_op) {
		setAttrVal("Name_emp_op", Name_emp_op);
	}
	/**
	 * 角色id
	 * @return String
	 */
	public String getId_role() {
		return ((String) getAttrVal("Id_role"));
	}
	/**
	 * 角色id
	 * @param Id_role
	 */
	public void setId_role(String Id_role) {
		setAttrVal("Id_role", Id_role);
	}
	/**
	 * 角色编码
	 * @return String
	 */
	public String getSd_role() {
		return ((String) getAttrVal("Sd_role"));
	}
	/**
	 * 角色编码
	 * @param Sd_role
	 */
	public void setSd_role(String Sd_role) {
		setAttrVal("Sd_role", Sd_role);
	}
	/**
	 * 角色
	 * @return String
	 */
	public String getName_role() {
		return ((String) getAttrVal("Name_role"));
	}
	/**
	 * 角色
	 * @param Name_role
	 */
	public void setName_role(String Name_role) {
		setAttrVal("Name_role", Name_role);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 物品类型id
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}
	/**
	 * 物品类型id
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 物品类型编码
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}
	/**
	 * 物品类型编码
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	/**
	 * 物品类型
	 * @return String
	 */
	public String getName_mmtp() {
		return ((String) getAttrVal("Name_mmtp"));
	}
	/**
	 * 物品类型
	 * @param Name_mmtp
	 */
	public void setName_mmtp(String Name_mmtp) {
		setAttrVal("Name_mmtp", Name_mmtp);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 厂商id
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}
	/**
	 * 厂商id
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 厂商
	 * @return String
	 */
	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}
	/**
	 * 厂商
	 * @param Name_sup
	 */
	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 数量
	 * @return Integer
	 */
	public Integer getQuan_cur() {
		return ((Integer) getAttrVal("Quan_cur"));
	}
	/**
	 * 数量
	 * @param Quan_cur
	 */
	public void setQuan_cur(Integer Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 零售包装单位id
	 * @return String
	 */
	public String getId_unit_pkgsp() {
		return ((String) getAttrVal("Id_unit_pkgsp"));
	}
	/**
	 * 零售包装单位id
	 * @param Id_unit_pkgsp
	 */
	public void setId_unit_pkgsp(String Id_unit_pkgsp) {
		setAttrVal("Id_unit_pkgsp", Id_unit_pkgsp);
	}
	/**
	 * 零售包装单位
	 * @return String
	 */
	public String getName_unit_pkgsp() {
		return ((String) getAttrVal("Name_unit_pkgsp"));
	}
	/**
	 * 零售包装单位
	 * @param Name_unit_pkgsp
	 */
	public void setName_unit_pkgsp(String Name_unit_pkgsp) {
		setAttrVal("Name_unit_pkgsp", Name_unit_pkgsp);
	}
	/**
	 * 排序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 排序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 手术 编码(code_srv)
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 手术 编码(code_srv)
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 手术id（id_srv）
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 手术id（id_srv）
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 手术名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 手术描述
	 * @return String
	 */
	public String getDes_op() {
		return ((String) getAttrVal("Des_op"));
	}
	/**
	 * 手术描述
	 * @param Des_op
	 */
	public void setDes_op(String Des_op) {
		setAttrVal("Des_op", Des_op);
	}
	/**
	 * Id_orsrv
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * Id_orsrv
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
}
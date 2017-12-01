package iih.ci.ord.emsdi.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱流向科室数据信息DTO DTO数据 
 * 
 */
public class OrWfDeptInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱流向执行科室列表
	 * @return FArrayList
	 */
	public FArrayList getOrwfexedepts() {
		return ((FArrayList) getAttrVal("Orwfexedepts"));
	}
	/**
	 * 医嘱流向执行科室列表
	 * @param Orwfexedepts
	 */
	public void setOrwfexedepts(FArrayList Orwfexedepts) {
		setAttrVal("Orwfexedepts", Orwfexedepts);
	}
	/**
	 * 物品流向库房科室列表
	 * @return FArrayList
	 */
	public FArrayList getPharmwfwhdepts() {
		return ((FArrayList) getAttrVal("Pharmwfwhdepts"));
	}
	/**
	 * 物品流向库房科室列表
	 * @param Pharmwfwhdepts
	 */
	public void setPharmwfwhdepts(FArrayList Pharmwfwhdepts) {
		setAttrVal("Pharmwfwhdepts", Pharmwfwhdepts);
	}
	/**
	 * 第一个执行科室id
	 * @return String
	 */
	public String getFirstid_mp_dept() {
		return ((String) getAttrVal("Firstid_mp_dept"));
	}
	/**
	 * 第一个执行科室id
	 * @param Firstid_mp_dept
	 */
	public void setFirstid_mp_dept(String Firstid_mp_dept) {
		setAttrVal("Firstid_mp_dept", Firstid_mp_dept);
	}
	/**
	 * 第一个执行科室名称
	 * @return String
	 */
	public String getFirstname_mp_dept() {
		return ((String) getAttrVal("Firstname_mp_dept"));
	}
	/**
	 * 第一个执行科室名称
	 * @param Firstname_mp_dept
	 */
	public void setFirstname_mp_dept(String Firstname_mp_dept) {
		setAttrVal("Firstname_mp_dept", Firstname_mp_dept);
	}
	/**
	 * 执行科室字符串
	 * @return String
	 */
	public String getId_mp_depts() {
		return ((String) getAttrVal("Id_mp_depts"));
	}
	/**
	 * 执行科室字符串
	 * @param Id_mp_depts
	 */
	public void setId_mp_depts(String Id_mp_depts) {
		setAttrVal("Id_mp_depts", Id_mp_depts);
	}
	/**
	 * 库存id
	 * @return String
	 */
	public String getId_dept_wh() {
		return ((String) getAttrVal("Id_dept_wh"));
	}
	/**
	 * 库存id
	 * @param Id_dept_wh
	 */
	public void setId_dept_wh(String Id_dept_wh) {
		setAttrVal("Id_dept_wh", Id_dept_wh);
	}
	/**
	 * 库房名称
	 * @return String
	 */
	public String getName_dept_wh() {
		return ((String) getAttrVal("Name_dept_wh"));
	}
	/**
	 * 库房名称
	 * @param Name_dept_wh
	 */
	public void setName_dept_wh(String Name_dept_wh) {
		setAttrVal("Name_dept_wh", Name_dept_wh);
	}
	/**
	 * 库房主键字符串拼接
	 * @return String
	 */
	public String getId_dept_whs() {
		return ((String) getAttrVal("Id_dept_whs"));
	}
	/**
	 * 库房主键字符串拼接
	 * @param Id_dept_whs
	 */
	public void setId_dept_whs(String Id_dept_whs) {
		setAttrVal("Id_dept_whs", Id_dept_whs);
	}
}
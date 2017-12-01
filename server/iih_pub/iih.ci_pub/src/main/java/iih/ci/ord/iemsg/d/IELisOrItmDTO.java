package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE检验申请对应项目信息DTO DTO数据 
 * 
 */
public class IELisOrItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检验申请对应项目主键标识
	 * @return String
	 */
	public String getId_ielisoritm() {
		return ((String) getAttrVal("Id_ielisoritm"));
	}	
	/**
	 * IE检验申请对应项目主键标识
	 * @param Id_ielisoritm
	 */
	public void setId_ielisoritm(String Id_ielisoritm) {
		setAttrVal("Id_ielisoritm", Id_ielisoritm);
	}
	/**
	 * IE检验申请
	 * @return String
	 */
	public String getId_ielisor() {
		return ((String) getAttrVal("Id_ielisor"));
	}	
	/**
	 * IE检验申请
	 * @param Id_ielisor
	 */
	public void setId_ielisor(String Id_ielisor) {
		setAttrVal("Id_ielisor", Id_ielisor);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getMedicaladvicecode() {
		return ((String) getAttrVal("Medicaladvicecode"));
	}	
	/**
	 * 医嘱号
	 * @param Medicaladvicecode
	 */
	public void setMedicaladvicecode(String Medicaladvicecode) {
		setAttrVal("Medicaladvicecode", Medicaladvicecode);
	}
	/**
	 * 检验项目编码
	 * @return String
	 */
	public String getTestcode() {
		return ((String) getAttrVal("Testcode"));
	}	
	/**
	 * 检验项目编码
	 * @param Testcode
	 */
	public void setTestcode(String Testcode) {
		setAttrVal("Testcode", Testcode);
	}
	/**
	 * 检验项目名称
	 * @return String
	 */
	public String getTestname() {
		return ((String) getAttrVal("Testname"));
	}	
	/**
	 * 检验项目名称
	 * @param Testname
	 */
	public void setTestname(String Testname) {
		setAttrVal("Testname", Testname);
	}
	/**
	 * 检验项目优先级别
	 * @return String
	 */
	public String getPriorityid() {
		return ((String) getAttrVal("Priorityid"));
	}	
	/**
	 * 检验项目优先级别
	 * @param Priorityid
	 */
	public void setPriorityid(String Priorityid) {
		setAttrVal("Priorityid", Priorityid);
	}
	/**
	 * 检验描述编码
	 * @return String
	 */
	public String getJydescode() {
		return ((String) getAttrVal("Jydescode"));
	}	
	/**
	 * 检验描述编码
	 * @param Jydescode
	 */
	public void setJydescode(String Jydescode) {
		setAttrVal("Jydescode", Jydescode);
	}
	/**
	 * 检验描述名称
	 * @return String
	 */
	public String getJydesname() {
		return ((String) getAttrVal("Jydesname"));
	}	
	/**
	 * 检验描述名称
	 * @param Jydesname
	 */
	public void setJydesname(String Jydesname) {
		setAttrVal("Jydesname", Jydesname);
	}
	/**
	 * 采集部位
	 * @return String
	 */
	public String getCollectposition() {
		return ((String) getAttrVal("Collectposition"));
	}	
	/**
	 * 采集部位
	 * @param Collectposition
	 */
	public void setCollectposition(String Collectposition) {
		setAttrVal("Collectposition", Collectposition);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getLabnum() {
		return ((String) getAttrVal("Labnum"));
	}	
	/**
	 * 标本号
	 * @param Labnum
	 */
	public void setLabnum(String Labnum) {
		setAttrVal("Labnum", Labnum);
	}
	/**
	 * 标本类型
	 * @return String
	 */
	public String getLabtype() {
		return ((String) getAttrVal("Labtype"));
	}	
	/**
	 * 标本类型
	 * @param Labtype
	 */
	public void setLabtype(String Labtype) {
		setAttrVal("Labtype", Labtype);
	}
	/**
	 * 标本名称
	 * @return String
	 */
	public String getLabname() {
		return ((String) getAttrVal("Labname"));
	}	
	/**
	 * 标本名称
	 * @param Labname
	 */
	public void setLabname(String Labname) {
		setAttrVal("Labname", Labname);
	}
	/**
	 * 采集日期
	 * @return FDateTime
	 */
	public FDateTime getCollectdatetime() {
		return ((FDateTime) getAttrVal("Collectdatetime"));
	}	
	/**
	 * 采集日期
	 * @param Collectdatetime
	 */
	public void setCollectdatetime(FDateTime Collectdatetime) {
		setAttrVal("Collectdatetime", Collectdatetime);
	}
	/**
	 * 测试项目容器类型
	 * @return String
	 */
	public String getContainerid() {
		return ((String) getAttrVal("Containerid"));
	}	
	/**
	 * 测试项目容器类型
	 * @param Containerid
	 */
	public void setContainerid(String Containerid) {
		setAttrVal("Containerid", Containerid);
	}
	/**
	 * 测试项目容器名称
	 * @return String
	 */
	public String getContainername() {
		return ((String) getAttrVal("Containername"));
	}	
	/**
	 * 测试项目容器名称
	 * @param Containername
	 */
	public void setContainername(String Containername) {
		setAttrVal("Containername", Containername);
	}
	/**
	 * 采集人id
	 * @return String
	 */
	public String getCollectbyid() {
		return ((String) getAttrVal("Collectbyid"));
	}	
	/**
	 * 采集人id
	 * @param Collectbyid
	 */
	public void setCollectbyid(String Collectbyid) {
		setAttrVal("Collectbyid", Collectbyid);
	}
	/**
	 * 采集人姓名
	 * @return String
	 */
	public String getCollectbyname() {
		return ((String) getAttrVal("Collectbyname"));
	}	
	/**
	 * 采集人姓名
	 * @param Collectbyname
	 */
	public void setCollectbyname(String Collectbyname) {
		setAttrVal("Collectbyname", Collectbyname);
	}
	/**
	 * 采集地点
	 * @return String
	 */
	public String getCollectaddressid() {
		return ((String) getAttrVal("Collectaddressid"));
	}	
	/**
	 * 采集地点
	 * @param Collectaddressid
	 */
	public void setCollectaddressid(String Collectaddressid) {
		setAttrVal("Collectaddressid", Collectaddressid);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExec_dept_code() {
		return ((String) getAttrVal("Exec_dept_code"));
	}	
	/**
	 * 执行科室编码
	 * @param Exec_dept_code
	 */
	public void setExec_dept_code(String Exec_dept_code) {
		setAttrVal("Exec_dept_code", Exec_dept_code);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExec_dept_name() {
		return ((String) getAttrVal("Exec_dept_name"));
	}	
	/**
	 * 执行科室名称
	 * @param Exec_dept_name
	 */
	public void setExec_dept_name(String Exec_dept_name) {
		setAttrVal("Exec_dept_name", Exec_dept_name);
	}
	/**
	 * 测试项目价格
	 * @return String
	 */
	public String getCharge_price_total() {
		return ((String) getAttrVal("Charge_price_total"));
	}	
	/**
	 * 测试项目价格
	 * @param Charge_price_total
	 */
	public void setCharge_price_total(String Charge_price_total) {
		setAttrVal("Charge_price_total", Charge_price_total);
	}
	/**
	 * 耗材价格
	 * @return String
	 */
	public String getSuppliesprice() {
		return ((String) getAttrVal("Suppliesprice"));
	}	
	/**
	 * 耗材价格
	 * @param Suppliesprice
	 */
	public void setSuppliesprice(String Suppliesprice) {
		setAttrVal("Suppliesprice", Suppliesprice);
	}
	/**
	 * 备注类型
	 * @return String
	 */
	public String getMemotype() {
		return ((String) getAttrVal("Memotype"));
	}	
	/**
	 * 备注类型
	 * @param Memotype
	 */
	public void setMemotype(String Memotype) {
		setAttrVal("Memotype", Memotype);
	}
	/**
	 * 标本要求
	 * @return String
	 */
	public String getLabneed() {
		return ((String) getAttrVal("Labneed"));
	}	
	/**
	 * 标本要求
	 * @param Labneed
	 */
	public void setLabneed(String Labneed) {
		setAttrVal("Labneed", Labneed);
	}
	/**
	 * 是否皮试
	 * @return String
	 */
	public String getIsstest() {
		return ((String) getAttrVal("Isstest"));
	}	
	/**
	 * 是否皮试
	 * @param Isstest
	 */
	public void setIsstest(String Isstest) {
		setAttrVal("Isstest", Isstest);
	}
	/**
	 * 是否皮试结果
	 * @return String
	 */
	public String getStest() {
		return ((String) getAttrVal("Stest"));
	}	
	/**
	 * 是否皮试结果
	 * @param Stest
	 */
	public void setStest(String Stest) {
		setAttrVal("Stest", Stest);
	}
	/**
	 * 是否加急
	 * @return String
	 */
	public String getIs_em() {
		return ((String) getAttrVal("Is_em"));
	}	
	/**
	 * 是否加急
	 * @param Is_em
	 */
	public void setIs_em(String Is_em) {
		setAttrVal("Is_em", Is_em);
	}
	/**
	 * 是否加急结果
	 * @return String
	 */
	public String getIs_em_r() {
		return ((String) getAttrVal("Is_em_r"));
	}	
	/**
	 * 是否加急结果
	 * @param Is_em_r
	 */
	public void setIs_em_r(String Is_em_r) {
		setAttrVal("Is_em_r", Is_em_r);
	}
	/**
	 * 是否药观
	 * @return String
	 */
	public String getIsyg() {
		return ((String) getAttrVal("Isyg"));
	}	
	/**
	 * 是否药观
	 * @param Isyg
	 */
	public void setIsyg(String Isyg) {
		setAttrVal("Isyg", Isyg);
	}
	/**
	 * 是否药观结果
	 * @return String
	 */
	public String getYg() {
		return ((String) getAttrVal("Yg"));
	}	
	/**
	 * 是否药观结果
	 * @param Yg
	 */
	public void setYg(String Yg) {
		setAttrVal("Yg", Yg);
	}
	/**
	 * 医嘱执行频率编码
	 * @return String
	 */
	public String getXy_zcy_fre_code() {
		return ((String) getAttrVal("Xy_zcy_fre_code"));
	}	
	/**
	 * 医嘱执行频率编码
	 * @param Xy_zcy_fre_code
	 */
	public void setXy_zcy_fre_code(String Xy_zcy_fre_code) {
		setAttrVal("Xy_zcy_fre_code", Xy_zcy_fre_code);
	}
	/**
	 * 医嘱执行频率名称
	 * @return String
	 */
	public String getXy_zcy_fre_name() {
		return ((String) getAttrVal("Xy_zcy_fre_name"));
	}	
	/**
	 * 医嘱执行频率名称
	 * @param Xy_zcy_fre_name
	 */
	public void setXy_zcy_fre_name(String Xy_zcy_fre_name) {
		setAttrVal("Xy_zcy_fre_name", Xy_zcy_fre_name);
	}
	/**
	 * VIP标识
	 * @return String
	 */
	public String getEu_vip() {
		return ((String) getAttrVal("Eu_vip"));
	}	
	/**
	 * VIP标识
	 * @param Eu_vip
	 */
	public void setEu_vip(String Eu_vip) {
		setAttrVal("Eu_vip", Eu_vip);
	}
}
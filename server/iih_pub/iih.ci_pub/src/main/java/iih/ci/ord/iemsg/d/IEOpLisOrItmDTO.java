package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检验申请对应项目信息DTO DTO数据 
 * 
 */
public class IEOpLisOrItmDTO extends BaseDTO {
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
	public String getYz_no() {
		return ((String) getAttrVal("Yz_no"));
	}	
	/**
	 * 医嘱号
	 * @param Yz_no
	 */
	public void setYz_no(String Yz_no) {
		setAttrVal("Yz_no", Yz_no);
	}
	/**
	 * 检验项目编码
	 * @return String
	 */
	public String getJy_applyserial() {
		return ((String) getAttrVal("Jy_applyserial"));
	}	
	/**
	 * 检验项目编码
	 * @param Jy_applyserial
	 */
	public void setJy_applyserial(String Jy_applyserial) {
		setAttrVal("Jy_applyserial", Jy_applyserial);
	}
	/**
	 * 检验项目名称
	 * @return String
	 */
	public String getJyname() {
		return ((String) getAttrVal("Jyname"));
	}	
	/**
	 * 检验项目名称
	 * @param Jyname
	 */
	public void setJyname(String Jyname) {
		setAttrVal("Jyname", Jyname);
	}
	/**
	 * 检验项目优先级别
	 * @return String
	 */
	public String getPriority() {
		return ((String) getAttrVal("Priority"));
	}	
	/**
	 * 检验项目优先级别
	 * @param Priority
	 */
	public void setPriority(String Priority) {
		setAttrVal("Priority", Priority);
	}
	/**
	 * 医嘱开始时间
	 * @return FDateTime
	 */
	public FDateTime getYz_start_date() {
		return ((FDateTime) getAttrVal("Yz_start_date"));
	}	
	/**
	 * 医嘱开始时间
	 * @param Yz_start_date
	 */
	public void setYz_start_date(FDateTime Yz_start_date) {
		setAttrVal("Yz_start_date", Yz_start_date);
	}
	/**
	 * 医嘱停止时间
	 * @return FDateTime
	 */
	public FDateTime getYz_stop_date() {
		return ((FDateTime) getAttrVal("Yz_stop_date"));
	}	
	/**
	 * 医嘱停止时间
	 * @param Yz_stop_date
	 */
	public void setYz_stop_date(FDateTime Yz_stop_date) {
		setAttrVal("Yz_stop_date", Yz_stop_date);
	}
	/**
	 * 医嘱执行频率编码
	 * @return String
	 */
	public String getYz_frequency() {
		return ((String) getAttrVal("Yz_frequency"));
	}	
	/**
	 * 医嘱执行频率编码
	 * @param Yz_frequency
	 */
	public void setYz_frequency(String Yz_frequency) {
		setAttrVal("Yz_frequency", Yz_frequency);
	}
	/**
	 * 医嘱执行频率名称
	 * @return String
	 */
	public String getYz_frequency_name() {
		return ((String) getAttrVal("Yz_frequency_name"));
	}	
	/**
	 * 医嘱执行频率名称
	 * @param Yz_frequency_name
	 */
	public void setYz_frequency_name(String Yz_frequency_name) {
		setAttrVal("Yz_frequency_name", Yz_frequency_name);
	}
	/**
	 * 检验描述编码
	 * @return String
	 */
	public String getDescp_code() {
		return ((String) getAttrVal("Descp_code"));
	}	
	/**
	 * 检验描述编码
	 * @param Descp_code
	 */
	public void setDescp_code(String Descp_code) {
		setAttrVal("Descp_code", Descp_code);
	}
	/**
	 * 检验描述名称
	 * @return String
	 */
	public String getDescription() {
		return ((String) getAttrVal("Description"));
	}	
	/**
	 * 检验描述名称
	 * @param Description
	 */
	public void setDescription(String Description) {
		setAttrVal("Description", Description);
	}
	/**
	 * 采集部位
	 * @return String
	 */
	public String getCollect_ragion() {
		return ((String) getAttrVal("Collect_ragion"));
	}	
	/**
	 * 采集部位
	 * @param Collect_ragion
	 */
	public void setCollect_ragion(String Collect_ragion) {
		setAttrVal("Collect_ragion", Collect_ragion);
	}
	/**
	 * 标本号
	 * @return String
	 */
	public String getSample_id() {
		return ((String) getAttrVal("Sample_id"));
	}	
	/**
	 * 标本号
	 * @param Sample_id
	 */
	public void setSample_id(String Sample_id) {
		setAttrVal("Sample_id", Sample_id);
	}
	/**
	 * 标本类型
	 * @return String
	 */
	public String getSample_class() {
		return ((String) getAttrVal("Sample_class"));
	}	
	/**
	 * 标本类型
	 * @param Sample_class
	 */
	public void setSample_class(String Sample_class) {
		setAttrVal("Sample_class", Sample_class);
	}
	/**
	 * 标本名称
	 * @return String
	 */
	public String getSample_code_name() {
		return ((String) getAttrVal("Sample_code_name"));
	}	
	/**
	 * 标本名称
	 * @param Sample_code_name
	 */
	public void setSample_code_name(String Sample_code_name) {
		setAttrVal("Sample_code_name", Sample_code_name);
	}
	/**
	 * 采集日期
	 * @return FDateTime
	 */
	public FDateTime getCollect_time() {
		return ((FDateTime) getAttrVal("Collect_time"));
	}	
	/**
	 * 采集日期
	 * @param Collect_time
	 */
	public void setCollect_time(FDateTime Collect_time) {
		setAttrVal("Collect_time", Collect_time);
	}
	/**
	 * 测试项目容器类型
	 * @return String
	 */
	public String getContainer_code() {
		return ((String) getAttrVal("Container_code"));
	}	
	/**
	 * 测试项目容器类型
	 * @param Container_code
	 */
	public void setContainer_code(String Container_code) {
		setAttrVal("Container_code", Container_code);
	}
	/**
	 * 测试项目容器名称
	 * @return String
	 */
	public String getContainer_code_name() {
		return ((String) getAttrVal("Container_code_name"));
	}	
	/**
	 * 测试项目容器名称
	 * @param Container_code_name
	 */
	public void setContainer_code_name(String Container_code_name) {
		setAttrVal("Container_code_name", Container_code_name);
	}
	/**
	 * 采集人id
	 * @return String
	 */
	public String getCollecter_code() {
		return ((String) getAttrVal("Collecter_code"));
	}	
	/**
	 * 采集人id
	 * @param Collecter_code
	 */
	public void setCollecter_code(String Collecter_code) {
		setAttrVal("Collecter_code", Collecter_code);
	}
	/**
	 * 采集人姓名
	 * @return String
	 */
	public String getCollecter_code_name() {
		return ((String) getAttrVal("Collecter_code_name"));
	}	
	/**
	 * 采集人姓名
	 * @param Collecter_code_name
	 */
	public void setCollecter_code_name(String Collecter_code_name) {
		setAttrVal("Collecter_code_name", Collecter_code_name);
	}
	/**
	 * 采集地点
	 * @return String
	 */
	public String getCollecter_place() {
		return ((String) getAttrVal("Collecter_place"));
	}	
	/**
	 * 采集地点
	 * @param Collecter_place
	 */
	public void setCollecter_place(String Collecter_place) {
		setAttrVal("Collecter_place", Collecter_place);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExec_code() {
		return ((String) getAttrVal("Exec_code"));
	}	
	/**
	 * 执行科室编码
	 * @param Exec_code
	 */
	public void setExec_code(String Exec_code) {
		setAttrVal("Exec_code", Exec_code);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExec_code_name() {
		return ((String) getAttrVal("Exec_code_name"));
	}	
	/**
	 * 执行科室名称
	 * @param Exec_code_name
	 */
	public void setExec_code_name(String Exec_code_name) {
		setAttrVal("Exec_code_name", Exec_code_name);
	}
	/**
	 * 测试项目价格
	 * @return String
	 */
	public String getTest_price() {
		return ((String) getAttrVal("Test_price"));
	}	
	/**
	 * 测试项目价格
	 * @param Test_price
	 */
	public void setTest_price(String Test_price) {
		setAttrVal("Test_price", Test_price);
	}
	/**
	 * 耗材价格
	 * @return String
	 */
	public String getSupply_price() {
		return ((String) getAttrVal("Supply_price"));
	}	
	/**
	 * 耗材价格
	 * @param Supply_price
	 */
	public void setSupply_price(String Supply_price) {
		setAttrVal("Supply_price", Supply_price);
	}
	/**
	 * 备注类型
	 * @return String
	 */
	public String getCommenttp() {
		return ((String) getAttrVal("Commenttp"));
	}	
	/**
	 * 备注类型
	 * @param Commenttp
	 */
	public void setCommenttp(String Commenttp) {
		setAttrVal("Commenttp", Commenttp);
	}
	/**
	 * 标本要求
	 * @return String
	 */
	public String getSample_request() {
		return ((String) getAttrVal("Sample_request"));
	}	
	/**
	 * 标本要求
	 * @param Sample_request
	 */
	public void setSample_request(String Sample_request) {
		setAttrVal("Sample_request", Sample_request);
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
	 * vip的值
	 * @return String
	 */
	public String getEu_vip() {
		return ((String) getAttrVal("Eu_vip"));
	}	
	/**
	 * vip的值
	 * @param Eu_vip
	 */
	public void setEu_vip(String Eu_vip) {
		setAttrVal("Eu_vip", Eu_vip);
	}
}
package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE检查申请对应项目信息DTO DTO数据 
 * 
 */
public class IERisOrItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检查申请对应项目主键标识
	 * @return String
	 */
	public String getId_ierisoritm() {
		return ((String) getAttrVal("Id_ierisoritm"));
	}	
	/**
	 * IE检查申请对应项目主键标识
	 * @param Id_ierisoritm
	 */
	public void setId_ierisoritm(String Id_ierisoritm) {
		setAttrVal("Id_ierisoritm", Id_ierisoritm);
	}
	/**
	 * IE检查申请
	 * @return String
	 */
	public String getId_ierisor() {
		return ((String) getAttrVal("Id_ierisor"));
	}	
	/**
	 * IE检查申请
	 * @param Id_ierisor
	 */
	public void setId_ierisor(String Id_ierisor) {
		setAttrVal("Id_ierisor", Id_ierisor);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getYz_ordercode() {
		return ((String) getAttrVal("Yz_ordercode"));
	}	
	/**
	 * 医嘱号
	 * @param Yz_ordercode
	 */
	public void setYz_ordercode(String Yz_ordercode) {
		setAttrVal("Yz_ordercode", Yz_ordercode);
	}
	/**
	 * 检查项目编码
	 * @return String
	 */
	public String getYz_jccode() {
		return ((String) getAttrVal("Yz_jccode"));
	}	
	/**
	 * 检查项目编码
	 * @param Yz_jccode
	 */
	public void setYz_jccode(String Yz_jccode) {
		setAttrVal("Yz_jccode", Yz_jccode);
	}
	/**
	 * 检查项目名称
	 * @return String
	 */
	public String getYz_jcname() {
		return ((String) getAttrVal("Yz_jcname"));
	}	
	/**
	 * 检查项目名称
	 * @param Yz_jcname
	 */
	public void setYz_jcname(String Yz_jcname) {
		setAttrVal("Yz_jcname", Yz_jcname);
	}
	/**
	 * 医嘱费用
	 * @return String
	 */
	public String getJgbz() {
		return ((String) getAttrVal("Jgbz"));
	}	
	/**
	 * 医嘱费用
	 * @param Jgbz
	 */
	public void setJgbz(String Jgbz) {
		setAttrVal("Jgbz", Jgbz);
	}
	/**
	 * 医嘱开始时间
	 * @return FDateTime
	 */
	public FDateTime getYz_start_time() {
		return ((FDateTime) getAttrVal("Yz_start_time"));
	}	
	/**
	 * 医嘱开始时间
	 * @param Yz_start_time
	 */
	public void setYz_start_time(FDateTime Yz_start_time) {
		setAttrVal("Yz_start_time", Yz_start_time);
	}
	/**
	 * 医嘱停止时间
	 * @return FDateTime
	 */
	public FDateTime getYz_stop_time() {
		return ((FDateTime) getAttrVal("Yz_stop_time"));
	}	
	/**
	 * 医嘱停止时间
	 * @param Yz_stop_time
	 */
	public void setYz_stop_time(FDateTime Yz_stop_time) {
		setAttrVal("Yz_stop_time", Yz_stop_time);
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
	 * 检查方法变编码
	 * @return String
	 */
	public String getYz_jcffcode() {
		return ((String) getAttrVal("Yz_jcffcode"));
	}	
	/**
	 * 检查方法变编码
	 * @param Yz_jcffcode
	 */
	public void setYz_jcffcode(String Yz_jcffcode) {
		setAttrVal("Yz_jcffcode", Yz_jcffcode);
	}
	/**
	 * 检查方法名
	 * @return String
	 */
	public String getYz_jcffname() {
		return ((String) getAttrVal("Yz_jcffname"));
	}	
	/**
	 * 检查方法名
	 * @param Yz_jcffname
	 */
	public void setYz_jcffname(String Yz_jcffname) {
		setAttrVal("Yz_jcffname", Yz_jcffname);
	}
	/**
	 * 检查部位编码
	 * @return String
	 */
	public String getYz_jcbwcode() {
		return ((String) getAttrVal("Yz_jcbwcode"));
	}	
	/**
	 * 检查部位编码
	 * @param Yz_jcbwcode
	 */
	public void setYz_jcbwcode(String Yz_jcbwcode) {
		setAttrVal("Yz_jcbwcode", Yz_jcbwcode);
	}
	/**
	 * 检查部位名称
	 * @return String
	 */
	public String getYz_jcbwname() {
		return ((String) getAttrVal("Yz_jcbwname"));
	}	
	/**
	 * 检查部位名称
	 * @param Yz_jcbwname
	 */
	public void setYz_jcbwname(String Yz_jcbwname) {
		setAttrVal("Yz_jcbwname", Yz_jcbwname);
	}
	/**
	 * 是否皮试
	 * @return String
	 */
	public String getIs_ps() {
		return ((String) getAttrVal("Is_ps"));
	}	
	/**
	 * 是否皮试
	 * @param Is_ps
	 */
	public void setIs_ps(String Is_ps) {
		setAttrVal("Is_ps", Is_ps);
	}
	/**
	 * 是否皮试结果
	 * @return String
	 */
	public String getIs_psresult() {
		return ((String) getAttrVal("Is_psresult"));
	}	
	/**
	 * 是否皮试结果
	 * @param Is_psresult
	 */
	public void setIs_psresult(String Is_psresult) {
		setAttrVal("Is_psresult", Is_psresult);
	}
	/**
	 * 是否加急
	 * @return String
	 */
	public String getIs_jj() {
		return ((String) getAttrVal("Is_jj"));
	}	
	/**
	 * 是否加急
	 * @param Is_jj
	 */
	public void setIs_jj(String Is_jj) {
		setAttrVal("Is_jj", Is_jj);
	}
	/**
	 * 是否加急结果
	 * @return String
	 */
	public String getIs_jjresult() {
		return ((String) getAttrVal("Is_jjresult"));
	}	
	/**
	 * 是否加急结果
	 * @param Is_jjresult
	 */
	public void setIs_jjresult(String Is_jjresult) {
		setAttrVal("Is_jjresult", Is_jjresult);
	}
	/**
	 * 是否药观
	 * @return String
	 */
	public String getIs_yg() {
		return ((String) getAttrVal("Is_yg"));
	}	
	/**
	 * 是否药观
	 * @param Is_yg
	 */
	public void setIs_yg(String Is_yg) {
		setAttrVal("Is_yg", Is_yg);
	}
	/**
	 * 是否药观结果
	 * @return String
	 */
	public String getIs_ygresult() {
		return ((String) getAttrVal("Is_ygresult"));
	}	
	/**
	 * 是否药观结果
	 * @param Is_ygresult
	 */
	public void setIs_ygresult(String Is_ygresult) {
		setAttrVal("Is_ygresult", Is_ygresult);
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
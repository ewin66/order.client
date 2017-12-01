package iih.ci.mrqc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class Cidiagdto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键标识
	 * @return String
	 */
	public String getId_cididt() {
		return ((String) getAttrVal("Id_cididt"));
	}
	/**
	 * 主键标识
	 * @param Id_cididt
	 */
	public void setId_cididt(String Id_cididt) {
		setAttrVal("Id_cididt", Id_cididt);
	}
	/**
	 * 诊断类型
	 * @return String
	 */
	public String getId_disys() {
		return ((String) getAttrVal("Id_disys"));
	}
	/**
	 * 诊断类型
	 * @param Id_disys
	 */
	public void setId_disys(String Id_disys) {
		setAttrVal("Id_disys", Id_disys);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 诊断名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 诊断编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 诊断描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 诊断描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 诊断日期
	 * @return String
	 */
	public String getDt_di() {
		return ((String) getAttrVal("Dt_di"));
	}
	/**
	 * 诊断日期
	 * @param Dt_di
	 */
	public void setDt_di(String Dt_di) {
		setAttrVal("Dt_di", Dt_di);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 诊断过程
	 * @return String
	 */
	public String getId_ditp() {
		return ((String) getAttrVal("Id_ditp"));
	}
	/**
	 * 诊断过程
	 * @param Id_ditp
	 */
	public void setId_ditp(String Id_ditp) {
		setAttrVal("Id_ditp", Id_ditp);
	}
}
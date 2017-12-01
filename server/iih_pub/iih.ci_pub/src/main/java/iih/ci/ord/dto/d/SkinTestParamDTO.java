package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 皮试逻辑入口参数DTO DTO数据 
 * 
 */
public class SkinTestParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pi() {
		return ((String) getAttrVal("Id_pi"));
	}
	/**
	 * 患者
	 * @param Id_pi
	 */
	public void setId_pi(String Id_pi) {
		setAttrVal("Id_pi", Id_pi);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 用药服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 用药服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 用药
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 用药
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 皮试服务
	 * @return String
	 */
	public String getId_skinsrv() {
		return ((String) getAttrVal("Id_skinsrv"));
	}
	/**
	 * 皮试服务
	 * @param Id_skinsrv
	 */
	public void setId_skinsrv(String Id_skinsrv) {
		setAttrVal("Id_skinsrv", Id_skinsrv);
	}
	/**
	 * 皮试药品
	 * @return String
	 */
	public String getId_skinmm() {
		return ((String) getAttrVal("Id_skinmm"));
	}
	/**
	 * 皮试药品
	 * @param Id_skinmm
	 */
	public void setId_skinmm(String Id_skinmm) {
		setAttrVal("Id_skinmm", Id_skinmm);
	}
}
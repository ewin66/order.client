package iih.ci.mr.diainfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊断信息DTO DTO数据 
 * 
 */
public class DiaInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断类别编码
	 * @return String
	 */
	public String getCode_dia_tp() {
		return ((String) getAttrVal("Code_dia_tp"));
	}
	/**
	 * 诊断类别编码
	 * @param Code_dia_tp
	 */
	public void setCode_dia_tp(String Code_dia_tp) {
		setAttrVal("Code_dia_tp", Code_dia_tp);
	}
	/**
	 * 诊断类别名称
	 * @return String
	 */
	public String getDia_tp() {
		return ((String) getAttrVal("Dia_tp"));
	}
	/**
	 * 诊断类别名称
	 * @param Dia_tp
	 */
	public void setDia_tp(String Dia_tp) {
		setAttrVal("Dia_tp", Dia_tp);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_dia() {
		return ((String) getAttrVal("Code_dia"));
	}
	/**
	 * 诊断编码
	 * @param Code_dia
	 */
	public void setCode_dia(String Code_dia) {
		setAttrVal("Code_dia", Code_dia);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDia() {
		return ((String) getAttrVal("Dia"));
	}
	/**
	 * 诊断名称
	 * @param Dia
	 */
	public void setDia(String Dia) {
		setAttrVal("Dia", Dia);
	}
	/**
	 * 诊断日期
	 * @return FDate
	 */
	public FDate getDt_dia() {
		return ((FDate) getAttrVal("Dt_dia"));
	}
	/**
	 * 诊断日期
	 * @param Dt_dia
	 */
	public void setDt_dia(FDate Dt_dia) {
		setAttrVal("Dt_dia", Dt_dia);
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
	 * 治疗结果编码
	 * @return String
	 */
	public String getCode_trre() {
		return ((String) getAttrVal("Code_trre"));
	}
	/**
	 * 治疗结果编码
	 * @param Code_trre
	 */
	public void setCode_trre(String Code_trre) {
		setAttrVal("Code_trre", Code_trre);
	}
	/**
	 * 治疗结果名称
	 * @return String
	 */
	public String getTrre() {
		return ((String) getAttrVal("Trre"));
	}
	/**
	 * 治疗结果名称
	 * @param Trre
	 */
	public void setTrre(String Trre) {
		setAttrVal("Trre", Trre);
	}
}
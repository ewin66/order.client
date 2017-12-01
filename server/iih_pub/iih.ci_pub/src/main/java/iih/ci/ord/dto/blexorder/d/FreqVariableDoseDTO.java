package iih.ci.ord.dto.blexorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 服务拆分频次变动剂量信息 DTO数据 
 * 
 */
public class FreqVariableDoseDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务项目剂量主键
	 * @return String
	 */
	public String getId_orsrvdose() {
		return ((String) getAttrVal("Id_orsrvdose"));
	}	
	/**
	 * 服务项目剂量主键
	 * @param Id_orsrvdose
	 */
	public void setId_orsrvdose(String Id_orsrvdose) {
		setAttrVal("Id_orsrvdose", Id_orsrvdose);
	}
	/**
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 频次执行时刻主键
	 * @return String
	 */
	public String getId_freqtime() {
		return ((String) getAttrVal("Id_freqtime"));
	}	
	/**
	 * 频次执行时刻主键
	 * @param Id_freqtime
	 */
	public void setId_freqtime(String Id_freqtime) {
		setAttrVal("Id_freqtime", Id_freqtime);
	}
	/**
	 * 频次时刻
	 * @return String
	 */
	public String getDt_freq() {
		return ((String) getAttrVal("Dt_freq"));
	}	
	/**
	 * 频次时刻
	 * @param Dt_freq
	 */
	public void setDt_freq(String Dt_freq) {
		setAttrVal("Dt_freq", Dt_freq);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getQuan_dose() {
		return ((FDouble) getAttrVal("Quan_dose"));
	}	
	/**
	 * 剂量
	 * @param Quan_dose
	 */
	public void setQuan_dose(FDouble Quan_dose) {
		setAttrVal("Quan_dose", Quan_dose);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getId_unit_dose() {
		return ((String) getAttrVal("Id_unit_dose"));
	}	
	/**
	 * 剂量单位
	 * @param Id_unit_dose
	 */
	public void setId_unit_dose(String Id_unit_dose) {
		setAttrVal("Id_unit_dose", Id_unit_dose);
	}
}
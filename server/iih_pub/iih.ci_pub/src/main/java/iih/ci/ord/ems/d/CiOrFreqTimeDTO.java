package iih.ci.ord.ems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱计划频次执行时刻DTO DTO数据 
 * 
 */
public class CiOrFreqTimeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱执行时刻主键标识
	 * @return String
	 */
	public String getId_orfreqtime() {
		return ((String) getAttrVal("Id_orfreqtime"));
	}	
	/**
	 * 医嘱执行时刻主键标识
	 * @param Id_orfreqtime
	 */
	public void setId_orfreqtime(String Id_orfreqtime) {
		setAttrVal("Id_orfreqtime", Id_orfreqtime);
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
	 * 计划日期
	 * @return FDate
	 */
	public FDate getWdno() {
		return ((FDate) getAttrVal("Wdno"));
	}	
	/**
	 * 计划日期
	 * @param Wdno
	 */
	public void setWdno(FDate Wdno) {
		setAttrVal("Wdno", Wdno);
	}
	/**
	 * 执行时刻
	 * @return FTime
	 */
	public FTime getTime_mp() {
		return ((FTime) getAttrVal("Time_mp"));
	}	
	/**
	 * 执行时刻
	 * @param Time_mp
	 */
	public void setTime_mp(FTime Time_mp) {
		setAttrVal("Time_mp", Time_mp);
	}
	/**
	 * 执行时刻描述
	 * @return String
	 */
	public String getDes_mp() {
		return ((String) getAttrVal("Des_mp"));
	}	
	/**
	 * 执行时刻描述
	 * @param Des_mp
	 */
	public void setDes_mp(String Des_mp) {
		setAttrVal("Des_mp", Des_mp);
	}
}
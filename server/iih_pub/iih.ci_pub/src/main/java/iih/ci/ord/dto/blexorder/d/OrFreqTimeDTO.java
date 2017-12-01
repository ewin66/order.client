package iih.ci.ord.dto.blexorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱拆分频次执行时刻数据 DTO数据 
 * 
 */
public class OrFreqTimeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱执行时刻ID
	 * @return String
	 */
	public String getId_orfreq() {
		return ((String) getAttrVal("Id_orfreq"));
	}	
	/**
	 * 医嘱执行时刻ID
	 * @param Id_orfreq
	 */
	public void setId_orfreq(String Id_orfreq) {
		setAttrVal("Id_orfreq", Id_orfreq);
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
	 * 对应星期或日
	 * @return Integer
	 */
	public Integer getWdno() {
		return ((Integer) getAttrVal("Wdno"));
	}	
	/**
	 * 对应星期或日
	 * @param Wdno
	 */
	public void setWdno(Integer Wdno) {
		setAttrVal("Wdno", Wdno);
	}
	/**
	 * 执行时刻
	 * @return FDateTime
	 */
	public FDateTime getTime_mp() {
		return ((FDateTime) getAttrVal("Time_mp"));
	}	
	/**
	 * 执行时刻
	 * @param Time_mp
	 */
	public void setTime_mp(FDateTime Time_mp) {
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
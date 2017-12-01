package iih.ci.mr.nu.script.compileservice.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 编译服务 DTO数据 
 * 
 */
public class CompileServiceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编译服务主键
	 * @return String
	 */
	public String getId_comps() {
		return ((String) getAttrVal("Id_comps"));
	}
	/**
	 * 编译服务主键
	 * @param Id_comps
	 */
	public void setId_comps(String Id_comps) {
		setAttrVal("Id_comps", Id_comps);
	}
	/**
	 * IP
	 * @return String
	 */
	public String getIp() {
		return ((String) getAttrVal("Ip"));
	}
	/**
	 * IP
	 * @param Ip
	 */
	public void setIp(String Ip) {
		setAttrVal("Ip", Ip);
	}
	/**
	 * 端口
	 * @return String
	 */
	public String getPort() {
		return ((String) getAttrVal("Port"));
	}
	/**
	 * 端口
	 * @param Port
	 */
	public void setPort(String Port) {
		setAttrVal("Port", Port);
	}
	/**
	 * 使用次数
	 * @return Integer
	 */
	public Integer getCount_usage() {
		return ((Integer) getAttrVal("Count_usage"));
	}
	/**
	 * 使用次数
	 * @param Count_usage
	 */
	public void setCount_usage(Integer Count_usage) {
		setAttrVal("Count_usage", Count_usage);
	}
	/**
	 * 成功次数
	 * @return Integer
	 */
	public Integer getCount_succ() {
		return ((Integer) getAttrVal("Count_succ"));
	}
	/**
	 * 成功次数
	 * @param Count_succ
	 */
	public void setCount_succ(Integer Count_succ) {
		setAttrVal("Count_succ", Count_succ);
	}
	/**
	 * 连续失败次数
	 * @return Integer
	 */
	public Integer getCount_consecutivefailures() {
		return ((Integer) getAttrVal("Count_consecutivefailures"));
	}
	/**
	 * 连续失败次数
	 * @param Count_consecutivefailures
	 */
	public void setCount_consecutivefailures(Integer Count_consecutivefailures) {
		setAttrVal("Count_consecutivefailures", Count_consecutivefailures);
	}
	/**
	 * 评分
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}
	/**
	 * 评分
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}
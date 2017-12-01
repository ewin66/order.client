package iih.ci.ord.dto.orsrvsplitorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * Mp执行回写医嘱项目状态 DTO数据 
 * 
 */
public class WriteBackOrSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱项目
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
	 * 最后执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_last_mp() {
		return ((FDateTime) getAttrVal("Dt_last_mp"));
	}
	/**
	 * 最后执行时间
	 * @param Dt_last_mp
	 */
	public void setDt_last_mp(FDateTime Dt_last_mp) {
		setAttrVal("Dt_last_mp", Dt_last_mp);
	}
	/**
	 * 可取消标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cancelable() {
		return ((FBoolean) getAttrVal("Fg_cancelable"));
	}
	/**
	 * 可取消标识
	 * @param Fg_cancelable
	 */
	public void setFg_cancelable(FBoolean Fg_cancelable) {
		setAttrVal("Fg_cancelable", Fg_cancelable);
	}
	/**
	 * 可退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}
	/**
	 * 可退费标识
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 执行类别
	 * @return Integer
	 */
	public Integer getMp_tp() {
		return ((Integer) getAttrVal("Mp_tp"));
	}
	/**
	 * 执行类别
	 * @param Mp_tp
	 */
	public void setMp_tp(Integer Mp_tp) {
		setAttrVal("Mp_tp", Mp_tp);
	}
}
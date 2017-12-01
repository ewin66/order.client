package iih.ci.ord.s.bp.ems;

import java.util.Hashtable;

import xap.mw.coreitf.d.FBoolean;
import iih.ci.ord.ciorder.d.CiorderAggDO;

/*
 * 临床医嘱聚集DO及关联数据信息
 */
public class CiOrAggAndRelDatum {
	private CiorderAggDO oraggdo;
	private Hashtable orattachht;
	private String fg_cp;//是否 临床路径患者  1 在径 ，0 不在径
	public CiorderAggDO getOraggdo() {
		return oraggdo;
	}
	public void setOraggdo(CiorderAggDO oraggdo) {
		this.oraggdo = oraggdo;
	}
	public Hashtable getOrattachht() {
		return orattachht;
	}
	public void setOrattachht(Hashtable orattachht) {
		this.orattachht = orattachht;
	}
	/**
	 * @return the fg_cp
	 */
	public String getFg_cp() {
		return fg_cp;
	}
	/**
	 * @param fg_cp the fg_cp to set
	 */
	public void setFg_cp(String fg_cp) {
		this.fg_cp = fg_cp;
	}
	
	
}

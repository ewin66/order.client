package iih.ci.ord.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FMap;
import iih.ci.ord.ciorder.d.CiorderAggDO;

/*
 * 临床医嘱聚集DO及关联药品数据信息
 */
public class CiOrAggAndRelInfo extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CiorderAggDO getOrAggDO() {
		return ((CiorderAggDO) getAttrVal("OrAggDO"));
	}
	public void setOrAggDO(CiorderAggDO oraggdo) {
		
		setAttrVal("OrAggDO", oraggdo);
	}
	public FMap getOrSrvMmMap() {
		return ((FMap) getAttrVal("OrSrvMmMap"));
	}
	public void setOrSrvMmMap(FMap orsrvmmmap) {
		setAttrVal("OrSrvMmMap", orsrvmmmap);
	}
	
	public FMap getBlSrvMap() {
		return ((FMap) getAttrVal("BlSrvMap"));
	}
	public void setBlSrvMap(FMap blsrvmap) {
		setAttrVal("BlSrvMap", blsrvmap);
	}
	
}

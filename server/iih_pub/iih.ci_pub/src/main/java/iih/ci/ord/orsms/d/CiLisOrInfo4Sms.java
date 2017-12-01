package iih.ci.ord.orsms.d;

import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciorder.d.CiOrderDO;

/**
 * 临床检验医嘱数据信息
 * 检验医嘱打印合单时使用内部仅包含
 * CiOrderDO和OrdApLabDO数据
 */
public class CiLisOrInfo4Sms {
	private CiOrderDO ordo;
	private OrdApLabDO orlisapdo;
	public CiOrderDO getOrdo() {
		return ordo;
	}
	public void setOrdo(CiOrderDO ordo) {
		this.ordo = ordo;
	}
	public OrdApLabDO getOrlisapdo() {
		return orlisapdo;
	}
	public void setOrlisapdo(OrdApLabDO orlisapdo) {
		this.orlisapdo = orlisapdo;
	}
	
	

}

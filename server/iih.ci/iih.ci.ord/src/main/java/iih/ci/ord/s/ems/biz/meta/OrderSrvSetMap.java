package iih.ci.ord.s.ems.biz.meta;

import java.util.HashMap;

import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;

/**
 * 数据库套内项目映射表
 * @author wangqingzhu
 *
 */
public class OrderSrvSetMap extends HashMap<String,OrdSrvSetDO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5782220141870494965L;

	public OrderSrvSetMap(OrdSrvSetDO[] szInfo){
		for (OrdSrvSetDO o : szInfo){
			this.put(o.getId_srvset(), o);
		}
	}
	
	public OrderSrvSetMap(OrderSrvSetList lsInfo){
		for (OrdSrvSetDO o : lsInfo){
			this.put(o.getId_srvset(), o);
		}
	}
}

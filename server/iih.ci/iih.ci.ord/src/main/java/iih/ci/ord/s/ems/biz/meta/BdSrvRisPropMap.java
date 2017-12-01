package iih.ci.ord.s.ems.biz.meta;

import java.util.HashMap;

import iih.bd.srv.medsrv.d.MedSrvRisDO;

/**
 * 检查属性映射表
 * @author wangqingzhu
 *
 */
public class BdSrvRisPropMap extends HashMap<String,MedSrvRisDO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1769776682981397958L;

	public BdSrvRisPropMap(MedSrvRisDO[] szInfo){
		for (MedSrvRisDO o : szInfo){
			this.put(o.getId_srv(), o);
		}
	}
	public BdSrvRisPropMap(BdSrvRisPropList szInfo){
		for (MedSrvRisDO o : szInfo){
			this.put(o.getId_srv(), o);
		}
	}
	
	public String[] asKeyArray(){
		return this.keySet().toArray(new String[this.size()]);
	}
	
}

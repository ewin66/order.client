package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;

import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.ci.ord.s.ems.define.StringList;

/**
 * 检查属性列表
 * @author wangqingzhu
 *
 */
public class BdSrvRisPropList extends ArrayList<MedSrvRisDO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -395861233899085001L;

	public BdSrvRisPropList(){}
	
	public BdSrvRisPropList(MedSrvRisDO[] szInfo){
		for (MedSrvRisDO o : szInfo){
			this.add(o);
		}
	}
	
	public MedSrvRisDO[] asArray(){
		return toArray(new MedSrvRisDO[this.size()]);
	}
	
	public String[] asKeyArray(String attr){
		StringList keys = new StringList();
		for (MedSrvRisDO o : this){
			keys.add(o.getAttrVal(attr).toString());
		}
		return keys.asArray();
	}
	
	public String[] asSrvIdArray(){
		
		return asKeyArray(MedSrvRisDO.ID_SRV);
	}
	
	public BdSrvRisPropMap asMap(){
		return new BdSrvRisPropMap(this);
	}
}

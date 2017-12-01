package iih.ci.ord.s.ems.biz.meta;

import java.util.HashMap;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;

/**
 * 基础服务套内项目映射表
 * @author wangqingzhu
 *
 */
public class BdSrvSetItemMap extends HashMap<String,MedSrvSetItemDO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5137938456259017300L;
	
	public BdSrvSetItemMap(){}
	
	
	public BdSrvSetItemMap(MedSrvSetItemDO[] szMedSrvSetItemDO){
		for (MedSrvSetItemDO info : szMedSrvSetItemDO){
			this.put(info.getId_srv_itm(), info);
		}
	}
	
	public String[] asKeyString(){
		return this.keySet().toArray(new String[size()]);
	}

}

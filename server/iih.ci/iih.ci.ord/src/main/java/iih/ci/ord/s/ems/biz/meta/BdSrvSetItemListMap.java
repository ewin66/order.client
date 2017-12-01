package iih.ci.ord.s.ems.biz.meta;

import java.util.HashMap;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;

/**
 * 服务套与套内项目的映射关系
 * @author wangqingzhu
 *
 */
public class BdSrvSetItemListMap extends HashMap<String, BdSrvSetItemList> {

	private static final long serialVersionUID = 1245228083597855264L;
	
	public BdSrvSetItemListMap(){}
	/**
	 * 分组构造
	 * @param szInfo
	 */
	public BdSrvSetItemListMap(MedSrvSetItemDO[] szInfo){
		for (MedSrvSetItemDO info : szInfo){
			if (!this.containsKey(info.getId_srv())){
				this.put(info.getId_srv(), new BdSrvSetItemList());
			}
			this.get(info.getId_srv()).add(info);
		}
	}

	public String[] asKeyArray(){
		return this.keySet().toArray(new String[size()]);
	}
}

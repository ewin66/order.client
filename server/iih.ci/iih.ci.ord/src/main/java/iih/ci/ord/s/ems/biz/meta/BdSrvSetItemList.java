package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;
import java.util.Arrays;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;

/**
 * 套内项目列表集合
 * @author wangqingzhu
 *
 */
public class BdSrvSetItemList extends ArrayList<MedSrvSetItemDO>{

	private static final long serialVersionUID = -8702781607166367886L;

	public BdSrvSetItemList(){}
	
	public BdSrvSetItemList(MedSrvSetItemDO[] szInfo){
		this.addAll(Arrays.asList(szInfo));
	}
	
	/**
	 * 提取套内项目数组集合
	 * @return
	 */
	public MedSrvSetItemDO[] asArray(){
		return this.toArray(new MedSrvSetItemDO[size()]);
	}
	
	/**
	 * 提取套内项目服务id集合
	 * @return
	 */
	public String[] asIdSrvArray(){
		String[] szId_srv = new String[size()];
		int index = 0;
		for (MedSrvSetItemDO info : this){
			szId_srv[index++] = info.getId_srv_itm();
		}
		
		return szId_srv;
	}
	
	public BdSrvSetItemMap asMap(){
		return new BdSrvSetItemMap(asArray());
	}
}

package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;

import iih.bd.srv.medsrv.d.MedSrvDO;

/**
 * 基础服务列表
 * @author wangqingzhu
 *
 */
public class BdSrvInfoList extends ArrayList<MedSrvDO>{

	private static final long serialVersionUID = 1L;
	
	
	public BdSrvInfoList(){}
	
	
	public BdSrvInfoList(MedSrvDO[] szSrvInfo){
		this.addAll(Arrays.asList(szSrvInfo));
	}

	/**
	 * 转化为数组集合
	 * @return
	 */
	public MedSrvDO[] asArray(){
		return this.toArray(new MedSrvDO[size()]);
	}
	/**
	 * 转化为
	 * @return
	 */
	public BdSrvInfoMap asMap(){
		LinkedMap mm = new LinkedMap();
		
		BdSrvInfoMap m = new BdSrvInfoMap();
		for(MedSrvDO srvInfo : this){
			m.put(srvInfo.getId_srv(), srvInfo);
		}
		return m;
	}

	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return super.clone();
	}

}

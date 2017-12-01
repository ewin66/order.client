package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.define.StringList;

/**
 * 服务物品对象集合
 * @author wangqingzhu
 *
 */
public class BdSrvMmInfoList extends ArrayList<BdSrvMmInfo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BdSrvMmInfoList(){}
	
	
	/**
	 * 转化为数组
	 * @return
	 */
	public BdSrvMmInfo[] asArray(){
		return this.toArray(new BdSrvMmInfo[size()]);
	}
	
	/**
	 * 提取基础服务对象数组
	 * @return
	 */
	public MedSrvDO[] asBdSrvInfoArray(){
		BdSrvInfoList ls = new BdSrvInfoList();
		for (BdSrvMmInfo info : this){
			ls.add(info.getBdSrvInfo());
		}
		return ls.asArray();
	}
	
	public BdSrvInfoList asBdSrvInfoList(){
		BdSrvInfoList ls = new BdSrvInfoList();
		for (BdSrvMmInfo info : this){
			ls.add(info.getBdSrvInfo());
		}
		return ls;
	}
	
	/**
	 * 提取服务ID数组
	 * @return
	 */
	public String[] asIdSrvArray(){
		StringList ls = new StringList();
		for (BdSrvMmInfo info : this){
			ls.add(info.getBdSrvInfo().getId_srv());
		}
		return ls.asArray();
	}
	
	/**
	 * 提取物品ID数组
	 * @return
	 */
	public String[] asIdMmArray(){
		StringList ls = new StringList();
		for (BdSrvMmInfo info : this){
			if (info.getMmInfo() != null){
				ls.add(info.getMmInfo().getId_mm());
			}
		}
		return ls.asArray();
	}
	/**
	 * 转化为映射表
	 * @return
	 */
	public Map<String,BdSrvMmInfo> asMap(){
		Map<String,BdSrvMmInfo> m = new HashMap<String,BdSrvMmInfo>();
		for (BdSrvMmInfo info : this){
			m.put(info.getBdSrvInfo().getId_srv(), info);
		}
		return m;
	}
	
	public MedSrvDO getMainSrvInfo(){
		if (!CiOrdUtils.isEmpty(this)){
			return this.get(0).getBdSrvInfo();
		}
		return null;
	}
}

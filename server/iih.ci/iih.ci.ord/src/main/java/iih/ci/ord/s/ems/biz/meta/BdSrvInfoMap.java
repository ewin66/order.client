package iih.ci.ord.s.ems.biz.meta;

import java.util.HashMap;

import iih.bd.srv.medsrv.d.MedSrvDO;
/**
 * 基础数据映射表
 * @author wangqingzhu
 *
 */
public class BdSrvInfoMap extends HashMap<String, MedSrvDO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6063788030256372647L;
	
	
	public BdSrvInfoMap(){}
	
	public BdSrvInfoMap(MedSrvDO[] szInfo){
		for (MedSrvDO info : szInfo){
			this.put(info.getId_srv(), info);
		}
	}
	
	public String[] asKeyArray(){
		return this.keySet().toArray(new String[size()]);
	}

}

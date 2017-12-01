package iih.ci.ord.s.ems.biz.meta;

import java.util.HashMap;
/**
 * 服务套ID与医嘱服务项目集合和医嘱套内项目集合 关系结构
 * @author wangqingzhu
 *
 */
public class OrderSrvExtPackageMap extends HashMap<String,OrderSrvExtPackage>{

	
	private static final long serialVersionUID = 1L;
	
	
	public String[] asKeyArray(){
		return this.keySet().toArray(new String[size()]);
	}

	public OrderSrvExtPackageMap append(OrderSrvExtPackageMap osaspm){
		if (null == osaspm) return this;
		for (String key : osaspm.keySet()){
			this.put(key, osaspm.get(key));
		}
		return this;
	}
}

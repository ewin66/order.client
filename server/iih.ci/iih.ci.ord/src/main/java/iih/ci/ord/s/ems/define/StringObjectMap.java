package iih.ci.ord.s.ems.define;

import java.util.HashMap;

/**
 * 泛型字典定义
 * @author wangqingzhu
 *
 */
public class StringObjectMap extends HashMap<String,Object>{

	private static final long serialVersionUID = 1L;


	public String[] asKeyArray(){
		return this.keySet().toArray(new String[size()]);
	}
}

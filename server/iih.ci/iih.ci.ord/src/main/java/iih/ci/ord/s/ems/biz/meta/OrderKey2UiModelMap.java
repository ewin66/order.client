package iih.ci.ord.s.ems.biz.meta;

import java.util.HashMap;

/**
 * 医嘱ID对应的UI模型
 * @author wangqingzhu
 *
 */
public class OrderKey2UiModelMap extends HashMap<String, Object>{
	private static final long serialVersionUID = 1L;

	public String[] asKeyArray(){
		return this.keySet().toArray(new String[size()]);
	}
}

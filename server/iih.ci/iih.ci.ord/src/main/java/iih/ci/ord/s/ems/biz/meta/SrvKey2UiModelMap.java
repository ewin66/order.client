package iih.ci.ord.s.ems.biz.meta;

import iih.ci.ord.s.ems.define.StringObjectMap;

/**
 * 临床服务项目主键与UI模型映射表
 * @author wangqingzhu
 *
 */
public class SrvKey2UiModelMap extends StringObjectMap{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String[] asKeyArray(){
		return this.keySet().toArray(new String[size()]);
	}
}

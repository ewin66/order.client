package iih.ci.ord.s.bp.orsms.lis.cfg;

import java.util.List;


public class RuntimeConfigure {
	private String id;
	private String name;
	private String desc;
	private String isdefault;
	private List<GroupRuleConfigure> rules;
	private List<NoticeConfigure> notices;
	private String indexformat;
	private String indexsuffix;
	private String wrap;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public boolean isDefault(){
		return this.isdefault.toLowerCase().equals("1")|this.isdefault.toLowerCase().equals("true");
	}
	
	public String getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	
	public List<GroupRuleConfigure> getRules() {
		return rules;
	}
	public void setRules(List<GroupRuleConfigure> rules) {
		this.rules = rules;
	}
	public List<NoticeConfigure> getNotices() {
		return notices;
	}
	public void setNotices(List<NoticeConfigure> notices) {
		this.notices = notices;
	}
	public String getIndexformat() {
		return indexformat;
	}
	public void setIndexformat(String indexformat) {
		this.indexformat = indexformat;
	}
	public String getIndexsuffix() {
		return indexsuffix;
	}
	public void setIndexsuffix(String indexsuffix) {
		this.indexsuffix = indexsuffix;
	}
	public String getWrap() {
		return wrap;
	}
	public void setWrap(String wrap) {
		this.wrap = wrap;
	}
	
	
	
}

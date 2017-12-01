package iih.ci.ord.s.bp.orsms.lis.cfg;

import java.util.List;

public class Configure {
	private String version;
	private String desc;
	private List<RuntimeConfigure> mergerules ;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String description) {
		this.desc = description;
	}

	public List<RuntimeConfigure> getMergerules() {
		return mergerules;
	}
	public void setMergerules(List<RuntimeConfigure> mergerules) {
		this.mergerules = mergerules;
	}
	
	
}

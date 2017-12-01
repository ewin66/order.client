package iih.ci.ord.s.ems.biz.meta;

public class OrderPriCalParam {
	
	private String id_srv;
	private String name_srv;
	private String id_price;
	private int num;//部位加收个数
	private String id_primd;//定价模式
	
	public String getId_srv() {
		return id_srv;
	}
	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}
	public String getName_srv() {
		return name_srv;
	}
	public void setName_srv(String name_srv) {
		this.name_srv = name_srv;
	}
	public String getId_price() {
		return id_price;
	}
	public void setId_price(String id_price) {
		this.id_price = id_price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId_primd() {
		return id_primd;
	}
	public void setId_primd(String id_primd) {
		this.id_primd = id_primd;
	}

	
	
}

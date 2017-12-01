package iih.ci.ord.s.ems.biz.utils.orcontent.dto;

import xap.mw.coreitf.d.FDouble;

public class OrContentDTO {
	public OrContentDTO(String Name_srv,FDouble Quan_med,String Name_unit_med,boolean Fg_self) {
		this.Name_srv = Name_srv;
		this.Quan_med = Quan_med;
		this.Name_unit_med = Name_unit_med;
		this.Fg_self = Fg_self;
	}
	/**
	 * 服务名称
	 * @return
	 */
	private String Name_srv;
	/**
	 * 剂量
	 * @return
	 */
	private FDouble Quan_med;
	/**
	 * 计量单位
	 * @return
	 */
	private String Name_unit_med;

	/**
	 * 自备药标识
	 * @return
	 */
	private boolean Fg_self;
	public String getName_srv() {
		return Name_srv;
	}
	public void setName_srv(String name_srv) {
		Name_srv = name_srv;
	}
	public FDouble getQuan_med() {
		return Quan_med;
	}
	public void setQuan_med(FDouble quan_med) {
		Quan_med = quan_med;
	}
	public String getName_unit_med() {
		return Name_unit_med;
	}
	public void setName_unit_med(String name_unit_med) {
		Name_unit_med = name_unit_med;
	}
	public boolean isFg_self() {
		return Fg_self;
	}
	public void setFg_self(boolean fg_self) {
		Fg_self = fg_self;
	}
	
	
}

package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

import java.util.List;

public class OrderPresSplitList {
   
	// 名称
	public String name;
	// 编码
	public String code;
	//处方sd
	public String sd_pres;
	//处方编码
	public String id_pres;
	//处方类型
	public String id_prestp;
	// 是否使用规则
	public boolean isAppRule  = true;
	
	public List<OrderPresSplitDTO> orderList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSd_pres() {
		return sd_pres;
	}
	public void setSd_pres(String sd_pres) {
		this.sd_pres = sd_pres;
	}
	public String getId_pres() {
		return id_pres;
	}
	public void setId_pres(String id_pres) {
		this.id_pres = id_pres;
	}
	public List<OrderPresSplitDTO> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderPresSplitDTO> orderList) {
		this.orderList = orderList;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId_prestp() {
		return id_prestp;
	}
	public void setId_prestp(String id_prestp) {
		this.id_prestp = id_prestp;
	}
	public boolean isAppRule() {
		return isAppRule;
	}
	public void setAppRule(boolean isAppRule) {
		this.isAppRule = isAppRule;
	}
	
	
	
}

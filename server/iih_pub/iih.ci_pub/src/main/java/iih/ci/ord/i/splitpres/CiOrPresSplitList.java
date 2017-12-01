package iih.ci.ord.i.splitpres;

import java.util.List;
import java.util.Map;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医嘱分方数据信息列表
 */
public class CiOrPresSplitList {

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
	public boolean isAppRule = true;
	//金额
	public double ant_amount;
	//医保类型   Y 医保处方，N 非医保处方
	public FBoolean Fg_hp_pres;
	//处方标志 
	public String sd_prestpword;
	public String id_prestpword;

	// 缓存处方规则对应的配置信息
	public Map<String, Object> cfgProps;

	//个数
	public int num;
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

	public double getAnt_amount() {
		return ant_amount;
	}

	public void setAnt_amount(double ant_amount) {
		this.ant_amount = ant_amount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public FBoolean getFg_hp_pres() {
		return Fg_hp_pres;
	}

	public void setFg_hp_pres(FBoolean fg_hp_pres) {
		Fg_hp_pres = fg_hp_pres;
	}

	public String getSd_prestpword() {
		return sd_prestpword;
	}

	public void setSd_prestpword(String sd_prestpword) {
		this.sd_prestpword = sd_prestpword;
	}

	public String getId_prestpword() {
		return id_prestpword;
	}

	public void setId_prestpword(String id_prestpword) {
		this.id_prestpword = id_prestpword;
	}

	public Map<String, Object> getCfgProps() {
		return cfgProps;
	}

	public void setCfgProps(Map<String, Object> cfgProps) {
		this.cfgProps = cfgProps;
	}
}

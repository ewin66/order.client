package iih.ci.ord.ems.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 用法对应费用服务数据
 */
public class UsageRelFeeSrvDO {
	private String id_srv;
	private String id_unit;
	private FDouble quan_medu;
	private Integer reltype;
	private FBoolean isTotalQuanMd;//是总量模式  还是单次模式
	private String def1;
	public String getId_srv() {
		return id_srv;
	}
	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}
	public String getId_unit() {
		return id_unit;
	}
	public void setId_unit(String id_unit) {
		this.id_unit = id_unit;
	}
	public FDouble getQuan_medu() {
		return quan_medu;
	}
	public void setQuan_medu(FDouble quan_medu) {
		this.quan_medu = quan_medu;
	}
	public Integer getReltype() {
		return reltype;
	}
	public void setReltype(Integer reltype) {
		this.reltype = reltype;
	}
	public String getDef1() {
		return def1;
	}
	public void setDef1(String def1) {
		this.def1 = def1;
	}
	public FBoolean getIsTotalQuanMd() {
		return isTotalQuanMd;
	}
	public void setIsTotalQuanMd(FBoolean isTotalQuanMd) {
		this.isTotalQuanMd = isTotalQuanMd;
	}

}

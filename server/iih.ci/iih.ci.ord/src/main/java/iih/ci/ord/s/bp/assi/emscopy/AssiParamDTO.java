package iih.ci.ord.s.bp.assi.emscopy;

import java.util.List;
import java.util.Map;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;

public class AssiParamDTO {

	// 就诊上下文环境
	private CiEnContextDTO envinfo;

	// 全部的MedSrv集合
	private Map<String, MedSrvDO> medSrvMap = null;

	// 关联全部的物品集合
	private Map<String, MeterialDO> meterialMap = null;

	// 服务套id与套内项目集合Map结构（key服务套的id_srv ，value 套内项目集合）
	private Map<String, List<MedSrvSetItemDO>> srvSetItemsMap = null;

	// 检查属性
	private Map<String, MedSrvRisDO> srvRisMap = null;

	public CiEnContextDTO getEnvinfo() {
		return envinfo;
	}

	public void setEnvinfo(CiEnContextDTO envinfo) {
		this.envinfo = envinfo;
	}

	public Map<String, MedSrvDO> getMedSrvMap() {
		return medSrvMap;
	}

	public void setMedSrvMap(Map<String, MedSrvDO> medSrvMap) {
		this.medSrvMap = medSrvMap;
	}

	public Map<String, List<MedSrvSetItemDO>> getSrvSetItemsMap() {
		return srvSetItemsMap;
	}

	public void setSrvSetItemsMap(Map<String, List<MedSrvSetItemDO>> srvSetItemsMap) {
		this.srvSetItemsMap = srvSetItemsMap;
	}

	public Map<String, MedSrvRisDO> getSrvRisMap() {
		return srvRisMap;
	}

	public void setSrvRisMap(Map<String, MedSrvRisDO> srvRisMap) {
		this.srvRisMap = srvRisMap;
	}

	public Map<String, MeterialDO> getMeterialMap() {
		return meterialMap;
	}

	public void setMeterialMap(Map<String, MeterialDO> meterialMap) {
		this.meterialMap = meterialMap;
	}

}

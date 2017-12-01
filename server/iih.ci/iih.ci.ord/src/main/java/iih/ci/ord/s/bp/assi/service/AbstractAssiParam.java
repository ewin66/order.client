package iih.ci.ord.s.bp.assi.service;

import java.util.List;
import java.util.Map;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.cherbboilmd.i.ICHerbBoilDesDORService;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDORService;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.srv.medusage.i.IMedusagedesRService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.assi.emscopy.AssiParamDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import xap.mw.sf.core.util.ServiceFinder;

public class AbstractAssiParam {

	protected AssiParamDTO paramDTO;
	// 就诊上下文环境
	protected CiEnContextDTO envinfo;

	// 全部的MedSrv集合
	protected Map<String, MedSrvDO> medSrvMap = null;

	// 关联全部的物品集合
	protected Map<String, MeterialDO> meterialMap = null;

	// 服务套id与套内项目集合Map结构（key服务套的id_srv ，value 套内项目集合）
	protected Map<String, List<MedSrvSetItemDO>> srvSetItemsMap = null;

	// 检查属性
	protected Map<String, MedSrvRisDO> srvRisMap = null;

	// 医嘱服务查询
	protected ICiOrdQryService iciOrdQryService = null;
	// 获取物品的默认总量单位服务
	protected IMaterialBaseInfoService imaterialInfoService = null;

	// 频次
	protected IFreqdefMDORService ifreqdefMDORService;
	// 用法
	protected IMedusageRService imedusageRService;
	// 用法要求
	protected IMedusagedesRService imedusagedesRService;
	// 煎法
	protected ICherbboilmdMDORService icherbboilmdMDORService;
	// 煎法要求
	protected ICHerbBoilDesDORService icHerbBoilDesDORService;

	public void setAssiParam(AssiParamDTO paramDTO) {

		this.envinfo = paramDTO.getEnvinfo();
		this.medSrvMap = paramDTO.getMedSrvMap();
		this.meterialMap = paramDTO.getMeterialMap();
		this.srvSetItemsMap = paramDTO.getSrvSetItemsMap();
		this.srvRisMap = paramDTO.getSrvRisMap();
		this.paramDTO = paramDTO;

		ifreqdefMDORService = CiOrdAppUtils.getFreqdefMDORService();
		imedusageRService = (IMedusageRService) ServiceFinder.find(IMedusageRService.class);
		imedusagedesRService = (IMedusagedesRService) ServiceFinder.find(IMedusagedesRService.class);
		icherbboilmdMDORService = (ICherbboilmdMDORService) ServiceFinder.find(ICherbboilmdMDORService.class);
		icHerbBoilDesDORService = (ICHerbBoilDesDORService) ServiceFinder.find(ICHerbBoilDesDORService.class);
		imaterialInfoService = (IMaterialBaseInfoService) ServiceFinder.find(IMaterialBaseInfoService.class);
		iciOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
	}
}

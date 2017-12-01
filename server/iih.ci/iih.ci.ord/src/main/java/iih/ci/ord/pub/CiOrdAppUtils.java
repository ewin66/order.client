package iih.ci.ord.pub;


import iih.bd.fc.i.IBdFcQryService;
import iih.bd.fc.i.IOrpltpmtParaService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.meterial.i.IMeterialRService;
import iih.bd.mm.mmrelskinsrv.i.IMmrelskinsrvRService;
import iih.bd.pp.bdpriboil.i.IBdpriboilRService;
import iih.bd.pp.bdprisamp.i.IBdprisampRService;
import iih.bd.pp.hp.i.IBdHpCtrDORService;
import iih.bd.pp.hpdiexpenseself.i.IHpdiexpenseselfRService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.pp.i.IBdHpQryService;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.priusg.i.IPriusgRService;
import iih.bd.pp.service.i.IPpQueService;
import iih.bd.srv.deptsrvlimit.i.IDeptsrvlimitRService;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.ems.i.IEmsRelSrvDORService;
import iih.bd.srv.freqdef.i.IFreqTimeDORService;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.freqdef.i.IFreqdefRService;
import iih.bd.srv.i.IBdSrvMaintainService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedSrvRelMmDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.medsrv.i.IRelsrvtacticsRService;
import iih.bd.srv.ortpl.i.IOrTplNItmDORService;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.bd.srv.ortpl.i.IOrtmplRService;
import iih.bd.srv.ortpl.i.IRegularorcaRService;
import iih.bd.srv.ortpl.i.IRegularorrelsrvRService;
import iih.bd.srv.ortpl.i.ISrvortplitemCudService;
import iih.bd.srv.ortpl.i.ISrvortplitemRService;
import iih.bd.srv.routedosage.i.IRoutedosageRService;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.cg.service.IBlcgqueryService;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.hp.bdhpindicationdto.service.i.IHpQueService;
import iih.ci.ciet.cievent.i.ICieventCudService;
import iih.ci.ciet.cievent.i.ICieventRService;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mr.mrserviceext.i.IMrServiceExt;
import iih.ci.ord.app.i.ICiapplissheetMDOCudService;
import iih.ci.ord.app.i.ICiapppathgysheetMDOCudService;
import iih.ci.ord.app.i.ICiapprissheetCudService;
import iih.ci.ord.app.i.ICiapptreatexecMDOCudService;
import iih.ci.ord.cior.i.ICiorappbtCudService;
import iih.ci.ord.cior.i.ICiorappbtMDOCudService;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.cior.i.ICiorappbuCudService;
import iih.ci.ord.cior.i.ICiorappbuRService;
import iih.ci.ord.cior.i.ICiorappconsultCudService;
import iih.ci.ord.cior.i.ICiorappconsultRService;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.cior.i.ICiorappouthospCudService;
import iih.ci.ord.cior.i.ICiorappouthospRService;
import iih.ci.ord.cior.i.ICiorapppathgyCudService;
import iih.ci.ord.cior.i.ICiorapppathgyMDOCudService;
import iih.ci.ord.cior.i.ICiorapppathgyMDORService;
import iih.ci.ord.cior.i.ICiorapppathgyRService;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.cior.i.ICiorappsurgeryCudService;
import iih.ci.ord.cior.i.ICiorappsurgeryMDOCudService;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.cior.i.ICiorappsurgeryRService;
import iih.ci.ord.cior.i.ICiorapptransdeptCudService;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;
import iih.ci.ord.cior.i.ICiorreactlogCudService;
import iih.ci.ord.cior.i.ICiorreactlogRService;
import iih.ci.ord.cior.i.ICiorsessionCudService;
import iih.ci.ord.cior.i.ICiorsessionRService;
import iih.ci.ord.ciord.i.ICiorsrvagentCudService;
import iih.ci.ord.ciord.i.ICiorsrvagentRService;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.ICiorderSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.ciorsrvhp.i.ICiorsrvhpCudService;
import iih.ci.ord.ciorsrvhp.i.ICiorsrvhpRService;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.ciprn.i.ICiprintMDOCudService;
import iih.ci.ord.cirptlab.i.ICirptlabRService;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseCudService;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseRService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetCudService;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pres.i.IPresCudService;
import iih.ci.ord.pres.i.IPresRService;
import iih.ci.ord.skintest.i.ISkintestCudService;
import iih.ci.ord.skintest.i.ISkintestRService;
import iih.en.pv.entdi.i.IEntdiCudService;
import iih.en.pv.entdi.i.IEntdiRService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.i.IEntcontCudService;
import iih.en.pv.pativisit.i.IEntcontRService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.hp.cp.itf.i.IHpcpAppItfService;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialService;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mp.dg.i.IMpDgOutService;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.splitplan.i.IResponseOrderHandelService;
import iih.pi.overview.overview.i.IOverviewMDORService;
import iih.pi.overview.overview.i.IPiPatAlDOCudService;
import iih.pi.overview.overview.i.IPiPatAlDORService;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.devcfg.func.i.IPageRService;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.group.i.IGroupRService;
import xap.sys.permfw.user.i.IUserRService;
import xap.sys.xbd.measdoc.i.IMeasdocRService;
import xap.sys.xbd.udi.i.IUdidocRService;

public class CiOrdAppUtils {
	
	/**
	 * 获得系统环境变量
	 * MM
	 * @return
	 */
	public static Context getEnvContext(){
		return Context.get();
	}
	
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	public static FDateTime getServerDateTime(){
		TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
		return  ts.getUFDateTime();
	}
	/**
	 * 获得医嘱项目服务
	 * @return
	 */
	public static IOrdSrvDORService getOrSrvQryService(){
		return (IOrdSrvDORService)ServiceFinder.find(IOrdSrvDORService.class);
	}
	/**
	 * 获得医嘱服务
	 * @return
	 */
	public static ICiorderMDORService getOrQryService(){
		return (ICiorderMDORService)ServiceFinder.find(ICiorderMDORService.class);
	}
	
	/**
	 * 获得转科申请查询服务
	 * @return
	 */
	public static ICiorapptransdeptRService getCiorapptransdeptQryService(){
		return (ICiorapptransdeptRService)ServiceFinder.find(ICiorapptransdeptRService.class);
	}
	
	/**
	 * 获得医嘱维护服务
	 * @return
	 */
	public static ICiorderMDOCudService getOrService(){
		return (ICiorderMDOCudService)ServiceFinder.find(ICiorderMDOCudService.class);
	}
	
	/**
	 * 获得医嘱聚集维护服务
	 * @return
	 */
	public static ICiorderCudService getOrAggService(){
		return (ICiorderCudService)ServiceFinder.find(ICiorderCudService.class);
	}
	
	/**
	 * 获得医嘱聚集服务
	 * @return
	 */
	public static ICiorderRService getOrAggQryService(){
		return (ICiorderRService)ServiceFinder.find(ICiorderRService.class);
	}
	

	/**
	 * 获得医嘱项目物品服务
	 * @return
	 */
	public static IOrdsrvmmRService getOrSrvMmQryService(){
		return (IOrdsrvmmRService)ServiceFinder.find(IOrdsrvmmRService.class);
	}
	
	/**
	 * 获得编码字段生成管理器
	 * @return
	 */
	public static IBillcodeManage getIBillcodeManager(){
		return (IBillcodeManage)ServiceFinder.find(IBillcodeManage.class);
	}
	
	/**
	 * 获得用户服务
	 * @return
	 */
	public static IUserRService getUserQryService(){
		return (IUserRService)ServiceFinder.find(IUserRService.class);
	}
	
	/**
	 * 获得部门服务
	 * @return
	 */
	public static IDeptRService getDeptQryService(){
		return (IDeptRService)ServiceFinder.find(IDeptRService.class);
	}
	
	/**
	 * 获得人员服务
	 * @return
	 */
	public static IPsndocMDORService getPsnDocQryService(){
		return (IPsndocMDORService)ServiceFinder.find(IPsndocMDORService.class);
	}
	
	/**
	 * 获得医嘱项目物品服务
	 * @return
	 */
	public static IMeterialMDORService getMaterialQryService(){
		return (IMeterialMDORService)ServiceFinder.find(IMeterialMDORService.class);
	}
	
	/**
	 * 获得医嘱项目物品服务
	 * @return
	 */
	public static IMaterialService getMaterialService(){
		return (IMaterialService)ServiceFinder.find(IMaterialService.class);
	}
	
	/**
	 * 获得物品结存及价格相关信息服务
	 * @return
	 */
	public static IMaterialStockService getMaterialStockQryService(){
		return (IMaterialStockService)ServiceFinder.find(IMaterialStockService.class);
	}
	
	
	/**
	 * 获得物品基本信息服务 DTO
	 * @return
	 */
	public static IMaterialBaseInfoService getMaterialBaseInfoyService(){
		return (IMaterialBaseInfoService)ServiceFinder.find(IMaterialBaseInfoService.class);
	}
     
	/**
	 * 获得物品基本信息服务  AggDO
	 * @return
	 */
	public static IMeterialRService getIMeterialRService(){
		return (IMeterialRService)ServiceFinder.find(IMeterialRService.class);
	}
	
	
	/**
	 * 获得医嘱项目物品服务
	 * @return
	 */
	public static IMmrelskinsrvRService getMmRelSkinQryService(){
		return (IMmrelskinsrvRService)ServiceFinder.find(IMmrelskinsrvRService.class);
	}
	
	/**
	 * 获得皮试结果服务
	 */
	public static ISkintestRService getCiskintestrstQryService(){
		return (ISkintestRService)ServiceFinder.find(ISkintestRService.class);
	}
	
	/**
	 * 获得皮试结果维护服务
	 */
	public static ISkintestCudService getCiskintestrstService(){
		return (ISkintestCudService)ServiceFinder.find(ISkintestCudService.class);
	}
	
	/**
	 * 获得临床事件维护服务
	 */
	public static ICieventCudService getCieventService(){
		return (ICieventCudService)ServiceFinder.find(ICieventCudService.class);
	}
	
	/**
	 * 获得临床事件查询服务
	 */
	public static ICieventRService getCieventQryService(){
		return (ICieventRService)ServiceFinder.find(ICieventRService.class);
	}

	/**
	 * 获得用法下费用对照查询服务
	 */
	public static IPriusgRService getPriusgRService(){
		return (IPriusgRService)ServiceFinder.find(IPriusgRService.class);
	}
	
	/**
	 * 获得标本类型对应费用服务查询服务
	 */
	public static IBdprisampRService getBdprisampRService(){
		return (IBdprisampRService)ServiceFinder.find(IBdprisampRService.class);
	}
	
	/**
	 * 获得患者就诊信息查询服务
	 */
	public static IEnOutQryService getEnOutQryService(){
		return (IEnOutQryService)ServiceFinder.find(IEnOutQryService.class);
	}
	
	/**
	 * 获得服务套套内项目信息查询服务
	 */
	public static IMedSrvSetItemDORService getMedSrvSetItemRService(){
		return (IMedSrvSetItemDORService)ServiceFinder.find(IMedSrvSetItemDORService.class);
	}
	
	/**
	 * 获得服务项目信息查询服务
	 */
	public static IMedsrvMDORService getMedsrvMDORService(){
		return (IMedsrvMDORService)ServiceFinder.find(IMedsrvMDORService.class);
	}
	
	/**
	 * 获得服务项目信息查询服务
	 */
	public static IMedsrvRService getMedsrvRService(){
		return (IMedsrvRService)ServiceFinder.find(IMedsrvRService.class);
	}
	
	/**
	 * 获得医疗服务关联的查询服务
	 */
	public static IMedSrvRelMmDORService getMedsrvRelMmQryService(){
		return (IMedSrvRelMmDORService)ServiceFinder.find(IMedSrvRelMmDORService.class);
	}
	
	
	
	/**
	 * 获得医嘱服务查询
	 */
	public static ICiorderMDORService getCiorderMDORService(){
		return (ICiorderMDORService)ServiceFinder.find(ICiorderMDORService.class);
	}
	
 
	/**
	 * 获得检验的查询服务 agg
	 */
	public static ICirptlabRService getCirptlabRService(){
		return (ICirptlabRService)ServiceFinder.find(ICirptlabRService.class);
	}
	
	/**
	 * 获得计价模式价格计算服务
	 */
	public static IPriCalService getPriCalService(){
		return (IPriCalService)ServiceFinder.find(IPriCalService.class);
	}
	
	
	/**
	 * 获得频次查询服务
	 */
	public static IFreqdefMDORService getFreqdefMDORService(){
		return (IFreqdefMDORService)ServiceFinder.find(IFreqdefMDORService.class);
	}
	
	/**
	 * 获得频次对应时间查询服务
	 */
	public static IFreqTimeDORService getFreqTimeDORService(){
		return (IFreqTimeDORService)ServiceFinder.find(IFreqTimeDORService.class);
	}
	
	/**
	 * 获得频次Agg查询服务
	 */
	public static IFreqdefRService getFreqdefRService(){
		return (IFreqdefRService)ServiceFinder.find(IFreqdefRService.class);
	}
	
	
	
	/**
	 * 获得临床医嘱项目对应物品服务
	 */
	public static IOrdsrvmmCudService getOrsrvmmService(){
		return (IOrdsrvmmCudService)ServiceFinder.find(IOrdsrvmmCudService.class);
	}
	
	/**
	 * 获得临床医嘱项目对代办人服务
	 */
	public static ICiorsrvagentCudService getOrsrvagentService(){
		return (ICiorsrvagentCudService)ServiceFinder.find(ICiorsrvagentCudService.class);
	}
	/**
	 * 获得临床医嘱项目对代办人服务
	 * @return
	 */
	public static ICiorsrvagentRService getCiorsrvagentRService(){
		return (ICiorsrvagentRService)ServiceFinder.find(ICiorsrvagentRService.class);
	}
	/**
	 * 获得就诊联系人服务
	 */
	public static IEntcontCudService getEntcontService(){
		return (IEntcontCudService)ServiceFinder.find(IEntcontCudService.class);
	}
	
	/**
	 * 获得就诊联系人查询服务
	 */
	public static IEntcontRService getEntcontQryService(){
		return (IEntcontRService)ServiceFinder.find(IEntcontRService.class);
	}
	
	
	
	/**
	 * 获得临床医嘱项目变动剂量服务
	 */
	public static IOrdsrvdoseCudService getOrsrvdoseService(){
		return (IOrdsrvdoseCudService)ServiceFinder.find(IOrdsrvdoseCudService.class);
	}
	
	/**
	 * 获得临床医嘱项目变动剂量查询服务
	 */
	public static IOrdsrvdoseRService getOrsrvdoseQryService(){
		return (IOrdsrvdoseRService)ServiceFinder.find(IOrdsrvdoseRService.class);
	}
	
	/**
	 * 获得临床医嘱或项目套内项目服务
	 */
	public static IOrdsrvsetCudService getOrsrvsetService(){
		return (IOrdsrvsetCudService)ServiceFinder.find(IOrdsrvsetCudService.class);
	}
	
	/**
	 * 获得临床医嘱或项目套内项目查询服务
	 */
	public static IOrdsrvsetRService getOrsrvsetQryService(){
		return (IOrdsrvsetRService)ServiceFinder.find(IOrdsrvsetRService.class);
	}
	
	/**
	 * 获得会诊申请维护服务
	 */
	public static ICiorappconsultCudService getOrappconsultService(){
		return (ICiorappconsultCudService)ServiceFinder.find(ICiorappconsultCudService.class);
	}
	
	/**
	 * 获得会诊申请查询服务
	 */
	public static ICiorappconsultRService getOrappconsultQryService(){
		return (ICiorappconsultRService)ServiceFinder.find(ICiorappconsultRService.class);
	}
	
	/**
	 * 获得手术申请维护服务
	 */
	public static ICiorappsurgeryCudService getOrappsurgerytService(){
		return (ICiorappsurgeryCudService)ServiceFinder.find(ICiorappsurgeryCudService.class);
	}
	
	/**
	 * 获得手术申请维护服务
	 */
	public static ICiorappsurgeryRService getOrappsurgeryQrytService(){
		return (ICiorappsurgeryRService)ServiceFinder.find(ICiorappsurgeryRService.class);
	}
	
	/**
	 * 获得病理申请维护服务
	 */
	public static ICiorapppathgyCudService getOrapppathgyService(){
		return (ICiorapppathgyCudService)ServiceFinder.find(ICiorapppathgyCudService.class);
	}
	
	/**
	 * 获得病理申请查询服务
	 */
	public static ICiorapppathgyRService getOrapppathgyQryService(){
		return (ICiorapppathgyRService)ServiceFinder.find(ICiorapppathgyRService.class);
	}
	
	/**
	 * 获得备血申请维护服务
	 */
	public static ICiorappbtCudService getOrappbtService(){
		return (ICiorappbtCudService)ServiceFinder.find(ICiorappbtCudService.class);
	}
	
	/**
	 * 获得备血申请查询服务
	 */
	public static ICiorappbtRService getOrappbtQryService(){
		return (ICiorappbtRService)ServiceFinder.find(ICiorappbtRService.class);
	}
	
	/**
	 * 获得用血申请维护服务
	 */
	public static ICiorappbuCudService getOrappbuService(){
		return (ICiorappbuCudService)ServiceFinder.find(ICiorappbuCudService.class);
	}
	
	/**
	 * 获得用血申请查询服务
	 */
	public static ICiorappbuRService getOrappbuQryService(){
		return (ICiorappbuRService)ServiceFinder.find(ICiorappbuRService.class);
	}

	/**
	 * 获得检验申请维护服务
	 */
	public static ICiorapplisCudService getOrapplisService(){
		return (ICiorapplisCudService)ServiceFinder.find(ICiorapplisCudService.class);
	}
	
	/**
	 * 获得检验申请查询服务
	 */
	public static ICiorapplisRService getOrapplisQryService(){
		return (ICiorapplisRService)ServiceFinder.find(ICiorapplisRService.class);
	}
	
	/**
	 * 获得出院申请维护服务
	 */
	public static ICiorappouthospCudService getOrappoutService(){
		return (ICiorappouthospCudService)ServiceFinder.find(ICiorappouthospCudService.class);
	}
	
	/**
	 * 获得出院申请查询服务
	 */
	public static ICiorappouthospRService getOrappoutQryService(){
		return (ICiorappouthospRService)ServiceFinder.find(ICiorappouthospRService.class);
	}	
	
	/**
	 * 获得检查申请维护服务
	 */
	public static ICiorapprisCudService getOrapprisService(){
		return (ICiorapprisCudService)ServiceFinder.find(ICiorapprisCudService.class);
	}
	
	/**
	 * 获得检查申请查询服务
	 */
	public static ICiorapprisRService getOrapprisQryService(){
		return (ICiorapprisRService)ServiceFinder.find(ICiorapprisRService.class);
	}
	
	/**
	 * 获得医保险扩展查询服务
	 */
	/*public static IHpExtService getHpExtService(){
		return (IHpExtService)ServiceFinder.find(IHpExtService.class);
	}*/
	
	/**
	 * 获得转科申请维护服务
	 */
	public static ICiorapptransdeptCudService getOrapptransdepService(){
		return (ICiorapptransdeptCudService)ServiceFinder.find(ICiorapptransdeptCudService.class);
	}
	
	/**
	 * 获得转科申请查询服务
	 */
	public static ICiorapptransdeptRService getOrapptransdepQryService(){
		return (ICiorapptransdeptRService)ServiceFinder.find(ICiorapptransdeptRService.class);
	}
	
	/**
	 * 获得转科申请查询服务
	 */
	public static IBdFcQryService getBdFcQryQryService(){
		return (IBdFcQryService)ServiceFinder.find(IBdFcQryService.class);
	}
	
	/**
	 * 获得医疗服务查询服务
	 */
	public static IBdSrvQryService getBdSrvQryQryService(){
		return (IBdSrvQryService)ServiceFinder.find(IBdSrvQryService.class);
	}
	/**
	 * 获得医疗服务维护通用服务
	 */
	public static IBdSrvMaintainService getBdSrvMaintainService(){
		return (IBdSrvMaintainService)ServiceFinder.find(IBdSrvMaintainService.class);
	}
	
	/**
	 * 获得医嘱互斥记录查询服务
	 */
	public static ICiorreactlogRService getOrreactlogQryService(){
		return (ICiorreactlogRService)ServiceFinder.find(ICiorreactlogRService.class);
	}
	
	/**
	 * 获得医嘱互斥记录维护服务
	 */
	public static ICiorreactlogCudService getOrreactlogService(){
		return (ICiorreactlogCudService)ServiceFinder.find(ICiorreactlogCudService.class);
	}
	 
	/**
	 * 获得医嘱门诊开立区间维护服务
	 */
	public static ICiorsessionCudService getCiorsessionService(){
		return (ICiorsessionCudService)ServiceFinder.find(ICiorsessionCudService.class);
	}	

	/**
	 * 获得医嘱门诊开立区间查询服务
	 */
	public static ICiorsessionRService getCiorsessionQryService(){
		return (ICiorsessionRService)ServiceFinder.find(ICiorsessionRService.class);
	}
	
	/**
	 * 获得部门服务限制查询服务
	 */
	public static IDeptsrvlimitRService getDeptSrvLimitQryService(){
		return (IDeptsrvlimitRService)ServiceFinder.find(IDeptsrvlimitRService.class);
	}
	 
	/**
	 * 获得医嘱处方查询服务
	 */
	public static IPresRService getCiPresQryService(){
		return (IPresRService)ServiceFinder.find(IPresRService.class);
	}
	 
	/**
	 * 获得医嘱处方维护服务
	 */
	public static IPresCudService getCiPresService(){
		return (IPresCudService)ServiceFinder.find(IPresCudService.class);
	}
	 
	/**
	 * 获得医嘱服务维护服务
	 */
	public static IOrdSrvDOCudService getOrSrvService(){
		return (IOrdSrvDOCudService)ServiceFinder.find(IOrdSrvDOCudService.class);
	}
	
	/**
	 * 获得药品执行相关服务
	 */
	public static IMpDgOutService getMpDrugOutService(){
		return (IMpDgOutService)ServiceFinder.find(IMpDgOutService.class);
	}
	
	/**
	 * 单据编码管理服务，包括申请单据号，回退单据号等
	 * @return
	 */
	public static IBillcodeManage getIBillcodeManage(){
		return 	 (IBillcodeManage)ServiceFinder.find(IBillcodeManage.class);
	}
	/**
	 * 病历的信息（门诊 住院使用）
	 * @return
	 */
	public static IMrServiceExt getIMrServiceExt(){
		return 	 (IMrServiceExt)ServiceFinder.find(IMrServiceExt.class);
	}            
	/**
	 * 生命体征信息
	 * @return
	 */
	public static IForeignService getIForeignService(){
		 return (IForeignService)ServiceFinder.find(IForeignService.class);
	}
	
	/**
	 * 总览取得费用数据
	 * @return
	 */
	public static IBlcgqueryService getIBlcgqueryService(){
		return (IBlcgqueryService)ServiceFinder.find(IBlcgqueryService.class);
	}
	/**
	 * 获得患者过敏史查询服务
	 * @return
	 */
	public static IPiPatAlDORService getIPiPatAlDORService(){
		return  (IPiPatAlDORService)ServiceFinder.find(IPiPatAlDORService.class);
	}
	/**
	 * 获得患者过敏史维护服务
	 * @return
	 */
	public static IPiPatAlDOCudService getIPiPatAlDOService(){
		return  (IPiPatAlDOCudService)ServiceFinder.find(IPiPatAlDOCudService.class);
	}
	/**
	 * 就诊Service 
	 * @return
	 */
	public static IEnOutQryService getIEQryService(){
		return  ServiceFinder.find(IEnOutQryService.class);
	}
	/**
	 * 医嘱助手列表集合(患者既往)
	 * @return
	 */
	public static IPageRService getIPageRService(){
		return ServiceFinder.find(IPageRService.class);	
	}
	/**
	 * 医嘱助手常用模板分类
	 * @return
	 */
	public static IRegularorcaRService getIRegularorcaRService(){
		return ServiceFinder.find(IRegularorcaRService.class);
	}
	/**
	 * 医嘱助手常用模板项目
	 * @return
	 */
	 public static IRegularorrelsrvRService getIRegularorrelsrvRService(){
		 return ServiceFinder.find(IRegularorrelsrvRService.class);
	 }
	 
	 /**
	  * 医嘱助手模板AggDO
	  * @return
	  */
	 public static ISrvortplitemRService getISrvortplitemRService(){
		 return ServiceFinder.find(ISrvortplitemRService.class);
	 }
	 
	 /**
	  * 医嘱模板项目
	  * @return
	  */
	 public static ISrvortplitemCudService getISrvortplitemCudService(){
		 return ServiceFinder.find(ISrvortplitemCudService.class);
	 }
	 /**
	  * 医疗服务药品属性
	  * @return
	  */
	  public  static IMedSrvDrugDORService getIMedSrvDrugDORService(){
		  return ServiceFinder.find(IMedSrvDrugDORService.class);
	  }
	  
	/**
	 * 获得医疗单关联服务数据信息查询服务
	 * @return
	 */
	public static IEmsRelSrvDORService getEmsRelSrvQryService(){
		return (IEmsRelSrvDORService)ServiceFinder.find(IEmsRelSrvDORService.class);
	}	
	
	/**
	 * 获得患者就诊信息查询服务
	 * @return
	 */
	public static IPativisitRService getPativisitQryService(){
		return (IPativisitRService)ServiceFinder.find(IPativisitRService.class);
	}
	/**
	 * 基础数据医疗服务（bd_srv）
	 * @return
	 */
	public static IMedsrvMDORService getIMedsrvMDORService(){
		return (IMedsrvMDORService)ServiceFinder.find(IMedsrvMDORService.class);
	}
	 
	/**
	 * 获得煎法关联服务
	 * @return
	 */
	public static IBdpriboilRService getIBdpriboilRService(){
		return (IBdpriboilRService)ServiceFinder.find(IBdpriboilRService.class);
	}	
	/**
	 * 就诊诊断
	 * @return
	 */
	public static IEntdiRService getIEntdiRService(){
		return ServiceFinder.find(IEntdiRService.class);
	}
	/**
	 * 就诊诊断
	 * @return
	 */
	public static IEntdiCudService getIEntdiCudService(){
		return ServiceFinder.find(IEntdiCudService.class);
	}
	/**
	 * 会诊agg  
	 * @return
	 */
	public static ICiorappconsultCudService getICiorappconsultCudService(){
		return ServiceFinder.find(ICiorappconsultCudService.class);
	}
	/**
	 * 医嘱停止和作废调用执行接口
	 * @return
	 */
	public static IResponseOrderHandelService getIResponseOrderHandelService(){
		return ServiceFinder.find(IResponseOrderHandelService.class);
	}
	
	/**
	 * 医嘱执行闭环类型匹配参数服务接口
	 * @return
	 */
	public static IOrpltpmtParaService getIOrpltpmtParaService(){
		return ServiceFinder.find(IOrpltpmtParaService.class);
	}
	/**
	 * 获得剂量单位对象
	 * @return
	 */
	public static IMeasdocRService getMeasdocRService()
	{
		return ServiceFinder.find(IMeasdocRService.class);
	}
	/**
	 * 获得关联服务策略查询服务
	 * @return
	 */
	public static IRelsrvtacticsRService getRelsrvtacticsRService()
	{
		return ServiceFinder.find(IRelsrvtacticsRService.class);
	}
	
	/**
	 * 医保信息
	 * @return
	 */
	public static IHpsrvorcaRService getIHpExtService(){
		
		return (IHpsrvorcaRService)ServiceFinder.find(IHpsrvorcaRService.class.getName());
	}
	
	public static HPSrvorcaDO findHp(String id_hp, String id_Srv) throws BizException{
		IHpsrvorcaRService hpService=(IHpsrvorcaRService)ServiceFinder.find(IHpsrvorcaRService.class.getName());
		//return hpService.getHpSrvTpByCode(hpCode,id_Srv)
		String whereStr = HPSrvorcaDO.ID_HP +"='"+id_hp+"' and  "+ HPSrvorcaDO.ID_SRV +" ='"+id_Srv+"'";
		HPSrvorcaDO[] orca =  hpService.find(whereStr,HPSrvorcaDO.ID_HPSRVTP,FBoolean.FALSE);
		if(orca != null && orca.length >0){
			return orca[0];
		}else{
			throw new BizException("没有找医保信息");
		}
	}
	
	 /***
	  * 物品查询服务
	  * @return
	  */
	public static IMaterialBaseInfoService getIMaterialService(){
		return (IMaterialBaseInfoService)ServiceFinder.find(IMaterialBaseInfoService.class);
	}
	
	/**
	 * 判断物品是否是基数库管理，便于确定物品执行科室
	 * @return
	 */
	public static IMaterialBaseInfoService getIMaterialBaseInfoService(){
		return (IMaterialBaseInfoService)ServiceFinder.find(IMaterialBaseInfoService.class);
	}
	/**
	 * 备血医疗单查询service
	 * @return
	 */
	public static ICiorappbtMDORService getICiorappbtMDORService(){
		return (ICiorappbtMDORService)ServiceFinder.find(ICiorappbtMDORService.class);
	}
	/**
	 * 备血医疗单写service
	 */
	public static ICiorappbtMDOCudService getICiorappbtMDOCudService(){
		return (ICiorappbtMDOCudService)ServiceFinder.find(ICiorappbtMDOCudService.class);
	}
	/**
	 *医嘱模板的查询DO
	 * @return
	 */
	public static IOrtmplMDORService getIOrtmplMDORService(){
		return (IOrtmplMDORService)ServiceFinder.find(IOrtmplMDORService.class);
	}
	/**
	 * 医嘱模板Agg查询接口
	 * @return
	 */
	public static IOrtmplRService getIOrtmplRService(){
		return (IOrtmplRService)ServiceFinder.find(IOrtmplRService.class);
	}
	/**
	 * 在径患者的医嘱检查
	 * @return
	 */
	public static IHpcpAppItfService getIHpcpAppItfService(){
		return (IHpcpAppItfService)ServiceFinder.find(IHpcpAppItfService.class);
	}
	
	/**
	 * 医嘱的模板项目
	 * @return
	 */
	public static IOrTplNItmDORService getIOrTplNItmDORService(){
		return (IOrTplNItmDORService)ServiceFinder.find(IOrTplNItmDORService.class);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static ICiorderSrvDOCudService getICiorderSrvDOCudService(){
		return (ICiorderSrvDOCudService)ServiceFinder.find(ICiorderSrvDOCudService.class);
	}
	
	/**
	 * 医保计划接口
	 * @return
	 */
	public static IHpQueService getIHpQueService(){
		return (IHpQueService)ServiceFinder.find(IHpQueService.class);
	}
	/**
	 * 患者信息
	 * @return
	 */
	public static IPatiMDORService getIPatiMDORService(){
		return (IPatiMDORService)ServiceFinder.find(IPatiMDORService.class);
	}
	/**
	 * 医疗服务检验属性service
	 * @return
	 */
	public static IMedSrvLisDORService getIMedSrvLisDORService(){
		return ServiceFinder.find(IMedSrvLisDORService.class);
	}

	/**
	 * 组织机构service
	 * @return
	 */
	public static IGroupRService getIGroupRService(){
		return ServiceFinder.find(IGroupRService.class);
	}  
	
	/**
	 * 医嘱自定义查询服务
	 * @return
	 */
	public  static ICiOrdQryService getCiOrdQryService(){
		return ServiceFinder.find(ICiOrdQryService.class);
	}
	/**
	 * 患者临床摘要数据维护服务
	 * @return
	 */
	public static IOverviewMDORService getOverviewMDORService(){
		return ServiceFinder.find(IOverviewMDORService.class);
	}
	
	/**
	 * SD对应的服务接口
	 * @return
	 */
	public static IUdidocRService getUdidocRService(){
		return ServiceFinder.find(IUdidocRService.class);
	}
	
	/**
	 * 用法关联剂型服务接口
	 * @return
	 */
	public static IRoutedosageRService getIRoutedosageRService(){
		return ServiceFinder.find(IRoutedosageRService	.class);
	}
	/**
	 * 医嘱的修改保存删除类（自定义）
	 * @return
	 */
	public static ICiOrdMaintainService getICiOrdMaintainService(){
		return ServiceFinder.find(ICiOrdMaintainService	.class);
	}
	/**
	 * 门诊退费接口
	 */
	public static IBLCancelSettlement getIBLCancelSettlement(){
		return ServiceFinder.find(IBLCancelSettlement.class);
	}
	/**
	 * 医嘱补费、退费接口
	 * @return
	 */
	public static IBLOrderAppendBillService getIBLOrderAppendBillService(){
		return ServiceFinder.find(IBLOrderAppendBillService.class);
	}
	/**
	 * 医保计划数据维护服务
	 * @return
	 */
	public static  IBdHpCtrDORService  getIBdHpCtrDORService(){
		return ServiceFinder.find(IBdHpCtrDORService.class);	
	}
	
	
	
	/**
	 * 临床打印单服务接口
	 * @return
	 */
	public static  ICiprintExtService  getICiprintExtService(){
		return ServiceFinder.find(ICiprintExtService.class);	
	}
	
	
	/**
	 *  病理查询服务 
	 * @return
	 */
	public static  ICiorapppathgyMDORService  getICiorapppathgyMDORService(){
		return ServiceFinder.find(ICiorapppathgyMDORService.class);	
	}
	
	
	/**
	 *  病理维护服务 
	 * @return
	 */
	public static  ICiorapppathgyMDOCudService  getICiorapppathgyMDOCudService(){
		return ServiceFinder.find(ICiorapppathgyMDOCudService.class);	
	}
	
	
	
	/**
	 *  手术申请查询
	 * @return
	 */
	public static  ICiorappsurgeryMDORService  getICiorappsurgeryMDORService(){
		return ServiceFinder.find(ICiorappsurgeryMDORService.class);	
	}
	/**
	 *  手术申请维护
	 * @return
	 */
	public static  ICiorappsurgeryMDOCudService  getICiorappsurgeryMDOCudService(){
		return ServiceFinder.find(ICiorappsurgeryMDOCudService.class);	
	}
	
	/**
	 * 医疗单匹配接口
	 * @return
	 */
	public static IEmsManagementService getIEmsManagementService(){
		return ServiceFinder.find(IEmsManagementService.class);	
	}
	
	/**
	 * 医保计划、医保计划目录、诊断查询服务
	 * @return
	 */
	public static IPpQueService getIPpQueService(){
		return ServiceFinder.find(IPpQueService.class);
	}
	/**
	 * 病历对外查询接口
	 * @return
	 */
	public static ICiMrOutQryServices getCiMrOutQryServices(){
		return ServiceFinder.find(ICiMrOutQryServices .class);
	} 
	
	/**
	 * 记账对外查询服务接口
	 * @return
	 */
	public static IBlOutQryService getIBlOutQryService(){
		return ServiceFinder.find(IBlOutQryService.class);
	}
	/**
	 *  医保计划自费诊断数据维护服务
	 * @return
	 */
	public static IHpdiexpenseselfRService getIHpdiexpenseself(){
		return ServiceFinder.find(IHpdiexpenseselfRService.class);
	}
	/**
	 * 检验申请单数据维护服务
	 * @return
	 */
	public static ICiapplissheetMDOCudService getICiapplissheetMDOCudService(){
		return  ServiceFinder.find(ICiapplissheetMDOCudService.class);
	}
	/**
	 * 病理申请单数据维护服务
	 * @return
	 */
	public static ICiapppathgysheetMDOCudService getICiapppathgysheetMDOCudService(){
		return ServiceFinder.find(ICiapppathgysheetMDOCudService.class);
	}
	/**
	 * 检查申请单数据维护服务
	 * @return
	 */
	public static ICiapprissheetCudService getICiapprissheetCudService(){
	   return ServiceFinder.find(ICiapprissheetCudService.class);	
	}
	/**
	 *  临床打印单数据维护服务
	 * @return
	 */
	public static ICiprintMDOCudService getICiprintMDOCudService(){
		return ServiceFinder.find(ICiprintMDOCudService.class);
	}
	/**
	 * 门诊诊疗执行单数据维护服务
	 * @return
	 */
	public static ICiapptreatexecMDOCudService getICiapptreatexecMDOCudService(){
		return ServiceFinder.find(ICiapptreatexecMDOCudService.class);
	}
	/**
	 * 临床医保信息
	 * @return
	 */
	public static ICiorsrvhpCudService getICiorsrvhpCudService(){
		return ServiceFinder.find(ICiorsrvhpCudService.class);
	}
	/**
	 * 临床医保信息
	 * @return
	 */
	public static ICiorsrvhpRService getICiorsrvhpRService(){
		return ServiceFinder.find(ICiorsrvhpRService.class);
	}
	/**
	 * 医保查询服务接口
	 * @return
	 */
	public static IBdHpQryService getIBdHpQryService(){
		return ServiceFinder.find(IBdHpQryService.class);
	}
	/**
	 * 诊断查询
	 * @return
	 */
	public static ICidiagQryService  getICidiagQryService(){
		 return ServiceFinder.find(ICidiagQryService.class);
	}
	 
}

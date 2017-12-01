package iih.ci.ord.s;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.i.IBdHpQryService;
import iih.bd.srv.dto.d.Emp2Dep2GroupDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.d.RegularOrCaDO;
import iih.bd.srv.ortpl.d.RegularOrRelSrvDO;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.bl.hp.i.IBlHpOutQryService;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.dto.d.IpViewDiagDTO;
import iih.ci.ord.cior.d.CiOrLastMpDTO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.d.desc.OrdAppBtUseDODesc;
import iih.ci.ord.ciordems.d.AddFeeDTO;
import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsOrSrvSc;
import iih.ci.ord.ciordems.d.OrConfirm;
import iih.ci.ord.ciordems.d.ext.CheckParamDTO;
import iih.ci.ord.ciordems.d.ext.CheckRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.dto.allergy.d.AllergyDto;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.dto.blexorder.d.DiagTreatKeyPointRntDataDTO;
import iih.ci.ord.dto.blexorder.d.DiagTreatViewRntDataDTO;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitOrModParamDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.dto.consdto.d.OrdConsDTO;
import iih.ci.ord.dto.cporderstatusdto.d.CpOrderStatusDto;
import iih.ci.ord.dto.d.CiOrAggAndRelInfo;
import iih.ci.ord.dto.d.CiordubDTO;
import iih.ci.ord.dto.d.InsurDrugDivideInfoDTO;
import iih.ci.ord.dto.d.LabDTO;
import iih.ci.ord.dto.d.MedicalSharingDTO;
import iih.ci.ord.dto.d.OrtplDTO;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.dto.hp.BdHpIndicDTO;
import iih.ci.ord.dto.medicalroutinetreedto.d.Medicalroutinetreedto;
import iih.ci.ord.dto.newordertemplatedto.d.NewOrderTemplateDTO;
import iih.ci.ord.dto.newordertemplatedto.d.OrderTemplateRstDTO;
import iih.ci.ord.dto.oporsplit.d.OpOrSplitParamDTO;
import iih.ci.ord.dto.ordermr.d.OrderMrDto;
import iih.ci.ord.dto.orderpandectemrdto.d.OrderPandectEmrDTO;
import iih.ci.ord.dto.ordersrvinfompdto.d.OrderSrvInfoMpDTO;
import iih.ci.ord.dto.ordertemplatedto.d.OrderTemplateDTO;
import iih.ci.ord.dto.ordertpltree.d.OrderTplTreeDto;
import iih.ci.ord.dto.ordinput.d.OrdInputDto;
import iih.ci.ord.dto.ordpres.d.OrdPresDTO;
import iih.ci.ord.dto.ordpres.d.PresPrintParamDTO;
import iih.ci.ord.dto.ordrationaldrugdto.d.OrdRationalDrugDTO;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.dto.orobsandlab.d.OrObsAandLabDTO;
import iih.ci.ord.dto.orsrvguide.d.OrSrvGuideDTO;
import iih.ci.ord.dto.outdeptcheckorder.d.OutDeptCheckOrderDTO;
import iih.ci.ord.dto.patdetaildto.d.PatDetailDTO;
import iih.ci.ord.dto.patorderlistdto.d.Patorderlistdto;
import iih.ci.ord.dto.patundoorderdto.d.PatUnDoOrderdto;
import iih.ci.ord.dto.prepaypat.d.PrepayCondDTO;
import iih.ci.ord.dto.prepaypat.d.PrepayPatDTO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdDTO;
import iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdSrvDTO;
import iih.ci.ord.dto.vitalsignsdto.d.VitalSignsDto;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.BdSrv4EmsDiDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.hp.HpService;
import iih.ci.ord.hp.HpService.MedSrvHpParam;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.ordappathgy.d.OrdApPathgyDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.DischargeCheckBP;
import iih.ci.ord.s.bp.GetCiOderBlSrvBP;
import iih.ci.ord.s.bp.GetConsDTOListBP;
import iih.ci.ord.s.bp.GetEmsFeeBySrvBp;
import iih.ci.ord.s.bp.GetEmsObsItemDOBP;
import iih.ci.ord.s.bp.GetEnHistoryCiOrdersBP;
import iih.ci.ord.s.bp.GetMedSrvScBP;
import iih.ci.ord.s.bp.GetMedSrvSetItemBP;
import iih.ci.ord.s.bp.GetMeterialDOByWhereSqlBP;
import iih.ci.ord.s.bp.GetOpPrepayPatListBP;
import iih.ci.ord.s.bp.GetOrderBP;
import iih.ci.ord.s.bp.GetPatEntFeesCensusBP;
import iih.ci.ord.s.bp.GetPatUnDoOrderListBP;
import iih.ci.ord.s.bp.GetPresNameBP;
import iih.ci.ord.s.bp.GetSrvortplitemAggDOSCacheBP;
import iih.ci.ord.s.bp.HpcpBannerInfoBP;
import iih.ci.ord.s.bp.IPGetSrvortplitemAggDOSBP;
import iih.ci.ord.s.bp.JudgeBeginEndTimeHasMpTimes;
import iih.ci.ord.s.bp.JudgeOrderStatusBP;
import iih.ci.ord.s.bp.MedicalSharingBP;
import iih.ci.ord.s.bp.OutDeptCheckOrderBP;
import iih.ci.ord.s.bp.PrescriptionConstAccountingBP;
import iih.ci.ord.s.bp.PrescriptionTreeBP;
import iih.ci.ord.s.bp.SrvSetItemBP;
import iih.ci.ord.s.bp.TransferStatusUpdatesBP;
import iih.ci.ord.s.bp.UnchargeOrderListBP;
import iih.ci.ord.s.bp.UnchargeOrderSrvBP;
import iih.ci.ord.s.bp.ValidateOrderAndDiagBP;
import iih.ci.ord.s.bp.getAllergyDtoBP;
import iih.ci.ord.s.bp.getBlCgRecipeDTOBP;
import iih.ci.ord.s.bp.getBlcgAmtVsDrugRationBP;
import iih.ci.ord.s.bp.getCiApObsDtoBP;
import iih.ci.ord.s.bp.getCiDiagItemDOListBP;
import iih.ci.ord.s.bp.getCiOrdConfirmBP;
import iih.ci.ord.s.bp.getCiOrdConfirmedBP;
import iih.ci.ord.s.bp.getCiOrdFeeBp;
import iih.ci.ord.s.bp.getCiOrderAggDOBP;
import iih.ci.ord.s.bp.getCiRptObsBP;
import iih.ci.ord.s.bp.getCiorderPreviewDTOSBP;
import iih.ci.ord.s.bp.getCirptlabAggBP;
import iih.ci.ord.s.bp.getClassMedSrvDOSBP;
import iih.ci.ord.s.bp.getConsPatListBP;
import iih.ci.ord.s.bp.getConsultationPatientsBP;
import iih.ci.ord.s.bp.getCpOrderStatusDtoBP;
import iih.ci.ord.s.bp.getDepsNumBP;
import iih.ci.ord.s.bp.getDiagTreatDataNewBP;
import iih.ci.ord.s.bp.getDiagTreatKeyPointDataBP;
import iih.ci.ord.s.bp.getDiagTreatViewDataBP;
import iih.ci.ord.s.bp.getEntDiDOListBP;
import iih.ci.ord.s.bp.getExtdispenseDtoBP;
import iih.ci.ord.s.bp.getLabItmsBP;
import iih.ci.ord.s.bp.getMedicalroutinetreedtoBP;
import iih.ci.ord.s.bp.getObsAndLabDTOBP;
import iih.ci.ord.s.bp.getObsAndLabListBP;
import iih.ci.ord.s.bp.getOrPresDTOsBP;
import iih.ci.ord.s.bp.getOrSrvGuideDTOBP;
import iih.ci.ord.s.bp.getOrdInputDtoBP;
import iih.ci.ord.s.bp.getOrderFlush2MrDtoListBP;
import iih.ci.ord.s.bp.getOrderMrDtoListBP;
import iih.ci.ord.s.bp.getOrderPandectEmrDTOBP;
import iih.ci.ord.s.bp.getOrderSrvInfoMpDTOBP;
import iih.ci.ord.s.bp.getOrderTplTreeDtoBP;
import iih.ci.ord.s.bp.getOrderUBDtoBP;
import iih.ci.ord.s.bp.getPageDOListBP;
import iih.ci.ord.s.bp.getPathgyListBP;
import iih.ci.ord.s.bp.getPrescriptionCostDtoBP;
import iih.ci.ord.s.bp.getRecipeDTOByCodeOrBP;
import iih.ci.ord.s.bp.getRecipeDTOByIdPresBP;
import iih.ci.ord.s.bp.getSrvortplitemAggDOSBP;
import iih.ci.ord.s.bp.getTemplateClassIficationBP;
import iih.ci.ord.s.bp.getTreeOrdApConsDOBP;
import iih.ci.ord.s.bp.getUsedHpdiexpenseseBP;
import iih.ci.ord.s.bp.splitOrSplitSqlRsBP;
import iih.ci.ord.s.bp.assi.CiOrderAndOrtmplCopyBP;
import iih.ci.ord.s.bp.assi.CiOrderCopyBP;
import iih.ci.ord.s.bp.assi.getMoreEmsParamDTOBP;
import iih.ci.ord.s.bp.assi.ciorcopy.IpCiOrderCopyBP;
import iih.ci.ord.s.bp.base.bizline.GetDeptsStr8DepWardRelBlTpBP;
import iih.ci.ord.s.bp.base.emsdi.GenEmsDiInfo8BdSrvBP;
import iih.ci.ord.s.bp.bedmargin.CiOrPharmArrivalInTransitUpdateBP;
import iih.ci.ord.s.bp.bedmargin.CiOrPharmBedMarginUpdateBP;
import iih.ci.ord.s.bp.checkems.CheckEmsBeforSaveBP;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.common.GetExeDepts4CiOrSrvBP;
import iih.ci.ord.s.bp.common.GetExeDepts4CiOrSrvNBP;
import iih.ci.ord.s.bp.ems.CiOrEmsGet8OrIdBP;
import iih.ci.ord.s.bp.ems.CiOrEmsGetOrAggAndRelInfoBP;
import iih.ci.ord.s.bp.ems.CiOrSrvExecuteDeptGetBP;
import iih.ci.ord.s.bp.ems_v1.GetEmsHandleBP;
import iih.ci.ord.s.bp.hp.HpQryCiorderBP;
import iih.ci.ord.s.bp.mp.CiOrLastMpJudgeBP;
import iih.ci.ord.s.bp.operableords.JudgeOrderStatusInMultiUserBP;
import iih.ci.ord.s.bp.oporsplit.getOpOrSplitSqlRsBp;
import iih.ci.ord.s.bp.ordpres.GetOrdPresInfo4PrintBP;
import iih.ci.ord.s.bp.ordpres.GetOrdPresInfoBP;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import iih.ci.ord.s.bp.orsrvsplit.CiOrInfoUpdateAfterSplitBP;
import iih.ci.ord.s.bp.orsrvsplit.CiOrInfoUpdateLastSplitBP;
import iih.ci.ord.s.bp.orsrvsplit.GetOrAndSrvSplitSqlBP;
import iih.ci.ord.s.bp.orsrvsplit.GetOrAndSrvSplitSqlRsBP;
import iih.ci.ord.s.bp.orsrvsplit.SplitOrAndSrvSplitSqlRsBP;
import iih.ci.ord.s.bp.orsrvsplit.SrvSplitRsApplyQuanBP;
import iih.ci.ord.s.bp.orsrvsplit.SrvSplitRsApplyQuanNBP;
import iih.ci.ord.s.bp.orsrvsplit.getOrSplitSqlRsBp;
import iih.ci.ord.s.bp.qry.CiOrdersUsedHpCidiQry;
import iih.ci.ord.s.bp.rationaldrug.dttong.GetRationalDrugBP;
import iih.ci.ord.s.bp.skintest.SkinTestLogicMainBP;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPriceCalBP;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalBP;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalByPriModeBP;
import iih.ci.ord.s.bp.validate.CiOrOpenEntStatusValidateBP;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.en.pv.dto.d.EnDiQrySchmDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.dto.d.EntHisDiDTO;
import iih.en.pv.entdi.d.EntDiDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.lang3.StringUtils;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.devcfg.func.d.PageDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

@Service(serviceInterfaces = { ICiOrdQryService.class }, binding = Binding.JSONRPC)
public class CiOrdQryServiceImpl implements ICiOrdQryService {

	GetPatUnDoOrderListBP patUnDoOrderBP = new GetPatUnDoOrderListBP();

	/**
	 *开立医嘱服务查询
	 * 
	 */
	@Override
	public EmsHeadDO getEmsHeadDO(String id_order, String orderType, String code_entp,CiEnContextDTO contextdto) throws BizException {
		GetOrderBP bp = new GetOrderBP();
		return bp.exec(id_order, orderType, code_entp,contextdto);
	}

	@Override
	public List<UnchargeOrdDTO> getUnchargeOrderList(String patid, FDateTime dtSignB, FDateTime dtSignE,
			String code_entp, String Id_org) throws BizException {
		// TODO Auto-generated method stub
		UnchargeOrderListBP bp = new UnchargeOrderListBP();
		return bp.exec(patid, dtSignB, dtSignE, code_entp, Id_org);
	}

	/**
	 * 获取服务关联的物品 全信息 （医嘱用）
	 * 
	 * @param id_org
	 * @param id_srv
	 * @param id_dept_mp
	 * @param id_dept_phy
	 * @param id_hp
	 * @return
	 * @throws BizException
	 */
	@Override
	public EmsOrDrug[] getSrvVsMm(String id_org, String id_srv, String id_dept_mp, String id_dept_phy, String id_hp,
			String code_entp) throws BizException {
		GetOrderBP bp = new GetOrderBP();
		return bp.getSrvVsMm(id_org, id_srv, id_dept_mp, id_dept_phy, id_hp);
	}

	/**
	 * 取得服务套的项目的服务
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	@Override
	public MedSrvDO[] getSrvSetItemList(String id_srv) throws BizException {
		// TODO Auto-generated method stub
		SrvSetItemBP bp = new SrvSetItemBP();
		return bp.exec(id_srv);
	}

	/**
	 * 转科过程状态更新
	 * 
	 * @param Id_ord
	 * @param status
	 * @return boolean true 成功， false 失败
	 * @throws BizException
	 */
	@Override
	public boolean TransferStatusUpdates(String id_ortrans, String status) throws BizException {

		TransferStatusUpdatesBP bp = new TransferStatusUpdatesBP();
		return bp.exec(id_ortrans, status);
	}

	@Override
	public OutDeptCheckOrderDTO[] GetOutDeptCheckOrder(String id_en) throws BizException {
		OutDeptCheckOrderBP bp = new OutDeptCheckOrderBP();
		return bp.exec(id_en);
	}

	/**
	 * 根据服务 id_srvs 和医保类型查找医保id_hp
	 * 
	 * @param hpCode
	 * @param idSrv
	 * @return HpSrvOrCaDO
	 * @throws BizException
	 */

	@Override
	public Map<String, HPSrvorcaDO> GetHpSrvOrCaDOMap(String id_hp, String[] id_srvs) throws BizException {
		GetOrderBP bp = new GetOrderBP();
		return bp.findHps(id_hp, id_srvs);
	}

	/**
	 * 根据服务id和医保类型查找医保id_hp
	 * 
	 * @param hpCode
	 * @param idSrv
	 * @return HpSrvOrCaDO
	 * @throws BizException
	 */
	@Override
	public HPSrvorcaDO GetHpSrvOrCaDo(String id_hp, String id_srv) throws BizException {
//		GetOrderBP bp = new GetOrderBP();
//		return bp.findHp(id_hp, id_srv);
		//TODO 医保信息调整后改动
		return null;
	}

	/**
	 * 是否可退院
	 * 
	 * @param entId 就诊id
	 * @return 错误信息
	 * @throws BizException
	 */
	public String canDischarge(String entId) throws BizException {
		DischargeCheckBP chkBP = new DischargeCheckBP();
		return chkBP.canDischarge(entId);
	}

	/**
	 * 患者出院时查询住院患者未处理完的医嘱 lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	@Override
	public PatUnDoOrderdto[] GetPatUnDoOrderdto(String id_ent) throws BizException {
		// TODO Auto-generated method stub
		return patUnDoOrderBP.exec(id_ent);
	}

	/**
	 * 患者本次就诊 医嘱列表 lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] GetOrderList(String id_ent) throws BizException {

		return patUnDoOrderBP.GetOrderList(id_ent);
	}

	/**
	 * 患者 医嘱列表 lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	@Override
	public Patorderlistdto[] getPatorderlistdto(String id_ent) throws BizException {
		// TODO Auto-generated method stub
		return patUnDoOrderBP.GetPatOrderList(id_ent);
	}

	/**
	 * 查询医嘱关联的服务 lizheng 时间 2015 -10-26
	 * 
	 * @param id_or
	 * @return
	 * @throws Exception
	 */
	@Override
	public OrdSrvDO[] GetOrderSrvDOS(String id_or) throws BizException {
		// TODO Auto-generated method stub
		return patUnDoOrderBP.GetOrderSrvDOS(id_or);
	}

	/**
	 * 患者出院时查询住院患者未处理完的医嘱 数量 lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	@Override
	public int GetPatUnDoOrderdtoNum(String id_ent) throws BizException {
		int num = 0;
		if (id_ent != null) {
			PatUnDoOrderdto[] dto = patUnDoOrderBP.exec(id_ent);
			if (dto != null && dto.length > 0) {
				return dto.length;
			}
			return num;
		}
		return num;
	}

	/**
	 * 患者出院时查询住院患者未处理完的医嘱 数量 lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	@Override
	public Map GetPatUnDoOrderdtoNums(String[] id_ents) throws BizException {
		if (id_ents == null)
			throw new BizException("param  id_ents is null");
		return patUnDoOrderBP.exe2(id_ents);
	}

	/**
	 * 获取医疗服务（含医保计划）
	 * 
	 * @param srvca 服务类型
	 * @param srvName 服务名称
	 * @param Healthcad 患者医保计划
	 * @return
	 * @throws BizException
	 */
	@Override
	public EmsOrSrvSc[] getMedSrvSc(String srvca, String srvName, String Healthca, String code_entp)
			throws BizException {
		GetMedSrvScBP bp = new GetMedSrvScBP();
		return bp.exec(srvca, srvName, Healthca, code_entp);
	}

	/**
	 * 医嘱模板获得医疗服务
	 * 
	 * @param dto 查询参数对象
	 * @return
	 * @throws BizException
	 */
	@Override
	public EmsOrSrvSc[] getOrtplMedSrvSc(OrtplDTO dto) throws BizException {
		GetMedSrvScBP bp = new GetMedSrvScBP();
		return bp.exec(dto);
	}

	/**
	 * 根据 ID_srv 取得医疗服务
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	@Override
	public EmsOrSrvSc[] getMedSrvId(String id_srv) throws BizException {
		GetMedSrvScBP bp = new GetMedSrvScBP();
		return bp.getBdSrv_id(id_srv);
	}

	/**
	 * 检查 项目取得（新增时）
	 * 
	 * @param id_srv
	 * @param type
	 * @return
	 * @throws BizException
	 */
	@Override
	public EmsObsItemDO[] getEmsObsItemDO(String id_srv, String type) throws BizException {
		GetEmsObsItemDOBP bp = new GetEmsObsItemDOBP();
		return bp.exce(id_srv, type);
	}

	/**
	 * 根据医嘱id_or 获取编辑信息 EmsHeadDO
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	@Override
	public EmsHeadDO GetemsHeadDO(String id_or, String type) throws BizException {
		// GetEmsBP bp = new GetEmsBP();
		//
		// return bp.getEmsBP(id_or, type);
		return null;
	}

	/**
	 * 获得执行与记费的医嘱或服务拆分时的有效医嘱查询字串操 cn_cgex_ip_sql
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public String getOrAndSrvSplitSql(OrSrvSplitParamDTO param) throws BizException {
		GetOrAndSrvSplitSqlBP bp = new GetOrAndSrvSplitSqlBP();
		return bp.exec(param);
	}

	/**
	 * 获得执行与记费的医嘱或服务拆分时的有效医嘱对应的结果值
	 * 
	 * @param param cn_or_ip_sel
	 * @return
	 * @throws BizException
	 */
	@Override
	public BaseDTO[] getOrAndSrvSplitSqlRs(OrSrvSplitParamDTO param) throws BizException {
		GetOrAndSrvSplitSqlRsBP bp = new GetOrAndSrvSplitSqlRsBP();
		return bp.exec(param);
	}

	/**
	 * 医嘱总分拆分（医嘱维度和服务维度）
	 */
	@Override
	public BaseDTO getOrSplitSqlRs(OrSrvSplitParamDTO param) throws BizException {

		getOrSplitSqlRsBp bp = new getOrSplitSqlRsBp();

		return bp.exec(param);
	}

	/**
	 * 门急诊医嘱拆分
	 * 
	 * @author lijm 2016年9月27日18:01:12
	 */
	@Override
	public BaseDTO[] getOpOrSplitSqlRs(OpOrSplitParamDTO ParamDTO) throws BizException {

		getOpOrSplitSqlRsBp bp = new getOpOrSplitSqlRsBp();

		return bp.exec(ParamDTO);
	}

	/**
	 * 回写医嘱和医嘱项目有的最近生成时间 xuxing_2016-06-12
	 */
	@Override
	public void writeBackOrAndOrSrvLastBl(OrSplitOrderDTO[] listOrSplitDTO, SrvSplitOrderDTO[] listSrvSplitDTO,
			FDateTime Dt_last_bl) throws BizException {

		CiOrInfoUpdateLastSplitBP bp = new CiOrInfoUpdateLastSplitBP();

		bp.exec(listOrSplitDTO, listSrvSplitDTO, Dt_last_bl);
	}

	/**
	 * 对有效医嘱对应的结果集进行拆分 cn_cgex_ip_calc
	 * 
	 * @param splitRsDTOs
	 * @param s
	 * @param e
	 * @param orgensplittp
	 * @throws BizException
	 */
	@Override
	public BaseDTO[] splitOrAndSrvSplitSqlRs(BaseDTO[] splitRsDTOs, FDateTime s, FDateTime e, Integer orgensplittp)
			throws BizException {
		SplitOrAndSrvSplitSqlRsBP bp = new SplitOrAndSrvSplitSqlRsBP();
		return bp.exec(splitRsDTOs, s, e, orgensplittp);
	}

	/**
	 * 服务拆分结果请领量计算 cn_cgex_ip_ap
	 * 
	 * @param srvsplitorders
	 * @return
	 * @throws BizException
	 */
	@Override
	public SrvSplitOrderDTO[] calSrvSplitRsApplyQuan(SrvSplitOrderDTO[] srvsplitorders) throws BizException {
		SrvSplitRsApplyQuanBP bp = new SrvSplitRsApplyQuanBP();
		return bp.exec(srvsplitorders);
	}

	/**
	 * 服务拆分结果请领量计算 cn_cgex_ip_ap
	 * 
	 * @param srvsplitorders
	 * @return
	 * @throws BizException
	 */
	@Override
	public ArrayList<ArrayList<SrvSplitOrderDTO>> calSrvSplitRsApplyQuanN(SrvSplitOrderDTO[] srvsplitorders)
			throws BizException {
		SrvSplitRsApplyQuanNBP bp = new SrvSplitRsApplyQuanNBP();
		return bp.exec(srvsplitorders);
	}

	/**
	 * 医嘱服务拆分后医嘱相关信息回写 cn_cgex_ip_newdatetime
	 * 
	 * @param params
	 * @throws BizException
	 */
	@Override
	public void ciOrInfoUpdateAfterSplit(OrSrvSplitOrModParamDTO[] params) throws BizException {
		CiOrInfoUpdateAfterSplitBP bp = new CiOrInfoUpdateAfterSplitBP();
		bp.exec(params);

	}

	/**
	 * 检查 检验报告的类别分类数据
	 * 
	 * @param id_ent
	 * @return OrObsAandLabDTO[]
	 * @throws BizException
	 */
	@Override
	public OrObsAandLabDTO[] getObsAndLabList(String id_ent, String type) throws BizException {

		getObsAndLabListBP bp = new getObsAndLabListBP();
		return bp.exec(id_ent, type);
	}

	/**
	 * 根据物品类型获得物品信息
	 */
	@Override
	public EmsOrDrug[] getMmByMmtp(String mmtp) throws BizException {
		GetOrderBP bp = new GetOrderBP();
		return bp.getMmByMmtp(mmtp);
	}

	/**
	 * 检查 检验报告的时间分类数据
	 * 
	 * @param id_ent
	 * @return OrObsAandLabDTO[]
	 * @throws BizException
	 */
	@Override
	public OrObsAandLabDTO[] getObsAndLabDateList(String id_ent, String type) throws BizException {

		getObsAndLabListBP bp = new getObsAndLabListBP();
		return bp.exec(id_ent, type);
	}

	/**
	 * 病理申请分类数据
	 */
	@Override
	public OrdApPathgyDTO[] getPathgyList(String id_ent) throws BizException {
		// TODO Auto-generated method stub
		getPathgyListBP bp = new getPathgyListBP();
		return bp.exec(id_ent);
	}

	/**
	 * 总览页面的诊断信息
	 * 
	 * @param id_ent
	 * @param type
	 * @return
	 * @throws BizException
	 */
	@Override
	public IpViewDiagDTO[] getCiDiagItemDOList(String id_ent, String type) throws BizException {
		getCiDiagItemDOListBP bp = new getCiDiagItemDOListBP();
		return bp.exec(id_ent);
	}

	/**
	 * 会诊应答,审批列表
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdConsDTO[] GetConsList(String id_dep, String su_cons) throws BizException {

		GetConsDTOListBP bp = new GetConsDTOListBP();
		return bp.getConsList(id_dep, su_cons);
	}

	/**
	 * 检验接口 (病历使用)
	 * 
	 * @param id_ent
	 * @return CiRptObsDO[]
	 * @throws BizException
	 */
	@Override
	public CiRptObsDO[] getCiRptObsDO(String id_ent) throws BizException {
		getCiRptObsBP bp = new getCiRptObsBP();
		return bp.exec(id_ent);
	}

	/**
	 * 检验接口 (病历使用)
	 * 
	 * @param id_ent
	 * @return CirptlabAggDO[]
	 * @throws BizException
	 */
	@Override
	public CirptlabAggDO[] getCirptlabAggDO(String id_ent) throws BizException {
		getCirptlabAggBP bp = new getCirptlabAggBP();
		return bp.exec(id_ent);
	}

	/**
	 * 医嘱录入模板使用 B画面使用
	 * 
	 * @param id_ent
	 * @param id_Doctor
	 * @return OrdInputDto[]
	 * @throws BizException
	 */
	@Override
	public OrdInputDto[] getOrdInputDto(String id_ent, String id_doctor) throws BizException {

		getOrdInputDtoBP bp = new getOrdInputDtoBP();
		return bp.exec(id_ent, id_doctor);
	}

	/**
	 * 医嘱信息（病历使用） OrderMrDto
	 * 
	 * @param id_ent
	 * @param type 00, 10
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrderMrDto[] getOrderMrDtoList(String id_ent, String type) throws BizException {
		getOrderMrDtoListBP bp = new getOrderMrDtoListBP();
		if (id_ent == null || type == null)
			return null;
		return bp.exec(id_ent, type);
	}
	/**
	 * 处置手动刷新到病历
	 * @param id_ent
	 * @param type
	 * @param orders
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrderMrDto[] getOrderFlushMrDtoList(String id_ent, String type,CiOrderDO[] orders) throws BizException {
		if(orders!=null && orders.length!=0){
			List<String> ordids=new ArrayList<String>();
			for(CiOrderDO orderdo: orders){
				ordids.add(orderdo.getId_or());
			}
			ICiorderMDORService iCiemrRService = ServiceFinder.find(ICiorderMDORService.class);
			if(ordids.size()==0 || iCiemrRService==null) return null;
			CiOrderDO[] signord=iCiemrRService.findByIds(ordids.toArray(new String[ordids.size()]), FBoolean.FALSE);
			ICiorderMDOCudService iCiemrCudService = ServiceFinder.find(ICiorderMDOCudService.class);
			if(signord==null ||signord.length==0 || iCiemrCudService==null) return null;
			for(CiOrderDO orderdo: signord){
				ordids.add(orderdo.getId_or());
				orderdo.setFg_flush2mr(FBoolean.TRUE);
				orderdo.setStatus(DOStatus.UPDATED);
			}
			iCiemrCudService.save(signord) ;
		}
		
		getOrderFlush2MrDtoListBP bp = new getOrderFlush2MrDtoListBP();
		if (id_ent == null || type == null)	return null;
		return bp.exec(id_ent, type);
	}
	/**
	 * 处置手动刷新到病历
	 * @author yzh 2017-05-09
	 * @param id_ent
	 * @param type
	 * @param orders
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap2 getOrderMrDtoFlushList(String id_ent, String code_entp,String[] idors,String id_psndoc,String refreshMode) throws BizException {
		getOrderFlush2MrDtoListBP bp = new getOrderFlush2MrDtoListBP();
		if (id_ent == null || code_entp == null ) return null;
		if(refreshMode.equals("0")){
			return bp.exec1(id_ent, code_entp, idors,id_psndoc);
		}else{
			return bp.exec2(idors);
		}
		
		
	}

	/**
	 * 会诊患者查询
	 * 
	 * @param id_dept
	 * @param id_emp
	 * @return Id_en
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] getConsPatList(String id_dept, String id_emp) throws BizException {
		getConsPatListBP bp = new getConsPatListBP();
		return bp.exec(id_dept, id_emp);

	}

	/**
	 * 用血申请
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiordubDTO getOrderUBDto(String id_or) throws BizException {
		// TODO Auto-generated method stub
		getOrderUBDtoBP bp = new getOrderUBDtoBP();
		return bp.execub(id_or);
	}

	/**
	 * 备血列表
	 * 
	 * @param id_or
	 * 
	 */
	@Override
	public CiordubDTO[] getOrderUBDtoList(String id_ent) throws BizException {
		// TODO Auto-generated method stub
		getOrderUBDtoBP bp = new getOrderUBDtoBP();
		return bp.execpbt(id_ent);
	}

	/**
	 * 编辑医嘱 取得 CiEmsDTO
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap getCiEmsDTO(String[] id_ors) throws BizException {
		CiOrEmsGet8OrIdBP bp = new CiOrEmsGet8OrIdBP();
		return bp.exec(id_ors);
	}

	/**
	 * 医嘱确认
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrConfirm[] getCiOrdConfirm(OrConfirm confirm) throws BizException {
		// TODO Auto-generated method stub
		getCiOrdConfirmBP bp = new getCiOrdConfirmBP();
		return bp.exec(confirm);
	}

	/**
	 * 医嘱确认
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	@Override
	public AddFeeDTO[] getCiOrdFee(OrConfirm confirm) throws BizException {
		// TODO Auto-generated method stub
		getCiOrdFeeBp bp = new getCiOrdFeeBp();
		return bp.exec(confirm);
	}

	/**
	 * 分方查询
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrderPresSplitDTO[] getOrPresDTOs(String id_en) throws BizException {
		// TODO Auto-generated method stub
		getOrPresDTOsBP bp = new getOrPresDTOsBP();

		return bp.exec(id_en);
	}

	/**
	 * 检查申请单号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getOrdApObsNoapplyform() throws BizException {
		return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(OrdApObsDODesc.CLASS_FULLNAME);
	}

	/**
	 * 检验申请单号
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getOrdApLabNoapplyform() throws BizException {
		return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(OrdApLabDODesc.CLASS_FULLNAME);
	}

	/**
	 * 大病区查询
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getDepsNum(String id_dep) throws BizException {
		// TODO Auto-generated method stub
		getDepsNumBP bp = new getDepsNumBP();
		return bp.exec(id_dep);
	}

	/**
	 * 趋势图
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public LabDTO[] getLabItms(String idpat, int num, String[] srvlist) throws BizException {
		// TODO Auto-generated method stub
		getLabItmsBP bp = new getLabItmsBP();
		return bp.exec(idpat, num, srvlist);

	}
	
	
	
	
	/**
	 * 通过日期查趋势图
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public LabDTO[] getLabItms8DateBP(String idpat, FDateTime start, FDateTime end,String[] srvlist) throws BizException {
		// TODO Auto-generated method stub
		iih.ci.ord.s.bp.getLabItms8DateBP bp = new iih.ci.ord.s.bp.getLabItms8DateBP();
		return bp.exec(idpat, start,end, srvlist);

	}

	/***
	 * 当前就诊的所用诊断
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntDiDO[] getEntDiDOList(String id_ent) throws BizException {
		getEntDiDOListBP bp = new getEntDiDOListBP();
		return bp.exec(id_ent);
	}

	/**
	 * 总览页面的病历信息
	 * 
	 * @param enttp
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrderPandectEmrDTO[] getOrderPandectEmrDTO(String enttp, String id_ent) throws BizException {
		getOrderPandectEmrDTOBP bp = new getOrderPandectEmrDTOBP();
		return bp.exec(enttp, id_ent);
	}

	/**
	 * 用血申请单号
	 * 
	 * @param fullclassname
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getNoapplyform(String fullclassname) throws BizException {
		// TODO Auto-generated method stub
		return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(OrdAppBtUseDODesc.CLASS_FULLNAME);
	}

	/**
	 * 生成备血申请单的申请单号
	 * 
	 * @param fullclassname
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getNoappbtlyform(String fullclassname) throws BizException {
		// TODO Auto-generated method stub
		String noappbt = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(OrdApBtDODesc.CLASS_FULLNAME);
		return noappbt;
	}

	/**
	 * 会诊树使用
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdApConsDO[] getTreeOrdApConsDO(String id_ent) throws BizException {
		if (id_ent == null)
			return null;
		getTreeOrdApConsDOBP bp = new getTreeOrdApConsDOBP();
		return bp.exec(id_ent);
	}

	/**
	 * 检查申请 未执行的列表
	 * 
	 * @param id_dep_exe 执行科室
	 * @param entps 就诊类型
	 * @param dtSignB 开始时间
	 * @param dtSignE 结束时间
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	@Override
	public AppObsDto[] getCiApObsDto(String id_dep_exe, String[] entps, FDateTime dtSignB, FDateTime dtSignE)
			throws BizException {
		if (id_dep_exe == null || entps == null || dtSignB == null || dtSignE == null) {
			throw new BizException("执行科室 ，就诊类型  开始结束时间 不能为空");
		}
		getCiApObsDtoBP bp = new getCiApObsDtoBP();
		return bp.exec(id_dep_exe, entps, dtSignB, dtSignE);
	}
    
	/**
	 * 检查申请 位置执行的列表
	 * 
	 * @param id_dep_exe
	 *            执行科室
	 * @param entps
	 *            就诊类型
	 * @param dtSignB
	 *            开始时间
	 * @param dtSignE
	 *            结束时间
	 * @return PagingRtnData<AppObsDto> 
	 * @throws BizException
	 */
	@Override
	public  PagingRtnData<AppObsDto> getCiApObsDtoByDeptPage(PaginationInfo pg,String id_dep_exe, String[] entps, FDateTime dtSignB, FDateTime dtSignE,String[] sd_su_bl)throws BizException{
		if (id_dep_exe == null || entps == null || dtSignB == null || dtSignE == null
			||sd_su_bl== null || sd_su_bl.length==0) {
			throw new BizException("执行科室 ，就诊类型  开始结束时间 不能为空");
		}
		getCiApObsDtoBP bp = new getCiApObsDtoBP();
		return bp.execPage(pg,id_dep_exe, entps, dtSignB, dtSignE,sd_su_bl);
	}
	
	/**
	 * 检查申请 未执行的列表 根据就诊id_en
	 * 
	 * @param id_en
	 * @return AppObsDto
	 * @throws BizException
	 */
	@Override
	public AppObsDto[] getCiApObsDtoIdEnt(String id_en) throws BizException {
		getCiApObsDtoBP bp = new getCiApObsDtoBP();
		return bp.getCiApObsDtoIdEnt(id_en);
	}
	/**
	 * 检查申请 未执行的列表 根据就诊id_en
	 * 
	 * @param id_en
	 * @return AppObsDto
	 * @throws BizException
	 */
	@Override
	public AppObsDto[] getCiApObsDtoIdEnt2(String id_en) throws BizException {
		getCiApObsDtoBP bp = new getCiApObsDtoBP();
		return bp.getCiApObsDtoIdEnt2(id_en);
	}
	/**
	 * 查询患者的检查申请单
	 * 
	 * @param id_pat [] 患者id
	 * @param dtSignB 开始时间
	 * @param dtSignE 结束时间
	 * @param obs_su 检查的状态 1 已安排 ，2 已到检，3 已检查，4 报告，5 已取消，0 已申请
	 * @return AppObsDto[] 返回的集合
	 * @throws BizException
	 */
	@Override
	public AppObsDto[] getCiApObsDtoIdPatAndDate(String[] id_pat, FDateTime dtSignB, FDateTime dtSignE, String[] obs_su)
			throws BizException {
		getCiApObsDtoBP bp = new getCiApObsDtoBP();
		return bp.getCiApObsDtoIdPatAndDate(id_pat, dtSignB, dtSignE, obs_su);
	}

	/**
	 * 取得门诊未缴费预付费患者列表(药品医嘱)
	 * 
	 * @param cond 查询条件
	 * @return 患者列表
	 * @throws BizException
	 */
	@Override
	public PrepayPatDTO[] getOpPrepayPatList(PrepayCondDTO cond) throws BizException {
		GetOpPrepayPatListBP bp = new GetOpPrepayPatListBP();
		return bp.exec(cond);
	}

	/**
	 * 门诊 住院 总览 取得生命体征的信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public VitalSignsDto getCiorderPreviewDTOS(String id_ent,String Dt_birth) throws BizException {
		getCiorderPreviewDTOSBP bp = new getCiorderPreviewDTOSBP();
		return bp.getCiorderPreviewDTOS(id_ent,Dt_birth);
	}

	/**
	 * 总览取得费用数据接口
	 * 
	 * @param id_pat 患者id
	 * @param id_ent 就诊id
	 * @param codeSrv 服务编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public String[] getBlcgAmtVsDrugRation(String id_pat, String id_ent, String codeSrv) throws BizException {
		getBlcgAmtVsDrugRationBP bp = new getBlcgAmtVsDrugRationBP();
		return bp.getBlcgAmtVsDrugRation(id_pat, id_ent, codeSrv);
	}

	/**
	 * 患者过敏史
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	@Override
	public AllergyDto[] getAllergyDto(String id_pat) throws BizException {
		if (id_pat == null)
			return null;
		getAllergyDtoBP bp = new getAllergyDtoBP();
		return bp.exe(id_pat);
	}

	/**
	 * 医嘱助手患者既往就诊
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntHisDiDTO[] getEntHisDiDTO(String id_pat) throws BizException {
		if (id_pat == null)
			throw new BizException("id_pat is null");
		return CiOrdAppUtils.getIEQryService().getEntHisDiDTO(id_pat);
	}

	/**
	 * 医嘱助手患者既往就诊
	 * 
	 * @param patId
	 * @param qrySchms
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntHisDiDTO[] getEntHisDiBySchm(String patId, EnDiQrySchmDTO[] qrySchms) throws BizException {
		if (patId == null || qrySchms == null)
			throw new BizException("id_pat is null");
		return CiOrdAppUtils.getIEQryService().getEntHisDiBySchm(patId, qrySchms);
	}

	/**
	 * 医嘱助手页签列表
	 * 
	 * @param doctor_id 登陆医生id
	 * @param dept_id 当前登陆科室
	 * @param biz_id 业务功能id
	 * @return
	 * @throws BizException
	 */
	@Override
	public PageDO[] getPageDOList(String doctor_id, String dept_id, String biz_id) throws BizException {
		getPageDOListBP bp = new getPageDOListBP();
		return bp.getPageDOList(doctor_id, dept_id, biz_id);
	}

	/**
	 * 医嘱助手 医疗服务项目分类
	 * 
	 * @param cindition
	 * @param ordercolumn
	 * @param islazy
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	@Override
	public MedSrvDO[] getClassMedSrvDOS(String condition, String orderColumn, FBoolean isLazy) throws BizException {
		if (condition == null || condition == "")
			return null;
		getClassMedSrvDOSBP bp = new getClassMedSrvDOSBP();
		FMap2 map = new FMap2();
		return bp.exe(condition, orderColumn, isLazy,map);
	}
	
	/**
	 * 医嘱助手 医疗服务项目分类
	 * 
	 * @param code_entp 就诊类型
	 * @param cindition 服务分类过滤条件
	 * @param orderColumn 排序列
	 * @return map key= medSrvList, value ： FArrayList 医疗服务集合，key=srvStatusMap，value：医疗服务不可用原因
	 * @throws BizException
	 */
	@Override
	public FMap2 getClassMedSrvMap(String code_entp, String condition, String orderColumn)
			throws BizException {		
		long  startTime = System.currentTimeMillis();
		getClassMedSrvDOSBP bp = new getClassMedSrvDOSBP();
		FMap2 map =  bp.exec(code_entp, condition, orderColumn);
		CiOrdUtils.LogerOutInfo(" 类  CiOrdQryServiceImpl  方法 getClassMedSrvMap 耗时"+(System.currentTimeMillis()- startTime));
	    return  map;
	}

	// 医嘱模板
	// 协定处方（草药）
	// 常用医嘱

	/**
	 * 医嘱助手 常规模板分类
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegularOrCaDO[] getRegularOrCaDOs() throws BizException {

		return CiOrdAppUtils.getIRegularorcaRService().find("1=1", "", FBoolean.FALSE);
	}
	
	

	/**
	 * 医嘱助手常规模板项目
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegularOrRelSrvDO[] getRegularOrRelSrvDOs(String id_regularorca) throws BizException {

		String whereStr = " a0.id_regularorca = '" + id_regularorca + "'";
		return CiOrdAppUtils.getIRegularorrelsrvRService().find(whereStr, "a0.id_regularorca", FBoolean.FALSE);
	}
	
	/**
	 * 医嘱助手 - 医技常规模板 修改 （新的）
	 * @return
	 * @throws BizException
	 */
	@Override
	public  Medicalroutinetreedto[] getMedicalroutinetreedto(String _entp) throws BizException{
		getMedicalroutinetreedtoBP bp = new getMedicalroutinetreedtoBP();
		return  bp.exce(_entp);//参数 门诊和住院 需要迭代
	}
	
	/**
	 * 医嘱助手 - 医技常规模板  项目 （新的）
	 * @param id_ortmpl
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrTplNItmDO[] getOrTplNItmDO(String id_ortmpl)throws BizException{
		 if(id_ortmpl != null ){
			 String whereStr = OrTplNItmDO.ID_ORTMPL +" = '"+id_ortmpl+"'";
			return  CiOrdAppUtils.getIOrTplNItmDORService().find(whereStr, OrTplNItmDO.ID_ORTMPL, FBoolean.FALSE);
		 }
		return null;
	}
	
	

	/**
	 * 医嘱助手医嘱模板树
	 * 
	 * @return OderTplTreeDto
	 * @throws BizException
	 */
	@Override
	public OrderTplTreeDto[] getOrderTplTreeDto(String id_ortpltp, Emp2Dep2GroupDTO edg) throws BizException {
		getOrderTplTreeDtoBP bp = new getOrderTplTreeDtoBP();
		return bp.getOrderTplTreeDto(id_ortpltp, edg);
	}

	/**
	 * 医嘱助手模板项目
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrderTemplateDTO getSrvortplitemAggDOS(String id_srvortpl) throws BizException {
		if (id_srvortpl == null || id_srvortpl.equals("null") || id_srvortpl == "")
			new BizException("parameter :id_srvortpl is null");
		getSrvortplitemAggDOSBP bp = new getSrvortplitemAggDOSBP(null);
		return bp.getSrvortplitemAggDOS(id_srvortpl);
		// return
		// CiOrdAppUtils.getISrvortplitemRService().find(" a0.id_srvortpl
		// ='"+id_srvortpl+"'",
		// "id_srvortpl", FBoolean.FALSE);
	}
     
	
	
	/**
	 * 临床路径调用医嘱接口查询医嘱状态 DTO数据
	 * 
	 * @param cpOrderStatus
	 * @return String []
	 * @throws BizException
	 */
	@Override
	public String[] getCpOrderStatusDto(CpOrderStatusDto cpOrderStatus) throws BizException {
		getCpOrderStatusDtoBP bp = new getCpOrderStatusDtoBP();
		return bp.getCpOrderStatusDto(cpOrderStatus);
	}

	/**
	 * 药品信息： id_mm、剂型，包装单位（当前包装单位），最小包装（基本包装单位）
	 * 
	 * @param id_mm
	 * @return InsurDrugDivideInfoDTO[]
	 * @throws BizException
	 */
	@Deprecated
	@Override
	public InsurDrugDivideInfoDTO[] getInsurDivideInfoDTO(String id_mm) throws BizException {

		InsurDrugDivideInfoDTO[] drugs = new InsurDrugDivideInfoDTO[1];
		drugs[0] = new InsurDrugDivideInfoDTO();
		return drugs;
	}

	/**
	 * 服务信息：id_orsrv，用法，剂量，剂量单位、用药天数；
	 * 
	 * @param id_orsrv
	 * @return RecipeDTO[]
	 * @throws BizException
	 */
	@Deprecated
	@Override
	public RecipeDTO[] getRecipeDTO(String[] id_orsrvs) throws BizException {
		RecipeDTO[] recipedto = new RecipeDTO[1];
		recipedto[0] = new RecipeDTO();
		return recipedto;
	}

	/**
	 * 1、 id_or :医嘱主键 2、 id_orsrv :医嘱服务主键
	 * 
	 * @param id_or
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrSrvGuideDTO[] getOrSrvGuideDTO(String[] id_orsrv) throws BizException {
		if (id_orsrv == null || id_orsrv.length < 0)
			return null;
		getOrSrvGuideDTOBP bp = new getOrSrvGuideDTOBP();
		return bp.getOrSrvGuideDTO(id_orsrv);
	}

	/**
	 * 检查医嘱及部位查询接口（根据申请单编号查询）
	 * 
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	@Override
	public AppObsDto[] getCiApObsDtoNOApplyForm(String no_applyform_obs) throws BizException {
		getCiApObsDtoBP bp = new getCiApObsDtoBP();
		return bp.getCiApObsDtoNOApplyForm(no_applyform_obs);
	}
	/**
	 * 检查医嘱及部位查询接口（根据申请单编号查询）
	 * 
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	@Override
	public AppObsDto[] getCiApObsDtoNOApplyForm2(String no_applyform_obs,String[] sd_su_bl) throws BizException {
		getCiApObsDtoBP bp = new getCiApObsDtoBP();
		return bp.getCiApObsDtoNOApplyForm2(no_applyform_obs,sd_su_bl);
	} 
	/**
	 * 检查医嘱及部位查询接口（根据患者ID查询）
	 * 
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	@Override
	public AppObsDto[] getCiApObsDtoIdPat(String id_pat) throws BizException {
		getCiApObsDtoBP bp = new getCiApObsDtoBP();
		return bp.getCiApObsDtoIdPat(id_pat);
	}
	/**
	 * 检查医嘱及部位查询接口（根据患者ID查询）
	 * 
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	@Override
	public AppObsDto[] getCiApObsDtoIdPat2(String id_pat,String[] sd_su_bl) throws BizException {
		getCiApObsDtoBP bp = new getCiApObsDtoBP();
		return bp.getCiApObsDtoIdPat2(id_pat,sd_su_bl);
	}

	/**
	 * 可录入服务范围
	 * 
	 * @param id_dep
	 * @param code
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getCiSrvCondition(String id_dep, String code) throws BizException {
		// TODO Auto-generated method stub
		String str = ParamsetQryUtil.getParaString(id_dep, code);
		return str;
	}

	/**
	 * 获取执行科室
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrWfExDeptDTO[] getMpDept(OrWfExDeptParamDTO param) throws BizException {
		// TODO Auto-generated method stub
		CiOrSrvExecuteDeptGetBP bp = new CiOrSrvExecuteDeptGetBP();
		OrWfExDeptDTO[] do1 = bp.exec(param);
		if (do1 == null || do1.length == 0)
			return null;
		return do1;
	}

	/**
	 * 皮试主线处理与判断逻辑
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public SkinTestRstDTO skinTestLogicMainBP(SkinTestParamDTO param) throws BizException {
		SkinTestLogicMainBP bp = new SkinTestLogicMainBP();
		return bp.exec(param);
	}

	/**
	 * 病理主键生辰规则
	 * 
	 * @param fullclassname
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getOrdApPathgyDONober(String fullclassname) throws BizException {
		// TODO Auto-generated method stub
		/*
		 * IBillcodeManage codeS1=ServiceFinder.find(IBillcodeManage.class);
		 * String code=""; try {
		 * code=codeS1.getPreBillCode_RequiresNew(OrdApPathgyDODesc
		 * .CLASS_FULLNAME); } catch (BizException e) { e.printStackTrace(); }
		 * return code;
		 */
		CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(OrdApPathgyDODesc.CLASS_FULLNAME);
		return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew("iih.ci.ord.cior.d.OrdApPathgyDO");

	}

	/**
	 * 患者按处方收费（未计费的医嘱）
	 * 
	 * @param patid 患者id
	 * @param dtSignB 开始时间
	 * @param dtSignE 结束时间
	 * @param code_entp 就诊类型
	 * @param Id_org 就诊机构
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrescriptionCostDto[] getPrescriptionCostDto(String patid, FDateTime dtSignB, FDateTime dtSignE,
			String code_entp, String Id_org) throws BizException {
		if (patid == null || code_entp == null || Id_org == null)
			throw new BizException(" parameter patid or code_entp  or  Id_org is null  ");
		getPrescriptionCostDtoBP bp = new getPrescriptionCostDtoBP();
		return bp.exe(patid, dtSignB, dtSignE, code_entp, Id_org);
	}

	/**
	 * 患者按处方收费（ 未计费的医嘱）
	 * 
	 * @param patid 患者id
	 * @param dtSignB 开始时间
	 * @param dtSignE 结束时间
	 * @param code_entp 就诊类型
	 * @param Id_org 就诊机构
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrescriptionConstBaseDto getPrescriptionConstBaseDto(String patid, FDateTime dtSignB, FDateTime dtSignE,
			String code_entp, String Id_org) throws BizException {
		if (patid == null || code_entp == null || Id_org == null)
			throw new BizException(" parameter patid or code_entp  or  Id_org is null  ");
		getPrescriptionCostDtoBP bp = new getPrescriptionCostDtoBP();
		return bp.exe2(patid, dtSignB, dtSignE, code_entp, Id_org);
	}
    
	
	
	
	/**
	 * 处方信息(费用使用)
	 * 
	 * @param id_repres
	 * @return
	 * @throws BizException
	 */
	public RecipeDTO[] getRecipeDTOAndBL(String[] id_repres) throws BizException {
		if (id_repres == null || id_repres.length == 0)
			return null;
		getPrescriptionCostDtoBP bp = new getPrescriptionCostDtoBP();
		return bp.exe3(id_repres);
	}

	/**
	 * 获取服务关联的物品 全信息 （医嘱确认用）
	 * 
	 * @param drug
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public AddFeeDTO getEmsfee(AddFeeDTO fee, OrWfExDeptParamDTO param) throws BizException {
		// TODO Auto-generated method stub
		GetEmsFeeBySrvBp bp = new GetEmsFeeBySrvBp();

		return bp.exec(fee, param);
	}

	/**
	 * 费用 使用(为了提高查询效率)
	 * 
	 * @param wherestr 条件
	 * @param TableColumns 需要的字段
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiorderAggDO[] getBlFeeCiOrderSrvDto(String wherestr, List TableColumnList) throws BizException {
		if (TableColumnList == null)
			return null;
		getCiOrderAggDOBP bp = new getCiOrderAggDOBP();
		return bp.exe(wherestr, TableColumnList);
	}
	

	/**
	 * 对有效医嘱进行拆分 cn_cgex_ip_calc
	 * 
	 * @param param
	 * @throws BizException
	 */
	@Override
	public SrvSplitOrderDTO[] splitSrvSplitSqlRs(OrSrvSplitParamDTO param) throws BizException {
		// TODO Auto-generated method stub
//		splitSrvSplitSqlRsBP bp = new splitSrvSplitSqlRsBP();
//		return bp.exec(param);
		return null;

	}

	/**
	 * 当前就诊的有效医嘱项目
	 * 
	 * @param id_ent
	 * @return OrdSrvDO[]
	 * @throws BizException
	 */
	@Override
	public OrdSrvDO[] getEffectiveOrdSrvDO(String id_ent, FDateTime startTime, FDateTime endTime) throws BizException {

		return null;
	}

	/**
	 * 根据医嘱 id_or 获取医嘱项目和物品信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrderSrvInfoMpDTO[] getOrderSrvInfoMpDTO(String[] id_ors) throws BizException {
		if (id_ors == null || id_ors.length == 0)
			return null;
		getOrderSrvInfoMpDTOBP bp = new getOrderSrvInfoMpDTOBP();
		return bp.exe(id_ors);
	}

	/**
	 * 当前时间之前的天数
	 * 
	 * @param days
	 * @return
	 * @throws BizException
	 */
	@Override
	public FDateTime getDateTomeBefore(int days) throws BizException {
		FDateTime dateTime = new FDateTime();
		return dateTime.getDateTimeBefore(days);
	}

	/**
	 * 当前时间之后的天数
	 * 
	 * @param days
	 * @return
	 * @throws BizException
	 */
	@Override
	public FDateTime getDateTomeAfter(int days) throws BizException {
		FDateTime dateTime = new FDateTime();
		return dateTime.getDateTimeAfter(days);
	}

	/**
	 * 对有效医嘱进行拆分 cn_cgex_ip_calc
	 * 
	 * @param param
	 * @throws BizException
	 */
	@Override
	public OrSplitOrderDTO[] splitOrSplitSqlRs(OrSrvSplitParamDTO param) throws BizException {
		// TODO Auto-generated method stub
		splitOrSplitSqlRsBP bp = new splitOrSplitSqlRsBP();

		return bp.exec(param);
	}

	/**
	 * 会诊患者列表
	 * 
	 * @param id_org 机构
	 * @param id_dep 登陆科室
	 * @param id_emp_response 登陆人员
	 * @return String[] 就诊id_en
	 * @throws BizException
	 */
	@Override
	public String[] getConsultationPatients(String id_org, String id_dep, String id_emp_response) throws BizException {
		getConsultationPatientsBP bp = new getConsultationPatientsBP();
		return bp.exe(id_org, id_dep, id_emp_response);
	}

	/**
	 * 待应答会诊患者列表查询接口
	 * 
	 * @param id_org 机构
	 * @param id_dep 登陆科室
	 * @param id_emp_response 登陆人员
	 * @return String[] 就诊id_en
	 * @throws BizException
	 */
	@Override
	public String[] getToRespondConsultationPatients(String id_org, String id_dep, String id_emp_response)
			throws BizException {
		getConsultationPatientsBP bp = new getConsultationPatientsBP();
		return bp.exe2(id_org, id_dep, id_emp_response);
	}

	/**
	 * 会诊患者详细信息接口
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatDetailDTO getConsPatDetail(String id_en) throws BizException {
		GetConsDTOListBP bp = new GetConsDTOListBP();
		return bp.getConsPatDetail(id_en);
	}

	/**
	 * 临床医嘱选择服务，服务价格计算 单服务价格计算
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public FDouble ciOrBdSrvPriceCal(BdSrvPriCalParamDTO param) throws BizException {
		CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
		return bp.exec(param);
	}

	/**
	 * 临床医嘱服务价格计算 批量服务价格计算
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public FDouble[] ciOrBdSrvPricesCal(BdSrvPriCalParamDTO[] params) throws BizException {
		CiOrBdSrvPricesCalBP bp = new CiOrBdSrvPricesCalBP();
		return bp.exec(params);
	}
	
	/**
	 * 临床医嘱服务价格计算 患者价格模式
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public MedSrvPriceDO ciOrBdSrvPriceCalByPriMode(BdSrvPriCalParamDTO param, String id_pripat) throws BizException {
		CiOrBdSrvPricesCalByPriModeBP bp = new CiOrBdSrvPricesCalByPriModeBP();
		
		return bp.exec(param, id_pripat);
	}

	/**
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getStringSystemParam(String id_org, String paramCode) throws BizException {
		if (CiOrdUtils.isEmpty(id_org)) {
			id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		}
		return ParamsetQryUtil.getParaString(id_org, paramCode);
	}

	/**
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	@Override
	public Integer getIntSystemParam(String id_org, String paramCode) throws BizException {
		// TODO Auto-generated method stub
		if (CiOrdUtils.isEmpty(id_org)) {
			id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		}
		Integer param = ParamsetQryUtil.getParaInt(id_org, paramCode);
		return param;
	}

	/**
	 * 根据传入的sql语句查询出物品
	 * 
	 * @param whereSql
	 * @return
	 * @throws BizException
	 */
	@Override
	public MeterialDO[] getMeterialDOByWhereSql(String whereSql) throws BizException {
		GetMeterialDOByWhereSqlBP bp = new GetMeterialDOByWhereSqlBP();
		return bp.exec(whereSql);
	}

	/**
	 * 获得患者就诊医嘱处方信息 （仅供处方打印用）
	 * 
	 * @param presprintparam
	 * @param 其中id_en 就诊Id
	 * @param 其中ids_orpres 重打或补打处方时处方Id字串（以逗号分隔）
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdPresDTO[] getOrdPresInfo(String id_en) throws BizException {
		GetOrdPresInfoBP bp = new GetOrdPresInfoBP();
		return bp.exec(id_en);
	}

	/**
	 * 获得科室下的病区id串
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getNurAreaOfDep(String id_dep) throws BizException {
		GetDeptsStr8DepWardRelBlTpBP bp = new GetDeptsStr8DepWardRelBlTpBP();
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		return bp.exec(id_org, id_dep, FBoolean.TRUE);
	}

	/**
	 * 扣减床旁余量
	 * 
	 * @author xuxing 2016-07-06
	 */
	@Override
	public String reductionBedQuan(String[] id_ors) throws BizException {

		CiOrPharmBedMarginUpdateBP bp = new CiOrPharmBedMarginUpdateBP();

		return bp.exec(id_ors);
	}

	/**
	 * 更新 在途量/床旁余量
	 * 
	 * @author xu_xing 2016-07-07
	 */
	@Override
	public String setPharmArrivalInTransitUpdate(String[] id_orsrvs) throws BizException {

		CiOrPharmArrivalInTransitUpdateBP bp = new CiOrPharmArrivalInTransitUpdateBP();

		return bp.exec(id_orsrvs);
	}

	/**
	 * 根据Ems数据获得临床医嘱及关联的相关信息 关联的相关信息：医嘱项目关联的物品信息、
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrAggAndRelInfo getCiOrAggAndRelInfo8Ems(CiEmsDTO ems,CiEnContextDTO CiEnContextDTO) throws BizException {
		Context.get().setAttribute("CiEnContextDTO", CiEnContextDTO);
		CiOrEmsGetOrAggAndRelInfoBP bp = new CiOrEmsGetOrAggAndRelInfoBP();
		return bp.exec(ems);
	}

	/**
	 * 根据Ems数据获得临床医嘱及关联的相关信息 关联的相关信息：医嘱项目关联的物品信息、
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdPresDTO[] getOrdPresInfo4Print(PresPrintParamDTO param) throws BizException {
		GetOrdPresInfo4PrintBP bp = new GetOrdPresInfo4PrintBP();
		return bp.exec(param);
	}

	/**
	 * 获取可录入服务范围
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	@Override
	public String[] getSrvScope(String sql) throws BizException {
		// TODO Auto-generated method stub
		// String idorg=CiOrdAppUtils.getEnvContext().getOrgId();
		DAFacade da = new DAFacade();
		List<String> ls=null;
		try {
			ls = (List<String>) da.execQuery(sql, new ColumnListHandler<>());
		} catch (Exception e) {
			// TODO: handle exception
			throw new BizException("参数CIOR0040设置错误！！！");
		}
		if(ls==null)
			return null;
		return ls.toArray(new String[0]);
	}

	/**
	 * 当服务选择时 界面数据初始化
	 * 
	 * @param envinfo 服务信息
	 * @param param 上下文信息
	 * @return EmsDiDTO[]
	 * @throws BizException
	 */
	@Override
	public CiEmsDTO getEmsDiDTO(CiEnContextDTO envinfo, BdSrv4EmsDiDTO param) throws BizException {
		GenEmsDiInfo8BdSrvBP bp = new GenEmsDiInfo8BdSrvBP();
		return bp.exec(envinfo, param);
	}

	/**
	 * 医嘱的列表的排列顺序
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getOrderSequenceMode() throws BizException {
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		// "CIORA0085"; //医嘱列表排列顺序模式 1 倒序 2 顺序
		String SequenceMdeo = "Desc";
		String temp = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_OpListMarshalSequenceMode);
		if ("1".equals(temp)) {
			SequenceMdeo = "Desc";
		} else if ("2".equals(temp)) {
			SequenceMdeo = "ASC";
		}
		return SequenceMdeo;
	}
    
	
	
	
	
	
	/**
	 * 执行科室（新的）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrWfExDeptDTO[] GetExeDepts4CiOrSrv(OrWfExDeptParamDTO param) throws BizException {
		if (param == null)
			throw new BizException("param  is null");
		GetExeDepts4CiOrSrvBP bp = new GetExeDepts4CiOrSrvBP();
		return bp.exec(param);
	}

	/**
	 * 执行科室2（新的）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OrWfDeptInfoDTO getExeDepts4CiOrSrvN(OrWfExDeptParamDTO param) throws BizException {
		if (param == null)
			throw new BizException("param  is null");
		GetExeDepts4CiOrSrvNBP bp = new GetExeDepts4CiOrSrvNBP();
		return bp.exec(param);
	}

	/**
	 * 获得剂量单位对象
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public MeasDocDO getMeasDocDOById(String id_measDoc) throws BizException {
		return CiOrdAppUtils.getMeasdocRService().findById(id_measDoc);
	}

	/**
	 * 检查 检验报告的dto
	 * 
	 * @param id_ent
	 * @return OrObsAandLabDTO[]
	 * @throws BizException
	 */
	@Override
	public OrObsAandLabDTO getObsAndLabDto(String id_or, String type) throws BizException {
		// TODO Auto-generated method stub
		getObsAndLabDTOBP bp = new getObsAndLabDTOBP();
		return bp.exec(id_or, type);
	}

	/**
	 * 临床医嘱执行是否为最后一顿判断处理
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrLastMpDTO[] ciOrLastMpJudgeHandle(CiOrLastMpDTO[] param) throws BizException {
		CiOrLastMpJudgeBP bp = new CiOrLastMpJudgeBP();
		return bp.exec(param);
	}

	/**
	 * 医嘱确认查看
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrConfirm[] getCiOrdConfirmedQry(OrConfirm confirm) throws BizException {
		// TODO Auto-generated method stub
		getCiOrdConfirmedBP bp = new getCiOrdConfirmedBP();
		return bp.exec(confirm);
	}

	/**
	 * 主键id生成 （使用）
	 * 
	 * @param size 生成的个数
	 * @return
	 * @throws BizException
	 */
	@Override
	public String[] getOIDs(int size) {
		String[] ids = new DBUtil().getOIDs(size);
		return ids;
	}

	/**
	 * 费用已经划价，没有计费的处方信息(药品 检查 检验)
	 * 
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
	@Override
	public RecipeDTO[] getBlCgRecipeDTO(String[] id_ents) throws BizException {
		getBlCgRecipeDTOBP bp = new getBlCgRecipeDTOBP();
		return bp.exec(id_ents);
	}

	/**
	 * 本次就诊的就诊数组 （诊断编码和诊断名称）
	 * 
	 * @param id_ent
	 * diag[0] = 急性阑尾炎&发热                   诊断名称的拼接
	 * diag[1] =  K35.902&R50.901   诊断编码的 拼接
	 * diag[2] =  001A0000003&011A0000004    子项目id的拼接
	 * diag[3] =  001A0000003   主诊断  
	 * diag[4] =   主诊断           名称
     * diag[5] =   Bd中诊断定义id 遗留问题，后续业务确定使用定义诊断，还是使用业务中诊断
	 * diag[6] =     慢性病标识，有慢性病是存的是慢性病的 编码（K35.902），无慢性病时 是 null
	 * diag[7] =  001A0000003   主诊断的主项目    id
	 * @throws BizException
	 */
	@Override
	public String[] getDiagArray(String id_ent) throws BizException {
		return CiOrdUtils.getDiag(id_ent);
	}
	/**
	 * 本次就诊的就诊数组 （诊断编码和诊断名称）
	 * 
	 * @param id_ent
	 * list[0] = 急性阑尾炎&发热                   诊断名称的拼接
	 * list[1] =  K35.902&R50.901   诊断编码的 拼接
	 * list[2] =  001A0000003&011A0000004    子项目id的拼接
	 * list[3] =  001A0000003   主诊断     
	 * @throws BizException
	 */
	@Override
	public FArrayList2 getDiagList(String id_ent)throws BizException{
			 return CiOrdUtils.getDiagList(id_ent);
		 }
 
	/**
	 * 医嘱复制
	 */
	public int CopyCiOrd(String[] ordIds) {

		return 0;
	}

	/**
	 * 未计费的医嘱信息
	 * 
	 * @param id_or
	 * @return UnchargeOrdSrvDTO[]
	 * @throws BizException
	 */
	@Override
	public UnchargeOrdSrvDTO[] getUnchargeOrderSrv(String id_or) throws BizException {
		UnchargeOrderSrvBP bp = new UnchargeOrderSrvBP();
		return bp.exec(id_or);
	}

	/**
	 * 多模板保存医嘱接口
	 * 
	 * @param envinfo 上下文患者信息
	 * @param ortplItemDO 模板信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public MoreEmsParamDTO getMoreEmsParamDTO(CiEnContextDTO envinfo, OrTplNItmDO[] ortplItemDO) throws BizException {
		getMoreEmsParamDTOBP bp = new getMoreEmsParamDTOBP();
		return bp.exec(envinfo, ortplItemDO);
	}

	/**
	 * 药品处方信息
	 * 
	 * @param Id_pres
	 * @return RecipeDTO[]
	 * @throws BizException
	 */
	@Override
	public RecipeDTO[] getRecipeDTOByIdPres(String[] Id_pres) throws BizException {
		getRecipeDTOByIdPresBP bp = new getRecipeDTOByIdPresBP();
		return bp.exec(Id_pres);
	}

	/**
	 * （药品之外的 检查检验 等 ）处方信息
	 * 
	 * @param code_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public RecipeDTO[] getRecipeDTOByCodeOr(String[] code_ors) throws BizException {
		getRecipeDTOByCodeOrBP bp = new getRecipeDTOByCodeOrBP();
		return bp.exec(code_ors);
	}

	/**
	 * 获取就诊历史中医嘱转换的就Ciems模板
	 * 
	 * @param ordIds 医嘱id集合
	 * @param bannerDTO banner对象
	 * @return
	 * @throws BizException
	 */
	public MoreEmsParamDTO getHistoryMoreEmsParam(String[] ordIds, CiEnContextDTO ciEnContext)
			throws BizException {
		CiOrderCopyBP bp = new CiOrderCopyBP(ordIds, ciEnContext);
		return bp.exec();
	}
	
	/**
	 * 医嘱复制（多医疗单）
	 * @param ordIds
	 * @param ciEnContext
	 * @return
	 * @throws BizException
	 */
	public MoreEmsParamDTO getCiEmsCopyByOrdIds(String[] ordIds, CiEnContextDTO ciEnContext) throws BizException{
		
		IpCiOrderCopyBP bp2 = new IpCiOrderCopyBP(ordIds, ciEnContext);
		return bp2.exec();
	}
	
	/**
	 * 根据组套中的医疗服务、医嘱模板获取界面展现的CiEmsDTO
	 * @param mkrMsSrvDOList 组套中服务集合
	 * @param mkrMsMrtplDOList 组套中医嘱模板集合
	 * @param bannerDTO banner对象
	 * @return 保存结果
	 * @throws BizException
	 */
	@Override
	public MoreEmsParamDTO getMkrMsMoreEmsParam(FArrayList mkrMsSrvDOList, FArrayList mkrMsMrtplDOList, Ent4BannerDTO bannerDTO) throws BizException{
		
		CiOrderAndOrtmplCopyBP bp = new CiOrderAndOrtmplCopyBP(mkrMsSrvDOList, mkrMsMrtplDOList, bannerDTO);
		return bp.exec();
	}

	/**
	 * 获取合理用药使用的CiEmsDTO对象
	 * 
	 * @param ordIds 医嘱id
	 * @param bannerDTO
	 * @return 本次就诊的已签署的药品医嘱以及ordIds 对应的医嘱
	 * @throws BizException
	 */
	public OrdRationalDrugDTO[] getRationalDrugDTOs(Ent4BannerDTO bannerDTO, String[] ordIds) throws BizException {
		
		GetRationalDrugBP bp = new GetRationalDrugBP();
		return bp.exec(bannerDTO, ordIds);
	}

	@Override
	public DiagTreatViewRntDataDTO getDiagTreatViewData(OrSrvSplitParamDTO orparams) throws BizException {
		// TODO Auto-generated method stub
		getDiagTreatViewDataBP bp=new getDiagTreatViewDataBP();
		return bp.exe(orparams);
	}

	

	/**
     * 模板项目显示（新）
     * @param id_ortmpl
     * @return
     * @throws BizException
     */
	@Override
    public   NewOrderTemplateDTO[] getNewOrderTemplateDTO(String id_ortmpl)throws BizException{
		return IPGetSrvortplitemAggDOSBP.getInstance().getNewOrderTemplateDTO(id_ortmpl);
	}
	
	 /**
     * 查询医嘱、服务、物品集合对象
     * @param id_en 就诊id
     * @param start 开始时间
     * @param end 结实时间
     * @return
     * @throws BizException
     */
	@Override
	public FArrayList2 getCiorderDTOs(String id_pat,FDateTime start,FDateTime end)throws BizException{
		
		HpQryCiorderBP bp = new HpQryCiorderBP();
		return bp.exec(id_pat, start, end);
	}
  
	/**
     * id_srv 是套id
     * @param id_srv
     * @return MedSrvSetItemDO 套内项目集合
     * @throws BizException
     */
	@Override
    public   MedSrvSetItemDO[] getMedSrvSetItemDO(String id_srv)throws BizException{
		GetMedSrvSetItemBP bp = new GetMedSrvSetItemBP();
		return bp.exec(id_srv);
	}
	/**
	 * 医保适应症查询
	 * @param id_srv
	 * @param id_mm
	 * @param ciEnContextDTO
	 * @return
	 */
	@Override
	public BdHpIndicDTO getBdHpIndicationDTO(String id_srv,String id_mm,CiEnContextDTO ciEnContextDTO)throws BizException{
		BdHpIndicationDTO[] bdhpdtos = HpService.getMedSrvHpService(id_srv,id_mm, ciEnContextDTO);
		if(CiOrdUtils.isEmpty(bdhpdtos)) return null;
		BdHpIndicDTO hpindic = new BdHpIndicDTO();
		hpindic.setCode_hpindicjudged(bdhpdtos[0].getCode_hpindicjudged());
		hpindic.setId_hp(bdhpdtos[0].getId_hp());
		hpindic.setId_hpsrvtp(bdhpdtos[0].getId_hpsrvtp());
		hpindic.setSd_hpsrvtp(bdhpdtos[0].getSd_hpsrvtp());
		hpindic.setFg_indic(bdhpdtos[0].getFg_indic());
		hpindic.setDes_hplimit(bdhpdtos[0].getDes_hplimit());
		return hpindic;
	}
	/**
	 * 医保适应症查询
	 * @param id_srv
	 * @param id_mm
	 * @param ciEnContextDTO
	 * @return
	 */
	@Override
	public BdHpIndicDTO[] getBdHpIndicationDTOs(String[] id_srvs,String[] id_mms,CiEnContextDTO ciEnContextDTO)throws BizException{
		BdHpIndicationDTO[] bdhpdtos = HpService.getMedSrvHpService(id_srvs,id_mms, ciEnContextDTO);
		if(CiOrdUtils.isEmpty(bdhpdtos)) return null;
		BdHpIndicDTO[] hpindics = new BdHpIndicDTO[bdhpdtos.length];
		for(int i=0;i<hpindics.length;i++){
			String dojson = bdhpdtos[i].serializeJson();
			hpindics[i] = new BdHpIndicDTO();
			hpindics[i].deSerializeJson(dojson);
		}
		return hpindics;
	}
	  /**
     * 查询处方名称和检查检验 等名称 
     * @param id_orsrvs 医嘱的项目id_orsrv
     * @return
     * @throws BizException
     */
	 @Override
     public   FMap2 getPresName(String[] id_orsrvs)throws BizException{
		 GetPresNameBP bp = new GetPresNameBP();
		 return bp.exec(id_orsrvs);
	 }

	 /**
	     * 获取医嘱费用清单
	     * @param id_ent
	     * @param code_entp
	     * @return
	     * @throws BizException
	     */
	@SuppressWarnings("unchecked")
	@Override
	public FMap2 getOrdFeebill(String id_ent, String code_entp) throws BizException {

		String OrderSequenceModel = getOrderSequenceMode();   
		//不包含医技补费的医嘱
		String strSql = "select id_or,code_or,content_or,dt_effe,id_emp_or "
				+ "from ci_order where id_en='%s' and code_entp='%s' and fg_canc='N' "
				+ "and eu_orsrcmdtp not in ('%s') and (eu_feereversetp is null or eu_feereversetp<>1) "
				+ "order by createdtime %s ";
		strSql = String.format(strSql, id_ent, code_entp, OrSourceFromEnum.IIHMEDTECHORDERS, OrderSequenceModel);
		SqlParam sqlParam = new SqlParam();
		DAFacade dAFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiOrderDO> ciOrders = (List<CiOrderDO>) dAFacade.execQuery(strSql, sqlParam, new BeanListHandler(CiOrderDO.class));

		List<String> lstIdors = new ArrayList<String>();
		for (CiOrderDO ord : ciOrders) {
			lstIdors.add(ord.getId_or());
		}
		FMap fMap = getCiEmsDTO(lstIdors.toArray(new String[] {}));

		FArrayList ordList = new FArrayList();
		FArrayList emsList = new FArrayList();
		List<String> idorlist = new ArrayList<String>();
		GetCiOderBlSrvBP blsrvbp = new GetCiOderBlSrvBP();
		for (CiOrderDO ord : ciOrders) {
			idorlist.add(ord.getId_or());
			CiEmsDTO ems = (CiEmsDTO) fMap.get(ord.getId_or());
			ordList.add(ord);
			emsList.add(ems);
		}
		FMap blsrvmap=blsrvbp.getCiordBlSrvByIdors(idorlist.toArray(new String[idorlist.size()]));
		FMap2 rtnMap = new FMap2();
		rtnMap.put("orders", ordList);
		rtnMap.put("emses", emsList);
		rtnMap.put("blsrvdes", blsrvmap);
		return rtnMap;
	}
	
	/**
     * 获取医嘱费用清单
     * @param ems, 医疗单对象
     * @return
     * @throws BizException
     */
	@Override
	public FMap2 getEmsFeebill(CiEmsDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	

	/**2017524新增参数 zwq
     * 保存多医疗单
     * @param szEmsDTO
     * @return error_message : CiEmsDTO
	 * @throws BizException 
     */
	@SuppressWarnings("unchecked")
	@Override
	public FMap2 saveMultiEmsDTO(CiEmsDTO[] szEmsDTO, CiEnContextDTO ctx) throws BizException {
		FMap2 rtnMap = new FMap2();
		ICiOrdMaintainService ordMaintainService = ServiceFinder.find(ICiOrdMaintainService.class);
		int errorIndex = 0;
		for (CiEmsDTO ems : szEmsDTO){
			String errMsg = "";
			try{
				CiOrderDO ord = ordMaintainService.SaveCiEmsDTO(ems,ctx);
				
			}
			catch(BizException e){
				errMsg = e.getMessage().isEmpty()?"未知错误"+errorIndex:e.getMessage();
			}
			catch (Exception e){
				errMsg = e.getMessage().isEmpty()?"未知错误"+errorIndex:e.getMessage();
			}
			finally{
				if (!errMsg.isEmpty()){
					rtnMap.put(errMsg, ems);
				}
			}
		}
		
		return rtnMap.values().size() == 0? null : rtnMap;
	}
	
	/**
     * 获取多医疗单
     * @param szId_ors
     * @param ctx
     * @return 有一项为医疗单数组
     */
	@Override
	public FMap2 getMultiEmsDTO(CiOrderDO[] szOrders, int[] szEmsType, CiEnContextDTO ctx)throws BizException {
		
		GetEmsHandleBP bp = new GetEmsHandleBP();
		return bp.exec(szOrders, szEmsType, ctx);
	}
	
	
	 
	
	/**
     * 根据保外诊断的诊断定义id查询关联的医嘱
     * @param id_en 本次就诊id
     * @param id_didef 诊断定义id
     * @return
     */
	public CiOrderDO[] getCiOrdersUsedHpCiDi(String id_en, String id_didef) throws BizException {

		if (StringUtils.isBlank(id_en) || StringUtils.isBlank(id_didef)){
			new BizException("parameter id_en  is null");
		}
	 
		CiOrdersUsedHpCidiQry qry = new CiOrdersUsedHpCidiQry(id_en, id_didef);
		CiOrderDO[] rtn = (CiOrderDO[]) AppFwUtil.getDORstWithDao(qry, CiOrderDO.class);
		return rtn;

	}

		

    /**
     * 协定处方tree  dto
     * @param id_temp
     * @return
     */
	 @Override
	 public Medicalroutinetreedto[] getPrescriptionTree(String id_temp)throws BizException{
		 PrescriptionTreeBP bp = new PrescriptionTreeBP();
		 return bp.getPresCriptionDTO(id_temp);
				 
	 }
	 
	 /**
	     * 协定处方tree  dto
	     * @param type 
	     * @return
	     */
		 @Override
		 public Medicalroutinetreedto[] getPrescriptionTreeNew(String id_temp)throws BizException{
			 PrescriptionTreeBP bp = new PrescriptionTreeBP();
			 return bp.getPresCriptionDTONew(id_temp);
					 
		 }
		 
	 
	 
   /**
     * 住院多医疗单的 参数
     * @return
     * 住院多医疗单的0  仅生成医疗单UI数据（非自动生成医嘱模式）  ,   1  后台自动生成医嘱模式
     * @throws BizException
	 */
	 @Override
	public String getCiOrAssMultiEmsHandleMode()throws BizException{
		 return ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_CiOrAssMultiEmsHandleMode);
	}

   @Override
   public DiagTreatKeyPointRntDataDTO[] getDiagTreatKeyPointData(String id_en, FDateTime start, FDateTime end) throws BizException {
	// TODO Auto-generated method stub
	   getDiagTreatKeyPointDataBP bp=new getDiagTreatKeyPointDataBP();
	 return bp.exe(id_en, start, end);
   }

	@Override
	public DiagTreatKeyPointRntDataDTO[] getDiagTreatDataBPNew(String id_en, FDateTime start, FDateTime end, String viewmod) throws BizException {
		// TODO Auto-generated method stub
		getDiagTreatDataNewBP bp=new getDiagTreatDataNewBP();
		return bp.exe(id_en, start, end, viewmod);
	}
	
	/**
	 * 判断医嘱状态是否改变
	 * @param orders
	 * @return FBoolean
	 * @throws BizException
	 */
	@Override
	public  String JudgeOrderStatus(CiOrderDO[] orders)throws BizException{
		JudgeOrderStatusBP bp = new JudgeOrderStatusBP();
		return bp.exe(orders);
	}
	
	 /**
     * 多用户操作下的医嘱状态校验
     * @param orders
     * @param id_dep_phy
     * @return 
     * @throws BizException
     */
    public FMap2 JudgeOrderStatusInMultiUser(CiOrderDO[] orders,String id_dep_phy,String id_dep_nur,String validateType) throws BizException{
    	JudgeOrderStatusInMultiUserBP bp = new JudgeOrderStatusInMultiUserBP();
    	return bp.exec(orders,id_dep_phy,id_dep_nur,validateType);
    }
    /**
     * 判断患者的就诊状态和执行科室的变化
     * 患者的就诊状态发生改变（已出院），提示患者已出院
     * @param code_entp
     * @param id_ent
     * @param id_dep_phy 前台传来的就诊科室
     * @return 
     * @throws BizException
     */
    public FBoolean JudgeEntStatusValidate(String code_entp,String id_ent,String id_dep_phy) throws BizException{
    	if(CiOrdUtils.isEmpty(code_entp)||CiOrdUtils.isEmpty(id_ent)||CiOrdUtils.isEmpty(id_dep_phy)) return null;
		CiOrOpenEntStatusValidateBP bp = new CiOrOpenEntStatusValidateBP();
		bp.exec(code_entp, id_ent, id_dep_phy,null);
		return FBoolean.TRUE;
    }
	/**
	 * banner临床路径信息
	 * @param ID_ENT
	 * @param id_cpapp
	 * @return
	 * @throws BizException
	 */
	@Override
	public String[] getHpcpBannerInfo(String ID_ENT, String id_cpapp)throws BizException{
		HpcpBannerInfoBP bp = new HpcpBannerInfoBP();
		return bp.exec(ID_ENT, id_cpapp);
	}
	/**
	 * 判断开始和结束日期之间是否有有效执行顿数
	 * @param dts
	 * @param id_freq
	 * @throws BizException
	 */
	public void judgeBeginEndTimeHasMpTimes(FDateTime begin,FDateTime end,String id_freq) throws BizException{
		JudgeBeginEndTimeHasMpTimes mpBP = new JudgeBeginEndTimeHasMpTimes();
		mpBP.exec(new FDateTime[]{begin,end}, id_freq);
	}
	
	/**
	 * 获取就诊历史医嘱列表数据集合
	 * @param id_en 就诊id
	 * @param code_entp 就诊类型编码
	 * @param orderStr 排序字段
	 * @return 医嘱map结构，包含两项，ciOrderList 医嘱list集合，ciOrderPriMap 医嘱id与价格的map集合
	 * @throws BizException
	 */
	@Override
	public FMap2 getEnHistoryCiOrders(String id_en, String code_entp, String orderStr) throws BizException {

		GetEnHistoryCiOrdersBP bp = new GetEnHistoryCiOrdersBP();
		return bp.exec(id_en, code_entp, orderStr);
	}

	@Override
	public FMap2 getPatEntFeesCensus(String id_en, String code_entp, FBoolean fg_pres_outp) throws BizException {
		GetPatEntFeesCensusBP census = new GetPatEntFeesCensusBP();
		return census.exec(id_en, code_entp, fg_pres_outp);
	}
	
	/**
	 * 医保共享参数 是否启用医保共享
	 * @param id_org
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	@Override
	public  FBoolean getIsDeptOrDatumshared(String id_org,String id_dept)throws BizException{
		return CiOrParamUtils.getIsDeptEnableOrDatumShared(id_org, id_dept);
	}
	
  /**
    *
    * @param id_dept  模板所属科室
    * @param id_emp   模板所属个人
    * @param sd_tp  模板类型
    * @return
    * @throws BizException
    */
	@Override
   public   FMap getTemplateClassIfication(String en_entp,String id_dept,String id_emp,String sd_tp)throws BizException{
		getTemplateClassIficationBP bp =new getTemplateClassIficationBP();
		return bp.getTemplateClassIfication(en_entp,id_dept, id_emp, sd_tp);
	}

	/**
     * 模板项目显示（20170510改造）
     * @param id_ortmpl
     * @return FMap2
     * @throws BizException
     */
	 @Override
    public   FMap getNewOrderTemplateDTO2(String[] id_ortmpl,CiEnContextDTO ctx)throws BizException{
		 if(id_ortmpl == null || id_ortmpl.length==0) return null;
		 getSrvortplitemAggDOSBP bp = new getSrvortplitemAggDOSBP(ctx);
		 return bp.getNewOrderTemplateDTO2(id_ortmpl);
	     
	 }
	 /**
	  * 从缓存中查询模板数据，缓存不存在查询数据库
	  */
	 public OrderTemplateRstDTO getOrTemplateCache(String[] id_ortmpl,CiEnContextDTO ctx) throws BizException{
		 GetSrvortplitemAggDOSCacheBP bp = new GetSrvortplitemAggDOSCacheBP();
		 return bp.exec(id_ortmpl, ctx);
	 }
		 
	/**
	 * 判断服务是否可开立
	 * 
	 * @param ordSrvChangedInfoDTOs传入对象集合 （id_srv,id_mm）
	 * @param code_entp 就诊类型
	 * @return FMap2，不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示）
	 * @throws BizException
	 */
	@Override
	public FMap2 JudgeOrdChangedSrv(OrdSrvChangedInfoDTO[] ordSrvChangedInfoDTOs, String code_entp)
			throws BizException {
		OrdChangedSrvValidateBP validateBP = new OrdChangedSrvValidateBP();
		return validateBP.exec(ordSrvChangedInfoDTOs, code_entp);
	}

	/**
	 * 判断服务是否可开立
	 * @param code_entp 就诊类型
	 * @param medSrvDOs 待判断服务对象数组
	 * @return FMap2，不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示）
	 * @throws BizException
	 */
	@Override
	public FMap2 JudgeOrdChangedSrv1(String code_entp, MedSrvDO[] medSrvDOs) throws BizException{
		OrdChangedSrvValidateBP validateBP = new OrdChangedSrvValidateBP();
		return validateBP.exec(code_entp, medSrvDOs);
	}
 
	
	/**
	 * 就诊 未计费和计费的医嘱项目
	 * @param id_ent
	 * @param sd_su_bl
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrescriptionConstBaseDto getPrescriptionConstAccounting(String id_ent, String[] sd_su_bl) throws BizException {
		if (id_ent == null )
			throw new BizException(" parameter id_ent is null  ");
		PrescriptionConstAccountingBP bp = new PrescriptionConstAccountingBP();
		return bp.exec(id_ent, sd_su_bl);
	}

	/**
     * 助手开立医嘱的个数限制设置
     * @param id_org
     * @return
     * @throws BizException
     */
	@Override
	public int  getOrHelperOpenOrCountLimitSet()throws BizException{
		String id_org  =  CiOrdAppUtils.getEnvContext().getOrgId(); 
		return CiOrParamUtils.getOrHelperOpenOrCountLimitSet(id_org);
	}
	
	/**
	 * 本院的医嘱共享数据查询 
	 * @param id_pat
	 * @param id_hp
	 * @return
	 * @throws BizException
	 */
	 @Override
	public  MedicalSharingDTO[]  getMedicalSharing(String id_pat,String id_hp)throws BizException{
		 return MedicalSharingBP.getInstance().getMedicalSharing(id_pat, id_hp);
 	 }
	
		/**
		 * 签署时验证医嘱共享医嘱信息
		 * @param id_pat
		 * @param id_hp
		 * @return
		 * @throws BizException
		 */
		 @Override
		public  MedicalSharingDTO[]  getOPenCiOrder(String[] id_or,String id_pat,String id_hp)throws BizException{
			 if(id_or== null) return null;
			 return MedicalSharingBP.getInstance().getOpenCiOrder(id_or, id_pat, id_hp);
	 	 }
	 
	 
	 
	 /**
	 	 * 外配处方
	 	 * 
	 	 * @param patid 患者id
	 	 * @param dtSignB 开始时间
	 	 * @param dtSignE 结束时间
	 	 * @param code_entp 就诊类型
	 	 * @param Id_org 就诊机构
	 	 * @return
	 	 * @throws BizException
	 	 */
	 	@Override
	 	public PrescriptionConstBaseDto getExtdispenseDto(String patid, FDateTime dtSignB, FDateTime dtSignE,
	 			String code_entp, String Id_org) throws BizException {
	 		if (patid == null || code_entp == null || Id_org == null)
	 			throw new BizException(" parameter patid or code_entp  or  Id_org is null  ");
	 		return getExtdispenseDtoBP.getInstance().getExtdispenseDto(patid, dtSignB, dtSignE, code_entp, Id_org);
	 	}
	 	
	 	/**
	 	 * 物品和服务的对应关系
	 	 * @param id_ors
	 	 * @return  id_orsrv ，Name_mm
	 	 * @throws BizException
	 	 */
	 	public  FMap2 getMMName(String[] id_ors)throws BizException{
	 		 if(id_ors== null) return null;
			 return MedicalSharingBP.getInstance().getMMName(id_ors);
	 	}
	 	/**
		 * 查询末次病程记录
		 * @param idEnt 就诊id
		 * @return
		 * @throws BizException
		 */
		@Override
		public FMap2 getCiMrCourseOfLastDisease(String idEnt,FBoolean firstMr) throws BizException{
			FMap2 map = CiOrdAppUtils.getCiMrOutQryServices().getCiMrCourseOfLastDisease(idEnt,firstMr);
			return map;
		}
		/**
		 * 判断是否是自费诊断
		 * @param id_didef
		 * @return
		 * @throws BizException
		 */
		
		 @Override
		public  String getUsedHpdiexpensese(String id_en, String Id_didef)throws BizException{
			 getUsedHpdiexpenseseBP bp = new getUsedHpdiexpenseseBP();
			 return bp.JudgeOwnExpenseDiag(id_en, Id_didef);
		}
	 
	/**
	 * 判定是否医保特殊病
	 * 
	 * @param idhp
	 * @param idpat
	 * @param iddiDefs
	 * @return
	 * @throws BizException
	 */
	public FMap isPatSpecDi(String idhp, String idpat, String[] idDiDefs)
			throws BizException {
		IBlHpOutQryService service = ServiceFinder.find(IBlHpOutQryService.class);
		return service.isPatSpecDi(idhp, idpat, idDiDefs);
	}
	
	/**
	 * 判定是否自费诊断
	 * @param idhp
	 * @param sdentp
	 * @param iddiDefs
	 * @return
	 * @throws BizException
	 */
	public FMap isSelfPaidDi(String idhp, String sdentp, String[] idDiDefs)
			throws BizException {
		IBdHpQryService service = ServiceFinder.find(IBdHpQryService.class);
		Map<String, FBoolean> map = service.isSelfPaidDi(idhp, sdentp, idDiDefs);
		FMap fMap = new FMap();
		if (map != null && map.size() > 0) {
			for (String key : map.keySet()) {
				fMap.put(key, map.get(key));
			}
		}
		return fMap;
	}
     
	 @Override
	 public  EmsOrDrug  getHPIndiccation(String id_srv,String id_mm,CiEnContextDTO ctx)throws BizException{
		 EmsOrDrug  drug = new EmsOrDrug();
		 FArrayList list = new FArrayList();
		 Map<String,BdHpIndicationDTO> tmpBdHpIndicationDTOCache= HpService.getMedSrvHpService(new MedSrvHpParam[]{new MedSrvHpParam(id_srv,id_mm)},ctx);
			 if (tmpBdHpIndicationDTOCache != null && tmpBdHpIndicationDTOCache.size() > 0 ) {
					BdHpIndicationDTO hpIndiccation = (BdHpIndicationDTO)tmpBdHpIndicationDTOCache.values().toArray()[0];
					
					drug.setFg_treat(hpIndiccation.getFg_indic());
					drug.setFg_selfpay(drug.getSd_srvtp() != null && drug.getSd_srvtp().startsWith("0103")?FBoolean.FALSE:
						(CiOrdUtils.isTrue(hpIndiccation.getFg_indic())?FBoolean.FALSE:FBoolean.TRUE));
					
					int model = CiOrParamUtils.getMedInsuranceIndicInfoModelSet(ctx.getId_org());
					if(model==2){
						drug.setLimit("医保限制条件："+CiOrdUtils.IsNull(hpIndiccation.getDes_hplimit())+"\n  院内限制条件："+ CiOrdUtils.IsNull(hpIndiccation.getDes_hislimit()));
					}else if(model==1){
						drug.setLimit("院内限制条件："+ CiOrdUtils.IsNull(hpIndiccation.getDes_hislimit()));
					}else{
						drug.setLimit(hpIndiccation.getDes_hplimit());
					}
					
					drug.setId_hp(ctx.getId_hp());
					drug.setSd_hpsrvtp(hpIndiccation.getSd_hpsrvtp());
					drug.setId_hpsrvtp(!CiOrdUtils.isEmpty(drug.getSd_hpsrvtp())?CiOrdUtils.idHpSrvtpFromSdHpSrvtp(drug.getSd_hpsrvtp()):null);
					drug.setFg_hpindicjudged(CiOrdUtils.getFg_hpindicjudged(hpIndiccation));
					drug.setBdHpIndicationDTO(new FArrayList().append(hpIndiccation));
		 }
		 return drug;
	 }
	
	  /**
	   * 验证医保关系
	   * @param id_ent
	   * @param id_hp
	   * @param id_srvs
	   * @return
	   * @throws BizException
	   */
	  public FMap  ValidateOrderAndDiag(String id_ent,String id_hp,String[] id_srvs)throws BizException{
		  ValidateOrderAndDiagBP bp = new ValidateOrderAndDiagBP();
	      return bp.getValidateOrderAndDiag(id_ent, id_hp, id_srvs);
	  }

	public List<MedicalSharingDTO> getRepeatMessageOrder(String id_or,CiEnContextDTO ctx){
		
		return null;
	}

	 /**
	   * 医疗单保存前校验
	   * @param param
	   * @return
	   * @throws BizException
	   */
	@Override
	public CheckRstDTO checkEmsBeforSave(CheckParamDTO param)
			throws BizException {
		CheckEmsBeforSaveBP bp=new CheckEmsBeforSaveBP();
		return bp.exec(param);
	} 
	
	/**
	 * 多就诊查询诊断集合
	 * @param id_ents
	 * @return  Map<String,List>  
	 * @throws BizException
	 */
	@Override
	public   Map<String,List> getDiagItemMap(String[] id_ents) throws BizException {
		if(id_ents== null || id_ents.length == 0) return null;
		Map<String,List> map =new HashMap<String,List>();
		for(String iden:id_ents){
		 	List list = new ArrayList();
			CidiagAggDO[] agg = CiOrdAppUtils.getICidiagQryService().getLastCiDiags(iden);
			for(CidiagAggDO aggDO:agg){
				for(CiDiagItemDO item:aggDO.getCiDiagItemDO()){
					list.add(item);
				}
			}
			map.put(iden,list);
		}
		return map;
    }
	
	
}
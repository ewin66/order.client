package iih.ci.ord.s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import com.founder.xap.runtime.msys.ModuleContext;
import com.founder.xap.runtime.msys.ModuleContextAware;

import iih.bd.srv.ortpl.d.SrvortplitemAggDO;
import iih.ci.ord.cfg.dto.validatecondition.d.MedSrvValidateConditionDTO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordrptbttestAggDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciordems.d.AddFeeDTO;
import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.d.ImplVtDTO;
import iih.ci.ord.dto.d.OrSuModRtnInfoDTO;
import iih.ci.ord.dto.orsrvadd.d.OrSrvAddDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.OrSplitDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.SrvSplitDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.WriteBackOrDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.WriteBackOrSrvDTO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.reportstatus.d.ReportStatusDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.CiOrderTransMissionDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.idvproperty.d.IdVProperty;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.AgainSaveOrderBP;
import iih.ci.ord.s.bp.CiOPAgainPresBP;
import iih.ci.ord.s.bp.CiOrderCancChkBP;
import iih.ci.ord.s.bp.CiOrderCancelBP;
import iih.ci.ord.s.bp.CiOrderCheckBP;
import iih.ci.ord.s.bp.CiOrderFeeDeleteBP;
import iih.ci.ord.s.bp.CiOrderFeeSaveBP;
import iih.ci.ord.s.bp.CiOrderSCSCheckBP;
import iih.ci.ord.s.bp.CiOrderSignBP;
import iih.ci.ord.s.bp.CiOrderSignBackBP;
import iih.ci.ord.s.bp.CiOrderSignStep1BP;
import iih.ci.ord.s.bp.CiOrderStopBP;
import iih.ci.ord.s.bp.CiOrderStopChkBP;
import iih.ci.ord.s.bp.CiOrderUpdateHpCiDiBP;
import iih.ci.ord.s.bp.GetCiOderBlSrvBP;
import iih.ci.ord.s.bp.GetOpPreCalcFeeRstBP;
import iih.ci.ord.s.bp.GetPrintChargesDetailsBP;
import iih.ci.ord.s.bp.ImplVtBP;
import iih.ci.ord.s.bp.OrTplItemSaveBP;
import iih.ci.ord.s.bp.RelDeleteOrderBP;
import iih.ci.ord.s.bp.SaveCheckPatInfoBP;
import iih.ci.ord.s.bp.SaveCompleteConsultAggDOBP;
import iih.ci.ord.s.bp.SaveHealthCheckReportBP;
import iih.ci.ord.s.bp.SaveOrAppConsultAggDOBP;
import iih.ci.ord.s.bp.UpdateCiOrSrvDtLastBlBP;
import iih.ci.ord.s.bp.UpdateOrdMpInfoBP;
import iih.ci.ord.s.bp.UpdateOrdStatusInfo0BP;
import iih.ci.ord.s.bp.UpdateOrderSdMpBP;
import iih.ci.ord.s.bp.setOrcontentSkinTestBP;
import iih.ci.ord.s.bp.setOrderRefundBillCancelReserveBP;
import iih.ci.ord.s.bp.setPresWIndowNoBP;
import iih.ci.ord.s.bp.ems.CiOrEmsSaveBP;
import iih.ci.ord.s.bp.emsnew.CiOrEmsSaveBPNew;
import iih.ci.ord.s.bp.ordbttest.GetBtTestInfoBp;
import iih.ci.ord.s.bp.ordbttest.OrdBtTestSaveBp;
import iih.ci.ord.s.bp.ordfeebill.OrdFeeBillHandleBP;
import iih.ci.ord.s.bp.orsrvsplit.IpDrugDispenseAppSaveBP;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.reportstatus.UpdateReportStatusBp;
import iih.ci.ord.s.bp.updatestatus.UpdateOrsrvStatusBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FBinary;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.scheduler.itf.ISchedulerServiceAPI;

/**
 * 医嘱的修改保存删除类（自定义）
 * 
 * @ClassName: CiOrdMaintainServiceImpl
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年5月21日 下午5:43:34
 * @Package iih.ci.ord.s Copyright: Copyright (c) 2011 Company: 北大医疗信息技术有限责任公司
 */
@Service(serviceInterfaces = { ICiOrdMaintainService.class }, binding = Binding.JSONRPC)
public class CiOrdMaintainServiceImpl implements ICiOrdMaintainService, ModuleContextAware {

	private ModuleContext moduleContext;
	private Logger logger;

	/*
	 * @Override public void updateOrdMpInfo(DispenseDTO[] preses) throws
	 * BizException { UpdateOrdMpInfoBP bp=new UpdateOrdMpInfoBP();
	 * bp.updateOrdMpInfo(preses); }
	 */

	/**
	 * 费用回写医嘱项目的状态
	 * 
	 * @param addDTOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean UpdateOrdChargeRelInfo2(String[] orsrvids, String id_su_bl, String sd_su_bl, FDateTime dt_last_bl,Integer BLCGCANCEL) throws BizException {
		UpdateOrdMpInfoBP bp = new UpdateOrdMpInfoBP();
		// return bp.UpdateOrdChargeRelInfo(orsrvids,id_su_bl, sd_su_bl);
		return bp.old_WriteBackCiOrSrvInfo(orsrvids, id_su_bl, sd_su_bl, dt_last_bl,BLCGCANCEL);
	}
 
	/**
	 * 费用回写医嘱项目的状态
	 * 
	 * @param addDTOs
	 * @return
	 * @throws BizException
	 */
	@Override
	@Deprecated
	public FBoolean UpdateOrdChargeRelInfo(String[] orsrvids, String id_su_bl, String sd_su_bl, FDateTime dt_last_bl) throws BizException {
		UpdateOrdMpInfoBP bp = new UpdateOrdMpInfoBP();
		// return bp.UpdateOrdChargeRelInfo(orsrvids,id_su_bl, sd_su_bl);
		return bp.WriteBackCiOrSrvInfo(orsrvids, id_su_bl, sd_su_bl, dt_last_bl);
	}
	/**
	 * 
	 */
	@Override
	@Deprecated
	public CiorderAggDO[] SaveEmsHeadDO(EmsHeadDO emsHeadDO, String type) throws BizException {
		// //System.out.println
		// System.out.println(emsHeadDO.getEmsapobs());
		// SetEmsBP bp = new SetEmsBP();
		// return bp.Save(emsHeadDO, type);
		return null;
	}
	
	public CiEmsSrvDTO[] saveOrdFeeBill(CiEmsSrvDTO[] szSrv,CiEnContextDTO ctx)throws BizException{
		
		OrdFeeBillHandleBP bp = new OrdFeeBillHandleBP();
		
		return bp.save(szSrv,ctx);
	}

	/**
	 * 医嘱执行时补录医嘱服务项目
	 * 
	 * @param addDTOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdSrvDO[] insertOrSrvDataWhenPerform(OrSrvAddDTO[] addDTOs) throws BizException {

		if (ArrayUtil.isEmpty(addDTOs))
			return null;

		UpdateOrdMpInfoBP bp = new UpdateOrdMpInfoBP();
		return bp.insertOrSrvDataWhenPerform(addDTOs);

	}

	/**
	 * 住院摆药请领存盘 cn_cgex_ip_save
	 * 
	 * @param param
	 * @param isCharged
	 * @return
	 * @throws BizException
	 */
	@Override
	public Integer ipDrugDispenseAppSave(OrSrvSplitParamDTO param, boolean isCharged) throws BizException {
		IpDrugDispenseAppSaveBP bp = new IpDrugDispenseAppSaveBP();
		return bp.exec(param, isCharged);
	}

	/*
	 * @Override public OrSuModRtnInfoDTO[] updateOrdStatusInfo(String[] id_ors,
	 * FDateTime dt_end, String sd_su_or) throws BizException {
	 * UpdateOrdStatusInfoBP bp=new UpdateOrdStatusInfoBP(); return
	 * bp.exec(id_ors, dt_end, sd_su_or); }
	 */
	/**
	 * 更新临床医嘱状态及相关信息 签署 核对（无补录） 作废 核对作废 停止 核对停止
	 * 
	 * @param id_ors
	 * @param dt_end
	 * @param sd_su_or
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrSuModRtnInfoDTO[] updateOrdStatusInfo(IdVProperty[] id_ors, FDateTime dt_end, String sd_su_or) throws BizException {
		UpdateOrdStatusInfo0BP bp = new UpdateOrdStatusInfo0BP();
		return bp.exec(id_ors, dt_end, sd_su_or);
	}

	/**
	 * 医嘱保存
	 * 
	 * @param ciEmsDTO
	 * @return CiOrderDO
	 * @throws BizException
	 */
	@Override
	public CiOrderDO SaveCiEmsDTO(CiEmsDTO ciEmsDTO,CiEnContextDTO CiEnContext) throws BizException {
		//CiEnContextDTO 存放在上下文信息中
		Context.get().setAttribute("CiEnContextDTO", CiEnContext);
		long startTIme = System.currentTimeMillis();
		logger.info("SaveCiEmsDTO  医嘱开始  .." + System.currentTimeMillis() + "毫秒");
		CiOrEmsSaveBP bp = new CiOrEmsSaveBP();
		CiorderAggDO agg = bp.exec(ciEmsDTO);
		logger.info("SaveCiEmsDTO 结束 耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		
		 return agg.getParentDO();
		//return Medicalinfo(agg,CiEnContext);
	}
	
	 
	
	
	/**
	 * 医嘱保存提示信息后保存
	 * 
	 * @param ciEmsDTO
	 * @return CiOrderDO
	 * @throws BizException
	 */
	public  CiOrderDO SaveCiEmsDTO2(CiOrderDO orderDO,CiEnContextDTO CiEnContext) throws BizException{
		
		return null;
	}

	
	/**
	 * 删除医嘱 和相关的信息
	 * 
	 * @param id_orders
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean relDeleteOrder(String[] id_orders) throws BizException {
		RelDeleteOrderBP bp = new RelDeleteOrderBP();
		return bp.RelDeleteOrder(id_orders);
	}

	/**
	 * 临床医嘱的签署（Step0） 医嘱开始签署时使用
	 * 
	 * @param id_ors
	 *            医嘱id集合
	 * @param ciEnContextDTO
	 *            就诊上下文环境
	 * @return
	 * @throws BizException
	 */
	@Override
	public ValidateRtnInfoDTO ciOrderSign(String[] id_ors, CiEnContextDTO ciEnContextDTO) throws BizException {
		Context.get().setAttribute("CiEnContextDTO", ciEnContextDTO);
		CiOrderSignBP bp = new CiOrderSignBP();
		return bp.exec(id_ors, ciEnContextDTO);
	}

	/**
	 * 
	 * @param map
	 *            医嘱信息
	 * @param Code_entp
	 *            就诊类型
	 * @return
	 */
	@Override
	public ValidateRtnInfoDTO CiOrderSignMedicalInsurance(FMap2 map, String Code_entp) throws BizException {
		CiOrderSignBP bp = new CiOrderSignBP();
		return bp.CiorderSignMedicalInsurance(map, Code_entp);
	}

	/**
	 * 临床医嘱的签署（Step1） 医嘱签署互斥停嘱互动提示后，继续时调用该服务 code_entp 就诊类型
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	@Override
	public ValidateRtnInfoDTO ciOrderSignStep1(FMap2 map, String Code_entp,CiEnContextDTO ciEnContextDTO) throws BizException {
		Context.get().setAttribute("CiEnContextDTO", ciEnContextDTO);
		CiOrderSignStep1BP bp = new CiOrderSignStep1BP();
		return bp.exec(map, Code_entp);
	}

	/**
	 * 临床医嘱的停止
	 * 
	 * @param id_ors
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderStop(String[] id_ors, FDateTime dt_end) throws BizException {
		CiOrderStopBP bp = new CiOrderStopBP();
		return bp.exec(id_ors, dt_end);
	}

	/**
	 * 临床医嘱的签署撤回
	 * 
	 * @param ids
	 *            门诊时为id_en 住院时为id_ors
	 * @param sd_entp
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderSignBack(String[] ids, String sd_entp) throws BizException {
		CiOrderSignBackBP bp = new CiOrderSignBackBP();
		return bp.exec(ids, sd_entp);
	}

	/**
	 * 临床医嘱的核对（签署后的）
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderCheck(String[] id_ors) throws BizException {
		CiOrderCheckBP bp = new CiOrderCheckBP();
		return bp.exec(id_ors);
	}

	/**
	 * 临床医嘱的作废（已核对未执行）
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderCancel(String[] id_ors) throws BizException {
		CiOrderCancelBP bp = new CiOrderCancelBP();
		return bp.exec(id_ors);
	}

	/**
	 * 临床医嘱的作废核对
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderCancChk(String[] id_ors) throws BizException {
		CiOrderCancChkBP bp = new CiOrderCancChkBP();
		return bp.exec(id_ors);
	}

	/**
	 * 临床医嘱的停止核对
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderStopChk(String[] id_ors) throws BizException {
		CiOrderStopChkBP bp = new CiOrderStopChkBP();
		return bp.exec(id_ors);
	}

	/**
	 * 皮试结果写回到医嘱内容中
	 * 
	 * @param id_or
	 * @param skinTest
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO setOrcontentSkinTest(String id_or, String skinTest) throws BizException {
		setOrcontentSkinTestBP bp = new setOrcontentSkinTestBP();
		return bp.exec(id_or, skinTest);
	}

	/**
	 * 停止 签署 作废 状态的核对
	 */
	@Override
	public CiOrderDO[] CiOrderSCSCheck(String[] id_sign_ors, String[] id_canc_ors, String[] id_stop_ors) throws BizException {
		// TODO Auto-generated method stub
		CiOrderSCSCheckBP bp = new CiOrderSCSCheckBP();
		return bp.exec(id_sign_ors, id_canc_ors, id_stop_ors);
	}

	/**
	 * 医嘱确认物品补录保存
	 */
	@Override
	public AddFeeDTO[] CiOrderFeeSave(String id_or, AddFeeDTO[] drugs, Integer sourcein) throws BizException {
		// TODO Auto-generated method stub

		CiOrderFeeSaveBP bp = new CiOrderFeeSaveBP();
		return bp.exe(id_or, drugs, sourcein);
	}

	/**
	 * 医嘱模板保存
	 * 
	 * @param aggdos
	 * @throws BizException
	 */
	@Override
	public void SaveOrTplItem(SrvortplitemAggDO[] aggdos) throws BizException {
		OrTplItemSaveBP bp = new OrTplItemSaveBP();
		bp.exec(aggdos);
	}

	/**
	 * 暂时不用 执行拆分回写医嘱项目最新生成时间
	 * 
	 * @param Id_ors
	 *            医嘱ID
	 * @param Dt_last_bl
	 *            时间
	 * @throws BizException
	 */
	@Override
	public String UpdateCiOrSrvDtLastBl(OrSplitDTO[] orSplit, SrvSplitDTO[] srvSplit) throws BizException {

		if (orSplit == null || orSplit == null)
			throw new BizException("执行拆分回写医嘱项目参数为空！");
		UpdateCiOrSrvDtLastBlBP bp = new UpdateCiOrSrvDtLastBlBP();
		return bp.exe(orSplit, srvSplit);
	}

	/**
	 * 保存会诊信息和会诊状态
	 * 
	 * @param aggs
	 *            会诊的记录信息
	 * @param consultType
	 *            类型 0 应答，1 科室审批，2 医务审批
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiorappconsultAggDO[] SaveOrAppConsultAggDO(CiorappconsultAggDO[] aggdos, String consultType) throws BizException {
		if (aggdos == null)
			return null;
		SaveOrAppConsultAggDOBP bp = new SaveOrAppConsultAggDOBP();
		return bp.exe(aggdos, consultType);
	}

	/**
	 * 执行回写医嘱状态
	 * 
	 * @param id_ors
	 *            医嘱id_ors
	 * @param sd_mptp
	 *            执行状态 1 执行 2 不执行
	 * @param dt_last_mp
	 *            执行时间
	 * @param dt_last_cg
	 *            费用时间
	 * @return
	 * @throws BizException
	 */
	@Override
	public String UpdateOrderSdMp(WriteBackOrDTO[] paramDTOS) throws BizException {
		UpdateOrderSdMpBP bp = new UpdateOrderSdMpBP();
		return bp.exe(paramDTOS);
	}

	/**
	 * 医嘱项目执行状态回写
	 * 
	 * @param parmDTOS
	 * @throws BizException
	 */
	public CiorderAggDO[] UpdateOrderSrvSdMp(WriteBackOrSrvDTO[] paramDTOS) throws BizException {
		UpdateOrsrvStatusBp bp = new UpdateOrsrvStatusBp();

		return bp.exec(paramDTOS);
	}

	/**
	 * 完成会诊
	 * 
	 * @param aggs
	 *            会诊的记录信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiorappconsultAggDO SaveCompleteConsultAggDO(CiorappconsultAggDO[] aggdos) throws BizException {
		if (aggdos == null || aggdos.length == 0)
			throw new BizException("没有会诊信息");

		SaveCompleteConsultAggDOBP bp = new SaveCompleteConsultAggDOBP();
		return bp.exe(aggdos);
	}

	@Override
	public void CiOrderFeeDelete(AddFeeDTO fee) throws BizException {
		// TODO Auto-generated method stub
		CiOrderFeeDeleteBP bp = new CiOrderFeeDeleteBP();
		bp.exe(fee);
	}

	/**
	 * 备血信息查询
	 */
	@Override
	public CiordrptbttestAggDO findApbt(String no_applyForm) throws BizException {
		
		GetBtTestInfoBp bp=new GetBtTestInfoBp();
		
		return bp.exec(no_applyForm);
	}

	/**
	 * 保存、更新备血申请的可用血余量
	 * 
	 */
	@Override
	public CiordrptbttestAggDO saveApbt(CiordrptbttestAggDO aggDO, FBoolean fg_submit) throws BizException {

		OrdBtTestSaveBp bp = new OrdBtTestSaveBp();

		return bp.exec(aggDO, FBoolean.TRUE.equals(fg_submit));
	}

	public CiOrderDO[] saveHealthCheckReport(OrdSrvDO[] orsrvdos, String[] id_ors) throws BizException {
		SaveHealthCheckReportBP bp = new SaveHealthCheckReportBP();
		return bp.exec(orsrvdos, id_ors);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.founder.xap.runtime.msys.ModuleContextAware#setModuleContext(com.
	 * founder.xap.runtime.msys.ModuleContext)
	 */
	@Override
	public void setModuleContext(ModuleContext arg0) {
		// TODO Auto-generated method stub
		this.moduleContext = arg0;
		this.logger = this.moduleContext.getLogger("CI_ORDER.DEBUG");
		this.moduleContext.setLogLevel("CI_ORDER.DEBUG", Level.INFO);
		CiOrdUtils.setLogger(this.logger);
	}

	/**
	 * 更新报告装填和医嘱的结果（检查检验）
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public void UpdateReportAndOrderState(ReportStatusDTO[] params) throws BizException {

		UpdateReportStatusBp bp = new UpdateReportStatusBp();

		bp.exec(params);
	}

	/**
	 * 保存径内径外医嘱报告
	 */
	public void saveCporCheckReport(CiOrderDO[] ciOrderDOs, String[] id_ors) throws BizException {
		if (!CiOrdUtils.isEmpty(id_ors)) {
			this.relDeleteOrder(id_ors);
		}
		if (!CiOrdUtils.isEmpty(ciOrderDOs)) {
			String[] idOrsMod = new String[ciOrderDOs.length];
			int i = 0;
			for (CiOrderDO ciOrdDO : ciOrderDOs) {
				idOrsMod[i++] = ciOrdDO.getId_or();
			}
			CiOrderDO[] orderDODatas = CiOrdAppUtils.getCiorderMDORService().findByBIds(idOrsMod, FBoolean.FALSE);
			for (CiOrderDO ciOrdDo : orderDODatas) {
				for (CiOrderDO ordo : ciOrderDOs) {
					if (ordo.getId_or().equals(ciOrdDo.getId_or())) {
						ciOrdDo.setEu_uncporjudge(ordo.getEu_uncporjudge());
						ciOrdDo.setReason_uncporuse(ordo.getReason_uncporuse());
						ciOrdDo.setStatus(DOStatus.UPDATED);
					}
				}
			}
			CiOrdAppUtils.getOrService().save(orderDODatas);
		}
	}

	@Override
	public void updateCiOrderBhpjudgerst(CiEnContextDTO contextDTO) throws BizException {

		CiOrderUpdateHpCiDiBP bp = new CiOrderUpdateHpCiDiBP(contextDTO);
		bp.execUpdateOrds();
	}

	/***
	 * 毒麻药品签署时保存核对的患者信息
	 * 
	 * @param checkPatInfoSrvs
	 * @param agentInfo
	 * @throws BizException
	 */
	@Override
	public void saveCheckPatInfo(FArrayList checkPatInfoSrvs, OrSrvAgentInfoDO agentInfo) throws BizException {
		SaveCheckPatInfoBP bp = new SaveCheckPatInfoBP();
		bp.exec(checkPatInfoSrvs, agentInfo);
	}
	@Override
	public Integer getTotalTimes(String id_freq, int use_day) throws BizException {
		GetTotalTimesBP bp = new GetTotalTimesBP();
		return bp.getTotalTimes(id_freq, use_day);
	}
	@Override
	public FDouble getMMQuantum(String code_entp, FBoolean fg_pres_outp, int times, String id_mm, String id_unit_sale,
			FDouble quan_medu) throws BizException {
		CalQuantumBP bp = new CalQuantumBP();
		return bp.getMMQuantum(code_entp, fg_pres_outp, times, id_mm, id_unit_sale, quan_medu);
	}

	/**
     * 根据费用id_srv返回费用备注
     * @param idsrvs
     * @return
     * @throws BizException
     */
	@Override
	public FMap getCiOrderBlSrvDesByIdsrvs(String[] idsrvs) throws BizException {
		GetCiOderBlSrvBP bp=new GetCiOderBlSrvBP();
		return bp.getCiordBlSrvByIdsrvs(idsrvs);
	}

	/**
     * 根据医嘱id_or返回费用备注
     * @param idors
     * @return
     * @throws BizException
     */
	@Override
	public FMap getCiOrderBlSrvDesByIdors(String[] idors) throws BizException {
		GetCiOderBlSrvBP bp=new GetCiOderBlSrvBP();
		return bp.getCiordBlSrvByIdors(idors);
	}
	 /**
     * 重新分方
     * @param id_ent
     * @param sd_entp
     * @return
     * @throws BizException
     */
	@Override
    public   CiOrderDO[] CiOPAgainPres(String id_en,String id_dep_sign,String sd_entp,CiEnContextDTO ciEnContextDTO)throws BizException{
		if(id_en ==null || sd_entp== null) return null;
		Context.get().setAttribute("CiEnContextDTO", ciEnContextDTO);
		CiOPAgainPresBP  bp = new CiOPAgainPresBP();
		return  bp.exec(id_en,id_dep_sign,sd_entp,ciEnContextDTO);
	}
	
	/**
     * 记账时 回写处方的窗口号
     * @param map<id_pres,winNo> key 处方号，values 是窗口号
     * @throws BizException
     */
	@Override
    public void setPresWindowNo(Map<String,String> map)throws BizException{
		setPresWIndowNoBP bp = new setPresWIndowNoBP();
		bp.exec(map);
	}
	
	
	/**
	 * 医生站记账
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @param AcctountType 记账类型
	 * @param id_psndoc 当前操作人id
	 * @DmEnumDesc(name="预交金记账",description="预交金记账") public static final String CG_PREPAY="1"; //预交金记账
	 * @DmEnumDesc(name="高端商保记账",description="高端商保记账") public static final String CG_HPCG="2"; //高端商保记账
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public String orderKeepAccounts(String id_ent, String code_entp, String acctountType,String id_psndoc) throws BizException {

		GetOpPreCalcFeeRstBP bp = new GetOpPreCalcFeeRstBP();
		return bp.exec(id_ent, code_entp, acctountType,id_psndoc);
	}

	/**
	 * 医生站销账
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @param AcctountType 记账类型
	 * @DmEnumDesc(name="预交金记账",description="预交金记账") public static final String CG_PREPAY="1"; //预交金记账
	 * @DmEnumDesc(name="高端商保记账",description="高端商保记账") public static final String CG_HPCG="2"; //高端商保记账
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public String cancelOrderAccounting(String id_ent, String code_entp, String id_psndoc) throws BizException {

		// 当前登录医生id		
		String msg = CiOrdAppUtils.getIBLOrderAppendBillService().setRefundBillForCi_ByIdent(id_ent, code_entp, id_psndoc);
		return msg;
	}
	
	
	/**
	 * 高端商保销账
	 * @param idOrs
	 * @param id_psndoc
	 * @param ciEnContextDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public String setOrderRefundBillCancelReserve(String[] idOrs,String id_psndoc,CiEnContextDTO ciEnContextDTO)throws BizException{
		 if(idOrs == null || idOrs.length==0 ||id_psndoc== null || ciEnContextDTO== null)throw new BizException("parammeter is null");
		setOrderRefundBillCancelReserveBP bp = new setOrderRefundBillCancelReserveBP();
		return bp.setOrderRefundBillCancelReserve(idOrs, id_psndoc, ciEnContextDTO);
	}
	/**
	 * 获得打印单费用明细
	 * @param print_no
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrescriptionConstBaseDto getPrintDetailsSrv(String[] print_no,String id_ent)
			throws BizException {
		if(print_no == null || print_no.length==0 )throw new BizException("parammeter is null");
		GetPrintChargesDetailsBP bp =new GetPrintChargesDetailsBP();
		return bp.exe(print_no,id_ent);
	}
	/**
	 * 生命体征预置数据导入
	 * @param vt
	 * @return
	 * @throws BizException
	 */
	public boolean importVt(ImplVtDTO vt) throws BizException{
		ImplVtBP bp = new ImplVtBP();
		bp.exec(vt);
		return true;
	}

	@Override
	public FArrayList checkBdSrvInfo(MedSrvValidateConditionDTO args) throws BizException {
		FMap2 variableValueMap = new FMap2();
		StringBuilder sb = new StringBuilder();
		sb.append(" Id_grp = '").append(args.getId_grp()).append("' ");
		sb.append(" and Id_org = '").append(args.getId_org()).append("' ");
		
		variableValueMap.put("id_grp", args.getId_grp());
		variableValueMap.put("id_org", args.getId_org());
		
		if (null!= args.getSd_srvtp() && !args.getSd_srvtp().isEmpty()){
			String strSdSrvtp = args.getSd_srvtp().replace(",", "','");
			strSdSrvtp = "'" +strSdSrvtp+"'";
			sb.append(" and substr(Sd_srvtp,0,2) in (").append(strSdSrvtp).append(") ");
		}
		variableValueMap.put("where", sb.toString());
		if (args.getFg_update() != null &&  args.getFg_update() == FBoolean.TRUE){
			variableValueMap.put("IsUpdateDB", "1");
		}
		else{
			variableValueMap.put("IsUpdateDB", "0");
		}
		if(args.getFg_active() == FBoolean.TRUE){
			
			variableValueMap.put("IsActive", "1");
		}
		else{
			variableValueMap.put("IsActive", "0");
		}		
		
		ISchedulerServiceAPI api = ServiceFinder.find(ISchedulerServiceAPI.class);
		String taskId =api.submitTask0("BDSrvInfoCheckTask_Param", CiOrdAppUtils.getServerDateTime().addSeconds(3), variableValueMap);		
		//BackgroundWorkUtil.createBgWorkByAlertTypeCode("BDSrvInfoCheckTask_Param", variableValueMap, CiOrdAppUtils.getServerDateTime().addSeconds(3));

		return null;
	}

	public String refreshCheckBdSrvInfo(MedSrvValidateConditionDTO args) throws BizException {
		String path = "M00/00/01/wKhJD1k3hWuEdFQMAAAAAE-tP7s5815157";
		xap.mw.basic.storage.StorageService ss = ServiceFinder.find(xap.mw.basic.storage.StorageService.class);
		FBinary rst = ss.read(path);
		String report = "";
		try {
			report = convertStreamToString(rst.getBody());
		} catch (IOException e) {
			throw new BizException(e.getMessage());
		}
		return report;
	}
	
	private String convertStreamToString(InputStream is) {      
        /*  
          * To convert the InputStream to String we use the BufferedReader.readLine()  
          * method. We iterate until the BufferedReader return null which means  
          * there's no more data to read. Each line will appended to a StringBuilder  
          * and returned as String.  
          */     
         BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
         StringBuilder sb = new StringBuilder();      
     
         String line = null;      
        try {      
            while ((line = reader.readLine()) != null) {      
                 sb.append(line + "\n");      
             }      
         } catch (IOException e) {      
             e.printStackTrace();      
         } finally {      
            try {      
                 is.close();      
             } catch (IOException e) {      
                 e.printStackTrace();      
             }      
         }      
     
        return sb.toString();      
     }

	@Override
	public Integer getDaysAvalidate(String sd_mupakgu,FDouble quan_cur,FDouble quan_medu,FDouble factor,FDouble factor_mb,String id_freq) throws BizException {
		GetTotalTimesBP bp = new GetTotalTimesBP();
		return bp.getDaysAvalidate(sd_mupakgu,quan_cur, quan_medu,factor,factor_mb, id_freq);
	}
	 

    /**
     * 保存时提示信息再次保存 TODO 临时方案，
     *  emstype  医疗单类型
     *   cienConttextDTO 上下文信息
     *   return CiOrderDO
     */
	@Override
    public CiorderAggDO AgainSaveOrder(String emstype,CiEnContextDTO ciEnContextDTO)throws BizException{
		Context.get().setAttribute("CiEnContextDTO", ciEnContextDTO);
		AgainSaveOrderBP bp = new AgainSaveOrderBP();
		return bp.exec();
	}
	/**
	 * 医嘱保存
	 * @param ciEmsDTO
	 * @param CiEnContext
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderTransMissionDTO SaveCiEmsDTONew(CiEmsDTO ciEmsDTO,CiEnContextDTO CiEnContext) throws BizException {
		//CiEnContextDTO 存放在上下文信息中
		Context.get().setAttribute("CiEnContextDTO", CiEnContext);
		long startTIme = System.currentTimeMillis();
		logger.info("SaveCiEmsDTO  医嘱开始  .." + System.currentTimeMillis() + "毫秒");
		CiOrEmsSaveBPNew bp = new CiOrEmsSaveBPNew();
		CiOrderTransMissionDTO transMissionDTO = bp.exec(ciEmsDTO);
		logger.info("SaveCiEmsDTO 结束 耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		 return transMissionDTO;
	}
	/**
	 * 本次就诊下 自费未结算的医嘱
	 */
	public FBoolean getEffective(CiEnContextDTO ctx)throws BizException{
		CiOrderUpdateHpCiDiBP bp = new CiOrderUpdateHpCiDiBP(ctx);
		return bp.getEffectiveOrder(ctx.getId_en());
	}
}

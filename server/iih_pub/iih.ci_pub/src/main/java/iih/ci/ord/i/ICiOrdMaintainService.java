package iih.ci.ord.i;

import java.util.Map;

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
import iih.ci.ord.idvproperty.d.IdVProperty;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public interface ICiOrdMaintainService {
	/**
	 * 执行发退药时，更新处方医嘱执行信息
	 * 
	 * @param preses
	 * @throws BizException
	 */
	/*
	 * public abstract void updateOrdMpInfo(DispenseDTO[] preses) throws
	 * BizException;
	 */

	/**
	 * 更新医嘱及项目记账相关信息
	 * 
	 * @param orsrvids
	 *            医嘱服务项目主键集合
	 * @param id_su_bl
	 *            记账状态
	 * @param sd_su_bl
	 *            记账状态编码
	 * @param Integer BLCGCANCEL 
	 * 1)        记账后，【记账状态】=已记账，冲账类型 =空。
	   2)        销账后，【记账状态】=已退费，冲账类型 =销账。
	   3)        结算后冲账后，【记账状态】=已退费，冲账类型 =结算后冲账。

	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean UpdateOrdChargeRelInfo2(String[] orsrvids, String id_su_bl, String sd_su_bl, FDateTime dt_last_bl,Integer BLCGCANCEL) throws BizException;

	/**
	 * 医嘱保存
	 * 
	 * @param emsHeadDO
	 * @return
	 * @throws BizException
	 */
	public abstract CiorderAggDO[] SaveEmsHeadDO(EmsHeadDO emsHeadDO, String type) throws BizException;

	/**
	 * 保存费用清单
	 * 
	 * @param szSrv
	 * @return
	 * @throws BizException
	 */
	public CiEmsSrvDTO[] saveOrdFeeBill(CiEmsSrvDTO[] szSrv,CiEnContextDTO ctx) throws BizException;

	/**
	 * 医嘱执行时医嘱服务补录项目
	 * 
	 * @param addDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract OrdSrvDO[] insertOrSrvDataWhenPerform(OrSrvAddDTO[] addDTOs) throws BizException;

	/**
	 * 住院摆药请领存盘 cn_cgex_ip_save
	 * 
	 * @param param
	 * @param isCharged
	 * @return
	 * @throws BizException
	 */
	public abstract Integer ipDrugDispenseAppSave(OrSrvSplitParamDTO param, boolean isCharged) throws BizException;

	/**
	 * 更新临床医嘱状态及相关信息 签署 核对（无补录） 作废 核对作废 停止 核对停止
	 * 
	 * @param id_ors
	 * @param dt_end
	 * @param sd_su_or
	 * @return
	 * @throws BizException
	 */
	// public abstract OrSuModRtnInfoDTO[] updateOrdStatusInfo(String[]
	// id_ors,FDateTime dt_end,String sd_su_or) throws BizException;

	/**
	 * 更新临床医嘱状态及相关信息 签署 核对（无补录） 作废 核对作废 停止 核对停止
	 * 
	 * @param id_ors
	 * @param dt_end
	 * @param sd_su_or
	 * @return
	 * @throws BizException
	 */
	public abstract OrSuModRtnInfoDTO[] updateOrdStatusInfo(IdVProperty[] id_ors, FDateTime dt_end, String sd_su_or) throws BizException;
    
	
	/**
	 * 更新医嘱及项目记账相关信息
	 * 
	 * @param orsrvids
	 *            医嘱服务项目主键集合
	 * @param id_su_bl
	 *            记账状态
	 * @param sd_su_bl
	 *            记账状态编码
	        

	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public abstract FBoolean UpdateOrdChargeRelInfo(String[] orsrvids, String id_su_bl, String sd_su_bl, FDateTime dt_last_bl) throws BizException;

	/**
	 * 医嘱保存
	 * 
	 * @param ciEmsDTO
	 * @return CiOrderDO
	 * @throws BizException
	 */
	public abstract CiOrderDO SaveCiEmsDTO(CiEmsDTO ciEmsDTO,CiEnContextDTO CiEnContext) throws BizException;
	/**
	 * 医嘱保存提示信息后保存
	 * 
	 * @param ciEmsDTO
	 * @return CiOrderDO
	 * @throws BizException
	 */
	public abstract CiOrderDO SaveCiEmsDTO2(CiOrderDO orderDO,CiEnContextDTO CiEnContext) throws BizException;

	
	/**
	 * 删除医嘱 和相关的信息
	 * 
	 * @param id_orders
	 * @return
	 * @throws BizException
	 */
	public abstract boolean relDeleteOrder(String[] id_orders) throws BizException;

	/**
	 * 临床医嘱的签署（Step0） 医嘱开始签署时使用 code_entp 就诊类型
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract ValidateRtnInfoDTO ciOrderSign(String[] id_ors, CiEnContextDTO ciEnContextDTO) throws BizException;

	/**
	 * 临床医嘱的签署（Step1） 医嘱签署互斥停嘱互动提示后，继续时调用该服务 code_entp 就诊类型
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public abstract ValidateRtnInfoDTO ciOrderSignStep1(FMap2 map, String Code_entp,CiEnContextDTO ciEnContextDTO) throws BizException;

	/**
	 * 临床医嘱的签署撤回
	 * 
	 * @param ids
	 *            门诊时为id_en 住院时为id_ors
	 * @param sd_entp
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] ciOrderSignBack(String[] ids, String sd_entp) throws BizException;

	/**
	 * 临床医嘱的核对（签署后的）
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] ciOrderCheck(String[] id_ors) throws BizException;

	/**
	 * 临床医嘱的作废（已核对未执行）
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] ciOrderCancel(String[] id_ors) throws BizException;

	/**
	 * 临床医嘱的作废核对
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] ciOrderCancChk(String[] id_ors) throws BizException;

	/**
	 * 临床医嘱的停止
	 * 
	 * @param id_ors
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] ciOrderStop(String[] id_ors, FDateTime dt_end) throws BizException;

	/**
	 * 临床医嘱的停止核对
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] ciOrderStopChk(String[] id_ors) throws BizException;

	/**
	 * 皮试结果写会到医嘱内容中
	 * 
	 * @param id_or
	 * @param skinTest
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO setOrcontentSkinTest(String id_or, String skinTest) throws BizException;

	/**
	 * 临床医嘱的核对（签署、停止、作废的核对）
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] CiOrderSCSCheck(String[] id_sign_ors, String[] id_canc_ors, String[] id_stop_ors) throws BizException;

	/**
	 * 医嘱确认物品补录保存
	 */
	public abstract AddFeeDTO[] CiOrderFeeSave(String id_or, AddFeeDTO[] drug, Integer sourcein) throws BizException;

	/**
	 * 医嘱确认物品补录保存
	 */
	public abstract void CiOrderFeeDelete(AddFeeDTO drug) throws BizException;

	/**
	 * 医嘱模板保存
	 * 
	 * @param aggdos
	 * @throws BizException
	 */
	public abstract void SaveOrTplItem(SrvortplitemAggDO[] aggdos) throws BizException;

	/**
	 * 执行拆分回写医嘱项目最新生成时间
	 * 
	 * @param Id_ors
	 *            医嘱ID
	 * @param Dt_last_bl
	 *            时间
	 * @throws BizException
	 */
	public abstract String UpdateCiOrSrvDtLastBl(OrSplitDTO[] orSplit, SrvSplitDTO[] srvSplit) throws BizException;

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
	public abstract CiorappconsultAggDO[] SaveOrAppConsultAggDO(CiorappconsultAggDO[] aggdos, String consultType) throws BizException;

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
	public abstract String UpdateOrderSdMp(WriteBackOrDTO[] parmDTOS) throws BizException;

	/**
	 * 医嘱项目执行状态回写
	 * 
	 * @param parmDTOS
	 * @throws BizException
	 */
	public abstract CiorderAggDO[] UpdateOrderSrvSdMp(WriteBackOrSrvDTO[] parmDTOS) throws BizException;

	/**
	 * 完成会诊
	 * 
	 * @param aggs
	 *            会诊的记录信息
	 * @return
	 * @throws BizException
	 */
	public abstract CiorappconsultAggDO SaveCompleteConsultAggDO(CiorappconsultAggDO[] aggdos) throws BizException;

	/**
	 * 更新备血申请的可用血余量
	 * 
	 * @param aggDO
	 * @param fg_submit
	 * @return
	 * @throws BizException
	 */
	public abstract CiordrptbttestAggDO saveApbt(CiordrptbttestAggDO aggDO, FBoolean fg_submit) throws BizException;

	/**
	 * 申请单号查询备血信息
	 * 
	 * @param aggDO
	 * @param fg_submit
	 * @return
	 * @throws BizException
	 */
	public abstract CiordrptbttestAggDO findApbt(String no_applyForm) throws BizException;
	
	/**
	 * 保存医保
	 * 
	 * @param orsrvdos
	 * @param id_ors
	 */
	public abstract CiOrderDO[] saveHealthCheckReport(OrdSrvDO[] orsrvdos, String[] id_ors) throws BizException;

	/**
	 * 更新医嘱的状态和检验结果的状态
	 * 
	 * @param id_or
	 * @param sd_su_lab
	 * @param id_su_lab
	 * @return
	 * @throws BizException
	 */
	public abstract void UpdateReportAndOrderState(ReportStatusDTO[] params) throws BizException;

	/**
	 * 保存径内径外医嘱报告
	 * 
	 * @param ciOrderDOs
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract void saveCporCheckReport(CiOrderDO[] ciOrderDOs, String[] id_ors) throws BizException;

	/**
	 * 签署时 医保信息的提示
	 * 
	 * @param map
	 *            医嘱信息
	 * @param Code_entp
	 *            就诊类型
	 * @return
	 */
	public abstract ValidateRtnInfoDTO CiOrderSignMedicalInsurance(FMap2 map, String Code_entp) throws BizException;

	/**
	 * 更新医医嘱中开立状态的基本医保判断结果数据信息
	 * 
	 * @param contextDTO
	 * @return
	 */
	public abstract void updateCiOrderBhpjudgerst(CiEnContextDTO contextDTO) throws BizException;

	/**
	 * 毒麻药品签署时，保存核对的患者信息
	 * 
	 * @param checkPatInfoSrvs
	 * @param agentInfo
	 * @throws BizException
	 */
	public abstract void saveCheckPatInfo(FArrayList checkPatInfoSrvs, OrSrvAgentInfoDO agentInfo) throws BizException;
	/**
	 * 计算医嘱总次数
	 * @param id_freq
	 * @param use_day
	 * @return
	 */
    public abstract Integer getTotalTimes(String id_freq, int use_day) throws BizException;
    /**
     * 物品类计算总量
     * @param code_entp
     * @param fg_pres_outp
     * @param times
     * @param id_mm
     * @param id_unit_sale
     * @param quan_medu
     * @return
     */
    public abstract FDouble getMMQuantum(String code_entp, FBoolean fg_pres_outp, int times, String id_mm, String id_unit_sale, FDouble quan_medu) throws BizException;
    /**
     * 根据费用id_srv返回费用备注
     * @param idsrvs
     * @return
     * @throws BizException
     */
    public abstract FMap getCiOrderBlSrvDesByIdsrvs(String[] idsrvs)throws BizException;
    /**
     * 根据医嘱id_or返回费用备注
     * @param idors
     * @return
     * @throws BizException
     */
    public abstract FMap getCiOrderBlSrvDesByIdors(String[] idors)throws BizException;
    /**
     * 重新分方
     * @param id_ent
     * @param sd_entp
     * @return
     * @throws BizException
     */
    public abstract CiOrderDO[] CiOPAgainPres(String id_en,String id_dep_sign,String sd_entp,CiEnContextDTO ciEnContextDTO)throws BizException;
    
	/**
	 * 记账时 回写处方的窗口号
	 * 
	 * @param map<id_pres,winNo> key 处方号，values 是窗口号
	 * @throws BizException
	 */
	public abstract void setPresWindowNo(Map<String, String> map) throws BizException;

	/**
	 * 医生站记账
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @param accountType 记账类型
	 * @param id_psndoc 当前操作人
	 * @DmEnumDesc(name="预交金记账",description="预交金记账") public static final String CG_PREPAY="1"; //预交金记账
	 * @DmEnumDesc(name="高端商保记账",description="高端商保记账") public static final String CG_HPCG="2"; //高端商保记账
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String orderKeepAccounts(String id_ent, String code_entp, String accountType,String id_psndoc) throws BizException;

	/**
	 * 医生站预交金销账
	 * 
	 * @param id_ent 就诊id
	 * @param code_entp 就诊类型
	 * @param AcctountType 记账类型
	 * @DmEnumDesc(name="预交金记账",description="预交金记账") public static final String CG_PREPAY="1"; //预交金记账
	 * @DmEnumDesc(name="高端商保记账",description="高端商保记账") public static final String CG_HPCG="2"; //高端商保记账
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String cancelOrderAccounting(String id_ent, String code_entp,String id_psndoc) throws BizException;
	/**
	 * 高端商保销账
	 * @param idOrs
	 * @param id_psndoc
	 * @param ciEnContextDTO
	 * @return
	 * @throws BizException
	 */
	public abstract String setOrderRefundBillCancelReserve(String[] idOrs,String id_psndoc,CiEnContextDTO ciEnContextDTO)throws BizException;
	/**
	 * 获得打印单费用明细
	 * @param print_no
	 * @return
	 * @throws BizException
	 */
	public abstract PrescriptionConstBaseDto getPrintDetailsSrv(String[] print_no,String id_ent) throws BizException;
	
	/**
	 * 基础数据有效性校验
	 * @param args
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList checkBdSrvInfo(MedSrvValidateConditionDTO args)throws BizException;
	
	public abstract  String refreshCheckBdSrvInfo(MedSrvValidateConditionDTO args) throws BizException;
	/**
	 * 生命体征预置数据导入
	 * @param vt
	 * @return
	 * @throws BizException
	 */
	public abstract boolean importVt(ImplVtDTO vt) throws BizException;
	/**
	 * 药品领量天数计算，只有药品非草药类才需要计算
	 * @param sd_mupakgu 取整模式
	 * @param quan_cur 总量
	 * @param quan_medu 剂量
	 * @param id_freq 频次
	 * @return
	 * @throws BizException
	 */
	public abstract Integer getDaysAvalidate(String sd_mupakgu,FDouble quan_cur,FDouble quan_medu,FDouble factor,FDouble factor_mb,String id_freq) throws BizException;
    /**
     * 保存时提示信息再次保存 TODO 临时方案，
     * @return
     * @throws BizException
     */
    public abstract CiorderAggDO AgainSaveOrder(String emstype,CiEnContextDTO ciEnContextDTO)throws BizException;
	/**
	 * 医嘱保存
	 * @param ciEmsDTO
	 * @param CiEnContext
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderTransMissionDTO SaveCiEmsDTONew(CiEmsDTO ciEmsDTO,CiEnContextDTO CiEnContext) throws BizException;
	
    public  abstract FBoolean getEffective(CiEnContextDTO ctx)throws BizException;
}

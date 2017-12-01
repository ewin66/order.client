package iih.ci.ord.i;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.srv.dto.d.Emp2Dep2GroupDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.d.RegularOrCaDO;
import iih.bd.srv.ortpl.d.RegularOrRelSrvDO;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.ci.diag.dto.d.IpViewDiagDTO;
import iih.ci.ord.cior.d.CiOrLastMpDTO;
import iih.ci.ord.cior.d.OrdApConsDO;
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
import iih.ci.ord.ciorder.d.OrdSrvDO;
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
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.BdSrv4EmsDiDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.ordappathgy.d.OrdApPathgyDTO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.en.pv.dto.d.EnDiQrySchmDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.dto.d.EntHisDiDTO;
import iih.en.pv.entdi.d.EntDiDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.devcfg.func.d.PageDO;
import xap.sys.xbd.measdoc.d.MeasDocDO;

public interface ICiOrdQryService {

	/**
	 * 获取医嘱DTO
	 * 
	 * @param id_order
	 * @param orderType
	 * @return
	 * @throws BizException
	 */
	public abstract EmsHeadDO getEmsHeadDO(String id_order, String orderType, String code_entp,
			CiEnContextDTO contextdto) throws BizException;

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
	public abstract EmsOrDrug[] getSrvVsMm(String id_org, String id_srv, String id_dept_mp, String id_dept_phy,
			String id_hp, String code_entp) throws BizException;

	/**
	 * 根据物品类型获得物品信息
	 * 
	 * @param mmtp
	 * @return
	 * @throws BizException
	 */
	public abstract EmsOrDrug[] getMmByMmtp(String mmtp) throws BizException;

	/**
	 * 未记费医嘱查询列表
	 * 
	 * @param patid
	 * @param dtSignB
	 * @param dtSignE
	 * @param code_entp
	 * @return
	 */
	@Deprecated
	public abstract List<UnchargeOrdDTO> getUnchargeOrderList(String patid, FDateTime dtSignB, FDateTime dtSignE,
			String code_entp, String Id_org) throws BizException;

	/**
	 * 取得服务套的项目的服务
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public abstract MedSrvDO[] getSrvSetItemList(String id_srv) throws BizException;

	/**
	 * 转科过程状态更新
	 * 
	 * @param Id_ord
	 * @param status
	 * @return boolean true 成功， false 失败
	 * @throws BizException
	 */
	public abstract boolean TransferStatusUpdates(String id_ortrans, String status) throws BizException;

	/**
	 * 出科检查医嘱
	 * 
	 * @param id_en
	 * @return OutDeptCheckOrderDTO[]
	 * @throws BizException
	 */
	public abstract OutDeptCheckOrderDTO[] GetOutDeptCheckOrder(String id_en) throws BizException;

	/**
	 * 获取医保计划类型
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String, HPSrvorcaDO> GetHpSrvOrCaDOMap(String id_hp, String[] id_srvs) throws BizException;

	/**
	 * 获取医保计划类型
	 * 
	 * @param id_hp
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public abstract HPSrvorcaDO GetHpSrvOrCaDo(String id_hp, String id_srv) throws BizException;

	/**
	 * 是否可退院
	 * 
	 * @param entId 就诊id
	 * @return 错误信息
	 * @throws BizException
	 */
	public abstract String canDischarge(String entId) throws BizException;

	/**
	 * 患者出院时查询住院患者未处理完的医嘱 lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	public abstract PatUnDoOrderdto[] GetPatUnDoOrderdto(String id_ent) throws BizException;

	/**
	 * 患者出院时查询住院患者未处理完的医嘱 数量 lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	public abstract int GetPatUnDoOrderdtoNum(String id_ent) throws BizException;

	/**
	 * 患者出院时查询住院患者未处理完的医嘱 数量(多个就诊号) lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	public abstract Map GetPatUnDoOrderdtoNums(String[] id_ents) throws BizException;

	/**
	 * 患者 医嘱列表 lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	public abstract Patorderlistdto[] getPatorderlistdto(String id_ent) throws BizException;

	/**
	 * 患者本次医嘱列表 lizheng 时间 2015 -10-26 * @return
	 * 
	 * @throws BizException
	 */
	public abstract CiOrderDO[] GetOrderList(String id_ent) throws BizException;

	/**
	 * 查询医嘱关联的服务 lizheng 时间 2015 -10-26
	 * 
	 * @param id_or
	 * @return
	 * @throws Exception
	 */
	public abstract OrdSrvDO[] GetOrderSrvDOS(String id_or) throws BizException;

	/**
	 * 获取服务（含医保计划）
	 * 
	 * @param srvca 服务类型
	 * @param srvName 服务名称
	 * @param Healthca 患者医保计划
	 * @return
	 * @throws BizException
	 */
	public abstract EmsOrSrvSc[] getMedSrvSc(String srvca, String srvName, String Healthca, String code_ent)
			throws BizException;

	/**
	 * 医嘱模板获得医疗服务
	 * 
	 * @param dto 查询参数对象
	 * @return
	 * @throws BizException
	 */
	public abstract EmsOrSrvSc[] getOrtplMedSrvSc(OrtplDTO dto) throws BizException;

	/**
	 * 根据 ID_srv 取得医疗服务
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public abstract EmsOrSrvSc[] getMedSrvId(String id_srv) throws BizException;

	/**
	 * 检查 项目取得（新增时）
	 * 
	 * @param id_srv
	 * @param type
	 * @return
	 * @throws BizException
	 */
	public abstract EmsObsItemDO[] getEmsObsItemDO(String id_srv, String type) throws BizException;

	/**
	 * 根据医嘱id_or 获取编辑信息 EmsHeadDO
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public abstract EmsHeadDO GetemsHeadDO(String id_or, String type) throws BizException;

	/**
	 * 获得执行与记费的医嘱或服务拆分时的有效医嘱查询字串操 cn_cgex_ip_sql
	 * 
	 * @param param
	 * @return
	 */
	public abstract String getOrAndSrvSplitSql(OrSrvSplitParamDTO param) throws BizException;

	/**
	 * 获得执行与记费的医嘱或服务拆分时的有效医嘱对应的结果值
	 * 
	 * @param param cn_or_ip_sel
	 * @return
	 * @throws BizException
	 */
	public abstract BaseDTO[] getOrAndSrvSplitSqlRs(OrSrvSplitParamDTO param) throws BizException;

	/**
	 * 住院医嘱拆分 xuxing_2016-06-06
	 * 
	 * @param param cn_or_ip_sel
	 * @return
	 * @throws BizException
	 */
	public abstract BaseDTO getOrSplitSqlRs(OrSrvSplitParamDTO param) throws BizException;

	/**
	 * 获取门诊需要拆分的有效医嘱拆解结构
	 * 
	 * @author lijm 2016年9月27日18:00:56
	 * 
	 * @param ParamDTO门诊医嘱查询参数
	 * @return
	 * @throws BizException
	 */
	public BaseDTO[] getOpOrSplitSqlRs(OpOrSplitParamDTO ParamDTO) throws BizException;

	/**
	 * 回写医嘱和医嘱项目的最近生成时间
	 * 
	 * @param param cn_or_ip_sel
	 * @return
	 * @throws BizException
	 */
	public abstract void writeBackOrAndOrSrvLastBl(OrSplitOrderDTO[] listOrSplitDTO,
			SrvSplitOrderDTO[] listSrvSplitDTO, FDateTime Dt_last_bl) throws BizException;

	/**
	 * 对有效医嘱对应的结果集进行拆分 cn_cgex_ip_calc
	 * 
	 * @param splitRsDTOs
	 * @param s
	 * @param e
	 * @param orgensplittp
	 * @throws BizException
	 */
	public abstract BaseDTO[] splitOrAndSrvSplitSqlRs(BaseDTO[] splitRsDTOs, FDateTime s, FDateTime e,
			Integer orgensplittp) throws BizException;

	/**
	 * 服务拆分结果请领量计算 cn_cgex_ip_ap
	 * 
	 * @param srvsplitorders
	 * @return
	 * @throws BizException
	 */
	public abstract SrvSplitOrderDTO[] calSrvSplitRsApplyQuan(SrvSplitOrderDTO[] srvsplitorders) throws BizException;

	/**
	 * 服务拆分结果请领量计算 cn_cgex_ip_ap
	 * 
	 * @param srvsplitorders
	 * @return
	 * @throws BizException
	 */
	public abstract ArrayList<ArrayList<SrvSplitOrderDTO>> calSrvSplitRsApplyQuanN(SrvSplitOrderDTO[] srvsplitorders)
			throws BizException;

	/**
	 * 医嘱服务拆分后医嘱相关信息回写 cn_cgex_ip_newdatetime
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void ciOrInfoUpdateAfterSplit(OrSrvSplitOrModParamDTO[] params) throws BizException;

	/**
	 * 检查 检验报告的类别 的数据
	 * 
	 * @param id_ent
	 * @return OrObsAandLabDTO[]
	 * @throws BizException
	 */
	public abstract OrObsAandLabDTO[] getObsAndLabList(String id_ent, String type) throws BizException;

	/**
	 * 检查 检验报告的时间分类数据
	 * 
	 * @param id_ent
	 * @return OrObsAandLabDTO[]
	 * @throws BizException
	 */
	public abstract OrObsAandLabDTO[] getObsAndLabDateList(String id_ent, String type) throws BizException;

	/**
	 * 检查 检验报告的dto
	 * 
	 * @param id_ent
	 * @return OrObsAandLabDTO[]
	 * @throws BizException
	 */
	public abstract OrObsAandLabDTO getObsAndLabDto(String id_or, String type) throws BizException;

	/**
	 * 病理报告的类别 的数据
	 * 
	 * @param id_ent
	 * @return OrObsAandLabDTO[]
	 * @throws BizException
	 */
	public abstract OrdApPathgyDTO[] getPathgyList(String id_ent) throws BizException;

	/**
	 * 会诊应,审批答列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract OrdConsDTO[] GetConsList(String id_dep, String su_cons) throws BizException;

	/**
	 * 检查接口 (病历使用)
	 * 
	 * @param id_ent
	 * @return CiRptObsDO[]
	 * @throws BizException
	 */
	public abstract CiRptObsDO[] getCiRptObsDO(String id_ent) throws BizException;

	/**
	 * 检验接口 (病历使用)
	 * 
	 * @param id_ent
	 * 
	 * @return CirptlabAggDO[]
	 * @throws BizException
	 */
	public abstract CirptlabAggDO[] getCirptlabAggDO(String id_ent) throws BizException;

	/**
	 * 医嘱录入模板使用 B画面
	 * 
	 * @param id_ent
	 * @param id_Doctor
	 * @return
	 * @throws BizException
	 */
	public abstract OrdInputDto[] getOrdInputDto(String id_ent, String id_Doctor) throws BizException;

	/**
	 * 医嘱信息（病历使用） OrderMrDto
	 * 
	 * @param id_ent
	 * @param type 00 门诊 ，10 住院
	 * @return
	 * @throws BizException
	 */
	public abstract OrderMrDto[] getOrderMrDtoList(String id_ent, String type) throws BizException;

	/**
	 * 处置手动刷新到病历
	 * 
	 * @param id_ent
	 * @param type
	 * @param orders
	 * @return
	 * @throws BizException
	 */
	public abstract OrderMrDto[] getOrderFlushMrDtoList(String id_ent, String type, CiOrderDO[] orders)
			throws BizException;

	/**
	 * 会诊患者查询
	 * 
	 * @param id_dept 会诊科室
	 * @param id_emp 邀请医生
	 * @return Id_en
	 * @throws BizException
	 */
	public abstract CiOrderDO[] getConsPatList(String id_dept, String id_emp) throws BizException;

	/**
	 * 用血申请
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public abstract CiordubDTO getOrderUBDto(String id_or) throws BizException;

	/**
	 * 备血列表
	 * 
	 * @param id_or
	 * 
	 */
	public abstract CiordubDTO[] getOrderUBDtoList(String id_ent) throws BizException;

	/**
	 * 编辑医嘱 取得 CiEmsDTO
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public abstract FMap getCiEmsDTO(String[] id_ors) throws BizException;

	/**
	 * 医嘱确认
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	public abstract OrConfirm[] getCiOrdConfirm(OrConfirm confirm) throws BizException;

	/**
	 * 医嘱确认查看
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	public abstract OrConfirm[] getCiOrdConfirmedQry(OrConfirm confirm) throws BizException;

	/**
	 * 医嘱确认
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	public abstract AddFeeDTO[] getCiOrdFee(OrConfirm confirm) throws BizException;

	/**
	 * 分方查询
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	public abstract OrderPresSplitDTO[] getOrPresDTOs(String id_en) throws BizException;

	/**
	 * 大病区查询
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	public abstract String getDepsNum(String id_dep) throws BizException;

	/**
	 * 检查申请单号
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String getOrdApObsNoapplyform() throws BizException;

	/**
	 * 检验申请单号
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String getOrdApLabNoapplyform() throws BizException;

	/**
	 * 趋势图
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract LabDTO[] getLabItms(String idpat, int num, String[] srvlist) throws BizException;

	/***
	 * 当前就诊的所用诊断
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract EntDiDO[] getEntDiDOList(String id_ent) throws BizException;

	/**
	 * 用血申请单号
	 * 
	 * @param fullclassname
	 * @return
	 * @throws BizException
	 */
	public abstract String getNoapplyform(String fullclassname) throws BizException;

	/**
	 * 会诊树使用
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract OrdApConsDO[] getTreeOrdApConsDO(String id_ent) throws BizException;

	/**
	 * 检查申请 位置执行的列表
	 * 
	 * @param id_dep_exe 执行科室
	 * @param entps 就诊类型
	 * @param dtSignB 开始时间
	 * @param dtSignE 结束时间
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	public abstract AppObsDto[] getCiApObsDto(String id_dep_exe, String[] entps, FDateTime dtSignB, FDateTime dtSignE)
			throws BizException;

	/**
	 * 检查申请 位置执行的列表
	 * 
	 * @param id_dep_exe 执行科室
	 * @param entps 就诊类型
	 * @param dtSignB 开始时间
	 * @param dtSignE 结束时间
	 * @return PagingRtnData<AppObsDto>
	 * @throws BizException
	 */
	public abstract PagingRtnData<AppObsDto> getCiApObsDtoByDeptPage(PaginationInfo pg, String id_dep_exe,
			String[] entps, FDateTime dtSignB, FDateTime dtSignE, String[] sd_su_bl) throws BizException;

	/**
	 * 检查申请 未执行的列表 根据就诊id_en
	 * 
	 * @param id_en
	 * @return AppObsDto
	 * @throws BizException
	 */
	public abstract AppObsDto[] getCiApObsDtoIdEnt(String id_en) throws BizException;

	/**
	 * 检查申请 未执行的列表 根据就诊id_en
	 * 
	 * @param id_en
	 * @return AppObsDto
	 * @throws BizException
	 */
	public abstract AppObsDto[] getCiApObsDtoIdEnt2(String id_en) throws BizException;

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
	public abstract AppObsDto[] getCiApObsDtoIdPatAndDate(String[] id_pat, FDateTime dtSignB, FDateTime dtSignE,
			String[] obs_su) throws BizException;

	/**
	 * 取得门诊未缴费预付费患者列表(药品医嘱)
	 * 
	 * @param cond 查询条件
	 * @return 患者列表
	 * @throws BizException
	 */
	public abstract PrepayPatDTO[] getOpPrepayPatList(PrepayCondDTO cond) throws BizException;

	// ==================总览接口=================================
	/**
	 * 总览页面的诊断信息
	 * 
	 * @param id_ent
	 * @param type
	 * @return
	 * @throws BizException
	 */
	public abstract IpViewDiagDTO[] getCiDiagItemDOList(String id_ent, String type) throws BizException;

	/**
	 * 门诊 住院 总览 取得生命体征的信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract VitalSignsDto getCiorderPreviewDTOS(String id_ent, String Dt_birth) throws BizException;

	/**
	 * 总览页面的病历信息
	 * 
	 * @param enttp
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract OrderPandectEmrDTO[] getOrderPandectEmrDTO(String enttp, String id_ent) throws BizException;

	/**
	 * 总览取得费用数据接口
	 * 
	 * @param id_pat 患者id
	 * @param id_ent 就诊id
	 * @param codeSrv 服务编码
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getBlcgAmtVsDrugRation(String id_pat, String id_ent, String codeSrv) throws BizException;

	/**
	 * 患者过敏史
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract AllergyDto[] getAllergyDto(String id_pat) throws BizException;

	// ======================================================
	/**
	 * 医嘱助手患者既往就诊
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract EntHisDiDTO[] getEntHisDiDTO(String id_pat) throws BizException;

	/**
	 * 医嘱助手患者既往就诊
	 * 
	 * @param patId
	 * @param qrySchms
	 * @return
	 * @throws BizException
	 */
	public abstract EntHisDiDTO[] getEntHisDiBySchm(String patId, EnDiQrySchmDTO[] qrySchms) throws BizException;

	/**
	 * 医嘱助手页签列表
	 * 
	 * @param doctor_id 登陆医生id
	 * @param dept_id 当前登陆科室
	 * @param biz_id 业务功能id
	 * @return
	 * @throws BizException
	 */
	public abstract PageDO[] getPageDOList(String doctor_id, String dept_id, String biz_id) throws BizException;

	/**
	 * 医嘱助手常用模板分类
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract RegularOrCaDO[] getRegularOrCaDOs() throws BizException;

	/**
	 * 医嘱助手 - 医技常规模板 修改 （新的）
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract Medicalroutinetreedto[] getMedicalroutinetreedto(String _entp) throws BizException;

	/**
	 * 医嘱助手 - 医技常规模板 项目 （新的）
	 * 
	 * @param id_ortmpl
	 * @return
	 * @throws BizException
	 */
	public abstract OrTplNItmDO[] getOrTplNItmDO(String id_ortmpl) throws BizException;

	/**
	 * 医嘱助手常用模板项目
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract RegularOrRelSrvDO[] getRegularOrRelSrvDOs(String id_regularorca) throws BizException;

	/**
	 * 医嘱助手医嘱模板树
	 * 
	 * @return OderTplTreeDto
	 * @throws BizException
	 */
	public abstract OrderTplTreeDto[] getOrderTplTreeDto(String id_ortpltp, Emp2Dep2GroupDTO edg) throws BizException;

	/**
	 * 医嘱助手模板项目
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract OrderTemplateDTO getSrvortplitemAggDOS(String id_srvortpl) throws BizException;

	/**
	 * 临床路径调用医嘱接口查询医嘱状态 DTO数据
	 * 
	 * @param cpOrderStatus
	 * @return String [] 医嘱 状态
	 * @throws BizException
	 */
	public abstract String[] getCpOrderStatusDto(CpOrderStatusDto cpOrderStatus) throws BizException;

	/**
	 * 药品信息： id_mm、剂型，包装单位（当前包装单位），最小包装（基本包装单位）
	 * 
	 * @param id_mm
	 * @return InsurDrugDivideInfoDTO[]
	 * @throws BizException
	 */
	public abstract InsurDrugDivideInfoDTO[] getInsurDivideInfoDTO(String id_mm) throws BizException;

	/**
	 * 服务信息：id_orsrv，用法，剂量，剂量单位、用药天数；
	 * 
	 * @param id_orsrv
	 * @return RecipeDTO[]
	 * @throws BizException
	 */
	public abstract RecipeDTO[] getRecipeDTO(String[] id_orsrvs) throws BizException;

	/**
	 * 1、 id_orsrv[] :医嘱服务主键
	 * 
	 * @param id_or
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
	public abstract OrSrvGuideDTO[] getOrSrvGuideDTO(String[] id_orsrv) throws BizException;

	/**
	 * 检查医嘱及部位查询接口（根据申请单编号查询）
	 * 
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	public abstract AppObsDto[] getCiApObsDtoNOApplyForm2(String no_applyform_obs, String[] sd_su_bl)
			throws BizException;

	/**
	 * 检查医嘱及部位查询接口（根据申请单编号查询）
	 * 
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	public abstract AppObsDto[] getCiApObsDtoNOApplyForm(String no_applyform_obs) throws BizException;

	/**
	 * 检查医嘱及部位查询接口（根据患者ID查询）
	 * 
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	public abstract AppObsDto[] getCiApObsDtoIdPat(String id_pat) throws BizException;

	/**
	 * 检查医嘱及部位查询接口（根据患者ID查询）
	 * 
	 * @return AppObsDto[]
	 * @throws BizException
	 */
	public abstract AppObsDto[] getCiApObsDtoIdPat2(String id_pat, String[] sd_su_bl) throws BizException;

	/**
	 * 可录入服务范围
	 * 
	 * @param id_dep
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public abstract String getCiSrvCondition(String id_dep, String code) throws BizException;

	/**
	 * 获取执行科室
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public abstract OrWfExDeptDTO[] getMpDept(OrWfExDeptParamDTO param) throws BizException;

	/**
	 * 皮试主线处理与判断逻辑
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract SkinTestRstDTO skinTestLogicMainBP(SkinTestParamDTO param) throws BizException;

	/**
	 * 病理主键生辰规则
	 * 
	 * @param fullclassname
	 * @return
	 * @throws BizException
	 */
	public abstract String getOrdApPathgyDONober(String fullclassname) throws BizException;

	/**
	 * 生成备血申请单的申请单号
	 * 
	 * @param fullclassname
	 * @return
	 * @throws BizException
	 */
	public abstract String getNoappbtlyform(String fullclassname) throws BizException;

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
	@Deprecated
	public abstract PrescriptionCostDto[] getPrescriptionCostDto(String patid, FDateTime dtSignB, FDateTime dtSignE,
			String code_entp, String Id_org) throws BizException;

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
	public abstract PrescriptionConstBaseDto getPrescriptionConstBaseDto(String patid, FDateTime dtSignB,
			FDateTime dtSignE, String code_entp, String Id_org) throws BizException;

	/**
	 * 处方信息(费用使用)
	 * 
	 * @param id_repres
	 * @return
	 * @throws BizException
	 */
	public abstract RecipeDTO[] getRecipeDTOAndBL(String[] id_repres) throws BizException;

	/**
	 * 获取服务关联的物品 全信息 （医嘱确认用）
	 * 
	 * @param fee
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract AddFeeDTO getEmsfee(AddFeeDTO fee, OrWfExDeptParamDTO param) throws BizException;

	/**
	 * 费用 使用(为了提高查询效率)
	 * 
	 * @param wherestr 条件
	 * @param TableColumns 需要的字段
	 * @return
	 * @throws BizException
	 */
	public abstract CiorderAggDO[] getBlFeeCiOrderSrvDto(String wherestr, List TableColumns) throws BizException;

	/**
	 * 对有效医嘱进行拆分 cn_cgex_ip_calc
	 * 
	 * @param param
	 * @throws BizException
	 */
	public abstract SrvSplitOrderDTO[] splitSrvSplitSqlRs(OrSrvSplitParamDTO param) throws BizException;

	/**
	 * 对有效医嘱进行拆分 cn_cgex_ip_calc
	 * 
	 * @param param
	 * @throws BizException
	 */
	public abstract OrSplitOrderDTO[] splitOrSplitSqlRs(OrSrvSplitParamDTO param) throws BizException;

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
	public abstract MedSrvDO[] getClassMedSrvDOS(String cindition, String ordercolumn, FBoolean islazy)
			throws BizException;

	/**
	 * 医嘱助手 医疗服务项目分类
	 * 
	 * @param code_entp 就诊类型
	 * @param cindition 查询医疗服务过滤条件
	 * @param ordercolumn 排序列
	 * @return map key= medSrvList, value ： FArrayList 医疗服务集合，key=srvStatusMap，value：医疗服务不可用原因
	 * @throws BizException
	 */
	public FMap2 getClassMedSrvMap(String code_entp, String condition, String orderColumn) throws BizException;

	/**
	 * 当前就诊的有效医嘱项目
	 * 
	 * @param id_ent
	 * @return OrdSrvDO[]
	 * @throws BizException
	 */
	public abstract OrdSrvDO[] getEffectiveOrdSrvDO(String id_ent, FDateTime startTime, FDateTime endTime)
			throws BizException;

	/**
	 * 根据医嘱 id_or 获取医嘱项目和物品信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract OrderSrvInfoMpDTO[] getOrderSrvInfoMpDTO(String[] id_ors) throws BizException;

	/**
	 * 当前时间之前的天数
	 * 
	 * @param days
	 * @return
	 * @throws BizException
	 */
	public abstract FDateTime getDateTomeBefore(int days) throws BizException;

	/**
	 * 当前时间之后的天数
	 * 
	 * @param days
	 * @return
	 * @throws BizException
	 */
	public abstract FDateTime getDateTomeAfter(int days) throws BizException;

	/**
	 * 会诊患者列表查询接口
	 * 
	 * @param id_org 机构
	 * @param id_dep 登陆科室
	 * @param id_emp_response 登陆人员
	 * @return String[] 就诊id_en
	 * @throws BizException
	 */
	public abstract String[] getConsultationPatients(String id_org, String id_dep, String id_emp_response)
			throws BizException;

	/**
	 * 待应答会诊患者列表查询接口
	 * 
	 * @param id_org 机构
	 * @param id_dep 登陆科室
	 * @param id_emp_response 登陆人员
	 * @return String[] 就诊id_en
	 * @throws BizException
	 */
	public abstract String[] getToRespondConsultationPatients(String id_org, String id_dep, String id_emp_response)
			throws BizException;

	/**
	 * 会诊患者详细信息接口
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public abstract PatDetailDTO getConsPatDetail(String id_en) throws BizException;

	/**
	 * 临床医嘱选择服务，服务价格计算 单服务价格计算
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MedSrvPriceDO ciOrBdSrvPriceCalByPriMode(BdSrvPriCalParamDTO param, String id_pripat)
			throws BizException;

	/**
	 * 临床医嘱选择服务，服务价格计算 单服务价格计算
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble ciOrBdSrvPriceCal(BdSrvPriCalParamDTO param) throws BizException;

	/**
	 * 临床医嘱服务价格计算 批量服务价格计算
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble[] ciOrBdSrvPricesCal(BdSrvPriCalParamDTO[] params) throws BizException;

	/**
	 * @param id_org ,paramCode
	 * @return
	 * @throws BizException
	 */
	public String getStringSystemParam(String id_org, String paramCode) throws BizException;

	/**
	 * @param id_org ,paramCode
	 * @return
	 * @throws BizException
	 */
	public Integer getIntSystemParam(String id_org, String paramCode) throws BizException;

	/**
	 * 
	 * @param whereSql
	 * @return
	 * @throws BizException
	 */
	public MeterialDO[] getMeterialDOByWhereSql(String whereSql) throws BizException;

	/**
	 * 获得患者一次就诊的处方信息
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public abstract OrdPresDTO[] getOrdPresInfo(String id_en) throws BizException;

	/**
	 * 获得患者就诊医嘱处方信息 （仅供处方打印用）
	 * 
	 * @param presprintparam
	 * @param 其中id_en 就诊Id
	 * @param 其中ids_orpres 重打或补打处方时处方Id字串（以逗号分隔）
	 * @return
	 * @throws BizException
	 */
	public abstract OrdPresDTO[] getOrdPresInfo4Print(PresPrintParamDTO presprintparam) throws BizException;

	/**
	 * 获得科室下的病区id串
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public String getNurAreaOfDep(String id_dep) throws BizException;

	/**
	 * 扣减床旁余量 2016-07-06
	 * 
	 * @author 徐星
	 * @return
	 * @throws BizException
	 */
	public String reductionBedQuan(String[] id_ors) throws BizException;

	/**
	 * 更新 在途量/床旁余量 2016-07-07
	 * 
	 * @author xu_xing
	 * @param id_orsrvs
	 * @return
	 * @throws BizException
	 */
	public String setPharmArrivalInTransitUpdate(String[] id_orsrvs) throws BizException;

	/**
	 * 根据Ems数据获得临床医嘱及关联的相关信息 关联的相关信息：医嘱项目关联的物品信息、
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrAggAndRelInfo getCiOrAggAndRelInfo8Ems(CiEmsDTO ems,CiEnContextDTO CiEnContextDTO) throws BizException;

	/**
	 * 获取可录入服务范围
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getSrvScope(String sql) throws BizException;

	/**
	 * 当服务选择时 界面数据初始化
	 * 
	 * @param envinfo 服务信息
	 * @param param 上下文信息
	 * @return EmsDiDTO[]
	 * @throws BizException
	 */
	public abstract CiEmsDTO getEmsDiDTO(CiEnContextDTO envinfo, BdSrv4EmsDiDTO param) throws BizException;

	/**
	 * 医嘱的列表的排列顺序
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String getOrderSequenceMode() throws BizException;

	/**
	 * 执行科室（新的）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrWfExDeptDTO[] GetExeDepts4CiOrSrv(OrWfExDeptParamDTO param) throws BizException;

	/**
	 * 执行科室（新的）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrWfDeptInfoDTO getExeDepts4CiOrSrvN(OrWfExDeptParamDTO param) throws BizException;

	public abstract MeasDocDO getMeasDocDOById(String id_measDoc) throws BizException;

	/**
	 * 临床医嘱执行是否为最后一顿判断处理
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrLastMpDTO[] ciOrLastMpJudgeHandle(CiOrLastMpDTO[] param) throws BizException;

	/**
	 * 主键id生成 （诊断使用）
	 * 
	 * @param size 生成的个数
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getOIDs(int size) throws BizException;

	/**
	 * 主键id生成 （诊断使用）
	 * 
	 * @param size 生成的个数
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList2 getDiagList(String id_ent) throws BizException;

	/**
	 * 费用已经划价，没有计费的处方信息(药品 检查 检验)
	 * 
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
	public abstract RecipeDTO[] getBlCgRecipeDTO(String[] id_ents) throws BizException;

	/**
	 * 本次就诊的就诊数组 （诊断编码和诊断名称）
	 * 
	 * @param id_ent diag[0] = 急性阑尾炎&发热 诊断名称的拼接 diag[1] = K35.902&R50.901 诊断编码的 拼接 diag[2] = 001A0000003&011A0000004
	 *            子项目id的拼接 diag[3] = 001A0000003 主诊断 diag[4] = 主诊断 名称 diag[5] = Bd中诊断定义id 遗留问题，后续业务确定使用定义诊断，还是使用业务中诊断
	 *            diag[6] = K35.902 慢性病标识，有慢性病是存的是慢性病的 编码，无慢性病时 是 null
	 * @throws BizException
	 */
	public abstract String[] getDiagArray(String id_ent) throws BizException;

	/**
	 * 为计费的医嘱信息
	 * 
	 * @param id_or
	 * @return UnchargeOrdSrvDTO[]
	 * @throws BizException
	 */
	public abstract UnchargeOrdSrvDTO[] getUnchargeOrderSrv(String id_or) throws BizException;

	/**
	 * 医嘱复制
	 * 
	 * @param ordIds 待复制的医嘱id
	 * @return 复制医嘱数
	 */
	public abstract int CopyCiOrd(String[] ordIds);

	/**
	 * 多模板保存医嘱接口
	 * 
	 * @param envinfo 上下文患者信息
	 * @param ortplItemDO 模板信息
	 * @return
	 * @throws BizException
	 */
	public abstract MoreEmsParamDTO getMoreEmsParamDTO(CiEnContextDTO envinfo, OrTplNItmDO[] ortplItemDO)
			throws BizException;

	/**
	 * 药品处方信息
	 * 
	 * @param Id_pres
	 * @return RecipeDTO[]
	 * @throws BizException
	 */
	public abstract RecipeDTO[] getRecipeDTOByIdPres(String[] Id_pres) throws BizException;

	/**
	 * （药品之外的 检查检验 等 ）处方信息
	 * 
	 * @param code_ors
	 * @return
	 * @throws BizException
	 */
	public abstract RecipeDTO[] getRecipeDTOByCodeOr(String[] code_ors) throws BizException;

	/**
	 * 获取就诊历史中医嘱转换的就Ciems模板
	 * 
	 * @param ordIds 医嘱id集合
	 * @param ciEnContext 上下文就诊环境
	 * @return
	 */
	public abstract MoreEmsParamDTO getHistoryMoreEmsParam(String[] ordIds, CiEnContextDTO ciEnContext)
			throws BizException;

	/**
	 * 医嘱复制（多医疗单）
	 * 
	 * @param ordIds
	 * @param ciEnContext
	 * @return
	 * @throws BizException
	 */
	public abstract MoreEmsParamDTO getCiEmsCopyByOrdIds(String[] ordIds, CiEnContextDTO ciEnContext)
			throws BizException;

	/**
	 * 根据组套中的医疗服务、医嘱模板获取界面展现的CiEmsDTO
	 * 
	 * @param mkrMsSrvDOList 组套中服务集合
	 * @param mkrMsMrtplDOList 组套中医嘱模板集合
	 * @param bannerDTO banner对象
	 * @return 保存结果
	 * @throws BizException
	 */
	public abstract MoreEmsParamDTO getMkrMsMoreEmsParam(FArrayList mkrMsSrvDOList, FArrayList mkrMsMrtplDOList,
			Ent4BannerDTO bannerDTO) throws BizException;

	public LabDTO[] getLabItms8DateBP(String idpat, FDateTime start, FDateTime end, String[] srvlist)
			throws BizException;

	/**
	 * 获取合理用药使用的CiEmsDTO对象
	 * 
	 * @param ordIds 医嘱id
	 * @param bannerDTO
	 * @return 本次就诊的已签署的药品医嘱以及ordIds 对应的医嘱
	 * @throws BizException
	 */
	public abstract OrdRationalDrugDTO[] getRationalDrugDTOs(Ent4BannerDTO bannerDTO, String[] ordIds)
			throws BizException;

	/**
	 * 获取诊疗视图所有数据
	 * 
	 * @param ordIds 医嘱id
	 * @param bannerDTO
	 * @return 本次就诊的已签署的药品医嘱以及ordIds 对应的医嘱
	 * @throws BizException
	 */
	public abstract DiagTreatViewRntDataDTO getDiagTreatViewData(OrSrvSplitParamDTO orparams) throws BizException;

	/**
	 * 获取诊疗视图关键点所有数据
	 * 
	 * @param id_en
	 * @param start
	 * @param end
	 * @return
	 * @throws BizException
	 */
	public abstract DiagTreatKeyPointRntDataDTO[] getDiagTreatKeyPointData(String id_en, FDateTime start, FDateTime end)
			throws BizException;

	/**
	 * 获取诊疗视图所有数据
	 * 
	 * @param id_en
	 * @param start
	 * @param end
	 * @param viewmod
	 * @return
	 * @throws BizException
	 */
	public abstract DiagTreatKeyPointRntDataDTO[] getDiagTreatDataBPNew(String id_en, FDateTime start, FDateTime end,
			String viewmod) throws BizException;

	/**
	 * 模板项目显示
	 * 
	 * @param id_ortmpl
	 * @return
	 * @throws BizException
	 */
	public abstract NewOrderTemplateDTO[] getNewOrderTemplateDTO(String id_ortmpl) throws BizException;

	/**
	 * 查询医嘱、服务、物品集合对象
	 * 
	 * @param id_en 就诊id
	 * @param start 开始时间
	 * @param end 结实时间
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList2 getCiorderDTOs(String id_en, FDateTime start, FDateTime end) throws BizException;

	/**
	 * id_srv 是套id
	 * 
	 * @param id_srv
	 * @return MedSrvSetItemDO 套内项目集合
	 * @throws BizException
	 */
	public abstract MedSrvSetItemDO[] getMedSrvSetItemDO(String id_srv) throws BizException;

	/**
	 * 查询医保适应症
	 * 
	 * @param id_srv
	 * @param id_mm
	 * @param ciEnContextDTO
	 * @return
	 * @throws BizException
	 */
	public abstract BdHpIndicDTO getBdHpIndicationDTO(String id_srv, String id_mm, CiEnContextDTO ciEnContextDTO)
			throws BizException;

	/**
	 * 查询医保适应症
	 * 
	 * @param id_srv[]
	 * @param id_mm[]
	 * @param ciEnContextDTO
	 * @return
	 * @throws BizException
	 */
	public abstract BdHpIndicDTO[] getBdHpIndicationDTOs(String[] id_srvs, String[] id_mms,
			CiEnContextDTO ciEnContextDTO) throws BizException;

	/**
	 * 查询处方名称和检查检验 等名称
	 * 
	 * @param id_orsrvs 医嘱的项目id_orsrv
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getPresName(String[] id_orsrvs) throws BizException;

	/**
	 * 获取医嘱费用清单
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getOrdFeebill(String id_ent, String code_entp) throws BizException;

	/**
	 * 根据医疗单对象获取费用信息
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getEmsFeebill(CiEmsDTO ems) throws BizException;

	
	/**
	 * 保存多医疗单
	 * 
	 * @param szEmsDTO
	 * @return error_message : CiEmsDTO
	 */
	public abstract FMap2 saveMultiEmsDTO(CiEmsDTO[] szEmsDTO, CiEnContextDTO ctx) throws BizException;

	/**
	 * 获取多医疗单
	 * 
	 * @param szId_ors
	 * @param ctx
	 * @return 有一项为医疗单数组
	 */
	public abstract FMap2 getMultiEmsDTO(CiOrderDO[] szOrders, int[] szEmsType, CiEnContextDTO ctx) throws BizException;

	/**
	 * 根据保外诊断的诊断定义id查询关联的医嘱
	 * 
	 * @param id_en 本次就诊id
	 * @param id_didef 诊断定义id
	 * @return
	 */
	public abstract CiOrderDO[] getCiOrdersUsedHpCiDi(String id_en, String id_didef) throws BizException;

	/**
	 * 住院的协定处方的 tree
	 * 
	 * @param id_temp
	 * @return
	 * @throws BizException
	 */
	public abstract Medicalroutinetreedto[] getPrescriptionTree(String id_temp) throws BizException;

	/**
	 * 住院多医疗单的 参数
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String getCiOrAssMultiEmsHandleMode() throws BizException;

	/**
	 * 判断医嘱状态是否改变
	 * 
	 * @param orders
	 * @return FBoolean
	 * @throws BizException
	 */
	public abstract String JudgeOrderStatus(CiOrderDO[] orders) throws BizException;

	/**
	 * 多用户操作下的医嘱状态校验
	 * 
	 * @param orders
	 * @param id_dep_phy
	 * @return
	 * @throws BizException
	 */
	public FMap2 JudgeOrderStatusInMultiUser(CiOrderDO[] orders, String id_dep_phy,String id_dep_nur, String validateType)
			throws BizException;

	/**
	 * banner临床路径信息
	 * 
	 * @param ID_ENT
	 * @param id_cpapp
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getHpcpBannerInfo(String ID_ENT, String id_cpapp) throws BizException;

	/**
	 * 判断开始和结束日期之间是否有有效执行顿数
	 * 
	 * @param dts
	 * @param id_freq
	 * @throws BizException
	 */
	public abstract void judgeBeginEndTimeHasMpTimes(FDateTime begin, FDateTime end, String id_freq)
			throws BizException;

	/**
	 * 协定处方tree dto
	 * 
	 * @param type //住院 fg_ip 门诊 fg_op
	 * @return
	 */
	public abstract Medicalroutinetreedto[] getPrescriptionTreeNew(String type) throws BizException;

	/**
	 * 获取就诊历史医嘱列表数据集合
	 * 
	 * @param id_en 就诊id
	 * @param code_entp 就诊类型编码
	 * @param orderStr 排序字段
	 * @return 医嘱map结构，包含两项，ciOrderList 医嘱list集合，ciOrderPriMap 医嘱id与价格的map集合
	 * @throws BizException
	 */
	public abstract FMap2 getEnHistoryCiOrders(String id_en, String code_entp, String orderStr) throws BizException;

	/***
	 * 患者就诊费用统计
	 * 
	 * @param id_en
	 * @param code_entp
	 * @param fg_pres_outp
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getPatEntFeesCensus(String id_en, String code_entp, FBoolean fg_pres_outp)
			throws BizException;

	/***
	 * 
	 * @param code_entp
	 * @param id_ent
	 * @param id_dep_phy
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean JudgeEntStatusValidate(String code_entp, String id_ent, String id_dep_phy)
			throws BizException;

	/**
	 * 医保共享参数 是否启用医保共享
	 * 
	 * @param id_org
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean getIsDeptOrDatumshared(String id_org, String id_dept) throws BizException;

	/**
	 * 处置手动刷新到病历 by yzh 2017-05-10 10:27:09
	 * 自动模式
	 * @param id_ent
	 * @param code_entp
	 * @param orders
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getOrderMrDtoFlushList(String id_ent, String code_entp, String[] idors,String id_psndoc,String refreshMode) throws BizException;
	
	/**
	 * @param en_entp 就诊类型
	 * @param id_dept 模板所属科室
	 * @param id_emp 模板所属个人
	 * @param sd_tp 模板类型
	 * @return
	 * @throws BizException
	 */
	public abstract FMap getTemplateClassIfication(String en_entp, String id_dept, String id_emp, String sd_tp)
			throws BizException;

	/**
	 * 模板项目显示（20170510改造）
	 * 
	 * @param id_ortmpl
	 * @return
	 * @throws BizException
	 */
	public abstract FMap getNewOrderTemplateDTO2(String[] id_ortmpl,CiEnContextDTO ctx)
			throws BizException;
	/**
	 * 查询模板明细，如果缓存中存在，则取缓存中数据；如果模板不存在，查询出数据后，放到缓存中
	 * @param id_ortmpl
	 * @param ctx
	 * @return
	 */
	public OrderTemplateRstDTO getOrTemplateCache(String[] id_ortmpl,CiEnContextDTO ctx) throws BizException;
	/**
	 * 判断服务是否可开立
	 * 
	 * @param ordSrvChangedInfoDTOs传入对象集合 （id_srv,id_mm）
	 * @param code_entp 就诊类型
	 * @return FMap2，不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示）
	 * @throws BizException
	 */
	public abstract FMap2 JudgeOrdChangedSrv(OrdSrvChangedInfoDTO[] ordSrvChangedInfoDTOs, String code_entp)
			throws BizException;

	/**
	 * 判断服务是否可开立
	 * @param code_entp 就诊类型
	 * @param medSrvDOs 待判断服务对象数组
	 * @return FMap2，不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示）
	 * @throws BizException
	 */
	public abstract FMap2 JudgeOrdChangedSrv1(String code_entp, MedSrvDO[] medSrvDOs) throws BizException;
 
	/**
	 * 就诊计费和未计费的医嘱项目
	 * @param id_ent
	 * @param sd_su_bl
	 * @return
	 * @throws BizException
	 */
	public abstract PrescriptionConstBaseDto getPrescriptionConstAccounting(String id_ent, String[] sd_su_bl) throws BizException;
	/**
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public abstract int  getOrHelperOpenOrCountLimitSet()throws BizException;
	/**
	 * 本院的医嘱共享数据查询 
	 * @param id_pat
	 * @param id_hp
	 * @return
	 * @throws BizException
	 */
	public abstract MedicalSharingDTO[]  getMedicalSharing(String id_pat,String id_hp)throws BizException;
    /**
     * 签署时验证医嘱共享（开立的医嘱）
     * @param id_or
     * @param id_pat
     * @param id_hp
     * @return
     * @throws BizException
     */
	public abstract MedicalSharingDTO[]  getOPenCiOrder(String[] id_or,String id_pat,String id_hp)throws BizException;
	/**
	 * 外配处方
	 * @param patid
	 * @param dtSignB
	 * @param dtSignE
	 * @param code_entp
	 * @param Id_org
	 * @return
	 * @throws BizException
	 */
 	public abstract PrescriptionConstBaseDto getExtdispenseDto(String patid, FDateTime dtSignB, FDateTime dtSignE,
 			String code_entp, String Id_org) throws BizException;
 	
 	/**
 	 * 物品和服务的对应关系
 	 * @param id_ors
 	 * @return  id_orsrv ，Name_mm
 	 * @throws BizException
 	 */
 	public abstract FMap2 getMMName(String[] id_ors)throws BizException;
 	/**
	 * 查询末次病程记录
	 * @param idEnt 就诊id
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getCiMrCourseOfLastDisease(String idEnt,FBoolean firstMr) throws BizException;
	/**
	 * 判断是否有自费诊断
	 * @param id_didef
	 * @return
	 * @throws BizException
	 */
	public abstract String getUsedHpdiexpensese(String id_ent ,String Id_didef)throws BizException;
	/**
	 * 判定是否医保特殊病	 
	 * @param idhp
	 * @param idpat
	 * @param iddiDefs
	 * @return
	 * @throws BizException
	 */
	public abstract FMap isPatSpecDi(String idhp, String idpat, String[] iddiDefs) throws BizException;
	/**
	 * 判定是否自费诊断
	 * @param idhp
	 * @param sdentp
	 * @param iddiDefs
	 * @return
	 * @throws BizException
	 */
	public abstract FMap isSelfPaidDi(String idhp, String sdentp, String[] iddiDefs) throws BizException;
   /**
    * 自费修改医保时，调用医保在适应症
    * @param id_srv
    * @param id_mm
    * @param cxt
    * @return
    */
  public  abstract EmsOrDrug  getHPIndiccation(String id_srv,String id_mm,CiEnContextDTO cxt)throws BizException;
  /**
   * 验证医保
   * @param id_hp
   * @param id_srvs
   * @return
   * @throws BizException
   */
  public  abstract FMap  ValidateOrderAndDiag(String id_ent,String id_hp,String[] id_srvs)throws BizException;
  /**
   * 检查检验重复性提示信息
   * @param id_or
   * @param ctx
   * @return
   * @throws BizException
   */
  public  abstract List<MedicalSharingDTO> getRepeatMessageOrder(String id_or,CiEnContextDTO ctx)throws BizException;
  /**
   * 医疗单保存前校验
   * @param param
   * @return
   * @throws BizException
   */
  public abstract CheckRstDTO checkEmsBeforSave(CheckParamDTO param)throws BizException;
		
   /**
    * 多就诊查询诊断集合
    * @param id_ents
    * @return Map<String,List>  
    * @throws BizException
    */
  public abstract  Map<String,List> getDiagItemMap(String[] id_ents) throws BizException; 
}

/**
 * 
 */
package iih.ci.ord.s.bp.assi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.i.ICHerbBoilDesDORService;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDORService;
import iih.bd.srv.ems.d.EmsMatchRstDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.srv.medusage.i.IMedusagedesRService;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.pub.util.tools.MessageConvertUtil;
import iih.ci.ord.s.bp.ems.CiEmsDefaultValueSetBP;
import iih.ci.ord.s.bp.emscalculate.total.CalTimesCurBP;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalByPriModeBP;
import iih.ci.ord.s.bp.validate.chain.AssembleAssiChain;
import iih.ci.ord.s.bp.validate.chain.ValidateDataDTO;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.utils.GetDrugDaysOfAvailable;
import iih.ci.ord.s.utils.GetDrugTotalQuan4DoseBP;
import iih.ci.ord.s.utils.GetDrugTotalQuan4HerbsBP;
import iih.ci.ord.s.utils.GetDrugTotalQuanBP;
import iih.ci.ord.s.utils.GetSrvTotalQuanBP;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStatus;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: CiOrTmplAggDTOMappingCiEmsDTO
 * @Description: 医嘱模板映成CiEmsDTO
 * @author Comsys-li_zheng
 * @date 2016年9月6日 下午2:55:36
 * @Package iih.ci.ord.s.bp.assi Copyright: Copyright (c) 2011 Company: 北大医疗信息技术有限责任公司
 */
public class CiOrTmplAggDTOMappingCiEmsDTO {

	// 频次
	private IFreqdefMDORService ifreqdefMDORService;
	// 用法
	private IMedusageRService imedusageRService;
	// 用法要求
	private IMedusagedesRService imedusagedesRService;
	// 煎法
	private ICherbboilmdMDORService icherbboilmdMDORService;
	// 煎法要求
	private ICHerbBoilDesDORService icHerbBoilDesDORService;
	// 医疗服务服务
	private IMedsrvMDORService imedsrvMDORService;
	// 套定义服务
	private IMedSrvSetItemDORService srvSetItemRSercie;
	// 检查属性
	private IMedSrvRisDORService imedSrvRisDORService = null;
	// 获取物品的默认总量单位服务
	private IMaterialBaseInfoService imaterialInfoService = null;
	// 诊断服务接口
	private ICidiagQryService icidiagQryService;

	// 套内项目对应的服务map结构(每个套内项目对应map中一条记录，key：对应bd_srv中的id_srv)
	private Map<String, MedSrvSetItemDO> setItemSrvMap = null;
	// 服务套id与套内项目集合Map结构（key服务套的id_srv ，value 套内项目集合）
	private Map<String, List<MedSrvSetItemDO>> srvSetItemsMap = null;
	// 检查属性
	private Map<String, MedSrvRisDO> srvRisMap = null;
	//bd_srv
	private Map<String, MedSrvDO> bdSrvMap = null;
	// 计算总次数
	private CalTimesCurBP calTimesCurBP;

	// 映射初始化时CiEms不随医嘱变化的属性对象
	private InitMappingCiEmsProperty mappingProperty;

	// 门诊住院的可使用状态对应关系，用于过滤当前就诊环境下是否支持模板转换为医嘱
	// key 就诊类型  value 可使用标识字段名称
	private final static Map<String, String> FG_USE_MAP = new HashMap<String, String>() {
		{
			put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, "get" + MedSrvDO.FG_USE_OP); // 可使用标识_门诊
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET, "get" + MedSrvDO.FG_USE_ER); // 可使用标识_急诊
			put(IBdFcDictCodeConst.SD_CODE_ENTP_PE, "get" + MedSrvDO.FG_USE_PE); // 可使用标识_体检
			put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, "get" + MedSrvDO.FG_USE_IP); // 可使用标识_住院
			put(IBdFcDictCodeConst.SD_CODE_ENTP_FA, "get" + MedSrvDO.FG_USE_FM); // 可使用标识_家庭
		}
	};

	// 门诊住院的可使用状态对应关系，用于准确提示服务不可使用的场景
	// key 就诊类型  value 可使用标识字段名称
	private final static Map<String, String> FG_USE_MSG = new HashMap<String, String>() {
		{
			put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, "门诊"); // 可使用标识_门诊
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET, "体检"); // 可使用标识_急诊
			put(IBdFcDictCodeConst.SD_CODE_ENTP_PE, "体检"); // 可使用标识_体检
			put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, "住院"); // 可使用标识_住院
			put(IBdFcDictCodeConst.SD_CODE_ENTP_FA, "家庭"); // 可使用标识_家庭
		}
	};

	public CiOrTmplAggDTOMappingCiEmsDTO() {
		ifreqdefMDORService = CiOrdAppUtils.getFreqdefMDORService();
		imedusageRService = (IMedusageRService) ServiceFinder.find(IMedusageRService.class);
		imedusagedesRService = (IMedusagedesRService) ServiceFinder.find(IMedusagedesRService.class);
		icherbboilmdMDORService = (ICherbboilmdMDORService) ServiceFinder.find(ICherbboilmdMDORService.class);
		icHerbBoilDesDORService = (ICHerbBoilDesDORService) ServiceFinder.find(ICHerbBoilDesDORService.class);
		imedsrvMDORService = (IMedsrvMDORService) ServiceFinder.find(IMedsrvMDORService.class);
		srvSetItemRSercie = (IMedSrvSetItemDORService) ServiceFinder.find(IMedSrvSetItemDORService.class);
		imedSrvRisDORService = (IMedSrvRisDORService) ServiceFinder.find(IMedSrvRisDORService.class);
		imaterialInfoService = (IMaterialBaseInfoService) ServiceFinder.find(IMaterialBaseInfoService.class);
		icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);

		calTimesCurBP = new CalTimesCurBP();
	}

	/**
	 * 医嘱模板映成CiEmsDTO
	 * 
	 * @param envinfo 上下文信息
	 * @param ciOrtmplAggDTO 医嘱逻辑模板
	 * @return CiEmsDTO[]
	 * @throws BizException
	 */
	public MoreEmsParamDTO Mapping(CiEnContextDTO envinfo, CiOrTmplDTO[] ciOrtmplAggDTO) throws BizException {

		if (ciOrtmplAggDTO == null || ciOrtmplAggDTO.length == 0)
			return null;
		// 不允许通过助手直接保存的医嘱提示信息
		StringBuffer refusedMsg = new StringBuffer();

		// 如果是医保就诊，判断是否存在保外诊断
		if (envinfo.getFg_hpfundpay() == FBoolean.TRUE) {

			// 查询保外诊断
			CiDiagItemDO[] ciDiagItems = icidiagQryService.getHpjudgetpCiDiagItems(envinfo.getId_en());
			CiEnContextUtil.SetHpCiDiagItem(envinfo, ciDiagItems);
		}

		mappingProperty = new InitMappingCiEmsProperty(envinfo);

		// 构造套内项目集合key值为套内项目对应的服务id
		setItemSrvMap = new HashMap<String, MedSrvSetItemDO>();
		srvRisMap = new HashMap<String, MedSrvRisDO>();
		// 服务套与套内项目对应关系集合
		srvSetItemsMap = new HashMap<String, List<MedSrvSetItemDO>>();

		this.createSrvSetItemMap(ciOrtmplAggDTO);

		//CiEmsDTO[] ciEmsDTOS = new CiEmsDTO[ciOrtmplAggDTO.length];
		List<CiEmsDTO> ciEmsList = new ArrayList<CiEmsDTO>();

		//优化 一次查询 bd_srv
		bdSrvMap = OptimizationMedSrvDO(ciOrtmplAggDTO);
		for (int i = 0; i < ciOrtmplAggDTO.length; i++) {

			CiOrTmplDTO orTmplDTO = ciOrtmplAggDTO[i];
			String msg = this.getRefuseMsg(envinfo, orTmplDTO, bdSrvMap);
			if (StringUtils.isNotEmpty(msg)) {
				refusedMsg.append(msg).append(System.lineSeparator());
				continue;
			}
			
			// TODO: 此处应该根据不同的医疗单服务，调用不同的映射方法（普药、草药、检验检查、手术、会诊、治疗、病理、用血、备血等等）
			CiEmsDTO ciEmsDto = new CiEmsDTO();
			ciEmsDto.setStatus(DOStatus.NEW);// 设置为新建状态

			// 根据上下文环境 + 医嘱模板生成 = 医疗单CiEmsDTO数据
			MappingFieldOrder(envinfo, ciEmsDto, orTmplDTO, bdSrvMap);
			// 补充对CiEms,CiEmsSrv的属性赋值 
			afterFieldMapping(envinfo,ciEmsDto);

			// 医嘱项目
			ciEmsList.add(ciEmsDto);
			//ciEmsDTOS[i] = ciEmsDto;
		}
		
		// 将CiEmsDTO集合转换为 MoreEmsParamDTO对象
		MoreEmsParamDTO moreEmsParam = new MoreEmsParamDTO();
		if (ciEmsList.size() > 0) {
			//校验医嘱模板开立服务的库存
			String resonInfo = emsSrvValidateCount(ciEmsList);
			
			if(!CiOrdUtils.isEmpty(resonInfo)){
				refusedMsg.append(resonInfo).append(System.lineSeparator());
			}
			CovertTmplToMoreEmsParamBP bp = new CovertTmplToMoreEmsParamBP();
			moreEmsParam = bp.exec(resonInfo,envinfo, ciEmsList.toArray(new CiEmsDTO[0]));
		}

		// 保存不允许执行保存的提示信息		
		moreEmsParam.setPrompt_msg(refusedMsg.toString());
		
		return moreEmsParam;
		//return ciEmsDTOS;
	}
	
	/**
	 * 判断是否支持模板保存<br/>
	 * 
	 * @param envinfo 当前就诊上下文环境
	 * @param ciOrTmpl 标识模板
	 * @param bdSrvMap 服务集合
	 * @return
	 * @throws BizException
	 */
	private String getRefuseMsg(CiEnContextDTO envinfo, CiOrTmplDTO ciOrTmpl, Map<String, MedSrvDO> bdSrvMap)
			throws BizException {

		String codeEntp = envinfo.getCode_entp();

		if (FG_USE_MAP.containsKey(codeEntp)) {

			MedSrvDO medSrv = bdSrvMap.get(ciOrTmpl.getId_srv());
			if (medSrv.getFg_active() != FBoolean.TRUE) {
				return "服务【" + medSrv.getName() + "】已停用";
			}

			if (medSrv.getFg_or() != FBoolean.TRUE) {
				return "服务【" + medSrv.getName() + "】为非临床项目";
			}
			if (medSrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_A)) {
				return "服务【" + medSrv.getName() + "】不支持通过助手开立医嘱";
			}
			try {

				// 获取可使用标识的get方法并执行
				Class<? extends MedSrvDO> cls = medSrv.getClass();
				Method getMethod = cls.getDeclaredMethod(FG_USE_MAP.get(codeEntp));
				Object fgUse = getMethod.invoke(medSrv);

				if (fgUse == null || FBoolean.valueOf(fgUse.toString()) != FBoolean.TRUE) {
					return FG_USE_MSG.get(codeEntp) + "中服务【" + medSrv.getName() + "】不可使用";
				}

			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

				throw new BizException("医嘱模板映射获取获取可使用标识失败");
			}
		}
		return null;
	}

	/**
	 * 获取bd套内项目集合
	 * 
	 * @param ciEmsDTO
	 * @throws BizException
	 */
	private void createSrvSetItemMap(CiOrTmplDTO[] ciOrTmpls) throws BizException {

		StringBuffer idSrvBuffer = new StringBuffer();
		StringBuffer idSetSrvBuffer = new StringBuffer();
		for (CiOrTmplDTO ciOrTmpl : ciOrTmpls) {
			if (ciOrTmpl.getFg_set() == FBoolean.TRUE) {
				idSrvBuffer.append(",'" + ciOrTmpl.getId_srv() + "'");
			}
		}

		if (idSrvBuffer.length() > 0) {
			// 查询套内项目
			String whereStr = "id_srv in (" + idSrvBuffer.substring(1) + ")";
			MedSrvSetItemDO[] medSrvSetItems = srvSetItemRSercie.find(whereStr, null, FBoolean.FALSE);
			for (MedSrvSetItemDO medSrvSetItem : medSrvSetItems) {

				// 构造套内项目对应服务id，用于其他属性查询
				idSetSrvBuffer.append(",'" + medSrvSetItem.getId_srv_itm() + "'");

				// 套内项目对应的服务map集合
				setItemSrvMap.put(medSrvSetItem.getId_srv_itm(), medSrvSetItem);

				// 构造套内项目集合map结构
				List<MedSrvSetItemDO> setItemList = null;
				if (srvSetItemsMap.containsKey(medSrvSetItem.getId_srv())) {
					setItemList = srvSetItemsMap.get(medSrvSetItem.getId_srv());
				} else {
					setItemList = new ArrayList<MedSrvSetItemDO>();
					srvSetItemsMap.put(medSrvSetItem.getId_srv(), setItemList);
				}
				setItemList.add(medSrvSetItem);
			}

			// 查询检查属性
			String whereStrRis = "id_srv in (" + idSetSrvBuffer.substring(1) + ")";
			MedSrvRisDO[] medSrvRises = imedSrvRisDORService.find(whereStrRis, null, FBoolean.FALSE);
			for (MedSrvRisDO medSrvRis : medSrvRises) {
				srvRisMap.put(medSrvRis.getId_srv(), medSrvRis);
			}
		}
	}

	/**
	 * 医嘱模板的映射(普通药品医疗单)
	 * 
	 * @param envinfo
	 * @param ciEmsDto
	 * @param aggDto
	 * @throws BizException
	 */
	private void MappingFieldOrder(CiEnContextDTO envinfo, CiEmsDTO ciEmsDto, CiOrTmplDTO ciOrTmplDTO,
			Map<String, MedSrvDO> bdSrvMap) throws BizException {

		// 对应的 bd_srv，传递数据为医嘱模板时
		ciEmsDto.setId_srv(ciOrTmplDTO.getId_srv());
		//优化 一次查询
		//MedSrvDO medSrvDO = imedsrvMDORService.findById(ciEmsDto.getId_srv());
		MedSrvDO medSrvDO = null;
		if (bdSrvMap != null) {
			medSrvDO = bdSrvMap.get(ciEmsDto.getId_srv());
		}
		if (medSrvDO == null) {
			OrdBizLogger.info(envinfo, "标准模板转CiEmsDTO时根据id_srv[" + ciEmsDto.getId_srv() + "]未获取到服务项目");
			throw new BizException("标准模板转CiEmsDTO时根据id_srv[" + ciEmsDto.getId_srv() + "]未获取到服务项目");
		}
		
		ValidateDataDTO param = new ValidateDataDTO();
		param.setMedSrv(medSrvDO);
		List<String> msgList = AssembleAssiChain.startValidate(envinfo, param);
		if (msgList.size() > 0) {
			throw new BizException(MessageConvertUtil.convertListToString(msgList));
		}
		ciEmsDto.setNote(ciOrTmplDTO.getDes_or());//医嘱描述
		ciEmsDto.setId_pat(envinfo.getId_pat());// 患者
		ciEmsDto.setId_en(envinfo.getId_en());// 就诊
		ciEmsDto.setId_entp(envinfo.getId_entp());// 就诊类型
		ciEmsDto.setCode_entp(envinfo.getCode_entp());// 就诊类型编码
		ciEmsDto.setId_srvtp(ciOrTmplDTO.getId_srvtp());// 医嘱类型
		ciEmsDto.setSd_srvtp(ciOrTmplDTO.getSd_srvtp());// 医嘱类型编码
		// 套服务是否包含套内项目，组套中的套都不包含套内项目
		CiOrTmplSrvDTO tmplSrvDTO = null;
		if (OrSourceFromEnum.IIHCLINICALKITHELPER != ciOrTmplDTO.getEu_orsrcmdtp()) {// 不是来源组套
			// 获取服务项目
			FArrayList ciOrTmplSrvs = ciOrTmplDTO.getOrtmplsrvs();
			tmplSrvDTO = (CiOrTmplSrvDTO) ciOrTmplSrvs.get(0); // 取第0个作为主服务
			// 将模板中的用法、频次、煎法 赋值到CiEmsDTO中
			// 频次
			if (StringUtils.isBlank(tmplSrvDTO.getId_freq())) {
				OrdBizLogger.error(envinfo,  "执行方法 CiOrTmplAggDTOMappingCiEmsDTO.MappingFieldOrder,映射服务["+tmplSrvDTO.getId_srv() + "]对应频次不能为空！" );
				throw new BizException("频次不能为空！");
			}
			ciEmsDto.setId_freq(tmplSrvDTO.getId_freq());// 频次id
			ciEmsDto.setId_route(tmplSrvDTO.getId_route());// 用法id
			ciEmsDto.setId_routedes(tmplSrvDTO.getId_routedes());// 用法要求
			ciEmsDto.setId_boil(tmplSrvDTO.getId_boil());// 设置煎法id
			ciEmsDto.setId_boildes(tmplSrvDTO.getId_boildes());// 煎法要求id

		}
        if(envinfo != null && envinfo.getEnt4BannerDTO().getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)){
        	ciEmsDto.setDays_or(null);// 医嘱天数
        }else{
        	ciEmsDto.setDays_or(ciOrTmplDTO.getDays_or());// 医嘱天数
        }
		

		// 补全频次、频次下次数、用法、用法要求、煎法、煎法要求
		this.setCiEmsDTOUseDetailByMedSrv(envinfo,ciEmsDto, medSrvDO);

		// 执行科室 执行完映射在设置执行科室
		//OrWfDeptInfoDTO deptMpDto = this.getMpDeptID(envinfo, medSrvDO,null);

		// ciEmsDto.setSd_orrsttp(ciOrTmplDTO.getSd_orrsttp());//医嘱结果编码
		//ciEmsDto.setId_dep_mp(deptMpDto.getFirstid_mp_dept());// 执行科室Id
		//ciEmsDto.setName_dep_mp(deptMpDto.getFirstname_mp_dept());// 执行科室名称

		ciEmsDto.setId_unit_med(medSrvDO.getId_unit_med());// 医学单位

		ciEmsDto.setId_srvca(medSrvDO.getId_srvca());// 医嘱基本分类
		ciEmsDto.setName_unit_med(medSrvDO.getMed_name());//医学单位名称
		ciEmsDto.setInnercode_srvca(medSrvDO.getSrvca_innercode());// 服务分类内码
		ciEmsDto.setId_grp(envinfo.getId_grp());// 所属集团
		ciEmsDto.setId_org(envinfo.getId_org());// 所属组织
		ciEmsDto.setEmsappmode(envinfo.getEmsappmode());// 医疗单应用场景
		//ciEmsDto.setName_ems(medSrvDO.getName());// 医疗单显示名称 医疗单名称不是服务名，从EmsMatchRstDTO中取

		// ciEmsDto.setId_orpltp(ciOrTmplDTO.getId_orpltp());//医嘱执行闭环类型

		// ciEmsDto.setMapkeys(ciOrTmplDTO.getMapkeys());//附加信息Map键值串
		// ciEmsDto.setMapinfo(ciOrTmplDTO.getMapinfo());//相关附加信息MAP
		// ciEmsDto.setFg_syncfee(ciOrTmplDTO.getFg_syncfee());//费用同步标识
		// ciEmsDto.setFreqct(ciOrTmplDTO.getFreqct());//频次下次数
		// ciEmsDto.setFrequnitct(ciOrTmplDTO.getFrequnitct());//频次周期数
		// ciEmsDto.setSd_frequnitct(ciOrTmplDTO.getSd_frequnitct());//频次周期类型编码
		// ciEmsDto.setSrvsetitms(ciOrTmplDTO.getSrvsetitms());//套对应的套内项目集合

		// ciEmsDto.setOrapplysheet(ciOrTmplDTO.getOrapplysheet());//医嘱对应的申请单

		ciEmsDto.setId_dept_en(envinfo.getId_dep_en());// 就诊科室
		ciEmsDto.setId_dept_ns(envinfo.getId_dep_ns());// 护理单元
		ciEmsDto.setFg_set(medSrvDO.getFg_set());// 是否是套
		ciEmsDto.setDes_or(ciOrTmplDTO.getDes_or());// 嘱托

		// ciEmsDto.setCiorfreqtimes(ciOrTmplDTO.getCiorfreqtimes());//医嘱计划频次执行时刻集合
		ciEmsDto.setFg_pres_outp(FBoolean.FALSE);// 出院带药标识

		// 门诊不使用后台匹配医疗单
		SrvMatchEmsRstDTO emsmatch = getFuncClassStr(envinfo, medSrvDO);
		if (emsmatch == null) {
			ciEmsDto.setEmstype(EmsType.COMMON);
			ciEmsDto.setFg_quickwflow(FBoolean.FALSE);
			//throw new BizException("医疗服务 ：" + medSrvDO.getName() + " 配不到医疗单 ");
		} else {
			ciEmsDto.setFuncclassstr(emsmatch.getFuncclassstr());// 医疗单URL
			ciEmsDto.setId_srvof(emsmatch.getId_ems());// 医疗单
			ciEmsDto.setName_ems(emsmatch.getName_show());// 医疗单名称
			ciEmsDto.setFg_quickwflow(emsmatch.getFg_quickwflow());

			try {
				ciEmsDto.setEmstype(Integer.parseInt(CiOrdUtils.getEmsFunclassKVDTO(emsmatch.getFuncclassstr()).getEmstype()));//医疗单类型
			} catch (Exception ex) {
				OrdBizLogger.info(envinfo,"医疗服务 ：" + medSrvDO.getName() + " 找不到医疗单类型 ");
				throw new BizException("医疗服务 ：" + medSrvDO.getName() + " 找不到医疗单类型 ");
			}
		}

		ciEmsDto.setApplyno(CiOrdUtils.getApplyNo(medSrvDO.getSd_srvtp()));// 申请单号
		// ciEmsDto.setFg_urgent(ciOrTmplDTO.getFg_urgent());//加急标识

		// ciEmsDto.setId_orrsttp(ciOrTmplDTO.getId_orrsttp());//医嘱结果
		// ciEmsDto.setId_or(ciOrTmplDTO.getId_or());//医嘱主键标识

		// ciEmsDto.setId_srv_pkg(ciOrTmplDTO.getId_srv_pkg());//服务包
		if (!envinfo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) { // 住院的常临标识通过 setCiEmsDTOUseDetailByMedSrv 中频次定义设置，门诊的都设置false
			ciEmsDto.setFg_long(FBoolean.FALSE);// 长临标识 	
		}

		//ciEmsDto.setEmstype(JudgeEmsType(medSrvDO.getSd_srvtp()));// 医疗单类型(药品)		 
		ciEmsDto.setFg_boil(ciOrTmplDTO.getFg_boil());// 代煎标识

		ciEmsDto.setOrders(ciOrTmplDTO.getOrders());// 医嘱付数
		ciEmsDto.setOrders_boil(ciOrTmplDTO.getOrders());//代煎付数
		ciEmsDto.setCode(ciOrTmplDTO.getCode());// 编码
		if (StringUtils.isBlank(ciEmsDto.getCode())) {
			ciEmsDto.setCode(medSrvDO.getCode());// 编码
		}
		ciEmsDto.setName(ciOrTmplDTO.getName());// 医嘱名称
		if (StringUtils.isBlank(ciEmsDto.getName())) {
			ciEmsDto.setName(medSrvDO.getName());
		}
		// ciEmsDto.setNote(ciOrTmplDTO.getNote());//备注
		ciEmsDto.setId_emp_phy(envinfo.getId_emp_or());// 开立医生
		// ciEmsDto.setName_emp_phy(envinfo.getName_emp());//开立医生姓名
		ciEmsDto.setId_dep_phy(envinfo.getId_dep_or());// 开立科室
		// ciEmsDto.setName_dep_phy(ciOrTmplDTO.getName_dep_phy());//开立科室名称
		ciEmsDto.setId_wg_or(envinfo.getId_wg_or());// 医疗组
		ciEmsDto.setDt_begin(CiOrdAppUtils.getServerDateTime());// 开始日期
		if (!CiOrdUtils.isEmpty(ciEmsDto.getDays_or())) {
			ciEmsDto.setDt_end(new FDateTime(ciEmsDto.getDt_begin().getBeginDate().getDateAfter(ciEmsDto.getDays_or()),
			ciEmsDto.getDt_begin().getUFTime()));//结束日期
		}
		// ciEmsDto.setDt_end(ciOrTmplDTO.getDt_end());//结束日期
		// ciEmsDto.setContent(ciOrTmplDTO.getContent());//医嘱内容
		// ciEmsDto.setDt_invalid(ciOrTmplDTO.getDt_invalid());//医嘱过期时间
		ciEmsDto.setFg_bb(envinfo.getFg_bb());// 婴儿标识
		ciEmsDto.setNo_bb(envinfo.getNo_bb());// 婴儿序号

		// ciEmsDto.setFg_pmor(ciOrTmplDTO.getFg_pmor());//备用医嘱标识
		// ciEmsDto.setDes_pmor(ciOrTmplDTO.getDes_pmor());//备用医嘱使用条件描述
		// ciEmsDto.setId_or_rel(ciOrTmplDTO.getId_or_rel());//关联医嘱
		// ciEmsDto.setFg_ctlcp(ciOrTmplDTO.getFg_ctlcp());//临床路径控制标识
		// ciEmsDto.setFg_mr(ciOrTmplDTO.getFg_mr());//医疗记录联动标识
		// ciEmsDto.setFg_skintest(ciOrTmplDTO.getFg_skintest());//需皮试标识
		// ciEmsDto.setId_skintest_skip_reaso(ciOrTmplDTO.getId_skintest_skip_reaso());//不皮试原因（废弃不用了）
		// ciEmsDto.setSd_skintest_skip_reaso(ciOrTmplDTO.getSd_skintest_skip_reaso());//不皮试原因编码（废弃不用了）

		ciEmsDto.setTimes_cur(calTimesCurBP.exec(ciEmsDto));// 总次数
		ciEmsDto.setFg_mp_in(mappingProperty.getFgMpIn(ciEmsDto)); // 在院执行状态
		CiEmsDefaultValueSetBP defaultSetbp = new CiEmsDefaultValueSetBP();
		defaultSetbp.exec(ciEmsDto);//设置在院执行状态
		//ciEmsDto.setFg_mp_in(FBoolean.TRUE);// 在院执行标识 从助手生成的医疗单都设置在院执行，（医疗单中可以根据医生患者沟通确定是否需要在院执行）

		if (ciEmsDto.getFg_mp_in().booleanValue()) { // 在院执行时
			ciEmsDto.setTimes_mp_in(ciEmsDto.getTimes_cur());// 如果是在院执行，助手中的构造的医嘱等于总次数
			/*if (ciEmsDto.getTimes_mp_in() != null) { // TODO 上边没有设置在院执行次数的地方，这个判断没意义
				ciEmsDto.setTimes_mp_in(ciEmsDto.getTimes_mp_in());
			} else {
				ciEmsDto.setTimes_mp_in(CiOrdUtils.JudgeTiemMpIn(ciEmsDto));
				ciEmsDto.setTimes_cur(ciEmsDto.getTimes_mp_in());// 总次数   TODO 总次数逻辑
			}*/
		}

		if (ciEmsDto.getSd_srvtp() != null
				&& ciEmsDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
			if (tmplSrvDTO != null && tmplSrvDTO.getQuan_med() != null) {
				ciEmsDto.setNote(" " + ciEmsDto.getName_boil() + " " + tmplSrvDTO.getQuan_med() + " "
						+ medSrvDO.getMed_name() + "," + ciEmsDto.getName_freq() + "," + ciEmsDto.getName_route());
			} else {
				ciEmsDto.setNote(" " + ciEmsDto.getName_boil() + " " + medSrvDO.getQuan_med() + " "
						+ medSrvDO.getMed_name() + "," + ciEmsDto.getName_freq() + "," + ciEmsDto.getName_route());
			}
			ciEmsDto.setNote(ciEmsDto.getDes_or());
		} else {
			//ciEmsDto.setNote();
		}
		// ciEmsDto.setFg_mp_bed(ciOrTmplDTO.getFg_mp_bed());//床边执行标识
		// ciEmsDto.setTimes_firday_mp(ciOrTmplDTO.getTimes_firday_mp());//首日执行次数
		// ciEmsDto.setFg_or_doc(ciOrTmplDTO.getFg_or_doc());//医生医嘱标识
		// ciEmsDto.setId_su_or(ciOrTmplDTO.getId_su_or());//医嘱状态
		// ciEmsDto.setSd_su_or(ciOrTmplDTO.getSd_su_or());//医嘱状态编码
		// ciEmsDto.setFg_active_pm(ciOrTmplDTO.getFg_active_pm());//备用医嘱启用标识
		// ciEmsDto.setId_reltp(ciOrTmplDTO.getId_reltp());//关联医嘱类型编码
		// ciEmsDto.setSd_reltp(ciOrTmplDTO.getSd_reltp());//关联医嘱类型
		ciEmsDto.setEu_orsrcmdtp(ciOrTmplDTO.getEu_orsrcmdtp()); // 数据来源类型 OrSourceFromEnum 既往、组套、模板、常规、分类...
		ciEmsDto.setId_orsrc_main(ciOrTmplDTO.getId_orsrc_main());// 数据来源id ，既往id_or ,组套的定义id，模板(常规)id， 分类id
		ciEmsDto.setId_orsrc_sub(ciOrTmplDTO.getId_orsrc_sub()); // 模板（常规）明细id
		ciEmsDto.setId_orsrc_subsub(ciOrTmplDTO.getId_orsrc_subsub());// 医嘱来源孙标识
		// 存在保外诊断时，医保就诊状态调整为不需要判断医保状态（非医保状态）
		if (HpBeyondEnum.HPEXTERNALDIAG.equals(envinfo.getEu_hpbeyond())) {
			ciEmsDto.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);
		}

		ciEmsDto.setBhpjudgerst(envinfo.getBhpjudgerst()); // 基本医保判断结果数据信息
		ciEmsDto.setDes_bhpjudgerst(envinfo.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述

		if (OrSourceFromEnum.IIHCLINICALKITHELPER == ciOrTmplDTO.getEu_orsrcmdtp()
				&& ciOrTmplDTO.getFg_set() == FBoolean.TRUE) {// 来源组套
			this.setMkrSetProperty(ciEmsDto, envinfo, ciOrTmplDTO, medSrvDO);
		} else {
			// 创建套内项目集合
			ciEmsDto.setSrvsetitms(this.createCiEmsSrvSetItems(ciOrTmplDTO));

			// 医嘱项目
			FArrayList list = this.getEmssrvs(envinfo, ciOrTmplDTO, medSrvDO);
			ciEmsDto.setEmssrvs(list);// 医疗单项目集合
			
			// ciEmsDto 保留剂量			
			CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO)list.get(0);
			ciEmsDto.setQuan_medu(ciEmsSrv.getQuan_med());
			
		}

		// 设置服务价格
		this.setCiEmsPrice(envinfo, ciEmsDto, medSrvDO);

		FArrayList emssrvList = ciEmsDto.getEmssrvs();
		for (Object obj : emssrvList) {
			CiEmsSrvDTO srvDTO = (CiEmsSrvDTO) obj;
			if (srvDTO.getFg_skintest() == FBoolean.TRUE) {
				ciEmsDto.setFg_skintest(FBoolean.TRUE);
				break;
			}
		}
		// TODO 代煎付数：计算代煎费用使用，草药的代煎付数等于草药付数
		// TODO 标本管理费用计算：检验门诊一条医嘱对应一组标本采集费 检验属性中标本类型，容器类型

	}

	/**
	 * 通过bd服务赋值频次、用法、用法要求、煎法、煎法要求、医嘱天数
	 * 
	 * @param ciEmsDto
	 * @param tmplSrvDTO
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void setCiEmsDTOUseDetailByMedSrv(CiEnContextDTO envinfo,CiEmsDTO ciEmsDto, MedSrvDO medSrvDO) throws BizException {

		// 频次
		if (StringUtils.isBlank(ciEmsDto.getId_freq())) {
			ciEmsDto.setId_freq(medSrvDO.getId_freq());
		}

		// 获取SD中频次
		FreqDefDO freqDef = ifreqdefMDORService.findById(ciEmsDto.getId_freq());
		if (freqDef == null) {
			throw new BizException("获取频次SD失败！");
		}

		ciEmsDto.setFg_long(freqDef.getFg_long()); // 常临标识 住院根据频次中定义的类型设置常临标识，门诊的都为false
		ciEmsDto.setName_freq(freqDef.getName());// 医嘱频次名称
		ciEmsDto.setFreqct(freqDef.getFreqct()); // 频次周期下次数
		ciEmsDto.setSd_frequnitct(freqDef.getSd_frequnitct()); // 频次周期类型编码
		ciEmsDto.setFrequnitct(freqDef.getFrequnitct());
		
		//住院
		if(envinfo != null && envinfo.getEnt4BannerDTO().getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)){
        	ciEmsDto.setDays_or(null);// 医嘱天数
        }
		// 频次是一次的医嘱天数设置为1
		if(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(freqDef.getFre_code())){
			ciEmsDto.setDays_or(1);
		}
	
		// 根据周期类型确定医嘱默认天数，住院医嘱天数存在 -1
		if (ciEmsDto.getDays_or() == null || ciEmsDto.getDays_or() <= 0) {
			if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(ciEmsDto.getSd_frequnitct())) { //如果频次周期类型是星期，返回一个周期的天数
				ciEmsDto.setDays_or(7);
				//ciEmsDto.setDt_end(fd.getDateTimeAfter(7));
			} else {
				//住院
				if(envinfo != null && envinfo.getEnt4BannerDTO().getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)){
		        	ciEmsDto.setDays_or(null);// 医嘱天数
		        }else{
		        	ciEmsDto.setDays_or(1);
		        }
			
			}
		}
		 

		// 设置用法id、名称
		if (StringUtils.isNotBlank(ciEmsDto.getId_route())) {

			MedUsageDO medUsage = imedusageRService.findById(ciEmsDto.getId_route()); // 用法
			if (medUsage == null) {
				throw new BizException("获取用法SD失败！");
			}
			ciEmsDto.setName_route(medUsage.getName());// 用法名称
		} else {
			ciEmsDto.setId_route(medSrvDO.getId_route());// 用法
			ciEmsDto.setName_route(medSrvDO.getRoute_name());// 用法名称
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isNotBlank(ciEmsDto.getId_routedes())) {
			ciEmsDto.setName_routedes(getName_routes(ciEmsDto.getId_routedes()));
		} else {
			ciEmsDto.setId_routedes(medSrvDO.getId_routedes());
			ciEmsDto.setName_routedes(medSrvDO.getRoutedes_name());
		}

		// 设置煎法id、名称
		if (StringUtils.isNotBlank(ciEmsDto.getId_boil())) {

			CHerbBoilMdDO cHerbBoilMd = icherbboilmdMDORService.findById(ciEmsDto.getId_boil());
			if (cHerbBoilMd == null) {
				throw new BizException("获取煎法SD失败！");
			}
			ciEmsDto.setName_boil(cHerbBoilMd.getName());
		} else {
			ciEmsDto.setId_boil(medSrvDO.getId_boil());
			ciEmsDto.setName_boil(medSrvDO.getBoil_name());
		}

		// 煎法要求
		if (StringUtils.isNotBlank(ciEmsDto.getId_boildes())) {

			CHerbBoilDesDO cherbBoilDes = icHerbBoilDesDORService.findById(ciEmsDto.getId_boildes());
			if (cherbBoilDes == null) {
				throw new BizException("煎法要求SD失败！");
			}
			ciEmsDto.setName_boildes(cherbBoilDes.getName());
		} else {
			ciEmsDto.setId_boildes(medSrvDO.getId_boildes());
			ciEmsDto.setName_boildes(medSrvDO.getBoildes_name());
		}
	}

	/**
	 * @throws BizException
	 * 
	 */
	private void setMkrSetProperty(CiEmsDTO ciEmsDto, CiEnContextDTO envinfo, CiOrTmplDTO ciOrTmpl, MedSrvDO medSrv)
			throws BizException {

		MedSrvDO[] medSrvs = this.getSetMedSrvDOs(ciOrTmpl);
		// 构造套内项目集合
		if (ciOrTmpl.getFg_set() == FBoolean.TRUE) {

			FMap Srvsetitms = this.getSrvSetitmMap(ciOrTmpl.getId_srv(), medSrvs);
			ciEmsDto.setSrvsetitms(Srvsetitms);
		}

		FArrayList ciEmsSrvList = new FArrayList();
		//套的处理
		if (ciEmsDto.getFg_set() == FBoolean.TRUE) {
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
			this.setCiEmSrvPropertys(srvdto, envinfo, null, medSrv);
			this.setCiEmsSrvMeduPropertys(srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders());
			ciEmsSrvList.add(srvdto);
		}

		for (int i = 0; i < medSrvs.length; i++) {

			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();

			// 设置CiEmsSrvDTO相关属性，环境、服务、物品
			this.setCiEmSrvPropertys(srvdto, envinfo, null, medSrvs[i]);

			// 设置量信息
			this.setCiEmsSrvMeduPropertys(srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders());
			srvdto.setSortno(i + 1);// 设置排序
			if (ciOrTmpl.getFg_set() == FBoolean.TRUE) {
				srvdto.setId_srv_set(ciOrTmpl.getId_srv());
			}
			srvdto.setCode_srv(medSrv.getCode());
			ciEmsSrvList.add(srvdto);
		}
		ciEmsDto.setEmssrvs(ciEmsSrvList);
		CiEmsSrvDTO srvDTO = (CiEmsSrvDTO) ciEmsSrvList.get(0);
		ciEmsDto.setQuan_medu(srvDTO.getQuan_med());

		if (ciEmsDto.getSd_srvtp() != null
				&& ciEmsDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
			ciEmsDto.setNote(" " + ciEmsDto.getName_boil() + " " + srvDTO.getQuan_med() + "," + ciEmsDto.getName_freq()
					+ "," + ciEmsDto.getName_route());

		} else {
			//ciEmsDto.setNote();
		}

	}

	/**
	 * 获取CiEmsSrvDTO集合
	 * 
	 * @param envinfo 当前环境吧信息
	 * @param ciOrTmpl 医嘱模板
	 * @param medSrv 基础服务
	 * @return
	 * @throws BizException
	 */
	private FArrayList getEmssrvs(CiEnContextDTO envinfo, CiOrTmplDTO ciOrTmpl, MedSrvDO medSrv) throws BizException {

		FArrayList ciEmsSrvList = new FArrayList();
		FArrayList srvlist = ciOrTmpl.getOrtmplsrvs();
		//套的处理
		if (medSrv.getFg_set() == FBoolean.TRUE) {
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();

			this.setCiEmSrvPropertys(srvdto, envinfo, null, medSrv);
			this.setCiEmsSrvMeduPropertys(srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders());
			ciEmsSrvList.add(srvdto);
		}

		MedSrvDO tempMedSrv = null;
		for (int i = 0; i < srvlist.size(); i++) {
			CiOrTmplSrvDTO tmplSrv = (CiOrTmplSrvDTO) srvlist.get(i);
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
			srvdto.setId_hp(envinfo.getId_hp());
			tempMedSrv = CiOrdAppUtils.getIMedsrvMDORService().findById(tmplSrv.getId_srv());// 获取每个项目
			// 设置CiEmsSrvDTO相关属性，环境、模板、服务、物品
			this.setCiEmSrvPropertys(srvdto, envinfo, tmplSrv, tempMedSrv);
			// 设置量信息
			this.setCiEmsSrvMeduPropertys(srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders());
			srvdto.setSortno(i + 1);// 设置排序			
			//是套服务时才设置id_srv_set属性 2016-11-28
			if (medSrv.getFg_set() == FBoolean.TRUE) {
				srvdto.setId_srv_set(ciOrTmpl.getId_srv());
			}
			srvdto.setCode_srv(medSrv.getCode());
			ciEmsSrvList.add(srvdto);
		}
		return ciEmsSrvList;
	}

	/**
	 * 设置CiEmsSrvDTO对象属性
	 * 
	 * @param srvdto
	 * @param envinfo
	 * @param tmplSrv 医嘱模板（组套数据转换该值为null）
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmSrvPropertys(CiEmsSrvDTO srvdto, CiEnContextDTO envinfo, CiOrTmplSrvDTO tmplSrv,
			MedSrvDO medSrv) throws BizException {

		// 设置环境相关属性
		this.setCiEmsSrvEnvinfoPropertys(srvdto, envinfo);
		if (tmplSrv != null) { // 医嘱模板进来的为空
			// 设置模板中的属性
			this.setCiEmSrvTmplPropertys(srvdto, tmplSrv);
		}
		// 设置服务相关属性
		this.setCiEmsSrvMedSrvPropertys(srvdto, medSrv);
		// 设置物品相关属性
		this.setCiEmsSrvMmPropertys(srvdto, envinfo, medSrv);

		// 设置执行科室相关属性
		this.setCiEmsSrvOrWfDept(srvdto, envinfo, medSrv);

		// 医保就诊，并且都是保内诊断时为医保就诊，否则为自费（保外）
		if (envinfo.getId_hp() != null && HpBeyondEnum.HPDIAG.equals(envinfo.getEu_hpbeyond())) {
			srvdto.setFg_selfpay(FBoolean.FALSE);// 保内，非自费
		} else {
			srvdto.setFg_selfpay(FBoolean.TRUE);// 保外 、自费
		}
		
	}

	/**
	 * 设置环境相关属性
	 * 
	 * @param srvdto 服务项目
	 * @param envinfo 当前环境
	 */
	private void setCiEmsSrvEnvinfoPropertys(CiEmsSrvDTO srvdto, CiEnContextDTO envinfo) {

		srvdto.setStatus(DOStatus.NEW);

		srvdto.setId_dep_srv(envinfo.getId_dep_or());// 开立科室
		srvdto.setId_ward_srv(envinfo.getId_dep_ns());// 开立病区，门诊该值为空，住院时会有值
		srvdto.setId_emp_srv(envinfo.getId_emp_or());// 开立人员
		srvdto.setDt_create_srv(CiOrdAppUtils.getServerDateTime());// 开立时间
		srvdto.setId_hp(envinfo.getId_hp());// 主医保计划

		srvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);// 医疗单项目数据来源方式
	}

	/**
	 * 设置模板中相关属性
	 * 
	 * @param srvdto
	 * @param envinfo
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmSrvTmplPropertys(CiEmsSrvDTO srvdto, CiOrTmplSrvDTO tmplSrv) throws BizException {

		// srvdto.setId_orsrv(tmplSrv.getId_orsrv());//医疗单项目主键标识
		// srvdto.setId_or(tmplSrv.getId_or());//医疗单
		// srvdto.setSortno(tmplSrv.getSortno());// 序号 循环时统一设置
		srvdto.setId_srv(tmplSrv.getId_srv());// 医疗服务
		srvdto.setFg_self(tmplSrv.getFg_selfsrv()); // 自定义服务标识
		if (srvdto.getFg_self() == FBoolean.TRUE) { // 自定义服务名，只有就诊历史会出现自定义服务
			srvdto.setName_srv(tmplSrv.getName_selfsrv());
		}
		srvdto.setFg_set(tmplSrv.getFg_set()); // TODO 套属性 套内项目，基本服务，套属性都应该是false ,自定义服务有tao概念没？
		srvdto.setId_srvtp(tmplSrv.getId_srvtp());// 服务类型
		srvdto.setSd_srvtp(tmplSrv.getSd_srvtp());// 服务类型编码
		srvdto.setId_freq(tmplSrv.getId_freq());// 频次
		srvdto.setId_route(tmplSrv.getId_route());// 用法
		srvdto.setId_routedes(tmplSrv.getId_routedes());// 用法要求
		srvdto.setId_boil(tmplSrv.getId_boil());// 煎法
		srvdto.setId_boildes(tmplSrv.getId_boildes());// 煎法要求
		srvdto.setQuan_med(tmplSrv.getQuan_med());// 医学单位数值（剂量）
		srvdto.setId_unit_med(tmplSrv.getId_unit_med());// 医学单位（计量单位）
		srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu()); // 总量 TODO 对于服务套来说，缺少总量单位

		srvdto.setId_dep(tmplSrv.getId_dep_mp()); // 执行科室
		srvdto.setId_mm(tmplSrv.getId_mm());// 物品		
	}

	/**
	 * 通过MedSrvDO补全CiEmsSrvDTO中缺失的属性
	 * 
	 * @param srvdto CiEmsSrvDTO对象
	 * @param medSrv 服务对象
	 * @param sortNo 排序号
	 * @param idSrvSet 所属的服务套id
	 * @throws BizException
	 */
	private void setCiEmsSrvMedSrvPropertys(CiEmsSrvDTO srvdto, MedSrvDO medSrv) throws BizException {

		// 频次
		if (StringUtils.isBlank(srvdto.getId_freq())) {
			srvdto.setId_freq(medSrv.getId_freq());
		}

		// 设置用法id
		if (StringUtils.isBlank(srvdto.getId_route())) {
			srvdto.setId_route(medSrv.getId_route());
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isBlank(srvdto.getId_routedes())) {
			srvdto.setId_routedes(medSrv.getId_routedes());
		}

		// 设置煎法id
		if (StringUtils.isBlank(srvdto.getId_boil())) {
			srvdto.setId_boil(medSrv.getId_boil());
		}

		// 煎法要求
		if (StringUtils.isBlank(srvdto.getId_boildes())) {
			srvdto.setId_boildes(medSrv.getId_boildes());
		}

		// 设置频次、用法、用法要求、煎法、煎法要求
		this.setCiEmsSrvUseDetail(srvdto, medSrv);

		// srvdto.setId_orsrv(tmplSrv.getId_orsrv());//医疗单项目主键标识
		// srvdto.setId_or(tmplSrv.getId_or());//医疗单
		// srvdto.setSortno(sortNo);// 序号

		if (StringUtils.isBlank(srvdto.getId_srv())) {
			srvdto.setId_srv(medSrv.getId_srv());// 医疗服务
		}

		if (StringUtils.isBlank(srvdto.getId_srvtp())) {
			srvdto.setId_srvtp(medSrv.getId_srvtp());// 服务类型
		}

		if (StringUtils.isBlank(srvdto.getSd_srvtp())) {
			srvdto.setSd_srvtp(medSrv.getSd_srvtp());// 服务类型编码
		}

		srvdto.setCode_srv(medSrv.getCode());// 医疗服务编码
		srvdto.setName_srv(medSrv.getName());// 医疗服务名称
		srvdto.setId_srvca(medSrv.getId_srvca());// 服务项目基本分类

		if (isFDoubleEmpty(srvdto.getQuan_med())) {
			srvdto.setQuan_med(medSrv.getQuan_med());// 医学单位数值（剂量）
		}

		if (StringUtils.isBlank(srvdto.getId_unit_med())) {
			srvdto.setId_unit_med(medSrv.getId_unit_med());// 医学单位(剂量单位)
		}
		srvdto.setName_unit_med(medSrv.getMed_name()); // 医学单位名称（剂量单位名称）

		//srvdto.setPrice(medSrv.getPri());// 参考价格 TODO 参考价为空时需要重新计算

		// srvdto.setFg_dose_anoma(tmplSrv.getFg_dose_anoma());//变动用药标识
		// srvdto.setDes_srv(tmplSrv.getDes_srv());//备注

		srvdto.setFg_mm(medSrv.getFg_mm());// 物品标识
		srvdto.setFg_set(medSrv.getFg_set());// 服务套标识 套内项目全设置为False TODO		
		// srvdto.setId_srv_set(medSrv.getId_srv()); 在循环过程中设置该属性
		MedSrvSetItemDO medSrvSetItem = setItemSrvMap.get(srvdto.getId_srv());
		if (medSrvSetItem != null) {
			srvdto.setFg_or(medSrvSetItem.getFg_clinical());// 医嘱标识	
		} else {
			srvdto.setFg_or(medSrv.getFg_or());// 医嘱标识
		}

		srvdto.setFg_bl(medSrv.getFg_bl());// 费用标识
		// srvdto.setFg_self(medSrvDO.getFg_self());//自备药标识
		// srvdto.setFg_outp(tmplSrv.getFg_outp());//出院带药标识（废弃不用了）
		// srvdto.setFg_propc(tmplSrv.getFg_propc());//预防用药标识
		// srvdto.setFg_treat(tmplSrv.getFg_treat());//治疗用药标识
		// srvdto.setId_org_srv(envinfo.getId_org_or());//开立机构
		// srvdto.setId_dep_srv(envinfo.getId_dep_or());// 开立科室
		// srvdto.setId_ward_srv(envinfo.getId_dep_ns());// 开立病区，门诊该值为空，住院时会有值
		// srvdto.setId_emp_srv(envinfo.getId_emp_or());// 开立人员
		// srvdto.setDt_create_srv(CiOrdAppUtils.getServerDateTime());// 开立时间
		// OrWfDeptInfoDTO deptMpDTo1 = getMpDeptID(envinfo, medSrv); // 执行科室
		//
		// srvdto.setId_dep(deptMpDTo.getFirstid_mp_dept());// 执行科室
		// srvdto.setName_dep(deptMpDTo.getFirstname_mp_dept());// 执行科室名称
		// srvdto.setDt_last_bl(tmplSrv.getDt_last_bl());//最近生成日期
		srvdto.setEu_blmd(medSrv.getEu_blmd());// 划价方式
		// srvdto.setId_orsrvmm(tmplSrv.getId_orsrvmm());//服务项目物品
		// srvdto.setId_mm(tmplSrv.getId_mm());// 物品

		// srvdto.setEmsfreqdose(tmplSrv.getEmsfreqdose());//变动用药安排

		MedSrvRisDO medSrvRis = srvRisMap.get(srvdto.getId_srv());
		if (medSrvRis != null && srvdto.getFg_set() != FBoolean.TRUE) {
			srvdto.setId_body(medSrvRis.getId_body());//部位
			srvdto.setSd_body(medSrvRis.getSd_body());//部位编码
			srvdto.setBody_name(medSrvRis.getName_body());//部位名称
			srvdto.setId_pos(medSrvRis.getId_pos());//体位
			srvdto.setSd_pos(medSrvRis.getSd_pos());//体位编码
			srvdto.setPos_name(medSrvRis.getName_pos());//体位名称
		}

		// srvdto.setFg_indic(tmplSrv.getFg_indic());//医保适应症标识
		srvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);// 医疗单项目数据来源方式
		// srvdto.setSrv_sv(medSrvDO.getSrv_sv());//服务版本号
		// srvdto.setMm_sv(tmplSrv.getMm_sv());//物品版本号
		// srvdto.setFg_skintest(tmplSrv.getFg_skintest());//需皮试标识
		// srvdto.setId_skintest_skip_reason(tmplSrv.getId_skintest_skip_reason());//不皮试原因
		// srvdto.setSd_skintest_skip_reason(tmplSrv.getSd_skintest_skip_reason());//不皮试原因编码
		// srvdto.setId_reltp(tmplSrv.getId_reltp());//关联类型
		// srvdto.setSd_reltp(tmplSrv.getSd_reltp());//关联类型编码
		// srvdto.setId_or_rel(tmplSrv.getId_or_rel());//关联医嘱
		// srvdto.setFg_skintest_rst(tmplSrv.getFg_skintest_rst());//皮试是否有结果
		srvdto.setFg_selfsrv(medSrv.getFg_ctm());// 自定义服务标识
		// srvdto.setId_srv_src(tmplSrv.getId_srv_src());//所属来源服务
		// srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu());// 服务总量
		srvdto.setId_primd(medSrv.getId_primd());// 定价模式
		// srvdto.setFg_selfpay(medSrvDO.getFg_selfpay());//自费标识
		// srvdto.setId_hp(envinfo.getId_hp());// 主医保计划
		// srvdto.setId_hpsrvtp(tmplSrv.getId_hpsrvtp());//医保目录类型
		// srvdto.setSd_hpsrvtp(tmplSrv.getSd_hpsrvtp());//医保目录类型编码
		// srvdto.setId_dep_wh(deptMpDTo.getId_dep_wh());// 仓库
		// srvdto.setEmsagentinfo(tmplSrv.getEmsagentinfo());//毒麻药品服务代办人信息
		srvdto.setInnercode_srvca(medSrv.getSrvca_code());// 服务分类内码
		// srvdto.setSd_frequnitct(tmplSrv.getSd_frequnitct());//频次周期类型
		// srvdto.setFrequnitct(tmplSrv.getFrequnitct());//频次周期数
		// srvdto.setFreqct(tmplSrv.getFreqct());//频次周期下次数
		// srvdto.setName_hpsrvtp(tmplSrv.getName_hpsrvtp());//医保目录名称
		// srvdto.setLimit(tmplSrv.getLimit());//限制报销条件
		// srvdto.setAmt_total(tmplSrv.getAmt_total());//总金额
		// srvdto.setName_dep_wh(deptMpDTo.getId_dep_wh());// 库房名称
		// srvdto.setId_unit_cg(tmplSrv.getId_unit_cg());//计费单位
		// srvdto.setName_unit_cg(meterial.getParentDO().getName_unit_cg());//计费单位名称
		// srvdto.setQuan_cgbase(meterial.getParentDO().getQuan_cgbase());//计费基数
		// srvdto.setFactor_cm(meterial.getParentDO().getFactor_cm());//系数_费医
		// srvdto.setSd_roundmd_cg(meterial.getParentDO().getSd_roundmd_cg());//计费取整模式

		// srvdto.setAmt_cur(tmplSrv.getAmt_cur());//金额
		// srvdto.setQuan_stock(tmplSrv.getQuan_stock());//可用库存
		// srvdto.setId_srvskin(tmplSrv.getId_srvskin());//对应皮试服务
		// srvdto.setMapkeys(tmplSrv.getMapkeys());//关联信息Map键值串
		// srvdto.setMapinfo(tmplSrv.getMapinfo());//服务与物品关联信息MAP
		// srvdto.setPriby(tmplSrv.getPriby());//计价依据
		// srvdto.setFg_base(tmplSrv.getFg_base());//基数药标识

		// TODO 调用计算总量方法
	}

	/**
	 * 设置CiEmsSrvDTO中物品相关属性
	 * 
	 * @param srvdto
	 * @param envinfo
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmsSrvMmPropertys(CiEmsSrvDTO srvdto, CiEnContextDTO envinfo, MedSrvDO medSrv)
			throws BizException {

		if(medSrv.getFg_mm() != FBoolean.TRUE){
			return ;
		}
		MeterialAggDO meterialAgg = null;
		if (StringUtils.isNotBlank(srvdto.getId_mm())) {
			meterialAgg = CiOrdAppUtils.getIMeterialRService().findById(srvdto.getId_mm());
		} else {
			String whereStr = MeterialDODesc.TABLE_ALIAS_NAME + "." + MeterialDO.ID_SRV + " = '" + medSrv.getId_srv()
					+ "'";
			MeterialAggDO[] meterAggDO = CiOrdAppUtils.getIMeterialRService().find(whereStr, MeterialDO.ID_SRV,
					FBoolean.FALSE);
			if (meterAggDO != null && meterAggDO.length > 0) {
				meterialAgg = meterAggDO[0];
			}
		}

		if (meterialAgg == null) {
			OrdBizLogger.info(envinfo, "服务【"+medSrv.getName()+"】没有查询到关联的物品！");
			throw new BizRuntimeException("服务【"+medSrv.getName()+"】没有查询到关联的物品！");
		}

		MeterialDO meterial = meterialAgg.getParentDO();
		srvdto.setFg_skintest(meterial.getFg_skin());
		srvdto.setId_srvskin(meterial.getId_srvskin());
		// srvdto.setQuan_cur(tmplSrv.getQuan_cur());//总量_当前
		/// srvdto.setQuan_base(meterial.getQuan_base());//总量_基本
		srvdto.setId_mm(meterial.getId_mm());// 物品id
		srvdto.setName_mm(meterial.getName());// 物品名称
		srvdto.setSpec_mm(meterial.getSpec());// 规格
		// 获取物品的有效单位
		MaterialUnitDTO[] materIalUnits = imaterialInfoService.getMMunitByEntp(new String[] { srvdto.getId_mm() },
				envinfo.getCode_entp());
		srvdto.setId_unit_sale(materIalUnits[0].getId_measdoc());// 零售单位
		srvdto.setName_unit_sale(materIalUnits[0].getMeasdoc_name());// 零售单位名称	

		srvdto.setId_unit_base(meterial.getId_unit_pkgbase());// 基本单位
		srvdto.setName_unit_base(meterial.getPkgbase_name());// 基本单位名称
		// srvdto.setQuan_num_base(meterial.getParentDO().getQuan_num_base());//单次数量_分子
		// srvdto.setQuan_den_base(meterial.getParentDO().getQuan_den_base());//单次数量_分母
		// srvdto.setPrice_cur(tmplSrv.getPrice_cur());//参考价当前
		// srvdto.setQuan_bed_medu(tmplSrv.getQuan_bed_medu());//床边量_医学
		srvdto.setFactor_cb(materIalUnits[0].getFactor());// 当前基本换算系数
		srvdto.setFactor_mb(meterial.getFactor_mb());// 医疗基本换算系数
		// srvdto.setFactor(getSaleFactor(meterial,srvdto.getId_unit_sale()));//总量单位换算系数
		FDouble pricce = this.getMMPrice(meterial.getId_mm(), materIalUnits[0].getId_measdoc());
		srvdto.setPrice_cur(pricce);
		srvdto.setPrice(pricce);
		if (iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(envinfo.getCode_entp())) {
			srvdto.setSd_roundmd(meterial.getSd_mupkgutp());// 住院-取整方式
		} else {
			srvdto.setSd_roundmd(meterial.getSd_opmutp());// 门诊-取整方式
		}
		srvdto.setId_mupkgutp(meterial.getId_mupkgutp());//物品住院取整模式id
		srvdto.setSd_mupkgutp(meterial.getSd_mupkgutp());//物品住院取整模式d
		srvdto.setId_opmutp(meterial.getId_opmutp());//物品门诊取整模式id
		srvdto.setSd_opmutp(meterial.getSd_opmutp());//物品门诊取整模式sd
		// 获取药品属性 代优化 查询位置不对
		String whereStr = MedSrvDrugDO.ID_SRV + "='" + medSrv.getId_srv() + "'";
		MedSrvDrugDO[] drugDO = CiOrdAppUtils.getIMedSrvDrugDORService().find(whereStr, MedSrvDrugDO.ID_SRV,
				FBoolean.FALSE);
		if (drugDO != null && drugDO.length > 0) {
			srvdto.setId_dosage(drugDO[0].getId_dosage());// 药品剂型
			srvdto.setSd_dosage(drugDO[0].getSd_dosage());// 药品剂型编码
			srvdto.setId_pharm(drugDO[0].getId_pharm());// 药理分类
			srvdto.setSd_pharm(drugDO[0].getSd_pharm());// 药理分类编码
			srvdto.setId_pois(drugDO[0].getId_pois());// 毒麻分类
			srvdto.setSd_pois(drugDO[0].getSd_pois());// 毒麻分类编码
			srvdto.setId_anti(drugDO[0].getId_anti());// 抗菌药分类
			srvdto.setSd_anti(drugDO[0].getSd_anti());// 抗菌药分类编码
		}

		srvdto.setId_mmtp(meterial.getId_mmtp());// 物品类型
		srvdto.setSd_mmtp(meterial.getSd_mmtp());// 物品类型编码
		srvdto.setName_mmtp(meterial.getMmca_name());// 物品类型名称
		srvdto.setId_sup(meterial.getId_sup());// 厂家
		srvdto.setName_sup(meterial.getFactory_name());// 厂家名称
		srvdto.setCode_mm(meterial.getCode());// 物品编码
		srvdto.setSd_val(meterial.getSd_val());// 价值分类编码
		srvdto.setId_val(meterial.getId_val());// 价值分类
		srvdto.setIndica(meterial.getIndica());// 适应症
		srvdto.setConstr(meterial.getConstr());// 禁忌症
		srvdto.setReact(meterial.getReact());// 不良反应
		//		 srvdto.setGuide(meterial.getGuide());//主要作用
		srvdto.setFg_otc(meterial.getFg_otc());// OTC标识	

		//srvdto.setPrice(meterial.getPrice());// 零售价
	}

	/**
	 * 设置服务价格
	 * 
	 * @param srvdto
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmsPrice(CiEnContextDTO envinfo, CiEmsDTO ciEmsDto, MedSrvDO medSrv) throws BizException {

		String id_pripat = envinfo.getEnt4BannerDTO().getId_pripat();
		FArrayList emssrvList = ciEmsDto.getEmssrvs();
		CiEmsSrvDTO srvdto = (CiEmsSrvDTO) emssrvList.get(0);
		// 如果价格不为空，或者套内项目不进行价格计算
		if (srvdto.getPrice() != null) {
			return;
		}

		// 构造查询价格参数
		BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
		param.setId_srv(medSrv.getId_srv());
		param.setName_srv(medSrv.getName());
		param.setId_primd(medSrv.getId_primd());
		param.setNum(0);
		// 如果是套，根据套内项目计算价格, 排除服务套单选模式
		if (ciEmsDto.getFg_set() == FBoolean.TRUE && medSrv.getFg_setradio() != FBoolean.TRUE) {

			// 计算费用的套内项目个数
			int clinicalBlCnt = 0;
			List<MedSrvSetItemDO> srvsetitmList = srvSetItemsMap.get(ciEmsDto.getId_srv());
			FArrayList list = new FArrayList();
			if(srvsetitmList == null || srvsetitmList.size() == 0){
				OrdBizLogger.info(envinfo, "服务["+ciEmsDto.getName() + "]未找到对应的套内项目！");
				throw new BizRuntimeException("服务["+ciEmsDto.getName() + "]未找到对应的套内项目！");
			}
			for (MedSrvSetItemDO medSrvSetItem : srvsetitmList) {

				// 非临床的不计算价格
				if (medSrvSetItem.getFg_clinical() != FBoolean.TRUE) {
					continue;
				}

				BdSrvPriCalParamDTO srvParamDTO = new BdSrvPriCalParamDTO();
				srvParamDTO.setId_primd(medSrv.getId_primd());
				srvParamDTO.setNum(1);
				srvParamDTO.setId_srv(medSrvSetItem.getId_srv_itm());

				// 诊疗项目中勾选临床价格计算标识的才计算个数
				if (medSrvSetItem.getFg_clinical_bl() == FBoolean.TRUE) {
					clinicalBlCnt++;
				}
				list.add(srvParamDTO);
			}

			param.setNum(clinicalBlCnt);
			param.setSrvsetitms(list);
		}

		CiOrBdSrvPricesCalByPriModeBP bp = new CiOrBdSrvPricesCalByPriModeBP();
		MedSrvPriceDO medSrvPrice = bp.exec(param,id_pripat);	
		// 存在不计费服务
		if (null != medSrvPrice){
			srvdto.setPrice(medSrvPrice.getPrice_ratio());
			srvdto.setPri_ratio(medSrvPrice.getPrice_ratio());
			srvdto.setPri_std(medSrvPrice.getPrice_std());
			srvdto.setPrice_cur(medSrvPrice.getPrice_ratio());
			srvdto.setId_pripat(id_pripat);
		}
		else{
			srvdto.setPrice(FDouble.ZERO_DBL);
			srvdto.setPri_ratio(FDouble.ONE_DBL);
			srvdto.setPri_std(FDouble.ZERO_DBL);
			srvdto.setPrice_cur(FDouble.ZERO_DBL);
			srvdto.setId_pripat(id_pripat);
		}

	}

	/**
	 * 计算CiEmsSrvDTO中的总量
	 * 
	 * @param srvdto 服务项目对象
	 * @param useDays 使用天数
	 * @param orders 医嘱付数（草药使用）
	 * @throws BizException
	 */
	private void setCiEmsSrvMeduPropertys(CiEmsSrvDTO srvdto, Integer useDays, Integer orders) throws BizException {

		useDays = useDays == null ? 1 : useDays;
		orders = orders == null ? 7 : orders;

		// 如果是物品，重新获取物品对象 TODO 计算总量
		if (srvdto.getFg_mm() == FBoolean.TRUE) {
			// 计算药品总量
			if (srvdto.getFg_dose_anoma() == FBoolean.TRUE) { // 变动用药计算总量
				GetDrugTotalQuan4DoseBP bp = new GetDrugTotalQuan4DoseBP();
				srvdto.setQuan_cur(new FDouble(bp.exec(srvdto, useDays)));
			} else {
				if (srvdto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) { // 草药计算总量
					GetDrugTotalQuan4HerbsBP bp = new GetDrugTotalQuan4HerbsBP();
					srvdto.setQuan_cur(bp.exec(srvdto, orders));
				} else {
					GetDrugTotalQuanBP bp = new GetDrugTotalQuanBP();
					srvdto.setQuan_cur(new FDouble(bp.exec(srvdto, useDays)));
				}
			}
			// 领量天数
			srvdto.setDays_available(new GetDrugDaysOfAvailable().exec(srvdto));
		} else {
			// 计算非药品服务总量
			GetSrvTotalQuanBP bp = new GetSrvTotalQuanBP();
			srvdto.setQuan_cur(new FDouble(bp.exec(srvdto, useDays)));
			srvdto.setQuan_total_medu(srvdto.getQuan_cur());
		}
	}

	/**
	 * 设置CiEmsSrvDTO中执行科室相关属性
	 * 
	 * @param srvdto CiEmsSrv 服务项目
	 * @param envinfo 当前环境
	 * @param medSrv bd中医疗服务对象
	 * @throws BizException
	 */
	private void setCiEmsSrvOrWfDept(CiEmsSrvDTO srvdto, CiEnContextDTO envinfo, MedSrvDO medSrv) throws BizException {		
//		OrWfDeptInfoDTO deptMpDTo = getMpDeptID(envinfo, medSrv,srvdto.getId_dep());
//		srvdto.setId_dep(deptMpDTo.getFirstid_mp_dept());// 执行科室 移动到映射完CiEmsDTO CiEmsSrvDTO 对象后在重新映射执行科室
//		srvdto.setName_dep(deptMpDTo.getFirstname_mp_dept());// 执行科室名称

		// 获取执行科室
		OrWfDeptInfoDTO wf = getMpDeptID(envinfo, medSrv);
		if (null != wf) {
			srvdto.setId_dep_wh(wf.getId_dept_wh());// 仓库
			srvdto.setName_dep_wh(wf.getName_dept_wh()); // 仓库的名称
		}
	}

	/**
	 * 判断FDouble类型数据是否为空
	 * 
	 * @param doubleData 待判断的数据
	 * @return true doubleData为空，否则不为空
	 */
	private boolean isFDoubleEmpty(FDouble doubleData) {

		FDouble date1 = new FDouble(0.00000001);
		if (doubleData == null || date1.compareTo(doubleData) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获取物品基本包装单位价格
	 * 
	 * @param id_mm 物品id
	 * @param id_unit_sale 物品零售单位
	 * @return
	 */
	private FDouble getMMPrice(String id_mm, String id_unit_sale) throws BizException {
		IMaterialStockService service = ServiceFinder.find(IMaterialStockService.class);
		GetStockReqDTO reqDto = new GetStockReqDTO();
		reqDto.setId_mm(id_mm);
		reqDto.setReq_unit_id(id_unit_sale);
		GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
		reqDtoArr[0] = reqDto;
		MaterialStockDTO[] materials = service.getMaterialStocks(reqDtoArr);
		if (materials != null && materials.length > 0) {
			return materials[0].getPrice_act();
		} else {
			return null;
		}
	}

	/**
	 * 创建套内项目
	 * 
	 * @param envinfo
	 * @param ciOrTmpl
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private FMap createCiEmsSrvSetItems(CiOrTmplDTO ciOrTmpl) throws BizException {

		FMap fmap = null;
		if (ciOrTmpl.getFg_set() != FBoolean.TRUE) {
			return fmap;
		}

		// 获取模板对应的套内项目
		MedSrvDO[] medSrvs = this.getSetMedSrvDOs(ciOrTmpl);

		return this.getSrvSetitmMap(ciOrTmpl.getId_srv(), medSrvs);
	}

	/**
	 * 获取套的map结果，
	 * 
	 * @param idSrv
	 * @param medSrvs
	 * @return
	 */
	private FMap getSrvSetitmMap(String idSrv, MedSrvDO[] medSrvs) {

		FMap fmap = new FMap();
		FArrayList ordSrvSetList = new FArrayList();
		List<MedSrvSetItemDO> setItems = srvSetItemsMap.get(idSrv);
		if (setItems != null && setItems.size() > 0) {
			for (MedSrvSetItemDO setItem : setItems) {
				OrdSrvSetDO ordSrvSet = new OrdSrvSetDO();
				ordSrvSet.setStatus(DOStatus.NEW);
				ordSrvSet.setId_srvsetdef(setItem.getId_srv()); // 服务套id 
				ordSrvSet.setId_srvset(setItem.getId_srv_itm()); //套内项目id
				ordSrvSet.setSortno(setItem.getSortno()); // 排序号
				ordSrvSet.setDes_srv(setItem.getDes()); // 套内服务项目描述
				ordSrvSet.setId_srvsetrole(setItem.getId_srvsetrole()); // 成员角色
				ordSrvSet.setSd_srvsetrole(setItem.getSd_srvsetrole()); // 成员角色编码
				ordSrvSet.setId_medu(setItem.getId_medu()); // 计量单位
				ordSrvSet.setQuan_medu(setItem.getQuan_medu()); // 数值_医疗单位
				ordSrvSet.setId_freqdef(setItem.getId_freq()); // 频次id
				//				ordSrvSet.setSd_body( ); 

				ordSrvSetList.add(ordSrvSet);
			}
		}

		fmap.put(idSrv, ordSrvSetList);
		return fmap;
	}

	/**
	 * 获取套的套内项目服务集合
	 * 
	 * @param ciOrTmpl 模板
	 * @return 如果模板中的项目为空，返回套内项目，如果模板选择了部分套内项目，按选择的结果返回
	 * @throws BizException
	 */
	private MedSrvDO[] getSetMedSrvDOs(CiOrTmplDTO ciOrTmpl) throws BizException {

		MedSrvDO[] medSrvs = null;
		FArrayList ortmplsrvs = ciOrTmpl.getOrtmplsrvs();
		if (OrSourceFromEnum.IIHCLINICALKITHELPER == ciOrTmpl.getEu_orsrcmdtp()
				&& ciOrTmpl.getFg_set() == FBoolean.TRUE) {// 来源组套

			String whereStr = "id_srv in (select srvset.id_srv_itm from bd_srvset_def srvset where srvset.id_srv ='"
					+ ciOrTmpl.getId_srv() + "')";
			medSrvs = imedsrvMDORService.find(whereStr, null, FBoolean.FALSE);
		} else {
			List<String> idSrvList = new ArrayList<String>();
			for (Object obj : ortmplsrvs) {
				CiOrTmplSrvDTO setItem = (CiOrTmplSrvDTO) obj;
				idSrvList.add(setItem.getId_srv());
			}

			medSrvs = imedsrvMDORService.findByIds(idSrvList.toArray(new String[0]), FBoolean.FALSE);
		}

		return medSrvs;
	}

	/**
	 * 设置CiEmsSrvDTO 频次、用法、用法要求、煎法、煎法要求
	 * 
	 * @param ciEmsDto
	 * @param tmplSrvDTO CiEmsDTO ciEmsDto
	 * @throws BizException
	 */
	private void setCiEmsSrvUseDetail(CiEmsSrvDTO srvdto, MedSrvDO medSrvDO) throws BizException {

		// 频次
		if (StringUtils.isBlank(srvdto.getId_freq())) {
			throw new BizException("频次不能为空！");
		}

		FreqDefDO freqDef = ifreqdefMDORService.findById(srvdto.getId_freq());
		if (freqDef == null) {
			throw new BizException("获取频次SD失败！");
		}
		srvdto.setId_freq(freqDef.getId_freq());
		srvdto.setName_freq(freqDef.getName());// 医嘱频次名称
		srvdto.setFreqct(freqDef.getFreqct()); // 频次周期下次数		
		srvdto.setSd_frequnitct(freqDef.getSd_frequnitct()); // 频次周期编码
		srvdto.setFrequnitct(freqDef.getFreqct());// TODO 频次周期数，使用混淆	

		// 设置用法id、名称
		if (StringUtils.isNotBlank(srvdto.getId_route())) {

			MedUsageDO medUsage = imedusageRService.findById(srvdto.getId_route()); // 用法
			if (medUsage == null) {
				throw new BizException("获取用法SD失败！");
			}
			srvdto.setName_route(medUsage.getName());// 用法名称
		} else {
			srvdto.setId_route(medSrvDO.getId_route());// 用法
			srvdto.setName_route(medSrvDO.getRoute_name());// 用法名称
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isNotBlank(srvdto.getId_routedes())) {
			srvdto.setName_routedes(this.getName_routes(srvdto.getId_routedes()));
		} else {
			srvdto.setId_routedes(medSrvDO.getId_routedes());
			srvdto.setName_routedes(medSrvDO.getRoutedes_name());
		}

		// 设置煎法id、名称
		if (StringUtils.isNotBlank(srvdto.getId_boil())) {
			CHerbBoilMdDO cHerbBoilMd = icherbboilmdMDORService.findById(srvdto.getId_boil());
			if (cHerbBoilMd == null) {
				throw new BizException("获取煎法SD失败！");
			}
			srvdto.setName_boil(cHerbBoilMd.getName());
		} else {
			srvdto.setId_boil(medSrvDO.getId_boil());
			srvdto.setName_boil(medSrvDO.getBoil_name());
		}

		// 煎法要求
		if (StringUtils.isNotBlank(srvdto.getId_boildes())) {
			CHerbBoilDesDO cherbBoilDes = icHerbBoilDesDORService.findById(srvdto.getId_boildes());
			if (cherbBoilDes == null) {
				throw new BizException("获取煎法要求SD失败！");
			}
			srvdto.setName_boildes(cherbBoilDes.getName());
		} else {
			srvdto.setId_boildes(medSrvDO.getId_boildes());
			srvdto.setName_boildes(medSrvDO.getBoildes_name());
		}
	}

	/**
	 * 医疗单匹配
	 * 
	 * @param envinfo
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private SrvMatchEmsRstDTO getFuncClassStr(CiEnContextDTO envinfo, MedSrvDO medSrvDO) throws BizException {
		return CiOrdUtils.getFuncClassStr(envinfo, medSrvDO);
	}

	/**
	 * 执行科室
	 * 
	 * @param envinfo 就诊环境
	 * @param medsrvDO 当前服务
	 * @return
	 * @throws BizException
	 */
	private OrWfDeptInfoDTO getMpDeptID(CiEnContextDTO envinfo, MedSrvDO medsrvDO)
			throws BizException {
//		OrWfExDeptParamDTO paramdto = new OrWfExDeptParamDTO();
		
		String idmm = "";
		if (medsrvDO.getFg_mm().booleanValue()) {
			String whereStr = MeterialDODesc.TABLE_ALIAS_NAME + "." + MeterialDO.ID_SRV + " = '" + medsrvDO.getId_srv() + "'";
			MeterialDO[] meteralDO = CiOrdAppUtils.getMaterialQryService().find(whereStr, MeterialDO.ID_SRV, FBoolean.FALSE);
			if (meteralDO != null && meteralDO.length > 0 && meteralDO[0] != null) {
				idmm = meteralDO[0].getId_mm(); // 服务选取的关联物品
			}

		}
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(envinfo, medsrvDO, idmm, null);

//		// dto.Innercode_srvca = "";//服务分类内码
//		paramdto.setEu_wftp(0); // 0执行与物资 1执行科室 2物资流向
//		paramdto.setCode_entp(envinfo.getCode_entp()); // 就诊类型
//		paramdto.setId_dept_ns(envinfo.getId_dep_ns()); // 就诊护理病区
//		paramdto.setId_dept_or(envinfo.getId_dep_or());// 开单科室
//		paramdto.setId_dept_en(envinfo.getId_dep_en()); // id_dept_en;//就诊科室
//		// dto.Recurstr = ""; //长临需要的 不知道 就为空
//		paramdto.setId_srv(medsrvDO.getId_srv()); // 服务
//		paramdto.setSd_srvtp(medsrvDO.getSd_srvtp()); // 服务类型sd
//		paramdto.setId_srvca(medsrvDO.getId_srvca());// 服务分类
//
//		paramdto.setId_usage(medsrvDO.getId_route()); // 用法
//		// dto.Weekno = "2";//生效日期时间相关的 周#与时间
//		Date date = new Date();
//		paramdto.setTimestr(new FTime(date));
//		// paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW); //只求执行科室
//		// 执行科室（新的）
//		ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
//		OrWfDeptInfoDTO orWfDeptInfo =  service.getExeDepts4CiOrSrvN(paramdto);
//		
//		// 执行科室集合
//		FArrayList orwfexedeptList = orWfDeptInfo.getOrwfexedepts();
//		
//		// 如果传入的参数包含默认的执行科室，并且返回的执行科室列表包含默认执行科室id，将默认执行科室设置为第一执行科室
//		if(orwfexedeptList != null && orwfexedeptList.size() > 0 && StringUtils.isNotBlank(defaultMpDeptId)){
//			
//			for(Object orWfExDeptObj : orwfexedeptList){
//				
//				OrWfExDeptDTO orWfExDept = (OrWfExDeptDTO)orWfExDeptObj;
//				// 设置默认执行科室为第一执行科室
//				if(orWfExDept.getId_dept().equals(defaultMpDeptId)){
//					
//					orWfDeptInfo.setFirstid_mp_dept(defaultMpDeptId);
//					orWfDeptInfo.setFirstname_mp_dept(orWfExDept.getName_dept());
//				}
//			}
//			
//		}
		
		return wf;
	}

	/**
	 * 一次性查询bd_srv 数据
	 * 
	 * @param ciOrtmplAggDTO
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> OptimizationMedSrvDO(CiOrTmplDTO[] ciOrtmplAggDTO) throws BizException {
		MedSrvDO[] medsrvDo = null;
		if (ciOrtmplAggDTO != null && ciOrtmplAggDTO.length > 0) {
			List<String> list = new ArrayList<String>();
			for (CiOrTmplDTO ciOrtmplDTO : ciOrtmplAggDTO) {
				if (ciOrtmplDTO.getId_srv() == null || ciOrtmplDTO.getId_srv() == "")
					continue;
				list.add(ciOrtmplDTO.getId_srv());
			}
			if (list != null && list.size() > 0) {
				String[] id_srv = list.toArray(new String[0]);
				medsrvDo = findByIds(id_srv, FBoolean.FALSE);
			}
		}
		return medSrvDOMap(medsrvDo);
	}

	/**
	 * 查询bd_srv
	 * 
	 * @param Id_srv
	 * @param IsLazy
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] findByIds(String[] Id_srv, FBoolean IsLazy) throws BizException {
		return imedsrvMDORService.findByIds(Id_srv, IsLazy);
	}

	/**
	 * MedsrvDO[] 转换成 map
	 * 
	 * @param medsrvDo
	 * @return
	 */
	private Map<String, MedSrvDO> medSrvDOMap(MedSrvDO[] medsrvDo) {
		Map<String,MedSrvDO> map = new HashMap<String,MedSrvDO>();
		if (medsrvDo == null)
			return null;
		for (MedSrvDO medsrvDO : medsrvDo) {
			map.put(medsrvDO.getId_srv(), medsrvDO);
		}
		return map;
	}
	
	/**
	 * CiEmsDTO执行属性映射后的设置
	 * @param ctx 当前就诊环境
	 * @param ciEms CiEmsDTO对象
	 * @throws BizException 
	 */
	private void afterFieldMapping(CiEnContextDTO ctx, CiEmsDTO ciEms) throws BizException{
		
		MedSrvDO medSrv = bdSrvMap.get(ciEms.getId_srv());
		
		FArrayList emSrvList = ciEms.getEmssrvs();		
		CiEmsSrvDTO firstCiEmsSrv = (CiEmsSrvDTO)emSrvList.get(0);
		
		// 获取执行科室（在标准模板中没有执行科室，在标准模板项目中才有）
		OrWfDeptInfoDTO orWfDeptInfo = getMpDeptID(ctx, medSrv);
		if (null != orWfDeptInfo) {
			ciEms.setId_dep_mp(orWfDeptInfo.getFirstid_mp_dept());
			ciEms.setName_dep_mp(orWfDeptInfo.getFirstname_mp_dept());
		}
		
		
		// 根据检查属性中的是否床边执行属性设置床旁执行属性
		MedSrvRisDO  medSrvRis = srvRisMap.get(ciEms.getId_srv());
		if(medSrvRis != null && medSrvRis.getIf_mp_bed() == FBoolean.TRUE){
			ciEms.setFg_mp_bed(FBoolean.TRUE);
		}else{
			ciEms.setFg_mp_bed(FBoolean.FALSE);
		}		
		
		// 设置服务项目中的执行科室
		for(Object obj :emSrvList){
			
			CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO)obj;
			ciEmsSrv.setId_dep(orWfDeptInfo.getFirstid_mp_dept());
			ciEmsSrv.setName_dep(orWfDeptInfo.getFirstname_mp_dept());
		}
	}
	/***
	 * 校验库存
	 * @param ciEmsList
	 * @return
	 * @throws BizException 
	 */
	private String emsSrvValidateCount(List<CiEmsDTO> ciEmsList) throws BizException{
		Map<String,CiEmsDTO> mapDto = new HashMap<String,CiEmsDTO>();
		Map<String,String[]> mapParams = new HashMap<String,String[]>();
		for(CiEmsDTO ems : ciEmsList){
			FArrayList srvs = ems.getEmssrvs();
			for(Object obj : srvs){
				CiEmsSrvDTO srvdto = (CiEmsSrvDTO)obj;
				if(srvdto.getFg_mm()==FBoolean.TRUE){
					String[] params = new String[5];
					String keyId = getKeyId(srvdto.getId_mm(),srvdto.getId_dep_wh(),srvdto.getId_unit_sale());
					if(!CiOrdUtils.isEmpty(keyId)){
						mapDto.put(keyId, ems);
						mapParams.put(keyId, params);
						params[0] = srvdto.getId_mm();
						params[1] = srvdto.getId_dep_wh();
						params[2] = srvdto.getId_unit_sale();
						params[3] = srvdto.getName_srv();
						params[4] = srvdto.getQuan_cur()==null?"0":srvdto.getQuan_cur().toString();
					}
				}
			}
		}
		if(!mapDto.isEmpty()){
			List<CiEmsDTO> delEmsDTOs = new ArrayList<CiEmsDTO>();
			String refusedMsg = validateDrugCount(mapParams,mapDto,delEmsDTOs);
			ciEmsList.removeAll(delEmsDTOs);
			return refusedMsg;
		}
		return null;
	}
	/**
	 * 拼接key关键字
	 * @param id_mm
	 * @param id_dep_wh
	 * @param id_unit_sale
	 * @return
	 */
	private String getKeyId(String id_mm,String id_dep_wh,String id_unit_sale){
		return (id_mm==null?"":id_mm)+(id_dep_wh==null?"":id_dep_wh)+(id_unit_sale==null?"":id_unit_sale);
	}
	/**
	 * 医嘱模板保存校验库存
	 * @param paramsMap
	 * @param mapEmsDto
	 * @param delEmsDTOs
	 * @return
	 * @throws BizException
	 */
	public String validateDrugCount(Map<String,String[]> paramsMap,Map<String,CiEmsDTO> mapEmsDto,List<CiEmsDTO> delEmsDTOs) throws BizException
    {
   	 String nocount = "";//无库存
   	 String stopSale = "";//停发
   	 String noDrug = "";//无此药
        List<GetStockReqDTO> reqDtos = new ArrayList<GetStockReqDTO>();
        for(Map.Entry<String, String[]> map: paramsMap.entrySet())
        {
                GetStockReqDTO reqDTO = new GetStockReqDTO();
                reqDTO.setId_mm(map.getValue()[0]);
                reqDTO.setId_dep(map.getValue()[1]);
                reqDTO.setReq_unit_id(map.getValue()[2]);
                reqDtos.add(reqDTO);
        }
        if (reqDtos.size() > 0)
        {
            IMaterialStockService stoctService = CiOrdAppUtils.getMaterialStockQryService();
            MaterialStockDTO[] stockdto = null;
            stockdto = stoctService.getMaterialStocks(reqDtos.toArray(new GetStockReqDTO[0]));
            if (stockdto != null)
            {
           	 String mmcounterror = "";
                for (MaterialStockDTO materialDo : stockdto)
                {
                	String key = this.getKeyId(materialDo.getId_mm(), materialDo.getId_dep(), materialDo.getReq_unit_id());
               	 	String[] param = paramsMap.get(key);
                        FDouble mmcount = materialDo.getQuan_usable();
                        //药房无此药的移除
                        if (materialDo.getMmstatus() == MaterialStatus.NORELATION)
                        {
                            noDrug += param[3] + ",";
                            if(mapEmsDto.containsKey(key)){
                            	delEmsDTOs.add(mapEmsDto.get(key));
                            }
                        }
                        else if (materialDo.getMmstatus() == MaterialStatus.STOP)
                        {
                            stopSale += param[3] + ",";
                            if(mapEmsDto.containsKey(key)){
                            	delEmsDTOs.add(mapEmsDto.get(key));
                            }
                        }
                        else if (mmcount.compareTo(new FDouble(param[4]))<0)
                        {
                            nocount += param[3] + ",";
                            if(mapEmsDto.containsKey(key)){
                            	delEmsDTOs.add(mapEmsDto.get(key));
                            }
                        }
                }
                if (!CiOrdUtils.isEmpty(noDrug))
                {
                    mmcounterror = "服务：" + noDrug.substring(0,noDrug.length()-1) + "，药房无此药！\r\n";
                }
                if (!CiOrdUtils.isEmpty(stopSale))
                {
                    mmcounterror += mmcounterror + "服务：" + stopSale.substring(0, stopSale.length() - 1) + "，已停发！\r\n";
                }
                if (!CiOrdUtils.isEmpty(nocount))
                {
                    mmcounterror += mmcounterror + "服务：" + nocount.substring(0, nocount.length() - 1) + "，库存不足！";
                }
                if (CiOrdUtils.isEmpty(mmcounterror)) return null;
                return mmcounterror;
            }
        }
        return null;
    }
	private String getName_routes(String id_routdes) throws BizException{
		if(CiOrdUtils.isEmpty(id_routdes)) return null;
		String[] idStr = id_routdes.split(",");
		MedUsageDesDO[] usageDes = imedusagedesRService.findByBIds(idStr, FBoolean.FALSE);
		if (usageDes == null) {
			throw new BizException("获取用法要求SD失败！");
		}
		String UsageDesNames = "";
		for(MedUsageDesDO usagedes : usageDes){
			UsageDesNames+=usagedes.getName()+",";
		}
		if(UsageDesNames.length()>0){
			return UsageDesNames.substring(0, UsageDesNames.length()-1);
		}
		return null;
	}
}

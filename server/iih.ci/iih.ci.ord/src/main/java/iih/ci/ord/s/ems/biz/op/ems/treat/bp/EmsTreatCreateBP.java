package iih.ci.ord.s.ems.biz.op.ems.treat.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.hp.HpService;
import iih.ci.ord.hp.HpService.MedSrvHpParam;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseCreateBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsDtUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.define.StringList;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 治疗医疗单创建逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsTreatCreateBP extends EmsBaseCreateBP {

	class TCalcMmPriceParam {
		public String Id_srv;
		public String Id_mm;
		public FBoolean Fg_mm;
		public String Id_unit_sale;
	}

	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsDrugItemDO emsModel = getCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv());
		
		if (null == emsModel) {
			emsModel = emsModelFrom(aggDO.getParentDO());
			putCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv(), emsModel);
		}
		emsModel.setStatus(DOStatus.NEW);
		// 非缓存信息
		{
			FDateTime tm = CiOrdAppUtils.getServerDateTime();
			emsModel.setUse_days(1);
			GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
			Integer totalTimes = totalTimesBP.getTotalTimes(aggDO.getParentDO().getId_freq(), emsModel.getUse_days());
			emsModel.setTimes_cur(totalTimes);
			emsModel.setDt_begin_ui(tm); // SINGLE
			emsModel.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1), tm.getUFTime()));
			emsModel.setEu_orsrcmdtp(OrSourceFromEnum.IIHSRVREF);
		}

		// 列表项目
		this.constructTableDatasource(ems.getEnContext(), emsModel, aggDO);

		// 诊断id
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ems.getEnContext().getId_en());
		if (diagOutlineInfo != null) {
			OrderEmsExtInfoUtils.SetDiInfo(rst, diagOutlineInfo.toFMap());
		}

		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO());
		// 保存执行科室过滤条件
		OrderEmsExtInfoUtils.SetMpDepFilter(rst, emsModel.getStr_mp_dep_ids());
		rst.setDocument(this.handleReturnDocument(emsModel));
//		rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.setEmsDriver(EmsType.COMMON.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	/**
	 * 将medSrv转换为EmsDrugItemDO
	 * 
	 * @param emsDrugItem
	 * @param medSrv
	 *            医疗服务对象
	 * @throws BizException
	 */
	private EmsDrugItemDO emsModelFrom(MedSrvDO medSrv) throws BizException {

		EmsDrugItemDO emsDrugItem = new EmsDrugItemDO();
		emsDrugItem.setId_srv(medSrv.getId_srv());// 服务项目id
		emsDrugItem.setName_srv(medSrv.getName());// 服务项目名称
		emsDrugItem.setId_srvtp(medSrv.getId_srvtp());// 服务项目类型id
		emsDrugItem.setSd_srvtp(medSrv.getSd_srvtp());// 服务项目类型sd
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		// 是否多剂量
//		emsDrugItem.setIsmuldose(FBoolean.TRUE);
		emsDrugItem.setIsmuldose(medSrv.getIsmuldose());
		// 是否多次执行
//		emsDrugItem.setIsmulexec(FBoolean.TRUE);
		emsDrugItem.setIsmulexec(medSrv.getIsmulexec());
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		emsDrugItem.setId_freq(medSrv.getId_freq());// 频次
		emsDrugItem.setName_freq(medSrv.getFreq_name());// 频次名称
		emsDrugItem.setFreqct(medSrv.getFreqct());// 频次下次数
		emsDrugItem.setSd_frequnitct(medSrv.getSd_frequnitct());// 频次单位编码 频次周期类型
		emsDrugItem.setId_route(medSrv.getId_route());// 用法
		emsDrugItem.setName_route(medSrv.getRoute_name());// 用法名称
		emsDrugItem.setId_routedes(medSrv.getId_routedes());// 用法要求
		emsDrugItem.setName_routedes(medSrv.getRoutedes_name());

		emsDrugItem.setName_unit_med(medSrv.getMed_name());// 计量单位名称
		emsDrugItem.setId_unit_med(medSrv.getId_unit_med());// 医学单位
		// emsDrugItem.First_freq = "2";//首次执行
		// emsDrugItem.First_time = "12:00;14:00";//首次执行时刻
		// emsDrugItem.Fg_skintest = false;
		emsDrugItem.setFg_mm(medSrv.getFg_mm()); // 物品标识
		emsDrugItem.setQuan_med(medSrv.getQuan_med()); // 剂量
		emsDrugItem.setFg_long(medSrv.getFg_long());// 长临标识
		if (medSrv.getSd_srvtp().indexOf("0103") == 0) {// 草药
			emsDrugItem.setName_boil(medSrv.getBoil_name());// 煎法名称
			emsDrugItem.setId_boil(medSrv.getId_boil()); // 煎法
			emsDrugItem.setOrders(1); // 医嘱付数
			emsDrugItem.setFg_boil(FBoolean.TRUE);// 代煎标识
			emsDrugItem.setOrders_boil(1);// 代煎付数

		}
		emsDrugItem.setFg_pmor(FBoolean.FALSE);// TODO 备用医嘱标识
		emsDrugItem.setFg_dose_anoma(FBoolean.FALSE);// 变动用药标识
		emsDrugItem.setFg_outp(FBoolean.FALSE);// 出院带药标识
		// emsDrugItem.setUse_days(1);// 使用天数

		// 简洁医疗单新增赋值属性
		emsDrugItem.setNote_or(medSrv.getNote()); // 备注
		emsDrugItem.setFg_bl(medSrv.getFg_bl());// 费用标识
		emsDrugItem.setName_route(medSrv.getRoute_name());// 用法名称
		emsDrugItem.setName_routedes(medSrv.getRoutedes_name());// 用法要求名称
		emsDrugItem.setFg_propc(FBoolean.FALSE);// 预防用药标识

		// 1) 判断当前工作台的就诊类型，当就诊类型是住院时，查询选中服务的BD_SRV.sd_mmbind_ip的值，
		// 0开立绑定时，从<BD_SRV_REL_MM医疗服务_项目_物品关系策略>表里找出服务关联的物品，
		if (medSrv.getSd_mmbind_ip() == "0") {

		}

		emsDrugItem.setId_route(medSrv.getId_route()); // 用法
		emsDrugItem.setName_route(medSrv.getRoute_name()); // 用法名称

		emsDrugItem.setId_freq(medSrv.getId_freq()); // 频次
		emsDrugItem.setName_freq(medSrv.getFreq_name()); // 频次名称
		emsDrugItem.setSd_frequnitct(medSrv.getSd_frequnitct()); // 频次周期类型编码
		emsDrugItem.setFreqct(medSrv.getFreqct()); // 频次周期下次数

		/*
		 * // 获取SD中频次 FreqDefDO freqDef =
		 * ifreqdefMDORService.findById(medSrv.getId_freq()); if (freqDef ==
		 * null) { throw new BizException("获取频次SD失败！"); }
		 */

		// 设置默认医嘱天数
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(emsDrugItem.getSd_frequnitct())) { // 如果频次周期类型是星期，返回一个周期的天数
			emsDrugItem.setUse_days(7);
		} else {
			emsDrugItem.setUse_days(1);
		}

		emsDrugItem.setDt_begin_ui(CiOrdAppUtils.getServerDateTime()); // 开始时间

		// 截止时间
		FDateTime dt_end_ui = OrderEmsDtUtils.GetEndDateTime(emsDrugItem.getDt_begin_ui(), emsDrugItem.getUse_days());
		emsDrugItem.setDt_end_ui(dt_end_ui);

		return emsDrugItem;
	}

	/**
	 * 构建表格数据源
	 * 
	 * @param ctx
	 * @param drugItem
	 * @param medSrvAggInfo
	 * @throws BizException
	 */
	private void constructTableDatasource(CiEnContextDTO ctx, EmsDrugItemDO drugItem, MedsrvAggDO medSrvAggInfo)
			throws BizException {
		// 医疗单与就诊上下文
		drugItem.setId_org(ctx.getId_org());
		
		// 列表数据
		MedSrvDO med = medSrvAggInfo.getParentDO();
		EmsOrDrug ems = new EmsOrDrug();
		ems.setStatus(DOStatus.NEW);
		ems.setInnercode_srvca(med.getSrvca_innercode());
		ems.setId_srv(med.getId_srv());
		ems.setSd_srvtp(med.getSd_srvtp());
		ems.setId_srvtp(med.getId_srvtp());
		ems.setId_srvca(med.getId_srvca());
		ems.setName_srv(med.getName());
		ems.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		ems.setQuan_med(med.getQuan_med());
		ems.setId_unit_med(med.getId_unit_med());
		ems.setName_unit_med(med.getMed_name());
		ems.setQuan_medu_virtual(ems.getQuan_med());
		ems.setName_unit_medu_virtual(ems.getName_unit_med());
		ems.setId_freq(med.getId_freq());
		ems.setName_freq(med.getFreq_name());
		ems.setFreqct(med.getFreqct());
		ems.setId_pri(med.getId_primd());
		ems.setSd_frequnitct(med.getSd_frequnitct());
		ems.setId_unit_sale(med.getId_unit_med());
		ems.setName_unit_sale(med.getMed_name());
		ems.setFg_bl(med.getFg_bl());
		ems.setFg_or(med.getFg_or());
		ems.setEu_blmd(med.getEu_blmd());
		ems.setId_pri(med.getId_primd());
		ems.setUse_days(drugItem.getUse_days());

		CalQuantumBP quantumBP = new CalQuantumBP();
		ems.setQuan_cur(quantumBP.getUnMMQuantum(ems.getId_freq(), ems.getUse_days(), ems.getQuan_med()));

		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrvAggInfo.getParentDO(), "", "");
		if (null != wf) {
			ems.setId_mp_dep(wf.getFirstid_mp_dept());
			ems.setName_mp_dep(wf.getFirstname_mp_dept());
			drugItem.setStr_mp_dep_ids(wf.getId_mp_depts());
			drugItem.setId_dep(wf.getFirstid_mp_dept());
			drugItem.setName_dep(wf.getFirstname_mp_dept());
		}

		drugItem.setId_dep(ems.getId_mp_dep());
		drugItem.setName_dep(ems.getName_mp_dep());

		// 计算单价和总额
		ems.setPrice(calculatePrice(medSrvAggInfo.getParentDO(), medSrvAggInfo.getMedSrvSetItemDO(),
				ctx.getEnt4BannerDTO().getId_pripat()).getPrice_ratio());
		ems.setTotalprice(ems.getPrice().multiply(ems.getQuan_cur()));

		FArrayList drugList = new FArrayList();
		drugList.add(ems);
		drugItem.setEmsOrDrugListEx(drugList);
	}

	/**
	 * 获取治疗服务套的总单价
	 * 
	 * @param agg
	 * @return
	 * @throws BizException
	 */
	// private FDouble calculatePrice(MedsrvAggDO agg,String id_pripat) throws
	// BizException
	// {
	// FDouble price = FDouble.ZERO_DBL;
	// if (agg == null) return price;
	// if (CiOrdUtils.isTrue(agg.getParentDO().getFg_set()))
	// {
	// TCalcMmPriceParam[] szTCalcMmPriceParam = getSetClinicalSrvDO(agg, "00",
	// 0);
	//
	// for (TCalcMmPriceParam emsdto : szTCalcMmPriceParam)
	// {
	// if (CiOrdUtils.isTrue(emsdto.Fg_mm) ) {
	// price= price.add( OrderEmsPriceUtils.getMaterialPrice(emsdto.Id_mm,
	// emsdto.Id_unit_sale));
	// }
	// }
	// // 包含服务本身价格
	// price = price.add
	// (OrderEmsPriceUtils.calculatePrice(agg.getParentDO(),id_pripat));
	// }
	// else{
	// price = OrderEmsPriceUtils.calculatePrice(agg.getParentDO(),id_pripat);
	// }
	// return price;
	// }
	private MedSrvPriceDO calculatePrice(MedSrvDO medSrv, MedSrvSetItemDO[] szMedSrvSetItemDO, String id_pripat)
			throws BizException {
		MedSrvPriceDO price = new MedSrvPriceDO();
		price.setPrice_ratio(FDouble.ZERO_DBL);
		price.setPrice_std(FDouble.ZERO_DBL);
		price.setRatio(FDouble.ONE_DBL);
		price.setId_pripat(id_pripat);
		if (medSrv == null )
			return price; // 套内临床项目为空时候，不计算价格
		if (CiOrdUtils.isTrue(medSrv.getFg_set())&&szMedSrvSetItemDO != null && szMedSrvSetItemDO.length > 0) {

			TCalcMmPriceParam[] szTCalcMmPriceParam = getSetClinicalSrvDO(medSrv, szMedSrvSetItemDO, "00", 0);
			if (null != szTCalcMmPriceParam) {
				for (TCalcMmPriceParam emsdto : szTCalcMmPriceParam) {
					if (CiOrdUtils.isTrue(emsdto.Fg_mm)) {
						price.setPrice_ratio(price.getPrice_ratio()
								.add(OrderEmsPriceUtils.getMaterialPrice(emsdto.Id_mm, emsdto.Id_unit_sale)));
					}
				}
			}
			// 包含服务本身价格
			price.setPrice_ratio(price.getPrice_ratio().add(OrderEmsPriceUtils.calculatePrice(medSrv, id_pripat)));
		} else {
			price = OrderEmsPriceUtils.calculatePrice(medSrv.getId_srv(), medSrv.getId_primd(), id_pripat);
		}
		return price;
	}

	/**
	 * 获取套内临床项目列表
	 * 
	 * @param mainAggInfo
	 * @param code_entp
	 * @param Eu_sourcemd
	 * @return
	 * @throws BizException
	 */
	// protected List<CiEmsSrvDTO> getSetClinicalSrvDO(MedsrvAggDO
	// mainAggInfo,String code_entp, int Eu_sourcemd) throws BizException
	// {
	// List<CiEmsSrvDTO> emslist = new ArrayList<CiEmsSrvDTO>();
	//
	// MedSrvDO aggParent = mainAggInfo.getParentDO();
	// MedSrvSetItemDO[] medSrvSetItems = mainAggInfo.getMedSrvSetItemDO();
	// List<MedSrvSetItemDO> listMedSrvSetItem = new
	// ArrayList<MedSrvSetItemDO>();
	// StringList listSrvId = new StringList();
	// for(int i=0;i<medSrvSetItems.length;i++){
	// if (CiOrdUtils.isTrue(medSrvSetItems[i].getFg_clinical()) &&
	// medSrvSetItems[i].getDs() == 0 &&
	// CiOrdUtils.isTrue(medSrvSetItems[i].getFg_active() )) {
	// listMedSrvSetItem.add(medSrvSetItems[i]);
	// listSrvId.add(medSrvSetItems[i].getId_srv());
	// }
	// }
	// MedsrvAggDO[] szMedsrvAggDO =
	// ServiceFinder.find(IMedsrvRService.class).findByIds(listSrvId.toArray(new
	// String[listSrvId.size()]), FBoolean.FALSE);
	// for(MedsrvAggDO agg : szMedsrvAggDO)
	// {
	// MedSrvDO medsrv = agg.getParentDO();
	// CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
	// stvdto.setId_srv_set ( aggParent.getId_srv());
	// stvdto.setFg_set ( medsrv.getFg_set());
	// stvdto.setId_srv ( medsrv.getId_srv());
	// stvdto.setId_freq ( medsrv.getId_freq());
	// stvdto.setId_srvca ( medsrv.getId_srvca());
	// stvdto.setSd_srvtp ( medsrv.getSd_srvtp());
	// stvdto.setEu_blmd ( medsrv.getEu_blmd());
	// stvdto.setFg_mm ( medsrv.getFg_mm());
	// stvdto.setCode_srv ( medsrv.getCode());
	// stvdto.setFg_bl ( medsrv.getFg_bl());
	// stvdto.setId_srvtp ( medsrv.getId_srvtp());
	// stvdto.setQuan_med ( medsrv.getQuan_med());
	// stvdto.setId_unit_med ( medsrv.getId_unit_med());
	// stvdto.setId_route ( medsrv.getId_route());
	// stvdto.setEu_sourcemd ( Eu_sourcemd);
	// stvdto.setDes_srv ( medsrv.getDes());
	// stvdto.setFg_or ( FBoolean.TRUE);
	// stvdto.setId_primd ( medsrv.getId_primd());
	// stvdto.setName_srv ( medsrv.getName());
	// if (CiOrdUtils.isTrue(stvdto.getFg_mm())) {
	// MeterialDO[] mms =
	// ServiceFinder.find(IMeterialMDORService.class).find(String.format("id_srv='%s'
	// and fg_active='Y' and ds=0 ",stvdto.getId_srv()), "",FBoolean.FALSE);
	// if (mms != null && mms.length > 0) {
	// stvdto.setId_mm ( mms[0].getId_mm());
	// IMaterialBaseInfoService meterialBaseService =
	// ServiceFinder.find(IMaterialBaseInfoService.class);
	// MaterialUnitDTO[] materUnit = meterialBaseService.getMMunitByEntp(new
	// String[]{mms[0].getId_mm()},code_entp );
	// if (materUnit != null && materUnit.length > 0)
	// {
	// stvdto.setId_unit_sale ( materUnit[0].getId_measdoc());
	// }
	// else {
	// stvdto.setId_unit_sale ( mms[0].getId_unit_pkgsp());
	// }
	// stvdto.setName_mm ( mms[0].getName());
	// stvdto.setId_unit_base ( mms[0].getId_unit_pkgbase());
	//
	// stvdto.setCode_mm ( mms[0].getCode());
	// stvdto.setFactor_mb ( mms[0].getFactor_mb());
	// stvdto.setFactor_cb ( mms[0].getFactor_sb());
	// stvdto.setId_val ( mms[0].getId_val());
	// stvdto.setSd_val ( mms[0].getSd_val());
	// stvdto.setId_mmtp ( mms[0].getId_mmtp());
	// stvdto.setSd_mmtp ( mms[0].getSd_mmtp());
	// if (code_entp == IEnDictCodeConst.SD_ENTP_INPATIENT)
	// {
	// stvdto.setSd_roundmd ( mms[0].getId_mupkgutp());
	// }
	// else if (code_entp == IEnDictCodeConst.SD_ENTP_OUTPATIENT) {
	// stvdto.setSd_roundmd ( mms[0].getSd_opmutp());
	// }
	// stvdto.setFg_skintest ( FBoolean.FALSE);
	// }
	// }
	// emslist.add(stvdto);
	// }
	//
	//
	// return emslist;
	// }
	protected TCalcMmPriceParam[] getSetClinicalSrvDO(MedSrvDO mainAggInfo, MedSrvSetItemDO[] medSrvSetItems,
			String code_entp, int Eu_sourcemd) throws BizException {
		List<TCalcMmPriceParam> emslist = new ArrayList<TCalcMmPriceParam>();

		List<MedSrvSetItemDO> listMedSrvSetItem = new ArrayList<MedSrvSetItemDO>();
		StringList listSrvId = new StringList();
		for (int i = 0; i < medSrvSetItems.length; i++) {
			if (CiOrdUtils.isTrue(medSrvSetItems[i].getFg_clinical()) && medSrvSetItems[i].getDs() == 0
					&& CiOrdUtils.isTrue(medSrvSetItems[i].getFg_active())) {
				listMedSrvSetItem.add(medSrvSetItems[i]);
				listSrvId.add(medSrvSetItems[i].getId_srv_itm());
			}
		}
		if (listSrvId.size() == 0) {
			return null;
		}
		MedsrvAggDO[] szMedsrvAggDO = ServiceFinder.find(IMedsrvRService.class)
				.findByIds(listSrvId.toArray(new String[listSrvId.size()]), FBoolean.FALSE);
		for (MedsrvAggDO agg : szMedsrvAggDO) {
			MedSrvDO medsrv = agg.getParentDO();
			TCalcMmPriceParam tCalcMmPriceParam = new TCalcMmPriceParam();

			tCalcMmPriceParam.Id_srv = (medsrv.getId_srv());

			tCalcMmPriceParam.Fg_mm = (medsrv.getFg_mm());

			if (CiOrdUtils.isTrue(medsrv.getFg_mm())) {
				MeterialDO[] mms = ServiceFinder.find(IMeterialMDORService.class).find(
						String.format("id_srv='%s' and fg_active='Y' and ds=0 ", medsrv.getId_srv()), "",
						FBoolean.FALSE);
				if (mms != null && mms.length > 0) {
					tCalcMmPriceParam.Id_mm = (mms[0].getId_mm());
					IMaterialBaseInfoService meterialBaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
					MaterialUnitDTO[] materUnit = meterialBaseService
							.getMMunitByEntp(new String[] { mms[0].getId_mm() }, code_entp);
					if (materUnit != null && materUnit.length > 0) {
						tCalcMmPriceParam.Id_unit_sale = (materUnit[0].getId_measdoc());
					} else {
						tCalcMmPriceParam.Id_unit_sale = (mms[0].getId_unit_pkgsp());
					}
				}
			}
			emslist.add(tCalcMmPriceParam);
		}

		return emslist.toArray(new TCalcMmPriceParam[emslist.size()]);
	}
}

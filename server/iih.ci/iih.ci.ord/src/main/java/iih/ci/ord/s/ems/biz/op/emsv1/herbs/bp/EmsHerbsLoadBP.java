package iih.ci.ord.s.ems.biz.op.emsv1.herbs.bp;

import iih.bl.hp.i.IBlHpOutQryService;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.op.ems.drugs.bp.EmsDrugsLoadBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsHerbsLoadBP extends EmsDrugsLoadBP {

	@Override
	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException {
		EmsLoadDTO arg = args[0];
		EmsRstDTO[] rsts = super.load(args);
		EmsRstDTO rst = rsts[0];
		// 医疗单类型
		rst.setEmsDriver(EmsType.HERB.toString());
		return rsts;
	}
	
	

	@Override
	protected EmsOrDrug orderDrugInfoFrom(CiEmsDTO dto, CiEmsSrvDTO srvInfo) {
		EmsOrDrug drug = super.orderDrugInfoFrom(dto, srvInfo);
		drug.setId_boildes ( srvInfo.getId_boildes());//煎法
		drug.setName_boildes ( srvInfo.getName_boildes());//煎法名称
		return drug;
	}

	


	@Override
	protected EmsDrugItemDO modelFrom(CiEnContextDTO ctx, CiEmsDTO dto) throws BizException {
		EmsDrugItemDO emsDrugItemInfo = super.modelFrom(ctx, dto);
		emsDrugItemInfo.setId_boil(dto.getId_boil()); // 煎法 REF 医疗服务中药煎法
		emsDrugItemInfo.setName_boil(dto.getName_boil()); // 煎法名称 SINGLE String
		emsDrugItemInfo.setId_boildes(dto.getId_boildes()); // 煎法要求 REF 中药煎法要求
		emsDrugItemInfo.setName_boildes(dto.getName_boildes()); // 煎法要求名称 SINGLE
																// String
		emsDrugItemInfo.setFg_boil(dto.getFg_boil()); // 代煎标识 SINGLE FBoolean
		emsDrugItemInfo.setOrders(dto.getOrders()); // 医嘱付数 SINGLE Integer
		emsDrugItemInfo.setOrders_boil(dto.getOrders_boil()); // 代煎付数 SINGLE
		
		FArrayList drugList = emsDrugItemInfo.getEmsOrDrugListEx();
		
		// 单方限制草药自费，在编辑后添加草药变为复方时，需要改为非自费。
		// 为解决在保存时过多查询医保信息，单方信息，是否为医生调整为自费，药品是否为丙类自费或者限制使用自费，改为在加载时判断
		// 因为单方限制的是适应症，自费，对于已经是非适应症的不需要判断。因此不需要在调用适应症获取接口
		EmsOrDrug drug = (EmsOrDrug)drugList.get(0);
		if (CiOrdUtils.isHpUsing(ctx) && FBoolean.TRUE.equals(drug.getFg_treat()) && drugList.size() == 1
				&& FBoolean.TRUE.equals(drug.getFg_selfpay())
				&& HpIndicJudgeEnum.NONEEDJUDGE.equals(dto.getEu_hpindicjudge())) {
			
			FBoolean hasPsdLimit = ServiceFinder.find(IBlHpOutQryService.class).hasPsdLimit(ctx.getId_hp(), drug.getId_srv());
			// 当因单方变为自费时，加载时先设置为非自费，在保存时在确定是否为自费
			if(hasPsdLimit == FBoolean.TRUE){
				// 符合单方限制的改为False , 单方的一定是医保
				drug.setFg_selfpay(FBoolean.FALSE);	
			}
		}
		
		return emsDrugItemInfo ;
	}



	/**
	 * 构建药品主信息 -- 同 药品
	 * 
	 * @param emsDrugItemInfo
	 * @param dto
	 * @throws BizException
	 */
	private EmsDrugItemDO modelFrom1(CiEnContextDTO ctx, CiEmsDTO dto) throws BizException {

		EmsDrugItemDO emsDrugItemInfo = new EmsDrugItemDO();
		CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx,dto);

		emsDrugItemInfo.setDt_begin_ui(dto.getDt_begin()); // 开始日期 SINGLE
															// FDateTim
		emsDrugItemInfo.setDt_end_ui(dto.getDt_end()); // 结束日期 SINGLE FDateTim
		emsDrugItemInfo.setUse_days(dto.getDays_or()); // 医嘱天数 SINGLE Integer
		emsDrugItemInfo.setTimes_cur(dto.getTimes_cur());// 医嘱次数
		emsDrugItemInfo.setTimes_mp_in(dto.getTimes_mp_in());// 在院执行次数

		emsDrugItemInfo.setFg_dose_anoma(mainSrvInfo.getFg_dose_anoma());
		emsDrugItemInfo.setId_unit_med(mainSrvInfo.getId_unit_med());
		emsDrugItemInfo.setName_unit_med(mainSrvInfo.getName_unit_med());
		emsDrugItemInfo.setFg_self(mainSrvInfo.getFg_self());
		emsDrugItemInfo.setFg_outp(mainSrvInfo.getFg_outp());
		emsDrugItemInfo.setFg_propc(mainSrvInfo.getFg_propc());
		emsDrugItemInfo.setFg_treat(mainSrvInfo.getFg_indic());// srvInfo.getFg_treat;
		emsDrugItemInfo.setFg_bl(mainSrvInfo.getFg_bl());

		emsDrugItemInfo.setId_srv(dto.getId_srv());
		emsDrugItemInfo.setName_srv(dto.getName());
		emsDrugItemInfo.setSd_srvtp(dto.getSd_srvtp());
		emsDrugItemInfo.setId_srvtp(dto.getId_srvtp());
		emsDrugItemInfo.setNote_or(dto.getNote());
		emsDrugItemInfo.setFg_long(dto.getFg_long());
		// 长临标识
		emsDrugItemInfo.setId_freq(dto.getId_freq()); // 医嘱频次 REF 医嘱频次定义
		emsDrugItemInfo.setName_freq(dto.getName_freq()); // 医嘱频次名称 SINGLE
															// String
		emsDrugItemInfo.setFreqct(dto.getFreqct());// zwq 2016-09-06
		emsDrugItemInfo.setSd_frequnitct(dto.getSd_frequnitct());// zwq
																	// 2016-09-06
		emsDrugItemInfo.setId_route(dto.getId_route()); // 用法 REF 医疗服务_医疗用法
		emsDrugItemInfo.setName_route(dto.getName_route()); // 用法名称 SINGLE
															// String
		emsDrugItemInfo.setId_routedes(dto.getId_routedes()); // 用法要求 REF 医疗用法要求
		emsDrugItemInfo.setName_routedes(dto.getName_routedes()); // 用法要求描述
																	// SINGLE
																	// String
		emsDrugItemInfo.setId_boil(dto.getId_boil()); // 煎法 REF 医疗服务中药煎法
		emsDrugItemInfo.setName_boil(dto.getName_boil()); // 煎法名称 SINGLE String
		emsDrugItemInfo.setId_boildes(dto.getId_boildes()); // 煎法要求 REF 中药煎法要求
		emsDrugItemInfo.setName_boildes(dto.getName_boildes()); // 煎法要求名称 SINGLE
																// String
		emsDrugItemInfo.setFg_boil(dto.getFg_boil()); // 代煎标识 SINGLE FBoolean
		emsDrugItemInfo.setOrders(dto.getOrders()); // 医嘱付数 SINGLE Integer
		emsDrugItemInfo.setOrders_boil(dto.getOrders_boil()); // 代煎付数 SINGLE

		emsDrugItemInfo.setNote_or(dto.getNote()); // 备注 SINGLE 备注 1000


		if (emsDrugItemInfo.getDt_end_ui() != null && emsDrugItemInfo.getDt_end_ui().getYear() > 2098) // 时间控件仅支持到
			emsDrugItemInfo.setDt_end_ui(null);
		emsDrugItemInfo.setDt_fail(dto.getDt_invalid()); // 医嘱过期时间 SINGLE

		emsDrugItemInfo.setFg_pmor(dto.getFg_pmor()); // 备用医嘱标识 SINGLE FBoolean
		emsDrugItemInfo.setBak_des(dto.getDes_pmor()); // 备用医嘱使用条件描述 SINGLE
		
		emsDrugItemInfo.setFg_mp_in(dto.getFg_mp_in()); // 在院执行标识 SINGLE
		dto.setFg_or_doc(FBoolean.TRUE); // 医生医嘱标识 SINGLE
		emsDrugItemInfo.setQuan_firday_mp(dto.getTimes_firday_mp());

		emsDrugItemInfo.setId_dep(dto.getId_dep_mp());// zwq 2016-08-04
		emsDrugItemInfo.setName_dep(dto.getName_dep_mp());// zwq 2016-08-04

		emsDrugItemInfo.setEmsOrDrugListEx(orderDrugListFrom(ctx, emsDrugItemInfo, dto));

		// 外配药逻辑赋值

		emsDrugItemInfo.setFg_extdispense(mainSrvInfo.getFg_extdispense());

		return emsDrugItemInfo;
	}

}

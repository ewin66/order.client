package iih.ci.ord.s.ems.biz.op.emsv1.lis.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.cache.CacheContext;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseCreateBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.define.StringList;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsLisCreateBP extends EmsBaseCreateBP {
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		EmsRstDTO rst = new EmsRstDTO();
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();

		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsObsItemDO emsModel = getCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv());
		if (null == emsModel) {
			emsModel = emsModelFrom(aggDO.getParentDO());
			this.putCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv(), emsModel);
		}

		{
			FDateTime tm = CiOrdAppUtils.getServerDateTime();
			emsModel.setUse_days(1);
			GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
			Integer totalTimes = totalTimesBP.getTotalTimes(aggDO.getParentDO().getId_freq(), emsModel.getUse_days());
			emsModel.setTimes_cur(totalTimes);
			emsModel.setDt_begin_ui(tm); // SINGLE
			emsModel.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1), tm.getUFTime()));

			// 检查申请单号
			emsModel.setNo_applyobs(CiOrdUtils.getApplyNo(aggDO.getParentDO().getSd_srvtp()));

			// 计划检查时间
			emsModel.setDt_plan(tm);
		}

		// 诊断id
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ems.getEnContext().getId_en());
		if (diagOutlineInfo != null) {
			emsModel.setId_di(diagOutlineInfo.getId_di());// 主诊断的主项目id
			emsModel.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断id
			emsModel.setName_diag(diagOutlineInfo.getName_diag());// 主诊断名称
			emsModel.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
			emsModel.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
			emsModel.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接
			
			OrderEmsExtInfoUtils.SetDiInfo(rst, diagOutlineInfo.toFMap());
		}

		// 获取价格
		MedSrvPriceDO medSrvPriceDO = OrderEmsPriceUtils.CalculatePrice(aggDO.getParentDO(),
				ems.getEnContext().getEnt4BannerDTO().getId_pripat(), emsModel.getEmsOrObsListEx());
		emsModel.setPrice(medSrvPriceDO.getPrice_ratio());
		emsModel.setPri_ratio(medSrvPriceDO.getRatio());
		emsModel.setPri_std(medSrvPriceDO.getPrice_std());
		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ems.getEnContext(), aggDO.getParentDO(), "", "");
		if (null == wf) {
			// 封装错误信息
			FArrayList errorlist=new FArrayList();
			errorlist.add("获取执行科室失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
		}
		emsModel.setId_mp_dep(wf.getFirstid_mp_dept());
		emsModel.setName_mp_dep(wf.getFirstname_mp_dept());

		constructTableDatasource(emsModel, aggDO.getParentDO());

		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO());

		// 保存执行科室过滤条件
		OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());

		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());

		// 返回值处理
		rst.setDocument(this.handleReturnDocument(emsModel));
//		rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.setEmsDriver(EmsType.LIS.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	private void constructTableDatasource(EmsObsItemDO ems, MedSrvDO med) {

		EmsOrDrug item = new EmsOrDrug();
		item.setStatus(DOStatus.NEW);
		item.setId_srv(ems.getId_srv());
		item.setName_srv(ems.getName_srv());

		item.setId_unit_med(ems.getId_unit_med());
		item.setName_unit_med(ems.getName_unit_med());
		item.setId_unit_sale(ems.getId_unit_med());
		item.setName_unit_sale(ems.getName_unit_med());
		item.setQuan_med(ems.getQuan_med());
		item.setQuan_cur(ems.getQuan_cur());// CalQuantumUtil.GetInstance().getUnMMQuantum(item.Quan_med,
											// ems.getTimes_cur);
		item.setUse_days(ems.getUse_days());

		item.setId_freq(med.getId_freq());
		item.setName_freq(med.getFreq_name());
		item.setFreqct(med.getFreqct());
		item.setSd_frequnitct(med.getSd_frequnitct());

		// 获取服务定价（另：服务查询）
		item.setPrice(ems.getPrice());

		item.setTotalprice(item.getQuan_cur().multiply((item.getPrice() == null ? FDouble.ZERO_DBL : item.getPrice())));

		item.setFg_urgent(ems.getFg_urgent());
		// 申请单号
		item.setNo_applyform(ems.getNo_applyobs());

		item.setId_mp_dep(ems.getId_mp_dep());
		item.setName_mp_dep(ems.getName_mp_dep());
		
		item.setId_samptp(ems.getId_samptp());
		item.setSd_samptp(ems.getSd_samptp());
		item.setName_samptp(ems.getName_samptp());
		item.setId_sampcoltime(ems.getId_sampcoltime());
		item.setName_sampcoltime(ems.getName_sampcoltime());
		item.setId_sampcollecttimetp(ems.getId_sampcollecttimetp());
		item.setSd_sampcollecttimetp(ems.getSd_sampcollecttimetp());
		item.setLen_sampcoltime(ems.getLen_sampcoltime());
		item.setId_unit_sampcoltime(ems.getId_unit_sampcoltime());
		item.setFg_setradio(med.getFg_setradio());
		
		
		FArrayList tableDataSource = new FArrayList();
		tableDataSource.add(item);
		ems.setEmsOrDrugListEx(tableDataSource);
	}

	/**
	 * 组装检验医疗单模型信息
	 * 
	 * @param ctx
	 * @param med
	 * @return
	 * @throws BizException
	 */
	private EmsObsItemDO emsModelFrom(MedSrvDO med) throws BizException {
		EmsObsItemDO ems = new EmsObsItemDO();
		ems.setStatus(DOStatus.NEW);
		// 医嘱服务id
		ems.setId_orsrv("");
		// 医嘱医疗单
		ems.setId_or("");
		// 服务id
		ems.setId_srv(med.getId_srv());
		// 服务名称
		ems.setName_srv(med.getName());
		// 服务类型
		ems.setId_srvtp(med.getId_srvtp());
		// 服务类型名称 -- 没有名称
		// headDo.Emsapobs.Name_srvtp ( med.Name);
		// 检查类型id
		ems.setId_obstp(med.getId_srv());
		// 检查类型名称
		ems.setName_obstp(med.getName());

		// 检查申请单号
		ems.setNo_applyobs(CiOrdUtils.getApplyNo(med.getSd_srvtp()));

		// 计划检查时间
		ems.setDt_plan(CiOrdAppUtils.getServerDateTime());

		ems.setId_unit_med(med.getId_unit_med());
		ems.setName_unit_med(med.getMed_name());
		ems.setQuan_med(med.getQuan_med());

		ems.setUse_days(1);
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(med.getId_freq(), ems.getUse_days());
		ems.setTimes_cur(totalTimes);

		FDateTime tm = CiOrdAppUtils.getServerDateTime();
		ems.setDt_begin_ui(tm);

		ems.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1), tm.getUFTime()));

		CalQuantumBP calQuantumBP = new CalQuantumBP();
		ems.setQuan_cur(calQuantumBP.getQuantum(med.getQuan_med(), ems.getTimes_cur()));
		ems.setFg_set(med.getFg_set());
		// 是服务套
		if (CiOrdUtils.isTrue(med.getFg_set())) {

			// 服务套
			MedSrvSetItemDO[] szMedSrvSetItem = GetItemInSet(med.getId_srv(), true);
			if (null == szMedSrvSetItem || szMedSrvSetItem.length == 0) {
				return ems;
			}

			MedSrvSetItemDO mainItem = null;
			StringList listSrvId = new StringList();
			Map<String, MedSrvSetItemDO> tmpSetItemCacheMap = new HashMap<String, MedSrvSetItemDO>();
			for (MedSrvSetItemDO item : szMedSrvSetItem) {
				if (mainItem == null && ICiDictCodeConst.SD_SRVSETITEM_ROLE_MAIN.equals(item.getSd_srvsetrole())) {
					mainItem = item;
				}
				listSrvId.add(item.getId_srv_itm());
				tmpSetItemCacheMap.put(item.getId_srv_itm(), item);
			}

			// 获取套内项目的基础服务定义信息
			MedsrvAggDO[] szMedSrvAggInfo = ServiceFinder.find(IMedsrvRService.class)
					.findByIds(listSrvId.toArray(new String[listSrvId.size()]), FBoolean.FALSE);
			if (szMedSrvAggInfo == null) {
				return ems;
			}

			// 排序号
			int iSortNo = 1;

			// 检查项目元数据集合
			FArrayList lisItemList = new FArrayList();
			for (MedsrvAggDO itemAgg : szMedSrvAggInfo) {
				MedSrvLisDO[] szLisDO = itemAgg.getMedSrvLisDO();
				if (szLisDO == null) {
					continue;
				}

				for (MedSrvLisDO lis : szLisDO) {
					EmsObsLap lab = new EmsObsLap();
					lab.setStatus(DOStatus.NEW);
					lab.setId_srv(lis.getId_srv());
					lab.setSd_contp(lis.getSd_contp());
					lab.setId_contp(lis.getId_contp());
					lab.setName_srv(lis.getSrv_name());

					// lab.setId_pps( lis.getId_pps() );
					// lab.setSd_pps( lis.getSd_pps() );
					// lab.setDes_pps( lis.getDes_pps() );
					lab.setId_su_obs(ICiDictCodeConst.ID_CI_LAB_SQ);
					lab.setSd_su_obs(ICiDictCodeConst.SD_CI_LAB_SQ);
					lab.setQuan(lis.getQuan());// 标本量 zwq 2016-08-05
					lab.setId_quan(lis.getId_unit_quan());// 标本量单位 zwq
															// 2016-08-05
					lab.setDes_sympsign(lis.getDes_labsamp());
					lab.setAnnouncements(lis.getNote()); // 注意事项 bd_srv_lab
					lab.setFg_urgent(ems.getFg_urgent());
					lab.setSd_samptp(lis.getSd_samptp());
					lab.setId_samptp(lis.getId_samptp());
					lab.setSd_colltp(lis.getSd_colltp());
					lab.setId_colltp(lis.getId_colltp());
					lab.setDes_labsamp(lis.getDes_labsamp());
					lab.setFg_chk(FBoolean.TRUE);// 默认全部选中 2016-6-25
					

					// 检验项目冗余服务信息
					lab.setId_srvca(itemAgg.getParentDO().getId_srvca());
					lab.setId_srvtp(itemAgg.getParentDO().getId_srvtp());
					lab.setSd_srvtp(itemAgg.getParentDO().getSd_srvtp());
					lab.setId_primd(itemAgg.getParentDO().getId_primd());
					lab.setFg_or(itemAgg.getParentDO().getFg_or());
					lab.setFg_or(itemAgg.getParentDO().getFg_or());
					lab.setEu_blmd(itemAgg.getParentDO().getEu_blmd());
					lab.setId_medu(itemAgg.getParentDO().getId_unit_med());// 剂量单位
					lab.setQuan_medu(itemAgg.getParentDO().getQuan_med());// 剂量
					lab.setId_freq(itemAgg.getParentDO().getId_freq());
					lab.setFg_bl(itemAgg.getParentDO().getFg_bl());

					if (tmpSetItemCacheMap.containsKey(lis.getId_srv())) {
						MedSrvSetItemDO item = tmpSetItemCacheMap.get(lis.getId_srv());
						lab.setFg_edit(item.getFg_edit());
						lab.setQuan_medu(item.getQuan_medu());
						// 临床项目可选标志 = false, 选中标志 = true, 否则，全部 = false
						lab.setFg_chk(CiOrdUtils.isTrue(item.getFg_clinical())&&!CiOrdUtils.isTrue(item.getFg_edit())?FBoolean.TRUE:FBoolean.FALSE);
					}

					if (mainItem != null) {
						if (mainItem.getId_srv_itm() != null && mainItem.getId_srv_itm().equals(lab.getId_srv())) {
							ems.setId_samptp(lis.getId_samptp());
							ems.setSd_samptp(lis.getSd_samptp());
							ems.setName_samptp(lis.getSamptp_name());
							// 标本采集时间
							ems.setId_sampcoltime(lis.getId_sampcoltime());// 标本采集时间id
							ems.setName_sampcoltime(lis.getName_sampcoltime());// 标本采集时间名称
							ems.setId_sampcollecttimetp(lis.getId_sampcollecttimetp());// 标本采集时间类型
							ems.setSd_sampcollecttimetp(lis.getSd_sampcollecttimetp());// 标本采集时间类型编码
							ems.setLen_sampcoltime(lis.getLen_sampcoltime());// 标本采集时长
							ems.setId_unit_sampcoltime(lis.getId_unit_sampcoltime());// 标本采集时间时长单位
						}
					} else {
						ems.setId_samptp(lis.getId_samptp());
						ems.setSd_samptp(lis.getSd_samptp());
						ems.setName_samptp(lis.getSamptp_name());
						ems.setId_sampcoltime(lis.getId_sampcoltime());// 标本采集时间id
						ems.setName_sampcoltime(lis.getName_sampcoltime());// 标本采集时间名称
						ems.setId_sampcollecttimetp(lis.getId_sampcollecttimetp());// 标本采集时间类型
						ems.setSd_sampcollecttimetp(lis.getSd_sampcollecttimetp());// 标本采集时间类型编码
						ems.setLen_sampcoltime(lis.getLen_sampcoltime());// 标本采集时长
						ems.setId_unit_sampcoltime(lis.getId_unit_sampcoltime());// 标本采集时间时长单位
					}
					lab.setId_labgroup(lis.getId_labgroup());
					lab.setSd_labgroup(lis.getSd_labgroup());
					lab.setSortno(iSortNo + "");
					iSortNo++;
					lisItemList.add(lab);
				}
			}
//			if(med.getFg_setradio()==FBoolean.TRUE){
//				for(int i=0;i<lisItemList.size();i++){
//					if(i==0){
//						((EmsObsLap)lisItemList.get(i)).setFg_chk(FBoolean.TRUE);
//					}else{
//						((EmsObsLap)lisItemList.get(i)).setFg_chk(FBoolean.FALSE);
//					}
//				}
//			}
			ems.setEmsOrObsListEx(lisItemList);
		} else {
			constructEmsObsLapInfo(ems, med);
		}

		return ems;
	}

	/**
	 * 构建检验属性项目
	 * 
	 * @param ems
	 * @param med
	 * @throws BizException
	 */
	public void constructEmsObsLapInfo(EmsObsItemDO ems, MedSrvDO med) throws BizException {

		// XapDataList<EmsObsLap> list = new XapDataList<EmsObsLap>();
		FArrayList listEmsObsLap = new FArrayList();
		MedSrvLisDO[] szMedSrvLisInfo = ServiceFinder.find(IMedSrvLisDORService.class)
				.find(String.format("a1.id_srv='%s'", med.getId_srv()), "", FBoolean.FALSE); // 调用此服务报错

		if (szMedSrvLisInfo == null || szMedSrvLisInfo.length == 0) {
			throw new BizException("检验属性表为空", CiOrdemsErrorCodeEnum.ERRORCODE_BDSRV_PROPERTY_NULL);
		}

		int iNumber = 1;
		for (MedSrvLisDO lis : szMedSrvLisInfo) {
			ems.setId_samptp(lis.getId_samptp());
			ems.setSd_samptp(lis.getSd_samptp());
			ems.setName_samptp(lis.getSamptp_name());
			ems.setId_sampcoltime(lis.getId_sampcoltime());// 标本采集时间id
			ems.setName_sampcoltime(lis.getName_sampcoltime());// 标本采集时间名称
			ems.setId_sampcollecttimetp(lis.getId_sampcollecttimetp());// 标本采集时间类型
			ems.setSd_sampcollecttimetp(lis.getSd_sampcollecttimetp());// 标本采集时间类型编码
			ems.setLen_sampcoltime(lis.getLen_sampcoltime());// 标本采集时长
			ems.setId_unit_sampcoltime(lis.getId_unit_sampcoltime());// 标本采集时间时长单位
			EmsObsLap lab = new EmsObsLap();
			lab.setId_srv(lis.getId_srv());
			lab.setSd_contp(lis.getSd_contp());
			lab.setId_contp(lis.getId_contp());
			lab.setName_srv(med.getName());
			lab.setId_srvca(med.getId_srvca());
			// lab.setDt_plan ( headDO.Dt_begin_ui);
			// lab.setId_pps ( lis.getId_pps);
			// lab.setSd_pps ( lis.getSd_pps);
			// lab.setDes_pps ( lis.getDes_pps);
			lab.setSd_srvtp(med.getSd_srvtp());
			lab.setId_su_obs(ICiDictCodeConst.ID_CI_LAB_SQ);
			lab.setSd_su_obs(ICiDictCodeConst.SD_CI_LAB_SQ);
			lab.setFg_or(med.getFg_or());
			lab.setEu_blmd(med.getEu_blmd());
			lab.setDes_sympsign(lis.getDes_labsamp());
			lab.setAnnouncements(lis.getNote());// 注意事项
			lab.setFg_urgent(ems.getFg_urgent());
			lab.setSd_samptp(lis.getSd_samptp());
			lab.setId_samptp(lis.getId_samptp());

			lab.setQuan(lis.getQuan());
			lab.setId_quan(lis.getId_unit_quan());
			// lab.setId_medu ( lis.Id_unit_nuit());
			lab.setQuan_medu(med.getQuan_med());
			lab.setId_medu(med.getId_unit_med());
			lab.setSd_colltp(lis.getSd_colltp());
			lab.setId_colltp(lis.getId_colltp());
			lab.setDes_labsamp(lis.getDes_labsamp());
			lab.setFg_bl(med.getFg_bl());// zwq 2016-08-22
			lab.setFg_chk(FBoolean.TRUE);// 新增时默认全部选中，2016-6-25
			lab.setSv(lis.getSv());
			lab.setSortno(iNumber + "");
			lab.setId_labgroup(lis.getId_labgroup());
			lab.setSd_labgroup(lis.getSd_labgroup());
			listEmsObsLap.add(lab);
			iNumber++;
		}
		ems.setEmsOrObsListEx(listEmsObsLap);

	}
	
	
	/**
	 * 获取检验套项目
	 * 
	 * @param id_srv
	 * @param is_clinical
	 * @return
	 * @throws BizException
	 */
	protected MedSrvSetItemDO[] GetItemInSet(String id_srv, boolean is_clinical) throws BizException {
		return ServiceFinder.find(IMedSrvSetItemDORService.class).find(String
				.format("a8.fg_clinical='%s' and a8.id_srv='%s' and a8.fg_active='Y'", is_clinical ? "Y" : "N", id_srv),
				"", FBoolean.FALSE);
	}
	
}

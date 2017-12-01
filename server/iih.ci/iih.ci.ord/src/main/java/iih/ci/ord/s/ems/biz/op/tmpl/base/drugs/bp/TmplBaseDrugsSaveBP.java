package iih.ci.ord.s.ems.biz.op.tmpl.base.drugs.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.PharmVerifyStatusEnum;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsMedicinesSaveBP;
import iih.ci.ord.s.ems.biz.op.ems.def.DefaultDrugsCreateOrderInfo;
import iih.ci.ord.s.ems.biz.op.ems.drugs.EmsDrugsValidate;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.dto.DrugOrContentParam;
import iih.ci.ord.s.ems.biz.utils.orcontent.dto.OrContentDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 药品医疗单
 * @author wangqingzhu
 *
 */
public class TmplBaseDrugsSaveBP extends EmsMedicinesSaveBP {

	public TmplBaseDrugsSaveBP() {
		this.setEmsValidate(new EmsDrugsValidate());
		this.setDefaultCreateOrderInfo(new DefaultDrugsCreateOrderInfo());
	}

	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException {
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		for (Object uiModel : listUiModel){
			EmsDrugItemDO doInfo = (EmsDrugItemDO)uiModel;
			// 基础服务和物品信息列表
			BdSrvMmInfoList bdSrvInfoList = new BdSrvMmInfoList();
			for (Object srvInfo : doInfo.getEmsOrDrugListEx()){
				EmsOrDrug drugInfo = (EmsOrDrug)srvInfo;
				BdSrvMmInfo bsmi = new BdSrvMmInfo(srvInfo);
				if (bsmi.createSrvMmInfo(
						drugInfo.getId_srv(), 
						drugInfo.getId_mm(), 
						this.getEnContextInfo().getId_org(), 
						this.getEnContextInfo().getId_dep_or())){
					bdSrvInfoList.add(bsmi);
				}
			}
			
			listDefaultCreateParam.add(new DefaultCreateParam(bdSrvInfoList,doInfo));
		}
    	return listDefaultCreateParam.asArray();
	}

	

	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, Object uiModel) throws BizException {
		EmsDrugItemDO drugItem = (EmsDrugItemDO) uiModel;
		//by yzh 添加医嘱付数
		orderInfo.setDt_last_mp(drugItem.getDt_begin_ui());
		orderInfo.setId_route(drugItem.getId_route());
		orderInfo.setRoute_name(drugItem.getName_route());
		orderInfo.setId_routedes(drugItem.getId_routedes());
		orderInfo.setId_freq(drugItem.getId_freq());
		orderInfo.setSd_frequnitct(drugItem.getSd_frequnitct());
		orderInfo.setFreqct(drugItem.getFreqct());
		orderInfo.setFreq_name(drugItem.getName_freq());
		orderInfo.setDays_or(drugItem.getUse_days());
		orderInfo.setDt_effe(drugItem.getDt_begin_ui());
		orderInfo.setDt_end(drugItem.getDt_end_ui());
		orderInfo.setFg_stop(FBoolean.TRUE);
		orderInfo.setFg_long(drugItem.getFg_long());
	
		orderInfo.setDes_or(drugItem.getNote_or());
		orderInfo.setId_dep_mp(drugItem.getId_dep());
		orderInfo.setTimes_cur(drugItem.getTimes_cur());
		orderInfo.setFg_mp_in(drugItem.getFg_mp_in());
		orderInfo.setTimes_mp_in(drugItem.getTimes_mp_in());
		orderInfo.setEu_orsrcmdtp(drugItem.getEu_orsrcmdtp());//医嘱来源方式
		orderInfo.setQuan_firday_mp(drugItem.getQuan_firday_mp());//首日执行次数
		orderInfo.setNote_or(drugItem.getNote_or());
		orderInfo.setName_or(getNameOR(orderInfo.getSd_srvtp(),drugItem.getEmsOrDrugListEx()));
		List<OrContentDTO> orContentDtos = new ArrayList<OrContentDTO>();
		FArrayList drugList = drugItem.getEmsOrDrugListEx();
		for(int i=0;i<drugList.size();i++){
			EmsOrDrug drug = (EmsOrDrug)drugList.get(i);
			OrContentDTO orContentDTO = new OrContentDTO(drug.getName_srv(), drug.getQuan_med(), drug.getName_unit_med(), drug.getFg_self() == null?false:drug.getFg_self().booleanValue());
			orContentDtos.add(orContentDTO);
		}
		DrugOrContentParam param = new DrugOrContentParam(orderInfo.getSd_srvtp(),orderInfo.getFreq_name(),orderInfo.getDays_or(),orderInfo.getRoute_name(),orderInfo.getNote_or(),orContentDtos);
		//DrugOrContentParam param = new DrugOrContentParam(orderInfo.getSd_srvtp(),orderInfo.getFreq_name(),orderInfo.getDays_or(),orderInfo.getRoute_name(),orderInfo.getNote_or(),drugItem.getEmsOrDrugListEx());
		CiOrContentDO ciOrContentDO = CiOrContentUtils.create(param);
		ciOrContentDO.setTitle(orderInfo.getOrders()==null?"":orderInfo.getOrders()+"");
		orderInfo.setContent_or(ciOrContentDO.toString());
		orderInfo.setDt_last_bl(OrderUtils.getLastDt(orderInfo.getId_freq(), orderInfo.getDt_effe(), orderInfo.getQuan_firday_mp(), orderInfo.getFg_long()));
		orderInfo.setApplyno(drugItem.getApplyno());
		orderInfo.setEu_verify_pharm(PharmVerifyStatusEnum.UNAUDIT);//药品审核标志
		orderInfo.setFuncclassstr(drugItem.getFuncclassstr());
		orderInfo.setId_srvof(drugItem.getId_srvof());
		orderInfo.setStatus(drugItem.getStatus());
		
	}

	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		EmsOrDrug curDrug = (EmsOrDrug) uiModel;
		String idSrv = curDrug.getId_srv();
		if (srvInfo.getId_srv() != null && srvInfo.getId_srv().equals(idSrv)) {
			if (curDrug.getStatus() == DOStatus.DELETED) {
				srvInfo.setStatus(DOStatus.DELETED);
			} else {
				srvInfo.setPri_ratio(FDouble.ONE_DBL);
				srvInfo.setFg_hpindicjudged(curDrug.getFg_hpindicjudged());
				srvInfo.setId_boildes(curDrug.getId_boildes());
				//srvInfo.setId_boil(curDrug.getId_boil());
				srvInfo.setId_srv(curDrug.getId_srv());
				srvInfo.setId_mm(curDrug.getId_mm());
				srvInfo.setPri(curDrug.getPrice());
				srvInfo.setPri_std(curDrug.getPrice());
				srvInfo.setQuan_medu(curDrug.getQuan_med());
				srvInfo.setQuan_total_medu(curDrug.getQuan_cur());
				srvInfo.setId_route(curDrug.getId_route());
				srvInfo.setId_freq(curDrug.getId_freq());
				srvInfo.setSd_frequnitct(curDrug.getSd_frequnitct());
				srvInfo.setFreqct(curDrug.getFreqct());
				srvInfo.setFreq_name(curDrug.getName_freq());
				srvInfo.setFg_extdispense(curDrug.getFg_extdispense());
				srvInfo.setId_hp(curDrug.getId_hp());
				srvInfo.setId_hpsrvtp(curDrug.getId_hpsrvtp());
				srvInfo.setSd_hpsrvtp(curDrug.getSd_hpsrvtp());
				srvInfo.setDes_hplimit(curDrug.getLimit());
				srvInfo.setFg_self(curDrug.getFg_self());
				srvInfo.setFg_selfpay(curDrug.getFg_selfpay());
				srvInfo.setFg_selfsrv(curDrug.getFg_selfsrv());
				srvInfo.setFg_indic(curDrug.getFg_treat());
				srvInfo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
				srvInfo.setId_routedes(curDrug.getId_routedes());
				srvInfo.setFg_dose_anoma(curDrug.getFg_dose_anoma());
				srvInfo.setId_dep_mp(curDrug.getId_mp_dep());
				srvInfo.setId_dep_wh(curDrug.getId_dep_wh());
				srvInfo.setFg_skintest(CiOrdUtils.nullHandle(curDrug.getFg_skintest()));
				srvInfo.setId_skintest_skip_reason(curDrug.getId_skintest_skip_reason());// 2016-03-25
																							// 新增
				srvInfo.setSd_skintest_skip_reason(curDrug.getSd_skintest_skip_reason());// 2016-03-25
																							// 新增
				// 服务关联的id_or
				srvInfo.setId_or_rel(curDrug.getId_or_rel());
				srvInfo.setSd_reltp(curDrug.getSd_reltp());
				srvInfo.setStatus(curDrug.getStatus());
			}
		}
		
		
	}
	
	
	protected void handleOrderSrvRelInfo(OrderPackageInfo pInfo, OrdSrvDO[] szOrdSrvInfo) throws BizException {
		for (OrdSrvDO srv : szOrdSrvInfo) {
			// 关联皮试逻辑
			// 到此为止的sd_reltp是前台判断医嘱是否进行皮试的标识0需要皮试
			if (FBoolean.TRUE.equals(srv.getFg_skintest()) && ICiDictCodeConst.CODE_SKIN_SKIN.equals(srv.getSd_reltp())) {
				// 皮试自动生成启动参数逻辑控制
				if (CiOrParamUtils.IsAutoGenSkinTestOrEnable(srv.getId_org())) {
					// 在此重新为sd_reltp和id_reltp重新赋值，赋值为皮试医嘱关联的sd和id
					srv.setSd_reltp(ICiDictCodeConst.SD_RELTYPE_SKINTEST);
					srv.setId_reltp(ICiDictCodeConst.SD_RELTYPE_ID_SKINTEST);
					// 如果当前药品服务已经关联了皮试医嘱，就不用重新生成皮试医嘱了
					if (CiOrdUtils.isEmpty(srv.getId_or_rel())) {
						String[] ids = new DBUtil().getOIDs(1);
						srv.setId_or_rel(ids[0]);
						//String id_srvskin = CiOrdUtils.getMmRelSkinSrv(srv.getId_mm());
					}
				}
			}
		}
	}
	
	

	@Override
	protected void mergeOrderMmInfo(CiEnContextDTO ctx, OrdSrvMmDO srvMmInfo, Object uiModel) throws BizException {
		// TODO Auto-generated method stub
		EmsOrDrug drug = (EmsOrDrug)uiModel;
		srvMmInfo.setId_pgku_cur(drug.getId_unit_sale());
		srvMmInfo.setPrice_pgku_cur(drug.getTotalprice());
		srvMmInfo.setQuan_cur(drug.getQuan_cur());
		srvMmInfo.setId_pgku_base(drug.getId_unit_base());
			try {
				int[] numben = OrSrvSplitUtil.getNumDen(drug.getQuan_med(), drug.getFactor_mb());
				srvMmInfo.setQuan_num_base(numben[0]);
				srvMmInfo.setQuan_den_base(numben[1]);
			} catch (NumberFormatException ex) {
				throw new BizException(drug.getName_srv() + "服务剂量录入不合法！");
			}
			srvMmInfo.setQuan_bed_medu(FDouble.ZERO_DBL);
			srvMmInfo.setId_mupkgutp(drug.getId_opmutp());
			srvMmInfo.setSd_mupkgutp(drug.getSd_mupkgutp());
			srvMmInfo.setFactor(drug.getFactor_cb());
			srvMmInfo.setFactor_mb(drug.getFactor_mb());
			srvMmInfo.setId_dosage(drug.getId_dosage());
			srvMmInfo.setSd_dosage(drug.getSd_dosage());
			srvMmInfo.setId_pharm(drug.getId_pharm());
			srvMmInfo.setSd_pharm(drug.getSd_pharm());
			srvMmInfo.setId_val(drug.getId_val());
			srvMmInfo.setSd_val(drug.getSd_val());
			srvMmInfo.setId_pois(drug.getId_pois());
			srvMmInfo.setSd_pois(drug.getSd_pois());
			srvMmInfo.setId_anti(drug.getId_anti());
			srvMmInfo.setSd_anti(drug.getSd_anti());
			srvMmInfo.setId_mmtp(drug.getId_mmtp());
			srvMmInfo.setSd_mmtp(drug.getSd_mmtp());
			srvMmInfo.setId_srv(drug.getId_srv());
			srvMmInfo.setFg_otc(drug.getFg_otc()); // 2016-07-21 将该注释去掉
			srvMmInfo.setStatus(drug.getStatus());
			// mm.setDays_available(targetDrug.getDays_available());//领可用天数（门诊用）
	
		
		
	}
	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		if (listUiModel==null || listUiModel.size()==0) return null;
		EmsDrugItemDO itemDO = (EmsDrugItemDO) listUiModel.get(0);
		OrderKey2UiModelMap orderMap = new OrderKey2UiModelMap();
		orderMap.put(itemDO.getId_or(), itemDO);
		return orderMap;
	}


	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		if (uiModel==null) return null;
		EmsDrugItemDO itemDO = (EmsDrugItemDO) uiModel;
		FArrayList drugList = itemDO.getEmsOrDrugListEx();
		SrvKey2UiModelMap srvMap = new SrvKey2UiModelMap();
		for (Object obj : drugList) {
			EmsOrDrug drug = (EmsOrDrug) obj;
			srvMap.put(drug.getId_orsrv(),drug);
		}
		return srvMap;
	}
	
	@Override
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO srvInfo, Object uiModel)
			throws BizException {
		
	}

	/**
	 * 物品对照，医生选择的药品进行对照
	 */
//	@Override
//	protected void mergeOrderMmInfo(CiEnContextDTO ctx, OrdSrvMmDO[] mmList, Object uiModel) throws BizException {
//		EmsDrugItemDO drugItem = (EmsDrugItemDO) uiModel;
//		FArrayList emsOrDrugs = drugItem.getEmsOrDrugListEx();
//		Map<String, EmsOrDrug> temEmsOrDrugMap = new HashMap<String, EmsOrDrug>();
//		for (Object obj : emsOrDrugs) {
//			EmsOrDrug curDrug = (EmsOrDrug) obj;
//			String key = curDrug.getId_srv() + curDrug.getId_mm();
//			temEmsOrDrugMap.put(key, curDrug);
//		}
//		for (OrdSrvMmDO mm : mmList) {
//			String targetKey = mm.getId_srv() + mm.getId_mm();
//			EmsOrDrug targetDrug = temEmsOrDrugMap.get(targetKey);
//			mm.setId_pgku_cur(targetDrug.getId_unit_sale());
//			mm.setPrice_pgku_cur(targetDrug.getTotalprice());
//			mm.setQuan_cur(targetDrug.getQuan_cur());
//			mm.setId_pgku_base(targetDrug.getId_unit_base());
//			try {
//				int[] numben = OrSrvSplitUtil.getNumDen(targetDrug.getQuan_med(), targetDrug.getFactor_mb());
//				mm.setQuan_num_base(numben[0]);
//				mm.setQuan_den_base(numben[1]);
//			} catch (NumberFormatException ex) {
//				throw new BizException(targetDrug.getName_srv() + "服务剂量录入不合法！");
//			}
//			mm.setQuan_bed_medu(FDouble.ZERO_DBL);
//			mm.setId_mupkgutp(targetDrug.getId_mupkgutp());
//			mm.setSd_mupkgutp(targetDrug.getSd_mupkgutp());
//			mm.setFactor(targetDrug.getFactor_cb());
//			mm.setFactor_mb(targetDrug.getFactor_mb());
//			mm.setId_dosage(targetDrug.getId_dosage());
//			mm.setSd_dosage(targetDrug.getSd_dosage());
//			mm.setId_pharm(targetDrug.getId_pharm());
//			mm.setSd_pharm(targetDrug.getSd_pharm());
//			mm.setId_val(targetDrug.getId_val());
//			mm.setSd_val(targetDrug.getSd_val());
//			mm.setId_pois(targetDrug.getId_pois());
//			mm.setSd_pois(targetDrug.getSd_pois());
//			mm.setId_anti(targetDrug.getId_anti());
//			mm.setSd_anti(targetDrug.getSd_anti());
//			mm.setId_mmtp(targetDrug.getId_mmtp());
//			mm.setSd_mmtp(targetDrug.getSd_mmtp());
//			mm.setId_srv(targetDrug.getId_srv());
//			mm.setFg_otc(targetDrug.getFg_otc()); // 2016-07-21 将该注释去掉
//			mm.setStatus(targetDrug.getStatus());
//			// mm.setDays_available(targetDrug.getDays_available());//领可用天数（门诊用）
//		}
//	}

	@Override
	protected int GetSrvObjStatus(Object objDO) {
		EmsDrugItemDO drugItem = (EmsDrugItemDO) objDO;
		return drugItem.getStatus();
	}
	private String getNameOR(String sd_srvtp,FArrayList emssrvs) {
		String name_or = "";
		if (!CiOrdUtils.isEmpty(emssrvs)) {
			if (sd_srvtp.equals(
					IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)
					|| sd_srvtp.equals(
							IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY) || sd_srvtp.equals(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_KF)) {
				for (int i = 0; i < emssrvs.size(); i++) {
					EmsOrDrug srv = (EmsOrDrug) emssrvs.get(i);
					name_or += "," + srv.getName_srv();
				}
			} else if (sd_srvtp.startsWith(
					IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				//name_or = ",草药";
				for (int i = 0; i < emssrvs.size(); i++) {
					EmsOrDrug srv = (EmsOrDrug) emssrvs.get(i);
					name_or += "," + srv.getName_srv();
				}
			} 
		}
		if (name_or != "") {
			return name_or.substring(1);
		}
		return name_or;
	}
}

package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.drugs.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.PharmVerifyStatusEnum;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.ems.drugs.bp.EmsDrugsSaveBP;
import iih.ci.ord.s.ems.biz.op.tmpl.meta.OrderTmplDetailList;
import iih.ci.ord.s.ems.biz.utils.FreqInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.dto.DrugOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 药品医疗单
 * @author wangqingzhu
 *
 */
public class TmplDrugsSaveBP extends EmsDrugsSaveBP {

	public TmplDrugsSaveBP(IEmsValidate iv) {
		super(iv);
		
	}

	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException {
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		for (Object uiModel : listUiModel){
			OrderTmplDetailList detailList = (OrderTmplDetailList)uiModel;
			// 基础服务和物品信息列表
			BdSrvMmInfoList bdSrvInfoList = new BdSrvMmInfoList();
			for (OrTplNItmDO tmplInfo : detailList){
				
				BdSrvMmInfo bsmi = new BdSrvMmInfo(tmplInfo);
				if (bsmi.createSrvMmInfo(
						tmplInfo.getId_srv(), 
						tmplInfo.getId_mm(), 
						this.getEnContextInfo().getId_org(), 
						this.getEnContextInfo().getId_dep_or())){
					bdSrvInfoList.add(bsmi);
				}
			}
			
			listDefaultCreateParam.add(new DefaultCreateParam(bdSrvInfoList,detailList));
		}
    	return listDefaultCreateParam.asArray();
	}

	

	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, Object uiModel) throws BizException {
		OrderTmplDetailList detailList = (OrderTmplDetailList)uiModel;
		OrTplNItmDO drugItem = detailList.get(0);
		FDateTime tm = CiOrdAppUtils.getServerDateTime();
		orderInfo.setDt_last_mp(tm);
		orderInfo.setId_route(drugItem.getId_route());
		
		orderInfo.setId_routedes(drugItem.getId_routedes());
		orderInfo.setId_freq(drugItem.getId_freq());
		orderInfo.setDays_or(drugItem.getDays_or());
		orderInfo.setDt_effe(tm);
		orderInfo.setDt_end(tm);
		orderInfo.setFg_stop(FBoolean.TRUE);
		orderInfo.setFg_long(FreqInfoUtils.GetFgLong(drugItem.getId_freq()));
	
		orderInfo.setDes_or(drugItem.getDes_or());
//		orderInfo.setId_dep_mp(drugItem.getId_dep_mp());
//		orderInfo.setTimes_cur(drugItem.getTimes_cur());
//		orderInfo.setFg_mp_in(drugItem.getFg_mp_in());
//		orderInfo.setTimes_mp_in(drugItem.getTimes_mp_in());
		
		orderInfo.setEu_orsrcmdtp(ctx.getEu_orsrcmdtp());//医嘱来源方式

		orderInfo.setNote_or(drugItem.getDescription());
		orderInfo.setName_or(getNameOR(orderInfo.getSd_srvtp(),detailList.asSrvNameArray()));
//		DrugOrContentParam param = new DrugOrContentParam(orderInfo.getSd_srvtp(),orderInfo.getFreq_name(),orderInfo.getDays_or(),orderInfo.getRoute_name(),orderInfo.getNote_or(),drugItem.getEmsOrDrugListEx());
//		CiOrContentDO ciOrContentDO = CiOrContentUtils.create(param);
//		ciOrContentDO.setTitle(orderInfo.getOrders()==null?"":orderInfo.getOrders()+"");
//		orderInfo.setContent_or(ciOrContentDO.toString());
		orderInfo.setDt_last_bl(OrderUtils.getLastDt(orderInfo.getId_freq(), orderInfo.getDt_effe(), orderInfo.getQuan_firday_mp(), orderInfo.getFg_long()));
		orderInfo.setApplyno(CiOrdUtils.getApplyNo(drugItem.getSd_srvtp()));
		orderInfo.setEu_verify_pharm(PharmVerifyStatusEnum.UNAUDIT);//药品审核标志
		
		orderInfo.setId_srvof(detailList.getId_ems());
		orderInfo.setStatus(drugItem.getStatus());
		
	}

	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		//EmsOrDrug curDrug = (EmsOrDrug) uiModel;
		OrTplNItmDO drugItem = (OrTplNItmDO) uiModel;
		String idSrv = drugItem.getId_srv();

				srvInfo.setPri_ratio(FDouble.ONE_DBL);
				
				
				srvInfo.setId_srv(drugItem.getId_srv());
				srvInfo.setId_mm(drugItem.getId_mm());
				srvInfo.setPri(drugItem.getPrice());
				srvInfo.setPri_std(drugItem.getPrice());
				srvInfo.setQuan_medu(drugItem.getQuan_med());
//				srvInfo.setQuan_total_medu(drugItem.getQuan_cur());
				srvInfo.setId_route(drugItem.getId_route());
				srvInfo.setId_freq(drugItem.getId_freq());
				srvInfo.setSd_frequnitct(FreqInfoUtils.GetSDFreq(drugItem.getId_freq()));
				srvInfo.setFreqct(FreqInfoUtils.GetFreqct(drugItem.getId_freq()));
				
				//srvInfo.setFg_extdispense(drugItem.getFg_extdispense());
				
				srvInfo.setFg_hpindicjudged(1);
				
//				srvInfo.setId_hp(ctx.getId_hp());
//				srvInfo.setId_hpsrvtp(drugItem.getId_hpsrvtp());
//				srvInfo.setSd_hpsrvtp(drugItem.getSd_hpsrvtp());
//				srvInfo.setDes_hplimit(drugItem.getLimit());
//				srvInfo.setFg_selfpay(drugItem.getFg_selfpay());
//				srvInfo.setFg_indic(drugItem.getFg_treat());
				srvInfo.setFg_self(FBoolean.FALSE);
				srvInfo.setFg_selfsrv(FBoolean.FALSE);
				srvInfo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
				srvInfo.setId_routedes(drugItem.getId_routedes());
				srvInfo.setFg_dose_anoma(FBoolean.FALSE);
			
//				srvInfo.setId_dep_mp(drugItem.getId_dep_mp());
//				srvInfo.setId_dep_wh(drugItem.getId_dep_wh());
//				srvInfo.setFg_skintest(CiOrdUtils.nullHandle(drugItem.getFg_skintest()));
//				srvInfo.setId_skintest_skip_reason(drugItem.getId_skintest_skip_reason());
//				srvInfo.setSd_skintest_skip_reason(drugItem.getSd_skintest_skip_reason());
				// 服务关联的id_or
//				srvInfo.setId_or_rel(drugItem.getId_or_rel());
//				srvInfo.setSd_reltp(drugItem.getSd_reltp());
				srvInfo.setStatus(DOStatus.NEW);
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
	protected int GetSrvObjStatus(Object objDO) {
		
		return DOStatus.NEW	;
	}
	
}

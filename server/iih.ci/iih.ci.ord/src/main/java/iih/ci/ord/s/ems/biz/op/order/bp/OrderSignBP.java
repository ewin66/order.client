package iih.ci.ord.s.ems.biz.op.order.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.service.d.CgTypeEnum;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.d.CijudgeSpecillDTO;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.dto.d.MedicalSharingDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.hp.HpDetailedRuleBP;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.CiOrEventsSaveBP;
import iih.ci.ord.s.bp.CiOrOpSessionInsertBP;
import iih.ci.ord.s.bp.CiOrderUpdateHpCiDiBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuValidateBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppPathgyDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppRisDataBP;
import iih.ci.ord.s.bp.orsms.lis.CiLisOrSmsHandlerBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitHandleBP;
import iih.ci.ord.s.bp.validate.OrDoctorCheckValidateBP;
import iih.ci.ord.s.bp.validate.OrSrvDoctorRtValidateBP;
import iih.ci.ord.s.bp.validate.PathgySampValidateBP;
import iih.ci.ord.s.bp.validate.SkinTestOrSignBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderSignBP;
import iih.ci.ord.s.ems.define.StringList;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱签署
 * 
 * @author Young
 *
 */
public class OrderSignBP implements IOrderSignBP {
	@Override
	public OrderRstDTO sign(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		FMap2 emsExtensionMap2 = arg.getExtension();

 		OrderRstDTO rstDTO = new OrderRstDTO();
		Context.get().setAttribute("CiEnContextDTO", arg.getEnContext());
		FArrayList paramList = arg.getDocument();
		if (paramList == null || paramList.size() <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		StringList lstIdors = new StringList(paramList);
		
		if (lstIdors.size() == 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		//获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(lstIdors.asArray(), FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(aggors)) {
			throw new BizException("医嘱状态已经发生变化，请刷新列表！");
		}
		
		 //签署时医保验证自费签署
		if(emsExtensionMap2 != null && emsExtensionMap2.containsKey("MedicalSharingDTO")){
			String id_orsrv = (String)emsExtensionMap2.get("MedicalSharingDTO");
			ValidataMedicalSharing(id_orsrv,aggors);
		}
		
		
		
		
		//皮试医嘱保存校验
		SkinTestOrSignBP skintestbp = new SkinTestOrSignBP();
		skintestbp.exec(aggors);

		//病理标本项目非空检查
		PathgySampValidateBP pathgysamptestbp = new PathgySampValidateBP();
		pathgysamptestbp.exec(aggors);

		//用血医嘱可用血余量的校验
		UseBtOrNumMarginBuValidateBP usebtbp = new UseBtOrNumMarginBuValidateBP();
		usebtbp.exe(aggors);

		//如果是医保类医嘱或临床路径待判断的医嘱，判断医生是否已经判断过。如果存在医生未判断，则将数据传送到前台，让医生判断
		OrDoctorCheckValidateBP docvalidatebp = new OrDoctorCheckValidateBP();
		FArrayList willCheckIdOrs = docvalidatebp.exec(aggors);
		if (!CiOrdUtils.isEmpty(willCheckIdOrs)) {
			OrderRstDTO dto = new OrderRstDTO();
			FMap2 scene = new FMap2();
			scene.put("willCheckIdOrs", willCheckIdOrs);
			dto.setExtension(scene);
			return dto;
		}
         
		//验证当前为医保数据进行医保规则校验
				String  hpmessage ="";
				Ent4BannerDTO banner = arg.getEnContext().getEnt4BannerDTO();
				if( banner != null && (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
						banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET))
						&& banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("1"))
				{ 
					if (emsExtensionMap2 != null) {
					   hpmessage = (String) emsExtensionMap2.get("hpmessage");
					}
					if(hpmessage==""){ //界面确认返回的
			           //医保规则
						OrderRstDTO checkRstDTO= SignMedicalRule(aggors);
						if(checkRstDTO != null){
							return checkRstDTO;
						}
				  }
				}
		//医嘱服务开立权限判断逻辑
		OrSrvDoctorRtValidateBP doctorRtbp = new OrSrvDoctorRtValidateBP();
		FMap2 orsrvrtchk = doctorRtbp.exec(aggors);
		if (orsrvrtchk != null && orsrvrtchk.size() > 0) {
			OrderRstDTO dto = new OrderRstDTO();
			dto.setExtension(orsrvrtchk);
			return dto;
		}

		CiOrderDO[] ciors = getCiOrderDOs(aggors);
		FDateTime dt_cur = CiOrdAppUtils.getServerDateTime();
		//药品毒麻信息审核
		FArrayList checkPatInfoSrvs = srvPoisInfoCheck(aggors);
		//判断特殊病，用户干预后 点击 否 签署 不是特殊病药，不在进行判断  bug 106951
		String notSpecilDrugIdOrsrv = "";
		if (emsExtensionMap2 != null) {
			notSpecilDrugIdOrsrv = (String) emsExtensionMap2.get("notSpecilDrugIdOrsrv");
			//ValidataMedicalSharing(notSpecilDrugIdOrsrv,aggors);
		}
		if (notSpecilDrugIdOrsrv == "") {
			//特殊病判断
			FMap2 mapIdOrsrv = new FMap2();
			String specilInfo = judgeSpecillFlag(aggors, arg.getEnContext(), mapIdOrsrv);
			if (checkPatInfoSrvs.size() > 0 || !CiOrdUtils.isEmpty(specilInfo)) {
				//插入   用户干预点   //用户确认后继续
				OrderRstDTO dto = new OrderRstDTO();
				FMap2 scene = new FMap2();
				scene.put("dt_cur", dt_cur);
				scene.put("ciors", CiOrdUtils.array2FArrayList(ciors));
				if (checkPatInfoSrvs.size() > 0) {
					scene.put("checkPatInfoSrvs", checkPatInfoSrvs);
				}
				if (!CiOrdUtils.isEmpty(specilInfo)) {
					scene.put("specilDrugs", specilInfo );
				}
				scene.put("notSpecilDrugIdOrsrv", getMapKey(mapIdOrsrv));
				dto.setExtension(scene);
				return dto;
			}
		}

		//本次就诊为医保就诊时，判断是否存在保外诊断，如果存在保外诊断更新医嘱中的保外诊断属性
		if (CiOrdUtils.isHpUsing(arg.getEnContext())) {
			List<String> idSrvList = new ArrayList<String>();
			for (CiorderAggDO ciorderAgg : aggors) {
				CiOrderDO ciOrder = ciorderAgg.getParentDO();
				if (ICiDictCodeConst.SD_SU_OPEN.equals(ciOrder.getSd_su_or())) {

					String sdSrvtp = ciOrder.getSd_srvtp();

					// 药品，非溶媒 时校验是否重复开药
					if (sdSrvtp.startsWith(IBdSrvTpDictCodeConst.SD_SRVTP_DRUG)
							&& !IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG_DSY.equals(sdSrvtp)) {

						OrdSrvDO[] OrdSrvs = ciorderAgg.getOrdSrvDO();
						for (OrdSrvDO ordSrv : OrdSrvs) {
							if (idSrvList.contains(ordSrv.getId_srv())) {
								throw new BizRuntimeException("医保患者签署处置时存在重复药品[" + ordSrv.getName() + "]！");
							}
							// 医保只需要 医保校验排除自费，自备，外配，频次周期类型为一次的药品
							if (FBoolean.TRUE.equals(ordSrv.getFg_mm())&& !FBoolean.TRUE.equals(ordSrv.getFg_selfpay()) 
									&& !FBoolean.TRUE.equals(ordSrv.getFg_self())
									&& !IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(ordSrv.getSd_frequnitct())) {
								idSrvList.add(ordSrv.getId_srv());
							}
						}
					}
				}
			}

			// 查询保外诊断
			ICidiagQryService icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);
			CiDiagItemDO[] ciDiagItems = icidiagQryService.getHpjudgetpCiDiagItems(arg.getEnContext().getId_en());

			if (!CiOrdUtils.isEmpty(ciDiagItems)) {

				CiEnContextUtil.SetHpCiDiagItem(arg.getEnContext(), ciDiagItems);
				for (CiOrderDO ciOrderDO : ciors) {
					ciOrderDO.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);// 医保适应症判断标识枚举
					ciOrderDO.setBhpjudgerst(arg.getEnContext().getBhpjudgerst()); // 基本医保判断结果数据信息
					ciOrderDO.setDes_bhpjudgerst(arg.getEnContext().getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述，保外诊断id串
				}

				CiOrderUpdateHpCiDiBP ciOrderUpdateHpCiDiBP = new CiOrderUpdateHpCiDiBP(arg.getEnContext());
				ciOrderUpdateHpCiDiBP.execUpdateOrdSrvs(lstIdors.toArray(new String[lstIdors.size()]));
			}
		}

		return saveSignData(ciors, dt_cur);
	}

	/**
	 * map 的values 转换成 String
	 * 
	 * @param map
	 * @return
	 */
	private String getMapKey(FMap2 map) {
		StringBuffer sb = new StringBuffer();
		if (map != null) {
			for (Object id_orsrv : map.values()) {
				sb.append("'");
				sb.append(id_orsrv.toString());
				sb.append("',");
			}
		}
		return sb.toString();
	}
	 /**
	  * 签署验证医保规则
	  * @param aggors
	  * @return
	  * @throws BizException
	  */
	private OrderRstDTO SignMedicalRule(CiorderAggDO[] aggors) throws BizException {
		//为医保验证弹窗中的服务名称拼装物品名称:服务名称(物品名称) by yzh 2017-10-23 13:39:40 BUG:0109371
		if (!CiOrdUtils.isEmpty(aggors)) {
			for (CiorderAggDO ciorderAggDO : aggors) {
				String MM_name = getOrderMMName(ciorderAggDO);
				if (MM_name != null)
					ciorderAggDO.getParentDO()
							.setName_or(ciorderAggDO.getParentDO().getName_or() + "(" + MM_name + ")");
			}
		}
		CiHpCheckResultDTO result = HpDetailedRuleBP.getInstance().getHpOrderSigndRule(aggors);
		if (result != null && !result.getCheckflag().booleanValue()) {
			FMap2 hpmessageMap = new FMap2();
			FArrayList2 hplist = new FArrayList2();
			FArrayList rstlist = result.getErroritm_list();
			if (rstlist != null) {
				for (int i = 0; i < rstlist.size(); i++) {
					ItmChkRstDTO chkRstDTO = (ItmChkRstDTO) rstlist.get(i);
					MedicalSharingDTO medicalSahringDTO = new MedicalSharingDTO();
					medicalSahringDTO.setCode_or(chkRstDTO.getCode_or());
					// medicalSahringDTO.setName_srv(chkRstDTO.getName_srv());
					// 医保验证弹窗服务名称取值 by yzh bug:0109371
					medicalSahringDTO.setName_srv(chkRstDTO.getName_or());
					FMap map = chkRstDTO.getError_map();
					List<String> mapKeyList = new ArrayList<String>(map.keySet());
					String keys = "";
					String values = "";
					for (String key : mapKeyList) {
						keys += "," + key;
						values += map.get(key) + "\n";
					}
					if (WarningAndStop(keys) == FBoolean.TRUE) {
						medicalSahringDTO.setCode("Stop");
					}
					medicalSahringDTO.setReason(values);
					hplist.add(medicalSahringDTO);
				}
			}
			hpmessageMap.put("hprule", hplist);
			OrderRstDTO dto = new OrderRstDTO();
			hpmessageMap.put("hpmessage", "hpmessage");
			dto.setExtension(hpmessageMap);
			return dto;
		}
		return null;
	}

	/**
	 * 物品名称
	 * by yzh
	 * @param oraggandrelinfo
	 * @return
	 */
	private String getOrderMMName(CiorderAggDO aggor) {
		if (!CiOrdUtils.isEmpty(aggor)) {
				OrdSrvDO[] ordSrvDOs = aggor.getOrdSrvDO();
				if(CiOrdUtils.isEmpty(ordSrvDOs)) return null;
				for (OrdSrvDO ordSrvDO : ordSrvDOs) {
					if(CiOrdUtils.isEmpty(ordSrvDO)) continue;
					if(FBoolean.TRUE.equals(ordSrvDO.getFg_mm())) return ordSrvDO.getName(); 
				}
		}
		return null;
	}

	 /**
		 * 保存时 提示信息还是终止保存；
		 * @param keys
		 * @return
		 */
	   private  FBoolean  WarningAndStop(String keys){
		   if(keys != ""){
				   if(keys.contains(CiHpCheckFailResultEnum.REPEAT_PRES_DRUG)){
					   return FBoolean.TRUE;
				   }
				 if(keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_ONE_TIME)){
					 return FBoolean.TRUE;
						   }
				 if(keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP)){
					 return FBoolean.TRUE;
				 }
				 if(keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_OWN_OEP)){
					 return FBoolean.TRUE;
				 }
				 if(keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_GET_ER)){
					 return FBoolean.TRUE;
				 }
				 return FBoolean.FALSE;
		   }
		   
		   return  FBoolean.FALSE;
	   }
	/**
	 * 获得医嘱主DO数组
	 * 
	 * @param aggors
	 * @return
	 */
	private CiOrderDO[] getCiOrderDOs(CiorderAggDO[] aggors) {

		List<CiOrderDO> ciOrderList = new ArrayList<CiOrderDO>();
		for (int i = 0; i < aggors.length; i++) {
			CiOrderDO ciOrder = aggors[i].getParentDO();
			if (ICiDictCodeConst.SD_SU_OPEN.equals(ciOrder.getSd_su_or())) {
				ciOrderList.add(ciOrder);
			}
		}
		if (ciOrderList.size() != aggors.length) {
			throw new BizRuntimeException("医嘱数据状态发生改变，请勿重复签署！");
		}
		return ciOrderList.toArray(new CiOrderDO[ciOrderList.size()]);
	}

	/**
	 * 药品毒麻信息审核
	 * 
	 * @param aggors
	 * @return
	 */
	private FArrayList srvPoisInfoCheck(CiorderAggDO[] aggors) {
		FArrayList idorsrvs = new FArrayList();
		FArrayList ordsrvPois = new FArrayList();
		FMap orsrvMap = new FMap();
		for (CiorderAggDO agg : aggors) {
			if (!agg.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
				continue;
			OrdSrvDO[] ordSrvdos = agg.getOrdSrvDO();
			for (OrdSrvDO srvdo : ordSrvdos) {
				idorsrvs.append(srvdo.getId_orsrv());
				orsrvMap.put(srvdo.getId_orsrv(), srvdo);
			}
		}
		try {
			OrdSrvMmDO[] srvmms = CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList("Id_orsrv", idorsrvs);
			idorsrvs.clear();
			if (srvmms == null)
				return ordsrvPois;
			for (OrdSrvMmDO srvmm : srvmms) {
				if (CiOrdUtils.isEmpty(srvmm.getSd_pois()))
					continue;
				if (CiOrdUtils.isNeedCheckPatInfo(srvmm.getSd_pois()).booleanValue()) {
					idorsrvs.append(srvmm.getId_orsrv());
				}
			}
			if (idorsrvs.size() > 0) {
				OrSrvAgentInfoDO[] orsrvAgentInfoDOs = CiOrdAppUtils.getCiorsrvagentRService().findByAttrValList(
						"Id_orsrv", idorsrvs);
				if (!CiOrdUtils.isEmpty(orsrvAgentInfoDOs)) {
					for (OrSrvAgentInfoDO srvagent : orsrvAgentInfoDOs) {
						idorsrvs.remove(srvagent.getId_orsrv());
					}
				}

				if (idorsrvs.size() > 0) {
					for (Object id_orsrv : idorsrvs) {
						ordsrvPois.append(orsrvMap.get(id_orsrv.toString()));
					}
				}
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return ordsrvPois;
	}

	/**
	 * 特殊判断，返回需要校验特殊病的服务集合
	 * 
	 * @param aggs
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private String judgeSpecillFlag(CiorderAggDO[] aggs, CiEnContextDTO ctx, FMap2 mapIdOrsrv) throws BizException {
		Ent4BannerDTO banner = ctx.getEnt4BannerDTO();
		//return "西药，中药";
		//非医保或患者非特病返回false
		if (CiOrdUtils.isEmpty(banner.getId_hp()) || banner.getFg_hpspcl() == null
				|| !banner.getFg_hpspcl().booleanValue())
			return null;
		FArrayList idOrsrvs = new FArrayList();
		Map<String, OrdSrvDO> ordsrvMap = new HashMap<String, OrdSrvDO>();
		for (CiorderAggDO agg : aggs) {
			OrdSrvDO[] ordsrvs = agg.getOrdSrvDO();
			for (OrdSrvDO srv : ordsrvs) {
				if (srv.getFg_self() == FBoolean.FALSE &&  srv.getFg_selfpay()==FBoolean.FALSE && srv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
					idOrsrvs.append(srv.getId_orsrv());
					ordsrvMap.put(srv.getId_orsrv(), srv);
				}
			}
		}

		if (idOrsrvs.size() == 0)
			return null;
		OrdSrvMmDO[] srvmmdos = CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList("Id_orsrv", idOrsrvs);
		List<String> idMMs = new ArrayList<String>();
		Map<String, OrdSrvMmDO> mmMap = new HashMap<String, OrdSrvMmDO>();
		if (!CiOrdUtils.isEmpty(srvmmdos)) {
			for (OrdSrvMmDO srvmm : srvmmdos) {
				if (!CiOrdUtils.isEmpty(srvmm.getId_mm())) {
					if (!idMMs.contains(srvmm.getId_mm())) {
						idMMs.add(srvmm.getId_mm());
						mmMap.put(srvmm.getId_mm(), srvmm);
					}
				}
			}
		} else {
			return null;
		}

		List<OrdSrvDO> updSpecilSrvs = new ArrayList<OrdSrvDO>();
		FArrayList2 specilDrugs = new FArrayList2();
		IBLCancelSettlement blservice = CiOrdAppUtils.getIBLCancelSettlement();
		List<CijudgeSpecillDTO> specils = blservice.JudgeSpecillFlag(banner.getNo_hp(), banner.getId_hp(),
				idMMs.toArray(new String[idMMs.size()]));
		if (!CiOrdUtils.isEmpty(specils) && specils.size() > 0) {
			ICiOrdQryService ciordqryservice = CiOrdAppUtils.getCiOrdQryService();
			EntDiDO[] entdis = ciordqryservice.getEntDiDOList(banner.getId_ent());
			for (CijudgeSpecillDTO specill : specils) {
				FMap2 diagmap = specill.getDiagmap();
				if (!CiOrdUtils.isEmpty(specill.getFg_mmspecill()) && specill.getFg_mmspecill().booleanValue()
						&& !CiOrdUtils.isEmpty(diagmap)) {
					if (!CiOrdUtils.isEmpty(entdis)) {
						boolean flag = true;
						for (EntDiDO entdi : entdis) {
							String code_di = entdi.getCode_didef_dis();
							if (diagmap.containsKey(code_di)) {
								flag = false;
								break;
							}
						}
						if (flag) {
							
							mapIdOrsrv.put(mmMap.get(specill.getId_mm()).getId_orsrv(), mmMap.get(specill.getId_mm()).getId_orsrv());
							String name_srv = ordsrvMap.get(mmMap.get(specill.getId_mm()).getId_orsrv()).getName();
							specilDrugs.add(name_srv+"["+mmMap.get(specill.getId_mm()).getName_mm() +"] 是特殊病药品，未录入其对应特殊病的诊断: "+getMapName(diagmap)+System.lineSeparator());
						} else {
							OrdSrvDO srvdo = ordsrvMap.get(mmMap.get(specill.getId_mm()).getId_orsrv());
							srvdo.setFg_specill(FBoolean.TRUE);
							updSpecilSrvs.add(srvdo);
						}
					}
				}
			}
		}
		if (updSpecilSrvs.size() > 0) {
			CiOrdAppUtils.getICiorderSrvDOCudService()
					.update(updSpecilSrvs.toArray(new OrdSrvDO[updSpecilSrvs.size()]));
		}
		if (specilDrugs.size() > 0) {
			StringBuffer str =  new StringBuffer();
            for(Object info :specilDrugs){
            	str.append(info.toString());
            }
			return str.append("是否录入?").toString();
		} else {
			return null;
		}
	}
   
	
	/**
	 * 特殊病诊断集合
	 * @param diagmap 特殊病诊断集合
	 * @return
	 */
	private String getMapName(FMap2 diagmap) {
		StringBuffer sb = new StringBuffer();
		if (diagmap != null) {
			return "";
		}

		for (Object key : diagmap.keySet()) {
			sb.append("，" + key + " " + diagmap.get(key));
		}

		return sb.substring(1);
	}
	
	/**
	 * 执行签署数据更新
	 * 
	 * @param ciors
	 * @throws BizException
	 */
	private OrderRstDTO saveSignData(CiOrderDO[] ciors, FDateTime dt_cur) throws BizException {

		//更新医嘱状态为签署
		updateOrderStatus(ciors);

		//临床事件保存
		ciEventInfoSave(ciors);

		//创建门诊医嘱会话区间
		CiOrOpSessionInsertBP bpSession = new CiOrOpSessionInsertBP();
		CiOrSessionDO sessiondo = bpSession.exec(ciors, dt_cur);

		//签署时，按规则自动分方  仅门急诊使用  新接口 可配置第三方插件
		CiOrPresSplitHandleBP bpPresSplit = new CiOrPresSplitHandleBP();
		bpPresSplit.exec(ciors, sessiondo);

		//检验合单
		CiLisOrSmsHandlerBP bpLis = new CiLisOrSmsHandlerBP();
		bpLis.exec(ciors, sessiondo);

		//保存检查打印数据    仅门急诊使用
		CiprnSaveAppRisDataBP bpRis = new CiprnSaveAppRisDataBP();
		bpRis.exec(ciors, sessiondo);

		//保存病理打印数据   仅门急诊使用
		CiprnSaveAppPathgyDataBP bpPathgy = new CiprnSaveAppPathgyDataBP();
		bpPathgy.exec(ciors, sessiondo);

		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		//生成门诊费用清单打印数据
		if (context != null) {
			Ent4BannerDTO banner = context.getEnt4BannerDTO();
			if (banner != null
					&& (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || banner.getCode_entp()
							.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET))) {
				//生成保存门诊费用清单打印数据 
				String[] id_ors = new String[ciors.length];
				int i = 0;
				for (CiOrderDO ciorder : ciors) {
					id_ors[i] = ciorder.getId_or();
					i++;
				}
				CiOrdAppUtils.getICiprintExtService().SaveFeeBillsData(id_ors, banner.getId_hp(), banner.getSd_hptp());
				//签署未记账时发送IE签署事件 by yzh 2017-08-17 10:43:15
				CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);

				//高端商保记账
				//高端商保判断是每条医嘱的金额 不能超过限制的 金额
				if (banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")) {
					String id_psndoc = context.getPsnInfo().getId_psndoc();
					CiOrdAppUtils.getIBLOrderAppendBillService().SetOrderAppendBill_ByItms_ci_kljz_new(
							banner.getId_ent(), banner.getCode_entp(), CgTypeEnum.CG_HPCG, id_psndoc);
				}
			}
		}

		//		Runnable r = new OrderSignSaveDataRunnable(ciors, sessiondo, (CiEnContextDTO) Context.get().getAttribute(
		//				"CiEnContextDTO"));
		//		ExecutorUtil.startRunnable(r);

		OrderRstDTO dto = new OrderRstDTO();
		FMap2 scene = new FMap2();
		scene.put("ciors", CiOrdUtils.array2FArrayList(ciors));
		dto.setExtension(scene);
		dto.setIsSuccess(FBoolean.TRUE);

		//CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);
		return dto;
	}

	/**
	 * 更新医嘱签署状态
	 * 
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrderStatus(CiOrderDO[] orders) throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, CiOrderDO.FG_SIGN,
				CiOrderDO.DT_SIGN, CiOrderDO.ID_DEP_SIGN, CiOrderDO.ID_EMP_SIGN };
		FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		String id_dep = CiOrdAppUtils.getEnvContext().getDeptId();
		String id_emp = CiOrdUtils.getPsnDocID(CiOrdAppUtils.getEnvContext().getUserId());
		List<CiOrderDO> origindos = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			origindos.add(order);

			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
			order.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
			order.setFg_sign(new FBoolean(true));
			order.setDt_sign(dtNow);
			order.setId_dep_sign(id_dep);
			order.setId_emp_sign(id_emp);
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}

	/**
	 * 临床事件保存
	 * 
	 * @param ors
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void ciEventInfoSave(CiOrderDO[] orders) throws BizException {
		//有效性校验
		if (orders == null || orders.length == 0)
			return;
		//医嘱事件创建保存 时机应该选择为 签署阶段
		CiOrEventsSaveBP bp = new CiOrEventsSaveBP();
		bp.exec(orders);
	}
	
	/**
	 * 签署时医保验证 （选择自费开立时）
	 * @param id_orsrv
	 * @param aggors
	 */
	private void ValidataMedicalSharing(String id_orsrv,CiorderAggDO[] aggors)throws BizException{
		
		if(id_orsrv != null && aggors != null && aggors.length > 0 ){
		   List<OrdSrvDO> list = new ArrayList();
			for(CiorderAggDO orderDO: aggors){
				for(OrdSrvDO srvdo:orderDO.getOrdSrvDO()){
					if(id_orsrv.contains(srvdo.getId_orsrv())){
						srvdo.setFg_selfpay(FBoolean.TRUE);
						srvdo.setStatus(DOStatus.UPDATED);
						list.add(srvdo);
					}
				}
			}
			if(list != null && list.size() >0){
				IOrdSrvDOCudService iordSrvDOCudService = CiOrdAppUtils.getOrSrvService();
				iordSrvDOCudService.save(list.toArray(new OrdSrvDO[list.size()]));	
			}
			
		}
	}
}

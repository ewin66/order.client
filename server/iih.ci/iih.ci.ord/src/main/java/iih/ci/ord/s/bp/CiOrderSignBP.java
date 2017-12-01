package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.fabric.xmlrpc.base.Array;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.d.CijudgeSpecillDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.validate.OrDoctorCheckValidateBP;
import iih.ci.ord.s.bp.validate.OrMutexValidateBP;
import iih.ci.ord.s.bp.validate.OrSrvDoctorRtValidateBP;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/*
 * 临床医嘱的签署操作BP
 */
public class CiOrderSignBP {

	// 诊断服务接口
	private ICidiagQryService icidiagQryService;

	public CiOrderSignBP() {
		icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);
	}

	/**
	 * 临床医嘱的签署（Step0）
	 * 
	 * 阶段0 返回互斥医嘱及相关停止医嘱数据信息(数据类型：ReactExOrsAndStopOrsDO   key="willstopors"）
	 * 阶段#
	 * 阶段99 为校验检查通过  返回签署成功的医嘱及互斥停止的医嘱信息（数据类型：FArrayList<CiOrderDO> key="ciors"）
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public ValidateRtnInfoDTO exec(String[] id_ors,CiEnContextDTO ciEnContextDTO) throws BizException{

		String Code_entp = ciEnContextDTO.getCode_entp();

		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;

		//获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(id_ors, FBoolean.FALSE);
		if(aggors==null || aggors.length==0){
			throw new BizException("医嘱信息已经发生变化，请刷新列表");
		}
		CiOrderDO[] ciors=getCiOrderDOs(aggors);

		//医嘱保存校验  其内部逻辑待完善
		CiOrdersSaveInvalidateBP validate4save=new CiOrdersSaveInvalidateBP();
		validate4save.exec(aggors);

		//如果医嘱是医保类医嘱或临床路径待判断的医嘱，判断医生是否已经判断过。如果存在医生未判断，则将数据传送到前台，让医生判断
		OrDoctorCheckValidateBP docvalidate = new OrDoctorCheckValidateBP();
		FArrayList willCheckIdOrs = docvalidate.exec(aggors);
		if(!CiOrdUtils.isEmpty(willCheckIdOrs)){
			ValidateRtnInfoDTO dto=new ValidateRtnInfoDTO();
			FMap2 scene=new FMap2();
			scene.put("willCheckIdOrs", willCheckIdOrs);
			dto.setScenedatum(scene);
			return dto;
		}

		//用血医嘱可用血余量的校验
		UseBtOrNumMarginBuValidateBP usebt = new UseBtOrNumMarginBuValidateBP();
		usebt.exe(aggors);

		// 执行科室校验逻辑  待完成
//		ExDeptValidateBP bpdept=new ExDeptValidateBP();
//		bpdept.exec();

		//药品库存检查    待完成
//		MmInvValidateBP bpinv=new MmInvValidateBP();
//		bpinv.exec();

		//医嘱服务开立权限判断逻辑
		FMap2 orsrvrtchk = orSrvRtCtlChkHandle(aggors);
		if (orsrvrtchk != null && orsrvrtchk.size() > 0) {
			ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();
			dto.setScenedatum(orsrvrtchk);
			return dto;
		}

		//进行互斥检查校验  仅对住院流程起作用
		FDateTime dt_cur=CiOrdAppUtils.getServerDateTime();
		FArrayList fa=new FArrayList();
		fa.add(dt_cur);
		//被排斥医嘱的停止时间应为全排医嘱的开立时间
		OrMutexValidateBP bp=new OrMutexValidateBP();
		ReactExtOrsAndStopOrsDO willstopors=bp.exec(aggors,fa);
		dt_cur=(FDateTime) fa.get(0);
		FArrayList checkPatInfoSrvs = new FArrayList();
		//住院不进行毒麻信息的核对,其他就诊类型进行毒麻药患者信息的核对
		if(!ciEnContextDTO.getCode_entp().equals(IEnDictCodeConst.SD_ENTP_INPATIENT)){
		//药品毒麻信息审核
			checkPatInfoSrvs = srvPoisInfoCheck(aggors);
		}
		//特殊病判断
		String specilInfo = judgeSpecillFlag(aggors,ciEnContextDTO);
		//有要停止的医嘱时的处理逻辑
		if((!CiOrdUtils.isEmpty(willstopors) && !CiOrdUtils.isEmpty(willstopors.getStopordos()))||checkPatInfoSrvs.size()>0||!CiOrdUtils.isEmpty(specilInfo)){
			//插入   用户干预点   //用户确认后继续
			ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();
			orReactStopOrPromptRtnHandle(dto,ciors,willstopors,dt_cur);
			if(checkPatInfoSrvs.size()>0){
				dto.getScenedatum().put("checkPatInfoSrvs", checkPatInfoSrvs);
			}
			if(!CiOrdUtils.isEmpty(specilInfo)){
				dto.getScenedatum().put("specilDrugs", specilInfo+"是特殊病药品，未录入其对应特殊病的诊断，是否录入?");
			}
			return dto;
		}

		//TODO 签署逻辑需要调整，将校验调整与处理分开，最终调用同一个签署方法
		//本次就诊为医保就诊时，判断是否存在保外诊断，如果存在保外诊断更新医嘱中的保外诊断属性
		if(CiOrdUtils.isHpUsing(ciEnContextDTO)){
			
			List<String> idSrvList = new ArrayList<String>();
			for(CiorderAggDO ciorderAgg : aggors){
				CiOrderDO ciOrder = ciorderAgg.getParentDO();
				if(ICiDictCodeConst.SD_SU_OPEN.equals( ciOrder.getSd_su_or())){

					String sdSrvtp = ciOrder.getSd_srvtp();
					
					// 药品，非溶媒 时校验是否重复开药
					if(sdSrvtp.startsWith(IBdSrvTpDictCodeConst.SD_SRVTP_DRUG) && !IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG_DSY.equals(sdSrvtp)){
					
						OrdSrvDO[] OrdSrvs = ciorderAgg.getOrdSrvDO();
						for(OrdSrvDO ordSrv : OrdSrvs){
							if(idSrvList.contains(ordSrv.getId_srv())){
								throw new BizRuntimeException("医保患者签署处置时存在重复药品["+ordSrv.getName()+"]！");
							}
							// 医保只需要 非自费物品
							if(ordSrv.getFg_mm() == FBoolean.TRUE && ordSrv.getFg_selfpay() == FBoolean.FALSE){
								idSrvList.add(ordSrv.getId_srv());
							}
						}
					}			
				}
			}

			// 查询保外诊断
			CiDiagItemDO[] ciDiagItems = icidiagQryService.getHpjudgetpCiDiagItems(ciEnContextDTO.getId_en());

			if (ciDiagItems != null && ciDiagItems.length > 0) {

				CiEnContextUtil.SetHpCiDiagItem(ciEnContextDTO, ciDiagItems);
				for (CiOrderDO ciOrderDO : ciors) {

					ciOrderDO.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);// 医保适应症判断标识枚举
					ciOrderDO.setBhpjudgerst(ciEnContextDTO.getBhpjudgerst()); // 基本医保判断结果数据信息
					ciOrderDO.setDes_bhpjudgerst(ciEnContextDTO.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述，保外诊断id串
				}

				CiOrderUpdateHpCiDiBP ciOrderUpdateHpCiDiBP = new CiOrderUpdateHpCiDiBP(ciEnContextDTO);
				ciOrderUpdateHpCiDiBP.execUpdateOrdSrvs(id_ors);
			}
		}
		//临床医嘱的签署（Step1）
		//更新医嘱状态、被排斥医嘱停止、创建临床事件 门诊创建会话期间、门诊处方分方
		CiOrderSignStep1aBP bp1a=new CiOrderSignStep1aBP();
		return bp1a.exec(ciors, willstopors, dt_cur,Code_entp);
	}


	/**
	 * 医保签署时 提示医保信息
	 * @param map
	 * @param Code_entp
	 * @return
	 * @throws BizException
	 */
	public ValidateRtnInfoDTO  CiorderSignMedicalInsurance(FMap2 map, String Code_entp)throws BizException{
		FArrayList  aggList = (FArrayList)map.get("aggors");
		CiorderAggDO[] aggors = (CiorderAggDO[])CiOrdUtils.FArrayLiatToBaseDOArray(aggList);
		CiOrderDO[] ciors=getCiOrderDOs(aggors);

		ValidateRtnInfoDTO dto=new ValidateRtnInfoDTO();
		//用血医嘱可用血余量的校验
		UseBtOrNumMarginBuValidateBP usebt = new UseBtOrNumMarginBuValidateBP();
		usebt.exe(aggors);



		// 执行科室校验逻辑  待完成
//		ExDeptValidateBP bpdept=new ExDeptValidateBP();
//		bpdept.exec();

		//药品库存检查    待完成
//		MmInvValidateBP bpinv=new MmInvValidateBP();
//		bpinv.exec();

		//医嘱服务开立权限判断逻辑
		FMap2 orsrvrtchk=orSrvRtCtlChkHandle(aggors);
		if(orsrvrtchk!=null && orsrvrtchk.size()>0){
			dto.setScenedatum(orsrvrtchk);
			return dto;
		}

		//进行互斥检查校验  仅对住院流程起作用
		//li_cheng 修改
		FDateTime dt_cur=CiOrdAppUtils.getServerDateTime();
		FArrayList fa=new FArrayList();
		fa.add(dt_cur);
		OrMutexValidateBP bp=new OrMutexValidateBP();
		//被排斥医嘱的停止时间应为全排医嘱的开立时间 li_cheng 修改
		ReactExtOrsAndStopOrsDO willstopors=bp.exec(aggors,fa);
		dt_cur=(FDateTime) fa.get(0);
		//有要停止的医嘱时的处理逻辑
		if(!CiOrdUtils.isEmpty(willstopors) && !CiOrdUtils.isEmpty(willstopors.getStopordos())){
			//插入   用户干预点   //用户确认后继续
			orReactStopOrPromptRtnHandle(dto,ciors,willstopors,dt_cur);
			return dto;
		}

		//临床医嘱的签署（Step1）
		//更新医嘱状态、被排斥医嘱停止、创建临床事件 门诊创建会话期间、门诊处方分方
		CiOrderSignStep1aBP bp1a=new CiOrderSignStep1aBP();
		return bp1a.exec(ciors, willstopors, dt_cur,Code_entp);
	}

	
	/**
	 * 获得医嘱主DO数组
	 * @param aggors
	 * @return
	 */
	private CiOrderDO[] getCiOrderDOs(CiorderAggDO[] aggors){
		
		List<CiOrderDO> ciOrderList = new ArrayList<CiOrderDO>();
		for(int i=0;i<aggors.length;i++){
			CiOrderDO ciOrder = aggors[i].getParentDO();
			if(ICiDictCodeConst.SD_SU_OPEN.equals( ciOrder.getSd_su_or())){
				ciOrderList.add(ciOrder);
			}
		}
		if(ciOrderList.size() != aggors.length ){
			throw new BizRuntimeException("数据状态发生改变，请勿重复签署！");
		}
		return  ciOrderList.toArray(new CiOrderDO[ciOrderList.size()]);
	}
	
	/**
	 * 医嘱签署权限检查处理
	 * @param aggors
	 * @throws BizException
	 */
	private FMap2 orSrvRtCtlChkHandle(CiorderAggDO[] aggors) throws BizException{
		OrSrvDoctorRtValidateBP bp=new OrSrvDoctorRtValidateBP();
		return bp.exec(aggors);

	}
	
	/**
	 * 
	 * @param aggors
	 * @return
	 */
	private FArrayList srvPoisInfoCheck(CiorderAggDO[] aggors){
		FArrayList idorsrvs = new FArrayList();
		FArrayList ordsrvPois = new FArrayList();
		FMap orsrvMap = new FMap();
		for(CiorderAggDO agg : aggors){
			OrdSrvDO[] ordSrvdos = agg.getOrdSrvDO();
			for(OrdSrvDO srvdo : ordSrvdos){
				idorsrvs.add(srvdo.getId_orsrv());
				orsrvMap.put(srvdo.getId_orsrv(), srvdo);
			}
		}
		try {
			OrdSrvMmDO[] srvmms = CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList("Id_orsrv", idorsrvs);
			idorsrvs.clear();
			if(srvmms==null) return ordsrvPois;
			for(OrdSrvMmDO srvmm : srvmms){
				if(CiOrdUtils.isEmpty(srvmm.getSd_pois())) continue;
				if(CiOrdUtils.isNeedCheckPatInfo(srvmm.getSd_pois()).booleanValue()){
					idorsrvs.add(srvmm.getId_orsrv());
				}
			}
			if(idorsrvs.size()>0){
				OrSrvAgentInfoDO[] orsrvAgentInfoDOs = CiOrdAppUtils.getCiorsrvagentRService().findByAttrValList("Id_orsrv", idorsrvs);
				if(!CiOrdUtils.isEmpty(orsrvAgentInfoDOs)){
					for(OrSrvAgentInfoDO srvagent : orsrvAgentInfoDOs){
						idorsrvs.remove(srvagent.getId_orsrv());
					}
				}

				if(idorsrvs.size()>0){
					for(Object id_orsrv : idorsrvs){
						ordsrvPois.add(orsrvMap.get(id_orsrv.toString()));
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
	 * @param aggs
	 * @param ctx
	 * @return
	 * @throws BizException 
	 */
	private String judgeSpecillFlag(CiorderAggDO[] aggs,CiEnContextDTO ctx) throws BizException{

		Ent4BannerDTO banner = ctx.getEnt4BannerDTO();
		//return "西药，中药";
		//非医保或患者非特病返回false
		if(CiOrdUtils.isEmpty(banner.getId_hp())||banner.getFg_hpspcl()==null||!banner.getFg_hpspcl().booleanValue()) return null;
		FArrayList idOrsrvs = new FArrayList();
		Map<String,OrdSrvDO> ordsrvMap = new HashMap<String,OrdSrvDO>();
		for(CiorderAggDO agg : aggs){
			OrdSrvDO[] ordsrvs = agg.getOrdSrvDO();
			for(OrdSrvDO srv :ordsrvs){
				if(srv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)){
					idOrsrvs.add(srv.getId_orsrv());
					ordsrvMap.put(srv.getId_orsrv(), srv);
				}
			}
		}
		
		if(idOrsrvs.size()==0) return null;
		OrdSrvMmDO[] srvmmdos=CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList("Id_orsrv", idOrsrvs);
		List<String> idMMs = new ArrayList<String>();
		Map<String,OrdSrvMmDO> mmMap = new HashMap<String,OrdSrvMmDO>();
		if(!CiOrdUtils.isEmpty(srvmmdos)){
			for(OrdSrvMmDO srvmm : srvmmdos){
				if(!CiOrdUtils.isEmpty(srvmm.getId_mm())){
					if(!idMMs.contains(srvmm.getId_mm())){
						idMMs.add(srvmm.getId_mm());
						mmMap.put(srvmm.getId_mm(), srvmm);
					}
				}
			} 
		}else{
			return null;
		}
		
		List<OrdSrvDO> updSpecilSrvs = new ArrayList<OrdSrvDO>();
		FArrayList2 specilDrugs = new FArrayList2();
		IBLCancelSettlement blservice = CiOrdAppUtils.getIBLCancelSettlement();
		List<CijudgeSpecillDTO> specils = blservice.JudgeSpecillFlag(banner.getNo_hp(), banner.getId_hp(),idMMs.toArray(new String[idMMs.size()]));
		if(!CiOrdUtils.isEmpty(specils)&&specils.size()>0){
			ICiOrdQryService ciordqryservice = CiOrdAppUtils.getCiOrdQryService();
			EntDiDO[] entdis = ciordqryservice.getEntDiDOList(banner.getId_ent());
			for(CijudgeSpecillDTO specill : specils){
				FMap2  diagmap = specill.getDiagmap();
				if(!CiOrdUtils.isEmpty(specill.getFg_mmspecill())&&specill.getFg_mmspecill().booleanValue()&&!CiOrdUtils.isEmpty(diagmap)){
					if(!CiOrdUtils.isEmpty(entdis)){
						boolean flag = true;
						for(EntDiDO entdi : entdis){
							String code_di = entdi.getCode_didef_dis();
							if(diagmap.containsKey(code_di)){
								flag =  false;
								break;
							}
						}
						if(flag){
							specilDrugs.add(mmMap.get(specill.getId_mm()).getName_mm());
						}else{
							OrdSrvDO srvdo = ordsrvMap.get(mmMap.get(specill.getId_mm()).getId_orsrv());
							srvdo.setFg_specill(FBoolean.TRUE);
							updSpecilSrvs.add(srvdo);
						}
					}
				}
			}
		}
		if(updSpecilSrvs.size()>0){
			CiOrdAppUtils.getICiorderSrvDOCudService().update(updSpecilSrvs.toArray(new OrdSrvDO[updSpecilSrvs.size()]));
		}
		if(specilDrugs.size()>0){
			return specilDrugs.toString(); 
		} 
		else{
			return null;
		}
	}

	/**
	 * 医嘱互斥停止相关医嘱执行时，设置返回值数据信息
	 * @param dto
	 * @param ors
	 * @param willstopors
	 * @param dt_cur
	 */
	private ValidateRtnInfoDTO orReactStopOrPromptRtnHandle(ValidateRtnInfoDTO dto,CiOrderDO[] ciors,ReactExtOrsAndStopOrsDO willstopors,FDateTime dt_cur){
		dto.setPhaseno(0);  //阶段0
		FMap2 scene=new FMap2();
		scene.put("dt_cur", dt_cur);
		scene.put("ciors", CiOrdUtils.array2FArrayList(ciors));
		dto.setScenedatum(scene);
		FMap2 rtnvalue=new FMap2();
		rtnvalue.put("willstopors", willstopors);
		dto.setRtnvalue(rtnvalue);
		dto.setFg_rtnscene(FBoolean.TRUE);
		return dto;
	}
}

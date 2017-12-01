package iih.ci.ord.s.ems.biz.op.emsv1.drugs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import iih.bd.srv.routedosage.i.IRoutedosageRService;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;
import iih.pi.overview.overview.d.PiPatDO;

/**
 * 药品医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class EmsDrugsValidate extends EmsBaseValidate {

	public FArrayList viewModelValidate(Object objEms,CiEnContextDTO ctx) throws BizException {
		FArrayList objs = (FArrayList) objEms;
		EmsDrugItemDO emsdrugs=(EmsDrugItemDO)objs.get(0);
		FArrayList emssrvlist=emsdrugs.getEmsOrDrugEx();
		if(emsdrugs==null||emssrvlist==null)return null;
		List<String> errorList=new ArrayList<String>();
		// 检查成组药品
		//		checkCombDurgInfo(emsDTO,errorList);
		List<String> depMps=new ArrayList<String>();//执行科室
		List<String> dosageMps=new ArrayList<String>();//用法
		for(Object obj : emssrvlist){
			EmsOrDrug emsDTO = (EmsOrDrug)obj;	
			depMps.add(emsDTO.getId_mp_dep());
			dosageMps.add(emsDTO.getId_dosage());
			// 空药品
			checkEmptyDrugInfo(emsDTO,errorList);
			//皮试医嘱判断逻辑
			checkSrvSkinLogic(emsDTO,errorList,ctx.getId_org(),ctx.getId_pat());
			// 频次信息检查
			checkSrvFreqInfo(emsDTO,errorList);
			// 用法信息检查
			checkSrvRouteInfo(emsDTO, errorList);
			// 用药天数必须大于0
			checkUseDayInfo(emsDTO,errorList);
			//药品的单价不能为空
			checkPriceInfo(emsDTO,errorList);

		}

		// 药品重复检查
		checkSameDrugInfo(emssrvlist,errorList);
		// 剂|总量必须大于0
		checkDrugQuanInfo(emssrvlist,errorList);
		//在院执行为true时，在院执行次数必须大于0
		checkMpInHospital(emsdrugs,errorList);
		//药品执行科室必须一致
		checkDepMpInfo(depMps,errorList);
		//校验每个服务的药品用法是否在剂型关联的用法集合里
		checkDosageRouteInfo(dosageMps,errorList,emssrvlist);
		//药品库存的判断
		checkMmStockInfo(emssrvlist,errorList);
		FArrayList errlist=new FArrayList();
		errlist.addAll(errorList);
		return errlist;
	}

	public FArrayList beforeSaveValidate(Object objEms) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}	


	/**
	 * 皮试校验
	 * @param emssrv
	 * @param errorList
	 * @param id_pat
	 * @param id_org
	 * @throws BizException
	 */
	private void checkSrvSkinLogic(EmsOrDrug emssrv,List<String> errorList,String id_pat,String id_org) throws BizException {
		if(!FBoolean.TRUE.equals(emssrv.getFg_skintest())) return;
		SkinTestParamDTO param = new SkinTestParamDTO();
		param.setId_mm(emssrv.getId_mm());
		param.setId_org(id_org); 
		param.setId_pi(id_pat);
		PiPatDO piPatDO = CiOrdAppUtils.getOverviewMDORService().findById(id_pat);
		if(piPatDO!=null)param.setDt_birth(piPatDO.getDt_birth());
		param.setId_srv(emssrv.getId_srv());
		param.setId_skinsrv(emssrv.getId_srvskin());
		SkinTestRstDTO retDTO = CiOrdAppUtils.getCiOrdQryService().skinTestLogicMainBP(param);
		String code = String.valueOf(retDTO.getAllergicpharmhandlemode());
		//禁用
		if (code.equals("0"))
		{
			new BizException("患者于" + retDTO.getDt_act() + "对" + emssrv.getName_mm() + "过敏！");
		}//再皮试1;皮试逻辑，3
		else if (code.equals("1") || code.equals("3"))
		{
			emssrv.setSd_reltp(ICiDictCodeConst.CODE_SKIN_SKIN);
			emssrv.setFg_skintest(FBoolean.TRUE);
		}//强制使用2
		else if (code.equals("2"))
		{
			//强制使用需要医生填写强制使用原因，要抛到前台去
			errorList.add("强制使用需要医生填写强制使用原因，要抛到前台去");
			//emssrv.setSd_reltp(ICiDictCodeConst.CODE_SKIN_FORCEUSE);
			//emssrv.setFg_skintest(FBoolean.FALSE);
		}//直接使用，不皮试4
		else if (code.equals("4"))
		{
			emssrv.setSd_reltp(ICiDictCodeConst.CODE_SKIN_FORCEUSE);
			emssrv.setFg_skintest(FBoolean.FALSE);
		}//测试了，未出结果5
		else if (code.equals("5"))
		{
			emssrv.setSd_reltp(ICiDictCodeConst.CODE_SKIN_NORESULT);
			emssrv.setFg_skintest(FBoolean.TRUE);
			emssrv.setId_or_rel(retDTO.getId_skinor());
		}

	}

	/**
	 * 服务频次检查
	 * @param emsDTO
	 * @param errors
	 */
	private void checkSrvFreqInfo(EmsOrDrug emsDTO,List<String> errors){
		if (StringUtil.isEmpty(emsDTO.getId_freq()) ||
				StringUtil.isEmpty(emsDTO.getName_freq())||
				StringUtil.isEmpty(emsDTO.getSd_frequnitct())){
			errors.add("频次信息不完整");
		}
	}

	/**
	 * 服务用法校验
	 * @param srvList
	 * @param errors
	 */
	private void checkSrvRouteInfo(EmsOrDrug emsDTO,List<String> errors){
		if (StringUtil.isEmpty(emsDTO.getId_route()) ||
				StringUtil.isEmpty(emsDTO.getName_route())){
			errors.add("途径信息不完整");
		}
	}

	/**
	 * 相同药品检查
	 * @param srvList
	 * @param errors
	 */
	private void checkSameDrugInfo(FArrayList srvList,List<String> errors){
		Map<String,Object> filterMap = new HashMap<String,Object>();
		for(Object obj : srvList){
			EmsOrDrug srvItem = (EmsOrDrug)obj;
			if (FBoolean.TRUE.equals(srvItem.getFg_or())){
				if (filterMap.containsKey(srvItem.getId_mm())){
					errors.add(String.format("%s([%s]) 已经存在", srvItem.getName_mm(),srvItem.getId_mm()));
				}
				else{
					filterMap.put(srvItem.getId_mm(), srvItem);
				}
			}
		}

	}

	

	

	/**
	 * 用药医嘱天数检查
	 * @param emsDTO
	 * @param errors
	 */
	private void checkUseDayInfo(EmsOrDrug emsDTO,List<String> errors){
		if (emsDTO.getUse_days()==null && emsDTO.getUse_days().intValue()<= 0){
			errors.add(String.format("%s([%s]) 使用天数必须大于0", emsDTO.getName_srv(),emsDTO.getId_srv()));
		}

	}

	/**
	 * 药品执行科室校验
	 * @param srvList
	 * @param errors
	 */
	private void checkDepMpInfo(List<String> depMps,List<String> errors){
		if(depMps.size()>1)
			errors.add("药品的执行科室不一致，不能保存！");
	}
	/**
	 * 在院执行校验
	 * @param emsDTO
	 * @param errors
	 */
	private void checkMpInHospital(EmsDrugItemDO emsdrugs,List<String> errors){
		if(FBoolean.TRUE.equals(emsdrugs.getFg_mp_in()) && (emsdrugs.getTimes_mp_in() == null || emsdrugs.getTimes_mp_in() <= 0)){
			errors.add("在院执行时，在院执行次数必须大于0！");
		}
	}
	/**
	 * 单价校验
	 * @param srvList
	 * @param errors
	 */
	private void checkPriceInfo(EmsOrDrug emsDTO,List<String> errors){
		if(emsDTO.getPrice()==null){
			errors.add(String.format("药品%s的价格为空", emsDTO.getName_srv()));
		}
	}
	/**
	 * 用法与剂型校验
	 * @param dosageIds
	 * @param errors
	 * @param srvList
	 * @throws BizException
	 */
	private void checkDosageRouteInfo(List<String> dosageIds,List<String> errors,FArrayList srvList) throws BizException{
		StringBuilder ids=new StringBuilder();
		for(String id_dosage : dosageIds){
			ids.append(String.format("'%s',", id_dosage));
		}
		IRoutedosageRService service = ServiceFinder.find(IRoutedosageRService.class);
		RouteDosageRefDO[] routeDosages=service.find(String.format("id_dosage in (%s)", ids.substring(0, ids.lastIndexOf(","))), "", FBoolean.FALSE);
		for(Object obj:srvList){
			EmsOrDrug emsDTO = (EmsOrDrug)obj;
			List<RouteDosageRefDO> refsDo=new ArrayList<RouteDosageRefDO>();
			for(RouteDosageRefDO refdo:routeDosages){
				if(refdo.getId_dosage().equals(emsDTO.getId_dosage()) && refdo.getId_route().equals(emsDTO.getId_route())){
					refsDo.add(refdo);
				}
			}
			if (refsDo.size() == 0)
			{
				errors.add(String.format("%s药品剂型与用法不匹配", emsDTO.getName_srv()));
			}
		}
	}


	
}

package iih.ci.ord.s.ems.biz.op.emsv1.herbs;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;

/**
 * 草药医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class EmsHerbsValidate extends EmsBaseValidate {
	public FArrayList viewModelValidate(Object objEms,CiEnContextDTO ctx) throws BizException {
		EmsDrugItemDO emsdrugs=(EmsDrugItemDO)objEms;
		FArrayList emssrvlist=emsdrugs.getEmsOrDrugEx();
		if(emsdrugs==null)return null;
		List<String> errorList=new ArrayList<String>();
		for(Object obj : emssrvlist){
			EmsOrDrug emsDTO = (EmsOrDrug)obj;	
			if(emsDTO.getId_mp_dep()==null){
				errorList.add(String.format("%s执行科室为空!", emsDTO.getName_srv()));
			}
			// 空药品
			checkEmptyDrugInfo(emsDTO,errorList);

		}
		//草药付数
		checkOrdersInfo(emsdrugs,errorList);
		// 采用剂型信息检查
		checkBoilInfo(emsdrugs,errorList);
		// 频次信息检查
		checkFreqInfo(emsdrugs,errorList);
		// 用法信息检查
		checkRouteInfo(emsdrugs,errorList);
		// 剂|总量必须大于0
		checkDrugQuanInfo(emssrvlist,errorList);

		// 住院时停止时间为空
		if(CiOrdUtils.isIpWf(ctx.getCode_entp())){
			if(emsdrugs.getDt_end_ui() == null){
				errorList.add(String.format("%s([%s]) 结束日期不能为空", emsdrugs.getName_srv(),emsdrugs.getId_srv()));
			}
		}
		//药品库存的判断
		checkMmStockInfo(emssrvlist,errorList);
		FArrayList errlist=new FArrayList();
		errlist.addAll(errlist);
		return errlist;
	}

	public FArrayList beforeSaveValidate(Object objEms) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}	
	/**
	 * 草药煎法不能为空
	 * @param ems
	 * @param errorList
	 */
	protected void checkBoilInfo(EmsDrugItemDO ems, List<String>errorList){
		if (StringUtil.isEmpty(ems.getId_boil())){
			errorList.add(ems.getName_srv()+" 草药煎法不能为空");
		}
	}
	/**
	 * 频次不能为空
	 * @param ems
	 * @param errorList
	 */
	protected void checkFreqInfo(EmsDrugItemDO ems, List<String>errorList){
		if (StringUtil.isEmpty(ems.getId_freq())){
			errorList.add(ems.getName_srv()+" 频次不能为空");
		}
	}
	/**
	 * 用法不能为空
	 * @param ems
	 * @param errorList
	 */
	protected void checkRouteInfo(EmsDrugItemDO ems, List<String>errorList){
		if (StringUtil.isEmpty(ems.getId_route())){
			errorList.add(ems.getName_srv()+" 草药用药方法不能为空");
		}
	}
	/**
	 * 草药的付数不能为空
	 * @param ems
	 * @param errorList
	 */
	protected void checkOrdersInfo(EmsDrugItemDO ems, List<String>errorList){
		if (ems.getOrders() <= 0){
			errorList.add(ems.getName_srv()+" 草药付数不正确");
		}
	}

}

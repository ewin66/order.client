package iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.herbs;

import java.util.List;

import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.tmpl.base.herbs.TmplBaseHerbsValidate;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;

/**
 * 草药医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class TmplHerbsValidate extends TmplBaseHerbsValidate {
	public ErrorEmsList viewModelValidate(Object objEms,CiEnContextDTO ctx) throws BizException {
		return null;
	}

	public ErrorEmsList beforeSaveValidate(Object objEms) throws BizException {
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

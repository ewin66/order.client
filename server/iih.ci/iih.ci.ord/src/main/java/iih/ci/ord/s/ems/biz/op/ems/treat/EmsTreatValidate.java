package iih.ci.ord.s.ems.biz.op.ems.treat;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.d.ems.tmpl.ErrorEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;

/**
 * 治疗医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class EmsTreatValidate extends EmsBaseValidate {
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms,CiEnContextDTO ctx) throws BizException  {
	
		ErrorEmsList eeList = new ErrorEmsList();
		for (Object objItem : objEms){
			EmsDrugItemDO itemDO = (EmsDrugItemDO)objItem;
			EmsOrDrug emsDTO=(EmsOrDrug)itemDO.getEmsOrDrugListEx().get(0);
			List<String> errorlist=new ArrayList<String>();
			if(StringUtil.isEmpty(emsDTO.getId_mp_dep())){
				errorlist.add(String.format("%s执行科室为空！", emsDTO.getName_srv()));
			}
			if(emsDTO.getQuan_med()==null || emsDTO.getQuan_med().toDouble()<=0){
				errorlist.add(String.format("%s剂量必须大于0！", emsDTO.getName_srv()));
			}
	/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
			if(errorlist.size() > 0){
				eeList.add(new ErrorEmsDTO(ctx,objItem,errorlist));
			}
	/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		}
		return eeList;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		return null;
	}

}

package iih.ci.ord.s.ems.biz.op.emsv1.treat;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;

/**
 * 治疗医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class EmsTreatValidate extends EmsBaseValidate {
	public FArrayList viewModelValidate(Object objEms,CiEnContextDTO ctx) throws BizException  {
		FArrayList errorlist=new FArrayList();
		FArrayList objEmsList = (FArrayList)objEms;
		for (Object objItem : objEmsList){
			EmsDrugItemDO itemDO = (EmsDrugItemDO)objItem;
			EmsOrDrug emsDTO=(EmsOrDrug)itemDO.getEmsOrDrugListEx().get(0);
			
			if(StringUtil.isEmpty(emsDTO.getId_mp_dep())){
				errorlist.add(String.format("%s执行科室为空！", emsDTO.getName_srv()));
			}
			if(emsDTO.getQuan_med()==null || emsDTO.getQuan_med().toDouble()<=0){
				errorlist.add(String.format("%s剂量必须大于0！", emsDTO.getName_srv()));
			}
		}
		return errorlist;
	}

	public FArrayList beforeSaveValidate(Object objEms) throws BizException {
		return null;
	}

}

package iih.ci.ord.s.ems.biz.op.emsv1.ris;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;

/**
 * 检查医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class EmsRisValidate extends EmsBaseValidate {

	public ErrorEmsList viewModelValidate(Object objEms,CiEnContextDTO ctx) throws BizException  {
		FArrayList listModel = (FArrayList)objEms;
		FArrayList errorlist=new FArrayList();
		for(Object objModel : listModel){
			EmsObsItemDO lisdo=(EmsObsItemDO)objModel;
			FArrayList emssrvlist=lisdo.getEmsOrDrugListEx();
			if(lisdo==null)return null;
			
			if(emssrvlist.size()>0){
				EmsOrDrug emsDTO = (EmsOrDrug)emssrvlist.get(0);
				if(StringUtil.isEmpty(emsDTO.getId_pps())){
					errorlist.add(String.format("%s检查目的为空！", lisdo.getName_srv()));
				}
				if(StringUtil.isEmpty(emsDTO.getId_di())){
					errorlist.add(String.format("%s临床诊断为空！", lisdo.getName_srv()));
				}
				if(emsDTO.getDt_plan()==null){
					errorlist.add(String.format("%s计划检查时间为空！", lisdo.getName_srv()));
				}
				if(StringUtil.isEmpty(emsDTO.getId_mp_dep())){
					errorlist.add(String.format("%s执行科室为空！", emsDTO.getName_srv()));
				}
			}
		}
		return new ErrorEmsList().fromFArrayList( errorlist);
	}

	public ErrorEmsList beforeSaveValidate(Object objEms) throws BizException {
		return null;
	}
}

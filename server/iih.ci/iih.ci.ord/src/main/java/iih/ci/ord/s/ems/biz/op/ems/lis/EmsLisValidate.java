package iih.ci.ord.s.ems.biz.op.ems.lis;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.d.ems.tmpl.ErrorEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;

/**
 * 检验医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class EmsLisValidate extends EmsBaseValidate {
	
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms,CiEnContextDTO ctx) throws BizException {
		ErrorEmsList eeList = new ErrorEmsList();
		for(Object objModel : objEms){
			EmsObsItemDO lisdo=(EmsObsItemDO)objModel;
		FArrayList emssrvlist=lisdo.getEmsOrObsListEx();
			List<String> errorlist = new ArrayList<String>();
		if(emssrvlist.size()>0){
				
				if(StringUtil.isEmpty(lisdo.getId_samptp())){
					errorlist.add(String.format("%s标本类型为空！", lisdo.getName_srv()));
			}
				if(StringUtil.isEmpty(lisdo.getId_mp_dep())){
					errorlist.add(String.format("%s执行科室为空！", lisdo.getName_srv()));
			}
		}
		if(StringUtil.isEmpty(lisdo.getId_di())){
			errorlist.add(String.format("%s临床诊断为空！", lisdo.getName_srv()));
		}
		if(lisdo.getDt_plan()==null){
			errorlist.add(String.format("%s计划检验时间为空！", lisdo.getName_srv()));
		}
			if (errorlist.size() > 0){
				eeList.add(new ErrorEmsDTO(ctx,objModel,errorlist));
			}
		}
		return eeList;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

}

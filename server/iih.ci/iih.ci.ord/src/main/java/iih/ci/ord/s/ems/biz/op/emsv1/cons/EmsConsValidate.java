package iih.ci.ord.s.ems.biz.op.emsv1.cons;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import iih.ci.ord.ciordems.d.EmsConsItemDO;
import iih.ci.ord.ciordems.d.EmsItemInCons;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;

/**
 * 会诊医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class EmsConsValidate extends EmsBaseValidate {

	public FArrayList viewModelValidate(Object objEms,CiEnContextDTO ctx) throws BizException  {
		FArrayList errorlist=new FArrayList();
		FArrayList objEmsList = (FArrayList)objEms;
		for (Object objItem : objEmsList){
			EmsConsItemDO consdo=(EmsConsItemDO)objItem;
			if(consdo==null)return null;
			FArrayList consitems=consdo.getConsAssList();
			
			if(consitems!=null &&consitems.size()>0){
				boolean flag=false;

				for(Object obj:consitems){
					EmsItemInCons conitem=(EmsItemInCons)obj;
						if(("").equals(conitem.getId_dep_emp()) || conitem.getId_dep_emp().equals(null))flag=true;
					
				}
				if(flag)errorlist.add(String.format("%s缺少受邀科室！", consdo.getName_srv()));

			}else{
				errorlist.add(String.format("%s缺少受邀方信息！", consdo.getName_srv()));
			}
		}
		return errorlist;
	}

	public FArrayList beforeSaveValidate(Object objEms) throws BizException {
		return null;
	}
}

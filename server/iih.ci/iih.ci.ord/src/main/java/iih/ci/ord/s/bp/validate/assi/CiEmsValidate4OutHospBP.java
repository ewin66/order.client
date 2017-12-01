package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;

/**
 * 出院医疗单有效性检查
 * @author lxy
 *
 */
public class CiEmsValidate4OutHospBP extends BaseEmsValidate4OtherBP {


	@Override
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		OrdApOutDO outdo=(OrdApOutDO)emsDTO.getOrapplysheet().get(EmsType.OUTHOSP);
		if(outdo!=null){
			if(("").equals(outdo.getId_outtp()) || outdo.getId_outtp().equals(null))
				errorList.add("请填写离院方式！");
		}
		return errorList.size()==0;
	}

}

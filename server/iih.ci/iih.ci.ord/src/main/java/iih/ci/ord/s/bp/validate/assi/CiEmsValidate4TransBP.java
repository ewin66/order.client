package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;
/**
 * 转科医疗单有效性检查
 * @author lxy
 *
 */
public class CiEmsValidate4TransBP extends BaseEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {

		OrdApTransDO trans=(OrdApTransDO)emsDTO.getOrapplysheet().get(EmsType.TRANSDEPT) ;
		if(trans!=null){
			if(("").equals(trans.getId_dep_to()) || trans.getId_dep_to().equals(null))
				errorList.add("请填写目标科室!");
			if(("").equals(trans.getId_dep_nur_to()) || trans.getId_dep_nur_to().equals(null))
				errorList.add("请填写目标病区!");
			if(("").equals(trans.getDes_rea_canc()) || trans.getDes_rea_canc().equals(null))
				errorList.add("请填写转科原因!");
			if(trans.getId_dep_from().equals(trans.getId_dep_to()) && trans.getId_dep_nur_from().equals(trans.getId_dep_nur_to()))
				errorList.add("原病区、科室不能与目标科室、病区完全相同!");
		}
		return errorList.size()==0;
	}

}

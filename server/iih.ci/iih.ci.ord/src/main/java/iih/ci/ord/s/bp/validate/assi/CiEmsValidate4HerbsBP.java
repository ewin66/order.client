package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 草药医疗单检查
 * @author qzwang
 *
 */
public class CiEmsValidate4HerbsBP extends BaseEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		super.exec(emsDTO, errorList);
		
		// 采用剂型信息检查
		checkBoilInfo(emsDTO,errorList);
		// 剂|总量必须大于0
		checkDrugQuanInfo(emsDTO.getEmssrvs(),errorList);
		
		// 住院时停止时间为空
		if(CiOrdUtils.isIpWf(emsDTO.getCode_entp())){
			if(emsDTO.getDt_end() == null){
				errorList.add(String.format("%s([%s]) 结束日期不能为空", emsDTO.getName(),emsDTO.getId_srv()));
			}
		}
		
		return errorList.size() == 0;
	}
}

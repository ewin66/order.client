package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 手术医疗单校验
 * @author qzwang
 *
 */
public class CiEmsValidate4OpsBP extends BaseEmsValidate4OtherBP {
	
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException{
		// 必填项的检查
		if (StringUtil.isEmpty(emsDTO.getId_srv())||
				StringUtil.isEmpty(emsDTO.getName())||
				StringUtil.isEmpty(emsDTO.getSd_srvtp()))
		{
			errorList.add("医疗单服务相关信息不完整，请重新检查");
		}
		// 执行科室
		checkDepInfo(emsDTO, errorList);
		
		// 就诊相关信息检查
		checkPatDiInfo(emsDTO, errorList);
		
		// 申请单检查 ？？
		
		
		return false;
	}
	
	private void checkDepInfo(CiEmsDTO ems, List<String> errorList){
		if (StringUtil.isEmpty(ems.getId_dep_mp()) || 
				StringUtil.isEmpty(ems.getName_dep_mp())){
			errorList.add("医疗单执行科室相关信息不完整，请重新检查");
		}
	}
	
	private void checkPatDiInfo(CiEmsDTO ems, List<String> errorList){
		if (StringUtil.isEmpty(ems.getId_en())||
				StringUtil.isEmpty(ems.getId_entp())||
				StringUtil.isEmpty(ems.getId_pat()))
		{
			errorList.add("医疗单就诊相关信息不完整，请重新检查");
		}
	}
	
	private void checkApplySheetInfo(CiEmsDTO ems, List<String> errorList){
		
	}
}

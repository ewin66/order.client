package iih.ci.ord.s.bp.validate;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.CiOrEnContextBabyNoException;
import iih.ci.ord.s.bp.exception.CiOrEnContextCurDeptNullException;
import iih.ci.ord.s.bp.exception.CiOrEnContextEntTpNullException;
import iih.ci.ord.s.bp.exception.CiOrEnContextNullException;
import iih.ci.ord.s.bp.exception.CiOrEnContextOrOpenInfoNullException;
import iih.ci.ord.s.bp.exception.CiOrEnContextOrgInfoNullException;
import iih.ci.ord.s.bp.exception.CiOrEnContextPvInfoNullException;
import xap.mw.core.data.BizException;

/**
 * 患者就诊上下文数据信息有效性检查操作BP
 */
public class CiOrPvContextValidateBP {
	/**
	 * 患者就诊上下文数据信息有效性检查
	 * @param context
	 * @throws BizException
	 */
	public boolean exec(CiEnContextDTO context) throws BizException{
		//基本校验
		if(CiOrdUtils.isEmpty(context))
			throw new CiOrEnContextNullException();
		
		//组织数据校验
		if(CiOrdUtils.isEmpty(context.getId_grp()) || CiOrdUtils.isEmpty(context.getId_org()))
			throw new CiOrEnContextOrgInfoNullException();
		
		//就诊类型数据校验
		if(CiOrdUtils.isEmpty(context.getId_entp()) || CiOrdUtils.isEmpty(context.getCode_entp()))
			throw new CiOrEnContextEntTpNullException();
		
		//患者就诊信息数据校验
		if(CiOrdUtils.isEmpty(context.getId_pat()) || CiOrdUtils.isEmpty(context.getId_en()))
			throw new CiOrEnContextPvInfoNullException();
		
		//就诊当前科室与病区数据校验
		if(CiOrdUtils.isEmpty(context.getId_dep_en()) || (CiOrdUtils.isIpWf(context.getCode_entp()) && CiOrdUtils.isEmpty(context.getId_dep_ns())))
			throw new CiOrEnContextCurDeptNullException();
		
		//开立科室与开立医生数据校验
		if(CiOrdUtils.isEmpty(context.getId_dep_or()) || CiOrdUtils.isEmpty(context.getId_emp_or()))
			throw new CiOrEnContextOrOpenInfoNullException();
		
		//婴儿时婴儿序号检查
		if(CiOrdUtils.isTrue(context.getFg_bb()) 
				&& (CiOrdUtils.isEmpty(context.getNo_bb())) || context.getNo_bb()<=0)
			throw new CiOrEnContextBabyNoException();

		
		return true;
	}

}

package iih.ci.ord.s.bp.validate;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.JudgeOrderStatusBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 医嘱开立时，医嘱有效性校验操作BP
 */
public class CiOrOpenEmsInvalidateBP {
	/**
	 * 医嘱开立时，医嘱有效性校验
	 * @param ems
	 * @throws BizException
	 */
	public void exec(CiEmsDTO ems) throws BizException{
		//sv校验
		orSvValidate(ems);
		//人员就诊状态校验
		//orSrvEntStatusValidate(ems);
		//医嘱开立,服务互斥有效性校验
		orSrvReactValidate(ems);
		
		//....
	}
	private void orSvValidate(CiEmsDTO ems) throws BizException{
		//只处理住院的情况
		if(!IEnDictCodeConst.SD_ENTP_INPATIENT.equals(ems.getCode_entp())) return;
		if(ems.getStatus()==DOStatus.NEW) return;//值判断编辑的情况
		CiOrderDO ordo = new CiOrderDO();
		ordo.setName_or(ems.getName());
		ordo.setSv(ems.getSv());
		ordo.setId_or(ems.getId_or());
		JudgeOrderStatusBP bp = new JudgeOrderStatusBP();
		String errorInfo = bp.exe(new CiOrderDO[]{ordo});
		if(!CiOrdUtils.isEmpty(errorInfo)) throw new BizException(errorInfo);
	}
	private void orSrvEntStatusValidate(CiEmsDTO ems) throws BizException{
		CiOrOpenEntStatusValidateBP bp = new CiOrOpenEntStatusValidateBP();
		bp.exec(ems.getCode_entp(), ems.getId_en(), ems.getId_dep_phy(),ems.getId_dept_ns());
	}
	/**
	 * 医嘱开立服务互斥有效性校验
	 * @param ems
	 * @throws BizException
	 */
	private void orSrvReactValidate(CiEmsDTO ems) throws BizException{
		CiOrOpenOrSrvReactValidateBP bp = new CiOrOpenOrSrvReactValidateBP();
		bp.exec(ems);
		
	}
}

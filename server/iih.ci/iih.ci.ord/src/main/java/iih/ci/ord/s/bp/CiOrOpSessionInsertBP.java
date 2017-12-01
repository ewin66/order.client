package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/*
 * 医嘱签署时，门诊医嘱会话区间新增记录保存操作BP
 */
public class CiOrOpSessionInsertBP {
	/**
	 * 医嘱签署时，门诊医嘱会话区间新增记录保存
	 * 
	 * @param ciors
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public CiOrSessionDO exec(CiOrderDO[] ciors, FDateTime dt_cur) throws BizException {
		//有效性检查
		if (CiOrdUtils.isEmpty(ciors) || !CiOrdUtils.isOpUrgentWf(ciors[0].getCode_entp()))
			return null;

		//参数设置
		String orgid = CiOrdAppUtils.getEnvContext().getOrgId(); //机构id
		String depid = CiOrdAppUtils.getEnvContext().getDeptId(); //科室id
		String empid = CiOrdAppUtils.getEnvContext().getUserId(); //人员id
		empid = CiOrdUtils.getPsnDocID(empid);

		CiOrSessionDO sessiondo = new CiOrSessionDO();
		//sessiondo.setId_ciorsession();
		sessiondo.setId_pat(ciors[0].getId_pat());
		sessiondo.setId_en(ciors[0].getId_en());
		sessiondo.setId_org_sign(orgid);
		sessiondo.setId_emp_sign(empid);
		sessiondo.setId_dep_sign(depid);
		sessiondo.setDt_sign(dt_cur);
		//sessiondo.setFg_signcanc();
		//sessiondo.setDt_signcanc();
		//sessiondo.setId_dep_signcanc();
		//sessiondo.setId_emp_signcanc();
		sessiondo.setId_ors(CiOrdUtils.aryToString(ciors, "Id_or"));
		AuditInfoUtil.addData(sessiondo);
		sessiondo.setStatus(DOStatus.NEW);

		CiOrSessionDO[] sessiondos = CiOrdAppUtils.getCiorsessionService().insert(new CiOrSessionDO[] { sessiondo });
		return sessiondos[0];
	}
}

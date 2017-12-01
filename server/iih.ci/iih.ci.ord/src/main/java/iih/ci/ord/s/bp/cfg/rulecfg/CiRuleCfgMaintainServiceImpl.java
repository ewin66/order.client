package iih.ci.ord.s.bp.cfg.rulecfg;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.cfg.cirulecfg.d.RegularCheckPoint;
import iih.ci.ord.cfg.cirulecfg.i.ICirulecfgMDORService;
import iih.ci.ord.i.cfg.rulecfg.ICiRuleCfgMaintainService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 规则校验维护实现类
 * 
 * @author HUMS
 *
 */
public class CiRuleCfgMaintainServiceImpl implements ICiRuleCfgMaintainService {

	@Override
	public List<CiRuleCfg> getRuleCfgs(String check_point, String code_entp) throws BizException {

		StringBuffer whereBuffer = new StringBuffer();
		String grpId = Context.get().getGroupId();
		String orgId = Context.get().getOrgId();

		ICirulecfgMDORService ciRuleCfgRService = (ICirulecfgMDORService) ServiceFinder
				.find(ICirulecfgMDORService.class);

		whereBuffer.append(" id_grp = '"+grpId+"'");
		whereBuffer.append(" and id_org = '"+orgId+"'");
		whereBuffer.append(" and eu_check_point = '" + check_point + "'");
		if (StringUtils.isNotEmpty(code_entp)) {
			whereBuffer.append(" and code_entp = '" + code_entp + "'");
		}
		CiRuleCfg[] ciRuleCfg = ciRuleCfgRService.find(whereBuffer.toString(), "sortno", FBoolean.FALSE);

		return Arrays.asList(ciRuleCfg);
	}

	/**
	 * 获取合单规则
	 */
	@Override
	public CiRuleCfg getMergeRuleCfg() throws BizException {

		List<CiRuleCfg> ciRuleList = this.getRuleCfgs(RegularCheckPoint.MERGE_BILL, null);

		if (ciRuleList != null && ciRuleList.size() > 0) {
			return ciRuleList.get(0);
		}
		return new CiRuleCfg();
	}

	/**
	 * 获取分方规则
	 */
	@Override
	public List<CiRuleCfg> getSplitPresRuleCfgs(String code_entp) throws BizException {

		return this.getRuleCfgs(RegularCheckPoint.HANDLE_PRES, code_entp);
	}

	@Override
	public List<CiRuleCfg> getExcessiveReasonCfgs(String code_entp) throws BizException {

		return this.getRuleCfgs(RegularCheckPoint.EXCESSIVE, code_entp);
	}

}

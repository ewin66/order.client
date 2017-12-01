package iih.ci.ord.s.bp.orsms.lis;

import iih.ci.ord.i.orsms.ICiLisOrSmsRule;
import iih.ci.ord.i.orsms.ICiLisOrSmsRuleArrange;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsMpDeptRule;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsSampColTimeRule;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsSamptpAndSrvCaRule;

import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 临床检验医嘱分合单规则编排操作BP 产品公司默认的
 */
public class CiLisOrSmsRuleDefaultArrangeBP implements ICiLisOrSmsRuleArrange {

	@Override
	public List<CiLisOrSmsIoDTO> exec(List<CiLisOrSmsIoDTO> lisorlist) throws BizException {

		// 空判断
		if (CiOrdUtils.isEmpty(lisorlist))
			return null;

		// 标本类型与检验分类复合合单规则
		lisorlist = SamptpAndSrvcaSmsIoRule(lisorlist);
		
		lisorlist = SmsSampColTimeRule(lisorlist);
		
		lisorlist = SmsMpDeptRule(lisorlist);
  
		return lisorlist;

	}

	/**
	 * 临床医嘱合单规则：标本类型检验分类合单规则合单
	 * 
	 * @param orsmsiolist
	 * @return
	 * @throws BizException
	 */
	private List<CiLisOrSmsIoDTO> SamptpAndSrvcaSmsIoRule(List<CiLisOrSmsIoDTO> orsmsiolist) throws BizException {
		ICiLisOrSmsRule rule = new CiLisOrSmsSamptpAndSrvCaRule();
		return rule.exec(orsmsiolist);
	}
	
	/**
	 * 临床医嘱合单规则：标本类型检验分类合单规则合单
	 * 
	 * @param orsmsiolist
	 * @return
	 * @throws BizException
	 */
	private List<CiLisOrSmsIoDTO> SmsSampColTimeRule(List<CiLisOrSmsIoDTO> orsmsiolist) throws BizException {
		ICiLisOrSmsRule rule = new CiLisOrSmsSampColTimeRule();
		return rule.exec(orsmsiolist);
	}
	
	/**
	 * 临床医嘱合单规则：标本类型检验分类合单规则合单
	 * 
	 * @param orsmsiolist
	 * @return
	 * @throws BizException
	 */
	private List<CiLisOrSmsIoDTO> SmsMpDeptRule(List<CiLisOrSmsIoDTO> orsmsiolist) throws BizException {
		ICiLisOrSmsRule rule = new CiLisOrSmsMpDeptRule();
		return rule.exec(orsmsiolist);
	}

}

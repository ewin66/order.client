package iih.ci.ord.s.bp.splitlis;

import java.util.List;

import xap.mw.core.data.BizException;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRuleArrangePlugin;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitlis.rule.CiOrSamptpLisSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrFgBasePresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrLocationPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrHPPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrMedSrvPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrOrdPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrPharmPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrPricePresSplitRule;
import iih.ci.ord.splitlis.d.CiOrdLisSplitList;
import iih.ci.ord.splitlis.d.ICiOrLisSplitRule;
import iih.ci.ord.splitlis.d.ICiOrLisSplitRuleArrangePlugin;

/**
 * 临床检验医嘱合单默认规则编排插件实现
 */
public class CiOrLisSplitRuleArrangeDefaultPlugin implements
ICiOrLisSplitRuleArrangePlugin {

	@Override
	public List<CiOrdLisSplitList> exec(List<CiOrdLisSplitList> orpressplitlist) throws BizException {
		//空判断
		if(CiOrdUtils.isEmpty(orpressplitlist))return null;
		
        //标本类型合单规则
		orpressplitlist=lisSplit8LisSamptpSplitRule( orpressplitlist);
		
		return orpressplitlist;
	}
	
	
	/**
	 * 临床医嘱合单规则：标本类型合单规则分方
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrdLisSplitList> lisSplit8LisSamptpSplitRule(List<CiOrdLisSplitList> orpressplitlist) throws BizException{
		ICiOrLisSplitRule rule=new CiOrSamptpLisSplitRule();
		return rule.exec(orpressplitlist);
	}
	
	

}

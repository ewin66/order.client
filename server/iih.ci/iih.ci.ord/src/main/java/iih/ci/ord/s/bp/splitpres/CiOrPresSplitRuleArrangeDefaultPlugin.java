package iih.ci.ord.s.bp.splitpres;

import java.util.List;

import xap.mw.core.data.BizException;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRuleArrangePlugin;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitpres.rule.CiOrFgBasePresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrLocationPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrHPPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrMedSrvPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrOrdPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrPharmPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrPricePresSplitRule;

/**
 * 临床医嘱分方默认规则编排插件实现
 */
public class CiOrPresSplitRuleArrangeDefaultPlugin implements
		ICiOrPresSplitRuleArrangePlugin {

	@Override
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> orpressplitlist) throws BizException {
		//空判断
		if(CiOrdUtils.isEmpty(orpressplitlist))return null;
		
		//临床医嘱分方规则：药理学分方规则分方
		orpressplitlist=presSplit8CiOrPharmPresSplitRule(orpressplitlist);
		
		//临床医嘱分方规则：规则过滤
		orpressplitlist=ciOrPresSplitFilterRule(orpressplitlist);		
		//临床医嘱分方规则：服务分方规则分方
		orpressplitlist=presSplit8CiOrMedSrvPresSplitRule(orpressplitlist);
		
		//临床医嘱分方规则：执行科室分方规则分方
		orpressplitlist=presSplit8CiOrExeDepPresSplitRule(orpressplitlist);
		
		//临床医嘱分方规则：医保规则过滤  草药不参与医保分方
	    orpressplitlist=ciOrPresSplitHPFilterRule(orpressplitlist);
		//临床医嘱分方规则：医保分方规则分方		
		orpressplitlist=presSplit8CiOrHPPresSplitRule(orpressplitlist);
		
		//临床医嘱分方规则：基数药分方规则分方
		orpressplitlist=presSplit8CiOrFgBasePresSplitRule(orpressplitlist); 
		
		//临床医嘱分方规则：规则过滤
		orpressplitlist=ciOrPresSplitFilterRule(orpressplitlist);
		//临床医嘱分方规则：医嘱分方规则分方
		orpressplitlist=presSplit8CiOrOrdPresSplitRule(orpressplitlist);
		
		//临床医嘱分方规则：数量和金额分方规则分方
		orpressplitlist=presSplit8CiOrPricePresSplitRule(orpressplitlist);
		
		return orpressplitlist;
	}

	/**
	 * 临床医嘱分方规则：药理学分方规则分方
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> presSplit8CiOrPharmPresSplitRule(List<CiOrPresSplitList> orpressplitlist) throws BizException{
		ICiOrPresSplitRule rule=new CiOrPharmPresSplitRule();
		return rule.exec(orpressplitlist);
	}
	
	/**
	 * 临床医嘱分方规则：服务分方规则分方
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> presSplit8CiOrMedSrvPresSplitRule(List<CiOrPresSplitList> orpressplitlist) throws BizException{
		ICiOrPresSplitRule rule=new CiOrMedSrvPresSplitRule();
		return rule.exec(orpressplitlist);
	}
	
	/**
	 * 临床医嘱分方规则：执行科室分方规则分方
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> presSplit8CiOrExeDepPresSplitRule(List<CiOrPresSplitList> orpressplitlist) throws BizException{
		ICiOrPresSplitRule rule=new CiOrLocationPresSplitRule();
		return rule.exec(orpressplitlist);
	}
	
	/**
	 * 临床医嘱分方规则：医保分方规则分方
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> presSplit8CiOrHPPresSplitRule(List<CiOrPresSplitList> orpressplitlist) throws BizException{
		ICiOrPresSplitRule rule=new CiOrHPPresSplitRule();
		return rule.exec(orpressplitlist);
	}
	
	/**
	 * 临床医嘱分方规则：基数药分方规则分方
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> presSplit8CiOrFgBasePresSplitRule(List<CiOrPresSplitList> orpressplitlist) throws BizException{
		ICiOrPresSplitRule rule=new CiOrFgBasePresSplitRule();
		return rule.exec(orpressplitlist);
	}
	
	/**
	 * 临床医嘱分方规则：医嘱分方规则分方
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> presSplit8CiOrOrdPresSplitRule(List<CiOrPresSplitList> orpressplitlist) throws BizException{
		ICiOrPresSplitRule rule=new CiOrOrdPresSplitRule();
		return rule.exec(orpressplitlist);
	}
	
	
	
	/**
	 * 临床医嘱分方规则：数量和金额分方规则分方
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> presSplit8CiOrPricePresSplitRule(List<CiOrPresSplitList> orpressplitlist) throws BizException{
		ICiOrPresSplitRule rule=new CiOrPricePresSplitRule();
		return rule.exec(orpressplitlist);
	}
	
	/**
	 * 临床医嘱分方规则：过滤规则
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> ciOrPresSplitFilterRule(List<CiOrPresSplitList> orpressplitlist) throws BizException{
		for (CiOrPresSplitList ciOrPresSplitList : orpressplitlist) {
			switch(ciOrPresSplitList.getSd_pres()){
			case PresConstant.SD_MENTAL1:
				ciOrPresSplitList.setAppRule(false);
			break;
			case PresConstant.SD_MENTAL2:
				ciOrPresSplitList.setAppRule(false);
				break;
			default:
				ciOrPresSplitList.setAppRule(true);
				break;
			}
		}
		return orpressplitlist;
	}
	
	/**
	 * 临床医嘱分方规则：医保过滤规则
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> ciOrPresSplitHPFilterRule(List<CiOrPresSplitList> orpressplitlist) throws BizException{
		for (CiOrPresSplitList ciOrPresSplitList : orpressplitlist) {
			switch(ciOrPresSplitList.getSd_pres()){
			case PresConstant.SD_HERBAL:
				ciOrPresSplitList.setAppRule(false);
				break;
			default:
				ciOrPresSplitList.setAppRule(true);
				break;
			}
		}
		return orpressplitlist;
	}
	
	

}

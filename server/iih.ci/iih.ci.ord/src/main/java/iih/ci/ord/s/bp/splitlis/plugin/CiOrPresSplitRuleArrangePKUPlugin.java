package iih.ci.ord.s.bp.splitlis.plugin;

import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRuleArrangePlugin;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitlis.pku.PKUPresciptionRuleSplit;
import iih.ci.ord.s.bp.splitlis.pku.PKUPrescriptionTypeSplit;
import iih.ci.ord.s.bp.splitpres.PresConstant;
import iih.ci.ord.s.bp.splitpres.rule.CiOrFgBasePresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrHPPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrLocationPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrMedSrvPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrOrdPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrPharmPresSplitRule;
import iih.ci.ord.s.bp.splitpres.rule.CiOrPricePresSplitRule;

import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 北京大学国际医院的分方规则插件
 * @author li_zheng
 *
 */
public class CiOrPresSplitRuleArrangePKUPlugin implements ICiOrPresSplitRuleArrangePlugin {
	@Override
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> orpressplitlist) throws BizException {
		//空判断
		if(CiOrdUtils.isEmpty(orpressplitlist))return null;
		 //处方类型
		 PKUPrescriptionTypeSplit typeSplit = new PKUPrescriptionTypeSplit();
		 orpressplitlist = typeSplit.exec(orpressplitlist);
		 //细规则
		 PKUPresciptionRuleSplit rule= new PKUPresciptionRuleSplit();
		 orpressplitlist = rule.exec(orpressplitlist);
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

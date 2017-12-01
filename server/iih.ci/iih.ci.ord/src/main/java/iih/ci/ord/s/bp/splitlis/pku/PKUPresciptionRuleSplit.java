package iih.ci.ord.s.bp.splitlis.pku;

import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUCiOrFgBasePresSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUCiOrHPPresSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUCiOrLocationPresSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUExtdispenseSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUGroupDrugSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUInfusionSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUMedSrvTpPresSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUNumberSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUPresFlagJudge;
import iih.ci.ord.s.bp.splitlis.pku.rule.PKUSpecialDiseaseSplitRule;
import iih.ci.ord.s.bp.splitpres.OrderPresSplitList;

import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 国际医院细规则分方
 *  1.	药房：同种药房的药分在一张方上
	2.	药品类别：西药、中成药、草药（一个草药医嘱一个处方，分处方类型时，以草药医嘱为单位区分）
	3.	医保：保内在一个处方，保外在一个处方，主要针对毒麻药处方。
	4.	特种病：作为特种病标志，特种病单独分方。
	5.	特定药：符合特定药的处方单独打印，基数药单独分方
	6.	成组：成组医嘱打印在一张方上，一个成组医嘱一个处方，如果组内药品是不同的处方笺类型，则分别打印。
	7.	大输液大类单独分方：当服务类型为【溶媒】时，并且不是成组医嘱时，单独成方
	8.	数量：单张医保最多为四个，自费为五个，当前是5
 * @author li_zheng
 *
 */
public class PKUPresciptionRuleSplit {
   /**
    *   1.	药房：同种药房的药分在一张方上
		2.	药品类别：西药、中成药、草药（一个草药医嘱一个处方，分处方类型时，以草药医嘱为单位区分）
		3.	医保：保内在一个处方，保外在一个处方，主要针对毒麻药处方。
		4.	特种病：作为特种病标志，特种病单独分方。
		5.	特定药：符合特定药的处方单独打印，基数药单独分方
		6.	成组：成组医嘱打印在一张方上，一个成组医嘱一个处方，如果组内药品是不同的处方笺类型，则分别打印。
		7.	大输液大类单独分方：当服务类型为【溶媒】时，并且不是成组医嘱时，单独成方
		8.	数量：单张医保最多为四个，自费为五个，当前是5
    * @param list
    * @return
    * @throws BizException
    */
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> list)throws BizException{
		List<CiOrPresSplitList> outList=null;
		//1.	药房：同种药房的药分在一张方上
		PKUCiOrLocationPresSplitRule lRule= new PKUCiOrLocationPresSplitRule();
		outList = lRule.exec(list);
		//2.	药品类别：西药、中成药、草药（一个草药医嘱一个处方，分处方类型时，以草药医嘱为单位区分）
		PKUMedSrvTpPresSplitRule srvRule = new PKUMedSrvTpPresSplitRule();
		outList = srvRule.exec(outList);
		//3.	医保：保内在一个处方，保外在一个处方，主要针对毒麻药处方。
		PKUCiOrHPPresSplitRule hpRule = new PKUCiOrHPPresSplitRule();
		outList = hpRule.exec(outList);
		//4.	特种病：作为特种病标志，特种病单独分方。
		PKUSpecialDiseaseSplitRule sRule = new PKUSpecialDiseaseSplitRule();
		outList = sRule.exec(outList); 
		//5.	特定药：符合特定药的处方单独打印，基数药单独分方
		PKUCiOrFgBasePresSplitRule bRule = new PKUCiOrFgBasePresSplitRule();
		outList = bRule.exec(outList);
		//外配处方  
		PKUExtdispenseSplitRule extdispense = new PKUExtdispenseSplitRule();
		outList = extdispense.exec(outList);
		
		//6.	成组：成组医嘱打印在一张方上，一个成组医嘱一个处方，如果组内药品是不同的处方笺类型，则分别打印。
		PKUGroupDrugSplitRule gRule = new PKUGroupDrugSplitRule();
		outList = gRule.exec(outList);
		//7.	大输液大类单独分方：当服务类型为【溶媒】时，并且不是成组医嘱时，单独成方
		PKUInfusionSplitRule iRule = new PKUInfusionSplitRule();
		//outList = iRule.exec(outList);
		//8.	数量：单张医保最多为四个，自费为五个，当前是5
		PKUNumberSplitRule nRule = new PKUNumberSplitRule();
		outList = nRule.exec(outList);
		// 标志
		PKUPresFlagJudge judge = new PKUPresFlagJudge();
		outList = judge.exec(outList);
		return outList;
	}
}

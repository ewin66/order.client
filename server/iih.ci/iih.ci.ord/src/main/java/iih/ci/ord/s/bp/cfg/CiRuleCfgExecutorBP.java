package iih.ci.ord.s.bp.cfg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.cfg.cirulecfg.d.RegularCheckPoint;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.s.bp.cfg.rulecfg.AbstractRuleExecutor;
import iih.ci.ord.s.bp.cfg.rulecfg.RuleCfgChainFacory;
import xap.mw.core.data.Context;

/**
 * 规则执行类对外服务
 * 
 * @author HUMS
 *
 */
public class CiRuleCfgExecutorBP {

	/**
	 * 执行分方
	 * 
	 * @param presList 待拆分的处方集合
	 * @return 拆分后的处方集合
	 */
	public List<CiOrPresSplitList> execSplitPres(List<CiOrPresSplitList> presList) {

		CiEnContextDTO ctx = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		RuleCfgChainFacory<List<CiOrPresSplitList>> ruleCfgChainFacory = new RuleCfgChainFacory<List<CiOrPresSplitList>>();

		List<CiOrPresSplitList> presSplitList = new ArrayList<CiOrPresSplitList>();
		
		// 待进行分方的草药集合
		List<CiOrPresSplitList> herbsPresList = new ArrayList<CiOrPresSplitList>();
		// 待分方的非草药集合
		List<CiOrPresSplitList> drugsPresList = new ArrayList<CiOrPresSplitList>();
		
		if(presList == null || presList.size() ==0 ){
			return presSplitList;
		}
		
		for(CiOrPresSplitList presSplit : presList){
			

			// 待进行分方的草药集合
			List<OrderPresSplitDTO> herbsOrdPresList = new ArrayList<OrderPresSplitDTO>();
			// 待分方的非草药集合
			List<OrderPresSplitDTO> drugsOrdPresList = new ArrayList<OrderPresSplitDTO>();
			
			List<OrderPresSplitDTO> orderPresSplit = presSplit.getOrderList();
			
			for(OrderPresSplitDTO orderPres : orderPresSplit){
				
				if (IBdMmDictCodeConst.SD_MMTP_DRUG_CHIHE.equals(orderPres.getSd_mmtp())) {
					herbsOrdPresList.add(orderPres);
				}else{
					drugsOrdPresList.add(orderPres);
				}
			}
			
			
			// 草药待分方数据
			if(herbsOrdPresList.size() > 0 ){
				
				CiOrPresSplitList herbsPresSplit = new CiOrPresSplitList();
				BeanUtils.copyProperties(presSplit, herbsPresSplit, new String[] { "orderList" ,"cfgProps"});
				herbsPresSplit.setOrderList(herbsOrdPresList);
				herbsPresList.add(herbsPresSplit);
			}

			// 非草药待分方数据
			if(drugsOrdPresList.size() >0){
				CiOrPresSplitList drugPresSplit = new CiOrPresSplitList();
				BeanUtils.copyProperties(presSplit, drugPresSplit, new String[] { "orderList" ,"cfgProps"});
				drugPresSplit.setOrderList(drugsOrdPresList);
				drugsPresList.add(drugPresSplit);
			}
			
		}
		
		if(herbsPresList.size() >0){
			AbstractRuleExecutor<List<CiOrPresSplitList>> herbsRuleExecutor = ruleCfgChainFacory
					.getRuleChain(RegularCheckPoint.HANDLE_HERBS_PRES, ctx.getCode_entp());
			List<CiOrPresSplitList> newHerbsPresList = herbsRuleExecutor.startExecuteRule(herbsPresList);
			presSplitList.addAll(newHerbsPresList);
		}
		
		if(drugsPresList.size() >0){
			AbstractRuleExecutor<List<CiOrPresSplitList>> ruleExecutor = ruleCfgChainFacory
					.getRuleChain(RegularCheckPoint.HANDLE_PRES, ctx.getCode_entp());

			List<CiOrPresSplitList> newDrugPresList = ruleExecutor.startExecuteRule(drugsPresList);
			presSplitList.addAll(newDrugPresList);
		}
		
		return presSplitList;
	}

}

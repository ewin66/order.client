package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONObject;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.s.bp.cfg.RuleCfgConstant;

/**
 * 8. 数量：单张医保最多为四个，自费为五个，当前是5个
 * 
 * @author HUMS
 *
 */
public class PresByNumber extends AbstractSinglePresRuleExecutor {

	/**
	 * 根据每个处方中携带的处方数量进行分方
	 */
	@Override
	protected List<CiOrPresSplitList> executePresSplitRule(CiOrPresSplitList presSplit) {

		// 新的处方集合
		List<CiOrPresSplitList> presSplitList = new Vector<CiOrPresSplitList>();
		Map<String, Object> map = presSplit.getCfgProps();

		if (map == null || !map.containsKey(RuleCfgConstant.CURR_PRES_TYPE)) {
			presSplitList.add(presSplit);
			return presSplitList;
		}

		JSONObject presTypeJson = (JSONObject) map.get(RuleCfgConstant.CURR_PRES_TYPE);

		// 获取当前处方的最大明细数量
		// int presCnt =
		// this.presTypeJson.getIntValue(RuleCfgConstant.PRES_DETAIL_NUM);
		int presCnt = presTypeJson.getIntValue(RuleCfgConstant.PRES_DETAIL_NUM);
		/*
		 * Object objNum = map.get(RuleCfgConstant.PRES_DETAIL_NUM); if (objNum
		 * == null || Integer.parseInt(objNum.toString()) == 0) {
		 * presSplitList.add(presSplit); return presSplitList; }
		 * 
		 * // 每个处方中明细项记录数 int presCnt = Integer.parseInt(objNum.toString());
		 */
		List<OrderPresSplitDTO> presSplitDetailList = presSplit.getOrderList();

		CiOrPresSplitList newPres = null;
		// 按照处方中配置的明细个数进行分方
		for (int i = 0; i < presSplitDetailList.size(); i++) {

			List<OrderPresSplitDTO> newPresDetailList = null;
			if (i % presCnt == 0) {

				newPres = new CiOrPresSplitList();
				BeanUtils.copyProperties(presSplit, newPres, new String[] { "orderList" });
				newPresDetailList = new Vector<OrderPresSplitDTO>();
				newPres.setOrderList(newPresDetailList);
				presSplitList.add(newPres);
			}

			newPresDetailList = newPres.getOrderList();
			newPresDetailList.add(presSplitDetailList.get(i));
		}

		return presSplitList;
	}

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		return true;
	}

	@Override
	protected boolean isForcedSplit() {

		return true;
	}
}

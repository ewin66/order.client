package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONObject;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.s.bp.cfg.RuleCfgConstant;
import iih.ci.ord.s.bp.cfg.rulecfg.rule.DefaultRuleExecutor;

/**
 * 处方规则执行器
 * 
 * @author HUMS
 *
 */
public abstract class AbstractPresRuleExecutor extends DefaultRuleExecutor<List<CiOrPresSplitList>> {


	/**
	 * 设置处方是否允许拆分默认值
	 */
	@Override
	public void setDefaultVal(List<CiOrPresSplitList> presSplitList) {

		for (CiOrPresSplitList ciOrPres : presSplitList) {
			
			// 设置是否允许拆分
			this.setPresAllowedSplit(ciOrPres);
		}

	}

	@Override
	protected void setDefaultJsonVal(String defaultJsonVal) {
		super.setDefaultJsonVal(defaultJsonVal);
	}

	/**
	 * 执行分方规则
	 */
	@Override
	public List<CiOrPresSplitList> executeRule(List<CiOrPresSplitList> presSplitList) {

		List<CiOrPresSplitList> newPresSplitList = new Vector<CiOrPresSplitList>();

		for (CiOrPresSplitList presSplit : presSplitList) {

			// 允许进行分方，或者当前配置需要进行强制分方时调用分方
			List<CiOrPresSplitList> presList = this.executePresSplitRule(presSplit);
			newPresSplitList.addAll(presList);

		}

		return newPresSplitList;
	}

	@Override
	protected boolean isExecuteNext() {

		return false;
	}

	/**
	 * 将当前处方按规则重新构造新的处方（处方拆分）
	 * 
	 * @param presSplit
	 *            当前待拆分处方
	 * @return 拆分后重新构造的处方
	 */
	protected List<CiOrPresSplitList> executePresSplitRule(CiOrPresSplitList presSplit) {

		// 获取当前处方的子项
		List<OrderPresSplitDTO> orderList = presSplit.getOrderList();
		if (orderList == null || orderList.size() == 0) {
			return null;
		}

		// 返回结果（处方集合）
		List<CiOrPresSplitList> newPresSplitList = new Vector<CiOrPresSplitList>();
		// 新处方子项集合
		Map<String, List<OrderPresSplitDTO>> presMap = new ConcurrentHashMap<String, List<OrderPresSplitDTO>>();
		
		// 当处方允许分方时或者需要强制分方时，才进行分方
		if (isAllowedSplitCurrPres(presSplit) || isForcedSplit()) {

			for (OrderPresSplitDTO orderPresChild : orderList) {

				// 获取拆分处方的唯一标识,作为map的key值，使用map结构因为存成组药，或按部门生成处方，一个规则会拆分出多个处方
				String presIdentification = this.getDefaultPresIdentification(orderPresChild);
				if (!presMap.containsKey(presIdentification)) {
					// 新处方的子项集合
					List<OrderPresSplitDTO> newOrderPresChildren = new Vector<OrderPresSplitDTO>();
					presMap.put(presIdentification, newOrderPresChildren);
				}

				// 当前处方允许拆分并且符合拆分规则 或者 需要强制拆分时在进行拆分
				if (isConformToTheRules(orderPresChild)) {
					presMap.get(presIdentification).add(orderPresChild);
				}

			}
			// 遍历新生成的处方map集合，构造新的处方对象，并添加到返回的处方集合中，同时删除原处方的子项
			newPresSplitList = this.reSplitPres(presSplit, presMap);

			// 设置新处方的默认值
			this.setDefaultVal(newPresSplitList);
		}
		
		// 如果原处方中还有剩余的处方数据，作为一个新的处方
		if (presSplit.getOrderList().size() > 0) {
			newPresSplitList.add(presSplit);
		}
		
		// 遍历处方设置处方类型，处方字
		for(CiOrPresSplitList ciOrPres : newPresSplitList){
			
			if(isAllowSetPresType(ciOrPres)){
				this.setPresType(ciOrPres);
			}
			
			if(isAllowSetPresWord(ciOrPres)){
				this.setPresWord(ciOrPres);
			}
			
		}
		

		return newPresSplitList;
	}
	
	/**
	 * 重新生成处方
	 * @param presSplit 当前的处方对象
	 * @param presMap 按这个规则拆分后的处方明细集合
	 * @return
	 */
	protected List<CiOrPresSplitList> reSplitPres(CiOrPresSplitList presSplit,
			Map<String, List<OrderPresSplitDTO>> presMap) {

		// 返回结果（处方集合）
		List<CiOrPresSplitList> newPresSplitList = new Vector<CiOrPresSplitList>();

		// 遍历新生成的处方map集合，构造新的处方对象，并添加到返回的处方集合中，同时删除原处方的子项
		for (List<OrderPresSplitDTO> orderPresChildren : presMap.values()) {

			if (orderPresChildren.size() == 0) {
				continue;
			}
			// 删除原处方子项
			presSplit.getOrderList().removeAll(orderPresChildren);

			// 构造新的处方对象，并将原处方属性复制到新处方中
			CiOrPresSplitList newPresSplit = new CiOrPresSplitList();

			BeanUtils.copyProperties(presSplit, newPresSplit, new String[] { "orderList" ,"cfgProps"});
			
			if(presSplit.getCfgProps() != null ){
				// 拷贝配置结果
				Map<String, Object> cfgPropsMap = new ConcurrentHashMap<String, Object>();
				cfgPropsMap.putAll(presSplit.getCfgProps());
				newPresSplit.setCfgProps(cfgPropsMap);	
			}			

			// 将构造的处方子项添加到原处方中
			newPresSplit.setOrderList(orderPresChildren);
			newPresSplitList.add(newPresSplit);
		}
		
		return newPresSplitList;
	}

	/**
	 * 是否允许设置处方类型
	 * @param presSplit 处方
	 * @return
	 */
	protected boolean isAllowSetPresType(CiOrPresSplitList presSplit){
		
		List<OrderPresSplitDTO> orderList = presSplit.getOrderList();
		for(OrderPresSplitDTO orderPresChild : orderList){
			if(isConformToTheRules(orderPresChild)){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 是否允许设置处方字
	 * @param presSplit 处方
	 * @return
	 */
	protected boolean isAllowSetPresWord(CiOrPresSplitList presSplit){
		
		List<OrderPresSplitDTO> orderList = presSplit.getOrderList();
		for(OrderPresSplitDTO orderPresChild : orderList){
			if(isConformToTheRules(orderPresChild)){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 获取默认的处方标识
	 * 
	 * @param orderPresSplit
	 *            处方明细项
	 * @return 返回处方唯一标识，如果子类返回值为空，使用当前类名作为处方唯一标识
	 */
	private String getDefaultPresIdentification(OrderPresSplitDTO orderPresSplit) {

		String presIdentification = this.getPresIdentification(orderPresSplit);
		if (StringUtils.isEmpty(presIdentification)) {
			return this.getClass().getName();
		}
		return presIdentification;
	}

	/**
	 * 获取医嘱处方唯一标识
	 * 
	 * @param orderPresSplit
	 * @return
	 */
	protected abstract String getPresIdentification(OrderPresSplitDTO orderPresSplit);

	/**
	 * 判断处方明细是否符合规则
	 * 
	 * @param orderPresSplit
	 *            处方明细
	 * @return true 符合规则，false 不符合规则
	 */
	protected abstract boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit);

	/**
	 * 设置处方类型
	 * 
	 * @param ciOrPres
	 *            处方
	 */
	protected void setPresType(CiOrPresSplitList ciOrPres) {

		// 配置结果中存在处方类型时
		if (!this.cfgJsonResult.containsKey(RuleCfgConstant.PRES_TYPE)) {
			return;
		}

		// 获取当前规则配置中的处方类型
		JSONObject presTypeJson = this.cfgJsonResult.getJSONObject(RuleCfgConstant.PRES_TYPE);
		// 下一规则未配置处方类型时，直接返回
		if (presTypeJson == null) {
			return;
		}

		// 取当前处方类型，如果处方类型为空，将当前规则中配置结果设置到处方对象中
		Map<String, Object> cfgPropsMap = ciOrPres.getCfgProps();
		if (cfgPropsMap == null) {
			cfgPropsMap = new ConcurrentHashMap<String, Object>();
			ciOrPres.setCfgProps(cfgPropsMap);
		}
		Object obj = cfgPropsMap.get(RuleCfgConstant.CURR_PRES_TYPE);
		if (obj == null) {
			cfgPropsMap.put(RuleCfgConstant.CURR_PRES_TYPE, presTypeJson);
			obj = presTypeJson;
		}

		// 获取当前处方类型
		JSONObject currPresTypeJson = (JSONObject) obj;

		// 获取覆盖模式 0：保持不变，1：替换（有权重值的按权重替换，没有权重属性的直接替换） ，2：追加
		/*
		 * Integer overWriteModel =
		 * currPresTypeJson.getInteger(RuleCfgConstant.OVERWRITE_MODEL);
		 * 
		 * // 保持不变 if (overWriteModel == 0) { return; }
		 */

		// 当前处方类型的权重
		Integer currWight = currPresTypeJson.getInteger(RuleCfgConstant.WEIGHT);
		// 当前规则配置的处方类型权重，
		Integer cfgWight = presTypeJson.getInteger(RuleCfgConstant.WEIGHT);

		// 当覆盖模式为替换时，并且规则中配置的处方类型权重大于当前处方中的处方类型，才进行处方类型替换
		// if (overWriteModel == 1 && cfgWight > currWight) {
		if (cfgWight >= currWight) {
			// 将规则中配置的处方类型做为当前处方类型
			cfgPropsMap.put(RuleCfgConstant.CURR_PRES_TYPE, presTypeJson);

			// 设置处方类型的id，编码，名称
			ciOrPres.setId_prestp(presTypeJson.getString("id_prestp"));
			ciOrPres.setSd_pres(presTypeJson.getString("sd_prestp"));
			ciOrPres.setName(presTypeJson.getString("name_prestp"));
		}
	}

	/**
	 * 设置处方字
	 * 
	 * @param ciOrPres
	 *            处方
	 */
	protected void setPresWord(CiOrPresSplitList ciOrPres) {

		// 判断配置结果中是否存在处方字
		if (!this.cfgJsonResult.containsKey(RuleCfgConstant.PRES_WORD)) {
			return;
		}

		// 获取当前规则配置中的处方字
		JSONObject cfgPresWordJson = this.cfgJsonResult.getJSONObject(RuleCfgConstant.PRES_WORD);
		// 下一规则未配置处方类型时，直接返回
		if (cfgPresWordJson == null) {
			return;
		}

		// 取当前处方类型，如果处方类型为空，将当前规则中配置结果设置到处方对象中
		Map<String, Object> cfgPropsMap = ciOrPres.getCfgProps();
		Object obj = cfgPropsMap.get(RuleCfgConstant.CURR_PRES_WORD);
		if (obj == null) {

			// 更新当前的处方字
			cfgPropsMap.put(RuleCfgConstant.CURR_PRES_WORD, cfgPresWordJson);
			
			ciOrPres.setId_prestpword(cfgPresWordJson.getString("id_prestpword"));
			ciOrPres.setSd_prestpword(cfgPresWordJson.getString("sd_prestpword"));
			return;
		}

		// 判断处方字是否已经赋值到当前的处方字中
		if (ciOrPres.getId_prestpword().indexOf(cfgPresWordJson.getString("id_prestpword")) >= 0) {
			return;
		}

		// 更新当前的处方字
		cfgPropsMap.put(RuleCfgConstant.CURR_PRES_WORD, cfgPresWordJson);

		ciOrPres.setId_prestpword(ciOrPres.getId_prestpword() + "," + cfgPresWordJson.getString("id_prestpword"));
		ciOrPres.setSd_prestpword(ciOrPres.getSd_prestpword() + "," + cfgPresWordJson.getString("sd_prestpword"));
	}

	/**
	 * 设置当前处方是否允许继续拆分
	 * 
	 * @param ciOrPres
	 */
	protected void setPresAllowedSplit(CiOrPresSplitList ciOrPres) {

		// 当前处方对象属性是否允许拆分,如果不允许拆分，后续一直处方保持不可拆分状态，如果可以拆分获取当前配置的结果确定是否允许拆分
		boolean isAllowedSplit = true;
		Map<String, Object> cfgPropsMap = ciOrPres.getCfgProps();
		if (cfgPropsMap == null) {
			cfgPropsMap = new ConcurrentHashMap<String, Object>();
			ciOrPres.setCfgProps(cfgPropsMap);
		}

		if (this.cfgJsonResult.containsKey(RuleCfgConstant.IS_ALLOWED_SPLIT)) {
			isAllowedSplit = this.cfgJsonResult.getBooleanValue(RuleCfgConstant.IS_ALLOWED_SPLIT);
		}

		if (!cfgPropsMap.containsKey(RuleCfgConstant.IS_ALLOWED_SPLIT)) {
			cfgPropsMap.put(RuleCfgConstant.IS_ALLOWED_SPLIT, isAllowedSplit);
		}

		// 获取当前处方携带的是否允许拆分属性
		Object obj = cfgPropsMap.get(RuleCfgConstant.IS_ALLOWED_SPLIT);
		boolean isCurrAllowedSplit = Boolean.parseBoolean(obj.toString());

		// 当前处方对象携带的是否拆分属性与当前分方规则中配置的是否允许拆分属性交集，判断该处方是否允许进行拆分
		isAllowedSplit = isAllowedSplit && isCurrAllowedSplit;
		cfgPropsMap.put(RuleCfgConstant.IS_ALLOWED_SPLIT, isAllowedSplit);
	}

	/**
	 * 判断当前处是否方允许再次进行分方
	 * 
	 * @param ciOrPres
	 * @return true 允许拆分，false 不允许拆分
	 */
	protected boolean isAllowedSplitCurrPres(CiOrPresSplitList ciOrPres) {

		// 当前处方对象属性是否允许拆分,如果不允许拆分，后续一直处方保持不可拆分状态，如果可以拆分获取当前配置的结果确定是否允许拆分
		Map<String, Object> cfgPropsMap = ciOrPres.getCfgProps();
		if (cfgPropsMap == null || !cfgPropsMap.containsKey(RuleCfgConstant.IS_ALLOWED_SPLIT)) {
			return true;
		}

		return Boolean.parseBoolean(cfgPropsMap.get(RuleCfgConstant.IS_ALLOWED_SPLIT).toString());
	}

	/**
	 * 是否强制进行分方
	 * 
	 * @return
	 */
	protected boolean isForcedSplit() {

		return false;
	}

}

package iih.ci.ord.s.bp.cfg.rulecfg;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.cfg.cirulecfg.d.CiRuleEntity;
import iih.ci.ord.cfg.cirulecfg.i.IRuleentityRService;
import iih.ci.ord.i.cfg.rulecfg.ICiRuleCfgMaintainService;
import iih.ci.ord.s.bp.cfg.rulecfg.rule.DefaultRuleExecutor;
import iih.ci.ord.s.bp.cfg.rulecfg.validator.DefaultValidatorExecutor;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 构造规则执行链
 * 
 * @author HUMS
 *
 * @param <T>
 */
public class RuleCfgChainFacory<T> {

	/**
	 * 获取规则执行链
	 * 
	 * @param check_point
	 *            规则校验点 数据来源于 RegularCheckPoint
	 * @param code_entp
	 *            就诊类型
	 * @return 规则链中第一个规则
	 */
	public AbstractRuleExecutor<T> getRuleChain(String check_point, String code_entp) {

		AbstractExecutorChain<T> executorChain = this.getExecutorChain(check_point, code_entp);
		if (executorChain == null) {
			return new DefaultRuleExecutor<T>();
		}
		return (AbstractRuleExecutor<T>) executorChain;
	}

	/**
	 * 获取规则校验链
	 * 
	 * @param check_point
	 *            规则校验点
	 * @return
	 */
	public AbstractRuleValidator<T> getRuleValidatorChain(String check_point, String code_entp) {

		AbstractExecutorChain<T> executorChain = this.getExecutorChain(check_point, code_entp);
		if (executorChain == null) {
			return new DefaultValidatorExecutor<T>();
		}

		return (AbstractRuleValidator<T>) executorChain;

	}

	/**
	 * 规则校验点
	 * 
	 * @param check_point
	 * @param code_entp
	 * @return
	 */
	private AbstractExecutorChain<T> getExecutorChain(String check_point, String code_entp) {

		ICiRuleCfgMaintainService ciRuleCfgRService = (ICiRuleCfgMaintainService) ServiceFinder
				.find(ICiRuleCfgMaintainService.class);

		IRuleentityRService ruleentityRService = (IRuleentityRService) ServiceFinder.find(IRuleentityRService.class);

		// 规则连的第一项
		AbstractExecutorChain<T> headRuleExecutor = null;

		// 前一个规则执行对象，用于构造规则连。记录前一个规则
		AbstractExecutorChain<T> preRuleExecutor = null;
		// 规则实体id集合
		List<String> idRuleList = new Vector<String>();

		try {
			// 获取规则配置结果，提取规则实体id
			List<CiRuleCfg> ruleCfgList = ciRuleCfgRService.getRuleCfgs(check_point, code_entp);
			if (ruleCfgList == null || ruleCfgList.size() == 0) {
				Logger.error("获取规则失败，传入参数check_point = '" + check_point + "' , code_entp = '" + code_entp + "' ， 使用默认的规则实现类！");
				return null;
			}

			for (CiRuleCfg ruleCfg : ruleCfgList) {
				idRuleList.add(ruleCfg.getId_rules());
			}

			// 获取对应规则链中使用的规则实体对象，并构造map结构便于后续使用
			CiRuleEntity[] ruleEntitys = ruleentityRService.findByIds(idRuleList.toArray(new String[idRuleList.size()]),
					FBoolean.FALSE);

			Map<String, CiRuleEntity> ruleEntityMap = new ConcurrentHashMap<String, CiRuleEntity>();

			for (CiRuleEntity ruleEntity : ruleEntitys) {
				ruleEntityMap.put(ruleEntity.getId_rule(), ruleEntity);
			}

			// 通过规则实体构造规则执行链
			for (CiRuleCfg ruleCfg : ruleCfgList) {

				CiRuleEntity ruleEntity = ruleEntityMap.get(ruleCfg.getId_rules());

				try {
					Class<?> cla = Class.forName(ruleEntity.getClass_path());
					AbstractExecutorChain<T> ruleExecutor = (AbstractExecutorChain<T>) cla.newInstance();
					ruleExecutor.setDefaultJsonVal(ruleCfg.getCfg_result());

					// preRuleExecutor为空时，为规则链第一项
					if (preRuleExecutor == null) {
						// 设置规则链的第一项，用于返回规则链对象
						headRuleExecutor = ruleExecutor;
					} else {
						// 构造规则链，指定下一个规则
						preRuleExecutor.setNextExecutor(ruleExecutor);
					}

					preRuleExecutor = ruleExecutor;

				} catch (Exception e) {
					throw new BizRuntimeException("实例化对象[" + ruleEntity.getClass_name() + "]失败");
				}
			}

		} catch (BizException e) {
			throw new BizRuntimeException("获取规则对象异常", e);
		}
		return headRuleExecutor;

	}

}

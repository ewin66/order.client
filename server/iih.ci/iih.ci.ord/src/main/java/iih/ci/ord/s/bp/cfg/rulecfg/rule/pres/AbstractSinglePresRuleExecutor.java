package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 一个规则只能拆分出唯一的处方时，继承该类，子类只实现一个是否符合规则接口
 * 
 * @author HUMS
 *
 */
public abstract class AbstractSinglePresRuleExecutor extends AbstractPresRuleExecutor {

	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {
		
		return this.getClass().getName();
	}

}

package iih.ci.ord.s.bp.cfg.rulecfg.rule;

import iih.ci.ord.s.bp.cfg.rulecfg.AbstractRuleExecutor;

public class DefaultRuleExecutor<T> extends AbstractRuleExecutor<T>{

	@Override
	public void setDefaultVal(T t) {
		
	}

	@Override
	public T executeRule(T t) {
		return t;
	}

	@Override
	protected boolean isExecuteNext() {
		return true;
	}

}

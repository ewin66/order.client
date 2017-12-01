package iih.ci.ord.s.bp.cfg.rulecfg.validator;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.bp.cfg.rulecfg.AbstractRuleValidator;

/**
 * 执行规则校验，不使用上下文环境
 * 
 * @author HUMS
 * @param <T>
 *
 */
public abstract class AbstractNoCtxValidator<T> extends DefaultValidatorExecutor<T> {

	@Override
	public final boolean validate(CiEnContextDTO ctx, T t) {
		return this.validate(t);
	}

	/**
	 * 执行规则校验
	 * 
	 * @param t
	 * @return
	 */
	protected abstract boolean validate(T t);

}

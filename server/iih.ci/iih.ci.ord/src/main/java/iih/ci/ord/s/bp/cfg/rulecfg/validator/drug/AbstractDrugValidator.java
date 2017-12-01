package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug;

import iih.ci.ord.cfg.dto.msg.d.RuleMsgDTO;
import iih.ci.ord.s.bp.cfg.RuleCfgConstant;
import iih.ci.ord.s.bp.cfg.rulecfg.validator.AbstractNoCtxValidator;

public abstract class AbstractDrugValidator<T> extends AbstractNoCtxValidator<T> {

	private boolean isBreakFailValidate;

	@Override
	public void setDefaultVal(T t) {
		
		boolean isBreak = false;
		
		String breakFailValidate = this.cfgJsonResult.getString(RuleCfgConstant.IS_BREAK_FAIL_VALIDATE);
		
		if(RuleCfgConstant.FIRST.equals(breakFailValidate)){
			isBreak = true;
		}
		this.setBreakFailValidate(isBreak);
	}

	@Override
	public RuleMsgDTO getValidateMsg() {
		return this.ruleMsg;
	}

	/**
	 * 校验失败是否停止执行下一个校验器
	 */
	@Override
	public boolean isBreakFailValidate() {
		
		return this.isBreakFailValidate;
	}

	private void setBreakFailValidate(boolean isBreakFailValidate) {
		this.isBreakFailValidate = isBreakFailValidate;
	}

}

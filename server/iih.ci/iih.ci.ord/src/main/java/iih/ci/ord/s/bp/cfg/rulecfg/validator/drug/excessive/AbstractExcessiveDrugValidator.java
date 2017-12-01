package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.s.bp.cfg.RuleCfgConstant;
import iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.AbstractDrugValidator;

public abstract class AbstractExcessiveDrugValidator extends AbstractDrugValidator<EmsDrugItemDO> {

	// 是否停止执行下一个校验器
	private boolean isBreak;
	// 规则配置中的使用天数
	private int useDays;

	@Override
	public void setDefaultVal(EmsDrugItemDO drugItm) {

		super.setDefaultVal(drugItm);

		this.setUseDays();
	}

	/**
	 * 设置规则中配置的默认天数<br>
	 * 如果规则配置界面中未设置天数，直接取规则实现中默认天数
	 */
	private void setUseDays() {

		Integer useDays = this.cfgJsonResult.getInteger(RuleCfgConstant.USE_DAYS);
		if (useDays == null || useDays < 0) {
			this.useDays = this.getDefaultUseDays();
		} else {
			this.useDays = useDays;
		}
	}

	@Override
	protected boolean validate(EmsDrugItemDO drugItem) {

		this.setDefaultVal(drugItem);
		String idExcessiveReasons = drugItem.getId_excessive_reason();

		if (StringUtils.isBlank(idExcessiveReasons)) {
			if (ICiDictCodeConst.ID_EXCESSIVE_REASON_NORMAL.equals(this.getExcessiveReasonIdentity())) {
				return isEffectiveUseDays(drugItem);
			}
			return true;
		}

		String[] excessiveReasons = idExcessiveReasons.split(",");
		for (String reasonId : excessiveReasons) {
			
			if (!this.getExcessiveReasonIdentity().equals(reasonId)) {
				continue;
			}
			
			return isEffectiveUseDays(drugItem);
		}

		return true;
	}

	/**
	 * 判断医嘱有效天数是否符合当前配置的最大有效天数
	 * 
	 * @param drugItem
	 * @return
	 */
	private boolean isEffectiveUseDays(EmsDrugItemDO drugItem) {

		// 如果规则不适用，直接返回true,进行下一个规则校验
		if (!isConformToTheRules(drugItem)) {
			return true;
		}
		boolean isEffective = this.useDays >= drugItem.getUse_days();

		if (!isEffective) {
			
			this.ruleMsg.setContent(this.getExcessiveReasonMsg());
			this.ruleMsg.getExt_content().put(RuleCfgConstant.MAX_USE_DAYS, this.useDays);
		} else {
			// 如果有一项满足要求，就不用在继续执行
			this.isBreak = true;
		}

		return isEffective;
	}

	/**
	 * 校验失败是否停止执行下一个校验器
	 */
	@Override
	public boolean isBreakFailValidate() {

		return this.isBreak;
	}

	/**
	 * 是否符合规则
	 * 
	 * @param ciEms
	 * @return
	 */
	protected abstract boolean isConformToTheRules(EmsDrugItemDO drugItem);

	/**
	 * 获取校验类，校验的类型sd值
	 * 
	 * @return
	 */
	protected abstract String getExcessiveReasonIdentity();

	/**
	 * 获取超量开单校验失败的原因
	 * 
	 * @return
	 */
	protected abstract String getExcessiveReasonMsg();

	/**
	 * 获取符合规则默认天数
	 * 
	 * @return
	 */
	protected abstract int getDefaultUseDays();

}

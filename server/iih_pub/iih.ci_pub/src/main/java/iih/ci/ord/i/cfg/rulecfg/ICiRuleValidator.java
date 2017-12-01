package iih.ci.ord.i.cfg.rulecfg;

import iih.ci.ord.cfg.dto.msg.d.RuleMsgDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 规则校验接口
 * 
 * @author HUMS
 *
 */
public interface ICiRuleValidator<T> {

	/**
	 * 执行数据校验
	 * 
	 * @param <T>
	 * 
	 * @param baseDO
	 * @return true 校验通过，false 校验失败
	 */
	public boolean validate(CiEnContextDTO ctx, T t);

	/**
	 * 获取校验失败信息
	 * 
	 * @return
	 */
	public RuleMsgDTO getValidateMsg();

	/**
	 * 校验失败是否停止校验
	 * 
	 * @return
	 */
	public boolean isBreakFailValidate();

}

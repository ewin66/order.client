package iih.ci.ord.s.bp.cfg.rulecfg;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.alibaba.fastjson.JSONObject;

import iih.ci.ord.cfg.dto.msg.d.RuleMsgDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.cfg.rulecfg.ICiRuleValidator;
import xap.mw.core.data.FMap;

/**
 * 校验执行器抽象类
 * 
 * @author HUMS
 * @param <T>
 *
 */
public abstract class AbstractRuleValidator<T> extends AbstractExecutorChain<T> implements ICiRuleValidator<T> {

	/*private AbstractValidator<T> nextValidator;

	protected Map<String, Object> request;
	protected Map<String, Object> response;*/

	protected RuleMsgDTO ruleMsg;

	/**
	 * 配置结果的json数据
	 */
	protected JSONObject cfgJsonResult = null;

	public List<RuleMsgDTO> startValidate(CiEnContextDTO ctxDTO, T t) {
		List<RuleMsgDTO> ruleMsgList = new Vector<RuleMsgDTO>();

		if (this.request == null) {
			this.request = new HashMap<String, Object>();

		}

		if (this.response == null) {
			this.response = new HashMap<String, Object>();
		}

		// 校验结果
		this.ruleMsg = new RuleMsgDTO();
		FMap extMap = new FMap();
		this.ruleMsg.setExt_content(extMap);

		boolean isSucc = this.validate(ctxDTO, t);

		// 校验失败获取失败原因
		if (!isSucc) {

			RuleMsgDTO ruleMsg = this.getValidateMsg();
			ruleMsgList.add(ruleMsg);
		}

		// 判断是否需要执行下一个校验器，如果不需要执行，直接返回
		if (this.isBreakFailValidate()) {
			return ruleMsgList;
		}

		if (nextExecutor != null) {
			nextExecutor.request = this.request;
			nextExecutor.response = this.response;

			List<RuleMsgDTO> msgList = ((AbstractRuleValidator<T>)nextExecutor).startValidate(ctxDTO, t);
			if (msgList != null && msgList.size() > 0) {
				ruleMsgList.addAll(msgList);
			}
		}

		return ruleMsgList;

	}

	/**
	 * 校验失败是否停止执行下一个校验器
	 */
	@Override
	public boolean isBreakFailValidate() {

		return false;
	}

	/**
	 * 设置默认json数据
	 * 
	 * @param defaultJsonVal
	 */
	/*protected void setDefaultJsonVal(String defaultJsonVal) {

		if (StringUtils.isNotEmpty(defaultJsonVal)) {
			try {
				cfgJsonResult = (JSONObject) JSONObject.parse(defaultJsonVal);
			} catch (Exception e) {
				throw new BizRuntimeException("设置规则执行器默认值失败", e);
			}
		} else {
			cfgJsonResult = new JSONObject();
		}
	}*/

	/*public void setNextValidator(AbstractValidator<T> nextValidator) {

		this.nextValidator = nextValidator;
	}*/
}

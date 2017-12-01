package iih.ci.ord.s.bp.cfg.rulecfg;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

import iih.ci.ord.i.cfg.rulecfg.ICiPresRuleCfgExecutor;
import xap.mw.core.data.BizRuntimeException;

public abstract class AbstractExecutorChain<T> implements ICiPresRuleCfgExecutor<T> {

	/**
	 * 下一个规则
	 */
	protected AbstractExecutorChain<T> nextExecutor;

	/**
	 * 当前规则配置结果的json数据
	 */
	protected JSONObject cfgJsonResult = null;

	public Map<String, Object> request;
	public Map<String, Object> response;

	/**
	 * 是否执行下一个
	 * 
	 * @return true 执行下一个， false 不执行
	 */
	protected abstract boolean isExecuteNext();

	/**
	 * 设置下一个执行器
	 * 
	 * @param nextExecutor
	 */
	public void setNextExecutor(AbstractExecutorChain<T> nextExecutor) {
		this.nextExecutor = nextExecutor;
	}

	/**
	 * 设置默认json数据
	 * 
	 * @param defaultJsonVal
	 *            配置的默认值
	 */
	protected void setDefaultJsonVal(String defaultJsonVal) {

		if (StringUtils.isNotEmpty(defaultJsonVal)) {
			try {
				cfgJsonResult = (JSONObject) JSONObject.parse(defaultJsonVal);
			} catch (Exception e) {
				throw new BizRuntimeException("设置规则执行器默认值失败", e);
			}
		} else {
			cfgJsonResult = new JSONObject();
		}
	}
}

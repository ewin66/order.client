package iih.ci.ord.i.cfg.rulecfg;

import java.util.List;

import iih.ci.ord.cfg.dto.msg.d.RuleMsgDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;

/**
 * 规则执行器
 * 
 * @author HUMS
 *
 */
public interface ICiRuleCfgExecutor<T> {

	/**
	 * 设置默认值
	 */
	public void setDefaultVal(T t);

	/**
	 * 执行规则
	 * 
	 * @param ctx 就诊上下文环境
	 * @param t 当前待处理对象
	 * @param msgList 执行结果信息
	 * @return true 继续执行，false 执行结束
	 */
	public boolean executeRule(CiEnContextDTO ctx, T t, List<RuleMsgDTO> msgList);
}

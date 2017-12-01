package iih.ci.ord.i.cfg.rulecfg;

/**
 * 处方规则执行器
 * 
 * @author HUMS
 *
 */
public interface ICiPresRuleCfgExecutor<T> {

	/**
	 * 设置默认值
	 */
	public void setDefaultVal(T t);

	/**
	 * 执行规则
	 * 
	 * @param t 当前待处理对象
	 * @return true 继续执行，false 执行结束
	 */
	public T executeRule(T t);

}

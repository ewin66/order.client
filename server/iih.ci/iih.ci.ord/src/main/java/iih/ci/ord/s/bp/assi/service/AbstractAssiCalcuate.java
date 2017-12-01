package iih.ci.ord.s.bp.assi.service;

import xap.mw.core.data.BizException;

public abstract class AbstractAssiCalcuate<T> extends AbstractAssiParam {

	/**
	 * 执行需要计算的属性拷贝
	 * 
	 * @param t
	 * @throws BizException
	 */
	public abstract void calcuateProperty(T t) throws BizException;

	/**
	 * 在执行计算开始时复制相关属性
	 * 
	 * @param t
	 * @throws BizException
	 */
	protected abstract void beforeCalcuateCustomProperty(T t) throws BizException;

	/**
	 * 在执行计算结束后处理相关属性
	 * 
	 * @param t
	 * @throws BizException
	 */
	protected abstract void afterCalcuateCustomProperty(T t) throws BizException;

}

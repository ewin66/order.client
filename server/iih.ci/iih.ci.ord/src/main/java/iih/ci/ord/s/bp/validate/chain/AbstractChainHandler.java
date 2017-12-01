package iih.ci.ord.s.bp.validate.chain;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

/**
 * 校验链基类
 * 
 * @author HUMS
 *
 */
public abstract class AbstractChainHandler {

	// 执行校验前，错误记录数，通过比较记录数，判断当前执行的校验是否有错误
	private int beforeValidateErrorCnt;

	// 校验处理对象
	private AbstractChainHandler handler;

	/**
	 * 添加下一个校验
	 * 
	 * @param handler
	 * @param isNotPassValiteStop
	 * @return
	 */
	public AbstractChainHandler addVlaidatorHandler(AbstractChainHandler handler) {

		this.handler = handler;
		return this.handler;
	}

	/**
	 * 开始执行校验
	 * 
	 * @param ciEms
	 * @return
	 */
	public List<String> startValidate(CiEnContextDTO ciEnContext, ValidateDataDTO param) throws BizException {

		List<String> validateResult = new ArrayList<String>();

		this.doNextValidate(ciEnContext, param, validateResult);

		return validateResult;
	}

	/**
	 * 下一个校验对象开始执行
	 * 
	 * @param ciEms
	 * @param handleResult
	 */
	private void doNextValidate(CiEnContextDTO ciEnContext, ValidateDataDTO param, List<String> validateResult)
			throws BizException {

		// 记录校验前，错误数量
		beforeValidateErrorCnt = validateResult.size();
		this.doValidate(ciEnContext, param, validateResult);

		// 下一个验证节点不为空, 校验未通过(校验后的错误数量增加)情况，并且停止校验属性为停止时，不执行下一个校验
		if (handler != null && (validateResult.size() == beforeValidateErrorCnt
				|| validateResult.size() > beforeValidateErrorCnt && !isBreakValidate())) {
			handler.doNextValidate(ciEnContext, param, validateResult);
		}
	}

	/**
	 * 子类执行自身校验<br>
	 * 
	 * @param param
	 *            待校验对象
	 * @param validateResult
	 *            校验结果
	 */
	protected abstract void doValidate(CiEnContextDTO ciEnContext, ValidateDataDTO param,
			List<String> validateResult) throws BizException;

	/**
	 * 当前校验不未通过时，是否停止校验
	 * 
	 * @return
	 */
	protected abstract boolean isBreakValidate();

}

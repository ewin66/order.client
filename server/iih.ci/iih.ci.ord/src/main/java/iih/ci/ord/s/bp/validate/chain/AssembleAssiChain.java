package iih.ci.ord.s.bp.validate.chain;

import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.bp.validate.chain.validators.FgOrValidator;
import iih.ci.ord.s.bp.validate.chain.validators.FgUseValidator;
import xap.mw.core.data.BizException;

/**
 * 校验责任链组装<br>
 * 需要将构造校验类加入到配置中
 * 
 * @author HUMS
 *
 */
public class AssembleAssiChain {

	/**
	 * 启动校验
	 * 
	 * @param ciEnContext
	 *            当前就诊上下文环境
	 * @param param
	 *            校验对象
	 * @return 校验结果集合
	 * @throws BizException
	 */
	public static List<String> startValidate(CiEnContextDTO ciEnContext, ValidateDataDTO param)
			throws BizException {

		AbstractChainHandler fgOrValidator = new FgOrValidator();
		AbstractChainHandler fgUseValidator = new FgUseValidator();
		fgOrValidator.addVlaidatorHandler(fgUseValidator);
		return fgOrValidator.startValidate(ciEnContext, param);
	}
}

package iih.ci.ord.s.bp.validate.chain.validators;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.bp.validate.chain.AbstractChainHandler;
import iih.ci.ord.s.bp.validate.chain.ValidateDataDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 可开立服务状态校验<br>
 * 1. fg_active 启用状态校验 2. fg_or 医嘱状态 3. ds 删除状态
 * 
 * @author HUMS
 *
 */
public class FgOrValidator extends AbstractChainHandler {

	@Override
	protected void doValidate(CiEnContextDTO ciEnContext, ValidateDataDTO param, List<String> handleResult)
			throws BizException {

		MedSrvDO medSrv = param.getMedSrv();

		if (medSrv == null) {
			handleResult.add("初始校验失败，医疗服务对象不能为空！");
			return;
		}
		if (medSrv.getFg_active() != FBoolean.TRUE) {
			handleResult.add("服务[" + medSrv.getName() + "]未启用！");
			return;
		}
		if (medSrv.getDs() != 0) {
			handleResult.add("服务[" + medSrv.getName() + "]为已删除状态！");
			return;
		}
		if (medSrv.getFg_or() != FBoolean.TRUE) {
			handleResult.add("服务[" + medSrv.getName() + "]非临床服务！");
			return;
		}
	}

	@Override
	protected boolean isBreakValidate() {

		return true;
	}

}

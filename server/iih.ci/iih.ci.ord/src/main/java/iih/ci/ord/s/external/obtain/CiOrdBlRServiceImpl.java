package iih.ci.ord.s.external.obtain;

import iih.bl.cg.i.IBlOutQryService;
import iih.ci.ord.i.external.obtain.ICiOrdBlRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 调用费用相关接口
 * 
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdBlRService.class }, binding = Binding.JSONRPC)
public class CiOrdBlRServiceImpl implements ICiOrdBlRService {

		
	/**
	 * 判断是否可以使用预交金 (北京市医保不支持预交金，高端商保记账不支持预交金)
	 * 
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @param bizType 业务场景类型，暂为空，（后续可参考：iih.bl.pay.prepay.d.EuPrepayBizType）
	 * @return FBoolean
	 * @throws BizException
	 */
	@Override
	public FBoolean isPatUsePrePay(String patId, String entId, String bizType) throws BizException {

		IBlOutQryService bllOutQryService = (IBlOutQryService)ServiceFinder.find(IBlOutQryService.class);
		return bllOutQryService.canUsePrepay(patId, entId, bizType);
	}
}

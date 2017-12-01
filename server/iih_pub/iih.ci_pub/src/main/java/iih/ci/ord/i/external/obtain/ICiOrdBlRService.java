package iih.ci.ord.i.external.obtain;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 调用费用相关接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdBlRService {

	/**
	 * 判断是否可以使用预交金 (北京市医保不支持预交金，高端商保记账不支持预交金)
	 * 
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @param bizType 业务场景类型，暂为空，（后续可参考：iih.bl.pay.prepay.d.EuPrepayBizType）
	 * @return FBoolean
	 * @throws BizException
	 */
	public abstract FBoolean isPatUsePrePay(String patId, String entId, String bizType) throws BizException;
}

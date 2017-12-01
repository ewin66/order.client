package iih.ci.ord.cirptlab.i;

import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import xap.mw.core.data.BizException;

/**
 * 检验报告单自定义服务接口
 * @author wu.junhui
 *
 */
public interface ICiRptLabService {
	/**
	 * 根据检验申请单号返回检验报告单信息。当检验申请单号对应的检验报告单信息
	 * 不存在时，返回根据检验申请单信息构造的初始检验报告单信息。
	 * 
	 */
	public CirptlabAggDO getRptLabByReqNo(String reqNo) throws BizException;
}

package iih.ci.ord.cirptobs.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cirptobs.d.CiRptObsDO;

/**
 * 检查报告单自定义服务接口
 * @author wu.junhui
 *
 */
public interface ICiRptObsService {

	/**
	 * 根据检查申请单号返回检查报告单信息。当检查申请单号对应的检查报告单信息
	 * 不存在时，返回根据检查申请单信息构造的初始检查报告单信息。
	 * 
	 */
	public CiRptObsDO getRptObsByReqNo(String reqNo) throws BizException;
}

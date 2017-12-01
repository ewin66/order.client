package iih.ci.ord.cior.i;

import iih.ci.ord.cior.d.CiordrptbttestAggDO;
import xap.mw.core.data.BizException;

public interface ICiRptBtTestService {
	/**
	 * 根据备血申请单号返回备血结果单信息。当备血申请单号对应的备血结果单信息
	 * 不存在时，返回根据备血申请单信息构造的初始备血结果单信息。
	 * 
	 */
	public CiordrptbttestAggDO getRptBtTestByReqNo(String reqNo) throws BizException;
}

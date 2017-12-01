package iih.ci.ord.cirptpathgy.i;

import iih.ci.ord.cirptpathgy.d.CiRptPathgy;
import iih.ci.ord.cirptpathgy.d.CiRptPathgyDO;
import xap.mw.core.data.BizException;


/**
 * 检查报告单自定义服务接口
 * @author shao_yuan
 *
 */
public interface ICiRptPathgyService {

	/**
	 * 根据病理申请单号返回病理报告单信息。当病理申请单号对应的病理报告单信息
	 * 不存在时，返回根据病理申请单信息构造的初始病理报告单信息。
	 * 
	 */
	public CiRptPathgyDO getRptPathgyByReqNo(CiRptPathgyDO ciRptPathgy) throws BizException;
}

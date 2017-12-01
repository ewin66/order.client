package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

/**
 * 生成集成平台出院服务数据信息操作BP
 */
public class GetIEMsgInfo4OutBP {
	/**
	 * 生成集成平台出院服务数据信息
	 * 出院属于就诊域时机触发
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public BaseDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		return null;
	}
}

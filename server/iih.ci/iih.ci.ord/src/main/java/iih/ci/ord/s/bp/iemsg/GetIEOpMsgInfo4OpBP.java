package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiSugOpOrQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成集成平台手术申请服务数据信息操作BP
 * （门诊）
 */
public class GetIEOpMsgInfo4OpBP {
	/**
	 * 生成集成平台手术申请服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpOpOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		CiSugOpOrQry qry=new CiSugOpOrQry(id_ors);
		IEOpOpOrEnDTO[] rtn = (IEOpOpOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpOpOrEnDTO.class);

		return rtn;
	}
}

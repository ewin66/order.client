package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEOpBtUseOrDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiBuOpOrQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成集成平台用血服务数据信息操作BP
 * （门诊）
 */
public class GetIEOpMsgInfo4UBtBP {
	/**
	 * 生成集成平台用血服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpBtUseOrDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		CiBuOpOrQry qry=new CiBuOpOrQry(id_ors);
		IEOpBtUseOrDTO[] rtn = (IEOpBtUseOrDTO[])AppFwUtil.getDORstWithDao(qry, IEOpBtUseOrDTO.class);

		
		return rtn;
	}
}

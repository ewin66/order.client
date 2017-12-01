package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEOpBtOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiBtOpOrQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成集成平台备血申请服务数据信息操作BP
 * （门诊）
 */
public class GetIEOpMsgInfo4PBtBP {
	/**
	 * 生成集成平台备血申请服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpBtOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得备血医嘱申请数据信息集合
		IEOpBtOrEnDTO[] rtndtos=getIEOpBtOrEnDTOs(id_ors);
		
		//返回备血申请医嘱数据集合信息
		return rtndtos;
	}
	
	/**
	 * 获得备血医嘱申请数据信息集合
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpBtOrEnDTO[] getIEOpBtOrEnDTOs(String id_ors) throws BizException{		
		CiBtOpOrQry qry=new CiBtOpOrQry(id_ors);
		IEOpBtOrEnDTO[] rtn = (IEOpBtOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpBtOrEnDTO.class);
		 return rtn;
	}
}

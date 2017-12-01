package iih.ci.ord.s.bp.validate;

import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.ICiOrValidateConst;
import xap.mw.core.data.BizException;

/*
 * 根据OrId获得服务互斥信息数据操作BP
 */
public class CiOrSrvReactInfo8OrIdGetBP {
	/**
	 * 根据OrId获得服务互斥信息数据
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public SrvReactDTO[] exec(String id_or) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_or))return null;
		
		//获得医嘱服务sql条件串
		String srvcondstr = String
				.format(ICiOrValidateConst.GET_ORSRV_IDS_SQLSTR,
						CiOrdUtils.SQUOTE_MARK_STR + id_or
								+ CiOrdUtils.SQUOTE_MARK_STR);
	
		//返回
		return CiOrdAppUtils.getBdSrvQryQryService().getSrvReactInfos(srvcondstr);
	}
	

	
}

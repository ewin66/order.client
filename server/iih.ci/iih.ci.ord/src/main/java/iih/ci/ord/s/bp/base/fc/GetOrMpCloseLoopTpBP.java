package iih.ci.ord.s.bp.base.fc;

import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 获得医嘱执行闭环类型操作BP
 */
public class GetOrMpCloseLoopTpBP {
	/**
	 * 获得医嘱执行闭环类型
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OrpltpDO[] exec(CiOrderDO ordo)  throws BizException{
		//有效性校验
		if(!validateCheck(ordo))return null;

		//获得匹配参数
		OrpltpMatchParamDTO param=getOrpltpMatchParam(ordo);
		
		//获得匹配的闭环类型id
		return CiOrdAppUtils.getIOrpltpmtParaService().GetOrpltp(param);
	}
	
	/**
	 * 有效性校验
	 * @param ordo
	 * @return
	 */
	private boolean validateCheck(CiOrderDO ordo){
		if(CiOrdUtils.isEmpty(ordo))return false;
		return true;
	}
	
	/**
	 * 获得闭环匹配参数
	 * @param ordo
	 * @return
	 */
	private OrpltpMatchParamDTO getOrpltpMatchParam(CiOrderDO ordo){
		OrpltpMatchParamDTO param=new OrpltpMatchParamDTO();
		param.setSd_srvtp(ordo.getSd_srvtp());
		param.setCode_entp(ordo.getCode_entp());
		param.setFg_skintest(ordo.getFg_skintest());
		param.setId_route(ordo.getId_route());
		param.setId_srv(ordo.getId_srv());
		
		return param;
	}
}

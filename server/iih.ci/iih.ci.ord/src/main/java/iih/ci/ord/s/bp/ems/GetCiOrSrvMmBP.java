package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获得医嘱项目对应的物品数据信息BP
 */
public class GetCiOrSrvMmBP {
	/**
	 * 获得医嘱项目对应的物品数据信息
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
	public OrdSrvMmDO exec(String id_orsrv) throws BizException{
		if(CiOrdUtils.isEmpty(id_orsrv))return null;
		String condstr=OrdSrvMmDODesc.TABLE_ALIAS_NAME+".id_orsrv='"+id_orsrv+"'";
		OrdSrvMmDO[] orsrvmms=CiOrdAppUtils.getOrSrvMmQryService().find(condstr, "", FBoolean.FALSE);
		if(orsrvmms==null || orsrvmms.length==0)return null;
		return orsrvmms[0];
	}
}

package iih.ci.ord.s.bp;

import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 医嘱物品查询操作BP
 */
public class CiOrMmGetBP {
	/**
	 * 医嘱物品查询
	 * @param id_or
	 * @throws BizException
	 */
	public OrdSrvMmDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String condstr=OrdSrvMmDODesc.TABLE_ALIAS_NAME+".id_orsrv='"+id_or+"'";
		OrdSrvMmDO[] dos=CiOrdAppUtils.getOrSrvMmQryService().find(condstr, "", FBoolean.FALSE);
		return dos;
	}
}

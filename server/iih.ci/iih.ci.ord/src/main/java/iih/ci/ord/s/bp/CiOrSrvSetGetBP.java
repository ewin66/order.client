package iih.ci.ord.s.bp;

import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 医嘱或项目对应套项目查询操作BP
 */
public class CiOrSrvSetGetBP {
	/**
	 * 医嘱或项目对应套项目查询
	 * @param id_or
	 * @throws BizException
	 */
	public OrdSrvSetDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String condstr=OrdSrvSetDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		OrdSrvSetDO[] dos=CiOrdAppUtils.getOrsrvsetQryService().find(condstr, "", FBoolean.FALSE);
		return dos;
	}
}
